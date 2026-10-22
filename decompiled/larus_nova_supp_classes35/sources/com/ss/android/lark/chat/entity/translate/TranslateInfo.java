package com.ss.android.lark.chat.entity.translate;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TranslateInfo implements Serializable, Cloneable {
    private String language;
    private int messageContentVersion;
    private String messageId;
    private HashMap<String, TranslateInfo> subTranslateInfoMap;
    private Content translateContent;

    public int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.language;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Content r7 = this.translateContent;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.messageContentVersion;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public TranslateInfo clone() {
        TranslateInfo r0 = (TranslateInfo) super.clone();     // Catch: CloneNotSupportedException -> L6
        if ((r0.getTranslateContent() instanceof MergeForwardContent) == false) goto L5;
        r0.setTranslateContent(((MergeForwardContent) r0.getTranslateContent()).clone());     // Catch: CloneNotSupportedException -> L6
    L5:
        return r0;
    L6:
        return null;
    }

    public TranslateInfo() {
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMessageContentVersion() {
        return this.messageContentVersion;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public Map<String, TranslateInfo> getSubTranslateInfoMap() {
        return this.subTranslateInfoMap;
    }

    public <T extends Content> T getTranslateContent() {
        return (T) this.translateContent;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m532clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L21;
        TranslateInfo r5 = (TranslateInfo) r4;
        if (Objects.equals(this.messageId, r5.messageId) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.language, r5.language) == true) goto L17;
        return false;
    L17:
        if (this.messageContentVersion == r5.messageContentVersion) goto L20;
        return false;
    L20:
        return Objects.equals(this.translateContent, r5.translateContent);
    }

    public void setLanguage(String r1) {
        this.language = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setSubTranslateInfoMap(HashMap<String, TranslateInfo> r1) {
        this.subTranslateInfoMap = r1;
    }

    public void setTranslateContent(Content r1) {
        this.translateContent = r1;
    }

    public TranslateInfo(String r1, String r2, Content r3) {
        this.messageId = r1;
        this.language = r2;
        this.translateContent = r3;
    }

    public TranslateInfo(String r1, String r2, Content r3, int r4) {
        this.messageId = r1;
        this.language = r2;
        this.translateContent = r3;
        this.messageContentVersion = r4;
    }
}
