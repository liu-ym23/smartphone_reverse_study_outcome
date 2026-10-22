package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatterInfo implements Serializable, y28.b<ChatterInfo> {
    private String avatarKey;
    private String id;
    private boolean isAnonymous;
    private String name;
    private Chatter.ChatterType type;

    public boolean isItemSame(ChatterInfo r1) {
        return true;
    }

    public ChatterInfo() {
        this.isAnonymous = false;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Chatter.ChatterType getType() {
        return this.type;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isContentSame(ChatterInfo r3) {
        if (TextUtils.equals(this.id, r3.id) == true) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.equals(this.name, r3.name) == false) goto L13;
        if (TextUtils.equals(this.avatarKey, r3.avatarKey) == false) goto L13;
        if (this.type != r3.type) goto L13;
        if (this.isAnonymous != r3.isAnonymous) goto L13;
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((ChatterInfo) r1);
    }

    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setType(Chatter.ChatterType r1) {
        this.type = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((ChatterInfo) r1);
    }
}
