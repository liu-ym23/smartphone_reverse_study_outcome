package com.larus.voicecall.impl.component.subtitle;

import android.graphics.Rect;
import android.view.View;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l0 implements com.larus.bmhome.chat.api.d0 {
    public final /* synthetic */ k0 a;

    public final void a(View r1, int r2, int r3) {
    }

    public l0(k0 r1) {
        this.a = r1;
    }

    public final void b(SelectionRangeType r16, int r17, int r18, boolean r19, boolean r20, Rect r21, String r22) {
        Intrinsics.checkNotNullParameter(r16, "rangeType");
        Intrinsics.checkNotNullParameter(r22, "selectedText");
        com.larus.bmhome.chat.api.d0.a.a(r16, NameKeys.UnloadStrategy_No_Strategy);
        if (r19 == false) goto L7;
        if (r20 == false) goto L6;
        String r2 = "drag_select_forward";
    L8:
        String r3 = r2;
        String r10 = r16.getValue();
        k0 r4 = this.a;
        String r11 = r4.h.e;
        Message r5 = r4.e;
        if (r5 == null) goto L11;
        String r6 = r5.getMessageId();
    L12:
        if (r6 != null) goto L14;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        tx9.a0.a(r3, null, r7, null, null, null, "call_subtitle", r10, r11, null, null, 419430267);
        return;
    L14:
        r7 = r6;
        goto L15
    L11:
        r6 = null;
        goto L12
    L6:
        r2 = "drag_select_backward";
        goto L8
    L7:
        r2 = "long_press_answer";
        goto L8
    }
}
