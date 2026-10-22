package com.larus.uaigc.createpage.bussiness.remove;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2", f = "ImageRemoveFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bundle $params;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2(Bundle r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2> r3) {
        this.$params = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2(this.$params, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r24);
        Serializable r1 = this.$params.getSerializable("creation_send_ui_event");
        String r4 = null;
        if ((r1 instanceof CreationSendUiEvent) == false) goto L7;
        CreationSendUiEvent r2 = (CreationSendUiEvent) r1;
    L8:
        if (r2 != null) goto L13;
        ImageRemoveFragment r3 = this.this$0;
        int r5 = ImageRemoveFragment.v;
        r3.getClass();
        CreationSendMessageConfig r6 = r3.t;
        if (r6 == null) goto L12;
        r4 = r6.getCvsId();
    L12:
        r2 = new CreationSendUiEvent(r4, null, false, true, true, true, false, false, false, false, false, false, false, false, false, 32710, null);
    L13:
        Bundle r7 = new Bundle(this.$params);
        r7.putSerializable("creation_send_ui_event", r2);
        r7.putBoolean("end_modify", true);
        r7.putString("result_from", "creation");
        ImageRemoveFragment r8 = this.this$0;
        int r9 = ImageRemoveFragment.v;
        FragmentActivity r10 = r8.X90();
        if (r10 == null) goto L16;
        ImageRemoveFragment r11 = this.this$0;
        FragmentManager r12 = r10.getSupportFragmentManager();
        String r13 = r2.getCvsId();
        r11.getClass();
        xe8.a r14 = ImageRemoveFragment.Z90(r12, r13);
        if (r14 == null) goto L20;
        r14.Lc(r7, 0, -1);
        int r15 = com.larus.uaigc.applet.a.a;
        if (IAICreationAppletHostService.a.i(true) == true) goto L27;
        FragmentActivity r16 = this.this$0.getActivity();
        if (r16 == null) goto L27;
        r16.finish();
    L27:
        return Boxing.boxBoolean(true);
    L20:
        return Boxing.boxBoolean(false);
    L16:
        return Boxing.boxBoolean(false);
    L7:
        r2 = null;
        goto L8
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
