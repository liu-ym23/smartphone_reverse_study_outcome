package com.larus.drive.sdk.impl.preview;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.bytedance.ee.drive.preview.d;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.drive.sdk.impl.utils.k;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1", f = "AiFilePreviewCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiFilePreviewCoordinator$open$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ cr9.a $request;
    final /* synthetic */ AiFilePreviewCoordinator.a $resolved;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1$2", f = "AiFilePreviewCoordinator.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $fallback;
        final /* synthetic */ String $requestId;
        final /* synthetic */ CoroutineScope $scope;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass2(Context r1, CoroutineScope r2, String r3, String r4, Function0<Unit> r5, Continuation<? super AnonymousClass2> r6) {
            this.$context = r1;
            this.$scope = r2;
            this.$accountId = r3;
            this.$requestId = r4;
            this.$fallback = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass2 r7 = new AnonymousClass2(this.$context, this.$scope, this.$accountId, this.$requestId, this.$fallback, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            String r2 = (String) this.L$3;
            String r3 = (String) this.L$2;
            CoroutineScope r4 = (CoroutineScope) this.L$1;
            Context r5 = (Context) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L24
        L16:
            if (AiFilePreviewCoordinator.b(r5, r4, r3) == true) goto L18;
            FLogger.a.i("AiFilePreview", "cancel, stage=container_ready_timeout");     // Catch: Throwable -> L24
            Unit r10 = Boxing.boxBoolean(DrivePreviewRequestStore.a.c(r2));     // Catch: Throwable -> L24
        L22:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L24
        L26:
            Context r6 = this.$context;
            CoroutineScope r7 = this.$scope;
            String r8 = this.$accountId;
            Function0<Unit> r12 = this.$fallback;
            Throwable r13 = Result.exceptionOrNull-impl(r11);
            if (r13 == null) goto L33;
            if ((r13 instanceof CancellationException) == true) goto L31;
            FLogger.a.e("AiFilePreview", "fallback, stage=container_ready_timeout, errorType=".concat(r13.getClass().getSimpleName()), r13);
            AiFilePreviewCoordinator.a(r6, r7, r8, r12);
            goto L33
        L31:
            throw r13;
        L33:
            return Unit.INSTANCE;
        L18:
            if (DrivePreviewRequestStore.a.d(r2) == false) goto L20;
            FLogger.a.w("AiFilePreview", "fallback, stage=container_ready_timeout");     // Catch: Throwable -> L24
        L20:
            r10 = Unit.INSTANCE;     // Catch: Throwable -> L24
            goto L22
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r9);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            r5 = this.$context;
            CoroutineScope r15 = this.$scope;
            r3 = this.$accountId;
            String r16 = this.$requestId;
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L24
            this.L$0 = r5;     // Catch: Throwable -> L24
            this.L$1 = r15;     // Catch: Throwable -> L24
            this.L$2 = r3;     // Catch: Throwable -> L24
            this.L$3 = r16;     // Catch: Throwable -> L24
            this.label = 1;     // Catch: Throwable -> L24
            if (DelayKt.delay(20000, this) != r0) goto L14;
            return r0;
        L14:
            r4 = r15;
            r2 = r16;
        L24:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        }
    }

    public AiFilePreviewCoordinator$open$1$1$1(Context r1, CoroutineScope r2, String r3, AiFilePreviewCoordinator.a r4, cr9.a r5, Function0<Unit> r6, Continuation<? super AiFilePreviewCoordinator$open$1$1$1> r7) {
        this.$context = r1;
        this.$scope = r2;
        this.$accountId = r3;
        this.$resolved = r4;
        this.$request = r5;
        this.$fallback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AiFilePreviewCoordinator$open$1$1$1 r8 = new AiFilePreviewCoordinator$open$1$1$1(this.$context, this.$scope, this.$accountId, this.$resolved, this.$request, this.$fallback, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.drive.sdk.impl.preview.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.drive.sdk.impl.preview.b, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r47) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L116;
        ResultKt.throwOnFailure(r47);
        final CoroutineScope r2 = (CoroutineScope) this.L$0;
        AiFilePreviewCoordinator r0 = AiFilePreviewCoordinator.a;
        if (AiFilePreviewCoordinator.b(this.$context, this.$scope, this.$accountId) == true) goto L8;
        FLogger.a.i("AiFilePreview", "cancel on route, reason=context_changed");
        return Unit.INSTANCE;
    L8:
        k r1 = k.a;
        Context r4 = this.$context;
        AiFilePreviewCoordinator.a r5 = this.$resolved;
        String r9 = r5.a;
        int r10 = r5.b;
        String r7 = r5.d;
        DrivePreviewResType r8 = r5.e;
        cr9.a r6 = this.$request;
        String r15 = r6.c;
        String r14 = r6.d;
        String r11 = r5.c;
        String r13 = r6.a;
        String r12 = r6.f;
        String r16 = r6.e;
        String r17 = r6.g;
        if (r17 != null) goto L11;
        String r21 = null;
    L16:
        String r18 = this.$request.h;
        if (r18 != null) goto L19;
        String r22 = null;
    L24:
        String r20 = this.$request.i;
        if (r20 != null) goto L27;
        String r23 = null;
    L32:
        final Context r24 = this.$context;
        final CoroutineScope r110 = this.$scope;
        final String r111 = this.$accountId;
        final Function0<Unit> r3 = this.$fallback;
        ?? r25 = new a(r24, r110, r111, r3);
        ?? r26 = new b(r24, r110, r111);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r9, "fileToken");
        Intrinsics.checkNotNullParameter(r7, "appId");
        Intrinsics.checkNotNullParameter(r8, "resType");
        Intrinsics.checkNotNullParameter(r13, "resourceUri");
        Intrinsics.checkNotNullParameter(r25, "launchFailureFallback");
        Intrinsics.checkNotNullParameter(r26, "isLaunchActive");
        if (StringsKt.isBlank(r9) == true) goto L105;
        if (r10 <= 0) goto L105;
        if (r14 == null) goto L40;
        String r27 = StringsKt.trim(r14).toString();
        if (r27 == null) goto L40;
        String r28 = r27.toLowerCase(Locale.ROOT);
    L41:
        if (r28 != null) goto L43;
    L46:
        boolean r210 = true;
    L47:
        if (r210 == false) goto L49;
        String r211 = "launchFailureFallback";
        String r212 = "DrivePreviewHelper";
        String r112 = r13;
        String r30 = null;
        String r113 = null;
    L54:
        if (r30 != null) goto L56;
    L64:
        if (r15 == null) goto L75;
        String r31 = StringsKt.substringAfterLast(r15, '.', "");
        if (r31 == null) goto L75;
        r30 = r31.toLowerCase(Locale.ROOT);
        if (r30 == null) goto L75;
        if (r30.length() <= 0) goto L72;
        boolean r114 = true;
    L73:
        if (r114 == false) goto L75;
    L76:
        String r38 = r211;
        String r41 = r212;
        String r213 = r113;
        String r42 = r112;
        DrivePreviewOpenRequest r32 = new DrivePreviewOpenRequest(new DrivePreviewOpenItem(r7, r8, r9, r10, r15, null, r30, null, r11, null, null, null, 3744, null), null, null, null, 14, null);
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L84
        d r34 = t.a;     // Catch: Throwable -> L84
        d r35 = t.a;     // Catch: Throwable -> L84
        if (r35 == null) goto L82;
        DrivePreviewOpenRequest r36 = r35.o9(r32);     // Catch: Throwable -> L84
        if (r36 == null) goto L82;
        r32 = r36;
    L82:
        Object r37 = Result.constructor-impl(r32);     // Catch: Throwable -> L84
    L86:
        Throwable r40 = Result.exceptionOrNull-impl(r37);
        if (r40 == null) goto L89;
        String r43 = r41;
        FLogger.a.e(r43, "prepare AI file preview request failed, errorType=".concat(r40.getClass().getSimpleName()));
    L91:
        if (Result.exceptionOrNull-impl(r37) != null) goto L104;
        DrivePreviewOpenRequest r44 = (DrivePreviewOpenRequest) r37;
        DrivePreviewRequestStore r45 = DrivePreviewRequestStore.a;
        Intrinsics.checkNotNullParameter(r44, "request");
        Intrinsics.checkNotNullParameter(r42, "resourceUri");
        Intrinsics.checkNotNullParameter(r25, r38);
        Intrinsics.checkNotNullParameter(r26, "isLaunchActive");
        String r46 = r45.f(r44, new com.larus.drive.sdk.impl.store.a(r44, r42, r12, r16, r15, r14, r21, r22, r23), r25, r26);
        i r48 = SmartRouter.buildRoute(r4, "//flow/drive_preview");     // Catch: Throwable -> L95
        r48.c.putExtra("ai_file_preview_request_id", r46);     // Catch: Throwable -> L95
        r48.d();     // Catch: Throwable -> L95
        Object r50 = Result.constructor-impl(r46);     // Catch: Throwable -> L95
    L97:
        Object r115 = r50;
        Throwable r51 = Result.exceptionOrNull-impl(r115);
        if (r51 == null) goto L101;
        FLogger.a.e(r43, "open AI file preview route failed, errorType=".concat(r51.getClass().getSimpleName()));
        DrivePreviewRequestStore.a.d(r46);
    L101:
        if (Result.isFailure-impl(r115) == false) goto L103;
        r115 = r213;
    L103:
        final String r116 = (String) r115;
    L107:
        if (r116 == null) goto L109;
        Job r52 = this.$scope.getCoroutineContext().get(Job.Key);
        if (r52 == null) goto L113;
        r52.invokeOnCompletion(new c(r2, r116));
    L113:
        CoroutineScope r53 = this.$scope;
        BuildersKt.launch$default(r53, null, null, new AnonymousClass2(this.$context, r53, this.$accountId, r116, this.$fallback, null), 3, null);
        FLogger.a.i("AiFilePreview", "start route, scene=" + this.$request.b.name());
        return Unit.INSTANCE;
    L109:
        return Unit.INSTANCE;
    L95:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L104:
        r25.invoke();
    L106:
        r116 = r213;
        goto L107
    L89:
        r43 = r41;
    L84:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L72:
        r114 = false;
    L75:
        r30 = r113;
        goto L76
    L56:
        if (r30.length() <= 0) goto L58;
        boolean r117 = true;
    L59:
        if (r117 == true) goto L62;
        r30 = r113;
    L62:
        if (r30 == null) goto L64;
    L58:
        r117 = false;
        goto L59
    L49:
        r211 = "launchFailureFallback";
        r212 = "DrivePreviewHelper";
        r112 = r13;
        r113 = null;
        if (StringsKt.contains$default(r28, '/', false, 2, null) == false) goto L53;
        r30 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r28);
        goto L54
    L53:
        r30 = StringsKt.trimStart(r28, new char[]{'.'});
        goto L54
    L43:
        if (r28.length() == 0) goto L46;
        r210 = false;
    L40:
        r28 = null;
    L105:
        r213 = null;
        FLogger.a.w("DrivePreviewHelper", "skip AI file preview, reason=invalid_request");
        r25.invoke();
        goto L106
    L27:
        if ((!StringsKt.isBlank(r20)) == true) goto L30;
        r20 = null;
    L30:
        r23 = r20;
        goto L32
    L19:
        if ((!StringsKt.isBlank(r18)) == true) goto L22;
        r18 = null;
    L22:
        r22 = r18;
        goto L24
    L11:
        if ((!StringsKt.isBlank(r17)) == true) goto L14;
        r17 = null;
    L14:
        r21 = r17;
        goto L16
    L116:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
