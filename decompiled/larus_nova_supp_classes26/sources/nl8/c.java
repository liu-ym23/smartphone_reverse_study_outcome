package nl8;

import android.app.Activity;
import android.view.View;
import com.larus.bmhome.bigimg.k;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final Function0<Unit> a;

    @Override // nl8.b
    public final void a() {
        this.a.invoke();
    }

    public c(ml8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "onRebind");
        this.a = r2;
    }

    @Override // nl8.b
    public final void b(String r24, View r25) {
        Intrinsics.checkNotNullParameter(r24, ShareType.URL);
        Intrinsics.checkNotNullParameter(r25, "view");
        l r1 = new l(null, r24, "", r24, null, null, null, null, null, null, 2033);
        Activity r9 = AppHost.a.a().getCurrentActivity();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.content.Context");
        k.c(r9, CollectionsKt.listOf(new Pair(0, r25)), CollectionsKt.listOf(r1), 0, new uo8.k(MapsKt.emptyMap(), null), true, null, null, false, null, null, null, null, 16320);
    }
}
