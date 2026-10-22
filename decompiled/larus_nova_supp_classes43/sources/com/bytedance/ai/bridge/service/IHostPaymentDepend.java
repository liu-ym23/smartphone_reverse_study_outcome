package com.bytedance.ai.bridge.service;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\fH&J>\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostPaymentDepend;", "", "preparePaymentAuthorization", "", a.VALUE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "extraInfo", "Landroid/os/Bundle;", "traceInfo", "", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", a.KEY_SHOPPING_GUIDE_NAME, "awemeBindStatus", "createPayOrder", "data", "type", "Lcom/bytedance/ai/bridge/service/AppletPayType;", "Lcom/bytedance/ai/bridge/service/OnPayOrderResultCallback;", "openDyPay", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostPaymentDepend {
    void createPayOrder(FragmentActivity r1, String r10, AppletPayType r11, Map<String, ? extends Object> r12, OnPayOrderResultCallback r13);

    void openDyPay(FragmentActivity r1, String r10, OnPayOrderResultCallback r11);

    void preparePaymentAuthorization(FragmentActivity r1, Bundle r10, Map<String, ? extends Object> r11, Function1<? super Boolean, Unit> r12);
}
