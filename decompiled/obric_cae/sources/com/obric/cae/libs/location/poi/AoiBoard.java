package com.obric.cae.libs.location.poi;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
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
        public static final /* synthetic */ Confidence[] f5409b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5410a;

        static {
            Confidence r8 = new Confidence(0, 0, "MIN");
            MIN = r8;
            Confidence r10 = new Confidence(1, 1, "LOW");
            LOW = r10;
            Confidence r11 = new Confidence(2, 2, "MEDIUM");
            MEDIUM = r11;
            Confidence r12 = new Confidence(3, 3, "HIGH");
            HIGH = r12;
            Confidence r13 = new Confidence(4, 4, "MAX");
            MAX = r13;
            f5409b = new Confidence[]{r8, r10, r11, r12, r13};
        }

        public Confidence(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5410a = r10;
        }

        public static Confidence valueOf(String r8) {
            return (Confidence) Enum.valueOf(Confidence.class, r8);
        }

        public static Confidence[] values() {
            return (Confidence[]) f5409b.clone();
        }

        public int getValue() {
            return this.f5410a;
        }
    }

    public static final enum ConfidenceSource extends Enum<ConfidenceSource> {
        public static final ConfidenceSource DEFAULT = null;
        public static final ConfidenceSource DISTANCE = null;
        public static final ConfidenceSource RETRY = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ConfidenceSource[] f5411b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5412a;

        static {
            ConfidenceSource r8 = new ConfidenceSource(0, 0, "DEFAULT");
            DEFAULT = r8;
            ConfidenceSource r10 = new ConfidenceSource(1, 1, "DISTANCE");
            DISTANCE = r10;
            ConfidenceSource r11 = new ConfidenceSource(2, 2, "RETRY");
            RETRY = r11;
            f5411b = new ConfidenceSource[]{r8, r10, r11};
        }

        public ConfidenceSource(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5412a = r10;
        }

        public static ConfidenceSource valueOf(String r8) {
            return (ConfidenceSource) Enum.valueOf(ConfidenceSource.class, r8);
        }

        public static ConfidenceSource[] values() {
            return (ConfidenceSource[]) f5411b.clone();
        }

        public int getValue() {
            return this.f5412a;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event ENTER = null;
        public static final Event EXIT = null;
        public static final Event UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Event[] f5413b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5414a;

        static {
            Event r8 = new Event(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            Event r10 = new Event(1, 1, "ENTER");
            ENTER = r10;
            Event r11 = new Event(2, 2, "EXIT");
            EXIT = r11;
            f5413b = new Event[]{r8, r10, r11};
        }

        public Event(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5414a = r10;
        }

        public static Event valueOf(String r8) {
            return (Event) Enum.valueOf(Event.class, r8);
        }

        public static Event[] values() {
            return (Event[]) f5413b.clone();
        }

        public int getValue() {
            return this.f5414a;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State INSIDE = null;
        public static final State OUTSIDE = null;
        public static final State UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f5415b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5416a;

        static {
            State r8 = new State(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            State r10 = new State(1, 1, "INSIDE");
            INSIDE = r10;
            State r11 = new State(2, 2, "OUTSIDE");
            OUTSIDE = r11;
            f5415b = new State[]{r8, r10, r11};
        }

        public State(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5416a = r10;
        }

        public static State valueOf(String r8) {
            return (State) Enum.valueOf(State.class, r8);
        }

        public static State[] values() {
            return (State[]) f5415b.clone();
        }

        public int getValue() {
            return this.f5416a;
        }
    }

    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType ENTERED_AND_EXITED = null;
        public static final TransitionType ENTERED_ONLY = null;
        public static final TransitionType EXITED_ONLY = null;
        public static final TransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f5417b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5418a;

        static {
            TransitionType r8 = new TransitionType(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            TransitionType r10 = new TransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r10;
            TransitionType r11 = new TransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r11;
            TransitionType r12 = new TransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r12;
            f5417b = new TransitionType[]{r8, r10, r11, r12};
        }

        public TransitionType(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5418a = r10;
        }

        public static TransitionType valueOf(String r8) {
            return (TransitionType) Enum.valueOf(TransitionType.class, r8);
        }

        public static TransitionType[] values() {
            return (TransitionType[]) f5417b.clone();
        }

        public int getValue() {
            return this.f5418a;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AIRPORT = null;
        public static final Type MALL = null;
        public static final Type SUBWAY_STATION = null;
        public static final Type TRAIN_STATION = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f5419b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5420a;

        static {
            Type r8 = new Type(0, 0, BdimCategoryConstants.VALUE_UNKNOWN);
            UNKNOWN = r8;
            Type r10 = new Type(1, 1, "AIRPORT");
            AIRPORT = r10;
            Type r11 = new Type(2, 2, "TRAIN_STATION");
            TRAIN_STATION = r11;
            Type r12 = new Type(3, 3, "SUBWAY_STATION");
            SUBWAY_STATION = r12;
            Type r13 = new Type(4, 4, "MALL");
            MALL = r13;
            f5419b = new Type[]{r8, r10, r11, r12, r13};
        }

        public Type(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5420a = r10;
        }

        public static Type valueOf(String r8) {
            return (Type) Enum.valueOf(Type.class, r8);
        }

        public static Type[] values() {
            return (Type[]) f5419b.clone();
        }

        public int getValue() {
            return this.f5420a;
        }
    }

    public class a implements Parcelable.Creator<AoiBoard> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard createFromParcel(Parcel r8) {
            return new AoiBoard(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard[] newArray(int r8) {
            return new AoiBoard[r8];
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

    public void applyEvent(Event r8) {
        if (r8 != Event.ENTER) goto L7;
        State r10 = State.INSIDE;
    L5:
        this.curState = r10;
        setEvent(r8);
        return;
    L7:
        if (r8 != Event.EXIT) goto L9;
        r10 = State.OUTSIDE;
        goto L5
    L9:
        r10 = State.UNKNOWN;
        goto L5
    }

    public void applyState(State r8) {
        if (r8 != null) goto L5;
        r8 = State.UNKNOWN;
    L5:
        if (this.curState == r8) goto L7;
        boolean r10 = true;
    L8:
        this.curState = r8;
        if (r10 == false) goto L11;
    L14:
        this.eventTime = System.currentTimeMillis();
        return;
    L11:
        if (r8 != State.UNKNOWN) goto L13;
        return;
    L13:
        if (this.eventTime <= 0) goto L14;
        return;
    L7:
        r10 = false;
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

    public boolean isBoundTo(StarGeofence r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this.geofenceId.isEmpty() == false) goto L8;
        String r10 = r8.getPoiId();
        String r11 = this.poiId;
        if (r10 != null) goto L12;
        return false;
    L12:
        if (r10.isEmpty() == true) goto L30;
        if (r11 != null) goto L15;
        return false;
    L15:
        if (r11.isEmpty() == true) goto L33;
        String[] r12 = r10.split(";");
        int r13 = r12.length;
        int r14 = 0;
    L18:
        if (r14 >= r13) goto L34;
        String r15 = r12[r14];
        if (r15 == null) goto L24;
        if (r11.equals(r15.trim()) == false) goto L24;
        return true;
    L24:
        r14 = r14 + 1;
        goto L18
    L34:
        return false;
    L33:
        return false;
    L30:
        return false;
    L8:
        return this.geofenceId.equals(r8.getGeofenceId());
    }

    public boolean isSecondLayerEnabledBy(StarGeofence r8) {
        if (isBoundTo(r8) == true) goto L5;
    L7:
        return false;
    L5:
        if (r8.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        return true;
    }

    public void readFromParcel(Parcel r8) {
        this.poiId = r8.readString();
        this.poiName = r8.readString();
        this.aoiBoard = r8.readString();
        this.curState = State.values()[r8.readInt()];
        this.transitionType = TransitionType.values()[r8.readInt()];
        this.confidence = Confidence.values()[r8.readInt()];
        this.confidenceSource = ConfidenceSource.values()[r8.readInt()];
        this.event = Event.values()[r8.readInt()];
        this.type = Type.values()[r8.readInt()];
        this.geofenceId = r8.readString();
        this.eventTime = r8.readLong();
    }

    public void setAoiBoard(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        this.aoiBoard = r8;
    }

    public void setConfidence(Confidence r8) {
        if (r8 != null) goto L4;
        r8 = Confidence.MIN;
    L4:
        this.confidence = r8;
    }

    public void setConfidenceSource(ConfidenceSource r8) {
        if (r8 != null) goto L4;
        r8 = ConfidenceSource.DEFAULT;
    L4:
        this.confidenceSource = r8;
    }

    public void setCurState(State r8) {
        if (r8 != null) goto L4;
        r8 = State.UNKNOWN;
    L4:
        this.curState = r8;
    }

    public void setEvent(Event r8) {
        if (r8 != null) goto L4;
        r8 = Event.UNKNOWN;
    L4:
        this.event = r8;
        if (r8 == Event.UNKNOWN) goto L8;
        this.eventTime = System.currentTimeMillis();
        return;
    }

    public void setEventTime(long r8) {
        this.eventTime = Math.max(0, r8);
    }

    public void setGeofenceId(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        this.geofenceId = r8;
    }

    public void setPoiId(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        this.poiId = r8;
    }

    public void setPoiName(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        this.poiName = r8;
    }

    public void setTransitionType(TransitionType r8) {
        if (r8 != null) goto L4;
        r8 = TransitionType.UNKNOWN;
    L4:
        this.transitionType = r8;
    }

    public void setType(Type r8) {
        if (r8 != null) goto L4;
        r8 = Type.UNKNOWN;
    L4:
        this.type = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("[AoiBoard: poiId=");
        r8.append(this.poiId);
        r8.append(", name=");
        r8.append(this.poiName);
        r8.append(", curState=");
        r8.append(this.curState);
        r8.append(", transitionType=");
        r8.append(this.transitionType);
        r8.append(", confidence=");
        r8.append(this.confidence);
        r8.append(", confidenceSource=");
        r8.append(this.confidenceSource);
        r8.append(", type=");
        r8.append(this.type);
        r8.append(", geofenceId=");
        r8.append(this.geofenceId);
        r8.append(", eventTime=");
        r8.append(this.eventTime);
        r8.append(", aoiBoard=(");
        return android.aimedia.a.i(r8, this.aoiBoard, ")]");
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.poiId);
        r8.writeString(this.poiName);
        r8.writeString(this.aoiBoard);
        r8.writeInt(this.curState.ordinal());
        r8.writeInt(this.transitionType.ordinal());
        r8.writeInt(this.confidence.ordinal());
        r8.writeInt(this.confidenceSource.ordinal());
        r8.writeInt(this.event.ordinal());
        r8.writeInt(this.type.ordinal());
        r8.writeString(this.geofenceId);
        r8.writeLong(this.eventTime);
    }

    public AoiBoard(Parcel r8) {
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
        readFromParcel(r8);
    }

    public AoiBoard(String r8, String r10, String r11) {
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
        setPoiId(r8);
        setPoiName(r10);
        setAoiBoard(r11);
    }
}
