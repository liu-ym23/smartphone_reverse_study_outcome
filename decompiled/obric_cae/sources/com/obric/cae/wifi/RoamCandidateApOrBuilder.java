package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface RoamCandidateApOrBuilder extends MessageOrBuilder {
    String getApBssid();

    ByteString getApBssidBytes();

    int getApChan();

    int getApRssi();

    int getApTotalScore();

    int getApType();

    boolean hasApBssid();

    boolean hasApChan();

    boolean hasApRssi();

    boolean hasApTotalScore();

    boolean hasApType();
}
