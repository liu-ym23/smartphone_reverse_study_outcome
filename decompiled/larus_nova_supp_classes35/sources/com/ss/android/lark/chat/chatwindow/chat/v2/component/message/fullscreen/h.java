package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements OnApplyWindowInsetsListener {
    public final /* synthetic */ MessageFullScreenFragment a;

    public h(MessageFullScreenFragment r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "insets");
        Insets r0 = r6.getInsets(WindowInsetsCompat.Type.systemBars());
        r5.setPadding(r0.left, 0, r0.right, UIUtils.dp2px(this.a.requireContext(), 6.0f));
        return r6;
    }
}
