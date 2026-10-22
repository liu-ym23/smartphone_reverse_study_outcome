package com.obric.cae.connectivity;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CaeConnectivityDataProtoOrBuilder extends MessageOrBuilder {
    CaeConnectivityProtoData getCaeConnectivityProto(int r8);

    int getCaeConnectivityProtoCount();

    List<CaeConnectivityProtoData> getCaeConnectivityProtoList();

    CaeConnectivityProtoDataOrBuilder getCaeConnectivityProtoOrBuilder(int r8);

    List<? extends CaeConnectivityProtoDataOrBuilder> getCaeConnectivityProtoOrBuilderList();
}
