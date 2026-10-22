package com.ss.android.lark.chat.preview.memberlist;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements MemberListAdapter.a {
    public final /* synthetic */ MemberListFragment a;

    public b(MemberListFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.preview.memberlist.MemberListAdapter.a
    public final void a(String r2) {
        g6b.a.InterfaceC0223a r3 = g6b.a.a;
        if (r3 == null) goto L8;
        com.ss.android.lark.officesdk.integrator.im.b r4 = r3.getCoreDependency();
        if (r4 == null) goto L9;
        r4.b(this.a.requireContext());
        return;
    L9:
        return;
    }
}
