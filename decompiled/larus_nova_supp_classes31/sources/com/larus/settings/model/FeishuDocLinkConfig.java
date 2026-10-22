package com.larus.settings.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/model/FeishuDocLinkConfig;", "", "enable", "", "domains", "", "", "docTypes", "<init>", "(ZLjava/util/List;Ljava/util/List;)V", "getEnable", "()Z", "getDomains", "()Ljava/util/List;", "getDocTypes", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FeishuDocLinkConfig {

    @SerializedName("doc_types")
    private final List<String> docTypes;

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("enable")
    private final boolean enable;

    public FeishuDocLinkConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeishuDocLinkConfig copy$default(FeishuDocLinkConfig r0, boolean r1, List r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.domains;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.docTypes;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.domains;
    }

    public final List<String> component3() {
        return this.docTypes;
    }

    public final FeishuDocLinkConfig copy(boolean r2, List<String> r3, List<String> r4) {
        return new FeishuDocLinkConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeishuDocLinkConfig) == true) goto L8;
        return false;
    L8:
        FeishuDocLinkConfig r6 = (FeishuDocLinkConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.domains, r6.domains) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.docTypes, r6.docTypes) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        List<String> r2 = this.domains;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<String> r6 = this.docTypes;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "FeishuDocLinkConfig(enable=" + this.enable + ", domains=" + this.domains + ", docTypes=" + this.docTypes + ')';
    }

    public final List<String> getDocTypes() {
        return this.docTypes;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public FeishuDocLinkConfig(boolean r1, List<String> r2, List<String> r3) {
        this.enable = r1;
        this.domains = r2;
        this.docTypes = r3;
    }

    public /* synthetic */ FeishuDocLinkConfig(boolean r1, List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        this(r1, r2, r3);
    }
}
