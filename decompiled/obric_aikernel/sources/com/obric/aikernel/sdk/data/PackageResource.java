package com.obric.aikernel.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class PackageResource implements Parcelable {
    public static final a CREATOR = null;
    private static final int FULL = -1;
    public static final int OWNER_AIKERNEL = 1;
    public static final int OWNER_LOCAL = 0;
    public static final int STATE_FLAG_AVAILABLE = 2;
    public static final int STATE_FLAG_DOWNLOADED = 4;
    public static final int STATE_FLAG_PROVISIONED = 1;
    public static final int STATE_MASK_UPDATED = 5;
    public static final int TYPE_CLOUD_MODEL = 2;
    public static final int TYPE_LORA = 3;
    public static final int TYPE_MODEL = 1;
    public static final int TYPE_PACKAGE = 0;
    private int flag;
    private final String name;
    private final int owner;
    private List<PackageResource> subRes;
    private final int type;
    private String version;

    public static final class a implements Parcelable.Creator<PackageResource> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public PackageResource a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new PackageResource(r10);
        }

        public PackageResource[] b(int r10) {
            return new PackageResource[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public PackageResource(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r11 = r10.readString();
        if (r11 != null) goto L5;
        String r12 = "";
    L6:
        int r13 = r10.readInt();
        int r14 = r10.readInt();
        String r15 = r10.readString();
        if (r15 != null) goto L9;
        String r16 = "";
    L10:
        this(r12, r13, r14, r16, r10.readInt());
        int r17 = r10.readInt();
        if (r17 <= 0) goto L14;
        ArrayList r18 = new ArrayList(r17);
        this.subRes = r18;
        Intrinsics.checkNotNull(r18);
        r10.readParcelableList(r18, PackageResource.class.getClassLoader());
        return;
    L14:
        return;
    L9:
        r16 = r15;
        goto L10
    L5:
        r12 = r11;
        goto L6
    }

    public PackageResource(PackageResource r10) {
        Intrinsics.checkNotNullParameter(r10, "src");
        this(r10.name, r10.owner, r10.type, r10.version, r10.flag);
        this.subRes = r10.subRes;
    }

    public PackageResource(String r10, int r11, int r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "version");
        this.name = r10;
        this.owner = r11;
        this.type = r12;
        this.version = r13;
        this.flag = r14;
    }

    public /* synthetic */ PackageResource(String r10, int r11, int r12, String r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((r15 & 4) == 0) goto L9;
        int r18 = 0;
    L11:
        if ((r15 & 8) == 0) goto L13;
        r13 = "";
    L13:
        String r19 = r13;
        if ((r15 & 16) == 0) goto L16;
        int r20 = 0;
    L17:
        this(r10, r17, r18, r19, r20);
        return;
    L16:
        r20 = r14;
        goto L17
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }

    private final boolean isState(int r10, int r11) {
        if ((r10 & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }

    public final void addFlag(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "flags");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.flag = r10[r12] | this.flag;
        r12 = r12 + 1;
        goto L3
    }

    public final void addFlagArray(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "flags");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.flag = r10[r12] | this.flag;
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String formatToString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[Package ");
        r10.append(this.name);
        r10.append('@');
        r10.append(this.version);
        r10.append(' ');
        if (this.owner != 1) goto L5;
        String r11 = "AIKERNEL";
    L6:
        r10.append(r11);
        r10.append(' ');
        int r12 = this.type;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L11;
        String r13 = "CLOUD_API";
    L17:
        r10.append(r13);
        r10.append(", state is ");
        String r14 = "avail";
        if (isAvailable() == false) goto L20;
        String r15 = "avail";
    L21:
        r10.append(r15);
        r10.append(", self is ");
        if (isState(getSelfFlag(), 2) == false) goto L25;
    L31:
        r10.append(r14);
        r10.append('.');
        List<PackageResource> r16 = this.subRes;
        if (r16 != null) goto L34;
    L47:
        String r17 = "";
    L48:
        r10.append(r17);
        r10.append(']');
        return r10.toString();
    L34:
        if ((!r16.isEmpty()) == true) goto L37;
        r16 = null;
    L37:
        if (r16 == null) goto L47;
        StringBuilder r18 = new StringBuilder();
        r18.append("|subResource:(");
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        int r20 = 0;
        Iterator<T> r110 = r16.iterator();
    L40:
        if (r110.hasNext() == false) goto L45;
        Object r21 = r110.next();
        int r22 = r20 + 1;
        if (r20 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        r19.add('{' + r20 + ", " + ((PackageResource) r21).formatToString() + '}');
        r20 = r22;
        goto L40
    L45:
        r18.append(CollectionsKt.joinToString$default(r19, null, null, null, 0, null, PackageResource$formatToString$2$2.INSTANCE, 31, null));
        r18.append(')');
        r17 = r18.toString();
        if (r17 != null) goto L48;
    L25:
        if (isState(getSelfFlag(), 4) == false) goto L28;
        r14 = "downloaded";
        goto L31
    L28:
        if (isState(getSelfFlag(), 1) == false) goto L30;
        r14 = "wait download";
        goto L31
    L30:
        r14 = "not found";
        goto L31
    L20:
        r15 = "not avail";
        goto L21
    L11:
        if (r12 == 3) goto L13;
        r13 = "unknown type";
        goto L17
    L13:
        r13 = "LORA";
        goto L17
    L15:
        r13 = "MODEL";
        goto L17
    L16:
        r13 = "PACKAGE";
        goto L17
    L5:
        r11 = "LOCAL";
        goto L6
    }

    public final String fullToString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("______________________________________\nPackage: ");
        r10.append(this.name);
        r10.append("\n[ver:");
        r10.append(this.version);
        r10.append("|own:");
        r10.append(this.owner);
        r10.append("|type:");
        r10.append(this.type);
        r10.append("]\n🆔Flag\tstate: [");
        String r11 = Integer.toString(getFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this, checkRadix(radix))");
        r10.append(r11);
        r10.append("] self:[");
        String r12 = Integer.toString(getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        r10.append(r12);
        r10.append("]\nflagFormat:[downloaded|available|provisioned]\n");
        List<PackageResource> r13 = this.subRes;
        if (r13 != null) goto L5;
    L18:
        String r14 = "";
    L19:
        r10.append(r14);
        r10.append("______________________________________\n");
        return r10.toString();
    L5:
        if ((!r13.isEmpty()) == true) goto L8;
        r13 = null;
    L8:
        if (r13 == null) goto L18;
        StringBuilder r15 = new StringBuilder();
        r15.append("🆔SubResource\t sum:");
        r15.append(r13.size());
        r15.append(":\n");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        int r17 = 0;
        Iterator<T> r18 = r13.iterator();
    L11:
        if (r18.hasNext() == false) goto L16;
        Object r19 = r18.next();
        int r20 = r17 + 1;
        if (r17 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        r16.add("++sub " + r17 + " of " + this.name + '\n' + ((PackageResource) r19));
        r17 = r20;
        goto L11
    L16:
        r15.append(CollectionsKt.joinToString$default(r16, null, null, null, 0, null, PackageResource$fullToString$2$2.INSTANCE, 31, null));
        r14 = r15.toString();
        if (r14 != null) goto L19;
        goto L18
    }

    public final int getFlag() {
        int r10 = this.flag;
        return getSubResFlag() & r10;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOwner() {
        return this.owner;
    }

    public final int getSelfFlag() {
        return this.flag;
    }

    public final List<PackageResource> getSubRes() {
        return this.subRes;
    }

    public final int getSubResFlag() {
        List<PackageResource> r10 = this.subRes;
        if (r10 != null) goto L5;
    L13:
        return -1;
    L5:
        if ((!r10.isEmpty()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L13;
        List<PackageResource> r11 = this.subRes;
        Intrinsics.checkNotNull(r11);
        int r12 = ((PackageResource) CollectionsKt.first(r11)).getFlag();
        Iterator<T> r13 = r10.iterator();
    L11:
        if (r13.hasNext() == false) goto L16;
        r12 = r12 & ((PackageResource) r13.next()).getFlag();
        goto L11
    L16:
        return r12;
    }

    public final int getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean isAvailable() {
        return isState(getFlag(), 2);
    }

    public final boolean isDownloaded() {
        return isState(getFlag(), 4);
    }

    public final boolean isLoraPackage() {
        if (this.type == 3) goto L18;
        List<PackageResource> r10 = this.subRes;
        Object r11 = null;
        if (r10 == null) goto L16;
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if (((PackageResource) r13).type != 3) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L8;
        r11 = r13;
        goto L15
    L12:
        r14 = false;
    L15:
        r11 = (PackageResource) r11;
    L16:
        if (r11 != null) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean isProvisioned() {
        return isState(getFlag(), 1);
    }

    public final boolean isSelfUpdated() {
        return isState(getSelfFlag(), 5);
    }

    public final boolean isUpdated() {
        return isState(getFlag(), 5);
    }

    public final void removeFlag(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "flags");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r13 = r10[r12];
        int r14 = this.flag;
        this.flag = (~r13) & r14;
        r12 = r12 + 1;
        goto L3
    }

    public final void setSubRes(List<PackageResource> r10) {
        this.subRes = r10;
    }

    public final void setVersion(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.version = r10;
    }

    public final String simpleToString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[Package ");
        r10.append(this.name);
        r10.append("|(ver:");
        r10.append(this.version);
        r10.append("|own:");
        r10.append(this.owner);
        r10.append("|type:");
        r10.append(this.type);
        r10.append(")|flag:");
        String r11 = Integer.toString(getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this, checkRadix(radix))");
        r10.append(r11);
        r10.append("|state:");
        String r12 = Integer.toString(getFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        r10.append(r12);
        List<PackageResource> r13 = this.subRes;
        if (r13 != null) goto L5;
    L18:
        String r14 = "";
    L19:
        r10.append(r14);
        r10.append(']');
        return r10.toString();
    L5:
        if ((!r13.isEmpty()) == true) goto L8;
        r13 = null;
    L8:
        if (r13 == null) goto L18;
        StringBuilder r15 = new StringBuilder();
        r15.append("|subResource:(");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        int r17 = 0;
        Iterator<T> r18 = r13.iterator();
    L11:
        if (r18.hasNext() == false) goto L16;
        Object r19 = r18.next();
        int r20 = r17 + 1;
        if (r17 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        r16.add('{' + r17 + ", " + ((PackageResource) r19).simpleToString() + '}');
        r17 = r20;
        goto L11
    L16:
        r15.append(CollectionsKt.joinToString$default(r16, null, null, null, 0, null, PackageResource$simpleToString$2$2.INSTANCE, 31, null));
        r15.append(')');
        r14 = r15.toString();
        if (r14 != null) goto L19;
        goto L18
    }

    public String toString() {
        return formatToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeString(this.name);
        r10.writeInt(this.owner);
        r10.writeInt(this.type);
        r10.writeString(this.version);
        r10.writeInt(this.flag);
        List<PackageResource> r12 = this.subRes;
        if (r12 == null) goto L5;
        int r13 = r12.size();
    L6:
        r10.writeInt(r13);
        if (r13 <= 0) goto L10;
        r10.writeParcelableList(this.subRes, 0);
        return;
    L10:
        return;
    L5:
        r13 = 0;
        goto L6
    }
}
