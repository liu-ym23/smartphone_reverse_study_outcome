package com.bytedance.android.live.profit.privilege.model.danmu;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.privilege.ScreenChatTabResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/IScreenChatTabResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/danmu/a;", "", "Lcom/bytedance/android/live/profit/privilege/model/danmu/ITabItemFlexImpl;", "item$delegate", "Ljava/lang/Object;", "getItem", "()Ljava/util/List;", "item", "", "shadowType$delegate", "getShadowType", "()J", "shadowType", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IScreenChatTabResponseFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("item")
    protected List<ITabItemFlexImpl> _$$item;

    @SerializedName("shadow_type")
    protected long _$$shadowType;

    public IScreenChatTabResponseFlexImpl() {
        super(a.class);
        this._$$item = $defaultValue_item$();
    }

    public final List<ITabItemFlexImpl> $defaultValue_item$() {
        return d.a();
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.a
    public final List<ITabItemFlexImpl> getItem() {
        return this._$$item;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.a
    public final long getShadowType() {
        return this._$$shadowType;
    }

    public IScreenChatTabResponseFlexImpl(g r6) {
        super(a.class);
        this._$$item = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$item.add(new ITabItemFlexImpl(r6));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$shadowType = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$item.isEmpty() == false) goto L25;
        this._$$item = $defaultValue_item$();
        return;
    }
}
