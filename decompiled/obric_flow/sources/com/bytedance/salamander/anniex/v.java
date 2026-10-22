package com.bytedance.salamander.anniex;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.rts.foundation.RTSStringKt;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7281a;

    public v() {
        Map r5 = RTSMapKt.RTSMap();
        this.f7281a = r5;
        c(r5);
    }

    public static n a(String r5, c0 r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "rule");
        int r11 = r5.length();
        int r12 = r10.f7249a;
        if (r11 > r12) goto L5;
        String r13 = r5;
    L7:
        return new n(r5.length(), r13, 0);
    L5:
        r13 = RTSStringKt.slice(r5, 0, r12);
        goto L7
    }

    public static void c(Map r10) {
        Intrinsics.checkNotNullParameter(r10, "rules");
        ValidationAction r5 = ValidationAction.d;
        RTSMapKt.set(r10, WsConstants.KEY_SDK_VERSION, new c0(WsConstants.KEY_SDK_VERSION, 100, r5));
        ValidationAction r11 = ValidationAction.f7237c;
        RTSMapKt.set(r10, "bid", new c0("bid", 64, r11));
        RTSMapKt.set(r10, LynxMonitorService.KEY_PID, new c0(LynxMonitorService.KEY_PID, 100, r11));
        ValidationAction r12 = ValidationAction.f7235a;
        RTSMapKt.set(r10, "js_base_release", new c0("js_base_release", 100, r12));
        RTSMapKt.set(r10, "js_base_env", new c0("js_base_env", 100, r12));
        RTSMapKt.set(r10, "js_base_context_key", new c0("js_base_context_key", 64, r12));
        RTSMapKt.set(r10, "js_base_context_value", new c0("js_base_context_value", 128, r12));
        RTSMapKt.set(r10, "js_exception_js_info_exception", new c0("js_exception_js_info_exception", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r12));
        RTSMapKt.set(r10, "js_exception_native_info_error_msg", new c0("js_exception_native_info_error_msg", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r12));
        RTSMapKt.set(r10, "js_exception_root_cause", new c0("js_exception_native_info_root_cause", 1000, r12));
        RTSMapKt.set(r10, "jsb_perf_info_jsb_name", new c0("jsb_perf_info_jsb_name", 100, r5));
        RTSMapKt.set(r10, "jsb_error_bridge_name", new c0("jsb_error_bridge_name", 100, r5));
        RTSMapKt.set(r10, "jsb_error_error_message", new c0("jsb_error_error_message", 1000, r11));
        RTSMapKt.set(r10, "jsb_error_jsb_params", new c0("jsb_error_jsb_params", 1000, ValidationAction.f7236b));
        RTSMapKt.set(r10, "schema", new c0("schema", 4000, r11));
        RTSMapKt.set(r10, "url", new c0("url", 4000, r11));
    }

    public final b0 b(Object r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Map r11 = this.f7281a;
        if (RTSMapKt.has(r11, r10) == false) goto L32;
        c0 r12 = (c0) r11.get(r10);
        Intrinsics.checkNotNull(r12);
        n r13 = a((String) r5, r12);
        int r14 = r12.f7250b.ordinal();
        int r15 = r12.f7249a;
        int r16 = r13.f7268b;
        String r17 = r13.f7269c;
        if (r14 != 0) goto L7;
        if (r16 > r15) goto L30;
        return new b0("validate success", r17);
    L30:
        return new b0("validate failed and throw exception", r15, r17);
    L7:
        if (r14 != 1) goto L9;
        if (r16 > r15) goto L25;
        return new b0("validate success", r17);
    L25:
        return new b0(r15, 0);
    L9:
        if (r14 != 2) goto L11;
        if (r16 > r15) goto L20;
        return new b0("validate success", r17);
    L20:
        return new b0("validate success and the field is truncated", r15, r17);
    L11:
        if (r14 != 3) goto L15;
        return new b0("validate success with none action", r17);
    L15:
        throw new NoWhenBranchMatchedException();
    L32:
        return new b0("don't need to validate", r5);
    }
}
