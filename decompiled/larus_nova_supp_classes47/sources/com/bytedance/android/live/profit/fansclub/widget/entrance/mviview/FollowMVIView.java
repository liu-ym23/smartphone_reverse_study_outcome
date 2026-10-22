package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.live.profit.util.ProfitNitaViewInfo;
import com.bytedance.android.live.revenue.common.FitTextView;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdk.config.gx0;
import com.bytedance.android.livesdk.f8;
import com.bytedance.android.livesdkapi.model.LiveVisionFrameDegradeConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveViewInflateConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import io.reactivex.disposables.CompositeDisposable;
import j40.b1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FollowMVIView extends com.bytedance.android.anya.d<eu0.j, eu0.l, eu0.h> {
    public final CompositeDisposable h;
    public ObjectAnimator i;
    public final View j;
    public final RelativeLayout k;
    public final FitTextView l;
    public final ProgressBar m;
    public final HSImageView n;
    public final int o;
    public final String p;
    public final Context q;
    public final DataCenter r;
    public final ViewGroup s;
    public final boolean t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FollowMVIView a;

        public a(FollowMVIView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            StringBuilder r4 = new StringBuilder("OnClickListener: ");
            DataCenter r0 = this.a.r;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            r4.append(r1);
            ALogger.i("FollowMVIView", r4.toString());
            FollowMVIView r5 = this.a;
            r5.o(new eu0.c(r5.r));
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    public final void g() {
        View r0 = this.j;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new a(this));
    L6:
        if (((Boolean) j40.w.a.getValue()).booleanValue() == false) goto L11;
        View r1 = this.j;
        if (r1 == null) goto L12;
        ViewCompat.setAccessibilityDelegate(r1, new FollowMVIView$onAttach$$inlined$let$lambda$1(this));
        return;
    L12:
        return;
    }

    public final void i() {
        this.h.clear();
        p();
    }

    public final void p() {
        HSImageView r0 = this.n;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenue.common.o.a(r0);
    L5:
        ObjectAnimator r1 = this.i;
        if (r1 != null) goto L8;
    L12:
        RelativeLayout r2 = this.k;
        if (r2 == null) goto L16;
        r2.setAlpha(1.0f);
        return;
    L16:
        return;
    L8:
        if (r1.isRunning() != true) goto L12;
        ObjectAnimator r3 = this.i;
        if (r3 == null) goto L12;
        r3.cancel();
        goto L12
    }

    public final Context getContext() {
        return this.q;
    }

    public final void a(com.bytedance.android.anya.dsl.f<eu0.j> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        FollowMVIView$bindToParent$1 r0 = FollowMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public static void q(View r1, int r2) {
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = (int) s1.e(r2);
        r1.setLayoutParams(r0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(com.bytedance.android.anya.k r12, MVIState r13) {
        eu0.l r14 = (eu0.l) r13;
        Intrinsics.checkNotNullParameter(r12, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r14, "state");
        r0<eu0.l, Boolean> r0 = r14.getShow();
        Object r1 = r12.c.a(r0);
        int r2 = 8;
        if (r1 == null) goto L9;
        r12.b.a.invoke(r0);
        boolean r3 = ((Boolean) r1).booleanValue();
        ViewGroup r4 = this.s;
        if (r3 == false) goto L7;
        int r5 = 0;
    L8:
        r4.setVisibility(r5);
        goto L9
    L7:
        r5 = 8;
    L9:
        com.bytedance.android.anya.internal.r r6 = r14.b;
        KProperty[] r7 = eu0.l.h;
        KProperty r8 = r7[1];
        r6.getClass();
        com.bytedance.android.anya.internal.r r9 = r14.d;
        KProperty r10 = r7[3];
        r9.getClass();
        Object r15 = r12.c.a(r6);
        if (r15 == null) goto L12;
        r12.b.a.invoke(r6);
    L13:
        Object r16 = r12.c.a(r9);
        if (r16 == null) goto L16;
        r12.b.a.invoke(r9);
    L17:
        if (r15 != null) goto L19;
        if (r16 != null) goto L19;
    L69:
        com.bytedance.android.anya.internal.r r17 = r14.c;
        KProperty r18 = r7[2];
        r17.getClass();
        Object r19 = r12.c.a(r17);
        if (r19 == null) goto L76;
        r12.b.a.invoke(r17);
        int r20 = ((Number) r19).intValue();
        if (r20 == 0) goto L76;
        RelativeLayout r22 = this.k;
        if (r22 == null) goto L76;
        r22.setBackground(s1.m(r20));
    L76:
        com.bytedance.android.anya.internal.r r23 = r14.c();
        Object r24 = r12.c.a(r23);
        if (r24 == null) goto L86;
        r12.b.a.invoke(r23);
        boolean r25 = ((Boolean) r24).booleanValue();
        LiveTextView r26 = this.l;
        if (r26 == null) goto L86;
        if (r25 == true) goto L82;
    L84:
        int r27 = 8;
    L85:
        r26.setVisibility(r27);
        goto L86
    L82:
        if (this.t == true) goto L84;
        r27 = 0;
    L86:
        com.bytedance.android.anya.internal.r r28 = r14.b();
        Object r29 = r12.c.a(r28);
        if (r29 == null) goto L93;
        r12.b.a.invoke(r28);
        boolean r30 = ((Boolean) r29).booleanValue();
        ProgressBar r32 = this.m;
        if (r32 == null) goto L93;
        if (r30 == false) goto L92;
        r2 = 0;
    L92:
        r32.setVisibility(r2);
    L93:
        com.bytedance.android.anya.internal.r r110 = r14.a();
        Object r33 = r12.c.a(r110);
        if (r33 == null) goto L120;
        r12.b.a.invoke(r110);
        int r111 = d.a[((EntranceAnimState) r33).ordinal()];
        if (r111 == 1) goto L102;
        if (r111 == 2) goto L99;
        p();
        return;
    L99:
        RelativeLayout r112 = this.k;
        if (r112 == null) goto L122;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r112, "alpha", new float[]{1.0f, 0.0f});
        r113.setDuration(200);
        r113.addListener(new e(this));
        r113.start();
        Unit r114 = Unit.INSTANCE;
        this.i = r113;
        return;
    L122:
        return;
    L102:
        AbstractDraweeController r115 = Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q("/revenue/entrance/ttlive_user_follow_tick_anim.webp")).setAutoPlayAnimations(true).setControllerListener(new g(this, SystemClock.uptimeMillis())).build();
        HSImageView r116 = this.n;
        if (r116 == null) goto L108;
        GenericDraweeHierarchy r117 = r116.getHierarchy();
        if (r117 == null) goto L108;
        r117.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L108:
        if (this.o != 2) goto L112;
        HSImageView r118 = this.n;
        if (r118 == null) goto L112;
        r118.setColorFilter(-16777216);
    L112:
        HSImageView r119 = this.n;
        if (r119 == null) goto L124;
        r119.setController(r115);
        return;
    L124:
        return;
    L120:
        return;
    L19:
        if (r15 != null) goto L21;
        r15 = r6.c();
    L21:
        if (r16 != null) goto L23;
        r16 = r9.c();
    L23:
        int r34 = ((Number) r16).intValue();
        boolean r35 = ((Boolean) r15).booleanValue();
        if (this.o == 3) goto L54;
        FitTextView r36 = this.l;
        if (r36 != null) goto L28;
    L62:
        if (r34 == 0) goto L125;
        LiveTextView r37 = this.l;
        if (r37 == null) goto L117;
        r37.setTextColor(s1.h(r34));
        Drawable r38 = r37.getCompoundDrawables()[0];
        if (r38 == null) goto L69;
        r38.setTint(s1.h(r34));
        goto L69
    L117:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L125:
        return;
    L28:
        if (this.t == true) goto L62;
        if (r35 == false) goto L48;
        r36.setCompoundDrawablesWithIntrinsicBounds(s1.m(2131250622), null, null, null);
        RelativeLayout r39 = this.k;
        if (r39 != null) goto L33;
    L40:
        LiveTextView r40 = this.l;
        Intrinsics.checkNotNull(r40);
        if (s1.getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L43;
        boolean r42 = true;
    L44:
        if (r42 == false) goto L46;
        int r43 = 50;
    L47:
        q(r40, r43);
        goto L62
    L46:
        r43 = 42;
        goto L47
    L43:
        r42 = false;
        goto L44
    L33:
        if (s1.getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L35;
        boolean r44 = true;
    L36:
        if (r44 == false) goto L38;
        int r45 = 62;
    L39:
        q(r39, r45);
        goto L40
    L38:
        r45 = 54;
        goto L39
    L35:
        r44 = false;
        goto L36
    L48:
        r36.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        RelativeLayout r46 = this.k;
        if (r46 == null) goto L51;
        q(r46, 41);
    L51:
        LiveTextView r47 = this.l;
        if (r47 == null) goto L62;
        Intrinsics.checkNotNull(r47);
        q(r47, 41);
        goto L62
    L54:
        LiveTextView r48 = this.l;
        if (r48 == null) goto L119;
        r48.setBackgroundResource(2131253298);
        r48.setText("");
        RelativeLayout r49 = this.k;
        if (r49 == null) goto L59;
        q(r49, 28);
    L59:
        LiveTextView r50 = this.l;
        if (r50 == null) goto L62;
        q(r50, 28);
        goto L62
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L16:
        r16 = null;
        goto L17
    L12:
        r15 = null;
        goto L13
    }

    public FollowMVIView(Context r4, DataCenter r5, ViewGroup r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "containerView");
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.h = new CompositeDisposable();
        this.o = ((LiveVisionFrameDegradeConfig) f8.a.getValue()).getFirstLineStyle();
        this.p = "live_perform_accessibility_action";
        HSImageView r1 = null;
        if (((e51) b1.a.getValue()).c() == false) goto L10;
        if (r6 == null) goto L6;
        RelativeLayout r8 = (RelativeLayout) r6.findViewById(2131373093);
    L7:
        if (r8 == null) goto L10;
        this.j = r6;
    L25:
        View r9 = this.j;
        if (r9 == null) goto L28;
        RelativeLayout r10 = (RelativeLayout) r9.findViewById(2131373093);
    L29:
        this.k = r10;
        View r12 = this.j;
        if (r12 == null) goto L32;
        FitTextView r13 = (FitTextView) r12.findViewById(2131373109);
    L33:
        this.l = r13;
        View r14 = this.j;
        if (r14 == null) goto L36;
        ProgressBar r15 = (ProgressBar) r14.findViewById(2131373102);
    L37:
        this.m = r15;
        View r16 = this.j;
        if (r16 == null) goto L40;
        r1 = (HSImageView) r16.findViewById(2131373081);
    L40:
        this.n = r1;
        return;
    L36:
        r15 = null;
        goto L37
    L32:
        r13 = null;
        goto L33
    L28:
        r10 = null;
        goto L29
    L6:
        r8 = null;
    L10:
        if (((LiveViewInflateConfig) gx0.a.getValue()).getProfit() == false) goto L19;
        if (r7 == false) goto L13;
        ProfitNitaViewInfo r17 = ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE;
    L14:
        int r18 = r17.getResId();
        String r19 = r17.getTag();
        if (r4 == null) goto L18;
        View r20 = NitaInflateUtil.a(r18, r19, (Activity) r4, r6, true);
    L24:
        this.j = r20;
        goto L25
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L13:
        r17 = ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW;
        goto L14
    L19:
        LayoutInflater r22 = LayoutInflater.from(r4);
        if (r7 == false) goto L22;
        int r23 = 2131567557;
    L23:
        r20 = r22.inflate(r23, r6, true);
        goto L24
    L22:
        r23 = 2131567556;
        goto L23
    }
}
