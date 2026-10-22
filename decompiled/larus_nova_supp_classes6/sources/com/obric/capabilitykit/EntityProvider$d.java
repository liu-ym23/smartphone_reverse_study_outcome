package com.obric.capabilitykit;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/net/Uri;", "uri", "", "method", "Landroid/os/Bundle;", "bundle", "invoke", "(Landroid/net/Uri;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class EntityProvider$d extends Lambda implements Function3<Uri, String, Bundle, Bundle> {
    public static final EntityProvider$d a = null;

    static {
        a = new EntityProvider$d();
    }

    public EntityProvider$d() {
        super(3);
    }

    public final Bundle a(Uri r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "method");
        return EntityProvider.access$innerCall(EntityProvider.INSTANCE, r3, r4, null, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return a((Uri) r1, (String) r2, (Bundle) r3);
    }
}
