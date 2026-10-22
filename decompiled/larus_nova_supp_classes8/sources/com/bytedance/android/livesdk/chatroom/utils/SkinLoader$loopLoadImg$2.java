package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SkinLoader$loopLoadImg$2 implements a4 {
    public final /* synthetic */ SkinLoader a;
    public final /* synthetic */ a4 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ View e;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void a(Disposable r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void b(final SkinLoadResultType r3, final String r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        SkinLoader.a r0 = SkinLoader.c;
        Function0<String> r1 = new SkinLoader$loopLoadImg$2$onResult$1(r3, r4);
        r0.getClass();
        SkinLoader.a.c(r1);
        SkinLoadResultType r2 = SkinLoadResultType.ERROR;
        if (r3 != r2) goto L9;
        a4 r5 = this.b;
        if (r5 == null) goto L7;
        r5.b(r2, this.c + " img is error.");
    L7:
        this.a.d(this.d, this.c + 1, this.e, this);
        return;
    L9:
        a4 r6 = this.b;
        if (r6 == null) goto L13;
        r6.b(r3, r4);
        return;
    }

    public SkinLoader$loopLoadImg$2(SkinLoader r1, a4 r2, int r3, ArrayList r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
