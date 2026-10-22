package com.lynx.tasm.fluency;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final WeakReference<LynxContext> a;
    public final Map<Integer, com.lynx.tasm.fluency.b> b;

    /* JADX INFO: renamed from: com.lynx.tasm.fluency.a$a, reason: collision with other inner class name */
    public static class C0060a {
        public String a;
        public String b;
        public double c;
        public LynxBooleanOption d;

        public C0060a() {
            this.a = NameKeys.UnloadStrategy_No_Strategy;
            this.b = NameKeys.UnloadStrategy_No_Strategy;
            this.c = -1.0d;
            this.d = LynxBooleanOption.UNSET;
        }
    }

    public static class b implements com.lynx.tasm.fluency.b.a {
        public final C0060a a;
        public final int b;

        public b(C0060a r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(LynxContext r2) {
        this.b = new HashMap();
        this.a = new WeakReference(r2);
    }
}
