package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f0 extends ClickableSpan {
    public final /* synthetic */ b0 a;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public f0(b0 r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Activity r5 = ViewUtils.getActivityByView(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(r5);
        r0.c.cancelOnTouchOutside(false);
        r0.j(2131892794);
        r0.c.titleBold(true);
        r0.c.message(2131892792);
        r0.b(2131378550, UIHelper.getString(2131892793), new a());
        r0.i();
        this.a.getClass();
        Statistics.sendEvent("invite_people_external_privacy", InvHitPoint.b(null));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        r2.setColor(UIHelper.getColor(2131103404));
        r2.setUnderlineText(false);
    }
}
