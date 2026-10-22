package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f590c;
    public final /* synthetic */ QueryInterceptorProgram d;

    public /* synthetic */ g(QueryInterceptorDatabase r5, SupportSQLiteQuery r10, QueryInterceptorProgram r11, int r12) {
        this.f588a = r12;
        this.f589b = r5;
        this.f590c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f588a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        QueryInterceptorProgram r5 = this.d;
        QueryInterceptorDatabase.L(this.f589b, this.f590c, r5);
        return;
    L6:
        QueryInterceptorProgram r10 = this.d;
        QueryInterceptorDatabase.K(this.f589b, this.f590c, r10);
    }
}
