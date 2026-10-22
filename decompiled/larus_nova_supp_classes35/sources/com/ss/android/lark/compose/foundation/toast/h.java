package com.ss.android.lark.compose.foundation.toast;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Handler.Callback {
        public final Handler a;

        public a(Handler r2) {
            Intrinsics.checkNotNullParameter(r2, "mHandler");
            this.a = r2;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a.handleMessage(r2);     // Catch: Throwable -> L5
            return true;
        L5:
            th = move-exception;
            th.printStackTrace();
            return true;
        }
    }

    public static final class b implements Runnable {
        public final Runnable a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "mRunnable");
            this.a = r2;
        }
    }

    static {
    }

    public static Object a(Object r3, String r4) {
        Class<?> r0 = r3.getClass();
    L4:
        if (r0 == null) goto L10;
        if (Intrinsics.areEqual(r0, Object.class) == true) goto L10;
        Field r5 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L9
    L11:
        if (r5 == null) goto L27;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        if (r5.isAccessible() == true) goto L15;
        r5.setAccessible(true);     // Catch: Exception -> L17
    L15:
        return r5.get(r3);
    L27:
        return null;
    L9:
        r0 = r0.getSuperclass();
    L10:
        r5 = null;
        goto L11
    }

    public static boolean b(Object r3, String r4, Object r5) {
        Class<?> r0 = r3.getClass();
    L3:
        if (r0 == null) goto L9;
        if (Intrinsics.areEqual(r0, Object.class) == true) goto L9;
        Field r6 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L8
    L10:
        if (r6 == null) goto L30;
    L19:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        if (Modifier.isFinal(r6.getModifiers()) == false) goto L15;
        Field r1 = Field.class.getDeclaredField("accessFlags");     // Catch: Exception -> L19
        r1.setAccessible(true);     // Catch: Exception -> L19
        r1.setInt(r6, r6.getModifiers() & (-17));     // Catch: Exception -> L19
    L15:
        if (r6.isAccessible() == true) goto L17;
        r6.setAccessible(true);     // Catch: Exception -> L19
    L17:
        r6.set(r3, r5);     // Catch: Exception -> L19
        return true;
    L30:
        return false;
    L8:
        r0 = r0.getSuperclass();
    L9:
        r6 = null;
        goto L10
    }
}
