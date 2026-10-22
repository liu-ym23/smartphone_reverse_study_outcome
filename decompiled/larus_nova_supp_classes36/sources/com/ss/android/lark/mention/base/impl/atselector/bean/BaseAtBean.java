package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseAtBean implements Serializable {
    protected String id;
    protected boolean isSelected;
    int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
        public static final int TYPE_ALL = 1;
        public static final int TYPE_AT_DOUBAO = 8;
        public static final int TYPE_GROUP_MEM = 0;
        public static final int TYPE_LABEL = 3;
        public static final int TYPE_MY_AI = 6;
        public static final int TYPE_SEARCH = 4;
        public static final int TYPE_SEARCH_TIP = 5;
        public static final int TYPE_SKELETON = 9;
        public static final int TYPE_USER_GROUP = 7;
        public static final int TYPE_WANT_AT_MEM = 2;
    }

    public abstract String getDisplayName();

    public abstract String getId();

    public abstract char getPinyin();

    public abstract int getType();

    public abstract void showAvatar(Context r1, ImageView r2, int r3, int r4);

    public BaseAtBean() {
        this.isSelected = false;
    }

    public String toString() {
        return getDisplayName();
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean r1) {
        this.isSelected = r1;
    }
}
