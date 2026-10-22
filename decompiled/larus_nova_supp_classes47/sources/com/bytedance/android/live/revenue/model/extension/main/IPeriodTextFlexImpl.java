package com.bytedance.android.live.revenue.model.extension.main;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.GiftPanelTopperTray.PeriodText")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/IPeriodTextFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/revenue/model/extension/main/d;", "", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "text", "", "dailyShowTimes$delegate", "getDailyShowTimes", "()I", "dailyShowTimes", "priority$delegate", "getPriority", "priority", "panelEnum$delegate", "getPanelEnum", "panelEnum", "key$delegate", "getKey", "key", "extra$delegate", "getExtra", "extra", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPeriodTextFlexImpl extends FlexModelBase<d> implements d, h {

    @SerializedName("daily_show_times")
    protected int _$$dailyShowTimes;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("key")
    protected int _$$key;

    @SerializedName("panel_enum")
    protected int _$$panelEnum;

    @SerializedName("priority")
    protected int _$$priority;

    @SerializedName("text")
    protected String _$$text;

    public IPeriodTextFlexImpl() {
        super(d.class);
        this._$$text = "";
        this._$$extra = "";
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final int getDailyShowTimes() {
        return this._$$dailyShowTimes;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final int getKey() {
        return this._$$key;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final int getPanelEnum() {
        return this._$$panelEnum;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final int getPriority() {
        return this._$$priority;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.d
    public final String getText() {
        return this._$$text;
    }

    public IPeriodTextFlexImpl(g r5) {
        super(d.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        g.a r3 = decodeExtensionFields(r2, r5);
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
        this._$$extra = am3.h.c(r5);
        goto L3
    L9:
        this._$$key = r5.i();
        goto L3
    L10:
        this._$$panelEnum = r5.i();
        goto L3
    L11:
        this._$$priority = r5.i();
        goto L3
    L12:
        this._$$dailyShowTimes = r5.i();
        goto L3
    L13:
        this._$$text = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L18;
        this._$$text = "";
    L18:
        if (this._$$extra != null) goto L37;
        this._$$extra = "";
        return;
    }
}
