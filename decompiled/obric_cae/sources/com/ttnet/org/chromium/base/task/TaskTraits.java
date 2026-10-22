package com.ttnet.org.chromium.base.task;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class TaskTraits {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TaskTraits BEST_EFFORT = null;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK = null;
    public static final TaskTraits CHOREOGRAPHER_FRAME = null;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final TaskTraits THREAD_POOL = null;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT = null;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING = null;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE = null;
    public static final TaskTraits USER_BLOCKING = null;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK = null;
    public static final TaskTraits USER_VISIBLE = null;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK = null;
    byte[] mExtensionData;
    byte mExtensionId;
    boolean mIsChoreographerFrame;
    boolean mMayBlock;
    int mPriority;
    boolean mPrioritySetExplicitly;
    boolean mUseThreadPool;

    static {
        TaskTraits r8 = new TaskTraits().taskPriority(0);
        BEST_EFFORT = r8;
        BEST_EFFORT_MAY_BLOCK = r8.mayBlock();
        TaskTraits r10 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = r10;
        USER_VISIBLE_MAY_BLOCK = r10.mayBlock();
        TaskTraits r11 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = r11;
        USER_BLOCKING_MAY_BLOCK = r11.mayBlock();
        TaskTraits r12 = new TaskTraits();
        CHOREOGRAPHER_FRAME = r12;
        r12.mIsChoreographerFrame = true;
        TaskTraits r13 = new TaskTraits().threadPool();
        THREAD_POOL = r13;
        THREAD_POOL_USER_BLOCKING = r13.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = r13.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = r13.taskPriority(0);
    }

    private TaskTraits() {
        this.mPriority = 1;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof TaskTraits) == false) goto L18;
        TaskTraits r10 = (TaskTraits) r8;
        if (this.mPrioritySetExplicitly != r10.mPrioritySetExplicitly) goto L17;
        if (this.mPriority != r10.mPriority) goto L17;
        if (this.mExtensionId != r10.mExtensionId) goto L17;
        if (Arrays.equals(this.mExtensionData, r10.mExtensionData) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> r8) {
        if (this.mExtensionId == r8.getId()) goto L5;
        return null;
    L5:
        return r8.fromSerializedData(this.mExtensionData);
    }

    public boolean hasExtension() {
        if (this.mExtensionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r8 = (((((((((1147 + (!this.mPrioritySetExplicitly ? 1 : 0)) * 37) + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37;
        return ((Arrays.hashCode(this.mExtensionData) + r8) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits r8 = new TaskTraits(this);
        r8.mMayBlock = true;
        return r8;
    }

    public TaskTraits taskPriority(int r8) {
        TaskTraits r10 = new TaskTraits(this);
        r10.mPrioritySetExplicitly = true;
        r10.mPriority = r8;
        return r10;
    }

    public TaskTraits threadPool() {
        TaskTraits r8 = new TaskTraits(this);
        r8.mUseThreadPool = true;
        return r8;
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> r8, Extension r10) {
        int r11 = r8.getId();
        byte[] r12 = r8.toSerializedData(r10);
        TaskTraits r13 = new TaskTraits(this);
        r13.mExtensionId = (byte) r11;
        r13.mExtensionData = r12;
        return r13;
    }

    private TaskTraits(TaskTraits r8) {
        this.mPrioritySetExplicitly = r8.mPrioritySetExplicitly;
        this.mPriority = r8.mPriority;
        this.mMayBlock = r8.mMayBlock;
        this.mUseThreadPool = r8.mUseThreadPool;
        this.mExtensionId = r8.mExtensionId;
        this.mExtensionData = r8.mExtensionData;
    }
}
