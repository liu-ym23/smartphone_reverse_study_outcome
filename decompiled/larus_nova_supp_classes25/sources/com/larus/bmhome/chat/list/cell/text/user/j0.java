package com.larus.bmhome.chat.list.cell.text.user;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.layout.widget.w0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.v2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 extends w0 {
    public final /* synthetic */ UserTextCell c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ TextView f;
    public final /* synthetic */ boolean g;

    @Override // com.larus.bmhome.chat.layout.widget.w0, android.text.style.ClickableSpan
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        this.c.r.e();
        Regex r0 = com.larus.bmhome.chat.markdown.richtext.n.a;
        if (com.larus.bmhome.chat.markdown.richtext.n.g(this.d) == false) goto L6;
        t19.s r1 = t19.s.a;
        Context r7 = r6.getContext();
        r1.getClass();
        t19.s.s(r7, 2131911210);
        return;
    L6:
        String r2 = this.e;
        if (r2 == null) goto L10;
        this.c.M(r2);
    L10:
        if (y0.e(this.d) == false) goto L12;
        String r3 = this.d;
    L13:
        FLogger r4 = FLogger.a;
        int r5 = UserTextCell.z;
        r4.d("UserTextCell", "clickableSpan: url = " + this.d + ", finalUrl = " + r3);
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L16;
        v2 r9 = r8.Y();
    L17:
        if (r9 == null) goto L21;
        boolean r10 = true;
        if (r9.a(UriProtector.parse(r3)) != true) goto L21;
    L22:
        if (r10 == false) goto L24;
        return;
    L24:
        com.larus.platform.service.q r11 = com.larus.platform.service.q.a;
        Context r12 = r6.getContext();
        Bundle r13 = new Bundle();
        r13.putString("link_url", r3);
        r13.putString("show_closeall", "1");
        Unit r14 = Unit.INSTANCE;
        r11.e(r12, r13, null);
        return;
    L21:
        r10 = false;
        goto L22
    L16:
        r9 = null;
        goto L17
    L12:
        r3 = "https://" + this.d;
        goto L13
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        Context r0 = this.f.getContext();
        if (r0 == null) goto L12;
        boolean r1 = this.g;
        String r2 = this.d;
        r5.linkColor = ContextCompat.getColor(r0, 2131103298);
        if (r1 == false) goto L9;
        Regex r3 = com.larus.bmhome.chat.markdown.richtext.n.a;
        if (com.larus.bmhome.chat.markdown.richtext.n.g(r2) == true) goto L9;
        boolean r4 = true;
    L10:
        r5.setUnderlineText(r4);
        return;
    L9:
        r4 = false;
        goto L10
    }

    public j0(View.OnClickListener r1, View.OnLongClickListener r2, UserTextCell r3, String r4, String r5, TextView r6, boolean r7) {
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        super(r1, r2);
    }
}
