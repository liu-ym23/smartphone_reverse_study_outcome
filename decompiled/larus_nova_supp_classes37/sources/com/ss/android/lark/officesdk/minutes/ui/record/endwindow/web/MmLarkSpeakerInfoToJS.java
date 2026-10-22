package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "Ljava/io/Serializable;", "id", "", AppbrandHostConstants.Schema_Meta.NAME, "department", "avatar", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;)V", "getId", "()Ljava/lang/String;", "getName", "getDepartment", "getAvatar", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmLarkSpeakerInfoToJS implements Serializable {
    public static final a Companion = null;

    @SerializedName("avatar")
    private final MmSpeakerAvatarToJS avatar;

    @SerializedName("department")
    private final String department;

    @SerializedName("id")
    private final String id;

    @SerializedName(AppbrandHostConstants.Schema_Meta.NAME)
    private final String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmLarkSpeakerInfoToJS copy$default(MmLarkSpeakerInfoToJS r0, String r1, String r2, String r3, MmSpeakerAvatarToJS r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.department;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.avatar;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.department;
    }

    public final MmSpeakerAvatarToJS component4() {
        return this.avatar;
    }

    public final MmLarkSpeakerInfoToJS copy(String r2, String r3, String r4, MmSpeakerAvatarToJS r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        return new MmLarkSpeakerInfoToJS(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmLarkSpeakerInfoToJS) == true) goto L8;
        return false;
    L8:
        MmLarkSpeakerInfoToJS r6 = (MmLarkSpeakerInfoToJS) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.department, r6.department) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String r1 = this.department;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        MmSpeakerAvatarToJS r5 = this.avatar;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MmLarkSpeakerInfoToJS(id=" + this.id + ", name=" + this.name + ", department=" + this.department + ", avatar=" + this.avatar + ')';
    }

    public final MmSpeakerAvatarToJS getAvatar() {
        return this.avatar;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public MmLarkSpeakerInfoToJS(String r2, String r3, String r4, MmSpeakerAvatarToJS r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        this.id = r2;
        this.name = r3;
        this.department = r4;
        this.avatar = r5;
    }

    public /* synthetic */ MmLarkSpeakerInfoToJS(String r2, String r3, String r4, MmSpeakerAvatarToJS r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }
}
