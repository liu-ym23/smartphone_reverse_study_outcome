package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/dto/chat/GetMessageIdsByPositionResponse$MessageTypeInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1", f = "FlowMessageSelectPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ccb.c.a>>, Object> {
    final /* synthetic */ ccb.c $data;
    int label;
    final /* synthetic */ FlowMessageSelectPlugin this$0;

    public FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1(FlowMessageSelectPlugin r1, ccb.c r2, Continuation<? super FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<ccb.c.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r6);
        FlowMessageSelectPlugin r7 = this.this$0;
        List r0 = this.$data.a;
        int r1 = FlowMessageSelectPlugin.f0;
        r7.getClass();
        p r8 = ImSdkService.f();     // Catch: Throwable -> L23
        List r2 = r0;     // Catch: Throwable -> L23
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Throwable -> L23
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L23
    L7:
        if (r4.hasNext() == false) goto L9;
        r3.add(((ccb.c.a) r4.next()).a);     // Catch: Throwable -> L23
        goto L7
    L9:
        Map<String, Message> r9 = r8.ta(r3);     // Catch: Throwable -> L23
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L23
        Iterator r10 = r0.iterator();     // Catch: Throwable -> L23
    L10:
        if (r10.hasNext() == false) goto L36;
        Object r11 = r10.next();     // Catch: Throwable -> L23
        Message r12 = r9.get(((ccb.c.a) r11).a);     // Catch: Throwable -> L23
        if (r12 == null) goto L15;
        CotContent r13 = r12.getCotContent();     // Catch: Throwable -> L23
    L16:
        if (r13 != null) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L10;
        r5.add(r11);     // Catch: Throwable -> L23
        goto L10
    L18:
        r14 = false;
        goto L19
    L15:
        r13 = null;
        goto L16
    L36:
        return r5;
    L23:
        th = move-exception;
        Log.w("FlowMessageSelectPlugin", "filter following cot messages failed", th);
        return r0;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
