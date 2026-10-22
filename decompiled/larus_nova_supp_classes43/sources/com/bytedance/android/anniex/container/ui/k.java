package com.bytedance.android.anniex.container.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.ies.bullet.ui.common.view.AutoRTLImageView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements q {
    public final q a;

    public static final class a implements q {
        public final Activity a;
        public final ia.c b;
        public final ViewGroup c;
        public final h d;
        public j e;
        public com.bytedance.android.anniex.base.service.d.b f;

        @Override // ia.g
        public final boolean c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
            Integer r11 = y36.q.a(r10, true);
            if (r11 == null) goto L9;
            int r12 = r11.intValue();
            j r1 = this.e;
            if (r1 == null) goto L11;
            FrameLayout r13 = r1.b;
            if (r13 == null) goto L12;
            r13.setBackgroundColor(r12);
            return true;
        L12:
            return true;
        L11:
            return true;
        L9:
            return false;
        }

        @Override // ia.h
        public final boolean e(String r10) {
            Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
            Integer r11 = y36.q.a(r10, true);
            if (r11 == null) goto L7;
            int r12 = r11.intValue();
            com.bytedance.android.anniex.base.service.d.b r1 = this.f;
            if (r1 == null) goto L9;
            r1.b(r12);
            return true;
        L9:
            return true;
        L7:
            return false;
        }

        @Override // ia.h
        public final void f(boolean r10) {
            com.bytedance.android.anniex.base.service.d.b r0 = this.f;
            if (r0 == null) goto L6;
            r0.e(r10);
            return;
        }

        @Override // com.bytedance.android.anniex.container.ui.q
        public final void g(ab.b r10) {
            Intrinsics.checkNotNullParameter(r10, "uiModel");
            this.e = com.bytedance.android.anniex.lite.utils.c.c(this.b.getBid(), this.b, this.a.getWindow(), this.c, this.a, r10);
            this.f = com.bytedance.android.anniex.lite.utils.c.d(this.b.getBid(), this.b, this.c, this.a, r10);
            String r0 = this.b.getBid();
            ia.c r1 = this.b;
            Activity r11 = this.a;
            r11.getWindow();
            com.bytedance.android.anniex.lite.utils.c.b(r0, r1, r11);
            this.d.c(this.a.getWindow(), r10);
            this.d.b(r10, this.b.getBid());
        }

        @Override // ia.h
        public final void k(boolean r10) {
            com.bytedance.android.anniex.base.service.d.b r0 = this.f;
            if (r0 == null) goto L6;
            r0.f(r10);
            return;
        }

        @Override // ia.g
        public final void n(boolean r10) {
            j r0 = this.e;
            if (r0 == null) goto L6;
            r0.e(r10);
            return;
        }

        @Override // ia.h
        public final boolean p(String r10) {
            Intrinsics.checkNotNullParameter(r10, "titleColor");
            Integer r11 = y36.q.a(r10, true);
            if (r11 == null) goto L7;
            int r12 = r11.intValue();
            com.bytedance.android.anniex.base.service.d.b r1 = this.f;
            if (r1 == null) goto L9;
            r1.d(r12);
            return true;
        L9:
            return true;
        L7:
            return false;
        }

        @Override // ia.g
        public final boolean setStatusFontMode(String r10) {
            Intrinsics.checkNotNullParameter(r10, "statusFontMode");
            StatusFontMode.Companion.getClass();
            StatusFontMode r11 = StatusFontMode.a.a(r10);
            if (r11 == null) goto L8;
            j r0 = this.e;
            if (r0 == null) goto L7;
            r0.c(r11);
        L7:
            return true;
        L8:
            return false;
        }

        @Override // ia.h
        public final void setTitle(String r10) {
            Intrinsics.checkNotNullParameter(r10, "title");
            com.bytedance.android.anniex.base.service.d.b r0 = this.f;
            if (r0 == null) goto L6;
            r0.c(r10);
            return;
        }

        public a(Activity r10, ia.c r11, ViewGroup r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "rootView");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = new h(r10, r11, r12);
        }
    }

    public static final class b implements q {
        public final Activity a;
        public final ia.c b;
        public final ViewGroup c;
        public final h d;

        @Override // ia.h
        public final void k(boolean r1) {
        }

        @Override // ia.g
        public final void n(boolean r1) {
        }

        @Override // ia.g
        public final boolean c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
            this.d.g(r10);
            return true;
        }

        @Override // ia.h
        public final boolean e(String r10) {
            Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
            this.d.e(r10);
            return true;
        }

        @Override // ia.h
        public final void f(boolean r1) {
            if (r1 == false) goto L4;
            this.d.l();
            return;
        L4:
            this.d.a();
        }

        @Override // com.bytedance.android.anniex.container.ui.q
        public final void g(ab.b r10) {
            Intrinsics.checkNotNullParameter(r10, "uiModel");
            h r1 = this.d;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r10, "uiModel");
            Drawable r11 = null;
            HybridLogger.m("StatusBarAndNavImp", "init navigation bar", null, null, 12);
            y36.i r0 = r10.c;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("hideNavBar");
            r0 = null;
        L7:
            if (Intrinsics.areEqual(r0.b, Boolean.TRUE) == false) goto L9;
            r1.a();
        L43:
            this.d.d(r10);
            this.d.c(this.a.getWindow(), r10);
            this.d.b(r10, this.b.getBid());
            return;
        L9:
            r1.l();
            y36.i r12 = r10.e;
            if (r12 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("navBarColor");
            r12 = null;
        L13:
            Integer r13 = (Integer) r12.b;
            if (r13 == null) goto L18;
            int r14 = r13.intValue();
            View r15 = r1.c.findViewById(2131363015);
            if (r15 == null) goto L18;
            r15.setBackgroundColor(r14);
        L18:
            y36.i r16 = r10.l;
            if (r16 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("title");
            r16 = null;
        L22:
            String r17 = (String) r16.b;
            if (r17 == null) goto L25;
            r1.j(r17);
        L25:
            AutoRTLImageView r18 = r1.c.findViewById(2131363018);
            if (r18 == null) goto L28;
            r18.setOnClickListener(new i(r1));
        L29:
            y36.i r19 = r10.m;
            if (r19 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("titleColor");
            r19 = null;
        L33:
            Integer r20 = (Integer) r19.b;
            if (r20 == null) goto L43;
            int r21 = r20.intValue();
            TextView r22 = (TextView) r1.c.findViewById(2131363024);
            if (r22 == null) goto L38;
            r22.setTextColor(r21);
        L38:
            if (r18 == null) goto L43;
            Drawable r23 = VectorDrawableCompat.create(r1.a.getResources(), 2131237683, r1.a.getTheme());
            if (r23 == null) goto L42;
            r23.setTint(r21);
            r11 = r23;
        L42:
            r18.setImageDrawable(r11);
            goto L43
        L28:
            r18 = null;
            goto L29
        }

        @Override // ia.h
        public final boolean p(String r10) {
            Intrinsics.checkNotNullParameter(r10, "titleColor");
            this.d.k(r10);
            return true;
        }

        @Override // ia.g
        public final boolean setStatusFontMode(String r10) {
            Intrinsics.checkNotNullParameter(r10, "statusFontMode");
            this.d.i(r10);
            return true;
        }

        @Override // ia.h
        public final void setTitle(String r10) {
            Intrinsics.checkNotNullParameter(r10, "title");
            this.d.j(r10);
        }

        public b(Activity r10, ia.c r11, ViewGroup r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "rootView");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = new h(r10, r11, r12);
        }
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        return this.a.c(r10);
    }

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        return this.a.e(r10);
    }

    @Override // ia.h
    public final void f(boolean r10) {
        this.a.f(r10);
    }

    @Override // com.bytedance.android.anniex.container.ui.q
    public final void g(ab.b r10) {
        Intrinsics.checkNotNullParameter(r10, "uiModel");
        this.a.g(r10);
    }

    @Override // ia.h
    public final void k(boolean r10) {
        this.a.k(r10);
    }

    @Override // ia.g
    public final void n(boolean r10) {
        this.a.n(r10);
    }

    @Override // ia.h
    public final boolean p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        return this.a.p(r10);
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        return this.a.setStatusFontMode(r10);
    }

    @Override // ia.h
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        this.a.setTitle(r10);
    }

    public k(Activity r10, ia.c r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "rootView");
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L9;
        w26.e r13 = (w26.e) r1.n0(w26.e.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.L();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == true) goto L12;
    L14:
        q r16 = new b(r10, r11, r12);
    L15:
        this.a = r16;
        return;
    L12:
        if (Intrinsics.areEqual("webcast", r11.getBid()) == true) goto L14;
        r16 = new a(r10, r11, r12);
    L9:
        r15 = true;
        goto L10
    }
}
