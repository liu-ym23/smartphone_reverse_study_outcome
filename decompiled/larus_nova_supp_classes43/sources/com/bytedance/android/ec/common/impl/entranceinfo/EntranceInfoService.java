package com.bytedance.android.ec.common.impl.entranceinfo;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.data.EntranceInfoWriteConfig;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jg.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EntranceInfoService implements IEntranceInfoService {
    public Set<b> a;

    public EntranceInfoService() {
        this.a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final List<String> fetchFilteredEntranceInfo(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "entranceInfoList");
        if (wf.a.b() == false) goto L32;
        HashSet<String> r0 = ECSettingKeys.k0().getWhiteList();
        ArrayList r11 = new ArrayList();
        if (r0 != null) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == false) goto L15;
        dm.a.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO).b("white list empty", null);
        int r13 = ECSdk.a;
        pi.b r14 = (pi.b) ECSdk.a(pi.b.class);
        if (r14 == null) goto L33;
        JSONObject r1 = new JSONObject();
        r1.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, "white_list_error");
        Unit r15 = Unit.INSTANCE;
        r14.monitorEvent("ec_entrance_info_check_result", r1, null, null);
        return null;
    L33:
        return null;
    L15:
        Iterator<T> r16 = r10.iterator();
    L17:
        if (r16.hasNext() == false) goto L24;
        String r17 = (String) r16.next();
        if (r0.contains(r17) == true) goto L17;
        r11.add(r17);
        if (ECAppInfoService.e.i() == false) goto L17;
        int r18 = j.a;
        j.c("ENTRANCE_INFO_WHITE_LIST_FILTER", "entrance_info 中 key值 " + r17 + " 不在白名单内");
        goto L17
    L24:
        return r11;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r12 = false;
        goto L11
    L32:
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final String filterEntranceInfoInLocalTest(String r10) {
        if (ECAppInfoService.e.i() == true) goto L5;
        return r10;
    L5:
        if (wf.a.b() == false) goto L33;
        JSONObject r0 = g.f(r10);
        if (r0 != null) goto L9;
        return r10;
    L9:
        ArrayList r1 = new ArrayList();
        JSONObject r11 = g.f(r10);
        if (r11 == null) goto L21;
        Iterator<String> r12 = r11.keys();
        if (r12 == null) goto L21;
    L14:
        if (r12.hasNext() == false) goto L21;
        String r13 = r12.next();
        EntranceInfoWriteConfig r14 = wf.a.a;
        HashSet<String> r15 = ECSettingKeys.k0().getWhiteList();
        if (r15 == null) goto L14;
        if (r15.contains(r13) == true) goto L14;
        r1.add(r13);
        r0.remove(r13);
    L21:
        if ((!r1.isEmpty()) == false) goto L24;
        int r16 = j.a;
        j.d("ENTRANCE_INFO_FILTER", "entrance_info中字段不在白名单,已被过滤, " + r1, null, null);
    L24:
        return r0.toString();
    L33:
        return r10;
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final gl.a initEntranceInfo(EntranceInfoScene r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        int r0 = b.h;
        b r12 = b.a.a(r10, r11);
        Function1<b, Unit> r13 = new EntranceInfoService$initEntranceInfo$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r13, "cb");
        r12.g = r13;
        return r12;
    }
}
