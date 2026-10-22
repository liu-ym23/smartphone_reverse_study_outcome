package com.obric.capabilitykit.entity.lark;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/entity/lark/LarkContactSearchResult;", "", "asrResult", "", "asrName", "larkContactsResults", "", "Lcom/obric/capabilitykit/entity/lark/LarkContacts;", WsConstants.KEY_EXTRA, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAsrName", "()Ljava/lang/String;", "getAsrResult", "getExtra", "getLarkContactsResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkContactSearchResult {
    private final String asrName;
    private final String asrResult;
    private final String extra;
    private final List<LarkContacts> larkContactsResults;

    public LarkContactSearchResult(String r3, String r4, List<LarkContacts> r5, String r6) {
        List<LarkContacts> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.asrResult = r3;
        this.asrName = r4;
        this.larkContactsResults = r7;
        this.extra = r6;
    }

    public static /* synthetic */ LarkContactSearchResult copy$default(LarkContactSearchResult r1, String r2, String r3, List r4, String r5, int r6, Object r7) {
        List<LarkContacts> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.asrResult;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.asrName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.larkContactsResults;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.extra;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.asrResult;
    }

    public final String component2() {
        return this.asrName;
    }

    public final List<LarkContacts> component3() {
        return this.larkContactsResults;
    }

    public final String component4() {
        return this.extra;
    }

    public final LarkContactSearchResult copy(String r2, String r3, List<LarkContacts> r4, String r5) {
        return new LarkContactSearchResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LarkContactSearchResult.class) == true) goto L8;
        return false;
    L8:
        LarkContactSearchResult r6 = (LarkContactSearchResult) ZeusTransformUtils.preCheckCast(r5, LarkContactSearchResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.asrResult, r6.asrResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrName, r6.asrName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.larkContactsResults, r6.larkContactsResults) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAsrName() {
        return this.asrName;
    }

    public final String getAsrResult() {
        return this.asrResult;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final List<LarkContacts> getLarkContactsResults() {
        return this.larkContactsResults;
    }

    public int hashCode() {
        String r0 = this.asrResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.asrName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<LarkContacts> r7 = this.larkContactsResults;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.extra;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkContactSearchResult(asrResult=" + this.asrResult + ", asrName=" + this.asrName + ", larkContactsResults=" + this.larkContactsResults + ", extra=" + this.extra + ')';
    }
}
