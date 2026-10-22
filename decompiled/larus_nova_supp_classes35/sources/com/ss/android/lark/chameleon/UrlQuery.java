package com.ss.android.lark.chameleon;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0000J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/UrlQuery;", "Ljava/io/Serializable;", IPortraitService.TYPE, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "queryKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getQueryKey", "()Ljava/util/ArrayList;", "setQueryKey", "(Ljava/util/ArrayList;)V", "copy", "toString", "component1", "component2", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlQuery implements Serializable {
    private ArrayList<String> queryKey;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public UrlQuery() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlQuery copy$default(UrlQuery r0, String r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.queryKey;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<String> component2() {
        return this.queryKey;
    }

    public final UrlQuery copy(String r2, ArrayList<String> r3) {
        return new UrlQuery(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlQuery) == true) goto L8;
        return false;
    L8:
        UrlQuery r6 = (UrlQuery) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryKey, r6.queryKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<String> r4 = this.queryKey;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final UrlQuery copy() {
        String r0 = this.type;
        ArrayList<String> r1 = this.queryKey;
        if (r1 == null) goto L5;
        ArrayList r2 = new ArrayList(r1);
    L7:
        return new UrlQuery(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    public String toString() {
        return "UrlQuery(type=" + this.type + ", queryKey=" + this.queryKey + ')';
    }

    public final ArrayList<String> getQueryKey() {
        return this.queryKey;
    }

    public final String getType() {
        return this.type;
    }

    public final void setQueryKey(ArrayList<String> r1) {
        this.queryKey = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public UrlQuery(String r1, ArrayList<String> r2) {
        this.type = r1;
        this.queryKey = r2;
    }

    public /* synthetic */ UrlQuery(String r2, ArrayList r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
