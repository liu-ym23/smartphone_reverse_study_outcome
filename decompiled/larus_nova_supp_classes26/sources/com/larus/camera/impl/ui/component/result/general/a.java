package com.larus.camera.impl.ui.component.result.general;

import android.content.Context;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r9, CameraResultViewModel r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        r4.put("action", "save_album");
        r4.put("entry", "camera_result_download");
        r4.put("channel", "album");
        if (r10.currentPreviewIsVideo() == false) goto L13;
        String r11 = "video";
    L14:
        r4.put("content_type", r11);
        Unit r12 = Unit.INSTANCE;
        r1.reportEvent("flow_enterprise_file_egress_block", r4);
        String r13 = r0.H0();
        if (r13 != null) goto L17;
    L23:
        return true;
    L17:
        if ((!StringsKt.isBlank(r13)) == true) goto L20;
        r13 = null;
    L20:
        String r5 = r13;
        if (r5 == null) goto L23;
        t19.s.j(t19.s.a, r9, r5, null, false, 28);
        goto L23
    L13:
        r11 = "image";
        goto L14
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }
}
