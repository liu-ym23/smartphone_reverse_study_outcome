package com.bytedance.ai.applet.app.foundation;

import androidx.activity.OnBackPressedCallback;
import com.bytedance.ai.applet.app.AppletAppActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"com/bytedance/ai/applet/app/foundation/AppletAppRouter$ensureBackCallbackInstalled$callback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "proceedSystemBack", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppRouter$ensureBackCallbackInstalled$callback$1 extends OnBackPressedCallback {
    public final /* synthetic */ AppletAppActivity a;
    public final /* synthetic */ AppletAppRouter b;

    public final void handleOnBackPressed() {
        Long r0 = this.a.C1();
        if (this.a.getSupportFragmentManager().getBackStackEntryCount() <= 0) goto L8;
        if (r0 == null) goto L8;
        AppletAppRouter r1 = this.b;
        AppletAppActivity r10 = this.a;
        long r11 = r0.longValue();
        Function0<Unit> r12 = new h(this);
        int r13 = AppletAppRouter.e;
        if (r1.o(r10, r11, r12) == false) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L12;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "system back intercepted by alert before unload");
        return;
    L12:
        setEnabled(false);
        this.a.getOnBackPressedDispatcher().onBackPressed();
        setEnabled(true);
        return;
    L8:
        r14 = false;
        goto L9
    }

    public AppletAppRouter$ensureBackCallbackInstalled$callback$1(AppletAppActivity r1, AppletAppRouter r10) {
        this.a = r1;
        this.b = r10;
        super(true);
    }
}
