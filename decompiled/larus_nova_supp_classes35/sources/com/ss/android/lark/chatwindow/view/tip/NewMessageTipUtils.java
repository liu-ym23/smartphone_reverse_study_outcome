package com.ss.android.lark.chatwindow.view.tip;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewMessageTipUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(List r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, NewMessageTipUtils$logMessageIds$1.INSTANCE, 30, null);
    }
}
