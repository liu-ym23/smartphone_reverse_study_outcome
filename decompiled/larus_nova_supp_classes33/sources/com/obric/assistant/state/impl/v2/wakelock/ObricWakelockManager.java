package com.obric.assistant.state.impl.v2.wakelock;

import android.os.PowerManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricWakelockManager {
    public static final ObricWakelockManager a = null;
    public static final String b = null;
    public static final CoroutineScope c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static int f;
    public static final ConcurrentHashMap<LockReason, Integer> g = null;
    public static final ObricWakelockTimeoutHandler h = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/state/impl/v2/wakelock/ObricWakelockManager$ForceReleaseWakelockReason;", "", "<init>", "(Ljava/lang/String;I)V", "ON_APP_BACKGROUND", "ON_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ForceReleaseWakelockReason extends Enum<ForceReleaseWakelockReason> {
        public static final ForceReleaseWakelockReason ON_APP_BACKGROUND = null;
        public static final ForceReleaseWakelockReason ON_TIMEOUT = null;
        public static final /* synthetic */ ForceReleaseWakelockReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ForceReleaseWakelockReason> getEntries() {
            return b;
        }

        static {
            ForceReleaseWakelockReason r0 = new ForceReleaseWakelockReason("ON_APP_BACKGROUND", 0);
            ON_APP_BACKGROUND = r0;
            ForceReleaseWakelockReason r1 = new ForceReleaseWakelockReason("ON_TIMEOUT", 1);
            ON_TIMEOUT = r1;
            ForceReleaseWakelockReason[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ForceReleaseWakelockReason[] values() {
            return (ForceReleaseWakelockReason[]) a.clone();
        }

        public static ForceReleaseWakelockReason valueOf(String r1) {
            return (ForceReleaseWakelockReason) r27.a.a(ForceReleaseWakelockReason.class, r1);
        }

        public ForceReleaseWakelockReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/impl/v2/wakelock/ObricWakelockManager$LockReason;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_TALK", "SEND_MSG", "RECEIVE_MSG", "TTS_PLAYING", "WAKEUP_IN_PROGRESS", "AUTO_DISMISS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LockReason extends Enum<LockReason> {
        public static final LockReason AUTO_DISMISS = null;
        public static final LockReason CLICK_TALK = null;
        public static final LockReason RECEIVE_MSG = null;
        public static final LockReason SEND_MSG = null;
        public static final LockReason TTS_PLAYING = null;
        public static final LockReason WAKEUP_IN_PROGRESS = null;
        public static final /* synthetic */ LockReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LockReason> getEntries() {
            return b;
        }

        static {
            LockReason r0 = new LockReason("CLICK_TALK", 0);
            CLICK_TALK = r0;
            LockReason r1 = new LockReason("SEND_MSG", 1);
            SEND_MSG = r1;
            LockReason r3 = new LockReason("RECEIVE_MSG", 2);
            RECEIVE_MSG = r3;
            LockReason r5 = new LockReason("TTS_PLAYING", 3);
            TTS_PLAYING = r5;
            LockReason r7 = new LockReason("WAKEUP_IN_PROGRESS", 4);
            WAKEUP_IN_PROGRESS = r7;
            LockReason r9 = new LockReason("AUTO_DISMISS", 5);
            AUTO_DISMISS = r9;
            LockReason[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static LockReason[] values() {
            return (LockReason[]) a.clone();
        }

        public static LockReason valueOf(String r1) {
            return (LockReason) r27.a.a(LockReason.class, r1);
        }

        public LockReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAppForeground() {
        }

        public final void onAllActivityDestroyed() {
            FLogger.a.i(ObricWakelockManager.b, "lock=wake action=lifecycle event=all_activity_destroyed");
            ObricWakelockManager r0 = ObricWakelockManager.a;
            ForceReleaseWakelockReason r1 = ForceReleaseWakelockReason.ON_APP_BACKGROUND;
            r0.getClass();
            ObricWakelockManager.b(r1);
        }

        public final void onAppBackground() {
            FLogger.a.i(ObricWakelockManager.b, "lock=wake action=lifecycle event=app_background");
            ObricWakelockManager r0 = ObricWakelockManager.a;
            ForceReleaseWakelockReason r1 = ForceReleaseWakelockReason.ON_APP_BACKGROUND;
            r0.getClass();
            ObricWakelockManager.b(r1);
        }
    }

    public ObricWakelockManager() {
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.assistant.state.impl.v2.wakelock.d] */
    static {
        a = new ObricWakelockManager();
        b = ObricWakelockManager.class.getSimpleName();
        c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.obric.assistant.state.impl.v2.wakelock.a())));
        d = LazyKt.lazy(new b());
        e = LazyKt.lazy(new c());
        a r0 = new a();
        g = new ConcurrentHashMap();
        new ReentrantLock();
        AppHost.a.a().j(r0);
        h = new ObricWakelockTimeoutHandler(new d());
    }

    public static PowerManager.WakeLock c() {
        return (PowerManager.WakeLock) e.getValue();
    }

    public static void a(LockReason r7) {
        Intrinsics.checkNotNullParameter(r7, WindowEvent.Params.REASON);
        BuildersKt.launch$default(c, null, null, new ObricWakelockManager$acquireWakeLock$1(r7, null), 3, null);
    }

    public static void b(ForceReleaseWakelockReason r7) {
        Intrinsics.checkNotNullParameter(r7, WindowEvent.Params.REASON);
        BuildersKt.launch$default(c, null, null, new ObricWakelockManager$forceReleaseWakeLock$1(r7, null), 3, null);
    }

    public static void d(ObricWakelockManager r6, LockReason r7) {
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, WindowEvent.Params.REASON);
        BuildersKt.launch$default(c, null, null, new ObricWakelockManager$releaseWakeLock$1(r7, 0, null), 3, null);
    }
}
