package com.obric.memorydata.sdk.awareness;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/HomeCompanyAddressLearningSharedState;", "", "<init>", "()V", "KEY_AUTO_LEARN_STATE", "", "KEY_HOME_LEARNING_STATUS", "KEY_COMPANY_LEARNING_STATUS", "AUTO_LEARN_STATE_UNKNOWN", "", "AUTO_LEARN_STATE_DISABLED", "AUTO_LEARN_STATE_ENABLED", "LEARNING_STATUS_UNKNOWN", "LEARNING_STATUS_DISABLED", "LEARNING_STATUS_LEARNING", "LEARNING_STATUS_LEARNED", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeCompanyAddressLearningSharedState {
    public static final int AUTO_LEARN_STATE_DISABLED = 0;
    public static final int AUTO_LEARN_STATE_ENABLED = 1;
    public static final int AUTO_LEARN_STATE_UNKNOWN = -1;
    public static final HomeCompanyAddressLearningSharedState INSTANCE = null;
    public static final String KEY_AUTO_LEARN_STATE = "memorydata_home_company_auto_learn_state";
    public static final String KEY_COMPANY_LEARNING_STATUS = "memorydata_company_address_learning_status";
    public static final String KEY_HOME_LEARNING_STATUS = "memorydata_home_address_learning_status";
    public static final int LEARNING_STATUS_DISABLED = 0;
    public static final int LEARNING_STATUS_LEARNED = 2;
    public static final int LEARNING_STATUS_LEARNING = 1;
    public static final int LEARNING_STATUS_UNKNOWN = -1;

    static {
        INSTANCE = new HomeCompanyAddressLearningSharedState();
    }

    private HomeCompanyAddressLearningSharedState() {
    }
}
