package com.obric.assistant.audio.timeout;

import android.os.Handler;
import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.service.IIdleQuiteService;
import com.obric.assistant.component.clicktalk.ChatClickTalkComponent;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J&\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/audio/timeout/IdleQuiteService;", "Lcom/obric/assistant/audio/service/IIdleQuiteService;", "<init>", "()V", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/assistant/audio/service/IdleTimeoutObserver;", "handler", "Landroid/os/Handler;", "lastArgs", "Ljava/util/concurrent/ConcurrentHashMap;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "timeoutRunnables", "Ljava/lang/Runnable;", "addObserver", NameKeys.UnloadStrategy_No_Strategy, "observer", "removeObserver", "stop", "botId", "reason", "start", "args", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdleQuiteService implements IIdleQuiteService {
    public static final /* synthetic */ int e = 0;
    public final CopyOnWriteArraySet<qba.a> a;
    public final Handler b;
    public final ConcurrentHashMap<String, Map<String, Object>> c;
    public final ConcurrentHashMap<String, Runnable> d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForegroundInteractionPhase.values().length];
            r0[ForegroundInteractionPhase.Activate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ForegroundInteractionPhase.Connecting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ForegroundInteractionPhase.Idle.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ForegroundInteractionPhase.Listen.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ForegroundInteractionPhase.Thinking.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ForegroundInteractionPhase.Generating.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ForegroundInteractionPhase.Generated.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    public IdleQuiteService() {
        this.a = new CopyOnWriteArraySet();
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        ObricInteractionProjectionDelegate.b.b(null, new rba.a(this));
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void b(ChatClickTalkComponent.e r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        FLogger.a.d("IdleQuiteService", "addObserver");
        this.a.add(r4);
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void c(ChatClickTalkComponent.e r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        FLogger.a.d("IdleQuiteService", "removeObserver");
        this.a.remove(r4);
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "botId");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Runnable r0 = this.d.remove(r5);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("stop botId=");
        r2.append(r5);
        r2.append(", reason=");
        r2.append(r6);
        r2.append(", timerActive=");
        if (r0 == null) goto L5;
        boolean r7 = true;
    L6:
        r2.append(r7);
        r1.i("IdleQuiteService", r2.toString());
        if (r0 == null) goto L9;
        this.b.removeCallbacks(r0);
    L9:
        this.c.remove(r5);
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void d(final String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        FLogger.a.i("IdleQuiteService", "start botId=" + r4 + ", timeoutMillis=7800, args=" + r5);
        Runnable r0 = this.d.remove(r4);
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
    L5:
        if (r5 == null) goto L7;
        this.c.put(r4, r5);
    L7:
        Runnable r6 = new rba.b(this, r4);
        this.d.put(r4, r6);
        this.b.postDelayed(r6, 7800);
    }
}
