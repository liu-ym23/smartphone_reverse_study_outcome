package com.bytedance.ai.settings.provider;

import ai.j0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetDegradeSetting;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appletId", "b", "c", "originalWidgetId", "degradeWidgetId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetDegradeSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appletId")
    private final String f2788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("originalWidgetId")
    private final String f2789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("degradeWidgetId")
    private final String f2790c;

    public WidgetDegradeSetting() {
        this.f2788a = "";
        this.f2789b = "";
        this.f2790c = "";
    }

    public final String a() {
        return this.f2788a;
    }

    public final String b() {
        return this.f2790c;
    }

    public final String c() {
        return this.f2789b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetDegradeSetting) == true) goto L8;
        return false;
    L8:
        WidgetDegradeSetting r10 = (WidgetDegradeSetting) r5;
        if (Intrinsics.areEqual(this.f2788a, r10.f2788a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2789b, r10.f2789b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2790c, r10.f2790c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f2788a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f2789b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f2790c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WidgetDegradeSetting(appletId=");
        r5.append(this.f2788a);
        r5.append(", originalWidgetId=");
        r5.append(this.f2789b);
        r5.append(", degradeWidgetId=");
        return j0.p(r5, this.f2790c, ')');
    }
}
