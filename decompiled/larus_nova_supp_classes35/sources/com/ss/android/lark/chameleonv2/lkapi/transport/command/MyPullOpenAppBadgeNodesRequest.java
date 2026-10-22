package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyPullOpenAppBadgeNodesRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "idFeaturePairs", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "Lkotlin/collections/ArrayList;", "isMobile", BuildConfig.FLAVOR, "strategy", BuildConfig.FLAVOR, "needTriggerPush", "<init>", "(Ljava/util/ArrayList;ZLjava/lang/Integer;Z)V", "getIdFeaturePairs", "()Ljava/util/ArrayList;", "()Z", "getStrategy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNeedTriggerPush", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/ArrayList;ZLjava/lang/Integer;Z)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyPullOpenAppBadgeNodesRequest;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyPullOpenAppBadgeNodesRequest implements NonProguard {
    private final ArrayList<MyIdFeaturePair> idFeaturePairs;
    private final boolean isMobile;
    private final boolean needTriggerPush;
    private final Integer strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyPullOpenAppBadgeNodesRequest copy$default(MyPullOpenAppBadgeNodesRequest r0, ArrayList r1, boolean r2, Integer r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.idFeaturePairs;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isMobile;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.strategy;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.needTriggerPush;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final ArrayList<MyIdFeaturePair> component1() {
        return this.idFeaturePairs;
    }

    public final boolean component2() {
        return this.isMobile;
    }

    public final Integer component3() {
        return this.strategy;
    }

    public final boolean component4() {
        return this.needTriggerPush;
    }

    public final MyPullOpenAppBadgeNodesRequest copy(ArrayList<MyIdFeaturePair> r2, boolean r3, Integer r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "idFeaturePairs");
        return new MyPullOpenAppBadgeNodesRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyPullOpenAppBadgeNodesRequest) == true) goto L8;
        return false;
    L8:
        MyPullOpenAppBadgeNodesRequest r6 = (MyPullOpenAppBadgeNodesRequest) r5;
        if (Intrinsics.areEqual(this.idFeaturePairs, r6.idFeaturePairs) == true) goto L12;
        return false;
    L12:
        if (this.isMobile == r6.isMobile) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.strategy, r6.strategy) == true) goto L18;
        return false;
    L18:
        if (this.needTriggerPush == r6.needTriggerPush) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.idFeaturePairs.hashCode() * 31;
        int r2 = 1231;
        if (this.isMobile == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        Integer r4 = this.strategy;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.needTriggerPush == true) goto L15;
        r2 = 1237;
    L15:
        return r6 + r2;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "MyPullOpenAppBadgeNodesRequest(idFeaturePairs=" + this.idFeaturePairs + ", isMobile=" + this.isMobile + ", strategy=" + this.strategy + ", needTriggerPush=" + this.needTriggerPush + ')';
    }

    public final ArrayList<MyIdFeaturePair> getIdFeaturePairs() {
        return this.idFeaturePairs;
    }

    public final boolean getNeedTriggerPush() {
        return this.needTriggerPush;
    }

    public final Integer getStrategy() {
        return this.strategy;
    }

    public final boolean isMobile() {
        return this.isMobile;
    }

    public MyPullOpenAppBadgeNodesRequest(ArrayList<MyIdFeaturePair> r2, boolean r3, Integer r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "idFeaturePairs");
        this.idFeaturePairs = r2;
        this.isMobile = r3;
        this.strategy = r4;
        this.needTriggerPush = r5;
    }
}
