package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/f$a;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/f$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class PSTopContainer$doShow$1 extends Lambda implements Function1<f.a, Unit> {
    final /* synthetic */ f52.c $view;
    final /* synthetic */ PSTopContainer this$0;

    public PSTopContainer$doShow$1(PSTopContainer r1, f52.c r2) {
        this.this$0 = r1;
        this.$view = r2;
        super(1);
    }

    public final void invoke(f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        Function0<View> r0 = new AnonymousClass1(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "view");
        r3.a = r0;
        Function1<f.a.C0095a, Unit> r1 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r1, "init");
        r3.b = r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f.a) r1);
        return Unit.INSTANCE;
    }
}
