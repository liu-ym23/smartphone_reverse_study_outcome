package com.obric.assistant.interaction.impl;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl$SlardarEventParams;", "", "event", "", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getEvent", "()Ljava/lang/String;", "getCategory", "()Lorg/json/JSONObject;", "getMetric", "getExtraLog", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricApmServiceImpl$SlardarEventParams {
    private final JSONObject category;
    private final String event;
    private final JSONObject extraLog;
    private final JSONObject metric;

    public static /* synthetic */ ObricApmServiceImpl$SlardarEventParams copy$default(ObricApmServiceImpl$SlardarEventParams r0, String r1, JSONObject r2, JSONObject r3, JSONObject r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.event;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.category;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.metric;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraLog;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.event;
    }

    public final JSONObject component2() {
        return this.category;
    }

    public final JSONObject component3() {
        return this.metric;
    }

    public final JSONObject component4() {
        return this.extraLog;
    }

    public final ObricApmServiceImpl$SlardarEventParams copy(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return new ObricApmServiceImpl$SlardarEventParams(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricApmServiceImpl$SlardarEventParams) == true) goto L8;
        return false;
    L8:
        ObricApmServiceImpl$SlardarEventParams r6 = (ObricApmServiceImpl$SlardarEventParams) r5;
        if (Intrinsics.areEqual(this.event, r6.event) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.category, r6.category) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metric, r6.metric) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraLog, r6.extraLog) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.event.hashCode() * 31;
        JSONObject r1 = this.category;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        JSONObject r5 = this.metric;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        JSONObject r8 = this.extraLog;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SlardarEventParams(event=" + this.event + ", category=" + this.category + ", metric=" + this.metric + ", extraLog=" + this.extraLog + ')';
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final String getEvent() {
        return this.event;
    }

    public final JSONObject getExtraLog() {
        return this.extraLog;
    }

    public final JSONObject getMetric() {
        return this.metric;
    }

    public ObricApmServiceImpl$SlardarEventParams(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.event = r2;
        this.category = r3;
        this.metric = r4;
        this.extraLog = r5;
    }
}
