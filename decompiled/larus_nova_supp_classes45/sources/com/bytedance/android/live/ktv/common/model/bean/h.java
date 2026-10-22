package com.bytedance.android.live.ktv.common.model.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/h;", "", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "e", "Lpy/k;", "icon", "Lpy/k;", "c", "()Lpy/k;", "conf", "b", "", "version", "I", "f", "()I", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {
    public boolean a;

    @SerializedName("conf")
    protected k conf;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("name")
    protected String name;

    @SerializedName("title")
    protected String title;

    @SerializedName("version")
    protected int version;

    public static final class a {
    }

    static {
    }

    public h(String r2, String r3, k r4, k r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "icon");
        Intrinsics.checkNotNullParameter(r5, "conf");
        this.name = r2;
        this.title = r3;
        this.icon = r4;
        this.conf = r5;
        this.version = r6;
        this.a = r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        k r11 = this.conf;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        int r12 = (((r9 + r1) * 31) + this.version) * 31;
        boolean r13 = this.a;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        return r12 + r14;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean g() {
        return Intrinsics.areEqual(this.name, "none");
    }

    public final String toString() {
        return "TuningEffectItem(name='" + this.name + "', title='" + this.title + "', icon=" + this.icon + ", conf=" + this.conf + ", version=" + this.version + ", isSelected=" + this.a + ')';
    }

    public h() {
        this.name = "none";
        this.title = "原声";
        this.icon = qy.a.c();
        this.conf = qy.a.c();
        this.version = 1;
    }

    public final k b() {
        return this.conf;
    }

    public final k c() {
        return this.icon;
    }

    public final String d() {
        return this.name;
    }

    public final String e() {
        return this.title;
    }

    public final int f() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, py.k] */
    public h(am3.g r7) {
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L20;
        if (r3 != 1) goto L7;
        this.name = am3.h.c(r7);
        goto L3
    L7:
        if (r3 != 2) goto L9;
        this.title = am3.h.c(r7);
        goto L3
    L9:
        if (r3 != 3) goto L11;
        this.icon = vh7.f.a(r7, k.class);
        goto L3
    L11:
        if (r3 != 4) goto L13;
        this.conf = vh7.f.a(r7, k.class);
        goto L3
    L13:
        if (r3 != 5) goto L14;
        this.version = (int) r7.j();
        r2 = r2 | true;
        goto L3
    L14:
        am3.h.e(r7);
        goto L3
    L20:
        r7.d(r0);
        if (this.name != null) goto L24;
        this.name = "none";
    L24:
        if (this.title != null) goto L27;
        this.title = "原声";
    L27:
        if (this.icon != null) goto L30;
        this.icon = qy.a.c();
    L30:
        if (this.conf != null) goto L33;
        this.conf = qy.a.c();
    L33:
        if ((r2 & true) == true) goto L54;
        this.version = 1;
        return;
    }

    public static h a(h r7) {
        String r1 = r7.name;
        String r2 = r7.title;
        k r3 = r7.icon;
        k r4 = r7.conf;
        int r5 = r7.version;
        boolean r6 = r7.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r4, "conf");
        return new h(r1, r2, r3, r4, r5, r6);
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof h) == true) goto L5;
        r4 = null;
    L5:
        h r5 = (h) r4;
        if (r5 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r5.name, this.name) == true) goto L10;
        return false;
    L10:
        if (r5.version == this.version) goto L12;
        return false;
    L12:
        return true;
    }

    public final boolean h(h r3) {
        Intrinsics.checkNotNullParameter(r3, "newItem");
        if (this.a == r3.a) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(this.title, r3.title) == false) goto L13;
        if (Intrinsics.areEqual(this.icon, r3.icon) == false) goto L13;
        if (Intrinsics.areEqual(this.conf, r3.conf) == false) goto L13;
        if (this.version != r3.version) goto L13;
        return true;
    }
}
