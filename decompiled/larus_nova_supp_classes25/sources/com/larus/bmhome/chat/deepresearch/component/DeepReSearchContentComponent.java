package com.larus.bmhome.chat.deepresearch.component;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.bmhome.chat.deepresearch.DeepResearchAdapter;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchStatusBlock;
import com.larus.im.bean.message.block.Status;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.callback.IMError;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 w2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001wB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020!H\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002JF\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020!2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010L2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010L2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010LH\u0002J\u0016\u0010O\u001a\u0002092\f\u0010P\u001a\b\u0012\u0004\u0012\u0002090LH\u0002J\b\u0010Q\u001a\u000209H\u0002J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0002J\u001c\u0010T\u001a\u0002092\f\u0010U\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010V\u001a\u00020!J\b\u0010W\u001a\u00020.H\u0002J>\u0010X\u001a\u0002092\f\u0010U\u001a\b\u0012\u0004\u0012\u00020.0-2\b\b\u0002\u0010Y\u001a\u00020!2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[2\b\b\u0002\u0010\\\u001a\u00020!2\u0006\u0010V\u001a\u00020!H\u0002J\u001a\u0010]\u001a\u0002092\u0006\u0010V\u001a\u00020!2\b\u0010^\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0_H\u0016J\b\u0010`\u001a\u00020!H\u0016J\b\u0010a\u001a\u000209H\u0002J\b\u0010b\u001a\u00020!H\u0002J\b\u0010c\u001a\u000209H\u0002J\u0010\u0010h\u001a\u0002092\u0006\u0010i\u001a\u00020)H\u0002J&\u0010j\u001a\u0002092\u0006\u0010k\u001a\u00020)2\u0006\u0010l\u001a\u00020m2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u000e\u0010o\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\u0012\u0010p\u001a\u0002092\b\b\u0002\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u000209H\u0016J\b\u0010t\u001a\u000209H\u0016J\b\u0010u\u001a\u000209H\u0016J\b\u0010v\u001a\u000209H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0004\u0012\u00020!0,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020!00X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020)X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020)X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020)X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/component/DeepReSearchContentComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchContentAbility;", "<init>", "()V", "deepReSearchParam", "Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "getDeepReSearchParam", "()Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "deepReSearchParam$delegate", "Lkotlin/Lazy;", "researchList", "Landroidx/recyclerview/widget/RecyclerView;", "getResearchList", "()Landroidx/recyclerview/widget/RecyclerView;", "researchList$delegate", "deepSearchFragmentAbility", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchFragmentAbility;", "getDeepSearchFragmentAbility", "()Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchFragmentAbility;", "deepSearchFragmentAbility$delegate", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepResearchBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageDeepResearchBinding;", "binding$delegate", "podcastTimeoutJob", "Lkotlinx/coroutines/Job;", "controller", "Lcom/larus/im/DeepResearchController;", "isFinishLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "isFailed", "mAdapter", "Lcom/larus/bmhome/chat/deepresearch/DeepResearchAdapter;", "isUserTouch", "mobCardIdCache", "Lcom/larus/bmhome/chat/search/LruSet;", "", "timedBlockingQueue", "Lcom/larus/bmhome/chat/deepresearch/component/TimedBlockingQueue;", "Lkotlin/Pair;", "", "Lcom/larus/im/bean/message/block/Block;", "foldStates", "", "hasScrollLastPosition", "resourceId", "getResourceId", "()Ljava/lang/String;", "resourceId$delegate", "mAudioPlayStateChangeCallback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "eventJob", "isPodcastRequesting", "requestFullscreenPlaying", "lastRequestJob", "enterLoadingTask", "Ljava/lang/Runnable;", "exitLoadingTask", "initPodcastBtn", "enablePodcastButton", "enablePodcastBtn", "result", "Lcom/larus/im/model/DeepResearchResp;", "tryRequestPlayPodcast", "needFullscreenPlayer", "onLoading", "Lkotlin/Function0;", "onComplete", "onTimeout", "startPodcastTimeoutTask", "timeoutCallback", "mobGenerateTimeout", "mobPodcastClicked", "trackFinishTTS", "refreshContent", "blocks", "isFinish", "generateLoadingBlock", "realRefreshContent", "isFromChunk", "podcastData", "Lcom/larus/im/model/ReportPodcastData;", "isPodcastEnable", "updateFinishStatus", "lastBlock", "Landroidx/lifecycle/LiveData;", "isSuccess", "setUpRecycleView", "isProcessContent", "fetchDeepResearch", "CURRENT_STATE_LOADING", "CURRENT_STATE_ERROR", "CURRENT_STATE_SUCCESS", "currentState", "updateCurrentState", "state", "fetchDeepResearchBySSE", "resId", "curCursor", "", "originBLocks", "getBlocks", "smoothScrollToBottom", "durationMs", "", "onResume", "onStop", "onDestroy", "setScrollOffset", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepReSearchContentComponent extends BaseContentWidget implements j0 {
    public static final Map<String, Long> M = null;
    public static final Map<String, Pair<Integer, Integer>> N = null;
    public final Lazy A;
    public final c B;
    public Job C;
    public boolean D;
    public boolean E;
    public Job F;
    public final o G;
    public final p H;
    public final String I;
    public final String J;
    public final String K;
    public String L;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public Job q;
    public com.larus.im.internal.research.d.a r;
    public final MutableLiveData<Boolean> s;
    public boolean t;
    public DeepResearchAdapter u;
    public boolean v;
    public final LruSet<String> w;
    public final m0<Pair<List<Block>, Boolean>> x;
    public final Map<String, Boolean> y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements mf9.a<mf9.c> {
        public final /* synthetic */ DeepReSearchContentComponent a;

        public b(DeepReSearchContentComponent r1) {
            this.a = r1;
        }

        public final void a(IMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger r0 = FLogger.a;
            Map<String, Long> r1 = DeepReSearchContentComponent.M;
            r0.e("DeepSearchContent", "get deep research failure errorcode = " + r4.getCode() + " msg = " + r4.getTips());
            DeepReSearchContentComponent r5 = this.a;
            if (Intrinsics.areEqual(r5.L, r5.K) == true) goto L6;
            DeepReSearchContentComponent r6 = this.a;
            r6.Q3(r6.J);
            return;
        }

        public final void b(final mf9.c r9) {
            Intrinsics.checkNotNullParameter(r9, "result");
            DeepReSearchContentComponent r1 = this.a;
            List r2 = r9.a;
            mf9.e r4 = r9.e;
            mf9.b r0 = r9.d;
            if (r0 == null) goto L5;
            boolean r5 = r0.a;
        L6:
            DeepReSearchContentComponent.E3(r1, r2, false, r4, r5, r9.b, 2);
            LarusPageDeepResearchBinding r3 = this.a.p3();
            if (r3 == null) goto L11;
            AppCompatImageView r6 = r3.i;
            if (r6 == null) goto L11;
            final DeepReSearchContentComponent r7 = this.a;
            r6.post(new t(r7, r9));
        L11:
            DeepReSearchContentComponent r10 = this.a;
            r10.Q3(r10.K);
            return;
        L5:
            r5 = false;
            goto L6
        }

        public final void onSuccess(Object r11) {
            final mf9.c r12 = (mf9.c) r11;
            Intrinsics.checkNotNullParameter(r12, "result");
            DeepReSearchContentComponent r0 = this.a;
            r0.Q3(r0.K);
            FLogger r1 = FLogger.a;
            Map<String, Long> r2 = DeepReSearchContentComponent.M;
            r1.i("DeepSearchContent", "get deep research success");
            DeepReSearchContentComponent r3 = this.a;
            List r4 = r12.a;
            mf9.e r6 = r12.e;
            mf9.b r5 = r12.d;
            int r7 = 0;
            if (r5 == null) goto L5;
            boolean r8 = r5.a;
        L6:
            DeepReSearchContentComponent.E3(r3, r4, false, r6, r8, r12.b, 2);
            if (r12.b == true) goto L15;
            DeepReSearchContentComponent r9 = this.a;
            String r10 = r9.C3();
            Integer r13 = r12.c;
            if (r13 == null) goto L11;
            r7 = r13.intValue();
        L11:
            List r14 = r12.a;
            com.larus.im.internal.research.d.a r15 = r9.r;
            if (r15 == null) goto L14;
            r15.a();
        L14:
            com.larus.im.e r16 = com.larus.im.c.a;
            r9.r = com.larus.im.internal.research.a.a.b(new mf9.f(r10, r7, r14, new v(r9, r10, r7)));
        L15:
            LarusPageDeepResearchBinding r17 = this.a.p3();
            if (r17 == null) goto L21;
            AppCompatImageView r18 = r17.i;
            if (r18 == null) goto L22;
            final DeepReSearchContentComponent r19 = this.a;
            r18.post(new u(r19, r12));
            return;
        L22:
            return;
        L21:
            return;
        L5:
            r8 = false;
            goto L6
        }
    }

    public static final class c implements n68.a {
        public final /* synthetic */ DeepReSearchContentComponent a;

        public c(DeepReSearchContentComponent r1) {
            this.a = r1;
        }

        public final void d(PlayStateEnum r1) {
        }

        public final void e(TtsErrorType r1) {
        }

        public final void c(PlayStateEnum r8) {
            if (r8 != PlayStateEnum.PLAY_STATE_STOPPED) goto L6;
            DeepReSearchContentComponent r9 = this.a;
            Map<String, Long> r0 = DeepReSearchContentComponent.M;
            r9.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), Dispatchers.getIO(), null, new DeepReSearchContentComponent$trackFinishTTS$1(r9, null), 2, null);
            return;
        }

        public final void a(boolean r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }

        public final void b(boolean r1, String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }
    }

    static {
        M = new LinkedHashMap();
        N = new LinkedHashMap();
    }

    public final RecyclerView B3() {
        return (RecyclerView) this.n.getValue();
    }

    public final String C3() {
        return (String) this.A.getValue();
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.j0
    public final List<Block> HK() {
        DeepResearchAdapter r0 = this.u;
        if (r0 == null) goto L15;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L15;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Block r4 = ((ne8.m) r3.next()).c;
        if (r4 == null) goto L9;
        r2.add(r4);
        goto L9
    L13:
        return r2;
    L15:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.j0
    public final boolean isSuccess() {
        if (Intrinsics.areEqual(this.s.getValue(), Boolean.TRUE) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.t == true) goto L7;
        return true;
    }

    public final void m3() {
        Q3(this.I);
        if (C3().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        com.larus.im.e r1 = com.larus.im.c.a;
        com.larus.im.internal.research.a.a.a(C3(), new b(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onResume() {
        AudioServiceDelegate.a.r0().m(this.B);
    }

    public final void onStop() {
        AudioServiceDelegate.a.r0().k(this.B);
    }

    public final LarusPageDeepResearchBinding p3() {
        return (LarusPageDeepResearchBinding) this.p.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, j0.class);
    }

    public final DeepReSearchParam z3() {
        return (DeepReSearchParam) this.m.getValue();
    }

    public DeepReSearchContentComponent() {
        this.m = LazyKt.lazy(new com.larus.bmhome.chat.deepresearch.component.a(this));
        this.n = LazyKt.lazy(new k(this));
        this.o = LazyKt.lazy(new l(this));
        this.p = LazyKt.lazy(new m(this));
        this.s = new MutableLiveData(Boolean.FALSE);
        this.w = new LruSet(50);
        this.x = new m0();
        this.y = new LinkedHashMap();
        this.A = LazyKt.lazy(new n(this));
        this.B = new c(this);
        this.G = new o(this);
        this.H = new p(this);
        this.I = "loading";
        this.J = "error";
        this.K = "success";
        this.L = "loading";
    }

    public final boolean D3() {
        DeepReSearchParam r0 = z3();
        if (r0 == null) goto L7;
        Boolean r1 = r0.i;
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public final void onDestroy() {
        if (D3() == true) goto L19;
        RecyclerView r0 = B3();
        if (r0 == null) goto L8;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
    L10:
        if ((r1 instanceof LinearLayoutManager) == false) goto L12;
        LinearLayoutManager r2 = (LinearLayoutManager) r1;
    L13:
        if (r2 == null) goto L19;
        int r3 = r2.findFirstVisibleItemPosition();
        View r4 = r2.findViewByPosition(r3);
        Map<String, Pair<Integer, Integer>> r5 = N;
        String r6 = C3();
        Integer r7 = Integer.valueOf(r3);
        if (r4 == null) goto L17;
        Number r8 = Float.valueOf(r4.getY());
    L18:
        r5.put(r6, new Pair(r7, Integer.valueOf(r8.intValue())));
        goto L19
    L17:
        r8 = 0;
        goto L18
    L12:
        r2 = null;
        goto L13
    L8:
        r1 = null;
    L19:
        com.larus.im.internal.research.d.a r9 = this.r;
        if (r9 == null) goto L22;
        r9.a();
    L22:
        Job r10 = this.x.c;
        if (r10 == null) goto L26;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
        return;
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.j0
    public final MutableLiveData ow() {
        return this.s;
    }

    public final void Q3(String r4) {
        this.L = r4;
        if (Intrinsics.areEqual(r4, this.I) == false) goto L29;
        LarusPageDeepResearchBinding r5 = p3();
        if (r5 == null) goto L11;
        LarusPageDeepResearchLoadingBinding r6 = r5.c;
        if (r6 == null) goto L11;
        LinearLayout r7 = r6.a;
        if (r7 == null) goto L11;
        r7.setVisibility(0);
    L11:
        LarusPageDeepResearchBinding r8 = p3();
        if (r8 == null) goto L18;
        LarusPageDeepResearchErrorBinding r9 = r8.b;
        if (r9 == null) goto L18;
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L18;
        r10.setVisibility(8);
    L18:
        LarusPageDeepResearchBinding r11 = p3();
        if (r11 == null) goto L23;
        FrameLayout r12 = r11.k;
        if (r12 == null) goto L23;
        r12.setVisibility(8);
    L23:
        LarusPageDeepResearchBinding r13 = p3();
        if (r13 == null) goto L81;
        ConstraintLayout r14 = r13.g;
        if (r14 == null) goto L82;
        r14.setVisibility(8);
        return;
    L82:
        return;
    L81:
        return;
    L29:
        if (Intrinsics.areEqual(r4, this.J) == false) goto L55;
        LarusPageDeepResearchBinding r15 = p3();
        if (r15 == null) goto L37;
        LarusPageDeepResearchLoadingBinding r16 = r15.c;
        if (r16 == null) goto L37;
        LinearLayout r17 = r16.a;
        if (r17 == null) goto L37;
        r17.setVisibility(8);
    L37:
        LarusPageDeepResearchBinding r18 = p3();
        if (r18 == null) goto L44;
        LarusPageDeepResearchErrorBinding r19 = r18.b;
        if (r19 == null) goto L44;
        ConstraintLayout r20 = r19.a;
        if (r20 == null) goto L44;
        r20.setVisibility(0);
    L44:
        LarusPageDeepResearchBinding r21 = p3();
        if (r21 == null) goto L49;
        FrameLayout r22 = r21.k;
        if (r22 == null) goto L49;
        r22.setVisibility(8);
    L49:
        LarusPageDeepResearchBinding r23 = p3();
        if (r23 == null) goto L84;
        ConstraintLayout r24 = r23.g;
        if (r24 == null) goto L85;
        r24.setVisibility(8);
        return;
    L85:
        return;
    L84:
        return;
    L55:
        if (Intrinsics.areEqual(r4, this.K) == false) goto L87;
        LarusPageDeepResearchBinding r25 = p3();
        if (r25 == null) goto L63;
        LarusPageDeepResearchLoadingBinding r26 = r25.c;
        if (r26 == null) goto L63;
        LinearLayout r27 = r26.a;
        if (r27 == null) goto L63;
        r27.setVisibility(8);
    L63:
        LarusPageDeepResearchBinding r28 = p3();
        if (r28 == null) goto L70;
        LarusPageDeepResearchErrorBinding r29 = r28.b;
        if (r29 == null) goto L70;
        ConstraintLayout r30 = r29.a;
        if (r30 == null) goto L70;
        r30.setVisibility(8);
    L70:
        LarusPageDeepResearchBinding r31 = p3();
        if (r31 == null) goto L75;
        FrameLayout r32 = r31.k;
        if (r32 == null) goto L75;
        r32.setVisibility(0);
    L75:
        LarusPageDeepResearchBinding r33 = p3();
        if (r33 == null) goto L88;
        ConstraintLayout r34 = r33.g;
        if (r34 == null) goto L89;
        r34.setVisibility(0);
        return;
    L89:
        return;
    L88:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.deepresearch.component.r] */
    public final void onViewCreated(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        RecyclerView r11 = B3();
        if (r11 == null) goto L15;
        r11.setLayoutManager(new LinearLayoutManager(r11.getContext()));
        r11.setItemAnimator(null);
        if (D3() == false) goto L7;
        r11.addItemDecoration(new DeepResearchProcessListItemDecoration());
    L8:
        DeepReSearchParam r2 = z3();
        if (r2 == null) goto L13;
        Boolean r3 = r2.i;
        if (r3 == null) goto L13;
        boolean r4 = r3.booleanValue();
    L14:
        DeepResearchAdapter r1 = new DeepResearchAdapter(r11, r4, new r(this));
        r1.f = new a0(this);
        this.u = r1;
        r11.setAdapter(r1);
    L13:
        r4 = false;
        goto L14
    L7:
        r11.addItemDecoration(new DeepResearchContentListItemDecoration());
    L15:
        RecyclerView r12 = B3();
        if (r12 == null) goto L18;
        ExposureTrackerExtKt.b(r12);
    L18:
        RecyclerView r13 = B3();
        if (r13 == null) goto L21;
        r13.addOnScrollListener(new DeepReSearchContentComponent$setUpRecycleView$2(this));
    L21:
        RecyclerView r14 = B3();
        if (r14 == null) goto L24;
        r14.setOnTouchListener(new s(this));
    L24:
        LarusPageDeepResearchBinding r15 = p3();
        if (r15 == null) goto L31;
        LarusPageDeepResearchErrorBinding r16 = r15.b;
        if (r16 == null) goto L31;
        ConstraintLayout r17 = r16.a;
        if (r17 == null) goto L31;
        r17.setOnClickListener(new com.larus.bmhome.chat.deepresearch.component.b(this));
    L31:
        m3();
        m0<Pair<List<Block>, Boolean>> r18 = this.x;
        Function1 r5 = new q(this);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r5, "onConsume");
        r18.c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TimedBlockingQueue$startConsuming$1(r18, r5, null), 3, null);
    }

    public static final boolean Y2(DeepReSearchContentComponent r2, mf9.c r3) {
        r2.getClass();
        mf9.b r4 = r3.d;
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L32;
        mf9.e r6 = r3.e;
        if (r6 == null) goto L30;
        String r7 = r6.a;
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L30;
        mf9.e r9 = r3.e;
        if (r9 == null) goto L22;
        String r10 = r9.b;
    L23:
        if (r10 != null) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r11 == true) goto L30;
        return false;
    L25:
        if (r10.length() == 0) goto L28;
        r11 = false;
        goto L29
    L22:
        r10 = null;
        goto L23
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
    L30:
        return true;
    L32:
        return false;
    L5:
        if (r4.a != true) goto L7;
        r5 = true;
        goto L8
    }

    public static final void h3(final DeepReSearchContentComponent r10, boolean r11) {
        boolean r0 = false;
        r10.D = false;
        Job r1 = r10.C;
        AppCompatImageView r2 = null;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        r10.C = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), Dispatchers.getIO(), null, new DeepReSearchContentComponent$initPodcastBtn$1(r10, r11, null), 2, null);
        if (r11 == true) goto L18;
        LarusPageDeepResearchBinding r12 = r10.p3();
        if (r12 == null) goto L12;
        AppCompatImageView r13 = r12.i;
        if (r13 == null) goto L12;
        e1.o(r13);
    L12:
        LarusPageDeepResearchBinding r14 = r10.p3();
        if (r14 == null) goto L40;
        ProgressBar r15 = r14.j;
        if (r15 == null) goto L41;
        e1.o(r15);
        return;
    L41:
        return;
    L40:
        return;
    L18:
        if (z2.a.deepResearchPodcastUseIconType() == 0) goto L30;
        LarusPageDeepResearchBinding r16 = r10.p3();
        if (r16 == null) goto L30;
        AppCompatImageView r17 = r16.i;
        if (r17 == null) goto L30;
        LarusPageDeepResearchBinding r3 = r10.p3();
        if (r3 == null) goto L28;
        AppCompatImageView r4 = r3.i;
        if (r4 == null) goto L28;
        Context r5 = r4.getContext();
    L29:
        r17.setImageResource(v19.c.b(2130971964, r5, 2131242600));
    L28:
        r5 = null;
    L30:
        DeepReSearchParam r18 = r10.z3();
        if (r18 == null) goto L33;
        r0 = Intrinsics.areEqual(r18.i, Boolean.FALSE);
    L33:
        if (r0 == false) goto L35;
        r10.H.run();
    L35:
        LarusPageDeepResearchBinding r19 = r10.p3();
        if (r19 == null) goto L38;
        r2 = r19.i;
    L38:
        e1.d(r2, new e(r10));
    }

    public final void G3(List<Block> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "blocks");
        m0<Pair<List<Block>, Boolean>> r0 = this.x;
        Pair<List<Block>, Boolean> r4 = TuplesKt.to(r2, Boolean.valueOf(r3));
        r0.b.put(r4);
        FLogger.a.d("TimedBlockingQueue", "offer:");
    }

    public final void H3(boolean r12, Function0<Unit> r13, Function0<Unit> r14, final Function0<Unit> r15) {
        if (this.D == false) goto L6;
        FLogger.a.i("DeepSearchContent", "podcast generate is requesting，so return click directly");
        return;
    L6:
        String r0 = C3();
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L16;
        FLogger.a.e("DeepSearchContent", "resourceId is empty!");
        return;
    L16:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L21;
        FlowAppletServiceImpl r3 = r2.g0();
        if (r3 == null) goto L21;
        String r4 = r3.i();
    L23:
        if (Intrinsics.areEqual(r4, C3()) == true) goto L25;
    L38:
        M.put(C3(), Long.valueOf(SystemClock.elapsedRealtime()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DeepReSearchContentComponent$mobPodcastClicked$1(this, null), 2, null);
        Function0 r5 = new j(r15);
        int r16 = z2.a.deepResearchPodcastLoadingTimeoutInterval();
        if (r16 <= 0) goto L41;
        this.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DeepReSearchContentComponent$startPodcastTimeoutTask$1(r16, this, r5, null), 2, null);
    L41:
        r13.invoke();
        this.D = true;
        this.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DeepReSearchContentComponent$tryRequestPlayPodcast$3(this, r12, r14, null), 2, null);
        return;
    L25:
        if ((!StringsKt.isBlank(C3())) == false) goto L38;
        FLogger.a.i("DeepSearchContent", "target podcast is the same as current, so send resume order and return.resourceId=" + C3() + ", requestPlaying=" + this.E + ", needFullscreenPlayer=" + r12);
        if (this.E == false) goto L30;
        if (r12 == false) goto L30;
        return;
    L30:
        if (r12 == false) goto L32;
        this.E = true;
    L32:
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L43;
        FlowAppletServiceImpl r18 = r17.g0();
        if (r18 == null) goto L44;
        JsonObject r19 = new JsonObject();
        r19.addProperty("resource_id", C3());
        r19.addProperty("open_player", Boolean.valueOf(r12));
        Unit r110 = Unit.INSTANCE;
        r18.a("flow.playDeepResearch", r19);
        return;
    L44:
        return;
    L43:
        return;
    L21:
        r4 = null;
        goto L23
    L9:
        if (StringsKt.isBlank(r0) == true) goto L12;
        r1 = false;
        goto L13
    }

    public static void E3(final DeepReSearchContentComponent r90, List r91, boolean r92, mf9.e r93, boolean r94, boolean r95, int r96) {
        boolean r2 = false;
        if ((r96 & 2) == 0) goto L5;
        final boolean r1 = false;
    L7:
        if ((r96 & 4) == 0) goto L9;
        mf9.e r3 = null;
    L11:
        if ((r96 & 8) == 0) goto L13;
        boolean r5 = false;
    L14:
        r90.getClass();
        Block r6 = (Block) CollectionsKt.lastOrNull(r91);
        if (r6 == null) goto L26;
        BlockContent r8 = r6.getContent();
        if (r8 == null) goto L26;
        ResearchStatusBlock r9 = r8.getResearchStatusBlock();
        if (r9 == null) goto L26;
        Integer r10 = r9.status;
        int r11 = Status.STATUS_FAIL.getValue();
        if (r10 == null) goto L26;
        if (r10.intValue() != r11) goto L26;
        boolean r12 = true;
    L27:
        r90.t = r12;
        MutableLiveData<Boolean> r13 = r90.s;
        if (r95 == true) goto L57;
        if (r6 == null) goto L40;
        BlockContent r14 = r6.getContent();
        if (r14 == null) goto L40;
        ResearchStatusBlock r15 = r14.getResearchStatusBlock();
        if (r15 == null) goto L40;
        Integer r16 = r15.status;
        int r17 = Status.STATUS_FAIL.getValue();
        if (r16 == null) goto L40;
        if (r16.intValue() != r17) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == true) goto L57;
        if (r6 == null) goto L53;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L53;
        ResearchStatusBlock r19 = r7.getResearchStatusBlock();
        if (r19 == null) goto L53;
        Integer r20 = r19.status;
        int r21 = Status.STATUS_FINISH.getValue();
        if (r20 == null) goto L53;
        if (r20.intValue() != r21) goto L53;
        boolean r22 = true;
    L54:
        if (r22 == true) goto L57;
        boolean r23 = false;
    L58:
        r13.setValue(Boolean.valueOf(r23));
        DeepResearchAdapter r24 = r90.u;
        if (r24 == null) goto L61;
        r24.e = r1;
    L61:
        Block r25 = (Block) CollectionsKt.lastOrNull(r91);
        if (r25 != null) goto L64;
    L66:
        if (r2 == true) goto L68;
    L70:
        List r4 = r91;
    L71:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r4.iterator();
    L73:
        if (r27.hasNext() == false) goto L82;
        Block r28 = (Block) r27.next();
        r26.add(new ne8.m(r28.getBlockType(), null, r28, 10));
        if (r28.getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.i) goto L73;
        if (z2.a.showPodcastsTopBanner() == false) goto L73;
        if (r5 == false) goto L73;
        if (r3 == null) goto L73;
        r26.add(new ne8.m(com.larus.bmhome.chat.deepresearch.view.j.a, r3, null, 12));
        goto L73
    L82:
        if (r90.D3() == false) goto L84;
    L86:
        DeepResearchAdapter r29 = r90.u;
        if (r29 == null) goto L101;
        r29.submitList(r26, new com.larus.bmhome.chat.deepresearch.component.c(r90, r1));
        return;
    L101:
        return;
    L84:
        if (r90.isSuccess() == false) goto L86;
        int r30 = com.larus.bmhome.chat.deepresearch.view.j.b;
        r26.add(new ne8.m(r30, null, new Block(r30, "local-ai-content-disclaimer", null, null, false, null, null, null, 252, null), 10));
        goto L86
    L68:
        if (Intrinsics.areEqual(r90.s.getValue(), Boolean.FALSE) == false) goto L70;
        r4 = CollectionsKt.toMutableList(r91);
        r4.add(new Block(com.larus.bmhome.chat.deepresearch.view.j.e, "local-loading-" + System.currentTimeMillis(), null, new BlockContent(new TextBlock(r90.getContext().getString(2131901447), null, null, null, 0, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 228, null));
        goto L71
    L64:
        if (r25.isFinish() != true) goto L66;
        r2 = true;
    L53:
        r22 = false;
    L40:
        r18 = false;
    L57:
        r23 = true;
    L26:
        r12 = false;
        goto L27
    L13:
        r5 = r94;
        goto L14
    L9:
        r3 = r93;
        goto L11
    L5:
        r1 = r92;
        goto L7
    }
}
