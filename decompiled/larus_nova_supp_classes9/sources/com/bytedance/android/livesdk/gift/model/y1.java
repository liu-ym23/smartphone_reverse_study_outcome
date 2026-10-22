package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\rR\u0014\u00100\u001a\u00020-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0004\u0018\u0001018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/y1;", "Lvh7/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "displayText", BuildConfig.FLAVOR, "getDescribe", "()Ljava/lang/String;", "describe", BuildConfig.FLAVOR, "getGiftId", "()J", "giftId", "getGroupCount", "groupCount", "getRepeatCount", "repeatCount", "getComboCount", "comboCount", "getMsgId", "msgId", "getTrayDisplayText", "trayDisplayText", "Lcom/bytedance/android/livesdk/gift/model/e0;", "getGiftBanner", "()Lcom/bytedance/android/livesdk/gift/model/e0;", "giftBanner", "Lcom/bytedance/android/livesdk/gift/model/o0;", "getGiftTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/o0;", "giftTrayInfo", "getTopBarText", "topBarText", "Lcom/bytedance/android/livesdk/gift/model/p1;", "getGiftExtra", "()Lcom/bytedance/android/livesdk/gift/model/p1;", "giftExtra", "Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/c;", "assetEffectMixInfo", "getOriginGiftId", "originGiftId", BuildConfig.FLAVOR, "getBuffLevel", "()I", "buffLevel", "Lcom/bytedance/android/livesdk/gift/model/c2;", "getGiftTip", "()Lcom/bytedance/android/livesdk/gift/model/c2;", "giftTip", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y1 extends vh7.c<y1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    c getAssetEffectMixInfo();

    int getBuffLevel();

    long getComboCount();

    String getDescribe();

    a5 getDisplayText();

    e0 getGiftBanner();

    p1 getGiftExtra();

    long getGiftId();

    c2 getGiftTip();

    o0 getGiftTrayInfo();

    long getGroupCount();

    long getMsgId();

    long getOriginGiftId();

    long getRepeatCount();

    String getTopBarText();

    a5 getTrayDisplayText();
}
