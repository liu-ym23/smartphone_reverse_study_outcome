package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/QuAction;", "Landroid/os/Parcelable;", "actionId", "", "actionName", "", "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "searchResultCount", "<init>", "(ILjava/lang/String;Ljava/util/Map;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActionId", "()I", "getActionName", "()Ljava/lang/String;", "getInputParams", "()Ljava/util/Map;", "getSearchResultCount", "setSearchResultCount", "(I)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QuAction implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("id")
    private final int actionId;
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private int searchResultCount;

    public static final class a implements Parcelable.Creator<QuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuAction createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new QuAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final QuAction[] newArray(int r1) {
            return new QuAction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuAction copy$default(QuAction r0, int r1, String r2, Map r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.actionId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.actionName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.inputParams;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.searchResultCount;
    L15:
        return r0.copy(r1, r2, r3, r4);
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
        Intrinsics.checkNotNullParameter(r3, "actionName");
        return new QuAction(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QuAction) == true) goto L8;
        return false;
    L8:
        QuAction r6 = (QuAction) r5;
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

    public int hashCode() {
        int r0 = ((this.actionId * 31) + this.actionName.hashCode()) * 31;
        Map<String, ParamItem> r1 = this.inputParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.searchResultCount;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "QuAction(actionId=" + this.actionId + ", actionName=" + this.actionName + ", inputParams=" + this.inputParams + ", searchResultCount=" + this.searchResultCount + ')';
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

    public QuAction(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r0 = r4.readInt();
        String r1 = r4.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, r4.readHashMap(QuAction.class.getClassLoader()), r4.readInt());
    }

    public final void setSearchResultCount(int r1) {
        this.searchResultCount = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.actionId);
        r1.writeString(this.actionName);
        r1.writeMap(this.inputParams);
        r1.writeInt(this.searchResultCount);
    }

    public QuAction(int r2, String r3, Map<String, ParamItem> r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        this.actionId = r2;
        this.actionName = r3;
        this.inputParams = r4;
        this.searchResultCount = r5;
    }

    public /* synthetic */ QuAction(int r1, String r2, Map r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = 0;
    L5:
        this(r1, r2, r3, r4);
    }
}
