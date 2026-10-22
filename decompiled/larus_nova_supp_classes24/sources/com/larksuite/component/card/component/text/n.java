package com.larksuite.component.card.component.text;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements View.OnLongClickListener {
    public final /* synthetic */ UniversalCardTextLynxUI a;
    public final /* synthetic */ LKUILightTextView b;

    public n(UniversalCardTextLynxUI r1, LKUILightTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r11) {
        UniversalCardTextLynxUI r12 = this.a;
        int r0 = UniversalCardTextLynxUI.g;
        com.larksuite.component.card.cardcontainer.c r13 = r12.O();
        if (r13 == null) goto L9;
        CardData r2 = r13.b;
        if (r2 == null) goto L9;
        if (r2.isStreamingMode() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return true;
    L12:
        UniversalCardTextLynxUI r4 = this.a;
        final LKUILightTextView r5 = this.b;
        final com.larksuite.component.card.cardcontainer.c r6 = r4.O();
        Context r7 = null;
        if (Intrinsics.areEqual((Boolean) r4.getLynxContext().getSharedData("in_detail"), Boolean.TRUE) == false) goto L23;
        Log.e("UniversalCardTextLynxUI", "share data error");
        com.ss.android.lark.widget.select.m r8 = (com.ss.android.lark.widget.select.m) r4.getLynxContext().getSharedData("copy_view");
        if (r8 == null) goto L20;
        r8.a();
        r8.d.getViewTreeObserver().removeOnScrollChangedListener(r8.r);
        r8.h();
        com.ss.android.lark.widget.select.r r9 = r8.o;
        if (r9 == null) goto L19;
        r9.release();
        r8.o = null;
    L19:
        r8.p = null;
    L20:
        com.ss.android.lark.widget.select.m.a r10 = new com.ss.android.lark.widget.select.m.a(new com.ss.android.lark.widget.select.b(r5), Contexts.requireActivity(r4.getLynxContext()));
        r10.c = UIUtils.getColor(r4.getLynxContext().getContext(), 2131105548);
        r10.d = UIUtils.dp2px(r4.getLynxContext().getContext(), 17.0f);
        com.ss.android.lark.widget.select.m r14 = new com.ss.android.lark.widget.select.m(r10);
        r4.b = r14;
        r14.m = new j(r4);
        r4.getLynxContext().putSharedData("copy_view", r4.b);
        com.ss.android.lark.widget.select.m r15 = r4.b;
        if (r15 == null) goto L32;
        r15.show();
    L32:
        boolean r16 = true;
    L34:
        if (r16 == false) goto L36;
        return true;
    L36:
        if (r13 == null) goto L43;
        CardContext r17 = r13.c;
        if (r17 == null) goto L44;
        ICardDependency r19 = r17.getDependency();
        if (r19 != null) goto L42;
        return false;
    L42:
        return r19.onLongClicked(this.b);
    L44:
        return false;
    L43:
        return false;
    L23:
        if (r6 == null) goto L26;
        r7 = r6.getContext();
    L26:
        if ((r7 instanceof Activity) == false) goto L33;
        int r20 = com.larksuite.component.card.utils.c.a;
        if ((!com.ss.android.lark.chat.utils.u.a.a.e) == false) goto L33;
        if (r6.c.getDependency().canCopy() == false) goto L33;
        Context r21 = r6.c.getContext();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.app.Activity");
        Function1<CharSequence, Unit> r22 = new UniversalCardTextLynxUI$enableCopy$3(r6);
        Function0<Unit> r23 = new UniversalCardTextLynxUI$enableCopy$4(r6, r5);
        Intrinsics.checkNotNullParameter(r5, "textView");
        Intrinsics.checkNotNullParameter(r22, "changeCopyAction");
        Intrinsics.checkNotNullParameter(r23, "onTextSelectedAction");
        r5.setSelectedColor(j08.b.c(r5.getContext(), 2131105548, 0.2f));
        com.ss.android.lark.widget.select.m.a r24 = new com.ss.android.lark.widget.select.m.a(new com.ss.android.lark.widget.select.b(r5), (Activity) r21);
        r24.c = UIUtils.getColor(r5.getContext(), 2131105548);
        r24.d = UIHelper.dp2px(15.0f);
        j08.b.c(r5.getContext(), 2131105548, 0.2f);
        com.ss.android.lark.widget.select.m r25 = new com.ss.android.lark.widget.select.m(r24);
        Intrinsics.checkNotNull(r25);
        com.larksuite.component.card.utils.c.a(r5, r25, r22, r23);
    L33:
        r16 = false;
    L9:
        r3 = false;
        goto L10
    }
}
