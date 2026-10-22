package com.obric.memorydata.middleware.api.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/Extras;", "", "urlMode", "", "urlBlackList", "", "titleMode", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getUrlMode", "()Ljava/lang/String;", "getUrlBlackList", "()Ljava/util/List;", "getTitleMode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Extras {
    private final String titleMode;
    private final List<String> urlBlackList;
    private final String urlMode;

    public Extras(String r3, List<String> r4, String r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.urlMode = r3;
        this.urlBlackList = r6;
        this.titleMode = r5;
    }

    public static /* synthetic */ Extras copy$default(Extras r1, String r2, List r3, String r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.urlMode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.urlBlackList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.titleMode;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.urlMode;
    }

    public final List<String> component2() {
        return this.urlBlackList;
    }

    public final String component3() {
        return this.titleMode;
    }

    public final Extras copy(String r2, List<String> r3, String r4) {
        return new Extras(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Extras.class) == true) goto L8;
        return false;
    L8:
        Extras r6 = (Extras) ZeusTransformUtils.preCheckCast(r5, Extras.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.urlMode, r6.urlMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlBlackList, r6.urlBlackList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.titleMode, r6.titleMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getTitleMode() {
        return this.titleMode;
    }

    public final List<String> getUrlBlackList() {
        return this.urlBlackList;
    }

    public final String getUrlMode() {
        return this.urlMode;
    }

    public int hashCode() {
        String r0 = this.urlMode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.urlBlackList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.titleMode;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Extras(urlMode=" + this.urlMode + ", urlBlackList=" + this.urlBlackList + ", titleMode=" + this.titleMode + ')';
    }
}
