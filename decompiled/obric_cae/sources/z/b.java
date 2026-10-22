package z;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.obric.cae.R;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f14130a = null;

    static {
        f14130a = new ThreadLocal();
    }

    public static ColorStateList a(Resources r8, XmlResourceParser r10, Resources.Theme r11) {
        AttributeSet r12 = Xml.asAttributeSet(r10);
    L3:
        int r13 = r10.next();
        if (r13 == 2) goto L8;
        if (r13 != 1) goto L3;
    L8:
        if (r13 != 2) goto L12;
        return b(r8, r10, r12, r11);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.content.res.TypedArray] */
    public static ColorStateList b(Resources r36, XmlResourceParser r37, AttributeSet r38, Resources.Theme r39) {
        r36 = r36;
        r38 = r38;
        r39 = r39;
        String r8 = r37.getName();
        if (r8.equals("selector") == false) goto L177;
        ?? r10 = 1;
        int r11 = r37.getDepth() + 1;
        int[][] r12 = new int[20][];
        int[] r13 = new int[20];
        int r14 = 0;
        int r15 = 0;
    L5:
        int r16 = r37.next();
        if (r16 == r10) goto L174;
        int r17 = r37.getDepth();
        if (r17 >= r11) goto L11;
        if (r16 == 3) goto L174;
    L11:
        if (r16 != 2) goto L173;
        if (r17 > r11) goto L173;
        if (r37.getName().equals("item") == false) goto L173;
        int[] r18 = y.a.f13899a;
        if (r39 != null) goto L19;
        ?? r19 = r36.obtainAttributes(r38, r18);
    L20:
        int r110 = r19.getResourceId(r14, -1);
        if (r110 == (-1)) goto L34;
        ThreadLocal<TypedValue> r111 = f14130a;
        TypedValue r112 = r111.get();
        if (r112 != null) goto L25;
        r112 = new TypedValue();
        r111.set(r112);
    L25:
        r36.getValue(r110, r112, r10);
        int r113 = r112.type;
        if (r113 >= 28) goto L28;
    L30:
        ?? r114 = r14;
    L31:
        if (r114 != 0) goto L34;
        int r115 = a(r36, r36.getXml(r110), r39).getDefaultColor();     // Catch: Exception -> L178
    L36:
        if (r19.hasValue(r10) == false) goto L39;
        float r116 = r19.getFloat(r10, 1.0f);
    L43:
        if (r19.hasValue(2) == false) goto L45;
        float r20 = r19.getFloat(2, -1.0f);
    L46:
        r19.recycle();
        int r21 = r38.getAttributeCount();
        int[] r117 = new int[r21];
        int r118 = r14;
        int r119 = r118;
    L47:
        if (r118 >= r21) goto L62;
        int r120 = r38.getAttributeNameResource(r118);
        if (r120 == 16843173) goto L61;
        if (r120 == 16843551) goto L61;
        if (r120 == R.attr.alpha) goto L61;
        if (r120 == R.attr.lStar) goto L61;
        int r22 = r119 + 1;
        if (r38.getAttributeBooleanValue(r118, false) == true) goto L60;
        r120 = -r120;
    L60:
        r117[r119] = r120;
        r119 = r22;
    L61:
        r118 = r118 + 1;
        goto L47
    L62:
        int[] r23 = StateSet.trimStateSet(r117, r119);
        float r24 = 0.0f;
        if (r20 >= 0.0f) goto L65;
    L67:
        boolean r25 = false;
    L69:
        if (r116 != 1.0f) goto L72;
        if (r25 == true) goto L72;
        r11 = r11;
        r12 = r12;
        r10 = 1;
        int[] r26 = r23;
    L157:
        int r27 = r15 + 1;
        int r28 = 8;
        if (r27 > r13.length) goto L160;
    L164:
        r13[r15] = r115;
        if (r27 <= r12.length) goto L171;
        Class<?> r29 = r12.getClass().getComponentType();
        if (r15 <= 4) goto L170;
        r28 = r15 * 2;
    L170:
        Object[] r30 = (Object[]) Array.newInstance(r29, r28);
        System.arraycopy(r12, 0, r30, 0, r15);
        Object[] r31 = r30;
    L172:
        r31[r15] = r26;
        r12 = (int[][]) r31;
        r15 = r27;
        r11 = r11;
        r14 = 0;
        goto L5
    L171:
        r31 = r12;
        goto L172
    L160:
        if (r15 > 4) goto L162;
        int r32 = 8;
    L163:
        int[] r33 = new int[r32];
        System.arraycopy(r13, 0, r33, 0, r15);
        r13 = r33;
        goto L164
    L162:
        r32 = r15 * 2;
    L72:
        int r121 = t2.b.p((int) ((Color.alpha(r115) * r116) + 0.5f), 0, 255);
        if (r25 == false) goto L155;
        a r34 = a.a(r115);
        j r122 = j.f14157k;
        float r123 = r34.f14125b;
        if (r123 < 1.0d) goto L128;
        int r210 = r121;
        if (Math.round(r20) <= 0.0d) goto L129;
        if (Math.round(r20) >= 100.0d) goto L129;
        float r35 = r34.f14124a;
        if (r35 >= 0.0f) goto L84;
        float r40 = 0.0f;
    L85:
        float r211 = 0.0f;
        float r124 = r123;
        a r125 = null;
        boolean r126 = true;
    L87:
        if (Math.abs(r211 - r123) < 0.4f) goto L122;
        float r212 = 1000.0f;
        float r213 = r24;
        float r214 = 1000.0f;
        float r215 = 100.0f;
        a r216 = null;
    L90:
        if (Math.abs(r213 - r215) <= 0.01f) goto L111;
        float r41 = ((r215 - r213) / 2.0f) + r213;
        int r42 = a.b(r41, r124, r40).c(j.f14157k);
        float r127 = zc.b.e(Color.red(r42));
        float r310 = zc.b.e(Color.green(r42));
        float r311 = zc.b.e(Color.blue(r42));
        float[] r312 = zc.b.f14336f[1];
        float r43 = ((r311 * r312[2]) + ((r310 * r312[1]) + (r127 * r312[0]))) / 100.0f;
        if (r43 > 0.008856452f) goto L94;
        float r44 = r43 * 903.2963f;
    L95:
        float r45 = Math.abs(r20 - r44);
        if (r45 >= 0.2f) goto L100;
        a r46 = a.a(r42);
        a r47 = a.b(r46.f14126c, r46.f14125b, r40);
        float r313 = r41;
        float r48 = r46.f14127d - r47.f14127d;
        float r314 = r40;
        float r128 = r46.f14128e - r47.f14128e;
        float r49 = r46.f14129f - r47.f14129f;
        float r50 = r49 * r49;
        r26 = r23;
        double r51 = Math.sqrt(r50 + ((r128 * r128) + (r48 * r48)));
        r12 = r12;
        float r52 = (float) (Math.pow(r51, 0.63d) * 1.41d);
        if (r52 > 1.0f) goto L101;
        r214 = r52;
        r216 = r46;
        r212 = r45;
    L101:
        float r53 = 0.0f;
        if (r212 != 0.0f) goto L107;
        if (r214 != 0.0f) goto L107;
    L112:
        a r54 = r216;
        if (r126 == false) goto L117;
        if (r54 != null) goto L115;
        r124 = ((r123 - r211) / 2.0f) + r211;
        r126 = false;
    L121:
        r24 = r53;
        r23 = r26;
        r12 = r12;
        r11 = r11;
        r40 = r314;
        goto L87
    L115:
        r115 = r54.c(r122);
    L126:
        boolean r55 = true;
    L156:
        r115 = (16777215 & r115) | (r210 << 24);
        r10 = r55;
        goto L157
    L117:
        if (r54 != null) goto L119;
        r123 = r124;
        r124 = r211;
    L120:
        r211 = r124;
        r124 = ((r123 - r124) / 2.0f) + r124;
        goto L121
    L119:
        r125 = r54;
    L107:
        if (r44 >= r20) goto L109;
        r213 = r313;
    L110:
        r24 = 0.0f;
        r23 = r26;
        r12 = r12;
        r11 = r11;
        r40 = r314;
        goto L90
    L109:
        r215 = r313;
        goto L110
    L100:
        r26 = r23;
        r313 = r41;
        r314 = r40;
        r12 = r12;
        goto L101
    L94:
        r44 = (((float) Math.cbrt(r43)) * 116.0f) - 16.0f;
        goto L95
    L111:
        r11 = r11;
        r314 = r40;
        r26 = r23;
        r12 = r12;
        r53 = r24;
        goto L112
    L122:
        r11 = r11;
        r12 = r12;
        r26 = r23;
        if (r125 == null) goto L131;
        r115 = r125.c(r122);
    L131:
        if (r20 >= 1.0f) goto L134;
        int r129 = -16777216;
        boolean r56 = true;
    L154:
        r115 = r129;
        r55 = r56;
        goto L156
    L134:
        if (r20 <= 99.0f) goto L136;
        r56 = true;
        r129 = -1;
        goto L154
    L136:
        float r57 = (r20 + 16.0f) / 116.0f;
        if (r20 <= 8.0f) goto L139;
        boolean r58 = true;
    L140:
        if (r58 == false) goto L142;
        float r59 = (r57 * r57) * r57;
    L143:
        float r60 = (r57 * r57) * r57;
        if (r60 <= 0.008856452f) goto L146;
        boolean r61 = true;
    L147:
        if (r61 == false) goto L149;
        float r62 = r60;
    L150:
        if (r61 == true) goto L153;
        r60 = ((r57 * 116.0f) - 16.0f) / 903.2963f;
    L153:
        float[] r63 = zc.b.f14335e;
        r56 = true;
        r129 = a0.a.a(r62 * r63[0], r59 * r63[1], r60 * r63[2]);
        goto L154
    L149:
        r62 = ((r57 * 116.0f) - 16.0f) / 903.2963f;
        goto L150
    L146:
        r61 = false;
        goto L147
    L142:
        r59 = r20 / 903.2963f;
        goto L143
    L139:
        r58 = false;
        goto L140
    L84:
        r40 = Math.min(360.0f, r35);
    L129:
        r26 = r23;
        goto L131
    L128:
        r210 = r121;
        goto L129
    L155:
        r11 = r11;
        r12 = r12;
        r210 = r121;
        r55 = true;
        r26 = r23;
        goto L156
    L65:
        if (r20 > 100.0f) goto L67;
        r25 = true;
        goto L69
    L45:
        r20 = r19.getFloat(4, -1.0f);
        goto L46
    L39:
        if (r19.hasValue(3) == false) goto L41;
        r116 = r19.getFloat(3, 1.0f);
        goto L43
    L41:
        r116 = 1.0f;
        goto L43
    L28:
        if (r113 > 31) goto L30;
        r114 = r10;
    L34:
        r115 = r19.getColor(r14, -65281);
        goto L36
    L19:
        r19 = r39.obtainStyledAttributes(r38, r18, r14, r14);
    L173:
        r12 = r12;
        r11 = r11;
        r14 = 0;
    L174:
        int[] r64 = new int[r15];
        int[][] r65 = new int[r15][];
        System.arraycopy(r13, 0, r64, 0, r15);
        System.arraycopy(r12, 0, r65, 0, r15);
        return new ColorStateList(r65, r64);
    L177:
        throw new XmlPullParserException(r37.getPositionDescription() + ": invalid color state list tag " + r8);
    }
}
