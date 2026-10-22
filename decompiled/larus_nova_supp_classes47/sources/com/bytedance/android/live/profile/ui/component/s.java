package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.AuthorReputation;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.HeartDiamondInfo;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ShopHeaderIcon;
import com.bytedance.android.live.base.model.user.ShopHeaderInfo;
import com.bytedance.android.live.base.model.user.WindowHeaderInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements com.bytedance.android.live.profile.ui.base.g {
    public static final /* synthetic */ int t = 0;
    public final com.bytedance.android.live.profile.a a;
    public final Fragment b;
    public final View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public LinearLayout h;
    public LinearLayout i;
    public HSImageView j;
    public final AtomicBoolean k;
    public final AtomicBoolean l;
    public final AtomicBoolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final long r;
    public final com.bytedance.android.live.profile.ui.base.l s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final void a() {
        TextView r0 = this.e;
        if (r0 == null) goto L11;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L11;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L11;
    L15:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L30;
        TextView r4 = this.f;
        if (r4 == null) goto L30;
        CharSequence r5 = r4.getText();
        if (r5 == null) goto L30;
        if (r5.length() <= 0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 != true) goto L30;
        View r7 = this.g;
        if (r7 == null) goto L34;
        r7.setVisibility(0);
        return;
    L34:
        return;
    L25:
        r6 = false;
    L30:
        View r8 = this.g;
        if (r8 == null) goto L36;
        r8.setVisibility(8);
        return;
    L36:
        return;
    L9:
        r2 = false;
    L11:
        HSImageView r9 = this.j;
        if (r9 != null) goto L14;
    L16:
        r3 = false;
        goto L17
    L14:
        if (r9.getVisibility() != 0) goto L16;
        goto L15
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        View r0 = this.s.getHostFragment().getView();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.removeView(this.c);
    L8:
        View r2 = this.c;
        if (r2 == null) goto L12;
        UtilityKotlinExtentionsKt.q(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.ShopComponent.INSTANCE;
    }

    public s(com.bytedance.android.live.profile.ui.base.l r6) {
        Intrinsics.checkNotNullParameter(r6, "hostBehavior");
        this.s = r6;
        this.a = r6.a();
        this.b = r6.getHostFragment();
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        long r0 = SystemClock.uptimeMillis();
        Fragment r7 = r6.getHostFragment();
        LinearLayout r2 = null;
        if (r7 == null) goto L7;
        View r8 = r7.getView();
        if (r8 == null) goto L7;
        ViewStub r9 = (ViewStub) r8.findViewById(2131380846);
    L8:
        if (r9 == null) goto L10;
        View r10 = r9.inflate();
    L11:
        this.c = r10;
        if (r10 == null) goto L14;
        TextView r3 = (TextView) r10.findViewById(2131391334);
    L15:
        this.d = r3;
        if (r10 == null) goto L18;
        HSImageView r4 = (HSImageView) r10.findViewById(2131393401);
    L19:
        this.j = r4;
        if (r10 == null) goto L22;
        TextView r5 = (TextView) r10.findViewById(2131391332);
    L23:
        this.e = r5;
        if (r10 == null) goto L26;
        TextView r12 = (TextView) r10.findViewById(2131391333);
    L27:
        this.f = r12;
        if (r10 == null) goto L30;
        View r13 = r10.findViewById(2131386227);
    L31:
        this.g = r13;
        if (r10 == null) goto L34;
        LinearLayout r14 = (LinearLayout) r10.findViewById(2131377615);
    L35:
        this.h = r14;
        if (r10 == null) goto L38;
        r2 = (LinearLayout) r10.findViewById(2131377617);
    L38:
        this.i = r2;
        if (r10 == null) goto L41;
        ConstraintLayout r15 = r10.findViewById(2131377616);
    L41:
        if (r10 == null) goto L43;
        ConstraintLayout r16 = r10.findViewById(2131377614);
    L43:
        long r17 = SystemClock.uptimeMillis();
        StringBuilder r18 = new StringBuilder("native shop init view cost = ");
        long r19 = r17 - r0;
        r18.append(r19);
        ALogger.i("TriangleManager", r18.toString());
        this.r = r19;
        return;
    L34:
        r14 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L26:
        r12 = null;
        goto L27
    L22:
        r5 = null;
        goto L23
    L18:
        r4 = null;
        goto L19
    L14:
        r3 = null;
        goto L15
    L10:
        r10 = null;
    L7:
        r9 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r3, "user");
        EcomInfo r4 = r3.ecomInfo;
        if (r4 == null) goto L5;
        int r5 = r4.getEcomType();
        this.s.a().showShopEntrance(r5, "live_personal_button");
    L5:
        this.s.b().recordBusinessShow(TrackArea.BottomOperatingArea, "shop");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r18) {
        Intrinsics.checkNotNullParameter(r18, "user");
        com.bytedance.android.live.profile.profilecontext.a r0 = this.s.b();
        if (r0 == null) goto L7;
        ProfileMonitor r1 = r0.getProfileMonitor();
        if (r1 == null) goto L7;
        r1.d(DataType.IsShopDSL, DataType.FALSE);
    L7:
        long r4 = SystemClock.uptimeMillis();
        com.bytedance.android.live.profile.ui.base.l r2 = this.s;
        if (r2 != null) goto L10;
    L16:
        boolean r9 = false;
    L17:
        EcomInfo r10 = r18.ecomInfo;
        if (r10 != null) goto L232;
    L222:
        long r12 = (SystemClock.uptimeMillis() - r4) + this.r;
        ALogger.i("TriangleManager", "native shop all cost = " + r12);
        j0.l().sendLog("livesdk_dsl_load_component_card", MapsKt.mapOf(new Pair[]{TuplesKt.to("id", "shop_card_slice"), TuplesKt.to("cost", String.valueOf(r12)), TuplesKt.to("useCache", DataType.FALSE), TuplesKt.to("is_dsl", DataType.FALSE)}), new Object[]{IRoom.class, am2.x.class});
        EcomInfo r3 = r18.ecomInfo;
        if (r3 == null) goto L225;
        final Integer r13 = Integer.valueOf(r3.getEcomType());
    L226:
        if (r13 == null) goto L246;
        View r5 = this.c;
        if (r5 == null) goto L245;
        r5.setOnClickListener(new w0(new ProfileShopComponent$bindClick$1(this, r13), 500));
        return;
    L245:
        return;
    L246:
        return;
    L225:
        r13 = null;
        goto L226
    L232:
        View r6 = this.c;     // Catch: Exception -> L52
        if (r6 == null) goto L22;
        Drawable r7 = r6.getBackground();     // Catch: Exception -> L52
    L24:
        if ((r7 instanceof GradientDrawable) == true) goto L26;
        r7 = null;
    L26:
        GradientDrawable r8 = (GradientDrawable) r7;     // Catch: Exception -> L52
        if (r8 == null) goto L29;
        r8.setShape(0);     // Catch: Exception -> L52
    L29:
        if (r8 == null) goto L31;
        r8.setGradientType(0);     // Catch: Exception -> L52
    L31:
        if (r8 == null) goto L33;
        r8.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L52
    L33:
        Map r14 = r10.ecomWallBgs;     // Catch: Exception -> L52
        if (r14 == null) goto L38;
        HonorWallUi.HonorWallBg r15 = (HonorWallUi.HonorWallBg) r14.get(Integer.valueOf(r10.getEcomType()));     // Catch: Exception -> L52
        if (r15 == null) goto L38;
        String r16 = r15.gradientStart;     // Catch: Exception -> L52
    L39:
        int r17 = Color.parseColor(r16);     // Catch: Exception -> L52
        Map r19 = r10.ecomWallBgs;     // Catch: Exception -> L52
        if (r19 == null) goto L44;
        HonorWallUi.HonorWallBg r110 = (HonorWallUi.HonorWallBg) r19.get(Integer.valueOf(r10.getEcomType()));     // Catch: Exception -> L52
        if (r110 == null) goto L44;
        String r111 = r110.gradientEnd;     // Catch: Exception -> L52
    L45:
        int r112 = Color.parseColor(r111);     // Catch: Exception -> L52
        if (r8 == null) goto L48;
        r8.setColors(new int[]{r17, r112});     // Catch: Exception -> L52
    L48:
        View r113 = this.c;     // Catch: Exception -> L52
        if (r113 == null) goto L54;
        r113.setBackground(r8);     // Catch: Exception -> L52
    L54:
        View r20 = this.c;
        if (r20 == null) goto L67;
        HSImageView r22 = r20.findViewById(2131384563);
        if (r22 == null) goto L67;
        Map r114 = r10.ecomWallBgs;
        if (r114 == null) goto L67;
        HonorWallUi.HonorWallBg r115 = (HonorWallUi.HonorWallBg) r114.get(Integer.valueOf(r10.getEcomType()));
        if (r115 == null) goto L67;
        py.k r116 = r115.icon;
        if (r116 == null) goto L67;
        r22.setVisibility(0);
        a1.p(r22, UtilityKotlinExtentionsKt.i(r116.getWidth()));
        a1.k(r22, UtilityKotlinExtentionsKt.i(r116.getHeight()));
        ImageLoader.bindImage(r22, r116);
    L67:
        if (r10.isShopType() == false) goto L78;
        ShopHeaderInfo r23 = r10.getShopHeaderInfo();
        if (r23 == null) goto L71;
        ProfileText r24 = r23.getJumpGuideInfo();
    L72:
        this.q = 0;
        if (r24 == null) goto L75;
        int r117 = r24.imagePiecesCount();
    L76:
        this.p = r117;
        zs0.a r118 = zs0.c.a;
        zs0.c.a(this.h, r24, new u(this), null);
    L89:
        if (r10.isWindowType() == false) goto L103;
        if (r9 == false) goto L94;
        TextView r25 = this.d;
        if (r25 == null) goto L116;
        r25.setText(s1.B(2131921762));
    L116:
        ShopHeaderInfo r26 = r10.getShopHeaderInfo();
        if (r26 == null) goto L140;
        List r27 = r26.getShopHeaderIconList();
        if (r27 == null) goto L140;
        this.o = 0;
        this.n = r27.size();
        Iterator r28 = r27.iterator();
    L123:
        if (r28.hasNext() == false) goto L140;
        ShopHeaderIcon r29 = (ShopHeaderIcon) r28.next();
        if (r29 == null) goto L123;
        py.k r30 = r29.getUrl();
        if (r30 == null) goto L123;
        View r119 = this.c;
        if (r119 == null) goto L123;
        Context r120 = r119.getContext();
        if (r120 == null) goto L123;
        HSImageView r121 = new HSImageView(r120);
        LinearLayout r122 = this.i;
        if (r122 == null) goto L138;
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r30.getWidth()), UtilityKotlinExtentionsKt.i(r30.getHeight()));
        r123.gravity = 16;
        r123.leftMargin = UtilityKotlinExtentionsKt.i(4);
        Unit r32 = Unit.INSTANCE;
        r122.addView(r121, r123);
    L138:
        ImageUtil.loadImage(r121, r30, new t(this));
    L140:
        if (r10.isWindowType() == false) goto L159;
        WindowHeaderInfo r33 = r10.getWindowHeaderInfo();
        if (r33 == null) goto L144;
        AuthorReputation r34 = r33.getReputation();
    L145:
        TextView r35 = this.e;
        if (r35 == null) goto L151;
        if (r34 == null) goto L149;
        String r36 = r34.getText();
    L150:
        r35.setText(r36);
        goto L151
    L149:
        r36 = null;
    L151:
        TextView r37 = this.f;
        if (r37 == null) goto L157;
        if (r34 == null) goto L155;
        String r38 = r34.getRecommendCount();
    L156:
        r37.setText(r38);
        goto L157
    L155:
        r38 = null;
    L157:
        a();
        this.l.set(true);
    L210:
        int r39 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((ss0.a) b0.a.getValue()).l() == false) goto L222;
        int r40 = com.bytedance.android.live.profile.ui.util.m.a;
        com.bytedance.android.live.profile.ui.util.m.e(this.d, r10.titleColor);
        View r42 = this.c;
        if (r42 == null) goto L216;
        View r43 = r42.findViewById(2131377615);
    L217:
        com.bytedance.android.live.profile.ui.util.m.e(r43, r10.titleColor);
        View r44 = this.c;
        if (r44 == null) goto L220;
        View r45 = r44.findViewById(2131377614);
    L221:
        com.bytedance.android.live.profile.ui.util.m.e(r45, r10.contentColor);
        goto L222
    L220:
        r45 = null;
        goto L221
    L216:
        r43 = null;
        goto L217
    L144:
        r34 = null;
        goto L145
    L159:
        if (r10.isShopType() == false) goto L210;
        ShopHeaderInfo r46 = r10.getShopHeaderInfo();
        if (r46 == null) goto L163;
        HeartDiamondInfo r47 = r46.getHeartDiamondInfo();
    L164:
        if (r47 == null) goto L187;
        TextView r48 = this.e;
        if (r48 == null) goto L168;
        UtilityKotlinExtentionsKt.u(r48);
    L168:
        HSImageView r49 = this.j;
        if (r49 == null) goto L171;
        UtilityKotlinExtentionsKt.w(r49);
    L171:
        HSImageView r50 = this.j;
        ShopHeaderInfo r52 = r10.getShopHeaderInfo();
        if (r52 == null) goto L176;
        HeartDiamondInfo r53 = r52.getHeartDiamondInfo();
        if (r53 == null) goto L176;
        py.k r54 = r53.getHeartDiamondIcon();
    L177:
        ImageLoader.bindImage(r50, r54, new v(this));
        TextView r55 = this.f;
        if (r55 == null) goto L186;
        ShopHeaderInfo r56 = r10.getShopHeaderInfo();
        if (r56 == null) goto L184;
        AuthorReputation r57 = r56.getShopReputation();
        if (r57 == null) goto L184;
        String r58 = r57.getSales();
    L185:
        r55.setText(r58);
    L184:
        r58 = null;
    L186:
        a();
    L176:
        r54 = null;
        goto L177
    L187:
        HSImageView r59 = this.j;
        if (r59 == null) goto L190;
        UtilityKotlinExtentionsKt.u(r59);
    L190:
        TextView r60 = this.e;
        if (r60 == null) goto L193;
        UtilityKotlinExtentionsKt.w(r60);
    L193:
        ShopHeaderInfo r62 = r10.getShopHeaderInfo();
        if (r62 == null) goto L196;
        AuthorReputation r63 = r62.getShopReputation();
    L197:
        TextView r64 = this.e;
        if (r64 == null) goto L203;
        if (r63 == null) goto L201;
        String r65 = r63.getText();
    L202:
        r64.setText(r65);
        goto L203
    L201:
        r65 = null;
    L203:
        TextView r66 = this.f;
        if (r66 == null) goto L209;
        if (r63 == null) goto L207;
        String r67 = r63.getSales();
    L208:
        r66.setText(r67);
        goto L209
    L207:
        r67 = null;
    L209:
        a();
        this.l.set(true);
        goto L210
    L196:
        r63 = null;
        goto L197
    L163:
        r47 = null;
        goto L164
    L94:
        TextView r68 = this.d;
        if (r68 == null) goto L116;
        WindowHeaderInfo r69 = r10.getWindowHeaderInfo();
        if (r69 == null) goto L100;
        String r70 = r69.getWindowName();
        if (r70 == null) goto L100;
    L101:
        r68.setText(r70);
    L100:
        r70 = "推荐橱窗";
        goto L101
    L103:
        if (r10.isShopType() == false) goto L116;
        if (r9 == false) goto L108;
        TextView r72 = this.d;
        if (r72 == null) goto L116;
        r72.setText(s1.B(2131921734));
        goto L116
    L108:
        TextView r73 = this.d;
        if (r73 == null) goto L116;
        ShopHeaderInfo r74 = r10.getShopHeaderInfo();
        if (r74 == null) goto L114;
        String r75 = r74.getShopName();
        if (r75 == null) goto L114;
    L115:
        r73.setText(r75);
    L114:
        r75 = "推荐店铺";
        goto L115
    L75:
        r117 = 0;
        goto L76
    L71:
        r24 = null;
        goto L72
    L78:
        if (r10.isWindowType() == false) goto L89;
        WindowHeaderInfo r76 = r10.getWindowHeaderInfo();
        if (r76 == null) goto L82;
        ProfileText r77 = r76.getJumpGuideInfo();
    L83:
        this.q = 0;
        if (r77 == null) goto L86;
        int r124 = r77.imagePiecesCount();
    L87:
        this.p = r124;
        zs0.a r125 = zs0.c.a;
        zs0.c.a(this.h, r77, new u(this), null);
        goto L89
    L86:
        r124 = 0;
        goto L87
    L82:
        r77 = null;
    L44:
        r111 = null;
    L38:
        r16 = null;
        goto L39
    L22:
        r7 = null;
    L52:
        e = move-exception;
        ALogger.e("ProfileShopComponent", "parse background error: " + e.getMessage());
        goto L54
    L10:
        if (r2.c() != 1) goto L16;
        com.bytedance.android.live.profile.ui.base.l r78 = this.s;
        if (r78 == null) goto L16;
        if (r78.getTargetType() != 2) goto L16;
        r9 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r6, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileShopComponent update");
        LinearLayout r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        LinearLayout r1 = this.i;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        TextView r2 = this.e;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        TextView r3 = this.f;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        HSImageView r4 = this.j;
        if (r4 == null) goto L17;
        r4.setVisibility(0);
    L17:
        this.k.set(false);
        this.l.set(false);
        this.m.set(false);
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        TextView r5 = this.d;
        if (r5 == null) goto L20;
        r5.setTextColor(-16777216);
    L20:
        int r7 = com.bytedance.android.live.profile.ui.util.m.a;
        View[] r8 = new View[2];
        View r9 = this.c;
        View r10 = null;
        if (r9 == null) goto L23;
        View r12 = r9.findViewById(2131391332);
    L24:
        r8[0] = r12;
        View r13 = this.c;
        if (r13 == null) goto L27;
        r10 = r13.findViewById(2131391333);
    L27:
        r8[1] = r10;
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(r8), s1.h(2131108287));
        g(r6);
        return;
    L23:
        r12 = null;
        goto L24
    }
}
