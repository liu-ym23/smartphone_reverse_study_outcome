package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaEngine", f = "FlowMfaEngine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CHATTER, BaseField.FIELD_TYPE_C_DESCRIPTION, 54, 59, 63}, m = "startFirstParty-BWLJW6A", n = {"activity", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startTime", "awaitingSessionResult", "activity", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startTime", "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startTime", "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startTime", "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startTime", "awaitingSessionResult"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0"})
public final class FlowMfaEngine$startFirstParty$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaEngine this$0;

    public FlowMfaEngine$startFirstParty$1(FlowMfaEngine r1, Continuation<? super FlowMfaEngine$startFirstParty$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.e(null, null, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
