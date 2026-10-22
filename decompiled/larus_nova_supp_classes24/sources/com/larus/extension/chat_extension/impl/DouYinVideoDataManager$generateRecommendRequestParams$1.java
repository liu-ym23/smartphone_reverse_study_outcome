package com.larus.extension.chat_extension.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.extension.chat_extension.impl.DouYinVideoDataManager", f = "DouYinVideoDataManager.kt", i = {}, l = {47}, m = "generateRecommendRequestParams", n = {}, s = {})
final class DouYinVideoDataManager$generateRecommendRequestParams$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DouYinVideoDataManager$generateRecommendRequestParams$1(a r1, Continuation<? super DouYinVideoDataManager$generateRecommendRequestParams$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        throw null;
    }
}
