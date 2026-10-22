package com.bytedance.bpea.entry.api.camera;

import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.DataType;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final c a(TokenCert r7, String r8, int r9) {
        return new c(r7, r8, r9, new String[]{DataType.VIDEO}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
    }
}
