package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements k82.d {
    public k82.a a;
    public final VSInputSectionType b;
    public final CompositeDisposable c;
    public k82.c d;
    public final c e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a$a, reason: collision with other inner class name */
    public static final class C0164a {
    }

    public final class b extends k82.c {
        public FrameLayout c;
        public FrameLayout d;
        public EditText e;
        public TextView f;
        public HSImageView g;
        public View h;
        public View i;
        public HSImageView j;
        public TextView k;
        public HSImageView l;
        public ImageView m;
        public TextView n;
        public String o;
        public final float p;
        public final CopyOnWriteArrayList<TextWatcher> q;
        public int r;
        public final g s;
        public final /* synthetic */ a t;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a$b$a, reason: collision with other inner class name */
        public static final class C0165a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;

            public C0165a(b r1, boolean r2, boolean r3, boolean r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r7) {
                Intrinsics.checkNotNullParameter(r7, "it");
                FrameLayout r0 = this.a.d;
                if (r0 == null) goto L39;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                if (r1 == null) goto L38;
                LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
                if (this.b == false) goto L21;
                r2.height = (int) (s1.f(35.0f) * r7.getAnimatedFraction());
                r0.setLayoutParams(r2);
                r0.requestLayout();
                HSImageView r3 = this.a.j;
                if (r3 == null) goto L11;
                r3.setAlpha(r7.getAnimatedFraction());
            L11:
                TextView r4 = this.a.k;
                if (r4 == null) goto L14;
                r4.setAlpha(r7.getAnimatedFraction());
            L14:
                HSImageView r5 = this.a.l;
                if (r5 == null) goto L17;
                r5.setAlpha(r7.getAnimatedFraction());
            L17:
                ImageView r6 = this.a.m;
                if (r6 == null) goto L20;
                r6.setAlpha(r7.getAnimatedFraction());
            L20:
                UtilityKotlinExtentionsKt.z(r0, true);
                return;
            L21:
                float r8 = 1;
                r2.height = (int) (s1.f(35.0f) * (r8 - r7.getAnimatedFraction()));
                r0.setLayoutParams(r2);
                r0.requestLayout();
                HSImageView r9 = this.a.j;
                if (r9 == null) goto L24;
                r9.setAlpha(r8 - r7.getAnimatedFraction());
            L24:
                TextView r10 = this.a.k;
                if (r10 == null) goto L27;
                r10.setAlpha(r8 - r7.getAnimatedFraction());
            L27:
                HSImageView r11 = this.a.l;
                if (r11 == null) goto L30;
                r11.setAlpha(r8 - r7.getAnimatedFraction());
            L30:
                ImageView r13 = this.a.m;
                if (r13 == null) goto L34;
                r13.setAlpha(r8 - r7.getAnimatedFraction());
            L34:
                if (r7.getAnimatedFraction() < r8) goto L36;
                UtilityKotlinExtentionsKt.z(r0, false);
                this.a.f(false, this.c, this.d);
                return;
            L36:
                UtilityKotlinExtentionsKt.z(r0, true);
                this.a.f(true, this.c, this.d);
                return;
            L38:
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        }

        @Override // k82.c
        public final void a() {
            this.t.c.clear();
            this.q.clear();
        }

        public final void c() {
            ImageUtil.loadRoundImage(this.j, fq1.t.a().h());
            TextView r0 = this.k;
            if (r0 == null) goto L6;
            r0.setText(fq1.t.a().i());
            return;
        }

        public final void e() {
            t9 r0 = this.b.s();
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.b;
        L6:
            if (r2 == null) goto L13;
            TextView r3 = this.n;
            if (r3 == null) goto L17;
            t9 r4 = this.b.s();
            if (r4 == null) goto L12;
            r1 = r4.b;
        L12:
            r3.setText(r1);
            return;
        L17:
            return;
        L13:
            TextView r5 = this.n;
            if (r5 == null) goto L19;
            r5.setText(2131922325);
            return;
        L19:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public static final void b(b r6) {
            TextView r0 = r6.n;
            String r1 = null;
            if (r0 == null) goto L5;
            r0.setOnClickListener(null);
        L5:
            FrameLayout r2 = r6.c;
            if (r2 == null) goto L8;
            UtilityKotlinExtentionsKt.z(r2, true);
        L8:
            r6.e();
            if (TextUtils.isEmpty(r6.o) == false) goto L16;
            k82.a r3 = r6.t.a;
            if (r3 == null) goto L13;
            r3.d(false);
        L13:
            TextView r4 = r6.n;
            if (r4 == null) goto L22;
            UtilityKotlinExtentionsKt.w(r4);
        L22:
            int r5 = n82.c.k("#161823", -1);
            View r7 = r6.i;
            if (r7 == null) goto L30;
            t9 r8 = r6.b.s();
            if (r8 == null) goto L29;
            u9 r9 = r8.c;
            if (r9 == null) goto L29;
            r1 = r9.d;
        L29:
            r7.setBackground(new RoundedColorDrawable(UtilityKotlinExtentionsKt.h(12), ColorUtils.setAlphaComponent(n82.c.k(r1, r5), (int) 12.75f)));
        L30:
            FrameLayout r10 = r6.d;
            if (r10 != null) goto L33;
        L35:
            r6.f(false, false, false);
            return;
        L33:
            if (r10.getVisibility() != 0) goto L35;
            r6.d(false, false, false);
            return;
        L16:
            k82.a r11 = r6.t.a;
            if (r11 == null) goto L19;
            r11.d(true);
        L19:
            TextView r13 = r6.n;
            if (r13 == null) goto L22;
            UtilityKotlinExtentionsKt.t(r13);
            goto L22
        }

        public b(a r2, View r3, h82.b r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.t = r2;
            super(r3, r4);
            this.o = BuildConfig.FLAVOR;
            this.p = 15.0f;
            this.q = new CopyOnWriteArrayList();
            this.s = new g(this, r4);
        }

        public final void d(boolean r4, boolean r5, boolean r6) {
            ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
            r0.addUpdateListener(new C0165a(this, r4, r5, r6));
            r0.setInterpolator(new om3.d());
            r0.start();
        }

        public final void f(boolean r2, boolean r3, boolean r4) {
            HSImageView r0 = this.j;
            if (r0 == null) goto L5;
            UtilityKotlinExtentionsKt.z(r0, r2);
        L5:
            TextView r1 = this.k;
            if (r1 == null) goto L8;
            UtilityKotlinExtentionsKt.z(r1, r2);
        L8:
            if (r2 == false) goto L15;
            HSImageView r5 = this.l;
            if (r5 == null) goto L12;
            UtilityKotlinExtentionsKt.z(r5, r4);
        L12:
            ImageView r6 = this.m;
            if (r6 == null) goto L22;
            UtilityKotlinExtentionsKt.z(r6, r3);
            return;
        L22:
            return;
        L15:
            HSImageView r7 = this.l;
            if (r7 == null) goto L18;
            UtilityKotlinExtentionsKt.z(r7, false);
        L18:
            ImageView r8 = this.m;
            if (r8 == null) goto L24;
            UtilityKotlinExtentionsKt.z(r8, false);
            return;
        }
    }

    public static final class c implements j82.a {
        public final /* synthetic */ a a;

        @Override // j82.a
        public final void c() {
            k82.a r0 = this.a.a;     // Catch: Exception -> L16
            if (r0 == null) goto L9;
            EditText r1 = r0.a;     // Catch: Exception -> L16
            if (r1 == null) goto L9;
            Editable r2 = r1.getText();     // Catch: Exception -> L16
            if (r2 == null) goto L9;
            int r3 = r2.length();     // Catch: Exception -> L16
        L10:
            k82.a r4 = this.a.a;     // Catch: Exception -> L16
            if (r4 == null) goto L21;
            EditText r5 = r4.a;     // Catch: Exception -> L16
            if (r5 == null) goto L22;
            r5.setSelection(r3);     // Catch: Exception -> L16
            return;
        L22:
            return;
        L21:
            return;
        L9:
            r3 = 0;
        L16:
            e = move-exception;
            b0 r6 = b0.o();
            StackTraceElement[] r7 = e.getStackTrace();
            r6.getClass();
            com.bytedance.android.live.core.log.g.m(6, r7);
        }

        @Override // j82.a
        public final int e() {
            k82.c r0 = this.a.d;
            if (r0 == null) goto L7;
            return ((b) r0).r;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VSMsgBoardContentSectionProvider.ContentSectionController");
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // j82.a
        public final void f(SkinSelection r4) {
            k82.c r0 = this.a.d;
            if ((r0 instanceof b) == true) goto L5;
            r0 = null;
        L5:
            b r1 = (b) r0;
            if (r1 == null) goto L11;
            View r2 = r1.a;
            if (r2 == null) goto L12;
            r2.post(new h(r1, r4));
            return;
        L12:
            return;
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final void d() {
        k82.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public a() {
        this.b = VSInputSectionType.CONTENT;
        this.c = new CompositeDisposable();
        this.e = new c(this);
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.b;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.d;
    }

    @Override // k82.d
    public final View g(h82.b r11) {
        Intrinsics.checkNotNullParameter(r11, "panelBridge");
        Activity r0 = r11.getActivity();
        String r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.a = r11;
        LayoutInflater r2 = LayoutInflater.from(r0);
        t9 r3 = r11.h.d;
        if (r3 != null) goto L8;
    L10:
        if (r3 != null) goto L12;
    L14:
        int r4 = 2131567702;
    L15:
        View r5 = r2.inflate(r4, null);
        b r6 = new b(this, r5, r11);
        r6.c = (FrameLayout) r6.a.findViewById(2131371464);
        View r13 = r6.a;
        k82.a r7 = r6.t.a;
        if (r7 == null) goto L19;
        Context r8 = r7.getContext();
        if (r8 == null) goto L19;
    L20:
        FrameLayout r14 = r6.c;
        if (r14 == null) goto L23;
        r14.getPaddingRight();
    L23:
        GradientEditText r15 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g().a(r8, VSMsgBoardPortraitInputDialog.x);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 8388611;
        r15.setGravity(8388659);
        r15.setLayoutParams(r9);
        r15.setImeOptions(268435460);
        r15.setInputType(1);
        r15.setLineSpacing(s1.f(3.0f), r15.getLineSpacingMultiplier());
        r15.setTextAlignment(5);
        r15.setTextColor(s1.h(2131107788));
        r15.setTextSize(1, r6.p);
        r15.setInputType(131072);
        r15.setSingleLine(false);
        r15.setPadding(0, 0, 0, 0);
        k82.a r10 = r6.t.a;
        if (r10 == null) goto L28;
        t9 r16 = r10.s();
        if (r16 == null) goto L28;
        int r17 = r16.j;
    L29:
        r15.setMaxLines(r17);
        k82.a r18 = r6.t.a;
        if (r18 == null) goto L34;
        t9 r19 = r18.s();
        if (r19 == null) goto L34;
        int r20 = r19.k;
    L35:
        r15.setMinLines(r20);
        r15.setHorizontallyScrolling(false);
        r15.setOnEditorActionListener(f.a);
        r15.setBackground(null);
        Field r21 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L38
        r21.setAccessible(true);     // Catch: Exception -> L38
        r21.set(r15, 2131250389);     // Catch: Exception -> L38
    L40:
        FrameLayout r23 = r6.c;
        if (r23 == null) goto L43;
        r23.addView(r15);
    L43:
        r6.e = r15;
        r6.n = (TextView) r6.a.findViewById(2131371466);
        r6.f = (TextView) r6.a.findViewById(2131388920);
        r6.g = r6.a.findViewById(2131388879);
        r6.h = r6.a.findViewById(2131389138);
        r6.j = r6.a.findViewById(2131389602);
        r6.k = (TextView) r6.a.findViewById(2131389603);
        r6.i = r6.a.findViewById(2131389600);
        r6.l = r6.a.findViewById(2131389599);
        r6.m = (ImageView) r6.a.findViewById(2131389601);
        r6.d = (FrameLayout) r6.a.findViewById(2131389604);
        t9 r110 = r6.b.s();
        if (r110 == null) goto L48;
        u9 r111 = r110.c;
        if (r111 == null) goto L48;
        u9.a r112 = r111.b;
    L49:
        k82.a r24 = r6.t.a;
        if (r24 == null) goto L101;
        t9 r25 = r24.s();
        if (r25 == null) goto L101;
        if (r25.i != true) goto L101;
        if (r112 == null) goto L57;
        String r26 = r112.b;
    L59:
        if (TextUtils.isEmpty(r26) == false) goto L66;
        if (r112 == null) goto L62;
        String r27 = r112.c;
    L64:
        if (TextUtils.isEmpty(r27) == false) goto L66;
    L62:
        r27 = null;
    L66:
        if (r112 == null) goto L104;
        View r28 = r6.h;
        if (r28 == null) goto L70;
        UtilityKotlinExtentionsKt.w(r28);
    L70:
        int r29 = r112.a;
        if (r29 != 1) goto L73;
        TextView r30 = r6.f;
        if (r30 == null) goto L92;
        r30.setText(r112.b);
    L92:
        TextView r31 = r6.f;
        if (r31 == null) goto L95;
        int r33 = n82.c.a;
        r31.setTextColor(n82.c.k(r112.d, n82.c.k("#161823", -1)));
    L95:
        TextView r113 = r6.f;
        if (r113 == null) goto L98;
        UtilityKotlinExtentionsKt.w(r113);
    L98:
        HSImageView r114 = r6.g;
        if (r114 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r114);
        goto L104
    L73:
        if (r29 != 2) goto L104;
        String r115 = r112.c;
        if (r115 == null) goto L83;
        py.k r34 = vh7.f.c(py.k.class);
        r34.setUrls(CollectionsKt.listOf(r115));
        HSImageView r116 = r6.g;
        if (r116 == null) goto L82;
        GenericDraweeHierarchy r117 = r116.getHierarchy();
        if (r117 == null) goto L82;
        r117.setActualImageScaleType(new n82.d());
    L82:
        ImageLoader.bindImage(r6.g, r34);
    L83:
        HSImageView r118 = r6.g;
        if (r118 == null) goto L86;
        UtilityKotlinExtentionsKt.w(r118);
    L86:
        TextView r119 = r6.f;
        if (r119 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r119);
    L104:
        r6.c();
        EditText r120 = r6.e;
        if (r120 == null) goto L107;
        r120.postDelayed(new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.c(r6), 1000);
    L107:
        EditText r121 = r6.e;
        if (r121 == null) goto L110;
        r121.addTextChangedListener(r6.s);
    L110:
        k82.a r122 = r6.t.a;
        if (r122 == null) goto L113;
        r122.a = r6.e;
    L113:
        EditText r123 = r6.e;
        if (r123 == null) goto L116;
        r123.setOnClickListener(new d(r6));
    L116:
        EditText r124 = r6.e;
        if (r124 == null) goto L119;
        r124.setOnKeyListener(new e(r6));
    L119:
        r6.e();
        t9 r125 = r6.b.s();
        if (r125 == null) goto L126;
        CharSequence r126 = r125.a;
        if (r126 == null) goto L126;
        EditText r35 = r6.e;
        if (r35 == null) goto L126;
        r35.post(new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.b(r126, r6));
    L126:
        int r127 = n82.c.k("#161823", -1);
        int r36 = n82.c.k("#ffac89", -1);
        t9 r37 = r6.b.s();
        if (r37 == null) goto L131;
        u9 r38 = r37.c;
        if (r38 == null) goto L131;
        String r39 = r38.f;
    L132:
        int r40 = n82.c.k(r39, r36);
        t9 r41 = r6.b.s();
        if (r41 == null) goto L137;
        u9 r43 = r41.c;
        if (r43 == null) goto L137;
        r1 = r43.e;
    L137:
        int r128 = n82.c.k(r1, r127);
        TextView r44 = r6.n;
        if (r44 == null) goto L140;
        r44.setTextColor(ColorUtils.setAlphaComponent(r128, (int) 86.700005f));
    L140:
        EditText r45 = r6.e;
        if (r45 == null) goto L143;
        r45.setTextColor(r128);
    L143:
        View r129 = r6.h;
        if (r129 == null) goto L146;
        int r46 = n82.b.a;
        r129.setBackground(n82.b.a(Color.argb(40, Color.red(r40), Color.green(r40), Color.blue(r40)), 0, GradientDrawable.Orientation.TOP_BOTTOM));
    L146:
        Unit r130 = Unit.INSTANCE;
        this.d = r6;
        return r5;
    L131:
        r39 = null;
        goto L132
    L57:
        r26 = null;
    L101:
        View r131 = r6.h;
        if (r131 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r131);
    L48:
        r112 = null;
    L38:
        e = move-exception;
        i40.h.b("V3 emoji key board mCursorDrawableRes", e);
    L34:
        r20 = 1;
    L28:
        r17 = 1;
    L19:
        r8 = r13.getContext();
        goto L20
    L12:
        if (r3.g != true) goto L14;
        r4 = 2131567701;
        goto L15
    L8:
        if (r3.h != true) goto L10;
        r4 = 2131567703;
        goto L15
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }
}
