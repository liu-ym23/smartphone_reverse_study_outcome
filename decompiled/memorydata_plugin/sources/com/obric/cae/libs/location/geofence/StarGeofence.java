package com.obric.cae.libs.location.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class StarGeofence implements Parcelable {
    public static final Parcelable.Creator<StarGeofence> CREATOR = null;
    public static final String KEY_CURRENT_LOCATION = "current-location";
    public static final String KEY_GEOFENCE_EVENT = "geofence-event";
    public static final String KEY_GEOFENCE_ID = "geofence-id";
    private String address;
    private GeoConfidence confidence;
    private long eventTimestamp;
    private boolean firstBreach;
    private GeoState geoState;
    private GeoType geoType;
    private String geofenceId;
    private double latitude;
    private double longitude;
    private String packageName;
    private String poiId;
    private int radius;
    private GeoTransitionType transitionType;

    public static final enum GeoConfidence extends Enum<GeoConfidence> {
        public static final GeoConfidence HIGH = null;
        public static final GeoConfidence LOW = null;
        public static final GeoConfidence MEDIUM = null;
        public static final GeoConfidence UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoConfidence[] f6961b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6962a;

        static {
            GeoConfidence r0 = new GeoConfidence("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoConfidence r1 = new GeoConfidence("LOW", 1, 1);
            LOW = r1;
            GeoConfidence r3 = new GeoConfidence("MEDIUM", 2, 2);
            MEDIUM = r3;
            GeoConfidence r5 = new GeoConfidence("HIGH", 3, 3);
            HIGH = r5;
            f6961b = new GeoConfidence[]{r0, r1, r3, r5};
        }

        public GeoConfidence(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6962a = r3;
        }

        public static GeoConfidence valueOf(String r2) {
            return (GeoConfidence) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoConfidence.class, r2), GeoConfidence.class, "com.obric.memorydata.plugin");
        }

        public static GeoConfidence[] values() {
            return (GeoConfidence[]) ZeusTransformUtils.preCheckCast(f6961b.clone(), GeoConfidence[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6962a;
        }
    }

    public static final enum GeoEvent extends Enum<GeoEvent> {
        public static final GeoEvent ENTER = null;
        public static final GeoEvent EXIT = null;
        public static final GeoEvent UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoEvent[] f6963b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6964a;

        static {
            GeoEvent r0 = new GeoEvent("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoEvent r1 = new GeoEvent("ENTER", 1, 1);
            ENTER = r1;
            GeoEvent r3 = new GeoEvent("EXIT", 2, 2);
            EXIT = r3;
            f6963b = new GeoEvent[]{r0, r1, r3};
        }

        public GeoEvent(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6964a = r3;
        }

        public static GeoEvent valueOf(String r2) {
            return (GeoEvent) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoEvent.class, r2), GeoEvent.class, "com.obric.memorydata.plugin");
        }

        public static GeoEvent[] values() {
            return (GeoEvent[]) ZeusTransformUtils.preCheckCast(f6963b.clone(), GeoEvent[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6964a;
        }
    }

    public static final enum GeoState extends Enum<GeoState> {
        public static final GeoState INSIDE = null;
        public static final GeoState OUTSIDE = null;
        public static final GeoState UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoState[] f6965b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6966a;

        static {
            GeoState r0 = new GeoState("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoState r1 = new GeoState("INSIDE", 1, 1);
            INSIDE = r1;
            GeoState r3 = new GeoState("OUTSIDE", 2, 2);
            OUTSIDE = r3;
            f6965b = new GeoState[]{r0, r1, r3};
        }

        public GeoState(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6966a = r3;
        }

        public static GeoState valueOf(String r2) {
            return (GeoState) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoState.class, r2), GeoState.class, "com.obric.memorydata.plugin");
        }

        public static GeoState[] values() {
            return (GeoState[]) ZeusTransformUtils.preCheckCast(f6965b.clone(), GeoState[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6966a;
        }
    }

    public static final enum GeoTransitionType extends Enum<GeoTransitionType> {
        public static final GeoTransitionType ENTERED_AND_EXITED = null;
        public static final GeoTransitionType ENTERED_ONLY = null;
        public static final GeoTransitionType EXITED_ONLY = null;
        public static final GeoTransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoTransitionType[] f6967b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6968a;

        static {
            GeoTransitionType r0 = new GeoTransitionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoTransitionType r1 = new GeoTransitionType("ENTERED_ONLY", 1, 1);
            ENTERED_ONLY = r1;
            GeoTransitionType r3 = new GeoTransitionType("EXITED_ONLY", 2, 2);
            EXITED_ONLY = r3;
            GeoTransitionType r5 = new GeoTransitionType("ENTERED_AND_EXITED", 3, 3);
            ENTERED_AND_EXITED = r5;
            f6967b = new GeoTransitionType[]{r0, r1, r3, r5};
        }

        public GeoTransitionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6968a = r3;
        }

        public static GeoTransitionType valueOf(String r2) {
            return (GeoTransitionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoTransitionType.class, r2), GeoTransitionType.class, "com.obric.memorydata.plugin");
        }

        public static GeoTransitionType[] values() {
            return (GeoTransitionType[]) ZeusTransformUtils.preCheckCast(f6967b.clone(), GeoTransitionType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6968a;
        }
    }

    public static final enum GeoType extends Enum<GeoType> {
        public static final GeoType COMPANY = null;
        public static final GeoType HOME = null;
        public static final GeoType INDOOR = null;
        public static final GeoType MALL = null;
        public static final GeoType OUTDOOR = null;
        public static final GeoType TRAFFIC = null;
        public static final GeoType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoType[] f6969b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6970a;

        static {
            GeoType r0 = new GeoType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoType r1 = new GeoType("HOME", 1, 1);
            HOME = r1;
            GeoType r3 = new GeoType("COMPANY", 2, 2);
            COMPANY = r3;
            GeoType r5 = new GeoType("TRAFFIC", 3, 3);
            TRAFFIC = r5;
            GeoType r7 = new GeoType("MALL", 4, 4);
            MALL = r7;
            GeoType r9 = new GeoType("INDOOR", 5, 5);
            INDOOR = r9;
            GeoType r11 = new GeoType("OUTDOOR", 6, 6);
            OUTDOOR = r11;
            f6969b = new GeoType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public GeoType(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6970a = r3;
        }

        public static GeoType valueOf(String r2) {
            return (GeoType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoType.class, r2), GeoType.class, "com.obric.memorydata.plugin");
        }

        public static GeoType[] values() {
            return (GeoType[]) ZeusTransformUtils.preCheckCast(f6969b.clone(), GeoType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6970a;
        }
    }

    public class a implements Parcelable.Creator<StarGeofence> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence createFromParcel(Parcel r1) {
            return new StarGeofence(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence[] newArray(int r1) {
            return new StarGeofence[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public StarGeofence() {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
    }

    public StarGeofence(Parcel r3) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        readFromParcel(r3);
    }

    public StarGeofence(String r3, String r4, double r5, double r7, int r9, GeoTransitionType r10) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        this.packageName = r3;
        this.geofenceId = r4;
        this.latitude = r5;
        this.longitude = r7;
        this.radius = r9;
        this.transitionType = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, StarGeofence.class) == false) goto L18;
        StarGeofence r7 = (StarGeofence) ZeusTransformUtils.preCheckCast(r6, StarGeofence.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.latitude, r7.getLatitude()) == 0) goto L7;
        return false;
    L7:
        if (Double.compare(this.longitude, r7.getLongitude()) == 0) goto L9;
        return false;
    L9:
        if (this.radius == r7.getRadius()) goto L11;
        return false;
    L11:
        if (this.geofenceId.equals(r7.getGeofenceId()) == true) goto L13;
        return false;
    L13:
        if (this.transitionType == r7.getTransitionType()) goto L15;
        return false;
    L15:
        if (this.confidence != r7.getConfidence()) goto L24;
        return true;
    L24:
        return false;
    L18:
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public GeoConfidence getConfidence() {
        return this.confidence;
    }

    public long getEventTimestamp() {
        return this.eventTimestamp;
    }

    public GeoState getGeoState() {
        return this.geoState;
    }

    public GeoType getGeoType() {
        return this.geoType;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public int getRadius() {
        return this.radius;
    }

    public GeoTransitionType getTransitionType() {
        return this.transitionType;
    }

    public boolean isBoundTo(AoiBoard r6) {
        if (r6 == null) goto L24;
        String r5 = this.poiId;
        String r7 = r6.getPoiId();
        if (r5 != null) goto L7;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L24;
        return true;
    L7:
        if (r5.isEmpty() == true) goto L20;
        if (r7 == null) goto L20;
        if (r7.isEmpty() == true) goto L20;
        String[] r9 = r5.split(";");
        int r2 = r9.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L20;
        String r4 = r9[r3];
        if (r4 == null) goto L19;
        if (r7.equals(r4.trim()) == false) goto L19;
        r8 = true;
    L19:
        r3 = r3 + 1;
    L24:
        return false;
    }

    public boolean isFirstBreach() {
        return this.firstBreach;
    }

    public void readFromParcel(Parcel r3) {
        this.packageName = r3.readString();
        this.geofenceId = r3.readString();
        this.latitude = r3.readDouble();
        this.longitude = r3.readDouble();
        this.radius = r3.readInt();
        this.address = r3.readString();
        this.eventTimestamp = r3.readLong();
        this.transitionType = GeoTransitionType.values()[r3.readInt()];
        this.confidence = GeoConfidence.values()[r3.readInt()];
        this.geoState = GeoState.values()[r3.readInt()];
        this.geoType = GeoType.values()[r3.readInt()];
        this.firstBreach = r3.readBoolean();
        this.poiId = r3.readString();
    }

    public void setAddress(String r1) {
        this.address = r1;
    }

    public void setConfidence(GeoConfidence r1) {
        this.confidence = r1;
    }

    public void setEventTimestamp(long r1) {
        this.eventTimestamp = r1;
    }

    public void setFirstBreach(boolean r1) {
        this.firstBreach = r1;
    }

    public void setGeoState(GeoState r1) {
        this.geoState = r1;
    }

    public void setGeoType(GeoType r1) {
        this.geoType = r1;
    }

    public void setGeofenceId(String r1) {
        this.geofenceId = r1;
    }

    public void setLatitude(double r1) {
        this.latitude = r1;
    }

    public void setLongitude(double r1) {
        this.longitude = r1;
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public void setPoiId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiId = r1;
    }

    public void setRadius(int r1) {
        this.radius = r1;
    }

    public void setTransitionType(GeoTransitionType r1) {
        this.transitionType = r1;
    }

    public boolean shouldEnableAoiBoard(AoiBoard r1) {
        if (isBoundTo(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.geoState != GeoState.INSIDE) goto L7;
        return true;
    }

    public String toString() {
        return "[StarGeofence: " + this.geofenceId + ", from: " + this.packageName + ", (" + this.latitude + ", " + this.longitude + ", " + this.radius + "), address: " + this.address + ", eventTime: " + this.eventTimestamp + ", transitionType: " + this.transitionType + ", curState: " + this.geoState + ", geoType: " + this.geoType + ", firstBreach: " + this.firstBreach + ", poiId: " + this.poiId + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.packageName);
        r3.writeString(this.geofenceId);
        r3.writeDouble(this.latitude);
        r3.writeDouble(this.longitude);
        r3.writeInt(this.radius);
        r3.writeString(this.address);
        r3.writeLong(this.eventTimestamp);
        r3.writeInt(this.transitionType.ordinal());
        r3.writeInt(this.confidence.ordinal());
        r3.writeInt(this.geoState.ordinal());
        r3.writeInt(this.geoType.ordinal());
        r3.writeBoolean(this.firstBreach);
        r3.writeString(this.poiId);
    }
}
