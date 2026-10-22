package com.ss.android.lark.chat.chatwindow.chat.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final boolean a(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3.computeVerticalScrollExtent() + r3.computeVerticalScrollOffset()) >= r3.computeVerticalScrollRange()) goto L6;
        return false;
    L6:
        return true;
    L11:
        return false;
    }
}
