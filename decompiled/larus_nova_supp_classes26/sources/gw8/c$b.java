package gw8;

import android.content.Context;
import com.larus.bmhome.chat.list.cell.text.components.middle.x;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import lw8.h;
import lw8.l;
import vg8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c$b {
    public static /* synthetic */ l b(c r6, ow8.a r7, String r8, boolean r9, lw8.d r10) {
        return r6.createMarkdownContent(r7, r8, r9, r10, null);
    }

    public static /* synthetic */ l a(c r11, Context r12, int r13, String r14, boolean r15, lw8.d r16, h r17, CharSequence r18, int r19) {
        if ((r19 & 32) == 0) goto L5;
        h r8 = null;
    L7:
        if ((r19 & 64) == 0) goto L9;
        CharSequence r9 = null;
    L11:
        return r11.createMarkdownContent(r12, r13, r14, r15, r16, r8, r9, null);
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public static /* synthetic */ uvc.b c(c r10, Context r11, String r12, boolean r13, lw8.d r14, MarkwonStruct r15, f r16, x r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        lw8.d r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        MarkwonStruct r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        f r8 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        x r9 = null;
    L19:
        return r10.createMarkdownNode(r11, r12, r13, r6, r7, r8, r9);
    L17:
        r9 = r17;
        goto L19
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
