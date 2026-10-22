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
@ProtoMessage("webcast.api.gift.GiftBaseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftBaseDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/j1;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/c1;", "<set-?>", "baseGiftList$delegate", "Ljava/lang/Object;", "getBaseGiftList", "()Ljava/util/List;", "setBaseGiftList", "(Ljava/util/List;)V", "baseGiftList", BuildConfig.FLAVOR, "version$delegate", "getVersion", "()J", "setVersion", "(J)V", "version", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftBaseDataFlexImpl extends FlexModelBase<j1> implements j1, vh7.h {

    @SerializedName("gift_base_list")
    protected List<? extends c1> _$$baseGiftList;

    @SerializedName("version")
    protected long _$$version;

    public IGiftBaseDataFlexImpl() {
        super(j1.class);
        this._$$baseGiftList = $defaultValue_baseGiftList$();
    }

    public final List<c1> $defaultValue_baseGiftList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.j1
    public final List<c1> getBaseGiftList() {
        return this._$$baseGiftList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j1
    public final long getVersion() {
        return this._$$version;
    }

    public IGiftBaseDataFlexImpl(am3.g r6) {
        super(j1.class);
        this._$$baseGiftList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$baseGiftList.add(vh7.f.a(r6, c1.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$version = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$baseGiftList.isEmpty() == false) goto L25;
        this._$$baseGiftList = $defaultValue_baseGiftList$();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j1
    public final void setBaseGiftList(List<? extends c1> r1) {
        this._$$baseGiftList = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j1
    public final void setVersion(long r1) {
        this._$$version = r1;
    }
}
