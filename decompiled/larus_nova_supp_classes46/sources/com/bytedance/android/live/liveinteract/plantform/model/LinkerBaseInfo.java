package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0018\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "", "toString", "", "scene", "I", "getScene", "()I", "setScene", "(I)V", "", "", "playModes", "Ljava/util/List;", "getPlayModes", "()Ljava/util/List;", "setPlayModes", "(Ljava/util/List;)V", "uiLayout", "getUiLayout", "setUiLayout", "maxMemberCount", "getMaxMemberCount", "setMaxMemberCount", "functionType2", "Ljava/lang/String;", "getFunctionType2", "()Ljava/lang/String;", "setFunctionType2", "(Ljava/lang/String;)V", "anchorManualOpenUiLayout", "getAnchorManualOpenUiLayout", "setAnchorManualOpenUiLayout", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerBaseInfo extends FlexModelBase<q> implements q, vh7.h {

    @SerializedName("anchor_manual_open_ui_layout")
    protected int anchorManualOpenUiLayout;

    @SerializedName("function_type")
    protected String functionType2;

    @SerializedName("MaxMemberCount")
    protected int maxMemberCount;

    @SerializedName("play_modes")
    protected List<Long> playModes;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("ui_layout")
    protected int uiLayout;

    public LinkerBaseInfo() {
        super(q.class);
    }

    public String toString() {
        return "LinkerBaseInfo(scene=" + getScene() + ", playModes=" + getPlayModes() + ", uiLayout=" + getUiLayout() + ", maxMemberCount=" + getMaxMemberCount() + ", functionType2=" + getFunctionType2() + ", anchorManualOpenUiLayout=" + getAnchorManualOpenUiLayout() + ')';
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public int getAnchorManualOpenUiLayout() {
        return this.anchorManualOpenUiLayout;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public String getFunctionType2() {
        return this.functionType2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public int getMaxMemberCount() {
        return this.maxMemberCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public List<Long> getPlayModes() {
        return this.playModes;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public int getScene() {
        return this.scene;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q
    public int getUiLayout() {
        return this.uiLayout;
    }

    public LinkerBaseInfo(am3.g r6) {
        super(q.class);
        this.playModes = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.scene = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.playModes.add(Long.valueOf(r6.j()));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.uiLayout = r6.i();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.maxMemberCount = (int) r6.j();
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.anchorManualOpenUiLayout = (int) r6.j();
        goto L3
    L16:
        if (r2 != 7) goto L17;
        this.functionType2 = am3.h.c(r6);
        goto L3
    L17:
        am3.h.d(r3, r6);
        goto L3
    L24:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setAnchorManualOpenUiLayout(int r1) {
        this.anchorManualOpenUiLayout = r1;
    }

    public void setFunctionType2(String r1) {
        this.functionType2 = r1;
    }

    public void setMaxMemberCount(int r1) {
        this.maxMemberCount = r1;
    }

    public void setPlayModes(List<Long> r1) {
        this.playModes = r1;
    }

    public void setScene(int r1) {
        this.scene = r1;
    }

    public void setUiLayout(int r1) {
        this.uiLayout = r1;
    }
}
