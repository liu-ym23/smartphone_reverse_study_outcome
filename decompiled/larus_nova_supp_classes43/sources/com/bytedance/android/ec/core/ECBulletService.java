package com.bytedance.android.ec.core;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.hybrid.ECBridgeProvider;
import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.host.api.core.api.IECBulletService;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kg.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pd.b;
import ti.d;
import ti.e;
import ti.h;
import ti.i;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J²\u0001\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007H\u0016J\"\u0010%\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\"\u0010&\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016JN\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u0011H\u0016J\b\u00101\u001a\u000200H\u0016J\"\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0016R\u0014\u00106\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/ec/core/ECBulletService;", "Lcom/bytedance/android/ec/host/api/core/api/IECBulletService;", "", "factory", "", "injectExternalBridges", "getCoreProvider", "", "getBid", "Landroid/content/Context;", "context", a.KEY_SCHEMA, "Lorg/json/JSONObject;", "extras", "", "type", "triggerOrigin", "", "showClose", "height", "maskColor", "closeByMask", "closeByGesture", "keyboardStyle", "style", "blockBackPress", "listenKeyboard", "lastContainerId", "Lkotlin/Function1;", "containerCB", "loadStatusCB", "showBulletPanel", "containerID", "closeBulletPanel", a.KEY_URL, "Landroid/os/Bundle;", "bundle", "openWithRifle", "openSchema", "", "initialData", "Landroid/view/ViewGroup;", "viewGroup", "Lti/k;", "callback", "useAnnie", "Lti/l;", "createLiveHybridComponent", "Lti/h;", "getBridgeProvider", "Lti/e;", "lifecycle", "Lti/d;", "createLiveAnnieComponent", "TAG", "Ljava/lang/String;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBulletService implements IECBulletService {
    private final String TAG;

    public void closeBulletPanel(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerID");
    }

    public String getBid() {
        return "EC";
    }

    public Object getCoreProvider() {
        return null;
    }

    public void openSchema(Context r1, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
    }

    public void openWithRifle(Context r1, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
    }

    public void showBulletPanel(Context r10, String r11, JSONObject r12, int r13, int r14, boolean r15, int r16, String r17, boolean r18, boolean r19, JSONObject r110, JSONObject r111, boolean r112, boolean r113, String r114, Function1<? super String, Unit> r115, Function1<? super String, Unit> r116) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r17, "maskColor");
        Intrinsics.checkNotNullParameter(r114, "lastContainerId");
    }

    public h getBridgeProvider() {
        return (ECBridgeProvider) ECBridgeProvider.a.getValue();
    }

    public ECBulletService() {
        this.TAG = kg.a.a("ECBulletService");
    }

    public void injectExternalBridges(Object r10) {
        Lazy r0 = ECBridgeProviderInjector.b;
        ECBridgeProviderInjector r1 = ECBridgeProviderInjector.a.a();
        if ((r10 instanceof i) == true) goto L5;
        r10 = null;
    L5:
        i r11 = (i) r10;
        if (r11 == null) goto L8;
        ((CopyOnWriteArrayList) r1.a).add(r11);
        return;
    L8:
        r1.getClass();
    }

    public d createLiveAnnieComponent(Context r10, String r11, e r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        ECLiveHybridUtil.a r0 = ECLiveHybridUtil.a;
        b r13 = ECLiveHybridUtil.a(r10, r11, new c(r12));
        Objects.toString(r13);
        if (r13 != null) goto L5;
        return null;
    L5:
        return new kg.b(r13);
    }

    public ti.c createAnnieCardComponentAndRegisterCrashMonitor(Context r10, ViewGroup r11, String r12, boolean r13, Map<String, ? extends Object> r14, ti.b r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "viewGroup");
        Intrinsics.checkNotNullParameter(r12, a.KEY_URL);
        Intrinsics.checkNotNullParameter(r15, "callback");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "viewGroup");
        Intrinsics.checkNotNullParameter(r12, a.KEY_URL);
        Intrinsics.checkNotNullParameter(null, "callback");
        return null;
    }

    public l createLiveHybridComponent(Context r14, String r15, Map<String, ? extends Object> r16, ViewGroup r17, k r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, a.KEY_URL);
        return ECLiveHybridUtil.b(r14, r15, r16, r17, r18, null, null, false, null, null, false, 4064);
    }
}
