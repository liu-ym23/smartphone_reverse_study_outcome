package com.obric.assistant.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001eHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/obric/assistant/settings/SelectableToggleItem;", "Landroid/os/Parcelable;", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "title", "", "subTitle", "selected", "", "permissionList", "", "<init>", "(Lcom/obric/assistant/settings/ToggleName;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getToggleName", "()Lcom/obric/assistant/settings/ToggleName;", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getSelected", "()Z", "setSelected", "(Z)V", "getPermissionList", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "component5", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectableToggleItem implements Parcelable {
    public static final a CREATOR = null;
    public final ToggleName a;
    public final String b;
    public final String c;
    public boolean d;
    public final List<String> e;

    public static final class a implements Parcelable.Creator<SelectableToggleItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectableToggleItem createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r0 = r9.readString();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            ToggleName r2 = ToggleName.valueOf(r0);
            String r1 = r9.readString();
            if (r1 != null) goto L8;
            String r3 = "";
        L9:
            String r4 = r9.readString();
            if (r9.readInt() == 0) goto L12;
            boolean r5 = true;
        L14:
            return new SelectableToggleItem(r2, r3, r4, r5, r9.createStringArrayList());
        L12:
            r5 = false;
            goto L14
        L8:
            r3 = r1;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SelectableToggleItem[] newArray(int r1) {
            return new SelectableToggleItem[r1];
        }
    }

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
        if ((r5 instanceof SelectableToggleItem) == true) goto L8;
        return false;
    L8:
        SelectableToggleItem r6 = (SelectableToggleItem) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.d == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        List<String> r7 = this.e;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectableToggleItem(toggleName=" + this.a + ", title=" + this.b + ", subTitle=" + this.c + ", selected=" + this.d + ", permissionList=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a.name());
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d ? 1 : 0);
        r1.writeStringList(this.e);
    }

    public /* synthetic */ SelectableToggleItem(ToggleName r9, String r10, String r11, List r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r13 & 16) == 0) goto L13;
        List r7 = null;
    L14:
        this(r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r12;
        goto L14
    L9:
        r6 = false;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public SelectableToggleItem(ToggleName r2, String r3, String r4, boolean r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
