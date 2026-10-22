package com.bytedance.android.livesdk.interactivity.comment.input;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentApi;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.r;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/VideoCommentPreviewFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/input/AbsLiveInputSecondaryFragment;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCommentPreviewFragment extends AbsLiveInputSecondaryFragment {
    public static final /* synthetic */ int w = 0;
    public gd0.b d;
    public u62.b e;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f;
    public r g;
    public boolean h;
    public final CompositeDisposable i;
    public final int j;
    public View k;
    public ViewGroup l;
    public ViewGroup m;
    public ImageView n;
    public ViewGroup o;
    public ViewGroup p;
    public LiveDoubleColorBallAnimationView q;
    public FrameLayout r;
    public boolean s;
    public boolean t;
    public final b u;
    public boolean v;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public b(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L7:
            r r4 = this.a.g;
            if (r4 == null) goto L12;
            r4.c();
            return;
        L12:
            return;
        L6:
            if (r3.intValue() != 2) goto L7;
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public d(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            gd0.b r4 = this.a.d;
            if (r4 == null) goto L7;
            Long r5 = r4.a;
            if (r5 == null) goto L7;
            long r0 = r5.longValue();
        L8:
            this.a.X90(r0);
            return;
        L7:
            r0 = 0;
            goto L8
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public e(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            VideoCommentPreviewFragment r4 = this.a;
            if (r4.e == null) goto L5;
            Intrinsics.checkNotNullParameter(InputDialogFragmentSwitchType.SLIDE_RIGHT, "switchType");
            Intrinsics.checkNotNullParameter(r4, "fragment");
        L5:
            VideoCommentPreviewFragment r5 = this.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = r5.f;
            if (r0 == null) goto L9;
            r0.G(InputDialogFragmentSwitchType.SLIDE_RIGHT, r5);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public f(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            VideoCommentPreviewFragment r3 = this.a;
            boolean r0 = !r3.s;
            r3.s = r0;
            if (r0 == false) goto L7;
            ImageView r4 = r3.n;
            if (r4 == null) goto L10;
            r4.setBackgroundResource(2131253237);
        L10:
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r5 = l42.a.t;
            Boolean r1 = Boolean.valueOf(this.a.s);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r1);
            return;
        L7:
            ImageView r6 = r3.n;
            if (r6 == null) goto L10;
            r6.setBackgroundResource(2131253238);
            goto L10
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public g(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r14) {
            VideoCommentPreviewFragment r15 = this.a;
            int r0 = VideoCommentPreviewFragment.w;
            r15.getClass();
            IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
            long r2 = 0;
            if (r1 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.o r3 = IRoomContextService.a.a(r1, null, 0, 3);
            if (r3 == null) goto L11;
            com.bytedance.live.datacontext.m r4 = r3.getRoom();
            if (r4 == null) goto L11;
            IRoom r5 = (IRoom) r4.getValue();
            if (r5 == null) goto L11;
            long r6 = r5.getId();
        L12:
            gd0.b r7 = r15.d;
            if (r7 == null) goto L17;
            Long r8 = r7.a;
            if (r8 == null) goto L17;
            long r9 = r8.longValue();
        L18:
            gd0.b r10 = r15.d;
            if (r10 == null) goto L23;
            Long r11 = r10.b;
            if (r11 == null) goto L23;
            r2 = r11.longValue();
        L23:
            long r13 = r2;
            gd0.b r16 = r15.d;
            if (r16 == null) goto L28;
            Integer r17 = r16.f;
            if (r17 == null) goto L28;
            int r18 = r17.intValue();
        L29:
            CommentApi r19 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
            if (r19 == null) goto L38;
            Observable<Response<com.bytedance.android.livesdk.interactivity.api.comment.data.g>> r20 = r19.videoPinShare(r6, r9, r13, r18);
            if (r20 == null) goto L38;
            Observable r21 = r20.compose(RxUtil.rxSchedulerHelper());
            if (r21 == null) goto L38;
            Disposable r23 = r21.subscribe(new k(r15, r6), new l(r15));
            if (r23 == null) goto L38;
            RxUtilKt.c(r23, r15.i);
        L38:
            VideoCommentPreviewFragment r110 = this.a;
            Map<String, String> r24 = r110.V90();
            if (r110.s == false) goto L41;
            String r111 = "on";
        L42:
            r24.put("pin_status", r111);
            j0.l().sendLog("livesdk_video_comment_send", r24, new Object[0]);
            return;
        L41:
            r111 = "off";
        L28:
            r18 = 0;
        L17:
            r9 = 0;
        L11:
            r6 = 0;
            goto L12
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public h(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            k42.d r2 = (k42.d) r1;
            r r3 = this.a.g;
            if (r3 == null) goto L6;
            r3.c();
            return;
        }
    }

    public static final class i implements IMiddlewareHostBusiness.AwemeQueryCallBack {
        public final /* synthetic */ VideoCommentPreviewFragment a;

        public final void onBatchSuccess(HashMap<Long, Object> r1) {
        }

        public i(VideoCommentPreviewFragment r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r10, long r11) {
            if (r10 == null) goto L47;
            VideoCommentPreviewFragment r0 = this.a;
            r0.v = true;
            int r4 = r0.T90() - s1.f(100.0f);
            IMiddlewareHostBusiness r2 = jc1.k.n(IMiddlewareHostBusiness.class);
            Context r5 = r0.getContext();
            IInteractService r13 = jc1.k.n(IInteractService.class);
            Fragment r8 = null;
            if (r0.t == false) goto L18;
            if (r13.getVideoTalkService() != null) goto L9;
        L11:
            com.bytedance.android.live.pushstream.d r1 = null;
        L13:
            if (r13.getAudioTalkService() != null) goto L15;
        L31:
            if (r1 == null) goto L35;
            d0 r14 = r1.A();
            if (r14 == null) goto L35;
            r14.h();
        L35:
            IMiddlewareHostBusiness.AwemeVideoPlayFragmentV2 r15 = r2.getLivePureVideoPlayFragmentV2(r10, r4, r5, 0);
            if (r15 == null) goto L38;
            r15.setCallback(new j(r0));
        L38:
            if (r15 == null) goto L40;
            r8 = r15.asFragment();
        L40:
            if (r8 == null) goto L46;
            FragmentTransaction r16 = r0.getChildFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "VideoCommentPreviewFragment", 2131378433) == true) goto L45;
            r16.add(2131378433, r8, "VideoCommentPreviewFragment");
        L45:
            r16.commitAllowingStateLoss();
        L46:
            this.a.W90(false, false);
            return;
        L15:
            if (r13.getAudioTalkService().getLiveStream() == null) goto L31;
            r1 = r13.getAudioTalkService().getLiveStream();
            goto L31
        L9:
            if (r13.getVideoTalkService().getLiveStream() == null) goto L11;
            r1 = r13.getVideoTalkService().getLiveStream();
            goto L13
        L18:
            if (r13.getVideoTalkService() != null) goto L20;
        L22:
            r1 = null;
        L24:
            if (r13.getAudioTalkService() == null) goto L29;
            if (r13.getAudioTalkService().getLiveStream() == null) goto L29;
            r1 = r13.getAudioTalkService().getLiveStream();
        L29:
            if (r13.getGuestRtcLiveStream() == null) goto L31;
            r1 = r13.getGuestRtcLiveStream();
            goto L31
        L20:
            if (r13.getVideoTalkService().getLiveStream() == null) goto L22;
            r1 = r13.getVideoTalkService().getLiveStream();
            goto L24
        L47:
            f2.b(2131915225, 0);
            VideoCommentPreviewFragment r17 = this.a;
            int r3 = VideoCommentPreviewFragment.w;
            r17.W90(false, true);
        }

        public final void onFailure(String r2, String r3, String r4) {
            if (TextUtils.isEmpty(r3) == true) goto L6;
            f2.c(r3, 0);
        L9:
            VideoCommentPreviewFragment r5 = this.a;
            int r6 = VideoCommentPreviewFragment.w;
            r5.W90(false, true);
            return;
        L6:
            if (TextUtils.isEmpty(r4) == true) goto L8;
            f2.c(r4, 0);
            goto L9
        L8:
            f2.b(2131915225, 0);
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final int T90() {
        if (this.h == false) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.f;
        if (r0 == null) goto L7;
        int r1 = r0.X();
    L8:
        if (r1 <= 0) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.f;
        if (r2 == null) goto L16;
        return r2.X();
    L16:
        return this.j;
    L7:
        r1 = 0;
    L13:
        boolean r3 = this.h;
        return this.j;
    }

    public final Map<String, String> V90() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        long r2 = 0;
        Boolean r4 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L6:
        LinkedHashMap r5 = new LinkedHashMap();
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m r6 = r1.getRoom();
        if (r6 == null) goto L13;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L13;
        String r8 = r7.getOwnerUserIdString();
    L14:
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.m r9 = r1.getRoom();
        if (r9 == null) goto L20;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L20;
        Long r11 = Long.valueOf(r10.getRoomId());
    L21:
        if (r1 == null) goto L24;
        r4 = r1.isAnchor();
    L24:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L26;
        String r3 = "anchor";
    L27:
        gd0.b r13 = this.d;
        if (r13 == null) goto L32;
        Integer r14 = r13.f;
        if (r14 == null) goto L32;
        int r15 = r14.intValue();
    L34:
        if (r15 != 1) goto L37;
        String r16 = "like";
    L42:
        gd0.b r17 = this.d;
        if (r17 == null) goto L47;
        Long r18 = r17.a;
        if (r18 == null) goto L47;
        r2 = r18.longValue();
    L47:
        r5.put("live_type", jc1.k.n(IInteractService.class).getLiveTypeForLog());
        r5.put("anchor_id", String.valueOf(r8));
        r5.put("room_id", String.valueOf(r11));
        r5.put("user_type", r3);
        r5.put("function_type", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        r5.put("function_type2", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        r5.put("tab_send", r16);
        r5.put("video_id", String.valueOf(r2));
        return r5;
    L37:
        if (r15 != 2) goto L39;
        r16 = "favorite";
        goto L42
    L39:
        if (r15 != 3) goto L41;
        r16 = "create";
        goto L42
    L41:
        r16 = "watched";
    L32:
        r15 = 0;
        goto L34
    L26:
        r3 = "guest";
    L20:
        r11 = null;
    L13:
        r8 = null;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public VideoCommentPreviewFragment() {
        this.h = true;
        this.i = new CompositeDisposable();
        this.j = 1400;
        this.s = ((Boolean) l42.a.t.getValue()).booleanValue();
        this.t = true;
        this.u = new b(this);
        this.v = true;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.i.dispose();
        if (this.t == true) goto L6;
        hd0.c.f().e(this.u);
        return;
    }

    public static final void U90(VideoCommentPreviewFragment r3) {
        Map<String, String> r0 = r3.V90();
        if (r3.v == false) goto L5;
        String r4 = "play";
    L6:
        r0.put("action_type", r4);
        j0.l().sendLog("livesdk_video_comment_preview_click", r0, new Object[0]);
        return;
    L5:
        r4 = "pause";
        goto L6
    }

    public final void X90(long r5) {
        if (r5 > 0) goto L11;
        f2.b(2131915225, 0);
        if (this.e == null) goto L7;
        Intrinsics.checkNotNullParameter(InputDialogFragmentSwitchType.SLIDE_RIGHT, "switchType");
        Intrinsics.checkNotNullParameter(this, "fragment");
    L7:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6 = this.f;
        if (r6 == null) goto L15;
        r6.G(InputDialogFragmentSwitchType.SLIDE_RIGHT, this);
        return;
    L15:
        return;
    L11:
        W90(true, false);
        Disposable r7 = jc1.k.n(IMiddlewareHostBusiness.class).queryAweme(r5, new i(this));
        if (r7 == null) goto L16;
        RxUtilKt.c(r7, this.i);
        return;
    }

    public final void W90(boolean r1, boolean r2) {
        if (r1 == false) goto L9;
        ViewGroup r3 = this.o;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r3);
    L6:
        LiveDoubleColorBallAnimationView r4 = this.q;
        if (r4 == null) goto L15;
        r4.b();
    L15:
        if (r2 == false) goto L19;
        ViewGroup r5 = this.p;
        if (r5 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L23:
        return;
    L19:
        ViewGroup r6 = this.p;
        if (r6 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r6);
        return;
    L25:
        return;
    L9:
        ViewGroup r7 = this.o;
        if (r7 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r7);
    L12:
        LiveDoubleColorBallAnimationView r8 = this.q;
        if (r8 == null) goto L15;
        r8.c();
        goto L15
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        gd0.b r5 = this.d;
        if (r5 == null) goto L7;
        Long r6 = r5.a;
        if (r6 == null) goto L7;
        long r7 = r6.longValue();
    L8:
        X90(r7);
        Map<String, String> r8 = V90();
        j0.l().sendLog("livesdk_video_comment_preview", r8, new Object[0]);
        RxUtilKt.c(xs2.b.a().b(k42.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this)), this.i);
        return;
    L7:
        r7 = 0;
        goto L8
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(2131566191, r7, false);
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        ViewGroup.LayoutParams r3 = null;
        if (r10 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r11 = IRoomContextService.a.a(r10, null, 0, 3);
        if (r11 == null) goto L9;
        Boolean r13 = r11.isAnchor();
        if (r13 == null) goto L9;
        boolean r14 = r13.booleanValue();
    L10:
        this.t = r14;
        ((ViewGroup) r9.findViewById(2131392281)).setOnClickListener(c.a);
        this.o = (ViewGroup) r9.findViewById(2131378435);
        this.p = (ViewGroup) r9.findViewById(2131378436);
        this.q = r9.findViewById(2131379052);
        Button r15 = (Button) r9.findViewById(2131378437);
        if (r15 == null) goto L13;
        r15.setOnClickListener(new d(this));
    L13:
        View r16 = r9.findViewById(2131382898);
        this.k = r16;
        if (r16 == null) goto L16;
        r16.setOnClickListener(new e(this));
    L16:
        this.n = (ImageView) r9.findViewById(2131382317);
        this.m = (ViewGroup) r9.findViewById(2131392338);
        this.r = (FrameLayout) r9.findViewById(2131378433);
        if (this.t == false) goto L33;
        IRoomContextService r17 = jc1.k.f(IRoomContextService.class);
        if (r17 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r18 = IRoomContextService.a.a(r17, null, 0, 3);
        if (r18 == null) goto L27;
        com.bytedance.live.datacontext.m r19 = r18.getRoom();
        if (r19 == null) goto L27;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L27;
        String r21 = r20.getAnchorAbValue("live_video_on_wall");
    L29:
        if (TextUtils.equals("1", r21) == false) goto L33;
        z.a.getClass();
        if (z.a.b().f() == true) goto L33;
        boolean r23 = true;
    L34:
        if (r23 == false) goto L41;
        ViewGroup r24 = this.m;
        if (r24 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r24);
    L38:
        ViewGroup r25 = this.m;
        if (r25 == null) goto L47;
        r25.setOnClickListener(new f(this));
    L47:
        if (r23 == true) goto L49;
        this.s = false;
    L49:
        ViewGroup r26 = (ViewGroup) r9.findViewById(2131392340);
        this.l = r26;
        if (r26 == null) goto L52;
        r26.setOnClickListener(new g(this));
    L52:
        ViewGroup r27 = this.l;
        if (r27 == null) goto L55;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
    L57:
        if ((r28 instanceof RelativeLayout.LayoutParams) == false) goto L60;
        r3 = r28;
    L60:
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r3;
        if (r4 == null) goto L69;
        if (r23 == false) goto L64;
        r4.addRule(11);
    L65:
        ViewGroup r29 = this.l;
        if (r29 == null) goto L69;
        r29.setLayoutParams(r4);
        goto L69
    L64:
        r4.addRule(13);
    L69:
        if (this.s == false) goto L73;
        ImageView r30 = this.n;
        if (r30 == null) goto L77;
        r30.setBackgroundResource(2131253237);
    L77:
        if (this.t == true) goto L79;
        hd0.c.f().c(this.u);
    L79:
        return r9;
    L73:
        ImageView r31 = this.n;
        if (r31 == null) goto L77;
        r31.setBackgroundResource(2131253238);
        goto L77
    L55:
        r28 = null;
        goto L57
    L41:
        ViewGroup r33 = this.m;
        if (r33 == null) goto L44;
        UtilityKotlinExtentionsKt.t(r33);
    L44:
        ViewGroup r34 = this.m;
        if (r34 == null) goto L47;
        r34.setOnClickListener(null);
    L27:
        r21 = null;
    L33:
        r23 = false;
    L9:
        r14 = false;
        goto L10
    }
}
