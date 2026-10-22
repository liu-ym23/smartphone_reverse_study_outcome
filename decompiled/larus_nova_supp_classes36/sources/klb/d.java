package klb;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.imageocr.utils.DrawObjectsPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Activity r11, SpannableStringBuilder r12, ImageOCRResponse r13) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "ocrTxtBuilder");
        Intrinsics.checkNotNullParameter(r13, "response");
        Map r0 = r13.mtype_to_entities;
        if (r0 == null) goto L25;
        ImageOCRResponse.Entities r1 = (ImageOCRResponse.Entities) r0.get(Integer.valueOf(ImageOCRResponse.EntityType.PHONE.getValue()));
        if (r1 == null) goto L25;
        List r2 = r1.mlist;
        if (r2 == null) goto L25;
        List r3 = CollectionsKt.filterNotNull(r2);
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L25;
        ImageOCRResponse.Entities.Entity r5 = (ImageOCRResponse.Entities.Entity) r4.next();
        String r6 = r5.mtext;
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L12;
        int r8 = com.ss.android.lark.imageocr.utils.b.a;
        Iterator r9 = ((ArrayList) com.ss.android.lark.imageocr.utils.b.c(r12, r5.mtext)).iterator();
    L23:
        if (r9.hasNext() == false) goto L12;
        int r10 = ((Number) r9.next()).intValue();
        int r14 = r5.mtext.length() + r10;
        r12.setSpan(new c(r11, r5.mtext), r10, r14, 33);
        Log.i("OCRTxtParser", "parsePhone once");
        goto L23
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
    L25:
        Map r15 = r13.mtype_to_entities;
        if (r15 == null) goto L53;
        ImageOCRResponse.Entities r16 = (ImageOCRResponse.Entities) r15.get(Integer.valueOf(ImageOCRResponse.EntityType.URL.getValue()));
        if (r16 == null) goto L68;
        List r17 = r16.mlist;
        if (r17 == null) goto L69;
        List r18 = CollectionsKt.filterNotNull(r17);
        if (r18 == null) goto L70;
        Iterator r19 = r18.iterator();
    L35:
        if (r19.hasNext() == false) goto L71;
        ImageOCRResponse.Entities.Entity r20 = (ImageOCRResponse.Entities.Entity) r19.next();
        String r21 = r20.mtext;
        if (r21 != null) goto L39;
    L42:
        boolean r22 = true;
    L43:
        if (r22 == true) goto L35;
        int r23 = com.ss.android.lark.imageocr.utils.b.a;
        String r24 = r20.mtext;
        Intrinsics.checkNotNullParameter(r24, "urlString");
        new URI(r24);     // Catch: URISyntaxException -> L47
        boolean r25 = true;
    L48:
        if (r25 == false) goto L35;
        int r26 = com.ss.android.lark.imageocr.utils.b.a;
        Iterator r27 = ((ArrayList) com.ss.android.lark.imageocr.utils.b.c(r12, r20.mtext)).iterator();
    L51:
        if (r27.hasNext() == false) goto L35;
        int r28 = ((Number) r27.next()).intValue();
        int r29 = r20.mtext.length() + r28;
        r12.setSpan(new e(r11, r20.mtext), r28, r29, 33);
        Log.i("OCRTxtParser", "parseURL once");
    L47:
        r25 = false;
        goto L48
    L39:
        if (r21.length() == 0) goto L42;
        r22 = false;
        goto L43
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    }

    public static SpannableStringBuilder b(ArrayList r13, ImageOCRResponse r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "lines");
        Intrinsics.checkNotNullParameter(r14, "response");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        ArrayList r1 = new ArrayList();
        Iterator r16 = r13.iterator();
    L3:
        boolean r3 = true;
        if (r16.hasNext() == false) goto L13;
        Object r2 = r16.next();
        ilb.b r5 = (ilb.b) r2;
        if (r15 == false) goto L8;
    L11:
        if (r3 == false) goto L3;
        r1.add(r2);
        goto L3
    L8:
        if (r5.j.d == true) goto L11;
        r3 = false;
        goto L11
    L13:
        Iterator r17 = r1.iterator();
        int r4 = -1;
    L15:
        if (r17.hasNext() == false) goto L106;
        ilb.b r6 = (ilb.b) r17.next();
        int r7 = r6.a;
        if (r7 < 0) goto L15;
        if (r7 >= r14.mlines.size()) goto L15;
        String r8 = ((ImageOCRResponse.Line) ListProtector.get(r14.mlines, r6.a)).mtext;
        int r9 = r6.a;
        List r10 = r14.mregions;
        if (r10 == null) goto L35;
        int r11 = r10.size();
        int r12 = 0;
    L23:
        if (r12 >= r11) goto L35;
        ImageOCRResponse.Region r18 = (ImageOCRResponse.Region) ListProtector.get(r10, r12);
        if (r18 == null) goto L31;
        List r19 = r18.mline_ids;
        if (r19 == null) goto L31;
        if (r19.contains(Integer.valueOf(r9)) != true) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == true) goto L36;
        r12 = r12 + 1;
    L36:
        if (r12 == (-1)) goto L15;
        if (r0.length() != 0) goto L40;
        boolean r20 = true;
    L41:
        if (r12 == r4) goto L43;
        boolean r21 = true;
    L45:
        if (r20 == true) goto L48;
        if (r21 == false) goto L48;
        r0.append("\n");
        b.a r22 = new b.a();
        r22.a = ((Number) DrawObjectsPool.d.getValue()).floatValue();
        r0.append("\n", new b(r22), 33);
    L48:
        if (r21 == true) goto L97;
        int r23 = r6.a;
        if (r8 != null) goto L52;
    L55:
        boolean r24 = true;
    L56:
        if (r24 == true) goto L97;
        char r25 = r8.charAt(0);
        if (r25 >= 0) goto L60;
    L62:
        boolean r26 = false;
    L63:
        if (r26 == false) goto L97;
        Map r27 = r14.mtype_to_entities;
        if (r27 == null) goto L94;
        Iterator r28 = r27.entrySet().iterator();
    L68:
        if (r28.hasNext() == false) goto L94;
        ImageOCRResponse.Entities r29 = (ImageOCRResponse.Entities) ((Map.Entry) r28.next()).getValue();
        if (r29 == null) goto L68;
        List r30 = r29.mlist;
        if (r30 == null) goto L68;
        List r31 = CollectionsKt.filterNotNull(r30);
        if (r31 == null) goto L68;
        Iterator r32 = r31.iterator();
    L77:
        if (r32.hasNext() == false) goto L68;
        List r33 = ((ImageOCRResponse.Entities.Entity) r32.next()).mline_msgs;
        if (r33 == null) goto L77;
        List r34 = CollectionsKt.filterNotNull(r33);
        if (r34 == null) goto L77;
        Iterator r35 = r34.iterator();
        int r111 = -2;
    L84:
        if (r35.hasNext() == false) goto L77;
        ImageOCRResponse.Entities.Entity.LineMsg r112 = (ImageOCRResponse.Entities.Entity.LineMsg) r35.next();
        Integer r113 = r112.mline_id;
        if (r113 == null) goto L93;
        if (r113.intValue() != r23) goto L93;
        if (r111 != (r23 - 1)) goto L93;
        boolean r36 = true;
    L95:
        if (r36 == true) goto L97;
        r0.append(" ");
    L93:
        r111 = r112.mline_id.intValue();
    L94:
        r36 = false;
        goto L95
    L60:
        if (r25 >= 128) goto L62;
        r26 = true;
        goto L63
    L52:
        if (r8.length() == 0) goto L55;
        r24 = false;
    L97:
        if (r8 != null) goto L99;
    L102:
        boolean r37 = true;
    L103:
        if (r37 == true) goto L105;
        r0.append(r8, new AbsoluteSizeSpan((int) ((Number) DrawObjectsPool.e.getValue()).floatValue()), 33);
        Log.i("OCRTxtParser", "appendLineTxt once");
    L105:
        r4 = r12;
        goto L15
    L99:
        if (r8.length() == 0) goto L102;
        r37 = false;
        goto L103
    L43:
        r21 = false;
        goto L45
    L40:
        r20 = false;
    L31:
        r110 = false;
    L35:
        r12 = -1;
        goto L36
    L106:
        return r0;
    }
}
