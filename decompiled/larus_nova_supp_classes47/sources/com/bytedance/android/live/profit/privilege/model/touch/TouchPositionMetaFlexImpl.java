package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.TouchPositionMeta")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b0\u00101R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR;\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R/\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR;\u0010+\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R/\u0010/\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\n¨\u00062"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionMetaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "", "<set-?>", "id$delegate", "Ljava/lang/Object;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "id", "metaId$delegate", "getMetaId", "setMetaId", "metaId", "", "position$delegate", "getPosition", "()I", "setPosition", "(I)V", "position", "template$delegate", "getTemplate", "setTemplate", "template", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/d;", "freqCtrlParamsList$delegate", "getFreqCtrlParamsList", "()Ljava/util/List;", "setFreqCtrlParamsList", "(Ljava/util/List;)V", "freqCtrlParamsList", "duration$delegate", "getDuration", "setDuration", Constants.Keys.duration, "Lcom/bytedance/android/live/profit/privilege/model/touch/m;", "refreshParamsList$delegate", "getRefreshParamsList", "setRefreshParamsList", "refreshParamsList", "priority$delegate", "getPriority", "setPriority", "priority", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchPositionMetaFlexImpl extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName(Constants.Keys.duration)
    protected Long _$$duration;

    @SerializedName("freq_ctrl_params_list")
    protected List<? extends d> _$$freqCtrlParamsList;

    @SerializedName("id")
    protected Long _$$id;

    @SerializedName("meta_id")
    protected Long _$$metaId;

    @SerializedName("position")
    protected int _$$position;

    @SerializedName("priority")
    protected Long _$$priority;

    @SerializedName("refresh_params_list")
    protected List<? extends m> _$$refreshParamsList;

    @SerializedName("template")
    protected Long _$$template;

    public TouchPositionMetaFlexImpl() {
        super(r.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final Long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final List<d> getFreqCtrlParamsList() {
        return this._$$freqCtrlParamsList;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final Long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final Long getMetaId() {
        return this._$$metaId;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final int getPosition() {
        return this._$$position;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final Long getPriority() {
        return this._$$priority;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final List<m> getRefreshParamsList() {
        return this._$$refreshParamsList;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final Long getTemplate() {
        return this._$$template;
    }

    public TouchPositionMetaFlexImpl(am3.g r5) {
        super(r.class);
        this._$$freqCtrlParamsList = new ArrayList();
        this._$$refreshParamsList = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$priority = Long.valueOf(r5.j());
        goto L3
    L9:
        List r4 = this._$$refreshParamsList;
        Class r6 = m.class;
    L12:
        r4.add(vh7.f.a(r5, r6));
        goto L3
    L10:
        this._$$duration = Long.valueOf(r5.j());
        goto L3
    L11:
        r4 = this._$$freqCtrlParamsList;
        r6 = d.class;
        goto L12
    L13:
        this._$$template = Long.valueOf(r5.j());
        goto L3
    L14:
        this._$$position = r5.i();
        goto L3
    L15:
        this._$$metaId = Long.valueOf(r5.j());
        goto L3
    L16:
        this._$$id = Long.valueOf(r5.j());
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L17:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setDuration(Long r1) {
        this._$$duration = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setFreqCtrlParamsList(List<? extends d> r1) {
        this._$$freqCtrlParamsList = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setId(Long r1) {
        this._$$id = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setMetaId(Long r1) {
        this._$$metaId = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setPosition(int r1) {
        this._$$position = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setPriority(Long r1) {
        this._$$priority = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setRefreshParamsList(List<? extends m> r1) {
        this._$$refreshParamsList = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.r
    public final void setTemplate(Long r1) {
        this._$$template = r1;
    }
}
