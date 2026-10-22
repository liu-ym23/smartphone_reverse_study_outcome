package com.bytedance.android.live.profit.dress;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.DressListResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/dress/IDressListResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/n;", "", "Lcom/bytedance/android/live/profit/dress/p;", "dressList", "Ljava/util/List;", "getDressList", "()Ljava/util/List;", "setDressList", "(Ljava/util/List;)V", "", "version$delegate", "Ljava/lang/Object;", "getVersion", "()Ljava/lang/String;", Constants.Keys.VERSION, "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDressListResponseFlexImpl extends FlexModelBase<n> implements n, vh7.h {

    @SerializedName(Constants.Keys.VERSION)
    protected String _$$version;

    @SerializedName("dress_list")
    protected List<? extends p> dressList;

    public IDressListResponseFlexImpl() {
        super(n.class);
        this.dressList = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.dress.n
    public List<p> getDressList() {
        return this.dressList;
    }

    @Override // com.bytedance.android.live.profit.dress.n
    public final String getVersion() {
        return this._$$version;
    }

    public IDressListResponseFlexImpl(am3.g r6) {
        super(n.class);
        this.dressList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.dressList.add(vh7.f.a(r6, p.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$version = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this.dressList.isEmpty() == false) goto L25;
        this.dressList = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
        return;
    }

    public void setDressList(List<? extends p> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dressList = r2;
    }
}
