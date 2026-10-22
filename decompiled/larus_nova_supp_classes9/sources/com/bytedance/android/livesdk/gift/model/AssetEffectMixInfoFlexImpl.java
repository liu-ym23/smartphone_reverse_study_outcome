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
@ProtoMessage("webcast.data.AssetEffectMixInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR;\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/AssetEffectMixInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/s;", "<set-?>", "effectMixImageInfoList$delegate", "Ljava/lang/Object;", "getEffectMixImageInfoList", "()Ljava/util/List;", "setEffectMixImageInfoList", "(Ljava/util/List;)V", "effectMixImageInfoList", "Lcom/bytedance/android/livesdk/gift/model/t;", "effectMixTextInfoList$delegate", "getEffectMixTextInfoList", "setEffectMixTextInfoList", "effectMixTextInfoList", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetEffectMixInfoFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("effect_mix_image_infos")
    protected List<? extends s> _$$effectMixImageInfoList;

    @SerializedName("effect_mix_text_infos")
    protected List<? extends t> _$$effectMixTextInfoList;

    public AssetEffectMixInfoFlexImpl() {
        super(c.class);
        this._$$effectMixImageInfoList = $defaultValue_effectMixImageInfoList$();
    }

    public AssetEffectMixInfoFlexImpl(am3.g r6) {
        super(c.class);
        this._$$effectMixImageInfoList = new ArrayList();
        this._$$effectMixTextInfoList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L13;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        List r4 = this._$$effectMixTextInfoList;
        Class r5 = t.class;
    L12:
        r4.add(vh7.f.a(r6, r5));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L11:
        r4 = this._$$effectMixImageInfoList;
        r5 = s.class;
        goto L12
    L13:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$effectMixImageInfoList.isEmpty() == false) goto L24;
        this._$$effectMixImageInfoList = $defaultValue_effectMixImageInfoList$();
        return;
    }

    public final List<s> $defaultValue_effectMixImageInfoList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.c
    public final List<s> getEffectMixImageInfoList() {
        return this._$$effectMixImageInfoList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c
    public final List<t> getEffectMixTextInfoList() {
        return this._$$effectMixTextInfoList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c
    public final void setEffectMixImageInfoList(List<? extends s> r1) {
        this._$$effectMixImageInfoList = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c
    public final void setEffectMixTextInfoList(List<? extends t> r1) {
        this._$$effectMixTextInfoList = r1;
    }
}
