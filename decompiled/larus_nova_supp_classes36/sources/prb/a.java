package prb;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import idb.f;
import kotlin.jvm.internal.Intrinsics;
import v5b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c(r5b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "chatContext");
        if (r1.Y() == false) goto L5;
    L11:
        return false;
    L5:
        if (r1.q() == true) goto L11;
        if (r1.r() == true) goto L11;
        if (r1.m() == true) goto L11;
        return true;
    }

    public static void a(Context r4, View r5) {
        BubbleStyle.a(12, r5, new int[]{UIUtils.dp2px(r4, 0.0f), UIUtils.dp2px(r4, 12.0f), UIUtils.dp2px(r4, 12.0f), UIUtils.dp2px(r4, 12.0f)});
    }

    public static BubbleStyle b(Context r7, c r8, r5b.a r9) {
        Intrinsics.checkNotNullParameter(r8, "messageVO");
        Intrinsics.checkNotNullParameter(r9, "chatContext");
        int[] r1 = {UIUtils.dp2px(r7, 12.0f), UIUtils.dp2px(r7, 12.0f), UIUtils.dp2px(r7, 12.0f), UIUtils.dp2px(r7, 12.0f)};
        if (r8.h() == true) goto L7;
        BubbleStyle.a(1, null, r1);
        return BubbleStyle.h;
    L7:
        if (r8.d() == true) goto L10;
        BubbleStyle.a(0, null, r1);
        return BubbleStyle.h;
    L10:
        Intrinsics.checkNotNullParameter(r9, "chatContext");
        if (f.a().isEnable("im.message.thread_reply_bubble_optimize") == true) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L18;
        BubbleStyle.a(0, null, r1);
        BubbleStyle r11 = BubbleStyle.h;
        Intrinsics.checkNotNull(r11);
        return r11;
    L18:
        BubbleStyle.a(1, null, r1);
        BubbleStyle r12 = BubbleStyle.h;
        Intrinsics.checkNotNull(r12);
        return r12;
    L13:
        if (c(r9) == false) goto L15;
        r10 = true;
        goto L16
    }
}
