package x7;

import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import c9.c;
import com.bytedance.android.annie.card.web.e;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.lynx.tasm.LynxView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends e {
    public final c b;
    public final com.bytedance.android.annie.debug.service.c c;
    public final BaseHybridParamVoNew d;

    @Override // com.bytedance.android.annie.card.web.e
    public final void y() {
        this.b.e(this.d);
        com.bytedance.android.annie.debug.service.c r0 = this.c;
        BaseHybridParamVoNew r1 = this.d;
        if (r1 == null) goto L5;
        String r10 = r1.b;
    L6:
        r0.onRelease(r10);
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void f(String r1, ValueCallback<String> r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        this.b.f(r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void h(View r10, com.bytedance.android.annie.card.web.resource.a r11) {
        Intrinsics.checkNotNullParameter(r11, "resourceInfo");
        super.h(r10, r11);
        this.c.h(r10, r11);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void s(WebView r1, String r10) {
        this.b.a(r10);
    }

    public b(c r10, com.bytedance.android.annie.debug.service.a r11, CardParamVoNew r12) {
        Intrinsics.checkNotNullParameter(r10, "debugService");
        Intrinsics.checkNotNullParameter(r11, "internalDebugInfoProvider");
        super(null);
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void i(LynxView r1, String r10, String r11) {
        this.b.g(this.d);
        this.c.a(r10);
    }
}
