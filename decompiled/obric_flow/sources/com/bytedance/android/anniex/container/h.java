package com.bytedance.android.anniex.container;

import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements com.bytedance.ies.bullet.core.kit.bridge.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s3.b f3147c;

    public /* synthetic */ h(boolean r5, s3.b r10, int r11) {
        this.f3145a = r11;
        this.f3146b = r5;
        this.f3147c = r10;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final String getName() {
        switch(this.f3145a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "pageVisibilityChange";
    L6:
        return "pageVisibilityChange";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final Object getParams() {
        switch(this.f3145a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        JSONObject r5 = new JSONObject();
        r5.put("visible", this.f3146b);
        AnnieXLiteContainer r10 = (AnnieXLiteContainer) this.f3147c;
        if (Intrinsics.areEqual(r10.getViewType(), "card") == true) goto L10;
        s3.f r11 = AnnieXLiteContainer.access$getUiComponent$p(r10);
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r11 = null;
    L9:
        r11.getClass();
        r5.put("source", "page");
    L10:
        return r5;
    L11:
        JSONObject r12 = new JSONObject();
        r12.put("visible", this.f3146b);
        AnnieXContainer r13 = (AnnieXContainer) this.f3147c;
        if (Intrinsics.areEqual(r13.getViewType(), "card") == true) goto L17;
        s3.f r14 = AnnieXContainer.access$getUiComponent$p(r13);
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r14 = null;
    L16:
        r14.getClass();
        r12.put("source", "page");
    L17:
        return r12;
    }
}
