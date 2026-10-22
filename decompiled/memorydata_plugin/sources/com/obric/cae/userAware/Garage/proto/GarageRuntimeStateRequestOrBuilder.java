package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface GarageRuntimeStateRequestOrBuilder extends MessageOrBuilder {
    int getCapabilityMask();

    boolean getEnabled();

    int getRequestId();

    int getVersion();

    boolean hasCapabilityMask();

    boolean hasEnabled();

    boolean hasRequestId();

    boolean hasVersion();
}
