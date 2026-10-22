package com.larus.bmhome.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i1 implements Runnable {
    public final /* synthetic */ ChatTitleAlignLeftStyle a;

    public /* synthetic */ i1(ChatTitleAlignLeftStyle r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatTitleAlignLeftStyle r0 = this.a;
        int r1 = ChatTitleAlignLeftStyle.T;
        r0.setHasMore(true);
        r0.x = false;
        r0.l7("hasAddBot", false);
    }
}
