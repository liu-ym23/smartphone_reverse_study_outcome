package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.core.network.FlowPassportAccountsHttpClient", f = "FlowPassportAccountsHttpClient.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {55, 66}, m = "executeAccounts", n = {"userId", AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, "method", "queryParams", "headers", "body", "requestId", "environment", "timeoutSeconds", "userTriggered", "includeLoginInfo", "userId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "Z$0", "Z$1", "L$0"})
public final class FlowPassportAccountsHttpClient$executeAccounts$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowPassportAccountsHttpClient this$0;

    public FlowPassportAccountsHttpClient$executeAccounts$1(FlowPassportAccountsHttpClient r1, Continuation<? super FlowPassportAccountsHttpClient$executeAccounts$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, null, null, 0, false, false, this);
    }
}
