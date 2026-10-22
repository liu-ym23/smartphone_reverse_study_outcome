package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.Border")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/user/BorderInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/f;", "", "o", "", "equals", "", "hashCode", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "level", "J", "getLevel", "()J", "setLevel", "(J)V", "defaultIcon", "getDefaultIcon", "setDefaultIcon", "", "dressId", "Ljava/lang/String;", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BorderInfo extends FlexModelBase<py.f> implements py.f, vh7.h {

    @SerializedName("thumb_icon")
    protected py.k defaultIcon;

    @SerializedName("dress_id")
    protected String dressId;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("level")
    protected long level;

    public BorderInfo() {
        super(py.f.class);
    }

    public int hashCode() {
        int r1 = 0;
        if (getIcon() == null) goto L7;
        py.k r0 = getIcon();
        if (r0 == null) goto L7;
        r1 = r0.hashCode();
    L7:
        long r2 = this.level;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    }

    @Override // py.f
    public py.k getDefaultIcon() {
        return this.defaultIcon;
    }

    @Override // py.f
    public String getDressId() {
        return this.dressId;
    }

    @Override // py.f
    public py.k getIcon() {
        return this.icon;
    }

    public final long getLevel() {
        return this.level;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public BorderInfo(am3.g r6) {
        super(py.f.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.level = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.defaultIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.dressId = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L21:
        return false;
    L8:
        if ((!Intrinsics.areEqual(BorderInfo.class, r8.getClass())) == true) goto L21;
        BorderInfo r9 = (BorderInfo) r8;
        if (this.level == r9.level) goto L14;
        return false;
    L14:
        if (getIcon() == null) goto L17;
        return Intrinsics.areEqual(getIcon(), r9.getIcon());
    L17:
        if (r9.getIcon() == null) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // py.f
    public void setDefaultIcon(py.k r1) {
        this.defaultIcon = r1;
    }

    @Override // py.f
    public void setDressId(String r1) {
        this.dressId = r1;
    }

    @Override // py.f
    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    public final void setLevel(long r1) {
        this.level = r1;
    }
}
