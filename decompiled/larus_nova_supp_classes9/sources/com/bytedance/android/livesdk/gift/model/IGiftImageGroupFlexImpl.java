package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftImageGroup")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftImageGroupFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/r1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lpy/k;", "giftImageMap", "Ljava/util/Map;", "getGiftImageMap", "()Ljava/util/Map;", "setGiftImageMap", "(Ljava/util/Map;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftImageGroupFlexImpl extends FlexModelBase<r1> implements r1, vh7.h {

    @SerializedName("image_group")
    protected Map<Integer, ? extends py.k> giftImageMap;

    public IGiftImageGroupFlexImpl() {
        super(r1.class);
        this.giftImageMap = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.gift.model.r1
    public Map<Integer, py.k> getGiftImageMap() {
        return this.giftImageMap;
    }

    public IGiftImageGroupFlexImpl(am3.g r11) {
        super(r1.class);
        this.giftImageMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 2) goto L7;
        long r7 = r11.c();
        Integer r3 = null;
        Object r6 = null;
    L9:
        int r9 = r11.f();
        if (r9 == (-1)) goto L16;
        if (r9 != 1) goto L12;
        r3 = Integer.valueOf(r11.i());
        goto L9
    L12:
        if (r9 != 2) goto L13;
        r6 = vh7.f.a(r11, py.k.class);
        goto L9
    L13:
        am3.h.e(r11);
        goto L9
    L16:
        r11.d(r7);
        Map<Integer, ? extends py.k> r4 = this.giftImageMap;
        if (r3 == null) goto L23;
        if (r6 == null) goto L21;
        r4.put(r3, r6);
        goto L3
    L21:
        throw new IllegalStateException("Value must not be null");
    L23:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L24:
        r11.d(r0);
        setThreadSafe(true);
        if (this.giftImageMap != null) goto L45;
        this.giftImageMap = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
        return;
    }

    public void setGiftImageMap(Map<Integer, ? extends py.k> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftImageMap = r2;
    }
}
