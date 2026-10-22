package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/ComponentOperate;", "", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ComponentOperate {
    public static final int AddToMoreRemoveFromToolbar = 2;
    public static final int AddToToolbarRemoveFromMore = 1;
    public static final int AnchorSwitchComponent = 6;
    public static final a Companion = null;
    public static final int InitMorePanelData = 101;
    public static final int InitToolbarData = 100;
    public static final int Invalid = 0;
    public static final int RefreshComponent = 7;
    public static final int RemoveAll = 4;
    public static final int RemoveFromToolbar = 3;
    public static final int Update = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }
}
