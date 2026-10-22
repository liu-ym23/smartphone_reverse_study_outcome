package com.bytedance.android.anniex.container.popup;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.k;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.ies.xbridge.event.d, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f3172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.base.utils.logger.b f3173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f3174c;
    public final /* synthetic */ ug.d d;
    public final /* synthetic */ md.c e;
    public final /* synthetic */ f f;

    public b(Uri r5, com.bytedance.ies.bullet.base.utils.logger.b r10, Context r11, ug.d r12, md.c r13, f r14) {
        this.f3172a = r5;
        this.f3173b = r10;
        this.f3174c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // com.bytedance.ies.xbridge.event.d
    public void a(com.bytedance.ies.xbridge.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "jsEvent");
        ug.e r11 = r10.f6330b;
        if (r11 == null) goto L6;
        Intrinsics.checkNotNullParameter("code", "name");
        String r12 = ((JSONObject) r11.f22361b).optString("code");
        if (r12 == null) goto L6;
    L7:
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Uri r13 = this.f3172a;
        Map r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", r13.toString()), TuplesKt.to("code", r12)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("popup with show_on_success, receive pageReady event", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "popup with show_on_success, receive pageReady event", r14, this.f3173b);
        if (Intrinsics.areEqual(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, r12) == false) goto L10;
        this.e.d.putString("prerender", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        ug.d r15 = this.d;
        this.f.d(this.f3174c, r13, r15);
    L10:
        com.bytedance.ies.xbridge.event.b.c(this);
        return;
    L6:
        r12 = "0";
        goto L7
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void c(PoolResult r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        if (r10 != null) goto L5;
        String r12 = "";
    L6:
        Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("errorMsg", r12), TuplesKt.to("schema", this.f3172a.toString())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("popup with show_on_success, preRender failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "popup with show_on_success, preRender failed", r13, this.f3173b);
        if (((t9.a) this.d.g) == null) goto L10;
        Intrinsics.checkNotNullParameter(new PreRenderFailedException(r10), "throwable");
        return;
    L10:
        return;
    L5:
        r12 = r10;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void onSuccess(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessinId");
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Uri r11 = this.f3172a;
        Map r12 = MapsKt.mapOf(TuplesKt.to("schema", r11.toString()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("popup with show_on_success, preRender success", "msg");
        com.bytedance.ies.bullet.base.utils.logger.b r13 = this.f3173b;
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "popup with show_on_success, preRender success", r12, r13);
        Context r14 = this.f3174c;
        if ((r14 instanceof Activity) == false) goto L5;
        Activity r15 = (Activity) r14;
    L6:
        ug.d r16 = this.d;
        if (r15 != null) goto L9;
    L14:
        b r17 = new b(r11, r13, this.e, this.f, this.f3174c, r16);
        Lazy r18 = com.bytedance.ies.xbridge.event.b.f6326a;
        Intrinsics.checkNotNullParameter("pageReady", "eventName");
        Intrinsics.checkNotNullParameter(r17, "subscriber");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        com.bytedance.ies.xbridge.event.b.d("pageReady", r17, System.currentTimeMillis(), r10);
        return;
    L9:
        if (r15.isFinishing() != true) goto L14;
        if (((t9.a) r16.g) == null) goto L16;
        Intrinsics.checkNotNullParameter(new ActivityFinishedException(), "throwable");
        return;
    L16:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public b(Uri r5, com.bytedance.ies.bullet.base.utils.logger.b r10, md.c r11, f r12, Context r13, ug.d r14) {
        this.f3172a = r5;
        this.f3173b = r10;
        this.e = r11;
        this.f = r12;
        this.f3174c = r13;
        this.d = r14;
    }
}
