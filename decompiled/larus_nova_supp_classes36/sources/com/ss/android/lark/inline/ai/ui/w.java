package com.ss.android.lark.inline.ai.ui;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.Input;
import com.ss.android.lark.inline.ai.api.ui.ParamDetail;
import com.ss.android.lark.inline.ai.api.ui.ParamResultDetail;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import com.ss.android.lark.inline.ai.api.ui.TextResultContentList;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ InlineAIPanelController a;

    public w(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        InlineAIPanelController.g r15 = this.a.T;
        r15.c.e.removeCallbacks(r15.b);
        Object r16 = this.a.D.getEditTextContent();
        InlineAIPanelController r0 = this.a;
        r0.getClass();
        boolean r2 = false;
        if ((r16 instanceof String) == true) goto L5;
    L46:
        if (r2 == false) goto L48;
        return;
    L48:
        this.a.b.h(r16);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) r16) == false) goto L46;
        InlineAIPanel r1 = r0.O;
        if (r1 == null) goto L13;
        Input r3 = r1.getInput();
        if (r3 == null) goto L13;
        if (r3.getPlacehoderSelected() != true) goto L13;
        r2 = true;
    L13:
        InlineAIPanel r4 = r0.O;
        if (r4 == null) goto L18;
        Input r5 = r4.getInput();
        if (r5 == null) goto L18;
        TextContentList r6 = r5.getTextContentList();
    L19:
        InlineAIPanel r7 = r0.O;
        if (r7 == null) goto L24;
        Input r8 = r7.getInput();
        if (r8 == null) goto L24;
        Prompt r9 = r8.getRecentPrompt();
    L25:
        if (r9 == null) goto L33;
        InlineAIPanel r10 = r0.O;
        if (r10 == null) goto L45;
        Input r11 = r10.getInput();
        if (r11 == null) goto L45;
        Prompt r12 = r11.getRecentPrompt();
        if (r12 == null) goto L45;
        r0.b.q(r12);
    L45:
        r2 = true;
        goto L46
    L33:
        if (r2 == false) goto L45;
        if (r6 == null) goto L44;
        wlb.e r13 = r0.b;
        int r17 = e0.a;
        Intrinsics.checkNotNullParameter(r6, "textContentList");
        TextResultContentList r18 = new TextResultContentList(null, 1, null);
        r18.setDisplayName(r6.getDisplayName());
        r18.setParamDetails(new ArrayList());
        ArrayList<ParamDetail> r19 = r6.getParamDetails();
        if (r19 == null) goto L43;
        Iterator<ParamDetail> r20 = r19.iterator();
    L39:
        if (r20.hasNext() == false) goto L43;
        ParamDetail r21 = r20.next();
        String r110 = r21.getName() + r21.getPlaceHolder();
        ArrayList<ParamResultDetail> r22 = r18.getParamDetails();
        if (r22 == null) goto L39;
        r22.add(new ParamResultDetail(r21.getKey(), r21.getName(), r21.getPlaceHolder(), r110, r110));
    L43:
        Log.d("DataConverter", "getEditTextContent result list = " + r18);
        r13.h(r18);
        goto L45
    L44:
        r0.b.h(r0.D.getHint());
    L24:
        r9 = null;
    L18:
        r6 = null;
        goto L19
    }
}
