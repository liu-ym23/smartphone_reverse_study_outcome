package com.obric.assistant.chat;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.debug.IChatDebugExtItem;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.agent.ObricAgentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatDebugExtItemImpl;", "Lcom/larus/bmhome/debug/IChatDebugExtItem;", "<init>", "()V", "priority", NameKeys.UnloadStrategy_No_Strategy, "supplyItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "messageId", NameKeys.UnloadStrategy_No_Strategy, "supplyItemGroup", "Landroid/widget/LinearLayout;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatDebugExtItemImpl implements IChatDebugExtItem {
    public ObricChatDebugExtItemImpl() {
    }

    public final void priority() {
    }

    public final LinearLayout a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        return ObricAgentService.a.b(r2, r3);
    }

    public final AppCompatTextView b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        return ObricAgentService.a.c(r2, r3);
    }
}
