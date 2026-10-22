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
@ProtoMessage("webcast.data.SeriesGiftsInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SeriesGiftsInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/l3;", BuildConfig.FLAVOR, "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", BuildConfig.FLAVOR, "fullSend$delegate", "getFullSend", "()Z", "fullSend", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/SeriesGiftFlexImpl;", "seriesGiftList$delegate", "getSeriesGiftList", "()Ljava/util/List;", "seriesGiftList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeriesGiftsInfoFlexImpl extends FlexModelBase<l3> implements l3, vh7.h {

    @SerializedName("allow_full_send")
    protected boolean _$$fullSend;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("series_gift_list")
    protected List<SeriesGiftFlexImpl> _$$seriesGiftList;

    public SeriesGiftsInfoFlexImpl() {
        super(l3.class);
        this._$$fullSend = false;
    }

    public SeriesGiftsInfoFlexImpl(am3.g r8) {
        super(l3.class);
        this._$$seriesGiftList = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L15;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$name = am3.h.c(r8);
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$seriesGiftList.add(new SeriesGiftFlexImpl(r8));
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$fullSend = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L11:
        am3.h.d(r5, r8);
        goto L3
    L15:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L31;
        this._$$fullSend = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l3
    public final boolean getFullSend() {
        return this._$$fullSend;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l3
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l3
    public final List<SeriesGiftFlexImpl> getSeriesGiftList() {
        return this._$$seriesGiftList;
    }
}
