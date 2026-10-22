package com.bytedance.iesgurd.model;

import androidx.annotation.Keep;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0013\u001a\u00020\u0004J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J \u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/DeploymentsData;", "", "groups", "", "", "channels", "(Ljava/util/List;Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "component1", "component2", "copy", "equals", "", "other", "getSortString", "hashCode", "", "isHit", "group", LynxMonitorService.KEY_CHANNEL, "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class DeploymentsData {

    @SerializedName("target_channels")
    private List<String> channels;

    @SerializedName("group_names")
    private List<String> groups;

    public DeploymentsData(List<String> r5, List<String> r10) {
        this.groups = r5;
        this.channels = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeploymentsData copy$default(DeploymentsData r5, List r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.groups;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.channels;
    L9:
        return r5.copy(r10, r11);
    }

    public final List<String> component1() {
        return this.groups;
    }

    public final List<String> component2() {
        return this.channels;
    }

    public final DeploymentsData copy(List<String> r5, List<String> r10) {
        return new DeploymentsData(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof DeploymentsData) == false) goto L10;
        DeploymentsData r10 = (DeploymentsData) r5;
        if (Intrinsics.areEqual(this.groups, r10.groups) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channels, r10.channels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final String getSortString() {
        StringBuilder r5 = new StringBuilder();
        List<String> r10 = this.groups;
        if (r10 == null) goto L5;
        r5.append(CollectionsKt.sorted(r10).toString());
    L5:
        List<String> r11 = this.channels;
        if (r11 == null) goto L9;
        r5.append(CollectionsKt.sorted(r11).toString());
    L9:
        return r5.toString();
    }

    public int hashCode() {
        List<String> r5 = this.groups;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        List<String> r13 = this.channels;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public final boolean isHit(List<String> r5, String r10) {
        List<String> r11 = this.groups;
        if (r11 != null) goto L5;
    L6:
        List<String> r12 = this.channels;
        if (r12 != null) goto L9;
    L47:
        return true;
    L9:
        if (r12.isEmpty() == true) goto L47;
    L11:
        if (r10 == null) goto L23;
        List<String> r13 = this.channels;
        if (r13 == null) goto L23;
        if (r13.isEmpty() == true) goto L23;
        List<String> r14 = this.channels;
        if (r14 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        if (r14.contains(r10) == false) goto L23;
        return true;
    L23:
        if (r5 == null) goto L45;
        List<String> r15 = this.groups;
        if (r15 != null) goto L27;
        return false;
    L27:
        if (r15.isEmpty() == true) goto L53;
        List<String> r16 = this.groups;
        if (r16 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        Iterator<T> r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L38;
        Object r18 = r17.next();
        if (r5.contains((String) r18) == false) goto L34;
    L39:
        CharSequence r19 = (CharSequence) r18;
        if (r19 != null) goto L42;
        return false;
    L42:
        if (r19.length() == 0) goto L54;
        return true;
    L54:
        return false;
    L38:
        r18 = null;
        goto L39
    L53:
        return false;
    L45:
        return false;
    L5:
        if (r11.isEmpty() == false) goto L11;
        goto L6
    }

    public final void setChannels(List<String> r5) {
        this.channels = r5;
    }

    public final void setGroups(List<String> r5) {
        this.groups = r5;
    }

    public String toString() {
        return "DeploymentsData(groups=" + this.groups + ", channels=" + this.channels + ")";
    }
}
