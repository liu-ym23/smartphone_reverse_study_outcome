package e50;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a {

    @SerializedName("dispatcher_task_inner_delay")
    public long mDispatcherTaskInnerDelay;

    @SerializedName("dispatcher_type")
    public int mDispatcherType;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("enable_log")
    public boolean mEnableLog;

    @SerializedName("insert_support")
    public boolean mInsertSupport;

    @SerializedName("simple_log")
    public boolean mSimpleLog;

    public a() {
        this.mEnable = false;
        this.mInsertSupport = false;
        this.mEnableLog = false;
        this.mSimpleLog = false;
        this.mDispatcherType = 0;
        this.mDispatcherTaskInnerDelay = 0;
    }
}
