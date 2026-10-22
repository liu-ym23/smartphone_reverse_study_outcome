package edb;

import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(UDIcon r2, RichTextElement.AnchorProperty r3) {
        if (r2 == null) goto L5;
        String r1 = r2.getUnicode();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L24;
        int r5 = a.a;
        if (r2 == null) goto L16;
        String r6 = r2.getKey();
    L17:
        int r7 = a.a(r6);
        if (r7 == 0) goto L30;
        r3.setLocalIconRes(r7);
        r3.setLocalGrayIconRes(r7);
        if (r2 == null) goto L31;
        ThemeColor r8 = r2.getThemeColor();
        if (r8 == null) goto L32;
        r3.setIconColor(com.ss.android.lark.export.entity.preview.a.a(r8, UIHelper.getContext(), null));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L16:
        r6 = null;
        goto L17
    L24:
        if (r2 == null) goto L34;
        String r9 = r2.getUnicode();
        if (r9 == null) goto L35;
        r3.setUnicode(r9);
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r4 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
