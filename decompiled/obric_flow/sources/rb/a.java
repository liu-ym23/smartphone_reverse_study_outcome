package rb;

import com.bytedance.ies.bullet.service.base.m;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21716b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f21715a = r10;
        this.f21716b = r5;
    }

    private final void b() {
    }

    public final Object a() {
        switch(this.f21715a) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        WeakReference r5 = (WeakReference) this.f21716b;
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.get();
    L10:
        return ((Function0) this.f21716b).invoke();
    L12:
        return this.f21716b;
    }

    @Override // com.bytedance.ies.bullet.service.base.m
    public final void release() {
        switch(this.f21715a) {
            case 0: goto L9;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        WeakReference r5 = (WeakReference) this.f21716b;
        if (r5 == null) goto L7;
        r5.clear();
    L7:
        this.f21716b = null;
        return;
    L9:
        this.f21716b = null;
        return;
    }

    public a(Object r5) {
        this.f21715a = 2;
        if (r5 != null) goto L5;
        WeakReference r10 = null;
    L6:
        this.f21716b = r10;
        return;
    L5:
        r10 = new WeakReference(r5);
        goto L6
    }
}
