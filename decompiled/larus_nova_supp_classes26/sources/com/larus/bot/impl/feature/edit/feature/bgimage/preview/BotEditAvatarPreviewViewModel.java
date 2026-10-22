package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.network.http.AsyncThrowable;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u000209H\u0002J\u000e\u0010=\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u0011*\u0004\u0018\u00010@H\u0002J\b\u0010A\u001a\u000209H\u0002J,\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010G\u001a\u0002092\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0002J,\u0010H\u001a\u0002092\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010I\u001a\u0002092\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0002J\b\u0010M\u001a\u00020NH\u0002J(\u0010O\u001a\u0002092\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010PJ*\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010PJ \u0010S\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010T\u001a\u00020\nH\u0002J$\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010@2\b\u0010X\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\u0011H\u0002J\u0012\u0010\\\u001a\u0002092\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u000e\u0010_\u001a\u000209H\u0082@¢\u0006\u0002\u0010>J\u0010\u0010`\u001a\u0002092\u0006\u0010a\u001a\u00020\u0011H\u0002J\b\u0010b\u001a\u00020\u0011H\u0002Jh\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u00020\u00112\b\b\u0002\u0010e\u001a\u00020f2\b\b\u0002\u0010g\u001a\u00020f2\b\b\u0003\u0010h\u001a\u00020N2\b\b\u0002\u0010i\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010k\u001a\u0002092\u0006\u0010l\u001a\u000203H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020305X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006n"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotEditAvatarPreviewViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/IBotEditAvatarPreviewViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "avatarInfo", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "botName", "", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "isInAiGenProcess", "originalUserImgUriLocal", "originalAvatarImgUri", "originalBackgroundImgUri", "repo", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/AIGenBgImageRepository;", "avatarLoadSuccess", "bgLoadSuccess", "hasAvatarCropped", "hasBgCropped", "needReviewBotInfo", "hasReviewBotInfo", "botCreateTrace", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotCreateAvatarPreviewTrace;", "getBotCreateTrace", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotCreateAvatarPreviewTrace;", "uploadViewModel", "Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/PreviewUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/PreviewUIEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "dispatchUIAction", "", "uiAction", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/PreviewUIAction;", "onClickChangeBtn", "interceptShowGenActionSheetForBotInfoReview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canUpload", "Landroid/net/Uri;", "onClickConfirm", "uploadAvatarAndBg", "uriIsFile", "scene", "parentScene", "imgWatermarkType", "handleUploadBg", "handleUploadAvatar", "handleUploadFail", "resp", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "getUploadFileBizTag", "", "onUploadSuccess", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBotAvatarAndBgImageInfo", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "isBotAvatarOrBgImageChanged", "bgInfo", "onCropped", "needReopen", "uri", "originalImgUri", "onFinalImageSet", "isBg", "success", "initData", "bundle", "Landroid/os/Bundle;", "cropAvatarFace", "onCheckedChange", "isChecked", "isBgLoadSuccess", "refreshUIState", "disable", "avatarUri", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/UriState;", "bgUri", "bgColor", "showBg", "initialBgUrl", "sendUIEvent", "event", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditAvatarPreviewViewModel extends AndroidViewModel implements u {
    public static final a Companion = null;
    private static final String TAG = "BotEditAvatarPreviewViewModel";
    private final MutableSharedFlow<x> _uiEvent;
    private final z0<y> _uiState;
    private BotAvatarIconData avatarInfo;
    private boolean avatarLoadSuccess;
    private BgImage bgImage;
    private boolean bgLoadSuccess;
    private final com.larus.bot.impl.feature.edit.feature.bgimage.preview.a botCreateTrace;
    private String botDescription;
    private BotModel botInfo;
    private String botName;
    private boolean hasAvatarCropped;
    private boolean hasBgCropped;
    private boolean hasReviewBotInfo;
    private boolean isInAiGenProcess;
    private boolean needReviewBotInfo;
    private boolean needUpdateBotInfo;
    private String originalAvatarImgUri;
    private String originalBackgroundImgUri;
    private String originalUserImgUriLocal;
    private final AIGenBgImageRepository repo;
    private final d1<x> uiEvent;
    private final i1<y> uiState;
    private final Lazy uploadViewModel$delegate;
    private String userBotGender;
    private String userBotType;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$cropAvatarFace$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {618, 655}, m = "cropAvatarFace", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public AnonymousClass1(BotEditAvatarPreviewViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BotEditAvatarPreviewViewModel.access$cropAvatarFace(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$handleUploadAvatar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$handleUploadAvatar$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {353, 355}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imgWatermarkType;
        final /* synthetic */ String $parentScene;
        final /* synthetic */ String $scene;
        final /* synthetic */ boolean $uriIsFile;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02111(String r1, String r2, BotEditAvatarPreviewViewModel r3, String r4, boolean r5, Continuation<? super C02111> r6) {
            this.$scene = r1;
            this.$parentScene = r2;
            this.this$0 = r3;
            this.$imgWatermarkType = r4;
            this.$uriIsFile = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C02111(this.$scene, this.$parentScene, this.this$0, this.$imgWatermarkType, this.$uriIsFile, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r44) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            String r11 = null;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r44);
        L48:
            qu8.b.c(0, new String[]{this.$scene, this.$parentScene});
        L51:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r44);
            Object r1 = r44;
        L15:
            com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
        L18:
            if ((r2 instanceof com.larus.network.http.y) == false) goto L49;
            com.larus.network.http.y r3 = (com.larus.network.http.y) r2;
            ImageUploadResult r4 = (ImageUploadResult) ((com.larus.network.http.a) r3).b;
            if (r4 == null) goto L22;
            String r5 = r4.getUploadUrl();
        L24:
            if (o0.d(r5) == false) goto L49;
            ImageUploadResult r6 = (ImageUploadResult) ((com.larus.network.http.a) r3).b;
            if (r6 == null) goto L28;
            String r8 = r6.getUploadUri();
        L30:
            if (o0.d(r8) == false) goto L49;
            BotEditAvatarPreviewViewModel r9 = this.this$0;
            BotModel r10 = BotEditAvatarPreviewViewModel.access$getBotInfo$p(r9);
            ImageUploadResult r12 = (ImageUploadResult) ((com.larus.network.http.a) r3).b;
            if (r12 == null) goto L34;
            String r13 = r12.getUploadUri();
        L35:
            ImageUploadResult r14 = (ImageUploadResult) ((com.larus.network.http.a) r3).b;
            if (r14 == null) goto L38;
            String r15 = r14.getUploadUrl();
        L39:
            ImageUploadResult r16 = (ImageUploadResult) ((com.larus.network.http.a) r3).b;
            if (r16 == null) goto L42;
            r11 = r16.getReferenceBgImgPrompt();
        L42:
            BotAvatarIconData r17 = new BotAvatarIconData(r13, r15, r11, null, null, 24, null);
            BgImage r18 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0);
            BgImageInfo r19 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImageInfo;
            if (r19 != null) goto L45;
            r19 = new BgImageInfo(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        L45:
            BgImage r20 = BgImage.copy$default(r18, null, null, null, BgImageInfo.copy$default(r19, null, null, null, null, Boxing.boxBoolean(((y) this.this$0.getUiState().getValue()).e), null, null, null, null, null, null, 2031, null), 7, null);
            this.label = 2;
            if (BotEditAvatarPreviewViewModel.access$onUploadSuccess(r9, r10, r17, r20, this) != r7) goto L48;
            return r7;
        L38:
            r15 = null;
            goto L39
        L34:
            r13 = null;
            goto L35
        L28:
            r8 = null;
            goto L30
        L22:
            r5 = null;
        L49:
            FLogger.a.e(BotEditAvatarPreviewViewModel.TAG, "Upload avatar failed");
            BotEditAvatarPreviewViewModel.access$handleUploadFail(this.this$0, r2);
            goto L51
        L10:
            ResultKt.throwOnFailure(r44);
            qu8.b.e(this.$scene, this.$parentScene, false);
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.b(true));
            Uri r21 = ((y) this.this$0.getUiState().getValue()).b.a;
            if (r21 == null) goto L16;
            BotEditAvatarPreviewViewModel r22 = this.this$0;
            String r23 = this.$imgWatermarkType;
            boolean r24 = this.$uriIsFile;
            BotImageUploadViewModel r25 = BotEditAvatarPreviewViewModel.access$getUploadViewModel(r22);
            int r26 = BotEditAvatarPreviewViewModel.access$getUploadFileBizTag(r22);
            this.label = 1;
            r1 = r25.syncUpload(r21, r26, r23, r24, this);
            if (r1 != r7) goto L15;
            return r7;
        L16:
            r2 = null;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$handleUploadBg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$handleUploadBg$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {319, 329}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $parentScene;
        final /* synthetic */ String $scene;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02121(String r1, String r2, BotEditAvatarPreviewViewModel r3, Continuation<? super C02121> r4) {
            this.$scene = r1;
            this.$parentScene = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02121(this.$scene, this.$parentScene, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r46) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            String r3 = (String) this.L$1;
            String r4 = (String) this.L$0;
            ResultKt.throwOnFailure(r46);
        L41:
            qu8.b.c(0, new String[]{r4, r3});
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r46);
            Object r5 = r46;
        L13:
            com.larus.network.http.a r6 = (com.larus.network.http.a) r5;
            if (r6 == null) goto L43;
            ImageUploadResult r7 = (ImageUploadResult) r6.b;
            if (r7 == null) goto L43;
            BotEditAvatarPreviewViewModel r8 = this.this$0;
            String r9 = this.$scene;
            String r10 = this.$parentScene;
            if (o0.d(r7.getUploadUrl()) == false) goto L43;
            if (o0.d(r7.getUploadUri()) == false) goto L43;
            BotModel r11 = BotEditAvatarPreviewViewModel.access$getBotInfo$p(r8);
            BotAvatarIconData r12 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r8);
            BgImage r13 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r8);
            String r14 = r7.getUploadUri();
            String r15 = r7.getUploadUrl();
            BgImageInfo r16 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r8).bgImageInfo;
            if (r16 != null) goto L24;
            r16 = new BgImageInfo(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        L24:
            BgImageInfo r31 = r16;
            Boolean r36 = Boxing.boxBoolean(((y) r8.getUiState().getValue()).e);
            String r17 = r7.getReferenceBgImgPrompt();
            if (r17 != null) goto L28;
            r17 = "";
        L28:
            if (r17.length() != 0) goto L30;
            boolean r18 = true;
        L31:
            if (r18 == false) goto L36;
            BgImageInfo r19 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r8).bgImageInfo;
            if (r19 == null) goto L35;
            r17 = r19.bgImagePromptForEnrich;
            goto L36
        L35:
            String r42 = null;
        L37:
            BgImage r20 = BgImage.copy$default(r13, r14, r15, null, BgImageInfo.copy$default(r31, null, null, null, null, r36, null, null, null, null, null, r42, 1007, null), 4, null);
            this.L$0 = r9;
            this.L$1 = r10;
            this.label = 2;
            if (BotEditAvatarPreviewViewModel.access$onUploadSuccess(r8, r11, r12, r20, this) != r1) goto L40;
            return r1;
        L40:
            r4 = r9;
            r3 = r10;
        L36:
            r42 = r17;
            goto L37
        L30:
            r18 = false;
        L43:
            FLogger.a.e(BotEditAvatarPreviewViewModel.TAG, "Upload bg failed");
            BotEditAvatarPreviewViewModel.access$handleUploadFail(this.this$0, r6);
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r46);
            qu8.b.e(this.$scene, this.$parentScene, false);
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.b(true));
            CoroutineDispatcher r21 = Dispatchers.getIO();
            BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1 r22 = new BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1(this.this$0, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r21, r22, this);
            if (r5 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$initData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$initData$2", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public AnonymousClass2(BotEditAvatarPreviewViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            BotEditAvatarPreviewViewModel r3 = this.this$0;
            String r15 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r3).getIconUrl();
            String r2 = "";
            if (r15 != null) goto L14;
            r15 = "";
        L14:
            z r5 = new z(UriProtector.parse(r15));
            String r16 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImgUrl;
            if (r16 != null) goto L19;
            r16 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(this.this$0).getIconUrl();
            if (r16 != null) goto L19;
        L20:
            z r6 = new z(UriProtector.parse(r2));
            String r17 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImgColor;
            if (r17 != null) goto L49;
        L32:
            int r18 = ((y) this.this$0.getUiState().getValue()).d;
        L33:
            int r7 = r18;
            Boolean r19 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).getBgImgOpen();
            if (r19 == null) goto L36;
            boolean r8 = r19.booleanValue();
        L37:
            boolean r9 = BotEditAvatarPreviewViewModel.access$isInAiGenProcess$p(this.this$0);
            if (BotEditAvatarPreviewViewModel.access$isInAiGenProcess$p(this.this$0) == false) goto L43;
            String r110 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImgUrl;
            if (r110 != null) goto L42;
            r110 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(this.this$0).getIconUrl();
        L42:
            String r10 = r110;
        L44:
            BotEditAvatarPreviewViewModel.access$refreshUIState(r3, false, r5, r6, r7, r8, r9, r10, BotEditAvatarPreviewViewModel.access$getOriginalAvatarImgUri$p(this.this$0), BotEditAvatarPreviewViewModel.access$getOriginalBackgroundImgUri$p(this.this$0));
            if (BotEditAvatarPreviewViewModel.access$isBgLoadSuccess(this.this$0) == false) goto L47;
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, x.e.a);
        L47:
            int r111 = v.a;
            com.larus.ugc.perf.impl.c.a("bot_edit_preview_page");
            return Unit.INSTANCE;
        L43:
            r10 = null;
            goto L44
        L36:
            r8 = true;
            goto L37
        L49:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
            Object r112 = Result.constructor-impl(Boxing.boxInt(Color.parseColor(r17)));     // Catch: Throwable -> L24
        L27:
            if (Result.isFailure-impl(r112) == false) goto L29;
            r112 = null;
        L29:
            Integer r113 = (Integer) r112;
            if (r113 == null) goto L32;
            r18 = r113.intValue();
        L24:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r112 = Result.constructor-impl(ResultKt.createFailure(th));
        L19:
            r2 = r16;
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            BotEditAvatarPreviewViewModel r114 = this.this$0;
            this.label = 1;
            if (BotEditAvatarPreviewViewModel.access$cropAvatarFace(r114, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$interceptShowGenActionSheetForBotInfoReview$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel", f = "BotEditAvatarPreviewViewModel.kt", i = {0}, l = {194}, m = "interceptShowGenActionSheetForBotInfoReview", n = {"delayShowLoadingJob"}, s = {"L$0"})
    public static final class C02131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02131(BotEditAvatarPreviewViewModel r1, Continuation<? super C02131> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BotEditAvatarPreviewViewModel.access$interceptShowGenActionSheetForBotInfoReview(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$onClickChangeBtn$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$onClickChangeBtn$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02141(BotEditAvatarPreviewViewModel r1, Continuation<? super C02141> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02141(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L12:
            if (((Boolean) r12).booleanValue() == true) goto L27;
            BotEditAvatarPreviewViewModel r13 = this.this$0;
            Uri r2 = ((y) r13.getUiState().getValue()).b.a;
            if (r2 == null) goto L16;
            String r3 = r2.getScheme();
        L18:
            if (Intrinsics.areEqual(r3, ShareType.FILE) == false) goto L20;
            BotAvatarIconData r4 = new BotAvatarIconData(null, String.valueOf(((y) this.this$0.getUiState().getValue()).b.a), null, null, null, 29, null);
        L21:
            BgImageInfo r5 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImageInfo;
            String r6 = BotEditAvatarPreviewViewModel.access$getBotName$p(this.this$0);
            String r7 = BotEditAvatarPreviewViewModel.access$getBotDescription$p(this.this$0);
            String r8 = BotEditAvatarPreviewViewModel.access$getUserBotGender$p(this.this$0);
            String r9 = BotEditAvatarPreviewViewModel.access$getUserBotType$p(this.this$0);
            Boolean r10 = Boxing.boxBoolean(BotEditAvatarPreviewViewModel.access$getNeedUpdateBotInfo$p(this.this$0));
            BotModel r11 = BotEditAvatarPreviewViewModel.access$getBotInfo$p(this.this$0);
            if (this.this$0.getBotCreateTrace().d() == false) goto L24;
            String r14 = "click_head_preview";
        L25:
            BotEditAvatarPreviewViewModel.access$sendUIEvent(r13, new x.d(r4, r5, r6, r7, r8, r9, r10, r11, r14));
            goto L27
        L24:
            r14 = "click_create_preview";
            goto L25
        L20:
            r4 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(this.this$0);
            goto L21
        L16:
            r3 = null;
        L27:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            BotEditAvatarPreviewViewModel r15 = this.this$0;
            this.label = 1;
            r12 = BotEditAvatarPreviewViewModel.access$interceptShowGenActionSheetForBotInfoReview(r15, this);
            if (r12 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$onClickConfirm$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$onClickConfirm$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $parentScene;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02151(BotEditAvatarPreviewViewModel r1, String r2, Continuation<? super C02151> r3) {
            this.this$0 = r1;
            this.$parentScene = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02151(this.this$0, this.$parentScene, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r40) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r40);
        L17:
            qu8.b.d(this.$parentScene, 0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r40);
            if (BotEditAvatarPreviewViewModel.access$getNeedUpdateBotInfo$p(this.this$0) == false) goto L11;
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.b(true));
        L11:
            BotEditAvatarPreviewViewModel r3 = this.this$0;
            BotModel r4 = BotEditAvatarPreviewViewModel.access$getBotInfo$p(r3);
            BotAvatarIconData r5 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(this.this$0);
            BgImage r7 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0);
            BgImageInfo r6 = BotEditAvatarPreviewViewModel.access$getBgImage$p(this.this$0).bgImageInfo;
            if (r6 != null) goto L14;
            r6 = new BgImageInfo(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        L14:
            BgImage r8 = BgImage.copy$default(r7, null, null, null, BgImageInfo.copy$default(r6, null, null, null, null, Boxing.boxBoolean(((y) this.this$0.getUiState().getValue()).e), null, null, null, null, null, null, 2031, null), 7, null);
            this.label = 1;
            if (BotEditAvatarPreviewViewModel.access$onUploadSuccess(r3, r4, r5, r8, this) != r1) goto L17;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$onUploadSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel", f = "BotEditAvatarPreviewViewModel.kt", i = {0, 0, 1, 1, 1, 2, 4, 4, 4}, l = {398, 401, 404, 405, 409, 410}, m = "onUploadSuccess", n = {"avatarInfo", "bgImage", "avatarInfo", "bgImage", "resp", "resp", "avatarInfo", "bgImage", "resp"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2"})
    public static final class C02161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02161(BotEditAvatarPreviewViewModel r1, Continuation<? super C02161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BotEditAvatarPreviewViewModel.access$onUploadSuccess(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$sendUIEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$sendUIEvent$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {703}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ x $event;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02171(BotEditAvatarPreviewViewModel r1, x r2, Continuation<? super C02171> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02171(this.this$0, this.$event, r4);
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
            MutableSharedFlow r5 = BotEditAvatarPreviewViewModel.access$get_uiEvent$p(this.this$0);
            x r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$updateBotAvatarAndBgImageInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$updateBotAvatarAndBgImageInfo$2", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {441, 449, 472}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ub8.b>, Object> {
        final /* synthetic */ BotAvatarIconData $avatarInfo;
        final /* synthetic */ BgImage $bgImage;
        final /* synthetic */ BotModel $botInfo;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02182(BotEditAvatarPreviewViewModel r1, BotModel r2, BotAvatarIconData r3, BgImage r4, Continuation<? super C02182> r5) {
            this.this$0 = r1;
            this.$botInfo = r2;
            this.$avatarInfo = r3;
            this.$bgImage = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02182(this.this$0, this.$botInfo, this.$avatarInfo, this.$bgImage, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super ub8.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r45) {
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r12 = false;
            String r13 = "";
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 != 3) goto L9;
            BotModel r1 = (BotModel) this.L$1;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r45);
            return r2;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r45);
            Object r3 = r45;
        L34:
            ub8.b r4 = (ub8.b) r3;
            if (r4 != null) goto L37;
        L39:
            boolean r5 = false;
        L40:
            if (r5 == false) goto L75;
            uc9.t r6 = r4.a;
            if (r6 == null) goto L76;
            BotModel r7 = r6.b;
            if (r7 == null) goto L77;
            String r8 = r7.getBgImgUrl();
            if (r8 != null) goto L48;
        L66:
            String r10 = r7.getBotId();
            if (r10 == null) goto L70;
            r13 = r10;
        L70:
            nq9.b r11 = new nq9.b(r13, null, null);
        L71:
            MutableSharedFlow<nq9.b> r14 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.d;
            this.L$0 = r3;
            this.L$1 = r7;
            this.label = 3;
            if (r14.emit(r11, this) != r9) goto L78;
            return r9;
        L78:
            return r3;
        L48:
            if ((!StringsKt.isBlank(r8)) == true) goto L50;
        L54:
            if (r12 == true) goto L57;
            r8 = null;
        L57:
            if (r8 == null) goto L66;
            String r15 = r7.getBotId();
            if (r15 != null) goto L61;
            r15 = "";
        L61:
            String r16 = r7.getBgImgColor();
            if (r16 == null) goto L65;
            r13 = r16;
        L65:
            r11 = new nq9.b(r15, r8, r13);
            goto L71
        L50:
            if (o0.d(r7.getBgImgColor()) == false) goto L54;
            if (r7.getBgImgOpen() == false) goto L54;
            r12 = true;
            goto L54
        L77:
            return r3;
        L76:
            return r3;
        L75:
            return r3;
        L37:
            if (true != ub8.d.a(r4)) goto L39;
            r5 = true;
            goto L40
        L11:
            ResultKt.throwOnFailure(r45);
            Object r17 = r45;
        L17:
            com.larus.network.http.y r18 = (com.larus.network.http.a) r17;
            if ((r18 instanceof com.larus.network.http.y) == false) goto L25;
            ImageUploadResult r19 = (ImageUploadResult) ((com.larus.network.http.a) r18).b;
            if (r19 == null) goto L22;
            String r20 = r19.getUploadUri();
        L23:
            String r37 = r20;
        L27:
            Lazy<UgcBotRepo> r21 = UgcBotRepo.d;
            UgcBotRepo r22 = UgcBotRepo.a.a();
            BotUpdateType r110 = BotUpdateType.OTHERS;
            String r23 = this.$botInfo.getBotId();
            if (r23 != null) goto L30;
            String r111 = "";
        L31:
            String r112 = this.$botInfo.getName();
            String r24 = this.$botInfo.getDescriptionForHuman();
            String r25 = this.$avatarInfo.getIconUri();
            BgImage r26 = this.$bgImage;
            uc9.s r27 = new uc9.s(r110, r111, r112, r24, r25, null, null, null, null, null, null, null, null, null, null, null, null, null, r26.bgImgUri, r26.bgImageInfo, r37, null, null, null, null, null, 65273824);
            this.label = 2;
            r22.getClass();
            CompletableDeferred r28 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            com.larus.im.d.a().updateBot(r27, new com.larus.bot.impl.repository.g(r28));
            r3 = r28.await(this);
            if (r3 != r9) goto L34;
            return r9;
        L30:
            r111 = r23;
            goto L31
        L22:
            r20 = null;
            goto L23
        L25:
            return new ub8.b(new uc9.t(false, null), null, 6);
        L12:
            ResultKt.throwOnFailure(r45);
            if (o0.d(BotEditAvatarPreviewViewModel.access$getOriginalUserImgUriLocal$p(this.this$0)) == false) goto L26;
            BotImageUploadViewModel r29 = BotEditAvatarPreviewViewModel.access$getUploadViewModel(this.this$0);
            Uri r30 = UriProtector.parse(BotEditAvatarPreviewViewModel.access$getOriginalUserImgUriLocal$p(this.this$0));
            this.label = 1;
            r17 = BotImageUploadViewModel.syncUpload$default(r29, r30, 0, null, false, this, 14, null);
            if (r17 != r9) goto L17;
            return r9;
        L26:
            r37 = null;
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$uploadAvatarAndBg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$uploadAvatarAndBg$1", f = "BotEditAvatarPreviewViewModel.kt", i = {0, 0, 1, 1, 3, 3, 4, 4, 5, 7, 7, 8, 8, 9}, l = {271, 276, 278, 297, 297, 298, 299, 301, 301, 302, 303}, m = "invokeSuspend", n = {"resp1", "resp2", "resp1", "resp2", "resp1", "resp2", "resp1", "resp2", "resp1", "resp1", "resp2", "resp1", "resp2", "resp1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class C02191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imgWatermarkType;
        final /* synthetic */ String $parentScene;
        final /* synthetic */ String $scene;
        final /* synthetic */ boolean $uriIsFile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

        public C02191(String r1, String r2, BotEditAvatarPreviewViewModel r3, String r4, boolean r5, Continuation<? super C02191> r6) {
            this.$scene = r1;
            this.$parentScene = r2;
            this.this$0 = r3;
            this.$imgWatermarkType = r4;
            this.$uriIsFile = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C02191 r7 = new C02191(this.$scene, this.$parentScene, this.this$0, this.$imgWatermarkType, this.$uriIsFile, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r51) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            long r3 = -2;
            String r6 = "";
            com.larus.network.http.f r10 = null;
            switch(this.label) {
                case 0: goto L17;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                case 11: goto L6;
                default: goto L5;
            };
        L6:
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r51);
            Object r5 = r51;
        L150:
            if ((r5 instanceof com.larus.network.http.f) == false) goto L152;
            r10 = (com.larus.network.http.f) r5;
        L152:
            if (r10 == null) goto L156;
            AsyncThrowable r4 = r10.d;
            if (r4 == null) goto L156;
            r3 = r4.getCode();
        L156:
            qu8.b.d(r2, r3);
            qu8.b.d(this.$parentScene, 10021);
        L158:
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.b(false));
            return Unit.INSTANCE;
        L7:
            BotEditAvatarPreviewViewModel r7 = (BotEditAvatarPreviewViewModel) this.L$1;
            Deferred r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            Object r8 = r51;
        L134:
            if ((r8 instanceof com.larus.network.http.f) == false) goto L136;
            com.larus.network.http.f r11 = (com.larus.network.http.f) r8;
        L137:
            if (r11 == null) goto L141;
            AsyncThrowable r12 = r11.d;
            if (r12 == null) goto L141;
            String r13 = r12.getMessage();
        L142:
            if (r13 == null) goto L145;
            r6 = r13;
        L145:
            BotEditAvatarPreviewViewModel.access$sendUIEvent(r7, new x.f(new TextRes.PlainText(r6)));
            String r14 = this.$scene;
            this.L$0 = r14;
            this.L$1 = null;
            this.label = 11;
            r5 = r9.await(this);
            if (r5 != r1) goto L148;
            return r1;
        L148:
            r2 = r14;
        L141:
            r13 = null;
            goto L142
        L136:
            r11 = null;
            goto L137
        L8:
            Deferred r15 = (Deferred) this.L$1;
            r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            Deferred r16 = r15;
            Object r17 = r51;
        L120:
            if ((r17 instanceof com.larus.network.http.f) == false) goto L122;
            com.larus.network.http.f r18 = (com.larus.network.http.f) r17;
        L123:
            if (r18 == null) goto L127;
            AsyncThrowable r19 = r18.d;
            if (r19 == null) goto L127;
            String r20 = r19.getMessage();
        L129:
            if (o0.d(r20) == false) goto L157;
            r7 = this.this$0;
            this.L$0 = r9;
            this.L$1 = r7;
            this.label = 10;
            r8 = r16.await(this);
            if (r8 != r1) goto L134;
            return r1;
        L157:
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.f(new TextRes.StringResId(2131900183)));
            qu8.b.d(this.$scene, -2);
            qu8.b.d(this.$parentScene, 10021);
        L127:
            r20 = null;
            goto L129
        L122:
            r18 = null;
            goto L123
        L9:
            Deferred r21 = (Deferred) this.L$1;
            r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            r16 = r21;
            Object r22 = r51;
        L115:
            if ((r22 instanceof com.larus.network.http.f) == false) goto L157;
            this.L$0 = r9;
            this.L$1 = r16;
            this.label = 9;
            r17 = r16.await(this);
            if (r17 != r1) goto L120;
            return r1;
        L10:
            String r23 = (String) this.L$0;
            ResultKt.throwOnFailure(r51);
            Object r24 = r51;
        L104:
            if ((r24 instanceof com.larus.network.http.f) == false) goto L106;
            r10 = (com.larus.network.http.f) r24;
        L106:
            if (r10 == null) goto L110;
            AsyncThrowable r25 = r10.d;
            if (r25 == null) goto L110;
            r3 = r25.getCode();
        L110:
            qu8.b.d(r23, r3);
            qu8.b.d(this.$parentScene, 10021);
            goto L158
        L11:
            BotEditAvatarPreviewViewModel r26 = (BotEditAvatarPreviewViewModel) this.L$1;
            r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            Object r27 = r51;
        L88:
            if ((r27 instanceof com.larus.network.http.f) == false) goto L90;
            com.larus.network.http.f r28 = (com.larus.network.http.f) r27;
        L91:
            if (r28 == null) goto L95;
            AsyncThrowable r29 = r28.d;
            if (r29 == null) goto L95;
            String r30 = r29.getMessage();
        L96:
            if (r30 == null) goto L99;
            r6 = r30;
        L99:
            BotEditAvatarPreviewViewModel.access$sendUIEvent(r26, new x.f(new TextRes.PlainText(r6)));
            String r31 = this.$scene;
            this.L$0 = r31;
            this.L$1 = null;
            this.label = 7;
            r24 = r9.await(this);
            if (r24 != r1) goto L102;
            return r1;
        L102:
            r23 = r31;
        L95:
            r30 = null;
            goto L96
        L90:
            r28 = null;
            goto L91
        L12:
            Deferred r32 = (Deferred) this.L$1;
            r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            r16 = r32;
            Object r33 = r51;
        L74:
            if ((r33 instanceof com.larus.network.http.f) == false) goto L76;
            com.larus.network.http.f r34 = (com.larus.network.http.f) r33;
        L77:
            if (r34 == null) goto L81;
            AsyncThrowable r35 = r34.d;
            if (r35 == null) goto L81;
            String r36 = r35.getMessage();
        L83:
            if (o0.d(r36) == false) goto L111;
            r26 = this.this$0;
            this.L$0 = r9;
            this.L$1 = r26;
            this.label = 6;
            r27 = r9.await(this);
            if (r27 != r1) goto L88;
            return r1;
        L111:
            this.L$0 = r9;
            this.L$1 = r16;
            this.label = 8;
            r22 = r16.await(this);
            if (r22 != r1) goto L115;
            return r1;
        L81:
            r36 = null;
            goto L83
        L76:
            r34 = null;
            goto L77
        L13:
            Deferred r37 = (Deferred) this.L$1;
            r9 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            r16 = r37;
            Object r38 = r51;
        L69:
            if ((r38 instanceof com.larus.network.http.f) == false) goto L111;
            this.L$0 = r9;
            this.L$1 = r16;
            this.label = 5;
            r33 = r9.await(this);
            if (r33 != r1) goto L74;
            return r1;
        L14:
            String r39 = (String) this.L$1;
            String r40 = (String) this.L$0;
            ResultKt.throwOnFailure(r51);
        L62:
            qu8.b.d(r40, 0);
            qu8.b.d(r39, 0);
        L64:
            return Unit.INSTANCE;
        L15:
            String r41 = (String) this.L$4;
            String r110 = (String) this.L$3;
            BotEditAvatarPreviewViewModel r111 = (BotEditAvatarPreviewViewModel) this.L$2;
            r16 = (Deferred) this.L$1;
            Deferred r112 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            String r113 = r41;
            Object r42 = r51;
        L32:
            com.larus.network.http.a r43 = (com.larus.network.http.a) r42;
            if (r43 == null) goto L65;
            ImageUploadResult r44 = (ImageUploadResult) r43.b;
            if (r44 == null) goto L65;
            if (o0.d(r44.getUploadUrl()) == false) goto L64;
            if (o0.d(r44.getUploadUri()) == false) goto L64;
            BotModel r45 = BotEditAvatarPreviewViewModel.access$getBotInfo$p(r111);
            BotAvatarIconData r46 = BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r111);
            BgImage r114 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r111);
            String r115 = r44.getUploadUri();
            String r210 = r44.getUploadUrl();
            BgImageInfo r47 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r111).bgImageInfo;
            if (r47 != null) goto L43;
            r47 = new BgImageInfo(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        L43:
            BgImageInfo r310 = r47;
            Boolean r48 = Boxing.boxBoolean(((y) r111.getUiState().getValue()).e);
            String r49 = r44.getReferenceBgImgPrompt();
            if (r49 == null) goto L48;
            r6 = r49;
        L48:
            if (r6.length() != 0) goto L50;
            boolean r50 = true;
        L51:
            if (r50 == false) goto L57;
            BgImageInfo r52 = BotEditAvatarPreviewViewModel.access$getBgImage$p(r111).bgImageInfo;
            if (r52 == null) goto L55;
            String r53 = r52.bgImagePromptForEnrich;
        L56:
            String r410 = r53;
        L58:
            BgImage r54 = BgImage.copy$default(r114, r115, r210, null, BgImageInfo.copy$default(r310, null, null, null, null, r48, null, null, null, null, null, r410, 1007, null), 4, null);
            this.L$0 = r110;
            this.L$1 = r113;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 3;
            if (BotEditAvatarPreviewViewModel.access$onUploadSuccess(r111, r45, r46, r54, this) != r1) goto L61;
            return r1;
        L61:
            r40 = r110;
            r39 = r113;
            goto L62
        L55:
            r53 = null;
            goto L56
        L57:
            r410 = r6;
            goto L58
        L50:
            r50 = false;
        L65:
            r9 = r112;
            FLogger.a.e(BotEditAvatarPreviewViewModel.TAG, "Upload failed");
            this.L$0 = r9;
            this.L$1 = r16;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 4;
            r38 = r9.await(this);
            if (r38 != r1) goto L69;
            return r1;
        L16:
            Deferred r55 = (Deferred) this.L$1;
            Deferred r116 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r51);
            Object r117 = r51;
            r16 = r55;
            r112 = r116;
        L21:
            com.larus.network.http.a r118 = (com.larus.network.http.a) r117;
            if (r118 == null) goto L65;
            ImageUploadResult r56 = (ImageUploadResult) r118.b;
            if (r56 == null) goto L65;
            r111 = this.this$0;
            r110 = this.$scene;
            r113 = this.$parentScene;
            if (o0.d(r56.getUploadUrl()) == false) goto L65;
            if (o0.d(r56.getUploadUri()) == false) goto L65;
            BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r111).setIconUri(r56.getUploadUri());
            BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r111).setIconUrl(r56.getUploadUrl());
            BotEditAvatarPreviewViewModel.access$getAvatarInfo$p(r111).setPrompt(r56.getReferenceBgImgPrompt());
            this.L$0 = r112;
            this.L$1 = r16;
            this.L$2 = r111;
            this.L$3 = r110;
            this.L$4 = r113;
            this.label = 2;
            r42 = r16.await(this);
            if (r42 != r1) goto L32;
            return r1;
        L17:
            ResultKt.throwOnFailure(r51);
            CoroutineScope r57 = (CoroutineScope) this.L$0;
            qu8.b.e(this.$scene, this.$parentScene, false);
            BotEditAvatarPreviewViewModel.access$sendUIEvent(this.this$0, new x.b(true));
            Deferred r119 = BuildersKt.async$default(r57, Dispatchers.getIO(), null, new BotEditAvatarPreviewViewModel$uploadAvatarAndBg$1$resp1$1(this.this$0, this.$imgWatermarkType, this.$uriIsFile, null), 2, null);
            Deferred r120 = BuildersKt.async$default(r57, Dispatchers.getIO(), null, new BotEditAvatarPreviewViewModel$uploadAvatarAndBg$1$resp2$1(this.this$0, null), 2, null);
            this.L$0 = r119;
            this.L$1 = r120;
            this.label = 1;
            r117 = r119.await(this);
            if (r117 != r1) goto L20;
            return r1;
        L20:
            r112 = r119;
            r16 = r120;
            goto L21
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ BotImageUploadViewModel Mo(Application r0) {
        return uploadViewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit yo(boolean r0) {
        return cropAvatarFace$lambda$4(r0);
    }

    private final int getUploadFileBizTag() {
        if (this.isInAiGenProcess == false) goto L5;
    L8:
        return 1;
    L5:
        if (this.needUpdateBotInfo == true) goto L8;
        return 6;
    }

    private final BotImageUploadViewModel getUploadViewModel() {
        return (BotImageUploadViewModel) this.uploadViewModel$delegate.getValue();
    }

    private final void onClickConfirm() {
        String r0 = this.bgImage.bgImgUri;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        if (canUpload(((y) getUiState().getValue()).c.a) == false) goto L13;
    L14:
        boolean r3 = true;
    L16:
        String r4 = this.avatarInfo.getIconUri();
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == false) goto L27;
        if (canUpload(((y) getUiState().getValue()).b.a) == false) goto L27;
    L28:
        boolean r6 = true;
    L30:
        String r7 = this.avatarInfo.getIconUri();
        if (r7 != null) goto L33;
    L36:
        boolean r8 = true;
    L37:
        if (r8 == true) goto L39;
    L43:
        boolean r9 = false;
    L44:
        boolean r10 = this.isInAiGenProcess;
        if (r10 == false) goto L47;
        String r11 = "bot_create/bg_setting/ai/file_upload";
    L48:
        if (r10 == false) goto L50;
        String r12 = "bot_create/bg_setting/ai";
    L51:
        String r13 = null;
        if (r9 == true) goto L63;
        BotModel r14 = this.botInfo;
        if (r14 == null) goto L56;
        String r15 = r14.getBotId();
    L57:
        if (r15 != null) goto L59;
    L60:
        r1 = true;
    L61:
        if (r1 == false) goto L63;
        r13 = "ai_gen";
        goto L63
    L59:
        if (r15.length() != 0) goto L61;
    L56:
        r15 = null;
    L63:
        if (r3 == false) goto L65;
        uploadAvatarAndBg(r6, r11, r12, r13);
        return;
    L65:
        if (r3 == false) goto L67;
        handleUploadBg(r11, r12);
        return;
    L67:
        handleUploadAvatar(r6, r11, r12, r13);
        return;
    L50:
        r12 = "bot_create/bg_setting/manual";
        goto L51
    L47:
        r11 = "file_handle_upload_bg";
        goto L48
    L39:
        if (canUpload(((y) getUiState().getValue()).b.a) == false) goto L43;
        if (this.hasAvatarCropped == true) goto L43;
        r9 = true;
        goto L44
    L33:
        if (StringsKt.isBlank(r7) == true) goto L36;
        r8 = false;
    L27:
        if (this.hasAvatarCropped == true) goto L28;
        r6 = false;
        goto L30
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r5 = false;
    L13:
        if (this.hasBgCropped == true) goto L14;
        r3 = false;
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean isBgLoadSuccess() {
        if (String.valueOf(((y) getUiState().getValue()).c.a).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.bgLoadSuccess == false) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final void onClickChangeBtn() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02141(this, null), 3, null);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.preview.u
    public com.larus.bot.impl.feature.edit.feature.bgimage.preview.a getBotCreateTrace() {
        return this.botCreateTrace;
    }

    @Override // uu8.b
    public d1<x> getUiEvent() {
        return this.uiEvent;
    }

    @Override // uu8.b
    public i1<y> getUiState() {
        return this.uiState;
    }

    public BotEditAvatarPreviewViewModel(final Application r19) {
        Intrinsics.checkNotNullParameter(r19, "application");
        super(r19);
        this.avatarInfo = new BotAvatarIconData(null, null, null, null, null, 31, null);
        this.bgImage = new BgImage(null, null, null, null, 15, null);
        this.repo = new AIGenBgImageRepository();
        this.botCreateTrace = new com.larus.bot.impl.feature.edit.feature.bgimage.preview.a();
        this.uploadViewModel$delegate = LazyKt.lazy(new s(r19));
        StateFlowImpl r1 = j1.a(new y(true, new z(null), new z(null), 0, false, false, null, null, null));
        this._uiState = r1;
        this.uiState = kotlinx.coroutines.flow.e.b(r1);
        MutableSharedFlow<x> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._uiEvent = r2;
        this.uiEvent = kotlinx.coroutines.flow.e.a(r2);
    }

    public static final /* synthetic */ BotAvatarIconData access$getAvatarInfo$p(BotEditAvatarPreviewViewModel r0) {
        return r0.avatarInfo;
    }

    public static final /* synthetic */ BgImage access$getBgImage$p(BotEditAvatarPreviewViewModel r0) {
        return r0.bgImage;
    }

    public static final /* synthetic */ String access$getBotDescription$p(BotEditAvatarPreviewViewModel r0) {
        return r0.botDescription;
    }

    public static final /* synthetic */ BotModel access$getBotInfo$p(BotEditAvatarPreviewViewModel r0) {
        return r0.botInfo;
    }

    public static final /* synthetic */ String access$getBotName$p(BotEditAvatarPreviewViewModel r0) {
        return r0.botName;
    }

    public static final /* synthetic */ boolean access$getNeedUpdateBotInfo$p(BotEditAvatarPreviewViewModel r0) {
        return r0.needUpdateBotInfo;
    }

    public static final /* synthetic */ String access$getOriginalAvatarImgUri$p(BotEditAvatarPreviewViewModel r0) {
        return r0.originalAvatarImgUri;
    }

    public static final /* synthetic */ String access$getOriginalBackgroundImgUri$p(BotEditAvatarPreviewViewModel r0) {
        return r0.originalBackgroundImgUri;
    }

    public static final /* synthetic */ String access$getOriginalUserImgUriLocal$p(BotEditAvatarPreviewViewModel r0) {
        return r0.originalUserImgUriLocal;
    }

    public static final /* synthetic */ int access$getUploadFileBizTag(BotEditAvatarPreviewViewModel r0) {
        return r0.getUploadFileBizTag();
    }

    public static final /* synthetic */ BotImageUploadViewModel access$getUploadViewModel(BotEditAvatarPreviewViewModel r0) {
        return r0.getUploadViewModel();
    }

    public static final /* synthetic */ String access$getUserBotGender$p(BotEditAvatarPreviewViewModel r0) {
        return r0.userBotGender;
    }

    public static final /* synthetic */ String access$getUserBotType$p(BotEditAvatarPreviewViewModel r0) {
        return r0.userBotType;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_uiEvent$p(BotEditAvatarPreviewViewModel r0) {
        return r0._uiEvent;
    }

    public static final /* synthetic */ boolean access$isBgLoadSuccess(BotEditAvatarPreviewViewModel r0) {
        return r0.isBgLoadSuccess();
    }

    public static final /* synthetic */ boolean access$isInAiGenProcess$p(BotEditAvatarPreviewViewModel r0) {
        return r0.isInAiGenProcess;
    }

    private final boolean canUpload(Uri r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getScheme();
    L6:
        return Intrinsics.areEqual(r3, ShareType.FILE);
    L4:
        r3 = null;
        goto L6
    }

    private final Object cropAvatarFace(Continuation<? super Unit> r26) {
        if ((r26 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r26;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
        Object r9 = null;
    L38:
        File r1 = (File) r0;
        if (r1 != null) goto L54;
    L51:
        qu8.b.d("bot_create/bg_setting/ai/file_handle", 0);
    L53:
        return Unit.INSTANCE;
    L54:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L42
        Object r7 = Result.constructor-impl(Uri.fromFile(r1));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r7) == true) goto L48;
        r9 = r7;
    L48:
        Uri r10 = (Uri) r9;
        if (r10 == null) goto L51;
        this.avatarInfo = new BotAvatarIconData(null, r10.toString(), null, null, null, 28, null);
        int r8 = v.a;
        Intrinsics.checkNotNullParameter("is_cropped_face_show", "key");
        Intrinsics.checkNotNullParameter("true", "value");
        com.larus.ugc.perf.impl.c.c("bot_edit_preview_page", new String[]{"is_cropped_face_show", "true"});
    L42:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
    L31:
        Bitmap r12 = (Bitmap) r0;
        if (r12 != null) goto L34;
        v.b("crop_face", "is_crop_face_success", "false");
        v.a("crop_face");
        qu8.b.d("bot_create/bg_setting/ai/file_handle", 20015);
        qu8.b.d("avatar_crop", -2);
    L34:
        if (r12 == null) goto L51;
        v.b("crop_face", "is_crop_face_success", "true");
        v.a("crop_face");
        qu8.b.d("avatar_crop", 0);
        r2.label = 2;
        r9 = null;
        r0 = BitmapHelperKt.g(null, r12, "bot_edit_avatar_cropped.jpg", r2);
        if (r0 != r4) goto L38;
        return r4;
    L16:
        ResultKt.throwOnFailure(r0);
        if (this.isInAiGenProcess == false) goto L53;
        if (o0.d(this.bgImage.bgImgUrl) == false) goto L53;
        if (o0.d(this.bgImage.bgImgUri) == false) goto L53;
        int r13 = v.a;
        Intrinsics.checkNotNullParameter("try_cropped_face", "key");
        Intrinsics.checkNotNullParameter("true", "value");
        com.larus.ugc.perf.impl.c.c("bot_edit_preview_page", new String[]{"try_cropped_face", "true"});
        v.c("get_face_location");
        qu8.b.e("bot_create/bg_setting/ai/file_handle", "bot_create/bg_setting/ai", false);
        qu8.b.e("avatar_head_location", "bot_create/bg_setting/ai/file_handle", false);
        AIGenBgImageRepository r14 = this.repo;
        BgImage r15 = this.bgImage;
        String r16 = r15.bgImgUri;
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        String r17 = r15.bgImgUrl;
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        Function1<? super Boolean, Unit> r18 = new t();
        r2.label = 1;
        r0 = r14.a(r16, r17, r18, r2);
        if (r0 != r4) goto L31;
        return r4;
    L7:
        r2 = new AnonymousClass1(this, r26);
        goto L8
    }

    private static final Unit cropAvatarFace$lambda$4(boolean r4) {
        v.b("get_face_location", "is_get_face_location_success", String.valueOf(r4));
        v.a("get_face_location");
        v.c("crop_face");
        if (r4 == false) goto L5;
        qu8.b.d("avatar_head_location", 0);
        qu8.b.e("avatar_crop", "bot_create/bg_setting/ai/file_handle", false);
    L7:
        return Unit.INSTANCE;
    L5:
        qu8.b.d("avatar_head_location", -2);
        qu8.b.d("bot_create/bg_setting/ai/file_handle", 20014);
        goto L7
    }

    private final void handleUploadFail(com.larus.network.http.a<ImageUploadResult> r12) {
        boolean r0 = this.isInAiGenProcess;
        if (r0 == false) goto L5;
        String r1 = "bot_create/bg_setting/ai/file_upload";
    L6:
        if (r0 == false) goto L8;
        String r2 = "bot_create/bg_setting/ai";
    L9:
        boolean r3 = r12 instanceof com.larus.network.http.f;
        long r5 = -2;
        if (r3 == false) goto L41;
        com.larus.network.http.f r7 = null;
        if (r3 == false) goto L14;
        com.larus.network.http.f r8 = (com.larus.network.http.f) r12;
    L15:
        if (r8 == null) goto L19;
        AsyncThrowable r9 = r8.d;
        if (r9 == null) goto L19;
        String r10 = r9.getMessage();
    L21:
        if (o0.d(r10) == false) goto L41;
        if (r3 == false) goto L25;
        com.larus.network.http.f r11 = (com.larus.network.http.f) r12;
    L26:
        if (r11 == null) goto L30;
        AsyncThrowable r13 = r11.d;
        if (r13 == null) goto L30;
        String r14 = r13.getMessage();
    L31:
        if (r14 != null) goto L33;
        r14 = "";
    L33:
        sendUIEvent(new x.f(new TextRes.PlainText(r14)));
        if (r3 == false) goto L36;
        r7 = (com.larus.network.http.f) r12;
    L36:
        if (r7 == null) goto L40;
        AsyncThrowable r15 = r7.d;
        if (r15 == null) goto L40;
        r5 = r15.getCode();
    L40:
        qu8.b.d(r1, r5);
        qu8.b.d(r2, 10021);
    L42:
        sendUIEvent(new x.b(false));
        return;
    L30:
        r14 = null;
        goto L31
    L25:
        r11 = null;
    L19:
        r10 = null;
        goto L21
    L14:
        r8 = null;
    L41:
        sendUIEvent(new x.f(new TextRes.StringResId(2131900183)));
        qu8.b.d(r1, -2);
        qu8.b.d(r2, 10021);
        goto L42
    L8:
        r2 = "bot_create/bg_setting/manual";
        goto L9
    L5:
        r1 = "file_handle_upload_bg";
        goto L6
    }

    private final void initData(Bundle r25) {
        if (r25 == null) goto L6;
        getBotCreateTrace().a.putAll(r25);
    L6:
        if (r25 == null) goto L8;
        Serializable r3 = r25.getSerializable("avatar_info");
    L10:
        if ((r3 instanceof BotAvatarIconData) == false) goto L12;
        BotAvatarIconData r4 = (BotAvatarIconData) r3;
    L13:
        if (r4 != null) goto L15;
        r4 = this.avatarInfo;
    L15:
        this.avatarInfo = r4;
        if (r25 == null) goto L18;
        Serializable r5 = r25.getSerializable("bg_image");
    L20:
        if ((r5 instanceof BgImage) == false) goto L22;
        BgImage r6 = (BgImage) r5;
    L23:
        if (r6 != null) goto L25;
        r6 = this.bgImage;
    L25:
        this.bgImage = r6;
        String r7 = r6.bgImgUri;
        boolean r8 = true;
        boolean r9 = false;
        if (r7 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == false) goto L41;
        String r11 = this.bgImage.bgImgUrl;
        if (r11 != null) goto L36;
    L39:
        if (r8 == false) goto L41;
        this.bgImage = new BgImage(this.avatarInfo.getIconUri(), this.avatarInfo.getIconUrl(), null, new BgImageInfo(null, null, null, null, Boolean.FALSE, null, null, null, null, null, null, 2031, null), 4, null);
        goto L41
    L36:
        if (StringsKt.isBlank(r11) == true) goto L39;
        r8 = false;
    L41:
        if (r25 == null) goto L44;
        String r12 = r25.getString("bot_name");
        if (r12 == null) goto L44;
    L45:
        this.botName = r12;
        if (r25 == null) goto L49;
        String r13 = r25.getString("bot_description");
        if (r13 == null) goto L49;
    L50:
        this.botDescription = r13;
        if (r25 == null) goto L54;
        String r14 = r25.getString("user_bot_gender");
        if (r14 == null) goto L54;
    L55:
        this.userBotGender = r14;
        if (r25 == null) goto L59;
        String r15 = r25.getString("user_bot_type");
        if (r15 == null) goto L59;
    L60:
        this.userBotType = r15;
        if (r25 == null) goto L63;
        boolean r16 = r25.getBoolean("need_update_bot_info");
    L64:
        this.needUpdateBotInfo = r16;
        if (r25 == null) goto L67;
        Serializable r17 = r25.getSerializable("bot_update_bot_argument");
    L69:
        if ((r17 instanceof BotModel) == false) goto L71;
        BotModel r18 = (BotModel) r17;
    L72:
        this.botInfo = r18;
        if (r25 == null) goto L75;
        boolean r19 = r25.getBoolean("is_in_ai_gen_process");
    L76:
        this.isInAiGenProcess = r19;
        com.larus.bot.impl.feature.edit.feature.bgimage.preview.a r20 = getBotCreateTrace();
        BgImageInfo r21 = this.bgImage.bgImageInfo;
        if (r21 == null) goto L79;
        boolean r22 = Intrinsics.areEqual(r21.getAiGenBgImg(), Boolean.TRUE);
    L80:
        r20.b = r22;
        if (r25 == null) goto L83;
        String r23 = r25.getString("original_user_image_uri_local");
    L84:
        this.originalUserImgUriLocal = r23;
        if (r25 == null) goto L87;
        String r24 = r25.getString("original_avatar_image_uri");
    L88:
        this.originalAvatarImgUri = r24;
        if (r25 == null) goto L91;
        String r26 = r25.getString("original_background_image_uri");
    L92:
        this.originalBackgroundImgUri = r26;
        if (r25 == null) goto L95;
        r9 = r25.getBoolean("need_review_bot_info");
    L95:
        this.needReviewBotInfo = r9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L91:
        r26 = null;
        goto L92
    L87:
        r24 = null;
        goto L88
    L83:
        r23 = null;
        goto L84
    L79:
        r22 = false;
        goto L80
    L75:
        r19 = false;
        goto L76
    L71:
        r18 = null;
        goto L72
    L67:
        r17 = null;
        goto L69
    L63:
        r16 = false;
    L59:
        r15 = this.userBotType;
    L54:
        r14 = this.userBotGender;
    L49:
        r13 = this.botDescription;
    L44:
        r12 = this.botName;
        goto L45
    L28:
        if (StringsKt.isBlank(r7) == true) goto L31;
        r10 = false;
        goto L32
    L22:
        r6 = null;
        goto L23
    L18:
        r5 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    private final Object interceptShowGenActionSheetForBotInfoReview(Continuation<? super Boolean> r19) {
        if ((r19 instanceof C02131) == false) goto L7;
        C02131 r2 = (C02131) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        C02131 r7 = r2;
        Object r1 = r7.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        boolean r9 = true;
        boolean r11 = false;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Job r6 = (Job) r7.L$0;
        ResultKt.throwOnFailure(r1);
    L26:
        com.larus.network.http.f r8 = (com.larus.network.http.a) r1;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        sendUIEvent(new x.b(false));
        if ((r8 instanceof com.larus.network.http.f) == false) goto L37;
        FLogger.a.e(TAG, "interceptShowGenActionSheetToBotInfoReview");
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L31;
        sendUIEvent(new x.f(new TextRes.StringResId(2131908080)));
    L39:
        return Boxing.boxBoolean(r9);
    L31:
        int r10 = lm9.e.a;
        String r12 = lm9.e.a(r8.d, "");
        if (r12.length() != 0) goto L34;
        r11 = true;
    L34:
        if (r11 == false) goto L36;
        sendUIEvent(new x.f(new TextRes.StringResId(2131901611)));
        goto L39
    L36:
        sendUIEvent(new x.f(new TextRes.PlainText(r12)));
        goto L39
    L37:
        this.hasReviewBotInfo = true;
        r9 = false;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (this.needReviewBotInfo == false) goto L41;
        if (this.hasReviewBotInfo == true) goto L41;
        if (o0.d(this.botName) == false) goto L21;
    L22:
        Job r13 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BotEditAvatarPreviewViewModel$interceptShowGenActionSheetForBotInfoReview$delayShowLoadingJob$1(this, null), 3, null);
        AIGenBgImageRepository r14 = this.repo;
        String r15 = this.botName;
        String r16 = this.botDescription;
        r7.L$0 = r13;
        r7.label = 1;
        Object r17 = AIGenBgImageRepository.d(r14, r15, r16, null, r7, 4);
        if (r17 != r4) goto L25;
        return r4;
    L25:
        r6 = r13;
        r1 = r17;
        goto L26
    L21:
        if (o0.d(this.botDescription) == true) goto L22;
    L41:
        return Boxing.boxBoolean(false);
    L7:
        r2 = new C02131(this, r19);
        goto L8
    }

    private final void onCheckedChange(boolean r13) {
        refreshUIState$default(this, false, null, null, 0, r13, false, null, null, null, 495, null);
    }

    private final void sendUIEvent(x r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02171(this, r7, null), 3, null);
    }

    private static final BotImageUploadViewModel uploadViewModel_delegate$lambda$0(Application r1) {
        return new BotImageUploadViewModel(r1);
    }

    /* JADX INFO: renamed from: dispatchUIAction, reason: avoid collision after fix types in other method */
    public void dispatchUIAction2(w r3) {
        Intrinsics.checkNotNullParameter(r3, "uiAction");
        if ((r3 instanceof w.d) == false) goto L6;
        initData(((w.d) r3).a);
        return;
    L6:
        if ((r3 instanceof w.f) == false) goto L9;
        w.f r4 = (w.f) r3;
        onFinalImageSet(r4.a, r4.b);
        return;
    L9:
        if ((r3 instanceof w.a) == false) goto L12;
        onCheckedChange(((w.a) r3).a);
        return;
    L12:
        if ((r3 instanceof w.e) == false) goto L15;
        w.e r5 = (w.e) r3;
        onCropped(r5.a, r5.b, r5.c);
        return;
    L15:
        if (Intrinsics.areEqual(r3, w.c.a) == false) goto L18;
        onClickConfirm();
        return;
    L18:
        if (Intrinsics.areEqual(r3, w.b.a) == false) goto L22;
        onClickChangeBtn();
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // uu8.b
    public /* bridge */ /* synthetic */ void dispatchUIAction(w r1) {
        dispatchUIAction2(r1);
    }

    public static final /* synthetic */ Object access$cropAvatarFace(BotEditAvatarPreviewViewModel r0, Continuation r1) {
        return r0.cropAvatarFace(r1);
    }

    public static final /* synthetic */ void access$handleUploadFail(BotEditAvatarPreviewViewModel r0, com.larus.network.http.a r1) {
        r0.handleUploadFail(r1);
    }

    public static final /* synthetic */ Object access$interceptShowGenActionSheetForBotInfoReview(BotEditAvatarPreviewViewModel r0, Continuation r1) {
        return r0.interceptShowGenActionSheetForBotInfoReview(r1);
    }

    public static final /* synthetic */ void access$sendUIEvent(BotEditAvatarPreviewViewModel r0, x r1) {
        r0.sendUIEvent(r1);
    }

    private final void handleUploadBg(String r10, String r11) {
        FLogger.a.d(TAG, "handleUploadBg");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02121(r10, r11, this, null), 3, null);
    }

    private final void onFinalImageSet(boolean r13, boolean r14) {
        FLogger.a.i(TAG, "onFinalImageSet, isBg: " + r13 + ", isSuccess: " + r14);
        boolean r0 = false;
        if (r13 == false) goto L14;
        if (String.valueOf(((y) getUiState().getValue()).c.a).length() <= 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L23;
        if (this.bgLoadSuccess == true) goto L23;
        if (r14 == false) goto L23;
        this.bgLoadSuccess = true;
        sendUIEvent(x.e.a);
    L23:
        if (((y) getUiState().getValue()).a == true) goto L25;
        return;
    L25:
        if (String.valueOf(((y) getUiState().getValue()).b.a).length() <= 0) goto L27;
        r0 = true;
    L27:
        if (r0 == true) goto L29;
        return;
    L29:
        if (this.bgLoadSuccess == true) goto L31;
        return;
    L31:
        if (this.avatarLoadSuccess == false) goto L37;
        refreshUIState$default(this, false, null, null, 0, false, false, null, null, null, 510, null);
        return;
    L37:
        return;
    L7:
        r15 = false;
        goto L8
    L14:
        if (String.valueOf(((y) getUiState().getValue()).b.a).length() <= 0) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L23;
        if (this.avatarLoadSuccess == true) goto L23;
        if (r14 == false) goto L23;
        this.avatarLoadSuccess = true;
        goto L23
    L16:
        r16 = false;
        goto L17
    }

    private final boolean isBotAvatarOrBgImageChanged(BotModel r2, BotAvatarIconData r3, BgImage r4) {
        BotIconImage r0 = r2.getIconImage();
        if (r0 == null) goto L5;
        String r1 = r0.getUri();
    L7:
        if (Intrinsics.areEqual(r1, r3.getIconUri()) == true) goto L9;
    L15:
        return true;
    L9:
        if (Intrinsics.areEqual(r2.getBgImgUri(), r4.bgImgUri) == false) goto L15;
        BgImageInfo r5 = r2.getBgImgInfo();
        if (r5 == null) goto L13;
        boolean r6 = Intrinsics.areEqual(r5.getBgImgOpen(), Boolean.valueOf(((y) getUiState().getValue()).e));
    L14:
        if (r6 == false) goto L15;
        return false;
    L13:
        r6 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    private final void onCropped(boolean r34, Uri r35, String r36) {
        if (r35 != null) goto L5;
        FLogger.a.e(TAG, "onCropped, uri is null");
        return;
    L5:
        if (r34 == false) goto L22;
        BotAvatarIconData r14 = new BotAvatarIconData("", r35.toString(), null, null, null, 24, null);
        String r17 = r35.toString();
        String r5 = this.userBotGender;
        String r6 = this.userBotType;
        if (o0.d(r5) == false) goto L9;
        boolean r7 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"type_of_bot_character_select_male_card", "type_of_bot_character_select_female_card", "type_of_bot_character_select_header"}), r5);
    L10:
        BgImage r3 = new BgImage(null, r17, null, new BgImageInfo(null, null, null, null, Boolean.valueOf(av8.b.b(Boolean.valueOf(r7), null)), null, null, null, null, null, null, 2031, null), 5, null);
        String r1 = this.botName;
        String r4 = this.botDescription;
        String r8 = this.userBotGender;
        String r9 = this.userBotType;
        Boolean r20 = Boolean.valueOf(this.needUpdateBotInfo);
        BotModel r10 = this.botInfo;
        String r22 = getBotCreateTrace().c();
        String r23 = getBotCreateTrace().b();
        if (getBotCreateTrace().d() == false) goto L13;
        String r11 = "click_head_preview";
    L14:
        String r24 = r11;
        String r25 = r35.toString();
        if (r36 != null) goto L17;
        String r26 = r35.toString();
    L18:
        if (r36 != null) goto L20;
        String r27 = r35.toString();
    L21:
        sendUIEvent(new x.c(r14, r3, r1, r4, r8, r9, r20, r10, r22, r23, r24, r25, r26, r27, getBotCreateTrace().d()));
        return;
    L20:
        r27 = r36;
        goto L21
    L17:
        r26 = r36;
        goto L18
    L13:
        r11 = "click_create_preview";
        goto L14
    L9:
        r7 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"type_of_bot_character_select_male_card", "type_of_bot_character_select_female_card", "type_of_bot_character_select_header"}), r6);
        goto L10
    L22:
        String r2 = r35.getPath();
        boolean r12 = false;
        if (r2 != null) goto L25;
    L27:
        if (r12 == false) goto L29;
        this.hasAvatarCropped = true;
        refreshUIState$default(this, false, new z(r35), null, 0, false, false, null, null, null, 509, null);
        return;
    L29:
        this.hasBgCropped = true;
        refreshUIState$default(this, false, null, new z(r35), 0, false, false, null, null, null, 507, null);
        return;
    L25:
        if (StringsKt.contains$default(r2, "bot_edit_avatar_cropped.jpg", false, 2, null) != true) goto L27;
        r12 = true;
        goto L27
    }

    private final void handleUploadAvatar(boolean r14, String r15, String r16, String r17) {
        FLogger.a.d(TAG, "handleUploadAvatar");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02111(r15, r16, this, r17, r14, null), 3, null);
    }

    private final Object onUploadSuccess(BotModel r23, BotAvatarIconData r24, BgImage r25, Continuation<? super Unit> r26) {
        BotAvatarIconData r1 = r24;
        BgImage r2 = r25;
        if ((r26 instanceof C02161) == false) goto L7;
        C02161 r4 = (C02161) r26;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r4.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L14;
            default: goto L11;
        };
    L12:
        ub8.b r7 = (ub8.b) r4.L$2;
        r2 = (BgImage) r4.L$1;
        BotAvatarIconData r8 = (BotAvatarIconData) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L13:
        BgImage r14 = r2;
        MutableSharedFlow<Unit> r9 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
        MutableSharedFlow<Bundle> r10 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.b;
        Pair[] r11 = new Pair[5];
        r11[0] = TuplesKt.to("avatar_info", r8);
        uc9.t r12 = r7.a;
        if (r12 == null) goto L66;
        BotModel r13 = r12.b;
        if (r13 == null) goto L66;
        String r17 = r13.getBgImgColor();
    L67:
        r11[1] = TuplesKt.to("bg_image", BgImage.copy$default(r14, null, null, r17, null, 11, null));
        r11[2] = TuplesKt.to("original_user_image_uri_local", this.originalUserImgUriLocal);
        r11[3] = TuplesKt.to("original_avatar_image_uri", this.originalAvatarImgUri);
        r11[4] = TuplesKt.to("original_background_image_uri", this.originalBackgroundImgUri);
        Bundle r15 = com.larus.utils.f.c(r11);
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 6;
        if (r10.emit(r15, r4) != r6) goto L70;
        return r6;
    L70:
        sendUIEvent(x.a.a);
    L73:
        return Unit.INSTANCE;
    L66:
        r17 = null;
        goto L67
    L14:
        ResultKt.throwOnFailure(r3);
        goto L70
    L15:
        r7 = (ub8.b) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L51:
        MutableSharedFlow<Unit> r16 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
        MutableSharedFlow<Bundle> r18 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.b;
        Pair[] r19 = new Pair[1];
        uc9.t r20 = r7.a;
        if (r20 == null) goto L54;
        BotModel r21 = r20.b;
    L55:
        r19[0] = TuplesKt.to("bot_update_result", r21);
        Bundle r22 = com.larus.utils.f.c(r19);
        r4.L$0 = null;
        r4.label = 4;
        if (r18.emit(r22, r4) != r6) goto L70;
        return r6;
    L54:
        r21 = null;
        goto L55
    L16:
        r7 = (ub8.b) r4.L$2;
        r2 = (BgImage) r4.L$1;
        r8 = (BotAvatarIconData) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L33:
        if (this.needUpdateBotInfo == false) goto L58;
        String[] r27 = new String[2];
        uc9.t r28 = r7.a;
        if (r28 == null) goto L41;
        BotModel r29 = r28.b;
        if (r29 == null) goto L41;
        BotIconImage r30 = r29.getIconImage();
        if (r30 == null) goto L41;
        String r31 = r30.getOriginUrl();
    L42:
        r27[0] = r31;
        uc9.t r32 = r7.a;
        if (r32 == null) goto L47;
        BotModel r33 = r32.b;
        if (r33 == null) goto L47;
        String r34 = r33.getBgImgUrl();
    L48:
        r27[1] = r34;
        List r35 = CollectionsKt.listOf(r27);
        r4.L$0 = r7;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 3;
        if (BitmapHelperKt.f(r35, r4) != r6) goto L51;
        return r6;
    L47:
        r34 = null;
    L41:
        r31 = null;
        goto L42
    L58:
        List r36 = CollectionsKt.listOf(new String[]{r8.getIconUrl(), r2.bgImgUrl});
        r4.L$0 = r8;
        r4.L$1 = r2;
        r4.L$2 = r7;
        r4.label = 5;
        if (BitmapHelperKt.f(r36, r4) != r6) goto L13;
        return r6;
    L17:
        BgImage r37 = (BgImage) r4.L$1;
        BotAvatarIconData r38 = (BotAvatarIconData) r4.L$0;
        ResultKt.throwOnFailure(r3);
        r2 = r37;
        r1 = r38;
    L21:
        ub8.b r39 = (ub8.b) r3;
        if (r39 != null) goto L24;
    L26:
        boolean r40 = false;
    L27:
        if (r40 == false) goto L71;
        MutableSharedFlow<Unit> r41 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
        MutableSharedFlow<Unit> r42 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.c;
        Unit r110 = Unit.INSTANCE;
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.L$2 = r39;
        r4.label = 2;
        if (r42.emit(r110, r4) != r6) goto L31;
        return r6;
    L31:
        r8 = r1;
        r7 = r39;
        goto L33
    L71:
        FLogger.a.e(TAG, "updateBotAvatarAndBgImageInfo failed");
        sendUIEvent(new x.b(false));
        sendUIEvent(new x.f(new TextRes.StringResId(2131900183)));
        goto L73
    L24:
        if (true != ub8.d.a(r39)) goto L26;
        r40 = true;
        goto L27
    L18:
        ResultKt.throwOnFailure(r3);
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.label = 1;
        r3 = updateBotAvatarAndBgImageInfo(r23, r1, r2, r4);
        if (r3 != r6) goto L21;
        return r6;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r4 = new C02161(this, r26);
        goto L8
    }

    private final Object updateBotAvatarAndBgImageInfo(BotModel r9, BotAvatarIconData r10, BgImage r11, Continuation<? super ub8.b> r12) {
        if (this.needUpdateBotInfo == false) goto L10;
        if (r9 == null) goto L10;
        if (isBotAvatarOrBgImageChanged(r9, r10, r11) == false) goto L10;
        return BuildersKt.withContext(Dispatchers.getIO(), new C02182(this, r9, r10, r11, null), r12);
    L10:
        return new ub8.b(new uc9.t(true, r9), null, 6);
    }

    private final void uploadAvatarAndBg(boolean r14, String r15, String r16, String r17) {
        FLogger.a.d(TAG, "uploadAvatarAndBg");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02191(r15, r16, this, r17, r14, null), 3, null);
    }

    public static final /* synthetic */ Object access$onUploadSuccess(BotEditAvatarPreviewViewModel r0, BotModel r1, BotAvatarIconData r2, BgImage r3, Continuation r4) {
        return r0.onUploadSuccess(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$updateBotAvatarAndBgImageInfo(BotEditAvatarPreviewViewModel r0, BotModel r1, BotAvatarIconData r2, BgImage r3, Continuation r4) {
        return r0.updateBotAvatarAndBgImageInfo(r1, r2, r3, r4);
    }

    public static /* synthetic */ void handleUploadAvatar$default(BotEditAvatarPreviewViewModel r0, boolean r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.handleUploadAvatar(r1, r2, r3, r4);
    }

    public static /* synthetic */ void uploadAvatarAndBg$default(BotEditAvatarPreviewViewModel r0, boolean r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.uploadAvatarAndBg(r1, r2, r3, r4);
    }

    private final void refreshUIState(boolean r14, z r15, z r16, int r17, boolean r18, boolean r19, String r20, String r21, String r22) {
        z0<y> r1 = this._uiState;
        ((y) getUiState().getValue()).getClass();
        Intrinsics.checkNotNullParameter(r15, "avatarUri");
        Intrinsics.checkNotNullParameter(r16, "bgUri");
        r1.setValue(new y(r14, r15, r16, r17, r18, r19, r20, r21, r22));
    }

    public static final /* synthetic */ void access$refreshUIState(BotEditAvatarPreviewViewModel r0, boolean r1, z r2, z r3, int r4, boolean r5, boolean r6, String r7, String r8, String r9) {
        r0.refreshUIState(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void refreshUIState$default(BotEditAvatarPreviewViewModel r9, boolean r10, z r11, z r12, int r13, boolean r14, boolean r15, String r16, String r17, String r18, int r19, Object r20) {
        if ((r19 & 1) == 0) goto L5;
        boolean r1 = ((y) r9.getUiState().getValue()).a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        z r2 = ((y) r9.getUiState().getValue()).b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        z r3 = ((y) r9.getUiState().getValue()).c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        int r4 = ((y) r9.getUiState().getValue()).d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        boolean r5 = ((y) r9.getUiState().getValue()).e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        boolean r6 = ((y) r9.getUiState().getValue()).f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r7 = ((y) r9.getUiState().getValue()).g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r8 = ((y) r9.getUiState().getValue()).h;
    L35:
        if ((r19 & 256) == 0) goto L37;
        String r0 = ((y) r9.getUiState().getValue()).i;
    L38:
        r9.refreshUIState(r1, r2, r3, r4, r5, r6, r7, r8, r0);
        return;
    L37:
        r0 = r18;
        goto L38
    L33:
        r8 = r17;
        goto L35
    L29:
        r7 = r16;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
