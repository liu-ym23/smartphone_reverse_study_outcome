package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.Format265Resource")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/core/resources/ResourceH265ModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/j;", "Lcom/bytedance/android/live/core/resources/ResourceModelFlexImpl;", "resourceModel$delegate", "Ljava/lang/Object;", "getResourceModel", "()Lcom/bytedance/android/live/core/resources/ResourceModelFlexImpl;", "resourceModel", "", "resourceUri$delegate", "getResourceUri", "()Ljava/lang/String;", "resourceUri", "md5$delegate", "getMd5", "md5", "ttmd5$delegate", "getTtmd5", "ttmd5", "size$delegate", "getSize", "size", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ResourceH265ModelFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("md5")
    protected String _$$md5;

    @SerializedName("resource_url")
    protected ResourceModelFlexImpl _$$resourceModel;

    @SerializedName("resource_uri")
    protected String _$$resourceUri;

    @SerializedName("size")
    protected String _$$size;

    @SerializedName("ttmd5")
    protected String _$$ttmd5;

    public ResourceH265ModelFlexImpl() {
        super(j.class);
        this._$$resourceModel = $defaultValue_resourceModel$();
        this._$$resourceUri = "";
        this._$$md5 = "";
        this._$$size = "";
    }

    public ResourceH265ModelFlexImpl(am3.g r6) {
        super(j.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$resourceUri = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$resourceModel = new ResourceModelFlexImpl(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$md5 = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$size = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$ttmd5 = am3.h.c(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$resourceModel != null) goto L25;
        this._$$resourceModel = $defaultValue_resourceModel$();
    L25:
        if (this._$$resourceUri != null) goto L28;
        this._$$resourceUri = "";
    L28:
        if (this._$$md5 != null) goto L31;
        this._$$md5 = "";
    L31:
        if (this._$$size != null) goto L52;
        this._$$size = "";
        return;
    }

    public final ResourceModelFlexImpl $defaultValue_resourceModel$() {
        return (ResourceModelFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(ResourceModelFlexImpl.class);
    }

    @Override // com.bytedance.android.live.core.resources.j
    public /* bridge */ /* synthetic */ l getResourceModel() {
        return getResourceModel();
    }

    @Override // com.bytedance.android.live.core.resources.j
    public final String getMd5() {
        return this._$$md5;
    }

    @Override // com.bytedance.android.live.core.resources.j
    public final String getResourceUri() {
        return this._$$resourceUri;
    }

    @Override // com.bytedance.android.live.core.resources.j
    public final String getSize() {
        return this._$$size;
    }

    @Override // com.bytedance.android.live.core.resources.j
    public final String getTtmd5() {
        return this._$$ttmd5;
    }

    @Override // com.bytedance.android.live.core.resources.j
    public final ResourceModelFlexImpl getResourceModel() {
        return this._$$resourceModel;
    }
}
