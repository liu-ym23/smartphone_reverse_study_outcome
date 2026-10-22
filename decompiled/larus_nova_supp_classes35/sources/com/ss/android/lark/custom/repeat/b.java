package com.ss.android.lark.custom.repeat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements oab.f {
    public final /* synthetic */ ChooseCustomRepeatFragment a;

    public b(ChooseCustomRepeatFragment r1) {
        this.a = r1;
    }

    @Override // oab.f
    public final void onItemSelected(int r3) {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        if (this.a.getActivity() == null) goto L10;
        ChooseCustomRepeatFragment r0 = this.a;
        r0.r.setRepeatType(r0.s.get(r3).intValue());
        ChooseCustomRepeatFragment r1 = this.a;
        r1.n = r3;
        r1.Z90();
        this.a.ba0();
        return;
    }
}
