package com.bytedance.android.anniex.ability;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b implements u26.d {
    public final KitType a;

    public final void b(String r1, com.bytedance.ies.bullet.service.base.p r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    public final void c() {
    }

    public final void f(byte[] r10, String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "templateArray");
        Intrinsics.checkNotNullParameter(r11, "baseUrl");
        Intrinsics.checkNotNullParameter(r12, "data");
    }

    public void g() {
    }

    public abstract /* synthetic */ q26.j getContext();

    public String getSessionId() {
        return null;
    }

    public final void h(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
    }

    public final void m() {
    }

    public final void n(String r10, com.bytedance.ies.bullet.core.q r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "lifeCycle");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
    }

    public final boolean onBackPressed() {
        return false;
    }

    public void onHide() {
    }

    public void onShow() {
    }

    public View realView() {
        return null;
    }

    public void sendEvent(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalprops");
    }

    public final void updateScreenMetrics(int r1, int r10) {
    }

    public b() {
        this.a = KitType.LYNX;
    }

    public final KitType getKitType() {
        return this.a;
    }

    public final SccConfig.SccLevel i() {
        return SccConfig.SccLevel.SAFE;
    }

    public final boolean k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaUrl");
        Intrinsics.checkNotNullParameter(r10, "schemaUrl");
        return true;
    }
}
