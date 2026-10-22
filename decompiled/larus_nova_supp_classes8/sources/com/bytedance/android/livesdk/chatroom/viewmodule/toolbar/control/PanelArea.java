package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.base.model.PanelWidget;
import com.bytedance.android.live.base.model.morepanel.AreaPattern;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.room.PanelArea")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/PanelArea;", "", "()V", "areaPattern", "Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "getAreaPattern", "()Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "setAreaPattern", "(Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;)V", "dataList", "", "Lcom/bytedance/android/live/base/model/PanelWidget;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "type", "", "getType", "()I", "setType", "(I)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelArea implements vh7.h {

    @SerializedName("area_pattern")
    protected AreaPattern areaPattern;

    @SerializedName("widget_list")
    protected List<PanelWidget> dataList;

    @SerializedName("area_type")
    protected int type;

    public PanelArea() {
        this.dataList = new ArrayList();
    }

    public final AreaPattern getAreaPattern() {
        return this.areaPattern;
    }

    public final List<PanelWidget> getDataList() {
        return this.dataList;
    }

    public final int getType() {
        return this.type;
    }

    public PanelArea(am3.g r5) {
        this.dataList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.dataList.add(new PanelWidget(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.type = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.areaPattern = new AreaPattern(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.dataList.isEmpty() == false) goto L31;
        this.dataList = new ArrayList();
        return;
    }

    public final void setAreaPattern(AreaPattern r1) {
        this.areaPattern = r1;
    }

    public final void setDataList(List<PanelWidget> r1) {
        this.dataList = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
