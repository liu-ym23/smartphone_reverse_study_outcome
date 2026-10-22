package com.bytedance.android.annie.xbridge.mix;

import android.view.View;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.m0;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {

    public static final class a implements com.bytedance.ies.web.jsbridge2.h {
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o a;

        public a(com.bytedance.ies.bullet.service.base.o r1) {
            this.a = r1;
        }

        public final <T> void a(String r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.a.sendEvent(r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.b$b, reason: collision with other inner class name */
    public static final class C0088b implements com.bytedance.ies.web.jsbridge2.h {
        public final /* synthetic */ ue7.c a;

        public C0088b(ue7.c r1) {
            this.a = r1;
        }

        public final <T> void a(String r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.a.sendEvent(r10, r11);
        }
    }

    public static final CallContext a(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        h16.e r1 = (h16.e) r10.c(h16.e.class);
        ue7.c r11 = (ue7.c) r10.c(ue7.c.class);
        if (r1 == null) goto L11;
        CallContext r12 = new CallContext();
        com.bytedance.ies.bullet.service.base.o r13 = r1.getKitView();
        if (r13 == null) goto L7;
        r12.d = r13.realView();
        r12.h = new a(r13);
    L7:
        BulletContext r14 = r1.getBulletContext();
        if (r14 == null) goto L10;
        r12.a = r14.getContext();
    L10:
        r12.g = "webcast";
        r12.b = String.valueOf(r1.getCurrentUri());
    L17:
        r12.f = true;
        r10.d(CallContext.class, r12);
        Set r15 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        com.bytedance.sdk.xbridge.cn.auth.h r16 = (com.bytedance.sdk.xbridge.cn.auth.h) r10.c(com.bytedance.sdk.xbridge.cn.auth.h.class);
        if (r16 == null) goto L21;
        m0 r0 = r12.i;
        r0.a = r16.a();
        r0.b = r16.b();
        r16.getAppId();
        r16.getAppVersion();
        r16.getChannel();
        r0.c = r16.getContainerType();
        r16.getMethodName();
    L21:
        return r12;
    L11:
        if (r11 == null) goto L16;
        CallContext r17 = new CallContext();
        View r18 = r11.i();
        if (r18 == null) goto L15;
        r17.d = r18;
        r17.h = new C0088b(r11);
        r17.a = r11.context();
    L15:
        r17.g = "webcast";
        r17.b = r11.a().toString();
        r12 = r17;
        goto L17
    L16:
        r12 = new CallContext();
        goto L17
    }
}
