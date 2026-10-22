package com.larksuite.component.card.protocol.data.at;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.w;
import java.io.Serializable;
import java.util.Objects;
import ty7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AtProperty implements Serializable {
    private String content;
    private boolean isAnonymous;
    private boolean isOutChatUser;
    private String originUserName;
    private String userId;

    public AtProperty() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.content, Boolean.valueOf(this.isOutChatUser), Boolean.valueOf(this.isAnonymous)});
    }

    public String getAtContent() {
        String r0 = this.content;
        if (r0 != null) goto L6;
        return "@";
    L6:
        if (r0.startsWith("@") == false) goto L8;
        return r0;
    L8:
        return "@".concat(r0);
    }

    public String getContent() {
        String r0 = this.content;
        if (r0 == null) goto L9;
        if (r0.startsWith("@") == true) goto L9;
        return "@" + this.content;
    L9:
        return this.content;
    }

    public JsonObject toJson() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("content", this.content);
        return r0;
    }

    public String getOriginUserName() {
        return this.originUserName;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isOutChatUser() {
        return this.isOutChatUser;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        AtProperty r6 = (AtProperty) r5;
        if (this.isAnonymous == r6.isAnonymous) goto L24;
        return false;
    L24:
    L21:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        if (TextUtils.equals(this.userId, r6.userId) == false) goto L19;
        if (TextUtils.equals(getContent(), r6.getAtContent()) == false) goto L19;
        return true;
    L19:
        return false;
    }

    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setContent(String r3) {
        this.content = r3;
        String r4 = getAtContent();
        String r0 = a.a().getLoginUserId();
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        this.content = w.b(r4) + "...";
        return;
    L15:
        return;
    L5:
        if (TextUtils.isEmpty(this.userId) == true) goto L11;
        if (TextUtils.equals(this.userId, r0) == false) goto L11;
        if (w.a(r4, r4.length()) <= 18) goto L11;
        r1 = true;
        goto L12
    }

    public void setOriginUserName(String r1) {
        this.originUserName = r1;
    }

    public void setOutChatUser(boolean r1) {
        this.isOutChatUser = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }
}
