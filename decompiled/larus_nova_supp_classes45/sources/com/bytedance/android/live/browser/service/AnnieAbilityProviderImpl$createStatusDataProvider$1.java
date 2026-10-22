package com.bytedance.android.live.browser.service;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnnieAbilityProviderImpl$createStatusDataProvider$1 implements w8.e {
    public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.i.d a;
    public final /* synthetic */ y6.c b;

    public final Map<String, Object> a() {
        return UtilsKt.i(this.a.a());
    }

    public final void release() {
        this.a.release();
    }

    public AnnieAbilityProviderImpl$createStatusDataProvider$1(com.bytedance.android.live.browser.jsbridge.i.d r1, JSBridgeManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(String r3, JSONArray r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r5, "stateSubscriber");
        this.a.b(r3, r4, new AnnieAbilityProviderImpl$createStatusDataProvider$1$observeWith$1(this), r5);
    }
}
