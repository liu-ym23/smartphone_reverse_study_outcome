package com.bytedance.android.live.browser;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements IExternalLiveAnnieComponent {
    public final HybridCard a;

    public final View getHybridView() {
        Objects.toString(this.a);
        return this.a;
    }

    public final void release() {
        this.a.release();
    }

    public p(HybridCard r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridCard");
        this.a = r2;
    }

    public final void updateData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a.updateData(r2);
    }

    public final void load(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        this.a.load(r2, r3);
    }

    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a.registerMethod(r2, r3);
    }

    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.sendJsEvent(r2, r3);
    }

    public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.a.registerMethod(r2, r3);
    }
}
