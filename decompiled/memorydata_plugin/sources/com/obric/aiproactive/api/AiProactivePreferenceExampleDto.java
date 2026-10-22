package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0016HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "Landroid/os/Parcelable;", OaidModel.KEY_ID, "", "title", "iconType", "actions", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()Ljava/lang/String;", "getTitle", "getIconType", "getActions", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiProactivePreferenceExampleDto implements Parcelable {
    public static final a CREATOR = null;
    private final List<String> actions;
    private final String iconType;
    private final String id;
    private final String title;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AiProactivePreferenceExampleDto> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public AiProactivePreferenceExampleDto a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AiProactivePreferenceExampleDto(r1);
        }

        public AiProactivePreferenceExampleDto[] a(int r1) {
            return new AiProactivePreferenceExampleDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AiProactivePreferenceExampleDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AiProactivePreferenceExampleDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public AiProactivePreferenceExampleDto(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        String r0 = r6.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r6.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r6.readString();
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        ArrayList<String> r7 = r6.createStringArrayList();
        if (r7 == null) goto L15;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L16:
        this(r0, r2, r1, r8);
        return;
    L15:
        r8 = CollectionsKt.emptyList();
        goto L16
    }

    public AiProactivePreferenceExampleDto(String r3, String r4, String r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "iconType");
        Intrinsics.checkNotNullParameter(r7, "actions");
        this.id = r3;
        this.title = r4;
        this.iconType = r5;
        this.actions = r7;
    }

    public static /* synthetic */ AiProactivePreferenceExampleDto copy$default(AiProactivePreferenceExampleDto r1, String r2, String r3, String r4, List r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.id;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.title;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.iconType;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.actions;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.iconType;
    }

    public final List<String> component4() {
        return this.actions;
    }

    public final AiProactivePreferenceExampleDto copy(String r2, String r3, String r4, List<String> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "iconType");
        Intrinsics.checkNotNullParameter(r1, "actions");
        return new AiProactivePreferenceExampleDto(r2, r3, r4, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AiProactivePreferenceExampleDto.class) == true) goto L8;
        return false;
    L8:
        AiProactivePreferenceExampleDto r6 = (AiProactivePreferenceExampleDto) ZeusTransformUtils.preCheckCast(r5, AiProactivePreferenceExampleDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconType, r6.iconType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<String> getActions() {
        return this.actions;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.iconType.hashCode()) * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "AiProactivePreferenceExampleDto(id=" + this.id + ", title=" + this.title + ", iconType=" + this.iconType + ", actions=" + this.actions + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.title);
        r1.writeString(this.iconType);
        r1.writeStringList(this.actions);
    }
}
