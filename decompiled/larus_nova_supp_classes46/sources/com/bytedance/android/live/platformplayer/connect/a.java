package com.bytedance.android.live.platformplayer.connect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ud1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.PreConnectConfig;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.platformplayer.connect.b {
    public int b;
    public final PreConnectConfig c;
    public final d d;

    /* JADX INFO: renamed from: com.bytedance.android.live.platformplayer.connect.a$a, reason: collision with other inner class name */
    public static final class C0184a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ IRoom a;

        public b(IRoom r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            IFeatureService r0 = k.f(IFeatureService.class);
            if (r0 == null) goto L5;
            r0.unifyHandleRoom(this.a);
        L5:
            if (r0 == null) goto L7;
            boolean r1 = true;
        L8:
            r3.onNext(Boolean.valueOf(r1));
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ IRoom b;

        public c(Function1 r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Boolean r9 = (Boolean) r8;
            if (this.a == null) goto L23;
            IResolutionService r0 = k.f(IResolutionService.class);
            String r10 = null;
            if (r0 == null) goto L17;
            long r1 = this.b.getRoomId();
            IRoom r3 = this.b;
            if ((r3 instanceof Room) == true) goto L9;
            r3 = null;
        L9:
            Room r4 = (Room) r3;
            if (r4 == null) goto L12;
            StreamUrl r5 = r4.getStreamUrl();
        L13:
            PlayerResolution.PickResult r2 = IResolutionService.DefaultImpls.getPullStreamResolutionNew$default(r0, r1, r5, false, 4, null);
            if (r2 == null) goto L17;
            String r6 = r2.getResultSdkKey();
            if (r6 == null) goto L17;
        L18:
            if (r6 == null) goto L21;
            r10 = r6;
        L21:
            this.a.invoke(r10);
            return;
        L12:
            r5 = null;
        L17:
            r6 = this.b.getMultiStreamDefaultQualitySdkKey();
            goto L18
        }
    }

    public static final class d extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r18) {
            Intrinsics.checkNotNullParameter(r18, "msg");
            if (r18.what != 2) goto L90;
            a r3 = this.a;
            int r4 = r18.arg1;
            Object r0 = r18.obj;
            if ((r0 instanceof Room) == true) goto L7;
            r0 = null;
        L7:
            final Room r1 = (Room) r0;
            if (r3.c.getEnabled() == true) goto L11;
            return;
        L11:
            if (r3.b != r4) goto L14;
            return;
        L14:
            if (r1 != null) goto L16;
            ALogger.i("InnerDrawPreConnectHandler", "invalid given room");
            return;
        L16:
            com.bytedance.android.live.platformplayer.connect.b.a r7 = r3.a;
            if (r7 == null) goto L19;
            boolean r8 = r7.q(r4);
        L20:
            if (r8 == true) goto L22;
            ALogger.i("InnerDrawPreConnectHandler", "invalid given pos: " + r4);
            return;
        L22:
            com.bytedance.android.live.platformplayer.connect.b.a r9 = r3.a;
            if (r9 == null) goto L25;
            ILiveRoomPlayFragment r10 = r9.o(r4);
        L26:
            if (r10 == null) goto L30;
            Fragment r11 = r10.getFragment();
            if (r11 == null) goto L30;
            Fragment r12 = r11.getParentFragment();
        L32:
            if ((r12 instanceof ILiveRoomPageFragment) == true) goto L34;
            r12 = null;
        L34:
            ILiveRoomPageFragment r13 = (ILiveRoomPageFragment) r12;
            if (r13 == null) goto L39;
            ILiveRoomPageFragment r14 = r13.getRealAction();
            if (r14 == null) goto L39;
            int r15 = r14.getCurrentPosition();
        L40:
            if (r4 != r15) goto L42;
        L88:
            ALogger.i("InnerDrawPreConnectHandler", "invalid given pos2: " + r4 + ' ' + r15);
            return;
        L42:
            if (Math.abs(r4 - r15) > 2) goto L88;
            com.bytedance.android.live.platformplayer.connect.b.a r2 = r3.a;
            if (r2 == null) goto L47;
            final String r5 = r2.p(r4);
        L48:
            if (r5 != null) goto L50;
            ALogger.i("InnerDrawPreConnectHandler", "invalid streamData: null");
            return;
        L50:
            r3.b = r4;
            IFeatureService r6 = k.f(IFeatureService.class);
            long r16 = 0;
            if (r6 == null) goto L56;
            WeakReference r17 = r6.getWeakRoom();
            if (r17 == null) goto L56;
            IRoom r19 = (IRoom) r17.get();
            if (r19 == null) goto L56;
        L63:
            if (v.a() == false) goto L85;
            StringBuilder r20 = new StringBuilder("currentRoomResolution:");
            IResolutionService r110 = k.f(IResolutionService.class);
            if (r110 == null) goto L79;
            if (r19 == null) goto L68;
            r16 = r19.getRoomId();
        L68:
            long r111 = r16;
            if ((r19 instanceof Room) == true) goto L71;
            IRoom r21 = null;
        L72:
            Room r22 = (Room) r21;
            if (r22 == null) goto L75;
            IBaseStreamUrl r112 = r22.getStreamUrl();
        L76:
            PlayerResolution.PickResult r23 = IResolutionService.DefaultImpls.getPullStreamResolutionNew$default(r110, r111, r112, false, 4, null);
            if (r23 == null) goto L79;
            String r24 = r23.getResultSdkKey();
        L80:
            r20.append(r24);
            r20.append(" roomId:");
            if (r19 == null) goto L83;
            Long r25 = Long.valueOf(r19.getRoomId());
        L84:
            r20.append(r25);
            ALogger.i("InnerDrawPreConnectHandler", r20.toString());
            goto L85
        L83:
            r25 = null;
            goto L84
        L75:
            r112 = null;
            goto L76
        L71:
            r21 = r19;
        L79:
            r24 = null;
        L85:
            a.b(r1, new InnerDrawPreConnectHandler$preConnect$1(r1, r5));
            if (r19 == null) goto L94;
            a.b(r19, null);
            return;
        L94:
            return;
        L56:
            RoomContext r26 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r26 == null) goto L61;
            m r27 = r26.getRoom();
            if (r27 == null) goto L61;
            r19 = (Room) r27.getValue();
        L61:
            r19 = null;
            goto L63
        L47:
            r5 = null;
        L39:
            r15 = -1;
        L30:
            r12 = null;
            goto L32
        L25:
            r10 = null;
            goto L26
        L19:
            r8 = false;
            goto L20
        }

        public d(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    public a() {
        this.b = -1;
        this.c = (PreConnectConfig) ud1.a.getValue();
        this.d = new d(this, Looper.getMainLooper());
    }

    public static void b(IRoom r2, Function1 r3) {
        Observable.create(new b(r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r3, r2));
    }

    public final void a(int r4, Room r5) {
        this.d.removeMessages(2);
        Message r0 = this.d.obtainMessage(2);
        r0.arg1 = r4;
        r0.obj = r5;
        this.d.sendMessageDelayed(r0, this.c.getDelayedTime());
        ALogger.i("InnerDrawPreConnectHandler", "post " + r4 + " room pre connect operation! delay" + this.c.getDelayedTime());
    }
}
