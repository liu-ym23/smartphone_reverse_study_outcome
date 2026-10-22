package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallBg;
import com.bytedance.android.live.base.model.user.HonorWallContent;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ProfileTextPiece;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.profile.customview.TrapezoidConstraintLayout;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends com.bytedance.android.live.profile.ui.base.k {
    public ViewGroup b;
    public ViewGroup c;
    public HSImageView d;
    public LinearLayout e;
    public LinearLayout f;
    public AppCompatTextView g;
    public TrapezoidConstraintLayout h;
    public HSImageView i;
    public LinearLayout j;
    public LinearLayout k;
    public AppCompatTextView l;
    public boolean m;
    public TrapezoidConstraintLayout n;
    public HSImageView o;
    public LinearLayout p;
    public LinearLayout q;
    public final Lazy r;
    public final com.bytedance.android.live.profile.ui.base.h s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.FansClubVip.INSTANCE;
    }

    public p(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.s = r2;
        this.r = LazyKt.lazy(new ProfileFansClubVipComponent$trapezoidWidth$2(this));
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r5) {
        LinearLayout r3 = null;
        if (ProfilePreInflateUtil.a() == false) goto L7;
        View r6 = ((com.bytedance.android.live.profile.ui.base.e) r5).b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_FANS_VIP, true);
        if (r6 == null) goto L10;
        ViewGroup r7 = (ViewGroup) r6.findViewById(2131384813);
    L11:
        this.b = r7;
        if (r7 == null) goto L14;
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131372099);
    L15:
        this.c = r8;
        ViewGroup r9 = this.b;
        if (r9 == null) goto L18;
        HSImageView r10 = (HSImageView) r9.findViewById(2131386664);
    L19:
        this.d = r10;
        ViewGroup r12 = this.b;
        if (r12 == null) goto L22;
        LinearLayout r13 = (LinearLayout) r12.findViewById(2131386665);
    L23:
        this.e = r13;
        ViewGroup r14 = this.b;
        if (r14 == null) goto L26;
        LinearLayout r15 = (LinearLayout) r14.findViewById(2131386668);
    L27:
        this.f = r15;
        ViewGroup r16 = this.b;
        if (r16 == null) goto L30;
        AppCompatTextView r17 = (AppCompatTextView) r16.findViewById(2131386666);
    L31:
        this.g = r17;
        ViewGroup r18 = this.b;
        if (r18 == null) goto L34;
        TrapezoidConstraintLayout r19 = (TrapezoidConstraintLayout) r18.findViewById(2131389370);
    L35:
        this.h = r19;
        ViewGroup r20 = this.b;
        if (r20 == null) goto L38;
        HSImageView r22 = (HSImageView) r20.findViewById(2131389363);
    L39:
        this.i = r22;
        ViewGroup r23 = this.b;
        if (r23 == null) goto L42;
        LinearLayout r24 = (LinearLayout) r23.findViewById(2131389364);
    L43:
        this.j = r24;
        ViewGroup r25 = this.b;
        if (r25 == null) goto L46;
        LinearLayout r26 = (LinearLayout) r25.findViewById(2131389365);
    L47:
        this.k = r26;
        ViewGroup r27 = this.b;
        if (r27 == null) goto L50;
        AppCompatTextView r28 = (AppCompatTextView) r27.findViewById(2131389366);
    L51:
        this.l = r28;
        ViewGroup r29 = this.b;
        if (r29 == null) goto L54;
        TrapezoidConstraintLayout r30 = (TrapezoidConstraintLayout) r29.findViewById(2131389371);
    L55:
        this.n = r30;
        ViewGroup r32 = this.b;
        if (r32 == null) goto L58;
        HSImageView r33 = (HSImageView) r32.findViewById(2131389367);
    L59:
        this.o = r33;
        ViewGroup r34 = this.b;
        if (r34 == null) goto L62;
        LinearLayout r35 = (LinearLayout) r34.findViewById(2131389368);
    L63:
        this.p = r35;
        ViewGroup r36 = this.b;
        if (r36 == null) goto L66;
        r3 = (LinearLayout) r36.findViewById(2131389369);
    L66:
        this.q = r3;
        return;
    L62:
        r35 = null;
        goto L63
    L58:
        r33 = null;
        goto L59
    L54:
        r30 = null;
        goto L55
    L50:
        r28 = null;
        goto L51
    L46:
        r26 = null;
        goto L47
    L42:
        r24 = null;
        goto L43
    L38:
        r22 = null;
        goto L39
    L34:
        r19 = null;
        goto L35
    L30:
        r17 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
        goto L23
    L18:
        r10 = null;
        goto L19
    L14:
        r8 = null;
    L10:
        r7 = null;
        goto L11
    L7:
        View r37 = ((com.bytedance.android.live.profile.ui.base.e) r5).f(2131567177, true);
        if (r37 == null) goto L10;
        r7 = (ViewGroup) r37.findViewById(2131384813);
        goto L11
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        ProfileOpenArea r9 = r8.openArea;
        if (r9 == null) goto L61;
        ProfileBusinessArea r10 = r9.businessAreaV3;
        if (r10 == null) goto L74;
        List r12 = r10.topElementList;
        if (r12 == null) goto L75;
        List r13 = CollectionsKt.filterNotNull(r12);
        if (r13 == null) goto L76;
        List r14 = CollectionsKt.take(r13, 2);
        if (r14 == null) goto L77;
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L78;
        HonorWallElement r0 = (HonorWallElement) r15.next();
        String r1 = r0.getName();
        if (r1 == null) goto L19;
        this.s.recordBusinessShow(TrackArea.BottomOperatingArea, r1);
    L19:
        if (((ss0.c) rs0.y.a.getValue()).c() == false) goto L48;
        ExtraInfo r2 = r0.getExtraInfo();
        if (r2 == null) goto L48;
        Map r3 = r2.getShowEventParams();
        if (r3 == null) goto L48;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r3.entrySet().iterator();
    L26:
        if (r5.hasNext() == false) goto L47;
        Map.Entry r6 = (Map.Entry) r5.next();
        CharSequence r7 = (CharSequence) r6.getKey();
        boolean r16 = true;
        if (r7 != null) goto L30;
    L33:
        boolean r17 = true;
    L34:
        if (r17 == true) goto L44;
        CharSequence r18 = (CharSequence) r6.getValue();
        if (r18 != null) goto L38;
    L41:
        boolean r19 = true;
    L42:
        if (r19 == true) goto L44;
    L45:
        if (r16 == false) goto L26;
        r4.put(r6.getKey(), r6.getValue());
        goto L26
    L38:
        if (r18.length() == 0) goto L41;
        r19 = false;
    L44:
        r16 = false;
        goto L45
    L30:
        if (r7.length() == 0) goto L33;
        r17 = false;
        goto L34
    L47:
        this.s.recordShowMap(r4);
    L48:
        ExtraInfo r20 = r0.getExtraInfo();
        if (r20 == null) goto L14;
        String r22 = r20.getShowEvent();
        if (r22 == null) goto L14;
        ExtraInfo r23 = r0.getExtraInfo();
        if (r23 == null) goto L56;
        Map r24 = r23.getShowEventParams();
    L57:
        LinkedHashMap r25 = new LinkedHashMap();
        if (r24 == null) goto L60;
        r25.putAll(r24);
    L60:
        this.s.sendLog(r22, r25, new Object[0]);
        goto L14
    L56:
        r24 = null;
        goto L57
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r19) {
        Intrinsics.checkNotNullParameter(r19, "user");
        ProfileOpenArea r0 = r19.openArea;
        if (r0 == null) goto L281;
        ProfileBusinessArea r1 = r0.businessAreaV3;
        if (r1 == null) goto L297;
        List r2 = r1.topElementList;
        if (r2 == null) goto L298;
        List r3 = CollectionsKt.filterNotNull(r2);
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.isEmpty() == false) goto L15;
        return;
    L15:
        if (r3.size() != 1) goto L85;
        HonorWallElement r12 = (HonorWallElement) ListProtector.get(r3, 0);
        ViewGroup r4 = this.c;
        if (r4 == null) goto L19;
        r4.setVisibility(0);
    L19:
        ExtraInfo r5 = r12.getExtraInfo();
        if (r5 != null) goto L22;
    L26:
        HonorWallContent r6 = r12.getHonorWallContent();
        if (r6 == null) goto L29;
        HonorWallBg r13 = r6.getHonorWallBg();
    L30:
        if (r13 == null) goto L75;
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(0);
        r14.setGradientType(0);
        r14.setOrientation(GradientDrawable.Orientation.BL_TR);
        r14.setCornerRadius(UtilityKotlinExtentionsKt.h(8));
        String r7 = r13.getColorStart();
        String r15 = r13.getColorEnd();
        if (r7 != null) goto L35;
    L38:
        boolean r16 = true;
    L39:
        if (r16 == true) goto L51;
        if (r15 != null) goto L42;
    L45:
        boolean r17 = true;
    L46:
        if (r17 == true) goto L51;
        r14.setColors(new int[]{Color.parseColor(r7), Color.parseColor(r15)});     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgOneElement bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L51
    L42:
        if (r15.length() == 0) goto L45;
        r17 = false;
    L51:
        String r8 = r13.getBorderColor();
        if (r8 != null) goto L54;
    L57:
        boolean r9 = true;
    L58:
        if (r9 == false) goto L290;
    L63:
        ViewGroup r10 = this.c;
        if (r10 == null) goto L66;
        r10.setBackground(r14);
    L66:
        py.k r18 = r13.getIcon();
        if (r18 == null) goto L75;
        HSImageView r20 = this.d;
        if (r20 == null) goto L71;
        a1.p(r20, UtilityKotlinExtentionsKt.i(r18.getWidth()));
    L71:
        HSImageView r22 = this.d;
        if (r22 == null) goto L74;
        a1.k(r22, UtilityKotlinExtentionsKt.i(r18.getHeight()));
    L74:
        ImageLoader.bindImage(this.d, r18, UtilityKotlinExtentionsKt.i(r18.getWidth()), UtilityKotlinExtentionsKt.i(r18.getHeight()));
        goto L75
    L290:
        r14.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r8));     // Catch: Exception -> L61
    L61:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgOneElement stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L63
    L54:
        if (r8.length() == 0) goto L57;
        r9 = false;
        goto L58
    L35:
        if (r7.length() == 0) goto L38;
        r16 = false;
    L75:
        zs0.a r23 = zs0.c.a;
        LinearLayout r24 = this.e;
        HonorWallContent r25 = r12.getHonorWallContent();
        if (r25 == null) goto L78;
        ProfileText r26 = r25.getHonorWallTopDisplay();
    L79:
        zs0.c.a(r24, r26, null, null);
        LinearLayout r27 = this.f;
        HonorWallContent r28 = r12.getHonorWallContent();
        if (r28 == null) goto L82;
        ProfileText r29 = r28.getHonorWallBottomDisplay();
    L83:
        zs0.c.a(r27, r29, null, null);
        List r30 = null;
    L229:
        HonorWallElement r32 = (HonorWallElement) ListProtector.get(r3, 0);
        if (r3.size() != 1) goto L232;
        boolean r33 = true;
    L233:
        ProfileFansClub r34 = r19.fansClub;
        if (r34 == null) goto L238;
        ProfileFansClubData r35 = r34.getData();
        if (r35 == null) goto L238;
        int r36 = r35.level;
    L239:
        int r37 = UtilityKotlinExtentionsKt.i(48);
        HonorWallContent r38 = r32.getHonorWallContent();
        if (r38 == null) goto L295;
        ProfileText r39 = r38.getHonorWallTopDisplay();
        if (r39 == null) goto L245;
        List r40 = r39.getPieces();
    L246:
        if (r40 != null) goto L248;
        r40 = CollectionsKt.emptyList();
    L248:
        ProfileText r42 = r38.getHonorWallBottomDisplay();
        if (r42 == null) goto L251;
        List r43 = r42.getPieces();
    L252:
        if (r43 != null) goto L255;
        r43 = CollectionsKt.emptyList();
    L255:
        if (r40.size() <= 1) goto L257;
        boolean r44 = true;
    L258:
        if (r44 == false) goto L262;
        ViewGroup r45 = this.b;
        if (r45 == null) goto L262;
        a1.k(r45, r37);
    L262:
        if (r33 != true) goto L264;
        AppCompatTextView r46 = this.g;
    L266:
        if (r46 == null) goto L296;
        ProfileTextPiece r47 = (ProfileTextPiece) CollectionsKt.firstOrNull(r43);
        if (r47 != null) goto L271;
    L273:
        boolean r48 = false;
    L274:
        if (r48 == false) goto L277;
        if (r36 <= 0) goto L277;
        r46.setText(String.valueOf(r36));
        r46.setVisibility(0);
        this.m = true;
        return;
    L277:
        r46.setVisibility(8);
        return;
    L271:
        if (r47.getType() != ProfileTextPiece.PIECE_TYPE_IMAGE) goto L273;
        r48 = true;
        goto L274
    L296:
        return;
    L264:
        if (r33 == true) goto L280;
        r46 = this.l;
        goto L266
    L280:
        throw new NoWhenBranchMatchedException();
    L257:
        r44 = false;
        goto L258
    L251:
        r43 = r30;
        goto L252
    L245:
        r40 = r30;
        goto L246
    L295:
        return;
    L238:
        r36 = 0;
        goto L239
    L232:
        r33 = false;
        goto L233
    L82:
        r29 = null;
        goto L83
    L78:
        r26 = null;
        goto L79
    L29:
        r13 = null;
        goto L30
    L22:
        if (r5.isCanClick() != true) goto L26;
        ViewGroup r49 = this.c;
        if (r49 == null) goto L26;
        r49.setOnClickListener(new q(this, r12));
        goto L26
    L85:
        HonorWallElement r110 = (HonorWallElement) ListProtector.get(r3, 0);
        HonorWallElement r111 = (HonorWallElement) ListProtector.get(r3, 1);
        ConstraintLayout r50 = this.h;
        if (r50 == null) goto L88;
        r50.setVisibility(0);
    L88:
        ConstraintLayout r52 = this.n;
        if (r52 == null) goto L91;
        r52.setVisibility(0);
    L91:
        ConstraintLayout r53 = this.h;
        if (r53 == null) goto L94;
        a1.p(r53, ((Number) this.r.getValue()).intValue());
    L94:
        ExtraInfo r54 = r110.getExtraInfo();
        if (r54 != null) goto L97;
    L101:
        HonorWallContent r55 = r110.getHonorWallContent();
        if (r55 == null) goto L104;
        HonorWallBg r112 = r55.getHonorWallBg();
    L106:
        if (r112 == null) goto L152;
        TrapezoidConstraintLayout r56 = this.h;
        if (r56 == null) goto L152;
        r56.setAcuteAnglePosition(1);
        r56.setAcuteAngleDegree(60.0f);
        r56.setLeftCornerRadius(UtilityKotlinExtentionsKt.h(8));
        r56.setRightCornerRadius(UtilityKotlinExtentionsKt.h(2));
        String r57 = r112.getColorStart();
        if (r57 != null) goto L113;
    L116:
        boolean r58 = true;
    L117:
        if (r58 == true) goto L130;
        String r59 = r112.getColorEnd();
        if (r59 != null) goto L121;
    L124:
        boolean r60 = true;
    L125:
        if (r60 == true) goto L130;
        r56.setGradientOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L128
        r56.setColors(new int[]{Color.parseColor(r112.getColorStart()), Color.parseColor(r112.getColorEnd())});     // Catch: Exception -> L128
    L128:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L130
    L121:
        if (r59.length() == 0) goto L124;
        r60 = false;
    L130:
        String r62 = r112.getBorderColor();
        if (r62 != null) goto L133;
    L136:
        boolean r63 = true;
    L137:
        if (r63 == false) goto L284;
    L143:
        py.k r64 = r112.getIcon();
        if (r64 == null) goto L152;
        HSImageView r65 = this.i;
        if (r65 == null) goto L148;
        a1.p(r65, UtilityKotlinExtentionsKt.i(r64.getWidth()));
    L148:
        HSImageView r66 = this.i;
        if (r66 == null) goto L151;
        a1.k(r66, UtilityKotlinExtentionsKt.i(r64.getHeight()));
    L151:
        ImageLoader.bindImage(this.i, r64, UtilityKotlinExtentionsKt.i(r64.getWidth()), UtilityKotlinExtentionsKt.i(r64.getHeight()));
        goto L152
    L284:
        r56.setStrokeWidth(UtilityKotlinExtentionsKt.h(0.5f));     // Catch: Exception -> L141
        r56.setStrokeColor(Color.parseColor(r112.getBorderColor()));     // Catch: Exception -> L141
    L141:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L143
    L133:
        if (r62.length() == 0) goto L136;
        r63 = false;
        goto L137
    L113:
        if (r57.length() == 0) goto L116;
        r58 = false;
    L152:
        zs0.a r67 = zs0.c.a;
        LinearLayout r68 = this.j;
        HonorWallContent r69 = r110.getHonorWallContent();
        if (r69 == null) goto L155;
        ProfileText r70 = r69.getHonorWallTopDisplay();
    L156:
        zs0.c.a(r68, r70, null, null);
        LinearLayout r72 = this.k;
        HonorWallContent r73 = r110.getHonorWallContent();
        if (r73 == null) goto L159;
        ProfileText r74 = r73.getHonorWallBottomDisplay();
    L160:
        zs0.c.a(r72, r74, null, null);
        ConstraintLayout r75 = this.n;
        if (r75 == null) goto L163;
        a1.p(r75, ((Number) this.r.getValue()).intValue());
    L163:
        ExtraInfo r76 = r111.getExtraInfo();
        if (r76 != null) goto L166;
    L170:
        HonorWallContent r77 = r111.getHonorWallContent();
        if (r77 == null) goto L173;
        HonorWallBg r78 = r77.getHonorWallBg();
    L174:
        if (r78 == null) goto L220;
        TrapezoidConstraintLayout r79 = this.n;
        if (r79 == null) goto L220;
        r79.setAcuteAnglePosition(3);
        r79.setAcuteAngleDegree(60.0f);
        r79.setLeftCornerRadius(UtilityKotlinExtentionsKt.h(2));
        r79.setRightCornerRadius(UtilityKotlinExtentionsKt.h(8));
        String r80 = r78.getColorStart();
        if (r80 != null) goto L181;
    L184:
        boolean r82 = true;
    L185:
        if (r82 == true) goto L198;
        String r83 = r78.getColorEnd();
        if (r83 != null) goto L189;
    L192:
        boolean r84 = true;
    L193:
        if (r84 == true) goto L198;
        r79.setGradientOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L196
        r79.setColors(new int[]{Color.parseColor(r78.getColorStart()), Color.parseColor(r78.getColorEnd())});     // Catch: Exception -> L196
    L196:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L198
    L189:
        if (r83.length() == 0) goto L192;
        r84 = false;
    L198:
        String r85 = r78.getBorderColor();
        if (r85 != null) goto L201;
    L204:
        boolean r86 = true;
    L205:
        if (r86 == false) goto L292;
    L211:
        py.k r87 = r78.getIcon();
        if (r87 == null) goto L220;
        HSImageView r88 = this.o;
        if (r88 == null) goto L216;
        a1.p(r88, UtilityKotlinExtentionsKt.i(r87.getWidth()));
    L216:
        HSImageView r89 = this.o;
        if (r89 == null) goto L219;
        a1.k(r89, UtilityKotlinExtentionsKt.i(r87.getHeight()));
    L219:
        ImageLoader.bindImage(this.o, r87, UtilityKotlinExtentionsKt.i(r87.getWidth()), UtilityKotlinExtentionsKt.i(r87.getHeight()));
        goto L220
    L292:
        r79.setStrokeWidth(UtilityKotlinExtentionsKt.h(0.5f));     // Catch: Exception -> L209
        r79.setStrokeColor(Color.parseColor(r78.getBorderColor()));     // Catch: Exception -> L209
    L209:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L211
    L201:
        if (r85.length() == 0) goto L204;
        r86 = false;
        goto L205
    L181:
        if (r80.length() == 0) goto L184;
        r82 = false;
    L220:
        zs0.a r90 = zs0.c.a;
        LinearLayout r92 = this.p;
        HonorWallContent r93 = r111.getHonorWallContent();
        if (r93 == null) goto L223;
        ProfileText r94 = r93.getHonorWallTopDisplay();
    L224:
        r30 = null;
        zs0.c.a(r92, r94, null, null);
        LinearLayout r95 = this.q;
        HonorWallContent r96 = r111.getHonorWallContent();
        if (r96 == null) goto L227;
        ProfileText r97 = r96.getHonorWallBottomDisplay();
    L228:
        zs0.c.a(r95, r97, null, null);
        goto L229
    L227:
        r97 = null;
        goto L228
    L223:
        r94 = null;
        goto L224
    L173:
        r78 = null;
        goto L174
    L166:
        if (r76.isCanClick() != true) goto L170;
        ConstraintLayout r98 = this.n;
        if (r98 == null) goto L170;
        r98.setOnClickListener(new s(this, r111));
        goto L170
    L159:
        r74 = null;
        goto L160
    L155:
        r70 = null;
        goto L156
    L104:
        r112 = null;
        goto L106
    L97:
        if (r54.isCanClick() != true) goto L101;
        ConstraintLayout r99 = this.h;
        if (r99 == null) goto L101;
        r99.setOnClickListener(new r(this, r110));
        goto L101
    L298:
        return;
    L297:
        return;
    }

    public final void k(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L22;
        com.bytedance.android.live.profile.ui.base.d r1 = this.a;
        if (r1 == null) goto L16;
        Context r2 = r1.getContext();
        if (r2 == null) goto L16;
        IBaseLiveActionHandler r4 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r4 == null) goto L16;
        r4.handle(r2, r3);
    L16:
        this.s.getLogUseCase().v(this.m);
        IGiftServiceExternal r5 = jc1.k.f(IGiftServiceExternal.class);
        if (r5 == null) goto L23;
        ca0.o r6 = r5.getRevenueEventCenter();
        if (r6 == null) goto L24;
        r6.c();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r7, "newUser");
        ViewGroup r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ConstraintLayout r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ConstraintLayout r2 = this.n;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        AppCompatTextView r3 = this.l;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        AppCompatTextView r4 = this.g;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        this.m = false;
        ViewGroup r5 = this.c;
        if (r5 == null) goto L20;
        r5.setBackground(null);
    L20:
        ViewGroup r6 = this.c;
        if (r6 == null) goto L23;
        r6.setOnClickListener(null);
    L23:
        HSImageView r8 = this.d;
        if (r8 == null) goto L26;
        int r9 = com.bytedance.android.live.profile.ui.util.m.a;
        Intrinsics.checkNotNullParameter(r8, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r8);
        a1.p(r8, -2);
        a1.k(r8, -2);
    L26:
        LinearLayout r10 = this.e;
        if (r10 == null) goto L29;
        r10.removeAllViews();
    L29:
        LinearLayout r12 = this.f;
        if (r12 == null) goto L32;
        r12.removeAllViews();
    L32:
        TrapezoidConstraintLayout r13 = this.h;
        if (r13 == null) goto L35;
        r13.reset();
    L35:
        ConstraintLayout r14 = this.h;
        if (r14 == null) goto L38;
        r14.setOnClickListener(null);
    L38:
        ConstraintLayout r15 = this.h;
        if (r15 == null) goto L41;
        a1.p(r15, -1);
    L41:
        HSImageView r16 = this.i;
        if (r16 == null) goto L44;
        int r17 = com.bytedance.android.live.profile.ui.util.m.a;
        Intrinsics.checkNotNullParameter(r16, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r16);
        a1.p(r16, -2);
        a1.k(r16, -2);
    L44:
        LinearLayout r18 = this.j;
        if (r18 == null) goto L47;
        r18.removeAllViews();
    L47:
        LinearLayout r19 = this.k;
        if (r19 == null) goto L50;
        r19.removeAllViews();
    L50:
        TrapezoidConstraintLayout r20 = this.n;
        if (r20 == null) goto L53;
        r20.reset();
    L53:
        ConstraintLayout r22 = this.n;
        if (r22 == null) goto L56;
        r22.setOnClickListener(null);
    L56:
        ConstraintLayout r23 = this.n;
        if (r23 == null) goto L59;
        a1.p(r23, -1);
    L59:
        HSImageView r24 = this.o;
        if (r24 == null) goto L62;
        int r25 = com.bytedance.android.live.profile.ui.util.m.a;
        Intrinsics.checkNotNullParameter(r24, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r24);
        a1.p(r24, -2);
        a1.k(r24, -2);
    L62:
        LinearLayout r26 = this.p;
        if (r26 == null) goto L65;
        r26.removeAllViews();
    L65:
        LinearLayout r27 = this.q;
        if (r27 == null) goto L68;
        r27.removeAllViews();
    L68:
        g(r7);
    }

    public static final void j(p r9, HonorWallElement r10) {
        boolean r0 = com.bytedance.android.live.profile.ui.base.i.l(r9.s);
        boolean r1 = com.bytedance.android.live.profile.ui.base.i.m(r9.s);
        com.bytedance.android.live.profile.ui.base.h r2 = r9.s;
        Intrinsics.checkNotNullParameter(r2, "$this$selfIsGuest");
        Intrinsics.checkNotNullParameter(r2, "$this$selfUserId");
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        Map<? extends String, String> r4 = null;
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.user.e r5 = r3.user();
        if (r5 == null) goto L7;
        String r6 = r5.n();
    L8:
        String r7 = String.valueOf(r6);
        Intrinsics.checkNotNullParameter(r2, "$this$isTargetGuest");
        Intrinsics.checkNotNullParameter(r7, "uid");
        boolean r8 = vt0.h.b(r7);
        boolean r12 = true;
        if (r0 == true) goto L14;
        if (r1 == false) goto L13;
        if (r8 == false) goto L14;
    L13:
        boolean r13 = false;
    L15:
        ALogger.i("ProfileFansClubVipComponent", "click type: " + r10.getId() + ", isTargetAnchor: " + r0 + ", isTargetSelf: " + r1 + ", isSelfGuest: " + r8 + ", showCurrentAnchorPage: " + r13);
        if (r10.getId() != HonorWallElement.TYPE_FANS_CLUB) goto L53;
        if (r13 == false) goto L53;
        int r14 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((Boolean) rs0.l.a.getValue()).booleanValue() == false) goto L36;
        ExtraInfo r15 = r10.getExtraInfo();
        if (r15 == null) goto L23;
        String r16 = r15.getScheme();
    L24:
        if (r16 != null) goto L26;
    L29:
        boolean r17 = true;
    L30:
        if (r17 == true) goto L36;
        ExtraInfo r18 = r10.getExtraInfo();
        if (r18 == null) goto L34;
        String r19 = r18.getScheme();
    L35:
        r9.k(r19);
    L86:
        ExtraInfo r20 = r10.getExtraInfo();
        if (r20 == null) goto L89;
        r20.isDismissAfterClick();
    L89:
        ExtraInfo r22 = r10.getExtraInfo();
        if (r22 == null) goto L102;
        String r23 = r22.getClickEvent();
        if (r23 == null) goto L102;
        ExtraInfo r24 = r10.getExtraInfo();
        if (r24 == null) goto L97;
        Map r25 = r24.getClickEventParams();
    L98:
        LinkedHashMap r26 = new LinkedHashMap();
        if (r25 == null) goto L101;
        r26.putAll(r25);
    L101:
        r9.s.sendLog(r23, r26, new Object[0]);
        goto L102
    L97:
        r25 = null;
    L102:
        String r27 = r10.getName();
        if (r27 != null) goto L105;
        return;
    L105:
        if (((ss0.c) rs0.y.a.getValue()).b() == false) goto L109;
        ExtraInfo r110 = r10.getExtraInfo();
        if (r110 == null) goto L109;
        r4 = r110.getClickEventParams();
    L109:
        r9.s.recordBusinessClick(r27, r4);
        return;
    L34:
        r19 = null;
        goto L35
    L26:
        if (r16.length() == 0) goto L29;
        r17 = false;
        goto L30
    L23:
        r16 = null;
    L36:
        com.bytedance.android.live.profile.ui.base.d r28 = r9.a;
        if (r28 == null) goto L39;
        Context r29 = r28.getContext();
    L40:
        FragmentActivity r30 = ContextUtil.contextToFragmentActivity(r29);
        if (r30 == null) goto L86;
        com.bytedance.android.live.profile.ui.base.h r32 = r9.s;
        SubscribeInfo r33 = r32.getTargetUser().subscribeInfo;
        if (r33 == null) goto L45;
        boolean r34 = r33.isMember;
    L46:
        if (r34 == true) goto L48;
    L50:
        r12 = false;
    L51:
        r32.showFansClub(r30, "mini_card", r12);
        goto L86
    L48:
        if (com.bytedance.android.live.profile.ui.base.i.l(r9.s) == true) goto L50;
    L45:
        r34 = false;
        goto L46
    L39:
        r29 = null;
    L53:
        if (r10.getId() != HonorWallElement.TYPE_SHOP_FANS_CLUB) goto L72;
        if (r13 == false) goto L72;
        com.bytedance.android.live.profile.ui.base.d r35 = r9.a;
        if (r35 == null) goto L58;
        Context r36 = r35.getContext();
    L59:
        FragmentActivity r37 = ContextUtil.contextToFragmentActivity(r36);
        if (r37 == null) goto L86;
        com.bytedance.android.live.profile.ui.base.h r38 = r9.s;
        SubscribeInfo r39 = r38.getTargetUser().subscribeInfo;
        if (r39 == null) goto L64;
        boolean r40 = r39.isMember;
    L65:
        if (r40 == true) goto L67;
    L69:
        r12 = false;
    L70:
        r38.showFansClub(r37, "mini_card", r12);
        goto L86
    L67:
        if (com.bytedance.android.live.profile.ui.base.i.l(r9.s) == true) goto L69;
    L64:
        r40 = false;
        goto L65
    L58:
        r36 = null;
    L72:
        if (r10.getId() != HonorWallElement.TYPE_VIP) goto L81;
        if (r13 == false) goto L81;
        com.bytedance.android.live.profile.ui.base.d r42 = r9.a;
        if (r42 == null) goto L77;
        Context r43 = r42.getContext();
    L78:
        FragmentActivity r44 = ContextUtil.contextToFragmentActivity(r43);
        if (r44 == null) goto L86;
        r9.s.showSubscribePanel(r44, false);
        goto L86
    L77:
        r43 = null;
    L81:
        ExtraInfo r45 = r10.getExtraInfo();
        if (r45 == null) goto L84;
        String r46 = r45.getScheme();
    L85:
        r9.k(r46);
        goto L86
    L84:
        r46 = null;
    L14:
        r13 = true;
    L7:
        r6 = null;
        goto L8
    }
}
