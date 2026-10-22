package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/ErrorReason;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ORIENTATION_CHECK", "FIND_CONTAINER_IS_NULL", "NOT_FOUND_CONFIG", "LOCAL_BUTTON_IS_NULL", "BEHAVIOR_IS_NULL", "SHOWING_LIST_EMPTY", "LOW_PRIORITY", "REPLACE_LIST_EMPTY", "REPLACE_LIST_OVER_SIZE", "NOT_FOUND_TOOLBAR_CONFIG", "NOT_FOUND_TOOLBAR_BUTTON", "TOOLBAR_VIEW_IS_SHOWING", "TOOLBAR_BEHAVIOR_IS_NULL", "TOOLBAR_ITEM_VIEW_IS_NULL", "TOOLBAR_ITEM_VIEW_ATTACH_FAILED", "GAMECP_EXTERNAL_BUTTON_IS_NULL", "GAMECP_TOOLBAR_VIEW_PARENT_IS_ALREADY_EXISTS", "REMOVE_GAMECP_TOOLBAR_VIEW_ON_UNLOAD", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorReason extends Enum<ErrorReason> {
    public static final ErrorReason BEHAVIOR_IS_NULL = null;
    public static final ErrorReason FIND_CONTAINER_IS_NULL = null;
    public static final ErrorReason GAMECP_EXTERNAL_BUTTON_IS_NULL = null;
    public static final ErrorReason GAMECP_TOOLBAR_VIEW_PARENT_IS_ALREADY_EXISTS = null;
    public static final ErrorReason LOCAL_BUTTON_IS_NULL = null;
    public static final ErrorReason LOW_PRIORITY = null;
    public static final ErrorReason NOT_FOUND_CONFIG = null;
    public static final ErrorReason NOT_FOUND_TOOLBAR_BUTTON = null;
    public static final ErrorReason NOT_FOUND_TOOLBAR_CONFIG = null;
    public static final ErrorReason ORIENTATION_CHECK = null;
    public static final ErrorReason REMOVE_GAMECP_TOOLBAR_VIEW_ON_UNLOAD = null;
    public static final ErrorReason REPLACE_LIST_EMPTY = null;
    public static final ErrorReason REPLACE_LIST_OVER_SIZE = null;
    public static final ErrorReason SHOWING_LIST_EMPTY = null;
    public static final ErrorReason TOOLBAR_BEHAVIOR_IS_NULL = null;
    public static final ErrorReason TOOLBAR_ITEM_VIEW_ATTACH_FAILED = null;
    public static final ErrorReason TOOLBAR_ITEM_VIEW_IS_NULL = null;
    public static final ErrorReason TOOLBAR_VIEW_IS_SHOWING = null;
    public static final /* synthetic */ ErrorReason[] a = null;
    private final String value;

    public static ErrorReason valueOf(String r1) {
        return (ErrorReason) r27.a.a(ErrorReason.class, r1);
    }

    public static ErrorReason[] values() {
        return (ErrorReason[]) a.clone();
    }

    static {
        ErrorReason r1 = new ErrorReason("ORIENTATION_CHECK", 0, "orientation check");
        ORIENTATION_CHECK = r1;
        ErrorReason r2 = new ErrorReason("FIND_CONTAINER_IS_NULL", 1, "find container is null");
        FIND_CONTAINER_IS_NULL = r2;
        ErrorReason r3 = new ErrorReason("NOT_FOUND_CONFIG", 2, "canload: not found config");
        NOT_FOUND_CONFIG = r3;
        ErrorReason r4 = new ErrorReason("LOCAL_BUTTON_IS_NULL", 3, "canload: local button is null");
        LOCAL_BUTTON_IS_NULL = r4;
        ErrorReason r5 = new ErrorReason("BEHAVIOR_IS_NULL", 4, "canload: behavior is null");
        BEHAVIOR_IS_NULL = r5;
        ErrorReason r6 = new ErrorReason("SHOWING_LIST_EMPTY", 5, "showing list empty");
        SHOWING_LIST_EMPTY = r6;
        ErrorReason r7 = new ErrorReason("LOW_PRIORITY", 6, "low priority");
        LOW_PRIORITY = r7;
        ErrorReason r8 = new ErrorReason("REPLACE_LIST_EMPTY", 7, "replace list empty");
        REPLACE_LIST_EMPTY = r8;
        ErrorReason r9 = new ErrorReason("REPLACE_LIST_OVER_SIZE", 8, "replace list over size");
        REPLACE_LIST_OVER_SIZE = r9;
        ErrorReason r10 = new ErrorReason("NOT_FOUND_TOOLBAR_CONFIG", 9, "not found toolbar config");
        NOT_FOUND_TOOLBAR_CONFIG = r10;
        ErrorReason r11 = new ErrorReason("NOT_FOUND_TOOLBAR_BUTTON", 10, "not found toolbar button");
        NOT_FOUND_TOOLBAR_BUTTON = r11;
        ErrorReason r12 = new ErrorReason("TOOLBAR_VIEW_IS_SHOWING", 11, "toolbar view is showing");
        TOOLBAR_VIEW_IS_SHOWING = r12;
        ErrorReason r13 = new ErrorReason("TOOLBAR_BEHAVIOR_IS_NULL", 12, "toolbar behavior is null");
        TOOLBAR_BEHAVIOR_IS_NULL = r13;
        ErrorReason r14 = new ErrorReason("TOOLBAR_ITEM_VIEW_IS_NULL", 13, "create toolbar item view is null");
        TOOLBAR_ITEM_VIEW_IS_NULL = r14;
        ErrorReason r15 = new ErrorReason("TOOLBAR_ITEM_VIEW_ATTACH_FAILED", 14, "toolbar item view attach failed");
        TOOLBAR_ITEM_VIEW_ATTACH_FAILED = r15;
        ErrorReason r16 = new ErrorReason("GAMECP_EXTERNAL_BUTTON_IS_NULL", 15, "gamecp external button is null");
        GAMECP_EXTERNAL_BUTTON_IS_NULL = r16;
        ErrorReason r17 = new ErrorReason("GAMECP_TOOLBAR_VIEW_PARENT_IS_ALREADY_EXISTS", 16, "gamecp toolbar view parent is already exists");
        GAMECP_TOOLBAR_VIEW_PARENT_IS_ALREADY_EXISTS = r17;
        ErrorReason r18 = new ErrorReason("REMOVE_GAMECP_TOOLBAR_VIEW_ON_UNLOAD", 17, "remove gamecp toolbar view on unload");
        REMOVE_GAMECP_TOOLBAR_VIEW_ON_UNLOAD = r18;
        a = new ErrorReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public final String getValue() {
        return this.value;
    }

    public ErrorReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
