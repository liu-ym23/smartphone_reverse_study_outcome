package op8;

import android.net.Uri;
import com.larus.bmhome.chat.component.input.b0;
import com.larus.bmhome.chat.component.input.d0;
import com.larus.bmhome.chat.component.input.e0;
import com.larus.bmhome.chat.component.input.f0;
import com.larus.bmhome.chat.component.input.g0;
import com.larus.bmhome.chat.component.input.h0;
import com.larus.bmhome.chat.component.input.i0;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final Function1<String, Unit> a;
    public final Function0<List<UplinkFileEntity>> b;
    public final Function1<List<UplinkFileEntity>, Integer> c;
    public final Function1<List<UplinkFileEntity>, Unit> d;
    public final Function1<Uri, Unit> e;
    public final Function1<List<String>, Unit> f;
    public final Function1<String, Unit> g;
    public final Function0<Unit> h;
    public boolean i;
    public String j;
    public Set<? extends Uri> k;
    public Set<String> l;

    public final void a() {
        String r0 = this.j;
        if (r0 == null) goto L5;
        dr9.g r1 = dr9.g.a;
        dr9.g.f(r0);
    L5:
        this.j = null;
        this.k = SetsKt.emptySet();
        this.l = SetsKt.emptySet();
    }

    public j(b0 r2, d0 r3, e0 r4, f0 r5, g0 r6, h0 r7, Function1 r8, i0 r9) {
        Intrinsics.checkNotNullParameter(r2, "setInputText");
        Intrinsics.checkNotNullParameter(r3, "currentEntities");
        Intrinsics.checkNotNullParameter(r4, "appendEntities");
        Intrinsics.checkNotNullParameter(r5, "removeEntities");
        Intrinsics.checkNotNullParameter(r6, "removeEntityByUri");
        Intrinsics.checkNotNullParameter(r7, "restoreLegacyUris");
        Intrinsics.checkNotNullParameter(r8, "showInput");
        Intrinsics.checkNotNullParameter(r9, "closeInvalidInput");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.k = SetsKt.emptySet();
        this.l = SetsKt.emptySet();
    }
}
