package sdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;

    static {
        a = b.g(UIHelper.getContext(), 16);
        b = (int) b.h(UIHelper.getContext(), 14);
        c = 2;
    }

    @JvmStatic
    public static final void a(Context r8, SpannableStringBuilder r9, String r10, String r11, IGetDataCallback<Boolean> r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "emojiKey");
        if (r8 == null) goto L18;
        Drawable r3 = EmojiHandler.c(r10, r12, r12);
        String r14 = qsb.b.a().df(r10);
        if (r14.length() <= 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        StringBuilder r15 = new StringBuilder("[");
        r15.append(r14);
    L13:
        r15.append(']');
        r11 = r15.toString();
    L14:
        int r16 = r9.length();
        r9.append(r11);
        if (r3 == null) goto L19;
        r9.setSpan(new com.ss.android.lark.widget.linked_emojicon.base.a(r8, r3, r10, r13, c, b), r16, r9.length(), 17);
        return;
    L19:
        return;
    L11:
        if (r11 != null) goto L14;
        r15 = new StringBuilder("[");
        r15.append(r10);
        goto L13
    L7:
        r0 = false;
        goto L9
    }
}
