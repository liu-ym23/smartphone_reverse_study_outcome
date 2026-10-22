package com.ss.android.lark.compose.chatsetting.report;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.compose.chatsetting.bridge.SelectChatMessagesBridge;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.report.FlowReportManager$report$1", f = "FlowReportManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class FlowReportManager$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ Context $context;
    int label;

    public FlowReportManager$report$1(Context r1, String r2, Continuation<? super FlowReportManager$report$1> r3) {
        this.$context = r1;
        this.$chatId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowReportManager$report$1(this.$context, this.$chatId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L11:
        com.larksuite.rucket.job.base.b.b r4 = (com.larksuite.rucket.job.base.b) r3;
        if ((r4 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L15;
        StringBuilder r5 = new StringBuilder("get report url failed, error = ");
        com.larksuite.rucket.job.base.b.b r6 = r4;
        r5.append(r6.b.getDisplayMsg());
        Log.e("ChatSettingViewModel", r5.toString());
        String r7 = UIUtils.getString(this.$context, 2131891305);
        FlowToast.d(this.$context, r6.b.getDisplayMsg(r7));
        return Unit.INSTANCE;
    L15:
        String r8 = ((GenLarkReportUrlResponse) r4.b()).mreport_url;
        if (TextUtils.isEmpty(r8) == false) goto L19;
        String r9 = UIUtils.getString(this.$context, 2131891305);
        Context r10 = this.$context;
        Intrinsics.checkNotNull(r9);
        FlowToast.d(r10, r9);
        Log.e("ChatSettingViewModel", "report, url is empty");
        return Unit.INSTANCE;
    L19:
        OpenConfig r11 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        r11.setShowLoading(true);
        ChameleonConfig r12 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_CHAT.getType()).loadUrl(r8).openConfig(r11).build();
        ArrayList r13 = new ArrayList();
        r13.add(new SelectChatMessagesBridge());
        Chameleon r14 = Chameleon.a;
        Chameleon.b(this.$context, r12, r13);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        FlowReportManager$report$1$response$1 r16 = new FlowReportManager$report$1$response$1(this.$chatId, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r15, r16, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
