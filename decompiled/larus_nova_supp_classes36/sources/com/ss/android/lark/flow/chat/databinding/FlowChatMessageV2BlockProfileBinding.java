package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.flow.chat.view.MaxWidthConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatMessageV2BlockProfileBinding implements ViewBinding {
    public final MaxWidthConstraintLayout a;
    public final LarkAvatarView b;
    public final TextView c;
    public final View d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public FlowChatMessageV2BlockProfileBinding(MaxWidthConstraintLayout r1, LarkAvatarView r2, TextView r3, View r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
