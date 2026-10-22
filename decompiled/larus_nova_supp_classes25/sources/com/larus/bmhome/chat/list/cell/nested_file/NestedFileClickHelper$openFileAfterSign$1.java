package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper$openFileAfterSign$1", f = "NestedFileClickHelper.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class NestedFileClickHelper$openFileAfterSign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ lr8.a $delegate;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ String $key;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $path;
    final /* synthetic */ String $previewUrl;
    final /* synthetic */ String $targetFileName;
    private /* synthetic */ Object L$0;
    int label;

    public NestedFileClickHelper$openFileAfterSign$1(UplinkFileInfo r1, String r2, Context r3, String r4, String r5, Message r6, String r7, lr8.a r8, Continuation<? super NestedFileClickHelper$openFileAfterSign$1> r9) {
        this.$fileInfo = r1;
        this.$previewUrl = r2;
        this.$context = r3;
        this.$path = r4;
        this.$key = r5;
        this.$message = r6;
        this.$targetFileName = r7;
        this.$delegate = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        NestedFileClickHelper$openFileAfterSign$1 r10 = new NestedFileClickHelper$openFileAfterSign$1(this.$fileInfo, this.$previewUrl, this.$context, this.$path, this.$key, this.$message, this.$targetFileName, this.$delegate, r13);
        r10.L$0 = r12;
        return r10;
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
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        lr8.g r13 = (lr8.g) r12;
        Integer r3 = r13.b;
        if (r3 != null) goto L17;
    L41:
        lr8.g r5 = r13;
    L43:
        NestedFileClickHelper r14 = NestedFileClickHelper.a;
        Context r4 = this.$context;
        String r6 = this.$path;
        UplinkFileInfo r7 = this.$fileInfo;
        String r8 = this.$key;
        Message r9 = this.$message;
        String r10 = this.$targetFileName;
        lr8.a r11 = this.$delegate;
        r14.getClass();
        NestedFileClickHelper.g(r4, r6, r7, r8, r9, r5, r10, r11);
        return Unit.INSTANCE;
    L17:
        if (r3.intValue() != 14007) goto L41;
        FlowFileProtectionService r15 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r15 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        if (r16 == false) goto L35;
        com.larus.platform.service.o r17 = com.larus.platform.service.o.a;
        JSONObject r18 = new JSONObject();
        r18.put("action", "open_external");
        r18.put("entry", "nested_file_preview_fallback");
        r18.put("content_type", "file");
        Unit r19 = Unit.INSTANCE;
        r17.reportEvent("flow_enterprise_file_egress_block", r18);
        String r110 = r15.A0();
        if (r110 == null) goto L34;
        if ((!StringsKt.isBlank(r110)) == false) goto L30;
        String r20 = r110;
    L31:
        if (r20 == null) goto L34;
        t19.s.j(t19.s.a, this.$context, r20, null, false, 28);
        goto L34
    L30:
        r20 = null;
    L34:
        return Unit.INSTANCE;
    L35:
        String r111 = this.$previewUrl;
        if (r111 == null) goto L38;
        com.larus.platform.service.q.a.e(this.$context, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r111)}), null);
    L40:
        return Unit.INSTANCE;
    L38:
        Context r21 = this.$context;
        t19.s.j(t19.s.a, r21, r21.getString(2131898024), null, false, 28);
        goto L40
    L21:
        if (r15.I0() != true) goto L23;
        r16 = true;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        if (this.$fileInfo == null) goto L42;
        CoroutineDispatcher r22 = Dispatchers.getIO();
        NestedFileClickHelper$openFileAfterSign$1$result$1 r23 = new NestedFileClickHelper$openFileAfterSign$1$result$1(this.$fileInfo, null);
        this.L$0 = r112;
        this.label = 1;
        r12 = BuildersKt.withContext(r22, r23, this);
        if (r12 != r0) goto L13;
        return r0;
    L42:
        r5 = null;
        goto L43
    }
}
