package com.obric.aikernel.multiusr;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.UserHandle;
import com.bytedance.crash.event.EnsureReportData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMultiUsrProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f4717c;

    public BaseMultiUsrProvider() {
        this.f4717c = LazyKt.lazy(new BaseMultiUsrProvider$shouldDispatchToUsr0$2(this));
    }

    private final boolean b() {
        return ((Boolean) this.f4717c.getValue()).booleanValue();
    }

    public abstract Bundle a(String r10, String r11, Bundle r12);

    protected abstract String c();

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        if (b() == false) goto L18;
        if (r12 != null) goto L6;
        r12 = new Bundle();
    L6:
        r12.putParcelable("_src_usr_handle", Process.myUserHandle());
        MultiUsrAdapter r13 = MultiUsrAdapter.f4720a;
        Context r14 = getContext();
        if (r14 == null) goto L9;
        Context r15 = r14.getApplicationContext();
    L10:
        if (r15 == null) goto L17;
        r12.putBinder("_src_usr_convertor", r13.c(r15));
        Context r16 = getContext();
        if (r16 == null) goto L32;
        ContentResolver r17 = r16.getContentResolver();
        if (r17 != null) goto L34;
        return null;
    L34:
        return r17.call(c(), r10, r11, r12);
    L32:
        return null;
    L17:
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        r15 = null;
        goto L10
    L18:
        boolean r18 = true;
        if (r12 != null) goto L21;
    L23:
        r18 = false;
    L24:
        if (r18 == false) goto L31;
        UserHandle r19 = (UserHandle) r12.getParcelable("_src_usr_handle");
        if (r19 == null) goto L31;
        IBinder r20 = r12.getBinder("_src_usr_convertor");
        if (r20 == null) goto L31;
        MultiUsrAdapter r21 = MultiUsrAdapter.f4720a;
        Intrinsics.checkNotNullExpressionValue(r20, "convertor");
        r21.f(r19, r20);
    L31:
        return a(r10, r11, r12);
    L21:
        if (r12.containsKey("_src_usr_convertor") != true) goto L23;
        goto L23
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }
}
