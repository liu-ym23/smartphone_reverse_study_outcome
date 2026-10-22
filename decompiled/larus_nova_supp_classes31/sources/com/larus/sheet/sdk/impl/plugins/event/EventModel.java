package com.larus.sheet.sdk.impl.plugins.event;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/event/EventModel;", "Ljava/io/Serializable;", "<init>", "()V", "event", "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "type", "getType", "setType", "message", "getMessage", "setMessage", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class EventModel implements Serializable {

    @SerializedName("event")
    private String event;

    @SerializedName("message")
    private String message;

    @SerializedName("token")
    private String token;

    @SerializedName("type")
    private String type;

    public EventModel() {
    }

    public String toString() {
        return "EventModel{event=" + this.event + ", token=" + this.token + ", type=" + this.type + ", message=" + this.message + '}';
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getType() {
        return this.type;
    }

    public final void setEvent(String r1) {
        this.event = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }
}
