package kq9;

import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaRule;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumMixedRule;
import com.larus.platform.model.album.CreationReferenceAlbumViolation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CreationReferenceAlbumViolation a(CreationReferenceAlbumConfig r1, List r2, CreationReferenceAlbumAttachment r3) {
        Intrinsics.checkNotNullParameter(r1, "config");
        Intrinsics.checkNotNullParameter(r2, "selected");
        Intrinsics.checkNotNullParameter(r3, "candidate");
        return b(r1, CollectionsKt.plus(r2, r3), CollectionsKt.listOf(r3));
    }

    public static CreationReferenceAlbumViolation b(CreationReferenceAlbumConfig r13, List r14, List r15) {
        List r16 = r15;
        Iterator r0 = r16.iterator();
    L3:
        int r2 = 0;
        if (r0.hasNext() == false) goto L15;
        CreationReferenceAlbumMediaRule r1 = r13.ruleFor(((CreationReferenceAlbumAttachment) r0.next()).getType());
        if (r1 == null) goto L8;
        Integer r3 = r1.getMaxCount();
        if (r3 == null) goto L12;
        r2 = r3.intValue();
    L12:
        if (r2 > 0) goto L3;
        return CreationReferenceAlbumViolation.UNSUPPORTED_TYPE;
    L8:
        return CreationReferenceAlbumViolation.UNSUPPORTED_TYPE;
    L15:
        List r17 = CollectionsKt.plus(r13.getExistingAttachments(), r14);
        CreationReferenceAlbumMediaRule r4 = r13.ruleFor(CreationReferenceAlbumMediaType.VIDEO);
        if (r4 == null) goto L20;
        Integer r5 = r4.getMaxCount();
        if (r5 == null) goto L20;
        int r6 = r5.intValue();
    L22:
        if (r6 <= 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
        int r8 = RangesKt.coerceAtLeast(r13.getAdditionalVideoCount(), 0);
    L28:
        Iterator<T> r9 = r13.getMediaRules().iterator();
    L30:
        if (r9.hasNext() == false) goto L56;
        CreationReferenceAlbumMediaRule r10 = (CreationReferenceAlbumMediaRule) r9.next();
        Integer r11 = r10.getMaxCount();
        if (r11 == null) goto L30;
        int r12 = r11.intValue();
        List r18 = r17;
        if ((r18 instanceof Collection) == true) goto L36;
    L38:
        Iterator r19 = r18.iterator();
        int r20 = 0;
    L40:
        if (r19.hasNext() == false) goto L50;
        if (((CreationReferenceAlbumAttachment) r19.next()).getType() != r10.getType()) goto L44;
        boolean r21 = true;
    L45:
        if (r21 == false) goto L40;
        r20 = r20 + 1;
        if (r20 >= 0) goto L40;
        CollectionsKt.throwCountOverflow();
        goto L40
    L44:
        r21 = false;
    L50:
        if (r10.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L52;
        int r22 = r8;
    L54:
        if ((r20 + r22) <= r12) goto L30;
        CreationReferenceAlbumViolation r23 = CreationReferenceAlbumViolation.TYPE_COUNT;
    L88:
        if (r23 == null) goto L90;
        return r23;
    L90:
        Iterator r24 = r16.iterator();
    L92:
        if (r24.hasNext() == false) goto L112;
        CreationReferenceAlbumAttachment r25 = (CreationReferenceAlbumAttachment) r24.next();
        CreationReferenceAlbumMediaRule r26 = r13.ruleFor(r25.getType());
        if (r26 == null) goto L109;
        Long r27 = r26.getMaxResolution();
        if (r27 == null) goto L109;
        long r28 = r27.longValue();
        Integer r29 = r25.getWidth();
        Integer r30 = r25.getHeight();
        if (r29 == null) goto L108;
        if (r30 == null) goto L108;
        if (r29.intValue() <= 0) goto L108;
        if (r30.intValue() <= 0) goto L108;
        if (Math.max(r29.intValue(), r30.intValue()) <= r28) goto L109;
        CreationReferenceAlbumViolation r31 = CreationReferenceAlbumViolation.RESOLUTION;
    L110:
        if (r31 == null) goto L92;
        return r31;
    L108:
        r31 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L109:
        r31 = null;
        goto L110
    L112:
        Iterator r32 = r16.iterator();
    L114:
        if (r32.hasNext() == false) goto L154;
        CreationReferenceAlbumAttachment r33 = (CreationReferenceAlbumAttachment) r32.next();
        CreationReferenceAlbumMediaRule r34 = r13.ruleFor(r33.getType());
        if (r34 != null) goto L119;
    L149:
        CreationReferenceAlbumViolation r35 = null;
    L152:
        if (r35 == null) goto L114;
        return r35;
    L119:
        if (r34.getMinSingleDuration() == null) goto L121;
    L123:
        Double r36 = r33.getDurationSeconds();
        if (r36 != null) goto L126;
    L151:
        r35 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
        goto L152
    L126:
        if (r36.doubleValue() <= 0.0d) goto L151;
        Double r37 = r34.getMinSingleDuration();
        if (r37 != null) goto L131;
    L136:
        boolean r38 = false;
    L137:
        if (r38 == true) goto L150;
        Double r39 = r34.getMaxSingleDuration();
        if (r39 != null) goto L141;
    L146:
        boolean r40 = false;
    L147:
        if (r40 == false) goto L149;
    L141:
        if (r36.doubleValue() <= r39.doubleValue()) goto L143;
        boolean r41 = true;
    L144:
        if (r41 != true) goto L146;
        r40 = true;
        goto L147
    L143:
        r41 = false;
    L150:
        r35 = CreationReferenceAlbumViolation.SINGLE_DURATION;
        goto L152
    L131:
        if (r36.doubleValue() >= r37.doubleValue()) goto L133;
        boolean r42 = true;
    L134:
        if (r42 != true) goto L136;
        r38 = true;
        goto L137
    L133:
        r42 = false;
        goto L134
    L121:
        if (r34.getMaxSingleDuration() != null) goto L123;
    L154:
        Iterator<T> r43 = r13.getMediaRules().iterator();
    L156:
        if (r43.hasNext() == false) goto L180;
        CreationReferenceAlbumMediaRule r44 = (CreationReferenceAlbumMediaRule) r43.next();
        if (r44.getType() == CreationReferenceAlbumMediaType.VIDEO) goto L162;
        if (r44.getType() != CreationReferenceAlbumMediaType.AUDIO) goto L156;
    L162:
        Double r45 = r44.getMaxTotalDuration();
        if (r45 == null) goto L156;
        double r46 = r45.doubleValue();
        ArrayList r47 = new ArrayList();
        Iterator r48 = r17.iterator();
    L166:
        if (r48.hasNext() == false) goto L174;
        Object r49 = r48.next();
        if (((CreationReferenceAlbumAttachment) r49).getType() != r44.getType()) goto L170;
        boolean r110 = true;
    L171:
        if (r110 == false) goto L166;
        r47.add(r49);
        goto L166
    L170:
        r110 = false;
        goto L171
    L174:
        if (r44.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L176;
        Double r50 = r13.getAdditionalVideoDurationSeconds();
    L177:
        CreationReferenceAlbumViolation r51 = c(r47, r46, r50);
        if (r51 == null) goto L156;
    L208:
        if (r51 == null) goto L210;
        return r51;
    L210:
        Iterator r111 = r16.iterator();
    L212:
        if (r111.hasNext() == false) goto L233;
        CreationReferenceAlbumAttachment r52 = (CreationReferenceAlbumAttachment) r111.next();
        CreationReferenceAlbumMediaRule r53 = r13.ruleFor(r52.getType());
        if (r53 == null) goto L230;
        Long r54 = r53.getMaxFileSize();
        if (r54 == null) goto L230;
        long r55 = r54.longValue();
        Long r56 = r52.getFileSize();
        if (r56 == null) goto L230;
        if (r56.longValue() <= 0) goto L222;
        boolean r57 = true;
    L223:
        if (r57 == true) goto L226;
        r56 = null;
    L226:
        if (r56 == null) goto L230;
        if (r56.longValue() <= r55) goto L230;
        CreationReferenceAlbumViolation r58 = CreationReferenceAlbumViolation.FILE_SIZE;
    L231:
        if (r58 == null) goto L212;
        return r58;
    L222:
        r57 = false;
    L230:
        r58 = null;
        goto L231
    L233:
        Iterator r112 = r16.iterator();
    L235:
        if (r112.hasNext() == false) goto L278;
        CreationReferenceAlbumAttachment r113 = (CreationReferenceAlbumAttachment) r112.next();
        CreationReferenceAlbumMediaRule r59 = r13.ruleFor(r113.getType());
        if (r59 != null) goto L240;
    L273:
        CreationReferenceAlbumViolation r114 = null;
    L276:
        if (r114 == null) goto L235;
        return r114;
    L240:
        if (r59.getMinRatio() == null) goto L242;
    L244:
        Integer r60 = r113.getWidth();
        Integer r115 = r113.getHeight();
        if (r60 == null) goto L275;
        if (r115 == null) goto L275;
        if (r60.intValue() <= 0) goto L275;
        if (r115.intValue() <= 0) goto L275;
        double r61 = ((double) r60.intValue()) / ((double) r115.intValue());
        Double r116 = r59.getMinRatio();
        if (r116 != null) goto L255;
    L260:
        boolean r117 = false;
    L261:
        if (r117 == true) goto L274;
        Double r118 = r59.getMaxRatio();
        if (r118 != null) goto L265;
    L270:
        boolean r119 = false;
    L271:
        if (r119 == false) goto L273;
    L265:
        if (r61 <= r118.doubleValue()) goto L267;
        boolean r120 = true;
    L268:
        if (r120 != true) goto L270;
        r119 = true;
        goto L271
    L267:
        r120 = false;
    L274:
        r114 = CreationReferenceAlbumViolation.RATIO;
        goto L276
    L255:
        if (r61 >= r116.doubleValue()) goto L257;
        boolean r121 = true;
    L258:
        if (r121 != true) goto L260;
        r117 = true;
        goto L261
    L257:
        r121 = false;
    L275:
        r114 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
        goto L276
    L242:
        if (r59.getMaxRatio() != null) goto L244;
    L278:
        return null;
    L176:
        r50 = null;
        goto L177
    L180:
        Iterator<T> r62 = r13.getMixedRules().iterator();
    L182:
        if (r62.hasNext() == false) goto L207;
        CreationReferenceAlbumMixedRule r63 = (CreationReferenceAlbumMixedRule) r62.next();
        Double r64 = r63.getMaxTotalDuration();
        if (r64 == null) goto L182;
        double r65 = r64.doubleValue();
        ArrayList r66 = new ArrayList();
        Iterator r67 = r17.iterator();
    L187:
        if (r67.hasNext() == false) goto L198;
        Object r68 = r67.next();
        CreationReferenceAlbumAttachment r122 = (CreationReferenceAlbumAttachment) r68;
        if (r63.getSubTypes().contains(r122.getType()) == true) goto L191;
    L195:
        boolean r123 = false;
    L196:
        if (r123 == false) goto L187;
        r66.add(r68);
        goto L187
    L191:
        if (r122.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L193;
    L194:
        r123 = true;
        goto L196
    L193:
        if (r122.getType() != CreationReferenceAlbumMediaType.AUDIO) goto L195;
    L198:
        Double r69 = r13.getAdditionalVideoDurationSeconds();
        if (r69 == null) goto L203;
        r69.doubleValue();
        if (r63.getSubTypes().contains(CreationReferenceAlbumMediaType.VIDEO) == false) goto L203;
    L205:
        if (c(r66, r65, r69) == null) goto L182;
        r51 = CreationReferenceAlbumViolation.MIXED_TOTAL_DURATION;
    L203:
        r69 = null;
        goto L205
    L207:
        r51 = null;
        goto L208
    L52:
        r22 = 0;
        goto L54
    L36:
        if (r18.isEmpty() == false) goto L38;
        r20 = 0;
        goto L50
    L56:
        Iterator<T> r70 = r13.getMixedRules().iterator();
    L58:
        if (r70.hasNext() == false) goto L87;
        CreationReferenceAlbumMixedRule r71 = (CreationReferenceAlbumMixedRule) r70.next();
        List r72 = r17;
        if ((r72 instanceof Collection) == true) goto L62;
    L64:
        Iterator r73 = r72.iterator();
        int r74 = 0;
    L66:
        if (r73.hasNext() == false) goto L73;
        if (r71.getSubTypes().contains(((CreationReferenceAlbumAttachment) r73.next()).getType()) == false) goto L66;
        r74 = r74 + 1;
        if (r74 >= 0) goto L66;
        CollectionsKt.throwCountOverflow();
    L73:
        if (r71.getSubTypes().contains(CreationReferenceAlbumMediaType.VIDEO) == false) goto L75;
        int r75 = r8;
    L76:
        int r76 = r74 + r75;
        Integer r77 = r71.getMaxCount();
        if (r77 != null) goto L79;
    L84:
        boolean r78 = false;
    L85:
        if (r78 == false) goto L58;
        r23 = CreationReferenceAlbumViolation.MIXED_COUNT;
        goto L88
    L79:
        if (r76 <= r77.intValue()) goto L81;
        boolean r79 = true;
    L82:
        if (r79 != true) goto L84;
        r78 = true;
        goto L85
    L81:
        r79 = false;
        goto L82
    L75:
        r75 = 0;
        goto L76
    L62:
        if (r72.isEmpty() == false) goto L64;
        r74 = 0;
        goto L73
    L87:
        r23 = null;
        goto L88
    L27:
        r8 = 0;
        goto L28
    L24:
        r7 = false;
    L20:
        r6 = 0;
        goto L22
    }

    public static CreationReferenceAlbumViolation c(List r8, double r9, Double r11) {
        boolean r1 = false;
        double r3 = 0.0d;
        if (r8.isEmpty() == true) goto L17;
        Iterator r0 = r8.iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        CreationReferenceAlbumAttachment r5 = (CreationReferenceAlbumAttachment) r0.next();
        if (r5.getDurationSeconds() != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L7;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        if (r11 == null) goto L32;
        double r7 = r11.doubleValue();
        if (Double.isInfinite(r7) == false) goto L25;
    L27:
        if (r1 == false) goto L31;
        if (r11.doubleValue() > 0.0d) goto L32;
    L31:
        return CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L25:
        if (Double.isNaN(r7) == true) goto L27;
        r1 = true;
    L32:
        Iterator r10 = r8.iterator();
        double r4 = 0.0d;
    L34:
        if (r10.hasNext() == false) goto L40;
        Double r12 = ((CreationReferenceAlbumAttachment) r10.next()).getDurationSeconds();
        if (r12 == null) goto L38;
        double r13 = r12.doubleValue();
    L39:
        r4 = r4 + r13;
        goto L34
    L38:
        r13 = 0.0d;
        goto L39
    L40:
        if (r11 == null) goto L43;
        r3 = r11.doubleValue();
    L43:
        if ((r4 + r3) > r9) goto L55;
        return null;
    L55:
        return CreationReferenceAlbumViolation.TOTAL_DURATION;
    L20:
        return CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L11:
        if (r5.getDurationSeconds().doubleValue() <= 0.0d) goto L14;
        r6 = false;
    L17:
        r2 = false;
        goto L18
    }
}
