package c3b;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Layout a(RichText r3, Context r4, boolean r5, List<String> r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        r0.h = false;
        r0.m = false;
        r0.c = false;
        Layout.Alignment r1 = Layout.Alignment.ALIGN_NORMAL;
        Intrinsics.checkNotNullParameter(r1, "alignment");
        r0.v = r1;
        r0.d = r5;
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.a = r6;
    L5:
        if (r7 == null) goto L7;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.b = r7;
    L7:
        int r8 = TextLayoutRender.j;
        return TextLayoutRenderExtKt.e(w2b.b.d, r3, r0, r4);
    }
}
