package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.IndustryCertification")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IndustryCertification;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/x;", "Lcom/bytedance/android/live/base/model/user/y;", "profile", "Lcom/bytedance/android/live/base/model/user/y;", "getProfile", "()Lcom/bytedance/android/live/base/model/user/y;", "setProfile", "(Lcom/bytedance/android/live/base/model/user/y;)V", "Lcom/bytedance/android/live/base/model/user/z;", NewBroadcastMonitor.PAGE.ROOM, "Lcom/bytedance/android/live/base/model/user/z;", "getRoom", "()Lcom/bytedance/android/live/base/model/user/z;", "setRoom", "(Lcom/bytedance/android/live/base/model/user/z;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndustryCertification extends FlexModelBase<x> implements x, vh7.h {

    @SerializedName("profile")
    protected y profile;

    @SerializedName(NewBroadcastMonitor.PAGE.ROOM)
    protected z room;

    public IndustryCertification() {
        super(x.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.user.y, java.lang.Object] */
    public IndustryCertification(am3.g r6) {
        super(x.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.profile = vh7.f.a(r6, y.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.room = vh7.f.a(r6, z.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.x
    public y getProfile() {
        return this.profile;
    }

    @Override // com.bytedance.android.live.base.model.user.x
    public z getRoom() {
        return this.room;
    }

    @Override // com.bytedance.android.live.base.model.user.x
    public void setProfile(y r1) {
        this.profile = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.x
    public void setRoom(z r1) {
        this.room = r1;
    }
}
