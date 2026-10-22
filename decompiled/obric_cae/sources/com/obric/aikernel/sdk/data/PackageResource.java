package com.obric.aikernel.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.l;
import he.e;
import he.i;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yd.f;

/* JADX INFO: loaded from: classes.dex */
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
        @Override // android.os.Parcelable.Creator
        public final PackageResource createFromParcel(Parcel r8) {
            i.f(r8, "parcel");
            return new PackageResource(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final PackageResource[] newArray(int r8) {
            return new PackageResource[r8];
        }
    }

    public static final class b extends j implements l<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5360a = null;

        static {
            f5360a = new b();
        }

        public b() {
            super(1);
        }

        @Override // ge.l
        public final CharSequence invoke(String r8) {
            String r10 = r8;
            i.f(r10, "it");
            return r10;
        }
    }

    public static final class c extends j implements l<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5361a = null;

        static {
            f5361a = new c();
        }

        public c() {
            super(1);
        }

        @Override // ge.l
        public final CharSequence invoke(String r8) {
            String r10 = r8;
            i.f(r10, "it");
            return r10;
        }
    }

    public static final class d extends j implements l<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5362a = null;

        static {
            f5362a = new d();
        }

        public d() {
            super(1);
        }

        @Override // ge.l
        public final CharSequence invoke(String r8) {
            String r10 = r8;
            i.f(r10, "it");
            return r10;
        }
    }

    static {
        CREATOR = new a();
    }

    public PackageResource(Parcel r10) {
        i.f(r10, "parcel");
        String r8 = r10.readString();
        if (r8 != null) goto L5;
        String r11 = "";
    L6:
        int r12 = r10.readInt();
        int r13 = r10.readInt();
        String r14 = r10.readString();
        if (r14 != null) goto L9;
        String r15 = "";
    L10:
        this(r11, r12, r13, r15, r10.readInt());
        int r16 = r10.readInt();
        if (r16 <= 0) goto L14;
        ArrayList r17 = new ArrayList(r16);
        this.subRes = r17;
        r10.readParcelableList(r17, PackageResource.class.getClassLoader());
        return;
    L14:
        return;
    L9:
        r15 = r14;
        goto L10
    L5:
        r11 = r8;
        goto L6
    }

    private final boolean isState(int r8, int r10) {
        if ((r8 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public final void addFlag(int... r8) {
        i.f(r8, "flags");
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.flag = r8[r11] | this.flag;
        r11 = r11 + 1;
        goto L3
    }

    public final void addFlagArray(int[] r8) {
        i.f(r8, "flags");
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.flag = r8[r11] | this.flag;
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String formatToString() {
        StringBuilder r8 = new StringBuilder("[Package ");
        r8.append(this.name);
        r8.append('@');
        r8.append(this.version);
        r8.append(' ');
        if (this.owner != 1) goto L5;
        String r10 = "AIKERNEL";
    L6:
        r8.append(r10);
        r8.append(' ');
        int r11 = this.type;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L11;
        String r12 = "CLOUD_API";
    L17:
        r8.append(r12);
        r8.append(", state is ");
        String r13 = "avail";
        if (isAvailable() == false) goto L20;
        String r14 = "avail";
    L21:
        r8.append(r14);
        r8.append(", self is ");
        if (isState(getSelfFlag(), 2) == false) goto L25;
    L31:
        r8.append(r13);
        r8.append('.');
        List<PackageResource> r15 = this.subRes;
        if (r15 != null) goto L34;
    L48:
        String r16 = "";
    L49:
        r8.append(r16);
        r8.append(']');
        return r8.toString();
    L34:
        if ((!r15.isEmpty()) == true) goto L37;
        r15 = null;
    L37:
        if (r15 == null) goto L48;
        StringBuilder r17 = new StringBuilder("|subResource:(");
        ArrayList r18 = new ArrayList(f.f1(r15));
        Iterator<T> r19 = r15.iterator();
        int r20 = 0;
    L40:
        if (r19.hasNext() == false) goto L46;
        Object r21 = r19.next();
        int r22 = r20 + 1;
        if (r20 < 0) goto L44;
        StringBuilder r23 = defpackage.b.f("{", r20, ", ");
        r23.append(((PackageResource) r21).formatToString());
        r23.append('}');
        r18.add(r23.toString());
        r20 = r22;
        goto L40
    L44:
        l6.a.T0();
        throw null;
    L46:
        r17.append(yd.i.j1(r18, null, b.f5360a, 31));
        r17.append(')');
        r16 = r17.toString();
        if (r16 != null) goto L49;
    L25:
        if (isState(getSelfFlag(), 4) == false) goto L28;
        r13 = "downloaded";
        goto L31
    L28:
        if (isState(getSelfFlag(), 1) == false) goto L30;
        r13 = "wait download";
        goto L31
    L30:
        r13 = "not found";
        goto L31
    L20:
        r14 = "not avail";
        goto L21
    L11:
        if (r11 == 3) goto L13;
        r12 = "unknown type";
        goto L17
    L13:
        r12 = "LORA";
        goto L17
    L15:
        r12 = "MODEL";
        goto L17
    L16:
        r12 = "PACKAGE";
        goto L17
    L5:
        r10 = "LOCAL";
        goto L6
    }

    public final String fullToString() {
        StringBuilder r8 = new StringBuilder("______________________________________\nPackage: ");
        r8.append(this.name);
        r8.append("\n[ver:");
        r8.append(this.version);
        r8.append("|own:");
        r8.append(this.owner);
        r8.append("|type:");
        r8.append(this.type);
        r8.append("]\n🆔Flag\tstate: [");
        int r10 = getFlag();
        l6.a.v(2);
        String r11 = Integer.toString(r10, 2);
        i.e(r11, "toString(this, checkRadix(radix))");
        r8.append(r11);
        r8.append("] self:[");
        int r12 = getSelfFlag();
        l6.a.v(2);
        String r13 = Integer.toString(r12, 2);
        i.e(r13, "toString(this, checkRadix(radix))");
        r8.append(r13);
        r8.append("]\nflagFormat:[downloaded|available|provisioned]\n");
        List<PackageResource> r14 = this.subRes;
        if (r14 != null) goto L5;
    L19:
        String r15 = "";
    L21:
        return android.aimedia.a.i(r8, r15, "______________________________________\n");
    L5:
        if ((!r14.isEmpty()) == true) goto L8;
        r14 = null;
    L8:
        if (r14 == null) goto L19;
        StringBuilder r16 = new StringBuilder("🆔SubResource\t sum:");
        r16.append(r14.size());
        r16.append(":\n");
        ArrayList r17 = new ArrayList(f.f1(r14));
        Iterator<T> r18 = r14.iterator();
        int r19 = 0;
    L11:
        if (r18.hasNext() == false) goto L17;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 < 0) goto L15;
        StringBuilder r22 = defpackage.b.f("++sub ", r19, " of ");
        r22.append(this.name);
        r22.append('\n');
        r22.append((PackageResource) r20);
        r17.add(r22.toString());
        r19 = r21;
        goto L11
    L15:
        l6.a.T0();
        throw null;
    L17:
        r16.append(yd.i.j1(r17, null, c.f5361a, 31));
        r15 = r16.toString();
        if (r15 != null) goto L21;
        goto L19
    }

    public final int getFlag() {
        int r8 = this.flag;
        return getSubResFlag() & r8;
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
        List<PackageResource> r8 = this.subRes;
        if (r8 != null) goto L5;
    L13:
        return -1;
    L5:
        if ((!r8.isEmpty()) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L13;
        List<PackageResource> r10 = this.subRes;
        i.c(r10);
        int r11 = ((PackageResource) yd.i.g1(r10)).getFlag();
        Iterator<T> r12 = r8.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        r11 = r11 & ((PackageResource) r12.next()).getFlag();
        goto L11
    L16:
        return r11;
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
        if (this.type == 3) goto L25;
        List<PackageResource> r8 = this.subRes;
        Object r10 = null;
        if (r8 == null) goto L16;
        Iterator<T> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L15;
        Object r12 = r11.next();
        if (((PackageResource) r12).type != 3) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L8;
        r10 = r12;
        goto L15
    L12:
        r13 = false;
    L15:
        r10 = (PackageResource) r10;
    L16:
        if (r10 == null) goto L19;
        return true;
    L19:
        return false;
    L25:
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

    public final void removeFlag(int... r8) {
        i.f(r8, "flags");
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        int r12 = r8[r11];
        int r13 = this.flag;
        this.flag = (~r12) & r13;
        r11 = r11 + 1;
        goto L3
    }

    public final void setSubRes(List<PackageResource> r8) {
        this.subRes = r8;
    }

    public final void setVersion(String r8) {
        i.f(r8, "<set-?>");
        this.version = r8;
    }

    public final String simpleToString() {
        StringBuilder r8 = new StringBuilder("[Package ");
        r8.append(this.name);
        r8.append("|(ver:");
        r8.append(this.version);
        r8.append("|own:");
        r8.append(this.owner);
        r8.append("|type:");
        r8.append(this.type);
        r8.append(")|flag:");
        int r10 = getSelfFlag();
        l6.a.v(2);
        String r11 = Integer.toString(r10, 2);
        i.e(r11, "toString(this, checkRadix(radix))");
        r8.append(r11);
        r8.append("|state:");
        int r12 = getFlag();
        l6.a.v(2);
        String r13 = Integer.toString(r12, 2);
        i.e(r13, "toString(this, checkRadix(radix))");
        r8.append(r13);
        List<PackageResource> r14 = this.subRes;
        if (r14 != null) goto L5;
    L19:
        String r15 = "";
    L20:
        r8.append(r15);
        r8.append(']');
        return r8.toString();
    L5:
        if ((!r14.isEmpty()) == true) goto L8;
        r14 = null;
    L8:
        if (r14 == null) goto L19;
        StringBuilder r16 = new StringBuilder("|subResource:(");
        ArrayList r17 = new ArrayList(f.f1(r14));
        Iterator<T> r18 = r14.iterator();
        int r19 = 0;
    L11:
        if (r18.hasNext() == false) goto L17;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 < 0) goto L15;
        StringBuilder r22 = defpackage.b.f("{", r19, ", ");
        r22.append(((PackageResource) r20).simpleToString());
        r22.append('}');
        r17.add(r22.toString());
        r19 = r21;
        goto L11
    L15:
        l6.a.T0();
        throw null;
    L17:
        r16.append(yd.i.j1(r17, null, d.f5362a, 31));
        r16.append(')');
        r15 = r16.toString();
        if (r15 != null) goto L20;
        goto L19
    }

    public String toString() {
        return formatToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        i.f(r8, "parcel");
        r8.writeString(this.name);
        r8.writeInt(this.owner);
        r8.writeInt(this.type);
        r8.writeString(this.version);
        r8.writeInt(this.flag);
        List<PackageResource> r11 = this.subRes;
        if (r11 == null) goto L5;
        int r12 = r11.size();
    L6:
        r8.writeInt(r12);
        if (r12 <= 0) goto L10;
        r8.writeParcelableList(this.subRes, 0);
        return;
    L10:
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public PackageResource(PackageResource r8) {
        i.f(r8, "src");
        this(r8.name, r8.owner, r8.type, r8.version, r8.flag);
        this.subRes = r8.subRes;
    }

    public PackageResource(String r8, int r10, int r11, String r12, int r13) {
        i.f(r8, QesdkUtils.TAGS.JSON_TAG_NAME);
        i.f(r12, "version");
        this.name = r8;
        this.owner = r10;
        this.type = r11;
        this.version = r12;
        this.flag = r13;
    }

    public /* synthetic */ PackageResource(String r8, int r10, int r11, String r12, int r13, int r14, e r15) {
        if ((r14 & 2) == 0) goto L5;
        int r16 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r17 = 0;
    L11:
        if ((r14 & 8) == 0) goto L13;
        r12 = "";
    L13:
        String r18 = r12;
        if ((r14 & 16) == 0) goto L16;
        int r19 = 0;
    L17:
        this(r8, r16, r17, r18, r19);
        return;
    L16:
        r19 = r13;
        goto L17
    L9:
        r17 = r11;
        goto L11
    L5:
        r16 = r10;
        goto L7
    }
}
