package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiPnoStatsReportDataOrBuilder extends MessageOrBuilder {
    long getDurationMs();

    int getEstimatedRounds();

    int getEstimatedRoundsToday();

    int getEvent();

    int getPeriodMs();

    int getSessionCountToday();

    long getStartWallClockMs();

    long getStopWallClockMs();

    long getTimeStamp();

    long getTotalDurationTodayMs();

    boolean hasDurationMs();

    boolean hasEstimatedRounds();

    boolean hasEstimatedRoundsToday();

    boolean hasEvent();

    boolean hasPeriodMs();

    boolean hasSessionCountToday();

    boolean hasStartWallClockMs();

    boolean hasStopWallClockMs();

    boolean hasTimeStamp();

    boolean hasTotalDurationTodayMs();
}
