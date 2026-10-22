package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.core.ReqType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6672a = null;

    static {
        int[] r5 = new int[ReqType.values().length];
        f6672a = r5;
        r5[ReqType.QUEUE.ordinal()] = 1;
        r5[ReqType.REGISTER_LATE.ordinal()] = 2;
        r5[ReqType.PROBE.ordinal()] = 3;
        r5[ReqType.POLLING.ordinal()] = 4;
    }
}
