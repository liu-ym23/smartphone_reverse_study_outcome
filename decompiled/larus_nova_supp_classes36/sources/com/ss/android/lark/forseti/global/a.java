package com.ss.android.lark.forseti.global;

import com.ss.android.lark.api.bean.ForsetiMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements tua.a {
    public final /* synthetic */ ForsetiActivityChainManager a;
    public final /* synthetic */ Function1<ForsetiMode, Unit> b;

    public final void dispose() {
        this.a.g.remove(this.b);
    }

    public a(ForsetiActivityChainManager r1, Function1<? super ForsetiMode, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
