package com.bytedance.android.annie.business.latch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements h16.e {
    public final String a;
    public final String b;
    public final BulletContext c;
    public final k d;

    public final void Wn(View r1, int r10, int r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r1, "loadingView");
    }

    public final h16.d getActivityWrapper() {
        return null;
    }

    public final Uri getProcessingUri() {
        return null;
    }

    public final t36.j getSchemaModelUnion() {
        return null;
    }

    public void onEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
    }

    public final void qq(String r10, List<String> r11, List<? extends JSONObject> r12) {
        Intrinsics.checkNotNullParameter(r10, "actionType");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r12, "params");
    }

    public final void r0() {
    }

    public final void release() {
    }

    public final void v() {
    }

    public final void yc() {
    }

    public final Uri getCurrentUri() {
        return UriProtector.parse(this.a);
    }

    public final BulletContext getBulletContext() {
        return this.c;
    }

    public final o getKitView() {
        return this.d;
    }

    public final String getSessionId() {
        return this.b;
    }

    public i(Context r10, String r11, String r12, LynxView r13) {
        Intrinsics.checkNotNullParameter(r10, "viewContext");
        Intrinsics.checkNotNullParameter(r11, "pageUrl");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        Intrinsics.checkNotNullParameter(r13, "view");
        this.a = r11;
        this.b = r12;
        Lazy r14 = BulletContextManager.b;
        BulletContextManager.a.a().getClass();
        BulletContext r15 = new BulletContext();
        r15.b(r10);
        this.c = r15;
        this.d = new k(r12, r13);
    }
}
