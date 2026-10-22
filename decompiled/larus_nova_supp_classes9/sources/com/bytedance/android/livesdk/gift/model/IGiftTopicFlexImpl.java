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
@ProtoMessage("webcast.api.gift.GiftTopic")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftTopicFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/d2;", "Lpy/k;", "nameImage", "Lpy/k;", "getNameImage", "()Lpy/k;", "setNameImage", "(Lpy/k;)V", BuildConfig.FLAVOR, "id$delegate", "Ljava/lang/Object;", "getId", "()J", "id", BuildConfig.FLAVOR, "name$delegate", "getName", "()Ljava/lang/String;", "name", "Lcom/bytedance/android/livesdk/gift/model/PageInfoFlexImpl;", "pageInfo$delegate", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/PageInfoFlexImpl;", "pageInfo", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "relatedGiftIds$delegate", "getRelatedGiftIds", "()Ljava/util/List;", "relatedGiftIds", "clickType$delegate", "getClickType", "()I", "clickType", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftTopicFlexImpl extends FlexModelBase<d2> implements d2, vh7.h {

    @SerializedName("click_type")
    protected int _$$clickType;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("page_info")
    protected PageInfoFlexImpl _$$pageInfo;

    @SerializedName("related_gift_ids")
    protected List<Integer> _$$relatedGiftIds;

    @SerializedName("name_image")
    protected py.k nameImage;

    public IGiftTopicFlexImpl() {
        super(d2.class);
        this._$$name = BuildConfig.FLAVOR;
        this._$$relatedGiftIds = $defaultValue_relatedGiftIds$();
    }

    public final List<Integer> $defaultValue_relatedGiftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public /* bridge */ /* synthetic */ x2 getPageInfo() {
        return getPageInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public final int getClickType() {
        return this._$$clickType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public py.k getNameImage() {
        return this.nameImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public final List<Integer> getRelatedGiftIds() {
        return this._$$relatedGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d2
    public final PageInfoFlexImpl getPageInfo() {
        return this._$$pageInfo;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IGiftTopicFlexImpl(am3.g r5) {
        super(d2.class);
        this._$$relatedGiftIds = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$clickType = r5.i();
        goto L3
    L9:
        this._$$relatedGiftIds.add(Integer.valueOf(r5.i()));
        goto L3
    L10:
        this._$$pageInfo = new PageInfoFlexImpl(r5);
        goto L3
    L11:
        this.nameImage = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this._$$name = am3.h.c(r5);
        goto L3
    L13:
        this._$$id = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$name != null) goto L18;
        this._$$name = BuildConfig.FLAVOR;
    L18:
        if (this._$$relatedGiftIds.isEmpty() == false) goto L37;
        this._$$relatedGiftIds = $defaultValue_relatedGiftIds$();
        return;
    }

    public void setNameImage(py.k r1) {
        this.nameImage = r1;
    }
}
