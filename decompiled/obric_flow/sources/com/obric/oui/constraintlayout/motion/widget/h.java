package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f12794b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f12795a;

    static {
        HashMap r5 = new HashMap();
        f12794b = r5;
        r5.put("KeyAttribute", e.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        r5.put("KeyPosition", j.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        r5.put("KeyCycle", g.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        r5.put("KeyTimeCycle", l.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        r5.put("KeyTrigger", n.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("KeyFrames", "unable to load", e);
    }

    public h(Context r10, XmlResourceParser r11) {
        this.f12795a = new HashMap();
        int r5 = r11.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
        c r12 = null;
    L5:
        if (r5 == 1) goto L84;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L11;
    L63:
        r5 = r11.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L5
    L11:
        if ("KeyFrameSet".equals(r11.getName()) == false) goto L63;
        return;
    L17:
        String r13 = r11.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (f12794b.containsKey(r13) == false) goto L52;
        switch(r13.hashCode()) {
            case -300573030: goto L35;
            case -298435811: goto L32;
            case 540053991: goto L29;
            case 1153397896: goto L26;
            case 1308496505: goto L23;
            default: goto L37;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L37:
        byte r14 = -1;
    L38:
        if (r14 == 0) goto L49;
        if (r14 == 1) goto L48;
        if (r14 == 2) goto L47;
        if (r14 == 3) goto L46;
        if (r14 != 4) goto L45;
        c r15 = new n();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L50:
        r15.e(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L13 XmlPullParserException -> L15
        b(r15);     // Catch: IOException -> L13 XmlPullParserException -> L15
        r12 = r15;
        goto L63
    L45:
        throw new NullPointerException("Key " + r13 + " not found");     // Catch: IOException -> L13 XmlPullParserException -> L15
    L46:
        r15 = new l();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L47:
        r15 = new g();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L48:
        r15 = new j();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L49:
        r15 = new e();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L23:
        if (r13.equals("KeyTrigger") == false) goto L37;
        r14 = 4;
        goto L38
    L26:
        if (r13.equals("KeyPosition") == false) goto L37;
        r14 = 1;
        goto L38
    L29:
        if (r13.equals("KeyCycle") == false) goto L37;
        r14 = 2;
        goto L38
    L32:
        if (r13.equals("KeyAttribute") == false) goto L37;
        r14 = 0;
        goto L38
    L35:
        if (r13.equals("KeyTimeCycle") == false) goto L37;
        r14 = 3;
        goto L38
    L52:
        if (r13.equalsIgnoreCase("CustomAttribute") == false) goto L58;
        if (r12 == null) goto L63;
        HashMap r16 = r12.d;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r16 == null) goto L63;
        lr.b.d(r10, r11, r16);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L63
    L58:
        if (r13.equalsIgnoreCase("CustomMethod") == false) goto L63;
        if (r12 == null) goto L63;
        HashMap r17 = r12.d;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r17 == null) goto L63;
        lr.b.d(r10, r11, r17);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L63
    L84:
        return;
    L13:
        e = move-exception;
        Log.e("KeyFrames", "Error parsing XML resource", e);
        return;
    L15:
        e = move-exception;
        Log.e("KeyFrames", "Error parsing XML resource", e);
    }

    public final void a(q r5) {
        Integer r10 = Integer.valueOf(r5.f12875c);
        HashMap r11 = this.f12795a;
        ArrayList r12 = (ArrayList) r11.get(r10);
        if (r12 == null) goto L5;
        r5.f12890w.addAll(r12);
    L5:
        ArrayList r13 = (ArrayList) r11.get(-1);
        if (r13 == null) goto L18;
        Iterator r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L24;
        c r15 = (c) r14.next();
        String r16 = ((ConstraintLayout.LayoutParams) r5.f12874b.getLayoutParams()).Y;
        String r17 = r15.f12715c;
        if (r17 == null) goto L15;
        if (r16 == null) goto L15;
        boolean r18 = r16.matches(r17);
    L16:
        if (r18 == false) goto L9;
        r5.a(r15);
    L15:
        r18 = false;
        goto L16
    L24:
        return;
    }

    public final void b(c r5) {
        Integer r10 = Integer.valueOf(r5.f12714b);
        HashMap r11 = this.f12795a;
        if (r11.containsKey(r10) == true) goto L5;
        r11.put(Integer.valueOf(r5.f12714b), new ArrayList());
    L5:
        ArrayList r12 = (ArrayList) r11.get(Integer.valueOf(r5.f12714b));
        if (r12 == null) goto L9;
        r12.add(r5);
        return;
    }
}
