package com.ss.android.lark.keyboard.biz.send.inject;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.base.e;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin$clickWrapper$1", f = "SendInnerEndPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SendInnerEndPlugin$clickWrapper$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$clickWrapper$1(SendInnerEndPlugin r1, Continuation<? super SendInnerEndPlugin$clickWrapper$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SendInnerEndPlugin$clickWrapper$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L81;
        ResultKt.throwOnFailure(r21);
        SendInnerEndPlugin r1 = this.this$0;
        SendInnerEndPlugin.a r2 = SendInnerEndPlugin.q;
        wxa.a r3 = (wxa.a) r1.m.getValue();
        f r9 = null;
        if (r3 == null) goto L7;
        List r4 = r3.q1();
    L8:
        if (r4 != null) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        if (r4.isEmpty() == true) goto L72;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L14:
        boolean r10 = true;
        String r12 = "";
        if (r6.hasNext() == false) goto L32;
        Object r7 = r6.next();
        String r8 = ((UplinkFileEntity) r7).getFileIdentifier();
        if (r8 == null) goto L21;
        r12 = r8;
    L21:
        if (r12.length() <= 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == true) goto L26;
    L28:
        r10 = false;
    L29:
        if (r10 == false) goto L14;
        r5.add(r7);
        goto L14
    L26:
        if (r1.h.contains(r12) == false) goto L28;
    L23:
        r11 = false;
        goto L24
    L32:
        if (r5.isEmpty() == true) goto L72;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r5.iterator();
    L36:
        if (r14.hasNext() == false) goto L40;
        String r15 = ((UplinkFileEntity) r14.next()).getFileIdentifier();
        if (r15 == null) goto L36;
        r13.add(r15);
        goto L36
    L40:
        Log.i("SendInnerEndPlugin", "retryFailedUploadsAndWaitIfNeed: retry uploadIds=" + CollectionsKt.toSet(r13));
        Iterator r16 = r5.iterator();
    L42:
        if (r16.hasNext() == false) goto L72;
        UplinkFileEntity r17 = (UplinkFileEntity) r16.next();
        String r18 = r17.getFileIdentifier();
        if (r18 != null) goto L46;
        String r19 = "";
    L48:
        if (r19.length() != 0) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == true) goto L42;
        String r22 = r1.a.c.getId();
        if (r22 == null) goto L42;
        String r23 = r1.l(r17);
        if (r23 != null) goto L59;
        String r24 = "";
    L60:
        r1.g.remove(r19);
        if (r1.g.add(r19) == false) goto L42;
        r1.h.remove(r19);
        r17.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
        if (r17.getUpLinkProcess() == null) goto L70;
        Integer r25 = r17.getUpLinkProcess();
        if (r25 != null) goto L69;
    L71:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1.a.a), null, null, new SendInnerEndPlugin$forceRetryUpload$1(r1, r22, r19, r24, r17, null), 3, null);
        goto L42
    L69:
        if (r25.intValue() != (-1)) goto L71;
    L70:
        r17.setUpLinkProcess(0);
        goto L71
    L59:
        r24 = r23;
        goto L60
    L50:
        r20 = false;
        goto L51
    L46:
        r19 = r18;
    L72:
        com.ss.android.lark.keyboard.keyboard2.b r26 = this.this$0.k().L();
        if ((r26 instanceof f) == false) goto L75;
        r9 = (f) r26;
    L75:
        f r27 = r9;
        if (r27 == null) goto L78;
        r r110 = new r(null, false, false, null, null, null, false, null, (ConcurrentHashMap) this.this$0.o.getValue(), 4194303);
        int r28 = e.a;
        r27.F(true, null, true, null, r110);
    L78:
        ((ConcurrentHashMap) this.this$0.o.getValue()).clear();
        return Unit.INSTANCE;
    L7:
        r4 = null;
        goto L8
    L81:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
