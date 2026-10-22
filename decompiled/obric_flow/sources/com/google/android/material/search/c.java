package com.google.android.material.search;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements SearchBarAnimationHelper.OnLoadAnimationInvocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8565a;

    public /* synthetic */ c(int r5) {
        this.f8565a = r5;
    }

    @Override // com.google.android.material.search.SearchBarAnimationHelper.OnLoadAnimationInvocation
    public final void invoke(SearchBar.OnLoadAnimationCallback r5) {
        switch(this.f8565a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r5.onAnimationEnd();
        return;
    L6:
        r5.onAnimationStart();
    }
}
