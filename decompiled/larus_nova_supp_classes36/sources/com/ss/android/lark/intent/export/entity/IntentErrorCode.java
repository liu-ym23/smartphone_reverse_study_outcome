package com.ss.android.lark.intent.export.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/IntentErrorCode;", "", "<init>", "()V", "INVALID_ACCOUNT_ERROR", "", "CONTACT_NOT_EXIST_ERROR", "EMPTY_COTENT_ERROR", "KNOWLEDGE_NOT_AVAILABLE", "KNOWLEDGE_NOT_AUTHORIZE", "KNOWLEDGE_GEN_FAIL", "INVALID_COTENT_ERROR", "GROUP_NOT_EXIST_ERROR", "KNOWLEDGE_INSUFFICIENT_ERROR", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class IntentErrorCode {
    public static final int CONTACT_NOT_EXIST_ERROR = 7002;
    public static final int EMPTY_COTENT_ERROR = 7003;
    public static final int GROUP_NOT_EXIST_ERROR = 7011;
    public static final IntentErrorCode INSTANCE = null;
    public static final int INVALID_ACCOUNT_ERROR = 7001;
    public static final int INVALID_COTENT_ERROR = 7010;
    public static final int KNOWLEDGE_GEN_FAIL = 7006;
    public static final int KNOWLEDGE_INSUFFICIENT_ERROR = 7012;
    public static final int KNOWLEDGE_NOT_AUTHORIZE = 7005;
    public static final int KNOWLEDGE_NOT_AVAILABLE = 7004;

    static {
        INSTANCE = new IntentErrorCode();
    }

    private IntentErrorCode() {
    }
}
