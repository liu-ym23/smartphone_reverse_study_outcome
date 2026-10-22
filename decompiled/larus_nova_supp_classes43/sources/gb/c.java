package gb;

import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lgb/c;", "", "", "", "Lgb/a$d;", "jsb", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lgb/a$c;", "actions", "a", "onShow", "Lgb/a$c;", "e", "()Lgb/a$c;", "onHide", "d", "onViewLoad", "f", "data", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("actions")
    private final Map<String, a.c> actions;

    @SerializedName("data")
    @JsonAdapter(DataTypeAdapter.class)
    private final Map<String, Object> data;

    @SerializedName("jsb")
    private final Map<String, a.d> jsb;

    @SerializedName("onHide")
    private final a.c onHide;

    @SerializedName("onShow")
    private final a.c onShow;

    @SerializedName("onViewLoad")
    private final a.c onViewLoad;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.jsb, r11.jsb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r11.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onShow, r11.onShow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.onHide, r11.onHide) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.onViewLoad, r11.onViewLoad) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Map<String, a.d> r0 = this.jsb;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Map<String, a.c> r12 = this.actions;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        a.c r15 = this.onShow;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        a.c r18 = this.onHide;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        a.c r21 = this.onViewLoad;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        Map<String, Object> r24 = this.data;
        if (r24 == null) goto L27;
        r1 = r24.hashCode();
    L27:
        return r23 + r1;
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MetaContent(jsb=" + this.jsb + ", actions=" + this.actions + ", onShow=" + this.onShow + ", onHide=" + this.onHide + ", onViewLoad=" + this.onViewLoad + ", data=" + this.data + ')';
    }

    public c() {
        this.jsb = null;
        this.actions = null;
        this.onShow = null;
        this.onHide = null;
        this.onViewLoad = null;
        this.data = null;
    }

    public final Map<String, a.c> a() {
        return this.actions;
    }

    public final Map<String, Object> b() {
        return this.data;
    }

    public final Map<String, a.d> c() {
        return this.jsb;
    }

    public final a.c d() {
        return this.onHide;
    }

    public final a.c e() {
        return this.onShow;
    }

    public final a.c f() {
        return this.onViewLoad;
    }
}
