package com.bytedance.iesgurd.meta;

import ai.j0;
import androidx.annotation.Keep;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "", "schema", "", "domains", "", "resourcePrefix", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDomains", "()Ljava/util/List;", "getResourcePrefix", "()Ljava/lang/String;", "setResourcePrefix", "(Ljava/lang/String;)V", "getSchema", "component1", "component2", "component3", "copy", "equals", "", "other", "getUrl", "index", "", LynxMonitorService.KEY_CHANNEL, "bundle", "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class UltraUpdateResource {

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("resource_prefix")
    private String resourcePrefix;

    @SerializedName("schema")
    private final String schema;

    public UltraUpdateResource(String r5, List<String> r10, String r11) {
        this.schema = r5;
        this.domains = r10;
        this.resourcePrefix = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UltraUpdateResource copy$default(UltraUpdateResource r5, String r10, List r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.schema;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.domains;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.resourcePrefix;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.schema;
    }

    public final List<String> component2() {
        return this.domains;
    }

    public final String component3() {
        return this.resourcePrefix;
    }

    public final UltraUpdateResource copy(String r5, List<String> r10, String r11) {
        return new UltraUpdateResource(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof UltraUpdateResource) == false) goto L12;
        UltraUpdateResource r10 = (UltraUpdateResource) r5;
        if (Intrinsics.areEqual(this.schema, r10.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.domains, r10.domains) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resourcePrefix, r10.resourcePrefix) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final String getResourcePrefix() {
        return this.resourcePrefix;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUrl(int r5, String r10, String r11) {
        String r12 = this.domains.get(r5);
        if (StringsKt.k(r12, "/") == true) goto L8;
        if (StringsKt.P(this.resourcePrefix, "/") == true) goto L8;
        r12 = io.reactivex.internal.observers.h.b(r12, "/");
    L8:
        if (StringsKt.k(this.resourcePrefix, "/") == true) goto L11;
        this.resourcePrefix = io.reactivex.internal.observers.h.b(this.resourcePrefix, "/");
    L11:
        return this.schema + "://" + r12 + this.resourcePrefix + r10 + '/' + r11;
    }

    public int hashCode() {
        String r5 = this.schema;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        List<String> r13 = this.domains;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.resourcePrefix;
        if (r16 == null) goto L14;
        r10 = r16.hashCode();
    L14:
        return r15 + r10;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final void setResourcePrefix(String r5) {
        this.resourcePrefix = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("UltraUpdateResource(schema=");
        r5.append(this.schema);
        r5.append(", domains=");
        r5.append(this.domains);
        r5.append(", resourcePrefix=");
        return j0.q(r5, this.resourcePrefix, ")");
    }
}
