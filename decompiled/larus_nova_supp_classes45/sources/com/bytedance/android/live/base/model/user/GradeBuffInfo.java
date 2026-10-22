package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.GradeBuffInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/user/GradeBuffInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/v;", "", "buffLevel", "I", "getBuffLevel", "()I", "setBuffLevel", "(I)V", "status", "getStatus", "setStatus", "endTime", "getEndTime", "setEndTime", "Lpy/k;", "buffBadge", "Lpy/k;", "getBuffBadge", "()Lpy/k;", "setBuffBadge", "(Lpy/k;)V", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradeBuffInfo extends FlexModelBase<v> implements v, vh7.h {
    public static final int BUFF_LEVEL_1 = 1;
    public static final int BUFF_LEVEL_2 = 101;
    public static final int BUFF_LEVEL_3 = 201;
    public static final int BUFF_LEVEL_4 = 301;
    public static final int BUFF_STATUS_Active = 1;
    public static final int BUFF_STATUS_EXPIRED = 2;
    public static final int BUFF_STATUS_UNKNOWN = 0;
    public static final a Companion = null;

    @SerializedName("buff_badge")
    protected py.k buffBadge;

    @SerializedName("buff_level")
    protected int buffLevel;

    @SerializedName("end_time")
    protected int endTime;

    @SerializedName("status")
    protected int status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GradeBuffInfo() {
        super(v.class);
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public py.k getBuffBadge() {
        return this.buffBadge;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public int getBuffLevel() {
        return this.buffLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public int getEndTime() {
        return this.endTime;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public int getStatus() {
        return this.status;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public GradeBuffInfo(am3.g r6) {
        super(v.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.buffLevel = (int) r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.status = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.endTime = (int) r6.j();
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this.buffBadge = vh7.f.a(r6, py.k.class);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public void setBuffBadge(py.k r1) {
        this.buffBadge = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public void setBuffLevel(int r1) {
        this.buffLevel = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public void setEndTime(int r1) {
        this.endTime = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.v
    public void setStatus(int r1) {
        this.status = r1;
    }
}
