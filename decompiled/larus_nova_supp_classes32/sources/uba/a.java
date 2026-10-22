package uba;

import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAvailableManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jc8.a;
import jc8.b;
import jc8.d;
import jc8.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a<T extends jc8.a> extends b<T> {

    /* JADX INFO: renamed from: uba.a$a, reason: collision with other inner class name */
    public static final class C0115a {
    }

    static {
    }

    public final String c() {
        return "ObricBaseBlockHolder";
    }

    public final void a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        View r2 = ((b) this).c;     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        IObricAvailableManager r3 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);     // Catch: Throwable -> L18
        if (r3 == null) goto L10;
        boolean r4 = true;
        if (r3.a() != true) goto L10;
    L11:
        FLogger.a.d("ObricBaseBlockHolder", "checkIsDefaultAssistant isDefaultAssistant=" + r4);     // Catch: Throwable -> L18
        if (r4 == true) goto L14;
        r2.setAlpha(0.3f);     // Catch: Throwable -> L18
        j(r2);     // Catch: Throwable -> L18
    L14:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(r0);     // Catch: Throwable -> L18
        return;
    L10:
        r4 = false;
        goto L11
    L15:
        r0 = null;
    L18:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public a() {
    }

    public static void j(View r3) {
        r3.setOnClickListener(null);
        r3.setOnLongClickListener(null);
        int r0 = 0;
        r3.setClickable(false);
        if ((r3 instanceof ViewGroup) == false) goto L7;
        ViewGroup r4 = (ViewGroup) r3;
        int r1 = r4.getChildCount();
    L5:
        if (r0 >= r1) goto L9;
        j(r4.getChildAt(r0));
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    public final d f(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        return e.d(r2);
    }
}
