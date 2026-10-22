package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyPushOpenAppBadgeNodesRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "noticeNodes", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppBadgeNode;", "sid", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getNoticeNodes", "()Ljava/util/List;", "getSid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyPushOpenAppBadgeNodesRequest implements NonProguard {
    private final List<MyOpenAppBadgeNode> noticeNodes;
    private final String sid;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyPushOpenAppBadgeNodesRequest copy$default(MyPushOpenAppBadgeNodesRequest r0, List r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.noticeNodes;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.sid;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<MyOpenAppBadgeNode> component1() {
        return this.noticeNodes;
    }

    public final String component2() {
        return this.sid;
    }

    public final MyPushOpenAppBadgeNodesRequest copy(List<MyOpenAppBadgeNode> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "noticeNodes");
        return new MyPushOpenAppBadgeNodesRequest(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyPushOpenAppBadgeNodesRequest) == true) goto L8;
        return false;
    L8:
        MyPushOpenAppBadgeNodesRequest r6 = (MyPushOpenAppBadgeNodesRequest) r5;
        if (Intrinsics.areEqual(this.noticeNodes, r6.noticeNodes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sid, r6.sid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.noticeNodes.hashCode() * 31;
        String r1 = this.sid;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MyPushOpenAppBadgeNodesRequest(noticeNodes=" + this.noticeNodes + ", sid=" + this.sid + ')';
    }

    public final List<MyOpenAppBadgeNode> getNoticeNodes() {
        return this.noticeNodes;
    }

    public final String getSid() {
        return this.sid;
    }

    public MyPushOpenAppBadgeNodesRequest(List<MyOpenAppBadgeNode> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "noticeNodes");
        this.noticeNodes = r2;
        this.sid = r3;
    }
}
