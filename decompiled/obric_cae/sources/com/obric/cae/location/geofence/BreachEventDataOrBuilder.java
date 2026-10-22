package com.obric.cae.location.geofence;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface BreachEventDataOrBuilder extends MessageOrBuilder {
    float getBreachHacc();

    double getBreachLatitude();

    double getBreachLongitude();

    int getEvent(int r8);

    int getEventCount();

    List<Integer> getEventList();

    long getEventTimestamp();

    boolean getFirstBreach(int r8);

    int getFirstBreachCount();

    List<Boolean> getFirstBreachList();

    String getGeofenceId(int r8);

    ByteString getGeofenceIdBytes(int r8);

    int getGeofenceIdCount();

    List<String> getGeofenceIdList();

    String getProvider();

    ByteString getProviderBytes();

    float getResponseRate(int r8);

    int getResponseRateCount();

    List<Float> getResponseRateList();

    int getSimCardStatus();

    int getSource();

    boolean hasBreachHacc();

    boolean hasBreachLatitude();

    boolean hasBreachLongitude();

    boolean hasEventTimestamp();

    boolean hasProvider();

    boolean hasSimCardStatus();

    boolean hasSource();
}
