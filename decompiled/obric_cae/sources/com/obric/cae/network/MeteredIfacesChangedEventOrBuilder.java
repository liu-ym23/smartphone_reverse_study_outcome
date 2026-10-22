package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MeteredIfacesChangedEventOrBuilder extends MessageOrBuilder {
    String getMeteredIfaces(int r8);

    ByteString getMeteredIfacesBytes(int r8);

    int getMeteredIfacesCount();

    List<String> getMeteredIfacesList();
}
