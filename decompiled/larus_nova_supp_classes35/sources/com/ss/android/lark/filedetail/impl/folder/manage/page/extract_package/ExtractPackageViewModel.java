package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.media.v1.BrowseFolderRequest;
import com.bytedance.lark.pb.media.v1.BrowseFolderResponse;
import com.bytedance.lark.pb.media.v1.CancelExtractPackagePollRequest;
import com.bytedance.lark.pb.media.v1.ExtractPackageRequest;
import com.bytedance.lark.pb.media.v1.ExtractPackageResponse;
import com.bytedance.lark.pb.media.v1.PushExtractPackageStatus;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J<\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR%\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/ExtractPackageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "progressLiveData", BuildConfig.FLAVOR, "getProgressLiveData", "folderResponseLiveData", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FolderPreviewResponse;", "getFolderResponseLiveData", "curExtractKey", "folderService", "Lcom/ss/android/lark/filedetail/impl/folder/manage/service/FolderService;", "msgLinkToken", "onCreate", BuildConfig.FLAVOR, "key", "onDestroy", "registerPush", "Lkotlinx/coroutines/Job;", "requestExtractPackage", "previewId", "authFileKey", "step", BuildConfig.FLAVOR, "downloadFileScene", BuildConfig.FLAVOR, "handlePushExtractStatus", "status", "Lcom/bytedance/lark/pb/media/v1/PushExtractPackageStatus;", "cancelExtractPackagePoll", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtractPackageViewModel extends ViewModel implements CoroutineScope {
    public static final a Companion = null;
    public static final String TAG = "ExtractPackageViewModel";
    private final CoroutineContext coroutineContext;
    private String curExtractKey;
    private final MutableLiveData<ErrorResult> errorLiveData;
    private final MutableLiveData<Pair<String, nfb.c>> folderResponseLiveData;
    private final ofb.b folderService;
    private String msgLinkToken;
    private final MutableLiveData<Float> progressLiveData;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.ExtractPackageViewModel$registerPush$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.ExtractPackageViewModel$registerPush$1", f = "ExtractPackageViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ExtractPackageViewModel this$0;

        public AnonymousClass1(ExtractPackageViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0049 -> B:13:0x004e). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r7);
            com.larksuite.rucket.job.extension.a r3 = r2;
            Object r4 = r0;
            AnonymousClass1 r5 = this;
        L14:
            if (((Boolean) r7).booleanValue() == false) goto L23;
            com.larksuite.rucket.job.base.b.c r8 = r3.a();
            if ((r8 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L19;
            ExtractPackageViewModel.access$handlePushExtractStatus(r5.this$0, (PushExtractPackageStatus) r8.b);
        L21:
            AnonymousClass1 r9 = r5;
            r0 = r4;
            com.larksuite.rucket.job.extension.a r6 = r3;
        L9:
            r9.L$0 = r6;
            r9.label = 1;
            Object r10 = r6.hasNext(r9);
            if (r10 != r0) goto L12;
            return r0;
        L12:
            Object r11 = r0;
            r5 = r9;
            r7 = r10;
            r3 = r6;
            r4 = r11;
            goto L14
        L19:
            if ((r8 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L21;
            r5.this$0.getErrorLiveData().postValue(((com.larksuite.rucket.job.base.b.b) r8).b);
            goto L21
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ExtractPackageViewModel.access$getFolderService$p(this.this$0).getClass();
            r6 = ((ofb.c) b38.b.a.create(ofb.c.class)).pushExtractPackageStatus().iterator();
            r9 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.ExtractPackageViewModel$requestExtractPackage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.ExtractPackageViewModel$requestExtractPackage$1", f = "ExtractPackageViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authFileKey;
        final /* synthetic */ int $downloadFileScene;
        final /* synthetic */ String $key;
        final /* synthetic */ String $msgLinkToken;
        final /* synthetic */ String $previewId;
        final /* synthetic */ long $step;
        int label;
        final /* synthetic */ ExtractPackageViewModel this$0;

        public C04621(ExtractPackageViewModel r1, String r2, String r3, long r4, int r6, String r7, String r8, Continuation<? super C04621> r9) {
            this.this$0 = r1;
            this.$key = r2;
            this.$msgLinkToken = r3;
            this.$step = r4;
            this.$downloadFileScene = r6;
            this.$previewId = r7;
            this.$authFileKey = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new C04621(this.this$0, this.$key, this.$msgLinkToken, this.$step, this.$downloadFileScene, this.$previewId, this.$authFileKey, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L11:
            com.larksuite.rucket.job.base.b.b r16 = (com.larksuite.rucket.job.base.b) r15;
            if ((r16 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L15;
            this.this$0.getErrorLiveData().setValue(r16.b);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            ExtractPackageViewModel.access$setCurExtractKey$p(this.this$0, this.$key);
            ExtractPackageViewModel.access$setMsgLinkToken$p(this.this$0, this.$msgLinkToken);
            nfb.b.a r17 = new nfb.b.a();
            String r2 = this.$key;
            Intrinsics.checkNotNullParameter(r2, "key");
            long r5 = this.$step;
            int r9 = this.$downloadFileScene;
            String r10 = this.$previewId;
            String r11 = this.$authFileKey;
            String r12 = this.$msgLinkToken;
            nfb.b r13 = new nfb.b(r2, r17.a, r5, r17.b, r17.c, r9, r10, r11, r12);
            ExtractPackageViewModel.access$getFolderService$p(this.this$0).getClass();
            Intrinsics.checkNotNullParameter(r13, "params");
            BrowseFolderRequest r18 = ofb.b.a(r13).build();
            ExtractPackageRequest r19 = new ExtractPackageRequest.Builder().request(r18).build();
            ofb.c r3 = (ofb.c) b38.b.a.create(ofb.c.class);
            Intrinsics.checkNotNull(r19);
            RucketJob<ExtractPackageResponse> r110 = r3.sendExtractPackageRequest(r19);
            this.label = 1;
            r15 = r110.awaitGet(this);
            if (r15 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    private final Job registerPush() {
        return BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void cancelExtractPackagePoll() {
        ofb.b r0 = this.folderService;
        String r1 = this.curExtractKey;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        CancelExtractPackagePollRequest r2 = new CancelExtractPackagePollRequest.Builder().key(r1).build();
        ofb.c r3 = (ofb.c) b38.b.a.create(ofb.c.class);
        Intrinsics.checkNotNull(r2);
        r3.cancelExtractPackagePoll(r2);
    }

    public ExtractPackageViewModel() {
        this.coroutineContext = Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        this.errorLiveData = new MutableLiveData();
        this.progressLiveData = new MutableLiveData();
        this.folderResponseLiveData = new MutableLiveData(TuplesKt.to(BuildConfig.FLAVOR, null));
        this.curExtractKey = BuildConfig.FLAVOR;
        this.folderService = ofb.b.a;
    }

    public final void onDestroy() {
        cancelExtractPackagePoll();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final MutableLiveData<ErrorResult> getErrorLiveData() {
        return this.errorLiveData;
    }

    public final MutableLiveData<Pair<String, nfb.c>> getFolderResponseLiveData() {
        return this.folderResponseLiveData;
    }

    public final MutableLiveData<Float> getProgressLiveData() {
        return this.progressLiveData;
    }

    public static final /* synthetic */ ofb.b access$getFolderService$p(ExtractPackageViewModel r0) {
        return r0.folderService;
    }

    private final void handlePushExtractStatus(PushExtractPackageStatus r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r8.key, this.curExtractKey) == false) goto L21;
        StringBuilder r0 = new StringBuilder("compressed file key = " + this.curExtractKey + ", ");
        Float r1 = r8.progress;
        if (r1 == null) goto L9;
        float r2 = r1.floatValue();
        r0.append("progress = " + r2);
        this.progressLiveData.postValue(Float.valueOf(r2));
    L9:
        LarkError r3 = r8.error;
        boolean r4 = false;
        if (r3 == null) goto L12;
        r0.append("error code = " + r3 + ".code");
        MutableLiveData<ErrorResult> r5 = this.errorLiveData;
        Exception r6 = new Exception("unknown error");
        int r7 = r3.code.intValue();
        String r9 = r3.display_message;
        ErrorResult r10 = new ErrorResult(0);
        ErrorResult.access$002(r10, r7);
        ErrorResult.access$102(r10, Error.ParameterNull);
        ErrorResult.access$202(r10, 0);
        ErrorResult.access$302(r10, r6);
        ErrorResult.access$402(r10, BuildConfig.FLAVOR);
        ErrorResult.access$502(r10, BuildConfig.FLAVOR);
        ErrorResult.access$602(r10, r9);
        ErrorResult.access$702(r10, BuildConfig.FLAVOR);
        ErrorResult.access$802(r10, 0);
        ErrorResult.access$902(r10, null);
        ErrorResult.access$1002(r10, null);
        ErrorResult.access$1102(r10, null);
        r5.postValue(r10);
    L12:
        BrowseFolderResponse r11 = r8.result;
        if (r11 == null) goto L18;
        ofb.b r12 = this.folderService;
        String r13 = this.msgLinkToken;
        r12.getClass();
        nfb.c r14 = ofb.b.b(r11, r13);
        StringBuilder r15 = new StringBuilder("response == null: ");
        if (r14 != null) goto L17;
        r4 = true;
    L17:
        r15.append(r4);
        r15.append('}');
        r0.append(r15.toString());
        this.folderResponseLiveData.postValue(TuplesKt.to(this.curExtractKey, r14));
    L18:
        Log.i(TAG, r0.toString());
        return;
    }

    public static final /* synthetic */ void access$handlePushExtractStatus(ExtractPackageViewModel r0, PushExtractPackageStatus r1) {
        r0.handlePushExtractStatus(r1);
    }

    public static final /* synthetic */ void access$setCurExtractKey$p(ExtractPackageViewModel r0, String r1) {
        r0.curExtractKey = r1;
    }

    public static final /* synthetic */ void access$setMsgLinkToken$p(ExtractPackageViewModel r0, String r1) {
        r0.msgLinkToken = r1;
    }

    public final void onCreate(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.curExtractKey = r2;
        this.msgLinkToken = r3;
        registerPush();
    }

    public static /* synthetic */ void onCreate$default(ExtractPackageViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.onCreate(r1, r2);
    }

    public final Job requestExtractPackage(String r14, String r15, String r16, String r17, long r18, int r20) {
        Intrinsics.checkNotNullParameter(r14, "key");
        return BuildersKt.launch$default(this, null, null, new C04621(this, r14, r17, r18, r20, r15, r16, null), 3, null);
    }
}
