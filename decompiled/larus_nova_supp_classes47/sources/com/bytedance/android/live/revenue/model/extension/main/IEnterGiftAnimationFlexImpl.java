package com.bytedance.android.live.revenue.model.extension.main;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.EnterGiftAnimation")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/IEnterGiftAnimationFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/revenue/model/extension/main/a;", "", "giftEffectId$delegate", "Ljava/lang/Object;", "getGiftEffectId", "()I", "giftEffectId", "displayGap$delegate", "getDisplayGap", "displayGap", "displayFreq$delegate", "getDisplayFreq", "displayFreq", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEnterGiftAnimationFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("display_freq")
    protected int _$$displayFreq;

    @SerializedName("display_gap")
    protected int _$$displayGap;

    @SerializedName("gift_effect_id")
    protected int _$$giftEffectId;

    public IEnterGiftAnimationFlexImpl() {
        super(a.class);
        this._$$displayGap = $defaultValue_displayGap$();
        this._$$displayFreq = $defaultValue_displayFreq$();
    }

    public final int $defaultValue_displayFreq$() {
        return 1;
    }

    public final int $defaultValue_displayGap$() {
        return 1;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.a
    public final int getDisplayFreq() {
        return this._$$displayFreq;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.a
    public final int getDisplayGap() {
        return this._$$displayGap;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.a
    public final int getGiftEffectId() {
        return this._$$giftEffectId;
    }

    public IEnterGiftAnimationFlexImpl(g r7) {
        super(a.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L15;
        g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this._$$giftEffectId = r7.i();
        r0 = r0 | 1;
        goto L3
    L8:
        if (r3 != 2) goto L10;
        this._$$displayGap = r7.i();
        r0 = r0 | 2;
        goto L3
    L10:
        if (r3 != 3) goto L11;
        this._$$displayFreq = r7.i();
        r0 = r0 | 4;
        goto L3
    L11:
        am3.h.d(r4, r7);
        goto L3
    L15:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & 2) != 0) goto L19;
        this._$$displayGap = $defaultValue_displayGap$();
    L19:
        if ((r0 & 4) != 0) goto L34;
        this._$$displayFreq = $defaultValue_displayFreq$();
        return;
    }
}
