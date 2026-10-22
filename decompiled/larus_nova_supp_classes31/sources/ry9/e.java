package ry9;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentViolation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import wa8.d1;
import wa8.g1;
import wa8.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreationReferenceAttachmentType.values().length];
            r0[CreationReferenceAttachmentType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CreationReferenceAttachmentType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CreationReferenceAttachmentType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CreationReferenceAttachmentType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static CreationReferenceMediaType a(CreationReferenceAttachmentType r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return CreationReferenceMediaType.AUDIO;
    L19:
        return CreationReferenceMediaType.VIDEO;
    L16:
        return CreationReferenceMediaType.IMAGE;
    }

    public static CreationReferenceAttachmentViolation b(d1 r18, d r19) {
        Intrinsics.checkNotNullParameter(r18, "capability");
        Intrinsics.checkNotNullParameter(r19, "snapshot");
        CreationReferenceAttachmentViolation r2 = c(r18, r19);
        if (r2 == null) goto L5;
        return r2;
    L5:
        List<c> r3 = r19.a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        c r6 = (c) r5.next();
        CreationReferenceMediaType r7 = a(r6.getType());
        if (r7 == null) goto L12;
        r4.add(TuplesKt.to(r7, r6));
        goto L7
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L13:
        Iterator r8 = r4.iterator();
    L15:
        if (r8.hasNext() == false) goto L34;
        Pair r9 = (Pair) r8.next();
        CreationReferenceMediaType r10 = (CreationReferenceMediaType) r9.component1();
        c r11 = (c) r9.component2();
        g1 r12 = r18.d(r10);
        if (r12 == null) goto L15;
        Long r13 = r12.g;
        if (r13 == null) goto L15;
        long r14 = r13.longValue();
        Integer r15 = r11.h;
        Integer r16 = r11.i;
        if (r15 == null) goto L33;
        if (r16 == null) goto L33;
        if (r15.intValue() <= 0) goto L33;
        if (r16.intValue() <= 0) goto L33;
        if (Math.max(r15.intValue(), r16.intValue()) <= r14) goto L15;
        return CreationReferenceAttachmentViolation.RESOLUTION;
    L33:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L34:
        Iterator r17 = r4.iterator();
    L36:
        if (r17.hasNext() == false) goto L75;
        Pair r20 = (Pair) r17.next();
        CreationReferenceMediaType r21 = (CreationReferenceMediaType) r20.component1();
        c r22 = (c) r20.component2();
        g1 r23 = r18.d(r21);
        if (r23 == null) goto L36;
        Double r24 = r22.j;
        if (r23.l == null) goto L43;
    L44:
        if (r24 == null) goto L74;
        if (r24.doubleValue() <= 0.0d) goto L74;
    L48:
        if (r24 == null) goto L36;
        if (r24.doubleValue() <= 0.0d) goto L36;
        Double r25 = r23.l;
        if (r25 != null) goto L54;
    L59:
        boolean r26 = false;
    L60:
        if (r26 == true) goto L72;
        Double r27 = r23.m;
        if (r27 != null) goto L64;
    L69:
        boolean r28 = false;
    L70:
        if (r28 == false) goto L36;
    L64:
        if (r24.doubleValue() <= r27.doubleValue()) goto L66;
        boolean r29 = true;
    L67:
        if (r29 != true) goto L69;
        r28 = true;
        goto L70
    L66:
        r29 = false;
    L72:
        return CreationReferenceAttachmentViolation.SINGLE_DURATION;
    L54:
        if (r24.doubleValue() >= r25.doubleValue()) goto L56;
        boolean r30 = true;
    L57:
        if (r30 != true) goto L59;
        r26 = true;
        goto L60
    L56:
        r30 = false;
    L74:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L43:
        if (r23.m == null) goto L48;
    L75:
        Iterator r31 = r18.c.values().iterator();
    L76:
        Double r32 = null;
        if (r31.hasNext() == false) goto L143;
        g1 r33 = (g1) r31.next();
        if (r33.getType() == CreationReferenceMediaType.VIDEO) goto L83;
        if (r33.getType() != CreationReferenceMediaType.AUDIO) goto L76;
    L83:
        Double r110 = r33.d;
        if (r110 == null) goto L76;
        double r111 = r110.doubleValue();
        ArrayList r112 = new ArrayList();
        Iterator r113 = r4.iterator();
    L87:
        if (r113.hasNext() == false) goto L95;
        Object r114 = r113.next();
        if (((Pair) r114).getFirst() != r33.getType()) goto L91;
        boolean r34 = true;
    L92:
        if (r34 == false) goto L87;
        r112.add(r114);
        goto L87
    L91:
        r34 = false;
        goto L92
    L95:
        if (r112.isEmpty() == true) goto L109;
        Iterator r35 = r112.iterator();
    L99:
        if (r35.hasNext() == false) goto L109;
        Double r115 = ((c) ((Pair) r35.next()).getSecond()).j;
        if (r115 != null) goto L103;
    L106:
        boolean r116 = true;
    L107:
        if (r116 == false) goto L99;
        boolean r36 = true;
    L110:
        if (r36 == true) goto L112;
        if (r33.getType() != CreationReferenceMediaType.VIDEO) goto L116;
        r32 = r19.c;
    L116:
        if (r32 == null) goto L128;
        double r37 = r32.doubleValue();
        if (Double.isInfinite(r37) == false) goto L120;
    L122:
        boolean r38 = false;
    L123:
        if (r38 == false) goto L127;
        if (r32.doubleValue() > 0.0d) goto L128;
    L127:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L120:
        if (Double.isNaN(r37) == true) goto L122;
        r38 = true;
    L128:
        Iterator r39 = r112.iterator();
        double r117 = 0.0d;
    L130:
        if (r39.hasNext() == false) goto L136;
        Double r40 = ((c) ((Pair) r39.next()).getSecond()).j;
        if (r40 == null) goto L134;
        double r118 = r40.doubleValue();
    L135:
        r117 = r117 + r118;
        goto L130
    L134:
        r118 = 0.0d;
        goto L135
    L136:
        if (r32 == null) goto L138;
        double r41 = r32.doubleValue();
    L140:
        if ((r117 + r41) <= r111) goto L76;
        return CreationReferenceAttachmentViolation.TOTAL_DURATION;
    L138:
        r41 = 0.0d;
        goto L140
    L112:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L103:
        if (r115.doubleValue() <= 0.0d) goto L106;
        r116 = false;
    L109:
        r36 = false;
        goto L110
    L143:
        Iterator r42 = r18.d.iterator();
    L145:
        if (r42.hasNext() == false) goto L213;
        h1 r43 = (h1) r42.next();
        ArrayList r44 = new ArrayList();
        Iterator r119 = r4.iterator();
    L148:
        if (r119.hasNext() == false) goto L159;
        Object r120 = r119.next();
        Pair r121 = (Pair) r120;
        if (r43.a.contains(r121.getFirst()) == true) goto L152;
    L156:
        boolean r122 = false;
    L157:
        if (r122 == false) goto L148;
        r44.add(r120);
        goto L148
    L152:
        if (r121.getFirst() != CreationReferenceMediaType.VIDEO) goto L154;
    L155:
        r122 = true;
        goto L157
    L154:
        if (r121.getFirst() != CreationReferenceMediaType.AUDIO) goto L156;
    L159:
        Double r123 = r43.d;
        if (r123 == null) goto L145;
        double r124 = r123.doubleValue();
        Double r125 = r19.c;
        if (r125 == null) goto L166;
        r125.doubleValue();
        if (r43.a.contains(CreationReferenceMediaType.VIDEO) == false) goto L166;
    L168:
        if (r44.isEmpty() == true) goto L182;
        Iterator r45 = r44.iterator();
    L172:
        if (r45.hasNext() == false) goto L182;
        Double r126 = ((c) ((Pair) r45.next()).getSecond()).j;
        if (r126 != null) goto L176;
    L179:
        boolean r127 = true;
    L180:
        if (r127 == false) goto L172;
        boolean r46 = true;
    L183:
        if (r46 == true) goto L185;
        if (r125 == null) goto L198;
        double r128 = r125.doubleValue();
        if (Double.isInfinite(r128) == false) goto L190;
    L192:
        boolean r47 = false;
    L193:
        if (r47 == false) goto L197;
        if (r125.doubleValue() > 0.0d) goto L198;
    L197:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L190:
        if (Double.isNaN(r128) == true) goto L192;
        r47 = true;
    L198:
        Iterator r48 = r44.iterator();
        double r129 = 0.0d;
    L200:
        if (r48.hasNext() == false) goto L206;
        Double r49 = ((c) ((Pair) r48.next()).getSecond()).j;
        if (r49 == null) goto L204;
        double r130 = r49.doubleValue();
    L205:
        r129 = r129 + r130;
        goto L200
    L204:
        r130 = 0.0d;
        goto L205
    L206:
        if (r125 == null) goto L208;
        double r50 = r125.doubleValue();
    L210:
        if ((r129 + r50) <= r124) goto L145;
        return CreationReferenceAttachmentViolation.TOTAL_DURATION;
    L208:
        r50 = 0.0d;
        goto L210
    L185:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L176:
        if (r126.doubleValue() <= 0.0d) goto L179;
        r127 = false;
    L182:
        r46 = false;
    L166:
        r125 = null;
        goto L168
    L213:
        Iterator r1 = r4.iterator();
    L215:
        if (r1.hasNext() == false) goto L235;
        Pair r51 = (Pair) r1.next();
        CreationReferenceMediaType r52 = (CreationReferenceMediaType) r51.component1();
        c r53 = (c) r51.component2();
        g1 r54 = r18.d(r52);
        if (r54 == null) goto L215;
        Long r55 = r54.n;
        if (r55 == null) goto L215;
        long r56 = r55.longValue();
        Long r57 = r53.k;
        if (r57 != null) goto L224;
    L229:
        r57 = null;
    L230:
        if (r57 == null) goto L215;
        if (r57.longValue() <= r56) goto L215;
        return CreationReferenceAttachmentViolation.FILE_SIZE;
    L224:
        if (r57.longValue() <= 0) goto L226;
        boolean r58 = true;
    L227:
        if (r58 == false) goto L229;
    L226:
        r58 = false;
        goto L227
    L235:
        Iterator r59 = r4.iterator();
    L237:
        if (r59.hasNext() == false) goto L278;
        Pair r60 = (Pair) r59.next();
        CreationReferenceMediaType r61 = (CreationReferenceMediaType) r60.component1();
        c r62 = (c) r60.component2();
        g1 r63 = r18.d(r61);
        if (r63 == null) goto L237;
        if (r63.j != null) goto L246;
        if (r63.k == null) goto L237;
    L246:
        Integer r64 = r62.h;
        Integer r65 = r62.i;
        if (r64 == null) goto L277;
        if (r65 == null) goto L277;
        if (r64.intValue() <= 0) goto L277;
        if (r65.intValue() <= 0) goto L277;
        double r66 = ((double) r64.intValue()) / ((double) r65.intValue());
        Double r67 = r63.j;
        if (r67 != null) goto L257;
    L262:
        boolean r68 = false;
    L263:
        if (r68 == true) goto L275;
        Double r69 = r63.k;
        if (r69 != null) goto L267;
    L272:
        boolean r70 = false;
    L273:
        if (r70 == false) goto L237;
    L267:
        if (r66 <= r69.doubleValue()) goto L269;
        boolean r71 = true;
    L270:
        if (r71 != true) goto L272;
        r70 = true;
        goto L273
    L269:
        r71 = false;
    L275:
        return CreationReferenceAttachmentViolation.RATIO;
    L257:
        if (r66 >= r67.doubleValue()) goto L259;
        boolean r72 = true;
    L260:
        if (r72 != true) goto L262;
        r68 = true;
        goto L263
    L259:
        r72 = false;
    L277:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L278:
        return null;
    }

    public static CreationReferenceAttachmentViolation c(d1 r10, d r11) {
        Intrinsics.checkNotNullParameter(r10, "capability");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        if (r10.a(CreationReferenceMediaType.VIDEO) == false) goto L5;
        int r0 = RangesKt.coerceAtLeast(r11.b, 0);
    L6:
        List<c> r12 = r11.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        c r3 = (c) r13.next();
        CreationReferenceMediaType r4 = a(r3.getType());
        if (r4 == null) goto L12;
        r2.add(TuplesKt.to(r4, r3));
        goto L8
    L12:
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L14:
        Iterator r14 = r2.iterator();
    L16:
        if (r14.hasNext() == false) goto L28;
        g1 r5 = r10.d((CreationReferenceMediaType) ((Pair) r14.next()).component1());
        if (r5 == null) goto L20;
        Integer r6 = r5.b;
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
    L25:
        if (r7 > 0) goto L16;
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L24:
        r7 = 0;
        goto L25
    L20:
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L28:
        Iterator r15 = r10.c.values().iterator();
    L29:
        boolean r8 = true;
        if (r15.hasNext() == false) goto L61;
        g1 r9 = (g1) r15.next();
        Integer r16 = r9.b;
        if (r16 == null) goto L57;
        int r17 = r16.intValue();
        if (r2.isEmpty() == false) goto L36;
        int r18 = 0;
    L48:
        if (r9.getType() != CreationReferenceMediaType.VIDEO) goto L50;
        int r19 = r0;
    L52:
        if ((r18 + r19) <= r17) goto L54;
        boolean r20 = true;
    L55:
        if (r20 != true) goto L57;
    L58:
        if (r8 == false) goto L29;
        return CreationReferenceAttachmentViolation.TYPE_COUNT;
    L54:
        r20 = false;
        goto L55
    L50:
        r19 = 0;
        goto L52
    L36:
        Iterator r21 = r2.iterator();
        r18 = 0;
    L38:
        if (r21.hasNext() == false) goto L48;
        if (((Pair) r21.next()).getFirst() != r9.getType()) goto L42;
        boolean r22 = true;
    L43:
        if (r22 == false) goto L38;
        r18 = r18 + 1;
        if (r18 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
        goto L38
    L42:
        r22 = false;
    L57:
        r8 = false;
        goto L58
    L61:
        Iterator r110 = r10.d.iterator();
    L63:
        if (r110.hasNext() == false) goto L91;
        h1 r111 = (h1) r110.next();
        if (r2.isEmpty() == false) goto L67;
        int r23 = 0;
    L76:
        if (r111.a.contains(CreationReferenceMediaType.VIDEO) == false) goto L78;
        int r24 = r0;
    L79:
        int r25 = r23 + r24;
        Integer r112 = r111.b;
        if (r112 != null) goto L82;
    L87:
        boolean r113 = false;
    L88:
        if (r113 == false) goto L63;
        return CreationReferenceAttachmentViolation.MIXED_COUNT;
    L82:
        if (r25 <= r112.intValue()) goto L84;
        boolean r114 = true;
    L85:
        if (r114 != true) goto L87;
        r113 = true;
        goto L88
    L84:
        r114 = false;
        goto L85
    L78:
        r24 = 0;
        goto L79
    L67:
        Iterator r26 = r2.iterator();
        r23 = 0;
    L69:
        if (r26.hasNext() == false) goto L76;
        Pair r27 = (Pair) r26.next();
        if (r111.a.contains(r27.getFirst()) == false) goto L69;
        r23 = r23 + 1;
        if (r23 >= 0) goto L69;
        CollectionsKt.throwCountOverflow();
        goto L69
    L91:
        return null;
    L5:
        r0 = 0;
        goto L6
    }
}
