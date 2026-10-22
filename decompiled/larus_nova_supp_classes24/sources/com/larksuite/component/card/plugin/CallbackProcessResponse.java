package com.larksuite.component.card.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.plugin.model.MsgCardShowOverflowPluginModel$ActionsItemModel;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR2\u0010\u0013\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015`\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "selectText", "", "getSelectText", "()Ljava/lang/String;", "setSelectText", "(Ljava/lang/String;)V", "selectValue", "getSelectValue", "setSelectValue", "timezone", "getTimezone", "setTimezone", "result", "getResult", "setResult", "actions", "Ljava/util/ArrayList;", "Lcom/larksuite/component/card/plugin/model/MsgCardShowOverflowPluginModel$ActionsItemModel;", "Lkotlin/collections/ArrayList;", "getActions", "()Ljava/util/ArrayList;", "setActions", "(Ljava/util/ArrayList;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class CallbackProcessResponse extends LKBaseResponseModel {

    @JSONField(name = "actions")
    private ArrayList<MsgCardShowOverflowPluginModel$ActionsItemModel> actions;

    @JSONField(name = "result")
    private String result;

    @JSONField(name = "selectText")
    private String selectText;

    @JSONField(name = "selectValue")
    private String selectValue;

    @JSONField(name = "timezone")
    private String timezone;

    public CallbackProcessResponse() {
        this.actions = new ArrayList();
    }

    public final ArrayList<MsgCardShowOverflowPluginModel$ActionsItemModel> getActions() {
        return this.actions;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSelectText() {
        return this.selectText;
    }

    public final String getSelectValue() {
        return this.selectValue;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final void setActions(ArrayList<MsgCardShowOverflowPluginModel$ActionsItemModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.actions = r2;
    }

    public final void setResult(String r1) {
        this.result = r1;
    }

    public final void setSelectText(String r1) {
        this.selectText = r1;
    }

    public final void setSelectValue(String r1) {
        this.selectValue = r1;
    }

    public final void setTimezone(String r1) {
        this.timezone = r1;
    }
}
