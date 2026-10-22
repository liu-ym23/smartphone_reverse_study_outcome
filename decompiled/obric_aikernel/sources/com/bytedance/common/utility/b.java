package com.bytedance.common.utility;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b extends e {
    b() {
    }

    @Override // com.bytedance.common.utility.e
    public String a(String r10, Map<String, String> r11, e.a r12) {
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.e
    public String d(String r10, List<Pair<String, String>> r11, Map<String, String> r12, e.a r13) {
        throw new CommonHttpException(0, "not implemented");
    }

    @Override // com.bytedance.common.utility.e
    public String e(String r10, byte[] r11, Map<String, String> r12, e.a r13) {
        throw new CommonHttpException(0, "not implemented");
    }
}
