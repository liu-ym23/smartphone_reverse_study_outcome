package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.message.model.ab;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/IMultiLinkSettingNotifyMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/message/model/d9;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/e;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "Lcom/bytedance/android/livesdk/message/model/ab;", "getPaidOrTimeLimitChangeContent", "()Lcom/bytedance/android/livesdk/message/model/ab;", "paidOrTimeLimitChangeContent", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "getSettings", "()Ljava/util/List;", "settings", "base", "<init>", "(Lcom/bytedance/android/livesdk/message/model/d9;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiLinkSettingNotifyMessageExtensionImpl extends ModelExtensionBase<d9, e> implements e, d9 {
    private final /* synthetic */ d9 $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public <R extends vh7.e<d9>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public <R extends vh7.e<d9>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public m0 getCommonData() {
        return (m0) get(1, e.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public ab getPaidOrTimeLimitChangeContent() {
        return this.$$delegate_0.getPaidOrTimeLimitChangeContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public List<y> getSettings() {
        return this.$$delegate_0.getSettings();
    }

    public IMultiLinkSettingNotifyMessageExtensionImpl(d9 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.e
    public void setCommonData(m0 r4) {
        set(1, "common", e.class, r4);
    }
}
