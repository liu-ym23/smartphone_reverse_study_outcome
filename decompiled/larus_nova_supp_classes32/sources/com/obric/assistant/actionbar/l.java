package com.obric.assistant.actionbar;

import com.larus.bmhome.actionbar.model.AgentMode;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static WeakReference<com.obric.oui.dialog.v2.alert.c> a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AgentMode.values().length];
            r0[AgentMode.MOA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }
}
