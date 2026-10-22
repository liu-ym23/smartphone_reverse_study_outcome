package com.larus.dora.impl.feedback;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.util.LruCache;
import android.util.Patterns;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.annotation.DoraScene;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraSceneManager;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricConfigService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import java.util.regex.Matcher;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010L\u001a\u00020IH\u0002J\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020IJ\u0006\u0010P\u001a\u00020IJ\u000e\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020IJ\u0006\u0010S\u001a\u00020NJ\u0006\u0010T\u001a\u00020IJ\u000e\u0010U\u001a\u00020NH\u0086@¢\u0006\u0002\u0010VJ\u000e\u0010W\u001a\u00020N2\u0006\u0010X\u001a\u00020YJ\u000e\u0010Z\u001a\u00020N2\u0006\u0010[\u001a\u00020\u0012J\u000e\u0010\\\u001a\u00020N2\u0006\u0010[\u001a\u00020\u0012J\u0006\u0010]\u001a\u00020NJ\u0006\u0010^\u001a\u00020NJ\b\u0010_\u001a\u00020IH\u0002J \u0010`\u001a\u00020I2\u0006\u0010a\u001a\u00020\u00182\u0006\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020\u0018H\u0002J\u0006\u0010d\u001a\u00020NJ\u0016\u0010e\u001a\u00020N2\u0006\u0010f\u001a\u00020DH\u0082@¢\u0006\u0002\u0010gJ\u0016\u0010h\u001a\u00020N2\u0006\u0010f\u001a\u00020DH\u0082@¢\u0006\u0002\u0010gJ\u0010\u0010i\u001a\u00020IH\u0080@¢\u0006\u0004\bj\u0010VJ\u001e\u0010k\u001a\u00020N2\u0006\u0010l\u001a\u00020I2\u0006\u0010f\u001a\u00020DH\u0082@¢\u0006\u0002\u0010mJ$\u0010n\u001a\u00020N2\u0006\u0010o\u001a\u00020I2\u0006\u0010p\u001a\u00020D2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010r\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020608¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001805¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?05¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001805¢\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0012\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020I05X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020I08¢\u0006\b\n\u0000\u001a\u0004\bK\u0010:¨\u0006s"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGFeedbackViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_feedbackImageGroup", "Lcom/larus/dora/impl/feedback/DoraFeedbackImageGroup;", "_feedbackLog", "Lcom/larus/dora/impl/feedback/DoraFeedbackLog;", "_imageSubmitCallback", "Lcom/larus/dora/impl/feedback/DoraFeedbackImageSubmitCallback;", "_logSubmitCallback", "Lcom/larus/dora/impl/feedback/DoraFeedbackLogSubmitCallback;", "_imageXUploadCredentials", "Lcom/larus/dora/impl/feedback/ImageXUploadCredentials;", "imageUploadProgress", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getImageUploadProgress", "()Ljava/util/HashMap;", "thumbnailCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "getThumbnailCache", "()Landroid/util/LruCache;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "value", "imageSubmitCallback", "getImageSubmitCallback", "()Lcom/larus/dora/impl/feedback/DoraFeedbackImageSubmitCallback;", "setImageSubmitCallback", "(Lcom/larus/dora/impl/feedback/DoraFeedbackImageSubmitCallback;)V", "logSubmitCallback", "getLogSubmitCallback", "()Lcom/larus/dora/impl/feedback/DoraFeedbackLogSubmitCallback;", "setLogSubmitCallback", "(Lcom/larus/dora/impl/feedback/DoraFeedbackLogSubmitCallback;)V", "feedbackImageGroup", "getFeedbackImageGroup", "()Lcom/larus/dora/impl/feedback/DoraFeedbackImageGroup;", "feedbackLog", "getFeedbackLog", "()Lcom/larus/dora/impl/feedback/DoraFeedbackLog;", "imageXUploadCredentials", "getImageXUploadCredentials", "()Lcom/larus/dora/impl/feedback/ImageXUploadCredentials;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/feedback/FeedbackState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "feedbackContentFlow", "getFeedbackContentFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "feedbackTypeFlow", "Lcom/larus/dora/impl/feedback/FeedbackType;", "getFeedbackTypeFlow", "conversationLinkFlow", "getConversationLinkFlow", "pendingFeedbackSubmitStartTime", "", "Ljava/lang/Long;", "feedbackSubmitJob", "Lkotlinx/coroutines/Job;", "_canSubmitFlow", "", "canSubmitFlow", "getCanSubmitFlow", "shouldInterceptSubmitBecauseLowPower", "resetState", "", "canSubmitFeedback", "isFeedbackConsentGranted", "setFeedbackConsentGranted", "granted", "markFeedbackSubmitStart", "isImageXCredentialExpired", "requestToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addImage", "uri", "Landroid/net/Uri;", "removeImage", "position", "retryUploadImage", "collectLog", "cancelLog", "checkConversationLink", "isFeedbackFormValid", "content", "type", "conversationLink", "submitFeedback", "submitWithGLog", "submitStartTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectAndSubmitLog", "uploadAppLog", "uploadAppLog$impl_mainlandRelease", "submitAppLogAndInfo", "hasAppLog", "(ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportFeedbackSubmitResult", "isSuccess", "startTime", "failReason", "getEnvLaneNameByConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGFeedbackViewModel extends AndroidViewModel {
    private final z0<Boolean> _canSubmitFlow;
    private final h _feedbackImageGroup;
    private final l _feedbackLog;
    private i _imageSubmitCallback;
    private r0 _imageXUploadCredentials;
    private m _logSubmitCallback;
    private final z0<q0> _stateFlow;
    private final i1<Boolean> canSubmitFlow;
    private final z0<String> conversationLinkFlow;
    private final z0<String> feedbackContentFlow;
    private Job feedbackSubmitJob;
    private final z0<FeedbackType> feedbackTypeFlow;
    private final HashMap<Integer, Integer> imageUploadProgress;
    private Long pendingFeedbackSubmitStartTime;
    private final i1<q0> stateFlow;
    private final LruCache<String, Bitmap> thumbnailCache;

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "content", "", "type", "Lcom/larus/dora/impl/feedback/FeedbackType;", "conversationLink"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<String, FeedbackType, String, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public AnonymousClass1(DoraGFeedbackViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(4, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((String) r1, (FeedbackType) r2, (String) r3, (Continuation) r4);
        }

        public final Object invoke(String r3, FeedbackType r4, String r5, Continuation<? super Boolean> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r6);
            r0.L$0 = r3;
            r0.L$1 = r4;
            r0.L$2 = r5;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            String r5 = (String) this.L$0;
            FeedbackType r0 = (FeedbackType) this.L$1;
            String r1 = (String) this.L$2;
            return Boxing.boxBoolean(DoraGFeedbackViewModel.access$isFeedbackFormValid(this.this$0, r5, r0, r1));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$2", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public AnonymousClass2(DoraGFeedbackViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            boolean r3 = this.Z$0;
            DoraGFeedbackViewModel.access$get_canSubmitFlow$p(this.this$0).setValue(Boxing.boxBoolean(r3));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$3", f = "DoraGFeedbackViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            public static final AnonymousClass1<T> a = null;

            static {
                a = new AnonymousClass1();
            }

            public AnonymousClass1() {
            }

            public final Object a(q0 r7, Continuation<? super Unit> r8) {
                if ((r8 instanceof DoraGFeedbackViewModel$3$1$emit$1) == false) goto L7;
                DoraGFeedbackViewModel$3$1$emit$1 r0 = (DoraGFeedbackViewModel$3$1$emit$1) r8;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r9);
            L37:
                IDoraAVLinkService r10 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
                if (r10 == null) goto L41;
                r10.B0(5, 2);
            L41:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r9);
            L21:
                IDoraAVLinkService r11 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
                if (r11 == null) goto L41;
                r11.B0(5, 1);
                goto L41
            L16:
                ResultKt.throwOnFailure(r9);
                if ((r7 instanceof q0.c) == false) goto L25;
                DoraSceneManager r12 = DoraSceneManager.a;
                DoraScene r13 = DoraScene.FEEDBACK_SUBMITTING;
                r0.label = 1;
                if (r12.b(r13, r0) != r2) goto L21;
                return r2;
            L25:
                if ((r7 instanceof q0.d) == false) goto L27;
            L34:
                DoraSceneManager r14 = DoraSceneManager.a;
                DoraScene r15 = DoraScene.FEEDBACK_SUBMITTING;
                r0.label = 2;
                if (r14.e(r15, r0) != r2) goto L37;
                return r2;
            L27:
                if ((r7 instanceof q0.a) == true) goto L34;
                if (Intrinsics.areEqual(r7, q0.b.a) == true) goto L41;
                throw new NoWhenBranchMatchedException();
            L7:
                r0 = new DoraGFeedbackViewModel$3$1$emit$1(this, r8);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((q0) r1, r2);
            }
        }

        public AnonymousClass3(DoraGFeedbackViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            i1<q0> r5 = this.this$0.getStateFlow();
            FlowCollector r2 = AnonymousClass1.a;
            this.label = 1;
            if (r5.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LogState.values().length];
            r0[LogState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[LogState.P2P_CONNECTION_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[LogState.LOG_FETCH_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[LogState.LOG_UPLOAD_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b extends LruCache<String, Bitmap> {
        public b(int r1) {
            super(r1);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r2, Bitmap r3) {
            Bitmap r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            return r4.getByteCount() / 1024;
        }
    }

    public static final class c implements Function3<Boolean, Integer, String, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public c(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, Object r3, Object r4) {
            boolean r5 = ((Boolean) r2).booleanValue();
            int r6 = ((Number) r3).intValue();
            Intrinsics.checkNotNullParameter((String) r4, "<unused var>");
            if (r5 == false) goto L6;
            pk4.j.d("DoraGFeedbackViewModel", "App log upload success");
            DoraGFeedbackViewModel.access$uploadAppLog$lambda$1$resumeIfActive(this.a, true);
        L18:
            return Unit.INSTANCE;
        L6:
            if (r6 != 2) goto L8;
        L16:
            DoraGFeedbackViewModel.access$uploadAppLog$lambda$1$resumeIfActive(this.a, true);
            goto L18
        L8:
            if (r6 == 4) goto L16;
            if (r6 != 6) goto L12;
            DoraGFeedbackViewModel.access$uploadAppLog$lambda$1$resumeIfActive(this.a, false);
            goto L18
        L12:
            if (r6 == 13) goto L14;
            DoraGFeedbackViewModel.access$uploadAppLog$lambda$1$resumeIfActive(this.a, false);
            goto L18
        L14:
            DoraGFeedbackViewModel.access$uploadAppLog$lambda$1$resumeIfActive(this.a, false);
            pk4.j.d("DoraGFeedbackViewModel", "App log upload restricted by server");
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$requestToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel", f = "DoraGFeedbackViewModel.kt", i = {}, l = {249}, m = "requestToken", n = {}, s = {})
    public static final class C03541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public C03541(DoraGFeedbackViewModel r1, Continuation<? super C03541> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestToken(this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitAppLogAndInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel", f = "DoraGFeedbackViewModel.kt", i = {0}, l = {470}, m = "submitAppLogAndInfo", n = {"submitStartTime"}, s = {"J$0"})
    public static final class C03551 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public C03551(DoraGFeedbackViewModel r1, Continuation<? super C03551> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraGFeedbackViewModel.access$submitAppLogAndInfo(this.this$0, false, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitFeedback$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {385, 387, 387}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $submitStartTime;
        Object L$0;
        int label;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public C03561(DoraGFeedbackViewModel r1, long r2, Continuation<? super C03561> r4) {
            this.this$0 = r1;
            this.$submitStartTime = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03561(this.this$0, this.$submitStartTime, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L66:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            DoraGFeedbackViewModel r2 = (DoraGFeedbackViewModel) this.L$0;
            ResultKt.throwOnFailure(r10);
        L62:
            boolean r11 = ((Boolean) r10).booleanValue();
            long r3 = this.$submitStartTime;
            this.L$0 = null;
            this.label = 3;
            if (DoraGFeedbackViewModel.access$submitAppLogAndInfo(r2, r11, r3, this) != r0) goto L66;
            return r0;
        L11:
            ResultKt.throwOnFailure(r10);
        L58:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
            DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0).setValue(q0.c.a);
            FeedbackType r12 = (FeedbackType) this.this$0.getFeedbackTypeFlow().getValue();
            String r4 = (String) this.this$0.getFeedbackContentFlow().getValue();
            List<g> r5 = DoraGFeedbackViewModel.access$get_feedbackImageGroup$p(this.this$0).a();
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r7 = r5.iterator();
        L14:
            if (r7.hasNext() == false) goto L16;
            r6.add(((g) r7.next()).a.toString());
            goto L14
        L16:
            String r8 = (String) this.this$0.getConversationLinkFlow().getValue();
            Intrinsics.checkNotNullParameter(r12, "type");
            Intrinsics.checkNotNullParameter(r4, "description");
            pk4.j.d("DoraGFeedbackViewModel", "Submit feedback started: serverType=" + r12.getServerType() + ", imageCount=" + r6.size() + ", hasConversationLink=" + com.larus.utils.o0.d(r8));
            if (r12 != FeedbackType.NONE) goto L21;
            pk4.j.b("DoraGFeedbackViewModel", "Submit feedback blocked: feedback type is not selected");
            DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0).setValue(new q0.a(""));
            return Unit.INSTANCE;
        L21:
            if (StringsKt.isBlank(r4) == false) goto L24;
            DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0).setValue(new q0.a(""));
            return Unit.INSTANCE;
        L24:
            FeedbackType r9 = FeedbackType.DOUBAO_CONVERSATION_PROBLEM;
            if (r12 != r9) goto L40;
            if (r8 != null) goto L28;
        L31:
            boolean r13 = true;
        L32:
            if (r13 == false) goto L36;
            DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0).setValue(new q0.a(""));
            return Unit.INSTANCE;
        L36:
            if (DoraGFeedbackViewModel.access$checkConversationLink(this.this$0) == true) goto L40;
            z0 r14 = DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0);
            int r15 = com.larus.utils.j0.a;
            r14.setValue(new q0.a(com.larus.utils.j0.d(2131902711)));
            return Unit.INSTANCE;
        L28:
            if (StringsKt.isBlank(r8) == true) goto L31;
            r13 = false;
        L40:
            if (DoraGFeedbackViewModel.access$shouldInterceptSubmitBecauseLowPower(this.this$0) == false) goto L44;
            pk4.j.d("DoraGFeedbackViewModel", "DoraGFeedbackViewModel.submitFeedback: intercept submit because low power.");
            z0 r16 = DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0);
            int r17 = com.larus.utils.j0.a;
            r16.setValue(new q0.a(com.larus.utils.j0.d(2131902724)));
            return Unit.INSTANCE;
        L44:
            if (((Boolean) DoraGFeedbackViewModel.access$get_feedbackImageGroup$p(this.this$0).d.getValue()).booleanValue() == true) goto L48;
            z0 r18 = DoraGFeedbackViewModel.access$get_stateFlow$p(this.this$0);
            int r20 = com.larus.utils.j0.a;
            r18.setValue(new q0.a(com.larus.utils.j0.d(2131902718)));
            return Unit.INSTANCE;
        L48:
            if (r12 == FeedbackType.GLASSES_APP_FAULT) goto L53;
            if (r12 == r9) goto L53;
            if (r12 == FeedbackType.QUICK_FEEDBACK) goto L53;
        L59:
            r2 = this.this$0;
            this.L$0 = r2;
            this.label = 2;
            r10 = r2.uploadAppLog$impl_mainlandRelease(this);
            if (r10 != r0) goto L62;
            return r0;
        L53:
            if (o59.a.k(kj4.a.g().c()) == false) goto L59;
            DoraGFeedbackViewModel r110 = this.this$0;
            long r21 = this.$submitStartTime;
            this.label = 1;
            if (DoraGFeedbackViewModel.access$collectAndSubmitLog(r110, r21, this) != r0) goto L58;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitWithGLog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel", f = "DoraGFeedbackViewModel.kt", i = {0}, l = {395, 404}, m = "submitWithGLog", n = {"submitStartTime"}, s = {"J$0"})
    public static final class C03571 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGFeedbackViewModel this$0;

        public C03571(DoraGFeedbackViewModel r1, Continuation<? super C03571> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return DoraGFeedbackViewModel.access$submitWithGLog(this.this$0, 0, this);
        }
    }

    public final m getLogSubmitCallback() {
        return null;
    }

    public final void setLogSubmitCallback(m r1) {
    }

    private final boolean checkConversationLink() {
        Matcher r0 = Patterns.WEB_URL.matcher((String) this.conversationLinkFlow.getValue());
    L4:
        if (r0.find() == false) goto L20;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(new URI(r0.group()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        URI r3 = (URI) r2;
        if (r3 == null) goto L4;
        boolean r4 = true;
        if (StringsKt.equals(r3.getScheme(), "https", true) == false) goto L4;
        if (StringsKt.equals(r3.getHost(), "www.doubao.com", true) == false) goto L4;
    L21:
        pk4.j.a("DomainCheck", "Conversation link domain validation completed, matched=" + r4);
        return r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L20:
        r4 = false;
        goto L21
    }

    public final boolean canSubmitFeedback() {
        return isFeedbackFormValid((String) this.feedbackContentFlow.getValue(), (FeedbackType) this.feedbackTypeFlow.getValue(), (String) this.conversationLinkFlow.getValue());
    }

    public final void cancelLog() {
        l r0 = this._feedbackLog;
        Job r1 = r0.h;
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isActive() != true) goto L7;
    L8:
        if (r2 == false) goto L14;
        Job r3 = r0.h;
        if (r3 == null) goto L12;
        r3.cancel(new CancellationException("Log processing cancelled by user"));
    L12:
        r0.h = null;
        r0.b.setValue(LogState.IDLE);
        pk4.j.a("DoraGFeedbackViewModel", "Cancelled ongoing processing for Log [" + r0.d + ']');
        return;
    L14:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void collectLog() {
        l r8 = this._feedbackLog;
        r8.getClass();
        long r4 = System.currentTimeMillis();
        Ref.LongRef r2 = new Ref.LongRef();
        r2.element = r4;
        Ref.LongRef r3 = new Ref.LongRef();
        r3.element = r4;
        Ref.LongRef r6 = new Ref.LongRef();
        r6.element = r4;
        r8.h = BuildersKt.launch$default(ViewModelKt.getViewModelScope(r8.a), null, null, new DoraFeedbackLog$submit$1(r8, r2, r3, r4, r6, null), 3, null);
    }

    public final boolean isFeedbackConsentGranted() {
        com.larus.dora.impl.util.b0.a.getClass();
        String r0 = AccountService.a.getUserId();
        return com.larus.dora.impl.util.b0.j().getBoolean("dora_feedback_diagnostic_consent_".concat(r0), false);
    }

    public final boolean isImageXCredentialExpired() {
        r0 r0 = this._imageXUploadCredentials;
        if (r0 == null) goto L20;
        String r1 = r0.c();
        if (r1 == null) goto L22;
        SimpleDateFormat r2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.CHINA);     // Catch: Exception -> L15
        r2.setTimeZone(TimeZone.getTimeZone("UTC"));     // Catch: Exception -> L15
        Date r3 = r2.parse(r1);     // Catch: Exception -> L15
        if (r3 != null) goto L10;
        return true;
    L10:
        if (System.currentTimeMillis() <= (r3.getTime() - 60000)) goto L21;
        return true;
    L21:
        return false;
    L15:
        e = move-exception;
        pk4.j.c("DoraGFeedbackViewModel", "Failed to parse expiration time: ".concat(r1), e);
        return true;
    L22:
        return true;
    L20:
        return true;
    }

    public final void markFeedbackSubmitStart() {
        Job r0 = this.feedbackSubmitJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        pk4.j.f("DoraGFeedbackViewModel", "Feedback submit start ignored: submission already in progress");
        return;
    L10:
        this.pendingFeedbackSubmitStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void resetState() {
        this._stateFlow.setValue(q0.b.a);
    }

    public final void submitFeedback() {
        Job r0 = this.feedbackSubmitJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        pk4.j.f("DoraGFeedbackViewModel", "Submit feedback ignored: submission already in progress");
        return;
    L10:
        Long r2 = this.pendingFeedbackSubmitStartTime;
        if (r2 == null) goto L13;
        long r3 = r2.longValue();
    L14:
        this.pendingFeedbackSubmitStartTime = null;
        this.feedbackSubmitJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03561(this, r3, null), 3, null);
        return;
    L13:
        r3 = SystemClock.elapsedRealtime();
        goto L14
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    private final String getEnvLaneNameByConfig() {
        if (HttpExtKt.e().a == false) goto L6;
        return HttpExtKt.e().b;
    L6:
        if (HttpExtKt.e().c == true) goto L11;
        return "Product";
    L11:
        return HttpExtKt.e().d;
    }

    private final boolean shouldInterceptSubmitBecauseLowPower() {
        int r0 = kj4.a.g().d();
        if (o59.a.k(kj4.a.g().c()) == true) goto L5;
    L13:
        boolean r1 = false;
    L14:
        pk4.j.d("DoraGFeedbackViewModel", "DoraGFeedbackViewModel.shouldInterceptSubmitBecauseLowPower, lowPowerState: " + r0 + ", type: " + ((FeedbackType) this.feedbackTypeFlow.getValue()).getStr() + ", intercept: " + r1);
        return r1;
    L5:
        if (r0 != 2) goto L13;
        if (this.feedbackTypeFlow.getValue() != FeedbackType.GLASSES_APP_FAULT) goto L9;
    L12:
        r1 = true;
        goto L14
    L9:
        if (this.feedbackTypeFlow.getValue() == FeedbackType.DOUBAO_CONVERSATION_PROBLEM) goto L12;
        if (this.feedbackTypeFlow.getValue() != FeedbackType.QUICK_FEEDBACK) goto L13;
        goto L12
    }

    public final Context getContext() {
        return getApplication().getApplicationContext();
    }

    public final i1<Boolean> getCanSubmitFlow() {
        return this.canSubmitFlow;
    }

    public final z0<String> getConversationLinkFlow() {
        return this.conversationLinkFlow;
    }

    public final z0<String> getFeedbackContentFlow() {
        return this.feedbackContentFlow;
    }

    public final h getFeedbackImageGroup() {
        return this._feedbackImageGroup;
    }

    public final l getFeedbackLog() {
        return this._feedbackLog;
    }

    public final z0<FeedbackType> getFeedbackTypeFlow() {
        return this.feedbackTypeFlow;
    }

    public final i getImageSubmitCallback() {
        return this._imageSubmitCallback;
    }

    public final HashMap<Integer, Integer> getImageUploadProgress() {
        return this.imageUploadProgress;
    }

    public final r0 getImageXUploadCredentials() {
        return this._imageXUploadCredentials;
    }

    public final i1<q0> getStateFlow() {
        return this.stateFlow;
    }

    public final LruCache<String, Bitmap> getThumbnailCache() {
        return this.thumbnailCache;
    }

    public DoraGFeedbackViewModel(Application r11) {
        Intrinsics.checkNotNullParameter(r11, "application");
        super(r11);
        this._feedbackImageGroup = new h(this);
        this._feedbackLog = new l(this);
        this.imageUploadProgress = new HashMap();
        this.thumbnailCache = new b((int) ((Runtime.getRuntime().maxMemory() / ((long) 1024)) / ((long) 16)));
        StateFlowImpl r12 = j1.a(q0.b.a);
        this._stateFlow = r12;
        this.stateFlow = kotlinx.coroutines.flow.e.b(r12);
        StateFlowImpl r0 = j1.a("");
        this.feedbackContentFlow = r0;
        StateFlowImpl r1 = j1.a(FeedbackType.QUICK_FEEDBACK);
        this.feedbackTypeFlow = r1;
        StateFlowImpl r13 = j1.a("");
        this.conversationLinkFlow = r13;
        StateFlowImpl r2 = j1.a(Boolean.FALSE);
        this._canSubmitFlow = r2;
        this.canSubmitFlow = kotlinx.coroutines.flow.e.b(r2);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.j(r0, r1, r13, new AnonymousClass1(this, null)), new AnonymousClass2(this, null)), ViewModelKt.getViewModelScope(this));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass3(this, null), 2, null);
    }

    public static final /* synthetic */ boolean access$checkConversationLink(DoraGFeedbackViewModel r0) {
        return r0.checkConversationLink();
    }

    public static final /* synthetic */ z0 access$get_canSubmitFlow$p(DoraGFeedbackViewModel r0) {
        return r0._canSubmitFlow;
    }

    public static final /* synthetic */ h access$get_feedbackImageGroup$p(DoraGFeedbackViewModel r0) {
        return r0._feedbackImageGroup;
    }

    public static final /* synthetic */ z0 access$get_stateFlow$p(DoraGFeedbackViewModel r0) {
        return r0._stateFlow;
    }

    public static final /* synthetic */ boolean access$shouldInterceptSubmitBecauseLowPower(DoraGFeedbackViewModel r0) {
        return r0.shouldInterceptSubmitBecauseLowPower();
    }

    public final void addImage(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        h r1 = this._feedbackImageGroup;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "uri");
        g r2 = new g(r10, ((List) r1.b.getValue()).size(), r1);
        StateFlowImpl r0 = r1.b;
        r0.setValue(CollectionsKt.plus((Collection) r0.getValue(), r2));
        r2.h = BuildersKt.launch$default(ViewModelKt.getViewModelScope(r2.c.a), null, null, new DoraFeedbackImage$submit$1(r2, null), 3, null);
        pk4.j.a("DoraGFeedbackViewModel", "Added new image: " + r10 + ". Total images: " + ((List) r1.b.getValue()).size());
    }

    public final void removeImage(int r8) {
        h r0 = this._feedbackImageGroup;
        List r1 = (List) r0.b.getValue();
        g r2 = (g) ListProtector.get(r1, r8);
        Job r3 = r2.h;
        if (r3 == null) goto L7;
        boolean r4 = true;
        if (r3.isActive() != true) goto L7;
    L9:
        if (r4 == false) goto L14;
        Job r5 = r2.h;
        if (r5 == null) goto L13;
        r5.cancel(new CancellationException("Image processing cancelled by user"));
    L13:
        r2.h = null;
        r2.d.setValue(ImageState.IDLE);
        pk4.j.a("DoraGFeedbackViewModel", "Cancelled ongoing processing for image [" + r2.a + ']');
    L14:
        pk4.j.a("DoraGFeedbackViewModel", "Cancelled processing for image: " + r2.a);
        r0.b.setValue(CollectionsKt.minus(r1, r2));
        Iterator r6 = ((Iterable) r0.b.getValue()).iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        g r7 = (g) r6.next();
        int r9 = r7.b;
        if (r9 <= r8) goto L16;
        r7.b = r9 - 1;
        goto L16
    L20:
        pk4.j.a("DoraGFeedbackViewModel", "Removed image: " + r2.a + ". Remaining images: " + ((List) r0.b.getValue()).size());
        return;
    L7:
        r4 = false;
        goto L9
    }

    public final Object requestToken(Continuation<? super Unit> r9) {
        if ((r9 instanceof C03541) == false) goto L7;
        C03541 r0 = (C03541) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        C03541 r6 = r0;
        Object r10 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L21:
        com.larus.network.http.y r11 = (com.larus.network.http.a) r10;
        if ((r11 instanceof com.larus.network.http.y) == false) goto L24;
        this._imageXUploadCredentials = (r0) ((com.larus.network.http.a) r11).b;
        pk4.j.d("DoraGFeedbackViewModel", "Image upload credential request succeeded");
    L26:
        return Unit.INSTANCE;
    L24:
        pk4.j.b("DoraGFeedbackViewModel", "Image upload credential request failed");
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (isImageXCredentialExpired() == false) goto L17;
        com.larus.dora.api.network.a r4 = com.larus.dora.api.network.a.a;
        JSONObject r5 = new JSONObject();
        r6.label = 1;
        r10 = com.larus.dora.api.network.a.c(r4, r0.class, "https://api-normal.doubao.com/alice/device/feedback/get_imagex_token", r5, null, r6, 248);
        if (r10 != r2) goto L21;
        return r2;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new C03541(this, r9);
        goto L8
    }

    public final void retryUploadImage(int r8) {
        g r9 = (g) ListProtector.get(this._feedbackImageGroup.a(), r8);
        r9.h = BuildersKt.launch$default(ViewModelKt.getViewModelScope(r9.c.a), null, null, new DoraFeedbackImage$submit$1(r9, null), 3, null);
    }

    public final void setFeedbackConsentGranted(boolean r4) {
        com.larus.dora.impl.util.b0.a.getClass();
        String r0 = AccountService.a.getUserId();
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_feedback_diagnostic_consent_".concat(r0), r4);
    }

    public final void setImageSubmitCallback(i r1) {
        this._imageSubmitCallback = r1;
    }

    public final Object uploadAppLog$impl_mainlandRelease(Continuation<? super Boolean> r5) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r0.C();
        FLogger.a.e("feedback", new c(r0));
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r1;
    }

    public static final /* synthetic */ void access$uploadAppLog$lambda$1$resumeIfActive(kotlinx.coroutines.i r0, boolean r1) {
        uploadAppLog$lambda$1$resumeIfActive(r0, r1);
    }

    private final Object collectAndSubmitLog(long r1, Continuation<? super Unit> r3) {
        collectLog();
        Object r2 = submitWithGLog(r1, r3);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    private final Object submitWithGLog(long r7, Continuation<? super Unit> r9) {
        if ((r9 instanceof C03571) == false) goto L7;
        C03571 r0 = (C03571) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L57:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r0.J$0;
        ResultKt.throwOnFailure(r10);
    L19:
        LogState r11 = (LogState) r10;
        if (r11 != null) goto L22;
        int r12 = -1;
    L23:
        if (r12 == 1) goto L53;
        if (r12 != 2) goto L26;
        x39.b r8 = this._feedbackLog.g;
        if ((r8 instanceof x39.b.h) == false) goto L36;
        z0<q0> r13 = this._stateFlow;
        int r14 = com.larus.utils.j0.a;
        r13.setValue(new q0.a(com.larus.utils.j0.d(2131902865)));
    L52:
        return Unit.INSTANCE;
    L36:
        if ((r8 instanceof x39.b.c) == false) goto L39;
        z0<q0> r15 = this._stateFlow;
        int r16 = com.larus.utils.j0.a;
        r15.setValue(new q0.a(com.larus.utils.j0.d(2131902862)));
        goto L52
    L39:
        if ((r8 instanceof x39.b.C0147b) == false) goto L42;
        z0<q0> r17 = this._stateFlow;
        int r18 = com.larus.utils.j0.a;
        r17.setValue(new q0.a(com.larus.utils.j0.d(2131902863)));
        goto L52
    L42:
        if ((r8 instanceof x39.b.g) == false) goto L45;
        z0<q0> r20 = this._stateFlow;
        int r21 = com.larus.utils.j0.a;
        r20.setValue(new q0.a(com.larus.utils.j0.d(2131902875)));
        goto L52
    L45:
        if ((r8 instanceof x39.b.e) == false) goto L48;
        z0<q0> r22 = this._stateFlow;
        int r4 = com.larus.utils.j0.a;
        r22.setValue(new q0.a(com.larus.utils.j0.d(2131902876)));
        goto L52
    L48:
        if ((r8 instanceof x39.b.d) == false) goto L50;
        z0<q0> r23 = this._stateFlow;
        int r5 = com.larus.utils.j0.a;
        r23.setValue(new q0.a(com.larus.utils.j0.d(2131902876)));
        goto L52
    L50:
        z0<q0> r24 = this._stateFlow;
        int r25 = com.larus.utils.j0.a;
        r24.setValue(new q0.a(com.larus.utils.j0.d(2131902855)));
        goto L52
    L26:
        if (r12 != 3) goto L28;
        z0<q0> r26 = this._stateFlow;
        int r6 = com.larus.utils.j0.a;
        r26.setValue(new q0.a(com.larus.utils.j0.d(2131902717)));
        goto L52
    L28:
        if (r12 != 4) goto L52;
        z0<q0> r27 = this._stateFlow;
        int r28 = com.larus.utils.j0.a;
        r27.setValue(new q0.a(com.larus.utils.j0.d(2131902717)));
        goto L52
    L53:
        boolean r30 = this._feedbackLog.f;
        r0.label = 2;
        if (submitAppLogAndInfo(r30, r7, r0) != r2) goto L57;
        return r2;
    L22:
        r12 = a.a[r11.ordinal()];
        goto L23
    L16:
        ResultKt.throwOnFailure(r10);
        b1 r31 = this._feedbackLog.c;
        DoraGFeedbackViewModel$submitWithGLog$terminalState$1 r32 = new DoraGFeedbackViewModel$submitWithGLog$terminalState$1(null);
        r0.J$0 = r7;
        r0.label = 1;
        r10 = kotlinx.coroutines.flow.e.u(r31, r32, r0);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new C03571(this, r9);
        goto L8
    }

    private static final void uploadAppLog$lambda$1$resumeIfActive(kotlinx.coroutines.i<? super Boolean> r1, boolean r2) {
        if (r1.isActive() == false) goto L6;
        r1.resumeWith(Result.constructor-impl(Boolean.valueOf(r2)));
        return;
    }

    public static final /* synthetic */ Object access$collectAndSubmitLog(DoraGFeedbackViewModel r0, long r1, Continuation r3) {
        return r0.collectAndSubmitLog(r1, r3);
    }

    public static final /* synthetic */ Object access$submitWithGLog(DoraGFeedbackViewModel r0, long r1, Continuation r3) {
        return r0.submitWithGLog(r1, r3);
    }

    private final boolean isFeedbackFormValid(String r3, FeedbackType r4, String r5) {
        if (r4 != FeedbackType.NONE) goto L5;
        return false;
    L5:
        if (StringsKt.isBlank(r3) == false) goto L8;
        return false;
    L8:
        if (r4 == FeedbackType.DOUBAO_CONVERSATION_PROBLEM) goto L10;
    L11:
        return true;
    L10:
        if (com.larus.utils.o0.d(r5) == true) goto L11;
        return false;
    }

    private final void reportFeedbackSubmitResult(boolean r6, long r7, String r9) {
        boolean r1 = true;
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(!r6 ? 1 : 0)), TuplesKt.to("total_duration", Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r7, 0)))});
        if (r9 != null) goto L5;
    L8:
        if (r1 == true) goto L10;
        r8.put("fail_reason", r9);
    L10:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "feedback_submit_result", r8, false, 12);
        return;
    L5:
        if (r9.length() == 0) goto L8;
        r1 = false;
        goto L8
    }

    private final Object submitAppLogAndInfo(boolean r18, long r110, Continuation<? super Unit> r21) {
        if ((r21 instanceof C03551) == false) goto L7;
        C03551 r1 = (C03551) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        C03551 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r13.J$0;
        ResultKt.throwOnFailure(r0);
        long r6 = r5;
    L64:
        if ((((com.larus.network.http.a) r0) instanceof com.larus.network.http.y) == false) goto L66;
        z0<q0> r7 = this._stateFlow;
        int r8 = com.larus.utils.j0.a;
        r7.setValue(new q0.d(com.larus.utils.j0.d(2131905671)));
        reportFeedbackSubmitResult$default(this, true, r6, null, 4, null);
    L68:
        return Unit.INSTANCE;
    L66:
        z0<q0> r9 = this._stateFlow;
        int r10 = com.larus.utils.j0.a;
        r9.setValue(new q0.a(com.larus.utils.j0.d(2131902726)));
        reportFeedbackSubmitResult(false, r6, "SUBMISSION_FAILURE");
        goto L68
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        DoraDevice r11 = kj4.a.g().c();
        IObricConfigService r12 = (IObricConfigService) ServiceManager.get().getService(IObricConfigService.class);
        if (r12 == null) goto L17;
        Map r14 = r12.getCommonParams();
    L18:
        if (r14 != null) goto L20;
        r14 = MapsKt.emptyMap();
    L20:
        String r15 = (String) r14.get("o_rom_full_version");
        String r16 = "";
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        com.larus.dora.api.network.a r17 = com.larus.dora.api.network.a.a;
        JSONObject r111 = new JSONObject();
        FeedbackType.a r112 = FeedbackType.Companion;
        FeedbackType r113 = (FeedbackType) this.feedbackTypeFlow.getValue();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "type");
        r111.put("feedback_type", r113.getServerType());
        r111.put("feedback_content", this.feedbackContentFlow.getValue());
        r111.put("has_app_log", r18);
        r111.put("has_device_log", !StringsKt.isBlank(this._feedbackLog.e));
        if (this.feedbackTypeFlow.getValue() != FeedbackType.DOUBAO_CONVERSATION_PROBLEM) goto L26;
        String r114 = (String) this.conversationLinkFlow.getValue();
    L27:
        r111.put("chat_link", r114);
        JSONArray r115 = new JSONArray();
        JSONArray r116 = new JSONArray();
        Iterator<T> r117 = this._feedbackImageGroup.a().iterator();
    L29:
        if (r117.hasNext() == false) goto L35;
        g r20 = (g) r117.next();
        if (r20.f == false) goto L33;
        r116.put(r20.g);
        goto L29
    L33:
        r115.put(r20.g);
        goto L29
    L35:
        r111.put("image_uri_list", r115);
        r111.put("video_uri_list", r116);
        r111.put("device_log_file_name", this._feedbackLog.e);
        JSONObject r22 = new JSONObject();
        if ((!StringsKt.isBlank(r15)) == false) goto L39;
        r22.put("o_rom_full_version", r15);
    L39:
        if (r22.length() <= 0) goto L41;
        r111.put("dynamic_params", r22);
    L41:
        JSONObject r23 = new JSONObject();
        if (r11 == null) goto L44;
        String r24 = r11.getSerialNumber();
    L45:
        if (r24 != null) goto L47;
        r24 = "";
    L47:
        r23.put("sn", r24);
        if (r11 == null) goto L50;
        String r25 = r11.softVersion;
    L51:
        if (r25 != null) goto L53;
        r25 = "";
    L53:
        r23.put("firmware_version", r25);
        if (r11 == null) goto L56;
        String r26 = r11.androidRomVersion;
    L57:
        if (r26 == null) goto L60;
        r16 = r26;
    L60:
        r23.put("ar1_version", r16);
        r23.put("is_connected", o59.a.k(kj4.a.g().c()));
        r23.put("branch", "obric/rls/15.2.0.1");
        r23.put("commit_id", "fc4b8ba9c915");
        r23.put("server_env", getEnvLaneNameByConfig());
        Unit r27 = Unit.INSTANCE;
        r111.put("extra_params", r23);
        r6 = r110;
        r13.J$0 = r6;
        r13.label = 1;
        r0 = com.larus.dora.api.network.a.c(r17, Unit.class, "https://api-normal.doubao.com/alice/device/feedback/upload", r111, null, r13, 248);
        if (r0 != r3) goto L64;
        return r3;
    L56:
        r26 = null;
        goto L57
    L50:
        r25 = null;
        goto L51
    L44:
        r24 = null;
        goto L45
    L26:
        r114 = "";
        goto L27
    L17:
        r14 = null;
    L7:
        r1 = new C03551(this, r21);
        goto L8
    }

    public static final /* synthetic */ boolean access$isFeedbackFormValid(DoraGFeedbackViewModel r0, String r1, FeedbackType r2, String r3) {
        return r0.isFeedbackFormValid(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$submitAppLogAndInfo(DoraGFeedbackViewModel r0, boolean r1, long r2, Continuation r4) {
        return r0.submitAppLogAndInfo(r1, r2, r4);
    }

    public static /* synthetic */ void reportFeedbackSubmitResult$default(DoraGFeedbackViewModel r0, boolean r1, long r2, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r0.reportFeedbackSubmitResult(r1, r2, r4);
    }
}
