package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageSecondChatListBinding implements ViewBinding {
    public final LinearLayout a;
    public final ChatConversationList b;
    public final LinearLayout c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageSecondChatListBinding(LinearLayout r1, ChatConversationList r2, LinearLayout r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
