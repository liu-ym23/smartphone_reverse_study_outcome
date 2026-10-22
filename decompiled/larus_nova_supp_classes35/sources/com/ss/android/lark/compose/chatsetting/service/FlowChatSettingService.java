package com.ss.android.lark.compose.chatsetting.service;

import b38.b;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.GenLarkReportUrlRequest;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowChatSettingService {
    public static final FlowChatSettingService a = null;

    static {
        a = new FlowChatSettingService();
    }

    public FlowChatSettingService() {
    }

    public final Object a(String r8, Continuation<? super RucketJob<GenLarkReportUrlResponse>> r9) {
        if ((r9 instanceof FlowChatSettingService$getReportUrl$1) == false) goto L7;
        FlowChatSettingService$getReportUrl$1 r0 = (FlowChatSettingService$getReportUrl$1) r9;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RucketJobImpl r11 = (RucketJobImpl) r0.L$0;
        ResultKt.throwOnFailure(r10);
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Intrinsics.checkNotNullParameter(r8, "chatId");
        long r12 = CastLongProtector.parseLong(r8);     // Catch: Throwable -> L24
        int r4 = com.ss.android.lark.language.service.impl.a.f;
        Locale r5 = com.ss.android.lark.language.service.impl.a.b.a.getCacheLanguageSetting();
        StringBuilder r6 = new StringBuilder();
        String r7 = r5.getLanguage();
        String r13 = BuildConfig.FLAVOR;
        if (r7 != null) goto L19;
        r7 = BuildConfig.FLAVOR;
    L19:
        r6.append(r7);
        r6.append('-');
        String r14 = r5.getCountry();
        if (r14 == null) goto L23;
        r13 = r14;
    L23:
        r6.append(r13);
        String r15 = r6.toString();
        GenLarkReportUrlRequest.Builder r16 = new GenLarkReportUrlRequest.Builder().chat_id(Long.valueOf(r12)).lang_type(r15);
    L26:
        if (r16 != null) goto L28;
        RucketJobImpl r17 = new RucketJobImpl();
        ErrorResult r18 = new ErrorResult("generate request failed");
        r0.L$0 = r17;
        r0.label = 1;
        if (r17.setError(r18, r0) != r2) goto L35;
        return r2;
    L35:
        return r17;
    L28:
        return ((a) b.a.create(a.class)).getReportUrl(r16.build());
    L24:
        th = move-exception;
        Log.e("FlowChatSettingService", th);
        r16 = null;
    L7:
        r0 = new FlowChatSettingService$getReportUrl$1(this, r9);
        goto L8
    }
}
