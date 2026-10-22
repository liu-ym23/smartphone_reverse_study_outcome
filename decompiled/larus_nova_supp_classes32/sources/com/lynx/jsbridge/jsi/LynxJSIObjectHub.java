package com.lynx.jsbridge.jsi;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxJSIObjectHub {
    public static volatile LynxJSIObjectHub b;
    public final ConcurrentHashMap<String, ILynxJSIObjectDescriptor> a;

    public static final enum JObjectType extends Enum<JObjectType> {
        public static final JObjectType BOOLEAN_ARRAY_TYPE = null;
        public static final JObjectType BOOLEAN_WRAPPER_TYPE = null;
        public static final JObjectType DOUBLE_ARRAY_TYPE = null;
        public static final JObjectType DOUBLE_WRAPPER_TYPE = null;
        public static final JObjectType FLOAT_ARRAY_TYPE = null;
        public static final JObjectType FLOAT_WRAPPER_TYPE = null;
        public static final JObjectType INT_ARRAY_TYPE = null;
        public static final JObjectType INT_WRAPPER_TYPE = null;
        public static final JObjectType LIST_TYPE = null;
        public static final JObjectType LONG_ARRAY_TYPE = null;
        public static final JObjectType LONG_WRAPPER_TYPE = null;
        public static final JObjectType LYNX_JSI_OBJECT_TYPE = null;
        public static final JObjectType OBJECT_ARRAY_TYPE = null;
        public static final JObjectType STRING_TYPE = null;
        public static final JObjectType UNKNOWN_TYPE = null;
        public static final /* synthetic */ JObjectType[] a = null;

        static {
            JObjectType r0 = new JObjectType("UNKNOWN_TYPE", 0);
            UNKNOWN_TYPE = r0;
            JObjectType r1 = new JObjectType("LYNX_JSI_OBJECT_TYPE", 1);
            LYNX_JSI_OBJECT_TYPE = r1;
            JObjectType r3 = new JObjectType("STRING_TYPE", 2);
            STRING_TYPE = r3;
            JObjectType r5 = new JObjectType("OBJECT_ARRAY_TYPE", 3);
            OBJECT_ARRAY_TYPE = r5;
            JObjectType r7 = new JObjectType("BOOLEAN_ARRAY_TYPE", 4);
            BOOLEAN_ARRAY_TYPE = r7;
            JObjectType r9 = new JObjectType("INT_ARRAY_TYPE", 5);
            INT_ARRAY_TYPE = r9;
            JObjectType r11 = new JObjectType("LONG_ARRAY_TYPE", 6);
            LONG_ARRAY_TYPE = r11;
            JObjectType r13 = new JObjectType("FLOAT_ARRAY_TYPE", 7);
            FLOAT_ARRAY_TYPE = r13;
            JObjectType r15 = new JObjectType("DOUBLE_ARRAY_TYPE", 8);
            DOUBLE_ARRAY_TYPE = r15;
            JObjectType r14 = new JObjectType("LIST_TYPE", 9);
            LIST_TYPE = r14;
            JObjectType r12 = new JObjectType("BOOLEAN_WRAPPER_TYPE", 10);
            BOOLEAN_WRAPPER_TYPE = r12;
            JObjectType r10 = new JObjectType("INT_WRAPPER_TYPE", 11);
            INT_WRAPPER_TYPE = r10;
            JObjectType r8 = new JObjectType("LONG_WRAPPER_TYPE", 12);
            LONG_WRAPPER_TYPE = r8;
            JObjectType r6 = new JObjectType("FLOAT_WRAPPER_TYPE", 13);
            FLOAT_WRAPPER_TYPE = r6;
            JObjectType r4 = new JObjectType("DOUBLE_WRAPPER_TYPE", 14);
            DOUBLE_WRAPPER_TYPE = r4;
            a = new JObjectType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }

        public static JObjectType[] values() {
            return (JObjectType[]) a.clone();
        }

        public static JObjectType valueOf(String r1) {
            return (JObjectType) a.a(JObjectType.class, r1);
        }

        public JObjectType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxJSIObjectHub() {
        this.a = new ConcurrentHashMap();
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

    private static ILynxJSIObjectDescriptor getJSIObjectDescriptor(ILynxJSIObject r4) {
        if (b == null) goto L5;
    L14:
        LynxJSIObjectHub r1 = b;
        String r5 = r4.getClass().getName();
        ILynxJSIObjectDescriptor r2 = r1.a.get(r5);
        if (r2 == null) goto L24;
    L23:
        return r2;
    L24:
        ILynxJSIObjectDescriptor r0 = (ILynxJSIObjectDescriptor) a(r5.concat("$$Descriptor")).newInstance();     // Catch: Exception -> L18
    L20:
        r2 = r0;
        if (r2 == null) goto L23;
        r1.a.put(r5, r2);
    L18:
        e = move-exception;
        LLog.e("LynxJSIObjectHub", "getJSIObjectDescriptor failed, error: " + e + ", className: " + r5);
        r0 = null;
        goto L20
    L5:
        monitor-enter(LynxJSIObjectHub.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new LynxJSIObjectHub();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxJSIObjectHub.class);     // Catch: Throwable -> L11
        goto L14
    }

    private static int getJSIObjectFieldType(Object r1) {
        if (r1 != null) goto L6;
        return JObjectType.UNKNOWN_TYPE.ordinal();
    L6:
        if ((r1 instanceof ILynxJSIObject) == false) goto L10;
        return JObjectType.LYNX_JSI_OBJECT_TYPE.ordinal();
    L10:
        if ((r1 instanceof String) == false) goto L14;
        return JObjectType.STRING_TYPE.ordinal();
    L14:
        if ((r1 instanceof boolean[]) == false) goto L18;
        return JObjectType.BOOLEAN_ARRAY_TYPE.ordinal();
    L18:
        if ((r1 instanceof int[]) == false) goto L22;
        return JObjectType.INT_ARRAY_TYPE.ordinal();
    L22:
        if ((r1 instanceof long[]) == false) goto L26;
        return JObjectType.LONG_ARRAY_TYPE.ordinal();
    L26:
        if ((r1 instanceof float[]) == false) goto L30;
        return JObjectType.FLOAT_ARRAY_TYPE.ordinal();
    L30:
        if ((r1 instanceof double[]) == false) goto L34;
        return JObjectType.DOUBLE_ARRAY_TYPE.ordinal();
    L34:
        if (r1.getClass().isArray() == false) goto L38;
        return JObjectType.OBJECT_ARRAY_TYPE.ordinal();
    L38:
        if ((r1 instanceof List) == false) goto L42;
        return JObjectType.LIST_TYPE.ordinal();
    L42:
        if ((r1 instanceof Boolean) == false) goto L46;
        return JObjectType.BOOLEAN_WRAPPER_TYPE.ordinal();
    L46:
        if ((r1 instanceof Integer) == false) goto L50;
        return JObjectType.INT_WRAPPER_TYPE.ordinal();
    L50:
        if ((r1 instanceof Long) == false) goto L54;
        return JObjectType.LONG_WRAPPER_TYPE.ordinal();
    L54:
        if ((r1 instanceof Float) == false) goto L58;
        return JObjectType.FLOAT_WRAPPER_TYPE.ordinal();
    L58:
        if ((r1 instanceof Double) == false) goto L62;
        return JObjectType.DOUBLE_WRAPPER_TYPE.ordinal();
    L62:
        return JObjectType.UNKNOWN_TYPE.ordinal();
    }
}
