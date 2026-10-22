package com.ss.android.lark.contact.base.dto;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseSelectBean implements Serializable {
    private String avatarKey;
    private int deniedReason;
    private List<String> descHighLights;
    private String description;
    private String id;
    private boolean isCrossTenant;
    boolean isSelectable;
    boolean isSelected;
    private String name;
    private List<String> nameHighLights;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectType {
        public static final int TYPE_CHAT = 1;
        public static final int TYPE_CHATTER = 2;
        public static final int TYPE_EMAIL = 3;
    }

    public abstract int getType();

    public boolean isBeBlocked() {
        if (this.deniedReason == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isBlock() {
        if (this.deniedReason != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNotContact() {
        if (this.deniedReason != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseSelectBean() {
        this.isSelected = false;
        this.isSelectable = true;
        this.nameHighLights = new ArrayList();
        this.descHighLights = new ArrayList();
    }

    public boolean isBlockOrBeBlocked() {
        if (isBeBlocked() == false) goto L5;
    L8:
        return true;
    L5:
        if (isBlock() == true) goto L8;
        return false;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public List<String> getDescHighLights() {
        return this.descHighLights;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getNameHighLights() {
        return this.nameHighLights;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public void setDeniedReason(int r1) {
        this.deniedReason = r1;
    }

    public void setDescHighLights(List<String> r1) {
        this.descHighLights = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNameHighLights(List<String> r1) {
        this.nameHighLights = r1;
    }

    public void setSelectable(boolean r1) {
        this.isSelectable = r1;
    }

    public void setSelected(boolean r1) {
        this.isSelected = r1;
    }
}
