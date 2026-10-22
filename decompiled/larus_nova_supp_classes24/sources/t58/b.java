package t58;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import kotlin.Lazy;
import kotlin.LazyKt;
import m58.h;
import m58.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static boolean a(Lifecycle r7) {
        m58.b r0 = h.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        m58.b r3 = h.k;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        Boolean r5 = null;
        if (r7 == null) goto L26;
        m58.b r6 = h.k;
        if (r6 == null) goto L19;
        Activity r8 = r6.currentActivity();
    L21:
        if ((r8 instanceof AppCompatActivity) == false) goto L23;
        AppCompatActivity r9 = (AppCompatActivity) r8;
    L24:
        if (r9 == null) goto L26;
        Lifecycle r10 = r9.getLifecycle();
    L27:
        if (r2 == true) goto L54;
        if (r4 == false) goto L37;
        o r11 = h.n;
        if (r11 != null) goto L32;
    L34:
        boolean r12 = false;
    L35:
        if (r12 == false) goto L37;
    L52:
        r1 = true;
    L55:
        if (r1 == true) goto L60;
        int r13 = c68.b.a;
        StringBuilder r14 = new StringBuilder("[TTS][LIFECYCLE_NOT_MATCH] checkTTSLifecycle , isAppBackground : ");
        r14.append(r2);
        r14.append(", isPageResumed : ");
        r14.append(b(r7));
        r14.append(", isAppPaused : ");
        r14.append(r4);
        r14.append(", enableTtsWhenAppPaused : ");
        o r15 = h.n;
        if (r15 == null) goto L59;
        r5 = Boolean.valueOf(r15.e());
    L59:
        r14.append(r5);
        c68.b.b("AppBackgroundExt", r14.toString());
    L60:
        return r1;
    L32:
        if (r11.e() != true) goto L34;
        r12 = true;
    L37:
        m58.b r16 = h.k;
        if (r16 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        if (r17 == true) goto L45;
        r1 = b(r7);
        goto L55
    L45:
        if (b(r7) == true) goto L52;
        if (r10 != null) goto L48;
    L50:
        boolean r19 = false;
    L51:
        if (r19 == false) goto L55;
    L48:
        if (b(r10) != true) goto L50;
        r19 = true;
        goto L51
    L40:
        if (r16.a() != true) goto L42;
        r17 = true;
        goto L43
    L54:
        r1 = ((Boolean) a.getValue()).booleanValue();
        goto L55
    L23:
        r9 = null;
        goto L24
    L19:
        r8 = null;
    L26:
        r10 = null;
        goto L27
    L11:
        if (r3.isAppPaused() != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.isAppBackground() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static boolean b(Lifecycle r2) {
        if (r2 != null) goto L14;
        m58.b r3 = h.k;
        if (r3 == null) goto L6;
        Activity r4 = r3.currentActivity();
    L8:
        if ((r4 instanceof AppCompatActivity) == false) goto L10;
        AppCompatActivity r5 = (AppCompatActivity) r4;
    L11:
        if (r5 == null) goto L13;
        r2 = r5.getLifecycle();
        goto L14
    L13:
        r2 = null;
        goto L14
    L10:
        r5 = null;
        goto L11
    L6:
        r4 = null;
    L14:
        if (r2 == null) goto L18;
        Lifecycle.State r6 = r2.getCurrentState();
        if (r6 == null) goto L18;
        return r6.isAtLeast(Lifecycle.State.RESUMED);
    L18:
        return false;
    }
}
