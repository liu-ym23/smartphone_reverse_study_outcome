package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.config.u4;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RoomQuestionFeedback implements dx1.a {
    public ViewGroup a;
    public FrameLayout b;
    public TextView c;
    public HSImageView d;
    public SimpleDraweeView e;
    public SimpleDraweeView f;
    public SimpleMediaView g;
    public TextView h;
    public TextView i;
    public ViewGroup j;
    public FeedbackCard k;
    public Question l;
    public LivePlayerView m;
    public ILivePlayerClient n;
    public nx1.b o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Function0<Unit> u;
    public final a v;
    public final Context w;
    public final FeedbackContext x;
    public final Function0<Unit> y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RoomQuestionFeedback a;

        public a(RoomQuestionFeedback r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.u.invoke();
        }
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // dx1.a
    public final void startRoom() {
        ViewParent r0 = null;
        SimpleMediaView r3 = this.g;     // Catch: Exception -> L17
        if (r3 != null) goto L6;
    L18:
        FeedbackCard r4 = this.k;
        if (r4 == null) goto L49;
        final Room r5 = r4.room;
        if (r5 == null) goto L52;
        FrameLayout r6 = this.b;     // Catch: Exception -> L44
        if (r6 == null) goto L50;
        d(this.w, r5);     // Catch: Exception -> L44
        if (r6.indexOfChild(this.m) >= 0) goto L40;
        LivePlayerView r7 = this.m;     // Catch: Exception -> L44
        if (r7 == null) goto L36;
        r7.setVisibility(8);     // Catch: Exception -> L44
        ViewParent r8 = r7.getParent();     // Catch: Exception -> L44
        if ((r8 instanceof ViewGroup) == false) goto L33;
        r0 = r8;
    L33:
        ViewGroup r1 = (ViewGroup) r0;     // Catch: Exception -> L44
        if (r1 == null) goto L36;
        r1.removeView(this.m);     // Catch: Exception -> L44
    L36:
        LivePlayerView r2 = this.m;     // Catch: Exception -> L44
        if (r2 == null) goto L39;
        r2.setVisibility(0);     // Catch: Exception -> L44
    L39:
        r6.addView(this.m);     // Catch: Exception -> L44
    L40:
        LiveRequest r9 = new LiveRequest.Builder().streamData(r5.getMultiStreamData()).resolution(ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r5, false, true, 2, null)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r5.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L44
        ILivePlayerClient r10 = this.n;     // Catch: Exception -> L44
        if (r10 == null) goto L51;
        r10.stream(r9, new RoomQuestionFeedback$innerPlay$$inlined$let$lambda$1(this, r5));     // Catch: Exception -> L44
        return;
    L51:
        return;
    L50:
        return;
    L53:
        return;
    L52:
        return;
    L49:
        return;
    L6:
        if (r3.h() == false) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L18;
        r3.setPlayEntity((tic.a) this.s.getValue());     // Catch: Exception -> L17
        r3.k();     // Catch: Exception -> L17
        r3.setLoop(true);     // Catch: Exception -> L17
        goto L18
    L8:
        if (((tic.a) this.s.getValue()) == null) goto L10;
        r11 = true;
    L17:
        ALogger.d("FeedbackMediaPlayError", "RoomQuestion");
        goto L18
    }

    public final boolean e() {
        Integer r0 = u4.a.getValue().disableSubmitButton;
        if (r0 != null) goto L6;
    L16:
        return false;
    L6:
        if (r0.intValue() != 1) goto L16;
        Question r1 = this.l;
        if (r1 == null) goto L10;
        Long r2 = r1.type;
    L11:
        if (r2 == null) goto L16;
        if (r2.longValue() != 1) goto L16;
        return true;
    L10:
        r2 = null;
        goto L11
    }

    @Override // dx1.a
    public final void onSlide() {
        nx1.b r0 = this.o;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.o = null;
        f(false);
    }

    @Override // dx1.a
    public final void stopRoom() {
        ILivePlayerClient r0 = this.n;
        if (r0 != null) goto L5;
    L12:
        SimpleMediaView r1 = this.g;
        if (r1 == null) goto L16;
        r1.m();
        return;
    L16:
        return;
    L5:
        if (r0.isPlaying() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.stopAndRelease(this.w);
        HSImageView r2 = this.d;
        if (r2 == null) goto L12;
        r2.setVisibility(0);
        goto L12
    }

    @Override // dx1.a
    public final void c(FeedbackCard r10) {
        if (r10 == null) goto L128;
        List r0 = r10.question;
        if (r0 == null) goto L129;
        Integer r3 = null;
        if ((!r0.isEmpty()) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L130;
        Question r1 = (Question) ListProtector.get(r0, 0);
        if (r1 == null) goto L133;
        TextView r4 = this.h;
        if (r4 == null) goto L20;
        String r5 = r10.title;
        if (r5 != null) goto L19;
        r5 = s1.B(2131919102);
    L19:
        r4.setText(r5);
    L20:
        this.k = r10;
        this.l = r1;
        Object r2 = (nx1.b) this.p.getValue();
        if ((r2 instanceof View) == true) goto L23;
        r2 = null;
    L23:
        View r6 = (View) r2;
        if (r6 == null) goto L31;
        ViewGroup r7 = this.a;
        if (r7 == null) goto L28;
        r7.removeAllViews();
    L28:
        ViewGroup r8 = this.a;
        if (r8 == null) goto L31;
        r8.addView(r6);
    L31:
        HSImageView r9 = this.d;
        FeedbackCard r11 = this.k;
        if (r11 == null) goto L36;
        Room r12 = r11.room;
        if (r12 == null) goto L36;
        py.k r13 = r12.getCover();
    L37:
        ImageLoader.bindImage(r9, r13);
        SimpleDraweeView r14 = this.e;
        if (r14 == null) goto L40;
        r14.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L40:
        SimpleDraweeView r15 = this.f;
        if (r15 == null) goto L43;
        r15.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
    L43:
        f(false);
        TextView r16 = this.c;
        if (r16 != null) goto L46;
    L50:
        Room r17 = r10.room;
        if (r17 == null) goto L131;
        long r18 = r17.id;
        Long r19 = this.x.getMPreRoomId();
        if (r19 != null) goto L56;
    L57:
        boolean r20 = true;
    L59:
        if (r20 == false) goto L61;
        Room r21 = r17;
    L62:
        if (r21 == null) goto L132;
        LinkedHashMap r22 = new LinkedHashMap();
        FeedbackContext.a r23 = FeedbackContext.Companion;
        int r24 = hashCode();
        r23.getClass();
        FeedbackContext r25 = FeedbackContext.a.a(r24);
        String r26 = "";
        if (r25 == null) goto L67;
        String r27 = r25.getEnterFromMerge();
        if (r27 == null) goto L67;
    L68:
        r22.put("enter_from_merge", r27);
        FeedbackContext r28 = FeedbackContext.a.a(hashCode());
        if (r28 == null) goto L72;
        String r29 = r28.getEnterMethod();
        if (r29 == null) goto L72;
    L73:
        r22.put("enter_method", r29);
        String r30 = String.valueOf(r17.id);
        if (r30 != null) goto L76;
        r30 = "";
    L76:
        r22.put("room_id", r30);
        User r31 = r17.getOwner();
        if (r31 == null) goto L80;
        String r32 = r31.getIdString();
        if (r32 == null) goto L80;
    L81:
        r22.put("anchor_id", r32);
        String r33 = this.x.getReqId();
        if (r33 != null) goto L84;
        r33 = "";
    L84:
        r22.put("request_id", r33);
        FeedbackCard r34 = this.x.getMFeedbackCard();
        if (r34 == null) goto L90;
        Long r35 = r34.feedbackId;
        if (r35 == null) goto L90;
        String r36 = String.valueOf(r35.longValue());
        if (r36 == null) goto L90;
    L91:
        r22.put("feedback_id", r36);
        FeedbackCard r37 = this.x.getMFeedbackCard();
        if (r37 == null) goto L97;
        Integer r38 = r37.getIndex();
        if (r38 == null) goto L97;
        String r39 = String.valueOf(r38.intValue());
        if (r39 == null) goto L97;
    L98:
        r22.put("draw_order", r39);
        r22.put("flow_type", "internal_flow");
        FeedbackCard r40 = this.x.getMFeedbackCard();
        if (r40 == null) goto L102;
        String r41 = r40.getLogInfo();
        if (r41 == null) goto L102;
    L103:
        r22.put("question_text", r41);
        r22.put("card_type", "questionnaire");
        FeedbackCard r42 = this.k;
        if (r42 == null) goto L106;
        r3 = r42.feedbackType;
    L106:
        if (r3 != null) goto L109;
    L111:
        if (r3 != null) goto L114;
    L116:
        if (r3 != null) goto L119;
    L121:
        if (r3 != null) goto L124;
    L126:
        r22.put("question_type", r26);
        LiveMode r110 = r17.getStreamType();
        int r43 = h1.a;
        r22.put("live_type", i1.a(r110));
        r22.put("error_type", "bind_room_no_show");
        u.l().sendLog("livesdk_live_feedback_card_show_error", r22, new Object[0]);
        return;
    L124:
        if (r3.intValue() != 3) goto L126;
    L125:
        r26 = "multiple";
        goto L126
    L119:
        if (r3.intValue() != 4) goto L121;
    L114:
        if (r3.intValue() != 2) goto L116;
        r26 = "whole";
        goto L126
    L109:
        if (r3.intValue() != 1) goto L111;
        r26 = "single";
    L102:
        r41 = "";
    L97:
        r39 = "";
    L90:
        r36 = "";
    L80:
        r32 = "";
    L72:
        r29 = "";
    L67:
        r27 = "";
        goto L68
    L132:
        return;
    L61:
        r21 = null;
        goto L62
    L56:
        if (r18 != r19.longValue()) goto L57;
        r20 = false;
        goto L59
    L131:
        return;
    L46:
        if (e() == false) goto L48;
        int r44 = 4;
    L49:
        r16.setVisibility(r44);
        goto L50
    L48:
        r44 = 0;
    L36:
        r13 = null;
        goto L37
    L133:
        return;
    L130:
        return;
    L129:
        return;
    }

    public final void f(boolean r2) {
        if (r2 == false) goto L12;
        TextView r3 = this.c;
        if (r3 == null) goto L6;
        r3.setClickable(true);
    L6:
        TextView r4 = this.c;
        if (r4 == null) goto L9;
        r4.setTextColor(s1.h(2131107481));
    L9:
        TextView r5 = this.c;
        if (r5 == null) goto L22;
        r5.setBackgroundResource(2131249132);
        return;
    L22:
        return;
    L12:
        TextView r6 = this.c;
        if (r6 == null) goto L15;
        r6.setClickable(false);
    L15:
        TextView r7 = this.c;
        if (r7 == null) goto L18;
        r7.setTextColor(s1.h(2131107482));
    L18:
        TextView r8 = this.c;
        if (r8 == null) goto L24;
        r8.setBackgroundResource(2131249131);
        return;
    }

    @Override // dx1.a
    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.a = (ViewGroup) r5.findViewById(2131383533);
        this.b = (FrameLayout) r5.findViewById(2131382912);
        this.c = (TextView) r5.findViewById(2131387573);
        this.d = r5.findViewById(2131382914);
        this.e = r5.findViewById(2131364117);
        this.f = r5.findViewById(2131374136);
        TextView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setOnClickListener(this.v);
    L5:
        this.g = r5.findViewById(2131379806);
        this.h = (TextView) r5.findViewById(2131372318);
        this.i = (TextView) r5.findViewById(2131386885);
        this.j = (ViewGroup) r5.findViewById(2131383538);
        TextView r6 = this.i;
        int r1 = 0;
        Integer r2 = null;
        if (r6 == null) goto L18;
        j5 r3 = (j5) this.q.getValue();
        if (r3 == null) goto L10;
        Integer r4 = r3.guideVisible;
    L11:
        if (r4 != null) goto L14;
    L16:
        int r7 = 8;
    L17:
        r6.setVisibility(r7);
        goto L18
    L14:
        if (r4.intValue() != 1) goto L16;
        r7 = 0;
        goto L17
    L10:
        r4 = null;
    L18:
        ViewGroup r8 = this.j;
        if (r8 == null) goto L31;
        j5 r9 = (j5) this.q.getValue();
        if (r9 == null) goto L23;
        r2 = r9.titleVisible;
    L23:
        if (r2 != null) goto L26;
    L28:
        r1 = 4;
    L29:
        r8.setVisibility(r1);
        return;
    L26:
        if (r2.intValue() != 1) goto L28;
    }

    @Override // dx1.a
    public final View a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        return r3.inflate(2131566774, r4, false);
    }

    public final void d(Context r4, Room r5) {
        LivePlayerView r0 = this.m;
        if (r0 == null) goto L10;
        r0.setVisibility(8);
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L10;
        r2.removeView(this.m);
    L10:
        LivePlayerView r3 = new LivePlayerView(r4, LivePlayerConfig.Companion.buildWith(LivePlayerScene.INSTANCE.getFEEDBACK_PREVIEW(), r5.getIdStr()));
        this.m = r3;
        this.n = r3.getClient();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        r6.gravity = 17;
        LivePlayerView r7 = this.m;
        if (r7 == null) goto L13;
        r7.setLayoutParams(r6);
    L13:
        LivePlayerView r8 = this.m;
        if (r8 == null) goto L18;
        IRenderView r9 = r8.getRenderView();
        if (r9 == null) goto L18;
        r9.setLayoutParams(r6);
    L18:
        LivePlayerView r10 = this.m;
        if (r10 == null) goto L21;
        r10.setVisibility(0);
    L21:
        LivePlayerView r11 = this.m;
        if (r11 == null) goto L25;
        r11.setScaleType(2);
        return;
    }

    public RoomQuestionFeedback(Context r2, FeedbackContext r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedbackContext");
        Intrinsics.checkNotNullParameter(r4, "onSubmit");
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.p = LazyKt.lazy(new RoomQuestionFeedback$questionView$2(this));
        this.q = LazyKt.lazy(RoomQuestionFeedback$mFeedbackConfig$2.INSTANCE);
        this.r = LazyKt.lazy(new RoomQuestionFeedback$questionSelectListener$2(this));
        this.s = LazyKt.lazy(new RoomQuestionFeedback$musicEntity$2(this));
        this.t = LazyKt.lazy(RoomQuestionFeedback$feedbackService$2.INSTANCE);
        this.u = new RoomQuestionFeedback$submitAction$1(this);
        this.v = new a(this);
    }
}
