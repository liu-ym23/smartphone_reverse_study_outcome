package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.entity.IObricEntityNavigationService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final boolean a(s r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.f;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L30;
        String r4 = r3.d;
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L31;
        String r6 = r3.e;
        if (r6 != null) goto L21;
    L24:
        if (r1 == true) goto L33;
        IObricEntityNavigationService r7 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r7 != null) goto L29;
        return false;
    L29:
        return r7.b(r3.d);
    L33:
        return false;
    L21:
        if (StringsKt.isBlank(r6) == true) goto L24;
        r1 = false;
        goto L24
    L31:
        return false;
    L13:
        if (StringsKt.isBlank(r4) == true) goto L16;
        r5 = false;
        goto L17
    L30:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final boolean b(s r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((!r2.i.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r2.h.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean c(s r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.f;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L29;
        String r2 = r3.d;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L29;
        String r5 = r3.e;
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L29;
        if (a(r3) == true) goto L29;
        return true;
    L21:
        if (StringsKt.isBlank(r5) == true) goto L24;
        r6 = false;
        goto L25
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r4 = false;
    L29:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final void d(s r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        IObricEntityNavigationService r0 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r0 == null) goto L16;
        String r1 = r4.f;
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r1 != null) goto L7;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        String r3 = r4.d;
        if (r3 != null) goto L10;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        String r5 = r4.e;
        if (r5 == null) goto L14;
        r2 = r5;
    L14:
        r0.e(r1, r3, r2);
        return;
    }

    public static final void e(s r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IObricEntityNavigationService r0 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r0 == null) goto L6;
        r0.a(h(r2));
        return;
    }

    public static final List<zda.c> h(s r10) {
        if ((!r10.i.isEmpty()) == false) goto L9;
        List<r> r11 = r10.i;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r r1 = (r) r12.next();
        r0.add(new zda.c(r1.a, r1.b, r1.c, r1.d, r1.e, r1.f));
        goto L6
    L8:
        return r0;
    L9:
        List<String> r13 = r10.h;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        r2.add(new zda.c((String) r14.next(), null, null, null, null, false));
        goto L11
    L13:
        return r2;
    }

    public static final void f(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "reference");
        String r4 = r3.j;
        if (r4 != null) goto L6;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (StringsKt.isBlank(r4) == false) goto L8;
        return;
    L8:
        IObricEntityNavigationService r0 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r0 == null) goto L12;
        r0.d(r2, r4);
        return;
    }

    public static final View g(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "reference");
        IObricEntityNavigationService r0 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r0 == null) goto L5;
        RecyclerView r4 = r0.c(r2, h(r3));
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return new View(r2);
    L5:
        r4 = null;
        goto L6
    }
}
