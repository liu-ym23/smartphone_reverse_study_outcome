package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.SearchNodeEnum;
import com.obric.memorydata.sdk.screencapture.rule.TextMatchRuleEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JQ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u00060"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "Landroid/os/Parcelable;", "keyword", "", "searchNode", "Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "matchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "traverseAllChildren", "", "viewIdResourceName", "viewTreeCacheValidDuration", "", "viewVisibleOnly", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;ZLjava/lang/String;JZ)V", "getKeyword", "()Ljava/lang/String;", "getSearchNode", "()Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "getMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "getTraverseAllChildren", "()Z", "getViewIdResourceName", "getViewTreeCacheValidDuration", "()J", "getViewVisibleOnly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeywordMatchRule implements Parcelable {
    public static final Parcelable.Creator<KeywordMatchRule> CREATOR = null;
    private final String keyword;
    private final TextMatchRuleEnum matchRule;
    private final SearchNodeEnum searchNode;
    private final boolean traverseAllChildren;
    private final String viewIdResourceName;
    private final long viewTreeCacheValidDuration;
    private final boolean viewVisibleOnly;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<KeywordMatchRule> {
        public a() {
        }

        public final KeywordMatchRule a(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r1 = r11.readString();
            SearchNodeEnum r2 = SearchNodeEnum.valueOf(r11.readString());
            TextMatchRuleEnum r3 = TextMatchRuleEnum.valueOf(r11.readString());
            if (r11.readInt() == 0) goto L5;
            boolean r6 = true;
        L6:
            String r7 = r11.readString();
            long r8 = r11.readLong();
            if (r11.readInt() == 0) goto L9;
            boolean r12 = true;
        L11:
            return new KeywordMatchRule(r1, r2, r3, r6, r7, r8, r12);
        L9:
            r12 = false;
            goto L11
        L5:
            r6 = false;
            goto L6
        }

        public final KeywordMatchRule[] a(int r1) {
            return new KeywordMatchRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ KeywordMatchRule createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ KeywordMatchRule[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public KeywordMatchRule(String r2, SearchNodeEnum r3, TextMatchRuleEnum r4, boolean r5, String r6, long r7, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "searchNode");
        Intrinsics.checkNotNullParameter(r4, "matchRule");
        this.keyword = r2;
        this.searchNode = r3;
        this.matchRule = r4;
        this.traverseAllChildren = r5;
        this.viewIdResourceName = r6;
        this.viewTreeCacheValidDuration = r7;
        this.viewVisibleOnly = r9;
    }

    public /* synthetic */ KeywordMatchRule(String r11, SearchNodeEnum r12, TextMatchRuleEnum r13, boolean r14, String r15, long r16, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r19 & 16) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r19 & 32) == 0) goto L13;
        long r7 = 1000;
    L15:
        if ((r19 & 64) == 0) goto L17;
        boolean r9 = true;
    L18:
        this(r11, r12, r13, r5, r6, r7, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public static /* synthetic */ KeywordMatchRule copy$default(KeywordMatchRule r9, String r10, SearchNodeEnum r11, TextMatchRuleEnum r12, boolean r13, String r14, long r15, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.keyword;
    L7:
        if ((r18 & 2) == 0) goto L9;
        SearchNodeEnum r2 = r9.searchNode;
    L11:
        if ((r18 & 4) == 0) goto L13;
        TextMatchRuleEnum r3 = r9.matchRule;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r4 = r9.traverseAllChildren;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.viewIdResourceName;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r6 = r9.viewTreeCacheValidDuration;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.viewVisibleOnly;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.keyword;
    }

    public final SearchNodeEnum component2() {
        return this.searchNode;
    }

    public final TextMatchRuleEnum component3() {
        return this.matchRule;
    }

    public final boolean component4() {
        return this.traverseAllChildren;
    }

    public final String component5() {
        return this.viewIdResourceName;
    }

    public final long component6() {
        return this.viewTreeCacheValidDuration;
    }

    public final boolean component7() {
        return this.viewVisibleOnly;
    }

    public final KeywordMatchRule copy(String r11, SearchNodeEnum r12, TextMatchRuleEnum r13, boolean r14, String r15, long r16, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "keyword");
        Intrinsics.checkNotNullParameter(r12, "searchNode");
        Intrinsics.checkNotNullParameter(r13, "matchRule");
        return new KeywordMatchRule(r11, r12, r13, r14, r15, r16, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, KeywordMatchRule.class) == true) goto L8;
        return false;
    L8:
        KeywordMatchRule r10 = (KeywordMatchRule) ZeusTransformUtils.preCheckCast(r9, KeywordMatchRule.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.keyword, r10.keyword) == true) goto L12;
        return false;
    L12:
        if (this.searchNode == r10.searchNode) goto L15;
        return false;
    L15:
        if (this.matchRule == r10.matchRule) goto L18;
        return false;
    L18:
        if (this.traverseAllChildren == r10.traverseAllChildren) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.viewIdResourceName, r10.viewIdResourceName) == true) goto L24;
        return false;
    L24:
        if (this.viewTreeCacheValidDuration == r10.viewTreeCacheValidDuration) goto L27;
        return false;
    L27:
        if (this.viewVisibleOnly == r10.viewVisibleOnly) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final TextMatchRuleEnum getMatchRule() {
        return this.matchRule;
    }

    public final SearchNodeEnum getSearchNode() {
        return this.searchNode;
    }

    public final boolean getTraverseAllChildren() {
        return this.traverseAllChildren;
    }

    public final String getViewIdResourceName() {
        return this.viewIdResourceName;
    }

    public final long getViewTreeCacheValidDuration() {
        return this.viewTreeCacheValidDuration;
    }

    public final boolean getViewVisibleOnly() {
        return this.viewVisibleOnly;
    }

    public int hashCode() {
        int r0 = ((((((this.keyword.hashCode() * 31) + this.searchNode.hashCode()) * 31) + this.matchRule.hashCode()) * 31) + Boolean.hashCode(this.traverseAllChildren)) * 31;
        String r1 = this.viewIdResourceName;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Long.hashCode(this.viewTreeCacheValidDuration)) * 31) + Boolean.hashCode(this.viewVisibleOnly);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "KeywordMatchRule(keyword=" + this.keyword + ", searchNode=" + this.searchNode + ", matchRule=" + this.matchRule + ", traverseAllChildren=" + this.traverseAllChildren + ", viewIdResourceName=" + this.viewIdResourceName + ", viewTreeCacheValidDuration=" + this.viewTreeCacheValidDuration + ", viewVisibleOnly=" + this.viewVisibleOnly + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.keyword);
        r3.writeString(this.searchNode.name());
        r3.writeString(this.matchRule.name());
        r3.writeInt(this.traverseAllChildren ? 1 : 0);
        r3.writeString(this.viewIdResourceName);
        r3.writeLong(this.viewTreeCacheValidDuration);
        r3.writeInt(this.viewVisibleOnly ? 1 : 0);
    }
}
