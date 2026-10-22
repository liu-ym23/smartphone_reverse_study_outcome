package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchDomainQuery;", "Landroid/os/Parcelable;", "domain", "", ChatMessage.TYPE_QUERY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDomain", "()Ljava/lang/String;", "getQuery", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchDomainQuery implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("domain")
    private final String domain;

    @SerializedName(ChatMessage.TYPE_QUERY)
    private final String query;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchDomainQuery$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/search/SearchDomainQuery;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/search/SearchDomainQuery;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<SearchDomainQuery> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public SearchDomainQuery a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new SearchDomainQuery(r1);
        }

        public SearchDomainQuery[] a(int r1) {
            return new SearchDomainQuery[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SearchDomainQuery createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SearchDomainQuery[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchDomainQuery() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public SearchDomainQuery(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        String r0 = r3.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r3.readString();
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        this(r0, r1);
    }

    public SearchDomainQuery(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "domain");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        this.domain = r2;
        this.query = r3;
    }

    public /* synthetic */ SearchDomainQuery(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ SearchDomainQuery copy$default(SearchDomainQuery r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.domain;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.query;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final SearchDomainQuery copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "domain");
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return new SearchDomainQuery(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchDomainQuery.class) == true) goto L8;
        return false;
    L8:
        SearchDomainQuery r6 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r5, SearchDomainQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.domain, r6.domain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return (this.domain.hashCode() * 31) + this.query.hashCode();
    }

    public String toString() {
        return "SearchDomainQuery(domain=" + this.domain + ", query=" + this.query + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.domain);
        r1.writeString(this.query);
    }
}
