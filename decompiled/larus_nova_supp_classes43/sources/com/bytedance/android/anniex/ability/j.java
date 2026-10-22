package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends h16.e.a {
    public final /* synthetic */ ra.a a;
    public final /* synthetic */ AnnieXLynxView b;
    public final /* synthetic */ LynxBDXBridge c;

    public static final class a extends b {
        public final C0090a b;
        public final /* synthetic */ AnnieXLynxView c;
        public final /* synthetic */ ra.a d;

        /* JADX INFO: renamed from: com.bytedance.android.anniex.ability.j$a$a, reason: collision with other inner class name */
        public static final class C0090a implements q26.j {
            public final q26.a a;
            public final /* synthetic */ ra.a b;

            public final String getBid() {
                return this.b.c;
            }

            public final Map<Class<?>, Object> getAllDependency() {
                return getServiceContext().getAllDependency();
            }

            public final q26.h getServiceContext() {
                return this.a;
            }

            public final <T> T a(Class<T> r1) {
                return (T) q26.j.a.a(this, r1);
            }

            public final <T extends q26.c> T getService(Class<T> r1) {
                return (T) q26.j.a.b(this, r1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0090a(AnnieXLynxView r10, ra.a r11) {
                this.b = r11;
                this.a = new q26.a(r10.getContext(), com.bytedance.ies.bullet.core.h.h.a);
            }
        }

        public final String getViewTag() {
            return "annie-x";
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final void g() {
            this.c.destroy();
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final String getSessionId() {
            return this.d.g;
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final void onHide() {
            AnnieXLynxView r0 = this.c;
            JavaOnlyArray r1 = new JavaOnlyArray();
            int r10 = AnnieXLynxView.B;
            r0.O("viewAppeared", r1, true);
            this.c.onEnterBackground();
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final void onShow() {
            AnnieXLynxView r0 = this.c;
            JavaOnlyArray r1 = new JavaOnlyArray();
            int r10 = AnnieXLynxView.B;
            r0.O("viewDisappeared", r1, true);
            this.c.onEnterForeground();
        }

        @Override // com.bytedance.android.anniex.ability.b
        public q26.j getContext() {
            return this.b;
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final View realView() {
            return this.c;
        }

        public a(AnnieXLynxView r10, ra.a r11) {
            this.c = r10;
            this.d = r11;
            this.b = new C0090a(r10, r11);
        }

        @Override // com.bytedance.android.anniex.ability.b
        public final void sendEvent(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            AnnieXLynxView r0 = this.c;
            int r1 = AnnieXLynxView.B;
            r0.O(r10, r11, true);
        }
    }

    public final BulletContext getBulletContext() {
        String r0 = UriProtector.getQueryParameter(this.a.b, "enable_parse_full_scheme_in_lite_card");
        if (r0 == null) goto L10;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L14;
        Lazy r11 = BulletContextManager.b;
        BulletContextManager r12 = BulletContextManager.a.a();
        ra.a r13 = this.a;
        return BulletContextManager.c(r12, r13.c, r13.b, null);
    L14:
        Lazy r14 = BulletContextManager.b;
        BulletContextManager.a.a().getClass();
        BulletContext r15 = new BulletContext();
        ra.a r16 = this.a;
        LynxView r17 = this.b;
        LynxBDXBridge r18 = this.c;
        String r19 = r16.g;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r15.a = r19;
        r15.f = r16.c;
        if (com.bytedance.ies.bullet.service.base.h.Q() == false) goto L17;
        Context r20 = r17.getContext();
    L18:
        r15.b(r20);
        r15.C = true;
        return r15;
    L17:
        r20 = r18.getContext();
    L10:
        r10 = false;
        goto L11
    }

    public final Uri getCurrentUri() {
        return this.a.b;
    }

    public final com.bytedance.ies.bullet.service.base.o getKitView() {
        return new a(this.b, this.a);
    }

    public final Uri getProcessingUri() {
        return this.a.b;
    }

    public final String getSessionId() {
        return this.a.g;
    }

    public void onEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        AnnieXLynxView r0 = this.b;
        String r1 = r10.getName();
        Object r11 = r10.getParams();
        int r12 = AnnieXLynxView.B;
        r0.O(r1, r11, true);
    }

    public j(ra.a r1, AnnieXLynxView r10, LynxBDXBridge r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
