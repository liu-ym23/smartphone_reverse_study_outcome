package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.v2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y0 extends com.larus.bmhome.chat.layout.widget.w0 {
    public final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.g c;
    public final /* synthetic */ boolean d;

    @Override // com.larus.bmhome.chat.layout.widget.w0, android.text.style.ClickableSpan
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        if (com.larus.utils.y0.e(this.c.c) == false) goto L5;
        String r0 = this.c.c;
    L6:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        v2 r2 = r1.Y();
    L10:
        if (r2 == null) goto L14;
        boolean r3 = true;
        if (r2.a(UriProtector.parse(r0)) != true) goto L14;
    L15:
        if (r3 == false) goto L17;
        return;
    L17:
        com.larus.platform.service.q r4 = com.larus.platform.service.q.a;
        Context r7 = r6.getContext();
        Bundle r5 = new Bundle();
        r5.putString("link_url", r0);
        Unit r8 = Unit.INSTANCE;
        r4.e(r7, r5, null);
        return;
    L14:
        r3 = false;
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = "https://" + this.c.c;
        goto L6
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.linkColor = -16750849;
        r2.setColor(-16750849);
        r2.setUnderlineText(this.d);
    }

    public y0(com.larus.bmhome.chat.markdown.richtext.g r1, boolean r2) {
        this.c = r1;
        this.d = r2;
        super(null, null);
    }
}
