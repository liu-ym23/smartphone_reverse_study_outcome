package com.obric.cae.libs.location.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AoiBoard implements Parcelable {
    public static final Parcelable.Creator<AoiBoard> CREATOR = null;
    private String aoiBoard;
    private Confidence confidence;
    private ConfidenceSource confidenceSource;
    private State curState;
    private Event event;
    private long eventTime;
    private String geofenceId;
    private String poiId;
    private String poiName;
    private TransitionType transitionType;
    private Type type;

    public static final enum Confidence extends Enum<Confidence> {
        public static final Confidence HIGH = null;
        public static final Confidence LOW = null;
        public static final Confidence MAX = null;
        public static final Confidence MEDIUM = null;
        public static final Confidence MIN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Confidence[] f6975b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6976a;

        static {
            Confidence r0 = new Confidence("MIN", 0, 0);
            MIN = r0;
            Confidence r1 = new Confidence("LOW", 1, 1);
            LOW = r1;
            Confidence r3 = new Confidence("MEDIUM", 2, 2);
            MEDIUM = r3;
            Confidence r5 = new Confidence("HIGH", 3, 3);
            HIGH = r5;
            Confidence r7 = new Confidence("MAX", 4, 4);
            MAX = r7;
            f6975b = new Confidence[]{r0, r1, r3, r5, r7};
        }

        public Confidence(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6976a = r3;
        }

        public static Confidence valueOf(String r2) {
            return (Confidence) ZeusTransformUtils.preCheckCast(Enum.valueOf(Confidence.class, r2), Confidence.class, "com.obric.memorydata.plugin");
        }

        public static Confidence[] values() {
            return (Confidence[]) ZeusTransformUtils.preCheckCast(f6975b.clone(), Confidence[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6976a;
        }
    }

    public static final enum ConfidenceSource extends Enum<ConfidenceSource> {
        public static final ConfidenceSource DEFAULT = null;
        public static final ConfidenceSource DISTANCE = null;
        public static final ConfidenceSource RETRY = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ConfidenceSource[] f6977b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6978a;

        static {
            ConfidenceSource r0 = new ConfidenceSource("DEFAULT", 0, 0);
            DEFAULT = r0;
            ConfidenceSource r1 = new ConfidenceSource("DISTANCE", 1, 1);
            DISTANCE = r1;
            ConfidenceSource r3 = new ConfidenceSource("RETRY", 2, 2);
            RETRY = r3;
            f6977b = new ConfidenceSource[]{r0, r1, r3};
        }

        public ConfidenceSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6978a = r3;
        }

        public static ConfidenceSource valueOf(String r2) {
            return (ConfidenceSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConfidenceSource.class, r2), ConfidenceSource.class, "com.obric.memorydata.plugin");
        }

        public static ConfidenceSource[] values() {
            return (ConfidenceSource[]) ZeusTransformUtils.preCheckCast(f6977b.clone(), ConfidenceSource[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6978a;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event ENTER = null;
        public static final Event EXIT = null;
        public static final Event UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Event[] f6979b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6980a;

        static {
            Event r0 = new Event("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Event r1 = new Event("ENTER", 1, 1);
            ENTER = r1;
            Event r3 = new Event("EXIT", 2, 2);
            EXIT = r3;
            f6979b = new Event[]{r0, r1, r3};
        }

        public Event(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6980a = r3;
        }

        public static Event valueOf(String r2) {
            return (Event) ZeusTransformUtils.preCheckCast(Enum.valueOf(Event.class, r2), Event.class, "com.obric.memorydata.plugin");
        }

        public static Event[] values() {
            return (Event[]) ZeusTransformUtils.preCheckCast(f6979b.clone(), Event[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6980a;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State INSIDE = null;
        public static final State OUTSIDE = null;
        public static final State UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f6981b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6982a;

        static {
            State r0 = new State("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            State r1 = new State("INSIDE", 1, 1);
            INSIDE = r1;
            State r3 = new State("OUTSIDE", 2, 2);
            OUTSIDE = r3;
            f6981b = new State[]{r0, r1, r3};
        }

        public State(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6982a = r3;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast(f6981b.clone(), State[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6982a;
        }
    }

    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType ENTERED_AND_EXITED = null;
        public static final TransitionType ENTERED_ONLY = null;
        public static final TransitionType EXITED_ONLY = null;
        public static final TransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f6983b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6984a;

        static {
            TransitionType r0 = new TransitionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TransitionType r1 = new TransitionType("ENTERED_ONLY", 1, 1);
            ENTERED_ONLY = r1;
            TransitionType r3 = new TransitionType("EXITED_ONLY", 2, 2);
            EXITED_ONLY = r3;
            TransitionType r5 = new TransitionType("ENTERED_AND_EXITED", 3, 3);
            ENTERED_AND_EXITED = r5;
            f6983b = new TransitionType[]{r0, r1, r3, r5};
        }

        public TransitionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6984a = r3;
        }

        public static TransitionType valueOf(String r2) {
            return (TransitionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransitionType.class, r2), TransitionType.class, "com.obric.memorydata.plugin");
        }

        public static TransitionType[] values() {
            return (TransitionType[]) ZeusTransformUtils.preCheckCast(f6983b.clone(), TransitionType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6984a;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AIRPORT = null;
        public static final Type MALL = null;
        public static final Type SUBWAY_STATION = null;
        public static final Type TRAIN_STATION = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f6985b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6986a;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("AIRPORT", 1, 1);
            AIRPORT = r1;
            Type r3 = new Type("TRAIN_STATION", 2, 2);
            TRAIN_STATION = r3;
            Type r5 = new Type("SUBWAY_STATION", 3, 3);
            SUBWAY_STATION = r5;
            Type r7 = new Type("MALL", 4, 4);
            MALL = r7;
            f6985b = new Type[]{r0, r1, r3, r5, r7};
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6986a = r3;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast(f6985b.clone(), Type[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.f6986a;
        }
    }

    public class a implements Parcelable.Creator<AoiBoard> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard createFromParcel(Parcel r1) {
            return new AoiBoard(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard[] newArray(int r1) {
            return new AoiBoard[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AoiBoard() {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
    }

    public AoiBoard(Parcel r3) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        readFromParcel(r3);
    }

    public AoiBoard(String r3, String r4, String r5) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        setPoiId(r3);
        setPoiName(r4);
        setAoiBoard(r5);
    }

    public void applyEvent(Event r2) {
        if (r2 != Event.ENTER) goto L7;
        State r0 = State.INSIDE;
    L5:
        this.curState = r0;
        setEvent(r2);
        return;
    L7:
        if (r2 != Event.EXIT) goto L9;
        r0 = State.OUTSIDE;
        goto L5
    L9:
        r0 = State.UNKNOWN;
        goto L5
    }

    public void applyState(State r5) {
        if (r5 != null) goto L5;
        r5 = State.UNKNOWN;
    L5:
        if (this.curState == r5) goto L7;
        boolean r0 = true;
    L8:
        this.curState = r5;
        if (r0 == false) goto L11;
    L14:
        this.eventTime = System.currentTimeMillis();
        return;
    L11:
        if (r5 != State.UNKNOWN) goto L13;
        return;
    L13:
        if (this.eventTime <= 0) goto L14;
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAoiBoard() {
        return this.aoiBoard;
    }

    public Confidence getConfidence() {
        return this.confidence;
    }

    public ConfidenceSource getConfidenceSource() {
        return this.confidenceSource;
    }

    public State getCurState() {
        return this.curState;
    }

    public Event getEvent() {
        return this.event;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public TransitionType getTransitionType() {
        return this.transitionType;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isBoundTo(StarGeofence r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.geofenceId.isEmpty() == false) goto L8;
        String r6 = r5.getPoiId();
        String r4 = this.poiId;
        if (r6 != null) goto L12;
        return false;
    L12:
        if (r6.isEmpty() == true) goto L30;
        if (r4 != null) goto L15;
        return false;
    L15:
        if (r4.isEmpty() == true) goto L33;
        String[] r7 = r6.split(";");
        int r1 = r7.length;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L34;
        String r3 = r7[r2];
        if (r3 == null) goto L24;
        if (r4.equals(r3.trim()) == false) goto L24;
        return true;
    L24:
        r2 = r2 + 1;
        goto L18
    L34:
        return false;
    L33:
        return false;
    L30:
        return false;
    L8:
        return this.geofenceId.equals(r5.getGeofenceId());
    }

    public boolean isSecondLayerEnabledBy(StarGeofence r1) {
        if (isBoundTo(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        return true;
    }

    public void readFromParcel(Parcel r3) {
        this.poiId = r3.readString();
        this.poiName = r3.readString();
        this.aoiBoard = r3.readString();
        this.curState = State.values()[r3.readInt()];
        this.transitionType = TransitionType.values()[r3.readInt()];
        this.confidence = Confidence.values()[r3.readInt()];
        this.confidenceSource = ConfidenceSource.values()[r3.readInt()];
        this.event = Event.values()[r3.readInt()];
        this.type = Type.values()[r3.readInt()];
        this.geofenceId = r3.readString();
        this.eventTime = r3.readLong();
    }

    public void setAoiBoard(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.aoiBoard = r1;
    }

    public void setConfidence(Confidence r1) {
        if (r1 != null) goto L4;
        r1 = Confidence.MIN;
    L4:
        this.confidence = r1;
    }

    public void setConfidenceSource(ConfidenceSource r1) {
        if (r1 != null) goto L4;
        r1 = ConfidenceSource.DEFAULT;
    L4:
        this.confidenceSource = r1;
    }

    public void setCurState(State r1) {
        if (r1 != null) goto L4;
        r1 = State.UNKNOWN;
    L4:
        this.curState = r1;
    }

    public void setEvent(Event r3) {
        if (r3 != null) goto L4;
        r3 = Event.UNKNOWN;
    L4:
        this.event = r3;
        if (r3 == Event.UNKNOWN) goto L8;
        this.eventTime = System.currentTimeMillis();
        return;
    }

    public void setEventTime(long r3) {
        this.eventTime = Math.max(0, r3);
    }

    public void setGeofenceId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.geofenceId = r1;
    }

    public void setPoiId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiId = r1;
    }

    public void setPoiName(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiName = r1;
    }

    public void setTransitionType(TransitionType r1) {
        if (r1 != null) goto L4;
        r1 = TransitionType.UNKNOWN;
    L4:
        this.transitionType = r1;
    }

    public void setType(Type r1) {
        if (r1 != null) goto L4;
        r1 = Type.UNKNOWN;
    L4:
        this.type = r1;
    }

    public String toString() {
        return "[AoiBoard: poiId=" + this.poiId + ", name=" + this.poiName + ", curState=" + this.curState + ", transitionType=" + this.transitionType + ", confidence=" + this.confidence + ", confidenceSource=" + this.confidenceSource + ", type=" + this.type + ", geofenceId=" + this.geofenceId + ", eventTime=" + this.eventTime + ", aoiBoard=(" + this.aoiBoard + ")]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.poiId);
        r3.writeString(this.poiName);
        r3.writeString(this.aoiBoard);
        r3.writeInt(this.curState.ordinal());
        r3.writeInt(this.transitionType.ordinal());
        r3.writeInt(this.confidence.ordinal());
        r3.writeInt(this.confidenceSource.ordinal());
        r3.writeInt(this.event.ordinal());
        r3.writeInt(this.type.ordinal());
        r3.writeString(this.geofenceId);
        r3.writeLong(this.eventTime);
    }
}
