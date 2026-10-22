package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.FlexImageModel;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profit.dress.config.DressResource;
import com.bytedance.android.live.profit.dress.config.x;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static py.k a(NewProfileUser r7, DressType r8, x r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$getDressImageModelWithFallback");
        Intrinsics.checkNotNullParameter(r8, "dressType");
        Intrinsics.checkNotNullParameter(r7, "$this$getDressImageModel");
        Intrinsics.checkNotNullParameter(r8, "dressType");
        int r1 = t.a;
        boolean r2 = true;
        FlexImageModel r3 = null;
        if (((ss0.a) b0.a.getValue()).b() == false) goto L5;
    L11:
        if (r9 != null) goto L14;
        r9 = null;
    L14:
        switch(k.a[r8.ordinal()]) {
            case 1: goto L60;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L46;
            case 5: goto L42;
            case 6: goto L38;
            case 7: goto L34;
            case 8: goto L30;
            case 9: goto L26;
            case 10: goto L20;
            case 11: goto L16;
            default: goto L161;
        };
    L16:
        if (r9 == null) goto L64;
        com.bytedance.android.live.profit.dress.v r10 = r9.h;
        if (r10 == null) goto L137;
        py.k r12 = r10.k;
    L65:
        StringBuilder r4 = new StringBuilder("get ");
        r4.append(r8);
        r4.append(" from dressId is null: ");
        if (r12 != null) goto L68;
        boolean r6 = true;
    L69:
        r4.append(r6);
        ALogger.i(NewProfileInfoViewModel.TAG, r4.toString());
        if (r12 != null) goto L162;
        Intrinsics.checkNotNullParameter(r7, "$this$getFallbackImageModel");
        Intrinsics.checkNotNullParameter(r8, "dressType");
        switch(k.b[r8.ordinal()]) {
            case 1: goto L124;
            case 2: goto L117;
            case 3: goto L108;
            case 4: goto L99;
            case 5: goto L90;
            case 6: goto L83;
            case 7: goto L74;
            default: goto L131;
        };
    L74:
        ProfileSkin r13 = r7.mProfileSkin;
        if (r13 == null) goto L131;
        ProfileCustomSkin r14 = r13.skin;
        if (r14 == null) goto L131;
        ProfileCustomSkin.MainButtonUI r15 = r14.mainButtonUI;
        if (r15 == null) goto L131;
        com.bytedance.android.live.base.model.d r16 = r15.uri;
        if (r16 == null) goto L131;
        r3 = com.bytedance.android.live.base.model.e.a(r16);
        goto L131
    L83:
        ProfileSkin r17 = r7.mProfileSkin;
        if (r17 == null) goto L131;
        ProfileCustomSkin r18 = r17.skin;
        if (r18 == null) goto L131;
        ProfileCustomSkin.BgUI r19 = r18.bgSkin;
        if (r19 == null) goto L131;
        r3 = r19.rightBottomImage;
        goto L131
    L90:
        ProfileSkin r20 = r7.mProfileSkin;
        if (r20 == null) goto L131;
        ProfileCustomSkin r22 = r20.skin;
        if (r22 == null) goto L131;
        ProfileCustomSkin.BgUI r23 = r22.bgSkin;
        if (r23 == null) goto L131;
        ProfileCustomSkin.ExtendTopBorder r24 = r23.extendTopBorder;
        if (r24 == null) goto L131;
        r3 = r24.overlayWebpLoop;
        goto L131
    L99:
        ProfileSkin r25 = r7.mProfileSkin;
        if (r25 == null) goto L131;
        ProfileCustomSkin r26 = r25.skin;
        if (r26 == null) goto L131;
        ProfileCustomSkin.BgUI r27 = r26.bgSkin;
        if (r27 == null) goto L131;
        ProfileCustomSkin.ExtendTopBorder r28 = r27.extendTopBorder;
        if (r28 == null) goto L131;
        r3 = r28.overlayWebpEnter;
        goto L131
    L108:
        ProfileSkin r29 = r7.mProfileSkin;
        if (r29 == null) goto L131;
        ProfileCustomSkin r30 = r29.skin;
        if (r30 == null) goto L131;
        ProfileCustomSkin.BgUI r32 = r30.bgSkin;
        if (r32 == null) goto L131;
        com.bytedance.android.live.base.model.d r33 = r32.topBorder;
        if (r33 == null) goto L131;
        r3 = com.bytedance.android.live.base.model.e.a(r33);
        goto L131
    L117:
        ProfileSkin r34 = r7.mProfileSkin;
        if (r34 == null) goto L131;
        ProfileCustomSkin r35 = r34.skin;
        if (r35 == null) goto L131;
        ProfileCustomSkin.BgUIWebp r36 = r35.bgUIWebp;
        if (r36 == null) goto L131;
        r3 = r36.overallImage;
        goto L131
    L124:
        ProfileSkin r37 = r7.mProfileSkin;
        if (r37 == null) goto L131;
        ProfileCustomSkin r38 = r37.skin;
        if (r38 == null) goto L131;
        ProfileCustomSkin.BgUI r39 = r38.bgSkin;
        if (r39 == null) goto L131;
        r3 = r39.cardBg;
    L131:
        StringBuilder r40 = new StringBuilder("get ");
        r40.append(r8);
        r40.append(" from NewProfileUser is null: ");
        if (r3 == null) goto L135;
        r2 = false;
    L135:
        r40.append(r2);
        ALogger.i(NewProfileInfoViewModel.TAG, r40.toString());
        return r3;
    L162:
        return r12;
    L68:
        r6 = false;
        goto L69
    L137:
        r12 = null;
        goto L65
    L64:
        r12 = null;
        goto L65
    L20:
        if (r9 == null) goto L138;
        com.bytedance.android.live.profit.dress.v r42 = r9.h;
        if (r42 == null) goto L139;
        com.bytedance.android.live.base.model.d r43 = r42.j;
        if (r43 == null) goto L140;
        r12 = com.bytedance.android.live.base.model.e.a(r43);
        goto L65
    L140:
        r12 = null;
        goto L65
    L139:
        r12 = null;
        goto L65
    L138:
        r12 = null;
        goto L65
    L26:
        if (r9 == null) goto L141;
        DressResource.a r44 = (DressResource.a) MapsKt.getOrImplicitDefaultNullable(r9.d, x.i[1].getName());
        if (r44 == null) goto L142;
        r12 = (py.k) com.bytedance.android.live.profit.dress.config.a.a(r44);
        goto L65
    L142:
        r12 = null;
        goto L65
    L141:
        r12 = null;
        goto L65
    L30:
        if (r9 == null) goto L143;
        com.bytedance.android.live.profit.dress.v r45 = r9.h;
        if (r45 == null) goto L144;
        r12 = r45.g;
        goto L65
    L144:
        r12 = null;
        goto L65
    L143:
        r12 = null;
        goto L65
    L34:
        if (r9 == null) goto L145;
        com.bytedance.android.live.profit.dress.v r46 = r9.h;
        if (r46 == null) goto L146;
        r12 = r46.i;
        goto L65
    L146:
        r12 = null;
        goto L65
    L145:
        r12 = null;
        goto L65
    L38:
        if (r9 == null) goto L147;
        DressResource.a r47 = (DressResource.a) MapsKt.getOrImplicitDefaultNullable(r9.f, x.i[3].getName());
        if (r47 == null) goto L148;
        r12 = (py.k) com.bytedance.android.live.profit.dress.config.a.a(r47);
        goto L65
    L148:
        r12 = null;
        goto L65
    L147:
        r12 = null;
        goto L65
    L42:
        if (r9 == null) goto L149;
        DressResource.a r48 = (DressResource.a) MapsKt.getOrImplicitDefaultNullable(r9.e, x.i[2].getName());
        if (r48 == null) goto L150;
        r12 = (py.k) com.bytedance.android.live.profit.dress.config.a.a(r48);
        goto L65
    L150:
        r12 = null;
        goto L65
    L149:
        r12 = null;
        goto L65
    L46:
        if (r9 == null) goto L151;
        com.bytedance.android.live.profit.dress.v r49 = r9.h;
        if (r49 == null) goto L152;
        com.bytedance.android.live.base.model.d r50 = r49.h;
        if (r50 == null) goto L153;
        r12 = com.bytedance.android.live.base.model.e.a(r50);
        goto L65
    L153:
        r12 = null;
        goto L65
    L152:
        r12 = null;
        goto L65
    L151:
        r12 = null;
        goto L65
    L52:
        if (r9 == null) goto L154;
        com.bytedance.android.live.profit.dress.v r52 = r9.h;
        if (r52 == null) goto L155;
        r12 = r52.f;
        goto L65
    L155:
        r12 = null;
        goto L65
    L154:
        r12 = null;
        goto L65
    L56:
        if (r9 == null) goto L156;
        com.bytedance.android.live.profit.dress.v r53 = r9.h;
        if (r53 == null) goto L157;
        r12 = r53.e;
        goto L65
    L157:
        r12 = null;
        goto L65
    L156:
        r12 = null;
        goto L65
    L60:
        if (r9 == null) goto L158;
        com.bytedance.android.live.profit.dress.v r54 = r9.h;
        if (r54 == null) goto L159;
        r12 = r54.d;
        goto L65
    L159:
        r12 = null;
        goto L65
    L158:
        r12 = null;
        goto L65
    L161:
        r12 = null;
        goto L65
    L5:
        if (r8 == DressType.MainButtonWebp) goto L11;
        if (r8 == DressType.PanelEnterWebp) goto L11;
        if (r8 == DressType.PanelExitWebp) goto L11;
        r12 = null;
        goto L65
    }
}
