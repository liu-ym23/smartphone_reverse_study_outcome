package com.obric.assistant.view.listening;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.component.ObricIntercomComponent$f;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.ObricVoiceServiceImpl$b;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import laa.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final AtomicLong l = null;
    public final CoroutineScope a;
    public final Function1<Runnable, Unit> b;
    public final b c;
    public boolean d;
    public com.obric.assistant.view.listening.b e;
    public ObricListeningVisualMode f;
    public ObricListeningVisualMode g;
    public Job h;
    public final ConcurrentHashMap.KeySetView<com.obric.assistant.view.listening.b, Boolean> i;
    public boolean j;
    public final h k;

    public static final class a {
    }

    public interface b {
        void a();

        void b(ArrayList<Double> r1);

        void c();

        boolean isAvailable();
    }

    static {
        l = new AtomicLong(0);
    }

    public static com.obric.assistant.view.listening.a a() {
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 != null) goto L5;
        return null;
    L5:
        ObricVoiceServiceImpl$b r1 = r0.f();
        if (r1 != null) goto L9;
        return null;
    L9:
        if (sha.b.b() == true) goto L12;
        return null;
    L12:
        return new com.obric.assistant.view.listening.a(r1);
    }

    public final com.obric.assistant.view.listening.b b() {
        com.obric.assistant.view.listening.b r0 = a();
        if (r0 != null) goto L12;
        com.obric.assistant.view.listening.b r1 = this.e;
        if ((r1 instanceof i) == false) goto L8;
        r0 = (i) r1;
    L9:
        if (r0 != null) goto L12;
        r0 = new i(l.incrementAndGet());
        goto L12
    L8:
        r0 = null;
    L12:
        this.i.add(r0);
        return r0;
    }

    public final com.obric.assistant.view.listening.b d(n r3) {
        if ((r3 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r4 = (com.obric.assistant.view.listening.b) r3;
    L6:
        if (r4 != null) goto L9;
        return null;
    L9:
        if ((r4 instanceof com.obric.assistant.view.listening.a) == true) goto L11;
    L19:
        return r4;
    L11:
        if (this.j == true) goto L19;
        if (((com.obric.assistant.view.listening.a) r4).a.isActive() == true) goto L19;
        if ((this.e instanceof i) == false) goto L17;
    L18:
        return null;
    L17:
        if (a() != null) goto L19;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(n r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "handle");
        Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.REASON);
        if ((r7 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r9 = (com.obric.assistant.view.listening.b) r7;
    L6:
        if (r9 != null) goto L9;
        return;
    L9:
        if ((r9 instanceof i) == false) goto L12;
        FLogger.a.i("ObricListeningViewController", "finish local listening handle, reason=" + r8 + ", generation=" + ((i) r9).a);
    L14:
        this.i.remove(r9);
        if (Intrinsics.areEqual(this.e, r9) == false) goto L20;
        this.e = null;
        return;
    L20:
        return;
    L12:
        if ((r9 instanceof com.obric.assistant.view.listening.a) == false) goto L19;
        FLogger.a.i("ObricListeningViewController", "publish hidden delegated listening state, reason=".concat(r8));
        ((com.obric.assistant.view.listening.a) r9).a.finish();
        goto L14
    L19:
        throw new NoWhenBranchMatchedException();
    L5:
        r9 = null;
        goto L6
    }

    public final boolean e(com.obric.assistant.view.listening.b r7, double r8) {
        if (r7 != null) goto L5;
    L11:
        return false;
    L5:
        if ((r7 instanceof i) == false) goto L13;
        com.obric.assistant.view.listening.b r9 = this.e;
        if (r9 == null) goto L11;
        if (Intrinsics.areEqual(r9, r7) == true) goto L11;
        return true;
    L13:
        if ((r7 instanceof com.obric.assistant.view.listening.a) == false) goto L30;
        com.obric.assistant.view.listening.a r0 = (com.obric.assistant.view.listening.a) r7;
        if (r0.a.b() == true) goto L17;
        return true;
    L17:
        if (r0.a.isActive() == true) goto L20;
        return true;
    L20:
        if (Intrinsics.areEqual(this.e, r7) == false) goto L22;
        ObricListeningVisualMode r10 = this.f;
    L23:
        com.obric.assistant.voice.d r2 = r0.a;
        if (r8 <= 0.5d) goto L26;
        double r11 = 1.0d;
    L27:
        r2.a(new ObricListeningViewState(r10, true, RangesKt.coerceIn(((float) r11) * 2.5f, 0.0f, 1.0f)));
        r0.a.confirmListeningStarted();
        return true;
    L26:
        r11 = Math.sin(RangesKt.coerceAtLeast(r8, 0.0d) * 3.141592653589793d);
        goto L27
    L22:
        r10 = ObricListeningVisualMode.CLICK_TALK;
        goto L23
    L30:
        throw new NoWhenBranchMatchedException();
    }

    public f(LifecycleCoroutineScope r2, Function1 r3, ObricIntercomComponent$f r4) {
        Intrinsics.checkNotNullParameter(r2, "coroutineScope");
        Intrinsics.checkNotNullParameter(r3, "runOnUiThread");
        Intrinsics.checkNotNullParameter(r4, "host");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = ObricListeningVisualMode.CLICK_TALK;
        this.i = ConcurrentHashMap.newKeySet();
        this.k = new h(this);
    }

    public final void g(ObricListeningVisualMode r8, String r9, Function0<Boolean> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r10, "renderLocal");
        Intrinsics.checkNotNullParameter(r11, "onVisible");
        f(b(), r8, r9, r10, r11);
    }

    public final void f(n r6, ObricListeningVisualMode r7, String r8, Function0<Boolean> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "handle");
        Intrinsics.checkNotNullParameter(r7, "mode");
        Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r9, "renderLocal");
        Intrinsics.checkNotNullParameter(r10, "onVisible");
        if ((r6 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r11 = (com.obric.assistant.view.listening.b) r6;
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11 instanceof i) == false) goto L16;
        if (((Boolean) r9.invoke()).booleanValue() == true) goto L14;
        FLogger.a.i("ObricListeningViewController", "skip unavailable local listening View, reason=" + r8 + ", generation=" + ((i) r11).a + ", mode=" + r7);
        return;
    L14:
        this.i.add(r11);
        this.e = r11;
        this.f = r7;
        r10.invoke();
        return;
    L16:
        if ((r11 instanceof com.obric.assistant.view.listening.a) == false) goto L29;
        ObricListeningVisualMode r12 = this.g;
        ObricListeningVisualMode r0 = ObricListeningVisualMode.PRESS_TALK;
        if (r12 == r0) goto L20;
    L22:
        r0 = r7;
    L23:
        com.obric.assistant.view.listening.a r13 = (com.obric.assistant.view.listening.a) r11;
        if (r13.a.isActive() == true) goto L26;
        FLogger.a.i("ObricListeningViewController", "drop stale delegated visible state, reason=" + r8 + ", mode=" + r0);
        return;
    L26:
        this.e = r11;
        this.f = r0;
        this.g = r0;
        FLogger.a.i("ObricListeningViewController", "publish delegated listening state, reason=" + r8 + ", requestedMode=" + r7 + ", mode=" + r0);
        r13.a.a(new ObricListeningViewState(r0, true, 0.0f));
        r10.invoke();
        return;
    L20:
        if (r7 != ObricListeningVisualMode.CLICK_TALK) goto L22;
    L29:
        throw new NoWhenBranchMatchedException();
    L5:
        r11 = null;
        goto L6
    }
}
