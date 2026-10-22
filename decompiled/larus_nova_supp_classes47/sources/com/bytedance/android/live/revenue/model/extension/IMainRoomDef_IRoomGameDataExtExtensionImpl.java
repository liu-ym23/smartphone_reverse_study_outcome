package com.bytedance.android.live.revenue.model.extension;

import com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IGameTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.IGameRoomSticker;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import iy0.b;
import iy0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/IMainRoomDef_IRoomGameDataExtExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "Liy0/b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "gameTagId", "", "isGame", "Liy0/d;", "getRoomGameDataChannelConfig", "()Liy0/d;", "roomGameDataChannelConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "getGameRoomSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "gameRoomSticker", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "getGameTagInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "gameTagInfo", "Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "getSandwichBorderInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "sandwichBorderInfo", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainRoomDef_IRoomGameDataExtExtensionImpl extends ModelExtensionBase<IRoomGameData, b> implements b, IRoomGameData {
    private final /* synthetic */ IRoomGameData $$delegate_0;

    @Override // iy0.b
    public <R extends e<IRoomGameData>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // iy0.b
    public <R extends e<IRoomGameData>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public long gameTagId() {
        return this.$$delegate_0.gameTagId();
    }

    public IGameRoomSticker getGameRoomSticker() {
        return this.$$delegate_0.getGameRoomSticker();
    }

    public IGameTagInfo getGameTagInfo() {
        return this.$$delegate_0.getGameTagInfo();
    }

    @Override // iy0.b
    /* JADX INFO: renamed from: getRoomGameDataChannelConfig, reason: collision with other method in class */
    public d mo395getRoomGameDataChannelConfig() {
        return (d) get(1, b.class);
    }

    public ISandwichBorderInfo getSandwichBorderInfo() {
        return this.$$delegate_0.getSandwichBorderInfo();
    }

    public int isGame() {
        return this.$$delegate_0.isGame();
    }

    public /* bridge */ /* synthetic */ IRoomGameDataChannelConfig getRoomGameDataChannelConfig() {
        return mo395getRoomGameDataChannelConfig();
    }

    public IMainRoomDef_IRoomGameDataExtExtensionImpl(IRoomGameData r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
