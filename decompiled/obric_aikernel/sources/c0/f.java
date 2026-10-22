package c0;

import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    static Intent a(Message r10) {
        Object r11 = r10.obj;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L5;
    L10:
        if (r12 >= 28) goto L12;
        return null;
    L12:
        if (r10.what != 159) goto L32;
        List r13 = (List) x3.b.c(r11, "mActivityCallbacks");     // Catch: IllegalAccessException -> L8
        if (r13 == null) goto L33;
        int r14 = 0;
    L17:
        if (r14 >= r13.size()) goto L34;
        Object r15 = r13.get(r14);     // Catch: IllegalAccessException -> L8
        if (r15 == null) goto L23;
        Intent r16 = (Intent) x3.b.c(r15, "mIntent");     // Catch: IllegalAccessException -> L8
        if (r16 == null) goto L23;
        return r16;
    L23:
        r14 = r14 + 1;
        goto L17
    L34:
        return null;
    L33:
        return null;
    L32:
        return null;
    L5:
        if (r10.what != 100) goto L10;
        return (Intent) x3.b.c(r11, "intent");
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static Intent b(Message r10) {
        int r11 = r10.what;
        if (r11 == 100) goto L16;
        if (r11 == 121) goto L14;
        if (r11 == 159) goto L16;
        switch(r11) {
            case 113: goto L12;
            case 114: goto L14;
            case 115: goto L14;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return d(r10);
    L14:
        return e(r10);
    L16:
        return a(r10);
    }

    public static Intent c() {
        MessageQueue r10 = (MessageQueue) x3.b.c(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L39
        monitor-enter(r10);     // Catch: Throwable -> L39
        Message r11 = (Message) x3.b.c(r10, "mMessages");     // Catch: Throwable -> L36
        if (r11 != null) goto L7;
    L18:
        Field r12 = x3.b.a(Message.class, "next");     // Catch: Throwable -> L36
        r12.setAccessible(true);     // Catch: Throwable -> L36
    L19:
        if (r11 == null) goto L34;
        r11 = (Message) x3.b.d(r12, r11);     // Catch: Throwable -> L36
        if (r11 == null) goto L19;
        if (r11.getTarget() != x3.a.f()) goto L19;
        if (x3.a.h(r11) == false) goto L19;
        int r13 = r11.what;     // Catch: Throwable -> L36
        if (r13 == 100) goto L30;
        if (r13 != 159) goto L19;
    L30:
        Intent r14 = b(r11);     // Catch: Throwable -> L36
        if (r14 == null) goto L19;
        monitor-exit(r10);     // Catch: Throwable -> L36
        return r14;
    L34:
        monitor-exit(r10);     // Catch: Throwable -> L36
        return null;
    L7:
        if (r11.getTarget() != x3.a.f()) goto L18;
        if (x3.a.h(r11) == false) goto L18;
        int r15 = r11.what;     // Catch: Throwable -> L36
        if (r15 == 100) goto L14;
        if (r15 != 159) goto L18;
    L14:
        Intent r16 = b(r11);     // Catch: Throwable -> L36
        if (r16 == null) goto L18;
        monitor-exit(r10);     // Catch: Throwable -> L36
        return r16;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    static Intent d(Message r10) {
        if (r10.what != 113) goto L5;
        String r11 = "intent";
    L7:
        if (r11.isEmpty() == true) goto L18;
        Object r12 = r10.obj;
        if (r12 == null) goto L19;
        return (Intent) x3.b.c(r12, r11);
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    L18:
        return null;
    L5:
        r11 = "";
        goto L7
    }

    static Intent e(Message r10) {
        int r11 = r10.what;
        if (r11 != 114) goto L5;
    L11:
        String r12 = "intent";
    L13:
        if (r12.isEmpty() == true) goto L24;
        Object r13 = r10.obj;
        if (r13 == null) goto L25;
        return (Intent) x3.b.c(r13, r12);
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L25:
        return null;
    L24:
        return null;
    L5:
        if (r11 == 121) goto L11;
        if (r11 != 115) goto L10;
        r12 = "args";
        goto L13
    L10:
        r12 = "";
        goto L13
    }
}
