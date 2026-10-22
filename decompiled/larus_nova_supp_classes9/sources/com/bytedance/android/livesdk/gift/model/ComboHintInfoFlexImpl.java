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
@ProtoMessage("webcast.data.ComboHintInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ComboHintInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/ExtraComboHintFlexImpl;", "comboHintList$delegate", "Ljava/lang/Object;", "getComboHintList", "()Ljava/util/List;", "comboHintList", BuildConfig.FLAVOR, "buttonStyle$delegate", "getButtonStyle", "()I", "buttonStyle", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ComboHintInfoFlexImpl extends FlexModelBase<ComboHintInfo> implements ComboHintInfo, vh7.h {

    @SerializedName("button_style")
    protected int _$$buttonStyle;

    @SerializedName("combo_hint")
    protected List<ExtraComboHintFlexImpl> _$$comboHintList;

    public ComboHintInfoFlexImpl() {
        super(ComboHintInfo.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.ComboHintInfo
    public final int getButtonStyle() {
        return this._$$buttonStyle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.ComboHintInfo
    public final List<ExtraComboHintFlexImpl> getComboHintList() {
        return this._$$comboHintList;
    }

    public ComboHintInfoFlexImpl(am3.g r6) {
        super(ComboHintInfo.class);
        this._$$comboHintList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$comboHintList.add(new ExtraComboHintFlexImpl(r6));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$buttonStyle = r6.i();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }
}
