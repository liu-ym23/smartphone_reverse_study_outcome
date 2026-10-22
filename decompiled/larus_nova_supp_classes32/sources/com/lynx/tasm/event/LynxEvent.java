package com.lynx.tasm.event;

import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxEvent {
    private long mEventID;
    private String mName;
    private int mTag;
    private v6a.a mTarget;
    private long mTimestamp;
    private LynxEventType mType;

    public static final enum LynxEventType extends Enum<LynxEventType> {
        public static final /* synthetic */ LynxEventType[] a = null;
        public static final LynxEventType kCustom = null;
        public static final LynxEventType kKeyboard = null;
        public static final LynxEventType kMouse = null;
        public static final LynxEventType kNone = null;
        public static final LynxEventType kTouch = null;
        public static final LynxEventType kWheel = null;

        static {
            LynxEventType r0 = new LynxEventType("kNone", 0);
            kNone = r0;
            LynxEventType r1 = new LynxEventType("kTouch", 1);
            kTouch = r1;
            LynxEventType r3 = new LynxEventType("kMouse", 2);
            kMouse = r3;
            LynxEventType r5 = new LynxEventType("kWheel", 3);
            kWheel = r5;
            LynxEventType r7 = new LynxEventType("kKeyboard", 4);
            kKeyboard = r7;
            LynxEventType r9 = new LynxEventType("kCustom", 5);
            kCustom = r9;
            a = new LynxEventType[]{r0, r1, r3, r5, r7, r9};
        }

        public static LynxEventType[] values() {
            return (LynxEventType[]) a.clone();
        }

        public static LynxEventType valueOf(String r1) {
            return (LynxEventType) r27.a.a(LynxEventType.class, r1);
        }

        public LynxEventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ArrayList<Object> getEventParams() {
        ArrayList<Object> r0 = new ArrayList();
        r0.add(this.mName);
        r0.add(Integer.valueOf(this.mType.ordinal()));
        r0.add(Integer.valueOf(this.mTag));
        r0.add(Long.valueOf(this.mTimestamp));
        r0.add(Long.valueOf(this.mEventID));
        return r0;
    }

    public long getEventID() {
        return this.mEventID;
    }

    public String getName() {
        return this.mName;
    }

    public int getTag() {
        return this.mTag;
    }

    public v6a.a getTarget() {
        return this.mTarget;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public LynxEventType getType() {
        return this.mType;
    }

    public void setEventID(long r1) {
        this.mEventID = r1;
    }

    public void setTarget(v6a.a r1) {
        this.mTarget = r1;
    }

    public void setTimestamp(long r1) {
        this.mTimestamp = r1;
    }

    public LynxEvent(int r3, String r4, LynxEventType r5) {
        this.mTag = -1;
        this.mName = NameKeys.UnloadStrategy_No_Strategy;
        LynxEventType r0 = LynxEventType.kNone;
        this.mTarget = null;
        this.mTimestamp = 0;
        this.mEventID = 0;
        this.mTag = r3;
        this.mName = r4;
        this.mType = r5;
        this.mTimestamp = System.currentTimeMillis();
    }
}
