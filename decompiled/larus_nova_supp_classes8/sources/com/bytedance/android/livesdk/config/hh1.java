package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class hh1 {

    @SerializedName("duration_wait")
    public long mDurationWait;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("is_post")
    public boolean mIsPost;

    @SerializedName("is_wait_first_frame")
    public boolean mIsWaitFirstFrame;

    @SerializedName("log")
    public boolean mLog;

    @SerializedName("os_version_filter_list")
    @Nullable
    public ArrayList<Integer> mOsVersionFilterList;

    @SerializedName("strategy")
    public int mStrategy;

    public hh1() {
        this.mStrategy = 0;
        this.mOsVersionFilterList = new ArrayList();
    }
}
