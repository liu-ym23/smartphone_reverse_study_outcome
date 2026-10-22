package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.common.mockloading.ILoadingProgressMocker;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020CH\u0002J\u0012\u0010J\u001a\u00020C2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020\u001eH\u0002J\b\u0010M\u001a\u00020CH\u0002J\u0016\u0010N\u001a\u00020C2\u0006\u0010O\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020C2\u0006\u0010L\u001a\u00020\u001eH\u0002J\u0010\u0010R\u001a\u00020C2\u0006\u0010L\u001a\u00020\u001eH\u0002J\u0010\u0010S\u001a\u00020C2\u0006\u0010L\u001a\u00020\u001eH\u0002J\"\u0010T\u001a\u00020C2\u000e\b\u0002\u0010U\u001a\b\u0012\u0004\u0012\u00020W0V2\b\b\u0002\u0010X\u001a\u000209H\u0002J\u0010\u0010Y\u001a\u00020C2\u0006\u0010Z\u001a\u00020\u0018H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001e0AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IBgSelectViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "progressMockerJob", "Lkotlinx/coroutines/Job;", "repo", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/AIGenBgImageRepository;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "botCreateTrace", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BotCreateBgSelectTrace;", "getBotCreateTrace", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BotCreateBgSelectTrace;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "curPosition", "", "uploadViewModel", "Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "bgImageConfig", "Lcom/larus/bmhome/auth/BgImageConfig;", "getBgImageConfig", "()Lcom/larus/bmhome/auth/BgImageConfig;", "bgImageConfig$delegate", "onePageImageNum", "showBgImageMaxCnt", "maxPageNum", "pageIndexToProgressMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/ProgressMocker;", "curProgressRefreshJob", "bgImageEditInfo", "Lcom/larus/im/bean/bot/BgImageEditInfo;", "botName", "", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "observeFinishPreAiGenBgProcessFlowJob", "uploadStartTimeMs", "", "uploadDurationMs", "shownPageIndexSet", "", "dispatchUIAction", "", "uiAction", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIAction;", "handleOnResult", "bundle", "Landroid/os/Bundle;", "onConfirm", "onCreate", "onPageSelected", "position", "bindObservers", "genBg", "pageIndex", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onItemClick", "onItemLongClick", "refreshProgress", "refreshUIState", "viewPagerViewData", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder$BgSelectItemData;", "canConfirm", "sendUIEvent", "event", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgSelectViewModel extends AndroidViewModel implements q {
    public static final String AVATAR_BITMAP_CACHE_FILE_NAME = "bg_select_cropped_avatar.jpg";
    public static final a Companion = null;
    private static final String TAG = "BgSelectViewModel";
    private final MutableSharedFlow<k> _uiEvent;
    private final z0<l> _uiState;
    private final Lazy bgImageConfig$delegate;
    private uc9.b bgImageEditInfo;
    private final p botCreateTrace;
    private String botDescription;
    private BotModel botInfo;
    private String botName;
    private int curPosition;
    private Job curProgressRefreshJob;
    private int maxPageNum;
    private boolean needUpdateBotInfo;
    private Job observeFinishPreAiGenBgProcessFlowJob;
    private final int onePageImageNum;
    private final ConcurrentHashMap<Integer, y> pageIndexToProgressMap;
    private Job progressMockerJob;
    private final AIGenBgImageRepository repo;
    private final int showBgImageMaxCnt;
    private final Set<Integer> shownPageIndexSet;
    private final d1<k> uiEvent;
    private final i1<l> uiState;
    private long uploadDurationMs;
    private long uploadStartTimeMs;
    private final Lazy uploadViewModel$delegate;
    private String userBotGender;
    private String userBotType;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$bindObservers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/network/http/Async;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$bindObservers$1", f = "BgSelectViewModel.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.network.http.a<? extends BizResponse<ImageUploadResult>>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BgSelectViewModel this$0;

        public AnonymousClass1(BgSelectViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.larus.network.http.a<BizResponse<ImageUploadResult>> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.network.http.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r18);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            com.larus.network.http.f r3 = (com.larus.network.http.a) this.L$0;
            if ((r3 instanceof com.larus.network.http.f) == false) goto L16;
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("upload reference image fail, msg: ");
            com.larus.network.http.f r6 = r3;
            BizResponse r7 = (BizResponse) ((com.larus.network.http.a) r6).b;
            if (r7 == null) goto L13;
            String r8 = r7.getMsg();
        L14:
            r5.append(r8);
            r4.e(BgSelectViewModel.TAG, r5.toString());
            qu8.b.d("upload_file", r6.d.getCode());
            qu8.b.d("gen_bg_by_prompt_with_img", r6.d.getCode());
            BgSelectViewModel.refreshUIState$default(this.this$0, CollectionsKt.listOf(new BgSelectViewHolder.a(true, null, null, null, null, null, Boxing.boxInt(0))), false, 2, null);
            goto L26
        L13:
            r8 = null;
            goto L14
        L16:
            if ((r3 instanceof com.larus.network.http.y) == false) goto L26;
            BizResponse r9 = (BizResponse) ((com.larus.network.http.a) ((com.larus.network.http.y) r3)).b;
            if (r9 == null) goto L24;
            ImageUploadResult r10 = (ImageUploadResult) r9.getData();
            if (r10 == null) goto L24;
            BgSelectViewModel r11 = this.this$0;
            BgSelectViewModel.access$setUploadDurationMs$p(r11, System.currentTimeMillis() - BgSelectViewModel.access$getUploadStartTimeMs$p(r11));
            BgSelectViewModel.access$getBgImageEditInfo$p(r11).f = r10.getUploadUri();
            BgSelectViewModel.access$getBgImageEditInfo$p(r11).g = r10.getUploadUrl();
            BgSelectViewModel.access$getBgImageEditInfo$p(r11).h = r10.getReferenceBgImgStyle();
            BgSelectViewModel.access$getBgImageEditInfo$p(r11).i = r10.getReferenceBgImgPrompt();
            qu8.b.d("upload_file", 0);
            this.label = 1;
            if (BgSelectViewModel.access$genBg(r11, 0, this) != r1) goto L26;
            return r1;
        L24:
            BgSelectViewModel.refreshUIState$default(this.this$0, CollectionsKt.listOf(new BgSelectViewHolder.a(true, null, null, null, null, null, Boxing.boxInt(0))), false, 2, null);
            qu8.b.d("upload_file", -2);
            goto L26
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$genBg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel", f = "BgSelectViewModel.kt", i = {0, 0, 1, 1, 1, 1}, l = {332, 374}, m = "genBg", n = {"pageIndex", "genBgStartTimeMS", "resp", "newViewPagerData", "images", "pageIndex"}, s = {"I$0", "J$0", "L$0", "L$1", "L$2", "I$0"})
    public static final class C02051 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BgSelectViewModel this$0;

        public C02051(BgSelectViewModel r1, Continuation<? super C02051> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BgSelectViewModel.access$genBg(this.this$0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$genBg$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$genBg$2", f = "BgSelectViewModel.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ y $progressMocker;
        int label;

        public AnonymousClass2(y r1, Continuation<? super AnonymousClass2> r2) {
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
            y r5 = this.$progressMocker;
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

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onConfirm$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onConfirm$1", f = "BgSelectViewModel.kt", i = {0, 0, 0}, l = {158}, m = "invokeSuspend", n = {"bgUrl", "avatarInfo", "bgImage"}, s = {"L$0", "L$1", "L$2"})
    public static final class C02061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ BgSelectViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onConfirm$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onConfirm$1$1", f = "BgSelectViewModel.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BgSelectViewModel this$0;

            /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onConfirm$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ BgSelectViewModel a;

                public a(BgSelectViewModel r1) {
                    this.a = r1;
                }

                public final Object emit(Object r5, Continuation r6) {
                    Unit r7 = (Unit) r5;
                    Object r8 = BgSelectViewModel.access$get_uiEvent$p(this.a).emit(new k.b(com.larus.utils.f.c(new Pair[]{TuplesKt.to("quit_ai_gen_process", Boxing.boxBoolean(true))})), r6);
                    if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r8;
                L6:
                    return Unit.INSTANCE;
                }
            }

            public C00611(BgSelectViewModel r1, Continuation<? super C00611> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00611(this.this$0, r3);
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
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MutableSharedFlow<Unit> r6 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
                MutableSharedFlow<Unit> r7 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.c;
                a r2 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public C02061(BgSelectViewModel r1, Continuation<? super C02061> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02061(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            BgImage r3 = (BgImage) this.L$2;
            BotAvatarIconData r4 = (BotAvatarIconData) this.L$1;
            String r5 = (String) this.L$0;
            ResultKt.throwOnFailure(r30);
            BgImage r18 = r3;
            BotAvatarIconData r17 = r4;
            String r28 = r5;
        L22:
            BgSelectViewModel r6 = this.this$0;
            BgSelectViewModel.access$sendUIEvent(r6, new k.d(r17, r18, BgSelectViewModel.access$getBotName$p(r6), BgSelectViewModel.access$getBotDescription$p(this.this$0), BgSelectViewModel.access$getUserBotGender$p(this.this$0), BgSelectViewModel.access$getUserBotType$p(this.this$0), Boxing.boxBoolean(BgSelectViewModel.access$getNeedUpdateBotInfo$p(this.this$0)), BgSelectViewModel.access$getBotInfo$p(this.this$0), this.this$0.getBotCreateTrace().c(), this.this$0.getBotCreateTrace().b(), r28, r28));
            Job r7 = BgSelectViewModel.access$getObserveFinishPreAiGenBgProcessFlowJob$p(this.this$0);
            if (r7 == null) goto L25;
            Job.DefaultImpls.cancel$default(r7, null, 1, null);
        L25:
            BgSelectViewModel r8 = this.this$0;
            BgSelectViewModel.access$setObserveFinishPreAiGenBgProcessFlowJob$p(r8, BuildersKt.launch$default(ViewModelKt.getViewModelScope(r8), null, null, new C00611(this.this$0, null), 3, null));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r30);
            BgSelectViewHolder.a r9 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) this.this$0.getUiState().getValue()).a, BgSelectViewModel.access$getCurPosition$p(this.this$0));
            if (r9 == null) goto L11;
            String r10 = r9.e;
        L12:
            if (r9 == null) goto L14;
            String r14 = r9.d;
        L15:
            if (r9 == null) goto L17;
            String r11 = r9.f;
        L18:
            BgSelectViewModel.access$sendUIEvent(this.this$0, new k.f());
            BotAvatarIconData r15 = new BotAvatarIconData(r10, r14, null, null, null, 28, null);
            uc9.b r12 = BgSelectViewModel.access$getBgImageEditInfo$p(this.this$0);
            r12.c = Boxing.boxBoolean(true);
            r12.k = r11;
            Unit r13 = Unit.INSTANCE;
            BgImage r16 = new BgImage(r10, r14, null, r12.a());
            MutableSharedFlow<Unit> r19 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
            Unit r20 = Unit.INSTANCE;
            this.L$0 = r14;
            this.L$1 = r15;
            this.L$2 = r16;
            this.label = 1;
            if (r19.emit(r20, this) != r1) goto L21;
            return r1;
        L21:
            r18 = r16;
            r28 = r14;
            r17 = r15;
            goto L22
        L17:
            r11 = null;
            goto L18
        L14:
            r14 = null;
            goto L15
        L11:
            r10 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onPageSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onPageSelected$1", f = "BgSelectViewModel.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BgSelectViewModel this$0;

        public C02071(BgSelectViewModel r1, Continuation<? super C02071> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02071(this.this$0, r3);
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
            BgSelectViewModel r6 = this.this$0;
            int r2 = BgSelectViewModel.access$getCurPosition$p(r6) / BgSelectViewModel.access$getOnePageImageNum$p(this.this$0);
            this.label = 1;
            if (BgSelectViewModel.access$genBg(r6, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$refreshProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$refreshProgress$1", f = "BgSelectViewModel.kt", i = {}, l = {540}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ BgSelectViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$refreshProgress$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ BgSelectViewModel a;
            public final /* synthetic */ int b;

            public a(BgSelectViewModel r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r12, Continuation r13) {
                int r14 = ((Number) r12).intValue();
                BgSelectViewModel r15 = this.a;
                List r0 = CollectionsKt.toMutableList(((l) r15.getUiState().getValue()).a);
                int r1 = this.b;
                if (r1 >= r0.size()) goto L5;
                BgSelectViewHolder.a r2 = (BgSelectViewHolder.a) ListProtector.get(r0, r1);
                Integer r10 = Boxing.boxInt(r14);
                ListProtector.set(r0, r1, new BgSelectViewHolder.a(r2.a, r2.b, r2.c, r2.d, r2.e, r2.f, r10));
            L5:
                BgSelectViewModel.refreshUIState$default(r15, r0, false, 2, null);
                return Unit.INSTANCE;
            }
        }

        public C02081(BgSelectViewModel r1, int r2, Continuation<? super C02081> r3) {
            this.this$0 = r1;
            this.$position = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02081(this.this$0, this.$position, r4);
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
            y r7 = (y) BgSelectViewModel.access$getPageIndexToProgressMap$p(this.this$0).get(Boxing.boxInt(this.$position / BgSelectViewModel.access$getOnePageImageNum$p(this.this$0)));
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

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$sendUIEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$sendUIEvent$1", f = "BgSelectViewModel.kt", i = {}, l = {568}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ k $event;
        int label;
        final /* synthetic */ BgSelectViewModel this$0;

        public C02091(BgSelectViewModel r1, k r2, Continuation<? super C02091> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02091(this.this$0, this.$event, r4);
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
            MutableSharedFlow r5 = BgSelectViewModel.access$get_uiEvent$p(this.this$0);
            k r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ BgImageConfig Mo() {
        return bgImageConfig_delegate$lambda$1();
    }

    private final void handleOnResult(Bundle r1) {
    }

    public static /* synthetic */ BotImageUploadViewModel yo(Application r0) {
        return uploadViewModel_delegate$lambda$0(r0);
    }

    private static final BgImageConfig bgImageConfig_delegate$lambda$1() {
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    private final BgImageConfig getBgImageConfig() {
        return (BgImageConfig) this.bgImageConfig$delegate.getValue();
    }

    private final BotImageUploadViewModel getUploadViewModel() {
        return (BotImageUploadViewModel) this.uploadViewModel$delegate.getValue();
    }

    private final void bindObservers() {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(FlowLiveDataConversions.asFlow(getUploadViewModel().getUpload().c), new AnonymousClass1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void onConfirm() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02061(this, null), 3, null);
        if (getBotCreateTrace().c() == null) goto L38;
        String r0 = getBotCreateTrace().c();
        String r1 = getBotCreateTrace().b();
        Boolean r2 = this.bgImageEditInfo.e;
        Integer r3 = Integer.valueOf(this.shownPageIndexSet.size());
        Boolean r4 = Boolean.valueOf(getBotCreateTrace().a.getBoolean("if_base_image"));
        String r6 = getBotCreateTrace().e();
        String r7 = getBotCreateTrace().d();
        String r8 = getBotCreateTrace().a();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r0 != null) goto L36;
    L9:
        if (r1 == null) goto L11;
        r9.put("create_way", r1);     // Catch: JSONException -> L7
    L11:
        String r5 = "1";
        if (r4 != null) goto L14;
    L18:
        if (r6 == null) goto L20;
        r9.put("visual_style_status", r6);     // Catch: JSONException -> L7
    L20:
        if (r7 == null) goto L22;
        r9.put("description_status", r7);     // Catch: JSONException -> L7
    L22:
        if (r3 == null) goto L24;
        r9.put("cnt", r3.intValue());     // Catch: JSONException -> L7
    L24:
        if (r2 != null) goto L26;
    L30:
        if (r8 == null) goto L34;
        r9.put("enter_method", r8);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_confirm " + e.getLocalizedMessage());
    L34:
        TrackParams r10 = new TrackParams().merge(r9);
        by7.a r11 = new by7.a("bot_image_ai_choose_page_confirm");
        r11.a.merge(r10);
        r11.b();
        return;
    L26:
        if (r2.booleanValue() == true) goto L29;
        r5 = TriggerSendLoading.NO_LOADING;
    L29:
        r9.put("background_status", r5);     // Catch: JSONException -> L7
        goto L30
    L14:
        if (r4.booleanValue() == false) goto L16;
        Object r12 = "1";
    L17:
        r9.put("if_base_image", r12);     // Catch: JSONException -> L7
        goto L18
    L16:
        r12 = TriggerSendLoading.NO_LOADING;
        goto L17
    L36:
        r9.put("creation_id", r0);     // Catch: JSONException -> L7
        goto L9
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.q
    public p getBotCreateTrace() {
        return this.botCreateTrace;
    }

    @Override // uu8.b
    public d1<k> getUiEvent() {
        return this.uiEvent;
    }

    @Override // uu8.b
    public i1<l> getUiState() {
        return this.uiState;
    }

    public BgSelectViewModel(final Application r12) {
        Intrinsics.checkNotNullParameter(r12, "application");
        super(r12);
        this.repo = new AIGenBgImageRepository();
        StateFlowImpl r0 = j1.a(new l(CollectionsKt.listOf(new BgSelectViewHolder.a(false, null, null, null, null, null, 0)), false));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
        this.botCreateTrace = new p();
        MutableSharedFlow<k> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._uiEvent = r1;
        this.uiEvent = kotlinx.coroutines.flow.e.a(r1);
        this.uploadViewModel$delegate = LazyKt.lazy(new n(r12));
        this.bgImageConfig$delegate = LazyKt.lazy(new o());
        BgImageConfig r13 = getBgImageConfig();
        if (r13 == null) goto L7;
        Integer r14 = r13.c();
        if (r14 == null) goto L7;
        int r15 = r14.intValue();
    L8:
        int r16 = RangesKt.coerceAtLeast(1, r15);
        this.onePageImageNum = r16;
        BgImageConfig r2 = getBgImageConfig();
        if (r2 == null) goto L13;
        Integer r3 = r2.d();
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
    L14:
        int r5 = RangesKt.coerceAtLeast(3, r4);
        this.showBgImageMaxCnt = r5;
        this.maxPageNum = r5 / r16;
        this.pageIndexToProgressMap = new ConcurrentHashMap();
        this.bgImageEditInfo = new uc9.b();
        this.shownPageIndexSet = new LinkedHashSet();
        bindObservers();
        return;
    L13:
        r4 = 18;
    L7:
        r15 = 6;
        goto L8
    }

    public static final /* synthetic */ uc9.b access$getBgImageEditInfo$p(BgSelectViewModel r0) {
        return r0.bgImageEditInfo;
    }

    public static final /* synthetic */ String access$getBotDescription$p(BgSelectViewModel r0) {
        return r0.botDescription;
    }

    public static final /* synthetic */ BotModel access$getBotInfo$p(BgSelectViewModel r0) {
        return r0.botInfo;
    }

    public static final /* synthetic */ String access$getBotName$p(BgSelectViewModel r0) {
        return r0.botName;
    }

    public static final /* synthetic */ int access$getCurPosition$p(BgSelectViewModel r0) {
        return r0.curPosition;
    }

    public static final /* synthetic */ boolean access$getNeedUpdateBotInfo$p(BgSelectViewModel r0) {
        return r0.needUpdateBotInfo;
    }

    public static final /* synthetic */ Job access$getObserveFinishPreAiGenBgProcessFlowJob$p(BgSelectViewModel r0) {
        return r0.observeFinishPreAiGenBgProcessFlowJob;
    }

    public static final /* synthetic */ int access$getOnePageImageNum$p(BgSelectViewModel r0) {
        return r0.onePageImageNum;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPageIndexToProgressMap$p(BgSelectViewModel r0) {
        return r0.pageIndexToProgressMap;
    }

    public static final /* synthetic */ long access$getUploadStartTimeMs$p(BgSelectViewModel r2) {
        return r2.uploadStartTimeMs;
    }

    public static final /* synthetic */ BotImageUploadViewModel access$getUploadViewModel(BgSelectViewModel r0) {
        return r0.getUploadViewModel();
    }

    public static final /* synthetic */ String access$getUserBotGender$p(BgSelectViewModel r0) {
        return r0.userBotGender;
    }

    public static final /* synthetic */ String access$getUserBotType$p(BgSelectViewModel r0) {
        return r0.userBotType;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_uiEvent$p(BgSelectViewModel r0) {
        return r0._uiEvent;
    }

    private final void onCreate(Bundle r18) {
        if (r18 == null) goto L6;
        getBotCreateTrace().a.putAll(r18);
    L6:
        if (r18 == null) goto L8;
        Serializable r3 = r18.getSerializable("bg_image_info");
    L10:
        if ((r3 instanceof BgImageInfo) == false) goto L12;
        BgImageInfo r4 = (BgImageInfo) r3;
    L13:
        if (r4 == null) goto L16;
        uc9.b r5 = r4.toBgImageEditInfo();
        if (r5 == null) goto L16;
    L17:
        this.bgImageEditInfo = r5;
        if (r18 == null) goto L21;
        String r6 = r18.getString("bot_name");
        if (r6 == null) goto L21;
    L22:
        this.botName = r6;
        if (r18 == null) goto L26;
        String r7 = r18.getString("bot_description");
        if (r7 == null) goto L26;
    L27:
        this.botDescription = r7;
        if (r18 == null) goto L31;
        String r8 = r18.getString("user_bot_gender");
        if (r8 == null) goto L31;
    L32:
        this.userBotGender = r8;
        if (r18 == null) goto L36;
        String r9 = r18.getString("user_bot_type");
        if (r9 == null) goto L36;
    L37:
        this.userBotType = r9;
        if (r18 == null) goto L40;
        boolean r10 = r18.getBoolean("need_update_bot_info");
    L41:
        this.needUpdateBotInfo = r10;
        if (r18 == null) goto L44;
        Serializable r1 = r18.getSerializable("bot_update_bot_argument");
    L46:
        if ((r1 instanceof BotModel) == false) goto L48;
        BotModel r2 = (BotModel) r1;
    L49:
        this.botInfo = r2;
        String r11 = this.bgImageEditInfo.g;
        if (r11 != null) goto L52;
    L64:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain().getImmediate(), null, new BgSelectViewModel$onCreate$5$1(this, null), 2, null);
        return;
    L52:
        if ((!StringsKt.isBlank(r11)) == true) goto L55;
        r11 = null;
    L55:
        if (r11 == null) goto L64;
        Uri r12 = UriProtector.parse(r11);
        if (r12 == null) goto L64;
        if (Intrinsics.areEqual(r12.getScheme(), ShareType.FILE) == false) goto L61;
        Uri r13 = r12;
    L62:
        if (r13 == null) goto L64;
        this.uploadStartTimeMs = System.currentTimeMillis();
        qu8.b.e("upload_file", "gen_bg_by_prompt_with_img", false);
        BotImageUploadViewModel.upload$default(getUploadViewModel(), r13, 6, false, 4, null);
        return;
    L61:
        r13 = null;
        goto L62
    L48:
        r2 = null;
        goto L49
    L44:
        r1 = null;
        goto L46
    L40:
        r10 = false;
    L36:
        r9 = this.userBotType;
    L31:
        r8 = this.userBotGender;
    L26:
        r7 = this.botDescription;
    L21:
        r6 = this.botName;
    L16:
        r5 = this.bgImageEditInfo;
        goto L17
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    private final void onItemClick(int r9) {
        BgSelectViewHolder.a r0 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, r9);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == false) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new BgSelectViewModel$onItemClick$1$1(r9, this, null), 2, null);
        return;
    L8:
        if (o0.d(r0.d) == true) goto L10;
    L12:
        FLogger.a.i(TAG, "");
        return;
    L10:
        if (o0.d(r0.e) == false) goto L12;
        FLogger.a.i(TAG, "open save picture action page");
    }

    private final void onItemLongClick(int r4) {
        BgSelectViewHolder.a r5 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, r4);
        if (r5 != null) goto L5;
        return;
    L5:
        if (o0.d(r5.d) == true) goto L7;
        return;
    L7:
        if (o0.d(r5.e) == false) goto L12;
        FLogger.a.i(TAG, "open save picture action page");
        sendUIEvent(new k.e(r5, getBotCreateTrace().c(), getBotCreateTrace().b()));
        return;
    }

    private final void onPageSelected(int r11) {
        this.curPosition = r11;
        if (r11 > 0) goto L5;
    L13:
        refreshProgress(r11);
    L14:
        BgSelectViewHolder.a r2 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, this.curPosition);
        if (r2 == null) goto L17;
        String r3 = r2.e;
    L18:
        refreshUIState$default(this, null, o0.d(r3), 1, null);
        if (((l) getUiState().getValue()).b == false) goto L22;
        this.shownPageIndexSet.add(Integer.valueOf(r11));
        return;
    L22:
        return;
    L17:
        r3 = null;
        goto L18
    L5:
        if (this.pageIndexToProgressMap.containsKey(Integer.valueOf(r11 / this.onePageImageNum)) == true) goto L13;
        BgSelectViewHolder.a r4 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, this.curPosition);
        boolean r5 = false;
        if (r4 != null) goto L9;
    L11:
        if (r5 == true) goto L13;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02071(this, null), 2, null);
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
        BgSelectViewHolder.a r2 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, r10);
        if (r2 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L21;
        BgSelectViewHolder.a r3 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(((l) getUiState().getValue()).a, r10);
        if (r3 == null) goto L15;
        String r4 = r3.e;
    L16:
        if (r4 == null) goto L18;
        return;
    L18:
        if (this.pageIndexToProgressMap.containsKey(Integer.valueOf(r10 / this.onePageImageNum)) == false) goto L23;
        this.curProgressRefreshJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02081(this, r10, null), 2, null);
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

    private final void sendUIEvent(k r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02091(this, r7, null), 3, null);
    }

    private static final BotImageUploadViewModel uploadViewModel_delegate$lambda$0(Application r1) {
        return new BotImageUploadViewModel(r1);
    }

    /* JADX INFO: renamed from: dispatchUIAction, reason: avoid collision after fix types in other method */
    public void dispatchUIAction2(j r2) {
        Intrinsics.checkNotNullParameter(r2, "uiAction");
        if ((r2 instanceof j.b) == false) goto L6;
        onCreate(((j.b) r2).a);
        return;
    L6:
        if ((r2 instanceof j.e) == false) goto L9;
        onPageSelected(((j.e) r2).a);
        return;
    L9:
        if ((r2 instanceof j.c) == false) goto L12;
        onItemClick(((j.c) r2).a);
        return;
    L12:
        if ((r2 instanceof j.d) == false) goto L15;
        ((j.d) r2).getClass();
        onItemLongClick(0);
        return;
    L15:
        if (Intrinsics.areEqual(r2, j.a.a) == false) goto L18;
        onConfirm();
        return;
    L18:
        if ((r2 instanceof j.f) == false) goto L22;
        handleOnResult(((j.f) r2).a);
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // uu8.b
    public /* bridge */ /* synthetic */ void dispatchUIAction(j r1) {
        dispatchUIAction2(r1);
    }

    public static final /* synthetic */ void access$sendUIEvent(BgSelectViewModel r0, k r1) {
        r0.sendUIEvent(r1);
    }

    public static final /* synthetic */ void access$setObserveFinishPreAiGenBgProcessFlowJob$p(BgSelectViewModel r0, Job r1) {
        r0.observeFinishPreAiGenBgProcessFlowJob = r1;
    }

    public static final /* synthetic */ void access$setUploadDurationMs$p(BgSelectViewModel r0, long r1) {
        r0.uploadDurationMs = r1;
    }

    private final Object genBg(int r39, Continuation<? super Unit> r40) {
        if ((r40 instanceof C02051) == false) goto L7;
        C02051 r3 = (C02051) r40;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r0 = r3.I$0;
        List r6 = (List) r3.L$2;
        List<BgSelectViewHolder.a> r7 = (List) r3.L$1;
        com.larus.network.http.a r8 = (com.larus.network.http.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r9 = "gen_icon_by_prompt";
    L98:
        if (r0 != 0) goto L148;
        BgSelectViewModel r10 = this;
        uc9.b r12 = r10.bgImageEditInfo;
        BotGenBgImageResponse r13 = (BotGenBgImageResponse) r8.b;
        if (r13 == null) goto L102;
        Boolean r14 = r13.getBgImgOpen();
    L103:
        r12.e = r14;
        uc9.b r15 = r10.bgImageEditInfo;
        BotGenBgImageResponse r16 = (BotGenBgImageResponse) r8.b;
        if (r16 == null) goto L106;
        Integer r17 = r16.getBgCategoryType();
    L107:
        r15.j = r17;
        uc9.b r18 = r10.bgImageEditInfo;
        BotGenBgImageResponse r19 = (BotGenBgImageResponse) r8.b;
        if (r19 == null) goto L110;
        String r20 = r19.getBgImgPrompt();
    L111:
        r18.a = r20;
        uc9.b r21 = r10.bgImageEditInfo;
        BotGenBgImageResponse r22 = (BotGenBgImageResponse) r8.b;
        if (r22 == null) goto L114;
        String r23 = r22.getBgImgPromptEn();
    L115:
        r21.b = r23;
        List<BgSelectViewHolder.a> r24 = r7;
        List r25 = r6;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator r1 = r25.iterator();
        int r27 = 0;
    L117:
        if (r1.hasNext() == false) goto L147;
        BotAvatarIconData r28 = (BotAvatarIconData) r1.next();
        if (r28 == null) goto L121;
        String r29 = r28.getIconUri();
    L122:
        if (r29 != null) goto L124;
    L127:
        boolean r30 = true;
    L128:
        if (r30 == false) goto L131;
        r27 = r27 + 1;
    L131:
        if (r28 == null) goto L133;
        String r110 = r28.getPreviewUrl();
    L134:
        if (r28 == null) goto L136;
        String r111 = r28.getDownloadUrl();
    L137:
        if (r28 == null) goto L139;
        String r112 = r28.getIconUrl();
    L140:
        if (r28 == null) goto L142;
        String r113 = r28.getIconUri();
    L143:
        if (r28 == null) goto L145;
        String r114 = r28.getPrompt();
    L146:
        r26.add(new BgSelectViewHolder.a(false, r110, r111, r112, r113, r114, null));
        r1 = r1;
        goto L117
    L145:
        r114 = null;
        goto L146
    L142:
        r113 = null;
        goto L143
    L139:
        r112 = null;
        goto L140
    L136:
        r111 = null;
        goto L137
    L133:
        r110 = null;
        goto L134
    L124:
        if (StringsKt.isBlank(r29) == true) goto L127;
        r30 = false;
        goto L128
    L121:
        r29 = null;
        goto L122
    L147:
        CollectionsKt.addAll(r24, r26);
        Unit r31 = Unit.INSTANCE;
    L186:
        if (r0 >= (r10.maxPageNum - 1)) goto L191;
        List<BgSelectViewHolder.a> r32 = r7;
        int r33 = r10.onePageImageNum;
        ArrayList r34 = new ArrayList(r33);
        int r35 = 0;
    L188:
        if (r35 >= r33) goto L190;
        r34.add(new BgSelectViewHolder.a(false, null, null, null, null, null, Boxing.boxInt(0)));
        r35 = r35 + 1;
        goto L188
    L190:
        CollectionsKt.addAll(r32, r34);
    L191:
        String r36 = r9;
        qu8.b.b(r36, "empty_uri_count", String.valueOf(r27));
        qu8.b.d(r36, 0);
        BgSelectViewHolder.a r37 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(r7, r10.curPosition);
        if (r37 == null) goto L194;
        String r115 = r37.e;
    L195:
        r10.refreshUIState(r7, o0.d(r115));
    L226:
        return Unit.INSTANCE;
    L194:
        r115 = null;
        goto L195
    L114:
        r23 = null;
        goto L115
    L110:
        r20 = null;
        goto L111
    L106:
        r17 = null;
        goto L107
    L102:
        r14 = null;
        goto L103
    L148:
        r10 = this;
        CollectionsKt.addAll(r7, ((l) getUiState().getValue()).a);
        List r38 = r6;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator r42 = r38.iterator();
        r27 = 0;
        int r43 = 0;
    L150:
        if (r42.hasNext() == false) goto L186;
        Object r44 = r42.next();
        int r45 = r43 + 1;
        if (r43 >= 0) goto L154;
        CollectionsKt.throwIndexOverflow();
    L154:
        BotAvatarIconData r46 = (BotAvatarIconData) r44;
        if (((r10.onePageImageNum * r0) + r43) >= r7.size()) goto L184;
        if (r46 == null) goto L158;
        String r47 = r46.getIconUri();
    L159:
        if (r47 != null) goto L161;
    L164:
        boolean r48 = true;
    L165:
        if (r48 == false) goto L167;
        r27 = r27 + 1;
    L167:
        int r49 = (r10.onePageImageNum * r0) + r43;
        if (r46 == null) goto L170;
        String r116 = r46.getPreviewUrl();
    L171:
        if (r46 == null) goto L173;
        String r117 = r46.getDownloadUrl();
    L174:
        if (r46 == null) goto L176;
        String r118 = r46.getIconUrl();
    L177:
        if (r46 == null) goto L179;
        String r119 = r46.getIconUri();
    L180:
        if (r46 == null) goto L182;
        String r120 = r46.getPrompt();
    L183:
        ListProtector.set(r7, r49, new BgSelectViewHolder.a(false, r116, r117, r118, r119, r120, null));
        goto L184
    L182:
        r120 = null;
        goto L183
    L179:
        r119 = null;
        goto L180
    L176:
        r118 = null;
        goto L177
    L173:
        r117 = null;
        goto L174
    L170:
        r116 = null;
        goto L171
    L161:
        if (StringsKt.isBlank(r47) == true) goto L164;
        r48 = false;
        goto L165
    L158:
        r47 = null;
    L184:
        r41.add(Unit.INSTANCE);
        r43 = r45;
        goto L150
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r50 = r3.J$0;
        int r51 = r3.I$0;
        ResultKt.throwOnFailure(r2);
        String r121 = "gen_bg_by_prompt_with_img";
        String r122 = "";
        int r52 = r51;
        Object r53 = r2;
        r9 = "gen_icon_by_prompt";
        Object r54 = r11;
        long r123 = r50;
    L33:
        com.larus.network.http.a r55 = (com.larus.network.http.a) r53;
        long r56 = System.currentTimeMillis() - r123;
        ArrayList r57 = new ArrayList();
        BotGenBgImageResponse r58 = (BotGenBgImageResponse) r55.b;
        if (r58 == null) goto L196;
        List<BotAvatarIconData> r59 = r58.getBgImgList();
        if (r59 == null) goto L196;
        List r124 = CollectionsKt.take(r59, this.onePageImageNum);
        if (r124 == null) goto L196;
        if (getBotCreateTrace().c() == null) goto L89;
        if (r52 != 0) goto L43;
        Long r60 = Boxing.boxLong(this.uploadDurationMs + r56);
    L45:
        if (r60.longValue() <= 40000) goto L47;
        r60 = null;
    L47:
        String r61 = getBotCreateTrace().c();
        String r62 = getBotCreateTrace().b();
        if (r60 == null) goto L50;
        String r63 = r60.toString();
    L51:
        BotGenBgImageResponse r125 = (BotGenBgImageResponse) r55.b;
        if (r125 == null) goto L54;
        Boolean r126 = r125.getBgImgOpen();
    L55:
        Integer r127 = Boxing.boxInt(r52);
        Boolean r128 = Boxing.boxBoolean(getBotCreateTrace().a.getBoolean("if_base_image"));
        String r129 = getBotCreateTrace().e();
        String r64 = getBotCreateTrace().d();
        String r65 = getBotCreateTrace().a();
        JSONObject r66 = new JSONObject();
        Intrinsics.checkNotNullParameter(r66, "params");
        if (r61 != null) goto L227;
    L60:
        if (r62 == null) goto L62;
        r66.put("create_way", r62);     // Catch: JSONException -> L58
    L62:
        String r67 = "1";
        if (r128 != null) goto L65;
    L69:
        if (r129 == null) goto L71;
        r66.put("visual_style_status", r129);     // Catch: JSONException -> L58
    L71:
        if (r64 == null) goto L73;
        r66.put("description_status", r64);     // Catch: JSONException -> L58
    L73:
        if (r63 == null) goto L75;
        r66.put("duration", r63);     // Catch: JSONException -> L58
    L75:
        if (r126 != null) goto L77;
    L81:
        if (r127 == null) goto L83;
        r66.put("index", r127.intValue());     // Catch: JSONException -> L58
    L83:
        if (r65 == null) goto L87;
        r66.put("enter_method", r65);     // Catch: JSONException -> L58
    L58:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_load_success " + e.getLocalizedMessage());
    L87:
        TrackParams r68 = new TrackParams().merge(r66);
        by7.a r69 = new by7.a("bot_image_ai_choose_page_load_success");
        r69.a.merge(r68);
        r69.b();
        Unit r70 = Unit.INSTANCE;
        goto L89
    L77:
        if (r126.booleanValue() == true) goto L80;
        r67 = TriggerSendLoading.NO_LOADING;
    L80:
        r66.put("background_status", r67);     // Catch: JSONException -> L58
        goto L81
    L65:
        if (r128.booleanValue() == false) goto L67;
        Object r71 = "1";
    L68:
        r66.put("if_base_image", r71);     // Catch: JSONException -> L58
        goto L69
    L67:
        r71 = TriggerSendLoading.NO_LOADING;
        goto L68
    L227:
        r66.put("creation_id", r61);     // Catch: JSONException -> L58
        goto L60
    L54:
        r126 = null;
        goto L55
    L50:
        r63 = null;
        goto L51
    L43:
        r60 = Boxing.boxLong(r56);
    L89:
        BotAvatarIconData r72 = (BotAvatarIconData) CollectionsKt.firstOrNull(r124);
        if (r72 == null) goto L92;
        String r73 = r72.getIconUrl();
    L93:
        r3.L$0 = r55;
        r3.L$1 = r57;
        r3.L$2 = r124;
        int r74 = r52;
        r3.I$0 = r74;
        r3.label = 2;
        Object r75 = r54;
        if (BitmapHelperKt.e(r73, r3) != r75) goto L96;
        return r75;
    L96:
        r0 = r74;
        r8 = r55;
        r7 = r57;
        r6 = r124;
        goto L98
    L92:
        r73 = null;
    L196:
        String r76 = r9;
        int r77 = r52;
        this.pageIndexToProgressMap.remove(Boxing.boxInt(r77));
        if ((r55 instanceof com.larus.network.http.f) == false) goto L210;
        int r78 = lm9.e.a;
        com.larus.network.http.f r79 = (com.larus.network.http.f) r55;
        String r80 = lm9.e.a(r79.d, r122);
        if (r80.length() != 0) goto L201;
        boolean r81 = true;
    L202:
        if (r81 == false) goto L204;
        sendUIEvent(new k.g(new TextRes.StringResId(2131901083)));
    L208:
        qu8.b.d(r76, r79.d.getCode());
        qu8.b.d(r121, r79.d.getCode());
        goto L210
    L204:
        sendUIEvent(new k.g(new TextRes.PlainText(r80)));
        BizResponse.Companion.getClass();
        if (ArraysKt.contains(BizResponse.access$getCODE_RISK_CONTROL$cp(), r79.d.getCode()) == false) goto L208;
        sendUIEvent(new k.a(BundleKt.bundleOf(new Pair[]{TuplesKt.to("clear_ref_img", Boxing.boxBoolean(true))})));
        goto L208
    L201:
        r81 = false;
    L210:
        qu8.b.d(r76, -2);
        qu8.b.d(r121, -2);
        if (r77 != 0) goto L213;
        Boxing.boxBoolean(r57.add(new BgSelectViewHolder.a(true, null, null, null, null, null, null)));
    L220:
        BgSelectViewHolder.a r82 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(r57, this.curPosition);
        if (r82 == null) goto L223;
        String r130 = r82.e;
    L224:
        refreshUIState(r57, o0.d(r130));
        goto L226
    L223:
        r130 = null;
        goto L224
    L213:
        CollectionsKt.addAll(r57, ((l) getUiState().getValue()).a);
        int r83 = this.onePageImageNum;
        int r131 = 0;
    L214:
        if (r131 >= r83) goto L219;
        if (((this.onePageImageNum * r77) + r131) >= r57.size()) goto L218;
        ListProtector.set(r57, (this.onePageImageNum * r77) + r131, new BgSelectViewHolder.a(true, null, null, null, null, null, null));
    L218:
        r131 = r131 + 1;
        goto L214
    L219:
        Unit r84 = Unit.INSTANCE;
        goto L220
    L16:
        ResultKt.throwOnFailure(r2);
        FLogger.a.d(TAG, "genBg pageIndex: " + r39);
        long r85 = System.currentTimeMillis();
        Job r86 = this.progressMockerJob;
        if (r86 == null) goto L19;
        Job.DefaultImpls.cancel$default(r86, null, 1, null);
        Unit r87 = Unit.INSTANCE;
    L19:
        y r88 = new y();
        this.pageIndexToProgressMap.put(Boxing.boxInt(r39), r88);
        this.progressMockerJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass2(r88, null), 2, null);
        if (r39 != 0) goto L22;
        refreshUIState$default(this, CollectionsKt.listOf(new BgSelectViewHolder.a(false, null, null, null, null, null, Boxing.boxInt(0))), false, 2, null);
    L26:
        refreshProgress(this.curPosition);
        qu8.b.e("gen_icon_by_prompt", "gen_bg_by_prompt_with_img", false);
        qu8.b.b("gen_icon_by_prompt", "page_index", String.valueOf(r39));
        qu8.b.b("gen_icon_by_prompt", "batch_request_img_num", String.valueOf(this.onePageImageNum));
        AIGenBgImageRepository r89 = this.repo;
        uc9.b r90 = this.bgImageEditInfo;
        String r91 = r90.a;
        if (r91 != null) goto L29;
        r91 = "";
    L29:
        int r132 = this.onePageImageNum;
        GenBotImageRequest r133 = new GenBotImageRequest(this.botName, this.botDescription, r90.b, r90.f, r90.h, r90.i, r90.d, this.userBotGender, this.userBotType, null, 512, null);
        String r92 = getBotCreateTrace().c();
        r3.I$0 = r39;
        r3.J$0 = r85;
        r3.label = 1;
        r123 = r85;
        r9 = "gen_icon_by_prompt";
        r121 = "gen_bg_by_prompt_with_img";
        r122 = "";
        Object r93 = r89.b(r91, r132, r133, "image_to_image", r92, r3);
        r54 = r11;
        if (r93 != r54) goto L32;
        return r54;
    L32:
        r52 = r39;
        r53 = r93;
        goto L33
    L22:
        List r94 = CollectionsKt.toMutableList(((l) getUiState().getValue()).a.subList(0, this.onePageImageNum * r39));
        List r95 = r94;
        int r96 = this.onePageImageNum;
        ArrayList r134 = new ArrayList(r96);
        int r135 = 0;
    L23:
        if (r135 >= r96) goto L25;
        r134.add(new BgSelectViewHolder.a(false, null, null, null, null, null, Boxing.boxInt(0)));
        r135 = r135 + 1;
        goto L23
    L25:
        CollectionsKt.addAll(r95, r134);
        refreshUIState$default(this, r94, false, 2, null);
    L7:
        r3 = new C02051(this, r40);
        goto L8
    }

    private final void refreshUIState(List<BgSelectViewHolder.a> r3, boolean r4) {
        z0<l> r0 = this._uiState;
        ((l) getUiState().getValue()).getClass();
        Intrinsics.checkNotNullParameter(r3, "viewPagerViewData");
        r0.setValue(new l(r3, r4));
    }

    public static final /* synthetic */ Object access$genBg(BgSelectViewModel r0, int r1, Continuation r2) {
        return r0.genBg(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshUIState$default(BgSelectViewModel r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = ((l) r0.getUiState().getValue()).a;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = ((l) r0.getUiState().getValue()).b;
    L8:
        r0.refreshUIState(r1, r2);
    }
}
