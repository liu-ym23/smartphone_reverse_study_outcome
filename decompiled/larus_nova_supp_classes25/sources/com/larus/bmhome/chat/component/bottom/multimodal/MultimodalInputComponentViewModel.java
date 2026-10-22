package com.larus.bmhome.chat.component.bottom.multimodal;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.api.AppreciableTraceDelegate;
import com.larus.bmhome.chat.api.IAppreciableTraceService;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.preprocess.SendResourcePreprocessManager;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.utils.RegisterHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.model.action.PromptReplacementCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0015\u0018\u00010!H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020&H\u0002J\u0016\u0010+\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0002J.\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&H\u0002J\u009e\u0001\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002012\u0006\u00109\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010&2\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150!0!2\u0016\b\u0002\u0010;\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0013\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0006Jv\u0010F\u001a\u00020\u00152\u0006\u00108\u001a\u0002012\u0006\u0010G\u001a\u00020H2\b\u0010:\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020&2\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150!0!2\u0016\b\u0002\u0010;\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010<2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0006J\u0010\u0010I\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewState;", "<init>", "()V", "uploadProcessConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "repo", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "reader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "getReader", "()Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "handleUploadResultCode", "", "param", "Lcom/larus/bmhome/chat/component/bottom/multimodal/TryUploadFileOrImgParam;", "(Lcom/larus/bmhome/chat/component/bottom/multimodal/TryUploadFileOrImgParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageStatusLocal", "", "prepareUploadImageMsgNew", "", "handleUploadImageAfterAddMsgSuccess", "resourceUploadResult", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "uploadContext", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModel$UploadContext;", "isImgMsg", "handleUploadImageAfterAddMsgFailure", "resourceUploadError", "Lcom/larus/platform/model/upload/ResourceUploadError;", "uploadImageAfterAddMsg", "processCallback", "Lkotlin/Function1;", "Lcom/larus/platform/model/upload/ResourceUploadProgressResult;", "uploadImageMsgNew", "uploadSingleQuestionImagesInParallel", "originPath", "", "resolveUploadResourceScene", "Lcom/larus/bmhome/rc/FlowResourceScene;", "isImage", "fromScene", "tryUploadFileOrImg", "uploadImageMsgFailed", "msg", "Lcom/larus/im/bean/message/Message;", "sendMediaMessage", "conversationLiveData", "Lcom/larus/im/bean/conversation/Conversation;", "strategies", "", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "msgId", "scene", "onTakePictureSuccess", "conversation", "path", "botId", "ext", "", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "inputContent", "Lkotlin/Pair;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "processConfig", "onPickImageSuccess", "uri", "Landroid/net/Uri;", "setUploadProcessConfig", "Companion", "UploadContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MultimodalInputComponentViewModel extends ComponentViewModel<MultimodalInputComponentViewState> {
    public static final a Companion = null;
    private static final String TAG = "MultimodalInputComponentViewModel";
    private final IChatRepoService repo;
    private ns8.b uploadProcessConfig;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final j1 a;
        public final ic8.w b;
        public final Message c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "UploadContext(param=" + this.a + ", prepareStrategy=" + this.b + ", result=" + this.c + ')';
        }

        public b(j1 r2, ic8.w r3, Message r4) {
            Intrinsics.checkNotNullParameter(r2, "param");
            Intrinsics.checkNotNullParameter(r3, "prepareStrategy");
            Intrinsics.checkNotNullParameter(r4, "result");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$handleUploadResultCode$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel", f = "MultimodalInputComponentViewModel.kt", i = {0, 1}, l = {85, MessageCellStateTransformerType.MSG_SEND_ENTITY}, m = "handleUploadResultCode", n = {"$this$handleUploadResultCode_u24lambda_u240", "$this$handleUploadResultCode_u24lambda_u240"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MultimodalInputComponentViewModel this$0;

        public AnonymousClass1(MultimodalInputComponentViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MultimodalInputComponentViewModel.access$handleUploadResultCode(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$onPickImageSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$onPickImageSuccess$1", f = "MultimodalInputComponentViewModel.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ ChatPageContext $chatPageContext;
        final /* synthetic */ wc9.e $conversation;
        final /* synthetic */ Map<String, String> $ext;
        final /* synthetic */ String $fileIdentifier;
        final /* synthetic */ Function1<Message, Function1<mr9.k, Unit>> $processCallback;
        final /* synthetic */ ns8.b $processConfig;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ MultimodalInputComponentViewModel this$0;

        public C01471(Uri r1, ns8.b r2, wc9.e r3, String r4, String r5, Function1<? super Message, ? extends Function1<? super mr9.k, Unit>> r6, Map<String, String> r7, ChatPageContext r8, MultimodalInputComponentViewModel r9, Continuation<? super C01471> r10) {
            this.$uri = r1;
            this.$processConfig = r2;
            this.$conversation = r3;
            this.$botId = r4;
            this.$fileIdentifier = r5;
            this.$processCallback = r6;
            this.$ext = r7;
            this.$chatPageContext = r8;
            this.this$0 = r9;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            return new C01471(this.$uri, this.$processConfig, this.$conversation, this.$botId, this.$fileIdentifier, this.$processCallback, this.$ext, this.$chatPageContext, this.this$0, r13);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r24) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r24);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r24);
            ic8.n0 r13 = b$a.b(SendResourcePreprocessManager.a, this.$uri, false, null, null, this.$processConfig, 44);
            j1 r3 = new j1(this.$conversation, r13, "album", this.$botId, this.$fileIdentifier, this.$processCallback, this.$ext, null, null, null, this.$chatPageContext);
            MultimodalInputComponentViewModel r4 = this.this$0;
            this.label = 1;
            if (MultimodalInputComponentViewModel.access$tryUploadFileOrImg(r4, r3, this) != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$onTakePictureSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$onTakePictureSuccess$1", f = "MultimodalInputComponentViewModel.kt", i = {}, l = {740}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ ChatPageContext $chatPageContext;
        final /* synthetic */ wc9.e $conversation;
        final /* synthetic */ Map<String, String> $ext;
        final /* synthetic */ String $fileIdentifier;
        final /* synthetic */ Pair<String, Integer> $inputContent;
        final /* synthetic */ String $path;
        final /* synthetic */ Function1<Message, Function1<mr9.k, Unit>> $processCallback;
        final /* synthetic */ ns8.b $processConfig;
        final /* synthetic */ ReferenceInfo $referenceInfo;
        final /* synthetic */ SuggestedAction $suggestedAction;
        int label;
        final /* synthetic */ MultimodalInputComponentViewModel this$0;

        public C01481(Map<String, String> r1, String r2, ns8.b r3, wc9.e r4, String r5, String r6, Function1<? super Message, ? extends Function1<? super mr9.k, Unit>> r7, SuggestedAction r8, Pair<String, Integer> r9, ReferenceInfo r10, ChatPageContext r11, MultimodalInputComponentViewModel r12, Continuation<? super C01481> r13) {
            this.$ext = r1;
            this.$path = r2;
            this.$processConfig = r3;
            this.$conversation = r4;
            this.$botId = r5;
            this.$fileIdentifier = r6;
            this.$processCallback = r7;
            this.$suggestedAction = r8;
            this.$inputContent = r9;
            this.$referenceInfo = r10;
            this.$chatPageContext = r11;
            this.this$0 = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
            return new C01481(this.$ext, this.$path, this.$processConfig, this.$conversation, this.$botId, this.$fileIdentifier, this.$processCallback, this.$suggestedAction, this.$inputContent, this.$referenceInfo, this.$chatPageContext, this.this$0, r18);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r35) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r35);
        L47:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r35);
            VLMUploadDowngradeData r3 = p.b();
            z2 r4 = z2.a;
            oq9.b r5 = r4.getAppImageUploadConfig();
            String r7 = null;
            if (r3 == null) goto L20;
            Integer r8 = r3.getVlmResolution();
            if (r8 == null) goto L20;
            if (r8.intValue() <= 0) goto L15;
            boolean r9 = true;
        L16:
            if (r9 == true) goto L19;
            r8 = null;
        L19:
            if (r8 == null) goto L20;
        L21:
            Integer r10 = r8;
            if (r3 == null) goto L33;
            Integer r6 = r3.getVlmQuality();
            if (r6 == null) goto L33;
            if (r6.intValue() <= 0) goto L28;
            boolean r11 = true;
        L29:
            if (r11 == true) goto L32;
            r6 = null;
        L32:
            if (r6 == null) goto L33;
        L34:
            ns8.a r19 = new ns8.a(r10, null, r6, null, true, 232);
            Map<String, String> r12 = this.$ext;
            if (r12 == null) goto L38;
            r7 = r12.get("Copilot:hippo:hippo_ext");
        L38:
            if (com.larus.utils.o0.d(r7) == true) goto L40;
        L42:
            boolean r21 = false;
        L43:
            j1 r13 = new j1(this.$conversation, SendResourcePreprocessManager.a.f(this.$path, false, r19, this.$processConfig, r21), "shoot", this.$botId, this.$fileIdentifier, this.$processCallback, this.$ext, this.$suggestedAction, this.$inputContent, this.$referenceInfo, this.$chatPageContext);
            MultimodalInputComponentViewModel r14 = this.this$0;
            this.label = 1;
            if (MultimodalInputComponentViewModel.access$tryUploadFileOrImg(r14, r13, this) != r1) goto L47;
            return r1;
        L40:
            if (Intrinsics.areEqual(r4.preprocessAlbumImgOptConfig().d(), Boxing.boxBoolean(true)) == true) goto L42;
            r21 = true;
            goto L43
        L28:
            r11 = false;
        L33:
            r6 = r5.c();
            goto L34
        L15:
            r9 = false;
        L20:
            r8 = r5.b();
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$sendMediaMessage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$sendMediaMessage$1", f = "MultimodalInputComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultimodalInputComponentViewModel this$0;

        public C01491(MultimodalInputComponentViewModel r1, Continuation<? super C01491> r2) {
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MultimodalInputComponentViewModel.access$getReader(this.this$0).i6("MultimodalInputComponentViewModel sendMediaMessage", false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$tryUploadFileOrImg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel", f = "MultimodalInputComponentViewModel.kt", i = {0, 0}, l = {640}, m = "tryUploadFileOrImg", n = {"param", "$this$tryUploadFileOrImg_u24lambda_u2442"}, s = {"L$0", "L$1"})
    public static final class C01501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MultimodalInputComponentViewModel this$0;

        public C01501(MultimodalInputComponentViewModel r1, Continuation<? super C01501> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MultimodalInputComponentViewModel.access$tryUploadFileOrImg(this.this$0, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit No(b r0, MultimodalInputComponentViewModel r1, mr9.l r2) {
        return uploadImageMsgNew$lambda$26$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ Unit Oo(MultimodalInputComponentViewModel r0, b r1, ResourceUploadError r2) {
        return uploadImageAfterAddMsg$lambda$20$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit Po(b r0, mr9.k r1) {
        return uploadImageMsgNew$lambda$26$lambda$22$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit Qo(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, Ref.LongRef r4, Ref.LongRef r5, Ref.ObjectRef r6, Ref.LongRef r7, b r8, mr9.k r9) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$36(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit So(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, Ref.LongRef r4, Ref.ObjectRef r5, Ref.LongRef r6, b r7, MultimodalInputComponentViewModel r8, mr9.l r9) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$35(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit To(MultimodalInputComponentViewModel r0, b r1, ResourceUploadError r2) {
        return uploadImageMsgNew$lambda$26$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ Unit Wo(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, Ref.LongRef r4, Ref.ObjectRef r5, Ref.LongRef r6, b r7, MultimodalInputComponentViewModel r8, mr9.l r9) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$38(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit Yo(Function1 r0, ResourceUploadError r1) {
        return uploadImageAfterAddMsg$lambda$20$lambda$19(r0, r1);
    }

    public static /* synthetic */ Unit Zo(Function1 r0, ResourceUploadError r1) {
        return uploadImageMsgNew$lambda$26$lambda$25(r0, r1);
    }

    public static /* synthetic */ Unit ap(MultimodalInputComponentViewModel r0, b r1, mr9.l r2) {
        return uploadImageAfterAddMsg$lambda$20$lambda$17(r0, r1, r2);
    }

    public static /* synthetic */ Unit bp(Object r0, b r1, Ref.BooleanRef r2, Ref.BooleanRef r3, Ref.ObjectRef r4, MultimodalInputComponentViewModel r5, ResourceUploadError r6) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$37(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit cp(Object r0, b r1, MultimodalInputComponentViewModel r2, Ref.BooleanRef r3, Ref.ObjectRef r4, ResourceUploadError r5) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$40(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit dp(b r0, mr9.k r1) {
        return uploadImageMsgNew$lambda$26$lambda$24(r0, r1);
    }

    public static /* synthetic */ Unit ep(j1 r0, ic8.w r1, MultimodalInputComponentViewModel r2, Message r3) {
        return prepareUploadImageMsgNew$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit hp(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, Ref.LongRef r4, Ref.LongRef r5, Ref.ObjectRef r6, Ref.LongRef r7, b r8, mr9.k r9) {
        return uploadSingleQuestionImagesInParallel$lambda$41$lambda$39(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private final int getMessageStatusLocal() {
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L5;
        return 0;
    L5:
        return 12;
    }

    private final x1 getReader() {
        return this.repo.getReceiver().c();
    }

    public MultimodalInputComponentViewModel() {
        IChatRepoService r0 = zh8.a.a;
        this.repo = zh8.a.a;
    }

    public static final /* synthetic */ x1 access$getReader(MultimodalInputComponentViewModel r0) {
        return r0.getReader();
    }

    private final void prepareUploadImageMsgNew(final j1 r40) {
        int r2 = getMessageStatusLocal();
        if (r40.c == false) goto L12;
        ic8.m0 r12 = r40.b.a;
        if (r12 == null) goto L10;
        String r13 = r12.e;
        if (r13 == null) goto L10;
        String r14 = r13;
    L11:
        final ic8.w r3 = new ai8.e(r14, null, null, null, null, null, null, null, r40.h, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("loading", "1"), TuplesKt.to("progress", "0")}), false, r40.l, null, null, 27134);
    L23:
        String r4 = com.larus.bmhome.chat.trace.g0.a;
        com.larus.bmhome.chat.trace.g0.d = System.currentTimeMillis();
        this.repo.getSender().d(r40.a.a, r2, r3, new t0(r40, r3, this));
        return;
    L10:
        r14 = "";
        goto L11
    L12:
        ic8.m0 r15 = r40.b.a;
        if (r15 == null) goto L18;
        String r16 = r15.e;
        if (r16 == null) goto L18;
        String r29 = r16;
    L19:
        if (r15 == null) goto L21;
        String r11 = r15.b;
    L22:
        r3 = new ai8.d(r29, r11, null, null, null, null, r40.h, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("loading", "1"), TuplesKt.to("progress", "0")}), r40.l, 316);
        goto L23
    L21:
        r11 = null;
    L18:
        r29 = "";
        goto L19
    }

    private final void uploadImageMsgFailed(Message r2) {
        this.repo.getSender().w(r2);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.bmhome.chat.component.bottom.multimodal.q0] */
    private final void uploadImageMsgNew(final b r19) {
        com.larus.bmhome.chat.helper.n0 r2 = com.larus.bmhome.chat.helper.n0.a;
        Map<String, String> r3 = r19.a.h;
        r2.getClass();
        String r11 = com.larus.bmhome.chat.helper.n0.h(r3);
        j1 r4 = r19.a;
        boolean r5 = false;
        if (r4.c == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L19:
        boolean r7 = false;
    L20:
        FLogger r8 = FLogger.a;
        r8.i(TAG, "[uploadImageMsgNew] isSingleQuestion:" + r6 + ", uploadSingleOriginImage:" + r7 + ", fileIdentifier:" + r19.a.f);
        if (r7 == false) goto L25;
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        uploadSingleQuestionImagesInParallel(r19, r11);
        return;
    L25:
        r8.i(TAG, "[uploadImageMsgNew] originPath:" + r11 + ", fileIdentifier:" + r19.a.f);
        if (r11 != null) goto L28;
    L29:
        r5 = true;
    L30:
        if (r5 == true) goto L34;
        if (r6 == true) goto L34;
        Function1 r9 = new p0(r19, this);
        final ?? r10 = new q0(this, r19);
        Function1 r12 = new r0(r19);
        r8.i(TAG, "uploadImageMsgNew, upload origin path = " + r11);
        u1 r13 = this.repo.getSender();
        UploadDataType r14 = UploadDataType.IMAGE;
        Function1 r15 = new s0(r10);
        Boolean r16 = Boolean.valueOf(com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.b(r11));
        j1 r17 = r19.a;
        u1$a.h(r13, r11, null, r14, r9, r12, r15, r11, r16, null, r17.f, resolveUploadResourceScene(true, r17.d), r19.a.d, 1216);
        return;
    L34:
        r8.d(TAG, "uploadImageMsgNew, perform uploadImageAfterAddMsg()");
        uploadImageAfterAddMsg$default(this, r19, null, 2, null);
        return;
    L28:
        if (StringsKt.isBlank(r11) == false) goto L30;
    L10:
        if (z2.a.eduUploadOriginImage() == false) goto L19;
        if (r11 != null) goto L13;
    L16:
        boolean r18 = true;
    L17:
        if (r18 == true) goto L19;
        r7 = true;
        goto L20
    L13:
        if (StringsKt.isBlank(r11) == true) goto L16;
        r18 = false;
        goto L17
    L5:
        if (com.larus.bmhome.chat.helper.n0.g(r4.h) == false) goto L7;
        r6 = true;
        goto L8
    }

    public final void setUploadProcessConfig(ns8.b r1) {
        this.uploadProcessConfig = r1;
    }

    private final void handleUploadImageAfterAddMsgFailure(ResourceUploadError r9, b r10) {
        String r0 = r10.c.getLocalMessageId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        AppreciableTraceDelegate r1 = AppreciableTraceDelegate.b;
        j1 r2 = r10.a;
        String r3 = r2.d;
        if (r2.c == false) goto L8;
        int r4 = 6;
    L9:
        IAppreciableTraceService.a.a(r1, r0, r3, r4, null, 1, 8);
        String r5 = r9.getCode();
        if (Intrinsics.areEqual(r5, "upload_get_auth_token_error") == false) goto L13;
        ProcessFileResultCode r6 = ProcessFileResultCode.UPLOAD_GET_AUTH_TOKEN_ERROR;
    L16:
        int r7 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r10.a.f, r6, null, 12);
        FLogger.a.w(TAG, "tryUploadFileOrImg uploadImg for #" + r0 + " failed, err:" + r9);
        uploadImageMsgFailed(r10.c);
        return;
    L13:
        if (Intrinsics.areEqual(r5, "no_network") == false) goto L15;
        r6 = ProcessFileResultCode.UPLOAD_NO_NETWORK;
        goto L16
    L15:
        r6 = ProcessFileResultCode.UPLOAD_IMAGEX_ERROR;
        goto L16
    L8:
        r4 = 7;
        goto L9
    }

    private final Object handleUploadResultCode(j1 r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r9 = (j1) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L28:
        int r12 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r13 = r9.f;
        ic8.n0 r14 = r9.b;
        com.larus.bmhome.chat.trace.multimodal.a.c(r13, r14.b, r14.a, 8);
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (j1) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        int r15 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r16 = r9.f;
        ic8.n0 r17 = r9.b;
        com.larus.bmhome.chat.trace.multimodal.a.c(r16, r17.b, r17.a, 8);
        return Boxing.boxBoolean(true);
    L16:
        ResultKt.throwOnFailure(r11);
        ProcessFileResultCode r18 = r9.b.b;
        if (r18 != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L24;
        FLogger.a.w(TAG, "tryUploadFileOrImg ProcessResult for OverSize");
        MainCoroutineDispatcher r19 = Dispatchers.getMain();
        MultimodalInputComponentViewModel$handleUploadResultCode$2$1 r4 = new MultimodalInputComponentViewModel$handleUploadResultCode$2$1(r9, null);
        r0.L$0 = r9;
        r0.label = 1;
        if (BuildersKt.withContext(r19, r4, r0) != r2) goto L21;
        return r2;
    L24:
        if (r18 != ProcessFileResultCode.PREPARE_TYPE_NO_MATCH) goto L31;
        FLogger.a.w(TAG, "tryUploadFileOrImg ProcessResult for not support type");
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        MultimodalInputComponentViewModel$handleUploadResultCode$2$2 r5 = new MultimodalInputComponentViewModel$handleUploadResultCode$2$2(null);
        r0.L$0 = r9;
        r0.label = 2;
        if (BuildersKt.withContext(r110, r5, r0) != r2) goto L28;
        return r2;
    L31:
        if (r18 != null) goto L33;
    L35:
        boolean r111 = false;
    L36:
        if (r111 == true) goto L40;
        FLogger.a.w(TAG, "tryUploadFileOrImg ProcessResult for not Success, error msg: " + r9.b.b);
        int r112 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r113 = r9.f;
        ic8.n0 r20 = r9.b;
        com.larus.bmhome.chat.trace.multimodal.a.c(r113, r20.b, r20.a, 8);
        return Boxing.boxBoolean(true);
    L40:
        return Boxing.boxBoolean(false);
    L33:
        if (r18.isSuccess() != true) goto L35;
        r111 = true;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final FlowResourceScene resolveUploadResourceScene(boolean r1, String r2) {
        if (r1 == true) goto L6;
        return FlowResourceScene.FileUpload;
    L6:
        if (Intrinsics.areEqual(r2, "shoot_ocr") == true) goto L12;
        if (Intrinsics.areEqual(r2, "album_ocr") == true) goto L12;
        return FlowResourceScene.ImageVLM;
    L12:
        return FlowResourceScene.ImageOCR;
    }

    private final Object tryUploadFileOrImg(j1 r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C01501) == false) goto L7;
        C01501 r0 = (C01501) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (j1) r0.L$1;
        j1 r5 = (j1) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        if (((Boolean) r9).booleanValue() == true) goto L21;
        ns8.b r10 = this.uploadProcessConfig;
        if (r10 != null) goto L25;
    L27:
        r4 = false;
    L28:
        if (r4 == false) goto L31;
        FLogger.a.i(TAG, "[tryUploadFileOrImg] skipUpload=true, stop after preprocess");
        return Unit.INSTANCE;
    L31:
        int r11 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.a(r7.f, r7.b.a);
        prepareUploadImageMsgNew(r5);
        return Unit.INSTANCE;
    L25:
        if (r10.c != true) goto L27;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i(TAG, "[tryUploadFileOrImg], ProcessResult: " + r7.b);
        r0.L$0 = r7;
        r0.L$1 = r7;
        r0.label = 1;
        r9 = handleUploadResultCode(r7, r0);
        if (r9 != r2) goto L17;
        return r2;
    L17:
        r5 = r7;
    L7:
        r0 = new C01501(this, r8);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.chat.component.bottom.multimodal.b1] */
    private final void uploadImageAfterAddMsg(final b r19, Function1<? super mr9.k, Unit> r20) {
        Function1 r5 = new a1(this, r19);
        final ?? r2 = new b1(this, r19);
        FLogger.a.i(TAG, "[uploadImageMsgNew] fileIdentifier:" + r19.a.f);
        u1 r3 = this.repo.getSender();
        j1 r4 = r19.a;
        ic8.m0 r6 = r4.b.a;
        if (r6 == null) goto L6;
        String r7 = r6.e;
        if (r7 == null) goto L6;
    L7:
        mr9.c r8 = null;
        if (r4.c == true) goto L14;
        if (r6 == null) goto L14;
        String r9 = r6.b;
        if (r9 == null) goto L14;
        String r10 = StringsKt.substringAfterLast$default(r9, '.', null, 2, null);
    L15:
        j1 r11 = r19.a;
        if (r11.c == false) goto L18;
        UploadDataType r12 = UploadDataType.IMAGE;
    L19:
        if (r20 != null) goto L21;
        Function1<? super mr9.k, Unit> r13 = (Function1) r11.g.invoke(r19.c);
    L22:
        Function1 r14 = new c1(r2);
        ic8.m0 r15 = r19.a.b.a;
        if (r15 == null) goto L25;
        String r16 = r15.a;
    L26:
        int r17 = com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.a;
        if (r15 == null) goto L29;
        String r18 = r15.a;
    L30:
        Boolean r110 = Boolean.valueOf(com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.b(r18));
        j1 r21 = r19.a;
        ic8.m0 r111 = r21.b.a;
        if (r111 == null) goto L33;
        r8 = r111.l;
    L33:
        u1$a.h(r3, r7, r10, r12, r5, r13, r14, r16, r110, r8, r21.f, resolveUploadResourceScene(r21.c, r21.d), r19.a.d, 192);
        return;
    L29:
        r18 = null;
        goto L30
    L25:
        r16 = null;
        goto L26
    L21:
        r13 = r20;
        goto L22
    L18:
        r12 = UploadDataType.FILE;
    L14:
        r10 = null;
    L6:
        r7 = "";
        goto L7
    }

    private static final Unit uploadImageAfterAddMsg$lambda$20$lambda$19(Function1 r1, ResourceUploadError r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    private static final Unit uploadImageMsgNew$lambda$26$lambda$22$lambda$21(b r5, mr9.k r6) {
        Intrinsics.checkNotNullParameter(r6, "uploadResult");
        Function1 r7 = (Function1) r5.a.g.invoke(r5.c);
        Long r8 = r6.a;
        if (r8 == null) goto L5;
        Long r9 = Long.valueOf((r8.longValue() / ((long) 2)) + ((long) 50));
    L6:
        r7.invoke(new mr9.k(r9, false));
        return Unit.INSTANCE;
    L5:
        r9 = null;
        goto L6
    }

    private static final Unit uploadImageMsgNew$lambda$26$lambda$24(b r5, mr9.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Function1 r7 = (Function1) r5.a.g.invoke(r5.c);
        Long r8 = r6.a;
        if (r8 == null) goto L5;
        Long r9 = Long.valueOf(r8.longValue() / ((long) 2));
    L6:
        r7.invoke(new mr9.k(r9, false));
        return Unit.INSTANCE;
    L5:
        r9 = null;
        goto L6
    }

    private static final Unit uploadImageMsgNew$lambda$26$lambda$25(Function1 r1, ResourceUploadError r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    private final void uploadSingleQuestionImagesInParallel(final b r38, String r39) {
        final Object r12 = new Object();
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        final Ref.LongRef r16 = new Ref.LongRef();
        final Ref.LongRef r17 = new Ref.LongRef();
        final Ref.LongRef r18 = new Ref.LongRef();
        final Ref.BooleanRef r19 = new Ref.BooleanRef();
        FLogger.a.i(TAG, "[uploadSingleQuestionImagesInParallel] start, fileIdentifier:" + r38.a.f);
        u1 r20 = this.repo.getSender();
        UploadDataType r34 = UploadDataType.IMAGE;
        u1$a.h(r20, r39, null, r34, new u0(r12, r19, r15, r13, r16, r14, r17, r38, this), new v0(r12, r19, r15, r14, r16, r17, r13, r18, r38), new w0(r12, r38, r19, r15, r14, this), r39, Boolean.valueOf(com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.b(r39)), null, r38.a.f + "_origin", resolveUploadResourceScene(true, r38.a.d), r38.a.d, 1216);
        u1 r23 = this.repo.getSender();
        ic8.m0 r8 = r38.a.b.a;
        if (r8 == null) goto L5;
        String r0 = r8.e;
    L6:
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        String r24 = r0;
        Function1 r27 = new x0(r12, r19, r15, r13, r16, r14, r17, r38, this);
        Function1 r28 = new y0(r12, r19, r15, r14, r16, r17, r13, r18, r38);
        Function1 r29 = new z0(r12, r38, this, r19, r14);
        if (r8 == null) goto L11;
        String r30 = r8.a;
    L12:
        if (r8 == null) goto L14;
        String r1 = r8.a;
    L15:
        Boolean r31 = Boolean.valueOf(com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.b(r1));
        j1 r2 = r38.a;
        ic8.m0 r3 = r2.b.a;
        if (r3 == null) goto L18;
        mr9.c r32 = r3.l;
    L19:
        u1$a.h(r23, r24, null, r34, r27, r28, r29, r30, r31, r32, r2.f, resolveUploadResourceScene(true, r2.d), r38.a.d, 192);
        return;
    L18:
        r32 = null;
        goto L19
    L14:
        r1 = null;
        goto L15
    L11:
        r30 = null;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ Object access$handleUploadResultCode(MultimodalInputComponentViewModel r0, j1 r1, Continuation r2) {
        return r0.handleUploadResultCode(r1, r2);
    }

    public static final /* synthetic */ Object access$tryUploadFileOrImg(MultimodalInputComponentViewModel r0, j1 r1, Continuation r2) {
        return r0.tryUploadFileOrImg(r1, r2);
    }

    private final void handleUploadImageAfterAddMsgSuccess(mr9.l r37, b r38, boolean r39) {
        String r3 = r37.a;
        if (r3 != null) goto L5;
        String r8 = "";
    L6:
        ic8.m0 r4 = r38.a.b.a;
        if (r4 == null) goto L9;
        r4.h = r8;
    L9:
        String r5 = r38.c.getLocalMessageId();
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        AppreciableTraceDelegate r6 = AppreciableTraceDelegate.b;
        j1 r7 = r38.a;
        String r9 = r7.a.a;
        String r10 = r7.d;
        if (r7.c == false) goto L15;
        int r11 = 6;
    L16:
        r6.c(r5, r9, r10, r11);
        String r12 = r38.a.d;
        String r13 = "shoot";
        String r21 = null;
        if (Intrinsics.areEqual(r12, "shoot") == false) goto L27;
        Map<String, String> r14 = r38.a.h;
        if (r14 == null) goto L22;
        String r15 = r14.get("camera_data_source");
        if (r15 == null) goto L22;
    L24:
        if (Intrinsics.areEqual(r15, "1") == true) goto L31;
    L33:
        if (r13 == null) goto L35;
        LruCache r16 = ko8.a.a;
        String r17 = (String) IAIChatControlTraceService.a.eb().put(r5, r13);
    L35:
        Pair<String, Integer> r18 = r38.a.j;
        if (r18 != null) goto L38;
    L40:
        boolean r19 = false;
    L41:
        FLogger r20 = FLogger.a;
        r20.i(TAG, "[handleUploadImageAfterAddMsgSuccess] uploadImg for #" + r5 + " success, tosKey:" + r8 + ", hasValidCameraInputText:" + r19 + ", contentSource:" + r13);
        int r22 = MultimodalSendCostTrace.a;
        j1 r23 = r38.a;
        MultimodalSendCostTrace.d(r23.f, r23.b.a);
        String r24 = com.larus.bmhome.chat.trace.g0.a;
        ic8.m0 r25 = r38.a.b.a;
        if (r25 == null) goto L44;
        long r110 = r25.c;
    L45:
        com.larus.bmhome.chat.trace.g0.a(r39, r110);
        String r26 = UUID.randomUUID().toString();
        IAIChatService.Companion r111 = IAIChatService.a;
        if (r38.a.a.i == false) goto L48;
        Object r112 = "1";
    L49:
        Map r113 = MapsKt.toMutableMap(r111.A7(TuplesKt.to("tts", r112)));
        Map<String, String> r27 = r38.a.h;
        if (r27 == null) goto L53;
        r113.putAll(r27);
    L53:
        if (r38.a.i != null) goto L55;
        if (r19 == true) goto L55;
    L67:
        r20.d(TAG, "uploadImg for #" + r5 + " success, tosKey:" + r8);
        ArrayList r114 = new ArrayList();
        Map r28 = r38.c.getBusinessExt();
        if (r28 != null) goto L70;
        r28 = new LinkedHashMap();
    L70:
        Map r115 = com.larus.utils.h.c(r28, new Pair[]{TuplesKt.to("send_loading", "1"), TuplesKt.to("loading", "0"), TuplesKt.to("progress", "0")});
        if (r39 == false) goto L88;
        ic8.m0 r29 = r38.a.b.a;
        if (r29 == null) goto L78;
        String r30 = r29.e;
        if (r30 == null) goto L78;
        String r31 = r30;
    L79:
        mr9.d r32 = r37.d;
        if (r32 == null) goto L82;
        int r33 = r32.a;
    L83:
        Integer r116 = Integer.valueOf(r33);
        mr9.d r34 = r37.d;
        if (r34 == null) goto L86;
        int r35 = r34.b;
    L87:
        String r36 = "";
        Map r210 = r113;
        ic8.w r40 = new ai8.e(r31, r8, r116, Integer.valueOf(r35), r37.c, null, r38.c.getLocalMessageId(), com.larus.bmhome.chat.bean.d.b1(r38.c), r210, r115, false, r38.a.l, null, null, 26720);
    L97:
        r114.add(r40);
        SuggestedAction r41 = r38.a.i;
        if (r41 == null) goto L132;
        LruCache r42 = ko8.a.a;
        Map r43 = r41.getEventExtra();
        if (r43 == null) goto L102;
        String r44 = (String) r43.get("onboarding_item_id");
    L103:
        Intrinsics.checkNotNullParameter(r5, "msgId");
        IAIChatControlTraceService.Companion r117 = IAIChatControlTraceService.a;
        r117.qb(r5, r44);
        Map r45 = r38.a.i.getEventExtra();
        if (r45 == null) goto L106;
        String r46 = (String) r45.get("item_type");
    L107:
        Intrinsics.checkNotNullParameter(r5, "msgId");
        r117.Ga(r5, r46);
        Map r47 = r38.a.i.getEventExtra();
        if (r47 == null) goto L110;
        String r48 = (String) r47.get("reco_request_id");
    L111:
        Intrinsics.checkNotNullParameter(r5, "msgId");
        r117.Oa(r5, r48);
        int r49 = wf9.b.a;
        String r50 = com.flow.kmp.common.util.i.a();
        String r51 = r38.a.i.getDisplayName();
        if (r51 != null) goto L114;
        String r211 = r36;
    L115:
        LinkedHashMap r52 = new LinkedHashMap();
        r52.put("send_loading", "1");
        j1 r2 = r38.a;
        r114.add(new ai8.h(r211, r50, null, r2.k, r210, r52, false, false, r2.l, null, 708));
        Map r53 = r38.a.i.getEventExtra();
        if (r53 == null) goto L118;
        String r54 = (String) r53.get("onboarding_item_id");
    L119:
        Intrinsics.checkNotNullParameter(r50, "msgId");
        r117.qb(r50, r54);
        Map r55 = r38.a.i.getEventExtra();
        if (r55 == null) goto L122;
        String r56 = (String) r55.get("item_type");
    L123:
        Intrinsics.checkNotNullParameter(r50, "msgId");
        r117.Ga(r50, r56);
        Map r57 = r38.a.i.getEventExtra();
        if (r57 == null) goto L126;
        r21 = (String) r57.get("reco_request_id");
    L126:
        Intrinsics.checkNotNullParameter(r50, "msgId");
        r117.Oa(r50, r21);
        Map r58 = r38.a.i.getEventExtra();
        if (r58 == null) goto L157;
        String r59 = (String) r58.get("sug_scene");
        if (r59 == null) goto L157;
        Intrinsics.checkNotNullParameter(r50, "taskId");
        Intrinsics.checkNotNullParameter(r59, "scene");
        r117.Ma(r50, r59);
    L157:
        String r118 = r37.a;
        if (r118 == null) goto L160;
        int r60 = RegisterHelper.a;
        String r61 = r38.c.getLocalMessageId();
        j1 r62 = r38.a;
        RegisterHelper.c(r61, r62.e, r62.a.a, r118, r62.f, r37.g, null, null, 400);
    L160:
        wc9.e r0 = r38.a.a;
        String r63 = r38.c.getLocalMessageId();
        if (r63 != null) goto L163;
        r63 = r36;
    L163:
        SuggestedAction r64 = r38.a.i;
        if (r64 == null) goto L169;
        Map r65 = r64.getEventExtra();
        if (r65 == null) goto L169;
        String r66 = (String) r65.get("scene");
        if (r66 == null) goto L169;
    L170:
        sendMediaMessage(r0, r114, r63, r66);
        return;
    L169:
        r66 = r38.a.d;
        goto L170
    L122:
        r56 = null;
        goto L123
    L118:
        r54 = null;
        goto L119
    L114:
        r211 = r51;
        goto L115
    L110:
        r48 = null;
        goto L111
    L106:
        r46 = null;
        goto L107
    L102:
        r44 = null;
        goto L103
    L132:
        if (r19 == false) goto L157;
        int r67 = wf9.b.a;
        String r68 = com.flow.kmp.common.util.i.a();
        Pair<String, Integer> r69 = r38.a.j;
        if (r69 == null) goto L136;
        String r70 = (String) r69.getFirst();
    L137:
        if (r70 != null) goto L139;
        String r212 = r36;
    L140:
        LinkedHashMap r71 = new LinkedHashMap();
        r71.put(r10, "1");
        j1 r72 = r38.a;
        r114.add(new ai8.h(r212, r68, null, r72.k, r210, r71, false, false, r72.l, null, 708));
        Pair<String, Integer> r73 = r38.a.j;
        if (r73 == null) goto L143;
        Integer r74 = (Integer) r73.getSecond();
    L144:
        if (r74 != null) goto L147;
    L150:
        if (r74 != null) goto L153;
    L149:
        String r75 = r21;
        if (r75 == null) goto L157;
        LruCache r76 = ko8.a.a;
        Intrinsics.checkNotNullParameter(r68, "taskId");
        Intrinsics.checkNotNullParameter(r75, "scene");
        IAIChatControlTraceService.Companion r77 = IAIChatControlTraceService.a;
        r77.Ma(r68, r75);
        r77.kb().put(r68, "camera_confirm_input");
        String r78 = (String) r77.kb().put(r5, "camera_confirm_input");
        goto L157
    L153:
        if (r74.intValue() != 2) goto L149;
        r21 = "speak";
        goto L149
    L147:
        if (r74.intValue() != 1) goto L150;
        r21 = "keyboard";
        goto L149
    L143:
        r74 = null;
        goto L144
    L139:
        r212 = r70;
        goto L140
    L136:
        r70 = null;
        goto L137
    L86:
        r35 = 0;
        goto L87
    L82:
        r33 = 0;
    L78:
        r31 = "";
        goto L79
    L88:
        r36 = "";
        r210 = r113;
        ic8.m0 r79 = r38.a.b.a;
        if (r79 == null) goto L92;
        String r80 = r79.e;
        if (r80 == null) goto L92;
    L93:
        if (r79 == null) goto L95;
        String r81 = r79.b;
    L96:
        r40 = new ai8.d(r80, r81, r8, r37.c, r38.c.getLocalMessageId(), com.larus.bmhome.chat.bean.d.b1(r38.c), r210, r115, r38.a.l, 256);
        goto L97
    L95:
        r81 = null;
    L92:
        r80 = r36;
    L55:
        r113.put("collection_id", r26);
        SuggestedAction r82 = r38.a.i;
        if (r82 == null) goto L62;
        PromptReplacementCfg r83 = r82.getPromptReplacementCfg();
        if (r83 == null) goto L62;
        String r84 = r83.getReplacementKey();
        if (r84 == null) goto L62;
        r113.put("prompt_modification", r84);
    L62:
        SuggestedAction r85 = r38.a.i;
        if (r85 == null) goto L67;
        Map r86 = r85.getMsgExt();
        if (r86 == null) goto L67;
        r113.putAll(r86);
        goto L67
    L48:
        r112 = "0";
        goto L49
    L44:
        r110 = 0;
        goto L45
    L38:
        if (com.larus.utils.o0.d((String) r18.getFirst()) == false) goto L40;
        r19 = true;
    L31:
        r13 = "upload";
    L22:
        r15 = "";
        goto L24
    L27:
        if (Intrinsics.areEqual(r12, "shoot_ocr") == true) goto L33;
        if (CollectionsKt.listOf(new String[]{"album", "album_ocr"}).contains(r12) == true) goto L31;
        r13 = null;
        goto L33
    L15:
        r11 = 7;
        goto L16
    L5:
        r8 = r3;
        goto L6
    }

    private static final Unit uploadImageAfterAddMsg$lambda$20$lambda$17(MultimodalInputComponentViewModel r1, b r2, mr9.l r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.handleUploadImageAfterAddMsgSuccess(r3, r2, r2.a.c);
        return Unit.INSTANCE;
    }

    private static final Unit uploadImageAfterAddMsg$lambda$20$lambda$18(MultimodalInputComponentViewModel r1, b r2, ResourceUploadError r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.handleUploadImageAfterAddMsgFailure(r3, r2);
        return Unit.INSTANCE;
    }

    private static final Unit uploadImageMsgNew$lambda$26$lambda$22(final b r3, MultimodalInputComponentViewModel r4, mr9.l r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        j1 r0 = r3.a;
        com.larus.bmhome.chat.helper.n0 r1 = com.larus.bmhome.chat.helper.n0.a;
        Map<String, String> r2 = r0.h;
        r1.getClass();
        r0.h = com.larus.bmhome.chat.helper.n0.j(r2, r5);
        r4.uploadImageAfterAddMsg(r3, new o0(r3));
        return Unit.INSTANCE;
    }

    private static final Unit uploadImageMsgNew$lambda$26$lambda$23(MultimodalInputComponentViewModel r1, b r2, ResourceUploadError r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.handleUploadImageAfterAddMsgFailure(r3, r2);
        return Unit.INSTANCE;
    }

    private static final Unit prepareUploadImageMsgNew$lambda$3$lambda$2(j1 r11, ic8.w r12, MultimodalInputComponentViewModel r13, Message r14) {
        Intrinsics.checkNotNullParameter(r14, "result");
        String r0 = r14.getLocalMessageId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        FLogger.a.i(TAG, "tryUploadFileOrImg uploadImg for #" + r0 + " start upload");
        IConversationRepoService r5 = zh8.a.b;
        String r2 = r14.getConversationId();
        if (r2 != null) goto L8;
        String r6 = "";
    L9:
        IConversationRepoService$a.f(r5, r6, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        b r3 = new b(r11, r12, r14);
        LruCache r15 = IAIChatControlTraceService.a.kb();
        Map<String, String> r16 = r11.h;
        if (r16 == null) goto L16;
        String r17 = r16.get("enter_method");
        if (r17 == null) goto L15;
        r1 = r17;
    L15:
        r1 = r1;
    L16:
        r15.put(r0, r1);
        r13.uploadImageMsgNew(r3);
        return Unit.INSTANCE;
    L8:
        r6 = r2;
        goto L9
    }

    private final void sendMediaMessage(wc9.e r9, List<? extends ic8.w> r10, String r11, String r12) {
        IAIChatService.a.n4();
        this.repo.getSender().n1(r9.a, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        Lazy r0 = com.larus.platform.exp.s.a;
        if (com.larus.platform.exp.s.e == false) goto L5;
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01491(this, null), 2, null);
    L6:
        this.repo.getSender().o(r9, r11, r10, r12, "MultimodalInputComponentViewModel#sendMediaMessage", !com.larus.platform.exp.s.c);
        return;
    L5:
        getReader().i6("MultimodalInputComponentViewModel sendMediaMessage", false);
        goto L6
    }

    private static final void uploadSingleQuestionImagesInParallel$lambda$41$handleUploadSuccess(b r3, MultimodalInputComponentViewModel r4, mr9.l r5, mr9.l r6) {
        if (r5 == null) goto L4;
        j1 r0 = r3.a;
        com.larus.bmhome.chat.helper.n0 r1 = com.larus.bmhome.chat.helper.n0.a;
        Map<String, String> r2 = r0.h;
        r1.getClass();
        r0.h = com.larus.bmhome.chat.helper.n0.k(r2, r5);
    L4:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[uploadSingleQuestionImagesInParallel] main upload succeeded, originUploaded:");
        if (r5 == null) goto L7;
        boolean r9 = true;
    L8:
        r8.append(r9);
        r8.append(", fileIdentifier:");
        r8.append(r3.a.f);
        r7.i(TAG, r8.toString());
        r4.handleUploadImageAfterAddMsgSuccess(r6, r3, r3.a.c);
        return;
    L7:
        r9 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadImageAfterAddMsg$default(MultimodalInputComponentViewModel r0, b r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.uploadImageAfterAddMsg(r1, r2);
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$40(Object r1, b r2, MultimodalInputComponentViewModel r3, Ref.BooleanRef r4, Ref.ObjectRef r5, ResourceUploadError r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onMainUploadFailure(r1, r2, r3, r4, r5, r6);
        return Unit.INSTANCE;
    }

    private static final void uploadSingleQuestionImagesInParallel$lambda$41$onMainUploadFailure(Object r1, b r2, MultimodalInputComponentViewModel r3, Ref.BooleanRef r4, Ref.ObjectRef<mr9.l> r5, ResourceUploadError r6) {
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (r4.element == false) goto L6;
    L10:
        boolean r7 = false;
    L11:
        monitor-exit(r1);
        if (r7 == false) goto L20;
        FLogger.a.w(TAG, "[uploadSingleQuestionImagesInParallel] main upload failed, fileIdentifier:" + r2.a.f + ", error:" + r6);
        r3.handleUploadImageAfterAddMsgFailure(r6, r2);
        return;
    L20:
        return;
    L6:
        if (r5.element != null) goto L10;
        r7 = true;
        r4.element = true;     // Catch: Throwable -> L15
        goto L11
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$37(Object r1, b r2, Ref.BooleanRef r3, Ref.BooleanRef r4, Ref.ObjectRef r5, MultimodalInputComponentViewModel r6, ResourceUploadError r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onOriginUploadFailure(r1, r2, r3, r4, r5, r6, r7);
        return Unit.INSTANCE;
    }

    private static final void uploadSingleQuestionImagesInParallel$lambda$41$onOriginUploadFailure(Object r2, b r3, Ref.BooleanRef r4, Ref.BooleanRef r5, Ref.ObjectRef<mr9.l> r6, MultimodalInputComponentViewModel r7, ResourceUploadError r8) {
        monitor-enter(r2);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (r4.element == false) goto L6;
    L12:
        boolean r0 = false;
    L13:
        mr9.l r9 = null;
    L14:
        monitor-exit(r2);
        if (r0 == false) goto L17;
        FLogger.a.w(TAG, "[uploadSingleQuestionImagesInParallel] origin upload failed, continue sending main image, fileIdentifier:" + r3.a.f + ", error:" + r8);
    L17:
        if (r9 == null) goto L25;
        uploadSingleQuestionImagesInParallel$lambda$41$handleUploadSuccess(r3, r7, null, r9);
        return;
    L25:
        return;
    L6:
        if (r5.element == true) goto L12;
        r0 = true;
        r5.element = true;     // Catch: Throwable -> L20
        r9 = (mr9.l) r6.element;     // Catch: Throwable -> L20
        if (r9 == null) goto L13;
        r4.element = true;     // Catch: Throwable -> L20
        goto L14
    }

    public final void onPickImageSuccess(wc9.e r16, Uri r17, String r18, String r19, Function1<? super Message, ? extends Function1<? super mr9.k, Unit>> r20, Map<String, String> r21, ChatPageContext r22, ns8.b r23) {
        Intrinsics.checkNotNullParameter(r16, "conversation");
        Intrinsics.checkNotNullParameter(r17, "uri");
        Intrinsics.checkNotNullParameter(r19, "fromScene");
        Intrinsics.checkNotNullParameter(r20, "processCallback");
        String r5 = UUID.randomUUID().toString();
        FLogger.a.i(TAG, "[onPickImageSuccess] fileIdentifier:" + r5 + ", uri:" + r17);
        int r2 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.c(r5, null, r16.a, r19, AttachmentAreaType.NO_ATTACHMENT);
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01471(r17, r23, r16, r18, r5, r20, r21, r22, this, null), 2, null);
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$35(Object r12, Ref.BooleanRef r13, Ref.BooleanRef r14, Ref.ObjectRef r15, Ref.LongRef r16, Ref.ObjectRef r17, Ref.LongRef r18, b r19, MultimodalInputComponentViewModel r20, mr9.l r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onUploadSuccess(r12, r13, r14, r15, r16, r17, r18, r19, r20, true, r21);
        return Unit.INSTANCE;
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$36(Object r12, Ref.BooleanRef r13, Ref.BooleanRef r14, Ref.ObjectRef r15, Ref.LongRef r16, Ref.LongRef r17, Ref.ObjectRef r18, Ref.LongRef r19, b r20, mr9.k r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onUploadProgress(r12, r13, r14, r15, r16, r17, r18, r19, r20, true, r21);
        return Unit.INSTANCE;
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$38(Object r12, Ref.BooleanRef r13, Ref.BooleanRef r14, Ref.ObjectRef r15, Ref.LongRef r16, Ref.ObjectRef r17, Ref.LongRef r18, b r19, MultimodalInputComponentViewModel r20, mr9.l r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onUploadSuccess(r12, r13, r14, r15, r16, r17, r18, r19, r20, false, r21);
        return Unit.INSTANCE;
    }

    private static final Unit uploadSingleQuestionImagesInParallel$lambda$41$lambda$39(Object r12, Ref.BooleanRef r13, Ref.BooleanRef r14, Ref.ObjectRef r15, Ref.LongRef r16, Ref.LongRef r17, Ref.ObjectRef r18, Ref.LongRef r19, b r20, mr9.k r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        uploadSingleQuestionImagesInParallel$lambda$41$onUploadProgress(r12, r13, r14, r15, r16, r17, r18, r19, r20, false, r21);
        return Unit.INSTANCE;
    }

    public final void onTakePictureSuccess(wc9.e r19, String r20, String r21, Function1<? super Message, ? extends Function1<? super mr9.k, Unit>> r22, Map<String, String> r23, SuggestedAction r24, Pair<String, Integer> r25, ReferenceInfo r26, ChatPageContext r27, ns8.b r28) {
        Intrinsics.checkNotNullParameter(r19, "conversation");
        Intrinsics.checkNotNullParameter(r20, "path");
        Intrinsics.checkNotNullParameter(r22, "processCallback");
        if (r20.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        FLogger.a.w(TAG, "onTakePictureSuccess path is empty");
        return;
    L10:
        String r6 = UUID.randomUUID().toString();
        FLogger.a.i(TAG, "[onTakePictureSuccess] fileIdentifier:" + r6 + ", path:" + r20);
        int r1 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.c(r6, null, r19.a, "shoot", AttachmentAreaType.NO_ATTACHMENT);
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01481(r23, r20, r28, r19, r21, r6, r22, r24, r25, r26, r27, this, null), 2, null);
        return;
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onPickImageSuccess$default(MultimodalInputComponentViewModel r11, wc9.e r12, Uri r13, String r14, String r15, Function1 r16, Map r17, ChatPageContext r18, ns8.b r19, int r20, Object r21) {
        if ((r20 & 32) == 0) goto L5;
        Map r8 = null;
    L7:
        if ((r20 & 128) == 0) goto L9;
        ns8.b r10 = r11.uploadProcessConfig;
    L10:
        r11.onPickImageSuccess(r12, r13, r14, r15, r16, r8, r18, r10);
        return;
    L9:
        r10 = r19;
        goto L10
    L5:
        r8 = r17;
        goto L7
    }

    private static final void uploadSingleQuestionImagesInParallel$lambda$41$onUploadProgress(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef<mr9.l> r3, Ref.LongRef r4, Ref.LongRef r5, Ref.ObjectRef<mr9.l> r6, Ref.LongRef r7, b r8, boolean r9, mr9.k r10) {
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (r1.element == true) goto L32;
        if (r9 == true) goto L7;
    L8:
        if (r9 == false) goto L10;
    L12:
        if (r9 == false) goto L18;
        Long r11 = r10.a;     // Catch: Throwable -> L34
        if (r11 == null) goto L16;
        long r12 = r11.longValue();     // Catch: Throwable -> L34
    L17:
        r4.element = r12;     // Catch: Throwable -> L34
    L24:
        if (r2.element == true) goto L26;
    L28:
        long r13 = (r4.element + r5.element) / ((long) 2);     // Catch: Throwable -> L34
    L29:
        long r14 = Math.max(r7.element, r13);     // Catch: Throwable -> L34
        r7.element = r14;     // Catch: Throwable -> L34
        ((Function1) r8.a.g.invoke(r8.c)).invoke(new mr9.k(Long.valueOf(r14), false));     // Catch: Throwable -> L34
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r0);
        return;
    L26:
        if (r6.element != null) goto L28;
        r13 = r5.element;     // Catch: Throwable -> L34
        goto L29
    L16:
        r12 = r4.element;     // Catch: Throwable -> L34
        goto L17
    L18:
        Long r16 = r10.a;     // Catch: Throwable -> L34
        if (r16 == null) goto L21;
        long r17 = r16.longValue();     // Catch: Throwable -> L34
    L22:
        r5.element = r17;     // Catch: Throwable -> L34
        goto L24
    L21:
        r17 = r5.element;     // Catch: Throwable -> L34
        goto L22
    L10:
        if (r3.element == null) goto L12;
    L7:
        if (r2.element == false) goto L8;
    L32:
        monitor-exit(r0);
    }

    private static final void uploadSingleQuestionImagesInParallel$lambda$41$onUploadSuccess(Object r4, Ref.BooleanRef r5, Ref.BooleanRef r6, Ref.ObjectRef<mr9.l> r7, Ref.LongRef r8, Ref.ObjectRef<mr9.l> r9, Ref.LongRef r10, b r11, MultimodalInputComponentViewModel r12, boolean r13, mr9.l r14) {
        monitor-enter(r4);
        Pair r1 = null;
        if (r5.element == false) goto L7;
    L17:
        monitor-exit(r4);
        if (r1 == null) goto L25;
        uploadSingleQuestionImagesInParallel$lambda$41$handleUploadSuccess(r11, r12, (mr9.l) r1.component1(), (mr9.l) r1.component2());
        return;
    L25:
        return;
    L7:
        if (r13 == true) goto L9;
        r9.element = r14;     // Catch: Throwable -> L21
        r10.element = 100;     // Catch: Throwable -> L21
        if (r6.element == false) goto L17;
        r5.element = true;     // Catch: Throwable -> L21
        r1 = TuplesKt.to(r7.element, r14);     // Catch: Throwable -> L21
        goto L17
    L9:
        if (r6.element == true) goto L17;
        r7.element = r14;     // Catch: Throwable -> L21
        r6.element = true;     // Catch: Throwable -> L21
        r8.element = 100;     // Catch: Throwable -> L21
        mr9.l r15 = (mr9.l) r9.element;     // Catch: Throwable -> L21
        if (r15 == null) goto L17;
        r5.element = true;     // Catch: Throwable -> L21
        r1 = TuplesKt.to(r14, r15);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onTakePictureSuccess$default(MultimodalInputComponentViewModel r14, wc9.e r15, String r16, String r17, Function1 r18, Map r19, SuggestedAction r20, Pair r21, ReferenceInfo r22, ChatPageContext r23, ns8.b r24, int r25, Object r26) {
        if ((r25 & 16) == 0) goto L5;
        Map r8 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        SuggestedAction r9 = null;
    L11:
        if ((r25 & 64) == 0) goto L13;
        Pair r10 = null;
    L15:
        if ((r25 & 128) == 0) goto L17;
        ReferenceInfo r11 = null;
    L19:
        if ((r25 & 512) == 0) goto L21;
        ns8.b r13 = r14.uploadProcessConfig;
    L22:
        r14.onTakePictureSuccess(r15, r16, r17, r18, r8, r9, r10, r11, r23, r13);
        return;
    L21:
        r13 = r24;
        goto L22
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }
}
