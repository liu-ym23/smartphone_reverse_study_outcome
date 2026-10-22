package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.ViewTransition;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashMap<String, Constructor<? extends d>> f13689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Integer, ArrayList<d>> f13690b;

    static {
        HashMap<String, Constructor<? extends d>> r0 = new HashMap();
        f13689a = r0;
        r0.put("KeyAttribute", e.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f13689a.put(TypedValues.PositionType.NAME, h.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f13689a.put(TypedValues.CycleType.NAME, f.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f13689a.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f13689a.put(TypedValues.TriggerType.NAME, k.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("KeyFrames", "unable to load", e);
    }

    public g() {
        this.f13690b = new HashMap();
    }

    public g(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        this.f13690b = new HashMap();
        d r2 = null;
        int r3 = r13.getEventType();     // Catch: Throwable -> L61
    L5:
        if (r3 == 1) goto L78;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L11;
    L59:
        r3 = r13.next();     // Catch: Throwable -> L61
        goto L5
    L11:
        if (ViewTransition.KEY_FRAME_SET_TAG.equals(r13.getName()) == false) goto L59;
        return;
    L13:
        String r4 = r13.getName();     // Catch: Throwable -> L61
        if (f13689a.containsKey(r4) == false) goto L47;
        byte r5 = -1;
        switch(r4.hashCode()) {
            case -300573030: goto L31;
            case -298435811: goto L28;
            case 540053991: goto L25;
            case 1153397896: goto L22;
            case 1308496505: goto L19;
            default: goto L33;
        };     // Catch: Throwable -> L61
    L33:
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L42;
        if (r5 == 3) goto L41;
        if (r5 != 4) goto L40;
        r2 = new k();     // Catch: Throwable -> L61
    L45:
        r2.a(r12, Xml.asAttributeSet(r13));     // Catch: Throwable -> L61
        a(r2);     // Catch: Throwable -> L61
        goto L59
    L40:
        throw new NullPointerException("Key " + r4 + " not found");     // Catch: Throwable -> L61
    L41:
        r2 = new j();     // Catch: Throwable -> L61
        goto L45
    L42:
        r2 = new f();     // Catch: Throwable -> L61
        goto L45
    L43:
        r2 = new h();     // Catch: Throwable -> L61
        goto L45
    L44:
        r2 = new e();     // Catch: Throwable -> L61
        goto L45
    L19:
        if (r4.equals(TypedValues.TriggerType.NAME) == false) goto L33;
        r5 = 4;
        goto L33
    L22:
        if (r4.equals(TypedValues.PositionType.NAME) == false) goto L33;
        r5 = 1;
        goto L33
    L25:
        if (r4.equals(TypedValues.CycleType.NAME) == false) goto L33;
        r5 = 2;
        goto L33
    L28:
        if (r4.equals("KeyAttribute") == false) goto L33;
        r5 = 0;
        goto L33
    L31:
        if (r4.equals("KeyTimeCycle") == false) goto L33;
        r5 = 3;
        goto L33
    L47:
        if (r4.equalsIgnoreCase(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L54;
        if (r2 == null) goto L59;
        if (r2.f == null) goto L59;
        HashMap<String, ConstraintAttribute> r6 = r2.f;     // Catch: Throwable -> L61
    L52:
        ConstraintAttribute.a(r12, r13, r6);     // Catch: Throwable -> L61
        goto L59
    L54:
        if (r4.equalsIgnoreCase(ViewTransition.CUSTOM_METHOD) == false) goto L59;
        if (r2 == null) goto L59;
        if (r2.f == null) goto L59;
        r6 = r2.f;     // Catch: Throwable -> L61
        goto L52
    L78:
        return;
    L61:
        e = move-exception;
        Log.e("KeyFrames", "Error parsing XML resource", e);
    }

    public ArrayList<d> a(int r2) {
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.f13690b.get(Integer.valueOf(r2)), ArrayList.class, "com.obric.memorydata.plugin");
    }

    public void a(d r4) {
        if (this.f13690b.containsKey(Integer.valueOf(r4.c)) == true) goto L5;
        this.f13690b.put(Integer.valueOf(r4.c), new ArrayList());
    L5:
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f13690b.get(Integer.valueOf(r4.c)), ArrayList.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public void a(m r3) {
        ArrayList<d> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f13690b.get(-1), ArrayList.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r3.a(r2);
        return;
    }

    public void b(m r5) {
        ArrayList<d> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f13690b.get(Integer.valueOf(r5.c)), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r5.a(r0);
    L5:
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f13690b.get(-1), ArrayList.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.memorydata.plugin");
        if (r1.a(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.f13698b.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).ac) == false) goto L9;
        r5.a(r1);
        goto L9
    L19:
        return;
    }
}
