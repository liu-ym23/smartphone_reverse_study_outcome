package com.obric.memorydata.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/utils/TelephoneStandardValue;", "", "standardPhoneNumber", "", LocationMonitorConst.TAG, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStandardPhoneNumber", "()Ljava/lang/String;", "setStandardPhoneNumber", "(Ljava/lang/String;)V", "getTag", "setTag", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("standardPhoneNumber")
    private String f13181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(LocationMonitorConst.TAG)
    private String f13182b;

    public au(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "standardPhoneNumber");
        this.f13181a = r2;
        this.f13182b = r3;
    }

    public final String a() {
        return this.f13181a;
    }

    public final String b() {
        return this.f13182b;
    }
}
