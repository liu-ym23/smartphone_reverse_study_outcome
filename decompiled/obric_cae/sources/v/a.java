package v;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<C0177a> f12643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<androidx.constraintlayout.widget.d> f12644e;

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    public static class C0177a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f12646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.constraintlayout.widget.d f12648d;

        public C0177a(Context r8, XmlResourceParser r10) {
            this.f12646b = new ArrayList();
            this.f12647c = -1;
            TypedArray r11 = r8.obtainStyledAttributes(Xml.asAttributeSet(r10), d.f12664j);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L13;
            int r14 = r11.getIndex(r13);
            if (r14 != 0) goto L8;
            this.f12645a = r11.getResourceId(r14, this.f12645a);
        L12:
            r13 = r13 + 1;
            goto L3
        L8:
            if (r14 != 1) goto L12;
            int r15 = r11.getResourceId(r14, this.f12647c);
            this.f12647c = r15;
            String r16 = r8.getResources().getResourceTypeName(r15);
            r8.getResources().getResourceName(r15);
            if ("layout".equals(r16) == false) goto L12;
            androidx.constraintlayout.widget.d r17 = new androidx.constraintlayout.widget.d();
            this.f12648d = r17;
            r17.c((ConstraintLayout) LayoutInflater.from(r8).inflate(r15, null));
            goto L12
        L13:
            r11.recycle();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f12649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f12650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f12651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f12652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final androidx.constraintlayout.widget.d f12654f;

        public b(Context r8, XmlResourceParser r10) {
            this.f12649a = Float.NaN;
            this.f12650b = Float.NaN;
            this.f12651c = Float.NaN;
            this.f12652d = Float.NaN;
            this.f12653e = -1;
            TypedArray r11 = r8.obtainStyledAttributes(Xml.asAttributeSet(r10), d.f12666l);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L23;
            int r14 = r11.getIndex(r13);
            if (r14 != 0) goto L10;
            int r15 = r11.getResourceId(r14, this.f12653e);
            this.f12653e = r15;
            String r16 = r8.getResources().getResourceTypeName(r15);
            r8.getResources().getResourceName(r15);
            if ("layout".equals(r16) == false) goto L22;
            androidx.constraintlayout.widget.d r17 = new androidx.constraintlayout.widget.d();
            this.f12654f = r17;
            r17.c((ConstraintLayout) LayoutInflater.from(r8).inflate(r15, null));
        L22:
            r13 = r13 + 1;
            goto L3
        L10:
            if (r14 != 1) goto L13;
            this.f12652d = r11.getDimension(r14, this.f12652d);
            goto L22
        L13:
            if (r14 != 2) goto L16;
            this.f12650b = r11.getDimension(r14, this.f12650b);
            goto L22
        L16:
            if (r14 != 3) goto L19;
            this.f12651c = r11.getDimension(r14, this.f12651c);
            goto L22
        L19:
            if (r14 != 4) goto L21;
            this.f12649a = r11.getDimension(r14, this.f12649a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r11.recycle();
        }

        public final boolean a(float r8, float r10) {
            float r11 = this.f12649a;
            if (Float.isNaN(r11) == false) goto L5;
        L7:
            float r12 = this.f12650b;
            if (Float.isNaN(r12) == false) goto L10;
        L12:
            float r13 = this.f12651c;
            if (Float.isNaN(r13) == false) goto L15;
        L17:
            float r14 = this.f12652d;
            if (Float.isNaN(r14) == false) goto L20;
            return true;
        L20:
            if (r10 <= r14) goto L24;
            return false;
        L24:
            return true;
        L15:
            if (r8 <= r13) goto L17;
            return false;
        L10:
            if (r10 >= r12) goto L12;
            return false;
        L5:
            if (r8 >= r11) goto L7;
            return false;
        }
    }

    public a(Context r10, ConstraintLayout r11, int r12) {
        this.f12641b = -1;
        this.f12642c = -1;
        this.f12643d = new SparseArray();
        this.f12644e = new SparseArray();
        this.f12640a = r11;
        XmlResourceParser r8 = r10.getResources().getXml(r12);
        int r13 = r8.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L41
        C0177a r14 = null;
    L4:
        byte r15 = 1;
        if (r13 == 1) goto L55;
        if (r13 != 2) goto L37;
        String r16 = r8.getName();     // Catch: IOException -> L39 XmlPullParserException -> L41
        switch(r16.hashCode()) {
            case -1349929691: goto L25;
            case 80204913: goto L22;
            case 1382829617: goto L19;
            case 1657696882: goto L16;
            case 1901439077: goto L13;
            default: goto L27;
        };     // Catch: IOException -> L39 XmlPullParserException -> L41
    L27:
        r15 = -1;
    L28:
        if (r15 == 2) goto L36;
        if (r15 == 3) goto L33;
        if (r15 != 4) goto L37;
        a(r10, r8);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L33:
        b r17 = new b(r10, r8);     // Catch: IOException -> L39 XmlPullParserException -> L41
        if (r14 == null) goto L37;
        r14.f12646b.add(r17);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L36:
        C0177a r18 = new C0177a(r10, r8);     // Catch: IOException -> L39 XmlPullParserException -> L41
        this.f12643d.put(r18.f12645a, r18);     // Catch: IOException -> L39 XmlPullParserException -> L41
        r14 = r18;
        goto L37
    L13:
        if (r16.equals("Variant") == false) goto L27;
        r15 = 3;
        goto L28
    L16:
        if (r16.equals("layoutDescription") == false) goto L27;
        r15 = 0;
        goto L28
    L19:
        if (r16.equals("StateSet") == false) goto L27;
    L22:
        if (r16.equals("State") == false) goto L27;
        r15 = 2;
        goto L28
    L25:
        if (r16.equals("ConstraintSet") == false) goto L27;
        r15 = 4;
    L37:
        r13 = r8.next();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L55:
        return;
    L39:
        e = e;
        StringBuilder r19 = new StringBuilder("Error parsing resource: ");
    L43:
        r19.append(r12);
        Log.e("ConstraintLayoutStates", r19.toString(), e);
        return;
    L41:
        e = e;
        r19 = new StringBuilder("Error parsing resource: ");
        goto L43
    }

    public final void a(Context r12, XmlResourceParser r13) {
        androidx.constraintlayout.widget.d r8 = new androidx.constraintlayout.widget.d();
        int r10 = r13.getAttributeCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L142;
        String r14 = r13.getAttributeName(r11);
        String r15 = r13.getAttributeValue(r11);
        if (r14 == null) goto L116;
        if (r15 == null) goto L116;
        if ("id".equals(r14) == false) goto L116;
        if (r15.contains("/") == false) goto L13;
        int r16 = r12.getResources().getIdentifier(r15.substring(r15.indexOf(47) + 1), "id", r12.getPackageName());
    L14:
        if (r16 == (-1)) goto L16;
    L118:
        int r17 = r13.getEventType();     // Catch: Throwable -> L113
        androidx.constraintlayout.widget.d.a r18 = null;
    L20:
        if (r17 == 1) goto L115;
        if (r17 == 0) goto L110;
        byte r19 = 3;
        if (r17 == 2) goto L48;
        if (r17 != 3) goto L111;
        String r20 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L113
        switch(r20.hashCode()) {
            case -2075718416: goto L39;
            case -190376483: goto L36;
            case 426575017: goto L33;
            case 2146106725: goto L30;
            default: goto L41;
        };     // Catch: Throwable -> L113
    L41:
        byte r21 = -1;
    L42:
        if (r21 == 0) goto L115;
        if (r21 == 1) goto L47;
        if (r21 == 2) goto L47;
        if (r21 != 3) goto L111;
    L47:
        r8.f1443c.put(Integer.valueOf(r18.f1444a), r18);     // Catch: Throwable -> L113
        r18 = null;
        goto L111
    L30:
        if (r20.equals("constraintset") == false) goto L41;
        r21 = 0;
        goto L42
    L33:
        if (r20.equals("constraintoverride") == false) goto L41;
        r21 = 2;
        goto L42
    L36:
        if (r20.equals("constraint") == false) goto L41;
        r21 = 1;
        goto L42
    L39:
        if (r20.equals("guideline") == false) goto L41;
        r21 = 3;
    L111:
        r17 = r13.next();     // Catch: Throwable -> L113 Throwable -> L113
        goto L20
    L48:
        String r22 = r13.getName();     // Catch: Throwable -> L113
        switch(r22.hashCode()) {
            case -2025855158: goto L79;
            case -1984451626: goto L76;
            case -1962203927: goto L73;
            case -1269513683: goto L70;
            case -1238332596: goto L67;
            case -71750448: goto L64;
            case 366511058: goto L61;
            case 1331510167: goto L58;
            case 1791837707: goto L55;
            case 1803088381: goto L52;
            default: goto L81;
        };     // Catch: Throwable -> L113
    L81:
        r19 = -1;
    L83:
        switch(r19) {
            case 0: goto L108;
            case 1: goto L107;
            case 2: goto L106;
            case 3: goto L105;
            case 4: goto L101;
            case 5: goto L97;
            case 6: goto L93;
            case 7: goto L89;
            case 8: goto L85;
            case 9: goto L85;
            default: goto L111;
        };
    L85:
        if (r18 == null) goto L88;
        androidx.constraintlayout.widget.b.a(r12, r13, r18.f1449f);     // Catch: Throwable -> L113 Throwable -> L113
        goto L111
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: Throwable -> L113 Throwable -> L113
    L89:
        if (r18 == null) goto L92;
        r18.f1446c.a(r12, Xml.asAttributeSet(r13));     // Catch: Throwable -> L113 Throwable -> L113
        goto L111
    L92:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: Throwable -> L113 Throwable -> L113
    L93:
        if (r18 == null) goto L96;
        r18.f1447d.a(r12, Xml.asAttributeSet(r13));     // Catch: Throwable -> L113 Throwable -> L113
        goto L111
    L96:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: Throwable -> L113 Throwable -> L113
    L97:
        if (r18 == null) goto L100;
        r18.f1448e.a(r12, Xml.asAttributeSet(r13));     // Catch: Throwable -> L113 Throwable -> L113
        goto L111
    L100:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: Throwable -> L113 Throwable -> L113
    L101:
        if (r18 == null) goto L104;
        r18.f1445b.a(r12, Xml.asAttributeSet(r13));     // Catch: Throwable -> L113 Throwable -> L113
        goto L111
    L104:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: Throwable -> L113 Throwable -> L113
    L105:
        androidx.constraintlayout.widget.d.a r23 = androidx.constraintlayout.widget.d.e(r12, Xml.asAttributeSet(r13), false);     // Catch: Throwable -> L113 Throwable -> L113
        r23.f1447d.f1477h0 = 1;     // Catch: Throwable -> L113 Throwable -> L113
    L109:
        r18 = r23;
        goto L111
    L106:
        r23 = androidx.constraintlayout.widget.d.e(r12, Xml.asAttributeSet(r13), false);     // Catch: Throwable -> L113 Throwable -> L113
        r23.f1447d.f1463a = true;     // Catch: Throwable -> L113 Throwable -> L113
        goto L109
    L107:
        r23 = androidx.constraintlayout.widget.d.e(r12, Xml.asAttributeSet(r13), true);     // Catch: Throwable -> L113 Throwable -> L113
        goto L109
    L108:
        r23 = androidx.constraintlayout.widget.d.e(r12, Xml.asAttributeSet(r13), false);     // Catch: Throwable -> L113 Throwable -> L113
        goto L109
    L52:
        if (r22.equals("Constraint") == false) goto L81;
        r19 = 0;
        goto L83
    L55:
        if (r22.equals("CustomAttribute") == false) goto L81;
        r19 = 8;
        goto L83
    L58:
        if (r22.equals("Barrier") == false) goto L81;
    L61:
        if (r22.equals("CustomMethod") == false) goto L81;
        r19 = 9;
        goto L83
    L64:
        if (r22.equals("Guideline") == false) goto L81;
        r19 = 2;
        goto L83
    L67:
        if (r22.equals("Transform") == false) goto L81;
        r19 = 5;
        goto L83
    L70:
        if (r22.equals("PropertySet") == false) goto L81;
        r19 = 4;
        goto L83
    L73:
        if (r22.equals("ConstraintOverride") == false) goto L81;
        r19 = 1;
        goto L83
    L76:
        if (r22.equals("Motion") == false) goto L81;
        r19 = 7;
        goto L83
    L79:
        if (r22.equals("Layout") == false) goto L81;
        r19 = 6;
        goto L83
    L110:
        r13.getName();     // Catch: Throwable -> L113 Throwable -> L113
    L115:
        this.f12644e.put(r16, r8);
        return;
    L113:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
        goto L115
    L16:
        if (r15.length() <= 1) goto L18;
        r16 = Integer.parseInt(r15.substring(1));
        goto L118
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L118
    L13:
        r16 = -1;
    L116:
        r11 = r11 + 1;
        goto L3
    }
}
