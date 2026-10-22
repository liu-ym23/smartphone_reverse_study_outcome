package w29;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.contextwindow.api.a$b;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements com.larus.bmhome.view.actionbar.custom.router.b {
    public d() {
    }

    public final boolean b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schemaUrl");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Set<String> r1 = v29.b.a;     // Catch: Throwable -> L9
        if (v29.b.d(UriProtector.parse(r3)) == null) goto L6;
        boolean r4 = true;
    L7:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L9
    L11:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = r2;
    L15:
        return ((Boolean) r5).booleanValue();
    L6:
        r4 = false;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean a(BaseContentWidget r5, String r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "schemaUrl");
        Intrinsics.checkNotNullParameter(r7, "commonArgs");
        if (b(r6) == true) goto L7;
        return false;
    L7:
        if (r5 != null) goto L9;
        return true;
    L9:
        o r8 = s1a.d.a(r5).getAbility(o.class);
        if (r8 == null) goto L12;
        r8.c3();
    L12:
        v29.c r9 = s1a.d.a(r5).getAbility(v29.c.class);
        if (r9 != null) goto L15;
        return true;
    L15:
        ContextWindowEntryRequest r0 = r9.dO();
        if (r0 != null) goto L18;
        return true;
    L18:
        IContextWindowUsageService.a.getClass();
        IContextWindowUsageService r1 = (IContextWindowUsageService) IContextWindowUsageService.a.b.getValue();
        if (r1 == null) goto L27;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FragmentActivity r10 = com.larus.ui.arch.component.internal.attach.a.b(r5, r5).requireActivity();
        com.larus.contextwindow.api.a r11 = r9.O90();
        ContextWindowSnapshot r3 = null;
        if ((r11 instanceof a$b) == false) goto L23;
        a$b r12 = (a$b) r11;
    L24:
        if (r12 == null) goto L26;
        r3 = r12.a;
    L26:
        r1.b(r10, r0, r3);
        goto L27
    L23:
        r12 = null;
    L27:
        return true;
    }
}
