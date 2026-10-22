package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicJoinChannelData.DelegateSetting")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/DelegateSettingDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "", "<set-?>", "showPanel$delegate", "Ljava/lang/Object;", "getShowPanel", "()Z", "setShowPanel", "(Z)V", "showPanel", "enableDelegate$delegate", "getEnableDelegate", "setEnableDelegate", "enableDelegate", "Lpy/k;", "tagImageUrl$delegate", "getTagImageUrl", "()Lpy/k;", "setTagImageUrl", "(Lpy/k;)V", "tagImageUrl", "", "prompt$delegate", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "prompt", "", "status$delegate", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "status", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DelegateSettingDataFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("enable_delegate")
    protected boolean _$$enableDelegate;

    @SerializedName("prompt")
    protected String _$$prompt;

    @SerializedName("show_panel")
    protected boolean _$$showPanel;

    @SerializedName("status")
    protected Integer _$$status;

    @SerializedName("tag_image_url")
    protected py.k _$$tagImageUrl;

    public DelegateSettingDataFlexImpl() {
        super(d.class);
        this._$$showPanel = false;
        this._$$enableDelegate = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final boolean getEnableDelegate() {
        return this._$$enableDelegate;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final String getPrompt() {
        return this._$$prompt;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final boolean getShowPanel() {
        return this._$$showPanel;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final Integer getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final py.k getTagImageUrl() {
        return this._$$tagImageUrl;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, py.k] */
    public DelegateSettingDataFlexImpl(am3.g r9) {
        super(d.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$showPanel = am3.h.a(r9);
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this._$$enableDelegate = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$tagImageUrl = vh7.f.a(r9, py.k.class);
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this._$$prompt = am3.h.c(r9);
        goto L3
    L13:
        if (r4 != 5) goto L14;
        this._$$status = Integer.valueOf(r9.i());
        goto L3
    L14:
        am3.h.d(r5, r9);
        goto L3
    L20:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L24;
        this._$$showPanel = false;
    L24:
        if ((r3 & 2) != 0) goto L45;
        this._$$enableDelegate = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final void setEnableDelegate(boolean r1) {
        this._$$enableDelegate = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final void setPrompt(String r1) {
        this._$$prompt = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final void setShowPanel(boolean r1) {
        this._$$showPanel = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final void setStatus(Integer r1) {
        this._$$status = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.d
    public final void setTagImageUrl(py.k r1) {
        this._$$tagImageUrl = r1;
    }
}
