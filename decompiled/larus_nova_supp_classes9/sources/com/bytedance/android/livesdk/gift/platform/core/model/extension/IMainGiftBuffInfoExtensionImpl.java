package com.bytedance.android.livesdk.gift.platform.core.model.extension;

import com.bytedance.android.livesdk.gift.model.b2;
import com.bytedance.android.livesdk.gift.model.i;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import g12.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010M\u001a\u00020\u0002¢\u0006\u0004\bN\u0010OJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0017\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u001e\u001a\u00060\u0018j\u0002`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010!\u001a\u00060\u0018j\u0002`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010'\u001a\u00020\"8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010*\u001a\u00060\u0018j\u0002`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR4\u00100\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020,\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020,\u0018\u0001`-8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u00102\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b1\u0010\u000eR\u001e\u00108\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010>\u001a\u0002098\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R8\u0010@\u001a&\u0012\u0004\u0012\u00020\"\u0012\b\u0012\u00060\u0018j\u0002`\u00190+j\u0012\u0012\u0004\u0012\u00020\"\u0012\b\u0012\u00060\u0018j\u0002`\u0019`-8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b?\u0010/R \u0010C\u001a\u00060\u0018j\u0002`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR$\u0010F\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001c\u0010I\u001a\u0002098\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bG\u0010;\"\u0004\bH\u0010=R\u001c\u0010L\u001a\u0002098\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bJ\u0010;\"\u0004\bK\u0010=¨\u0006P"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/extension/IMainGiftBuffInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/gift/model/l1;", "Lg12/a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "bgImg", "getBgImgV2", "setBgImgV2", "bgImgV2", "getBuffDescribeImg", "setBuffDescribeImg", "buffDescribeImg", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getBuffDiamondCount", "()J", "setBuffDiamondCount", "(J)V", "buffDiamondCount", "getBuffGiftId", "setBuffGiftId", "buffGiftId", BuildConfig.FLAVOR, "getBuffLevel", "()I", "setBuffLevel", "(I)V", "buffLevel", "getDefaultChose", "setDefaultChose", "defaultChose", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/b2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getDefaultGiftTextMap", "()Ljava/util/Map;", "defaultGiftTextMap", "getDynamicGiftIcon", "dynamicGiftIcon", "Lcom/bytedance/android/livesdk/gift/model/i;", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/i;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/i;)V", "lockInfo", BuildConfig.FLAVOR, "getLockToast", "()Ljava/lang/String;", "setLockToast", "(Ljava/lang/String;)V", "lockToast", "getPageTypeToDefaultChoseActionMap", "pageTypeToDefaultChoseActionMap", "getStartTime", "setStartTime", "startTime", "getSweepLightImg", "setSweepLightImg", "sweepLightImg", "getText", "setText", "text", "getTextColor", "setTextColor", "textColor", "base", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/l1;)V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainGiftBuffInfoExtensionImpl extends ModelExtensionBase<l1, a> implements a, l1 {
    private final /* synthetic */ l1 $$delegate_0;

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public <R extends e<l1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public <R extends e<l1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public k getBgImg() {
        return this.$$delegate_0.getBgImg();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public k getBgImgV2() {
        return this.$$delegate_0.getBgImgV2();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public k getBuffDescribeImg() {
        return this.$$delegate_0.getBuffDescribeImg();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public long getBuffDiamondCount() {
        return this.$$delegate_0.getBuffDiamondCount();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public long getBuffGiftId() {
        return this.$$delegate_0.getBuffGiftId();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public int getBuffLevel() {
        return this.$$delegate_0.getBuffLevel();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public long getDefaultChose() {
        return this.$$delegate_0.getDefaultChose();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public Map<Integer, b2> getDefaultGiftTextMap() {
        return this.$$delegate_0.getDefaultGiftTextMap();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public k getDynamicGiftIcon() {
        return this.$$delegate_0.getDynamicGiftIcon();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public i getLockInfo() {
        return this.$$delegate_0.getLockInfo();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public String getLockToast() {
        return this.$$delegate_0.getLockToast();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public Map<Integer, Long> getPageTypeToDefaultChoseActionMap() {
        return this.$$delegate_0.getPageTypeToDefaultChoseActionMap();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public long getStartTime() {
        return this.$$delegate_0.getStartTime();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public k getSweepLightImg() {
        return this.$$delegate_0.getSweepLightImg();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public String getText() {
        return this.$$delegate_0.getText();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public String getTextColor() {
        return this.$$delegate_0.getTextColor();
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBgImg(k r2) {
        this.$$delegate_0.setBgImg(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBgImgV2(k r2) {
        this.$$delegate_0.setBgImgV2(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBuffDescribeImg(k r2) {
        this.$$delegate_0.setBuffDescribeImg(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBuffDiamondCount(long r2) {
        this.$$delegate_0.setBuffDiamondCount(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBuffGiftId(long r2) {
        this.$$delegate_0.setBuffGiftId(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setBuffLevel(int r2) {
        this.$$delegate_0.setBuffLevel(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setDefaultChose(long r2) {
        this.$$delegate_0.setDefaultChose(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setLockInfo(i r2) {
        this.$$delegate_0.setLockInfo(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setLockToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setLockToast(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setStartTime(long r2) {
        this.$$delegate_0.setStartTime(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setSweepLightImg(k r2) {
        this.$$delegate_0.setSweepLightImg(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setText(r2);
    }

    @Override // g12.a, com.bytedance.android.livesdk.gift.model.l1
    public void setTextColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setTextColor(r2);
    }

    public IMainGiftBuffInfoExtensionImpl(l1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
