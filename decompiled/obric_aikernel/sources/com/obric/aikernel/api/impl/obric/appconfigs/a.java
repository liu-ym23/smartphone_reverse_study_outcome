package com.obric.aikernel.api.impl.obric.appconfigs;

import com.bytedance.apm6.util.constant.NetConst;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.obric.aikernel.api.base.a {
    public a() {
    }

    @Override // com.obric.aikernel.api.base.a
    public Map<String, String> h() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("autoclose_mode", NetConst.ENCRYPT_VERISON_CODE), TuplesKt.to("autoclose_service_timeout", "70"), TuplesKt.to("autoclose_whitelist", "aik_app,vlm_local")});
    }

    @Override // com.obric.aikernel.api.base.a
    public boolean o() {
        return true;
    }

    @Override // com.obric.aikernel.api.base.a
    public boolean p() {
        return true;
    }

    @Override // com.obric.aikernel.api.base.a
    public boolean q() {
        return true;
    }
}
