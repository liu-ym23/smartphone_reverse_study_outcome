package com.obric.cae.location.geofence;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.location.database.StarLocationDbManager;

/* JADX INFO: loaded from: classes.dex */
public final class StarGeofenceEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_location_geofence_BreachEventData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_location_geofence_BreachEventData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_location_geofence_StarGeofenceData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_location_geofence_StarGeofenceData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_location_geofence_StarGeofenceProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_location_geofence_StarGeofenceProto_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012StarGeofence.proto\u0012\u001fcom.obric.cae.location.geofence\" \u0001\n\u0011StarGeofenceProto\u0012C\n\bgeofence\u0018\u0001 \u0003(\u000b21.com.obric.cae.location.geofence.StarGeofenceData\u0012F\n\fbreach_event\u0018\u0002 \u0003(\u000b20.com.obric.cae.location.geofence.BreachEventData\"\u0094\u0002\n\u0010StarGeofenceData\u0012\u0013\n\u000bgeofence_id\u0018\u0001 \u0002(\t\u0012\u0014\n\fpackage_name\u0018\u0002 \u0002(\t\u0012\u0010\n\blatitude\u0018\u0003 \u0002(\u0001\u0012\u0011\n\tlongitude\u0018\u0004 \u0002(\u0001\u0012\u000e\n\u0006radius\u0018\u0005 \u0002(\r\u0012\u0017\n\u000ftransition_type\u0018\u0006 \u0002(\r\u0012\u0010\n\bgeo_type\u0018\b \u0001(\r\u0012\u000f\n\u0007address\u0018\t \u0001(\t\u0012\u0015\n\radd_timestamp\u0018\n \u0003(\u0004\u0012\u0018\n\u0010delete_timestamp\u0018\u000b \u0003(\u0004\u0012\u0018\n\u0010update_timestamp\u0018\f \u0003(\u0004\u0012\u0019\n\u0011recover_timestamp\u0018\r \u0003(\u0004\"þ\u0001\n\u000fBreachEventData\u0012\u0017\n\u000fevent_timestamp\u0018\u0001 \u0002(\u0004\u0012\u0017\n\u000fbreach_latitude\u0018\u0002 \u0002(\u0001\u0012\u0018\n\u0010breach_longitude\u0018\u0003 \u0002(\u0001\u0012\u0013\n\u000bbreach_hacc\u0018\u0004 \u0002(\u0002\u0012\u0010\n\bprovider\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0006 \u0001(\r\u0012\u0017\n\u000fsim_card_status\u0018\u0007 \u0002(\r\u0012\u0013\n\u000bgeofence_id\u0018\b \u0003(\t\u0012\r\n\u0005event\u0018\t \u0003(\r\u0012\u0015\n\rresponse_rate\u0018\n \u0003(\u0002\u0012\u0014\n\ffirst_breach\u0018\u000b \u0003(\bB\u0015B\u0011StarGeofenceEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_location_geofence_StarGeofenceProto_descriptor = r8;
        internal_static_com_obric_cae_location_geofence_StarGeofenceProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"Geofence", "BreachEvent"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_location_geofence_StarGeofenceData_descriptor = r10;
        internal_static_com_obric_cae_location_geofence_StarGeofenceData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"GeofenceId", "PackageName", "Latitude", StarLocationDbManager.GeofenceEntry.LONGITUDE, "Radius", "TransitionType", "GeoType", "Address", "AddTimestamp", "DeleteTimestamp", "UpdateTimestamp", "RecoverTimestamp"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_location_geofence_BreachEventData_descriptor = r11;
        internal_static_com_obric_cae_location_geofence_BreachEventData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"EventTimestamp", "BreachLatitude", "BreachLongitude", "BreachHacc", "Provider", "Source", "SimCardStatus", "GeofenceId", "Event", "ResponseRate", "FirstBreach"});
    }

    private StarGeofenceEvent() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
