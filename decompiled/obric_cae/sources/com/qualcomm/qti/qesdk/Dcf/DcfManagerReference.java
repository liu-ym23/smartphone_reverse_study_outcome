package com.qualcomm.qti.qesdk.Dcf;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class DcfManagerReference {
    public static int gsession_id;
    public static final AtomicInteger init_count = null;

    static {
        init_count = new AtomicInteger(0);
        gsession_id = 0;
    }

    public DcfManagerReference() {
    }
}
