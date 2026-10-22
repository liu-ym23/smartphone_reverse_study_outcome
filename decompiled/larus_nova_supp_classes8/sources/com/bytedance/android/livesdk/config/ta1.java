package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.link.MultiLinkReqABParamConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ta1 extends SSettingKey<MultiLinkReqABParamConfig> {
    public static final ta1 a = null;

    static {
        a = new ta1();
    }

    public ta1() {
        super("multi_link_req_common_param_config", "多人业务网络请求公参配置AB数据类", new MultiLinkReqABParamConfig(), new MultiLinkReqABParamConfig());
    }
}
