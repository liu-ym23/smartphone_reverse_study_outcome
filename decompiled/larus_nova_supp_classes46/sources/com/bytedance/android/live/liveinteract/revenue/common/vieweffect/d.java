package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.n;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nh0.i;
import nh0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final FrameLayout a;
    public Typeface b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public final StrokeTextView h;
    public final ImageView i;
    public final HSImageView j;
    public final FrameLayout k;
    public final ImageView l;
    public boolean m;
    public final MicSeatScene n;
    public final ViewGroup o;
    public final ke0.a p;
    public final boolean q;
    public final Integer r;
    public final boolean s;
    public final xg0.a t;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Object r0 = this.p;
        ViewParent r2 = null;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L16;
        ViewParent r3 = this.a.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        r2 = r3;
    L11:
        ViewGroup r4 = (ViewGroup) r2;
        if (r4 == null) goto L14;
        r4.removeView(this.a);
    L14:
        r1.addView(this.a);
        this.m = true;
        return;
    }

    public final String c() {
        String r0 = this.e;
        if (r0 != null) goto L13;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L11;
        String r3 = r2.getAnchorId();
        if (r3 == null) goto L11;
        this.e = r3;
        return r3;
    L11:
        return null;
    L13:
        return r0;
    }

    public static void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$setVisibleByAlphaAnim");
        if (r3.getVisibility() == 0) goto L6;
        r3.animate().alpha(1.0f).setDuration(600).start();
        r3.setVisibility(0);
        return;
    }

    public final void b(boolean r5) {
        FrameLayout r0 = this.k;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r1;
        if (r3 != null) goto L13;
        return;
    L13:
        switch(e.b[this.n.ordinal()]) {
            case 1: goto L49;
            case 2: goto L49;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L40;
            case 6: goto L38;
            case 7: goto L16;
            default: goto L55;
        };
    L38:
        r3.leftMargin = s1.f(12.0f);
        r3.topMargin = UtilityKotlinExtentionsKt.i(4);
        goto L55
    L43:
        r3.leftMargin = UtilityKotlinExtentionsKt.i(6);
        r3.topMargin = UtilityKotlinExtentionsKt.i(22);
    L55:
        FrameLayout r6 = this.k;
        if (r6 == null) goto L60;
        r6.setLayoutParams(r3);
        return;
    L60:
        return;
    L16:
        if (r5 == false) goto L18;
    L21:
        r3.leftMargin = UtilityKotlinExtentionsKt.i(12);
        Integer r7 = this.r;
        if (r7 != null) goto L25;
    L26:
        Integer r8 = this.r;
        if (r8 == null) goto L33;
        if (r8.intValue() != 15) goto L33;
    L37:
        r3.topMargin = UtilityKotlinExtentionsKt.i(152);
    L33:
        if (this.g == false) goto L35;
        int r9 = UtilityKotlinExtentionsKt.i(22);
    L36:
        r3.topMargin = r9;
        goto L55
    L35:
        r9 = UtilityKotlinExtentionsKt.i(12);
        goto L36
    L25:
        if (r7.intValue() == 7) goto L37;
    L18:
        if (this.g == true) goto L21;
        r3.leftMargin = UtilityKotlinExtentionsKt.i(12);
        r3.topMargin = (int) UtilityKotlinExtentionsKt.h(20.0f);
        goto L55
    L40:
        if (this.s == false) goto L42;
        r3.leftMargin = UtilityKotlinExtentionsKt.i(24);
        r3.topMargin = UtilityKotlinExtentionsKt.i(10);
        goto L55
    L42:
        r3.topMargin = UtilityKotlinExtentionsKt.i(6);
        r3.leftMargin = UtilityKotlinExtentionsKt.i(21);
        goto L55
    L45:
        if (this.m == true) goto L47;
        a();
    L47:
        r3.topMargin = UtilityKotlinExtentionsKt.i(8);
        r3.leftMargin = UtilityKotlinExtentionsKt.i(22);
        goto L55
    L49:
        if (this.m == true) goto L52;
        a();
    L52:
        if (this.s == false) goto L54;
        r3.topMargin = UtilityKotlinExtentionsKt.i(2);
        r3.leftMargin = UtilityKotlinExtentionsKt.i(3);
        goto L55
    L54:
        r3.topMargin = s1.f(6.0f);
        r3.leftMargin = s1.f(11.0f);
        goto L55
    L5:
        r2 = null;
        goto L7
    }

    public final void d(int r9, i r10) {
        if (r10 == null) goto L78;
        String r0 = r10.c();
        if ((!Intrinsics.areEqual(this.f, r0)) == false) goto L6;
        b(Intrinsics.areEqual(c(), r0));
        this.f = r0;
    L6:
        ALogger.i("RandomEmojiManager", "handleEmojiInfo@@更新" + r10.c());
        ALogger.i("RandomEmojiManager", "handleEmojiInfo@@：" + r10.g() + "--" + r10.i() + "--" + r10.d() + "--" + this.q);
        String r3 = null;
        if (r10.d() != 8) goto L10;
        this.a.setVisibility(8);
        this.c = null;
        this.d = null;
        return;
    L10:
        this.a.setVisibility(0);
        this.k.setVisibility(0);
        if (Intrinsics.areEqual(this.c, r10.g()) == true) goto L13;
    L18:
        this.c = r10.g();
        this.d = r10.i();
        ImageView r1 = this.i;
        if (r1 == null) goto L21;
        r1.setVisibility(8);
    L21:
        HSImageView r2 = this.j;
        if (r2 == null) goto L24;
        r2.setVisibility(8);
    L24:
        this.l.setVisibility(8);
        this.h.setVisibility(8);
        if (Intrinsics.areEqual(r10.g(), "2") == false) goto L46;
        j r4 = r10.h();
        if (r4 == null) goto L30;
        r3 = r4.a();
    L30:
        if (Intrinsics.areEqual(r3, "1") == true) goto L32;
    L37:
        n r5 = new n(r10);
        ke0.a r11 = this.p;
        if (r11 == null) goto L40;
        r11.b(r5);
    L40:
        ALogger.w("RandomEmojiManager", "reset隐藏");
        e(this.k);
        xg0.a r12 = this.t;
        if (r12 == null) goto L80;
        ig0.b r13 = r12.P6(r9);
        if (r13 == null) goto L81;
        r13.b(r5);
        return;
    L81:
        return;
    L80:
        return;
    L32:
        if (TextUtils.isEmpty(r10.i()) == true) goto L37;
        HSImageView r14 = this.j;
        if (r14 == null) goto L36;
        r14.setVisibility(0);
    L36:
        e(this.k);
        this.j.setController(Fresco.newDraweeControllerBuilder().setUri(r10.i()).setAutoPlayAnimations(true).build());
        return;
    L46:
        if (Intrinsics.areEqual(r10.g(), "1") == false) goto L49;
        e(this.k);
        this.l.setVisibility(0);
        this.k.setVisibility(0);
        ImageUtil.loadImage(this.l, r10.i());
        return;
    L49:
        if (Intrinsics.areEqual(r10.g(), "0") == false) goto L84;
        this.h.setText(r10.i());
        this.h.setVisibility(0);
        j r15 = r10.h();
        if (r15 == null) goto L74;
        this.h.setTextSize(1, r15.c());
        String r16 = r15.e();
        if (r16 == null) goto L55;
        this.h.setTextColor(ColorProtector.parseColor(r16));
    L55:
        String r17 = r15.d();
        if (r17 == null) goto L58;
        this.h.x(UtilityKotlinExtentionsKt.h(2), ColorProtector.parseColor(r17));
    L59:
        String r18 = r15.b();
        if (r18 != null) goto L62;
    L69:
        StrokeTextView r19 = this.h;
        if (this.b != null) goto L74;
        Typeface r110 = Typeface.createFromAsset(this.o.getContext().getAssets(), "fonts/SFCompactDisplay-Bold_Num.ttf");     // Catch: Exception -> L73
        this.b = r110;     // Catch: Exception -> L73
        r19.setTypeface(r110);     // Catch: Exception -> L73
    L73:
        ALogger.e("RandomEmojiManager", "initTypeFace error");
        goto L74
    L62:
        if ((!TextUtils.isEmpty(r18)) == false) goto L64;
        r3 = r18;
    L64:
        if (r3 == null) goto L69;
        ImageView r20 = this.i;
        if (r20 == null) goto L68;
        r20.setVisibility(0);
    L68:
        ImageUtil.loadImage(this.i, r3);
        goto L69
    L58:
        this.h.x(0.0f, -1);
    L74:
        e(this.k);
        return;
    L84:
        return;
    L13:
        if (Intrinsics.areEqual(r10.i(), this.d) == false) goto L18;
        if ((!Intrinsics.areEqual(this.c, "0")) == false) goto L18;
        ALogger.i("RandomEmojiManager", "same resource");
        return;
    }

    public d(MicSeatScene r9, ViewGroup r10, ke0.a r11, boolean r12, boolean r13, xg0.a r14, int r15) {
        ViewGroup.LayoutParams r1 = null;
        if ((r15 & 16) == 0) goto L5;
        Integer r0 = je0.d.h();
    L7:
        if ((r15 & 32) == 0) goto L9;
        r13 = false;
    L9:
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "root");
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.r = r0;
        this.s = r13;
        this.t = r14;
        int r16 = s1.f(21.0f);
        FrameLayout r17 = new FrameLayout(r10.getContext());
        r17.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r18 = Unit.INSTANCE;
        this.a = r17;
        StrokeTextView r19 = new StrokeTextView(r10.getContext());
        r19.setTextColor(-1);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-2, -2);
        r110.gravity = 17;
        r19.setLayoutParams(r110);
        r19.setMinWidth(r16);
        r19.setMinHeight(r16);
        r19.setGravity(17);
        r19.setLines(1);
        this.h = r19;
        ImageView r3 = new ImageView(r10.getContext());
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r16, r16);
        r4.gravity = 17;
        r3.setLayoutParams(r4);
        this.i = r3;
        HSImageView r5 = new HSImageView(r10.getContext());
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r16, r16);
        r6.gravity = 17;
        r5.setLayoutParams(r6);
        r5.setVisibility(8);
        this.j = r5;
        FrameLayout r7 = new FrameLayout(r10.getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.topMargin = s1.f(13.0f);
        r8.leftMargin = s1.f(13.0f);
        r7.setLayoutParams(r8);
        r7.addView(r3);
        r7.addView(r19);
        r7.addView(r5);
        r17.addView(r7);
        this.k = r7;
        ImageView r111 = new ImageView(r10.getContext());
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r16, r16);
        r2.gravity = 17;
        r111.setLayoutParams(r2);
        r7.addView(r111);
        this.l = r111;
        r17.setId(2131389723);
        View r112 = r10.findViewById(2131389723);
        if (r112 == null) goto L17;
        ViewParent r113 = r112.getParent();
        if ((r113 instanceof ViewGroup) == true) goto L14;
        r113 = null;
    L14:
        ViewGroup r114 = (ViewGroup) r113;
        if (r114 == null) goto L17;
        r114.removeView(r112);
    L17:
        ViewGroup.LayoutParams r115 = r7.getLayoutParams();
        if ((r115 instanceof FrameLayout.LayoutParams) == false) goto L22;
        r1 = r115;
    L22:
        if (((FrameLayout.LayoutParams) r1) == null) goto L32;
        int r116 = e.a[r9.ordinal()];
        if (r116 != 1) goto L26;
    L28:
        ViewGroup r117 = (ViewGroup) r10.findViewById(2131383623);
        if (r117 == null) goto L31;
        r117.addView(r17);
        this.m = true;
        goto L32
    L31:
        a();
        goto L32
    L26:
        if (r116 == 2) goto L28;
    L32:
        b(r12);
        if (this.m == true) goto L35;
        r10.addView(r17);
    L35:
        Objects.toString(r9);
        com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        return;
    L5:
        r0 = null;
        goto L7
    }
}
