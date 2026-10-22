package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f1809b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f1810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f1811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f1813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1814q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1815r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CharSequence f1816s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f1817t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CharSequence f1818u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList<String> f1819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<String> f1820w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f1821x;

    public class a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackState createFromParcel(Parcel r8) {
            return new BackStackState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackState[] newArray(int r8) {
            return new BackStackState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BackStackState(Parcel r8) {
        this.f1808a = r8.createIntArray();
        this.f1809b = r8.createStringArrayList();
        this.f1810m = r8.createIntArray();
        this.f1811n = r8.createIntArray();
        this.f1812o = r8.readInt();
        this.f1813p = r8.readString();
        this.f1814q = r8.readInt();
        this.f1815r = r8.readInt();
        this.f1816s = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r8);
        this.f1817t = r8.readInt();
        this.f1818u = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r8);
        this.f1819v = r8.createStringArrayList();
        this.f1820w = r8.createStringArrayList();
        if (r8.readInt() == 0) goto L5;
        boolean r10 = true;
    L6:
        this.f1821x = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeIntArray(this.f1808a);
        r8.writeStringList(this.f1809b);
        r8.writeIntArray(this.f1810m);
        r8.writeIntArray(this.f1811n);
        r8.writeInt(this.f1812o);
        r8.writeString(this.f1813p);
        r8.writeInt(this.f1814q);
        r8.writeInt(this.f1815r);
        TextUtils.writeToParcel(this.f1816s, r8, 0);
        r8.writeInt(this.f1817t);
        TextUtils.writeToParcel(this.f1818u, r8, 0);
        r8.writeStringList(this.f1819v);
        r8.writeStringList(this.f1820w);
        r8.writeInt(this.f1821x ? 1 : 0);
    }

    public BackStackState(androidx.fragment.app.a r8) {
        int r10 = r8.f2067a.size();
        this.f1808a = new int[r10 * 5];
        if (r8.f2073g == false) goto L14;
        this.f1809b = new ArrayList(r10);
        this.f1810m = new int[r10];
        this.f1811n = new int[r10];
        int r11 = 0;
        int r12 = 0;
    L5:
        if (r11 >= r10) goto L11;
        z.a r13 = r8.f2067a.get(r11);
        int r14 = r12 + 1;
        this.f1808a[r12] = r13.f2083a;
        ArrayList<String> r15 = this.f1809b;
        Fragment r16 = r13.f2084b;
        if (r16 == null) goto L9;
        String r17 = r16.mWho;
    L10:
        r15.add(r17);
        int[] r18 = this.f1808a;
        int r19 = r14 + 1;
        r18[r14] = r13.f2085c;
        int r20 = r19 + 1;
        r18[r19] = r13.f2086d;
        int r21 = r20 + 1;
        r18[r20] = r13.f2087e;
        r18[r21] = r13.f2088f;
        this.f1810m[r11] = r13.f2089g.ordinal();
        this.f1811n[r11] = r13.f2090h.ordinal();
        r11 = r11 + 1;
        r12 = r21 + 1;
        goto L5
    L9:
        r17 = null;
        goto L10
    L11:
        this.f1812o = r8.f2072f;
        this.f1813p = r8.f2075i;
        this.f1814q = r8.f1925s;
        this.f1815r = r8.f2076j;
        this.f1816s = r8.f2077k;
        this.f1817t = r8.f2078l;
        this.f1818u = r8.f2079m;
        this.f1819v = r8.f2080n;
        this.f1820w = r8.f2081o;
        this.f1821x = r8.f2082p;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }
}
