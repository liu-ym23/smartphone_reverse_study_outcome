package com.obric.eventkit.eventstaskmanager;

import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskAction;", "", ChatMessage.TYPE_QUERY, "", MemorySourceLinkType.INTENT, "(Ljava/lang/String;Ljava/lang/String;)V", "getIntent", "()Ljava/lang/String;", "getQuery", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerTaskAction {
    private final String intent;
    private final String query;

    /* JADX WARN: Multi-variable type inference failed */
    public TimerTaskAction() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public TimerTaskAction(String r1, String r2) {
        this.query = r1;
        this.intent = r2;
    }

    public /* synthetic */ TimerTaskAction(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ TimerTaskAction copy$default(TimerTaskAction r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.intent;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.intent;
    }

    public final TimerTaskAction copy(String r1, String r2) {
        return new TimerTaskAction(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerTaskAction.class) == true) goto L8;
        return false;
    L8:
        TimerTaskAction r6 = (TimerTaskAction) ZeusTransformUtils.preCheckCast(r5, TimerTaskAction.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.intent;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        String r1 = j.a().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "gson.toJson(this)");
        return r1;
    }
}
