package yvb;

import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.PrefixSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final void a(PrefixSpan.b r3) {
        if (r3.g.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r3.d = 0.0f;
        return;
    L9:
        if (r3.getType() != PrefixSpan.Type.LIST_NUM) goto L17;
        int r1 = r3.g.length();
        if (r1 != 2) goto L13;
        r3.d = UIHelper.dp2px(14.0f);
        return;
    L13:
        if (r1 == 3) goto L15;
        r3.d = fec.b.d(r3.g, UIHelper.getDimens(2131167738));
        return;
    L15:
        r3.d = UIHelper.dp2px(24.0f);
        return;
    L17:
        r3.d = fec.b.d(r3.g, UIHelper.getDimens(2131167738));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
