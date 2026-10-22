package com.bytedance.android.live.recharge.trace;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/recharge/trace/g;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "", "stepList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setStepList", "(Ljava/util/List;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("step_list")
    private List<String> stepList;

    public g() {
        this.enable = true;
        RechargeTraceStep[] r0 = RechargeTraceStep.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.add(r0[r3].getValue());
        r3 = r3 + 1;
        goto L3
    L5:
        this.stepList = CollectionsKt.toList(r1);
    }

    public final boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.stepList;
    }
}
