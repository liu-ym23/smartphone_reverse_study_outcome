package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatOptionInfo implements Serializable {
    private static final long serialVersionUID = -4912521595824753252L;
    private boolean announceIsUnread;
    private String id;

    public ChatOptionInfo() {
    }

    public String getId() {
        return this.id;
    }

    public boolean isAnnounceIsUnread() {
        return this.announceIsUnread;
    }

    public void setAnnounceIsUnread(boolean r1) {
        this.announceIsUnread = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }
}
