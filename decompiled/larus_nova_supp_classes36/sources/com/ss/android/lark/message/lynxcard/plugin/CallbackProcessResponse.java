package com.ss.android.lark.message.lynxcard.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/message/lynxcard/plugin/CallbackProcessResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "selectText", "", "getSelectText", "()Ljava/lang/String;", "setSelectText", "(Ljava/lang/String;)V", "selectValue", "getSelectValue", "setSelectValue", "timezone", "getTimezone", "setTimezone", "result", "getResult", "setResult", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CallbackProcessResponse extends LKBaseResponseModel {

    @JSONField(name = "result")
    private String result;

    @JSONField(name = "selectText")
    private String selectText;

    @JSONField(name = "selectValue")
    private String selectValue;

    @JSONField(name = "timezone")
    private String timezone;

    public CallbackProcessResponse() {
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
