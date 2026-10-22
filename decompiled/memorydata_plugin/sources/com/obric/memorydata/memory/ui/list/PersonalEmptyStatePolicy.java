package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalEmptyStatePolicy;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/memory/ui/list/PersonalEmptyStatePolicy$State;", "isMigrating", "", "isUpdating", "hasContent", "State", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalEmptyStatePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PersonalEmptyStatePolicy f11094a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalEmptyStatePolicy$State;", "", "<init>", "(Ljava/lang/String;I)V", "MIGRATING", "UPDATING", "CONTENT", "EMPTY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CONTENT = null;
        public static final State EMPTY = null;
        public static final State MIGRATING = null;
        public static final State UPDATING = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{MIGRATING, UPDATING, CONTENT, EMPTY};
        }

        static {
            MIGRATING = new State("MIGRATING", 0);
            UPDATING = new State("UPDATING", 1);
            CONTENT = new State("CONTENT", 2);
            EMPTY = new State("EMPTY", 3);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f11094a = new PersonalEmptyStatePolicy();
    }

    private PersonalEmptyStatePolicy() {
    }

    public final State a(boolean r1, boolean r2, boolean r3) {
        if (r1 == true) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return State.CONTENT;
    L9:
        return State.EMPTY;
    L11:
        return State.UPDATING;
    L10:
        return State.MIGRATING;
    }
}
