package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECAlbumScanMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Ltf3/c;", com.bytedance.android.ec.core.event.a.KEY_RESULT, "", "onMessage", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAlbumScanMethod extends ECBaseBridgeMethod {
    public ECBaseBridgeMethod.a e;
    public final String f;

    public ECAlbumScanMethod() {
        this.f = "ecAlbumScan";
    }

    public final String getName() {
        return this.f;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(tf3.c r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        if (this.e != null) goto L6;
        this.e = null;
        EventBus.getDefault().unregister(this);
        return;
    L6:
        new JSONObject();
        throw null;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        Context r12 = getContext();
        if (r12 == null) goto L6;
        this.e = r11;
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().register(this);
        p.a.openSchema(r12, "sslocal://aweme/scanAlbum");
        return;
    }
}
