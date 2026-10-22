package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {

    public static final class a implements rj0.a {
        public final /* synthetic */ j a;
        public final /* synthetic */ m00.g b;

        @Override // rj0.a
        public final boolean a() {
            return true;
        }

        @Override // rj0.a
        public final boolean b() {
            return false;
        }

        @Override // rj0.a
        public final void c() {
        }

        @Override // rj0.a
        public final String getCancelText() {
            return "";
        }

        @Override // rj0.a
        public final vc0.a getSurfaceView() {
            m00.g r0 = this.b;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new vc0.a(r0);
        }

        @Override // rj0.a
        public final void onCancel() {
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRefuse();
            return;
        }

        @Override // rj0.a
        public final void onConfirm() {
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // rj0.a
        public final String getConfirmText() {
            return s1.B(2131917574);
        }

        public a(j r1, m00.g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final void a(j r4) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L5;
        m00.g r1 = r0.hh();
    L6:
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L10;
        r2.So(1, new a(r4, r1), "link_invite", false);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
