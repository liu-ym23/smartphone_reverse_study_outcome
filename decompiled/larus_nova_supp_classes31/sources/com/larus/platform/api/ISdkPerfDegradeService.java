package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface ISdkPerfDegradeService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/ISdkPerfDegradeService$ScrollState;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING", "SETTLING", "IDLE", "DETACH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState DETACH = null;
        public static final ScrollState DRAGGING = null;
        public static final ScrollState IDLE = null;
        public static final ScrollState SETTLING = null;
        public static final /* synthetic */ ScrollState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScrollState> getEntries() {
            return b;
        }

        static {
            ScrollState r0 = new ScrollState("DRAGGING", 0);
            DRAGGING = r0;
            ScrollState r1 = new ScrollState("SETTLING", 1);
            SETTLING = r1;
            ScrollState r3 = new ScrollState("IDLE", 2);
            IDLE = r3;
            ScrollState r5 = new ScrollState("DETACH", 3);
            DETACH = r5;
            ScrollState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) a.clone();
        }

        public static ScrollState valueOf(String r1) {
            return (ScrollState) r27.a.a(ScrollState.class, r1);
        }

        public ScrollState(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a(String r1, String r2, ScrollState r3);

    boolean b(String r1);
}
