package com.larus.uaigc.createpage.component.instruction;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$handleMsgInstructionRedirectSchema$3", f = "CreationEditorComponent.kt", i = {0, 0, 1, 1}, l = {4101, 4116}, m = "invokeSuspend", n = {"$this$launch", "copyMediaAttachment", "$this$launch", "copyMediaAttachment"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class CreationEditorComponent$handleMsgInstructionRedirectSchema$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, ry9.k> $multiMediaMap;
    final /* synthetic */ String $schema;
    final /* synthetic */ ry9.i.a $singleImageData;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$handleMsgInstructionRedirectSchema$3(Map<String, ry9.k> r1, ry9.i.a r2, CreationEditorComponent r3, String r4, Continuation<? super CreationEditorComponent$handleMsgInstructionRedirectSchema$3> r5) {
        this.$multiMediaMap = r1;
        this.$singleImageData = r2;
        this.this$0 = r3;
        this.$schema = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CreationEditorComponent$handleMsgInstructionRedirectSchema$3 r6 = new CreationEditorComponent$handleMsgInstructionRedirectSchema$3(this.$multiMediaMap, this.$singleImageData, this.this$0, this.$schema, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        MediaAttachment r1 = (MediaAttachment) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r25);
        Object r5 = r25;
        MediaAttachment r6 = r1;
    L64:
        File r7 = (File) r5;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L75
        if (r7 != null) goto L68;
    L70:
        if (r4 == false) goto L73;
        if (r6 == null) goto L73;
        r6.setLocalFilePath(com.larus.utils.y0.k(Uri.fromFile(r7)));     // Catch: Throwable -> L75
    L73:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L77:
        Result.box-impl(r9);
    L78:
        CreationEditorComponent r10 = this.this$0;
        String r11 = this.$schema;
        int r12 = CreationEditorComponent.g2;
        if (r10.m6(r11, r6, null) == true) goto L81;
        final com.bytedance.router.i r13 = SmartRouter.buildRoute(this.this$0.getContext(), this.$schema);
        r13.c.putExtra("media_attachment", r6);
        r13.c.putExtra("enable_compact_fragment_forseti", this.this$0.T5());
        this.this$0.o5(new q1(r13), null, null, new r1(r13));
    L84:
        return Unit.INSTANCE;
    L81:
        return Unit.INSTANCE;
    L68:
        if (r7.exists() != true) goto L70;
        r4 = true;
    L75:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ComponentFeature r15 = (CreationEditorComponent) this.L$2;
        MediaAttachment r16 = (MediaAttachment) this.L$1;
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r25);
        ComponentFeature r18 = r15;
        r6 = r16;
        Object r19 = r25;
    L59:
        Bitmap r20 = (Bitmap) r19;
        if (r20 == null) goto L78;
        ICreationWorkflowService.Companion r110 = ICreationWorkflowService.a;
        Context r21 = r18.getContext();
        this.L$0 = r17;
        this.L$1 = r6;
        this.L$2 = null;
        this.label = 2;
        r5 = r110.e(r21, r20, "remote_attachment_schema_default_file.jpeg", this);
        if (r5 != r0) goto L64;
        return r0;
    L10:
        ResultKt.throwOnFailure(r25);
        r17 = (CoroutineScope) this.L$0;
        if ((((ry9.k) CollectionsKt.first(this.$multiMediaMap.values())).b instanceof ry9.j.c) == false) goto L84;
        ry9.i.a r22 = this.$singleImageData;
        if (r22 == null) goto L17;
        MediaAttachment r23 = r22.a;
        if (r23 == null) goto L17;
        r6 = MediaAttachment.copy$default(r23, null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    L18:
        uz9.a r24 = this.this$0.r;
        if (r24 == null) goto L21;
        r24.o();
    L21:
        if (r6 == null) goto L24;
        String r26 = r6.getLocalFilePath();
        if (r26 == null) goto L24;
    L26:
        if (r26.length() <= 0) goto L28;
        boolean r27 = true;
    L29:
        if (r27 == true) goto L31;
    L40:
        uz9.a r28 = this.this$0.r;
        if (r28 == null) goto L78;
        Map r29 = (Map) r28.o().getValue();
        if (r29 == null) goto L78;
        Collection r30 = r29.values();
        if (r30 == null) goto L78;
        ry9.k r31 = (ry9.k) CollectionsKt.firstOrNull(r30);
        if (r31 == null) goto L78;
        r18 = this.this$0;
        ry9.j r111 = r31.b;
        if ((r111 instanceof ry9.j.c) == false) goto L78;
        if (r111.a() == null) goto L78;
        if ((r31.b.a() instanceof ry9.i.a) == false) goto L78;
        ry9.i r32 = r31.b.a();
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.MediaSelectorData.ImageSelectorData");
        String r33 = ((ry9.i.a) r32).a.getUrl();
        if (r33 == null) goto L78;
        CoroutineDispatcher r112 = Dispatchers.getIO();
        CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1 r113 = new CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1(r33, null);
        this.L$0 = r17;
        this.L$1 = r6;
        this.L$2 = r18;
        this.label = 1;
        r19 = BuildersKt.withContext(r112, r113, this);
        if (r19 != r0) goto L59;
        return r0;
    L31:
        if (new PolarisFileWrapper(r26).exists() == false) goto L40;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L37
        if (r6 == null) goto L35;
        r6.setLocalFilePath(com.larus.utils.y0.k(Uri.fromFile(new PolarisFileWrapper(r26))));     // Catch: Throwable -> L37
    L35:
        Object r35 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Result.box-impl(r35);
    L37:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L28:
        r27 = false;
    L24:
        r26 = "";
    L17:
        r6 = null;
        goto L18
    }
}
