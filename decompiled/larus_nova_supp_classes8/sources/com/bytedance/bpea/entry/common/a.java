package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Deprecated(message = "remove")
public final class a {
    public static final C0372a a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.common.a$a, reason: collision with other inner class name */
    public static final class C0372a {
        public C0372a() {
        }

        @JvmStatic
        public static void a(Cert r3, String[] r4, String r5, String r6) throws BPEAException {
            qc4.c r2 = new qc4.c(r3, r5 + '_' + r6, r4, Integer.valueOf(EntryCategory.DIRECT_AUTH.getType()));
            r2.f.put("sdkName", r5);
            r2.f.put("methodName", r6);
            d.b(r2);
        }
    }

    static {
        a = new C0372a();
    }
}
