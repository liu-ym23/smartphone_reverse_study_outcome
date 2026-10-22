package com.obric.cae.location.geofence;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface StarGeofenceDataOrBuilder extends MessageOrBuilder {
    long getAddTimestamp(int r8);

    int getAddTimestampCount();

    List<Long> getAddTimestampList();

    String getAddress();

    ByteString getAddressBytes();

    long getDeleteTimestamp(int r8);

    int getDeleteTimestampCount();

    List<Long> getDeleteTimestampList();

    int getGeoType();

    String getGeofenceId();

    ByteString getGeofenceIdBytes();

    double getLatitude();

    double getLongitude();

    String getPackageName();

    ByteString getPackageNameBytes();

    int getRadius();

    long getRecoverTimestamp(int r8);

    int getRecoverTimestampCount();

    List<Long> getRecoverTimestampList();

    int getTransitionType();

    long getUpdateTimestamp(int r8);

    int getUpdateTimestampCount();

    List<Long> getUpdateTimestampList();

    boolean hasAddress();

    boolean hasGeoType();

    boolean hasGeofenceId();

    boolean hasLatitude();

    boolean hasLongitude();

    boolean hasPackageName();

    boolean hasRadius();

    boolean hasTransitionType();
}
