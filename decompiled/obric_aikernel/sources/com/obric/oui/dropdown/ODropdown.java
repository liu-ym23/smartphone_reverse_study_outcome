package com.obric.oui.dropdown;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public interface ODropdown {

    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ODropdown r10, final ODropdownTrigger r11, Activity r12, Function0 r13, Function1 r14, int r15, Object r16) {
            if (r16 != null) goto L9;
            if ((r15 & 4) == 0) goto L6;
            r13 = new ODropdown$start$1(r11);
        L6:
            r10.a(r11, r12, r13, r14);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void a(ODropdownTrigger r10, Activity r11, Function0<Unit> r12, Function1<? super CharSequence, Unit> r13);
}
