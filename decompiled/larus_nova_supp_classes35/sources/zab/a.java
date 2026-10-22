package zab;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.desktopmode.base.FragmentParams;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final <T extends FragmentParams> void a(DesktopCompatFragment<T> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        g r0 = f.b(r1);
        if (r0 == null) goto L7;
        r0.g(null);
        return;
    L7:
        r1.finish();
    }

    public static final <T extends FragmentParams> void b(DesktopCompatFragment<T> r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.ParamKey.RESULT);
        if (r2 != null) goto L5;
        return;
    L5:
        g r0 = f.b(r2);
        if (r0 == null) goto L8;
        r0.c(r3, r4);
        return;
    L8:
        FragmentActivity r1 = r2.getActivity();
        if (r1 == null) goto L11;
        Intent r5 = new Intent();
        r5.putExtras(r4);
        Unit r6 = Unit.INSTANCE;
        r1.setResult(r3, r5);
    L11:
        r2.finish();
    }
}
