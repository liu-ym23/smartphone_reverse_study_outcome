package com.bytedance.android.annie.business.latch;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.p;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements o {
    public final String a;
    public final LynxView b;
    public final KitType c;
    public final j d;

    public final void b(String r1, p r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    public final void c() {
    }

    public final void f(byte[] r10, String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "templateArray");
        Intrinsics.checkNotNullParameter(r11, "baseUrl");
        Intrinsics.checkNotNullParameter(r12, "data");
    }

    public final void g() {
    }

    public final String getViewTag() {
        return "fakeKitViewService";
    }

    public final boolean k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaUrl");
        return true;
    }

    public final void m() {
    }

    public final boolean onBackPressed() {
        return false;
    }

    public final void onHide() {
    }

    public final void onShow() {
    }

    public final void sendEvent(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalprops");
    }

    public q26.j getContext() {
        return this.d;
    }

    public final KitType getKitType() {
        return this.c;
    }

    public final String getSessionId() {
        return this.a;
    }

    public final SccConfig.SccLevel i() {
        return SccConfig.SccLevel.SAFE;
    }

    public final View realView() {
        return this.b;
    }

    public k(String r10, LynxView r11) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        this.a = r10;
        this.b = r11;
        this.c = KitType.LYNX;
        this.d = new j();
    }
}
