package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/settings/config/ModelSettingsItem;", "Landroid/os/Parcelable;", "id", "", "key", "", "name", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getKey", "()Ljava/lang/String;", "getName", "isCurrent", "", "component1", "component2", "component3", "copy", "describeContents", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsItem implements Parcelable {
    public static final Parcelable.Creator<ModelSettingsItem> CREATOR = null;

    @SerializedName("id")
    private final int id;

    @SerializedName("key")
    private final String key;

    @SerializedName("name")
    private final String name;

    public static final class a implements Parcelable.Creator<ModelSettingsItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsItem createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new ModelSettingsItem(r4.readInt(), r4.readString(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsItem[] newArray(int r1) {
            return new ModelSettingsItem[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModelSettingsItem() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ModelSettingsItem copy$default(ModelSettingsItem r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.key;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.name;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.name;
    }

    public final ModelSettingsItem copy(int r2, String r3, String r4) {
        return new ModelSettingsItem(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ModelSettingsItem) == true) goto L8;
        return false;
    L8:
        ModelSettingsItem r6 = (ModelSettingsItem) r5;
        if (this.id == r6.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.id * 31;
        String r1 = this.key;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.name;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ModelSettingsItem(id=" + this.id + ", key=" + this.key + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.id);
        r1.writeString(this.key);
        r1.writeString(this.name);
    }

    public final int getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isCurrent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return Intrinsics.areEqual(this.key, r2);
    }

    public ModelSettingsItem(int r1, String r2, String r3) {
        this.id = r1;
        this.key = r2;
        this.name = r3;
    }

    public /* synthetic */ ModelSettingsItem(int r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "seed";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "beta 版";
    L11:
        this(r1, r2, r3);
    }
}
