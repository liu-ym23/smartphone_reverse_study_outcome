package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final StrangerTagType a(Boolean r0, boolean r1, int r2) {
        if (r0 != null) goto L6;
        Log.e("ChatStrangerRelationVM", "canSetStranger value is null, show no tag!");
        return StrangerTagType.NONE;
    L6:
        if (r0.booleanValue() == true) goto L10;
        if (r1 == false) goto L18;
        return StrangerTagType.BLOCK;
    L18:
        return StrangerTagType.NONE;
    L10:
        if (r1 == false) goto L13;
        return StrangerTagType.TOTAL_BLOCK;
    L13:
        if (r2 != 2) goto L16;
        return StrangerTagType.STRANGER;
    L16:
        return StrangerTagType.NONE;
    }
}
