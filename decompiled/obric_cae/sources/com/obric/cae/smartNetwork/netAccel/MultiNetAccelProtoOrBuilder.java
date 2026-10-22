package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MultiNetAccelProtoOrBuilder extends MessageOrBuilder {
    MultiNetAccelProtoData getMultiNetAccelProto(int r8);

    int getMultiNetAccelProtoCount();

    List<MultiNetAccelProtoData> getMultiNetAccelProtoList();

    MultiNetAccelProtoDataOrBuilder getMultiNetAccelProtoOrBuilder(int r8);

    List<? extends MultiNetAccelProtoDataOrBuilder> getMultiNetAccelProtoOrBuilderList();
}
