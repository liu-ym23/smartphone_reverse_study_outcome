package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "searchResponse", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "globalSearchResponse", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/search/SearchResponse;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getSearchResponse", "()Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "setSearchResponse", "(Lcom/obric/memorydata/sdk/entity/search/SearchResponse;)V", "getGlobalSearchResponse", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "setGlobalSearchResponse", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class GlobalAssistantIntentSearchResponse implements Parcelable {
    public static final a CREATOR = null;
    public final int a;
    public final String b;
    public final SearchResponse c;
    public final GlobalAssistantSearchResponse d;

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GlobalAssistantIntentSearchResponse) == true) goto L8;
        return false;
    L8:
        GlobalAssistantIntentSearchResponse r6 = (GlobalAssistantIntentSearchResponse) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        SearchResponse r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        GlobalAssistantSearchResponse r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GlobalAssistantIntentSearchResponse(code=" + this.a + ", message=" + this.b + ", searchResponse=" + this.c + ", globalSearchResponse=" + this.d + ')';
    }

    public GlobalAssistantIntentSearchResponse(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r0 = r5.readInt();
        String r1 = r5.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        SearchResponse r2 = (SearchResponse) r5.readParcelable(SearchResponse.class.getClassLoader());
        GlobalAssistantSearchResponse r6 = (GlobalAssistantSearchResponse) r5.readParcelable(GlobalAssistantSearchResponse.class.getClassLoader());
        Intrinsics.checkNotNullParameter(r1, "message");
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.d = r6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(this.a);
        r2.writeString(this.b);
        r2.writeParcelable(this.c, r3);
        r2.writeParcelable(this.d, r3);
    }
}
