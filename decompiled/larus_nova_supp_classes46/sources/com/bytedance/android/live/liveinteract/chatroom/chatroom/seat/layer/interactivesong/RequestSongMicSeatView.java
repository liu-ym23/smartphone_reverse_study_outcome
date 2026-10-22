package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import am2.x;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import com.bytedance.android.livesdk.config.c61;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001:\b)*+,-./0J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0003J\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u001b\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R.\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\u00020 8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00061"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongMicSeatView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongGoldMicrophoneState;", "state", "", "setState", "", "getSingState", "getMicState", "n", "setPlusN", "", "getSingText", "Lpf0/a;", "getCurrentMicInfo", "getCurrentUserId", "visibility", "setVisibility", "d", "Lkotlin/Lazy;", "getMAnchorId", "()Ljava/lang/String;", "mAnchorId", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "value", "t", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getMCurPositionInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setMCurPositionInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "mCurPositionInfo", "", "showAnchorLabel", "Z", "getShowAnchorLabel", "()Z", "", "getMSingingTextWidth", "()F", "mSingingTextWidth", "a", "EndSingTask", "ShowAnchorTask", "b", "c", "ShowSingLabelTask", "ShowStartSingTask", "UpdateScoreTask", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RequestSongMicSeatView extends FrameLayout {
    public static final /* synthetic */ int w = 0;
    public RequestSongGoldMicrophoneState a;
    public RequestSongGoldMicrophoneState b;
    public final Handler c;
    public final Lazy d;
    public int e;
    public MicSeatScene f;
    public View g;
    public View h;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public Disposable m;
    public PositionNameTv n;
    public SeatPosTagLabelTextView o;
    public boolean p;
    public f q;
    public boolean r;
    public xg0.a s;
    public ILinkPlayerInfoBridge t;
    public final float u;
    public final boolean v;

    public final class EndSingTask extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final /* synthetic */ RequestSongMicSeatView d;

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            q r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(this);
        L5:
            n.d("EndSingTask.Start." + this.d.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.d));
            if (RequestSongMicSeatView.c(this.d) != RequestSongGoldMicrophoneState.SHOW_ANCHOR) goto L8;
        L18:
            q r1 = this.a;
            if (r1 == null) goto L21;
            r1.b(this);
        L21:
            n.d("EndSingTask.End1." + this.d.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.d));
            return;
        L8:
            if (RequestSongMicSeatView.c(this.d) == RequestSongGoldMicrophoneState.NOSING) goto L18;
            if (RequestSongMicSeatView.c(this.d) != RequestSongGoldMicrophoneState.SINGING) goto L13;
            this.d.w(new RequestSongMicSeatView$EndSingTask$execute$1(this));
        L13:
            q r2 = this.a;
            if (r2 == null) goto L16;
            r2.b(this);
        L16:
            n.d("EndSingTask.End2." + this.d.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.d));
            RequestSongMicSeatView r3 = this.d;
            r3.i(r3).a();
            this.d.v();
        }

        public EndSingTask(RequestSongMicSeatView r1) {
            this.d = r1;
            super(null);
        }
    }

    public final class ShowAnchorTask extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final String d;
        public final /* synthetic */ RequestSongMicSeatView e;

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            q r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(this);
        L5:
            n.d("ShowAnchorTask ;; Start ;; " + this.e.getMCurPositionInfo() + " ;; state == " + RequestSongMicSeatView.c(this.e));
            if ((!Intrinsics.areEqual(this.d, RequestSongMicSeatView.b(this.e))) == false) goto L12;
            q r1 = this.a;
            if (r1 == null) goto L10;
            r1.b(this);
        L10:
            n.d("ShowAnchorTask ;; End1 ;; " + this.e.getMCurPositionInfo() + " ;; state == " + RequestSongMicSeatView.c(this.e));
            return;
        L12:
            this.e.j(new RequestSongMicSeatView$ShowAnchorTask$execute$1(this));
            q r2 = this.a;
            if (r2 == null) goto L15;
            r2.b(this);
        L15:
            n.d("ShowAnchorTask ;; End2 ;; " + this.e.getMCurPositionInfo() + " ;; state == " + RequestSongMicSeatView.c(this.e));
        }

        public ShowAnchorTask(RequestSongMicSeatView r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "curUserId");
            this.e = r2;
            super(null);
            this.d = r3;
        }
    }

    public final class ShowSingLabelTask extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final String d;
        public final /* synthetic */ RequestSongMicSeatView e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ ShowSingLabelTask a;

            public a(ShowSingLabelTask r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                Long r6 = (Long) r5;
                ShowSingLabelTask r7 = this.a;
                if (r7.b == true) goto L5;
            L15:
                n.d("ShowSingLabelTask.Preempted2." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e) + ",token:" + this.a.c);
                ShowSingLabelTask r8 = this.a;
                if (r8.b == false) goto L24;
                q r0 = r8.a;
                if (r0 == null) goto L20;
                r0.b(r8);
            L20:
                n.d("ShowSingLabelTask.End2." + this.a.e.getMCurPositionInfo() + ",token:" + this.a.c);
                return;
            L24:
                return;
            L5:
                if ((!Intrinsics.areEqual(r7.d, RequestSongMicSeatView.a(r7.e))) == true) goto L15;
                Object r9 = this.a.c;
                if ((!Intrinsics.areEqual(r9, r9)) == true) goto L15;
                ShowSingLabelTask r10 = this.a;
                q r1 = r10.a;
                if (r1 == null) goto L12;
                r1.b(r10);
            L12:
                n.d("ShowSingLabelTask.End3." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e) + ",token:" + this.a.c);
                if (this.a.e.k() == true) goto L22;
                RequestSongMicSeatView r11 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r12 = r11.i(r11);
                RequestSongMicSeatView r2 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r12, new c(r2, RequestSongMicSeatView.a(r2), this.a.e), false, 6);
                return;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            RequestSongMicSeatView r0 = this.e;
            int r1 = RequestSongMicSeatView.w;
            if (r0.k() == false) goto L5;
            return;
        L5:
            q r2 = this.a;
            if (r2 == null) goto L8;
            r2.a(this);
        L8:
            n.d("ShowSingLabelTask.Start." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e) + ",token:" + this.c);
            if (InteractiveSongContext.Companion.f() == true) goto L11;
        L18:
            boolean r3 = true;
        L19:
            if (r3 == false) goto L27;
            n.d("ShowSingLabelTask.Preempted1." + this.e.getMCurPositionInfo() + ",token:" + this.c);
            if (this.b == false) goto L32;
            q r4 = this.a;
            if (r4 == null) goto L25;
            r4.b(this);
        L25:
            n.d("ShowSingLabelTask.End1." + this.e.getMCurPositionInfo() + ",token:" + this.c);
            return;
        L32:
            return;
        L27:
            this.e.u();
            RequestSongMicSeatView r5 = this.e;
            r5.q(n.b(r5.getMCurPositionInfo()), true);
            RequestSongMicSeatView.g(this.e, new RequestSongMicSeatView$ShowSingLabelTask$execute$1(this));
            RequestSongMicSeatView.h(this.e, RequestSongGoldMicrophoneState.SINGING);
            Disposable r6 = this.e.m;
            if (r6 == null) goto L30;
            r6.dispose();
        L30:
            this.e.m = RxUtilKt.h(Observable.timer(5000, TimeUnit.MILLISECONDS)).subscribe(new a(this));
            return;
        L11:
            if (this.b == false) goto L18;
            if ((!Intrinsics.areEqual(this.d, RequestSongMicSeatView.a(this.e))) == true) goto L18;
            Object r7 = this.c;
            if ((!Intrinsics.areEqual(r7, r7)) == true) goto L18;
            r3 = false;
            goto L19
        }

        public ShowSingLabelTask(RequestSongMicSeatView r2, String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "userId");
            this.e = r2;
            super(r4);
            this.d = r3;
        }
    }

    public final class ShowStartSingTask extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final String d;
        public final /* synthetic */ RequestSongMicSeatView e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ ShowStartSingTask a;

            public a(ShowStartSingTask r1) {
                this.a = r1;
            }

            public final void accept(Object r7) {
                Long r8 = (Long) r7;
                ShowStartSingTask r9 = this.a;
                if (r9.b == true) goto L5;
            L11:
                n.d("ShowStartSingTask.Preempted." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e));
                if (RequestSongMicSeatView.c(this.a.e) != RequestSongGoldMicrophoneState.NOSING) goto L16;
                RequestSongMicSeatView r10 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r10.i(r10), new b(this.a.e), false, 6);
                return;
            L16:
                return;
            L5:
                if ((!Intrinsics.areEqual(r9.d, RequestSongMicSeatView.a(r9.e))) == true) goto L11;
                ShowStartSingTask r11 = this.a;
                q r0 = r11.a;
                if (r0 == null) goto L10;
                r0.b(r11);
            L10:
                n.d("ShowStartSingTask.End2." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e));
                RequestSongMicSeatView r12 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r13 = r12.i(r12);
                RequestSongMicSeatView r3 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r13, new c(r3, RequestSongMicSeatView.a(r3), this.a.e), false, 6);
            }
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            q r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(this);
        L5:
            n.d("ShowStartSingTask.Start." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e));
            if (this.b == true) goto L8;
        L23:
            q r1 = this.a;
            if (r1 == null) goto L26;
            r1.b(this);
        L26:
            n.d("ShowStartSingTask.End1." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e));
            return;
        L8:
            if ((!Intrinsics.areEqual(this.d, RequestSongMicSeatView.a(this.e))) == true) goto L23;
            RequestSongMicSeatView.h(this.e, RequestSongGoldMicrophoneState.START_ANIM);
            RequestSongMicSeatView.f(this.e, new RequestSongMicSeatView$ShowStartSingTask$execute$1(this));
            final f r2 = this.e.q;
            if (r2 == null) goto L18;
            HSImageView r3 = r2.b;
            if (r3 == null) goto L15;
            UtilityKotlinExtentionsKt.w(r3);
        L15:
            fd0.f r4 = LiveAnimator.a(new View[]{r2.b});
            r4.a.d = n.a;
            r4.d(new float[]{0.0f, 1.03f, 0.98f, 1.01f, 1.0f});
            r4.a.b = 500;
            r4.e();
            HSImageView r5 = r2.b;
            if (r5 == null) goto L18;
            n.c(r5, LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_request_song_start_sing_pro.webp"), new RequestSongLabelAnimManager$playStartSingAnimation$1(r2));
        L18:
            Disposable r6 = this.e.m;
            if (r6 == null) goto L21;
            r6.dispose();
        L21:
            this.e.m = RxUtilKt.h(Observable.timer(5000, TimeUnit.MILLISECONDS)).subscribe(new a(this));
        }

        public ShowStartSingTask(RequestSongMicSeatView r2, String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "userId");
            this.e = r2;
            super(r4);
            this.d = r3;
        }
    }

    public final class UpdateScoreTask extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final pf0.a d;
        public final /* synthetic */ RequestSongMicSeatView e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ UpdateScoreTask a;

            public a(UpdateScoreTask r1) {
                this.a = r1;
            }

            public final void accept(Object r7) {
                Long r8 = (Long) r7;
                UpdateScoreTask r9 = this.a;
                if (r9.b == true) goto L7;
                n.d("UpdateScoreTask.Preempted." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e));
                if (RequestSongMicSeatView.c(this.a.e) != RequestSongGoldMicrophoneState.NOSING) goto L14;
                RequestSongMicSeatView r10 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r10.i(r10), new b(this.a.e), false, 6);
                return;
            L14:
                return;
            L7:
                q r0 = r9.a;
                if (r0 == null) goto L10;
                r0.b(r9);
            L10:
                n.d("UpdateScoreTask.End2." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e));
                if (this.a.e.k() == true) goto L16;
                RequestSongMicSeatView r11 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r12 = r11.i(r11);
                RequestSongMicSeatView r3 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r12, new ShowSingLabelTask(r3, RequestSongMicSeatView.a(r3), this.a.e), false, 6);
                return;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            q r1 = this.a;
            if (r1 == null) goto L5;
            r1.a(this);
        L5:
            n.d("UpdateScoreTask.Start." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e));
            if (RequestSongMicSeatView.c(this.e) != RequestSongGoldMicrophoneState.HIDDEN) goto L12;
            q r2 = this.a;
            if (r2 == null) goto L10;
            r2.b(this);
        L10:
            n.d("UpdateScoreTask.End1." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e));
            return;
        L12:
            RequestSongMicSeatView.h(this.e, RequestSongGoldMicrophoneState.PLUS_ANIM);
            pf0.a r3 = this.d;
            Function0<Unit> r4 = new RequestSongMicSeatView$UpdateScoreTask$execute$1(this);
            if (RequestSongMicSeatView.c(this.e) != RequestSongGoldMicrophoneState.SINGING) goto L15;
            this.e.w(null);
        L16:
            RequestSongMicSeatView.e(this.e, r3, r4);
            final f r5 = this.e.q;
            if (r5 == null) goto L24;
            HSImageView r6 = r5.c;
            if (r6 == null) goto L21;
            UtilityKotlinExtentionsKt.w(r6);
        L21:
            fd0.f r7 = LiveAnimator.a(new View[]{r5.c});
            r7.a.d = n.a;
            r7.d(new float[]{0.0f, 1.15f, 1.0f});
            r7.a.b = 500;
            r7.e();
            HSImageView r8 = r5.c;
            if (r8 == null) goto L24;
            n.c(r8, LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_request_song_increase.webp"), new RequestSongLabelAnimManager$playPlusNAnimation$1(r5));
        L24:
            if (r3 == null) goto L47;
            IBaseUser r9 = r3.e;
            if (r9 == null) goto L47;
            final f r10 = this.e.q;
            if (r10 == null) goto L47;
            Intrinsics.checkNotNullParameter(r9, "sponsor");
            MicSeatSponsorView r11 = r10.d;
            if (r11 == null) goto L32;
            UtilityKotlinExtentionsKt.w(r11);
        L32:
            MicSeatSponsorView r12 = r10.d;
            if (r12 == null) goto L40;
            py.k r13 = r9.getAvatarThumbKt();
            if (r13 == null) goto L38;
            String r14 = wc0.a.a(r13);
            if (r14 == null) goto L38;
        L39:
            r12.a(r14, (String) vm2.d.K.getValue(null, vm2.d.a[34]));
        L38:
            r14 = "";
        L40:
            AnimatorSet r15 = new AnimatorSet();
            ArrayList r16 = new ArrayList();
            ObjectAnimator r17 = ObjectAnimator.ofFloat(r10.d, "alpha", new float[]{0.0f, 1.0f});
            r17.setDuration(300);
            r16.add(r17);
            ObjectAnimator r18 = ObjectAnimator.ofFloat(r10.d, "alpha", new float[]{1.0f, 1.0f});
            r18.setDuration(2400);
            r16.add(r18);
            ObjectAnimator r19 = ObjectAnimator.ofFloat(r10.d, "alpha", new float[]{1.0f, 0.0f});
            r19.setDuration(300);
            com.bytedance.android.live.ktv.common.midi.v2.a.a(r19, new RequestSongLabelAnimManager$playMicSeatSponsorView$1(r10));
            r16.add(r19);
            r15.playSequentially(r16);
            r15.start();
            Pair[] r20 = new Pair[5];
            ILinkPlayerInfoBridge r21 = r10.a;
            if (r21 == null) goto L45;
            IBaseUser r22 = r21.getUser();
            if (r22 == null) goto L45;
            String r23 = r22.getIdString();
        L46:
            r20[0] = TuplesKt.to("to_user_id", String.valueOf(r23));
            r20[1] = TuplesKt.to("play_stage", "ongoing");
            r20[2] = TuplesKt.to("naming_userid", r9.getIdString());
            r20[3] = TuplesKt.to("hornor_detail", "golden_microphone");
            r20[4] = TuplesKt.to("crown_type", "golden_microphone");
            Map r24 = MapsKt.mutableMapOf(r20);
            i0 r25 = TalkRoomLogUtils.a;
            TalkRoomLogUtils.c1(r24);
            j0.l().sendLog("livesdk_chatroom_game_naming_show", r24, new Object[]{IRoom.class, x.class});
        L45:
            r23 = null;
        L47:
            Disposable r26 = this.e.m;
            if (r26 == null) goto L50;
            r26.dispose();
        L50:
            this.e.m = RxUtilKt.h(Observable.timer(5000, TimeUnit.MILLISECONDS)).subscribe(new a(this));
            return;
        L15:
            RequestSongMicSeatView r27 = this.e;
            fd0.f r28 = LiveAnimator.a(new View[]{r27.k, r27.g});
            r28.a.d = n.a;
            r28.d(new float[]{1.0f, 1.15f, 0.0f});
            r28.a.b = 500;
            r28.e().i = new k(null);
            goto L16
        }

        public UpdateScoreTask(RequestSongMicSeatView r1, pf0.a r2) {
            this.e = r1;
            super(null);
            this.d = r2;
        }
    }

    public static final class a {
    }

    public final class b extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final /* synthetic */ RequestSongMicSeatView d;

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            q r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(this);
        L5:
            n.d("ShowNoSingTask.Start." + this.d.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.d));
            this.d.v();
            q r1 = this.a;
            if (r1 == null) goto L8;
            r1.b(this);
        L8:
            n.d("ShowNoSingTask.End." + this.d.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.d));
        }

        public b(RequestSongMicSeatView r1) {
            this.d = r1;
            super(null);
        }
    }

    public final class c extends com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b {
        public final String d;
        public final /* synthetic */ RequestSongMicSeatView e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void accept(Object r7) {
                Long r8 = (Long) r7;
                c r9 = this.a;
                if (r9.b == false) goto L7;
                if ((!Intrinsics.areEqual(r9.d, RequestSongMicSeatView.a(r9.e))) == true) goto L7;
            L17:
                c r10 = this.a;
                q r0 = r10.a;
                if (r0 == null) goto L20;
                r0.b(r10);
            L20:
                n.d("ShowScoreTask.End3." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e) + ",token:" + this.a.c);
                if (this.a.e.k() == true) goto L26;
                RequestSongMicSeatView r11 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r12 = r11.i(r11);
                RequestSongMicSeatView r3 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r12, new ShowSingLabelTask(r3, RequestSongMicSeatView.a(r3), this.a.e), false, 6);
                return;
            L26:
                return;
            L7:
                if (RequestSongMicSeatView.d(this.a.e) != RequestSongSingState.STATE_NOSING.getValue()) goto L17;
                n.d("ShowScoreTask.Preempted2." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e) + ",token:" + this.a.c);
                if (RequestSongMicSeatView.c(this.a.e) != RequestSongGoldMicrophoneState.NOSING) goto L11;
                RequestSongMicSeatView r13 = this.a.e;
                com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(r13.i(r13), new b(this.a.e), false, 6);
            L11:
                c r14 = this.a;
                if (r14.b == false) goto L24;
                q r1 = r14.a;
                if (r1 == null) goto L16;
                r1.b(r14);
            L16:
                n.d("ShowScoreTask.End2." + this.a.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.a.e) + ",token:" + this.a.c);
                return;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b
        public final void a() {
            RequestSongMicSeatView r0 = this.e;
            int r1 = RequestSongMicSeatView.w;
            if (r0.k() == false) goto L5;
            return;
        L5:
            q r2 = this.a;
            if (r2 == null) goto L8;
            r2.a(this);
        L8:
            n.d("ShowScoreTask.Start." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e) + ",token:" + this.c);
            if (this.b == true) goto L11;
        L22:
            n.d("ShowScoreTask.Preempted1." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e) + ",token:" + this.c);
            if (this.b == false) goto L29;
            q r3 = this.a;
            if (r3 == null) goto L27;
            r3.b(this);
        L27:
            n.d("ShowScoreTask.End1." + this.e.getMCurPositionInfo() + ",state:" + RequestSongMicSeatView.c(this.e) + ",token:" + this.c);
            return;
        L29:
            return;
        L11:
            if ((!Intrinsics.areEqual(this.d, RequestSongMicSeatView.a(this.e))) == true) goto L22;
            if (RequestSongMicSeatView.d(this.e) == RequestSongSingState.STATE_NOSING.getValue()) goto L22;
            Object r4 = this.c;
            if ((!Intrinsics.areEqual(r4, r4)) == true) goto L22;
            RequestSongMicSeatView.o(this.e);
            RequestSongMicSeatView.h(this.e, RequestSongGoldMicrophoneState.DIGITAL);
            Disposable r5 = this.e.m;
            if (r5 == null) goto L20;
            r5.dispose();
        L20:
            this.e.m = RxUtilKt.h(Observable.timer(5000, TimeUnit.MILLISECONDS)).subscribe(new a(this));
        }

        public c(RequestSongMicSeatView r2, String r3, RequestSongMicSeatView r4) {
            Intrinsics.checkNotNullParameter(r3, "userId");
            this.e = r2;
            super(r4);
            this.d = r3;
        }
    }

    public static final class d implements fd0.b {
        public final /* synthetic */ RequestSongMicSeatView a;
        public final /* synthetic */ Function0 b;

        public d(RequestSongMicSeatView r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // fd0.b
        public final void onStop() {
            TextView r0 = this.a.l;
            if (r0 == null) goto L5;
            UtilityKotlinExtentionsKt.t(r0);
        L5:
            Function0 r1 = this.b;
            if (r1 == null) goto L9;
            Unit r2 = (Unit) r1.invoke();
            return;
        }
    }

    static {
    }

    public RequestSongMicSeatView(Context r7) {
        this(r7, null, 0, false, 14);
    }

    public RequestSongMicSeatView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, false, 12);
    }

    public RequestSongMicSeatView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, false, 8);
    }

    private final String getMAnchorId() {
        return (String) this.d.getValue();
    }

    private final pf0.a getCurrentMicInfo() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L5;
        ConcurrentHashMap<String, pf0.a> r1 = r0.getGuestListInteractiveSongInfo();
    L6:
        String r2 = getCurrentUserId();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.get(r2);
    L5:
        r1 = null;
        goto L6
    }

    private final String getCurrentUserId() {
        ILinkPlayerInfoBridge r0 = this.t;
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L8;
        String r2 = r1.getIdString();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    private final float getMSingingTextWidth() {
        float r0 = n.a(this.l, getSingText());
        float r1 = this.u;
        if (r0 < r1) goto L5;
        return r0;
    L5:
        return r1;
    }

    private final RequestSongGoldMicrophoneState getMicState() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L9;
        ConcurrentHashMap<String, RequestSongGoldMicrophoneState> r1 = r0.getMicSeatStates();
        if (r1 == null) goto L9;
        RequestSongGoldMicrophoneState r2 = r1.get(getCurrentUserId().toString() + '&' + String.valueOf(hashCode()));
        if (r2 == null) goto L9;
        return r2;
    L9:
        return RequestSongGoldMicrophoneState.HIDDEN;
    }

    private final boolean getShowAnchorLabel() {
        ILinkPlayerInfoBridge r0 = this.t;
        if (r0 != null) goto L5;
        return false;
    L5:
        return s(r0, false, false);
    }

    private final int getSingState() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L10;
        ConcurrentHashMap<String, Integer> r1 = r0.getSingingStates();
        if (r1 == null) goto L10;
        Integer r2 = r1.get(getCurrentUserId());
        if (r2 == null) goto L10;
        return r2.intValue();
    L10:
        return RequestSongSingState.STATE_NOSING.getValue();
    }

    private final String getSingText() {
        MicSeatScene r0 = this.f;
        if (r0 == MicSeatScene.AUDIO_LINK_LARGE) goto L15;
        if (r0 == MicSeatScene.AUDIO_LINK) goto L15;
        if (r0 == MicSeatScene.AUDIO_LINK_C_POSITION) goto L15;
        if (r0 == MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L15;
        if (r0 == MicSeatScene.AUDIO_LINK_ANCHOR) goto L15;
        return ((c61) vm2.h.Y4.getValue(null, vm2.h.a[309(0x135, float:4.33E-43)])).video;
    L15:
        return ((c61) vm2.h.Y4.getValue(null, vm2.h.a[309(0x135, float:4.33E-43)])).audio;
    }

    public final boolean k() {
        if (this.a != RequestSongGoldMicrophoneState.PLUS_ANIM) goto L5;
        return true;
    L5:
        return false;
    }

    public final void p() {
        Disposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.m = null;
        i(this).a();
        clearAnimation();
        f r1 = this.q;
        if (r1 == null) goto L13;
        HSImageView r2 = r1.c;
        if (r2 == null) goto L10;
        r2.setController(null);
    L10:
        HSImageView r3 = r1.b;
        if (r3 == null) goto L13;
        r3.setController(null);
    L13:
        v();
    }

    public final void v() {
        Function1<Boolean, Unit> r0 = new RequestSongMicSeatView$showNoSingViewDirectlySyncState$1(this);
        pf0.a r1 = getCurrentMicInfo();
        if (r() == false) goto L5;
        n.d("showNoSingViewDirectly ;;  " + this.t + " ;; label == " + getShowAnchorLabel() + " ;; micInfo == " + r1);
        j(new RequestSongMicSeatView$showNoSingViewDirectly$1(this));
        Unit r2 = (Unit) r0.invoke(Boolean.FALSE);
        return;
    L5:
        u();
        if (r1 == null) goto L8;
        int r3 = r1.b;
    L9:
        n.d("showNoSingViewDirectly ;;  count == " + r3 + " ;; last count == " + this.e);
        q(r3, true);
        View r4 = this.h;
        if (r4 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r4);
    L12:
        View r5 = this.h;
        if (r5 == null) goto L15;
        q32.a.a(r5, (int) n.a(this.k, String.valueOf(r3)));
    L15:
        TextView r6 = this.k;
        if (r6 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r6);
    L18:
        View r7 = this.g;
        if (r7 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r7);
    L21:
        TextView r8 = this.k;
        if (r8 == null) goto L24;
        r8.setScaleX(1.0f);
        r8.setScaleY(1.0f);
        r8.setAlpha(1.0f);
    L24:
        View r9 = this.g;
        if (r9 == null) goto L27;
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        r9.setAlpha(1.0f);
    L27:
        TextView r10 = this.l;
        if (r10 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r10);
    L30:
        TextView r11 = this.j;
        if (r11 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r11);
    L33:
        Unit r12 = (Unit) r0.invoke(Boolean.TRUE);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    public final void n() {
        i(this).a();
        clearAnimation();
        f r0 = this.q;
        if (r0 == null) goto L10;
        HSImageView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setController(null);
    L7:
        HSImageView r2 = r0.b;
        if (r2 == null) goto L10;
        r2.setController(null);
    L10:
        j(new RequestSongMicSeatView$onDetach$1(this));
    }

    public final boolean r() {
        if (getShowAnchorLabel() == false) goto L5;
    L14:
        return true;
    L5:
        if (InteractiveSongContext.Companion.f() == false) goto L14;
        if (TeamFightContext.Companion.h() == false) goto L11;
        if (li0.d.e() == false) goto L14;
    L11:
        if (LinkRoomFightContext.Companion.c() == true) goto L14;
        return false;
    }

    public final void u() {
        UtilityKotlinExtentionsKt.w(this);
        View r0 = this.h;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        PositionNameTv r1 = this.n;
        if (r1 == null) goto L9;
        PositionNameTv.x(r1, this.t, this.p, 0, null, false, 60);
    L9:
        if (s(this.t, false, false) == true) goto L11;
    L12:
        AppCompatTextView r2 = this.o;
        if (r2 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r2);
        return;
    L17:
        return;
    L11:
        if (vm2.d.O() == false) goto L12;
    }

    public final ILinkPlayerInfoBridge getMCurPositionInfo() {
        return this.t;
    }

    public static final /* synthetic */ String a(RequestSongMicSeatView r0) {
        return r0.getCurrentUserId();
    }

    public static final /* synthetic */ String b(RequestSongMicSeatView r0) {
        return r0.getMAnchorId();
    }

    public static final /* synthetic */ RequestSongGoldMicrophoneState c(RequestSongMicSeatView r0) {
        return r0.getMicState();
    }

    public static final /* synthetic */ int d(RequestSongMicSeatView r0) {
        return r0.getSingState();
    }

    public static void o(RequestSongMicSeatView r9) {
        if (r9.i != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L19;
        TextView r1 = r9.k;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r1);
    L11:
        TextView r2 = r9.k;
        if (r2 == null) goto L14;
        r2.setScaleX(0.0f);
    L14:
        TextView r3 = r9.k;
        if (r3 == null) goto L17;
        r3.setScaleY(0.0f);
    L17:
        fd0.f r4 = LiveAnimator.a(new View[]{r9.h});
        r4.a.d = n.b;
        r4.f(new float[]{r9.getMSingingTextWidth(), n.a(r9.k, String.valueOf(n.b(r9.t)))});
        r4.a.b = 500;
        r4.e();
        fd0.f r5 = LiveAnimator.a(new View[]{r9.k});
        Interpolator r6 = n.a;
        r5.a.d = r6;
        r5.d(new float[]{0.0f, 1.15f, 1.0f});
        r5.a.b = 500;
        r5.e().i = new i(null);
        fd0.f r10 = LiveAnimator.a(new View[]{r9.l});
        r10.a.d = r6;
        r10.d(new float[]{1.0f, 1.15f, 0.0f});
        r10.a.b = 500;
        r10.e();
        return;
    L19:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void setPlusN(int r4) {
        TextView r0 = this.j;
        if (r0 == null) goto L6;
        r0.setText("+" + r4);
        return;
    }

    private final void setState(RequestSongGoldMicrophoneState r3) {
        this.a = r3;
        String r0 = getCurrentUserId().toString() + '&' + String.valueOf(hashCode());
        InteractiveSongContext r1 = InteractiveSongContext.Companion.getContext();
        if (r1 == null) goto L7;
        ConcurrentHashMap<String, RequestSongGoldMicrophoneState> r2 = r1.getMicSeatStates();
        if (r2 == null) goto L7;
        RequestSongGoldMicrophoneState r4 = r2.put(r0, r3);
    L7:
        n.d("setState ;; " + this.t + " ;; oldState:" + this.b + " ;; newState:" + getMicState() + " ;; sing:" + getSingState());
        this.b = this.a;
    }

    public final com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a i(RequestSongMicSeatView r8) {
        String r0 = getCurrentUserId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        String r9 = getCurrentUserId().toString() + '&' + String.valueOf(r8.hashCode());
        InteractiveSongContext.Companion.getClass();
        Iterator r2 = InteractiveSongContext.access$getMicSeatTaskExecutors$cp().entrySet().iterator();
    L14:
        if (r2.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r2.next();
        if ((!Intrinsics.areEqual((String) r3.getKey(), r9)) == false) goto L14;
        if (r2.a(getCurrentUserId()) == false) goto L14;
        if (StringsKt.startsWith$default((String) r3.getKey(), getCurrentUserId().toString(), false, 2, null) == false) goto L14;
        r2.remove();
    L22:
        InteractiveSongContext.Companion.getClass();
        ConcurrentHashMap r4 = InteractiveSongContext.access$getMicSeatTaskExecutors$cp();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r5 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a) r4.get(r9);
        if (r5 != null) goto L34;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a r6 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a(this.c);
        r4.put(r9, r6);
        return r6;
    L34:
        return r5;
    L11:
        return new e(this.c);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void j(Function0<Unit> r9) {
        UtilityKotlinExtentionsKt.t(this);
        PositionNameTv r0 = this.n;
        if (r0 == null) goto L5;
        PositionNameTv.x(r0, this.t, this.p, 0, null, false, 60);
    L5:
        ILinkPlayerInfoBridge r1 = this.t;
        if (r1 == null) goto L10;
        g0 r2 = r1.getMicPosTagInfo();
        if (r2 == null) goto L10;
        boolean r4 = this.r;
        int r3 = com.bytedance.android.live.liveinteract.utils.j0.a;
        com.bytedance.android.live.liveinteract.utils.j0.c(this.o, r2, this.t, r4, null, this.f, 16);
    L10:
        r9.invoke();
    }

    public final void setMCurPositionInfo(ILinkPlayerInfoBridge r2) {
        f r0 = this.q;
        if (r0 == null) goto L5;
        r0.a = r2;
    L5:
        this.t = r2;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (r() == false) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        super.setVisibility(r2);
    }

    public final void w(Function0<Unit> r8) {
        if (this.i != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        fd0.f r3 = LiveAnimator.a(new View[]{this.g, this.l});
        r3.a.d = n.a;
        r3.d(new float[]{1.0f, 1.15f, 0.0f});
        r3.a.b = 500;
        r3.e().i = new d(this, r8);
        fd0.f r9 = LiveAnimator.a(new View[]{this.h});
        r9.a.d = n.b;
        r9.f(new float[]{getMSingingTextWidth(), n.a(this.k, String.valueOf(n.b(this.t)))});
        r9.a.b = 500;
        r9.e();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void x(int r3) {
        if (r3 <= 0) goto L15;
        View r4 = this.h;
        if (r4 == null) goto L6;
        r4.setBackground(s1.m(2131249856));
    L6:
        View r5 = this.g;
        if (r5 == null) goto L9;
        r5.setBackground(s1.m(2131251773));
    L9:
        TextView r6 = this.k;
        if (r6 == null) goto L12;
        r6.setTextColor(s1.h(2131108198));
    L12:
        TextView r7 = this.l;
        if (r7 == null) goto L28;
        r7.setTextColor(s1.h(2131108198));
        return;
    L28:
        return;
    L15:
        View r8 = this.h;
        if (r8 == null) goto L18;
        r8.setBackground(s1.m(2131249859));
    L18:
        View r9 = this.g;
        if (r9 == null) goto L21;
        r9.setBackground(s1.m(2131251774));
    L21:
        TextView r10 = this.k;
        if (r10 == null) goto L24;
        r10.setTextColor(s1.h(2131108199));
    L24:
        TextView r11 = this.l;
        if (r11 == null) goto L30;
        r11.setTextColor(s1.h(2131108199));
        return;
    }

    public final void y(boolean r6) {
        n.d("updateRequestSongLabelStatus ;; " + this.t + ", show:" + r6);
        x(n.b(this.t));
        i(this).a();
        if (r() == false) goto L6;
        j(new RequestSongMicSeatView$updateRequestSongLabelStatus$1(this));
        return;
    L6:
        if (r6 == true) goto L8;
        j(new RequestSongMicSeatView$updateRequestSongLabelStatus$2(this));
        return;
    L8:
        ILinkPlayerInfoBridge r7 = this.t;
        if (r7 == null) goto L40;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L41;
        String r9 = r8.getIdString();
        if (r9 == null) goto L42;
        ILinkPlayerInfoBridge r0 = this.t;
        Intrinsics.checkNotNull(r0);
        s(r0, false, false);
        InteractiveSongContext r1 = InteractiveSongContext.Companion.getContext();
        if (r1 == null) goto L17;
        Integer r2 = Integer.valueOf(r1.getSingStateByUserId(r9));
    L18:
        RequestSongGoldMicrophoneState r3 = getMicState();
        if (r2 == null) goto L21;
        int r4 = r2.intValue();
    L23:
        if (r4 != RequestSongSingState.STATE_NOSING.getValue()) goto L26;
        v();
        return;
    L26:
        if (r4 != RequestSongSingState.STATE_SINGING.getValue()) goto L33;
        if (r3 != RequestSongGoldMicrophoneState.SINGING) goto L30;
        return;
    L30:
        if (r3 == RequestSongGoldMicrophoneState.DIGITAL) goto L45;
        i(this).a();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowSingLabelTask(this, r9, this), false, 6);
        return;
    L45:
        return;
    L33:
        if (r4 == RequestSongSingState.STATE_START_SING.getValue()) goto L35;
        v();
        return;
    L35:
        if (r3 == RequestSongGoldMicrophoneState.START_ANIM) goto L47;
        i(this).a();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowStartSingTask(this, r9, this), false, 6);
        return;
    L47:
        return;
    L21:
        r4 = RequestSongSingState.STATE_NOSING.getValue();
        goto L23
    L17:
        r2 = null;
        goto L18
    L42:
        return;
    L41:
        return;
    }

    public final void z(pf0.a r8) {
        Intrinsics.checkNotNullParameter(r8, "info");
        n.d("updateRequestSongMicInfo:" + r8);
        if (getShowAnchorLabel() == false) goto L5;
    L70:
        j(new RequestSongMicSeatView$updateRequestSongMicInfo$1(this));
        return;
    L5:
        if (InteractiveSongContext.Companion.f() == false) goto L70;
        if (TeamFightContext.Companion.h() == true) goto L9;
    L11:
        ILinkPlayerInfoBridge r0 = this.t;
        if (r0 == null) goto L73;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L79;
        Integer r2 = r8.c;
        OrderSingItemAction r3 = OrderSingItemAction.ORDER_SING_START_ITEM;
        int r4 = r3.getValue();
        int r6 = 0;
        if (r2 != null) goto L20;
    L28:
        Integer r5 = r8.c;
        int r7 = OrderSingItemAction.ORDER_SING_DEL_ALL_ITEM.getValue();
        if (r5 == null) goto L35;
        if (r5.intValue() != r7) goto L35;
        i(this).a();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new EndSingTask(this), false, 6);
    L35:
        if ((!Intrinsics.areEqual(r8.a, r1.getIdString())) == false) goto L37;
        return;
    L37:
        x(n.b(this.t));
        Integer r9 = r8.c;
        int r10 = OrderSingItemAction.ORDER_SING_ACTION_UNKNOWN.getValue();
        if (r9 != null) goto L41;
    L42:
        Integer r11 = r8.c;
        int r12 = r3.getValue();
        if (r11 != null) goto L46;
    L48:
        Integer r13 = r8.c;
        int r14 = OrderSingItemAction.ORDER_SING_END_ITEM.getValue();
        if (r13 != null) goto L52;
        return;
    L52:
        if (r13.intValue() != r14) goto L75;
        i(this).a();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new EndSingTask(this), false, 6);
        return;
    L75:
        return;
    L46:
        if (r11.intValue() != r12) goto L48;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowStartSingTask(this, getCurrentUserId(), this), false, 6);
        return;
    L41:
        if (r9.intValue() != r10) goto L42;
        Integer r15 = r8.d;
        if (r15 == null) goto L57;
        int r16 = r15.intValue();
    L58:
        if (r16 <= 0) goto L60;
    L63:
        Integer r17 = r8.d;
        if (r17 == null) goto L66;
        r6 = r17.intValue();
    L66:
        if (r6 <= 0) goto L68;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new UpdateScoreTask(this, r8), true, 2);
        return;
    L68:
        n.d("updateRequestSongMicInfo ;;  micState == " + getMicState() + " ;; singState == " + getSingState());
        return;
    L60:
        if (getMicState() != RequestSongGoldMicrophoneState.NOSING) goto L63;
        v();
        return;
    L57:
        r16 = 0;
        goto L58
    L20:
        if (r2.intValue() != r4) goto L28;
        if ((!Intrinsics.areEqual(r8.a, r1.getIdString())) == false) goto L28;
        i(this).a();
        if (s(this.t, false, false) == false) goto L26;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowAnchorTask(this, r1.getIdString()), false, 6);
        return;
    L26:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new EndSingTask(this), false, 6);
        return;
    L79:
        return;
    L73:
        return;
    L9:
        if (li0.d.g(null) == true) goto L11;
        goto L11
    }

    public static final void f(RequestSongMicSeatView r12, Function0 r13) {
        if (r12.i != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L19;
        TextView r1 = r12.l;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r1);
    L11:
        TextView r2 = r12.l;
        if (r2 == null) goto L14;
        r2.setScaleX(0.0f);
    L14:
        TextView r3 = r12.l;
        if (r3 == null) goto L17;
        r3.setScaleY(0.0f);
    L17:
        fd0.f r4 = LiveAnimator.a(new View[]{r12.g, r12.k});
        Interpolator r5 = n.a;
        r4.a.d = r5;
        r4.d(new float[]{1.0f, 1.15f, 0.0f});
        r4.a.b = 500;
        r4.e();
        fd0.f r6 = LiveAnimator.a(new View[]{r12.l});
        r6.a.d = r5;
        r6.d(new float[]{0.0f, 1.15f, 0.85f, 1.08f, 1.0f});
        LiveAnimator r7 = r6.a;
        r7.b = 500;
        View[] r8 = {r12.h};
        r7.getClass();
        fd0.f r9 = new fd0.f(r7, r8);
        ((ArrayList) r7.a).add(r9);
        r9.a.d = n.b;
        r9.f(new float[]{n.a(r12.k, String.valueOf(n.b(r12.t))), r12.getMSingingTextWidth()});
        r9.a.b = 250;
        r9.e();
        fd0.f r14 = LiveAnimator.a(new View[]{r12.g});
        LiveAnimator r10 = r14.a;
        r10.d = r5;
        r10.c = 3000;
        r14.d(new float[]{0.0f, 1.15f, 1.0f});
        r14.a.b = 500;
        r14.e().i = new j(r13);
        return;
    L19:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void g(RequestSongMicSeatView r9, Function0 r10) {
        if (r9.k() == false) goto L6;
        return;
    L6:
        if (r9.i != null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L20;
        View r1 = r9.g;
        if (r1 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r1);
    L14:
        TextView r2 = r9.l;
        if (r2 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r2);
    L17:
        fd0.f r3 = LiveAnimator.a(new View[]{r9.k});
        Interpolator r4 = n.a;
        r3.a.d = r4;
        r3.d(new float[]{1.0f, 1.15f, 0.0f});
        r3.a.b = 500;
        r3.e();
        fd0.f r5 = LiveAnimator.a(new View[]{r9.g, r9.l});
        r5.a.d = r4;
        r5.d(new float[]{0.0f, 1.15f, 1.0f});
        r5.a.b = 500;
        r5.e();
        fd0.f r6 = LiveAnimator.a(new View[]{r9.h});
        r6.a.d = n.b;
        r6.f(new float[]{n.a(r9.k, String.valueOf(n.b(r9.t))), r9.getMSingingTextWidth()});
        r6.a.b = 500;
        r6.e().i = new g(r10);
        return;
    L20:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public static final /* synthetic */ void h(RequestSongMicSeatView r0, RequestSongGoldMicrophoneState r1) {
        r0.setState(r1);
    }

    public final void l(ILinkPlayerInfoBridge r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "info");
        IBaseUser r0 = r7.getUser();
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdString();
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        j(new RequestSongMicSeatView$onBind$1(this));
        return;
    L16:
        n.d("onBind ;; position:" + r7 + ",lastPosition:" + this.t + ",state:" + getMicState() + ",sing:" + getSingState());
        setMCurPositionInfo(r7);
        if (r() == false) goto L20;
        n.d("onBind ;; position:" + r8 + ",RequestSong Off,hide");
        j(new RequestSongMicSeatView$onBind$2(this));
        return;
    L20:
        p();
        x(n.b(this.t));
        s(r7, false, false);
        InteractiveSongContext r9 = InteractiveSongContext.Companion.getContext();
        if (r9 == null) goto L23;
        r1 = Integer.valueOf(r9.getSingStateByUserId(r2));
    L23:
        RequestSongGoldMicrophoneState r10 = getMicState();
        n.d("initState.state:" + r10 + ",singState:" + r1);
        if (r1 == null) goto L26;
        int r11 = r1.intValue();
    L28:
        if (r11 != RequestSongSingState.STATE_SINGING.getValue()) goto L37;
        if (getShowAnchorLabel() == false) goto L32;
        j(new RequestSongMicSeatView$initState$1(this));
    L46:
        if (this.f != MicSeatScene.AUDIO_LINK_DYNAMIC_ISLAND) goto L63;
        View r12 = this.i;
        if (r12 == null) goto L50;
        UtilityKotlinExtentionsKt.t(r12);
    L50:
        View r13 = this.h;
        if (r13 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r13);
    L53:
        View r14 = this.h;
        if (r14 == null) goto L56;
        r14.setAlpha(0.0f);
    L56:
        View r4 = findViewById(2131384394);
        if (r4 == null) goto L59;
        r4.setAlpha(0.0f);
    L59:
        View r15 = findViewById(2131384394);
        if (r15 == null) goto L64;
        UtilityKotlinExtentionsKt.t(r15);
        return;
    L64:
        return;
    L63:
        return;
    L32:
        if (r10 != RequestSongGoldMicrophoneState.NOSING) goto L34;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowStartSingTask(this, r2, this), false, 6);
        goto L46
    L34:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowSingLabelTask(this, r2, this), false, 6);
        goto L46
    L37:
        if (r11 != RequestSongSingState.STATE_START_SING.getValue()) goto L42;
        if (r10 == RequestSongGoldMicrophoneState.START_ANIM) goto L46;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a.c(i(this), new ShowStartSingTask(this, r2, this), false, 6);
        goto L46
    L42:
        if (getShowAnchorLabel() == true) goto L44;
        v();
        goto L46
    L44:
        j(new RequestSongMicSeatView$initState$2(this));
        goto L46
    L26:
        r11 = RequestSongSingState.STATE_NOSING.getValue();
        goto L28
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final void q(int r2, boolean r3) {
        UtilityKotlinExtentionsKt.w(this);
        View r0 = this.h;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        if (r3 == false) goto L10;
        TextView r4 = this.k;
        if (r4 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r4);
    L10:
        if (r2 <= 999) goto L12;
        String r5 = "999";
    L13:
        TextView r1 = this.k;
        if (r1 == null) goto L16;
        r1.setText(r5);
    L16:
        this.e = r2;
        return;
    L12:
        r5 = String.valueOf(r2);
        goto L13
    }

    public static final void e(RequestSongMicSeatView r9, pf0.a r10, Function0 r11) {
        if (r9.i != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L32;
        TextView r1 = r9.j;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r1);
    L11:
        TextView r2 = r9.l;
        if (r2 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r2);
    L14:
        if (r10 == null) goto L18;
        Integer r3 = r10.d;
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
    L19:
        r9.setPlusN(r4);
        if (r10 == null) goto L22;
        int r12 = r10.b;
    L23:
        r9.q(r12, false);
        View r13 = r9.h;
        if (r13 == null) goto L30;
        TextView r5 = r9.j;
        if (r5 == null) goto L28;
        CharSequence r6 = r5.getText();
    L29:
        q32.a.a(r13, (int) n.a(r5, String.valueOf(r6)));
        goto L30
    L28:
        r6 = null;
    L30:
        fd0.f r14 = LiveAnimator.a(new View[]{r9.j});
        Interpolator r7 = n.a;
        r14.a.d = r7;
        r14.d(new float[]{0.0f, 1.15f, 1.0f});
        r14.a.b = 500;
        r14.e();
        fd0.f r15 = LiveAnimator.a(new View[]{r9.j});
        LiveAnimator r8 = r15.a;
        r8.c = 3000;
        r8.d = r7;
        r15.d(new float[]{1.0f, 1.15f, 0.0f});
        r15.a.b = 500;
        r15.e().i = new h(r9, r11);
        return;
    L22:
        r12 = 0;
    L18:
        r4 = 1;
        goto L19
    L32:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean s(ILinkPlayerInfoBridge r7, boolean r8, boolean r9) {
        if (r7 == null) goto L8;
        g0 r1 = r7.getMicPosTagInfo();
        if (r1 == null) goto L8;
        if (r1.getTagType() != 3) goto L8;
        return true;
    L8:
        String r2 = getMAnchorId();
        String r3 = null;
        if (r7 == null) goto L13;
        IBaseUser r4 = r7.getUser();
        if (r4 == null) goto L13;
        String r5 = r4.getIdString();
    L15:
        if (Intrinsics.areEqual(r2, r5) == false) goto L29;
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r6.getLinkUserInfoCenter();
        if (r10 == null) goto L25;
        List<T> r11 = r10.getOnlineUserList();
        if (r11 == 0) goto L25;
        boolean r12 = CPositionModeUtil.hasCPositionUser(r11);
    L26:
        if (r12 == false) goto L29;
        if (r7.isEnlarged() == true) goto L29;
        return true;
    L25:
        r12 = false;
    L29:
        String r13 = getMAnchorId();
        if (r7 == null) goto L35;
        IBaseUser r14 = r7.getUser();
        if (r14 == null) goto L35;
        r3 = r14.getIdString();
    L35:
        if (Intrinsics.areEqual(r13, r3) == true) goto L37;
    L44:
        if (r8 == false) goto L50;
        if (r7 == null) goto L50;
        if (r7.isEnlarged() == true) goto L50;
        if (r9 == false) goto L50;
        return true;
    L50:
        return false;
    L37:
        if (r7.isEnlarged() == true) goto L44;
        CPositionContext r15 = CPositionContext.Companion.getContext();
        if (r15 == null) goto L44;
        com.bytedance.live.datacontext.m<Boolean> r16 = r15.isCPositionOpen();
        if (r16 == null) goto L44;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L44;
        return true;
    L13:
        r5 = null;
        goto L15
    }

    public final void t(int r1, ILinkPlayerInfoBridge r2, boolean r3, boolean r4) {
        if (s(r2, r3, r4) == false) goto L6;
        j(new RequestSongMicSeatView$showFeedViewMicrophoneDirectly$1(this));
        return;
    L6:
        u();
        q(r1, true);
        View r5 = this.h;
        if (r5 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r5);
    L9:
        View r6 = this.h;
        if (r6 == null) goto L12;
        q32.a.a(r6, (int) n.a(this.k, String.valueOf(r1)));
    L12:
        TextView r7 = this.k;
        if (r7 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r7);
    L15:
        View r8 = this.g;
        if (r8 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r8);
    L18:
        TextView r9 = this.k;
        if (r9 == null) goto L21;
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        r9.setAlpha(1.0f);
    L21:
        View r10 = this.g;
        if (r10 == null) goto L24;
        r10.setScaleX(1.0f);
        r10.setScaleY(1.0f);
        r10.setAlpha(1.0f);
    L24:
        TextView r11 = this.l;
        if (r11 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r11);
    L27:
        TextView r12 = this.j;
        if (r12 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r12);
    L30:
        x(r1);
    }

    public RequestSongMicSeatView(Context r3, AttributeSet r4, int r5, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.v = r6;
        RequestSongGoldMicrophoneState r8 = RequestSongGoldMicrophoneState.HIDDEN;
        this.a = r8;
        this.b = r8;
        this.c = com.bytedance.android.live.core.utils.i0.c();
        this.d = LazyKt.lazy(RequestSongMicSeatView$mAnchorId$2.INSTANCE);
        this.e = -1;
        this.f = MicSeatScene.AUDIO_LINK;
        this.u = s1.f(53.0f);
    }

    public static void m(RequestSongMicSeatView r4, Context r5, MicSeatScene r6, PositionNameTv r7, SeatPosTagLabelTextView r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, xg0.a r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r8 = null;
    L6:
        if ((r15 & 16) == 0) goto L9;
        r9 = false;
    L9:
        if ((r15 & 32) == 0) goto L12;
        r10 = true;
    L12:
        if ((r15 & 64) == 0) goto L15;
        r11 = false;
    L15:
        if ((r15 & 128) == 0) goto L18;
        r12 = false;
    L18:
        if ((r15 & 256) == 0) goto L21;
        r13 = false;
    L21:
        if ((r15 & 512) == 0) goto L23;
        r14 = null;
    L23:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        r4.f = r6;
        r4.p = r9;
        LayoutInflater r16 = LayoutInflater.from(r5);
        if (r6 != MicSeatScene.AUDIO_LINK_LARGE) goto L30;
        if (r4.v == false) goto L28;
        int r17 = 2131565199;
    L59:
        r16.inflate(r17, r4, true);
        r4.i = r4.findViewById(2131375535);
        r4.h = r4.findViewById(2131375536);
        r4.g = r4.findViewById(2131384388);
        r4.k = (TextView) r4.findViewById(2131384390);
        TextView r18 = (TextView) r4.findViewById(2131384391);
        r4.l = r18;
        if (r18 == null) goto L62;
        r18.setText(r4.getSingText());
    L62:
        r4.j = (TextView) r4.findViewById(2131384389);
        if (r10 == false) goto L65;
        f r19 = new f(r4.findViewById(2131384394), r4.findViewById(2131384397), (MicSeatSponsorView) r4.findViewById(2131378753));
        r4.q = r19;
        r19.a = r4.t;
    L65:
        r4.n = r7;
        r4.o = r8;
        r4.r = r12;
        r4.x(n.b(r4.t));
        r4.s = r14;
        return;
    L28:
        r17 = 2131565198;
        goto L59
    L30:
        if (r6 != MicSeatScene.AUDIO_LINK) goto L36;
        if (r4.v == false) goto L34;
        r17 = 2131565196;
        goto L59
    L34:
        r17 = 2131565194;
        goto L59
    L36:
        if (r6 != MicSeatScene.AUDIO_LINK_DYNAMIC_ISLAND) goto L39;
        r17 = 2131565197;
        goto L59
    L39:
        if (r6 != MicSeatScene.AUDIO_LINK_C_POSITION) goto L46;
        if (r4.v == false) goto L44;
        if (r13 == false) goto L52;
        r17 = 2131565192;
    L52:
        r17 = 2131565191;
        goto L59
    L44:
        r17 = 2131565190;
        goto L59
    L46:
        if (r6 != MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L49;
        r17 = 2131565193;
        goto L59
    L49:
        if (r6 == MicSeatScene.AUDIO_LINK_ANCHOR) goto L51;
        if (r10 == false) goto L58;
        if (r11 == false) goto L57;
        r17 = 2131567589;
        goto L59
    L57:
        r17 = 2131567588;
        goto L59
    L58:
        r17 = 2131567587;
        goto L59
    L51:
        if (r4.v == true) goto L52;
        r17 = 2131565195;
        goto L59
    }
}
