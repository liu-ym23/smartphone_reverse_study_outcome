package com.obric.memorydata.realtimecontext.tracker;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/RealTimeTrackerValue;", "", "<init>", "()V", "NerTextSource", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeTrackerValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RealTimeTrackerValue f12486a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/RealTimeTrackerValue$NerTextSource;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNDEFINED", "TYPE_ASSIST_QUERY", "TYPE_ASSIST_REPLY", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum NerTextSource extends Enum<NerTextSource> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ NerTextSource[] $VALUES = null;
        public static final NerTextSource TYPE_ASSIST_QUERY = null;
        public static final NerTextSource TYPE_ASSIST_REPLY = null;
        public static final NerTextSource TYPE_UNDEFINED = null;
        private final int value;

        private static final /* synthetic */ NerTextSource[] $values() {
            return new NerTextSource[]{TYPE_UNDEFINED, TYPE_ASSIST_QUERY, TYPE_ASSIST_REPLY};
        }

        static {
            TYPE_UNDEFINED = new NerTextSource("TYPE_UNDEFINED", 0, -1);
            TYPE_ASSIST_QUERY = new NerTextSource("TYPE_ASSIST_QUERY", 1, 0);
            TYPE_ASSIST_REPLY = new NerTextSource("TYPE_ASSIST_REPLY", 2, 1);
            NerTextSource[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private NerTextSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<NerTextSource> getEntries() {
            return $ENTRIES;
        }

        public static NerTextSource valueOf(String r2) {
            return (NerTextSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(NerTextSource.class, r2), NerTextSource.class, "com.obric.memorydata.plugin");
        }

        public static NerTextSource[] values() {
            return (NerTextSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NerTextSource[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    static {
        f12486a = new RealTimeTrackerValue();
    }

    private RealTimeTrackerValue() {
    }
}
