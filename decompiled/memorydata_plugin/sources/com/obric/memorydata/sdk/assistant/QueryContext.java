package com.obric.memorydata.sdk.assistant;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/QueryContext;", "Landroid/os/Parcelable;", "windowState", "", "queryType", "<init>", "(II)V", "getWindowState", "()I", "getQueryType", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QueryContext implements Parcelable {
    public static final a CREATOR = null;
    private static final int DEFAULT_QUERY_TYPE = 0;
    private final int queryType;
    private final int windowState;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/QueryContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/assistant/QueryContext;", "<init>", "()V", "DEFAULT_QUERY_TYPE", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/memorydata/sdk/assistant/QueryContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<QueryContext> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public QueryContext a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            int r1 = r2.readInt();
            if (r2.dataAvail() <= 0) goto L5;
            int r3 = r2.readInt();
        L7:
            return new QueryContext(r1, r3);
        L5:
            r3 = 0;
            goto L7
        }

        public QueryContext[] a(int r1) {
            return new QueryContext[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ QueryContext createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ QueryContext[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public QueryContext(int r1, int r2) {
        this.windowState = r1;
        this.queryType = r2;
    }

    public static /* synthetic */ QueryContext copy$default(QueryContext r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.windowState;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.queryType;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.windowState;
    }

    public final int component2() {
        return this.queryType;
    }

    public final QueryContext copy(int r1, int r2) {
        return new QueryContext(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QueryContext.class) == true) goto L8;
        return false;
    L8:
        QueryContext r6 = (QueryContext) ZeusTransformUtils.preCheckCast(r5, QueryContext.class, "com.obric.memorydata.plugin");
        if (this.windowState == r6.windowState) goto L12;
        return false;
    L12:
        if (this.queryType == r6.queryType) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getQueryType() {
        return this.queryType;
    }

    public final int getWindowState() {
        return this.windowState;
    }

    public int hashCode() {
        return (Integer.hashCode(this.windowState) * 31) + Integer.hashCode(this.queryType);
    }

    public String toString() {
        return "QueryContext(windowState=" + this.windowState + ", queryType=" + this.queryType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.windowState);
        r1.writeInt(this.queryType);
    }
}
