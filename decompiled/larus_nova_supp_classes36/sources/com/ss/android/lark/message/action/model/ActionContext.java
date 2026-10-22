package com.ss.android.lark.message.action.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ActionContext {
    public ActionChat a;
    public ActionMode b;
    public List<ActionMessage> c;

    public ActionContext() {
    }

    public ActionChat getActionChat() {
        return this.a;
    }

    public List<ActionMessage> getActionMessages() {
        return this.c;
    }

    public ActionMode getActionMode() {
        return this.b;
    }

    public void setActionChat(ActionChat r1) {
        this.a = r1;
    }

    public void setActionMessages(List<ActionMessage> r1) {
        this.c = r1;
    }

    public void setActionMode(ActionMode r1) {
        this.b = r1;
    }
}
