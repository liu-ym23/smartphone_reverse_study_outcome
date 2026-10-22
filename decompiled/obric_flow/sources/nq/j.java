package nq;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatrixTeaManager f20299a;

    public j(MatrixTeaManager r5) {
        this.f20299a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MatrixTeaManager r5 = this.f20299a;
        if (MatrixTeaManager.access$isBound$p(r5) == true) goto L6;
        com.lynx.jsbridge.a.s("MatrixTeaManager", "尝试重新绑定下载服务");
        r5.bindServiceInternal();
        MatrixTeaManager.access$getHandler$p(r5).postDelayed(this, 5000);
        return;
    }
}
