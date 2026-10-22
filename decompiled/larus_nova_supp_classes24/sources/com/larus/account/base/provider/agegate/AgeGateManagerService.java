package com.larus.account.base.provider.agegate;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s38.a;
import s38.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/larus/account/base/provider/agegate/AgeGateManagerService;", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "impl$delegate", "Lkotlin/Lazy;", "onPassAgeGate", "", "pass", "", "verifyAgeGate", "callback", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "platform", "", "trackerJson", "Lorg/json/JSONObject;", "getLoginPlatform", "getNeutralAgeGateStyle", "", "()Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AgeGateManagerService implements IAgeGateManagerInterface {
    public static final AgeGateManagerService a = null;
    public static final Lazy b = null;

    private AgeGateManagerService() {
    }

    static {
        a = new AgeGateManagerService();
        b = LazyKt.lazy(new a());
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final Integer b() {
        IAgeGateManagerInterface r0 = (IAgeGateManagerInterface) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final String getLoginPlatform() {
        IAgeGateManagerInterface r0 = (IAgeGateManagerInterface) b.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.getLoginPlatform();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void c(boolean r2) {
        IAgeGateManagerInterface r0 = (IAgeGateManagerInterface) b.getValue();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void a(b r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "platform");
        IAgeGateManagerInterface r0 = (IAgeGateManagerInterface) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }
}
