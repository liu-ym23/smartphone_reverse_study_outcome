package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.ButtonRouterKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.CollaboratedMultiFeatureSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.DropdownListSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.DropdownSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.MenuTabContainerKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.MultiMediaSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.MultiSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.TabSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.TextListSelectorKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.TranslatorKmpInstructionWidgetProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import cq8.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public static final o a = null;
    public static final Set<IKmpInstructionWidgetProvider<? extends a0>> b = null;
    public static final IKmpInstructionWidgetProvider<a0> c = null;
    public static boolean d;

    public o() {
    }

    static {
        a = new o();
        b = new LinkedHashSet();
        c = new NoopKmpInstructionWidgetProvider();
    }

    public static AbsKmpInstructionWidget a(Context r3, a0 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        if (d == true) goto L17;
        d = true;
        Set<IKmpInstructionWidgetProvider<? extends a0>> r1 = b;
        r1.add(new DropdownListSelectorKmpInstructionWidgetProvider());
        r1.add(new DropdownSelectorKmpInstructionWidgetProvider());
        r1.add(new MultiSelectorKmpInstructionWidgetProvider());
        r1.add(new CollaboratedMultiFeatureSelectorKmpInstructionWidgetProvider());
        r1.add(new MenuTabContainerKmpInstructionWidgetProvider());
        r1.add(new MultiMediaSelectorKmpInstructionWidgetProvider());
        r1.add(new TabSelectorKmpInstructionWidgetProvider());
        r1.add(new TextListSelectorKmpInstructionWidgetProvider());
        r1.add(new TranslatorKmpInstructionWidgetProvider());
        r1.add(new ButtonRouterKmpInstructionWidgetProvider());
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        List r0 = CollectionsKt.toList(ServiceManager.get().getServices(IKmpInstructionWidgetProvider.class, true));     // Catch: Throwable -> L14
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r6 = r0.iterator();     // Catch: Throwable -> L14
    L8:
        if (r6.hasNext() == false) goto L12;
        IKmpInstructionWidgetProvider r7 = (IKmpInstructionWidgetProvider) r6.next();     // Catch: Throwable -> L14
        if (r7 == null) goto L8;
        r5.add(r7);     // Catch: Throwable -> L14
        goto L8
    L12:
        Result.constructor-impl(Boolean.valueOf(b.addAll(r5)));     // Catch: Throwable -> L14
    L16:
        b.add(c);
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        Iterator<T> r9 = b.iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        Object r10 = r9.next();
        if (((IKmpInstructionWidgetProvider) r10).a(r4) == false) goto L19;
    L24:
        IKmpInstructionWidgetProvider<a0> r11 = (IKmpInstructionWidgetProvider) r10;
        if (r11 != null) goto L27;
        r11 = c;
    L27:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider<com.larus.bmhome.instruction.core.model.widget.InstructionWidgetDescriptor>");
        return r11.b(r3, r4);
    L23:
        r10 = null;
        goto L24
    }
}
