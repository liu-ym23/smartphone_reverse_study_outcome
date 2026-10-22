package com.bytedance.android.live.emoji.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.GradientEditText;
import f06.b;
import f06.c;
import f06.d;
import jc1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EmojiEditView extends GradientEditText {
    public int c;

    public EmojiEditView(Context r1) {
        super(r1);
        this.c = LiveResUtil.dp2Px(16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTextContextMenuItem(int r17) {
        if (r17 != 16908322) goto L16;
        ClipboardManager r0 = (ClipboardManager) a.b().getSystemService("clipboard");
        c r11 = new c();
        Object[] r12 = new Object[0];
        b r13 = new b();
        d r14 = r11.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r0, r12, "android.content.ClipData", r13);
        if (r14.a == false) goto L7;
        r11.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r0, r12, null, r13, false);
        ClipData r1 = (ClipData) r14.b;
    L8:
        if (r1 == null) goto L16;
        if (r1.getItemAt(0) == null) goto L16;
        if (r1.getItemAt(0).getText() == null) goto L16;
        String r2 = r1.getItemAt(0).getText().toString();
        getText().insert(getSelectionStart(), r90.a.a().c(r2, this.c, false));
        return true;
    L7:
        ClipData r15 = r0.getPrimaryClip();
        r11.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r0, r12, r15, r13, true);
        r1 = r15;
    L16:
        return super.onTextContextMenuItem(r17);
    }

    public void setTextEmojiSize(int r1) {
        this.c = r1;
    }

    public EmojiEditView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = LiveResUtil.dp2Px(16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r4, TextView.BufferType r5) {
        super/*android.widget.EditText*/.setText(r90.a.a().c(r4, this.c, false), r5);
    }

    public EmojiEditView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = LiveResUtil.dp2Px(16.0f);
    }
}
