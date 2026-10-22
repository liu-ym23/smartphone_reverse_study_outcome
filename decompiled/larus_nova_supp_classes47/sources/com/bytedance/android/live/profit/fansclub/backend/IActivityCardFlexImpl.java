package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data.ActivityCard")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R)\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCardFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCard;", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "subTitle$delegate", "getSubTitle", "subTitle", "iconUrl$delegate", "getIconUrl", "iconUrl", "jumpSchema$delegate", "getJumpSchema", "jumpSchema", "", "type$delegate", "getType", "()Ljava/lang/Long;", "type", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IActivityCardFlexImpl extends FlexModelBase<IActivityCard> implements IActivityCard, h {

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("icon_url")
    protected String _$$iconUrl;

    @SerializedName("jump_schema")
    protected String _$$jumpSchema;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("type")
    protected Long _$$type;

    public IActivityCardFlexImpl() {
        super(IActivityCard.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getIconUrl() {
        return this._$$iconUrl;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getJumpSchema() {
        return this._$$jumpSchema;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final Long getType() {
        return this._$$type;
    }

    public IActivityCardFlexImpl(g r12) {
        super(IActivityCard.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L30;
        g.a r5 = decodeExtensionFields(r2, r12);
        switch(r2) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        long r6 = r12.c();
        String r3 = null;
        String r7 = null;
    L9:
        int r8 = r12.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = am3.h.c(r12);
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = am3.h.c(r12);
        goto L9
    L14:
        am3.h.e(r12);
        goto L9
    L17:
        r12.d(r6);
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._$$type = Long.valueOf(r12.j());
        goto L3
    L26:
        this._$$jumpSchema = am3.h.c(r12);
        goto L3
    L27:
        this._$$iconUrl = am3.h.c(r12);
        goto L3
    L28:
        this._$$subTitle = am3.h.c(r12);
        goto L3
    L29:
        this._$$title = am3.h.c(r12);
        goto L3
    L7:
        am3.h.d(r5, r12);
        goto L3
    L30:
        r12.d(r0);
        setThreadSafe(true);
    }
}
