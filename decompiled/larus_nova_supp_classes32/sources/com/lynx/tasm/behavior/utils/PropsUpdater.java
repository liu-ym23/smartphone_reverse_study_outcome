package com.lynx.tasm.behavior.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PropsUpdater {
    public static final Map<Class<?>, LynxUISetter<?>> a = null;
    public static final Map<Class<?>, ShadowNodeSetter<?>> b = null;
    public static final Map<String, Settable> c = null;

    public static class FallbackLynxUISetter<T extends LynxBaseUI> implements LynxUISetter<T> {
        public final Map<String, e.k> a;

        public FallbackLynxUISetter() {
            throw null;
        }

        public FallbackLynxUISetter(Class r1) {
            this.a = e.c(r1);
        }

        @Override // com.lynx.tasm.behavior.utils.LynxUISetter
        public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
            e.k r8 = this.a.get(r6);
            if (r8 == null) goto L16;
            Integer r0 = r8.c;     // Catch: Throwable -> L9
            if (r0 != null) goto L7;
            r8.b.invoke(r5, new Object[]{r8.a(r7)});     // Catch: Throwable -> L9
        L13:
            return;
        L7:
            r8.b.invoke(r5, new Object[]{r0, r8.a(r7)});     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            RuntimeException r1 = new RuntimeException("Fallback setter, error while updating property '" + r8.a + "' in Lynx UI of type: " + r5.getClass() + ":" + th, th);
            r1.setStackTrace(th.getStackTrace());
            throw r1;
        }
    }

    public static class FallbackShadowNodeSetter<T extends ShadowNode> implements ShadowNodeSetter<T> {
        public final Map<String, e.k> a;

        public FallbackShadowNodeSetter() {
            throw null;
        }

        public FallbackShadowNodeSetter(Class r1) {
            this.a = e.d(r1);
        }

        @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
        public final void a(ShadowNode r5, String r6, x0 r7) {
            e.k r8 = this.a.get(r6);
            if (r8 == null) goto L16;
            Integer r0 = r8.c;     // Catch: Throwable -> L9
            if (r0 != null) goto L7;
            r8.b.invoke(r5, new Object[]{r8.a(r7)});     // Catch: Throwable -> L9
        L13:
            return;
        L7:
            r8.b.invoke(r5, new Object[]{r0, r8.a(r7)});     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            RuntimeException r1 = new RuntimeException("Fallback setter, error while updating property '" + r8.a + "' in shadow node of type: " + r5.n() + ":" + th, th);
            r1.setStackTrace(th.getStackTrace());
            throw r1;
        }
    }

    public PropsUpdater() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static <T> T b(Class<?> r4) {
        String r5 = r4.getName().concat("$$PropsSetter");
        T r0 = (T) ((Settable) ((HashMap) c).get(r5));
        if (r0 == null) goto L14;
        return r0;
    L14:
        return (T) a(r5).newInstance();
    L12:
        return null;
    L7:
        e = e;
    L11:
        throw new RuntimeException("Unable to instantiate methods getter for " + r5, e);
    L9:
        e = e;
        goto L11
    }

    public static <T extends LynxBaseUI> LynxUISetter<T> c(final Class<? extends LynxBaseUI> r5) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) a;
        LynxUISetter<T> r1 = (LynxUISetter) r0.get(r5);
        if (r1 != null) goto L15;
        r1 = (LynxUISetter) b(r5);
        if (r1 != null) goto L14;
        String r2 = "PropsSetter not generated for class: " + r5.getName() + ". You should add module lynxProcessor";
        if (LynxEnv.inst().isCheckPropsSetter() == true) goto L9;
    L13:
        LLog.e("PropsUpdater", r2);
        r1 = new FallbackLynxUISetter(r5);
        LynxEventReporter.onEvent("lynxsdk_props_setter_fallback", new AnonymousClass1(r5), -1);
        goto L14
    L9:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L13;
        throw new IllegalStateException(r2);
    L14:
        r0.put(r5, r1);
    L15:
        return r1;
    }

    public static <T extends ShadowNode> void d(T r4, x0 r5) {
        Class<?> r0 = r4.getClass();
        ConcurrentHashMap r1 = (ConcurrentHashMap) b;
        ShadowNodeSetter r2 = (ShadowNodeSetter) r1.get(r0);
        if (r2 != null) goto L8;
        r2 = (ShadowNodeSetter) b(r0);
        if (r2 != null) goto L7;
        r2 = new FallbackShadowNodeSetter(r0);
    L7:
        r1.put(r0, r2);
    L8:
        ReadableMapKeySetIterator r3 = r5.a.keySetIterator();
    L10:
        if (r3.hasNextKey() == false) goto L12;
        r2.a(r4, r3.nextKey(), r5);
        goto L10
    L12:
        MapBuffer r6 = r5.b;
        if (r6 != null) goto L15;
        return;
    L15:
        if ((r4 instanceof BaseTextShadowNode) == false) goto L114;
        BaseTextShadowNode r7 = (BaseTextShadowNode) r4;
        Iterator<MapBuffer.a> r8 = r6.iterator();
    L19:
        if (r8.hasNext() == false) goto L115;
        MapBuffer.a r9 = r8.next();
        int r10 = r9.getKey();
        if (r10 != 22) goto L23;
        r7.setColor(new g6a.a(new com.lynx.react.bridge.mapbuffer.e(r6), 22));
        goto L19
    L23:
        if (r10 != 73) goto L25;
        r7.setLineSpacing((float) r9.b());
        goto L19
    L25:
        if (r10 != 122) goto L27;
        r7.setWordBreakStrategy(r9.a());
        goto L19
    L27:
        if (r10 != 130) goto L29;
        r7.setDirection(r9.a());
        goto L19
    L29:
        if (r10 != 192) goto L31;
        r7.setTextIndent(new com.lynx.react.bridge.mapbuffer.e(r9.f()));
        goto L19
    L31:
        if (r10 != 61) goto L33;
        r7.setFontFamily(r9.getString());
        goto L19
    L33:
        if (r10 != 62) goto L35;
        r7.setFontStyle(r9.a());
        goto L19
    L35:
        if (r10 != 96) goto L37;
        r7.setTextDecoration(new com.lynx.react.bridge.mapbuffer.e(r9.f()));
        goto L19
    L37:
        if (r10 != 97) goto L39;
        r7.setTextShadow(new com.lynx.react.bridge.mapbuffer.e(r9.f()));
        goto L19
    L39:
        if (r10 != 195) goto L41;
        r7.setTextStrokeWidth((float) r9.b());
        goto L19
    L41:
        if (r10 != 196) goto L42;
        r7.setTextStrokeColor(new g6a.a(new com.lynx.react.bridge.mapbuffer.e(r6), 196));
        goto L19
    L42:
        switch(r10) {
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
        r7.setFontWeight(r9.a());
        goto L19
    L45:
        r7.setFontSize((float) r9.b());
        goto L19
    L46:
        r7.setTextOverflow(r9.a());
        goto L19
    L47:
        r7.setLineHeight((float) r9.b());
        goto L19
    L48:
        r7.setTextAlign(r9.a());
        goto L19
    L49:
        r7.setLetterSpacing((float) r9.b());
        goto L19
    L50:
        r7.setWhiteSpace(r9.a());
        goto L19
    L115:
        return;
    }
}
