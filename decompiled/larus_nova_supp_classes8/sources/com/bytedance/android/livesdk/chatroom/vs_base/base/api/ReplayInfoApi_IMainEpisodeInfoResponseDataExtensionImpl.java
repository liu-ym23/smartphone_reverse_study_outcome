package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi_IMainEpisodeInfoResponseDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$a;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getLongVideoId", "()Ljava/lang/Long;", "setLongVideoId", "(Ljava/lang/Long;)V", "longVideoId", "base", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$a;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayInfoApi_IMainEpisodeInfoResponseDataExtensionImpl extends ModelExtensionBase<ReplayInfoApi.a, ReplayInfoApi.b> implements ReplayInfoApi.b, ReplayInfoApi.a {
    private final /* synthetic */ ReplayInfoApi.a $$delegate_0;

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.b, com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.a
    public <R extends e<ReplayInfoApi.a>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.b, com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.a
    public <R extends e<ReplayInfoApi.a>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.b
    public Long getLongVideoId() {
        return (Long) get(3, ReplayInfoApi.b.class);
    }

    public ReplayInfoApi_IMainEpisodeInfoResponseDataExtensionImpl(ReplayInfoApi.a r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.b
    public void setLongVideoId(Long r4) {
        set(3, "lvideo_item_id", ReplayInfoApi.b.class, r4);
    }
}
