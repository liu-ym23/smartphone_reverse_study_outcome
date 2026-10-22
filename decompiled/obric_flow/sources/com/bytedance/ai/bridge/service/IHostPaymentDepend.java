package com.bytedance.ai.bridge.service;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostPaymentDepend;", "", "createPayOrder", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "data", "", "callback", "Lcom/bytedance/ai/bridge/service/OnPayOrderResultCallback;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHostPaymentDepend {
    void createPayOrder(FragmentActivity r5, String r10, OnPayOrderResultCallback r11);
}
