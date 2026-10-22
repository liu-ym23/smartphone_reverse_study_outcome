package com.larus.bmhome.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d4 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ SelectButtonListView b;
    public final /* synthetic */ int c;

    public /* synthetic */ d4(boolean r1, SelectButtonListView r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        SelectButtonListView r1 = this.b;
        int r2 = this.c;
        int r3 = SelectButtonListView.l;
        if (r0 == false) goto L6;
        r1.scrollToPosition(r2);
        return;
    }
}
