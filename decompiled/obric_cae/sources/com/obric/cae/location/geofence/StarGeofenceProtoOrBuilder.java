package com.obric.cae.location.geofence;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface StarGeofenceProtoOrBuilder extends MessageOrBuilder {
    BreachEventData getBreachEvent(int r8);

    int getBreachEventCount();

    List<BreachEventData> getBreachEventList();

    BreachEventDataOrBuilder getBreachEventOrBuilder(int r8);

    List<? extends BreachEventDataOrBuilder> getBreachEventOrBuilderList();

    StarGeofenceData getGeofence(int r8);

    int getGeofenceCount();

    List<StarGeofenceData> getGeofenceList();

    StarGeofenceDataOrBuilder getGeofenceOrBuilder(int r8);

    List<? extends StarGeofenceDataOrBuilder> getGeofenceOrBuilderList();
}
