package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.livesdk.multilink.base.model.u;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightInviteResultExtra;", "Lcom/bytedance/android/live/base/model/Extra;", "Lcom/bytedance/android/livesdk/multilink/base/model/u;", "Lvh7/c$a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castToOrNull", "(Ljava/lang/Class;)Lvh7/e;", "castTo", "", "failReason", "Ljava/lang/String;", "getFailReason", "()Ljava/lang/String;", "setFailReason", "(Ljava/lang/String;)V", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightInviteResultExtra extends Extra implements u, c.a<u> {
    private final transient FlexModelDelegate<u> delegate;

    @SerializedName("fail_reason")
    private String failReason;

    public LinkRoomFightInviteResultExtra() {
        this.failReason = "";
        this.delegate = new FlexModelDelegate(u.class, this);
    }

    public FlexModelDelegate<u> getDelegate() {
        return this.delegate;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public <R extends e<u>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castTo(r2);
    }

    public <R extends e<u>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castToOrNull(r2);
    }

    public void setFailReason(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.failReason = r2;
    }
}
