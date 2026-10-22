package com.bytedance.android.annie.business.lynx;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/business/lynx/AnnieXLivePropsProvider;", "Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "<init>", "()V", "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLivePropsProvider extends IAnnieXBizPropsProvider {
    public AnnieXLivePropsProvider() {
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final Map<String, Object> b(KitType r12, String r13, Uri r14) {
        Intrinsics.checkNotNullParameter(r12, "kitType");
        Intrinsics.checkNotNullParameter(r13, "bid");
        Intrinsics.checkNotNullParameter(r14, "uri");
        Object r1 = null;
        if (Intrinsics.areEqual(r13, "webcast") == false) goto L28;
        LinkedHashMap r0 = new LinkedHashMap();
        if (r12 != KitType.LYNX) goto L7;
        r0.put("lynxVersion", LynxEnv.inst().getLynxVersion());
        r0.put("lynx_version", LynxEnv.inst().getLynxVersion());
    L7:
        i7.a r15 = i7.a.a;
        Application r10 = h.h.b;
        String r11 = r14.toString();
        boolean r16 = true;
        boolean r17 = !o7.e.a();
        String r18 = UriProtector.getQueryParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r18 != null) goto L10;
        r18 = r14.toString();
    L10:
        Boolean r19 = Boolean.TRUE;
        r15.getClass();
        i7.a.a(r0, r13, r10, r11, r17, r18, r13, r19);
        String r110 = com.bytedance.ies.bullet.service.router.d.a(r14, "flow_page_cache_param");
        if (com.bytedance.ies.bullet.service.base.h.l0() == false) goto L27;
        if (r110 != null) goto L14;
    L17:
        if (r16 == true) goto L27;
        Object r111 = r0.get("initialBusinessProps");
        if ((r111 instanceof Map) == false) goto L21;
        Map r112 = (Map) r111;
    L23:
        if (r112 == null) goto L25;
        r1 = r112.get("bcm_chain");
    L25:
        if (r1 == null) goto L27;
        r0.put("bcm_chain", r1);
        goto L27
    L21:
        r112 = null;
        goto L23
    L14:
        if (r110.length() == 0) goto L17;
        r16 = false;
    L27:
        return r0;
    L28:
        return null;
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final Map<String, Object> c(String r10, KitType r11, Context r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "kitType");
        if (Intrinsics.areEqual(r10, "webcast") == true) goto L5;
        return null;
    L5:
        return ((i9.c) Annie.getService$default(i9.c.class, null, 2, null)).H1(r12);
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final void a(Map<String, Object> r10, KitType r11, String r12, Uri r13) {
        Intrinsics.checkNotNullParameter(r10, "originProps");
        Intrinsics.checkNotNullParameter(r11, "kitType");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "uri");
        if (Intrinsics.areEqual(r12, "webcast") == true) goto L5;
        return;
    L5:
        if (r11 != KitType.LYNX) goto L7;
        r10.put("lynxVersion", LynxEnv.inst().getLynxVersion());
        r10.put("lynx_version", LynxEnv.inst().getLynxVersion());
    L7:
        r10.put("os", "Android");
        LinkedHashMap r14 = (LinkedHashMap) r10;
        Object r15 = r14.get("appVersion");
        if (r15 == null) goto L10;
        r10.put("version_name", r15);
    L10:
        Object r16 = r14.get("deviceId");
        if (r16 == null) goto L13;
        r10.put("device_id", r16);
        r10.put("deviceID", r16);
    L13:
        Object r17 = r14.get("deviceScore");
        if (r17 == null) goto L16;
        r10.put("device_score", r17.toString());
    L16:
        ((IUserInfoService) Annie.getService$default(IUserInfoService.class, null, 2, null)).getUserId();
        r10.put(com.bytedance.android.ec.core.event.a.KEY_USER_ID, "");
        r10.put("container_name", "annie");
        r10.put("ac", NetworkUtils.getNetworkAccessType(h.h.b));
        r10.put("device_platform", "android");
        r10.put("devicePlatform", "mobile");
        Map<String, Object> r18 = ((i9.c) Annie.getService$default(i9.c.class, null, 2, null)).I1();
        if (r18 == null) goto L21;
        r10.putAll(r18);
        return;
    }
}
