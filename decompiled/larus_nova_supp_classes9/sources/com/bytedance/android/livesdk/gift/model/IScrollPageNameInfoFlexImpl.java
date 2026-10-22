package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.ScrollPageName")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IScrollPageNameInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/o2;", "Lpy/k;", "nameImage", "Lpy/k;", "getNameImage", "()Lpy/k;", "setNameImage", "(Lpy/k;)V", BuildConfig.FLAVOR, "<set-?>", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", BuildConfig.FLAVOR, "relatedTopicId$delegate", "getRelatedTopicId", "()J", "setRelatedTopicId", "(J)V", "relatedTopicId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IScrollPageNameInfoFlexImpl extends FlexModelBase<o2> implements o2, vh7.h {

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("related_topic_id")
    protected long _$$relatedTopicId;

    @SerializedName("name_image")
    protected py.k nameImage;

    public IScrollPageNameInfoFlexImpl() {
        super(o2.class);
        this._$$name = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o2
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o2
    public py.k getNameImage() {
        return this.nameImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o2
    public final long getRelatedTopicId() {
        return this._$$relatedTopicId;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IScrollPageNameInfoFlexImpl(am3.g r6) {
        super(o2.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$name = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$relatedTopicId = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.nameImage = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$name != null) goto L31;
        this._$$name = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o2
    public final void setName(String r1) {
        this._$$name = r1;
    }

    public void setNameImage(py.k r1) {
        this.nameImage = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o2
    public final void setRelatedTopicId(long r1) {
        this._$$relatedTopicId = r1;
    }
}
