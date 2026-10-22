package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import ju1.m;
import ju1.n;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements iu1.b {
    public final PropertyOwner<n> a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        boolean r0 = a0.d(this.b, false);
        IRoom r1 = a0.n(this.b);
        Lazy r2 = PublicScreenABHelper.a;
        if (q.g(r1) == null) goto L6;
    L35:
        String r3 = null;
    L37:
        if (r3 == null) goto L44;
        ju1.h r4 = mu1.b.d(r3);
        if (r4 == null) goto L44;
        if (TextUtils.equals(r4.b(), "public_screen_speed_strategy") == false) goto L44;
        return r4;
    L44:
        return new m("public_screen_speed_strategy", -1);
    L6:
        if (r0 == false) goto L21;
        if (r1 == null) goto L13;
        IRoomAuthStatus r5 = r1.getRoomAuthStatus();
        if (r5 == null) goto L13;
        if (r5.isEnableAnchorChatDynamicSlideSpeed() == false) goto L35;
    L13:
        Lazy r6 = PublicScreenABHelper.g;
        if (TextUtils.isEmpty((String) r6.getValue()) == true) goto L35;
        List r7 = ((j0) PublicScreenABHelper.h.getValue()).b();
        if (r7 == null) goto L35;
        if ((!r7.isEmpty()) != true) goto L35;
        r3 = (String) r6.getValue();
        goto L37
    L21:
        if (r1 == null) goto L27;
        IRoomAuthStatus r8 = r1.getRoomAuthStatus();
        if (r8 == null) goto L27;
        if (r8.isEnableChatDynamicSlideSpeed() == false) goto L35;
    L27:
        Lazy r9 = PublicScreenABHelper.e;
        if (TextUtils.isEmpty((String) r9.getValue()) == true) goto L35;
        List r10 = ((j0) PublicScreenABHelper.f.getValue()).b();
        if (r10 == null) goto L35;
        if ((!r10.isEmpty()) != true) goto L35;
        r3 = (String) r9.getValue();
        goto L37
    }

    public j(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r4;
        this.a = new PropertyOwner(new n(2, true));
    }

    @Override // iu1.b
    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof ju1.g) == true) goto L13;
    L11:
        this.a.a(r3);
        return;
    L13:
        int r0 = lu1.k.a;     // Catch: Exception -> L9
        PublicScreenSpeedStrategyV2$traceResult$1 r1 = new PublicScreenSpeedStrategyV2$traceResult$1(r3);     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(r1, "info");     // Catch: Exception -> L9
        if (v.a() == false) goto L11;
        ALogger.i("DynamicStrategy", (String) r1.invoke());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ALogger.e("public_screen_speed_strategy", e);
        goto L11
    }

    @Override // iu1.b
    public final void b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof ju1.g) == true) goto L13;
    L11:
        this.a.a(r3);
        return;
    L13:
        int r0 = lu1.k.a;     // Catch: Exception -> L9
        PublicScreenSpeedStrategyV2$traceResult$1 r1 = new PublicScreenSpeedStrategyV2$traceResult$1(r3);     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(r1, "info");     // Catch: Exception -> L9
        if (v.a() == false) goto L11;
        ALogger.i("DynamicStrategy", (String) r1.invoke());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ALogger.e("public_screen_speed_strategy", e);
        goto L11
    }
}
