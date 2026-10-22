package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public r(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r7, xwb.d r8, String r9, OfficeWebView r10) {
        String r11 = (String) r7;
        Intrinsics.checkNotNullParameter(r8, "callback");
        MmEndWindowWebHelper r12 = this.a;
        r12.getClass();
        int r13 = bwb.b.a;
        MmUiLogScene r14 = MmUiLogScene.WEB;
        bwb.b.f(r14, "updateTitle", "data=" + r11, r12.f());
        Gson r0 = e0.a;
        TailUpdateTitle r15 = (TailUpdateTitle) e0.a(r11, TailUpdateTitle.class);
        if (r15 == null) goto L5;
        String r16 = r15.getTitleName();
    L6:
        if (r16 != null) goto L9;
        r16 = "";
    L9:
        if (r16.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        bwb.b.d(r14, "updateTitle", "newTitle is null or empty", r12.f());
        r8.a(Status.FAILURE, "{\"error\":\"invalid title\"}");
        return;
    L15:
        if (Intrinsics.areEqual(r16, r12.h) == false) goto L17;
        bwb.b.f(r14, "updateTitle", "newTitle=" + r16 + ", same with last", r12.f());
        r8.a(Status.SUCCESS, new JSONObject().put("titleName", r16));
        return;
    L17:
        BuildersKt.launch$default(r12.c, null, null, new MmEndWindowWebHelper$updateTitle$1(r12, r16, r8, null), 3, null);
        return;
    L11:
        r1 = false;
        goto L12
    L5:
        r16 = null;
        goto L6
    }
}
