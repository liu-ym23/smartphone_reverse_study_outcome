package com.bytedance.android.livesdk.interactivity.comment.input;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.x3;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.interactivity.api.comment.video.VideoApi;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.app.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.r;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/VideoCommentSearchFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/input/AbsLiveInputSecondaryFragment;", "Lw62/g;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCommentSearchFragment extends AbsLiveInputSecondaryFragment implements w62.g {
    public static final String O = null;
    public static final String P = null;
    public boolean A;
    public String B;
    public final HashSet<Long> C;
    public boolean D;
    public final HashSet<Long> E;
    public final d F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public final CompositeDisposable d;
    public u62.b e;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f;
    public r g;
    public EditText h;
    public ViewGroup i;
    public ViewGroup j;
    public ViewGroup k;
    public ImageView l;
    public ViewGroup m;
    public LiveDoubleColorBallAnimationView n;
    public ViewGroup o;
    public HSImageView p;
    public Button q;
    public ViewGroup r;
    public HSImageView s;
    public RecyclerView t;
    public MultiTypeAdapter u;
    public LoadMoreScrollListener v;
    public boolean w;
    public boolean x;
    public long y;
    public long z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public b(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
        public final void accept(Object r8) {
            Response r9 = (Response) r8;
            VideoCommentSearchFragment r0 = this.a;
            List r1 = null;
            if (r9 == null) goto L5;
            x3 r10 = (x3) ((BaseResponse) r9).data;
        L6:
            String r2 = VideoCommentSearchFragment.O;
            r0.getClass();
            if (r10 == null) goto L18;
            List r3 = r10.c();
            if (r3 == null) goto L18;
            if ((!r3.isEmpty()) == false) goto L13;
            r1 = r3;
        L13:
            if (r1 == null) goto L18;
            List r4 = r1;
            ?? r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L16:
            if (r6.hasNext() == false) goto L20;
            r5.add(((com.bytedance.android.livesdk.chatroom.model.j) r6.next()).e());
        L20:
            if (r5.isEmpty() == false) goto L41;
            r0.x = true;
            LoadMoreScrollListener r11 = r0.v;
            if (r11 == null) goto L25;
            r11.b = 0;
        L25:
            if (r0.z != 0) goto L35;
            ViewGroup r13 = r0.o;
            if (r13 == null) goto L29;
            UtilityKotlinExtentionsKt.t(r13);
        L29:
            ViewGroup r14 = r0.m;
            if (r14 == null) goto L32;
            UtilityKotlinExtentionsKt.t(r14);
        L32:
            ViewGroup r15 = r0.r;
            if (r15 == null) goto L40;
            UtilityKotlinExtentionsKt.w(r15);
        L40:
            r0.A = false;
            Map<String, String> r16 = r0.aa0();
            r16.put("video_num", String.valueOf(0));
            j0.l().sendLog("livesdk_video_search_result_page_show", r16, new Object[0]);
            return;
        L35:
            r0.ha0(true);
            if (r0.x == true) goto L40;
            r0.ea0(false, true);
            LoadMoreScrollListener r17 = r0.v;
            if (r17 == null) goto L40;
            r17.b = 2;
            goto L40
        L41:
            Disposable r18 = jc1.k.n(IMiddlewareHostBusiness.class).queryBatchAweme(r5, new o(r0, r10));
            if (r18 == null) goto L47;
            r0.d.add(r18);
            return;
        L47:
            return;
        L18:
            r5 = CollectionsKt.emptyList();
            goto L20
        L5:
            r10 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public c(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            VideoCommentSearchFragment r10 = this.a;
            if (r10.z == 0) goto L5;
            boolean r0 = true;
        L6:
            r10.ha0(r0);
            VideoCommentSearchFragment r11 = this.a;
            if (r11.z != 0) goto L13;
            r11.ga0(false, true);
            MultiTypeAdapter r13 = this.a.u;
            if (r13 == null) goto L13;
            List r14 = r13.a;
            if (r14 == null) goto L13;
            r14.clear();
        L13:
            VideoCommentSearchFragment r15 = this.a;
            LoadMoreScrollListener r1 = r15.v;
            if (r1 == null) goto L16;
            r1.b = 0;
        L16:
            MultiTypeAdapter r16 = r15.u;
            if (r16 == null) goto L19;
            r16.notifyDataSetChanged();
        L19:
            this.a.A = false;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public d(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() == 2) goto L11;
            r r4 = this.a.g;
            if (r4 == null) goto L12;
            r4.c();
            return;
        L12:
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoCommentSearchFragment r0 = this.a.a;     // Catch: Throwable -> L9
                if (r0.e == null) goto L5;
                Intrinsics.checkNotNullParameter(InputDialogFragmentSwitchType.FADE, "switchType");     // Catch: Throwable -> L9
                Intrinsics.checkNotNullParameter(r0, "fragment");     // Catch: Throwable -> L9
            L5:
                VideoCommentSearchFragment r1 = this.a.a;     // Catch: Throwable -> L9
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = r1.f;     // Catch: Throwable -> L9
                if (r2 == null) goto L12;
                r2.G(InputDialogFragmentSwitchType.FADE, r1);     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public e(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            t2.a(this.a.getContext(), this.a.h);
            EditText r5 = this.a.h;
            if (r5 == null) goto L6;
            r5.postDelayed(new a(this), 300);
            return;
        }
    }

    public static final class f implements View.OnKeyListener {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public f(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if (66 == r2) goto L5;
            return false;
        L5:
            if (1 != r3.getAction()) goto L10;
            VideoCommentSearchFragment r4 = this.a;
            r4.B = BuildConfig.FLAVOR;
            VideoCommentSearchFragment.U90(r4);
            return false;
        L10:
            return false;
        }
    }

    public static final class g implements TextWatcher {
        public final /* synthetic */ VideoCommentSearchFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public g(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            EditText r5 = this.a.h;
            if (r5 == null) goto L7;
            CharSequence r6 = r5.getText();
            if (r6 == null) goto L7;
        L9:
            if (TextUtils.isEmpty(r6) == false) goto L14;
            ImageView r7 = this.a.l;
            if (r7 == null) goto L13;
            UtilityKotlinExtentionsKt.t(r7);
        L13:
            this.a.fa0(100);
            this.a.B = BuildConfig.FLAVOR;
            return;
        L14:
            ImageView r8 = this.a.l;
            if (r8 == null) goto L19;
            UtilityKotlinExtentionsKt.w(r8);
            return;
        L19:
            return;
        L7:
            r6 = BuildConfig.FLAVOR;
            goto L9
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public h(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            VideoCommentSearchFragment r3 = this.a;
            r3.B = BuildConfig.FLAVOR;
            VideoCommentSearchFragment.U90(r3);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public i(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            EditText r6 = this.a.h;
            if (r6 == null) goto L5;
            r6.setText(null);
        L5:
            VideoCommentSearchFragment.U90(this.a);
            VideoCommentSearchFragment r7 = this.a;
            EditText r0 = r7.h;
            if (r0 == null) goto L9;
            r0.postDelayed(new n(r7), 100);
            return;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ VideoCommentSearchFragment a;

        public j(VideoCommentSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (TextUtils.isEmpty(this.a.B) == false) goto L6;
            this.a.fa0(100);
            return;
        L6:
            VideoCommentSearchFragment r4 = this.a;
            r4.X90(r4.B);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ VideoCommentSearchFragment a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ int e;

        public k(VideoCommentSearchFragment r1, long r2, long r4, boolean r6, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }

        public final void accept(Object r9) {
            Response r10 = (Response) r9;
            this.a.C.remove(Long.valueOf(this.b));
            t5 r0 = vh7.f.c(t5.class);
            Long r1 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).b();
            long r2 = 0;
            if (r1 == null) goto L5;
            long r4 = r1.longValue();
        L6:
            r0.setItemId(r4);
            Long r3 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).c();
            if (r3 == null) goto L9;
            long r5 = r3.longValue();
        L10:
            r0.setItemType(r5);
            r0.setTitle(((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).e());
            r0.setBaseUser(((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).f());
            Long r6 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).b();
            String r7 = null;
            if (r6 == null) goto L13;
            String r8 = String.valueOf(r6.longValue());
        L14:
            r0.setItemIdStr(r8);
            Long r11 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).c();
            if (r11 == null) goto L17;
            r7 = String.valueOf(r11.longValue());
        L17:
            r0.setItemTypeStr(r7);
            r0.setMessageMethod("WebcastVideoShareMessage");
            Long r13 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).d();
            if (r13 == null) goto L20;
            r2 = r13.longValue();
        L20:
            m0 r14 = vh7.f.c(m0.class);
            r14.setRoomId(this.c);
            r14.setMessageId(r2);
            a5 r15 = ((com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r10).data).a();
            if (r15 == null) goto L23;
            r14.setDisplayText(r15);
        L23:
            r14.setShowMsg(true);
            r14.setMethod("WebcastVideoShareMessage");
            r0.setBaseMessage(r14);
            if (this.a.D == false) goto L26;
            r0.setPin(this.d);
        L27:
            r r16 = this.a.g;
            if (r16 == null) goto L30;
            r16.e(r0);
        L30:
            VideoCommentSearchFragment r17 = this.a;
            long r18 = this.b;
            boolean r19 = this.d;
            int r20 = this.e;
            Map<String, String> r21 = r17.aa0();
            r21.put("tab_send", "search");
            r21.put("video_id", String.valueOf(r18));
            if (r19 == false) goto L33;
            String r23 = "on";
        L34:
            r21.put("pin_status", r23);
            r21.put("video_index", String.valueOf(r20 + 1));
            j0.l().sendLog("livesdk_video_comment_send_success", r21, new Object[0]);
            return;
        L33:
            r23 = "off";
            goto L34
        L26:
            r0.setPin(false);
            goto L27
        L13:
            r8 = null;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ VideoCommentSearchFragment a;
        public final /* synthetic */ long b;

        public l(VideoCommentSearchFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            this.a.C.remove(Long.valueOf(this.b));
            Context r0 = this.a.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r4);
            r r5 = this.a.g;
            if (r5 == null) goto L6;
            r5.a();
            return;
        }
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-android/ttlive_video_search_empty.png");
        O = r0.toString();
        P = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_video_search_error.png";
    }

    @Override // w62.g
    public final void Px() {
        IInteractService r0 = jc1.k.n(IInteractService.class);
        com.bytedance.android.live.pushstream.d r2 = null;
        if (this.w == false) goto L15;
        if (r0.getVideoTalkService() == null) goto L10;
        if (r0.getVideoTalkService().getLiveStream() == null) goto L10;
        r2 = r0.getVideoTalkService().getLiveStream();
    L10:
        if (r0.getAudioTalkService() != null) goto L12;
    L27:
        if (r2 == null) goto L32;
        d0 r1 = r2.A();
        if (r1 == null) goto L33;
        r1.h();
        return;
    L33:
        return;
    L32:
        return;
    L12:
        if (r0.getAudioTalkService().getLiveStream() == null) goto L27;
        r2 = r0.getAudioTalkService().getLiveStream();
        goto L27
    L15:
        if (r0.getVideoTalkService() == null) goto L20;
        if (r0.getVideoTalkService().getLiveStream() == null) goto L20;
        r2 = r0.getVideoTalkService().getLiveStream();
    L20:
        if (r0.getAudioTalkService() == null) goto L25;
        if (r0.getAudioTalkService().getLiveStream() == null) goto L25;
        r2 = r0.getAudioTalkService().getLiveStream();
    L25:
        if (r0.getGuestRtcLiveStream() == null) goto L27;
        r2 = r0.getGuestRtcLiveStream();
        goto L27
    }

    public final void V90() {
        if (this.L < 0) goto L5;
        return;
    L5:
        int r0 = this.I + 1;
        int r1 = this.H;
        int r2 = -1;
    L6:
        if (r1 >= r0) goto L16;
        if (r2 >= 0) goto L16;
        if (this.M == r1) goto L15;
        if (W90(r1) == false) goto L15;
        r2 = r1;
    L15:
        r1 = r1 + 1;
    L16:
        if (r2 < 0) goto L18;
        this.J = r2;
        return;
    L18:
        int r3 = this.J;
        if (r3 < 0) goto L30;
        da0(r3);
        w62.a r4 = w62.a.b;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r5 = w62.a.C0291a.a().a;
        if (r5 == null) goto L31;
        r5.pauseVideoPlayer();
        return;
    L31:
        return;
    }

    public final Map<String, String> aa0() {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        Boolean r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r3 = IRoomContextService.a.a(r1, null, 0, 3);
    L6:
        r0.put("live_type", jc1.k.n(IInteractService.class).getLiveTypeForLog());
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L13;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L13;
        String r6 = r5.getOwnerUserIdString();
    L14:
        r0.put("anchor_id", String.valueOf(r6));
        if (r3 == null) goto L21;
        com.bytedance.live.datacontext.m r7 = r3.getRoom();
        if (r7 == null) goto L21;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L21;
        Long r9 = Long.valueOf(r8.getRoomId());
    L22:
        r0.put("room_id", String.valueOf(r9));
        if (r3 == null) goto L26;
        r2 = r3.isAnchor();
    L26:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L28;
        String r10 = "anchor";
    L29:
        r0.put("user_type", r10);
        r0.put("function_type", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        r0.put("function_type2", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        return r0;
    L28:
        r10 = "guest";
    L21:
        r9 = null;
    L13:
        r6 = null;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public VideoCommentSearchFragment() {
        this.d = new CompositeDisposable();
        this.w = true;
        this.x = true;
        this.B = BuildConfig.FLAVOR;
        this.C = new HashSet();
        this.E = new HashSet();
        this.F = new d(this);
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = -1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final int T90() {
        return s1.f(590.0f);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        if (this.w == true) goto L5;
        hd0.c.f().e(this.F);
    L5:
        w62.a r0 = w62.a.b;
        w62.a r1 = w62.a.C0291a.a();
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r2 = r1.a;
        if (r2 == null) goto L8;
        r2.stopVideoPlayer();
    L8:
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r3 = r1.a;
        if (r3 == null) goto L11;
        r3.releaseVideoPlayer();
    L11:
        r1.a = null;
        this.d.clear();
        this.E.clear();
        this.C.clear();
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        int r0 = this.J;
        if (r0 < 0) goto L6;
        da0(r0);
        this.K = this.J;
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        int r0 = this.K;
        if (r0 < 0) goto L13;
        RecyclerView r1 = this.t;
        if (r1 == null) goto L7;
        RecyclerView.ViewHolder r2 = r1.findViewHolderForAdapterPosition(r0);
    L9:
        if ((r2 instanceof LiveVideoCommentSearchVideoViewHolder) == false) goto L11;
        int r3 = LiveVideoCommentSearchVideoViewHolder.s;
        ((LiveVideoCommentSearchVideoViewHolder) r2).T3(false);
    L11:
        this.J = this.K;
        this.K = -1;
        return;
    L7:
        r2 = null;
        goto L9
    }

    public static final void U90(VideoCommentSearchFragment r4) {
        EditText r0 = r4.h;
        if (r0 == null) goto L8;
        Editable r1 = r0.getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
        if (r2 == null) goto L8;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r4.fa0(100);
        r4.B = BuildConfig.FLAVOR;
        return;
    L12:
        t2.a(r4.getContext(), r4.h);
        r4.X90(r2);
        return;
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L10
    }

    @Override // w62.g
    public final boolean Ip(long r5) {
        int r0 = Y90(r5);
        int r1 = this.H;
        int r2 = this.I;
        if (r1 > r0) goto L15;
        if (r2 < r0) goto L15;
        RecyclerView r3 = this.t;
        if (r3 == null) goto L9;
        RecyclerView.ViewHolder r4 = r3.findViewHolderForAdapterPosition(r0);
    L10:
        if (r4 == null) goto L15;
        if ((r4 instanceof LiveVideoCommentSearchVideoViewHolder) == false) goto L15;
        int r6 = LiveVideoCommentSearchVideoViewHolder.s;
        ((LiveVideoCommentSearchVideoViewHolder) r4).T3(false);
        this.L = r0;
        ca0(String.valueOf(r5), "play");
        return true;
    L9:
        r4 = null;
    L15:
        return false;
    }

    @Override // w62.g
    public final void O80(com.bytedance.android.livesdk.chatroom.model.l r6) {
        Intrinsics.checkNotNullParameter(r6, "videoItem");
        if (this.D == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.model.j r7 = r6.a;
        if (r7 == null) goto L10;
        Long r8 = r7.e();
        if (r8 == null) goto L10;
        long r0 = r8.longValue();
    L12:
        if (this.C.contains(Long.valueOf(r0)) == false) goto L14;
        return;
    L14:
        MultiTypeAdapter r9 = this.u;
        RecyclerView.ViewHolder r2 = null;
        if (r9 == null) goto L17;
        List r10 = r9.a;
    L19:
        if (TypeIntrinsics.isMutableList(r10) == true) goto L21;
        r10 = null;
    L21:
        int r1 = Z90(Long.valueOf(r0));
        if (r1 < 0) goto L43;
        if (r10 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.model.l r3 = (com.bytedance.android.livesdk.chatroom.model.l) ListProtector.get(r10, r1);
    L26:
        if (r3 == null) goto L46;
        RecyclerView r4 = this.t;
        if (r4 == null) goto L31;
        r2 = r4.findViewHolderForAdapterPosition(r1);
    L31:
        if (r2 != null) goto L33;
        return;
    L33:
        if ((r2 instanceof LiveVideoCommentSearchVideoViewHolder) == false) goto L45;
        boolean r5 = !((com.bytedance.android.livesdk.chatroom.model.l) ListProtector.get(r10, r1)).b;
        LiveVideoCommentSearchVideoViewHolder r11 = (LiveVideoCommentSearchVideoViewHolder) r2;
        if (r5 == false) goto L37;
        r11.g.setBackgroundResource(2131253237);
    L38:
        com.bytedance.android.livesdk.chatroom.model.l r13 = r11.k;
        if (r13 == null) goto L41;
        r13.b = r5;
    L41:
        ((com.bytedance.android.livesdk.chatroom.model.l) ListProtector.get(r10, r1)).b = r5;
        return;
    L37:
        r11.g.setBackgroundResource(2131253238);
        goto L38
    L45:
        return;
    L46:
        return;
    L25:
        r3 = null;
        goto L26
    L43:
        return;
    L17:
        r10 = null;
    L10:
        r0 = 0;
        goto L12
    }

    @Override // w62.g
    public final boolean RH(long r1) {
        if (Y90(r1) != this.J) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean W90(int r7) {
        RecyclerView r0 = this.t;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r1 = r0.findViewHolderForAdapterPosition(r7);
    L7:
        if (r1 != null) goto L9;
    L20:
        return false;
    L9:
        if ((r1 instanceof LiveVideoCommentSearchVideoViewHolder) == false) goto L20;
        LiveVideoCommentSearchVideoViewHolder r2 = (LiveVideoCommentSearchVideoViewHolder) r1;
        ViewGroup r3 = r2.i;
        Rect r4 = new Rect();
        if (r3.getGlobalVisibleRect(r4) == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L19;
        r2.T3(true);
        return true;
    L19:
        da0(r7);
        goto L20
    L13:
        if ((r4.bottom - r4.top) < r3.getHeight()) goto L15;
        r5 = true;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void X90(String r14) {
        if (this.A == false) goto L5;
        return;
    L5:
        this.A = true;
        if (this.B.equals(r14) == true) goto L16;
        this.z = 0;
        this.y = new Date().getTime();
        ga0(true, false);
        this.B = r14;
        MultiTypeAdapter r1 = this.u;
        if (r1 == null) goto L12;
        List r2 = r1.a;
        if (r2 == null) goto L12;
        r2.clear();
    L12:
        this.J = -1;
        this.L = -1;
        this.M = -1;
        w62.a r3 = w62.a.b;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r4 = w62.a.C0291a.a().a;
        if (r4 == null) goto L16;
        r4.stopVideoPlayer();
    L16:
        if (this.z != 0) goto L18;
        ga0(true, false);
    L19:
        RxUtilKt.c(((VideoApi) com.bytedance.android.live.network.c.b().e(VideoApi.class)).videoSearch("douyin_search", "normal_search", r14, this.z, 12, "search_" + this.y).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this)), this.d);
        Map<String, String> r15 = aa0();
        r15.put("search_content", this.B);
        j0.l().sendLog("livesdk_video_comment_search_click", r15, new Object[0]);
        return;
    L18:
        ea0(true, true);
        goto L19
    }

    public final int Y90(long r8) {
        MultiTypeAdapter r0 = this.u;
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L7:
        if (TypeIntrinsics.isMutableList(r1) == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        int r2 = this.H - 1;
        if (r2 >= 0) goto L14;
        r2 = 0;
    L14:
        int r3 = this.I + 1;
        if (r3 <= r1.size()) goto L17;
        r3 = r1.size();
    L17:
        if (r2 >= r3) goto L34;
        if ((ListProtector.get(r1, r2) instanceof com.bytedance.android.livesdk.chatroom.model.l) == false) goto L33;
        Object r4 = ListProtector.get(r1, r2);
        if (r4 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.model.j r5 = ((com.bytedance.android.livesdk.chatroom.model.l) r4).a;
        if (r5 == null) goto L25;
        Long r6 = r5.e();
    L26:
        if (r6 == null) goto L33;
        if (r6.longValue() != r8) goto L33;
        return r2;
    L25:
        r6 = null;
        goto L26
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.AwemeVideoItemInfo");
    L33:
        r2 = r2 + 1;
        goto L17
    L34:
        return -1;
    L5:
        r1 = null;
        goto L7
    }

    public final int Z90(Long r7) {
        MultiTypeAdapter r0 = this.u;
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L7:
        if (TypeIntrinsics.isMutableList(r1) == true) goto L9;
        r1 = null;
    L9:
        int r2 = 0;
        if (r1 == null) goto L12;
        int r3 = r1.size();
    L13:
        if (r2 >= r3) goto L30;
        if (r1 == null) goto L16;
        Object r4 = ListProtector.get(r1, r2);
    L18:
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.model.l) == true) goto L20;
        r4 = null;
    L20:
        com.bytedance.android.livesdk.chatroom.model.l r5 = (com.bytedance.android.livesdk.chatroom.model.l) r4;
        if (r5 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.model.j r6 = r5.a;
        if (r6 == null) goto L25;
        Long r8 = r6.e();
    L27:
        if (Intrinsics.areEqual(r8, r7) == true) goto L35;
        r2 = r2 + 1;
        goto L13
    L35:
        return r2;
    L25:
        r8 = null;
        goto L27
    L16:
        r4 = null;
        goto L18
    L30:
        return -1;
    L12:
        r3 = 0;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void ba0(int r4) {
        if (this.N != r4) goto L5;
        return;
    L5:
        this.N = r4;
        MultiTypeAdapter r0 = this.u;
        Object r1 = null;
        if (r0 == null) goto L8;
        List r2 = r0.a;
    L10:
        if (TypeIntrinsics.isMutableList(r2) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        Object r3 = ListProtector.get(r2, r4);
    L16:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.model.l) == false) goto L19;
        r1 = r3;
    L19:
        com.bytedance.android.livesdk.chatroom.model.l r5 = (com.bytedance.android.livesdk.chatroom.model.l) r1;
        if (r5 == null) goto L29;
        Map<String, String> r6 = aa0();
        com.bytedance.android.livesdk.chatroom.model.j r7 = r5.a;
        if (r7 == null) goto L26;
        Long r8 = r7.e();
        if (r8 == null) goto L26;
        long r9 = r8.longValue();
    L27:
        r6.put("video_id", String.valueOf(r9));
        r6.put("video_index", String.valueOf(r4 + 1));
        r6.put("tab_send", "search");
        j0.l().sendLog("livesdk_video_comment_preview", r6, new Object[0]);
        return;
    L26:
        r9 = 0;
        goto L27
    L29:
        return;
    L14:
        r3 = null;
        goto L16
    L8:
        r2 = null;
        goto L10
    }

    @Override // w62.g
    public final void cm(com.bytedance.android.livesdk.chatroom.model.l r21) {
        Intrinsics.checkNotNullParameter(r21, "videoItem");
        com.bytedance.android.livesdk.chatroom.model.j r1 = r21.a;
        if (r1 != null) goto L5;
        return;
    L5:
        Long r2 = r1.e();
        long r3 = 0;
        if (r2 == null) goto L8;
        long r6 = r2.longValue();
    L10:
        if (this.C.contains(Long.valueOf(r6)) == false) goto L12;
        return;
    L12:
        int r17 = Z90(Long.valueOf(r6));
        this.C.add(Long.valueOf(r6));
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.o r5 = IRoomContextService.a.a(r4, null, 0, 3);
        if (r5 == null) goto L21;
        com.bytedance.live.datacontext.m r7 = r5.getRoom();
        if (r7 == null) goto L21;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L21;
        long r18 = r8.getId();
    L22:
        Long r9 = r1.f();
        if (r9 == null) goto L25;
        r3 = r9.longValue();
    L25:
        long r14 = r3;
        boolean r10 = r21.b;
        VideoApi r11 = (VideoApi) com.bytedance.android.live.network.c.b().e(VideoApi.class);
        if (r11 == null) goto L34;
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.comment.data.g>> r0 = r11.videoPinShare(r18, r6, r14, 5);
        if (r0 == null) goto L34;
        Observable r13 = r0.compose(RxUtil.rxSchedulerHelper());
        if (r13 == null) goto L34;
        boolean r15 = r10;
        long r16 = r6;
        Disposable r19 = r13.subscribe(new k(this, r6, r18, r15, r17), new l(this, r16));
        if (r19 == null) goto L35;
        RxUtilKt.c(r19, this.d);
    L35:
        Map<String, String> r20 = aa0();
        r20.put("tab_send", "search");
        r20.put("video_id", String.valueOf(r16));
        if (r15 == false) goto L38;
        String r23 = "on";
    L39:
        r20.put("pin_status", r23);
        r20.put("video_index", String.valueOf(r17 + 1));
        j0.l().sendLog("livesdk_video_comment_send", r20, new Object[0]);
        return;
    L38:
        r23 = "off";
    L34:
        r15 = r10;
        r16 = r6;
    L21:
        r18 = 0;
        goto L22
    L8:
        r6 = 0;
        goto L10
    }

    public final void da0(int r2) {
        RecyclerView r0 = this.t;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r3 = r0.findViewHolderForAdapterPosition(r2);
    L7:
        if ((r3 instanceof LiveVideoCommentSearchVideoViewHolder) == false) goto L12;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r4 = ((LiveVideoCommentSearchVideoViewHolder) r3).n;
        if (r4 == null) goto L13;
        r4.pauseVideoPlayer();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public final void fa0(long r3) {
        ViewGroup r0 = this.m;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        LiveDoubleColorBallAnimationView r1 = this.n;
        if (r1 == null) goto L8;
        r1.c();
    L8:
        ViewGroup r2 = this.o;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r2);
    L11:
        ViewGroup r4 = this.r;
        if (r4 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r4);
    L14:
        EditText r5 = this.h;
        if (r5 == null) goto L18;
        r5.postDelayed(new n(this), r3);
        return;
    }

    public final void ha0(boolean r4) {
        MultiTypeAdapter r0 = this.u;
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L6:
        if (r1 == null) goto L21;
        List r2 = TypeIntrinsics.asMutableList(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.size() <= 0) goto L22;
        int r3 = r2.size() - 1;
        if ((ListProtector.get(r2, r3) instanceof com.bytedance.android.livesdk.chatroom.model.k) == false) goto L23;
        ListProtector.remove(r2, r3);
        if (r4 == false) goto L24;
        MultiTypeAdapter r5 = this.u;
        if (r5 == null) goto L25;
        r5.notifyItemRemoved(r3);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
    L5:
        r1 = null;
        goto L6
    }

    @Override // w62.g
    public final boolean l00(long r1) {
        if (Y90(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void ca0(String r3, String r4) {
        Map<String, String> r0 = aa0();
        r0.put("video_id", r3);
        r0.put("action_type", r4);
        r0.put("tab_send", "search");
        j0.l().sendLog("livesdk_video_comment_preview_click", r0, new Object[0]);
    }

    public final void ea0(boolean r4, boolean r5) {
        MultiTypeAdapter r0 = this.u;
        List r1 = null;
        if (r0 == null) goto L5;
        List r2 = r0.a;
    L7:
        if (TypeIntrinsics.isMutableList(r2) == false) goto L10;
        r1 = r2;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        int r3 = r1.size();
        if (r4 == false) goto L19;
        r1.add(new com.bytedance.android.livesdk.chatroom.model.k(1));
        if (r5 == false) goto L25;
        MultiTypeAdapter r6 = this.u;
        if (r6 == null) goto L26;
        r6.notifyItemInserted(r3);
        return;
    L26:
        return;
    L25:
        return;
    L19:
        r1.add(new com.bytedance.android.livesdk.chatroom.model.k(2));
        if (r5 == false) goto L28;
        MultiTypeAdapter r7 = this.u;
        if (r7 == null) goto L29;
        r7.notifyItemInserted(r3);
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void ga0(boolean r2, boolean r3) {
        if (r2 == false) goto L9;
        ViewGroup r0 = this.m;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r0);
    L6:
        LiveDoubleColorBallAnimationView r1 = this.n;
        if (r1 == null) goto L15;
        r1.b();
    L15:
        if (r3 == false) goto L19;
        ViewGroup r4 = this.o;
        if (r4 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r4);
    L22:
        if (r2 == true) goto L27;
        if (r3 == true) goto L27;
        RecyclerView r5 = this.t;
        if (r5 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r5);
    L30:
        ViewGroup r6 = this.r;
        if (r6 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r6);
        return;
    L34:
        return;
    L27:
        RecyclerView r7 = this.t;
        if (r7 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r7);
        goto L30
    L19:
        ViewGroup r8 = this.o;
        if (r8 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r8);
        goto L22
    L9:
        ViewGroup r9 = this.m;
        if (r9 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r9);
    L12:
        LiveDoubleColorBallAnimationView r10 = this.n;
        if (r10 == null) goto L15;
        r10.c();
        goto L15
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        this.x = true;
        ImageLoader.bindImage(this.p, P);
        ImageLoader.bindImage(this.s, O);
        ViewGroup r15 = this.i;
        if (r15 == null) goto L5;
        r15.setOnClickListener(new e(this));
    L5:
        EditText r16 = this.h;
        if (r16 == null) goto L8;
        r16.setOnKeyListener(new f(this));
    L8:
        EditText r17 = this.h;
        if (r17 == null) goto L11;
        r17.addTextChangedListener(new g(this));
    L11:
        ViewGroup r18 = this.j;
        if (r18 == null) goto L14;
        r18.setOnClickListener(new h(this));
    L14:
        ViewGroup r19 = this.k;
        if (r19 == null) goto L17;
        r19.setOnClickListener(new i(this));
    L17:
        Button r110 = this.q;
        if (r110 == null) goto L20;
        r110.setOnClickListener(new j(this));
    L20:
        int r111 = s1.y() - s1.f(32.0f);
        int r0 = s1.f(343.0f);
        if (this.w == false) goto L36;
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        String r3 = null;
        if (r1 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L32;
        com.bytedance.live.datacontext.m r4 = r2.getRoom();
        if (r4 == null) goto L32;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L32;
        r3 = r5.getAnchorAbValue("live_video_on_wall");
    L32:
        if (TextUtils.equals("1", r3) == false) goto L36;
        z.a.getClass();
        if (z.a.b().f() == true) goto L36;
        boolean r6 = true;
    L37:
        this.D = r6;
        if (r111 < r0) goto L41;
        r111 = r0;
    L41:
        int r7 = s1.f(331.0f);
        Context r8 = getContext();
        if (r8 == null) goto L47;
        w62.a r9 = w62.a.b;
        w62.a r10 = w62.a.C0291a.a();
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r10.a != null) goto L47;
        r10.a = jc1.k.n(IMiddlewareHostBusiness.class).getLivePureVideoPlayerView(r8, r111, r7, 0);
    L47:
        MultiTypeAdapter r11 = new MultiTypeAdapter();
        this.u = r11;
        r11.a = new ArrayList();
        MultiTypeAdapter r20 = this.u;
        if (r20 == null) goto L50;
        int r21 = r111;
        r20.z2(com.bytedance.android.livesdk.chatroom.model.l.class, new w62.b(getContext(), this, r21, r7, this.D));
    L50:
        MultiTypeAdapter r112 = this.u;
        if (r112 == null) goto L53;
        r112.z2(com.bytedance.android.livesdk.chatroom.model.k.class, new w62.c());
    L53:
        LinearLayoutManager r113 = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView r114 = this.t;
        if (r114 == null) goto L56;
        r114.setLayoutManager(r113);
    L56:
        RecyclerView r115 = this.t;
        if (r115 == null) goto L59;
        r115.setAdapter(this.u);
    L59:
        LoadMoreScrollListener r116 = new LoadMoreScrollListener(r113, new AnonymousClass8(this), new AnonymousClass9(this), new AnonymousClass10(this));
        this.v = r116;
        RecyclerView r117 = this.t;
        if (r117 == null) goto L62;
        r117.addOnScrollListener(r116);
    L62:
        this.A = false;
        fa0(300);
        if (this.w == true) goto L65;
        hd0.c.f().c(this.F);
    L65:
        w62.a r118 = w62.a.b;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r119 = w62.a.C0291a.a().a;
        if (r119 == null) goto L69;
        r119.setCallback(new m(this));
        return;
    L69:
        return;
    L36:
        r6 = false;
        goto L37
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        boolean r0 = false;
        View r8 = r5.inflate(2131566192, r6, false);
        IRoomContextService r9 = jc1.k.f(IRoomContextService.class);
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r10 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r10 == null) goto L9;
        Boolean r11 = r10.isAnchor();
        if (r11 == null) goto L9;
        r0 = r11.booleanValue();
    L9:
        this.w = r0;
        this.i = (ViewGroup) r8.findViewById(2131385310);
        this.h = (EditText) r8.findViewById(2131385509);
        this.j = (ViewGroup) r8.findViewById(2131385301);
        this.k = (ViewGroup) r8.findViewById(2131385510);
        this.l = (ImageView) r8.findViewById(2131385511);
        this.m = (ViewGroup) r8.findViewById(2131392368);
        this.n = r8.findViewById(2131392367);
        this.o = (ViewGroup) r8.findViewById(2131392370);
        this.p = r8.findViewById(2131392371);
        this.q = (Button) r8.findViewById(2131392369);
        this.r = (ViewGroup) r8.findViewById(2131392362);
        this.s = r8.findViewById(2131392363);
        this.t = r8.findViewById(2131392329);
        return r8;
    }
}
