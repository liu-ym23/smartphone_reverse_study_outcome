package com.larus.security.api;

import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.security.api.ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1", f = "ReportDialogHelper.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<SaveMessageShareInfo>>, Object> {
    final /* synthetic */ List<Message> $shareMsgList;
    int label;

    public ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1(List<Message> r1, Continuation<? super ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1> r2) {
        this.$shareMsgList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1(this.$shareMsgList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L29:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ReportDialogHelper r11 = ReportDialogHelper.a;
        List<Message> r2 = this.$shareMsgList;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L26;
        Object r5 = r4.next();
        Message r6 = (Message) r5;
        Map r7 = r6.getExt();
        String r8 = null;
        if (r7 == null) goto L14;
        String r9 = (String) r7.get("forbid_message_share");
    L16:
        if (Intrinsics.areEqual(r9, "1") == true) goto L23;
        Map r12 = r6.getExt();
        if (r12 == null) goto L21;
        r8 = (String) r12.get("is_crowd_testing");
    L21:
        if (Intrinsics.areEqual(r8, "1") == true) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L10;
        r3.add(r5);
    L23:
        r13 = false;
        goto L24
    L14:
        r9 = null;
        goto L16
    L26:
        this.label = 1;
        r10 = r11.b(r3, this);
        if (r10 != r0) goto L29;
        return r0;
    }
}
