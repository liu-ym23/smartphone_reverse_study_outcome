package com.ss.android.lark.notification.export.speech.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "resource_url_tpl")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/notification/export/speech/setting/ResourceUrlConfigValue;", "", "fsDomain", "", "", "", "<init>", "(Ljava/util/Map;)V", "getFsDomain", "()Ljava/util/Map;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ResourceUrlConfigValue {

    @SerializedName("fs_domains")
    private final Map<String, List<String>> fsDomain;

    public ResourceUrlConfigValue() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceUrlConfigValue copy$default(ResourceUrlConfigValue r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.fsDomain;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, List<String>> component1() {
        return this.fsDomain;
    }

    public final ResourceUrlConfigValue copy(Map<String, ? extends List<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "fsDomain");
        return new ResourceUrlConfigValue(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ResourceUrlConfigValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fsDomain, ((ResourceUrlConfigValue) r4).fsDomain) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fsDomain.hashCode();
    }

    public String toString() {
        return "ResourceUrlConfigValue(fsDomain=" + this.fsDomain + ')';
    }

    public final Map<String, List<String>> getFsDomain() {
        return this.fsDomain;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceUrlConfigValue(Map<String, ? extends List<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "fsDomain");
        this.fsDomain = r2;
    }

    public /* synthetic */ ResourceUrlConfigValue(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        this(r1);
    }
}
