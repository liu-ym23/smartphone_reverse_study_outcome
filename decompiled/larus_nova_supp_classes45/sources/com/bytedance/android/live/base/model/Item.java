package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.model.user.IUser;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface Item {
    public static final long DEFAULT_SUB_ID = 0;
    public static final long INVALID_ID = -1;
    public static final String MIX_ID_SEPERATOR = "_";

    IUser author();

    ImageModel cover();

    List<Object> getDislikeReason();

    long getId();

    String getMixId();

    String getVideoUrl();

    String subtitle();

    String title();
}
