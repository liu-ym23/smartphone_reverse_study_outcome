package com.bytedance.android.anniex.container;

import com.bytedance.android.anniex.container.popup.PopupCloseType;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.ies.bullet.ui.common.Orientation;
import com.lynx.tasm.behavior.v0;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.bytedance.ies.bullet.core.kit.bridge.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3144b;

    public /* synthetic */ g(JSONObject r5, int r10) {
        this.f3143a = r10;
        this.f3144b = r5;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final String getName() {
        switch(this.f3143a) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return "screenOrientationChange";
    L8:
        return "perf";
    L10:
        return "keyboardStatusChange";
    L12:
        return "H5_keyboardStatusChange";
    L14:
        return "containerShouldClose";
    L16:
        return "keyboardStatusChange";
    L18:
        return "H5_keyboardStatusChange";
    L20:
        return "screenOrientationChange";
    L22:
        return "screenFoldStateChange";
    L5:
        return (String) this.f3144b;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final Object getParams() {
        switch(this.f3143a) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return (JSONObject) this.f3144b;
    L9:
        return (JSONObject) this.f3144b;
    L11:
        return (JSONObject) this.f3144b;
    L13:
        return (JSONObject) this.f3144b;
    L15:
        return (JSONObject) this.f3144b;
    L17:
        return (JSONObject) this.f3144b;
    L19:
        return (JSONObject) this.f3144b;
    L21:
        return (JSONObject) this.f3144b;
    L23:
        return (JSONObject) this.f3144b;
    }

    public g() {
        this.f3143a = 7;
        JSONObject r5 = new JSONObject();
        r5.put("perfBaseTimeStamp", String.valueOf(System.currentTimeMillis()));
        r5.put("perf", null);
        this.f3144b = r5;
    }

    public g(int r5, Map r10) {
        this.f3143a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f3144b = new JSONObject(r10);
        return;
    L6:
        this.f3144b = new JSONObject(r10);
    }

    public g(PopupCloseType r5) {
        this.f3143a = 4;
        JSONObject r10 = new JSONObject();
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r12 == null) goto L9;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.M0();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        r10.put("type", r5.a(r15));
        this.f3144b = r10;
        return;
    L9:
        r15 = true;
        goto L10
    }

    public g(BulletCardView r5) {
        this.f3143a = 9;
        this.f3144b = r5.f6174l;
    }

    public g(LinkedHashMap r5, Orientation r10, BulletCardView r11) {
        this.f3143a = 8;
        if (r5 == null) goto L5;
        JSONObject r12 = new JSONObject(r5);
    L6:
        String r13 = r10.name();
        Locale r14 = Locale.ROOT;
        if (r13 == null) goto L18;
        r12.put("screenOrientation", r13.toLowerCase(r14));
        xd.d r15 = v0.p(r11.getContext());
        if (r15 == null) goto L15;
        int r16 = UIUtils.px2dip(r11.getContext(), r15.f23106b);
        int r17 = UIUtils.px2dip(r11.getContext(), r15.f23105a);
        if (r10 != Orientation.f6194b) goto L13;
        r12.put("screenHeight", Math.min(r17, r16));
        r12.put("screenWidth", Math.max(r17, r16));
    L14:
        r12.put("kitViewHeight", null);
        boolean r18 = BulletCardView.D;
        r12.put("kitViewWidth", null);
        goto L15
    L13:
        r12.put("screenHeight", Math.max(r17, r16));
        r12.put("screenWidth", Math.min(r17, r16));
    L15:
        this.f3144b = r12;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        r12 = new JSONObject();
        goto L6
    }
}
