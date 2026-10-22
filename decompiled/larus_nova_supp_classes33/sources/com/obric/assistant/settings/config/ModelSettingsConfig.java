package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/assistant/settings/config/ModelSettingsConfig;", "Landroid/os/Parcelable;", "queryWithPicTimeout", "", "modelSettingsEnable", "", "defaultModel", "", "modelSettingsList", "", "Lcom/obric/assistant/settings/config/ModelSettingsItem;", "<init>", "(JZLjava/lang/String;Ljava/util/List;)V", "getQueryWithPicTimeout", "()J", "getModelSettingsList", "()Ljava/util/List;", "isModelSettingsEnable", "getDefaultModel", "getModel", "key", "getModelList", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsConfig implements Parcelable {
    public static final Parcelable.Creator<ModelSettingsConfig> CREATOR = null;

    @SerializedName("default_model")
    private final String defaultModel;

    @SerializedName("model_settings_enable")
    private final boolean modelSettingsEnable;

    @SerializedName("model_settings_list")
    private final List<ModelSettingsItem> modelSettingsList;

    @SerializedName("query_with_pic_timeout")
    private final long queryWithPicTimeout;

    public static final class a implements Parcelable.Creator<ModelSettingsConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsConfig createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            long r2 = r9.readLong();
            int r1 = 0;
            if (r9.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r9.readString();
            if (r9.readInt() != 0) goto L9;
            ArrayList r6 = null;
        L13:
            return new ModelSettingsConfig(r2, r4, r5, r6);
        L9:
            int r0 = r9.readInt();
            r6 = new ArrayList(r0);
        L10:
            if (r1 == r0) goto L13;
            r6.add(ModelSettingsItem.CREATOR.createFromParcel(r9));
            r1 = r1 + 1;
            goto L10
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsConfig[] newArray(int r1) {
            return new ModelSettingsConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModelSettingsConfig() {
        this(0, false, null, null, 15, null);
    }

    private final boolean component2() {
        return this.modelSettingsEnable;
    }

    private final String component3() {
        return this.defaultModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSettingsConfig copy$default(ModelSettingsConfig r6, long r7, boolean r9, String r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.queryWithPicTimeout;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.modelSettingsEnable;
    L8:
        boolean r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.defaultModel;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.modelSettingsList;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.queryWithPicTimeout;
    }

    public final List<ModelSettingsItem> component4() {
        return this.modelSettingsList;
    }

    public final ModelSettingsConfig copy(long r8, boolean r10, String r11, List<ModelSettingsItem> r12) {
        return new ModelSettingsConfig(r8, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ModelSettingsConfig) == true) goto L8;
        return false;
    L8:
        ModelSettingsConfig r9 = (ModelSettingsConfig) r8;
        if (this.queryWithPicTimeout == r9.queryWithPicTimeout) goto L12;
        return false;
    L12:
        if (this.modelSettingsEnable == r9.modelSettingsEnable) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultModel, r9.defaultModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.modelSettingsList, r9.modelSettingsList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r0 = this.queryWithPicTimeout;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        if (this.modelSettingsEnable == false) goto L5;
        int r2 = 1231;
    L6:
        int r3 = (r1 + r2) * 31;
        String r4 = this.defaultModel;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        List<ModelSettingsItem> r8 = this.modelSettingsList;
        if (r8 == null) goto L15;
        r5 = r8.hashCode();
    L15:
        return r7 + r5;
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r2 = 1237;
        goto L6
    }

    public String toString() {
        return "ModelSettingsConfig(queryWithPicTimeout=" + this.queryWithPicTimeout + ", modelSettingsEnable=" + this.modelSettingsEnable + ", defaultModel=" + this.defaultModel + ", modelSettingsList=" + this.modelSettingsList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.queryWithPicTimeout);
        r3.writeInt(this.modelSettingsEnable ? 1 : 0);
        r3.writeString(this.defaultModel);
        List<ModelSettingsItem> r0 = this.modelSettingsList;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<ModelSettingsItem> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r1.next().writeToParcel(r3, r4);
        goto L7
    }

    public final ModelSettingsItem getDefaultModel() {
        List<ModelSettingsItem> r0 = this.modelSettingsList;
        ModelSettingsItem r1 = null;
        if (r0 == null) goto L18;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        ModelSettingsItem r4 = (ModelSettingsItem) r3;
        String r5 = this.defaultModel;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        if (r4.isCurrent(r5) == false) goto L6;
    L14:
        ModelSettingsItem r6 = (ModelSettingsItem) r3;
        if (r6 == null) goto L18;
        r1 = r6;
    L21:
        if (r1 == null) goto L23;
        return r1;
    L23:
        return new ModelSettingsItem(0, null, null, 7, null);
    L13:
        r3 = null;
    L18:
        List<ModelSettingsItem> r7 = this.modelSettingsList;
        if (r7 == null) goto L21;
        r1 = (ModelSettingsItem) CollectionsKt.firstOrNull(r7);
        goto L21
    }

    public final List<ModelSettingsItem> getModelList() {
        List<ModelSettingsItem> r0 = this.modelSettingsList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean isModelSettingsEnable() {
        if (this.modelSettingsEnable == false) goto L13;
        List<ModelSettingsItem> r0 = this.modelSettingsList;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if ((!r0.isEmpty()) != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public final List<ModelSettingsItem> getModelSettingsList() {
        return this.modelSettingsList;
    }

    public final long getQueryWithPicTimeout() {
        return this.queryWithPicTimeout;
    }

    public final ModelSettingsItem getModel(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        List<ModelSettingsItem> r0 = this.modelSettingsList;
        Object r1 = null;
        if (r0 == null) goto L15;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((ModelSettingsItem) r3).isCurrent(r5) == false) goto L6;
        r1 = r3;
    L11:
        return (ModelSettingsItem) r1;
    L15:
        return null;
    }

    public ModelSettingsConfig(long r1, boolean r3, String r4, List<ModelSettingsItem> r5) {
        this.queryWithPicTimeout = r1;
        this.modelSettingsEnable = r3;
        this.defaultModel = r4;
        this.modelSettingsList = r5;
    }

    public /* synthetic */ ModelSettingsConfig(long r13, boolean r15, String r16, List r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r0 = 5000;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = "seed";
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r3 = CollectionsKt.arrayListOf(new ModelSettingsItem[]{new ModelSettingsItem(0, null, null, 7, null)});
    L18:
        this(r0, r2, r4, r3);
        return;
    L17:
        r3 = r17;
        goto L18
    L13:
        r4 = r16;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }
}
