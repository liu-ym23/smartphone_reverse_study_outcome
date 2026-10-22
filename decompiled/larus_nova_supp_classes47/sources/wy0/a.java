package wy0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<P, R> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    public final void j(R r1) {
        if (r1 != null) goto L4;
        finishWithSuccess();
        return;
    L4:
        finishWithResult(r1);
    }
}
