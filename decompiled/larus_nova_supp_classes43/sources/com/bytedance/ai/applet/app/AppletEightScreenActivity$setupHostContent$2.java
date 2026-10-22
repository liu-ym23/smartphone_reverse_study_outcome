package com.bytedance.ai.applet.app;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AppletEightScreenActivity$setupHostContent$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public AppletEightScreenActivity$setupHostContent$2(Object r10) {
        super(0, r10, AppletEightScreenActivity.class, "showOptionsMenu", "showOptionsMenu()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m17invoke() {
        AppletEightScreenActivity r0 = (AppletEightScreenActivity) ((CallableReference) this).receiver;
        int r1 = AppletEightScreenActivity.C;
        AppletApplication r10 = r0.e;
        if (r10 != null) goto L5;
        com.bytedance.ai.utils.g.a.e("AppletEightScreenActivity", "showOptionsMenu: application is null");
        return;
    L5:
        com.bytedance.ai.applet.app.foundation.j r11 = r10.h().e();
        r11.getClass();
        r11.i("click_doubao_apps_more", MapsKt.emptyMap());
        if (r10.A() == true) goto L8;
        com.bytedance.ai.utils.g.a.i("AppletEightScreenActivity", "showOptionsMenu: delegate to applet custom handler");
        r10.o();
        return;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new AppletEightScreenActivity$showOptionsMenu$1(r0, r10, null), 3, null);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m17invoke();
        return Unit.INSTANCE;
    }
}
