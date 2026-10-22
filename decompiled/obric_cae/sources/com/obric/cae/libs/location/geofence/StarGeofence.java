package com.obric.cae.libs.location.geofence;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
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
        public static final /* synthetic */ GeoConfidence[] f5399b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5400a;

        static {
            GeoConfidence r8 = new GeoConfidence(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            GeoConfidence r10 = new GeoConfidence(1, 1, "LOW");
            LOW = r10;
            GeoConfidence r11 = new GeoConfidence(2, 2, "MEDIUM");
            MEDIUM = r11;
            GeoConfidence r12 = new GeoConfidence(3, 3, "HIGH");
            HIGH = r12;
            f5399b = new GeoConfidence[]{r8, r10, r11, r12};
        }

        public GeoConfidence(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5400a = r10;
        }

        public static GeoConfidence valueOf(String r8) {
            return (GeoConfidence) Enum.valueOf(GeoConfidence.class, r8);
        }

        public static GeoConfidence[] values() {
            return (GeoConfidence[]) f5399b.clone();
        }

        public int getValue() {
            return this.f5400a;
        }
    }

    public static final enum GeoEvent extends Enum<GeoEvent> {
        public static final GeoEvent ENTER = null;
        public static final GeoEvent EXIT = null;
        public static final GeoEvent UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoEvent[] f5401b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5402a;

        static {
            GeoEvent r8 = new GeoEvent(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            GeoEvent r10 = new GeoEvent(1, 1, "ENTER");
            ENTER = r10;
            GeoEvent r11 = new GeoEvent(2, 2, "EXIT");
            EXIT = r11;
            f5401b = new GeoEvent[]{r8, r10, r11};
        }

        public GeoEvent(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5402a = r10;
        }

        public static GeoEvent valueOf(String r8) {
            return (GeoEvent) Enum.valueOf(GeoEvent.class, r8);
        }

        public static GeoEvent[] values() {
            return (GeoEvent[]) f5401b.clone();
        }

        public int getValue() {
            return this.f5402a;
        }
    }

    public static final enum GeoState extends Enum<GeoState> {
        public static final GeoState INSIDE = null;
        public static final GeoState OUTSIDE = null;
        public static final GeoState UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoState[] f5403b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5404a;

        static {
            GeoState r8 = new GeoState(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            GeoState r10 = new GeoState(1, 1, "INSIDE");
            INSIDE = r10;
            GeoState r11 = new GeoState(2, 2, "OUTSIDE");
            OUTSIDE = r11;
            f5403b = new GeoState[]{r8, r10, r11};
        }

        public GeoState(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5404a = r10;
        }

        public static GeoState valueOf(String r8) {
            return (GeoState) Enum.valueOf(GeoState.class, r8);
        }

        public static GeoState[] values() {
            return (GeoState[]) f5403b.clone();
        }

        public int getValue() {
            return this.f5404a;
        }
    }

    public static final enum GeoTransitionType extends Enum<GeoTransitionType> {
        public static final GeoTransitionType ENTERED_AND_EXITED = null;
        public static final GeoTransitionType ENTERED_ONLY = null;
        public static final GeoTransitionType EXITED_ONLY = null;
        public static final GeoTransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoTransitionType[] f5405b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5406a;

        static {
            GeoTransitionType r8 = new GeoTransitionType(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            GeoTransitionType r10 = new GeoTransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r10;
            GeoTransitionType r11 = new GeoTransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r11;
            GeoTransitionType r12 = new GeoTransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r12;
            f5405b = new GeoTransitionType[]{r8, r10, r11, r12};
        }

        public GeoTransitionType(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5406a = r10;
        }

        public static GeoTransitionType valueOf(String r8) {
            return (GeoTransitionType) Enum.valueOf(GeoTransitionType.class, r8);
        }

        public static GeoTransitionType[] values() {
            return (GeoTransitionType[]) f5405b.clone();
        }

        public int getValue() {
            return this.f5406a;
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
        public static final /* synthetic */ GeoType[] f5407b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5408a;

        static {
            GeoType r8 = new GeoType(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            GeoType r10 = new GeoType(1, 1, "HOME");
            HOME = r10;
            GeoType r11 = new GeoType(2, 2, "COMPANY");
            COMPANY = r11;
            GeoType r12 = new GeoType(3, 3, "TRAFFIC");
            TRAFFIC = r12;
            GeoType r13 = new GeoType(4, 4, "MALL");
            MALL = r13;
            GeoType r14 = new GeoType(5, 5, "INDOOR");
            INDOOR = r14;
            GeoType r15 = new GeoType(6, 6, "OUTDOOR");
            OUTDOOR = r15;
            f5407b = new GeoType[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public GeoType(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5408a = r10;
        }

        public static GeoType valueOf(String r8) {
            return (GeoType) Enum.valueOf(GeoType.class, r8);
        }

        public static GeoType[] values() {
            return (GeoType[]) f5407b.clone();
        }

        public int getValue() {
            return this.f5408a;
        }
    }

    public class a implements Parcelable.Creator<StarGeofence> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence createFromParcel(Parcel r8) {
            return new StarGeofence(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence[] newArray(int r8) {
            return new StarGeofence[r8];
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof StarGeofence) == false) goto L18;
        StarGeofence r10 = (StarGeofence) r8;
        if (Double.compare(this.latitude, r10.getLatitude()) == 0) goto L7;
        return false;
    L7:
        if (Double.compare(this.longitude, r10.getLongitude()) == 0) goto L9;
        return false;
    L9:
        if (this.radius == r10.getRadius()) goto L11;
        return false;
    L11:
        if (this.geofenceId.equals(r10.getGeofenceId()) == true) goto L13;
        return false;
    L13:
        if (this.transitionType == r10.getTransitionType()) goto L15;
        return false;
    L15:
        if (this.confidence != r10.getConfidence()) goto L24;
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

    public boolean isBoundTo(AoiBoard r8) {
        if (r8 == null) goto L28;
        String r10 = this.poiId;
        String r11 = r8.getPoiId();
        if (r10 != null) goto L7;
    L20:
        boolean r12 = false;
    L21:
        if (r12 == true) goto L23;
        return false;
    L23:
        return true;
    L7:
        if (r10.isEmpty() == true) goto L20;
        if (r11 == null) goto L20;
        if (r11.isEmpty() == true) goto L20;
        String[] r13 = r10.split(";");
        int r14 = r13.length;
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L20;
        String r16 = r13[r15];
        if (r16 == null) goto L19;
        if (r11.equals(r16.trim()) == false) goto L19;
        r12 = true;
    L19:
        r15 = r15 + 1;
        goto L13
    L28:
        return false;
    }

    public boolean isFirstBreach() {
        return this.firstBreach;
    }

    @SuppressLint({"NewApi"})
    public void readFromParcel(Parcel r8) {
        this.packageName = r8.readString();
        this.geofenceId = r8.readString();
        this.latitude = r8.readDouble();
        this.longitude = r8.readDouble();
        this.radius = r8.readInt();
        this.address = r8.readString();
        this.eventTimestamp = r8.readLong();
        this.transitionType = GeoTransitionType.values()[r8.readInt()];
        this.confidence = GeoConfidence.values()[r8.readInt()];
        this.geoState = GeoState.values()[r8.readInt()];
        this.geoType = GeoType.values()[r8.readInt()];
        this.firstBreach = r8.readBoolean();
        this.poiId = r8.readString();
    }

    public void setAddress(String r8) {
        this.address = r8;
    }

    public void setConfidence(GeoConfidence r8) {
        this.confidence = r8;
    }

    public void setEventTimestamp(long r8) {
        this.eventTimestamp = r8;
    }

    public void setFirstBreach(boolean r8) {
        this.firstBreach = r8;
    }

    public void setGeoState(GeoState r8) {
        this.geoState = r8;
    }

    public void setGeoType(GeoType r8) {
        this.geoType = r8;
    }

    public void setGeofenceId(String r8) {
        this.geofenceId = r8;
    }

    public void setLatitude(double r8) {
        this.latitude = r8;
    }

    public void setLongitude(double r8) {
        this.longitude = r8;
    }

    public void setPackageName(String r8) {
        this.packageName = r8;
    }

    public void setPoiId(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        this.poiId = r8;
    }

    public void setRadius(int r8) {
        this.radius = r8;
    }

    public void setTransitionType(GeoTransitionType r8) {
        this.transitionType = r8;
    }

    public boolean shouldEnableAoiBoard(AoiBoard r8) {
        if (isBoundTo(r8) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.geoState != GeoState.INSIDE) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("[StarGeofence: ");
        r8.append(this.geofenceId);
        r8.append(", from: ");
        r8.append(this.packageName);
        r8.append(", (");
        r8.append(this.latitude);
        r8.append(", ");
        r8.append(this.longitude);
        r8.append(", ");
        r8.append(this.radius);
        r8.append("), address: ");
        r8.append(this.address);
        r8.append(", eventTime: ");
        r8.append(this.eventTimestamp);
        r8.append(", transitionType: ");
        r8.append(this.transitionType);
        r8.append(", curState: ");
        r8.append(this.geoState);
        r8.append(", geoType: ");
        r8.append(this.geoType);
        r8.append(", firstBreach: ");
        r8.append(this.firstBreach);
        r8.append(", poiId: ");
        return android.aimedia.a.i(r8, this.poiId, "]");
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.packageName);
        r8.writeString(this.geofenceId);
        r8.writeDouble(this.latitude);
        r8.writeDouble(this.longitude);
        r8.writeInt(this.radius);
        r8.writeString(this.address);
        r8.writeLong(this.eventTimestamp);
        r8.writeInt(this.transitionType.ordinal());
        r8.writeInt(this.confidence.ordinal());
        r8.writeInt(this.geoState.ordinal());
        r8.writeInt(this.geoType.ordinal());
        r8.writeBoolean(this.firstBreach);
        r8.writeString(this.poiId);
    }

    public StarGeofence(Parcel r8) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        readFromParcel(r8);
    }

    public StarGeofence(String r8, String r10, double r11, double r12, int r13, GeoTransitionType r14) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        this.packageName = r8;
        this.geofenceId = r10;
        this.latitude = r11;
        this.longitude = r12;
        this.radius = r13;
        this.transitionType = r14;
    }
}
