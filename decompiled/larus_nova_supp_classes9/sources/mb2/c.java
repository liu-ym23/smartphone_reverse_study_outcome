package mb2;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import ek6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ob2.f;
import py.k;
import qb2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final int a = 0;

    static {
        a = s1.f(20.0f);
    }

    public static ImageStyle a(float r18) {
        return new ImageStyle(ImageStyle.AdjustType.SCALE, 0, 0, r18, (int) (a * r18), 0, null, null, null, 0, 0, null, 0, 0, 0, 2097126);
    }

    public static ib2.a b(tb2.c r2, tb2.b r3) {
        m6 r0 = r2.getConvertedSchema();
        if (r0 != null) goto L5;
    L8:
        if (r3 != null) goto L10;
        i5 r4 = r2.getUserValue();
        if (r4 == null) goto L14;
        IBaseUser r5 = r4.getUser();
    L15:
        if (r5 != null) goto L17;
    L20:
        return null;
    L17:
        if (r2.getType() != PieceType.USER.getPieceType()) goto L20;
        return new ib2.a(new b(r5));
    L14:
        r5 = null;
        goto L15
    L10:
        return new ib2.a(r3);
    L5:
        if (TextUtils.isEmpty(r0.a()) == true) goto L8;
        return new ib2.a(new a(r0));
    }

    public static e c(tb2.d r35, float r36, String r37) {
        Intrinsics.checkNotNullParameter(r35, "payload");
        Intrinsics.checkNotNullParameter(r37, "source");
        bk6.a r1 = new bk6.a();
        yb2.a r2 = r35.b;
        b5 r3 = r35.c;
        float r5 = 0;
        if (r36 <= r5) goto L5;
        float r6 = r36;
    L6:
        List<tb2.c> r0 = r35.a;
        ArrayList r7 = new ArrayList();
        Iterator r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L234;
        tb2.c r8 = (tb2.c) r4.next();
        int r13 = r8.getType();
        if (r13 != PieceType.IMAGE.getPieceType()) goto L116;
        ITextPieceImage r11 = r8.getImageValue();
        if (r11 == null) goto L14;
        Integer r14 = Integer.valueOf(r11.getLocalResId());
    L15:
        ITextPieceImage r15 = r8.getImageValue();
        if (r15 == null) goto L18;
        k r16 = r15.getImageModel();
    L19:
        if (r14 != null) goto L21;
    L23:
        if (r16 != null) goto L25;
    L29:
        if (r16 != null) goto L31;
    L35:
        if (r16 != null) goto L37;
    L39:
        ek6.b r17 = null;
    L40:
        if (r17 != null) goto L42;
        Iterator r31 = r4;
        bk6.a r33 = r1;
        float r34 = r5;
        r7 = r7;
    L126:
        fk6.b r10 = null;
    L230:
        ArrayList r9 = r7;
        if (r10 == null) goto L233;
        r9.add(r10);
    L233:
        r7 = r9;
        r4 = r31;
        r5 = r34;
        r1 = r33;
        goto L8
    L42:
        if (r16 == null) goto L53;
        k.b r18 = r16.getImageContent();
        if (r18 == null) goto L53;
        String r19 = r18.getAccessibilityText();
        if (r19 == null) goto L53;
        if ((!TextUtils.isEmpty(r19)) == true) goto L51;
        r19 = null;
    L51:
        if (r19 == null) goto L53;
        jb2.b r110 = new jb2.b(r19);
    L54:
        ITextPieceImage r111 = r8.getImageValue();
        if (r111 != null) goto L57;
        ImageStyle r112 = a(r6);
    L82:
        ImageStyle.AdjustType r113 = r112.a;
        int r114 = r112.b;
        int r115 = r112.c;
        float r20 = r112.d;
        r31 = r4;
        int r21 = r112.e;
        r34 = r5;
        int r23 = r112.f;
        ImageStyle.PlaceHolderType r24 = ImageStyle.PlaceHolderType.EMPTY;
        ITextPieceImage r116 = r8.getImageValue();
        if (r116 == null) goto L87;
        int r117 = r114;
        r33 = r1;
        if (r116.getEnableTextWhenFailed() != true) goto L88;
        ImageStyle.PlaceHolderType r25 = ImageStyle.PlaceHolderType.TEXT;
    L89:
        String r26 = r8.getText();
        ImageStyle.AdjustType r27 = r112.a;
        ImageStyle.AdjustType r118 = ImageStyle.AdjustType.EXACTLY;
        if (r27 != r118) goto L92;
        int r28 = r112.c;
    L93:
        if (r27 != r118) goto L95;
        int r29 = r112.b;
    L96:
        ImageStyle.AlignmentType r210 = ImageStyle.AlignmentType.CENTER_ALIGN_TO_LINE_CENTER;
        int r211 = r8.getVerticalOffset();
        ITextPieceImage r30 = r8.getImageValue();
        if (r30 != null) goto L99;
    L101:
        int r212 = 0;
    L102:
        ImageStyle r38 = new ImageStyle(r113, r117, r115, r20, r21, r23, r24, r25, r26, r28, r29, r210, r211, r212, 0, 1048576);
        ib2.a r39 = b(r8, r8.getClickAction());
        h5 r40 = r8.getImageValue();
        if ((r40 instanceof h5) == true) goto L105;
        h5 r119 = null;
    L106:
        h5 r120 = r119;
        if (r120 != null) goto L109;
    L111:
        if (r120 != null) goto L113;
    L115:
        fk6.b r41 = new jb2.c(r17, r38, r39, r110);
    L123:
        r10 = r41;
        goto L230
    L113:
        if ((r17 instanceof f) == true) goto L115;
        r41 = new jb2.e(r120.getTextType(), r120.getTextContent(), r120.getTextColor(), r17, r38, r39, r110);
        goto L123
    L109:
        if ((r17 instanceof f) == false) goto L111;
        r41 = new jb2.f(r120.getTextContent(), r120.getTextColor(), r120.getTextSizeRate(), (f) r17, r38, r39, r110);
        goto L123
    L105:
        r119 = r40;
        goto L106
    L99:
        if (r30.isNeedExtraSpace() != true) goto L101;
        r212 = 10;
        goto L102
    L95:
        r29 = 0;
        goto L96
    L92:
        r28 = 0;
    L88:
        r25 = r24;
        goto L89
    L87:
        r33 = r1;
        r117 = r114;
        goto L88
    L57:
        k r121 = r111.getImageModel();
        if (r121 != null) goto L61;
        r112 = a(r6);
        goto L82
    L61:
        if (r111.getHeight() <= 0) goto L66;
        if (r111.getWidth() <= 0) goto L66;
        r112 = new ImageStyle(ImageStyle.AdjustType.EXACTLY, (int) (r111.getHeight() * r6), (int) (r111.getWidth() * r6), 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097144);
    L66:
        if (r111.getScaleType() != ITextPieceImage.ScaleType.FIT_Y) goto L72;
        if (r111.getHeight() <= 0) goto L72;
        ImageStyle r43 = new ImageStyle(ImageStyle.AdjustType.ADJUST_HEIGHT, (int) (r111.getHeight() * r6), 0, 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097148);
    L70:
        r112 = r43;
    L72:
        if (r111.getScaleX() <= r5) goto L77;
        if (r111.getScaleY() <= r5) goto L77;
        r43 = new ImageStyle(ImageStyle.AdjustType.SCALE, 0, 0, r111.getScaleX() * r6, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097142);
    L77:
        if (r121.getHeight() > 0) goto L79;
    L81:
        r112 = a(r6);
        goto L82
    L79:
        if (r121.getWidth() <= 0) goto L81;
        ImageStyle.AdjustType r122 = ImageStyle.AdjustType.EXACTLY;
        float r44 = r121.getWidth();
        int r123 = w2.a;
        r112 = new ImageStyle(r122, (int) ((r121.getHeight() * s1.E()) * r6), (int) ((r44 * s1.E()) * r6), 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097144);
    L53:
        r110 = null;
        goto L54
    L37:
        if (r16.isValid() != true) goto L39;
        r17 = new ob2.c(r16.getUrls(), r8.getImageDefaultRes());
        goto L40
    L31:
        if (r16.isResizableImg() != true) goto L35;
        if (r16.isValid() == false) goto L35;
        r17 = new f(r16.getUrls());
        goto L40
    L25:
        if (r16.isAnimated() != true) goto L29;
        if (r16.isValid() == false) goto L29;
        r17 = new ob2.a(r16.getUrls());
        goto L40
    L21:
        if (r14.intValue() == 0) goto L23;
        r17 = new ob2.d(r14.intValue());
        goto L40
    L18:
        r16 = null;
        goto L19
    L14:
        r14 = null;
        goto L15
    L116:
        r31 = r4;
        r33 = r1;
        r34 = r5;
        r7 = r7;
        if (r13 != PieceType.GIFT.getPieceType()) goto L125;
        e5 r45 = r8.getGiftValue();
        if (r45 == null) goto L121;
        long r46 = r45.getGiftId();
    L122:
        r41 = new jb2.c(new ob2.b(r46), a(r6), b(r8, r8.getClickAction()), null);
        goto L123
    L121:
        r46 = 0;
        goto L122
    L125:
        if (r13 == PieceType.HEART.getPieceType()) goto L126;
        PieceType r47 = PieceType.STRING;
        if (r13 != r47.getPieceType()) goto L153;
        String r48 = r8.getText();
        Integer r124 = Integer.valueOf(w.b(r47.getPieceType(), r8.getFormat(), r3, r2));
        b5 r49 = r8.getFormat();
        if (r49 == null) goto L138;
        Integer r50 = Integer.valueOf(r49.getFontSize());
        if (r50.intValue() <= 0) goto L134;
        boolean r51 = true;
    L136:
        if (Boolean.valueOf(r51).booleanValue() == false) goto L138;
        Integer r125 = r50;
    L139:
        Boolean r126 = Boolean.TRUE;
        b5 r53 = r8.getFormat();
        if (r53 != null) goto L142;
        boolean r127 = false;
    L147:
        b5 r54 = r8.getFormat();
        if (r54 == null) goto L150;
        boolean r128 = r54.isItalic();
    L151:
        r10 = new jb2.d(r48, new gk6.a(r124, r125, r126, r127, r128, false, null), b(r8, r8.getClickAction()), 8);
        goto L230
    L150:
        r128 = false;
        goto L151
    L142:
        if (Integer.valueOf(r53.getWeight()).intValue() < 700) goto L144;
        boolean r55 = true;
    L145:
        r127 = r55;
        goto L147
    L144:
        r55 = false;
        goto L145
    L134:
        r51 = false;
    L138:
        r125 = null;
        goto L139
    L153:
        PieceType r56 = PieceType.USER;
        if (r13 != r56.getPieceType()) goto L182;
        String r57 = r8.getText();
        Integer r129 = Integer.valueOf(w.b(r56.getPieceType(), r8.getFormat(), r3, r2));
        b5 r58 = r8.getFormat();
        if (r58 == null) goto L164;
        Integer r59 = Integer.valueOf(r58.getFontSize());
        if (r59.intValue() <= 0) goto L160;
        boolean r60 = true;
    L162:
        if (Boolean.valueOf(r60).booleanValue() == false) goto L164;
        Integer r130 = r59;
    L165:
        Boolean r131 = Boolean.TRUE;
        b5 r61 = r8.getFormat();
        if (r61 != null) goto L168;
        boolean r132 = false;
    L173:
        b5 r63 = r8.getFormat();
        if (r63 == null) goto L176;
        boolean r133 = r63.isItalic();
    L178:
        if (r2 == null) goto L180;
        Integer r134 = Integer.valueOf(r2.m);
    L181:
        r10 = new jb2.d(r57, new gk6.a(r129, r130, r131, r132, r133, false, r134), b(r8, r8.getClickAction()), false);
        goto L230
    L180:
        r134 = null;
        goto L181
    L176:
        r133 = false;
        goto L178
    L168:
        if (Integer.valueOf(r61.getWeight()).intValue() < 700) goto L170;
        boolean r64 = true;
    L171:
        r132 = r64;
        goto L173
    L170:
        r64 = false;
        goto L171
    L160:
        r60 = false;
    L164:
        r130 = null;
        goto L165
    L182:
        PieceType r65 = PieceType.PATTERN_REF;
        if (r13 != r65.getPieceType()) goto L207;
        String r66 = r8.getText();
        Integer r135 = Integer.valueOf(w.b(r65.getPieceType(), r8.getFormat(), r3, r2));
        b5 r67 = r8.getFormat();
        if (r67 == null) goto L193;
        Integer r68 = Integer.valueOf(r67.getFontSize());
        if (r68.intValue() <= 0) goto L189;
        boolean r69 = true;
    L191:
        if (Boolean.valueOf(r69).booleanValue() == false) goto L193;
        Integer r136 = r68;
    L194:
        Boolean r137 = Boolean.TRUE;
        b5 r70 = r8.getFormat();
        if (r70 != null) goto L197;
        boolean r138 = false;
    L202:
        b5 r71 = r8.getFormat();
        if (r71 == null) goto L205;
        boolean r139 = r71.isItalic();
    L206:
        r10 = new jb2.d(r66, new gk6.a(r135, r136, r137, r138, r139, false, null), b(r8, r8.getClickAction()), 8);
        goto L230
    L205:
        r139 = false;
        goto L206
    L197:
        if (Integer.valueOf(r70.getWeight()).intValue() < 700) goto L199;
        boolean r73 = true;
    L200:
        r138 = r73;
        goto L202
    L199:
        r73 = false;
        goto L200
    L189:
        r69 = false;
    L193:
        r136 = null;
        goto L194
    L207:
        String r74 = r8.getText();
        Integer r140 = Integer.valueOf(w.b(r47.getPieceType(), r8.getFormat(), r3, r2));
        b5 r75 = r8.getFormat();
        if (r75 == null) goto L216;
        Integer r76 = Integer.valueOf(r75.getFontSize());
        if (r76.intValue() <= 0) goto L212;
        boolean r77 = true;
    L214:
        if (Boolean.valueOf(r77).booleanValue() == false) goto L216;
        Integer r141 = r76;
    L217:
        Boolean r142 = Boolean.TRUE;
        b5 r78 = r8.getFormat();
        if (r78 != null) goto L220;
        boolean r143 = false;
    L225:
        b5 r79 = r8.getFormat();
        if (r79 == null) goto L228;
        boolean r144 = r79.isItalic();
    L229:
        r10 = new jb2.d(r74, new gk6.a(r140, r141, r142, r143, r144, false, null), b(r8, r8.getClickAction()), 8);
        goto L230
    L228:
        r144 = false;
        goto L229
    L220:
        if (Integer.valueOf(r78.getWeight()).intValue() < 700) goto L222;
        boolean r80 = true;
    L223:
        r143 = r80;
        goto L225
    L222:
        r80 = false;
        goto L223
    L212:
        r77 = false;
    L216:
        r141 = null;
        goto L217
    L234:
        bk6.a r310 = r1;
        List r81 = CollectionsKt.toList(r7);
        Intrinsics.checkNotNullParameter(r81, "contents");
        ((ArrayList) r310.a).addAll(r81);
        if (r3 == null) goto L249;
        Integer r145 = Integer.valueOf(w.b(PieceType.STRING.getPieceType(), null, r3, r2));
        g r83 = qb2.c.a;
        Integer r84 = Integer.valueOf(r3.getFontSize());
        if (r84.intValue() <= 0) goto L239;
        boolean r85 = true;
    L240:
        if (r85 == false) goto L242;
        Integer r146 = r84;
    L243:
        Boolean r147 = Boolean.TRUE;
        if (r3.getWeight() < 700) goto L246;
        boolean r148 = true;
    L247:
        gk6.a r149 = new gk6.a(r145, r146, r147, r148, r3.isItalic(), false, null);
    L254:
        r310.b = r149;
        return new e(CollectionsKt.toMutableList(r310.a), r310.b);
    L246:
        r148 = false;
        goto L247
    L242:
        r146 = null;
        goto L243
    L239:
        r85 = false;
        goto L240
    L249:
        if (r2 == null) goto L253;
        int r86 = r2.d;
        if (r86 == 0) goto L253;
        r149 = new gk6.a(Integer.valueOf(r86));
    L253:
        r149 = null;
        goto L254
    L5:
        r6 = 1.0f;
        goto L6
    }
}
