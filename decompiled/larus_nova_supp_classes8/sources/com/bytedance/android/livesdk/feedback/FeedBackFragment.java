package com.bytedance.android.livesdk.feedback;

import am2.x;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.x3;
import com.bytedance.android.livesdk.explore.view.AbsBaseFragment;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdk.feedback.view.feedback.GlobalQuestionFeedback;
import com.bytedance.android.livesdk.feedback.view.feedback.LargeCardPreviewFeedback;
import com.bytedance.android.livesdk.feedback.view.feedback.LynxFeedbackView;
import com.bytedance.android.livesdk.feedback.view.feedback.RoomQuestionFeedback;
import com.bytedance.android.livesdk.feedback.view.feedback.SmallCardPreviewFeedback;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/FeedBackFragment;", "Lcom/bytedance/android/livesdk/explore/view/AbsBaseFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedBackFragment extends AbsBaseFragment {
    public static final /* synthetic */ int p = 0;
    public FeedItem f;
    public Long g;
    public FeedbackCard h;
    public dx1.a i;
    public long j;
    public boolean k;
    public boolean l;
    public final Function0<Unit> m;
    public final Function0<Unit> n;
    public final Lazy o;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ FeedBackFragment a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View r0 = this.a.getView();
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            View r2 = this.a.getView();
            if (r2 == null) goto L13;
            dx1.a r3 = this.a.i;
            if (r3 == null) goto L14;
            r2.getWidth();
            r2.getHeight();
            r3.b();
            return;
        L14:
            return;
        }

        public b(FeedBackFragment r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final FeedbackContext T90() {
        return (FeedbackContext) this.o.getValue();
    }

    public final void forceSmoothExit() {
    }

    public final LiveMode getStreamType() {
        return null;
    }

    public final as0.a roomPlayerContext() {
        return null;
    }

    public final String S90() {
        FeedbackCard r0 = this.h;
        if (r0 == null) goto L5;
        Integer r1 = r0.feedbackType;
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
    L21:
        if (r1 != null) goto L24;
    L26:
        return "";
    L24:
        if (r1.intValue() != 1) goto L26;
    L25:
        return "questionnaire";
    L19:
        if (r1.intValue() != 2) goto L21;
    L14:
        if (r1.intValue() != 3) goto L16;
        return "small_card";
    L9:
        if (r1.intValue() != 4) goto L11;
        return "big_card";
    L5:
        r1 = null;
        goto L6
    }

    public final String U90() {
        FeedbackCard r0 = this.h;
        if (r0 == null) goto L5;
        Integer r1 = r0.feedbackType;
    L7:
        if (r1 != null) goto L10;
    L12:
        if (r1 != null) goto L15;
    L17:
        if (r1 != null) goto L20;
    L22:
        if (r1 != null) goto L25;
    L27:
        if (r1 != null) goto L30;
    L32:
        if (r1 != null) goto L35;
    L37:
        return "";
    L35:
        if (r1.intValue() != 3) goto L37;
    L36:
        return "multiple";
    L30:
        if (r1.intValue() != 4) goto L32;
    L25:
        if (r1.intValue() != 2) goto L27;
        return "whole";
    L20:
        if (r1.intValue() != 10) goto L22;
        return "single";
    L15:
        if (r1.intValue() != 6) goto L17;
        return "single";
    L10:
        if (r1.intValue() != 1) goto L12;
        return "single";
    L5:
        r1 = null;
        goto L7
    }

    public final void onSlide() {
        dx1.a r0 = this.i;
        if (r0 == null) goto L6;
        r0.onSlide();
        return;
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment
    public final void startRoom() {
        super.startRoom();
        this.l = true;
        FeedbackManager.Companion.getClass();
        FeedbackManager r2 = FeedbackManager.b.a();
        if (r2 == null) goto L5;
        r2.onReadFeedback(this.f);
    L5:
        dx1.a r3 = this.i;
        if (r3 == null) goto L8;
        r3.startRoom();
    L8:
        this.j = System.currentTimeMillis();
        IFeedbackApi r4 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
        FeedbackCard r5 = this.h;
        long r14 = 0;
        if (r5 == null) goto L13;
        Long r6 = r5.feedbackId;
        if (r6 == null) goto L13;
        long r7 = r6.longValue();
    L14:
        FeedbackCard r8 = this.h;
        if (r8 == null) goto L19;
        Long r9 = r8.roomId;
        if (r9 == null) goto L19;
        long r10 = r9.longValue();
    L20:
        FeedbackCard r11 = this.h;
        if (r11 == null) goto L25;
        Integer r12 = r11.feedbackType;
        if (r12 == null) goto L25;
        int r13 = r12.intValue();
    L26:
        FeedItem r15 = this.f;
        if (r15 == null) goto L33;
        FeedbackCard r16 = r15.feedbackCard;
        if (r16 == null) goto L33;
        Room r17 = r16.room;
        if (r17 == null) goto L33;
        LiveMode r18 = r17.getStreamType();
    L34:
        int r19 = h1.a;
        String r110 = i1.a(r18);
        FeedbackCard r111 = this.h;
        if (r111 == null) goto L39;
        Integer r112 = r111.getIndex();
        if (r112 == null) goto L39;
        int r113 = r112.intValue();
    L40:
        FeedbackCard r114 = this.h;
        if (r114 == null) goto L45;
        Room r115 = r114.room;
        if (r115 == null) goto L45;
        Long r116 = Long.valueOf(r115.id);
    L46:
        FeedbackContext.a r117 = FeedbackContext.Companion;
        int r118 = hashCode();
        r117.getClass();
        FeedbackContext r119 = FeedbackContext.a.a(r118);
        if (r119 == null) goto L49;
        Long r120 = r119.getMPreRoomId();
    L50:
        boolean r121 = !Intrinsics.areEqual(r116, r120);
        FeedbackCard r122 = this.h;
        if (r122 == null) goto L53;
        int r123 = r122.getScene();
    L54:
        ((ObservableSubscribeProxy) r4.feedbackCardShow(r7, r10, 0, r13, r110, r113, r121, r123).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this))).subscribe(c.a, d.a);
        e r20 = com.bytedance.android.livesdk.sharedpref.b.W2;
        Boolean r21 = Boolean.FALSE;
        r20.getClass();
        f.d(r20, r21);
        e r22 = com.bytedance.android.livesdk.sharedpref.b.U2;
        Long r23 = Long.valueOf(System.currentTimeMillis());
        r22.getClass();
        f.d(r22, r23);
        if ((this.i instanceof LynxFeedbackView) == true) goto L133;
        LinkedHashMap r24 = new LinkedHashMap();
        FeedbackContext r25 = FeedbackContext.a.a(hashCode());
        String r26 = "";
        if (r25 == null) goto L60;
        String r27 = r25.getEnterFromMerge();
        if (r27 == null) goto L60;
    L61:
        r24.put("enter_from_merge", r27);
        FeedbackContext r28 = FeedbackContext.a.a(hashCode());
        if (r28 == null) goto L65;
        String r29 = r28.getEnterMethod();
        if (r29 == null) goto L65;
    L66:
        r24.put("enter_method", r29);
        FeedItem r30 = this.f;
        if (r30 == null) goto L74;
        FeedbackCard r31 = r30.feedbackCard;
        if (r31 == null) goto L74;
        Room r32 = r31.room;
        if (r32 == null) goto L74;
        String r33 = String.valueOf(r32.id);
        if (r33 == null) goto L74;
    L75:
        r24.put("room_id", r33);
        FeedItem r34 = this.f;
        if (r34 == null) goto L85;
        FeedbackCard r35 = r34.feedbackCard;
        if (r35 == null) goto L85;
        Room r36 = r35.room;
        if (r36 == null) goto L85;
        User r37 = r36.getOwner();
        if (r37 == null) goto L85;
        String r38 = r37.getIdString();
        if (r38 == null) goto L85;
    L86:
        r24.put("anchor_id", r38);
        FeedbackContext r39 = FeedbackContext.a.a(hashCode());
        if (r39 == null) goto L90;
        String r40 = r39.getReqId();
        if (r40 == null) goto L90;
    L91:
        r24.put("request_id", r40);
        FeedItem r41 = this.f;
        if (r41 == null) goto L99;
        FeedbackCard r42 = r41.feedbackCard;
        if (r42 == null) goto L99;
        Long r43 = r42.feedbackId;
        if (r43 == null) goto L99;
        String r44 = String.valueOf(r43.longValue());
        if (r44 == null) goto L99;
    L100:
        r24.put("feedback_id", r44);
        FeedItem r45 = this.f;
        if (r45 == null) goto L108;
        FeedbackCard r46 = r45.feedbackCard;
        if (r46 == null) goto L108;
        Integer r47 = r46.getIndex();
        if (r47 == null) goto L108;
        String r48 = String.valueOf(r47.intValue());
        if (r48 == null) goto L108;
    L109:
        r24.put("draw_order", r48);
        r24.put("flow_type", "internal_flow");
        FeedItem r49 = this.f;
        if (r49 == null) goto L115;
        FeedbackCard r50 = r49.feedbackCard;
        if (r50 == null) goto L115;
        String r51 = r50.getLogInfo();
        if (r51 == null) goto L115;
    L116:
        r24.put("question_text", r51);
        r24.put("card_type", S90());
        r24.put("question_type", U90());
        o r52 = u.l().c(x.class);
        if (r52 == null) goto L124;
        Map r53 = r52.getMap();
        if (r53 == null) goto L124;
        String r54 = (String) r53.get("action_type");
        if (r54 == null) goto L124;
        r26 = r54;
    L124:
        r24.put("action_type", r26);
        FeedItem r55 = this.f;
        if (r55 == null) goto L131;
        FeedbackCard r56 = r55.feedbackCard;
        if (r56 == null) goto L131;
        Room r57 = r56.room;
        if (r57 == null) goto L131;
        LiveMode r58 = r57.getStreamType();
    L132:
        r24.put("live_type", i1.a(r58));
        u.l().sendLog("livesdk_live_feedback_card_show", r24, new Object[0]);
    L131:
        r58 = null;
    L115:
        r51 = "";
    L108:
        r48 = "";
    L99:
        r44 = "";
    L90:
        r40 = "";
    L85:
        r38 = "";
    L74:
        r33 = "";
    L65:
        r29 = "";
    L60:
        r27 = "";
    L133:
        FeedbackCard r59 = this.h;
        if (r59 != null) goto L136;
        return;
    L136:
        if (r59.getFromPreview() != true) goto L156;
        IService r1 = k.f(ILiveFeedbackService.class);
        if ((r1 instanceof LiveFeedbackService) == true) goto L140;
        r1 = null;
    L140:
        LiveFeedbackService r60 = (LiveFeedbackService) r1;
        if (r60 == null) goto L157;
        Map<Long, Long> r61 = r60.getRoomFeedbackCache();
        if (r61 == null) goto L158;
        FeedbackCard r62 = this.h;
        if (r62 == null) goto L149;
        Room r63 = r62.room;
        if (r63 == null) goto L149;
        r14 = r63.id;
    L149:
        Long r64 = Long.valueOf(r14);
        FeedbackCard r65 = this.h;
        if (r65 == null) goto L152;
        Long r66 = r65.feedbackId;
    L153:
        Long r67 = r61.put(r64, r66);
        return;
    L152:
        r66 = null;
        goto L153
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L53:
        r123 = -1;
        goto L54
    L49:
        r120 = null;
    L45:
        r116 = null;
    L39:
        r113 = -1;
    L33:
        r18 = null;
    L25:
        r13 = -1;
    L19:
        r10 = 0;
    L13:
        r7 = 0;
        goto L14
    }

    public FeedBackFragment() {
        this.m = new FeedBackFragment$onSubmitAction$1(this);
        this.n = new FeedBackFragment$onLynxSubmitAction$1(this);
        this.o = LazyKt.lazy(new FeedBackFragment$feedbackContext$2(this));
    }

    public final void V90() {
        long r0 = System.currentTimeMillis();
        long r2 = this.j;
        if (r0 > r2) goto L5;
        return;
    L5:
        if (r2 == 0) goto L77;
        LinkedHashMap r3 = new LinkedHashMap();
        FeedbackContext.a r4 = FeedbackContext.Companion;
        int r6 = hashCode();
        r4.getClass();
        FeedbackContext r5 = FeedbackContext.a.a(r6);
        String r7 = "";
        if (r5 == null) goto L10;
        String r8 = r5.getEnterFromMerge();
        if (r8 == null) goto L10;
    L11:
        r3.put("enter_from_merge", r8);
        FeedbackContext r9 = FeedbackContext.a.a(hashCode());
        if (r9 == null) goto L15;
        String r10 = r9.getEnterMethod();
        if (r10 == null) goto L15;
    L16:
        r3.put("enter_method", r10);
        FeedItem r11 = this.f;
        if (r11 == null) goto L24;
        FeedbackCard r12 = r11.feedbackCard;
        if (r12 == null) goto L24;
        Room r13 = r12.room;
        if (r13 == null) goto L24;
        String r14 = String.valueOf(r13.id);
        if (r14 == null) goto L24;
    L25:
        r3.put("room_id", r14);
        FeedItem r15 = this.f;
        if (r15 == null) goto L35;
        FeedbackCard r16 = r15.feedbackCard;
        if (r16 == null) goto L35;
        Room r17 = r16.room;
        if (r17 == null) goto L35;
        User r18 = r17.getOwner();
        if (r18 == null) goto L35;
        String r19 = r18.getIdString();
        if (r19 == null) goto L35;
    L36:
        r3.put("anchor_id", r19);
        FeedbackContext r20 = FeedbackContext.a.a(hashCode());
        if (r20 == null) goto L40;
        String r21 = r20.getReqId();
        if (r21 == null) goto L40;
    L41:
        r3.put("request_id", r21);
        FeedItem r22 = this.f;
        if (r22 == null) goto L49;
        FeedbackCard r23 = r22.feedbackCard;
        if (r23 == null) goto L49;
        Long r24 = r23.feedbackId;
        if (r24 == null) goto L49;
        String r25 = String.valueOf(r24.longValue());
        if (r25 == null) goto L49;
    L50:
        r3.put("feedback_id", r25);
        r3.put("duration", String.valueOf(r0 - this.j));
        FeedItem r1 = this.f;
        if (r1 == null) goto L58;
        FeedbackCard r26 = r1.feedbackCard;
        if (r26 == null) goto L58;
        Integer r27 = r26.getIndex();
        if (r27 == null) goto L58;
        String r28 = String.valueOf(r27.intValue());
        if (r28 == null) goto L58;
    L59:
        r3.put("draw_order", r28);
        r3.put("flow_type", "internal_flow");
        FeedItem r29 = this.f;
        if (r29 == null) goto L65;
        FeedbackCard r30 = r29.feedbackCard;
        if (r30 == null) goto L65;
        String r31 = r30.getLogInfo();
        if (r31 == null) goto L65;
    L66:
        r3.put("question_text", r31);
        r3.put("card_type", S90());
        r3.put("question_type", U90());
        o r32 = u.l().c(x.class);
        if (r32 == null) goto L74;
        Map r33 = r32.getMap();
        if (r33 == null) goto L74;
        String r34 = (String) r33.get("action_type");
        if (r34 == null) goto L74;
        r7 = r34;
    L74:
        r3.put("action_type", r7);
        u.l().sendLog("livesdk_live_feedback_card_duration", r3, new Object[0]);
        this.j = 0;
        return;
    L65:
        r31 = "";
    L58:
        r28 = "";
    L49:
        r25 = "";
    L40:
        r21 = "";
    L35:
        r19 = "";
    L24:
        r14 = "";
    L15:
        r10 = "";
    L10:
        r8 = "";
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        dx1.a r0 = this.i;
        if (r0 == null) goto L5;
        r0.stopRoom();
    L5:
        dx1.a r1 = this.i;
        if (r1 == null) goto L9;
        r1.onDestroy();
        return;
    }

    public final void onPause() {
        super.onPause();
        this.k = true;
        if (this.l == false) goto L8;
        dx1.a r0 = this.i;
        if (r0 == null) goto L9;
        r0.stopRoom();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.l == false) goto L12;
        dx1.a r0 = this.i;
        if (r0 == null) goto L9;
        r0.startRoom();
    L9:
        this.k = false;
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (r2.orientation != 1) goto L10;
        View r3 = getView();
        if (r3 == null) goto L11;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L12;
        r4.addOnGlobalLayoutListener(new b(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment
    public final void stopRoom(String r1) {
        super.stopRoom(r1);
        this.l = false;
        dx1.a r2 = this.i;
        if (r2 == null) goto L5;
        r2.stopRoom();
    L5:
        V90();
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment
    public final void stopRoomWithoutReleasePlayer(boolean r1) {
        dx1.a r2 = this.i;
        if (r2 == null) goto L5;
        r2.stopRoom();
    L5:
        V90();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        dx1.a r4 = this.i;
        if (r4 == null) goto L5;
        r4.onViewCreated(r2);
    L5:
        dx1.a r5 = this.i;
        if (r5 == null) goto L9;
        r5.c(this.h);
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Context r8 = getContext();
        if (r8 != null) goto L5;
        return null;
    L5:
        FeedbackContext r1 = T90();
        Fragment r2 = getParentFragment();
        if (r2 == null) goto L8;
        Bundle r3 = r2.getArguments();
    L9:
        r1.configContext(r3);
        FeedbackContext r4 = T90();
        FeedItem r9 = this.f;
        if (r9 == null) goto L12;
        String r10 = r9.resId;
    L13:
        r4.setReqId(r10);
        T90().setMFeedbackCard(this.h);
        T90().setMPreRoomId(this.g);
        com.bytedance.live.datacontext.d.c(T90(), FeedbackContext.TAG + hashCode());
        FeedbackCard r11 = this.h;
        if (r11 == null) goto L16;
        Integer r12 = r11.feedbackType;
    L17:
        if (r12 != null) goto L20;
    L25:
        if (r12 != null) goto L28;
    L33:
        if (r12 != null) goto L36;
    L38:
        if (r12 != null) goto L41;
    L43:
        dx1.a r13 = null;
    L44:
        this.i = r13;
        if (r13 != null) goto L47;
        return null;
    L47:
        return r13.a(r5, r6);
    L41:
        if (r12.intValue() != 4) goto L43;
        r13 = new LargeCardPreviewFeedback(r8, T90(), this.m);
        goto L44
    L36:
        if (r12.intValue() != 3) goto L38;
        r13 = new SmallCardPreviewFeedback(r8, T90(), this.m);
        goto L44
    L28:
        if (r12.intValue() != 2) goto L33;
        if (x3.a.getValue().booleanValue() == false) goto L32;
        r13 = new LynxFeedbackView(r8, T90(), this.n);
        goto L44
    L32:
        r13 = new GlobalQuestionFeedback(r8, T90(), this.m);
        goto L44
    L20:
        if (r12.intValue() != 1) goto L25;
        if (x3.a.getValue().booleanValue() == false) goto L24;
        r13 = new LynxFeedbackView(r8, T90(), this.n);
        goto L44
    L24:
        r13 = new RoomQuestionFeedback(r8, T90(), this.m);
        goto L44
    L16:
        r12 = null;
        goto L17
    L12:
        r10 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }
}
