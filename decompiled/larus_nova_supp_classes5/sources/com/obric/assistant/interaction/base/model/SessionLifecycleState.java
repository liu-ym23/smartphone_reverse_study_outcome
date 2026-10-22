package com.obric.assistant.interaction.base.model;

import com.obric.assistant.interaction.base.interact.IStatable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/base/model/SessionLifecycleState;", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CREATE", "PREPARE", "SHOW", "HIDE", "DESTROY", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionLifecycleState extends Enum<SessionLifecycleState> implements IStatable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SessionLifecycleState[] $VALUES = null;
    public static final SessionLifecycleState CREATE = null;
    public static final SessionLifecycleState DESTROY = null;
    public static final SessionLifecycleState HIDE = null;
    public static final SessionLifecycleState NA = null;
    public static final SessionLifecycleState PREPARE = null;
    public static final SessionLifecycleState SHOW = null;

    private static final /* synthetic */ SessionLifecycleState[] $values() {
        return new SessionLifecycleState[]{NA, CREATE, PREPARE, SHOW, HIDE, DESTROY};
    }

    public static EnumEntries<SessionLifecycleState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new SessionLifecycleState("NA", 0);
        CREATE = new SessionLifecycleState("CREATE", 1);
        PREPARE = new SessionLifecycleState("PREPARE", 2);
        SHOW = new SessionLifecycleState("SHOW", 3);
        HIDE = new SessionLifecycleState("HIDE", 4);
        DESTROY = new SessionLifecycleState("DESTROY", 5);
        SessionLifecycleState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SessionLifecycleState[] values() {
        return (SessionLifecycleState[]) $VALUES.clone();
    }

    public static SessionLifecycleState valueOf(String r1) {
        return (SessionLifecycleState) a.a(SessionLifecycleState.class, r1);
    }

    private SessionLifecycleState(String r1, int r2) {
        super(r1, r2);
    }
}
