package com.obric.capabilitykit;

import com.obric.capabilitykit.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class p$b extends Lambda implements Function0<wia.v> {
    public static final p$b a = null;

    static {
        a = new p$b();
    }

    public p$b() {
        super(0);
    }

    public final wia.v a() {
        return wia.v.b.a(AppHost.Companion.getApplication().getApplicationContext());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return a();
    }
}
