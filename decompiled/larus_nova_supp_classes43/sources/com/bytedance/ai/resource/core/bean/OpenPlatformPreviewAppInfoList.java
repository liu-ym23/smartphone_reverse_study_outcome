package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "", "mode", "", "scanSelectedApps", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "apps", "nextCursor", "hasMore", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)V", "getMode", "()Ljava/lang/String;", "getScanSelectedApps", "()Ljava/util/List;", "getApps", "getNextCursor", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfoList {

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewAppInfo> apps;

    @SerializedName("has_more")
    private final boolean hasMore;
    private final String mode;

    @SerializedName("next_cursor")
    private final String nextCursor;

    @SerializedName("scan_selected_apps")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewAppInfo> scanSelectedApps;

    public OpenPlatformPreviewAppInfoList() {
        this(null, null, null, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfoList copy$default(OpenPlatformPreviewAppInfoList r10, String r11, List r12, List r13, String r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.mode;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.scanSelectedApps;
    L8:
        List r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.apps;
    L11:
        List r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.nextCursor;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.hasMore;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.mode;
    }

    public final List<OpenPlatformPreviewAppInfo> component2() {
        return this.scanSelectedApps;
    }

    public final List<OpenPlatformPreviewAppInfo> component3() {
        return this.apps;
    }

    public final String component4() {
        return this.nextCursor;
    }

    public final boolean component5() {
        return this.hasMore;
    }

    public final OpenPlatformPreviewAppInfoList copy(String r10, List<OpenPlatformPreviewAppInfo> r11, List<OpenPlatformPreviewAppInfo> r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        return new OpenPlatformPreviewAppInfoList(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPreviewAppInfoList) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfoList r11 = (OpenPlatformPreviewAppInfoList) r10;
        if (Intrinsics.areEqual(this.mode, r11.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scanSelectedApps, r11.scanSelectedApps) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.apps, r11.apps) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextCursor, r11.nextCursor) == true) goto L21;
        return false;
    L21:
        if (this.hasMore == r11.hasMore) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.mode.hashCode() * 31;
        List<OpenPlatformPreviewAppInfo> r1 = this.scanSelectedApps;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        List<OpenPlatformPreviewAppInfo> r13 = this.apps;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.nextCursor;
        if (r16 == null) goto L14;
        r10 = r16.hashCode();
    L14:
        int r17 = (r15 + r10) * 31;
        if (this.hasMore == false) goto L17;
        int r18 = 1231;
    L19:
        return r17 + r18;
    L17:
        r18 = 1237;
        goto L19
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformPreviewAppInfoList(mode=" + this.mode + ", scanSelectedApps=" + this.scanSelectedApps + ", apps=" + this.apps + ", nextCursor=" + this.nextCursor + ", hasMore=" + this.hasMore + ')';
    }

    public final List<OpenPlatformPreviewAppInfo> getApps() {
        return this.apps;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final List<OpenPlatformPreviewAppInfo> getScanSelectedApps() {
        return this.scanSelectedApps;
    }

    public OpenPlatformPreviewAppInfoList(String r10, List<OpenPlatformPreviewAppInfo> r11, List<OpenPlatformPreviewAppInfo> r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this.mode = r10;
        this.scanSelectedApps = r11;
        this.apps = r12;
        this.nextCursor = r13;
        this.hasMore = r14;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfoList(String r10, List r11, List r12, String r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = CollectionsKt.emptyList();
    L8:
        List r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = CollectionsKt.emptyList();
    L11:
        List r0 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = null;
    L14:
        String r1 = r13;
        if ((r15 & 16) == 0) goto L17;
        boolean r18 = false;
    L18:
        this(r10, r17, r0, r1, r18);
        return;
    L17:
        r18 = r14;
        goto L18
    }
}
