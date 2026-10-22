package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import android.graphics.Color;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.live.base.model.message.n6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser;
import com.bytedance.android.livesdk.utils.b0;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final List<Integer> a = null;
    public static final Map<Integer, List<Integer>> b = null;
    public static final Boolean c = null;

    static {
        ArrayList r0 = new ArrayList();
        a = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        b = r1;
        c = (Boolean) com.bytedance.android.livesdk.interactivity.service.settings.d.a.getValue();
        r0.add(51);
        r0.add(52);
        r0.add(53);
        r0.add(55);
        r0.add(56);
        r0.add(57);
        r1.put(51, CollectionsKt.listOf(7));
        r1.put(50, CollectionsKt.listOf(new Integer[]{7, 51}));
        r1.put(52, CollectionsKt.listOf(new Integer[]{7, 51, 50}));
        r1.put(53, CollectionsKt.listOf(new Integer[]{7, 51, 50, 52}));
        r1.put(58, CollectionsKt.listOf(new Integer[]{34, 35}));
        r1.put(59, CollectionsKt.listOf(new Integer[]{53, 52, 50, 58, 34, 35, 4, 57}));
    }

    public static List a(List r9) {
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L238;
        k r1 = (k) r10.next();
        Integer r2 = r1.getImageType();
        String r5 = null;
        if (r2 != null) goto L9;
    L32:
        Integer r3 = r1.getImageType();
        if (r3 != null) goto L36;
    L59:
        Integer r4 = r1.getImageType();
        if (r4 != null) goto L63;
    L86:
        Integer r6 = r1.getImageType();
        if (r6 != null) goto L90;
    L91:
        Integer r7 = r1.getImageType();
        if (r7 != null) goto L95;
    L96:
        Integer r8 = r1.getImageType();
        if (r8 != null) goto L100;
    L132:
        Integer r11 = r1.getImageType();
        if (r11 != null) goto L136;
    L137:
        Integer r13 = r1.getImageType();
        if (r13 != null) goto L141;
    L173:
        Integer r14 = r1.getImageType();
        if (r14 != null) goto L177;
    L209:
        Integer r15 = r1.getImageType();
        if (r15 != null) goto L213;
    L236:
        tb2.c r16 = c(r1);
    L237:
        r16.setBadgePiece(true);
        r0.add(r16);
        goto L4
    L213:
        if (r15.intValue() != 8) goto L236;
        k.b.a r17 = k.b.Companion;
        k.b r18 = r1.getImageContent();
        r17.getClass();
        if (k.b.a.a(r18) == false) goto L236;
        r16 = d(r1);
        h5 r19 = r16.getImageValue();
        if (r19 == null) goto L235;
        r19.setTextType(3);
        h5 r20 = r16.getImageValue();
        if (r20 == null) goto L233;
        h5 r21 = r20;
        k.b r23 = r1.getImageContent();
        if (r23 == null) goto L223;
        String r24 = r23.getName();
    L224:
        r21.setTextContent(r24);
        h5 r25 = r16.getImageValue();
        if (r25 == null) goto L231;
        h5 r26 = r25;
        k.b r27 = r1.getImageContent();
        if (r27 == null) goto L229;
        r5 = r27.getFontColor();
    L229:
        r26.setTextColor(f(String.valueOf(r5)));
        goto L237
    L231:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L223:
        r24 = null;
        goto L224
    L233:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L235:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L177:
        if (r14.intValue() != 57) goto L209;
        k.b.a r28 = k.b.Companion;
        k.b r29 = r1.getImageContent();
        r28.getClass();
        if (k.b.a.a(r29) == false) goto L209;
        r16 = d(r1);
        ITextPieceImage r30 = r16.getImageValue();
        if (r30 == null) goto L185;
        k r31 = r30.getImageModel();
        if (r31 == null) goto L185;
        r31.setIsResizableImg(true);
    L185:
        h5 r33 = r16.getImageValue();
        if (r33 == null) goto L208;
        r33.setTextType(5);
        h5 r34 = r16.getImageValue();
        if (r34 == null) goto L206;
        h5 r35 = r34;
        k.b r36 = r1.getImageContent();
        if (r36 == null) goto L192;
        String r37 = r36.getName();
    L193:
        r35.setTextContent(r37);
        h5 r38 = r16.getImageValue();
        if (r38 == null) goto L204;
        h5 r39 = r38;
        k.b r40 = r1.getImageContent();
        if (r40 == null) goto L198;
        r5 = r40.getFontColor();
    L198:
        r39.setTextColor(f(String.valueOf(r5)));
        h5 r41 = r16.getImageValue();
        if (r41 == null) goto L202;
        r41.setTextSizeRate(0.55f);
        goto L237
    L202:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L204:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L192:
        r37 = null;
        goto L193
    L206:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L208:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L141:
        if (r13.intValue() != 53) goto L173;
    L142:
        k.b.a r43 = k.b.Companion;
        k.b r44 = r1.getImageContent();
        r43.getClass();
        if (k.b.a.a(r44) == false) goto L173;
        r16 = d(r1);
        ITextPieceImage r45 = r16.getImageValue();
        if (r45 == null) goto L149;
        k r46 = r45.getImageModel();
        if (r46 == null) goto L149;
        r46.setIsResizableImg(true);
    L149:
        h5 r47 = r16.getImageValue();
        if (r47 == null) goto L172;
        r47.setTextType(5);
        h5 r48 = r16.getImageValue();
        if (r48 == null) goto L170;
        h5 r49 = r48;
        k.b r50 = r1.getImageContent();
        if (r50 == null) goto L156;
        String r51 = r50.getName();
    L157:
        r49.setTextContent(r51);
        h5 r53 = r16.getImageValue();
        if (r53 == null) goto L168;
        h5 r54 = r53;
        k.b r55 = r1.getImageContent();
        if (r55 == null) goto L162;
        r5 = r55.getFontColor();
    L162:
        r54.setTextColor(f(String.valueOf(r5)));
        h5 r56 = r16.getImageValue();
        if (r56 == null) goto L166;
        r56.setTextSizeRate(0.55f);
        goto L237
    L166:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L168:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L156:
        r51 = null;
        goto L157
    L170:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L172:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L136:
        if (r11.intValue() == 52) goto L142;
    L100:
        if (r8.intValue() != 56) goto L132;
    L101:
        k.b.a r57 = k.b.Companion;
        k.b r58 = r1.getImageContent();
        r57.getClass();
        if (k.b.a.a(r58) == false) goto L132;
        r16 = d(r1);
        ITextPieceImage r59 = r16.getImageValue();
        if (r59 == null) goto L108;
        k r60 = r59.getImageModel();
        if (r60 == null) goto L108;
        r60.setIsResizableImg(true);
    L108:
        h5 r61 = r16.getImageValue();
        if (r61 == null) goto L131;
        r61.setTextType(5);
        h5 r63 = r16.getImageValue();
        if (r63 == null) goto L129;
        h5 r64 = r63;
        k.b r65 = r1.getImageContent();
        if (r65 == null) goto L115;
        String r66 = r65.getName();
    L116:
        r64.setTextContent(r66);
        h5 r67 = r16.getImageValue();
        if (r67 == null) goto L127;
        h5 r68 = r67;
        k.b r69 = r1.getImageContent();
        if (r69 == null) goto L121;
        r5 = r69.getFontColor();
    L121:
        r68.setTextColor(f(String.valueOf(r5)));
        h5 r70 = r16.getImageValue();
        if (r70 == null) goto L125;
        r70.setTextSizeRate(0.55f);
        goto L237
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L127:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L115:
        r66 = null;
        goto L116
    L129:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L131:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L95:
        if (r7.intValue() == 55) goto L101;
    L90:
        if (r6.intValue() == 51) goto L101;
    L63:
        if (r4.intValue() != 50) goto L86;
        k.b.a r71 = k.b.Companion;
        k.b r73 = r1.getImageContent();
        r71.getClass();
        if (k.b.a.a(r73) == false) goto L86;
        r16 = d(r1);
        h5 r74 = r16.getImageValue();
        if (r74 == null) goto L85;
        r74.setTextType(4);
        h5 r75 = r16.getImageValue();
        if (r75 == null) goto L83;
        h5 r76 = r75;
        k.b r77 = r1.getImageContent();
        if (r77 == null) goto L73;
        String r78 = r77.getName();
    L74:
        r76.setTextContent(r78);
        h5 r79 = r16.getImageValue();
        if (r79 == null) goto L81;
        h5 r80 = r79;
        k.b r81 = r1.getImageContent();
        if (r81 == null) goto L79;
        r5 = r81.getFontColor();
    L79:
        r80.setTextColor(f(String.valueOf(r5)));
        goto L237
    L81:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L73:
        r78 = null;
        goto L74
    L83:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L36:
        if (r3.intValue() != 7) goto L59;
        k.b.a r83 = k.b.Companion;
        k.b r84 = r1.getImageContent();
        r83.getClass();
        if (k.b.a.a(r84) == false) goto L59;
        r16 = d(r1);
        h5 r85 = r16.getImageValue();
        if (r85 == null) goto L58;
        r85.setTextType(1);
        h5 r86 = r16.getImageValue();
        if (r86 == null) goto L56;
        h5 r87 = r86;
        k.b r88 = r1.getImageContent();
        if (r88 == null) goto L46;
        String r89 = r88.getName();
    L47:
        r87.setTextContent(r89);
        h5 r90 = r16.getImageValue();
        if (r90 == null) goto L54;
        h5 r91 = r90;
        k.b r93 = r1.getImageContent();
        if (r93 == null) goto L52;
        r5 = r93.getFontColor();
    L52:
        r91.setTextColor(f(String.valueOf(r5)));
        goto L237
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L46:
        r89 = null;
        goto L47
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L9:
        if (r2.intValue() != 5) goto L32;
        k.b.a r94 = k.b.Companion;
        k.b r95 = r1.getImageContent();
        r94.getClass();
        if (k.b.a.a(r95) == false) goto L32;
        r16 = d(r1);
        h5 r96 = r16.getImageValue();
        if (r96 == null) goto L31;
        r96.setTextType(2);
        h5 r97 = r16.getImageValue();
        if (r97 == null) goto L29;
        h5 r98 = r97;
        k.b r99 = r1.getImageContent();
        if (r99 == null) goto L19;
        String r100 = r99.getName();
    L20:
        r98.setTextContent(r100);
        h5 r101 = r16.getImageValue();
        if (r101 == null) goto L27;
        h5 r102 = r101;
        k.b r103 = r1.getImageContent();
        if (r103 == null) goto L25;
        r5 = r103.getFontColor();
    L25:
        r102.setTextColor(f(String.valueOf(r5)));
        goto L237
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L19:
        r100 = null;
        goto L20
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L238:
        return r0;
    }

    @JvmStatic
    public static final List<tb2.c> b(List<? extends k> r1) {
        Intrinsics.checkNotNullParameter(r1, "badgeImageList");
        List<tb2.c> r2 = a(r1);
        h(r2);
        g(r2);
        return r2;
    }

    public static tb2.c c(k r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (r3.getWidth() != 0) goto L5;
    L7:
        int r0 = w2.a;
        return c.d(BuildConfig.FLAVOR, r3, s1.E() / 3.0f);
    L5:
        if (r3.getHeight() == 0) goto L7;
        return c.b(BuildConfig.FLAVOR, r3, (int) g.a(r3.getWidth()), (int) g.a(r3.getHeight()));
    }

    public static tb2.c d(k r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        ITextPieceImage r2 = null;
        if (r7.getWidth() != 0) goto L5;
    L12:
        int r1 = w2.a;
        float r3 = s1.E() / 3.0f;
        int r5 = c.a;
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "placeholder");
        Intrinsics.checkNotNullParameter(r7, "model");
        tb2.c r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.IMAGE.getPieceType());
        r0.setText(BuildConfig.FLAVOR);
        n6.a r4 = n6.a;
        if (r4 == null) goto L17;
        ITextPieceImage r6 = r4.a();
        if (r6 == null) goto L17;
        r6.setResourceType(ITextPieceImage.ResourceType.NetWork);
        r6.setImageModel(r7);
        r6.setScaleX(r3);
        r6.setScaleY(r3);
        Unit r8 = Unit.INSTANCE;
        r2 = r6;
    L17:
        r0.setImageValue(r2);
    L18:
        return r0;
    L5:
        if (r7.getHeight() == 0) goto L12;
        int r9 = (int) g.a(r7.getWidth());
        int r10 = (int) g.a(r7.getHeight());
        int r11 = c.a;
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "placeholder");
        Intrinsics.checkNotNullParameter(r7, "model");
        r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.IMAGE.getPieceType());
        r0.setText(BuildConfig.FLAVOR);
        n6.a r13 = n6.a;
        if (r13 == null) goto L11;
        ITextPieceImage r14 = r13.a();
        if (r14 == null) goto L11;
        r14.setResourceType(ITextPieceImage.ResourceType.NetWork);
        r14.setImageModel(r7);
        r14.setWidth(r9);
        r14.setHeight(r10);
        Unit r15 = Unit.INSTANCE;
        r2 = r14;
    L11:
        r0.setImageValue(r2);
        goto L18
    }

    public static int f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "colorString");
        return Color.parseColor(r1);
    L5:
        return -16777216;
    }

    public static void g(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L20;
        ITextPieceImage r0 = ((tb2.c) r3.next()).getImageValue();
        if (r0 == null) goto L4;
        k r1 = r0.getImageModel();
        if (r1 == null) goto L4;
        k.b r4 = r1.getImageContent();
        if (r4 == null) goto L4;
        String r5 = r4.getAccessibilityText();
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L4;
        r4.setAccessibilityText("勋章");
        goto L4
    L14:
        if (r5.length() == 0) goto L17;
        r6 = false;
        goto L18
    }

    public static void h(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        ITextPieceImage r0 = ((tb2.c) r3.next()).getImageValue();
        if (r0 == null) goto L4;
        r0.setNeedExtraSpace(true);
        goto L4
    }

    @JvmStatic
    public static final List<tb2.c> e(IBaseUser r13, boolean r14, boolean r15) {
        Object r1 = null;
        if (c.booleanValue() == false) goto L15;
        int r0 = UserDslBadgeUtils.a;
        if (r13 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.service.model.d r2 = (com.bytedance.android.livesdk.interactivity.service.model.d) r13.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class);
        if (r2 == null) goto L9;
        PublicAreaBadgeInfo r3 = r2.getPublicAreaBadgeInfo();
    L10:
        if (r3 == null) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        List<tb2.c> r16 = UserDslBadgeUtils.b(UserDslBadgeUtils.e(r13));
        h(r16);
        g(r16);
        return r16;
    L12:
        r4 = false;
    L9:
        r3 = null;
    L15:
        if (r13 != null) goto L17;
        ArrayList r17 = new ArrayList();
    L124:
        return b(r17);
    L17:
        if (r14 == false) goto L22;
        if (r13.getMediaBadgeImageList() == null) goto L22;
        Iterable r18 = r13.getMediaBadgeImageList();
    L25:
        if (r18 == null) goto L59;
        ArrayList r5 = new ArrayList();
        Iterator r19 = r18.iterator();
    L28:
        if (r19.hasNext() == false) goto L60;
        Object r6 = r19.next();
        k r7 = (k) r6;
        if (r15 == false) goto L46;
        Integer r8 = r7.getImageType();
        if (r8 == null) goto L34;
        int r9 = r8.intValue();
    L36:
        if (b0.a(r9) == false) goto L38;
    L45:
        boolean r10 = true;
    L51:
        boolean r11 = CollectionsKt.contains(a, r7.getImageType());
        if (r10 == true) goto L56;
        if (r11 == true) goto L56;
        boolean r20 = false;
    L57:
        if (r20 == false) goto L28;
        r5.add(r6);
    L56:
        r20 = true;
        goto L57
    L38:
        if (r9 == 35) goto L42;
        if (r9 == 34) goto L42;
    L44:
        r10 = false;
    L42:
        if (((Boolean) j40.a.a.getValue()).booleanValue() == false) goto L44;
    L34:
        r9 = 0;
        goto L36
    L46:
        Integer r21 = r7.getImageType();
        if (r21 == null) goto L49;
        int r23 = r21.intValue();
    L50:
        r10 = b0.a(r23);
        goto L51
    L49:
        r23 = 0;
    L60:
        LinkedHashSet r110 = new LinkedHashSet();
        IFansClubMemberUser r111 = (IFansClubMemberUser) jc1.k.f(IFansClubMemberUser.class);
        if (r111 != null) goto L63;
    L72:
        r110.addAll(CollectionsKt.listOf(new Integer[]{56, 55, 57}));
    L73:
        IFansClubMemberUser r112 = (IFansClubMemberUser) jc1.k.f(IFansClubMemberUser.class);
        if (r112 == null) goto L76;
        Boolean r113 = Boolean.valueOf(r112.canShowVipSingleBadge());
    L78:
        if (r5 == null) goto L94;
        Iterator r24 = r5.iterator();
    L81:
        if (r24.hasNext() == false) goto L94;
        k r25 = (k) r24.next();
        List r26 = (List) ((LinkedHashMap) b).get(r25.getImageType());
        if (r26 == null) goto L81;
        Integer r27 = r25.getImageType();
        if (r27 == null) goto L92;
        if (r27.intValue() != 59) goto L92;
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L81;
        r110.addAll(r26);
    L92:
        r110.addAll(r26);
    L94:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L114;
        if (r5 == null) goto L109;
        Iterator r114 = r5.iterator();
    L98:
        if (r114.hasNext() == false) goto L108;
        Object r28 = r114.next();
        Integer r29 = ((k) r28).getImageType();
        if (r29 != null) goto L103;
    L105:
        boolean r30 = false;
    L106:
        if (r30 == false) goto L98;
        r1 = r28;
        goto L108
    L103:
        if (r29.intValue() != 59) goto L105;
        r30 = true;
    L108:
        r1 = (k) r1;
    L109:
        if (r1 != null) goto L111;
    L115:
        if (r5 == null) goto L122;
        r17 = new ArrayList();
        Iterator r115 = r5.iterator();
    L118:
        if (r115.hasNext() == false) goto L124;
        Object r31 = r115.next();
        if ((!CollectionsKt.contains(r110, ((k) r31).getImageType())) == false) goto L118;
        r17.add(r31);
        goto L118
    L122:
        r17 = new ArrayList();
        goto L124
    L111:
        if (((IFansClubMemberUser) jc1.k.n(IFansClubMemberUser.class)).isShopFansClubUser() == false) goto L113;
        r110.remove(55);
        goto L115
    L113:
        r110.remove(51);
        goto L115
    L114:
        r110.add(59);
        goto L115
    L76:
        r113 = null;
        goto L78
    L63:
        if (r111.isShopFansClubUser() != true) goto L72;
        IFansClubMemberUser r116 = (IFansClubMemberUser) jc1.k.f(IFansClubMemberUser.class);
        if (r116 == null) goto L69;
        if (r116.enableEcomFansClubReverse() == true) goto L72;
    L69:
        if (r13.isSubscriber() == false) goto L71;
        r110.addAll(CollectionsKt.listOf(new Integer[]{7, 51, 50, 52, 53, 55}));
        goto L73
    L71:
        r110.addAll(CollectionsKt.listOf(new Integer[]{7, 51, 50, 52, 53}));
        goto L73
    L59:
        r5 = null;
    L22:
        if (r13.getBadgeImageListV2() == null) goto L24;
        r18 = r13.getBadgeImageListV2();
        goto L25
    L24:
        r18 = new ArrayList();
        goto L25
    }
}
