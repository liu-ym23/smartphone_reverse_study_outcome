package com.bytedance.badger.collect.impl.network;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class DefaultNetworkImpl implements INetworkApi {
    public DefaultNetworkImpl() {
    }

    public TTResponse get(String r3, Map<String, String> r4) throws Exception {
        return CommonUtils.http(null, Constants.Keys.METHOD_GET, r3, (HashMap) r4, null);
    }

    public TTResponse post(String r3, Map<String, String> r4, Map<String, String> r5) throws Exception {
        return CommonUtils.http(null, Constants.Keys.METHOD_POST, r3, (HashMap) r4, CommonUtils.map2QueryString(r5).getBytes());
    }
}
