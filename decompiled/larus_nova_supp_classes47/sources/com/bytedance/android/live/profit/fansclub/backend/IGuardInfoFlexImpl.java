package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.GuardInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfo;", "", "guardStatus$delegate", "Ljava/lang/Object;", "getGuardStatus", "()I", "guardStatus", "", "activeGuardDay$delegate", "getActiveGuardDay", "()J", "activeGuardDay", "totalGuardDay$delegate", "getTotalGuardDay", "totalGuardDay", "expireTime$delegate", "getExpireTime", "expireTime", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IGuardInfoFlexImpl extends FlexModelBase<IGuardInfo> implements IGuardInfo, h {

    @SerializedName("active_guard_day")
    protected long _$$activeGuardDay;

    @SerializedName("expire_time")
    protected long _$$expireTime;

    @SerializedName("guard_status")
    protected int _$$guardStatus;

    @SerializedName("total_guard_day")
    protected long _$$totalGuardDay;

    public IGuardInfoFlexImpl() {
        super(IGuardInfo.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGuardInfo
    public final long getActiveGuardDay() {
        return this._$$activeGuardDay;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGuardInfo
    public final long getExpireTime() {
        return this._$$expireTime;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGuardInfo
    public final int getGuardStatus() {
        return this._$$guardStatus;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGuardInfo
    public final long getTotalGuardDay() {
        return this._$$totalGuardDay;
    }

    public IGuardInfoFlexImpl(g r6) {
        super(IGuardInfo.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$guardStatus = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$activeGuardDay = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$totalGuardDay = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$expireTime = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }
}
