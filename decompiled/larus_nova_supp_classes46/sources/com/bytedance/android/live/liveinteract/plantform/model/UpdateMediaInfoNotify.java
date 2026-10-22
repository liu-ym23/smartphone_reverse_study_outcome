package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0097D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/UpdateMediaInfoNotify;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/k0;", "", "needUpdate", "Z", "getNeedUpdate", "()Z", "", "position", "J", "getPosition", "()J", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpdateMediaInfoNotify extends FlexModelBase<k0> implements k0, vh7.h {

    @SerializedName("need_update")
    protected boolean needUpdate;

    @SerializedName("position")
    protected long position;

    public UpdateMediaInfoNotify() {
        super(k0.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k0
    public boolean getNeedUpdate() {
        return this.needUpdate;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k0
    public long getPosition() {
        return this.position;
    }

    public UpdateMediaInfoNotify(am3.g r6) {
        super(k0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.needUpdate = am3.h.a(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.position = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }
}
