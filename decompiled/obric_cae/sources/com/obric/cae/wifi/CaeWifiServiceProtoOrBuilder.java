package com.obric.cae.wifi;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CaeWifiServiceProtoOrBuilder extends MessageOrBuilder {
    CaeWifiServiceProtoData getCaeWifiServiceProto(int r8);

    int getCaeWifiServiceProtoCount();

    List<CaeWifiServiceProtoData> getCaeWifiServiceProtoList();

    CaeWifiServiceProtoDataOrBuilder getCaeWifiServiceProtoOrBuilder(int r8);

    List<? extends CaeWifiServiceProtoDataOrBuilder> getCaeWifiServiceProtoOrBuilderList();
}
