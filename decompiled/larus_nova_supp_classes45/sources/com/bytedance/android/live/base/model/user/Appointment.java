package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class Appointment {

    @SerializedName("push_status")
    public long PushStates;

    public Appointment() {
        this.PushStates = 0;
    }
}
