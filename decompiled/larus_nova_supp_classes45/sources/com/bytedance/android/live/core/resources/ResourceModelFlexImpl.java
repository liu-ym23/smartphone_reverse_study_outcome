package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.Image")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/core/resources/ResourceModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/l;", "", "uri$delegate", "Ljava/lang/Object;", "getUri", "()Ljava/lang/String;", "uri", "", "<set-?>", "urlList$delegate", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "urlList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ResourceModelFlexImpl extends FlexModelBase<l> implements l, vh7.h {

    @SerializedName("uri")
    protected String _$$uri;

    @SerializedName("url_list")
    protected List<String> _$$urlList;

    public ResourceModelFlexImpl() {
        super(l.class);
        this._$$uri = "";
        this._$$urlList = $defaultValue_urlList$();
    }

    public ResourceModelFlexImpl(am3.g r6) {
        super(l.class);
        this._$$urlList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$urlList.add(am3.h.c(r6));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$uri = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$uri != null) goto L16;
        this._$$uri = "";
    L16:
        if (this._$$urlList.isEmpty() == false) goto L28;
        this._$$urlList = $defaultValue_urlList$();
        return;
    }

    public final List<String> $defaultValue_urlList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.core.resources.l
    public final String getUri() {
        return this._$$uri;
    }

    @Override // com.bytedance.android.live.core.resources.l
    public final List<String> getUrlList() {
        return this._$$urlList;
    }

    @Override // com.bytedance.android.live.core.resources.l
    public final void setUrlList(List<String> r1) {
        this._$$urlList = r1;
    }
}
