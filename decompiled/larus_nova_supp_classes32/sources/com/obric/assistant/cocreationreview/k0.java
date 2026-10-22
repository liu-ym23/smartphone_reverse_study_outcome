package com.obric.assistant.cocreationreview;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ModuleKey.values().length];
            r0[ModuleKey.PROACTIVE_AGENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ModuleKey.SCREEN_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ModuleKey.AUDIO_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ModuleKey.AUTO_MEMORY_PRO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ModuleKey.COLLECTION_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ModuleKey.PERSONAL_MEMORY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ModuleKey.SEARCH_QA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ModuleKey.OMNI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public static int a(ModuleKey r1) {
        Intrinsics.checkNotNullParameter(r1, "module");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return 2;
    L7:
        return 3;
    L8:
        return 7;
    L9:
        return 8;
    L10:
        return 6;
    L11:
        return 5;
    L12:
        return 4;
    L13:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
