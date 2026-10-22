package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.rule.SearchNodeEnum;
import com.obric.memorydata.sdk.screencapture.rule.TextMatchRuleEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JQ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u00060"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "Landroid/os/Parcelable;", "keyword", "", "searchNode", "Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "matchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "traverseAllChildren", "", "viewIdResourceName", "viewTreeCacheValidDuration", "", "viewVisibleOnly", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;ZLjava/lang/String;JZ)V", "getKeyword", "()Ljava/lang/String;", "getSearchNode", "()Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "getMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "getTraverseAllChildren", "()Z", "getViewIdResourceName", "getViewTreeCacheValidDuration", "()J", "getViewVisibleOnly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class KeywordMatchRule implements Parcelable {
    public static final Parcelable.Creator<KeywordMatchRule> CREATOR = null;
    public final String a;
    public final SearchNodeEnum b;
    public final TextMatchRuleEnum c;
    public final boolean d;
    public final String e;
    public final long f;
    public final boolean g;

    public static final class a implements Parcelable.Creator<KeywordMatchRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r2 = r12.readString();
            SearchNodeEnum r3 = SearchNodeEnum.valueOf(r12.readString());
            TextMatchRuleEnum r4 = TextMatchRuleEnum.valueOf(r12.readString());
            if (r12.readInt() == 0) goto L5;
            boolean r7 = true;
        L6:
            String r8 = r12.readString();
            long r9 = r12.readLong();
            if (r12.readInt() == 0) goto L9;
            boolean r13 = true;
        L11:
            return new KeywordMatchRule(r2, r3, r4, r7, r8, r9, r13);
        L9:
            r13 = false;
            goto L11
        L5:
            r7 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule[] newArray(int r1) {
            return new KeywordMatchRule[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof KeywordMatchRule) == true) goto L8;
        return false;
    L8:
        KeywordMatchRule r9 = (KeywordMatchRule) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        long r6 = this.f;
        int r7 = (((r3 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        if (this.g == true) goto L15;
        r2 = 1237;
    L15:
        return r7 + r2;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "KeywordMatchRule(keyword=" + this.a + ", searchNode=" + this.b + ", matchRule=" + this.c + ", traverseAllChildren=" + this.d + ", viewIdResourceName=" + this.e + ", viewTreeCacheValidDuration=" + this.f + ", viewVisibleOnly=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b.name());
        r3.writeString(this.c.name());
        r3.writeInt(this.d ? 1 : 0);
        r3.writeString(this.e);
        r3.writeLong(this.f);
        r3.writeInt(this.g ? 1 : 0);
    }

    public KeywordMatchRule(String r2, SearchNodeEnum r3, TextMatchRuleEnum r4, boolean r5, String r6, long r7, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "searchNode");
        Intrinsics.checkNotNullParameter(r4, "matchRule");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
    }
}
