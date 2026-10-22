package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.AnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AnchorInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/b;", "", "o", "", "equals", "", "hashCode", "", "level", "J", "getLevel", "()J", "setLevel", "(J)V", "type", "getType", "setType", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInfo extends FlexModelBase<py.b> implements py.b, vh7.h {
    public static final a Companion = null;

    @SerializedName("level")
    protected long level;

    @IgnoreProtoFieldCheck
    @SerializedName("type")
    private long type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AnchorInfo() {
        super(py.b.class);
    }

    public int hashCode() {
        int r1 = ((int) (getLevel() ^ (getLevel() >>> 32))) * 31;
        long r2 = this.type;
        return r1 + ((int) (r2 ^ (r2 >>> 32)));
    }

    @Override // py.b
    public long getLevel() {
        return this.level;
    }

    public final long getType() {
        return this.type;
    }

    public AnchorInfo(am3.g r6) {
        super(py.b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.level = r6.j();
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L16:
        return false;
    L8:
        if ((!Intrinsics.areEqual(AnchorInfo.class, r8.getClass())) == true) goto L16;
        AnchorInfo r9 = (AnchorInfo) r8;
        if (getLevel() == r9.getLevel()) goto L14;
    L12:
        return false;
    L14:
        if (this.type != r9.type) goto L12;
        return true;
    }

    @Override // py.b
    public void setLevel(long r1) {
        this.level = r1;
    }

    public final void setType(long r1) {
        this.type = r1;
    }
}
