package com.obric.cae.libs.location.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.geofence.StarGeofence;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    public static final enum Event extends Enum<Event> {
        public static final Event ENTER = null;
        public static final Event EXIT = null;
        public static final Event UNKNOWN = null;
        public static final /* synthetic */ Event[] b = null;
        public final int a;

        static {
            Event r0 = new Event(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            Event r1 = new Event(1, 1, "ENTER");
            ENTER = r1;
            Event r3 = new Event(2, 2, "EXIT");
            EXIT = r3;
            b = new Event[]{r0, r1, r3};
        }

        public static Event[] values() {
            return (Event[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }

        public static Event valueOf(String r1) {
            return (Event) a.a(Event.class, r1);
        }

        public Event(int r1, int r2, String r3) {
            super(r3, r1);
            this.a = r2;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State INSIDE = null;
        public static final State OUTSIDE = null;
        public static final State UNKNOWN = null;
        public static final /* synthetic */ State[] b = null;
        public final int a;

        static {
            State r0 = new State(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            State r1 = new State(1, 1, "INSIDE");
            INSIDE = r1;
            State r3 = new State(2, 2, "OUTSIDE");
            OUTSIDE = r3;
            b = new State[]{r0, r1, r3};
        }

        public static State[] values() {
            return (State[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public State(int r1, int r2, String r3) {
            super(r3, r1);
            this.a = r2;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AIRPORT = null;
        public static final Type MALL = null;
        public static final Type SUBWAY_STATION = null;
        public static final Type TRAIN_STATION = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] b = null;
        public final int a;

        static {
            Type r0 = new Type(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            Type r1 = new Type(1, 1, "AIRPORT");
            AIRPORT = r1;
            Type r3 = new Type(2, 2, "TRAIN_STATION");
            TRAIN_STATION = r3;
            Type r5 = new Type(3, 3, "SUBWAY_STATION");
            SUBWAY_STATION = r5;
            Type r7 = new Type(4, 4, "MALL");
            MALL = r7;
            b = new Type[]{r0, r1, r3, r5, r7};
        }

        public static Type[] values() {
            return (Type[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public Type(int r1, int r2, String r3) {
            super(r3, r1);
            this.a = r2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "[AoiBoard: poiId=" + this.poiId + ", name=" + this.poiName + ", geofenceId=" + this.geofenceId + ", curState=" + this.curState + ", transitionType=" + this.transitionType + ", confidence=" + this.confidence + ", confidenceSource=" + this.confidenceSource + ", type=" + this.type + ", geofenceId=" + this.geofenceId + ", eventTime=" + this.eventTime + ", aoiBoard=(" + this.aoiBoard + ")]";
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

    public void applyEvent(Event r2) {
        if (r2 != Event.ENTER) goto L6;
        this.curState = State.INSIDE;
    L9:
        setEvent(r2);
        return;
    L6:
        if (r2 != Event.EXIT) goto L8;
        this.curState = State.OUTSIDE;
        goto L9
    L8:
        this.curState = State.UNKNOWN;
        goto L9
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

    public boolean isBoundTo(StarGeofence r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.geofenceId.isEmpty() == true) goto L10;
        return this.geofenceId.equals(r3.getGeofenceId());
    L10:
        if (this.poiId.isEmpty() == false) goto L12;
        return false;
    L12:
        if (this.poiId.equals(r3.getPoiId()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isSecondLayerEnabledBy(StarGeofence r2) {
        if (isBoundTo(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
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
}
