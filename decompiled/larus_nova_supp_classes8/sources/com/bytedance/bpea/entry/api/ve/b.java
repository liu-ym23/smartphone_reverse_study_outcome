package com.bytedance.bpea.entry.api.ve;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import com.ss.android.vesdk.h;
import com.ss.android.vesdk.i;
import com.ss.android.vesdk.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final void a(Cert r3, final j r4) throws BPEAException, Exception {
        BaseAuthEntry.a.a(d.a(r3, new String[]{DataType.AUDIO}, "audio_release"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$release$1(r4));
    }

    @JvmStatic
    public static final void b(Cert r3, final h r4) throws BPEAException, Exception {
        BaseAuthEntry.a.a(d.a(r3, new String[]{DataType.AUDIO}, "audio_start"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$start$1(r4));
    }

    @JvmStatic
    public static final void c(Cert r3, final i r4) throws BPEAException, Exception {
        BaseAuthEntry.a.a(d.a(r3, new String[]{DataType.AUDIO}, "audio_stop"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$stop$1(r4));
    }
}
