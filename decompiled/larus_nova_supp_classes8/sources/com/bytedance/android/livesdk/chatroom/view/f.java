package com.bytedance.android.livesdk.chatroom.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.q6;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import nic.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public View a;
    public SimpleMediaView b;
    public HSImageView c;
    public View d;
    public SharePanelPreviewProgressBar e;
    public TextView f;
    public DouyinLoadingLayout g;
    public ImageView h;
    public PreviewType i;
    public final c j;
    public final com.bytedance.android.livesdk.chatroom.view.c k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r0 = this.a;     // Catch: Throwable -> L14
            SimpleMediaView r1 = r0.b;     // Catch: Throwable -> L14
            if (r1 == null) goto L7;
            c r2 = r0.j;     // Catch: Throwable -> L14
            VideoContext r3 = r1.e;     // Catch: Throwable -> L14
            if (r3 == null) goto L7;
            r3.D0(r2);     // Catch: Throwable -> L14
        L7:
            SimpleMediaView r4 = this.a.b;     // Catch: Throwable -> L14
            if (r4 == null) goto L10;
            r4.k();     // Catch: Throwable -> L14
        L10:
            View r5 = this.a.d;     // Catch: Throwable -> L14
            if (r5 == null) goto L17;
            UtilityKotlinExtentionsKt.t(r5);     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class c extends nic.l.a {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void B(p r1, tic.a r2) {
            this.a.c(false);
        }

        public final void b(oic.f r1, tic.a r2) {
            com.bytedance.android.livesdk.chatroom.view.c r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }

        public final void s(oic.f r1, tic.a r2) {
            com.bytedance.android.livesdk.chatroom.view.c r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.onPause();
            return;
        }

        public final void u(oic.f r1, tic.a r2) {
            this.a.c(true);
        }

        public final void q(oic.f r2, tic.a r3, int r4, int r5) {
            SharePanelPreviewProgressBar r6 = this.a.e;
            if (r6 == null) goto L6;
            if (r5 <= 0) goto L6;
            r6.a = ((r4 * 1.0f) / r5) * 100;
            r6.invalidate();
        L6:
            TextView r7 = this.a.f;
            if (r7 == null) goto L10;
            r7.setText(q6.c(r4));
            return;
        }
    }

    static {
    }

    public f() {
        this(null);
    }

    public final void b() {
        SimpleMediaView r0 = this.b;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        View r1 = this.d;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r1);
    L8:
        SimpleMediaView r2 = this.b;
        if (r2 == null) goto L12;
        r2.p(this.j);
        return;
    }

    public f(com.bytedance.android.livesdk.chatroom.view.c r1) {
        this.k = r1;
        this.i = PreviewType.UNKNOWN;
        this.j = new c(this);
    }

    public final void a(boolean r5) {
        if (PadConfigUtils.c() == false) goto L7;
        SimpleMediaView r0 = this.b;
        if (r0 == null) goto L7;
        VideoContext.n0(r0.getContext()).H0(e5.a());
    L7:
        com.bytedance.android.livesdk.chatroom.view.c r1 = this.k;
        if (r1 == null) goto L10;
        r1.onPlay();
    L10:
        SimpleMediaView r2 = this.b;
        if (r2 == null) goto L18;
        b r3 = new b(this);
        if (r5 == false) goto L15;
        long r4 = 0;
    L16:
        r2.postDelayed(r3, r4);
        return;
    L15:
        r4 = 200;
        goto L16
    }

    public final void c(boolean r1) {
        if (r1 == false) goto L9;
        DouyinLoadingLayout r2 = this.g;
        if (r2 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r2);
    L6:
        DouyinLoadingLayout r3 = this.g;
        if (r3 == null) goto L16;
        r3.b();
        return;
    L16:
        return;
    L9:
        DouyinLoadingLayout r4 = this.g;
        if (r4 == null) goto L12;
        r4.c();
    L12:
        DouyinLoadingLayout r5 = this.g;
        if (r5 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    }

    public final void d(PreviewType r3) {
        this.i = r3;
        View r0 = this.a;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        int r4 = g.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        HSImageView r5 = this.c;
        if (r5 == null) goto L47;
        UtilityKotlinExtentionsKt.w(r5);
    L47:
        ImageView r6 = this.h;
        if (r6 == null) goto L50;
        UtilityKotlinExtentionsKt.w(r6);
    L50:
        SimpleMediaView r7 = this.b;
        if (r7 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r7);
    L53:
        View r8 = this.d;
        if (r8 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r8);
    L56:
        SharePanelPreviewProgressBar r9 = this.e;
        if (r9 == null) goto L59;
        UtilityKotlinExtentionsKt.t(r9);
    L59:
        c(false);
        return;
    L8:
        if (r4 != 2) goto L10;
        HSImageView r10 = this.c;
        if (r10 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r10);
    L31:
        ImageView r11 = this.h;
        if (r11 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r11);
    L34:
        SimpleMediaView r12 = this.b;
        if (r12 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r12);
    L37:
        View r13 = this.d;
        if (r13 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r13);
    L40:
        SharePanelPreviewProgressBar r14 = this.e;
        if (r14 == null) goto L43;
        UtilityKotlinExtentionsKt.t(r14);
    L43:
        c(false);
        return;
    L10:
        if (r4 != 3) goto L63;
        SimpleMediaView r15 = this.b;
        if (r15 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r15);
    L15:
        SharePanelPreviewProgressBar r16 = this.e;
        if (r16 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r16);
    L18:
        HSImageView r17 = this.c;
        if (r17 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r17);
    L21:
        ImageView r18 = this.h;
        if (r18 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r18);
    L24:
        View r19 = this.d;
        if (r19 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r19);
    L27:
        c(false);
        return;
    }
}
