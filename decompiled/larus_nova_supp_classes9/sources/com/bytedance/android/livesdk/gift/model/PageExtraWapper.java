package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(PageExtraWrapperJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B+\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PageExtraWapper;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/k2;", "Lvh7/h;", "Lcom/bytedance/android/livesdk/gift/model/w2;", "decoded", "Lcom/bytedance/android/livesdk/gift/model/w2;", "getDecoded", "()Lcom/bytedance/android/livesdk/gift/model/w2;", BuildConfig.FLAVOR, "rawPB", "[B", "getRawPB", "()[B", "Lcom/google/gson/JsonObject;", "rawJson", "Lcom/google/gson/JsonObject;", "getRawJson", "()Lcom/google/gson/JsonObject;", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/w2;[BLcom/google/gson/JsonObject;)V", "Lam3/g;", "reader", "(Lam3/g;)V", "bytes", "([B)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageExtraWapper extends FlexModelBase<k2> implements k2, vh7.h {
    private final w2 decoded;
    private final JsonObject rawJson;
    private final byte[] rawPB;

    public PageExtraWapper() {
        this(null, null, null, 7, null);
    }

    @Override // com.bytedance.android.livesdk.gift.model.k2
    public w2 getDecoded() {
        return this.decoded;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k2
    public JsonObject getRawJson() {
        return this.rawJson;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k2
    public byte[] getRawPB() {
        return this.rawPB;
    }

    public PageExtraWapper(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        this((w2) vh7.f.b(r3, w2.class), r3, null);
    }

    public PageExtraWapper(am3.g r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        this(am3.h.b(r2));
    }

    public PageExtraWapper(w2 r2, byte[] r3, JsonObject r4) {
        super(k2.class);
        this.decoded = r2;
        this.rawPB = r3;
        this.rawJson = r4;
        if (getRawPB() == null) goto L5;
        return;
    L5:
        if (getRawJson() == null) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L10;
        ALogger.e("GiftExtraWrapper", "both pb and json data is null");
        return;
    L10:
        throw new Error("both pb and json data is null");
    }

    public /* synthetic */ PageExtraWapper(w2 r2, byte[] r3, JsonObject r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
