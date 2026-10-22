package com.larus.avlink.gallery.executor;

import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$handleArchiveFile$1", f = "MediaDownloadExecutor.kt", i = {0, 1, 2}, l = {590, 594, 600}, m = "invokeSuspend", n = {"callbackId", "callbackId", "callbackId"}, s = {"L$0", "L$0", "L$0"})
final class MediaDownloadExecutor$handleArchiveFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $id;
    final /* synthetic */ MediaInfo $mediaInfo;
    final /* synthetic */ long $mediaSize;
    final /* synthetic */ String $mediaType;
    final /* synthetic */ String $sn;
    final /* synthetic */ long $startTime;
    Object L$0;
    int label;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$handleArchiveFile$1(MediaInfo r1, String r2, MediaDownloadExecutor r3, String r4, String r5, long r6, String r8, long r9, String r11, Continuation<? super MediaDownloadExecutor$handleArchiveFile$1> r12) {
        this.$mediaInfo = r1;
        this.$id = r2;
        this.this$0 = r3;
        this.$filePath = r4;
        this.$fileName = r5;
        this.$mediaSize = r6;
        this.$mediaType = r8;
        this.$startTime = r9;
        this.$sn = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new MediaDownloadExecutor$handleArchiveFile$1(this.$mediaInfo, this.$id, this.this$0, this.$filePath, this.$fileName, this.$mediaSize, this.$mediaType, this.$startTime, this.$sn, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.avlink.gallery.executor.MediaDownloadExecutor] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.larus.avlink.gallery.executor.MediaDownloadExecutor] */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.larus.avlink.gallery.executor.MediaDownloadExecutor] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r20v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r24) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        String r0 = (String) this.L$0;
        ResultKt.throwOnFailure(r24);
        ?? r18 = r0;
    L45:
        ?? r10 = this.this$0;
        long r12 = this.$mediaSize;
        String r14 = this.$mediaType;
        long r15 = System.currentTimeMillis() - this.$startTime;
        String r2 = this.$sn;
        int r3 = MediaDownloadExecutor.n;
        r10.i(1, r12, r14, r15, 1, r18, r2);
    L47:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Exception -> L16
        r1 = r4;
    L35:
        ?? r13 = this.this$0;     // Catch: Exception -> L16
        long r16 = this.$mediaSize;     // Catch: Exception -> L16
        String r5 = this.$mediaType;     // Catch: Exception -> L16
        long r17 = System.currentTimeMillis() - this.$startTime;     // Catch: Exception -> L16
        String r6 = this.$sn;     // Catch: Exception -> L16
        int r7 = MediaDownloadExecutor.n;     // Catch: Exception -> L16
        r13.i(1, r16, r5, r17, 1, r1, r6);     // Catch: Exception -> L16
        goto L47
    L13:
        String r8 = (String) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Exception -> L16
        ?? r11 = r8;
        Object r19 = r24;
    L52:
    L37:
        e = e;
    L41:
        FLogger.a.e("MediaDownloadExecutor", "Error during archive file handling: " + e.getMessage(), e);
        MediaLifecycleStateManager r20 = this.this$0.c;
        String r21 = this.$id;
        String r22 = "Archive file handling failed: " + e.getMessage();
        this.L$0 = r11;
        this.label = 3;
        if (r20.b(r21, r22, this) != r9) goto L44;
        return r9;
    L44:
        r18 = r11;
        goto L45
    L29:
        if (((Boolean) r19).booleanValue() == false) goto L31;
        ?? r110 = this.this$0;     // Catch: Exception -> L37
        long r23 = this.$mediaSize;     // Catch: Exception -> L37
        String r25 = this.$mediaType;     // Catch: Exception -> L37
        long r111 = System.currentTimeMillis() - this.$startTime;     // Catch: Exception -> L37
        String r26 = this.$sn;     // Catch: Exception -> L37
        int r27 = MediaDownloadExecutor.n;     // Catch: Exception -> L37
        r110.i(0, r23, r25, r111, 0, r11, r26);     // Catch: Exception -> L37
        goto L47
    L31:
        FLogger.a.w("MediaDownloadExecutor", "No displayable file found in archive");     // Catch: Exception -> L37
        MediaLifecycleStateManager r28 = this.this$0.c;     // Catch: Exception -> L37
        String r29 = this.$id;     // Catch: Exception -> L37
        this.L$0 = r11;     // Catch: Exception -> L37
        this.label = 2;     // Catch: Exception -> L37
        if (r28.b(r29, "No displayable file found in archive", this) != r9) goto L34;
        return r9;
    L34:
        r1 = r11;
        goto L35
    L18:
        ResultKt.throwOnFailure(r24);
        Long r30 = this.$mediaInfo.getMediaId();
        if (r30 == null) goto L22;
        String r31 = r30.toString();
        if (r31 == null) goto L22;
    L23:
        String r112 = r31;
        MediaDownloadExecutor r32 = this.this$0;     // Catch: Exception -> L39
        String r33 = this.$filePath;     // Catch: Exception -> L39
        String r34 = this.$fileName;     // Catch: Exception -> L39
        String r35 = this.$id;     // Catch: Exception -> L39
        MediaInfo r36 = this.$mediaInfo;     // Catch: Exception -> L39
        this.L$0 = r112;     // Catch: Exception -> L39
        this.label = 1;     // Catch: Exception -> L39
        int r37 = MediaDownloadExecutor.n;     // Catch: Exception -> L39
        r19 = r32.f(r33, r34, r35, r36, false, this);     // Catch: Exception -> L39
        if (r19 != r9) goto L27;
        return r9;
    L27:
        r11 = r112;
    L39:
        e = e;
        r11 = r112;
    L22:
        r31 = this.$id;
    L16:
        e = e;
        r11 = r1;
        goto L41
    }
}
