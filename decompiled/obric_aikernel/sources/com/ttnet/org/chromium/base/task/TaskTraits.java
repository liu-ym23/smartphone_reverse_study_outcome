package com.ttnet.org.chromium.base.task;

import androidx.annotation.Nullable;
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
    boolean mUseThreadPool;

    static {
        TaskTraits r10 = new TaskTraits().taskPriority(0);
        BEST_EFFORT = r10;
        BEST_EFFORT_MAY_BLOCK = r10.mayBlock();
        TaskTraits r11 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = r11;
        USER_VISIBLE_MAY_BLOCK = r11.mayBlock();
        TaskTraits r12 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = r12;
        USER_BLOCKING_MAY_BLOCK = r12.mayBlock();
        TaskTraits r13 = new TaskTraits();
        CHOREOGRAPHER_FRAME = r13;
        r13.mIsChoreographerFrame = true;
        TaskTraits r14 = new TaskTraits().threadPool().taskPriority(2);
        THREAD_POOL = r14;
        THREAD_POOL_USER_BLOCKING = r14.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = r14.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = r14.taskPriority(0);
    }

    private TaskTraits() {
        this.mPriority = 2;
    }

    private TaskTraits(TaskTraits r10) {
        this.mPriority = r10.mPriority;
        this.mMayBlock = r10.mMayBlock;
        this.mUseThreadPool = r10.mUseThreadPool;
        this.mExtensionId = r10.mExtensionId;
        this.mExtensionData = r10.mExtensionData;
    }

    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TaskTraits) == false) goto L22;
        TaskTraits r11 = (TaskTraits) r10;
        if (this.mPriority != r11.mPriority) goto L21;
        if (this.mMayBlock != r11.mMayBlock) goto L21;
        if (this.mUseThreadPool != r11.mUseThreadPool) goto L21;
        if (this.mExtensionId != r11.mExtensionId) goto L21;
        if (Arrays.equals(this.mExtensionData, r11.mExtensionData) == false) goto L21;
        if (this.mIsChoreographerFrame != r11.mIsChoreographerFrame) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> r10) {
        if (this.mExtensionId == r10.getId()) goto L5;
        return null;
    L5:
        return r10.fromSerializedData(this.mExtensionData);
    }

    public boolean hasExtension() {
        if (this.mExtensionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return ((((((((((1147 + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37) + Arrays.hashCode(this.mExtensionData)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits r10 = new TaskTraits(this);
        r10.mMayBlock = true;
        return r10;
    }

    public TaskTraits taskPriority(int r10) {
        TaskTraits r11 = new TaskTraits(this);
        r11.mPriority = r10;
        return r11;
    }

    public TaskTraits threadPool() {
        TaskTraits r10 = new TaskTraits(this);
        r10.mUseThreadPool = true;
        return r10;
    }

    public TaskTraits withExplicitDestination() {
        if (this.mUseThreadPool == false) goto L5;
        return this;
    L5:
        if (hasExtension() == false) goto L7;
        return this;
    L7:
        return threadPool();
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> r10, Extension r11) {
        int r12 = r10.getId();
        byte[] r13 = r10.toSerializedData(r11);
        TaskTraits r14 = new TaskTraits(this);
        r14.mExtensionId = (byte) r12;
        r14.mExtensionData = r13;
        return r14;
    }
}
