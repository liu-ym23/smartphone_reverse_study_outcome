package com.ss.android.lark.maintab.export.opennavi;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/maintab/export/opennavi/OpenNavigationAppInfo;", "", "appType", "Lcom/ss/android/lark/maintab/export/TabAppType;", "uniqueId", "", TabAppInfo.IMAGE_JSON_KEY, "i18nName", "", "<init>", "(Lcom/ss/android/lark/maintab/export/TabAppType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAppType", "()Lcom/ss/android/lark/maintab/export/TabAppType;", "getUniqueId", "()Ljava/lang/String;", "getKey", "getI18nName", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OpenNavigationAppInfo {
    private final TabAppType appType;
    private final Map<String, String> i18nName;
    private final String key;
    private final String uniqueId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenNavigationAppInfo copy$default(OpenNavigationAppInfo r0, TabAppType r1, String r2, String r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.appType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.uniqueId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.key;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.i18nName;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final TabAppType component1() {
        return this.appType;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final String component3() {
        return this.key;
    }

    public final Map<String, String> component4() {
        return this.i18nName;
    }

    public final OpenNavigationAppInfo copy(TabAppType r2, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "appType");
        Intrinsics.checkNotNullParameter(r5, "i18nName");
        return new OpenNavigationAppInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenNavigationAppInfo) == true) goto L8;
        return false;
    L8:
        OpenNavigationAppInfo r6 = (OpenNavigationAppInfo) r5;
        if (this.appType == r6.appType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueId, r6.uniqueId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nName, r6.i18nName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.appType.hashCode() * 31;
        String r1 = this.uniqueId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.key;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.i18nName.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenNavigationAppInfo(appType=" + this.appType + ", uniqueId=" + this.uniqueId + ", key=" + this.key + ", i18nName=" + this.i18nName + ')';
    }

    public final TabAppType getAppType() {
        return this.appType;
    }

    public final Map<String, String> getI18nName() {
        return this.i18nName;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public OpenNavigationAppInfo(TabAppType r2, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "appType");
        Intrinsics.checkNotNullParameter(r5, "i18nName");
        this.appType = r2;
        this.uniqueId = r3;
        this.key = r4;
        this.i18nName = r5;
    }

    public /* synthetic */ OpenNavigationAppInfo(TabAppType r1, String r2, String r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new HashMap();
    L5:
        this(r1, r2, r3, r4);
    }
}
