package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$onDownloadAction$1", f = "CreationBottomView.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class CreationBottomView$onDownloadAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$onDownloadAction$1(CreationBottomView r1, Continuation<? super CreationBottomView$onDownloadAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationBottomView$onDownloadAction$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r26);
        Object r3 = r26;
    L21:
        final UserCreationFromIM r5 = (UserCreationFromIM) r3;
        IAIChatUgcAIGCService.Companion r6 = IAIChatUgcAIGCService.a;
        Context r7 = this.this$0.getContext();
        CreationBottomView r8 = this.this$0;
        sz9.a r9 = r8.d;
        if (r9 == null) goto L24;
        nr9.g r10 = r9.s;
    L25:
        if (r9 == null) goto L28;
        c4 r11 = r9.t;
        if (r11 == null) goto L28;
    L29:
        CoroutineScope r12 = r8.e;
        if (r9 == null) goto L34;
        c4 r13 = r9.t;
        if (r13 == null) goto L34;
        JSONObject r14 = r13.m;
    L35:
        Map<String, String> r15 = ICreationMetadataService.a.s(r5, null);
        sz9.a r16 = this.this$0.d;
        if (r16 == null) goto L40;
        Integer r17 = r16.z;
        if (r17 == null) goto L40;
        r4 = DataConverterKt.h(r17.intValue());
    L40:
        final CreationBottomView r18 = this.this$0;
        IAIChatUgcAIGCService.a.e(r6, r7, r10, r11, "detail_click", r12, r14, r15, r4, true, new k(r18, r5), 32);
        return Unit.INSTANCE;
    L34:
        r14 = null;
    L28:
        r11 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
        goto L29
    L24:
        r10 = null;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        CreationGalleryUtil r19 = CreationGalleryUtil.a;
        sz9.a r20 = this.this$0.d;
        if (r20 == null) goto L13;
        Message r21 = r20.v;
        if (r21 == null) goto L13;
        String r22 = r21.getMessageId();
    L14:
        sz9.a r23 = this.this$0.d;
        if (r23 == null) goto L17;
        String r24 = r23.e;
    L18:
        this.label = 1;
        r3 = r19.e(r22, r24, this);
        if (r3 != r1) goto L21;
        return r1;
    L17:
        r24 = null;
    L13:
        r22 = null;
        goto L14
    }
}
