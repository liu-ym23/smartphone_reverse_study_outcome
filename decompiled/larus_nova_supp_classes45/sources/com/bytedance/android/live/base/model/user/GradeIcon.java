package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.PayGrade.GradeIcon")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/base/model/user/GradeIcon;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/w;", "", "o", "", "equals", "", "hashCode", "", "levelStr", "Ljava/lang/String;", "getLevelStr", "()Ljava/lang/String;", "setLevelStr", "(Ljava/lang/String;)V", "iconDiamond", "I", "getIconDiamond", "()I", "setIconDiamond", "(I)V", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "level", "getLevel", "setLevel", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradeIcon extends FlexModelBase<w> implements w, vh7.h {
    public static final a Companion = null;
    private static final int NUM_31 = 31;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("icon_diamond")
    protected int iconDiamond;

    @SerializedName("level")
    protected int level;

    @SerializedName("level_str")
    protected String levelStr;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GradeIcon() {
        super(w.class);
    }

    public int hashCode() {
        int r1 = 0;
        if (getLevelStr() == null) goto L7;
        String r0 = getLevelStr();
        if (r0 == null) goto L7;
        int r2 = r0.hashCode();
    L8:
        int r3 = ((r2 * 31) + getIconDiamond()) * 31;
        if (getIcon() == null) goto L14;
        py.k r4 = getIcon();
        if (r4 == null) goto L14;
        r1 = r4.hashCode();
    L14:
        return ((r3 + r1) * 31) + getLevel();
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public int getIconDiamond() {
        return this.iconDiamond;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public String getLevelStr() {
        return this.levelStr;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public GradeIcon(am3.g r6) {
        super(w.class);
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
        this.iconDiamond = (int) r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.level = (int) r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.levelStr = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L33:
        return false;
    L8:
        if ((!Intrinsics.areEqual(GradeIcon.class, r5.getClass())) == true) goto L33;
        GradeIcon r6 = (GradeIcon) r5;
        if (getIconDiamond() == r6.getIconDiamond()) goto L14;
        return false;
    L14:
        if (getLevel() == r6.getLevel()) goto L17;
        return false;
    L17:
        if (getLevelStr() == null) goto L20;
        boolean r2 = !Intrinsics.areEqual(getLevelStr(), r6.getLevelStr());
    L23:
        if (r2 == false) goto L26;
        return false;
    L26:
        if (getIcon() == null) goto L29;
        return Intrinsics.areEqual(getIcon(), r6.getIcon());
    L29:
        if (r6.getIcon() == null) goto L35;
        return false;
    L35:
        return true;
    L20:
        if (r6.getLevelStr() == null) goto L22;
        r2 = true;
        goto L23
    L22:
        r2 = false;
        goto L23
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public void setIconDiamond(int r1) {
        this.iconDiamond = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public void setLevel(int r1) {
        this.level = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.w
    public void setLevelStr(String r1) {
        this.levelStr = r1;
    }
}
