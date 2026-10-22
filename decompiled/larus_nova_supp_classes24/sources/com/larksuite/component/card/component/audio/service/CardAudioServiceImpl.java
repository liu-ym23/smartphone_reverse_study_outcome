package com.larksuite.component.card.component.audio.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larksuite.component.card.component.audio.monitor.CardAudioMonitor;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.resources.CardResource;
import com.larksuite.component.card.resources.e;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0003<=>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020\u0018H\u0007J \u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J9\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002J(\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioServiceImpl;", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "Landroidx/lifecycle/LifecycleObserver;", "serviceContext", "Lcom/larksuite/component/card/service/CardServiceContext;", "<init>", "(Lcom/larksuite/component/card/service/CardServiceContext;)V", "resourceService", "Lcom/larksuite/component/card/resources/ICardResourceService;", "resourceLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "resourceLoadJob", "Lkotlinx/coroutines/Job;", "audioSessions", "Ljava/util/HashMap;", "", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity;", "Lkotlin/collections/HashMap;", "observers", "", "Lcom/larksuite/component/card/component/audio/service/ICardAudioStateObserver;", "audioOperations", "Lcom/larksuite/component/card/component/audio/service/CardAudioServiceImpl$AudioOperation;", "play", "", "sessionID", "audioInfo", "Lcom/larksuite/component/card/protocol/data/media/AudioInfo;", "position", "", "monitorData", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService$CardAudioMonitorData;", "playBySeek", "", "pause", "stop", "seek", "getState", "registerStateObserver", "observer", "removeStateObserver", "destroy", "onStop", "loadResourceAndPlay", "doPlay", "resource", "Lcom/larksuite/component/card/resources/CardResource;", "updateAudioState", "state", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "duration", "(Ljava/lang/String;Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;Ljava/lang/Integer;Ljava/lang/Integer;)V", "monitorOperateAudioSuccess", "operation", "Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationEnum;", "monitorOperateAudioFail", "failType", "Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationFailType;", "errorCode", "errorMsg", "AudioPlayerCallback", "AudioOperation", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardAudioServiceImpl implements com.larksuite.component.card.component.audio.service.b, LifecycleObserver {
    public static final /* synthetic */ int g = 0;
    public final e a;
    public final CoroutineScope b;
    public Job c;
    public final HashMap<String, CardAudioStateEntity> d;
    public final List<com.larksuite.component.card.component.audio.service.c> e;
    public final HashMap<String, a> f;

    public static final class a {
        public final String a;
        public final CardAudioMonitor.AudioOperationEnum b;
        public final AudioInfo c;
        public final com.larksuite.component.card.component.audio.service.b.a d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            AudioInfo r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            com.larksuite.component.card.component.audio.service.b.a r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "AudioOperation(sessionID=" + this.a + ", operation=" + this.b + ", audioInfo=" + this.c + ", monitorData=" + this.d + ')';
        }

        public a(String r2, CardAudioMonitor.AudioOperationEnum r3, AudioInfo r4, com.larksuite.component.card.component.audio.service.b.a r5) {
            Intrinsics.checkNotNullParameter(r2, "sessionID");
            Intrinsics.checkNotNullParameter(r3, "operation");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b implements com.ss.android.lark.audio.opus.e.a {
        public final String a;
        public final AudioInfo b;
        public final WeakReference<CardAudioServiceImpl> c;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void a() {
                CardAudioServiceImpl r0 = b.c(this.a);
                if (r0 == null) goto L5;
                b r1 = this.a;
                String r2 = r1.a;
                int r3 = r1.b.getDuration();
                CardAudioStateEntity.CardAudioStateEnum r4 = CardAudioStateEntity.CardAudioStateEnum.ERROR;
                Integer r5 = Integer.valueOf(r3);
                int r6 = CardAudioServiceImpl.g;
                r0.p(r2, r4, 0, r5);
            L5:
                CardAudioServiceImpl r7 = b.c(this.a);
                if (r7 == null) goto L9;
                CardAudioServiceImpl.m(r7, this.a.a, CardAudioMonitor.AudioOperationFailType.PLAYER, -1, "player error");
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.component.audio.service.CardAudioServiceImpl$b$b, reason: collision with other inner class name */
        public static final class RunnableC0019b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0019b(b r1) {
                this.a = r1;
            }

            public final void a() {
                CardAudioServiceImpl r1 = b.c(this.a);
                if (r1 == null) goto L5;
                b r0 = this.a;
                String r2 = r0.a;
                int r3 = r0.b.getDuration();
                CardAudioServiceImpl.q(r1, r2, CardAudioStateEntity.CardAudioStateEnum.PAUSED, null, Integer.valueOf(r3), 4);
            L5:
                CardAudioServiceImpl r4 = b.c(this.a);
                if (r4 == null) goto L9;
                CardAudioServiceImpl.n(r4, this.a.a, CardAudioMonitor.AudioOperationEnum.PAUSE);
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ b a;

            public c(b r1) {
                this.a = r1;
            }

            public final void a() {
                CardAudioServiceImpl r1 = b.c(this.a);
                if (r1 == null) goto L5;
                b r0 = this.a;
                String r2 = r0.a;
                int r3 = r0.b.getDuration();
                CardAudioServiceImpl.q(r1, r2, CardAudioStateEntity.CardAudioStateEnum.PLAYING, null, Integer.valueOf(r3), 4);
            L5:
                CardAudioMonitor.AudioOperationEnum r4 = CardAudioMonitor.AudioOperationEnum.PLAY;
                CardAudioServiceImpl r5 = b.c(this.a);
                if (r5 == null) goto L12;
                HashMap<String, a> r6 = r5.f;
                if (r6 == null) goto L12;
                a r7 = r6.get(this.a.a);
                if (r7 == null) goto L12;
                CardAudioMonitor.AudioOperationEnum r8 = r7.b;
            L13:
                CardAudioMonitor.AudioOperationEnum r9 = CardAudioMonitor.AudioOperationEnum.SEEK;
                if (r8 != r9) goto L16;
                r4 = r9;
            L16:
                CardAudioServiceImpl r10 = b.c(this.a);
                if (r10 == null) goto L20;
                CardAudioServiceImpl.n(r10, this.a.a, r4);
                return;
            L20:
                return;
            L12:
                r8 = null;
                goto L13
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
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
            public final /* synthetic */ b a;

            public d(b r1) {
                this.a = r1;
            }

            public final void a() {
                CardAudioServiceImpl r1 = b.c(this.a);
                if (r1 == null) goto L5;
                b r0 = this.a;
                String r2 = r0.a;
                int r3 = r0.b.getDuration();
                CardAudioServiceImpl.q(r1, r2, CardAudioStateEntity.CardAudioStateEnum.PLAYING, null, Integer.valueOf(r3), 4);
            L5:
                CardAudioMonitor.AudioOperationEnum r4 = CardAudioMonitor.AudioOperationEnum.PLAY;
                CardAudioServiceImpl r5 = b.c(this.a);
                if (r5 == null) goto L12;
                HashMap<String, a> r6 = r5.f;
                if (r6 == null) goto L12;
                a r7 = r6.get(this.a.a);
                if (r7 == null) goto L12;
                CardAudioMonitor.AudioOperationEnum r8 = r7.b;
            L13:
                CardAudioMonitor.AudioOperationEnum r9 = CardAudioMonitor.AudioOperationEnum.SEEK;
                if (r8 != r9) goto L16;
                r4 = r9;
            L16:
                CardAudioServiceImpl r10 = b.c(this.a);
                if (r10 == null) goto L20;
                CardAudioServiceImpl.n(r10, this.a.a, r4);
                return;
            L20:
                return;
            L12:
                r8 = null;
                goto L13
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
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
            public final /* synthetic */ b a;

            public e(b r1) {
                this.a = r1;
            }

            public final void a() {
                CardAudioServiceImpl r0 = b.c(this.a);
                if (r0 == null) goto L5;
                b r1 = this.a;
                String r2 = r1.a;
                int r3 = r1.b.getDuration();
                CardAudioStateEntity.CardAudioStateEnum r4 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
                Integer r5 = Integer.valueOf(r3);
                int r6 = CardAudioServiceImpl.g;
                r0.p(r2, r4, 0, r5);
            L5:
                CardAudioServiceImpl r7 = b.c(this.a);
                if (r7 == null) goto L9;
                CardAudioServiceImpl.n(r7, this.a.a, CardAudioMonitor.AudioOperationEnum.STOP);
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
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
            public final /* synthetic */ b a;
            public final /* synthetic */ float b;

            public f(b r1, float r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                int r0 = (int) (this.a.b.getDuration() * this.b);
                CardAudioServiceImpl r1 = b.c(this.a);
                if (r1 == null) goto L8;
                CardAudioStateEntity r2 = r1.getState(this.a.a);
                if (r2 == null) goto L8;
                CardAudioStateEntity.CardAudioStateEnum r3 = r2.getState();
                if (r3 == null) goto L8;
            L9:
                StringBuilder r4 = new StringBuilder();
                int r5 = CardAudioServiceImpl.g;
                r4.append(c.a(this.a.a));
                r4.append("[callback] progress=");
                r4.append(this.b);
                r4.append(", position=");
                r4.append(r0);
                r4.append(", state=");
                r4.append(r3.getValue());
                Log.d("CardAudioService", r4.toString());
                CardAudioServiceImpl r6 = b.c(this.a);
                if (r6 == null) goto L13;
                b r7 = this.a;
                r6.p(r7.a, r3, Integer.valueOf(r0), Integer.valueOf(r7.b.getDuration()));
                return;
            L13:
                return;
            L8:
                r3 = CardAudioStateEntity.CardAudioStateEnum.PLAYING;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            StringBuilder r0 = new StringBuilder();
            int r1 = CardAudioServiceImpl.g;
            r0.append(c.a(this.a));
            r0.append("[callback] error");
            Log.e("CardAudioService", r0.toString());
            mz7.b.a(new a(this));
        }

        public final void pause() {
            StringBuilder r0 = new StringBuilder();
            int r1 = CardAudioServiceImpl.g;
            r0.append(c.a(this.a));
            r0.append("[callback] pause");
            Log.d("CardAudioService", r0.toString());
            mz7.b.a(new RunnableC0019b(this));
        }

        public final void resume() {
            StringBuilder r0 = new StringBuilder();
            int r1 = CardAudioServiceImpl.g;
            r0.append(c.a(this.a));
            r0.append("[callback] resume");
            Log.d("CardAudioService", r0.toString());
            mz7.b.a(new c(this));
        }

        public final void start() {
            StringBuilder r0 = new StringBuilder();
            int r1 = CardAudioServiceImpl.g;
            r0.append(c.a(this.a));
            r0.append("[callback] start");
            Log.d("CardAudioService", r0.toString());
            mz7.b.a(new d(this));
        }

        public final void stop() {
            StringBuilder r0 = new StringBuilder();
            int r1 = CardAudioServiceImpl.g;
            r0.append(c.a(this.a));
            r0.append("[callback] stop");
            Log.d("CardAudioService", r0.toString());
            mz7.b.a(new e(this));
        }

        public static final CardAudioServiceImpl c(b r0) {
            return r0.c.get();
        }

        public final void b(float r2) {
            mz7.b.a(new f(this, r2));
        }

        public b(String r2, AudioInfo r3, CardAudioServiceImpl r4) {
            Intrinsics.checkNotNullParameter(r2, "sessionID");
            Intrinsics.checkNotNullParameter(r3, "audioInfo");
            Intrinsics.checkNotNullParameter(r4, "audioService");
            this.a = r2;
            this.b = r3;
            this.c = new WeakReference(r4);
        }
    }

    public static final class c {
        public c() {
        }

        public static final String a(String r2) {
            int r0 = CardAudioServiceImpl.g;
            return "[CardAudioService-" + r2 + ']';
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardAudioStateEntity.CardAudioStateEnum.values().length];
            r0[CardAudioStateEntity.CardAudioStateEnum.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CardAudioStateEntity.CardAudioStateEnum.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CardAudioStateEntity.CardAudioStateEnum.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CardAudioStateEntity.CardAudioStateEnum.PREPARING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CardAudioStateEntity.CardAudioStateEnum.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        new c();
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        Log.i("CardAudioService", "[lifecycle] destroy");
        Job r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel(new CancellationException("Destroy"));
    L5:
        ((ArrayList) this.e).clear();
        this.d.clear();
        this.f.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Log.i("CardAudioService", "[lifecycle] stop");
        com.ss.android.lark.audio.opus.e.d().g();
    }

    public CardAudioServiceImpl(com.larksuite.component.card.service.b r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceContext");
        e r0 = (e) r4.c.getService(e.class);
        if (r0 != null) goto L9;
        Log.e("CardAudioService", "CardResourceService is null");
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L8;
        r0 = new com.larksuite.component.card.resources.d();
        goto L9
    L8:
        throw new NullPointerException("CardResourceService is null");
    L9:
        this.a = r0;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new HashMap();
        Log.i("CardAudioService", "[lifecycle] init");
        Lifecycle r5 = r4.a;
        if (r5 == null) goto L13;
        r5.addObserver(this);
        return;
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void e(az7.a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (((ArrayList) this.e).contains(r2) == true) goto L6;
        ((ArrayList) this.e).add(r2);
        return;
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final CardAudioStateEntity getState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionID");
        return this.d.get(r2);
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void c(String r5, com.larksuite.component.card.component.audio.service.b.a r6) {
        Intrinsics.checkNotNullParameter(r5, "sessionID");
        String r3 = null;
        this.f.put(r5, new a(r5, CardAudioMonitor.AudioOperationEnum.STOP, null, r6));
        CardAudioStateEntity r7 = this.d.get(r5);
        if (r7 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r8 = r7.getState();
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append(c.a(r5));
        r0.append("[stop] current state: ");
        if (r8 == null) goto L9;
        r3 = r8.getValue();
    L9:
        r0.append(r3);
        Log.i("CardAudioService", r0.toString());
        if (r8 != null) goto L12;
        int r9 = -1;
    L14:
        if (r9 != 3) goto L16;
    L23:
        com.ss.android.lark.audio.opus.e.d().m(true);
        return;
    L16:
        if (r9 != 4) goto L18;
        Job r10 = this.c;
        if (r10 == null) goto L25;
        r10.cancel(new CancellationException("Stopped"));
        return;
    L25:
        return;
    L18:
        if (r9 == 5) goto L23;
        return;
    L12:
        r9 = d.a[r8.ordinal()];
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void l(String r5, com.larksuite.component.card.component.audio.service.b.a r6) {
        Intrinsics.checkNotNullParameter(r5, "sessionID");
        String r3 = null;
        this.f.put(r5, new a(r5, CardAudioMonitor.AudioOperationEnum.PAUSE, null, r6));
        CardAudioStateEntity r7 = this.d.get(r5);
        if (r7 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r8 = r7.getState();
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append(c.a(r5));
        r0.append("[pause] current state: ");
        if (r8 == null) goto L9;
        r3 = r8.getValue();
    L9:
        r0.append(r3);
        Log.i("CardAudioService", r0.toString());
        if (r8 != CardAudioStateEntity.CardAudioStateEnum.PLAYING) goto L13;
        com.ss.android.lark.audio.opus.e.d().g();
        return;
    L13:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static final void n(CardAudioServiceImpl r2, String r3, CardAudioMonitor.AudioOperationEnum r4) {
        a r5 = r2.f.get(r3);
        if (r5 == null) goto L18;
        int r6 = CardAudioMonitor.a;
        com.larksuite.component.card.component.audio.service.b.a r7 = r5.d;
        if (r7 == null) goto L8;
        String r0 = r7.a;
        if (r0 == null) goto L8;
    L9:
        String r1 = null;
        if (r7 == null) goto L12;
        String r8 = r7.b;
    L13:
        AudioInfo r9 = r5.c;
        if (r9 == null) goto L16;
        r1 = r9.getKey();
    L16:
        CardAudioMonitor.b(r0, r4, r8, r1);
        return;
    L12:
        r8 = null;
    L8:
        r0 = "";
        goto L9
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void f(String r9, AudioInfo r10, int r11, com.larksuite.component.card.component.audio.service.b.a r12) {
        Intrinsics.checkNotNullParameter(r9, "sessionID");
        Intrinsics.checkNotNullParameter(r10, "audioInfo");
        this.f.put(r9, new a(r9, CardAudioMonitor.AudioOperationEnum.SEEK, r10, r12));
        CardAudioStateEntity r0 = this.d.get(r9);
        StringBuilder r1 = new StringBuilder();
        r1.append(c.a(r9));
        r1.append("[seek], current state: ");
        if (r0 == null) goto L7;
        CardAudioStateEntity.CardAudioStateEnum r2 = r0.getState();
        if (r2 == null) goto L7;
        String r3 = r2.getValue();
    L8:
        r1.append(r3);
        Log.i("CardAudioService", r1.toString());
        if (r0 == null) goto L12;
        CardAudioStateEntity.CardAudioStateEnum r4 = r0.getState();
        if (r4 == null) goto L12;
    L13:
        q(this, r9, null, Integer.valueOf(r11), Integer.valueOf(r10.getDuration()), 2);
        int r5 = d.a[r4.ordinal()];
        if (r5 != 1) goto L16;
    L27:
        j(r9, r10, r11, r12, true);
        return;
    L16:
        if (r5 == 2) goto L27;
        if (r5 != 3) goto L20;
    L22:
        int r13 = r10.getDuration();
        if (r13 != 0) goto L25;
        float r14 = 0.0f;
    L26:
        com.ss.android.lark.audio.opus.e.d().j(r14);
        com.ss.android.lark.audio.opus.e.d().i();
        return;
    L25:
        r14 = r11 / r13;
        goto L26
    L20:
        if (r5 == 5) goto L22;
        return;
    L12:
        r4 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
    L7:
        r3 = null;
        goto L8
    }

    public final void o(String r9, AudioInfo r10, CardResource r11, int r12) {
        Log.i("CardAudioService", c.a(r9) + " doPlay");
        int r5 = r10.getDuration();
        com.ss.android.lark.audio.a r13 = new com.ss.android.lark.audio.a(r9, "", r5, (int) ((((float) r12) / ((float) r5)) * 100.0f), r11.c);
        CardAudioStateEntity r14 = getState(r9);
        if (r14 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r15 = r14.getState();
    L6:
        CardAudioStateEntity.CardAudioStateEnum r4 = CardAudioStateEntity.CardAudioStateEnum.STARTING;
        if (r15 != r4) goto L10;
        Log.i("CardAudioService", c.a(r9) + " already starting play");
        return;
    L10:
        com.ss.android.lark.audio.opus.e.d().m(true);
        com.ss.android.lark.audio.opus.e.d().n(r13, new b(r9, r10, this));
        q(this, r9, r4, null, Integer.valueOf(r10.getDuration()), 4);
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void p(String r9, CardAudioStateEntity.CardAudioStateEnum r10, Integer r11, Integer r12) {
        HashMap<String, CardAudioStateEntity> r0 = this.d;
        CardAudioStateEntity r1 = r0.get(r9);
        if (r1 != null) goto L5;
        r1 = new CardAudioStateEntity(null, 0, 0, 7, null);
        r0.put(r9, r1);
    L5:
        CardAudioStateEntity r2 = CardAudioStateEntity.copy$default(r1, null, 0, 0, 7, null);
        boolean r3 = false;
        boolean r4 = true;
        if (r10 != null) goto L8;
    L16:
        boolean r13 = false;
    L17:
        if (r11 != null) goto L19;
    L27:
        if (r12 != null) goto L29;
    L36:
        r4 = r13;
    L37:
        this.d.put(r9, r2);
        if (r4 == true) goto L40;
        return;
    L40:
        if (r2.getState().isLocalState() == true) goto L47;
        Iterator<T> r14 = this.e.iterator();
    L43:
        if (r14.hasNext() == false) goto L48;
        ((com.larksuite.component.card.component.audio.service.c) r14.next()).a(r9, r2);
        goto L43
    L48:
        return;
    L47:
        return;
    L29:
        if (r2.getDuration() == r12.intValue()) goto L31;
        r3 = true;
    L31:
        if (r3 == true) goto L34;
        r12 = null;
    L34:
        if (r12 == null) goto L36;
        r2.setDuration(r12.intValue());
        goto L37
    L19:
        if (r2.getPosition() == r11.intValue()) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L27;
        r2.setPosition(r11.intValue());
        r13 = true;
        goto L27
    L21:
        r5 = false;
        goto L22
    L8:
        if (r2.getState() == r10) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L14;
        r10 = null;
    L14:
        if (r10 == null) goto L16;
        r2.setState(r10);
        r13 = true;
        goto L17
    L10:
        r6 = false;
        goto L11
    }

    public static final void m(CardAudioServiceImpl r8, String r9, CardAudioMonitor.AudioOperationFailType r10, int r11, String r12) {
        a r13 = r8.f.get(r9);
        if (r13 == null) goto L19;
        int r14 = CardAudioMonitor.a;
        com.larksuite.component.card.component.audio.service.b.a r15 = r13.d;
        if (r15 == null) goto L8;
        String r0 = r15.a;
        if (r0 == null) goto L8;
    L9:
        String r1 = r0;
        CardAudioMonitor.AudioOperationEnum r2 = r13.b;
        if (r15 == null) goto L12;
        String r3 = r15.b;
    L13:
        AudioInfo r16 = r13.c;
        if (r16 == null) goto L16;
        String r4 = r16.getKey();
    L17:
        CardAudioMonitor.a(r1, r2, r3, r4, r10, r11, r12);
        return;
    L16:
        r4 = null;
        goto L17
    L12:
        r3 = null;
    L8:
        r0 = "";
        goto L9
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void j(String r15, AudioInfo r16, int r17, com.larksuite.component.card.component.audio.service.b.a r19, boolean r110) {
        Intrinsics.checkNotNullParameter(r15, "sessionID");
        Intrinsics.checkNotNullParameter(r16, "audioInfo");
        if (r110 == false) goto L5;
        CardAudioMonitor.AudioOperationEnum r0 = CardAudioMonitor.AudioOperationEnum.SEEK;
    L6:
        this.f.put(r15, new a(r15, r0, r16, r19));
        CardAudioStateEntity r1 = this.d.get(r15);
        if (r1 == null) goto L10;
        CardAudioStateEntity.CardAudioStateEnum r2 = r1.getState();
        if (r2 == null) goto L10;
    L11:
        Log.i("CardAudioService", c.a(r15) + "[play] current state: " + r2.getValue());
        int r3 = d.a[r2.ordinal()];
        if (r3 != 1) goto L14;
    L19:
        CardResource r4 = this.a.i(r16.getKey());
        if (r4 == null) goto L22;
        Log.i("CardAudioService", c.a(r15) + " play resource hit");
        o(r15, r16, r4, r17);
        return;
    L22:
        Log.i("CardAudioService", c.a(r15) + " resource miss");
        Job r5 = this.c;
        if (r5 == null) goto L25;
        r5.cancel(new CancellationException("Another audio play"));
    L25:
        q(this, r15, CardAudioStateEntity.CardAudioStateEnum.PREPARING, null, Integer.valueOf(r16.getDuration()), 4);
        this.c = BuildersKt.launch$default(this.b, null, null, new CardAudioServiceImpl$loadResourceAndPlay$2(r16, this, r15, r17, null), 3, null);
        return;
    L14:
        if (r3 == 2) goto L19;
        if (r3 != 3) goto L29;
        com.ss.android.lark.audio.opus.e.d().i();
        return;
    L29:
        return;
    L10:
        r2 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
        goto L11
    L5:
        r0 = CardAudioMonitor.AudioOperationEnum.PLAY;
        goto L6
    }

    public static /* synthetic */ void q(CardAudioServiceImpl r2, String r3, CardAudioStateEntity.CardAudioStateEnum r4, Integer r5, Integer r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        r2.p(r3, r4, r5, r6);
    }
}
