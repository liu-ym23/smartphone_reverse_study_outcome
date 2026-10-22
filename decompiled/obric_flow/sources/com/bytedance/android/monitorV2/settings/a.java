package com.bytedance.android.monitorV2.settings;

import com.bytedance.android.monitorV2.util.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\n\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "settings", "d", "vidInfo", "c", "ctxInfos", "", "Ljava/lang/Long;", "()Ljava/lang/Long;", "settingsTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("settings")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String f3716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("vid_info")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String f3717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("ctx_infos")
    private final String f3718c;

    @SerializedName("settings_time")
    private final Long d;

    public a() {
        this.f3716a = null;
        this.f3717b = null;
        this.f3718c = null;
        this.d = null;
    }

    public final String a() {
        return this.f3718c;
    }

    public final String b() {
        return this.f3716a;
    }

    public final Long c() {
        return this.d;
    }

    public final String d() {
        return this.f3717b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(this.f3716a, r10.f3716a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3717b, r10.f3717b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3718c, r10.f3718c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f3716a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f3717b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f3718c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.d;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "Data(settings=" + this.f3716a + ", vidInfo=" + this.f3717b + ", ctxInfos=" + this.f3718c + ", settingsTime=" + this.d + ')';
    }
}
