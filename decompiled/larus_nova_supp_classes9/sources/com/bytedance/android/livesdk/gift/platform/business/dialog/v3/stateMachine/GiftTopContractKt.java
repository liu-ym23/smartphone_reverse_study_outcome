package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.h;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anya/l0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState;", "state", BuildConfig.FLAVOR, "simpleStateString", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", "mode", BuildConfig.FLAVOR, "isGroupMode", "livegift-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class GiftTopContractKt {
    public static final boolean isGroupMode(GiftTopViewState.Mode r1) {
        Intrinsics.checkNotNullParameter(r1, "mode");
        if (r1 != GiftTopViewState.Mode.Group) goto L5;
    L8:
        return true;
    L5:
        if (r1 == GiftTopViewState.Mode.GroupContainer) goto L8;
        return false;
    }

    public static final String simpleStateString(l0<GiftTopViewState> r2, GiftTopViewState r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$simpleStateString");
        Intrinsics.checkNotNullParameter(r3, "state");
        StringBuilder r0 = new StringBuilder("GiftTopViewState{mode=");
        r0<GiftTopViewState, GiftTopViewState.Mode> r1 = r3.getMode();
        r2.getClass();
        r0.append((GiftTopViewState.Mode) h.b(r1));
        r0.append(",showDetail=");
        r0.append(((Boolean) h.b(r3.getShowDetail())).booleanValue());
        r0.append(",visible=");
        r0.append(((Boolean) h.b(r3.getVisibility())).booleanValue());
        r0.append('}');
        return r0.toString();
    }
}
