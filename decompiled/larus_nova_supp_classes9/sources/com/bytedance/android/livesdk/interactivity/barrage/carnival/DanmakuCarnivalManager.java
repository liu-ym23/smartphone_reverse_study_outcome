package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.ChatCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ShowFinishType;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import f52.j;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r52.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DanmakuCarnivalManager implements o22.d, f52.e {
    public static final /* synthetic */ int y = 0;
    public final o a;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.b b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public com.bytedance.android.livesdk.interactivity.api.barrage.model.a h;
    public final Lazy i;
    public f52.b j;
    public a k;
    public final Handler l;
    public o22.c m;
    public Disposable n;
    public Disposable o;
    public long p;
    public Disposable q;
    public boolean r;
    public final e s;
    public final d t;
    public final c u;
    public final StateMachine<State, Event, SideEffect> v;
    public final String w;
    public final DataCenter x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", BuildConfig.FLAVOR, "()V", "toString", BuildConfig.FLAVOR, "Carnival", "Countdown", "End", "Start", "StartEnd", "Stop", "WarmUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Carnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$End;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$StartEnd;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Stop;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$WarmUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class Event {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Carnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Carnival extends Event {
            public static final Carnival INSTANCE = null;

            private Carnival() {
                super(null);
            }

            static {
                INSTANCE = new Carnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "directIn", BuildConfig.FLAVOR, "(Z)V", "getDirectIn", "()Z", "component1", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Countdown extends Event {
            private final boolean directIn;

            public static /* synthetic */ Countdown copy$default(Countdown r0, boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.directIn;
            L6:
                return r0.copy(r1);
            }

            public final boolean component1() {
                return this.directIn;
            }

            public final Countdown copy(boolean r2) {
                return new Countdown(r2);
            }

            public boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof Countdown) == true) goto L6;
                return false;
            L6:
                if (this.directIn == ((Countdown) r2).directIn) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                boolean r0 = this.directIn;
                if (r0 == false) goto L6;
                return 1;
            L6:
                return r0 ? 1 : 0;
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.Event
            public String toString() {
                return "Countdown(directIn=" + this.directIn + ")";
            }

            public final boolean getDirectIn() {
                return this.directIn;
            }

            public Countdown(boolean r2) {
                super(null);
                this.directIn = r2;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$End;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class End extends Event {
            public static final End INSTANCE = null;

            private End() {
                super(null);
            }

            static {
                INSTANCE = new End();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "component1", "msg", "copy", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "getMsg", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Start extends Event {
            private final com.bytedance.android.livesdk.interactivity.api.barrage.model.a msg;

            public static /* synthetic */ Start copy$default(Start r0, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.msg;
            L6:
                return r0.copy(r1);
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a component1() {
                return this.msg;
            }

            public final Start copy(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                return new Start(r2);
            }

            public boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof Start) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.msg, ((Start) r2).msg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = this.msg;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.Event
            public String toString() {
                return "Start(msg=" + this.msg + ")";
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getMsg() {
                return this.msg;
            }

            public Start(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                super(null);
                this.msg = r2;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$StartEnd;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StartEnd extends Event {
            public static final StartEnd INSTANCE = null;

            private StartEnd() {
                super(null);
            }

            static {
                INSTANCE = new StartEnd();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Stop;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Stop extends Event {
            public static final Stop INSTANCE = null;

            private Stop() {
                super(null);
            }

            static {
                INSTANCE = new Stop();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$WarmUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmUp extends Event {
            public static final WarmUp INSTANCE = null;

            private WarmUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmUp();
            }
        }

        private Event() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ Event(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", BuildConfig.FLAVOR, "()V", "toString", BuildConfig.FLAVOR, "EndingCarnival", "InCarnival", "StartCountdown", "Started", "StopCarnival", "WarmingUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$EndingCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StartCountdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$Started;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StopCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$WarmingUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class SideEffect {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$EndingCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class EndingCarnival extends SideEffect {
            public static final EndingCarnival INSTANCE = null;

            private EndingCarnival() {
                super(null);
            }

            static {
                INSTANCE = new EndingCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class InCarnival extends SideEffect {
            public static final InCarnival INSTANCE = null;

            private InCarnival() {
                super(null);
            }

            static {
                INSTANCE = new InCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StartCountdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "directIn", BuildConfig.FLAVOR, "(Z)V", "getDirectIn", "()Z", "component1", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StartCountdown extends SideEffect {
            private final boolean directIn;

            public static /* synthetic */ StartCountdown copy$default(StartCountdown r0, boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.directIn;
            L6:
                return r0.copy(r1);
            }

            public final boolean component1() {
                return this.directIn;
            }

            public final StartCountdown copy(boolean r2) {
                return new StartCountdown(r2);
            }

            public boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof StartCountdown) == true) goto L6;
                return false;
            L6:
                if (this.directIn == ((StartCountdown) r2).directIn) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                boolean r0 = this.directIn;
                if (r0 == false) goto L6;
                return 1;
            L6:
                return r0 ? 1 : 0;
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.SideEffect
            public String toString() {
                return "StartCountdown(directIn=" + this.directIn + ")";
            }

            public final boolean getDirectIn() {
                return this.directIn;
            }

            public StartCountdown(boolean r2) {
                super(null);
                this.directIn = r2;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$Started;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "component1", "msg", "copy", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "getMsg", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Started extends SideEffect {
            private final com.bytedance.android.livesdk.interactivity.api.barrage.model.a msg;

            public static /* synthetic */ Started copy$default(Started r0, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.msg;
            L6:
                return r0.copy(r1);
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a component1() {
                return this.msg;
            }

            public final Started copy(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                return new Started(r2);
            }

            public boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof Started) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.msg, ((Started) r2).msg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = this.msg;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.SideEffect
            public String toString() {
                return "Started(msg=" + this.msg + ")";
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getMsg() {
                return this.msg;
            }

            public Started(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                super(null);
                this.msg = r2;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StopCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StopCarnival extends SideEffect {
            public static final StopCarnival INSTANCE = null;

            private StopCarnival() {
                super(null);
            }

            static {
                INSTANCE = new StopCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$WarmingUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmingUp extends SideEffect {
            public static final WarmingUp INSTANCE = null;

            private WarmingUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmingUp();
            }
        }

        private SideEffect() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ SideEffect(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", BuildConfig.FLAVOR, "()V", "toString", BuildConfig.FLAVOR, "Countdown", "Ending", "Idle", "InCarnival", "Start", "WarmUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Ending;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Idle;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$WarmUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Countdown extends State {
            public static final Countdown INSTANCE = null;

            private Countdown() {
                super(null);
            }

            static {
                INSTANCE = new Countdown();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Ending;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Ending extends State {
            public static final Ending INSTANCE = null;

            private Ending() {
                super(null);
            }

            static {
                INSTANCE = new Ending();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Idle;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Idle extends State {
            public static final Idle INSTANCE = null;

            private Idle() {
                super(null);
            }

            static {
                INSTANCE = new Idle();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class InCarnival extends State {
            public static final InCarnival INSTANCE = null;

            private InCarnival() {
                super(null);
            }

            static {
                INSTANCE = new InCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Start extends State {
            public static final Start INSTANCE = null;

            private Start() {
                super(null);
            }

            static {
                INSTANCE = new Start();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$WarmUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmUp extends State {
            public static final WarmUp INSTANCE = null;

            private WarmUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmUp();
            }
        }

        private State() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ State(DefaultConstructorMarker r1) {
            this();
        }
    }

    public final class a extends j<com.bytedance.android.livesdk.interactivity.api.barrage.model.a> {
        public final /* synthetic */ DanmakuCarnivalManager n;

        @Override // f52.c
        public final void a(DiscardReason r5) {
            Intrinsics.checkNotNullParameter(r5, "reason");
            DanmakuCarnivalManager r0 = this.n;
            String r6 = ((com.bytedance.android.livesdk.interactivity.api.barrage.model.a) this.m).getMessageId() + " is discard. reason=" + r5;
            int r1 = DanmakuCarnivalManager.y;
            r0.l(r6);
        }

        @Override // f52.c
        public final void h(f52.b r3) {
            Intrinsics.checkNotNullParameter(r3, "container");
            DanmakuCarnivalManager r4 = this.n;
            r4.k = this;
            StateMachine<State, Event, SideEffect> r5 = r4.v;
            Event.Start r0 = new Event.Start((com.bytedance.android.livesdk.interactivity.api.barrage.model.a) this.m);
            StateMachine.a r1 = StateMachine.c;
            r5.d(r0, null);
        }

        @Override // f52.c
        public final CleanStrategy i(f52.b r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            DanmakuCarnivalManager r3 = this.n;
            int r0 = DanmakuCarnivalManager.y;
            r3.l("onShowFinish");
            return CleanStrategy.NONE;
        }

        public a(DanmakuCarnivalManager r18, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r19) {
            Intrinsics.checkNotNullParameter(r19, "msg");
            this.n = r18;
            String r1 = "carnival_" + r19.getMessageId();
            NativePSTopViewType r2 = NativePSTopViewType.ChatCarnival;
            ConflictStrategy r11 = ConflictStrategy.DISCARD;
            super(r1, r2, 0, 0, 0, 0, 0, r11, r11, ConflictStrategy.INTERRUPT, false, r19.getHighlightAreaPriorityConfig(), r19, 1024);
        }

        @Override // f52.c
        public final CleanStrategy b(f52.b r1, f52.c r2) {
            Intrinsics.checkNotNullParameter(r1, "container");
            DanmakuCarnivalManager r3 = this.n;
            int r4 = DanmakuCarnivalManager.y;
            r3.l("onInterrupt");
            DanmakuCarnivalManager r5 = this.n;
            r5.k = null;
            r5.reset();
            return CleanStrategy.NONE;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DanmakuCarnivalManager a;

        public c(DanmakuCarnivalManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r0 = this.a.v;     // Catch: Throwable -> L4
            Event.Countdown r1 = new Event.Countdown(false);     // Catch: Throwable -> L4
            StateMachine.a r2 = StateMachine.c;     // Catch: Throwable -> L4
            r0.d(r1, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DanmakuCarnivalManager a;

        public d(DanmakuCarnivalManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r0 = this.a.v;     // Catch: Throwable -> L4
            Event.StartEnd r1 = Event.StartEnd.INSTANCE;     // Catch: Throwable -> L4
            StateMachine.a r2 = StateMachine.c;     // Catch: Throwable -> L4
            r0.d(r1, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ DanmakuCarnivalManager a;

        public e(DanmakuCarnivalManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r0 = this.a.v;     // Catch: Throwable -> L4
            Event.Carnival r1 = Event.Carnival.INSTANCE;     // Catch: Throwable -> L4
            StateMachine.a r2 = StateMachine.c;     // Catch: Throwable -> L4
            r0.d(r1, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ DanmakuCarnivalManager a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.data.d b;

        public f(DanmakuCarnivalManager r1, com.bytedance.android.livesdk.interactivity.api.barrage.data.d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.k().addFirst(this.b);     // Catch: Throwable -> L4
            this.a.o();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final LimitQueue<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> k() {
        return (LimitQueue) this.i.getValue();
    }

    @Override // f52.d
    public final void onUnload() {
        this.j = null;
        l("onUnload");
    }

    @Override // o22.d
    public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a c() {
        if (this.e == false) goto L11;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = this.h;
        if (r0 == null) goto L7;
        long r3 = r0.getMessageId();
    L9:
        if (r3 <= 0) goto L11;
        return this.h;
    L7:
        r3 = 0;
    L11:
        return null;
    }

    @Override // o22.d
    public final void init() {
        if (this.c == false) goto L5;
        return;
    L5:
        if (this.d == true) goto L33;
        l("init");
        boolean r0 = true;
        this.d = true;
        if (a0.l(this.x, true) == false) goto L10;
    L19:
        r0 = false;
    L20:
        this.f = r0;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r1 = this.b;
        if (r1 == null) goto L25;
        com.bytedance.live.datacontext.j<ChatCarnivalDataSyncModel> r2 = r1.getChatCarnivalSyncModel();
        if (r2 == null) goto L25;
        r2.c(new AnonymousClass1(this));
    L25:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r3 = this.b;
        if (r3 == null) goto L30;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r4 = r3.getGeneralCarnivalSyncModel();
        if (r4 == null) goto L30;
        r4.c(new AnonymousClass2(this));
    L30:
        this.r = ((Boolean) g0.a.getValue()).booleanValue();
        q(null);
        return;
    L10:
        if (rf2.a.a() == true) goto L19;
        int r5 = a1.a;
        if (a1.a.a().d() == false) goto L19;
        BarrageSetting r6 = (BarrageSetting) l42.a.d.getValue();
        if (r6 == null) goto L19;
        if (r6.isCarnivalBarrageOpen() == true) goto L19;
    }

    public final boolean m() {
        o r0 = this.a;
        if (r0 == null) goto L5;
        Boolean r1 = r0.isPortraitInteraction();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L9;
    L21:
        return false;
    L9:
        if (this.a.isVSFirstShow() == false) goto L21;
        IVSPlayerService r2 = k.f(IVSPlayerService.class);
        if (r2 == null) goto L21;
        IPlayerProgressService r3 = r2.provideVSProgressService(this.x);
        if (r3 == null) goto L21;
        PlayerProgressServiceContext r4 = r3.provideContext(this.x);
        if (r4 == null) goto L21;
        m r5 = r4.getAtLatest();
        if (r5 == null) goto L21;
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L21;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final void o() {
        if (this.m != null) goto L5;
        l("processNextMsg release=" + this.c + " disabled=" + this.f + " running=" + this.e + " msgNum=" + k().size() + " listener not set");
    L7:
        if (this.c == false) goto L9;
        return;
    L9:
        if (this.f == true) goto L18;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r0 = k().poll();
        if (r0 != null) goto L13;
        return;
    L13:
        if (this.e == false) goto L15;
        l("carnival is running. discard msg. id=" + r0.getMessageId());
        return;
    L15:
        n(r0);
        return;
    L18:
        return;
    L5:
        l("processNextMsg release=" + this.c + " disabled=" + this.f + " running=" + this.e + " msgNum=" + k().size() + " listener set");
        goto L7
    }

    @Override // o22.d
    public final void release() {
        if (this.c == false) goto L5;
        return;
    L5:
        l(BuildConfig.BUILD_TYPE);
        this.c = true;
        this.d = false;
        this.m = null;
        Disposable r2 = this.n;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        Disposable r3 = this.o;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        k().clear();
        this.l.removeCallbacksAndMessages(null);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = this.b;
        if (r4 == null) goto L14;
        r(r4, C03061.INSTANCE);
    L14:
        this.e = false;
        this.p = -1;
        this.k = null;
        this.j = null;
        q(null);
    }

    @Override // o22.d
    public final void reset() {
        if (this.c == false) goto L5;
        return;
    L5:
        if (this.d == false) goto L16;
        l("reset");
        Disposable r0 = this.n;
        if (r0 == null) goto L10;
        r0.dispose();
    L10:
        Disposable r1 = this.o;
        if (r1 == null) goto L13;
        r1.dispose();
    L13:
        k().clear();
        this.l.removeCallbacksAndMessages(null);
        StateMachine<State, Event, SideEffect> r2 = this.v;
        Event.Stop r3 = Event.Stop.INSTANCE;
        StateMachine.a r4 = StateMachine.c;
        r2.d(r3, null);
        this.d = false;
        return;
    }

    @Override // o22.d
    public final boolean a() {
        return c() instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
    }

    @Override // o22.d
    public final boolean i() {
        return c() instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.d;
    }

    @Override // o22.d
    public final long e() {
        return this.p;
    }

    @Override // f52.d
    public final String getId() {
        return this.w;
    }

    public DanmakuCarnivalManager(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.x = r5;
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L5;
        o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
    L6:
        this.a = r6;
        this.b = q.b();
        this.i = LazyKt.lazy(DanmakuCarnivalManager$msgQueue$2.INSTANCE);
        this.l = new Handler(Looper.getMainLooper());
        this.p = -1;
        this.s = new e(this);
        this.t = new d(this);
        this.u = new c(this);
        StateMachine.a r7 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit> r1 = new DanmakuCarnivalManager$stateMachine$1(this);
        r7.getClass();
        this.v = StateMachine.a.a(r1);
        this.w = "DanmakuCarnivalManager";
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // o22.d
    public final void b(boolean r6) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (r6 != this.f) goto L7;
        return;
    L7:
        if (a0.l(this.x, true) == true) goto L40;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r0 = null;
        if (r6 == false) goto L19;
        this.f = true;
        if (this.e == false) goto L18;
        StringBuilder r7 = new StringBuilder("disable carnival danmaku and force stop carnival. msgId=");
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r1 = this.h;
        if (r1 == null) goto L16;
        Long r2 = Long.valueOf(r1.getMessageId());
    L17:
        r7.append(r2);
        l(r7.toString());
        StateMachine<State, Event, SideEffect> r8 = this.v;
        Event.Stop r3 = Event.Stop.INSTANCE;
        StateMachine.a r4 = StateMachine.c;
        r8.d(r3, null);
        return;
    L16:
        r2 = null;
        goto L17
    L18:
        l("disable carnival danmaku");
        return;
    L19:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r9 = this.b;
        if (r9 == null) goto L24;
        n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r10 = r9.getChatCarnivalMessage();
        if (r10 == null) goto L24;
        r0 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r10.getValue();
    L24:
        this.f = false;
        if (r0 != null) goto L27;
    L33:
        l("enable carnival");
        o();
        return;
    L27:
        if (r0.getMessageId() <= 0) goto L33;
        if (r0.x() != 0) goto L31;
    L32:
        l("enable and resume carnival. msgId=" + r0.getMessageId());
        n(r0);
        return;
    L31:
        if (r0.n() <= 10000) goto L33;
    }

    @Override // o22.d
    public final void f(o22.c r5) {
        if (r5 == null) goto L4;
        l("setListener");
    L6:
        if (r5 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        this.m = r5;
        if (r1 == true) goto L14;
        return;
    L14:
        if (this.d == true) goto L16;
        return;
    L16:
        if ((!Intrinsics.areEqual((State) this.v.b(), State.Idle.INSTANCE)) == false) goto L34;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r6 = this.h;
        if (r6 == null) goto L38;
        o22.c r2 = this.m;
        if (r2 == null) goto L35;
        l("syncListenerState to " + ((State) this.v.b()));
        State r3 = (State) this.v.b();
        if (Intrinsics.areEqual(r3, State.WarmUp.INSTANCE) == false) goto L26;
        r2.g(this, r6, true);
        r2.f(this, r6);
        return;
    L26:
        if (Intrinsics.areEqual(r3, State.InCarnival.INSTANCE) == false) goto L37;
        r2.g(this, r6, this.g);
        if (this.g == false) goto L30;
        r2.f(this, r6);
    L30:
        r2.d(this, r6);
        return;
    L37:
        return;
    L35:
        return;
    L38:
        return;
    L34:
        return;
    L8:
        if ((!Intrinsics.areEqual(this.m, r5)) == false) goto L10;
        r1 = true;
        goto L11
    L4:
        l("setListener null");
        goto L6
    }

    @Override // f52.e
    public final void g(f52.c r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r2.getType().getPriority() <= NativePSTopViewType.ChatCarnival.getPriority()) goto L6;
        reset();
        return;
    }

    @Override // f52.d
    public final void j(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        l("onLoad");
        this.j = r2;
        r2.f(this);
    }

    public final void l(String r2) {
        ALogger.i("DanmakuCarnivalManager", r2);
    }

    public final void n(com.bytedance.android.livesdk.interactivity.api.barrage.data.d r10) {
        if (m() == false) goto L5;
        return;
    L5:
        o r0 = this.a;
        if (r0 == null) goto L50;
        m r1 = r0.getRoom();
        if (r1 == null) goto L50;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L50;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L50;
        if (r3.isEnableLandscapeChat() != true) goto L50;
        if (this.c == false) goto L19;
        return;
    L19:
        if ((r10 instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.d) == true) goto L22;
        return;
    L22:
        if (r10.A(a0.l(this.x, true)) == true) goto L30;
        if (a0.l(this.x, true) == false) goto L26;
        String r4 = "portrait";
    L27:
        ALogger.e("DanmakuCarnivalManager", "on carnival message. not support in " + r4 + ". supportShowType=" + r10.w());
        return;
    L26:
        r4 = "landscape";
        goto L27
    L30:
        if (r10.x() == 0) goto L36;
        if (r10.n() > 10000) goto L36;
        l("on carnival message, real duration <= 10s, return");
        return;
    L36:
        if (Intrinsics.areEqual((State) this.v.b(), State.Idle.INSTANCE) == true) goto L39;
        l("is in carnival current now. discard msg. id=" + r10.getMessageId());
        return;
    L39:
        long r5 = (r10.x() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) - (com.bytedance.android.livesdk.utils.ntp.a.a + System.currentTimeMillis());
        if (r5 <= 0) goto L43;
        this.l.postDelayed(new f(this, r10), r5);
        l("dispatch carnival message, delay to add to msg queue timediff = " + r5);
        return;
    L43:
        if (this.f == false) goto L45;
        k().add(r10);
        l("dispatch carnival message. isCarnivalRunning=" + this.e + " disabled=" + this.f);
        return;
    L45:
        if (r10.n() <= 10000) goto L47;
        p(r10);
        l("dispatch carnival message. userStartTimestamp = " + r10.x() + ". start");
        return;
    L47:
        l("dispatch carnival message. message timeout. realDuration=" + r10.n());
        return;
    L50:
        l("landscape_chat is close, intercept carnival message");
    }

    public final void p(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
        f52.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.a(new a(this, r3));
        return;
    L5:
        StateMachine<State, Event, SideEffect> r1 = this.v;
        Event.Start r2 = new Event.Start(r3);
        StateMachine.a r4 = StateMachine.c;
        r1.d(r2, null);
    }

    public final void q(String r5) {
        if (this.r == true) goto L10;
        return;
    L10:
        Npth.addTags(MapsKt.mapOf(TuplesKt.to("live_comment_activity", r5)));     // Catch: Exception -> L7
        l("update monitor tag " + r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        SafetyGuard.a("carnival add monitor tag failed", e, null);
        ALogger.e("DanmakuCarnivalManager", "update monitor tag " + r5 + " failed", e);
    }

    public static void r(com.bytedance.android.livesdk.interactivity.api.publicscreen.b r1, Function1 r2) {
        if (r1.hasCleared() == true) goto L6;
        r2.invoke(r1);
        return;
    }

    @Override // f52.e
    public final void d(f52.c r2, ShowFinishType r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "type");
        if (r3 != ShowFinishType.DESTROY) goto L5;
        return;
    L5:
        if (r3 != ShowFinishType.INTERRUPT) goto L7;
        return;
    L7:
        if (r2.getType().getPriority() <= NativePSTopViewType.ChatCarnival.getPriority()) goto L12;
        init();
        return;
    }

    @Override // o22.d
    public final void h(ChatCarnivalView r3, ViewGroup.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        a r0 = this.k;
        if (r0 == null) goto L8;
        f52.b r1 = this.j;
        if (r1 == null) goto L9;
        r1.b(r0, r3, r4);
        return;
    L9:
        return;
    }
}
