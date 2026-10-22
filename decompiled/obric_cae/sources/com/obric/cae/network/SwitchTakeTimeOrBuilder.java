package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface SwitchTakeTimeOrBuilder extends MessageOrBuilder {
    int getCellOkTime();

    int getOtherTime();

    int getProbeTime();

    int getQoeBadTime();

    int getSwitchTime();

    int getTotalTime();

    boolean hasCellOkTime();

    boolean hasOtherTime();

    boolean hasProbeTime();

    boolean hasQoeBadTime();

    boolean hasSwitchTime();

    boolean hasTotalTime();
}
