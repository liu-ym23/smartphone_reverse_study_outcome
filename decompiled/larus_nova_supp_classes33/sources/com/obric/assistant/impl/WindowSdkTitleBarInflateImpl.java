package com.obric.assistant.impl;

import android.content.Context;
import com.larus.bmhome.chat.i4;
import com.larus.platform.api.ISdkTitleBarInflate;
import com.larus.platform.api.g0;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.view.ObricChatTitleAlignLeftStyle;
import com.obric.assistant.view.WindowChatTitleAlignLeftStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/impl/WindowSdkTitleBarInflateImpl;", "Lcom/larus/platform/api/ISdkTitleBarInflate;", "<init>", "()V", "inflate", "Lcom/larus/platform/api/IChatTitle;", "context", "Landroid/content/Context;", "eventType", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowSdkTitleBarInflateImpl implements ISdkTitleBarInflate {
    public WindowSdkTitleBarInflateImpl() {
    }

    public final g0 a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eventType");
        if ((r2 instanceof i4) == false) goto L7;
        return null;
    L7:
        if (IWindowContextKt.isWindowContext(r2) == false) goto L10;
        return new WindowChatTitleAlignLeftStyle(r2);
    L10:
        return new ObricChatTitleAlignLeftStyle(r2);
    }
}
