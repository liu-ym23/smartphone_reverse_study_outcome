package com.larksuite.component.card.component.personlist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ PersonListLynxUI a;

    public d(PersonListLynxUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r7) {
        final com.larksuite.component.card.cardcontainer.c r8 = (com.larksuite.component.card.cardcontainer.c) this.a.getLynxContext().getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
        boolean r0 = false;
        if (r8 == null) goto L15;
        PersonListLynxUI r1 = this.a;
        final PersonListTextView r2 = (PersonListTextView) PersonListLynxUI.M(r1);
        if ((r8.getContext() instanceof Activity) == false) goto L11;
        int r3 = com.larksuite.component.card.utils.c.a;
        if ((!u.a.a.e) == false) goto L11;
        if (r8.c.getDependency().canCopy() == false) goto L11;
        Context r4 = r8.c.getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        com.larksuite.component.card.utils.c.b(r2, (Activity) r4, new PersonListLynxUI$enableCopy$1(r8), new PersonListLynxUI$enableCopy$2(r8, r2));
        r0 = true;
    L11:
        if (r0 == false) goto L14;
        return true;
    L14:
        return r8.c.getDependency().onLongClicked(PersonListLynxUI.M(r1));
    L15:
        return false;
    }
}
