package com.larus.uaigc.helper;

import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessUploader$submitLegacyUpload$job$1", f = "CreationResourceAccessUploader.kt", i = {0}, l = {420, 498}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class CreationResourceAccessUploader$submitLegacyUpload$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ResourceUploadError, Unit> $failedCallback;
    final /* synthetic */ String $fileIdentifier;
    final /* synthetic */ Function1<mr9.k, Unit> $processCallback;
    final /* synthetic */ com.larus.bmhome.resource.access.w $request;
    final /* synthetic */ Function1<mr9.l, Unit> $successCallback;
    final /* synthetic */ CreationResourceAccessUploader.a $task;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationResourceAccessUploader$submitLegacyUpload$job$1(CreationResourceAccessUploader.a r1, Function1<? super ResourceUploadError, Unit> r2, String r3, com.larus.bmhome.resource.access.w r4, Function1<? super mr9.l, Unit> r5, Function1<? super mr9.k, Unit> r6, Continuation<? super CreationResourceAccessUploader$submitLegacyUpload$job$1> r7) {
        this.$task = r1;
        this.$failedCallback = r2;
        this.$fileIdentifier = r3;
        this.$request = r4;
        this.$successCallback = r5;
        this.$processCallback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CreationResourceAccessUploader$submitLegacyUpload$job$1 r8 = new CreationResourceAccessUploader$submitLegacyUpload$job$1(this.$task, this.$failedCallback, this.$fileIdentifier, this.$request, this.$successCallback, this.$processCallback, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        CreationResourceAccessUploader$submitLegacyUpload$job$1 r1 = this;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = r1.label;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L11;
        ResultKt.throwOnFailure(r36);     // Catch: Throwable -> L8
        String r32 = "";
    L127:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L129
    L131:
        CreationResourceAccessUploader.a r4 = r1.$task;
        Function1<ResourceUploadError, Unit> r5 = r1.$failedCallback;
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L140;
        String r7 = r6.getMessage();
        if (r7 != null) goto L136;
        r7 = r32;
    L136:
        ResourceUploadError r8 = new ResourceUploadError("legacy_upload_exception", r7);
        CreationResourceAccessUploader r9 = CreationResourceAccessUploader.a;
        if (r4.d(CreationResourceAccessUploader.m(r8, r6)) == false) goto L140;
        r5.invoke(r8);
    L140:
        return Unit.INSTANCE;
    L129:
        Throwable th = th;
    L130:
        Result.Companion r10 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = th;
        r32 = "";
        goto L130
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r11 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r36);     // Catch: Throwable -> L21
        Object r12 = r36;
    L19:
        Object r13 = Result.constructor-impl((com.larus.bmhome.resource.access.w) r12);     // Catch: Throwable -> L21
    L23:
        CreationResourceAccessUploader.a r14 = r1.$task;
        Function1<ResourceUploadError, Unit> r15 = r1.$failedCallback;
        Throwable r16 = Result.exceptionOrNull-impl(r13);
        if (r16 != null) goto L142;
        final com.larus.bmhome.resource.access.w r17 = (com.larus.bmhome.resource.access.w) r13;
        if (r1.$task.c() == true) goto L28;
        com.larus.bmhome.resource.access.j0.d r18 = r17.b;
        CreationResourceAccessUploader r19 = CreationResourceAccessUploader.a;
        boolean r20 = r18 instanceof com.larus.bmhome.resource.access.j0.d;
        if (r20 == false) goto L33;
        mr9.l r110 = new mr9.l(r18.b, null, null, null, null, false, null, 126);
    L42:
        if (r110 == null) goto L48;
        CreationResourceAccessUploader.a r111 = r1.$task;
        String r112 = r1.$fileIdentifier;
        Function1<mr9.l, Unit> r113 = r1.$successCallback;
        com.larus.bmhome.resource.access.a0.d r114 = new com.larus.bmhome.resource.access.a0.d(new com.larus.bmhome.resource.access.f0(r17.c, r18, r110.a, r110.c, r110, null, 32));
        if (r111.d(r114) == false) goto L47;
        CreationResourceAccessUploader.b(r112, r114.a);
        r113.invoke(r110);
    L47:
        return Unit.INSTANCE;
    L48:
        boolean r21 = r18 instanceof com.larus.bmhome.resource.access.j0.b;
        if (r21 == false) goto L53;
        String r115 = ((com.larus.bmhome.resource.access.j0.b) r18).b;
    L51:
        String r116 = r115;
    L62:
        if (r116 != null) goto L64;
    L67:
        boolean r117 = true;
    L68:
        if (r117 == false) goto L74;
        ResourceUploadError r22 = new ResourceUploadError("unsupported_resource_input", "legacy upload only supports local path or content uri");
        if (r1.$task.d(CreationResourceAccessUploader.m(r22, null)) == false) goto L73;
        r1.$failedCallback.invoke(r22);
    L73:
        return Unit.INSTANCE;
    L74:
        String r118 = r17.d.b;
        int r119 = CreationResourceAccessUploader.b.a[r17.c.ordinal()];
        if (r119 == 1) goto L83;
        if (r119 != 2) goto L78;
        UploadDataType r120 = UploadDataType.IMAGE;
    L84:
        UploadDataType r121 = r120;
        final CreationResourceAccessUploader.a r122 = r1.$task;
        final String r123 = r1.$fileIdentifier;
        final Function1<mr9.l, Unit> r23 = r1.$successCallback;
        Function1 r24 = new w(r17, r122, r123, r23);
        final Function1<mr9.k, Unit> r25 = r1.$processCallback;
        Function1 r26 = new x(r122, r25);
        final Function1<ResourceUploadError, Unit> r27 = r1.$failedCallback;
        r32 = "";
        Function1 r28 = new y(r122, r27);
        boolean r29 = r18 instanceof com.larus.bmhome.resource.access.j0.a;
        com.larus.bmhome.resource.access.g0 r124 = r17.d;
        String r30 = r124.e;
        boolean r31 = r124.f;
        CountDownLatch r33 = r124.g;
        mr9.h r125 = r124.h;
        if (r21 == false) goto L87;
        com.larus.bmhome.resource.access.j0.b r126 = (com.larus.bmhome.resource.access.j0.b) r18;
    L88:
        if (r126 == null) goto L91;
        String r127 = r126.c;
        if (r127 == null) goto L91;
    L96:
        String r210 = r127;
    L98:
        if (r21 == false) goto L100;
        Boolean r34 = ((com.larus.bmhome.resource.access.j0.b) r18).d;
    L102:
        Boolean r211 = r34;
    L110:
        com.larus.bmhome.resource.access.g0 r35 = r17.d;
        mr9.c r37 = r35.i;
        String r128 = r35.d;
        if (r21 == false) goto L113;
        com.larus.bmhome.resource.access.j0.b r38 = (com.larus.bmhome.resource.access.j0.b) r18;
    L114:
        if (r38 == null) goto L119;
        Long r39 = r38.e;
        if (r39 == null) goto L119;
        Long r212 = r39;
    L120:
        mr9.j r129 = new mr9.j(r116, r118, r121, r24, r26, r28, r29, null, null, r30, r123, r31, r33, r125, r210, r211, r37, r128, r212, null, 1049472);
        r1 = this;
        if (r1.$task.c() == true) goto L123;
        ResourceUploader r40 = ResourceUploader.a;     // Catch: Throwable -> L129
        r1.L$0 = null;     // Catch: Throwable -> L129
        r1.label = 2;     // Catch: Throwable -> L129
        if (r40.j(r129, r1) != r2) goto L127;
        return r2;
    L123:
        return Unit.INSTANCE;
    L119:
        r212 = r35.j;
        goto L120
    L113:
        r38 = null;
        goto L114
    L100:
        if (r29 == false) goto L104;
        r34 = Boxing.boxBoolean(true);
        goto L102
    L104:
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L109;
        if (r20 == true) goto L109;
        throw new NoWhenBranchMatchedException();
    L109:
        r211 = null;
    L91:
        if (r29 == false) goto L93;
        com.larus.bmhome.resource.access.j0.a r130 = (com.larus.bmhome.resource.access.j0.a) r18;
    L94:
        if (r130 == null) goto L97;
        r127 = r130.b;
        goto L96
    L97:
        r210 = null;
        goto L98
    L93:
        r130 = null;
        goto L94
    L87:
        r126 = null;
        goto L88
    L78:
        if (r119 != 3) goto L81;
        r120 = UploadDataType.FILE;
        goto L84
    L81:
        throw new NoWhenBranchMatchedException();
    L83:
        r120 = UploadDataType.VIDEO;
        goto L84
    L64:
        if (StringsKt.isBlank(r116) == true) goto L67;
        r117 = false;
        goto L68
    L53:
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L56;
        r115 = ((com.larus.bmhome.resource.access.j0.a) r18).b;
        goto L51
    L56:
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L61;
        if (r20 == true) goto L61;
        throw new NoWhenBranchMatchedException();
    L61:
        r116 = null;
        goto L62
    L33:
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L35;
    L41:
        r110 = null;
        goto L42
    L35:
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.a) == true) goto L41;
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L41;
        throw new NoWhenBranchMatchedException();
    L28:
        return Unit.INSTANCE;
    L142:
        if ((r16 instanceof CreationResourceAccessUploader.LegacyPrepareException) == false) goto L144;
        CreationResourceAccessUploader.LegacyPrepareException r41 = (CreationResourceAccessUploader.LegacyPrepareException) r16;
    L145:
        if (r41 == null) goto L148;
        ResourceUploadError r42 = r41.getError();
        if (r42 == null) goto L148;
    L153:
        CreationResourceAccessUploader r43 = CreationResourceAccessUploader.a;
        if (r14.d(CreationResourceAccessUploader.m(r42, r16)) == false) goto L157;
        r15.invoke(r42);
    L157:
        return Unit.INSTANCE;
    L148:
        String r44 = r16.getMessage();
        if (r44 != null) goto L151;
        String r45 = "";
    L152:
        r42 = new ResourceUploadError("legacy_prepare_exception", r45);
        goto L153
    L151:
        r45 = r44;
        goto L152
    L144:
        r41 = null;
        goto L145
    L15:
        ResultKt.throwOnFailure(r36);
        CoroutineScope r46 = (CoroutineScope) r1.L$0;
        com.larus.bmhome.resource.access.w r47 = r1.$request;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L21
        CreationResourceAccessUploader r49 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L21
        r1.L$0 = r46;     // Catch: Throwable -> L21
        r1.label = 1;     // Catch: Throwable -> L21
        r12 = CreationResourceAccessUploader.a(r49, r47, r1);     // Catch: Throwable -> L21
        if (r12 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
