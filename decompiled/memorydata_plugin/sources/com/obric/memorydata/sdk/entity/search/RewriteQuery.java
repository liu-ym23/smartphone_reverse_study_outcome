package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0016HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "Landroid/os/Parcelable;", "domain", "", ChatMessage.TYPE_QUERY, "type", "subDomain", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDomain", "()Ljava/lang/String;", "getQuery", "getType", "getSubDomain", "()Ljava/util/Set;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RewriteQuery implements Parcelable {
    public static final a CREATOR = null;
    private final String domain;
    private final String query;
    private final Set<String> subDomain;
    private final String type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/RewriteQuery$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<RewriteQuery> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public RewriteQuery a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new RewriteQuery(r1);
        }

        public RewriteQuery[] a(int r1) {
            return new RewriteQuery[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RewriteQuery createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RewriteQuery[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public RewriteQuery(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r0 = r4.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r4.readString();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        String r3 = r4.readString();
        if (r3 != null) goto L12;
        r3 = "default";
    L12:
        String[] r5 = r4.createStringArray();
        if (r5 == null) goto L15;
        Set r6 = ArraysKt.toSet(r5);
    L16:
        this(r0, r1, r3, r6);
        return;
    L15:
        r6 = null;
        goto L16
    }

    public RewriteQuery(String r3, String r4, String r5, Set<String> r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "domain");
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        this.domain = r3;
        this.query = r4;
        this.type = r5;
        this.subDomain = r7;
    }

    public /* synthetic */ RewriteQuery(String r2, String r3, String r4, Set r5, int r6, DefaultConstructorMarker r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = null;
    L8:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ RewriteQuery copy$default(RewriteQuery r1, String r2, String r3, String r4, Set r5, int r6, Object r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.domain;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.query;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.type;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.subDomain;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.type;
    }

    public final Set<String> component4() {
        return this.subDomain;
    }

    public final RewriteQuery copy(String r2, String r3, String r4, Set<String> r5) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "domain");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        return new RewriteQuery(r2, r3, r4, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RewriteQuery.class) == true) goto L8;
        return false;
    L8:
        RewriteQuery r6 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r5, RewriteQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.domain, r6.domain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subDomain, r6.subDomain) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Set<String> getSubDomain() {
        return this.subDomain;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.domain.hashCode() * 31) + this.query.hashCode()) * 31;
        String r1 = this.type;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Set<String> r5 = this.subDomain;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RewriteQuery(domain=" + this.domain + ", query=" + this.query + ", type=" + this.type + ", subDomain=" + this.subDomain + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.domain);
        r2.writeString(this.query);
        r2.writeString(this.type);
        Set<String> r1 = this.subDomain;
        if (r1 == null) goto L5;
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L6:
        r2.writeStringArray(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
