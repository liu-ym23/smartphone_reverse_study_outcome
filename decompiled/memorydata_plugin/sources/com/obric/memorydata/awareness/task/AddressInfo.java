package com.obric.memorydata.awareness.task;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/task/AddressInfo;", "", ActivityLifecycle.NAME, "", MemoryListActivity.JUMP_FROM_DETAIL, "latitude", "", "longitude", "isSelect", "", "isFromAutoLearn", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDZZ)V", "getName", "()Ljava/lang/String;", "getDetail", "getLatitude", "()D", "getLongitude", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressInfo {
    private final String detail;
    private final boolean isFromAutoLearn;
    private boolean isSelect;
    private final double latitude;
    private final double longitude;
    private final String name;

    public AddressInfo(String r2, String r3, double r4, double r6, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, MemoryListActivity.JUMP_FROM_DETAIL);
        this.name = r2;
        this.detail = r3;
        this.latitude = r4;
        this.longitude = r6;
        this.isSelect = r8;
        this.isFromAutoLearn = r9;
    }

    public /* synthetic */ AddressInfo(String r11, String r12, double r13, double r15, boolean r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r9 = false;
    L6:
        this(r11, r12, r13, r15, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public static /* synthetic */ AddressInfo copy$default(AddressInfo r9, String r10, String r11, double r12, double r14, boolean r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.name;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.detail;
    L11:
        if ((r18 & 4) == 0) goto L13;
        double r3 = r9.latitude;
    L15:
        if ((r18 & 8) == 0) goto L17;
        double r5 = r9.longitude;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r7 = r9.isSelect;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r8 = r9.isFromAutoLearn;
    L27:
        return r9.copy(r1, r2, r3, r5, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.detail;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    public final boolean component5() {
        return this.isSelect;
    }

    public final boolean component6() {
        return this.isFromAutoLearn;
    }

    public final AddressInfo copy(String r11, String r12, double r13, double r15, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, MemoryListActivity.JUMP_FROM_DETAIL);
        return new AddressInfo(r11, r12, r13, r15, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AddressInfo.class) == true) goto L8;
        return false;
    L8:
        AddressInfo r10 = (AddressInfo) ZeusTransformUtils.preCheckCast(r9, AddressInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.detail, r10.detail) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L21;
        return false;
    L21:
        if (this.isSelect == r10.isSelect) goto L24;
        return false;
    L24:
        if (this.isFromAutoLearn == r10.isFromAutoLearn) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.detail.hashCode()) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + Boolean.hashCode(this.isSelect)) * 31) + Boolean.hashCode(this.isFromAutoLearn);
    }

    public final boolean isFromAutoLearn() {
        return this.isFromAutoLearn;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean r1) {
        this.isSelect = r1;
    }

    public String toString() {
        return "AddressInfo(name=" + this.name + ", detail=" + this.detail + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", isSelect=" + this.isSelect + ", isFromAutoLearn=" + this.isFromAutoLearn + ')';
    }
}
