package com.obric.cae.connectivity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface CellularCellRecordReportOrBuilder extends MessageOrBuilder {
    long getLeaveTimestampMs();

    float getRsrp();

    String getSpecificCellId();

    ByteString getSpecificCellIdBytes();

    int getStepCount();

    boolean hasLeaveTimestampMs();

    boolean hasRsrp();

    boolean hasSpecificCellId();

    boolean hasStepCount();
}
