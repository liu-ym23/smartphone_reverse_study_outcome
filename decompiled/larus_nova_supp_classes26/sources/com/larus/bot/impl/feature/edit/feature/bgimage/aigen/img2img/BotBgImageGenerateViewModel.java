package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.ImageAndContent;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.StarlingContent;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference.PaintStyleViewHolder;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateViewModel;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.yalantis.ucrop.UCropFragment;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
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
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0002abB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020%H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020)0AH\u0002J\u0010\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020%H\u0002J\u0012\u0010F\u001a\u00020%2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010G\u001a\u00020%H\u0002J\u0018\u0010H\u001a\u0004\u0018\u00010!2\u0006\u0010I\u001a\u00020)H\u0082@¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020%H\u0002J\u001a\u0010L\u001a\u0004\u0018\u00010)2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020.H\u0002J\u000e\u0010O\u001a\u00020.H\u0082@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020)H\u0002J\u0016\u0010R\u001a\u00020%2\f\u0010S\u001a\b\u0018\u00010TR\u00020UH\u0002J\b\u0010V\u001a\u00020%H\u0002J\u0012\u0010W\u001a\u00020%2\b\u0010X\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020\u001cH\u0002J\"\u0010[\u001a\u00020%2\b\b\u0003\u0010\\\u001a\u00020\u001c2\u000e\b\u0002\u0010]\u001a\b\u0012\u0004\u0012\u00020^0AH\u0002J\u0010\u0010_\u001a\u00020%2\u0006\u0010`\u001a\u00020\u0016H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR-\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u000205X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u000209X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006c"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotBgImageGenerateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/IBotBgImageGenerateViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "uploadViewModel", "Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BgImageGenerateUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BgImageGenerateUIEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "curCroppedImageConsumer", "", "getCurCroppedImageConsumer$annotations", "()V", "onImageCropped", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "croppedUri", "", "bgImageEditInfo", "Lcom/larus/im/bean/bot/BgImageEditInfo;", "botName", "", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "hasUploadReferenceImage", "repo", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/AIGenBgImageRepository;", "promptGenerateViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/IBgPromptGenerateViewModel;", "getPromptGenerateViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/IBgPromptGenerateViewModel;", "botCreateTrace", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotCreateBgGenTrace;", "getBotCreateTrace", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotCreateBgGenTrace;", "dispatchUIAction", "uiAction", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BgImageGenerateUIAction;", "bindObservers", "getSelectedDrawStyles", "", "handleOnResult", "bundle", "Landroid/os/Bundle;", "onManualQuite", "initData", "onStateFlowBound", "getLocalUriFromUrl", ShareType.URL, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClickGenerate", "getSourceType", "ifHasRefImg", "ifHasBgPrompt", "interceptShowGenActionSheetForBotInfoReview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHitDescriptionStatus", "onCropFinish", "result", "Lcom/yalantis/ucrop/UCropFragment$UCropResult;", "Lcom/yalantis/ucrop/UCropFragment;", "onClickDelete", "onAlbumPicked", "uri", "onClickStyle", "index", "refreshUIState", "referenceImageUIState", "paintStylesViewData", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder$PaintStyleViewData;", "sendUIEvent", "event", "CroppedImageConsumer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotBgImageGenerateViewModel extends AndroidViewModel implements i {
    public static final a Companion = null;
    private static final String TAG = "BotBgImageGenerateViewModel";
    private final MutableSharedFlow<c> _uiEvent;
    private final z0<d> _uiState;
    private uc9.b bgImageEditInfo;
    private final h botCreateTrace;
    private String botDescription;
    private BotModel botInfo;
    private String botName;
    private int curCroppedImageConsumer;
    private boolean hasUploadReferenceImage;
    private boolean needUpdateBotInfo;
    private Function1<? super Uri, Unit> onImageCropped;
    private final com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.i promptGenerateViewModel;
    private final AIGenBgImageRepository repo;
    private final d1<c> uiEvent;
    private final i1<d> uiState;
    private final Lazy uploadViewModel$delegate;
    private String userBotGender;
    private String userBotType;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotBgImageGenerateViewModel$CroppedImageConsumer;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CroppedImageConsumer {
        public static final int BG_GENERATE = 1;
        public static final a Companion = null;
        public static final int PROMPT_GENERATE = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h {
        public final /* synthetic */ BotBgImageGenerateViewModel a;

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final String a() {
            return BotBgImageGenerateViewModel.access$getBotName$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final String c() {
            return BotBgImageGenerateViewModel.access$getUserBotType$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final uc9.b d() {
            return BotBgImageGenerateViewModel.access$getBgImageEditInfo$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final String e() {
            return BotBgImageGenerateViewModel.access$getUserBotGender$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final String f() {
            return BotBgImageGenerateViewModel.access$getBotDescription$p(this.a);
        }

        public b(BotBgImageGenerateViewModel r1) {
            this.a = r1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
        public final void b(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.g r3) {
            Intrinsics.checkNotNullParameter(r3, "doOnNext");
            if (((d) this.a.getUiState().getValue()).a != 2) goto L5;
            BotBgImageGenerateViewModel.access$sendUIEvent(this.a, c.a.a);
            BotBgImageGenerateViewModel.access$setOnImageCropped$p(this.a, r3);
            BotBgImageGenerateViewModel.access$setCurCroppedImageConsumer$p(this.a, 0);
            return;
        L5:
            r3.invoke(null);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$bindObservers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/network/http/Async;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$bindObservers$1", f = "Img2BgImageViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.network.http.a<? extends BizResponse<ImageUploadResult>>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BotBgImageGenerateViewModel this$0;

        public AnonymousClass1(BotBgImageGenerateViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L27:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            y r8 = (com.larus.network.http.a) this.L$0;
            if ((r8 instanceof com.larus.network.http.f) == false) goto L16;
            if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L13;
            BotBgImageGenerateViewModel.access$sendUIEvent(this.this$0, new c.h(new TextRes.StringResId(2131906741)));
            FLogger.a.w(BotBgImageGenerateViewModel.TAG, "upload failed, internet connect failed");
        L14:
            BotBgImageGenerateViewModel.refreshUIState$default(this.this$0, 0, null, 2, null);
            goto L27
        L13:
            BotBgImageGenerateViewModel.access$sendUIEvent(this.this$0, new c.h(new TextRes.StringResId(2131908918)));
            goto L14
        L16:
            if ((r8 instanceof y) == false) goto L27;
            BizResponse r9 = (BizResponse) ((com.larus.network.http.a) r8).b;
            if (r9 == null) goto L27;
            ImageUploadResult r10 = (ImageUploadResult) r9.getData();
            if (r10 == null) goto L27;
            String r11 = r10.getUploadUrl();
            if (r11 == null) goto L27;
            BotBgImageGenerateViewModel r2 = this.this$0;
            CoroutineDispatcher r4 = Dispatchers.getIO();
            BotBgImageGenerateViewModel$bindObservers$1$1$1 r5 = new BotBgImageGenerateViewModel$bindObservers$1$1$1(r2, r11, null);
            this.label = 1;
            if (BuildersKt.withContext(r4, r5, this) != r0) goto L27;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$getLocalUriFromUrl$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$getLocalUriFromUrl$2", f = "Img2BgImageViewModel.kt", i = {}, l = {285, 286}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
        final /* synthetic */ String $url;
        int label;

        public AnonymousClass2(String r1, Continuation<? super AnonymousClass2> r2) {
            this.$url = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$url, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L18:
            File r7 = (File) r6;
            if (r7 != null) goto L21;
            return null;
        L21:
            return Uri.fromFile(r7);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            Bitmap r8 = (Bitmap) r6;
            if (r8 == null) goto L22;
            this.label = 2;
            r6 = BitmapHelperKt.g(null, r8, "bg_reference_bitmap_cache_initial.jpg", this);
            if (r6 != r0) goto L18;
            return r0;
        L22:
            return null;
        L10:
            ResultKt.throwOnFailure(r6);
            String r9 = this.$url;
            this.label = 1;
            r6 = BitmapHelperKt.c(r9, this);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$interceptShowGenActionSheetForBotInfoReview$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel", f = "Img2BgImageViewModel.kt", i = {0}, l = {393}, m = "interceptShowGenActionSheetForBotInfoReview", n = {"delayShowLoadingJob"}, s = {"L$0"})
    public static final class C02021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotBgImageGenerateViewModel this$0;

        public C02021(BotBgImageGenerateViewModel r1, Continuation<? super C02021> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BotBgImageGenerateViewModel.access$interceptShowGenActionSheetForBotInfoReview(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$onClickGenerate$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$onClickGenerate$2", f = "Img2BgImageViewModel.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $descriptionStatus;
        final /* synthetic */ boolean $ifBaseImage;
        final /* synthetic */ List<String> $selectedDrawStyles;
        final /* synthetic */ String $visualStyleStatus;
        int label;
        final /* synthetic */ BotBgImageGenerateViewModel this$0;

        public C02032(BotBgImageGenerateViewModel r1, boolean r2, String r3, String r4, List<String> r5, Continuation<? super C02032> r6) {
            this.this$0 = r1;
            this.$ifBaseImage = r2;
            this.$visualStyleStatus = r3;
            this.$descriptionStatus = r4;
            this.$selectedDrawStyles = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C02032(this.this$0, this.$ifBaseImage, this.$visualStyleStatus, this.$descriptionStatus, this.$selectedDrawStyles, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r22);
            Object r3 = r22;
        L12:
            if (((Boolean) r3).booleanValue() == true) goto L18;
            if (((d) this.this$0.getUiState().getValue()).a != 2) goto L16;
            BotBgImageGenerateViewModel.access$sendUIEvent(this.this$0, c.a.a);
            final BotBgImageGenerateViewModel r4 = this.this$0;
            final boolean r6 = this.$ifBaseImage;
            final String r7 = this.$visualStyleStatus;
            final String r8 = this.$descriptionStatus;
            final List<String> r9 = this.$selectedDrawStyles;
            BotBgImageGenerateViewModel.access$setOnImageCropped$p(r4, new g(r4, r6, r7, r8, r9));
            BotBgImageGenerateViewModel.access$setCurCroppedImageConsumer$p(this.this$0, 0);
            goto L18
        L16:
            BotBgImageGenerateViewModel r5 = this.this$0;
            uc9.b r10 = BotBgImageGenerateViewModel.access$getBgImageEditInfo$p(r5);
            List<String> r11 = this.$selectedDrawStyles;
            r10.f = null;
            r10.g = null;
            r10.h = null;
            r10.i = null;
            r10.d = r11;
            r10.e = null;
            BotBgImageGenerateViewModel.access$sendUIEvent(r5, new c.C0059c(r10.a(), BotBgImageGenerateViewModel.access$getBotName$p(this.this$0), BotBgImageGenerateViewModel.access$getBotDescription$p(this.this$0), BotBgImageGenerateViewModel.access$getUserBotGender$p(this.this$0), BotBgImageGenerateViewModel.access$getUserBotType$p(this.this$0), Boxing.boxBoolean(BotBgImageGenerateViewModel.access$getNeedUpdateBotInfo$p(this.this$0)), BotBgImageGenerateViewModel.access$getBotInfo$p(this.this$0), this.this$0.getBotCreateTrace().c(), this.this$0.getBotCreateTrace().b(), Boxing.boxBoolean(this.$ifBaseImage), this.$visualStyleStatus, this.$descriptionStatus, this.this$0.getBotCreateTrace().a(), this.this$0.getBotCreateTrace().a.getBoolean("has_origin_avatar", false)));
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            BotBgImageGenerateViewModel r12 = this.this$0;
            this.label = 1;
            r3 = BotBgImageGenerateViewModel.access$interceptShowGenActionSheetForBotInfoReview(r12, this);
            if (r3 != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$sendUIEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$sendUIEvent$1", f = "Img2BgImageViewModel.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c $event;
        int label;
        final /* synthetic */ BotBgImageGenerateViewModel this$0;

        public C02041(BotBgImageGenerateViewModel r1, c r2, Continuation<? super C02041> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02041(this.this$0, this.$event, r4);
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
            MutableSharedFlow r5 = BotBgImageGenerateViewModel.access$get_uiEvent$p(this.this$0);
            c r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    @CroppedImageConsumer
    private static /* synthetic */ void getCurCroppedImageConsumer$annotations() {
    }

    private final String getSourceType(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return "3";
    L5:
        if (r1 == false) goto L7;
        return "1";
    L7:
        if (r2 == false) goto L9;
        return "2";
    L9:
        return null;
    }

    public static /* synthetic */ BotImageUploadViewModel yo(Application r0) {
        return uploadViewModel_delegate$lambda$0(r0);
    }

    private final String getHitDescriptionStatus() {
        String r0 = this.bgImageEditInfo.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return "no_description";
    L11:
        com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.i r3 = getPromptGenerateViewModel();
        if ((r3 instanceof BgPromptGenerateViewModel) == false) goto L14;
        BgPromptGenerateViewModel r4 = (BgPromptGenerateViewModel) r3;
    L15:
        if (r4 != null) goto L17;
    L19:
        if (r1 == false) goto L21;
        return "auto_fill";
    L21:
        return "original";
    L17:
        if (true != r4.o) goto L19;
        r1 = true;
        goto L19
    L14:
        r4 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final BotImageUploadViewModel getUploadViewModel() {
        return (BotImageUploadViewModel) this.uploadViewModel$delegate.getValue();
    }

    private final void onClickDelete() {
        uc9.b r0 = this.bgImageEditInfo;
        r0.f = null;
        r0.g = null;
        r0.h = null;
        r0.i = null;
        sendUIEvent(new c.e(null));
        refreshUIState$default(this, 0, null, 2, null);
    }

    private final void onClickGenerate() {
        boolean r2 = false;
        if (((d) getUiState().getValue()).a != 2) goto L5;
        boolean r4 = true;
    L6:
        List<String> r6 = getSelectedDrawStyles();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        String r1 = "";
        String r5 = null;
        if (r6.isEmpty() == true) goto L19;
        Iterator<T> r0 = r6.iterator();
        String r7 = "";
    L11:
        if (r0.hasNext() == false) goto L14;
        r7 = (r7 + ((String) r0.next())) + ',';
        goto L11
    L14:
        if (r7.length() <= 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        r5 = r7.substring(0, r7.length() - 1);
        goto L19
    L16:
        r3 = false;
    L19:
        String r8 = getHitDescriptionStatus();
        if (getBotCreateTrace().c() == null) goto L56;
        String r9 = getBotCreateTrace().c();
        String r10 = getBotCreateTrace().b();
        Boolean r11 = Boolean.valueOf(r4);
        String r12 = getBotCreateTrace().a();
        JSONObject r13 = new JSONObject();
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r9 != null) goto L58;
    L26:
        if (r10 == null) goto L28;
        r13.put("create_way", r10);     // Catch: JSONException -> L24
    L28:
        if (r11 != null) goto L30;
    L34:
        if (r5 == null) goto L36;
        r13.put("visual_style_status", r5);     // Catch: JSONException -> L24
    L36:
        if (r8 == null) goto L38;
        r13.put("description_status", r8);     // Catch: JSONException -> L24
    L38:
        if (r12 == null) goto L42;
        r13.put("enter_method", r12);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_creation_complete " + e.getLocalizedMessage());
    L42:
        TrackParams r14 = new TrackParams().merge(r13);
        by7.a r15 = new by7.a("bot_image_ai_creation_complete");
        r15.a.merge(r14);
        r15.b();
        if (r5 != null) goto L45;
        String r16 = "";
    L46:
        qu8.b.b("gen_bg_by_prompt_with_img", "draw_styles", r16);
        String r17 = this.bgImageEditInfo.a;
        if (r17 != null) goto L49;
    L50:
        r2 = true;
    L51:
        String r18 = getSourceType(r4, !r2);
        if (r18 == null) goto L55;
        r1 = r18;
    L55:
        qu8.b.b("gen_bg_by_prompt_with_img", "source_type", r1);
        goto L56
    L49:
        if (StringsKt.isBlank(r17) == false) goto L51;
    L45:
        r16 = r5;
        goto L46
    L30:
        if (r11.booleanValue() == false) goto L32;
        String r19 = "1";
    L33:
        r13.put("if_base_image", r19);     // Catch: JSONException -> L24
        goto L34
    L32:
        r19 = TriggerSendLoading.NO_LOADING;
        goto L33
    L58:
        r13.put("creation_id", r9);     // Catch: JSONException -> L24
    L56:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02032(this, r4, r5, r8, r6, null), 3, null);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private final void onManualQuite() {
        if (this.hasUploadReferenceImage == false) goto L5;
    L8:
        sendUIEvent(c.f.a);
        return;
    L5:
        if (o0.d(this.bgImageEditInfo.a) == true) goto L8;
        sendUIEvent(new c.b(BundleKt.bundleOf(new Pair[]{TuplesKt.to("quit_ai_gen_process", Boolean.TRUE)})));
    }

    private final void onStateFlowBound() {
        String r0 = this.bgImageEditInfo.a;
        if (r0 == null) goto L11;
        com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.i r1 = getPromptGenerateViewModel();
        if ((r1 instanceof BgPromptGenerateViewModel) == false) goto L7;
        BgPromptGenerateViewModel r2 = (BgPromptGenerateViewModel) r1;
    L8:
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r0, "prompt");
        r2.i(new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.a(r0));
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    private final void bindObservers() {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(FlowLiveDataConversions.asFlow(getUploadViewModel().getUpload().c), new AnonymousClass1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final List<String> getSelectedDrawStyles() {
        List<PaintStyleViewHolder.a> r0 = ((d) getUiState().getValue()).b;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((PaintStyleViewHolder.a) r3).d == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        String r6 = ((PaintStyleViewHolder.a) r5.next()).b;
        if (r6 == null) goto L10;
        r4.add(r6);
        goto L10
    L14:
        return r4;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.i
    public h getBotCreateTrace() {
        return this.botCreateTrace;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.i
    public com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.i getPromptGenerateViewModel() {
        return this.promptGenerateViewModel;
    }

    @Override // uu8.b
    public d1<c> getUiEvent() {
        return this.uiEvent;
    }

    @Override // uu8.b
    public i1<d> getUiState() {
        return this.uiState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public BotBgImageGenerateViewModel(final Application r9) {
        Intrinsics.checkNotNullParameter(r9, "application");
        super(r9);
        this.uploadViewModel$delegate = LazyKt.lazy(new f(r9));
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 == null) goto L28;
        BgImageConfig r1 = r0.h();
        if (r1 == null) goto L28;
        List r2 = r1.b();
        if (r2 == null) goto L28;
        List r3 = r2;
        List r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L29;
        ImageAndContent r6 = (ImageAndContent) r5.next();
        if (r6 == null) goto L16;
        String r7 = r6.a();
        if (r7 == null) goto L16;
        Uri r8 = UriProtector.parse(r7);
    L17:
        if (r6 == null) goto L21;
        StarlingContent r10 = r6.b();
        if (r10 == null) goto L21;
        String r11 = r10.a();
    L22:
        if (r6 == null) goto L26;
        StarlingContent r12 = r6.b();
        if (r12 == null) goto L26;
        String r13 = r12.b();
    L27:
        r4.add(new PaintStyleViewHolder.a(r8, r11, r13, false));
    L26:
        r13 = null;
    L21:
        r11 = null;
    L16:
        r8 = null;
    L29:
        if (r4 != 0) goto L31;
        r4 = CollectionsKt.emptyList();
    L31:
        StateFlowImpl r14 = j1.a(new d(0, r4));
        this._uiState = r14;
        this.uiState = kotlinx.coroutines.flow.e.b(r14);
        MutableSharedFlow<c> r15 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._uiEvent = r15;
        this.uiEvent = kotlinx.coroutines.flow.e.a(r15);
        this.curCroppedImageConsumer = 1;
        this.bgImageEditInfo = new uc9.b();
        AIGenBgImageRepository r16 = new AIGenBgImageRepository();
        this.repo = r16;
        this.promptGenerateViewModel = new BgPromptGenerateViewModel(r9, ViewModelKt.getViewModelScope(this), r16, new b(this));
        this.botCreateTrace = new h();
        bindObservers();
        return;
    L28:
        r4 = 0;
        goto L29
    }

    public static final /* synthetic */ uc9.b access$getBgImageEditInfo$p(BotBgImageGenerateViewModel r0) {
        return r0.bgImageEditInfo;
    }

    public static final /* synthetic */ String access$getBotDescription$p(BotBgImageGenerateViewModel r0) {
        return r0.botDescription;
    }

    public static final /* synthetic */ BotModel access$getBotInfo$p(BotBgImageGenerateViewModel r0) {
        return r0.botInfo;
    }

    public static final /* synthetic */ String access$getBotName$p(BotBgImageGenerateViewModel r0) {
        return r0.botName;
    }

    public static final /* synthetic */ boolean access$getNeedUpdateBotInfo$p(BotBgImageGenerateViewModel r0) {
        return r0.needUpdateBotInfo;
    }

    public static final /* synthetic */ BotImageUploadViewModel access$getUploadViewModel(BotBgImageGenerateViewModel r0) {
        return r0.getUploadViewModel();
    }

    public static final /* synthetic */ String access$getUserBotGender$p(BotBgImageGenerateViewModel r0) {
        return r0.userBotGender;
    }

    public static final /* synthetic */ String access$getUserBotType$p(BotBgImageGenerateViewModel r0) {
        return r0.userBotType;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_uiEvent$p(BotBgImageGenerateViewModel r0) {
        return r0._uiEvent;
    }

    private final void handleOnResult(Bundle r3) {
        if (r3.getBoolean("clear_ref_img") == false) goto L6;
        onClickDelete();
        FLogger.a.i(TAG, "reference image cleared");
        return;
    }

    private final void initData(Bundle r11) {
        if (r11 == null) goto L5;
        getBotCreateTrace().a.putAll(r11);
    L5:
        if (r11 == null) goto L7;
        Serializable r1 = r11.getSerializable("bg_image_info");
    L9:
        if ((r1 instanceof BgImageInfo) == false) goto L11;
        BgImageInfo r2 = (BgImageInfo) r1;
    L12:
        if (r2 == null) goto L15;
        uc9.b r3 = r2.toBgImageEditInfo();
        if (r3 == null) goto L15;
    L16:
        this.bgImageEditInfo = r3;
        if (r11 == null) goto L19;
        Serializable r4 = r11.getSerializable("avatar_info");
    L21:
        if ((r4 instanceof BotAvatarIconData) == false) goto L23;
        BotAvatarIconData r5 = (BotAvatarIconData) r4;
    L24:
        if (r11 == null) goto L27;
        String r6 = r11.getString("bot_name");
        if (r6 == null) goto L27;
    L28:
        this.botName = r6;
        if (r11 == null) goto L32;
        String r7 = r11.getString("bot_description");
        if (r7 == null) goto L32;
    L33:
        this.botDescription = r7;
        if (r11 == null) goto L37;
        String r8 = r11.getString("user_bot_gender");
        if (r8 == null) goto L37;
    L38:
        this.userBotGender = r8;
        if (r11 == null) goto L42;
        String r9 = r11.getString("user_bot_type");
        if (r9 == null) goto L42;
    L43:
        this.userBotType = r9;
        boolean r10 = false;
        if (r11 == null) goto L46;
        boolean r12 = r11.getBoolean("need_update_bot_info");
    L47:
        this.needUpdateBotInfo = r12;
        if (r11 == null) goto L50;
        Serializable r13 = r11.getSerializable("bot_update_bot_argument");
    L52:
        if ((r13 instanceof BotModel) == false) goto L54;
        BotModel r14 = (BotModel) r13;
    L55:
        this.botInfo = r14;
        if (r5 == null) goto L58;
        String r15 = r5.getIconUri();
    L60:
        if (r15 != null) goto L62;
    L65:
        boolean r16 = true;
    L66:
        if (r16 == false) goto L81;
        if (r5 == null) goto L73;
        String r17 = r5.getIconUrl();
        if (r17 == null) goto L73;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Uri r18 = UriProtector.parse(r17);
        Intrinsics.checkNotNullParameter(r18, "<this>");
        if (true != Intrinsics.areEqual(r18.getScheme(), ShareType.FILE)) goto L73;
        boolean r19 = true;
    L74:
        if (r19 == false) goto L81;
        if (r5.getIconUrl() != null) goto L78;
        return;
    L78:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L80;
        sendUIEvent(new c.h(new TextRes.StringResId(2131906741)));
        FLogger.a.w(TAG, "internet connect failed");
        return;
    L80:
        refreshUIState$default(this, 1, null, 2, null);
        BotImageUploadViewModel.upload$default(getUploadViewModel(), UriProtector.parse(r5.getIconUrl()), 5, false, 4, null);
        return;
    L73:
        r19 = false;
    L81:
        String r110 = this.bgImageEditInfo.f;
        if (r110 != null) goto L84;
    L87:
        boolean r111 = true;
    L88:
        if (r111 == true) goto L116;
        String r112 = this.bgImageEditInfo.g;
        if (r112 != null) goto L92;
    L95:
        boolean r113 = true;
    L96:
        if (r113 == true) goto L116;
        String r114 = this.bgImageEditInfo.g;
        if (r114 == null) goto L100;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BotBgImageGenerateViewModel$initData$3$1(this, r114, null), 3, null);
    L100:
        List r115 = CollectionsKt.toMutableList(((d) getUiState().getValue()).b);
        List r20 = this.bgImageEditInfo.d;
        if (r20 == null) goto L115;
        Iterator r21 = r20.iterator();
    L104:
        if (r21.hasNext() == false) goto L115;
        String r22 = (String) r21.next();
        Iterator r23 = r115.iterator();
        int r24 = 0;
    L107:
        if (r23.hasNext() == false) goto L112;
        if (Intrinsics.areEqual(((PaintStyleViewHolder.a) r23.next()).b, r22) == true) goto L113;
        r24 = r24 + 1;
    L113:
        if ((-1) == r24) goto L104;
        ListProtector.set(r115, r24, PaintStyleViewHolder.a.a((PaintStyleViewHolder.a) ListProtector.get(r115, r24), true));
        goto L104
    L112:
        r24 = -1;
    L115:
        refreshUIState$default(this, 0, r115, 1, null);
        return;
    L92:
        if (StringsKt.isBlank(r112) == true) goto L95;
        r113 = false;
    L116:
        if (r5 == null) goto L118;
        String r116 = r5.getIconUrl();
    L119:
        if (r116 != null) goto L121;
    L124:
        boolean r117 = true;
    L125:
        if (r117 == true) goto L150;
        if (r5 == null) goto L128;
        String r118 = r5.getIconUri();
    L129:
        if (r118 != null) goto L131;
    L132:
        r10 = true;
    L133:
        if (r10 == true) goto L151;
        if (r5 == null) goto L152;
        String r119 = r5.getIconUrl();
        if (r119 == null) goto L153;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BotBgImageGenerateViewModel$initData$5$1(this, r119, null), 3, null);
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    L131:
        if (StringsKt.isBlank(r118) == false) goto L133;
    L128:
        r118 = null;
        goto L129
    L150:
        return;
    L121:
        if (StringsKt.isBlank(r116) == true) goto L124;
        r117 = false;
        goto L125
    L118:
        r116 = null;
        goto L119
    L84:
        if (StringsKt.isBlank(r110) == true) goto L87;
        r111 = false;
        goto L88
    L62:
        if (StringsKt.isBlank(r15) == true) goto L65;
        r16 = false;
        goto L66
    L58:
        r15 = null;
        goto L60
    L54:
        r14 = null;
        goto L55
    L50:
        r13 = null;
        goto L52
    L46:
        r12 = false;
    L42:
        r9 = this.userBotType;
    L37:
        r8 = this.userBotGender;
    L32:
        r7 = this.botDescription;
    L27:
        r6 = this.botName;
        goto L28
    L23:
        r5 = null;
        goto L24
    L19:
        r4 = null;
    L15:
        r3 = this.bgImageEditInfo;
        goto L16
    L11:
        r2 = null;
        goto L12
    L7:
        r1 = null;
        goto L9
    }

    private final Object interceptShowGenActionSheetForBotInfoReview(Continuation<? super Boolean> r21) {
        if ((r21 instanceof C02021) == false) goto L7;
        C02021 r2 = (C02021) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        C02021 r7 = r2;
        Object r1 = r7.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        boolean r9 = true;
        boolean r13 = false;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Job r6 = (Job) r7.L$0;
        ResultKt.throwOnFailure(r1);
    L20:
        com.larus.network.http.f r8 = (com.larus.network.http.a) r1;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        sendUIEvent(new c.d(false));
        if ((r8 instanceof com.larus.network.http.f) == false) goto L31;
        FLogger.a.e(TAG, "interceptShowGenActionSheetToBotInfoReview");
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L25;
        qu8.b.d("review_bot", 20016);
        qu8.b.d("gen_bg_by_prompt_with_img", 20016);
        sendUIEvent(new c.g(new TextRes.StringResId(2131908080)));
    L33:
        return Boxing.boxBoolean(r9);
    L25:
        com.larus.network.http.f r10 = r8;
        qu8.b.d("review_bot", r10.d.getCode());
        qu8.b.d("gen_bg_by_prompt_with_img", r10.d.getCode());
        int r11 = lm9.e.a;
        String r12 = lm9.e.a(r10.d, "");
        if (r12.length() != 0) goto L28;
        r13 = true;
    L28:
        if (r13 == false) goto L30;
        sendUIEvent(new c.g(new TextRes.StringResId(2131901611)));
        goto L33
    L30:
        sendUIEvent(new c.g(new TextRes.PlainText(r12)));
        goto L33
    L31:
        qu8.b.d("review_bot", 0);
        r9 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (o0.d(this.bgImageEditInfo.a) == false) goto L35;
        Job r14 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BotBgImageGenerateViewModel$interceptShowGenActionSheetForBotInfoReview$delayShowLoadingJob$1(this, null), 3, null);
        qu8.b.e("review_bot", "gen_bg_by_prompt_with_img", false);
        AIGenBgImageRepository r15 = this.repo;
        String r16 = this.bgImageEditInfo.a;
        r7.L$0 = r14;
        r7.label = 1;
        Object r17 = AIGenBgImageRepository.d(r15, null, null, r16, r7, 3);
        if (r17 != r4) goto L19;
        return r4;
    L19:
        r6 = r14;
        r1 = r17;
        goto L20
    L35:
        return Boxing.boxBoolean(false);
    L7:
        r2 = new C02021(this, r21);
        goto L8
    }

    private final void onAlbumPicked(Uri r10) {
        if (r10 == null) goto L5;
        this.hasUploadReferenceImage = true;
        refreshUIState$default(this, 1, null, 2, null);
        if (BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BotBgImageGenerateViewModel$onAlbumPicked$1$1(r10, this, null), 3, null) == null) goto L5;
        return;
    L5:
        FLogger.a.e(TAG, "pickLauncher return null");
        Unit r11 = Unit.INSTANCE;
    }

    private final void onClickStyle(int r5) {
        List r0 = CollectionsKt.toMutableList(((d) getUiState().getValue()).b);
        PaintStyleViewHolder.a r1 = (PaintStyleViewHolder.a) CollectionsKt.getOrNull(r0, r5);
        if (r1 == null) goto L5;
        PaintStyleViewHolder.a r6 = (PaintStyleViewHolder.a) ListProtector.set(r0, r5, PaintStyleViewHolder.a.a(r1, !r1.d));
    L5:
        refreshUIState$default(this, 0, r0, 1, null);
    }

    private final void onCropFinish(UCropFragment.c r3) {
        if (r3 == null) goto L12;
        Intent r4 = r3.a;
        if (r4 != null) goto L6;
        r4 = new Intent();
    L6:
        Uri r5 = (Uri) r4.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        if (r5 == null) goto L12;
        Function1<? super Uri, Unit> r0 = this.onImageCropped;
        if (r0 == null) goto L16;
        r0.invoke(r5);
        return;
    L16:
        return;
    L12:
        FLogger.a.e(TAG, "onCropFinish but return null uri, curCroppedImageConsumer: " + this.curCroppedImageConsumer);
        Function1<? super Uri, Unit> r6 = this.onImageCropped;
        if (r6 == null) goto L17;
        r6.invoke(null);
        return;
    }

    private final void sendUIEvent(c r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02041(this, r7, null), 3, null);
    }

    private static final BotImageUploadViewModel uploadViewModel_delegate$lambda$0(Application r1) {
        return new BotImageUploadViewModel(r1);
    }

    /* JADX INFO: renamed from: dispatchUIAction, reason: avoid collision after fix types in other method */
    public void dispatchUIAction2(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b r2) {
        Intrinsics.checkNotNullParameter(r2, "uiAction");
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.d) == false) goto L6;
        onClickStyle(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.d) r2).a);
        return;
    L6:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.a) == false) goto L9;
        onAlbumPicked(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.a) r2).a);
        return;
    L9:
        if (Intrinsics.areEqual(r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.C0058b.a) == false) goto L12;
        onClickDelete();
        return;
    L12:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.f) == false) goto L15;
        onCropFinish(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.f) r2).a);
        return;
    L15:
        if (Intrinsics.areEqual(r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.c.a) == false) goto L18;
        onClickGenerate();
        return;
    L18:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.e) == false) goto L21;
        initData(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.e) r2).a);
        return;
    L21:
        if (Intrinsics.areEqual(r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.i.a) == false) goto L24;
        onStateFlowBound();
        return;
    L24:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.h) == false) goto L27;
        handleOnResult(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.h) r2).a);
        return;
    L27:
        if (Intrinsics.areEqual(r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b.g.a) == false) goto L31;
        onManualQuite();
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    }

    @Override // uu8.b
    public /* bridge */ /* synthetic */ void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.b r1) {
        dispatchUIAction2(r1);
    }

    public static final /* synthetic */ Object access$interceptShowGenActionSheetForBotInfoReview(BotBgImageGenerateViewModel r0, Continuation r1) {
        return r0.interceptShowGenActionSheetForBotInfoReview(r1);
    }

    public static final /* synthetic */ void access$sendUIEvent(BotBgImageGenerateViewModel r0, c r1) {
        r0.sendUIEvent(r1);
    }

    public static final /* synthetic */ void access$setCurCroppedImageConsumer$p(BotBgImageGenerateViewModel r0, int r1) {
        r0.curCroppedImageConsumer = r1;
    }

    public static final /* synthetic */ void access$setOnImageCropped$p(BotBgImageGenerateViewModel r0, Function1 r1) {
        r0.onImageCropped = r1;
    }

    private final Object getLocalUriFromUrl(String r4, Continuation<? super Uri> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, null), r5);
    }

    private final void refreshUIState(@ReferenceImageContainer.ReferenceImageUIState int r3, List<PaintStyleViewHolder.a> r4) {
        z0<d> r0 = this._uiState;
        ((d) getUiState().getValue()).getClass();
        Intrinsics.checkNotNullParameter(r4, "paintStylesViewData");
        r0.setValue(new d(r3, r4));
    }

    public static final /* synthetic */ Object access$getLocalUriFromUrl(BotBgImageGenerateViewModel r0, String r1, Continuation r2) {
        return r0.getLocalUriFromUrl(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshUIState$default(BotBgImageGenerateViewModel r0, int r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = ((d) r0.getUiState().getValue()).a;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = ((d) r0.getUiState().getValue()).b;
    L8:
        r0.refreshUIState(r1, r2);
    }
}
