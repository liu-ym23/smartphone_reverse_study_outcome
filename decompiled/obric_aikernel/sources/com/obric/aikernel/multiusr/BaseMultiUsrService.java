package com.obric.aikernel.multiusr;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.UserHandle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMultiUsrService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f4718c;

    public BaseMultiUsrService() {
        this.f4718c = LazyKt.lazy(new BaseMultiUsrService$shouldDispatchToUsr0$2(this));
    }

    private final boolean a() {
        return ((Boolean) this.f4718c.getValue()).booleanValue();
    }

    protected abstract ComponentName b();

    public abstract IBinder c(Intent r10);

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        boolean r11 = true;
        Bundle r12 = null;
        if (a() == false) goto L13;
        if (r10 == null) goto L6;
        Object r13 = r10.clone();
    L8:
        if ((r13 instanceof Intent) == false) goto L10;
        Intent r14 = (Intent) r13;
    L11:
        if (r14 == null) goto L29;
        r14.setComponent(b());
        Bundle r15 = new Bundle();
        r15.putParcelable("_src_usr_handle", Process.myUserHandle());
        MultiUsrAdapter r16 = MultiUsrAdapter.f4720a;
        Context r17 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r17, "applicationContext");
        r15.putBinder("_src_usr_convertor", r16.c(r17));
        r14.putExtras(r15);
        return (IBinder) h.f(null, new BaseMultiUsrService$onBind$1$2(this, r14, null), 1, null);
    L29:
        return null;
    L10:
        r14 = null;
        goto L11
    L6:
        r13 = null;
        goto L8
    L13:
        if (r10 == null) goto L16;
        r12 = r10.getExtras();
    L16:
        if (r12 != null) goto L18;
    L20:
        r11 = false;
    L21:
        if (r11 == false) goto L28;
        UserHandle r18 = (UserHandle) r12.getParcelable("_src_usr_handle");
        if (r18 == null) goto L28;
        IBinder r19 = r12.getBinder("_src_usr_convertor");
        if (r19 == null) goto L28;
        MultiUsrAdapter r20 = MultiUsrAdapter.f4720a;
        Intrinsics.checkNotNullExpressionValue(r19, "convertor");
        r20.f(r18, r19);
    L28:
        return c(r10);
    L18:
        if (r12.containsKey("_src_usr_convertor") != true) goto L20;
        goto L20
    }
}
