package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\bg\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001JR\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0016\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u00020\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0016\u0010*\u001a\u0004\u0018\u00010\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0019R\u0014\u0010+\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0016\u0010/\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0014\u00103\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u0014\u00105\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u000bR\u0014\u00106\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0015R\u001c\u0010:\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0005\"\u0004\b8\u00109R\u001c\u0010>\u001a\u00020\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010=R\u001c\u0010B\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u0010AR\u001c\u0010E\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010AR\u001c\u0010H\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010A¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/l2;", "Lvh7/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getPrimaryEffectId", "()J", "primaryEffectId", "getNextExpire", "nextExpire", BuildConfig.FLAVOR, "getDescription", "()Ljava/lang/String;", "description", "getId", "id", "getManual", "manual", "getDiamond", "diamond", BuildConfig.FLAVOR, "getReddotTip", "()Z", "reddotTip", "Lpy/k;", "getIcon", "()Lpy/k;", "icon", BuildConfig.FLAVOR, "getCount", "()I", "setCount", "(I)V", "count", "getName", "name", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "gift", "getLabelIcon", "labelIcon", "getDiamondLabel", "diamondLabel", "isAwemeFreeGift", "Lcom/bytedance/android/livesdk/gift/model/b1;", "getBanner", "()Lcom/bytedance/android/livesdk/gift/model/b1;", "banner", "getPropType", "propType", "getPropDefSubType", "propDefSubType", "getSchemeUrl", "schemeUrl", "isDisplayedOnPanel", "getNowTimeDiff", "setNowTimeDiff", "(J)V", "nowTimeDiff", "getSetGray", "setSetGray", "(Z)V", "setGray", "getPropDescription", "setPropDescription", "(Ljava/lang/String;)V", "propDescription", "getExpiredException", "setExpiredException", "expiredException", "getRefId", "setRefId", "refId", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l2 extends vh7.c<l2> {
    public static final long CNY_PROP_SEND_COUNT = 10;
    public static final a Companion = null;
    public static final long PROP_SUB_TYPE_PK_BATTLE_PROP_CARD = 1;
    public static final long PROP_TYPE_PERIOD_CARD = 9;
    public static final long PROP_TYPE_PK_BATTLE_PROP_CARD = 1;
    public static final long PROP_TYPE_POPULAR_CARD = 4;
    public static final long PROP_TYPE_RECHARGE_COUPON = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    b1 getBanner();

    int getCount();

    String getDescription();

    long getDiamond();

    py.k getDiamondLabel();

    String getExpiredException();

    h1 getGift();

    py.k getIcon();

    long getId();

    py.k getLabelIcon();

    String getManual();

    String getName();

    long getNextExpire();

    long getNowTimeDiff();

    long getPrimaryEffectId();

    long getPropDefSubType();

    String getPropDescription();

    long getPropType();

    boolean getReddotTip();

    String getRefId();

    String getSchemeUrl();

    boolean getSetGray();

    long isAwemeFreeGift();

    boolean isDisplayedOnPanel();

    void setCount(int r1);

    void setExpiredException(String r1);

    void setNowTimeDiff(long r1);

    void setPropDescription(String r1);

    void setRefId(String r1);

    void setSetGray(boolean r1);
}
