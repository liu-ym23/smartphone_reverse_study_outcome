package com.obric.assistant.chat;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.logger.FLogger;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ ObricChatUIServiceImpl a;
    public final /* synthetic */ ChatConstraintLayout b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ d0(ObricChatUIServiceImpl r1, ChatConstraintLayout r2) {
        this.a = r1;
        this.b = r2;
        this.c = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricChatUIServiceImpl r0 = this.a;
        ChatConstraintLayout r1 = this.b;
        boolean r2 = this.c;
        Set r3 = ObricChatUIServiceImpl.g;
        r0.getClass();
        FragmentActivity r4 = ObricChatUIServiceImpl.S(r1.getContext());
        if (r2 == false) goto L9;
        if (r4 == null) goto L6;
        int r5 = com.larus.utils.u.b(r4);
    L7:
        if (r5 <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        int r7 = 0;
    L13:
        int r8 = r1.getBottomPadding();
        if (r7 > 0) goto L22;
        if (r1.getDisableBottomPadding() == true) goto L18;
    L20:
        FLogger.a.i("ObricChatUIServiceImpl", "applyOverlayRootBottomPadding reset to 0, paddingBottom=" + r1.getPaddingBottom() + ", cache=" + r8);
        r1.setDisableBottomPadding(true);
        r1.C6(0, "doc_post_fix_reset");
        return;
    L18:
        if (r1.getPaddingBottom() > 0) goto L20;
        if (r8 > 0) goto L20;
        return;
    L22:
        if (r1.getDisableBottomPadding() == false) goto L24;
    L27:
        FLogger.a.i("ObricChatUIServiceImpl", "applyOverlayRootBottomPadding safeBottom=" + r7 + ", paddingBottom=" + r1.getPaddingBottom() + ", cache=" + r8);
        r1.setDisableBottomPadding(false);
        r1.C6(r7, "doc_post_fix");
        return;
    L24:
        if (r1.getPaddingBottom() < r7) goto L27;
        if (r8 < r7) goto L27;
        return;
    L12:
        r7 = ObricChatUIServiceImpl.R(r4, ViewCompat.getRootWindowInsets(r1));
        goto L13
    L6:
        r5 = 0;
    L9:
        r6 = false;
        goto L10
    }
}
