package com.larus.dora.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraGlassOpenState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CLOSE", "OPEN", "UNKNOWN", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowDoraGlassOpenState extends Enum<FlowDoraGlassOpenState> {
    public static final FlowDoraGlassOpenState CLOSE = null;
    public static final a Companion = null;
    public static final FlowDoraGlassOpenState OPEN = null;
    public static final FlowDoraGlassOpenState UNKNOWN = null;
    public static final /* synthetic */ FlowDoraGlassOpenState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static FlowDoraGlassOpenState a(int r6) {
            FlowDoraGlassOpenState[] r0 = FlowDoraGlassOpenState.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            FlowDoraGlassOpenState r4 = r0[r3];
            if (r4.getValue() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return FlowDoraGlassOpenState.UNKNOWN;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static EnumEntries<FlowDoraGlassOpenState> getEntries() {
        return b;
    }

    static {
        FlowDoraGlassOpenState r0 = new FlowDoraGlassOpenState("CLOSE", 0, 0);
        CLOSE = r0;
        FlowDoraGlassOpenState r1 = new FlowDoraGlassOpenState("OPEN", 1, 1);
        OPEN = r1;
        FlowDoraGlassOpenState r3 = new FlowDoraGlassOpenState("UNKNOWN", 2, -1);
        UNKNOWN = r3;
        FlowDoraGlassOpenState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static FlowDoraGlassOpenState[] values() {
        return (FlowDoraGlassOpenState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowDoraGlassOpenState valueOf(String r1) {
        return (FlowDoraGlassOpenState) r27.a.a(FlowDoraGlassOpenState.class, r1);
    }

    public FlowDoraGlassOpenState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
