package vd8;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements com.larus.bmhome.chat.list.cell.spacer.i {
    public final /* synthetic */ p a;

    public b(p r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spacerId");
        Set<String> r0 = a.b;
        a.b.remove(r2);
        this.a.f.a(r2);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spacerId");
        this.a.f.b(r2);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spacerId");
        this.a.f.c(r2);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spacerId");
        Set<String> r0 = a.b;
        a.b.add(r2);
        this.a.f.d(r2);
    }
}
