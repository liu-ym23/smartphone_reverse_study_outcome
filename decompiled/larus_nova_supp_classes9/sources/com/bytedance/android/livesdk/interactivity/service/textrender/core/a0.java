package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.p3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 {
    public static final Boolean a = null;

    static {
        a = (Boolean) com.bytedance.android.livesdk.interactivity.service.settings.i.a.getValue();
    }

    public static PieceType b(int r2) {
        PieceType r0 = PieceType.HEART;
        if (r2 != r0.getPieceType()) goto L5;
        return r0;
    L5:
        PieceType r1 = PieceType.USER;
        if (r2 != r1.getPieceType()) goto L8;
        return r1;
    L8:
        PieceType r3 = PieceType.STRING;
        if (r2 != r3.getPieceType()) goto L11;
        return r3;
    L11:
        PieceType r4 = PieceType.GIFT;
        if (r2 != r4.getPieceType()) goto L14;
        return r4;
    L14:
        PieceType r5 = PieceType.PATTERN_REF;
        if (r2 != r5.getPieceType()) goto L17;
        return r5;
    L17:
        PieceType r6 = PieceType.IMAGE;
        if (r2 != r6.getPieceType()) goto L21;
        return r6;
    L21:
        return PieceType.UNKNOWN;
    }

    public static tb2.d a(a5 r19, yb2.a r20) {
        if (r19 == null) goto L4;
        if (r20 != null) goto L7;
        yb2.a r0 = w.a();
    L8:
        Map<String, ? extends c5> r1 = r0.l;
        if (r1 != null) goto L11;
    L35:
        boolean r2 = CollectionUtils.isEmpty(r19.getPieces());
        String r3 = BuildConfig.FLAVOR;
        if (r2 == false) goto L45;
        tb2.d r4 = new tb2.d();
        r4.c = r19.getDefaultFormat();
        r4.b = r0;
        ArrayList r5 = new ArrayList();
        tb2.c r6 = new tb2.c(vh7.f.c(c5.class));
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L43;
        String r7 = r19.getDefaultPattern();
        if (r7 == null) goto L43;
        r3 = r7;
    L43:
        r6.setText(r3);
        r5.add(r6);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.a = r5;
        return r4;
    L45:
        ArrayList r8 = new ArrayList();
        HashMap r9 = new HashMap();
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L49;
        String r10 = r19.getDefaultPattern();
        if (r10 == null) goto L49;
    L50:
        List r11 = r19.getPieces();
        if (r11 == null) goto L241;
        if (r11.isEmpty() == true) goto L241;
        ArrayList r13 = new ArrayList();
        r13.add(r8);
        r13.add(r9);
        StringBuilder r14 = new StringBuilder();
        int r15 = r10.length();
        int r16 = 0;
        int r17 = 0;
        int r18 = -1;
        int r110 = -1;
        int r111 = -1;
    L56:
        if (r16 >= r15) goto L234;
        char r21 = r10.charAt(r16);
        if (r21 != ':') goto L60;
        List r112 = r11;
        r15 = r15;
        if (r17 == 0) goto L232;
        if (r17 != 1) goto L241;
        r111 = CastIntegerProtector.valueOf(r10.subSequence(r18, r16).toString()).intValue();
        r110 = r16 + 1;
        char r23 = '}';
        r18 = -1;
    L230:
        if (r21 == r23) goto L232;
        r14.append(r21);
    L232:
        r16 = r16 + 1;
        r15 = r15;
        r11 = r112;
        goto L56
    L60:
        if (r21 == '{') goto L214;
        if (r21 == '}') goto L65;
        r112 = r11;
        r15 = r15;
    L223:
        r23 = '}';
        goto L230
    L65:
        if (r110 == (-1)) goto L67;
        String r113 = r10.subSequence(r110, r16).toString();
    L68:
        int r114 = r111;
        if (r114 == (-1)) goto L241;
        if (r14.length() <= 0) goto L73;
        boolean r115 = true;
    L74:
        if (r115 == false) goto L77;
        r14.delete(0, r14.length());
    L77:
        if (r114 >= 0) goto L79;
    L98:
        r112 = r11;
    L99:
        c5 r116 = null;
    L100:
        if (r116 == null) goto L209;
        int r24 = c.a;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "config");
        int r25 = r116.getType();
        if (r25 != PieceType.STRING.getPieceType()) goto L106;
        String r26 = r116.getStringValue();
    L104:
        String r27 = r26;
    L207:
        r8.add(r27);
        r9.put(Integer.valueOf(r8.size() - 1), r116);
    L213:
        r17 = r17 - 1;
        r23 = '}';
        r110 = -1;
        r111 = -1;
        goto L230
    L106:
        if (r25 != PieceType.USER.getPieceType()) goto L167;
        i5 r28 = r116.getUserValue();
        if (r28 != null) goto L110;
    L206:
        r27 = null;
        goto L207
    L110:
        if (r28.getUser() == null) goto L206;
        if (r28.isWithColon() == false) goto L115;
        String r29 = "：";
    L117:
        if (r0.j == false) goto L126;
        String r117 = r0.g;
        IBaseUser r118 = r28.getUser();
        if (r118 == null) goto L121;
        String r119 = r118.getIdString();
    L123:
        if (Intrinsics.areEqual(r117, r119) == false) goto L126;
        r26 = s1.B(2131915891) + r29;
        goto L104
    L121:
        r119 = null;
    L126:
        if (r0.k == false) goto L145;
        IBaseUser r120 = r28.getUser();
        if (r120 == null) goto L130;
        String r121 = r120.getSafeNicName();
    L132:
        if (TextUtils.isEmpty(r121) == true) goto L145;
        StringBuilder r122 = new StringBuilder();
        String r123 = r28.getPrefixString();
        if (r123 != null) goto L136;
        r123 = BuildConfig.FLAVOR;
    L136:
        r122.append(r123);
        IBaseUser r124 = r28.getUser();
        if (r124 == null) goto L139;
        String r125 = r124.getSafeNicName();
    L140:
        r122.append(r125);
        String r30 = r28.getPostfixString();
        if (r30 != null) goto L143;
        r30 = BuildConfig.FLAVOR;
    L143:
        r122.append(r30);
        r122.append(r29);
        r26 = r122.toString();
        goto L104
    L139:
        r125 = null;
        goto L140
    L130:
        r121 = null;
    L145:
        if (r28.selfShowRealName() == false) goto L159;
        IBaseUser r126 = r28.getUser();
        if (r126 == null) goto L159;
        String r127 = r126.getWebcastUid();
        if (r127 == null) goto L159;
        if (r127.equals(r0.h) != true) goto L159;
        StringBuilder r128 = new StringBuilder();
        String r129 = r28.getPrefixString();
        if (r129 != null) goto L155;
        r129 = BuildConfig.FLAVOR;
    L155:
        r128.append(r129);
        r128.append(r0.i);
        String r31 = r28.getPostfixString();
        if (r31 != null) goto L158;
        r31 = BuildConfig.FLAVOR;
    L158:
        r128.append(r31);
        r128.append(r29);
        r26 = r128.toString();
    L159:
        StringBuilder r130 = new StringBuilder();
        String r131 = r28.getPrefixString();
        if (r131 != null) goto L162;
        r131 = BuildConfig.FLAVOR;
    L162:
        r130.append(r131);
        r130.append(gm2.q.b(r28.getUser()));
        String r33 = r28.getPostfixString();
        if (r33 != null) goto L165;
        r33 = BuildConfig.FLAVOR;
    L165:
        r130.append(r33);
        r130.append(r29);
        r26 = r130.toString();
        goto L104
    L115:
        r29 = BuildConfig.FLAVOR;
        goto L117
    L167:
        if (r25 != PieceType.GIFT.getPieceType()) goto L191;
        e5 r34 = r116.getGiftValue();
        if (r34 == null) goto L206;
        if (r34.getNameRef() == null) goto L189;
        p3 r35 = r34.getNameRef();
        if (r35 == null) goto L176;
        String r36 = r35.getKey();
    L177:
        if (r36 == null) goto L189;
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L184;
        p3 r37 = r34.getNameRef();
        if (r37 == null) goto L184;
        String r38 = r37.getDefaultPattern();
        if (r38 == null) goto L184;
    L186:
        if (TextUtils.isEmpty(r38) == false) goto L188;
        r38 = s1.B(2131919136);
    L188:
        r26 = Intrinsics.stringPlus(r38, " . ");
    L184:
        r38 = BuildConfig.FLAVOR;
        goto L186
    L176:
        r36 = null;
    L189:
        r26 = s1.B(2131919136) + " . ";
        goto L104
    L191:
        if (r116.getType() != PieceType.HEART.getPieceType()) goto L194;
        r27 = " ";
        goto L207
    L194:
        if (r25 != PieceType.PATTERN_REF.getPieceType()) goto L204;
        g5 r39 = r116.getPatternRefValue();
        if (r39 != null) goto L199;
    L202:
        r27 = BuildConfig.FLAVOR;
        goto L207
    L199:
        if (TextUtils.isEmpty(r39.getDefaultPattern()) == true) goto L202;
        r26 = r39.getDefaultPattern();
        if (r26 != null) goto L104;
    L204:
        if (r25 != PieceType.IMAGE.getPieceType()) goto L206;
        r27 = tb2.c.DEFAULT_TEXT;
        goto L207
    L209:
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.b == false) goto L213;
        pm0.a r40 = om0.c.c();
        if (r40 == null) goto L213;
        r40.i("ttlive_render_engine", "piece result is null !! pattern " + r10 + "  index: " + r114 + "  tag " + r113);
        goto L213
    L79:
        if (r114 >= r11.size()) goto L98;
        if (TextUtils.isEmpty(r113) == true) goto L98;
        if (r11.isEmpty() == true) goto L98;
        r116 = (c5) ListProtector.get(r11, r114);
        r112 = r11;
        if (r0.f != true) goto L95;
        if (r116.getType() != PieceType.IMAGE.getPieceType()) goto L95;
        c5 r41 = (c5) vh7.f.c(c5.class);
        r41.setFormat(r116.getFormat());
        r41.setType(r116.getType());
        r41.setGiftValue(r116.getGiftValue());
        r41.setHeartValue(r116.getHeartValue());
        r41.setPatternRefValue(r116.getPatternRefValue());
        r41.setStringValue(r116.getStringValue());
        r41.setUserValue(r116.getUserValue());
        ITextPieceImage r43 = r116.getImageValue();
        if (r43 == null) goto L92;
        ITextPieceImage r44 = r43.doClone();
    L93:
        r41.setImageValue(r44);
        r41.setSchemaKey(r116.getSchemaKey());
        r116 = r41;
        goto L95
    L92:
        r44 = null;
    L95:
        if (Intrinsics.areEqual(b(r116.getType()).getTag(), r113) == true) goto L100;
        Logger.e("I18N_MESSAGE", "TextPieceHelper: tag is false");
        goto L99
    L73:
        r115 = false;
        goto L74
    L67:
        r111 = CastIntegerProtector.valueOf(r10.subSequence(r18, r16).toString()).intValue();
        r113 = "string";
        goto L68
    L214:
        r112 = r11;
        r15 = r15;
        r17 = r17 + 1;
        if (r17 != 1) goto L241;
        r18 = r16 + 1;
        if (r14.length() <= 0) goto L220;
        boolean r45 = true;
    L221:
        if (r45 == false) goto L223;
        r8.add(r14.toString());
        c5 r46 = vh7.f.c(c5.class);
        r46.setNormalPiece(true);
        r9.put(Integer.valueOf(r8.size() - 1), r46);
        r14.delete(0, r14.length());
        goto L223
    L220:
        r45 = false;
        goto L221
    L234:
        if (r14.length() <= 0) goto L236;
        boolean r132 = true;
    L237:
        if (r132 == false) goto L241;
        r8.add(r14.toString());
        c5 r47 = vh7.f.c(c5.class);
        r47.setNormalPiece(true);
        r9.put(Integer.valueOf(r8.size() - 1), r47);
        r14.delete(0, r14.length());
        goto L241
    L236:
        r132 = false;
    L241:
        if (a.booleanValue() == true) goto L244;
        r0 = w.a();
    L244:
        tb2.d r48 = new tb2.d();
        r48.b = r0;
        LinkedList r49 = new LinkedList();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r48.a = r49;
        r48.c = r19.getDefaultFormat();
        int r50 = r8.size();
        int r51 = 0;
    L245:
        if (r51 >= r50) goto L262;
        String r53 = (String) ListProtector.get(r8, r51);
        c5 r54 = (c5) r9.get(Integer.valueOf(r51));
        if (r53 != null) goto L249;
        r53 = BuildConfig.FLAVOR;
    L249:
        tb2.c r55 = new tb2.c(r54, r53);
        Map r56 = r19.getSchemaInfos();
        if (r56 == null) goto L261;
        String r57 = r55.getSchemaKey();
        if (r57 == null) goto L261;
        if (r56.keySet().contains(r57) == false) goto L261;
        r55.setConvertedSchema((m6) r56.get(r57));
        m6 r58 = r55.getConvertedSchema();
        if (r58 == null) goto L261;
        r58.a = r57;
    L261:
        r49.add(r55);
        r51 = r51 + 1;
        goto L245
    L262:
        return r48;
    L49:
        r10 = BuildConfig.FLAVOR;
        goto L50
    L11:
        if (r1.isEmpty() == true) goto L35;
        Iterator r59 = r19.getPieces().iterator();
    L15:
        if (r59.hasNext() == false) goto L35;
        c5 r60 = (c5) r59.next();
        c5 r61 = r1.get(r60.getRefKey());
        if (r61 == null) goto L15;
        int r63 = z.a[b(r60.getType()).ordinal()];
        if (r63 != 1) goto L22;
        r60.setStringValue(r61.getStringValue());
        goto L15
    L22:
        if (r63 != 2) goto L24;
        r60.setUserValue(r61.getUserValue());
        goto L15
    L24:
        if (r63 != 3) goto L26;
        r60.setGiftValue(r61.getGiftValue());
        goto L15
    L26:
        if (r63 != 4) goto L28;
        r60.setPatternRefValue(r61.getPatternRefValue());
        goto L15
    L28:
        if (r63 != 5) goto L15;
        r60.setImageValue(r61.getImageValue());
        goto L15
    L7:
        r0 = r20;
        goto L8
    L4:
        return new tb2.d();
    }
}
