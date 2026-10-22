package com.obric.common.oea.foundation.blur;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BlurUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Method> f7729a;

    public static final enum BLEND_MODE extends Enum<BLEND_MODE> {
        private static final /* synthetic */ BLEND_MODE[] $VALUES = null;
        public static final BLEND_MODE COLOR_BURN = null;
        public static final BLEND_MODE COLOR_DODGE = null;
        public static final BLEND_MODE DEFAULT = null;
        public static final BLEND_MODE LUMINOSITY = null;
        public static final BLEND_MODE OVERLAY = null;
        public static final BLEND_MODE PLUS_DARKER = null;
        public static final BLEND_MODE PLUS_LIGHTER = null;
        public static final BLEND_MODE SOFT_LIGHT = null;

        static {
            BLEND_MODE r0 = new BLEND_MODE("DEFAULT", 0);
            DEFAULT = r0;
            BLEND_MODE r1 = new BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r1;
            BLEND_MODE r3 = new BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r3;
            BLEND_MODE r5 = new BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r5;
            BLEND_MODE r7 = new BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r7;
            BLEND_MODE r9 = new BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r9;
            BLEND_MODE r11 = new BLEND_MODE("OVERLAY", 6);
            OVERLAY = r11;
            BLEND_MODE r13 = new BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r13;
            $VALUES = new BLEND_MODE[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private BLEND_MODE(String r1, int r2) {
            super(r1, r2);
        }

        public static BLEND_MODE valueOf(String r2) {
            return (BLEND_MODE) ZeusTransformUtils.preCheckCast(Enum.valueOf(BLEND_MODE.class, r2), BLEND_MODE.class, "com.obric.memorydata.plugin");
        }

        public static BLEND_MODE[] values() {
            return (BLEND_MODE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BLEND_MODE[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum BlurType extends Enum<BlurType> {
        private static final /* synthetic */ BlurType[] $VALUES = null;
        public static final BlurType NONE = null;
        public static final BlurType NORMAL_BLUR = null;
        public static final BlurType PROGRESS_BLUR_DOWN_UP = null;
        public static final BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
        public static final BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
        public static final BlurType PROGRESS_BLUR_UP_DOWN = null;

        static {
            BlurType r0 = new BlurType("NONE", 0);
            NONE = r0;
            BlurType r1 = new BlurType("NORMAL_BLUR", 1);
            NORMAL_BLUR = r1;
            BlurType r3 = new BlurType("PROGRESS_BLUR_DOWN_UP", 2);
            PROGRESS_BLUR_DOWN_UP = r3;
            BlurType r5 = new BlurType("PROGRESS_BLUR_UP_DOWN", 3);
            PROGRESS_BLUR_UP_DOWN = r5;
            BlurType r7 = new BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
            PROGRESS_BLUR_LEFT_RIGHT = r7;
            BlurType r9 = new BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
            PROGRESS_BLUR_RIGHT_LEFT = r9;
            $VALUES = new BlurType[]{r0, r1, r3, r5, r7, r9};
        }

        private BlurType(String r1, int r2) {
            super(r1, r2);
        }

        public static BlurType valueOf(String r2) {
            return (BlurType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlurType.class, r2), BlurType.class, "com.obric.memorydata.plugin");
        }

        public static BlurType[] values() {
            return (BlurType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlurType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f7729a = new HashMap();
    }

    private static Object a(View r4) {
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(f7729a.get("getExt"), Method.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
    L5:
        return r0.invoke(r4, new Object[0]);
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        r0 = NativeReflect.a(View.class, "getExt", new Class[0]);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        f7729a.put("getExt", r0);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        goto L5
    }

    private static void a(View r9, int r10, float r11, int... r12) {
        Object r13 = a(r9);
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(f7729a.get("setBackdropBlurEffect"), Method.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
    L5:
        r0.invoke(r13, new Object[]{Integer.valueOf(r10), Float.valueOf(r11), r12});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        return;
    L14:
        r0 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtView", "com.obric.memorydata.plugin"), "setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        f7729a.put("setBackdropBlurEffect", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        goto L5
    }

    public static void a(View r0, BlurType r1, float r2, int... r3) {
        a(r0, r1.ordinal() - 1, r2, r3);
    }
}
