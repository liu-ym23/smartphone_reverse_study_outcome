package com.bytedance.badger.collect.impl.network.interfaces;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface INetWorkService {
    TTResponse fetchMobilePseudoCodeSign(String r1, Map<String, String> r2, NetworkMethodEnum r3, Map<String, String> r4) throws Exception;

    TTResponse fetchMobilePseudoCodeToken(Network r1, String r2, Map<String, String> r3, NetworkMethodEnum r4, Map<String, String> r5) throws Exception;
}
