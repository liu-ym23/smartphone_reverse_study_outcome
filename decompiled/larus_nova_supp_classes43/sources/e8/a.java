package e8;

import com.bytedance.android.annie.ng.h;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements h {
    public final /* synthetic */ Function1<d8.b, Unit> a;
    public final /* synthetic */ com.bytedance.android.annie.ng.a.C0073a b;

    @Override // com.bytedance.android.annie.ng.h
    public final void onCallback() {
        d8.b r0 = new d8.b();
        this.a.invoke(r0);
        ConcurrentHashMap<String, d8.b> r1 = d.a;
        d.a.put(this.b.a, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super d8.b, Unit> r1, com.bytedance.android.annie.ng.a.C0073a r10) {
        this.a = r1;
        this.b = r10;
    }
}
