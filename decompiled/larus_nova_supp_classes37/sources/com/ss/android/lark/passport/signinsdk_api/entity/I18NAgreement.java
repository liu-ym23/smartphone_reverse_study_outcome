package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.pb.entities.I18nInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/I18NAgreement;", "Ljava/io/Serializable;", "<init>", "()V", "enUs", "Lcom/ss/android/lark/passport/signinsdk_api/entity/AgreementUrl;", "getEnUs", "()Lcom/ss/android/lark/passport/signinsdk_api/entity/AgreementUrl;", "setEnUs", "(Lcom/ss/android/lark/passport/signinsdk_api/entity/AgreementUrl;)V", "zhCn", "getZhCn", "setZhCn", "jaJp", "getJaJp", "setJaJp", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class I18NAgreement implements Serializable {

    @JSONField(name = "en_us")
    private AgreementUrl enUs;

    @JSONField(name = "ja_jp")
    private AgreementUrl jaJp;

    @JSONField(name = I18nInfo.DEFAULT_LOCALE)
    private AgreementUrl zhCn;

    public I18NAgreement() {
    }

    public final AgreementUrl getEnUs() {
        return this.enUs;
    }

    public final AgreementUrl getJaJp() {
        return this.jaJp;
    }

    public final AgreementUrl getZhCn() {
        return this.zhCn;
    }

    public final void setEnUs(AgreementUrl r1) {
        this.enUs = r1;
    }

    public final void setJaJp(AgreementUrl r1) {
        this.jaJp = r1;
    }

    public final void setZhCn(AgreementUrl r1) {
        this.zhCn = r1;
    }
}
