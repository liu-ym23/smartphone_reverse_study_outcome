package com.obric.common.oea.foundation.blur;

import android.annotation.SuppressLint;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class BlurUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Method> f5629a;

    public static final enum BlurType extends Enum<BlurType> {
        private static final /* synthetic */ BlurType[] $VALUES = null;
        public static final BlurType NONE = null;
        public static final BlurType NORMAL_BLUR = null;
        public static final BlurType PROGRESS_BLUR_DOWN_UP = null;
        public static final BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
        public static final BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
        public static final BlurType PROGRESS_BLUR_UP_DOWN = null;

        static {
            BlurType r10 = new BlurType("NONE", 0);
            NONE = r10;
            BlurType r11 = new BlurType("NORMAL_BLUR", 1);
            NORMAL_BLUR = r11;
            BlurType r12 = new BlurType("PROGRESS_BLUR_DOWN_UP", 2);
            PROGRESS_BLUR_DOWN_UP = r12;
            BlurType r13 = new BlurType("PROGRESS_BLUR_UP_DOWN", 3);
            PROGRESS_BLUR_UP_DOWN = r13;
            BlurType r14 = new BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
            PROGRESS_BLUR_LEFT_RIGHT = r14;
            BlurType r15 = new BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
            PROGRESS_BLUR_RIGHT_LEFT = r15;
            $VALUES = new BlurType[]{r10, r11, r12, r13, r14, r15};
        }

        private BlurType(String r10, int r11) {
            super(r10, r11);
        }

        public static BlurType valueOf(String r10) {
            return (BlurType) Enum.valueOf(BlurType.class, r10);
        }

        public static BlurType[] values() {
            return (BlurType[]) $VALUES.clone();
        }
    }

    static {
        f5629a = new HashMap();
    }

    private static void a(View r10, int r11, float r12) {
        Method r13 = f5629a.get("setBackdropBlurEffect");
        if (r13 == null) goto L12;
    L5:
        r13.invoke(r10, new Object[]{Integer.valueOf(r11), Float.valueOf(r12)});     // Catch: InvocationTargetException -> L7 Throwable -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        return;
    L12:
        r13 = NativeReflect.a(View.class, "setBackdropBlurEffect", new Class[]{Integer.TYPE, Float.TYPE});     // Catch: InvocationTargetException -> L7 Throwable -> L9
        r13.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        f5629a.put("setBackdropBlurEffect", r13);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        goto L5
    }

    public static void b(View r10, BlurType r11, float r12) {
        a(r10, r11.ordinal() - 1, r12);
    }
}
