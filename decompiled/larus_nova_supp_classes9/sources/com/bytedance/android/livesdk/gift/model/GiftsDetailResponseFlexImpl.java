package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftsDetailResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftsDetailResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/s0;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "giftList", "Ljava/util/List;", "getGiftList", "()Ljava/util/List;", "setGiftList", "(Ljava/util/List;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftsDetailResponseFlexImpl extends FlexModelBase<s0> implements s0, vh7.h {

    @SerializedName("gifts")
    protected List<? extends h1> giftList;

    public GiftsDetailResponseFlexImpl() {
        super(s0.class);
    }

    public GiftsDetailResponseFlexImpl(am3.g r6) {
        super(s0.class);
        this.giftList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.giftList.add(vh7.f.a(r6, h1.class));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.s0
    public List<h1> getGiftList() {
        return this.giftList;
    }

    public void setGiftList(List<? extends h1> r1) {
        this.giftList = r1;
    }
}
