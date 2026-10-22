package com.ss.android.lark.chat.export.entity.message.content;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContentValue implements Serializable {
    private SystemMessageAction action;
    private int actionId;
    private ContentValueType contentValueType;
    private String id;
    private Boolean isAnonymous;
    private boolean isClickable;
    private String link;
    private String value;

    public ContentValue() {
    }

    public SystemMessageAction getAction() {
        return this.action;
    }

    public int getActionId() {
        return this.actionId;
    }

    public ContentValueType getContentValueType() {
        return this.contentValueType;
    }

    public String getId() {
        return this.id;
    }

    public String getLink() {
        return this.link;
    }

    public String getValue() {
        return this.value;
    }

    public Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public void setAction(SystemMessageAction r1) {
        this.action = r1;
    }

    public void setActionId(int r1) {
        this.actionId = r1;
    }

    public void setAnonymous(Boolean r1) {
        this.isAnonymous = r1;
    }

    public void setClickable(boolean r1) {
        this.isClickable = r1;
    }

    public void setContentValueType(ContentValueType r1) {
        this.contentValueType = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setLink(String r1) {
        this.link = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }
}
