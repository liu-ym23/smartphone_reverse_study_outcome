package com.obric.assistant.automic;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.voice.ContentScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.assistant.automic.a$a, reason: collision with other inner class name */
    public static final class C0075a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContentScene.values().length];
            r0[ContentScene.OAUTO_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ContentScene.COMPLEX_ASK_USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ContentScene.PRIORITY_NOTIFICATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ContentScene.AI_ACTIVE_ASK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ContentScene.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static String a(ContentScene r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "oauto_automic";
    L5:
        if (r2 != 2) goto L7;
        return "oautopro_automic";
    L7:
        if (r2 != 3) goto L9;
        return "high_priority_notification";
    L9:
        if (r2 != 4) goto L11;
        return "ai_active_ask";
    L11:
        if (r2 != 5) goto L14;
        return NameKeys.UnloadStrategy_No_Strategy;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
