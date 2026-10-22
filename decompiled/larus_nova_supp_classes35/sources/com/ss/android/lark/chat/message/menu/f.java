package com.ss.android.lark.chat.message.menu;

import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnTouchListener {
    public final /* synthetic */ LKUILightTextView a;
    public final /* synthetic */ MessageLongPressTextSelectHelper.b b;

    public f(LKUILightTextView r1, MessageLongPressTextSelectHelper.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "event");
        int r7 = r6.getActionMasked();
        if (r7 == 0) goto L9;
        if (r7 != 1) goto L6;
    L8:
        this.b.c = false;
    L10:
        return false;
    L6:
        if (r7 == 3) goto L8;
    L9:
        this.a.setTag(2131388122, null);
        this.a.setTag(2131388120, null);
        this.a.setTag(2131388121, null);
        MessageLongPressTextSelectHelper.b r8 = this.b;
        r8.a = r6.getX();
        MessageLongPressTextSelectHelper.b r9 = this.b;
        r9.b = r6.getY();
        this.b.c = true;
        goto L10
    }
}
