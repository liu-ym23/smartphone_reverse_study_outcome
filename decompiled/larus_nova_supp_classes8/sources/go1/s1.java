package go1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s1<T> implements h80.d {
    public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.e0 a;

    public s1(com.bytedance.android.livesdk.widgetdescriptor.e0 r1) {
        this.a = r1;
    }

    public final Object get() {
        jo1.h r0 = ho1.a.g(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ok();
    }
}
