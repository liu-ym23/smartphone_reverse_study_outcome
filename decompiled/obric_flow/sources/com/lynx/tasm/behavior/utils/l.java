package com.lynx.tasm.behavior.utils;

import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f10800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f10801b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f10802c = null;

    static {
        f10800a = new ConcurrentHashMap();
        f10801b = new ConcurrentHashMap();
        f10802c = new HashMap();
    }

    public static Object a(Class r5) {
        String r10 = r5.getName().concat("$$PropsSetter");
        Settable r11 = (Settable) f10802c.get(r10);
        if (r11 == null) goto L12;
        return r11;
    L12:
        return Class.forName(r10).newInstance();
    L10:
        return null;
    L7:
        e = move-exception;
        throw new RuntimeException(td.d.b("Unable to instantiate methods getter for ", r10), e);
    }

    public static void b(ShadowNode r5, y0 r10) {
        final Class<?> r11 = r5.getClass();
        ConcurrentHashMap r12 = f10801b;
        ShadowNodeSetter r13 = (ShadowNodeSetter) r12.get(r11);
        if (r13 != null) goto L8;
        r13 = (ShadowNodeSetter) a(r11);
        if (r13 != null) goto L7;
        r13 = new PropsUpdater$FallbackShadowNodeSetter(r11);
    L7:
        r12.put(r11, r13);
    L8:
        ReadableMapKeySetIterator r14 = r10.f10815a.keySetIterator();
    L10:
        if (r14.hasNextKey() == false) goto L12;
        r13.b(r5, r14.nextKey(), r10);
        goto L10
    L12:
        ReadableMapBuffer r15 = r10.f10816b;
        if (r15 != null) goto L15;
        return;
    L15:
        if ((r5 instanceof BaseTextShadowNode) == false) goto L114;
        BaseTextShadowNode r16 = (BaseTextShadowNode) r5;
        Iterator r17 = r15.iterator();
    L19:
        if (r17.hasNext() == false) goto L115;
        qm.c r18 = (qm.c) r17.next();
        ByteBuffer r19 = r18.f21526b.f21527a;
        int r20 = r18.f21525a;
        short r21 = r19.getShort(r20);
        if (r21 != 22) goto L23;
        r16.setColor(new qm.a(new qm.f(r15), 22));
        goto L19
    L23:
        if (r21 != 73) goto L25;
        r16.setLineSpacing((float) r18.a());
        goto L19
    L25:
        if (r21 != 122) goto L27;
        r16.setWordBreakStrategy(r18.b());
        goto L19
    L27:
        if (r21 != 130) goto L29;
        r16.setDirection(r18.b());
        goto L19
    L29:
        if (r21 != 192) goto L31;
        r16.setTextIndent(new qm.f(r18.c()));
        goto L19
    L31:
        if (r21 != 61) goto L33;
        qm.d r22 = r18.f21526b;
        r16.setFontFamily(r22.c(r20 + r22.f21529c));
        goto L19
    L33:
        if (r21 != 62) goto L35;
        r16.setFontStyle(r18.b());
        goto L19
    L35:
        if (r21 != 96) goto L37;
        r16.setTextDecoration(new qm.f(r18.c()));
        goto L19
    L37:
        if (r21 != 97) goto L39;
        r16.setTextShadow(new qm.f(r18.c()));
        goto L19
    L39:
        if (r21 != 195) goto L41;
        r16.setTextStrokeWidth((float) r18.a());
        goto L19
    L41:
        if (r21 != 196) goto L42;
        r16.setTextStrokeColor(new qm.a(new qm.f(r15), 196));
        goto L19
    L42:
        switch(r21) {
            case 42: goto L50;
            case 43: goto L49;
            case 44: goto L48;
            case 45: goto L47;
            case 46: goto L46;
            case 47: goto L45;
            case 48: goto L44;
            default: goto L19;
        };
    L44:
        r16.setFontWeight(r18.b());
        goto L19
    L45:
        r16.setFontSize((float) r18.a());
        goto L19
    L46:
        r16.setTextOverflow(r18.b());
        goto L19
    L47:
        r16.setLineHeight((float) r18.a());
        goto L19
    L48:
        r16.setTextAlign(r18.b());
        goto L19
    L49:
        r16.setLetterSpacing((float) r18.a());
        goto L19
    L50:
        r16.setWhiteSpace(r18.b());
        goto L19
    L115:
        return;
    }

    public static LynxUISetter c(final Class r5) {
        ConcurrentHashMap r10 = f10800a;
        LynxUISetter r11 = (LynxUISetter) r10.get(r5);
        if (r11 != null) goto L15;
        r11 = (LynxUISetter) a(r5);
        if (r11 != null) goto L14;
        String r12 = "PropsSetter not generated for class: " + r5.getName() + ". You should add module lynxProcessor";
        if (LynxEnv.inst().isCheckPropsSetter() == true) goto L9;
    L13:
        LynxLog.b(4, "PropsUpdater", r12);
        r11 = new PropsUpdater$FallbackLynxUISetter(r5);
        LynxEventReporter.onEvent("lynxsdk_props_setter_fallback", new PropsUpdater$1(r5), -1);
        goto L14
    L9:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L13;
        throw new IllegalStateException(r12);
    L14:
        r10.put(r5, r11);
    L15:
        return r11;
    }
}
