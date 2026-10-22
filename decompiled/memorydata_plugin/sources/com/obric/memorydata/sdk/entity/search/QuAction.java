package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/QuAction;", "Landroid/os/Parcelable;", "actionId", "", "actionName", "", "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "searchResultCount", "<init>", "(ILjava/lang/String;Ljava/util/Map;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActionId", "()I", "getActionName", "()Ljava/lang/String;", "getInputParams", "()Ljava/util/Map;", "getSearchResultCount", "setSearchResultCount", "(I)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QuAction implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName(OaidModel.KEY_ID)
    private final int actionId;
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private int searchResultCount;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/QuAction$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/search/QuAction;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/search/QuAction;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<QuAction> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public QuAction a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new QuAction(r1);
        }

        public QuAction[] a(int r1) {
            return new QuAction[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ QuAction createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ QuAction[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public QuAction(int r3, String r4, Map<String, ParamItem> r5, int r6) {
        Map<String, ParamItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "actionName");
        this.actionId = r3;
        this.actionName = r4;
        this.inputParams = r7;
        this.searchResultCount = r6;
    }

    public /* synthetic */ QuAction(int r2, String r3, Map r4, int r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = 0;
    L5:
        this(r2, r3, r8, r5);
    }

    public QuAction(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        int r0 = r6.readInt();
        String r1 = r6.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, (Map) ZeusTransformUtils.preCheckCast(r6.readHashMap(QuAction.class.getClassLoader()), Map.class, "com.obric.memorydata.plugin"), r6.readInt());
    }

    public static /* synthetic */ QuAction copy$default(QuAction r1, int r2, String r3, Map r4, int r5, int r6, Object r7) {
        Map<String, ParamItem> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.actionId;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.actionName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.inputParams;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.searchResultCount;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final int component1() {
        return this.actionId;
    }

    public final String component2() {
        return this.actionName;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final int component4() {
        return this.searchResultCount;
    }

    public final QuAction copy(int r2, String r3, Map<String, ParamItem> r4, int r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "actionName");
        return new QuAction(r2, r3, r1, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QuAction.class) == true) goto L8;
        return false;
    L8:
        QuAction r6 = (QuAction) ZeusTransformUtils.preCheckCast(r5, QuAction.class, "com.obric.memorydata.plugin");
        if (this.actionId == r6.actionId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionName, r6.actionName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.searchResultCount == r6.searchResultCount) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final int getSearchResultCount() {
        return this.searchResultCount;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.actionId) * 31) + this.actionName.hashCode()) * 31;
        Map<String, ParamItem> r1 = this.inputParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.searchResultCount);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setSearchResultCount(int r1) {
        this.searchResultCount = r1;
    }

    public String toString() {
        return "QuAction(actionId=" + this.actionId + ", actionName=" + this.actionName + ", inputParams=" + this.inputParams + ", searchResultCount=" + this.searchResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.actionId);
        r1.writeString(this.actionName);
        r1.writeMap(this.inputParams);
        r1.writeInt(this.searchResultCount);
    }
}
