package com.larus.security.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.security.api.ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1", f = "ReportDialogHelper.kt", i = {0, 0, 1}, l = {84, 91}, m = "invokeSuspend", n = {"$this$launch", "clipLogId", "clipLogId"}, s = {"L$0", "L$1", "L$0"})
public final class ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $context;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ String $originUrl;
    final /* synthetic */ List<Message> $shareMsgList;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1(List<Message> r1, List<Message> r2, String r3, FragmentActivity r4, Continuation<? super ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1> r5) {
        this.$shareMsgList = r1;
        this.$msgList = r2;
        this.$originUrl = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1 r6 = new ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1(this.$shareMsgList, this.$msgList, this.$originUrl, this.$context, r9);
        r6.L$0 = r8;
        return r6;
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
        String r3 = null;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Context r2 = (Context) this.L$2;
        ReportDialogHelper r5 = (ReportDialogHelper) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
    L34:
        SaveMessageShareInfo r13 = (SaveMessageShareInfo) ((BizResponse) r12).getData();
        if (r13 == null) goto L37;
        r3 = r13.getShareUrl();
    L37:
        r5.getClass();
        ReportDialogHelper.a(r2, r3, r6);
    L40:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r7 = (String) this.L$1;
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        String r14 = r7;
    L21:
        String r9 = this.$originUrl;
        if (r9 != null) goto L24;
    L27:
        if (r4 == true) goto L29;
    L38:
        ReportDialogHelper r10 = ReportDialogHelper.a;
        FragmentActivity r11 = this.$context;
        String r15 = this.$originUrl;
        r10.getClass();
        ReportDialogHelper.a(r11, r15, r14);
        goto L40
    L29:
        if (AppHost.a.isPlugin() == true) goto L38;
        Deferred r16 = BuildersKt.async$default(r8, Dispatchers.getIO(), null, new ReportDialogHelper$showReportDialogByMessage$1$dialog$2$cancel$1$requestShareData$1(this.$shareMsgList, null), 2, null);
        ReportDialogHelper r17 = ReportDialogHelper.a;
        Context r18 = this.$context;
        this.L$0 = r14;
        this.L$1 = r17;
        this.L$2 = r18;
        this.label = 2;
        Object r19 = r16.await(this);
        if (r19 != r0) goto L33;
        return r0;
    L33:
        r6 = r14;
        r12 = r19;
        r5 = r17;
        r2 = r18;
        goto L34
    L24:
        if (r9.length() == 0) goto L27;
        r4 = false;
        goto L27
    L10:
        ResultKt.throwOnFailure(r12);
        r8 = (CoroutineScope) this.L$0;
        Message r110 = (Message) CollectionsKt.lastOrNull(this.$shareMsgList);
        if (r110 == null) goto L14;
        r14 = a.x(r110);
        if (r14 == null) goto L14;
    L18:
        int r20 = g.a;
        List<Message> r21 = this.$shareMsgList;
        this.L$0 = r8;
        this.L$1 = r14;
        this.label = 1;
        if (g.b(r21, 6, this) != r0) goto L21;
        return r0;
    L14:
        Message r111 = (Message) CollectionsKt.lastOrNull(this.$msgList);
        if (r111 == null) goto L17;
        r14 = a.x(r111);
        goto L18
    L17:
        r14 = null;
        goto L18
    }
}
