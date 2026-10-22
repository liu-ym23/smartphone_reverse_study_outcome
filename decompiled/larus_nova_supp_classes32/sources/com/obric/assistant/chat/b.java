package com.obric.assistant.chat;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.remove("obric_auto_mention");
        r1.remove("obric_skill_slug");
        r1.remove("obric_skill_display_name");
        r1.remove("obric_skill_cover_url");
        r1.remove("obric_auto_mention_content");
    }

    public static boolean b(Bundle r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3.getString("obric_auto_mention"), "1") == true) goto L8;
        return false;
    L8:
        String r1 = r3.getString("obric_skill_slug");
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L26;
        String r4 = r3.getString("obric_skill_display_name");
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L27;
        return true;
    L27:
        return false;
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r5 = false;
        goto L23
    L26:
        return false;
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
        goto L15
    }

    public static boolean c(Bundle r2) {
        boolean r0 = false;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (b(r2) == true) goto L8;
        return false;
    L8:
        String r3 = r2.getString("obric_auto_mention_content");
        if (r3 != null) goto L11;
    L12:
        r0 = true;
    L14:
        return !r0;
    L11:
        if (StringsKt.isBlank(r3) == false) goto L14;
        goto L12
    }
}
