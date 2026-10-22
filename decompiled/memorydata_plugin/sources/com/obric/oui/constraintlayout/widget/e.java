package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13784b;
    int c;
    private SparseArray<a> d;
    private c e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f13786b;
        int c;
        boolean d;

        a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.f13786b = new ArrayList();
            this.c = -1;
            int r0 = 0;
            this.d = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L13;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f13785a = r12.getResourceId(r3, this.f13785a);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.c = r12.getResourceId(r3, this.c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.c);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.c);
            if ("layout".equals(r4) == false) goto L12;
            this.d = true;
            goto L12
        L13:
            r12.recycle();
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f13786b.size()) goto L9;
            if (((b) ZeusTransformUtils.preCheckCast(this.f13786b.get(r0), b.class, "com.obric.memorydata.plugin")).a(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        void a(b r1) {
            this.f13786b.add(r1);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f13787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13788b;
        float c;
        float d;
        int e;
        boolean f;

        b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.f13787a = Float.NaN;
            this.f13788b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            int r0 = 0;
            this.f = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L23;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.e = r12.getResourceId(r3, this.e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.e);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.e);
            if ("layout".equals(r4) == false) goto L22;
            this.f = true;
        L22:
            r0 = r0 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.d = r12.getDimension(r3, this.d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f13788b = r12.getDimension(r3, this.f13788b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.c = r12.getDimension(r3, this.c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f13787a = r12.getDimension(r3, this.f13787a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f13787a) == true) goto L8;
            if (r3 >= this.f13787a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f13788b) == true) goto L13;
            if (r4 >= this.f13788b) goto L13;
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

    public e(Context r3, XmlPullParser r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        this.f13783a = -1;
        this.f13784b = -1;
        this.c = -1;
        this.d = new SparseArray();
        this.e = null;
        a(r5, r6);
    }

    private void a(Context r12, XmlPullParser r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        TypedArray r2 = r14.obtainStyledAttributes(Xml.asAttributeSet(r15), R.styleable.StateSet);
        int r3 = r2.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        int r6 = r2.getIndex(r5);
        if (r6 != ZeusTransformUtils.mapRes(R.styleable.StateSet_defaultState, "styleable", "StateSet_defaultState")) goto L7;
        this.f13783a = r2.getResourceId(r6, this.f13783a);
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        r2.recycle();
        a r4 = null;
        int r7 = r15.getEventType();     // Catch: Throwable -> L44
    L10:
        byte r8 = 1;
        if (r7 == 1) goto L60;
        if (r7 == 2) goto L19;
        if (r7 != 3) goto L42;
        if ("StateSet".equals(r15.getName()) == false) goto L42;
        return;
    L42:
        r7 = r15.next();     // Catch: Throwable -> L44 Throwable -> L44
        goto L10
    L19:
        String r9 = r15.getName();     // Catch: Throwable -> L44 Throwable -> L44
        switch(r9.hashCode()) {
            case 80204913: goto L32;
            case 1301459538: goto L29;
            case 1382829617: goto L26;
            case 1901439077: goto L23;
            default: goto L34;
        };     // Catch: Throwable -> L44 Throwable -> L44
    L34:
        r8 = -1;
    L35:
        if (r8 == 2) goto L41;
        if (r8 != 3) goto L42;
        b r10 = new b(r14, r15);     // Catch: Throwable -> L44 Throwable -> L44
        if (r4 == null) goto L42;
        r4.a(r10);     // Catch: Throwable -> L44 Throwable -> L44
        goto L42
    L41:
        r4 = new a(r14, r15);     // Catch: Throwable -> L44 Throwable -> L44
        this.d.put(r4.f13785a, r4);     // Catch: Throwable -> L44 Throwable -> L44
        goto L42
    L23:
        if (r9.equals("Variant") == false) goto L34;
        r8 = 3;
        goto L35
    L26:
        if (r9.equals("StateSet") == false) goto L34;
    L29:
        if (r9.equals("LayoutDescription") == false) goto L34;
        r8 = 0;
        goto L35
    L32:
        if (r9.equals("State") == false) goto L34;
        r8 = 2;
        goto L35
    L60:
        return;
    L44:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
    }

    public int a(int r5, int r6, float r7, float r8) {
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r6), a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return r6;
    L6:
        if (r7 == (-1.0f)) goto L25;
        if (r8 == (-1.0f)) goto L25;
        b r9 = null;
        Iterator<b> r0 = r4.f13786b.iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        if (r2.a(r7, r8) == false) goto L12;
        if (r5 == r2.e) goto L17;
        r9 = r2;
        goto L12
    L17:
        return r5;
    L19:
        if (r9 == null) goto L23;
        return r9.e;
    L23:
        return r4.c;
    L25:
        if (r4.c != r5) goto L27;
        return r5;
    L27:
        Iterator<b> r10 = r4.f13786b.iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        if (r5 != ((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.memorydata.plugin")).e) goto L29;
        return r5;
    L34:
        return r4.c;
    }

    public int a(int r2, int r3, int r4) {
        return b(-1, r2, r3, r4);
    }

    public int b(int r4, int r5, float r6, float r7) {
        if (r4 != r5) goto L22;
        if (r5 != (-1)) goto L6;
        a r8 = this.d.valueAt(0);
    L7:
        a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L11;
        return -1;
    L11:
        if (this.c != (-1)) goto L13;
    L15:
        int r3 = r9.a(r6, r7);
        if (r4 != r3) goto L18;
        return r4;
    L18:
        if (r3 != (-1)) goto L21;
        return r9.c;
    L21:
        return ((b) ZeusTransformUtils.preCheckCast(r9.f13786b.get(r3), b.class, "com.obric.memorydata.plugin")).e;
    L13:
        if (((b) ZeusTransformUtils.preCheckCast(r9.f13786b.get(r4), b.class, "com.obric.memorydata.plugin")).a(r6, r7) == false) goto L15;
        return r4;
    L6:
        r8 = this.d.get(this.f13784b);
        goto L7
    L22:
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L25;
        return -1;
    L25:
        int r11 = r10.a(r6, r7);
        if (r11 != (-1)) goto L29;
        return r10.c;
    L29:
        return ((b) ZeusTransformUtils.preCheckCast(r10.f13786b.get(r11), b.class, "com.obric.memorydata.plugin")).e;
    }
}
