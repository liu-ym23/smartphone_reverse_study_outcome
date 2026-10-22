package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.ChorusStageEffectConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IChorusStageEffectConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/g;", "", "Lpy/k;", "advanImageList", "Ljava/util/List;", "getAdvanImageList", "()Ljava/util/List;", "setAdvanImageList", "(Ljava/util/List;)V", "<set-?>", "basicImage$delegate", "Ljava/lang/Object;", "getBasicImage", "()Lpy/k;", "setBasicImage", "(Lpy/k;)V", "basicImage", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IChorusStageEffectConfigFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("basic_image")
    protected py.k _$$basicImage;

    @SerializedName("advan_image_list")
    protected List<? extends py.k> advanImageList;

    public IChorusStageEffectConfigFlexImpl() {
        super(g.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IChorusStageEffectConfigFlexImpl(am3.g r6) {
        super(g.class);
        this.advanImageList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$basicImage = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.advanImageList.add(vh7.f.a(r6, py.k.class));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.g
    public List<py.k> getAdvanImageList() {
        return this.advanImageList;
    }

    @Override // com.bytedance.android.live.profit.dress.config.g
    public final py.k getBasicImage() {
        return this._$$basicImage;
    }

    public void setAdvanImageList(List<? extends py.k> r1) {
        this.advanImageList = r1;
    }

    @Override // com.bytedance.android.live.profit.dress.config.g
    public final void setBasicImage(py.k r1) {
        this._$$basicImage = r1;
    }
}
