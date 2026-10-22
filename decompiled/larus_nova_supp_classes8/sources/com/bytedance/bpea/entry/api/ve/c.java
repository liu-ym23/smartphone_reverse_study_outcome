package com.bytedance.bpea.entry.api.ve;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final void a(Cert r3, final com.bytedance.bpea.entry.api.ve.a r4) throws BPEAException, Exception {
        BaseAuthEntry.a.a(d.a(r3, new String[]{DataType.VIDEO}, "camera_close"), new VEPrivacyCertCheckEntry$Camera$Companion$close$1(r4));
    }

    @JvmStatic
    public static final <T> T b(Cert r3, final com.bytedance.bpea.entry.api.ve.a<T> r4) throws BPEAException, Exception {
        return (T) BaseAuthEntry.a.a(d.a(r3, new String[]{DataType.VIDEO}, "camera_open"), new VEPrivacyCertCheckEntry$Camera$Companion$open$1(r4));
    }
}
