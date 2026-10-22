package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/JsbAuthInfo;", "Ljava/io/Serializable;", "pattern", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "group", "Lcom/ss/android/lark/chameleon/JsbAuthGroup;", "includedMethods", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "excludedMethods", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/JsbAuthGroup;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getPattern", "()Ljava/lang/String;", "getGroup", "()Lcom/ss/android/lark/chameleon/JsbAuthGroup;", "getIncludedMethods", "()Ljava/util/ArrayList;", "getExcludedMethods", "component1", "component2", "component3", "component4", "copy", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JsbAuthInfo implements Serializable {
    private final ArrayList<String> excludedMethods;
    private final JsbAuthGroup group;
    private final ArrayList<String> includedMethods;
    private final String pattern;

    public JsbAuthInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsbAuthInfo copy$default(JsbAuthInfo r0, String r1, JsbAuthGroup r2, ArrayList r3, ArrayList r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.pattern;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.group;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.includedMethods;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.excludedMethods;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.pattern;
    }

    public final JsbAuthGroup component2() {
        return this.group;
    }

    public final ArrayList<String> component3() {
        return this.includedMethods;
    }

    public final ArrayList<String> component4() {
        return this.excludedMethods;
    }

    public final JsbAuthInfo copy(String r2, JsbAuthGroup r3, ArrayList<String> r4, ArrayList<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "group");
        Intrinsics.checkNotNullParameter(r4, "includedMethods");
        Intrinsics.checkNotNullParameter(r5, "excludedMethods");
        return new JsbAuthInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JsbAuthInfo) == true) goto L8;
        return false;
    L8:
        JsbAuthInfo r6 = (JsbAuthInfo) r5;
        if (Intrinsics.areEqual(this.pattern, r6.pattern) == true) goto L12;
        return false;
    L12:
        if (this.group == r6.group) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.includedMethods, r6.includedMethods) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.excludedMethods, r6.excludedMethods) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.pattern.hashCode() * 31) + this.group.hashCode()) * 31) + this.includedMethods.hashCode()) * 31) + this.excludedMethods.hashCode();
    }

    public String toString() {
        return "JsbAuthInfo(pattern=" + this.pattern + ", group=" + this.group + ", includedMethods=" + this.includedMethods + ", excludedMethods=" + this.excludedMethods + ')';
    }

    public final ArrayList<String> getExcludedMethods() {
        return this.excludedMethods;
    }

    public final JsbAuthGroup getGroup() {
        return this.group;
    }

    public final ArrayList<String> getIncludedMethods() {
        return this.includedMethods;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public JsbAuthInfo(String r2, JsbAuthGroup r3, ArrayList<String> r4, ArrayList<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "group");
        Intrinsics.checkNotNullParameter(r4, "includedMethods");
        Intrinsics.checkNotNullParameter(r5, "excludedMethods");
        this.pattern = r2;
        this.group = r3;
        this.includedMethods = r4;
        this.excludedMethods = r5;
    }

    public /* synthetic */ JsbAuthInfo(String r1, JsbAuthGroup r2, ArrayList r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = JsbAuthGroup.Public;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = new ArrayList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = new ArrayList();
    L14:
        this(r1, r2, r3, r4);
    }
}
