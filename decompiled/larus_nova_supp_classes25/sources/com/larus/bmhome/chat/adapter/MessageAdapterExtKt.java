package com.larus.bmhome.chat.adapter;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.api.v2;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageAdapterExtKt {
    public static final void a(String r11, Context r12, String r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "context");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        x1 r1 = null;
        if (r0 == null) goto L5;
        v2 r2 = r0.Y();
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        return;
    L14:
        Uri r5 = UriProtector.parse(r11);
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L17;
        r2 r7 = r6.A0();
    L18:
        if (r7 == null) goto L22;
        Intrinsics.checkNotNull(r5);
        if (r7.j(r5) != true) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L32;
        JSONObject r15 = new JSONObject();
        r15.put("enter_method", "search_references");
        r15.put("local_page", "chat");
        if (r14 == null) goto L30;
        Iterator<Map.Entry<String, String>> r16 = r14.entrySet().iterator();
    L28:
        if (r16.hasNext() == false) goto L30;
        Map.Entry<String, String> r17 = r16.next();
        r15.put(r17.getKey(), r17.getValue());
    L30:
        Intrinsics.checkNotNull(r5);
        r7.a(r12, r5);
        return;
    L32:
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L35;
        r9.D();
        r1 = x1.a;
    L35:
        x1 r10 = r1;
        if (z2.a.enableStandardLinkNavigation() == false) goto L44;
        if (r10 != null) goto L39;
    L41:
        if (r3 == false) goto L44;
        r10.i(r12, r11);
        return;
    L39:
        if (r10.a(r11) != true) goto L41;
        r3 = true;
    L44:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new MessageAdapterExtKt$openReference$1(r11, r12, r13, r14, r10, null), 2, null);
        return;
    L22:
        r8 = false;
        goto L23
    L17:
        r7 = null;
        goto L18
    L9:
        if (r2.a(null) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
