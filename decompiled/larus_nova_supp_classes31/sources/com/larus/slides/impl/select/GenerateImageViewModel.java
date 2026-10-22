package com.larus.slides.impl.select;

import android.app.Application;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.common.mockloading.ILoadingProgressMocker;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.slides.impl.select.common.TextRes;
import com.larus.slides.impl.select.model.SlidesAIPPTRepository;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000201H\u0002J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u0018H\u0002J\u0016\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u0002012\u0006\u0010:\u001a\u00020\u0018H\u0002J\u0010\u0010?\u001a\u0002012\u0006\u0010:\u001a\u00020\u0018H\u0002J\u0010\u0010@\u001a\u0002012\u0006\u0010:\u001a\u00020\u0018H\u0002J\"\u0010A\u001a\u0002012\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\b\b\u0002\u0010E\u001a\u00020(H\u0002J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u0012H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/larus/slides/impl/select/IGenerateImageViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "progressMockerJob", "Lkotlinx/coroutines/Job;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/slides/impl/select/GenerateImageUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/slides/impl/select/GenerateImageUIEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "curPosition", "", "onePageImageNum", "showBgImageMaxCnt", "maxPageNum", "pageIndexToProgressMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/slides/impl/select/ProgressMocker;", "curProgressRefreshJob", "bgImageEditInfo", "Lcom/larus/im/bean/bot/BgImageEditInfo;", "botName", "", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "shownPageIndexSet", "", "queryText", "queryImageListString", "queryImageRatio", "dispatchUIAction", "", "uiAction", "Lcom/larus/slides/impl/select/GenerateImageUIAction;", "onConfirm", "handleOnResult", "bundle", "Landroid/os/Bundle;", "onCreate", "onPageSelected", "position", "generateImage", "pageIndex", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onItemClick", "onItemLongClick", "refreshProgress", "refreshUIState", "viewPagerViewData", "", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "canConfirm", "sendUIEvent", "event", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GenerateImageViewModel extends AndroidViewModel implements t {
    public static final a Companion = null;
    private static final int DEFAULT_GEN_IMAGES_CNT = 4;
    private static final String TAG = "GenerateImageViewModel";
    private final MutableSharedFlow<o> _uiEvent;
    private final z0<p> _uiState;
    private uc9.b bgImageEditInfo;
    private String botDescription;
    private BotModel botInfo;
    private String botName;
    private int curPosition;
    private Job curProgressRefreshJob;
    private int maxPageNum;
    private boolean needUpdateBotInfo;
    private final int onePageImageNum;
    private final ConcurrentHashMap<Integer, b0> pageIndexToProgressMap;
    private Job progressMockerJob;
    private String queryImageListString;
    private String queryImageRatio;
    private String queryText;
    private final int showBgImageMaxCnt;
    private final Set<Integer> shownPageIndexSet;
    private final d1<o> uiEvent;
    private final i1<p> uiState;
    private String userBotGender;
    private String userBotType;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/slides/impl/select/GenerateImageViewModel$generateImage$queryImageObjList$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/slides/impl/select/model/AIPPTReferenceImage;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<List<? extends com.larus.slides.impl.select.model.c>> {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$generateImage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel", f = "GenerateImageViewModel.kt", i = {0}, l = {173}, m = "generateImage", n = {"pageIndex"}, s = {"I$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GenerateImageViewModel this$0;

        public AnonymousClass1(GenerateImageViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return GenerateImageViewModel.access$generateImage(this.this$0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$generateImage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$generateImage$2", f = "GenerateImageViewModel.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b0 $progressMocker;
        int label;

        public AnonymousClass2(b0 r1, Continuation<? super AnonymousClass2> r2) {
            this.$progressMocker = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$progressMocker, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            b0 r5 = this.$progressMocker;
            this.label = 1;
            r5.getClass();
            Object r6 = ILoadingProgressMocker.DefaultImpls.a(r5, this);
            if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r6 = Unit.INSTANCE;
        L12:
            if (r6 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$onConfirm$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$onConfirm$1", f = "GenerateImageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GenerateImageViewModel this$0;

        public C01481(GenerateImageViewModel r1, Continuation<? super C01481> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01481(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            GenerateImageViewHolder.b r4 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) this.this$0.getUiState().getValue()).a, GenerateImageViewModel.access$getCurPosition$p(this.this$0));
            if (r4 == null) goto L10;
            String r5 = r4.c;
            if (r5 == null) goto L10;
            GenerateImageViewModel.access$sendUIEvent(this.this$0, new o.f(r5));
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$onCreate$1", f = "GenerateImageViewModel.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GenerateImageViewModel this$0;

        public C01491(GenerateImageViewModel r1, Continuation<? super C01491> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01491(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            GenerateImageViewModel r5 = this.this$0;
            this.label = 1;
            if (GenerateImageViewModel.access$generateImage(r5, 0, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$onPageSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$onPageSelected$1", f = "GenerateImageViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GenerateImageViewModel this$0;

        public C01501(GenerateImageViewModel r1, Continuation<? super C01501> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01501(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            GenerateImageViewModel r6 = this.this$0;
            int r2 = GenerateImageViewModel.access$getCurPosition$p(r6) / GenerateImageViewModel.access$getOnePageImageNum$p(this.this$0);
            this.label = 1;
            if (GenerateImageViewModel.access$generateImage(r6, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$refreshProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$refreshProgress$1", f = "GenerateImageViewModel.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ GenerateImageViewModel this$0;

        /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$refreshProgress$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GenerateImageViewModel a;
            public final /* synthetic */ int b;

            public a(GenerateImageViewModel r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r6, Continuation r7) {
                int r8 = ((Number) r6).intValue();
                GenerateImageViewModel r9 = this.a;
                List r0 = CollectionsKt.toMutableList(((p) r9.getUiState().getValue()).a);
                int r1 = this.b;
                if (r1 >= r0.size()) goto L5;
                ListProtector.set(r0, r1, GenerateImageViewHolder.b.a((GenerateImageViewHolder.b) ListProtector.get(r0, r1), Boxing.boxInt(r8), null, null, 447));
            L5:
                GenerateImageViewModel.refreshUIState$default(r9, r0, false, 2, null);
                return Unit.INSTANCE;
            }
        }

        public C01511(GenerateImageViewModel r1, int r2, Continuation<? super C01511> r3) {
            this.this$0 = r1;
            this.$position = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01511(this.this$0, this.$position, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            b0 r7 = (b0) GenerateImageViewModel.access$getPageIndexToProgressMap$p(this.this$0).get(Boxing.boxInt(this.$position / GenerateImageViewModel.access$getOnePageImageNum$p(this.this$0)));
            if (r7 == null) goto L18;
            StateFlowImpl r8 = r7.a;
            if (r8 == null) goto L18;
            a r2 = new a(this.this$0, this.$position);
            this.label = 1;
            if (r8.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.select.GenerateImageViewModel$sendUIEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageViewModel$sendUIEvent$1", f = "GenerateImageViewModel.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ o $event;
        int label;
        final /* synthetic */ GenerateImageViewModel this$0;

        public C01521(GenerateImageViewModel r1, o r2, Continuation<? super C01521> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01521(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = GenerateImageViewModel.access$get_uiEvent$p(this.this$0);
            o r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    private final void handleOnResult(Bundle r1) {
    }

    private final void onItemLongClick(int r1) {
    }

    private final void onConfirm() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01481(this, null), 3, null);
    }

    @Override // com.larus.slides.impl.select.s
    public d1<o> getUiEvent() {
        return this.uiEvent;
    }

    @Override // com.larus.slides.impl.select.s
    public i1<p> getUiState() {
        return this.uiState;
    }

    public GenerateImageViewModel(Application r13) {
        Intrinsics.checkNotNullParameter(r13, "application");
        super(r13);
        StateFlowImpl r14 = j1.a(new p(CollectionsKt.listOf(new GenerateImageViewHolder.b(false, null, null, null, null, null, 0, null, null)), false));
        this._uiState = r14;
        this.uiState = kotlinx.coroutines.flow.e.b(r14);
        MutableSharedFlow<o> r15 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._uiEvent = r15;
        this.uiEvent = kotlinx.coroutines.flow.e.a(r15);
        this.onePageImageNum = 4;
        this.showBgImageMaxCnt = 4;
        this.maxPageNum = 1;
        this.pageIndexToProgressMap = new ConcurrentHashMap();
        this.bgImageEditInfo = new uc9.b();
        this.shownPageIndexSet = new LinkedHashSet();
    }

    public static final /* synthetic */ int access$getCurPosition$p(GenerateImageViewModel r0) {
        return r0.curPosition;
    }

    public static final /* synthetic */ int access$getOnePageImageNum$p(GenerateImageViewModel r0) {
        return r0.onePageImageNum;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPageIndexToProgressMap$p(GenerateImageViewModel r0) {
        return r0.pageIndexToProgressMap;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_uiEvent$p(GenerateImageViewModel r0) {
        return r0._uiEvent;
    }

    private final void onCreate(Bundle r8) {
        String r0 = "";
        if (r8 == null) goto L6;
        String r1 = r8.getString("gen_images_query_text", "");
        if (r1 == null) goto L6;
    L7:
        this.queryText = r1;
        if (r8 == null) goto L11;
        String r2 = r8.getString("gen_images_query_image_list", "");
        if (r2 == null) goto L11;
    L12:
        this.queryImageListString = r2;
        if (r8 == null) goto L18;
        String r3 = r8.getString("gen_images_query_ratio", "");
        if (r3 == null) goto L18;
        r0 = r3;
    L18:
        this.queryImageRatio = r0;
        if (r8 == null) goto L21;
        Serializable r4 = r8.getSerializable("bg_image_info");
    L23:
        if ((r4 instanceof BgImageInfo) == false) goto L25;
        BgImageInfo r5 = (BgImageInfo) r4;
    L26:
        if (r5 == null) goto L29;
        uc9.b r6 = r5.toBgImageEditInfo();
        if (r6 == null) goto L29;
    L30:
        this.bgImageEditInfo = r6;
        if (r8 == null) goto L34;
        String r7 = r8.getString("bot_name");
        if (r7 == null) goto L34;
    L35:
        this.botName = r7;
        if (r8 == null) goto L39;
        String r9 = r8.getString("bot_description");
        if (r9 == null) goto L39;
    L40:
        this.botDescription = r9;
        if (r8 == null) goto L44;
        String r10 = r8.getString("user_bot_gender");
        if (r10 == null) goto L44;
    L45:
        this.userBotGender = r10;
        if (r8 == null) goto L49;
        String r11 = r8.getString("user_bot_type");
        if (r11 == null) goto L49;
    L50:
        this.userBotType = r11;
        if (r8 == null) goto L53;
        boolean r12 = r8.getBoolean("need_update_bot_info");
    L54:
        this.needUpdateBotInfo = r12;
        if (r8 == null) goto L57;
        Serializable r13 = r8.getSerializable("bot_update_bot_argument");
    L59:
        if ((r13 instanceof BotModel) == false) goto L61;
        BotModel r14 = (BotModel) r13;
    L62:
        this.botInfo = r14;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain().getImmediate(), null, new C01491(this, null), 2, null);
        return;
    L61:
        r14 = null;
        goto L62
    L57:
        r13 = null;
        goto L59
    L53:
        r12 = false;
    L49:
        r11 = this.userBotType;
    L44:
        r10 = this.userBotGender;
    L39:
        r9 = this.botDescription;
    L34:
        r7 = this.botName;
    L29:
        r6 = this.bgImageEditInfo;
        goto L30
    L25:
        r5 = null;
        goto L26
    L21:
        r4 = null;
    L11:
        r2 = "";
    L6:
        r1 = "";
        goto L7
    }

    private final void onItemClick(int r8) {
        GenerateImageViewHolder.b r0 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) getUiState().getValue()).a, r8);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == false) goto L9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new GenerateImageViewModel$onItemClick$1$1(this, r8, null), 2, null);
        return;
    }

    private final void onPageSelected(int r11) {
        this.curPosition = r11;
        if (r11 > 0) goto L5;
    L13:
        refreshProgress(r11);
    L14:
        GenerateImageViewHolder.b r2 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) getUiState().getValue()).a, this.curPosition);
        if (r2 == null) goto L17;
        String r3 = r2.e;
    L18:
        refreshUIState$default(this, null, o0.d(r3), 1, null);
        if (((p) getUiState().getValue()).b == false) goto L22;
        this.shownPageIndexSet.add(Integer.valueOf(r11));
        return;
    L22:
        return;
    L17:
        r3 = null;
        goto L18
    L5:
        if (this.pageIndexToProgressMap.containsKey(Integer.valueOf(r11 / this.onePageImageNum)) == true) goto L13;
        GenerateImageViewHolder.b r4 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) getUiState().getValue()).a, this.curPosition);
        boolean r5 = false;
        if (r4 != null) goto L9;
    L11:
        if (r5 == true) goto L13;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01501(this, null), 2, null);
        goto L14
    L9:
        if (true != r4.a) goto L11;
        r5 = true;
        goto L11
    }

    private final void refreshProgress(int r10) {
        Job r0 = this.curProgressRefreshJob;
        boolean r1 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.curProgressRefreshJob = null;
        GenerateImageViewHolder.b r2 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) getUiState().getValue()).a, r10);
        if (r2 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L21;
        GenerateImageViewHolder.b r3 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(((p) getUiState().getValue()).a, r10);
        if (r3 == null) goto L15;
        String r4 = r3.e;
    L16:
        if (r4 == null) goto L18;
        return;
    L18:
        if (this.pageIndexToProgressMap.containsKey(Integer.valueOf(r10 / this.onePageImageNum)) == false) goto L23;
        this.curProgressRefreshJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01511(this, r10, null), 2, null);
        return;
    L23:
        return;
    L15:
        r4 = null;
        goto L16
    L21:
        return;
    L8:
        if (r2.a == true) goto L10;
        goto L10
    }

    private final void sendUIEvent(o r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01521(this, r7, null), 3, null);
    }

    /* JADX INFO: renamed from: dispatchUIAction, reason: avoid collision after fix types in other method */
    public void dispatchUIAction2(n r2) {
        Intrinsics.checkNotNullParameter(r2, "uiAction");
        if ((r2 instanceof n.b) == false) goto L6;
        onCreate(((n.b) r2).a);
        return;
    L6:
        if ((r2 instanceof n.e) == false) goto L9;
        onPageSelected(((n.e) r2).a);
        return;
    L9:
        if ((r2 instanceof n.c) == false) goto L12;
        onItemClick(((n.c) r2).a);
        return;
    L12:
        if ((r2 instanceof n.d) == false) goto L15;
        onItemLongClick(((n.d) r2).a);
        return;
    L15:
        if ((r2 instanceof n.a) == false) goto L18;
        onConfirm();
        return;
    L18:
        if ((r2 instanceof n.f) == false) goto L22;
        handleOnResult(((n.f) r2).a);
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.slides.impl.select.s
    public /* bridge */ /* synthetic */ void dispatchUIAction(n r1) {
        dispatchUIAction2(r1);
    }

    public static final /* synthetic */ void access$sendUIEvent(GenerateImageViewModel r0, o r1) {
        r0.sendUIEvent(r1);
    }

    private final Object generateImage(int r26, Continuation<? super Unit> r27) {
        int r1 = r26;
        if ((r27 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r27;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 0;
        String r9 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r1 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L30:
        com.larus.network.http.f r8 = (com.larus.network.http.a) r2;
        ArrayList r10 = new ArrayList();
        com.larus.slides.impl.select.model.b r11 = (com.larus.slides.impl.select.model.b) ((com.larus.network.http.a) r8).b;
        if (r11 == null) goto L154;
        List<com.larus.slides.impl.select.model.d> r12 = r11.a();
        if (r12 == null) goto L154;
        List r13 = CollectionsKt.take(r12, this.onePageImageNum);
        if (r13 == null) goto L154;
        Ref.IntRef r14 = new Ref.IntRef();
        if (r1 != 0) goto L89;
        List r15 = r13;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L40:
        if (r17.hasNext() == false) goto L88;
        com.larus.slides.impl.select.model.d r18 = (com.larus.slides.impl.select.model.d) r17.next();
        if (r18 == null) goto L46;
        com.larus.slides.impl.actionbar.model.a r19 = r18.a();
        if (r19 == null) goto L46;
        String r110 = r19.b();
    L47:
        if (r110 != null) goto L49;
    L52:
        boolean r111 = true;
    L53:
        if (r111 == false) goto L56;
        r14.element++;
    L56:
        if (r18 == null) goto L60;
        com.larus.slides.impl.actionbar.model.a r112 = r18.b();
        if (r112 == null) goto L60;
        String r113 = r112.c();
    L61:
        if (r18 == null) goto L65;
        com.larus.slides.impl.actionbar.model.a r114 = r18.a();
        if (r114 == null) goto L65;
        String r115 = r114.c();
    L66:
        if (r18 == null) goto L70;
        com.larus.slides.impl.actionbar.model.a r116 = r18.b();
        if (r116 == null) goto L70;
        String r117 = r116.c();
    L71:
        if (r18 == null) goto L75;
        com.larus.slides.impl.actionbar.model.a r118 = r18.b();
        if (r118 == null) goto L75;
        String r119 = r118.c();
    L77:
        if (r18 == null) goto L81;
        com.larus.slides.impl.actionbar.model.a r120 = r18.a();
        if (r120 == null) goto L81;
        Integer r121 = r120.d();
    L82:
        if (r18 == null) goto L86;
        com.larus.slides.impl.actionbar.model.a r20 = r18.a();
        if (r20 == null) goto L86;
        Integer r21 = r20.a();
    L87:
        r16.add(new GenerateImageViewHolder.b(false, r113, r115, r117, r119, null, null, r121, r21));
    L86:
        r21 = null;
    L81:
        r121 = null;
    L75:
        r119 = null;
    L70:
        r117 = null;
    L65:
        r115 = null;
    L60:
        r113 = null;
        goto L61
    L49:
        if (StringsKt.isBlank(r110) == true) goto L52;
        r111 = false;
    L46:
        r110 = null;
        goto L47
    L88:
        CollectionsKt.addAll(r10, r16);
    L145:
        if (r1 >= (this.maxPageNum - 1)) goto L150;
        int r22 = this.onePageImageNum;
        ArrayList r23 = new ArrayList(r22);
        int r24 = 0;
    L147:
        if (r24 >= r22) goto L149;
        r23.add(new GenerateImageViewHolder.b(false, null, null, null, null, null, Boxing.boxInt(0), null, null));
        r24 = r24 + 1;
        goto L147
    L149:
        CollectionsKt.addAll(r10, r23);
    L150:
        GenerateImageViewHolder.b r25 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(r10, this.curPosition);
        if (r25 == null) goto L153;
        r9 = r25.e;
    L153:
        refreshUIState(r10, o0.d(r9));
    L174:
        return Unit.INSTANCE;
    L89:
        CollectionsKt.addAll(r10, ((p) getUiState().getValue()).a);
        List r28 = r13;
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
        int r31 = 0;
    L91:
        if (r30.hasNext() == false) goto L145;
        Object r122 = r30.next();
        int r123 = r31 + 1;
        if (r31 >= 0) goto L95;
        CollectionsKt.throwIndexOverflow();
    L95:
        com.larus.slides.impl.select.model.d r124 = (com.larus.slides.impl.select.model.d) r122;
        if (((this.onePageImageNum * r1) + r31) >= r10.size()) goto L143;
        if (r124 == null) goto L101;
        com.larus.slides.impl.actionbar.model.a r125 = r124.a();
        if (r125 == null) goto L101;
        String r126 = r125.b();
    L102:
        if (r126 != null) goto L104;
    L107:
        boolean r127 = true;
    L108:
        if (r127 == false) goto L110;
        r14.element++;
    L110:
        int r128 = (this.onePageImageNum * r1) + r31;
        if (r124 == null) goto L115;
        com.larus.slides.impl.actionbar.model.a r129 = r124.b();
        if (r129 == null) goto L115;
        String r130 = r129.c();
    L116:
        if (r124 == null) goto L120;
        com.larus.slides.impl.actionbar.model.a r131 = r124.a();
        if (r131 == null) goto L120;
        String r132 = r131.c();
    L121:
        if (r124 == null) goto L125;
        com.larus.slides.impl.actionbar.model.a r133 = r124.b();
        if (r133 == null) goto L125;
        String r134 = r133.c();
    L126:
        if (r124 == null) goto L130;
        com.larus.slides.impl.actionbar.model.a r135 = r124.b();
        if (r135 == null) goto L130;
        String r136 = r135.c();
    L132:
        if (r124 == null) goto L136;
        com.larus.slides.impl.actionbar.model.a r137 = r124.a();
        if (r137 == null) goto L136;
        Integer r210 = r137.d();
    L137:
        if (r124 == null) goto L141;
        com.larus.slides.impl.actionbar.model.a r138 = r124.a();
        if (r138 == null) goto L141;
        Integer r211 = r138.a();
    L142:
        ListProtector.set(r10, r128, new GenerateImageViewHolder.b(false, r130, r132, r134, r136, null, null, r210, r211));
    L141:
        r211 = null;
    L136:
        r210 = null;
    L130:
        r136 = null;
    L125:
        r134 = null;
    L120:
        r132 = null;
    L115:
        r130 = null;
        goto L116
    L104:
        if (StringsKt.isBlank(r126) == true) goto L107;
        r127 = false;
    L101:
        r126 = null;
    L143:
        r29.add(Unit.INSTANCE);
        r31 = r123;
    L154:
        this.pageIndexToProgressMap.remove(Boxing.boxInt(r1));
        if ((r8 instanceof com.larus.network.http.f) == false) goto L161;
        int r32 = lm9.e.a;
        com.larus.network.http.f r33 = r8;
        String r34 = lm9.e.a(r33.d, "");
        if (o0.d(r34) == false) goto L161;
        sendUIEvent(new o.g(new TextRes.PlainText(r34)));
        BizResponse.Companion.getClass();
        if (ArraysKt.contains(BizResponse.access$getCODE_RISK_CONTROL$cp(), r33.d.getCode()) == false) goto L161;
        sendUIEvent(new o.a(BundleKt.bundleOf(new Pair[]{TuplesKt.to("clear_ref_img", Boxing.boxBoolean(true))})));
    L161:
        if (r1 != 0) goto L163;
        Boxing.boxBoolean(r10.add(new GenerateImageViewHolder.b(true, null, null, null, null, null, null, null, null)));
    L169:
        GenerateImageViewHolder.b r35 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(r10, this.curPosition);
        if (r35 == null) goto L172;
        r9 = r35.e;
    L172:
        refreshUIState(r10, o0.d(r9));
        goto L174
    L163:
        CollectionsKt.addAll(r10, ((p) getUiState().getValue()).a);
        int r36 = this.onePageImageNum;
    L164:
        if (r7 >= r36) goto L169;
        if (((this.onePageImageNum * r1) + r7) >= r10.size()) goto L168;
        ListProtector.set(r10, (this.onePageImageNum * r1) + r7, new GenerateImageViewHolder.b(true, null, null, null, null, null, null, null, null));
    L168:
        r7 = r7 + 1;
        goto L164
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        FLogger.a.d(TAG, "genBg pageIndex: " + r1);
        Job r37 = this.progressMockerJob;
        if (r37 == null) goto L17;
        Job.DefaultImpls.cancel$default(r37, null, 1, null);
    L17:
        b0 r38 = new b0();
        this.pageIndexToProgressMap.put(Boxing.boxInt(r26), r38);
        this.progressMockerJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass2(r38, null), 2, null);
        if (r1 != 0) goto L20;
        refreshUIState$default(this, CollectionsKt.listOf(new GenerateImageViewHolder.b(false, null, null, null, null, null, Boxing.boxInt(0), null, null)), false, 2, null);
    L24:
        refreshProgress(this.curPosition);
        Gson r39 = new Gson();
        String r40 = this.queryImageListString;
        if (r40 != null) goto L27;
        r40 = "";
    L27:
        List r41 = (List) GsonProtectorUtils.fromJson(r39, r40, new b().getType());
        FLogger.a.d(TAG, "genBg queryText=" + this.queryText + " queryImage=" + this.queryImageListString);
        SlidesAIPPTRepository r42 = SlidesAIPPTRepository.a;
        com.larus.slides.impl.select.model.a r139 = new com.larus.slides.impl.select.model.a(this.queryText, this.queryImageRatio, r41, 8);
        r3.I$0 = r1;
        r3.label = 1;
        r2 = r42.a(r139, r3);
        if (r2 != r5) goto L30;
        return r5;
    L20:
        List r43 = CollectionsKt.toMutableList(((p) getUiState().getValue()).a.subList(0, this.onePageImageNum * r1));
        List r140 = r43;
        int r141 = this.onePageImageNum;
        ArrayList r142 = new ArrayList(r141);
        int r143 = 0;
    L21:
        if (r143 >= r141) goto L23;
        r142.add(new GenerateImageViewHolder.b(false, null, null, null, null, null, Boxing.boxInt(0), null, null));
        r143 = r143 + 1;
        goto L21
    L23:
        CollectionsKt.addAll(r140, r142);
        refreshUIState$default(this, r43, false, 2, null);
    L7:
        r3 = new AnonymousClass1(this, r27);
        goto L8
    }

    private final void refreshUIState(List<GenerateImageViewHolder.b> r3, boolean r4) {
        z0<p> r0 = this._uiState;
        ((p) getUiState().getValue()).getClass();
        Intrinsics.checkNotNullParameter(r3, "viewPagerViewData");
        r0.setValue(new p(r3, r4));
    }

    public static final /* synthetic */ Object access$generateImage(GenerateImageViewModel r0, int r1, Continuation r2) {
        return r0.generateImage(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshUIState$default(GenerateImageViewModel r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = ((p) r0.getUiState().getValue()).a;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = ((p) r0.getUiState().getValue()).b;
    L8:
        r0.refreshUIState(r1, r2);
    }
}
