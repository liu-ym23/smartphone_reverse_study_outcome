package cn.nubia.neopush.sdk;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class NeoPushCommandMessage {
    public static final String SET_ALIAS = "set_alias";
    public static final String SET_TOPIC = "set_topic";
    public static final String UNREGISTER_APP = "unregister_app";
    public static final String UNSET_TOPIC = "unset_topic";
    private String command;
    private String reason;
    private boolean result;

    public NeoPushCommandMessage() {
    }

    public String getCommand() {
        return this.command;
    }

    public String getReason() {
        return this.reason;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCommand(String r5) {
        this.command = r5;
    }

    public void setReason(String r5) {
        this.reason = r5;
    }

    public void setResult(boolean r5) {
        this.result = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("NeoPushCommandMessage{command='");
        r5.append(this.command);
        r5.append("', result=");
        r5.append(this.result);
        r5.append(", reason='");
        return j0.q(r5, this.reason, "'}");
    }
}
