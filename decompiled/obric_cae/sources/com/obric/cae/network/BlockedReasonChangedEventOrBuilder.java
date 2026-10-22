package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface BlockedReasonChangedEventOrBuilder extends MessageOrBuilder {
    int getNewBlockedReasonMask();

    int getOldBlockedReasonMask();

    int getUid();

    boolean hasNewBlockedReasonMask();

    boolean hasOldBlockedReasonMask();

    boolean hasUid();
}
