package com.obric.aikernel.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0002\u0010\u0006B5\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00020 \"\u00020\nJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\b\u0010\"\u001a\u00020\nH\u0016J\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020)J\u0012\u0010/\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00020 \"\u00020\nJ\u0006\u00100\u001a\u00020\bJ\b\u00101\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0014\u00103\u001a\u00020)*\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u001c¨\u00065"}, d2 = {"Lcom/obric/aikernel/sdk/data/PackageResource;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "src", "(Lcom/obric/aikernel/sdk/data/PackageResource;)V", ActivityLifecycle.NAME, "", "owner", "", "type", "version", "flag", "(Ljava/lang/String;IILjava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getOwner", "()I", "subRes", "", "getSubRes", "()Ljava/util/List;", "setSubRes", "(Ljava/util/List;)V", "getType", "getVersion", "setVersion", "(Ljava/lang/String;)V", "addFlag", "", "flags", "", "addFlagArray", "describeContents", "formatToString", "fullToString", "getFlag", "getSelfFlag", "getSubResFlag", "isAvailable", "", "isDownloaded", "isLoraPackage", "isProvisioned", "isSelfUpdated", "isUpdated", "removeFlag", "simpleToString", "toString", "writeToParcel", "isState", "CREATOR", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageResource implements Parcelable {
    public static final CREATOR CREATOR = null;
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/aikernel/sdk/data/PackageResource$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "()V", "FULL", "", "OWNER_AIKERNEL", "OWNER_LOCAL", "STATE_FLAG_AVAILABLE", "STATE_FLAG_DOWNLOADED", "STATE_FLAG_PROVISIONED", "STATE_MASK_UPDATED", "TYPE_CLOUD_MODEL", "TYPE_LORA", "TYPE_MODEL", "TYPE_PACKAGE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/aikernel/sdk/data/PackageResource;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<PackageResource> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageResource createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new PackageResource(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageResource[] newArray(int r1) {
            return new PackageResource[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public PackageResource(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        String r0 = r9.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        int r4 = r9.readInt();
        int r5 = r9.readInt();
        String r1 = r9.readString();
        if (r1 != null) goto L9;
        String r6 = "";
    L10:
        this(r3, r4, r5, r6, r9.readInt());
        int r2 = r9.readInt();
        if (r2 <= 0) goto L14;
        List<PackageResource> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(r2), List.class, "com.obric.memorydata.plugin");
        this.subRes = r7;
        Intrinsics.checkNotNull(r7);
        r9.readParcelableList(r7, getClass().getClassLoader());
        return;
    L14:
        return;
    L9:
        r6 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public PackageResource(PackageResource r8) {
        Intrinsics.checkNotNullParameter(r8, "src");
        this(r8.name, r8.owner, r8.type, r8.version, r8.flag);
        this.subRes = r8.subRes;
    }

    public PackageResource(String r2, int r3, int r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        this.name = r2;
        this.owner = r3;
        this.type = r4;
        this.version = r5;
        this.flag = r6;
    }

    public /* synthetic */ PackageResource(String r8, int r9, int r10, String r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        r11 = "";
    L13:
        String r5 = r11;
        if ((r13 & 16) == 0) goto L16;
        int r6 = 0;
    L17:
        this(r8, r3, r4, r5, r6);
        return;
    L16:
        r6 = r12;
        goto L17
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    private final boolean isState(int r1, int r2) {
        if ((r1 & r2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void addFlag(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.flag = r5[r1] | this.flag;
        r1 = r1 + 1;
        goto L3
    }

    public final void addFlagArray(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.flag = r5[r1] | this.flag;
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String formatToString() {
        StringBuilder r0 = new StringBuilder().append("[Package ").append(this.name).append('@').append(this.version).append(' ');
        if (this.owner != 1) goto L5;
        String r2 = "AIKERNEL";
    L6:
        StringBuilder r1 = r0.append(r2).append(' ');
        int r3 = this.type;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L11;
        String r4 = "CLOUD_API";
    L17:
        StringBuilder r5 = r1.append(r4).append(", state is ");
        String r6 = "avail";
        if (isAvailable() == false) goto L20;
        String r7 = "avail";
    L21:
        StringBuilder r8 = r5.append(r7).append(", self is ");
        if (isState(getSelfFlag(), 2) == false) goto L25;
    L31:
        StringBuilder r9 = r8.append(r6).append('.');
        List<PackageResource> r12 = this.subRes;
        if (r12 != null) goto L34;
    L47:
        String r13 = "";
    L49:
        return r9.append(r13).append(']').toString();
    L34:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L37;
        r12 = null;
    L37:
        if (r12 == null) goto L47;
        StringBuilder r10 = new StringBuilder().append("|subResource:(");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r15 = 0;
        Iterator r16 = r14.iterator();
    L40:
        if (r16.hasNext() == false) goto L45;
        Object r17 = r16.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        r11.add('{' + r15 + ", " + ((PackageResource) ZeusTransformUtils.preCheckCast(r17, PackageResource.class, "com.obric.memorydata.plugin")).formatToString() + '}');
        r15 = r18;
        goto L40
    L45:
        r13 = r10.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(PackageResource$formatToString$2$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null)).append(')').toString();
        if (r13 != null) goto L49;
    L25:
        if (isState(getSelfFlag(), 4) == false) goto L28;
        r6 = "downloaded";
        goto L31
    L28:
        if (isState(getSelfFlag(), 1) == false) goto L30;
        r6 = "wait download";
        goto L31
    L30:
        r6 = "not found";
        goto L31
    L20:
        r7 = "not avail";
        goto L21
    L11:
        if (r3 == 3) goto L13;
        r4 = "unknown type";
        goto L17
    L13:
        r4 = "LORA";
        goto L17
    L15:
        r4 = "MODEL";
        goto L17
    L16:
        r4 = "PACKAGE";
        goto L17
    L5:
        r2 = "LOCAL";
        goto L6
    }

    public final String fullToString() {
        StringBuilder r0 = new StringBuilder().append("______________________________________\nPackage: ").append(this.name).append("\n[ver:").append(this.version).append("|own:").append(this.owner).append("|type:").append(this.type).append("]\n🆔Flag\tstate: [");
        String r1 = Integer.toString(getFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r1, "toString(this, checkRadix(radix))");
        StringBuilder r2 = r0.append(r1).append("] self:[");
        String r3 = Integer.toString(getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(this, checkRadix(radix))");
        StringBuilder r4 = r2.append(r3).append("]\nflagFormat:[downloaded|available|provisioned]\n");
        List<PackageResource> r5 = this.subRes;
        if (r5 != null) goto L5;
    L18:
        String r13 = "";
    L20:
        return r4.append(r13).append("______________________________________\n").toString();
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L18;
        StringBuilder r6 = new StringBuilder().append("🆔SubResource\t sum:").append(r5.size()).append(":\n");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        Iterator r10 = r7.iterator();
    L11:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        int r12 = r9 + 1;
        if (r9 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        r8.add("++sub " + r9 + " of " + this.name + '\n' + ((PackageResource) ZeusTransformUtils.preCheckCast(r11, PackageResource.class, "com.obric.memorydata.plugin")));
        r9 = r12;
        goto L11
    L16:
        r13 = r6.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(PackageResource$fullToString$2$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null)).toString();
        if (r13 != null) goto L20;
        goto L18
    }

    public final int getFlag() {
        int r0 = this.flag;
        return getSubResFlag() & r0;
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
        List<PackageResource> r1 = this.subRes;
        if (r1 != null) goto L5;
    L13:
        return -1;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L13;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        List<PackageResource> r4 = this.subRes;
        Intrinsics.checkNotNull(r4);
        int r5 = ((PackageResource) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r4), PackageResource.class, "com.obric.memorydata.plugin")).getFlag();
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        r5 = r5 & ((PackageResource) ZeusTransformUtils.preCheckCast(r3.next(), PackageResource.class, "com.obric.memorydata.plugin")).getFlag();
        goto L11
    L16:
        return r5;
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
        List<PackageResource> r8 = this.subRes;
        Object r1 = null;
        if (r8 == null) goto L16;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        Object r5 = r9.next();
        if (((PackageResource) ZeusTransformUtils.preCheckCast(r5, PackageResource.class, "com.obric.memorydata.plugin")).type != 3) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r1 = r5;
        goto L15
    L12:
        r7 = false;
    L15:
        r1 = (PackageResource) ZeusTransformUtils.preCheckCast(r1, PackageResource.class, "com.obric.memorydata.plugin");
    L16:
        if (r1 != null) goto L18;
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

    public final void removeFlag(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r5[r1];
        int r3 = this.flag;
        this.flag = (~r2) & r3;
        r1 = r1 + 1;
        goto L3
    }

    public final void setSubRes(List<PackageResource> r3) {
        this.subRes = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.version = r2;
    }

    public final String simpleToString() {
        StringBuilder r0 = new StringBuilder().append("[Package ").append(this.name).append("|(ver:").append(this.version).append("|own:").append(this.owner).append("|type:").append(this.type).append(")|flag:");
        String r1 = Integer.toString(getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r1, "toString(this, checkRadix(radix))");
        StringBuilder r2 = r0.append(r1).append("|state:");
        String r3 = Integer.toString(getFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(this, checkRadix(radix))");
        StringBuilder r4 = r2.append(r3);
        List<PackageResource> r12 = this.subRes;
        if (r12 != null) goto L5;
    L18:
        String r13 = "";
    L20:
        return r4.append(r13).append(']').toString();
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L18;
        StringBuilder r5 = new StringBuilder().append("|subResource:(");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        Object r8 = r15.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        r6.add('{' + r7 + ", " + ((PackageResource) ZeusTransformUtils.preCheckCast(r8, PackageResource.class, "com.obric.memorydata.plugin")).simpleToString() + '}');
        r7 = r9;
        goto L11
    L16:
        r13 = r5.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(PackageResource$simpleToString$2$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null)).append(')').toString();
        if (r13 != null) goto L20;
        goto L18
    }

    public String toString() {
        return formatToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.name);
        r2.writeInt(this.owner);
        r2.writeInt(this.type);
        r2.writeString(this.version);
        r2.writeInt(this.flag);
        List<PackageResource> r4 = this.subRes;
        if (r4 == null) goto L5;
        int r5 = r4.size();
    L6:
        r2.writeInt(r5);
        if (r5 <= 0) goto L10;
        r2.writeParcelableList(this.subRes, 0);
        return;
    L10:
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
