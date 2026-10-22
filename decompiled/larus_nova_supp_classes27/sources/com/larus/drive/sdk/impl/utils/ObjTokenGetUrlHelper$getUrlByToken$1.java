package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$getUrlByToken$1", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {46, 58}, m = "invokeSuspend", n = {}, s = {})
final class ObjTokenGetUrlHelper$getUrlByToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowDriveFileType $fileType;
    final /* synthetic */ String $objTokenString;
    final /* synthetic */ Function1<String, Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$getUrlByToken$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$getUrlByToken$1$1", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        final /* synthetic */ com.larus.network.http.a<FileUrlRespData> $resp;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(com.larus.network.http.a<FileUrlRespData> r1, Function1<? super String, Unit> r2, Function1<? super String, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$resp = r1;
            this.$onSuccess = r2;
            this.$onFailure = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$resp, this.$onSuccess, this.$onFailure, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r2);
            FileUrlRespData r3 = (FileUrlRespData) this.$resp.b;
            if (r3 == null) goto L13;
            List r4 = r3.getFileUrlList();
            if (r4 == null) goto L13;
            FileUrlData r5 = (FileUrlData) CollectionsKt.firstOrNull(r4);
            if (r5 == null) goto L13;
            String r0 = r5.getMainUrl();
            if (r0 != null) goto L14;
            r0 = r5.getBackUrl();
        L14:
            if (r0 == null) goto L16;
            this.$onSuccess.invoke(r0);
        L20:
            return Unit.INSTANCE;
        L16:
            Function1<String, Unit> r6 = this.$onFailure;
            if (r6 == null) goto L20;
            r6.invoke("");
        L13:
            r0 = null;
            goto L14
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FlowDriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FlowDriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObjTokenGetUrlHelper$getUrlByToken$1(FlowDriveFileType r1, String r2, CoroutineScope r3, Function1<? super String, Unit> r4, Function1<? super String, Unit> r5, Continuation<? super ObjTokenGetUrlHelper$getUrlByToken$1> r6) {
        this.$fileType = r1;
        this.$objTokenString = r2;
        this.$scope = r3;
        this.$onSuccess = r4;
        this.$onFailure = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObjTokenGetUrlHelper$getUrlByToken$1(this.$fileType, this.$objTokenString, this.$scope, this.$onSuccess, this.$onFailure, r9);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L26:
        BuildersKt.launch$default(this.$scope, Dispatchers.getMain(), null, new AnonymousClass1((com.larus.network.http.a) r10, this.$onSuccess, this.$onFailure, null), 2, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L19:
        BuildersKt.launch$default(this.$scope, Dispatchers.getMain(), null, new ObjTokenGetUrlHelper$getUrlByToken$1$type$1((String) r10, this.$onSuccess, this.$onFailure, null), 2, null);
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r10);
        FlowDriveFileType r11 = this.$fileType;
        int r12 = a.a[r11.ordinal()];
        if (r12 == 1) goto L22;
        if (r12 != 2) goto L14;
        UploadDataType r13 = UploadDataType.VIDEO;
    L23:
        ObjTokenGetUrlHelper r2 = ObjTokenGetUrlHelper.a;
        List r3 = CollectionsKt.listOf(this.$objTokenString);
        this.label = 2;
        r10 = ObjTokenGetUrlHelper.d(r3, r13, this);
        if (r10 != r0) goto L26;
        return r0;
    L14:
        if (r12 == 3) goto L16;
        r13 = UploadDataType.FILE;
        goto L23
    L16:
        ObjTokenGetUrlHelper r14 = ObjTokenGetUrlHelper.a;
        String r4 = this.$objTokenString;
        this.label = 1;
        r10 = r14.c(r4, this);
        if (r10 != r0) goto L19;
        return r0;
    L22:
        r13 = UploadDataType.IMAGE;
        goto L23
    }
}
