package com.ss.android.common.applog;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ac {
    public static void a(Context r10, String r11) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), "event_v1", r11, null, 0, 0, false, null);
    }

    public static void a(Context r10, String r11, String r12) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), "event_v1", r11, r12, 0, 0, false, null);
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r17, false, null);
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, JSONObject r19) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r17, false, r19);
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, boolean r19) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r17, r19, null);
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, boolean r19, JSONObject r20) {
        AppLog.a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r17, r19, r20);
    }
}
