package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0000J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/JsbAuthConfig;", "Ljava/io/Serializable;", "jsbAuthEnable", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "enableIframeCallPrivateJsb", "jsbAuthInfoList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/JsbAuthInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(ZZLjava/util/ArrayList;)V", "getJsbAuthEnable", "()Z", "getEnableIframeCallPrivateJsb", "getJsbAuthInfoList", "()Ljava/util/ArrayList;", "copy", "component1", "component2", "component3", "equals", "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "toString", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JsbAuthConfig implements Serializable {
    private final boolean enableIframeCallPrivateJsb;
    private final boolean jsbAuthEnable;
    private final ArrayList<JsbAuthInfo> jsbAuthInfoList;

    public JsbAuthConfig() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsbAuthConfig copy$default(JsbAuthConfig r0, boolean r1, boolean r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.jsbAuthEnable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enableIframeCallPrivateJsb;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.jsbAuthInfoList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.jsbAuthEnable;
    }

    public final boolean component2() {
        return this.enableIframeCallPrivateJsb;
    }

    public final ArrayList<JsbAuthInfo> component3() {
        return this.jsbAuthInfoList;
    }

    public final JsbAuthConfig copy(boolean r2, boolean r3, ArrayList<JsbAuthInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "jsbAuthInfoList");
        return new JsbAuthConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JsbAuthConfig) == true) goto L8;
        return false;
    L8:
        JsbAuthConfig r6 = (JsbAuthConfig) r5;
        if (this.jsbAuthEnable == r6.jsbAuthEnable) goto L12;
        return false;
    L12:
        if (this.enableIframeCallPrivateJsb == r6.enableIframeCallPrivateJsb) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jsbAuthInfoList, r6.jsbAuthInfoList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.jsbAuthEnable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableIframeCallPrivateJsb == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.jsbAuthInfoList.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "JsbAuthConfig(jsbAuthEnable=" + this.jsbAuthEnable + ", enableIframeCallPrivateJsb=" + this.enableIframeCallPrivateJsb + ", jsbAuthInfoList=" + this.jsbAuthInfoList + ')';
    }

    public final JsbAuthConfig copy() {
        boolean r0 = this.jsbAuthEnable;
        boolean r1 = this.enableIframeCallPrivateJsb;
        ArrayList<JsbAuthInfo> r2 = this.jsbAuthInfoList;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r3.add(JsbAuthInfo.copy$default((JsbAuthInfo) r4.next(), null, null, null, null, 15, null));
        goto L4
    L7:
        return new JsbAuthConfig(r0, r1, new ArrayList(r3));
    }

    public final boolean getEnableIframeCallPrivateJsb() {
        return this.enableIframeCallPrivateJsb;
    }

    public final boolean getJsbAuthEnable() {
        return this.jsbAuthEnable;
    }

    public final ArrayList<JsbAuthInfo> getJsbAuthInfoList() {
        return this.jsbAuthInfoList;
    }

    public JsbAuthConfig(boolean r2, boolean r3, ArrayList<JsbAuthInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "jsbAuthInfoList");
        this.jsbAuthEnable = r2;
        this.enableIframeCallPrivateJsb = r3;
        this.jsbAuthInfoList = r4;
    }

    public /* synthetic */ JsbAuthConfig(boolean r2, boolean r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new ArrayList();
    L11:
        this(r2, r3, r4);
    }
}
