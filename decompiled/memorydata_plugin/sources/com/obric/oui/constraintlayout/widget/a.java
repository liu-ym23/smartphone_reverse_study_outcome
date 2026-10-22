package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.obric.oui.constraintlayout.widget.b f13760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13761b;
    int c;
    private final ConstraintLayout d;
    private SparseArray<C0742a> e;
    private SparseArray<com.obric.oui.constraintlayout.widget.b> f;
    private c g;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.a$a, reason: collision with other inner class name */
    static class C0742a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f13763b;
        int c;
        com.obric.oui.constraintlayout.widget.b d;

        C0742a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.f13763b = new ArrayList();
            this.c = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f13762a = r12.getResourceId(r3, this.f13762a);
        L12:
            r2 = r2 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.c = r12.getResourceId(r3, this.c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.c);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.c);
            if ("layout".equals(r4) == false) goto L12;
            com.obric.oui.constraintlayout.widget.b r5 = new com.obric.oui.constraintlayout.widget.b();
            this.d = r5;
            r5.a(r10, this.c);
            goto L12
        L13:
            r12.recycle();
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f13763b.size()) goto L9;
            if (((b) ZeusTransformUtils.preCheckCast(this.f13763b.get(r0), b.class, "com.obric.memorydata.plugin")).a(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        void a(b r1) {
            this.f13763b.add(r1);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f13764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13765b;
        float c;
        float d;
        int e;
        com.obric.oui.constraintlayout.widget.b f;

        b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.f13764a = Float.NaN;
            this.f13765b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L23;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.e = r12.getResourceId(r3, this.e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.e);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.e);
            if ("layout".equals(r4) == false) goto L22;
            com.obric.oui.constraintlayout.widget.b r5 = new com.obric.oui.constraintlayout.widget.b();
            this.f = r5;
            r5.a(r10, this.e);
        L22:
            r2 = r2 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.d = r12.getDimension(r3, this.d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f13765b = r12.getDimension(r3, this.f13765b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.c = r12.getDimension(r3, this.c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f13764a = r12.getDimension(r3, this.f13764a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f13764a) == true) goto L8;
            if (r3 >= this.f13764a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f13765b) == true) goto L13;
            if (r4 >= this.f13765b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.c) == true) goto L18;
            if (r3 <= this.c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.d) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    a(Context r3, ConstraintLayout r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f13761b = -1;
        this.c = -1;
        this.e = new SparseArray();
        this.f = new SparseArray();
        this.g = null;
        this.d = r4;
        a(r6, r5);
    }

    private void a(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getXml(r13);
        C0742a r3 = null;
        int r4 = r2.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L4:
        byte r5 = 1;
        if (r4 == 1) goto L55;
        if (r4 != 2) goto L37;
        String r6 = r2.getName();     // Catch: IOException -> L39 XmlPullParserException -> L41
        switch(r6.hashCode()) {
            case -1349929691: goto L25;
            case 80204913: goto L22;
            case 1382829617: goto L19;
            case 1657696882: goto L16;
            case 1901439077: goto L13;
            default: goto L27;
        };     // Catch: IOException -> L39 XmlPullParserException -> L41
    L27:
        r5 = -1;
    L28:
        if (r5 == 2) goto L36;
        if (r5 == 3) goto L33;
        if (r5 != 4) goto L37;
        a(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L33:
        b r7 = new b(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        if (r3 == null) goto L37;
        r3.a(r7);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L36:
        r3 = new C0742a(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        this.e.put(r3.f13762a, r3);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L13:
        if (r6.equals("Variant") == false) goto L27;
        r5 = 3;
        goto L28
    L16:
        if (r6.equals("layoutDescription") == false) goto L27;
        r5 = 0;
        goto L28
    L19:
        if (r6.equals("StateSet") == false) goto L27;
    L22:
        if (r6.equals("State") == false) goto L27;
        r5 = 2;
        goto L28
    L25:
        if (r6.equals("ConstraintSet") == false) goto L27;
        r5 = 4;
    L37:
        r4 = r2.next();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L55:
        return;
    L39:
        e = e;
        StringBuilder r15 = new StringBuilder();
    L43:
        Log.e("ConstraintLayoutStates", r15.append("Error parsing resource: ").append(r13).toString(), e);
        return;
    L41:
        e = e;
        r15 = new StringBuilder();
        goto L43
    }

    private void a(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.widget.b r0 = new com.obric.oui.constraintlayout.widget.b();
        int r2 = r13.getAttributeCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L27;
        String r4 = r13.getAttributeName(r3);
        String r5 = r13.getAttributeValue(r3);
        if (r4 == null) goto L20;
        if (r5 == null) goto L20;
        if (OaidModel.KEY_ID.equals(r4) == false) goto L20;
        if (r5.contains("/") == false) goto L13;
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r5.substring(r5.indexOf(47) + 1), OaidModel.KEY_ID, r12.getPackageName(), "com.obric.memorydata.plugin");
    L14:
        if (r1 == (-1)) goto L16;
    L19:
        r0.a(r12, r13);
        this.f.put(r1, r0);
        return;
    L16:
        if (r5.length() <= 1) goto L18;
        r1 = Integer.parseInt(r5.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r1 = -1;
    L20:
        r3 = r3 + 1;
        goto L3
    }

    public void a(int r7, float r8, float r9) {
        int r0 = this.f13761b;
        if (r0 != r7) goto L29;
        if (r7 != (-1)) goto L6;
        C0742a r10 = this.e.valueAt(0);
    L7:
        C0742a r11 = (C0742a) ZeusTransformUtils.preCheckCast(r10, C0742a.class, "com.obric.memorydata.plugin");
        if (this.c != (-1)) goto L10;
    L12:
        int r12 = r11.a(r8, r9);
        if (this.c != r12) goto L15;
        return;
    L15:
        if (r12 != (-1)) goto L17;
        com.obric.oui.constraintlayout.widget.b r13 = this.f13760a;
    L18:
        if (r12 != (-1)) goto L20;
        int r14 = r11.c;
    L21:
        if (r13 != null) goto L23;
        return;
    L23:
        this.c = r12;
        c r15 = this.g;
        if (r15 == null) goto L26;
        r15.a(-1, r14);
    L26:
        r13.c(this.d);
        c r6 = this.g;
        if (r6 == null) goto L46;
        r6.b(-1, r14);
        return;
    L46:
        return;
    L20:
        r14 = ((b) ZeusTransformUtils.preCheckCast(r11.f13763b.get(r12), b.class, "com.obric.memorydata.plugin")).e;
        goto L21
    L17:
        r13 = ((b) ZeusTransformUtils.preCheckCast(r11.f13763b.get(r12), b.class, "com.obric.memorydata.plugin")).f;
        goto L18
    L10:
        if (((b) ZeusTransformUtils.preCheckCast(r11.f13763b.get(this.c), b.class, "com.obric.memorydata.plugin")).a(r8, r9) == false) goto L12;
        return;
    L6:
        r10 = this.e.get(r0);
        goto L7
    L29:
        this.f13761b = r7;
        C0742a r1 = (C0742a) ZeusTransformUtils.preCheckCast(this.e.get(r7), C0742a.class, "com.obric.memorydata.plugin");
        int r3 = r1.a(r8, r9);
        if (r3 != (-1)) goto L32;
        com.obric.oui.constraintlayout.widget.b r4 = r1.d;
    L33:
        if (r3 != (-1)) goto L35;
        int r2 = r1.c;
    L36:
        if (r4 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r7 + ", dim =" + r8 + ", " + r9);
        return;
    L39:
        this.c = r3;
        c r16 = this.g;
        if (r16 == null) goto L42;
        r16.a(r7, r2);
    L42:
        r4.c(this.d);
        c r17 = this.g;
        if (r17 == null) goto L48;
        r17.b(r7, r2);
        return;
    L48:
        return;
    L35:
        r2 = ((b) ZeusTransformUtils.preCheckCast(r1.f13763b.get(r3), b.class, "com.obric.memorydata.plugin")).e;
        goto L36
    L32:
        r4 = ((b) ZeusTransformUtils.preCheckCast(r1.f13763b.get(r3), b.class, "com.obric.memorydata.plugin")).f;
        goto L33
    }

    public void a(c r1) {
        this.g = r1;
    }
}
