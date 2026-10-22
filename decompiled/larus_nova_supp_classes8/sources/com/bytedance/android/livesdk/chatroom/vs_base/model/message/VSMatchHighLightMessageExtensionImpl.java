package com.bytedance.android.livesdk.chatroom.vs_base.model.message;

import com.bytedance.android.live.base.model.message.f3;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import er1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J6\u0010\t\u001a\u00028\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/model/message/VSMatchHighLightMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/message/f3;", "Ler1/a;", "Lvh7/e;", "kotlin.jvm.PlatformType", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "getBaseMessage", "", "getTargetSei", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "getPoints", "()Ljava/util/List;", "points", "base", "<init>", "(Lcom/bytedance/android/live/base/model/message/f3;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSMatchHighLightMessageExtensionImpl extends ModelExtensionBase<f3, a> implements a, f3 {
    private final /* synthetic */ f3 $$delegate_0;

    @Override // er1.a
    public <R extends e<f3>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // er1.a
    public <R extends e<f3>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // er1.a
    public m0 getBaseMessage() {
        return this.$$delegate_0.getBaseMessage();
    }

    @Override // er1.a
    public List<EpisodeHighLight> getPoints() {
        return (List) get(2, a.class);
    }

    @Override // er1.a
    public long getTargetSei() {
        return this.$$delegate_0.getTargetSei();
    }

    public VSMatchHighLightMessageExtensionImpl(f3 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
