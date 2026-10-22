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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/settings/config/ObricImageUploadCompressConfig;", "Landroid/os/Parcelable;", "screenSemanticScene", "", "Lcom/obric/assistant/settings/config/CompressParam;", "defaultScene", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getScreenSemanticScene", "()Ljava/util/List;", "getDefaultScene", "component1", "component2", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricImageUploadCompressConfig implements Parcelable {
    public static final Parcelable.Creator<ObricImageUploadCompressConfig> CREATOR = null;
    public static final a Companion = null;

    @SerializedName("default")
    private final List<CompressParam> defaultScene;

    @SerializedName("screen_semantic")
    private final List<CompressParam> screenSemanticScene;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<ObricImageUploadCompressConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricImageUploadCompressConfig createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            int r1 = 0;
            ArrayList r2 = null;
            if (r7.readInt() != 0) goto L5;
            ArrayList r3 = null;
        L13:
            if (r7.readInt() == 0) goto L24;
            int r0 = r7.readInt();
            ArrayList r4 = new ArrayList(r0);
        L16:
            if (r1 == r0) goto L22;
            if (r7.readInt() != 0) goto L20;
            CompressParam r5 = null;
        L21:
            r4.add(r5);
            r1 = r1 + 1;
            goto L16
        L20:
            r5 = CompressParam.CREATOR.createFromParcel(r7);
            goto L21
        L22:
            r2 = r4;
        L24:
            return new ObricImageUploadCompressConfig(r3, r2);
        L5:
            int r6 = r7.readInt();
            r3 = new ArrayList(r6);
            int r8 = 0;
        L6:
            if (r8 == r6) goto L13;
            if (r7.readInt() != 0) goto L10;
            CompressParam r9 = null;
        L11:
            r3.add(r9);
            r8 = r8 + 1;
            goto L6
        L10:
            r9 = CompressParam.CREATOR.createFromParcel(r7);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final ObricImageUploadCompressConfig[] newArray(int r1) {
            return new ObricImageUploadCompressConfig[r1];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public ObricImageUploadCompressConfig() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricImageUploadCompressConfig copy$default(ObricImageUploadCompressConfig r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.screenSemanticScene;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.defaultScene;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<CompressParam> component1() {
        return this.screenSemanticScene;
    }

    public final List<CompressParam> component2() {
        return this.defaultScene;
    }

    public final ObricImageUploadCompressConfig copy(List<CompressParam> r2, List<CompressParam> r3) {
        return new ObricImageUploadCompressConfig(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricImageUploadCompressConfig) == true) goto L8;
        return false;
    L8:
        ObricImageUploadCompressConfig r6 = (ObricImageUploadCompressConfig) r5;
        if (Intrinsics.areEqual(this.screenSemanticScene, r6.screenSemanticScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultScene, r6.defaultScene) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<CompressParam> r0 = this.screenSemanticScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<CompressParam> r4 = this.defaultScene;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricImageUploadCompressConfig(screenSemanticScene=" + this.screenSemanticScene + ", defaultScene=" + this.defaultScene + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<CompressParam> r0 = this.screenSemanticScene;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        List<CompressParam> r1 = this.defaultScene;
        if (r1 != null) goto L15;
        r5.writeInt(0);
        return;
    L15:
        r5.writeInt(1);
        r5.writeInt(r1.size());
        Iterator<CompressParam> r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L35;
        CompressParam r3 = r2.next();
        if (r3 == null) goto L20;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L17
    L20:
        r5.writeInt(0);
        goto L17
    L35:
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<CompressParam> r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        CompressParam r7 = r4.next();
        if (r7 == null) goto L10;
        r5.writeInt(1);
        r7.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    public final List<CompressParam> getDefaultScene() {
        return this.defaultScene;
    }

    public final List<CompressParam> getScreenSemanticScene() {
        return this.screenSemanticScene;
    }

    public ObricImageUploadCompressConfig(List<CompressParam> r1, List<CompressParam> r2) {
        this.screenSemanticScene = r1;
        this.defaultScene = r2;
    }

    public /* synthetic */ ObricImageUploadCompressConfig(List r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
