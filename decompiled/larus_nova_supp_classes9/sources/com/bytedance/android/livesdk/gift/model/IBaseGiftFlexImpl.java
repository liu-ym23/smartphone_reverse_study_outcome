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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftBaseStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011R)\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IBaseGiftFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/c1;", BuildConfig.FLAVOR, "id$delegate", "Ljava/lang/Object;", "getId", "()J", "id", BuildConfig.FLAVOR, "name$delegate", "getName", "()Ljava/lang/String;", "name", BuildConfig.FLAVOR, "diamondCount$delegate", "getDiamondCount", "()I", "diamondCount", "bizType$delegate", "getBizType", "bizType", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/IGiftImageGroupFlexImpl;", "giftImageGroupMap$delegate", "getGiftImageGroupMap", "()Ljava/util/Map;", "giftImageGroupMap", "topicId$delegate", "getTopicId", "topicId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBaseGiftFlexImpl extends FlexModelBase<c1> implements c1, vh7.h {

    @SerializedName("biz_type")
    protected int _$$bizType;

    @SerializedName("diamond_count")
    protected int _$$diamondCount;

    @SerializedName("image_group_map")
    protected Map<Integer, IGiftImageGroupFlexImpl> _$$giftImageGroupMap;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("topic_id")
    protected long _$$topicId;

    public IBaseGiftFlexImpl() {
        super(c1.class);
        this._$$name = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final int getBizType() {
        return this._$$bizType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final int getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final Map<Integer, IGiftImageGroupFlexImpl> getGiftImageGroupMap() {
        return this._$$giftImageGroupMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c1
    public final long getTopicId() {
        return this._$$topicId;
    }

    public IBaseGiftFlexImpl(am3.g r11) {
        super(c1.class);
        this._$$giftImageGroupMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L30;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$topicId = r11.j();
        goto L3
    L9:
        long r6 = r11.c();
        Integer r3 = null;
        IGiftImageGroupFlexImpl r7 = null;
    L10:
        int r8 = r11.f();
        if (r8 == (-1)) goto L18;
        if (r8 != 1) goto L14;
        r3 = Integer.valueOf(r11.i());
        goto L10
    L14:
        if (r8 != 2) goto L15;
        r7 = new IGiftImageGroupFlexImpl(r11);
        goto L10
    L15:
        am3.h.e(r11);
        goto L10
    L18:
        r11.d(r6);
        Map<Integer, IGiftImageGroupFlexImpl> r4 = this._$$giftImageGroupMap;
        if (r3 == null) goto L25;
        if (r7 == null) goto L23;
        r4.put(r3, r7);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this._$$bizType = r11.i();
        goto L3
    L27:
        this._$$name = am3.h.c(r11);
        goto L3
    L28:
        this._$$diamondCount = r11.i();
        goto L3
    L29:
        this._$$id = r11.j();
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L30:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$name != null) goto L61;
        this._$$name = BuildConfig.FLAVOR;
        return;
    }
}
