package com.zte.miboard.recommend.agent.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class FlightOrTrainInfo {
    private static volatile FlightOrTrainInfo instance;
    public static ArrayList<TravelData> travelDatalist;
    private TravelData changeFrom;
    private TravelData latestTravelData;

    static {
        instance = new FlightOrTrainInfo();
        travelDatalist = new ArrayList();
    }

    private FlightOrTrainInfo() {
        this.changeFrom = null;
    }

    public static FlightOrTrainInfo getInstance() {
        if (instance != null) goto L5;
        return null;
    L5:
        return instance;
    }

    public TravelData getChangeFrom() {
        return this.changeFrom;
    }

    public TravelData getLatestTravelData() {
        return this.latestTravelData;
    }

    public void setChangeFrom(TravelData r5) {
        this.changeFrom = r5;
    }

    public void setLatestTravelData(TravelData r5) {
        this.latestTravelData = r5;
    }

    private FlightOrTrainInfo(TravelData r5) {
        this.changeFrom = null;
        this.latestTravelData = r5;
    }

    public static FlightOrTrainInfo getInstance(TravelData r5) {
        if (instance != null) goto L16;
        monitor-enter(FlightOrTrainInfo.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new FlightOrTrainInfo(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(FlightOrTrainInfo.class);     // Catch: Throwable -> L9
    L20:
        return instance;
    L16:
        monitor-enter(FlightOrTrainInfo.class);
        instance.latestTravelData = r5;     // Catch: Throwable -> L21
        monitor-exit(FlightOrTrainInfo.class);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
