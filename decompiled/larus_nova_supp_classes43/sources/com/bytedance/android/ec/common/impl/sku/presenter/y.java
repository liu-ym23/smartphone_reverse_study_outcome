package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ d0 a;

    public y(d0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Long r11 = (Long) r10;
        d0.d0(this.a);
        JSONArray r12 = new JSONArray();
        SkuViewModel r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuRestoreState r1 = r0.getSkuPanelState();
        if (r1 == null) goto L8;
        String[] r13 = r1.getSelectSkuKeys();
    L9:
        if (r13 == null) goto L16;
        int r14 = r13.length;
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L16;
        String r16 = r13[r15];
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        r12.put(r16);
        r15 = r15 + 1;
    L16:
        JSONObject r17 = new JSONObject();
        SkuViewModel r18 = this.a.f;
        if (r18 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r17.put("sku_session_id", r18.getSkuParams().getSkuSessionId());
        SkuViewModel r19 = this.a.f;
        if (r19 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r17.put("combo_num", r19.m1027getCurrentCount().a());
        r17.put("select_spec_ids", r12);
        ECLiveHybridUtil.f("ecom.sku.spec.change", r17);
        return;
    L8:
        r13 = null;
        goto L9
    }
}
