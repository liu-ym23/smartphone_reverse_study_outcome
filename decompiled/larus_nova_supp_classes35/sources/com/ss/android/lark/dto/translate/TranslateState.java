package com.ss.android.lark.dto.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TranslateState implements Serializable {
    private int errorCode;
    private String errorMsg;
    private boolean isManual;
    private boolean isMessageVersionUpdate;
    private Message message;
    private String messageId;
    private MessageSource messageSource;
    private TranslateInfo translateInfo;

    public boolean isError() {
        return TextUtils.isEmpty(this.errorMsg);
    }

    public TranslateState() {
    }

    public String getError() {
        return this.errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public MessageSource getMessageSource() {
        return this.messageSource;
    }

    public TranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public boolean isManual() {
        return this.isManual;
    }

    public boolean isMessageVersionUpdate() {
        return this.isMessageVersionUpdate;
    }

    public TranslateState(String r1) {
        this.messageId = r1;
    }

    public void setError(String r1) {
        this.errorMsg = r1;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public void setIsMessageVersionUpdate(boolean r1) {
        this.isMessageVersionUpdate = r1;
    }

    public void setManual(boolean r1) {
        this.isManual = r1;
    }

    public void setMessage(Message r1) {
        this.message = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setMessageSource(MessageSource r1) {
        this.messageSource = r1;
    }

    public void setTranslateInfo(TranslateInfo r1) {
        this.translateInfo = r1;
    }
}
