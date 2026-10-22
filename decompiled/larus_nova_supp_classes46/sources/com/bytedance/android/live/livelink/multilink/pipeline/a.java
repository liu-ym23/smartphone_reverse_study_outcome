package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[MultiLinkConfig.LinkSource.values().length];
        a = r0;
        MultiLinkConfig.LinkSource r1 = MultiLinkConfig.LinkSource.APPLY;
        r0[r1.ordinal()] = 1;
        MultiLinkConfig.LinkSource r2 = MultiLinkConfig.LinkSource.REPLY;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[MultiLinkConfig.LinkSource.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[MultiLinkConfig.LinkSource.JOIN.ordinal()] = 3;
        int[] r4 = new int[OperateType.values().length];
        c = r4;
        r4[OperateType.APPLY.ordinal()] = 1;
        OperateType r5 = OperateType.REPLY;
        r4[r5.ordinal()] = 2;
        r4[OperateType.JOIN.ordinal()] = 3;
        int[] r6 = new int[OperateType.values().length];
        d = r6;
        r6[r5.ordinal()] = 1;
    }
}
