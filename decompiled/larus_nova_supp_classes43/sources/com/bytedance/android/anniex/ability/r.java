package com.bytedance.android.anniex.ability;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r extends h16.e.a {
    public final /* synthetic */ AnnieXWebModel a;
    public final /* synthetic */ AnnieXWebKit b;

    public static final class a extends c {
        public final /* synthetic */ AnnieXWebKit c;
        public final /* synthetic */ AnnieXWebModel d;

        public final String getCurrentUrl() {
            return "";
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final String getViewTag() {
            return "annie-x";
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final String getSessionId() {
            return this.d.d;
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final void onHide() {
            this.c.j();
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final void onShow() {
            this.c.k();
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final View realView() {
            return this.c.e;
        }

        public a(AnnieXWebKit r1, AnnieXWebModel r10) {
            this.c = r1;
            this.d = r10;
            super(r10);
            if (r1.u != null) goto L6;
            Uri r11 = r10.c;
            return;
        }

        @Override // com.bytedance.android.anniex.ability.c
        public final void sendEvent(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.c.p(r10, r11);
        }
    }

    public final BulletContext getBulletContext() {
        return this.a.l;
    }

    public final Uri getCurrentUri() {
        return this.a.c;
    }

    public final com.bytedance.ies.bullet.service.base.o getKitView() {
        return new a(this.b, this.a);
    }

    public final Uri getProcessingUri() {
        return this.a.c;
    }

    public final String getSessionId() {
        return this.a.d;
    }

    public void onEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        this.b.p(r10.getName(), r10.getParams());
    }

    public r(AnnieXWebModel r1, AnnieXWebKit r10) {
        this.a = r1;
        this.b = r10;
    }
}
