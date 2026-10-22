package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`!8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R$\u0010+\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IMainGiftTipExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/gift/model/c2;", "Lcom/bytedance/android/livesdk/gift/model/j2;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", BuildConfig.FLAVOR, "value", "getRemainTime", "()J", "setRemainTime", "(J)V", "remainTime", "Lcom/bytedance/android/live/base/model/message/a5;", "getTimeSuffixText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setTimeSuffixText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "timeSuffixText", "getDeadLineTime", "setDeadLineTime", "deadLineTime", BuildConfig.FLAVOR, "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundColor", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayText", "setDisplayText", "displayText", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getPrefixImage", "()Lpy/k;", "setPrefixImage", "(Lpy/k;)V", "prefixImage", "base", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/c2;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainGiftTipExtensionImpl extends ModelExtensionBase<c2, j2> implements j2, c2 {
    private final /* synthetic */ c2 $$delegate_0;

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public <R extends vh7.e<c2>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public <R extends vh7.e<c2>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public String getBackgroundColor() {
        return this.$$delegate_0.getBackgroundColor();
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public a5 getDisplayText() {
        return this.$$delegate_0.getDisplayText();
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public py.k getPrefixImage() {
        return this.$$delegate_0.getPrefixImage();
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public a5 getTimeSuffixText() {
        return (a5) get(5, j2.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public void setBackgroundColor(String r2) {
        this.$$delegate_0.setBackgroundColor(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public void setDisplayText(a5 r2) {
        this.$$delegate_0.setDisplayText(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2, com.bytedance.android.livesdk.gift.model.c2
    public void setPrefixImage(py.k r2) {
        this.$$delegate_0.setPrefixImage(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public long getDeadLineTime() {
        return ((Number) get(6, j2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public long getRemainTime() {
        return ((Number) get(4, j2.class, 0L)).longValue();
    }

    public IMainGiftTipExtensionImpl(c2 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public void setDeadLineTime(long r3) {
        set(6, "countdown_deadline_time", j2.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public void setRemainTime(long r3) {
        set(4, "remaining_duration", j2.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.gift.model.j2
    public void setTimeSuffixText(a5 r4) {
        set(5, "remaining_duration_suffix_text", j2.class, r4);
    }
}
