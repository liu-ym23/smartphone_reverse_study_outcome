package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/sticker/GiftStickerSettingConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/core/sticker/a;", BuildConfig.FLAVOR, "assetPathCheck", "Z", "h8", "()Z", "pathExceptionReset", "v2", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftStickerSettingConfigSerializableObjectImpl implements a {

    @SerializedName("asset_path")
    private final boolean assetPathCheck;

    @SerializedName("path_exception_reset")
    private final boolean pathExceptionReset;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/sticker/GiftStickerSettingConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftStickerSettingConfigSerializableObjectImpl.class);
        }
    }

    public GiftStickerSettingConfigSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.sticker.a
    public final boolean h8() {
        return this.assetPathCheck;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.sticker.a
    public final boolean v2() {
        return this.pathExceptionReset;
    }
}
