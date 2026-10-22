package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SubscriptionOverrideChangedEventOrBuilder extends MessageOrBuilder {
    NetworkType getNetworkTypes(int r8);

    int getNetworkTypesCount();

    List<NetworkType> getNetworkTypesList();

    int getOverrideMask();

    int getOverrideValue();

    int getSubId();

    boolean hasOverrideMask();

    boolean hasOverrideValue();

    boolean hasSubId();
}
