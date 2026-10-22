package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WindowUtils {
    private static final String TAG = "WindowUtils";

    public static class Api14Impl {
        private Api14Impl() {
        }

        @NonNull
        public static Rect getCurrentWindowBounds(@NonNull WindowManager r5) {
            Display r10 = r5.getDefaultDisplay();
            Point r11 = getRealSizeForDisplay(r10);
            Rect r12 = new Rect();
            int r13 = r11.x;
            if (r13 == 0) goto L8;
            int r14 = r11.y;
            if (r14 == 0) goto L8;
            r12.right = r13;
            r12.bottom = r14;
        L9:
            return r12;
        L8:
            r10.getRectSize(r12);
            goto L9
        }

        private static Point getRealSizeForDisplay(Display r5) {
            Point r10 = new Point();
            Method r11 = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
            r11.setAccessible(true);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
            r11.invoke(r5, new Object[]{r10});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
        L14:
            return r10;
        L7:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
        L9:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
        L5:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
            goto L14
        }
    }

    @RequiresApi(api = 17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @NonNull
        public static Rect getCurrentWindowBounds(@NonNull WindowManager r5) {
            Display r10 = r5.getDefaultDisplay();
            Point r11 = new Point();
            r10.getRealSize(r11);
            Rect r12 = new Rect();
            r12.right = r11.x;
            r12.bottom = r11.y;
            return r12;
        }
    }

    @RequiresApi(api = 30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        public static Rect getCurrentWindowBounds(@NonNull WindowManager r5) {
            return r5.getCurrentWindowMetrics().getBounds();
        }
    }

    private WindowUtils() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    @NonNull
    public static Rect getCurrentWindowBounds(@NonNull Context r5) {
        return Api30Impl.getCurrentWindowBounds((WindowManager) r5.getSystemService("window"));
    }
}
