package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBadgeSuffix;
import com.bytedance.android.live.base.model.user.ProfileBasicArea;
import com.bytedance.android.live.base.model.user.ProfileConstant;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.base.model.user.ShopEntrance;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.view.ProfileBadgeSuffixView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.r2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileCommonComponent implements com.bytedance.android.live.profile.ui.base.g {
    public final Fragment a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public int g;
    public final List<String> h;
    public final com.bytedance.android.live.profile.ui.base.l i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    public final ViewGroup c() {
        return (ViewGroup) this.e.getValue();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final ConstraintLayout h() {
        return (ConstraintLayout) this.d.getValue();
    }

    public final TextView i() {
        return (TextView) this.c.getValue();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.CommonComponent.INSTANCE;
    }

    public ProfileCommonComponent(com.bytedance.android.live.profile.ui.base.l r2) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        this.i = r2;
        this.a = r2.getHostFragment();
        this.b = LazyKt.lazy(new ProfileCommonComponent$mAvatarView$2(this));
        this.c = LazyKt.lazy(new ProfileCommonComponent$mUserName$2(this));
        this.d = LazyKt.lazy(new ProfileCommonComponent$mShopEntrance$2(this));
        this.e = LazyKt.lazy(new ProfileCommonComponent$badgeScrollContainer$2(this));
        this.f = LazyKt.lazy(new ProfileCommonComponent$badgeInnerContainer$2(this));
        this.h = new ArrayList();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r4, "user");
        int r5 = this.g;
        if (r5 == 0) goto L5;
        this.i.a().showShopEntrance(r5, "live_personal_card");
    L5:
        Iterator r6 = ((ArrayList) this.h).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        String r0 = (String) r6.next();
        this.i.b().recordBusinessShow(TrackArea.BasicAreaArea, r0);
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r3) {
        if ((r3 instanceof ProfileSkin) == false) goto L17;
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L18;
        ProfileCustomSkin.GradientColor r5 = r4.nickNameColor;
        if (r5 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r5.from) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5.to) == true) goto L22;
        TextView r0 = i();
        if (r0 == null) goto L21;
        r0.post(new g(r5, this));
        return;
    L21:
        return;
    L22:
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.profile.ui.component.view.ProfileBadgeSuffixView] */
    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r20) {
        Intrinsics.checkNotNullParameter(r20, "user");
        if (r20.isVcdContentAuthorized() == true) goto L8;
        TextView r0 = i();
        if (r0 == null) goto L223;
        r0.setText(s1.B(2131920694));
        return;
    L223:
        return;
    L8:
        TextView r1 = i();
        String r3 = "";
        if (r1 == null) goto L15;
        String r4 = r20.getDisplayName();
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r1.setText(r4);
    L15:
        TextView r2 = i();
        String r5 = r20.getDisplayName();
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        boolean r6 = true;
        r3.c(r2, r5, true);
        TextView r7 = i();
        if (r7 == null) goto L21;
        r7.setOnClickListener(new f(this));
    L21:
        ((ArrayList) this.h).add("user_name");
        BaseProfileInfo r8 = r20.baseProfileInfo;
        if (r8 == null) goto L26;
        py.k r9 = r8.avatarThumb;
        if (r9 == null) goto L26;
        ImageLoader.bindImage((HSImageView) this.b.getValue(), r9, UtilityKotlinExtentionsKt.i(72), UtilityKotlinExtentionsKt.i(72));
    L26:
        HSImageView r10 = (HSImageView) this.b.getValue();
        if (r10 == null) goto L29;
        r10.setOnClickListener(new c(this));
    L29:
        HSImageView r12 = (HSImageView) this.b.getValue();
        if (r12 == null) goto L32;
        r12.setImportantForAccessibility(1);
    L32:
        HSImageView r13 = (HSImageView) this.b.getValue();
        Object[] r14 = new Object[1];
        String r15 = r20.getDisplayName();
        if (r15 == null) goto L36;
        r3 = r15;
    L36:
        int r16 = 0;
        r14[0] = r3;
        r3.c(r13, s1.C(2131921709, r14), true);
        ((ArrayList) this.h).add("avatar");
        ShopEntrance r17 = r20.shopEntrance;
        if (r17 == null) goto L39;
        int r18 = r17.entranceType;
    L41:
        if (r18 == 0) goto L100;
        ProfileStyleParams r19 = r20.getProfileStyleParams();
        if (r19 != null) goto L46;
    L47:
        ProfileStyleParams r22 = r20.getProfileStyleParams();
        if (r22 != null) goto L50;
    L52:
        ConstraintLayout r23 = h();
        if (r23 == null) goto L100;
        TextView r24 = (TextView) r23.findViewById(2131378520);
        if (r18 != 1) goto L57;
        String r25 = s1.B(2131920037);
    L58:
        r24.setText(r25);
        r23.setVisibility(0);
        this.g = r18;
        r23.setOnClickListener(new e(this, r18));
        ProfileSkin r26 = r20.mProfileSkin;
        if (r26 == null) goto L99;
        ProfileCustomSkin r27 = r26.skin;
        if (r27 == null) goto L99;
        if (r27.honorWallSkin == null) goto L99;
        int r28 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((ss0.a) b0.a.getValue()).g() == false) goto L99;
        Drawable r29 = s1.m(2131249476);     // Catch: Exception -> L97
        if ((r29 instanceof GradientDrawable) == true) goto L72;
        r29 = null;
    L72:
        GradientDrawable r30 = (GradientDrawable) r29;     // Catch: Exception -> L97
        if (r30 == null) goto L77;
        r30.mutate();     // Catch: Exception -> L97
        r30.setColor(Color.parseColor("#26FFFFFF"));     // Catch: Exception -> L97
        ConstraintLayout r32 = h();     // Catch: Exception -> L97
        if (r32 == null) goto L77;
        r32.setBackground(r30);     // Catch: Exception -> L97
    L77:
        int r33 = Color.parseColor("#E6FFFFFF");     // Catch: Exception -> L97
        ConstraintLayout r34 = h();     // Catch: Exception -> L97
        if (r34 == null) goto L84;
        ImageView r35 = (ImageView) r34.findViewById(2131378519);     // Catch: Exception -> L97
        if (r35 == null) goto L84;
        Drawable r36 = r35.getBackground();     // Catch: Exception -> L97
        if (r36 == null) goto L84;
        r36.mutate();     // Catch: Exception -> L97
        r36.setColorFilter(r33, PorterDuff.Mode.SRC_ATOP);     // Catch: Exception -> L97
    L84:
        ConstraintLayout r37 = h();     // Catch: Exception -> L97
        if (r37 == null) goto L89;
        TextView r38 = (TextView) r37.findViewById(2131378520);     // Catch: Exception -> L97
        if (r38 == null) goto L89;
        r38.setTextColor(r33);     // Catch: Exception -> L97
        r38.setAlpha(1.0f);     // Catch: Exception -> L97
    L89:
        ConstraintLayout r39 = h();     // Catch: Exception -> L97
        if (r39 == null) goto L99;
        ImageView r40 = (ImageView) r39.findViewById(2131378518);     // Catch: Exception -> L97
        if (r40 == null) goto L99;
        Drawable r42 = r40.getBackground();     // Catch: Exception -> L97
        if (r42 == null) goto L99;
        r42.mutate();     // Catch: Exception -> L97
        r42.setColorFilter(r33, PorterDuff.Mode.SRC_ATOP);     // Catch: Exception -> L97
    L97:
        e = move-exception;
        ALogger.e(NewProfileInfoViewModel.TAG, "loadShopEntranceSkin error: " + e.getMessage());
    L99:
        ((ArrayList) this.h).add("small_shop_entrance");
        goto L100
    L57:
        r25 = s1.B(2131920038);
        goto L58
    L50:
        if (((int) r22.getProfileStyle()) != ProfileConstant.ProfileType.SHOP.getType()) goto L52;
    L46:
        if (((int) r19.getProfileStyle()) != ProfileConstant.ProfileType.WINDOW.getType()) goto L47;
    L100:
        ViewGroup r43 = c();
        int r44 = 6;
        if (r43 == null) goto L175;
        Context r45 = r43.getContext();
        if (r45 == null) goto L175;
        ViewGroup r46 = (ViewGroup) this.f.getValue();
        if (r46 == null) goto L108;
        r46.removeAllViews();
    L108:
        ProfileBasicArea r47 = r20.basicArea;
        if (r47 == null) goto L172;
        List r48 = r47.badgeList;
        if (r48 == null) goto L172;
        if ((!r48.isEmpty()) == true) goto L116;
        r48 = null;
    L116:
        if (r48 == null) goto L172;
        ViewGroup r49 = c();
        if (r49 == null) goto L120;
        r49.setVisibility(0);
    L120:
        py.k r50 = (py.k) CollectionsKt.firstOrNull(r48);
        if (r50 == null) goto L125;
        Intrinsics.checkNotNullParameter(r50, "$this$heightKt");
        int r52 = r50.getHeight();
        ViewGroup r53 = c();
        if (r53 == null) goto L125;
        a1.k(r53, UtilityKotlinExtentionsKt.i(r52) + UtilityKotlinExtentionsKt.i(4));
    L125:
        ProfileBasicArea r54 = r20.basicArea;
        if (r54 == null) goto L129;
        Map r55 = r54.badgeSuffixMap;
        if (r55 == null) goto L129;
    L130:
        List r56 = r48;
        Iterator r57 = r56.iterator();
    L132:
        if (r57.hasNext() == false) goto L145;
        py.k r110 = (py.k) r57.next();
        Context r111 = this.i.getHostFragment().getContext();
        if (r111 != null) goto L136;
        r111 = r45;
    L136:
        ?? r112 = new ProfileBadgeSuffixView(r111, null, r44, r16);
        ProfileBadgeSuffix r113 = (ProfileBadgeSuffix) r55.get(r110.getImageType());
        Intrinsics.checkNotNullParameter(r110, "badge");
        ImageLoader.bindImage(r112.b, r110, null, -1, -1, null, new com.bytedance.android.live.profile.ui.component.view.a(r112, r110, r113), true);
        if (com.bytedance.android.live.profile.ui.base.i.m(this.i.b()) == true) goto L139;
    L141:
        ViewGroup r58 = (ViewGroup) this.f.getValue();
        if (r58 == 0) goto L144;
        r58.addView(r112);
    L144:
        r44 = 6;
        r16 = 0;
        goto L132
    L139:
        if (r2.a(r110.getSchema()) == false) goto L141;
        r112.setOnClickListener(new d(r110, r55, this, r45));
        goto L141
    L145:
        boolean r59 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).convertHonorImageModel((py.k) CollectionsKt.firstOrNull(r48));
        StringBuilder r60 = new StringBuilder();
        Iterator r62 = r56.iterator();
        int r63 = 0;
    L147:
        if (r62.hasNext() == false) goto L160;
        Object r64 = r62.next();
        int r65 = r63 + 1;
        if (r63 >= 0) goto L151;
        CollectionsKt.throwIndexOverflow();
    L151:
        py.k.b r66 = ((py.k) r64).getImageContent();
        if (r66 == null) goto L159;
        String r67 = r66.getAccessibilityText();
        if (r67 == null) goto L159;
        if (r63 <= 0) goto L158;
        r60.append(", ");
    L158:
        r60.append(r67);
    L159:
        r63 = r65;
        goto L147
    L160:
        String r68 = r60.toString();
        if (com.bytedance.android.live.profile.ui.base.i.m(this.i.b()) == false) goto L167;
        ViewGroup r69 = c();
        if (r69 == null) goto L166;
        ViewCompat.setAccessibilityDelegate(r69, null);
    L166:
        r3.c(c(), r68, true);
        goto L175
    L167:
        ViewGroup r70 = c();
        if (r70 == null) goto L171;
        ViewCompat.setAccessibilityDelegate(r70, null);
    L171:
        r3.b(c(), r68, TextView.class);
    L129:
        r55 = MapsKt.emptyMap();
    L172:
        ViewGroup r72 = c();
        if (r72 == null) goto L175;
        UtilityKotlinExtentionsKt.t(r72);
    L175:
        TextView r73 = i();
        if (r73 == null) goto L178;
        a1.n(r73, UtilityKotlinExtentionsKt.i(16));
    L178:
        ViewGroup r74 = c();
        if (r74 == null) goto L181;
        a1.m(r74, UtilityKotlinExtentionsKt.i(6));
    L181:
        ViewGroup r75 = c();
        if (r75 == null) goto L184;
        a1.n(r75, UtilityKotlinExtentionsKt.i(10));
    L184:
        ConstraintLayout r76 = h();
        if (r76 == null) goto L187;
        a1.n(r76, UtilityKotlinExtentionsKt.i(16));
    L187:
        ViewGroup r77 = c();
        if (r77 != null) goto L190;
    L192:
        boolean r78 = false;
    L193:
        ConstraintLayout r79 = h();
        if (r79 != null) goto L196;
    L198:
        r6 = false;
    L199:
        if (r78 == false) goto L205;
        if (r6 == false) goto L205;
        TextView r80 = i();
        if (r80 == null) goto L224;
        a1.n(r80, 0);
        return;
    L224:
        return;
    L205:
        if (r78 == false) goto L226;
        if (r6 == true) goto L227;
        TextView r82 = i();
        if (r82 == null) goto L210;
        a1.n(r82, 0);
    L210:
        ViewGroup r83 = c();
        if (r83 == null) goto L228;
        a1.n(r83, UtilityKotlinExtentionsKt.i(16));
        return;
    L228:
        return;
    L227:
        return;
    L226:
        return;
    L196:
        if (r79.getVisibility() != 0) goto L198;
    L190:
        if (r77.getVisibility() != 0) goto L192;
        r78 = true;
        goto L193
    L39:
        r18 = 0;
        goto L41
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileCommonComponent update");
        ConstraintLayout r0 = h();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ViewGroup r1 = c();
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ViewGroup r2 = (ViewGroup) this.f.getValue();
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        ViewGroup r4 = c();
        if (r4 == null) goto L14;
        r4.setClickable(false);
    L14:
        this.g = 0;
        ((ArrayList) this.h).clear();
        TextView r5 = i();
        if (r5 == null) goto L17;
        r5.post(new h(this));
    L17:
        g(r3);
        e(r3.mProfileSkin);
    }

    public static final void a(ProfileCommonComponent r8, TextView r9, int r10, int r12) {
        r8.getClass();
        if (r9 == null) goto L6;
        r9.getPaint().setShader(new LinearGradient(0.0f, r9.getHeight(), 0.0f, 0.0f, r10, r12, Shader.TileMode.CLAMP));
        r9.invalidate();
        return;
    }
}
