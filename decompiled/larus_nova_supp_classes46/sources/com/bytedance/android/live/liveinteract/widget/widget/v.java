package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public final Map<String, com.bytedance.android.live.liveinteract.plantform.dynamicframe.h> a;
    public final Context b;
    public final DataCenter c;
    public final a d;

    public interface a {
        View c();
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.d {
        public final /* synthetic */ v a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ih0.h c;

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
        public final void onRelease() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
        public final void onSuccess() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
        public final void onFail() {
            this.a.a(this.b);
            this.c.a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
        }

        public c(v r1, String r2, ih0.h r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void a(String r2) {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.h r3 = this.a.remove(r2);
        if (r3 == null) goto L16;
        r3.b();
        ih0.c r0 = r3.a;
        if (r0 == null) goto L17;
        View r1 = r0.S0();
        if (r1 == null) goto L18;
        ViewGroup r4 = UtilityKotlinExtentionsKt.p(r1);
        if (r4 == null) goto L19;
        ih0.c r5 = r3.a;
        if (r5 == null) goto L13;
        View r6 = r5.S0();
    L14:
        r4.removeView(r6);
        return;
    L13:
        r6 = null;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public v(Context r2, DataCenter r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new LinkedHashMap();
    }

    public final void b(String r21, JsonObject r22, ih0.h r23) {
        Intrinsics.checkNotNullParameter(r21, "type");
        Intrinsics.checkNotNullParameter(r22, "data");
        Intrinsics.checkNotNullParameter(r23, "updateCallback");
        ALogger.i("MultiLinkUpdateViewInLiveBgManager", "updateViewInLiveBgEvent type=" + r21 + " data=" + r22);
        View r4 = this.d.c();
        JsonElement r5 = r22.get("id");
        if (r5 == null) goto L6;
        String r6 = r5.getAsString();
        if (r6 == null) goto L6;
    L7:
        JsonElement r7 = r22.get("x");
        if (r7 == null) goto L10;
        int r8 = r7.getAsInt();
    L11:
        JsonElement r9 = r22.get("y");
        if (r9 == null) goto L14;
        int r10 = r9.getAsInt();
    L15:
        JsonElement r11 = r22.get("width");
        if (r11 == null) goto L18;
        int r12 = r11.getAsInt();
    L19:
        JsonElement r13 = r22.get("height");
        if (r13 == null) goto L22;
        int r14 = r13.getAsInt();
    L23:
        JsonElement r15 = r22.get("schema");
        if (r15 == null) goto L29;
        String r16 = r15.getAsString();
        if (r16 == null) goto L29;
        String r17 = r16;
    L30:
        JsonElement r18 = r22.get("url");
        if (r18 == null) goto L36;
        String r19 = r18.getAsString();
        if (r19 == null) goto L36;
        String r110 = r19;
    L37:
        JsonElement r2 = r22.get("use_schema");
        if (r2 != null) goto L40;
    L42:
        boolean r111 = false;
    L44:
        if ((r4 instanceof ViewGroup) == true) goto L46;
        r4 = null;
    L46:
        ViewGroup r20 = (ViewGroup) r4;
        if (r20 == null) goto L69;
        int r3 = r21.hashCode();
        if (r3 == (-1183792455)) goto L57;
        if (r3 == (-934610812)) goto L54;
        return;
    L54:
        if (r21.equals("remove") == false) goto L70;
        a(r6);
        r23.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L70:
        return;
    L57:
        if (r21.equals("insert") == false) goto L72;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.h r1 = (com.bytedance.android.live.liveinteract.plantform.dynamicframe.h) ((LinkedHashMap) this.a).get(r6);
        if (r1 == null) goto L61;
        r1.b();
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.h r24 = this.a.remove(r6);
    L61:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.h r25 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.h(this.b, r17, r110, r111, "dynamicBg_".concat(r6), new c(this, r6, r23));
        this.a.put(r6, r25);
        ih0.c r26 = r25.a(this.c);
        if (r26 != null) goto L64;
        return;
    L64:
        FrameLayout.LayoutParams r27 = new FrameLayout.LayoutParams(s1.f(r12), s1.f(r14));
        r27.topMargin = s1.f(r10);
        r27.leftMargin = s1.f(r8);
        View r28 = r26.S0();
        if (r28 == null) goto L67;
        r28.setLayoutParams(r27);
    L67:
        r20.addView(r26.S0());
        r23.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L72:
        return;
    L69:
        return;
    L40:
        if (r2.getAsBoolean() != true) goto L42;
        r111 = true;
    L36:
        r110 = "";
    L29:
        r17 = "";
        goto L30
    L22:
        r14 = 0;
        goto L23
    L18:
        r12 = 0;
        goto L19
    L14:
        r10 = 0;
        goto L15
    L10:
        r8 = 0;
    L6:
        r6 = "";
        goto L7
    }
}
