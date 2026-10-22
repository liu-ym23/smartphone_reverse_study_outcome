package com.larksuite.component.card.component.personlist.detail;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements PersonListAdapter.b {
    public final /* synthetic */ PersonListFragment a;

    public a(PersonListFragment r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.card.component.personlist.detail.PersonListAdapter.b
    public final void a(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L10:
        if (r0 == false) goto L12;
        Log.e(PersonListFragment.S90(this.a), "item click error, userId is empty");
    L12:
        yy7.a r1 = ty7.a.a();
        if (r1 == null) goto L16;
        r1.showProfile(this.a.requireContext(), r4);
        return;
    L16:
        return;
    L5:
        if (r4.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L10;
        r0 = true;
        goto L10
    L7:
        r2 = false;
        goto L8
    }
}
