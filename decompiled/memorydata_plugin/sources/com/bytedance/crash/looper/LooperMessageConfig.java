package com.bytedance.crash.looper;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class LooperMessageConfig {
    private static final String BLOCK_STACK_FILE_NAME = "block_stack.json";
    static final String BLOCK_STACK_KET = "block_stack";
    private static final String CURRENT_FILE_NAME = "current.json";
    static final String CURRENT_MESSAGE_KET = "current_message";
    static final String HISTORY_DETAILS_KET = "history_details";
    private static final String HISTORY_FILE_NAME = "history.json";
    static final String HISTORY_MESSAGE_KET = "history_message";
    static final String MESSAGE_TAG_PREFIX = "npth_message_";
    private static final String PENDING_FILE_NAME = "pending.json";
    static final String PENDING_MESSAGE_KET = "pending_messages";
    static final int SCHEDULE_TYPE_IDLE = 1;
    static final int SCHEDULE_TYPE_LONG = 8;
    static final int SCHEDULE_TYPE_NORMAL = 9;

    public LooperMessageConfig() {
    }

    static File getBlockStackJsonFile(File r2) {
        return new File(r2, BLOCK_STACK_FILE_NAME);
    }

    static File getCurrentJsonFile(File r2) {
        return new File(r2, CURRENT_FILE_NAME);
    }

    static File getHistoryJsonFile(File r2) {
        return new File(r2, HISTORY_FILE_NAME);
    }

    static File getPendingJsonFile(File r2) {
        return new File(r2, PENDING_FILE_NAME);
    }
}
