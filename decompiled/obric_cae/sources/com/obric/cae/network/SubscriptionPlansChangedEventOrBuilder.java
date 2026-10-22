package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SubscriptionPlansChangedEventOrBuilder extends MessageOrBuilder {
    String getPlans(int r8);

    ByteString getPlansBytes(int r8);

    int getPlansCount();

    List<String> getPlansList();

    int getSubId();

    boolean hasSubId();
}
