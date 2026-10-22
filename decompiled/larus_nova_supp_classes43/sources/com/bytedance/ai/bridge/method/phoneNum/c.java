package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.phoneNum.AbsGetPhoneNumberMethodIDL;
import f3.h;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ h a;
    public final /* synthetic */ GetPhoneNumFlow b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(h r1, GetPhoneNumFlow r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final Object invoke(Object r12) {
        h r0 = this.a;
        GetPhoneNumFlow r1 = this.b;
        String r10 = this.c;
        int r11 = GetPhoneNumFlow.b;
        Object r13 = ((Result) r12).unbox-impl();
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 != null) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new GetPhoneNumFlow$handle$moaConsumed$1$1$1$1(r1, r10, null), 3, null);
        Intrinsics.checkNotNullParameter(AbsGetPhoneNumberMethodIDL.b.class, "<this>");
        BaseModel r15 = k3.c.a(AbsGetPhoneNumberMethodIDL.b.class);
        AbsGetPhoneNumberMethodIDL.b r16 = (AbsGetPhoneNumberMethodIDL.b) r15;
        r16.setCode((String) r13);
        r16.setMessage("success");
        h.a.b(r0, (ResultModel) r15);
    L7:
        return Unit.INSTANCE;
    L5:
        h.a.a(r0, "Error: " + r14.getMessage(), null, null, 12);
        goto L7
    }
}
