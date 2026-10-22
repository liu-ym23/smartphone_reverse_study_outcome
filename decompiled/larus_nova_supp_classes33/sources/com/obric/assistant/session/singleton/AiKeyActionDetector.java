package com.obric.assistant.session.singleton;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.larus.audio.utils.g1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AiKeyActionDetector {
    public static final AiKeyActionDetector a = null;
    public static final Handler b = null;
    public static a c;
    public static Bundle d;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public interface a {
        void a(Bundle r1);

        void b(String r1);

        void c();

        void g();

        void i();

        void j();

        void k();

        void l();

        void o();

        void q();
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricAiKeyGestureAction.values().length];
            r0[ObricAiKeyGestureAction.DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L53:
            r0[ObricAiKeyGestureAction.LONG_PRESS_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L63:
            r0[ObricAiKeyGestureAction.SINGLE_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[ObricAiKeyGestureAction.DOUBLE_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L41:
            r0[ObricAiKeyGestureAction.PRESS_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L51:
            r0[ObricAiKeyGestureAction.SHORT_PRESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L61:
            r0[ObricAiKeyGestureAction.LONG_PRESS_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L45:
            r0[ObricAiKeyGestureAction.LONG_PRESS_STOP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L55:
            r0[ObricAiKeyGestureAction.CANCEL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L57:
            r0[ObricAiKeyGestureAction.TIMEOUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L16:
            a = r0;
            int[] r1 = new int[ObricAiKeyGestureState.values().length];
            r1[ObricAiKeyGestureState.FIRST_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L49:
            r1[ObricAiKeyGestureState.PRESS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L59:
            r1[ObricAiKeyGestureState.SECOND_DOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L37:
            r1[ObricAiKeyGestureState.LONG_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L21:
            b = r1;
        }
    }

    public AiKeyActionDetector() {
    }

    static {
        a = new AiKeyActionDetector();
        Handler r0 = g1.a;
        b = g1.a;
        e = LazyKt.lazy(new com.obric.assistant.session.singleton.a());
        f = LazyKt.lazy(new com.obric.assistant.session.singleton.b());
    }

    public static long a(Bundle r5) {
        Long r6 = Long.valueOf(r5.getLong("android.intent.extra.TIME", -1));
        if (r6.longValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L12;
        return r6.longValue();
    L12:
        return SystemClock.uptimeMillis();
    L5:
        r0 = false;
        goto L6
    }

    public static void b(Bundle r4) {
        FLogger.a.i("AiKeyActionDetector", "onKeyCancel");
        com.obric.assistant.common.utils.i.a r0 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyCancel");
        a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f.getValue()).f(a(r4));     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r0 == null) goto L13;
        r0.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        throw th;
    }

    public static void c(Bundle r4) {
        FLogger.a.i("AiKeyActionDetector", "onKeyDown");
        d = r4;
        com.obric.assistant.common.utils.i.a r0 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyDown");
        a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f.getValue()).g(a(r4));     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r0 == null) goto L13;
        r0.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        throw th;
    }

    public static void d(Bundle r4) {
        FLogger.a.i("AiKeyActionDetector", "onKeyUp");
        com.obric.assistant.common.utils.i.a r0 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyUp");
        a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f.getValue()).h(a(r4));     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r0 == null) goto L13;
        r0.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        throw th;
    }

    public static void e(int r2, String r3, String r4) {
        JSONObject r5 = new JSONObject().put("press_type", r3).put("end_reason", r4).put("keyguard_locked", IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        ILaunchMethodOperation r6 = bga.g.a();
        if (r6 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        r6.c(r2, r5);
        return;
    }
}
