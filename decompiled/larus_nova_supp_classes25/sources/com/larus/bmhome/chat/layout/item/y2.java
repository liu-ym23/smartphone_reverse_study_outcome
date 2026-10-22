package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y2 extends c6 {
    public final /* synthetic */ Context c;
    public final /* synthetic */ PromptSpan d;

    public final void a(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("chat.message.PROMPT_SPAN_CLICK"));
        int r0 = gx9.o.a;
        Intrinsics.checkNotNullParameter("other", "originalSource");
        Intrinsics.checkNotNullParameter("", "messageId");
        IAIChatControlTraceService.a.Ab("other", "");
        if ((r6 instanceof LinearLayout) == false) goto L13;
        if (((ViewGroup) r6).getChildCount() == 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L13;
        View r2 = ((LinearLayout) r6).getChildAt(0);
        if ((r2 instanceof TextView) == false) goto L15;
        TextView r3 = (TextView) r2;
    L16:
        if (r3 != null) goto L18;
        return;
    L18:
        FLogger.a.d("WcbSugPromptSpan", "doClick, content:" + g2a.d.b(r3.getText()) + ", pos:" + r3.getTag());
        Object r7 = r6.getTag(2131387708);
        if ((r7 instanceof PromptContent.SuggestV2) == false) goto L21;
        PromptContent.SuggestV2 r8 = (PromptContent.SuggestV2) r7;
    L22:
        Function4<? super View, ? super PromptContent.SuggestV2, ? super PromptContent.SuggestItem, ? super PromptContent.SuggestV2ExtraForMultiAction, Unit> r4 = this.d.E;
        if (r4 == null) goto L26;
        r4.invoke(r3, r8, null, null);
        return;
    L26:
        return;
    L21:
        r8 = null;
    L15:
        r3 = null;
        goto L16
    L7:
        r1 = false;
    L13:
        if ((r6 instanceof TextView) == false) goto L15;
        r3 = (TextView) r6;
        goto L16
    }

    public y2(Context r1, PromptSpan r2) {
        this.c = r1;
        this.d = r2;
    }
}
