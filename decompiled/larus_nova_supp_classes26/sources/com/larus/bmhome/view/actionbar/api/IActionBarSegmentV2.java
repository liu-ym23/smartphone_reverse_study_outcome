package com.larus.bmhome.view.actionbar.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ss8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface IActionBarSegmentV2 extends e {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/view/actionbar/api/IActionBarSegmentV2$Position;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_DEFAULT", "AFTER_DEFAULT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Position extends Enum<Position> {
        public static final Position AFTER_DEFAULT = null;
        public static final Position BEFORE_DEFAULT = null;
        public static final /* synthetic */ Position[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Position> getEntries() {
            return b;
        }

        static {
            Position r0 = new Position("BEFORE_DEFAULT", 0);
            BEFORE_DEFAULT = r0;
            Position r1 = new Position("AFTER_DEFAULT", 1);
            AFTER_DEFAULT = r1;
            Position[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Position[] values() {
            return (Position[]) a.clone();
        }

        public static Position valueOf(String r1) {
            return (Position) r27.a.a(Position.class, r1);
        }

        public Position(String r1, int r2) {
            super(r1, r2);
        }
    }

    String c();

    Position getPosition();

    int getPriority();

    boolean isEnabled();
}
