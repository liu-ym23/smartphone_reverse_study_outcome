package l4;

import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0013\u0010\u000fR(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0016"}, d2 = {"Ll4/e;", "", "", "", "Ll4/c;", "a", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "jsb", "Ll4/b;", "b", "actions", "Ll4/b;", "e", "()Ll4/b;", "onShow", "d", "onHide", "f", "onViewLoad", "data", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("jsb")
    private final Map<String, c> f19528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("actions")
    private final Map<String, b> f19529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("onShow")
    private final b f19530c;

    @SerializedName("onHide")
    private final b d;

    @SerializedName("onViewLoad")
    private final b e;

    @SerializedName("data")
    @JsonAdapter(DataTypeAdapter.class)
    private final Map<String, Object> f;

    public e() {
        this.f19528a = null;
        this.f19529b = null;
        this.f19530c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public final Map a() {
        return this.f19529b;
    }

    public final Map b() {
        return this.f;
    }

    public final Map c() {
        return this.f19528a;
    }

    public final b d() {
        return this.d;
    }

    public final b e() {
        return this.f19530c;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        if (Intrinsics.areEqual(this.f19528a, r10.f19528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19529b, r10.f19529b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19530c, r10.f19530c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final b f() {
        return this.e;
    }

    public final int hashCode() {
        Map<String, c> r5 = this.f19528a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Map<String, b> r13 = this.f19529b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        b r16 = this.f19530c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        b r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        b r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        Map<String, Object> r25 = this.f;
        if (r25 == null) goto L27;
        r10 = r25.hashCode();
    L27:
        return r24 + r10;
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "MetaContent(jsb=" + this.f19528a + ", actions=" + this.f19529b + ", onShow=" + this.f19530c + ", onHide=" + this.d + ", onViewLoad=" + this.e + ", data=" + this.f + ')';
    }
}
