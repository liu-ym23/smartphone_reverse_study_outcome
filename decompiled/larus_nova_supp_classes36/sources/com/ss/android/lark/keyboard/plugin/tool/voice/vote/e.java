package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.view.View;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ai_engine.FeedsbackData;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ UDButton b;

    public e(d r1, UDButton r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        UDButton r7 = this.a.f;
        if (r7 == null) goto L5;
        r7.setBackgroundColor(UDColorUtils.getColor(this.b.getContext(), 2131105549));
    L5:
        this.b.setEnabled(false);
        UDButton r8 = this.a.f;
        if (r8 == null) goto L8;
        com.larksuite.component.universe_design.button.d r0 = new com.larksuite.component.universe_design.button.d();
        r0.k = 2131105560;
        ((com.larksuite.component.universe_design.button.a) r0).a = 2131892934;
        com.larksuite.component.universe_design.button.e.g(r8, r0);
    L8:
        ArrayList r9 = new ArrayList();
        ArrayList r1 = new ArrayList();
        List<DownVoteReasonAdapter.b> r2 = this.a.h.b;
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((ArrayList) r2).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (((DownVoteReasonAdapter.b) r5).c == false) goto L10;
        r3.add(r5);
        goto L10
    L14:
        Iterator r10 = r3.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        DownVoteReasonAdapter.b r11 = (DownVoteReasonAdapter.b) r10.next();
        r9.add(r11.a);
        r1.add(r11.b);
        goto L16
    L18:
        SCAppCompatEditText r12 = this.a.i.a;
        if (r12 == null) goto L21;
        String r13 = String.valueOf(r12.getText());
    L22:
        String r14 = StringsKt.trim(r13).toString();
        FeedsbackData r15 = new FeedsbackData.Builder().like(Boolean.FALSE).reason_id(r9).extra(r14).build();
        d r16 = this.a;
        osb.e r17 = r16.b;
        UDButton r18 = r16.f;
        Intrinsics.checkNotNull(r15);
        r17.a(r18, r15, r1);
        return;
    L21:
        Log.i("DownVoteInputAdapter", "EditText is null");
        r13 = "";
        goto L22
    }
}
