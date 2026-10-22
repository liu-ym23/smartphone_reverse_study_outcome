package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "searchResponse", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "globalSearchResponse", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/search/SearchResponse;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getSearchResponse", "()Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "setSearchResponse", "(Lcom/obric/memorydata/sdk/entity/search/SearchResponse;)V", "getGlobalSearchResponse", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "setGlobalSearchResponse", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantIntentSearchResponse implements Parcelable {
    public static final a CREATOR = null;
    private int code;
    private GlobalAssistantSearchResponse globalSearchResponse;
    private String message;
    private SearchResponse searchResponse;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalAssistantIntentSearchResponse> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalAssistantIntentSearchResponse a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GlobalAssistantIntentSearchResponse(r1);
        }

        public GlobalAssistantIntentSearchResponse[] a(int r1) {
            return new GlobalAssistantIntentSearchResponse[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantIntentSearchResponse createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantIntentSearchResponse[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalAssistantIntentSearchResponse(int r2, String r3, SearchResponse r4, GlobalAssistantSearchResponse r5) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.code = r2;
        this.message = r3;
        this.searchResponse = r4;
        this.globalSearchResponse = r5;
    }

    public GlobalAssistantIntentSearchResponse(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        int r0 = r6.readInt();
        String r1 = r6.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, (SearchResponse) ZeusTransformUtils.preCheckCast(r6.readParcelable(SearchResponse.class.getClassLoader()), SearchResponse.class, "com.obric.memorydata.plugin"), (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r6.readParcelable(GlobalAssistantSearchResponse.class.getClassLoader()), GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ GlobalAssistantIntentSearchResponse copy$default(GlobalAssistantIntentSearchResponse r0, int r1, String r2, SearchResponse r3, GlobalAssistantSearchResponse r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.searchResponse;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.globalSearchResponse;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final SearchResponse component3() {
        return this.searchResponse;
    }

    public final GlobalAssistantSearchResponse component4() {
        return this.globalSearchResponse;
    }

    public final GlobalAssistantIntentSearchResponse copy(int r1, String r2, SearchResponse r3, GlobalAssistantSearchResponse r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return new GlobalAssistantIntentSearchResponse(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantIntentSearchResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantIntentSearchResponse r6 = (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantIntentSearchResponse.class, "com.obric.memorydata.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.searchResponse, r6.searchResponse) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.globalSearchResponse, r6.globalSearchResponse) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final GlobalAssistantSearchResponse getGlobalSearchResponse() {
        return this.globalSearchResponse;
    }

    public final String getMessage() {
        return this.message;
    }

    public final SearchResponse getSearchResponse() {
        return this.searchResponse;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        SearchResponse r1 = this.searchResponse;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        GlobalAssistantSearchResponse r5 = this.globalSearchResponse;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setGlobalSearchResponse(GlobalAssistantSearchResponse r1) {
        this.globalSearchResponse = r1;
    }

    public final void setMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.message = r2;
    }

    public final void setSearchResponse(SearchResponse r1) {
        this.searchResponse = r1;
    }

    public String toString() {
        return "GlobalAssistantIntentSearchResponse(code=" + this.code + ", message=" + this.message + ", searchResponse=" + this.searchResponse + ", globalSearchResponse=" + this.globalSearchResponse + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeInt(this.code);
        r4.writeString(this.message);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.searchResponse, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.globalSearchResponse, Parcelable.class, "com.obric.memorydata.plugin"), r5);
    }
}
