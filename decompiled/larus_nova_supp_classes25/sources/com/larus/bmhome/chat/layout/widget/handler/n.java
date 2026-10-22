package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.Logger;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.c0;
import com.larus.bmhome.utils.t2;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements pw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ uvc.b b;
    public final /* synthetic */ o c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.bmhome.chat.layout.widget.handler.m] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.larus.bmhome.chat.layout.widget.handler.l] */
    public final void a(ViewGroup r56) {
        Intrinsics.checkNotNullParameter(r56, "parent");
        final c0 r3 = ILegacyChatUiServiceDelegate.b.s8(this.a);
        HtmlBlock r0 = this.b;
        xc8.h r5 = null;
        if ((r0 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r1 = r0;
    L6:
        if (r1 == null) goto L29;
        final o r4 = this.c;
        final Context r6 = this.a;
        String r2 = r1.h;
        r4.getClass();
        if (r2 != null) goto L50;
    L20:
        final Message r7 = null;
    L21:
        if (r7 == null) goto L29;
        if (r3 == 0) goto L24;
        r3.g(r7);
    L24:
        if (r3 == 0) goto L26;
        r3.c(new l(r4));
    L26:
        if (r3 == 0) goto L29;
        r3.f(new m(r4, r6, r3, r7));
        goto L29
    L50:
        int r8 = t2.a;     // Catch: Exception -> L18
        String r9 = t2.a(r4.a.getMessageId(), r2);     // Catch: Exception -> L18
        if (r9 == null) goto L20;
        if (o0.d(r9) == false) goto L16;
        JSONArray r10 = new JSONObject(r9).optJSONArray("videos");     // Catch: Exception -> L18
        if (r10 == null) goto L16;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L18
        r11.put("has_more", "false");     // Catch: Exception -> L18
        r11.put("search_result", new JSONObject().put("video_card", new JSONObject().put("card_list", r10)));     // Catch: Exception -> L18
        String r20 = r11.toString();     // Catch: Exception -> L18
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Exception -> L18
        r12.put("video_as_ref", "1");     // Catch: Exception -> L18
        r12.put("is_from_deep_search", "1");     // Catch: Exception -> L18
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L18
        r7 = new Message(null, null, null, 0, 0, null, 0, false, null, r20, null, null, null, r12, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8705, 31, null);     // Catch: Exception -> L18
    L16:
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Logger.e("SingleRowVideoWidgetHandler", "e : " + e);
        Unit r15 = Unit.INSTANCE;
    L29:
        if ((r3 instanceof ViewGroup) == false) goto L31;
        ViewGroup r16 = (ViewGroup) r3;
    L32:
        if (r16 == null) goto L49;
        Context r17 = this.a;
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if (r18 == null) goto L48;
        r18.width = -1;
        r18.height = -2;
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
    L39:
        if (r19 == null) goto L42;
        r19.topMargin = i5.Q();
    L42:
        if ((r3 instanceof xc8.h) == false) goto L44;
        r5 = (xc8.h) r3;
    L44:
        if (r5 == null) goto L46;
        Resources r21 = r17.getResources();
        r5.setMaxWidth(WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()).widthPixels);
    L46:
        r16.setLayoutParams(r18);
        r56.addView((View) r3);
        return;
    L38:
        r19 = null;
        goto L39
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L49:
        return;
    L31:
        r16 = null;
        goto L32
    L5:
        r1 = null;
        goto L6
    }

    public final void b(int r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "currentViewGroup");
    }

    public n(Context r1, uvc.b r2, o r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
