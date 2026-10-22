package com.bytedance.ies.bullet.pool;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f5801c;
    public final WeakReference d;

    public b(Context r5, String r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "originSchema");
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.f5799a = r11;
        this.f5800b = r10;
        this.d = new WeakReference(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Object r10, Object r11) {
        Function2 r12 = (Function2) r11;
        Intrinsics.checkNotNullParameter((String) r10, "cacheKey");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Context r13 = (Context) this.d.get();
        if (r13 == null) goto L9;
        String r5 = null;
        Object[] r14 = 0 == true ? 1 : 0;
        BulletContainerView r15 = new BulletContainerView(new MutableContextWrapper(r13), r14, 6, 0);
        r15.f(this.f5800b);
        Uri r16 = this.f5799a;
        com.bytedance.ies.bullet.service.base.e r17 = new com.bytedance.ies.bullet.service.base.e(r16, r16, r15);
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r19 = new StringBuilder("Create View Success, Start Load uri, sessionId=");
        Bundle r20 = this.f5801c;
        if (r20 == null) goto L7;
        r5 = r20.getString("__x_session_id");
    L7:
        r19.append(r5);
        com.bytedance.ies.bullet.service.base.b.a(2, r19.toString(), "XPreRender");
        Bundle r21 = this.f5801c;
        a r22 = new a(r12, r17);
        Uri r23 = this.f5799a;
        Intrinsics.checkNotNullParameter(r23, LynxResourceModule.URI_KEY);
        r15.j(r23, r21, null, null, r22);
    L9:
        return Unit.INSTANCE;
    }
}
