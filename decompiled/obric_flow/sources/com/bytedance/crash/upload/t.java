package com.bytedance.crash.upload;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.compose.runtime.ComposerKt;
import com.google.common.base.b0;
import com.google.common.collect.g8;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4161c;
    public Object d;
    public Cloneable e;
    public Object f;

    public t(int r5) {
        this.f4159a = 0;
        this.f4160b = r5;
    }

    public void a(JSONObject r5) {
        this.d = r5;
        String r10 = "";
        if (((Map) this.f) == null) goto L14;
        new ArrayList();     // Catch: Throwable -> L22
        Iterator r11 = ((Map) this.f).entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L22
        if ("Alog_quota".equalsIgnoreCase((String) r12.getKey()) == false) goto L8;
        List r13 = (List) r12.getValue();     // Catch: Throwable -> L22
        if (r13.size() <= 0) goto L8;
        r10 = (String) r13.get(0);     // Catch: Throwable -> L22
    L14:
        ((JSONObject) this.d).putOpt("Alog_quota", r10);     // Catch: Throwable -> L22
        String r14 = ((JSONObject) this.d).optString("message");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r14) == false) goto L17;
        return;
    L17:
        if (r14.equals("drop all data") == false) goto L19;
    L20:
        this.f4160b = 213;     // Catch: Throwable -> L22
        return;
    L19:
        if (r14.equals("drop data") == true) goto L20;
        return;
    }

    public boolean b() {
        if (this.f4160b != 213) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean c() {
        int r5 = this.f4160b;
        if (r5 != 207) goto L5;
        return false;
    L5:
        if (r5 == 214) goto L10;
        return true;
    L10:
        return false;
    }

    public void d(Context r10, XmlResourceParser r11) {
        com.obric.oui.constraintlayout.widget.d r5 = new com.obric.oui.constraintlayout.widget.d();
        int r12 = r11.getAttributeCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L27;
        String r14 = r11.getAttributeName(r13);
        String r15 = r11.getAttributeValue(r13);
        if (r14 == null) goto L20;
        if (r15 == null) goto L20;
        if ("id".equals(r14) == false) goto L20;
        if (r15.contains("/") == false) goto L13;
        int r16 = r10.getResources().getIdentifier(r15.substring(r15.indexOf(47) + 1), "id", r10.getPackageName());
    L14:
        if (r16 == (-1)) goto L16;
    L19:
        r5.k(r10, r11);
        ((SparseArray) this.f).put(r16, r5);
        return;
    L16:
        if (r15.length() <= 1) goto L18;
        r16 = Integer.parseInt(r15.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r16 = -1;
    L20:
        r13 = r13 + 1;
        goto L3
    }

    public String toString() {
        switch(this.f4159a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = "Response:mErrorCode=" + this.f4160b + ", mServerErrorCode=" + this.f4161c;
        if (((JSONObject) this.d) == null) goto L10;
        StringBuilder r10 = com.lynx.tasm.utils.j.d(r5, ", mServerJson=");
        r10.append(((JSONObject) this.d).toString());
        return r10.toString();
    L10:
        return r5;
    L5:
        return super.toString();
    }

    public t(Throwable r5) {
        this.f4159a = 0;
        this.f4160b = ComposerKt.reuseKey;
        r5.getMessage();
    }

    public t(Context r11, ConstraintLayout r12, int r13) {
        this.f4159a = 2;
        this.f4160b = -1;
        this.f4161c = -1;
        this.e = new SparseArray();
        this.f = new SparseArray();
        this.d = r12;
        XmlResourceParser r5 = r11.getResources().getXml(r13);
        int r10 = r5.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
        lr.d r14 = null;
    L4:
        byte r15 = 1;
        if (r10 == 1) goto L57;
        if (r10 != 2) goto L41;
        String r16 = r5.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        switch(r16.hashCode()) {
            case -1349929691: goto L29;
            case 80204913: goto L26;
            case 1382829617: goto L23;
            case 1657696882: goto L20;
            case 1901439077: goto L13;
            default: goto L31;
        };     // Catch: IOException -> L15 XmlPullParserException -> L17
    L31:
        r15 = -1;
    L32:
        if (r15 == 2) goto L40;
        if (r15 == 3) goto L37;
        if (r15 != 4) goto L41;
        d(r11, r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L41
    L37:
        lr.e r17 = new lr.e(r11, r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r14 == null) goto L41;
        r14.f19701b.add(r17);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L41
    L40:
        lr.d r18 = new lr.d(r11, r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
        ((SparseArray) this.e).put(r18.f19700a, r18);     // Catch: IOException -> L15 XmlPullParserException -> L17
        r14 = r18;
        goto L41
    L13:
        if (r16.equals("Variant") == false) goto L31;
        r15 = 3;
        goto L32
    L20:
        if (r16.equals("layoutDescription") == false) goto L31;
        r15 = 0;
        goto L32
    L23:
        if (r16.equals("StateSet") == false) goto L31;
    L26:
        if (r16.equals("State") == false) goto L31;
        r15 = 2;
        goto L32
    L29:
        if (r16.equals("ConstraintSet") == false) goto L31;
        r15 = 4;
    L41:
        r10 = r5.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L57:
        return;
    L15:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + r13, e);
        return;
    L17:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + r13, e);
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Cloneable, java.lang.Object[]] */
    public t(g8 r10, int r11) {
        this.f4159a = 1;
        this.d = r10;
        this.f4160b = r11;
        boolean r12 = true;
        if (r11 < 0) goto L5;
        boolean r5 = true;
    L6:
        b0.d(r11, "k (%s) must be >= 0", r5);
        if (r11 > 1073741823) goto L9;
        boolean r13 = true;
    L10:
        b0.d(r11, "k (%s) must be <= Integer.MAX_VALUE / 2", r13);
        long r14 = ((long) r11) * ((long) 2);
        int r15 = (int) r14;
        if (r14 == r15) goto L14;
        r12 = false;
    L14:
        com.lynx.tasm.utils.j.l("checkedMultiply", r11, 2, r12);
        this.e = new Object[r15];
        this.f4161c = 0;
        this.f = null;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }
}
