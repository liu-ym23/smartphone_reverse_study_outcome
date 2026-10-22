package com.larus.bmhome.chat.camera.command;

import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    static {
    }

    public static boolean a(BotModel r8) {
        if (FeatureKitDelegate.b.Z().b() == false) goto L26;
        String r0 = null;
        if (r8 == null) goto L24;
        List r3 = r8.getBotConf();
        if (r3 == null) goto L24;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        BotConfItem r6 = (BotConfItem) r5;
        if (Intrinsics.areEqual(r6.getConfGroupKey(), "disable_function") == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L10;
    L20:
        BotConfItem r9 = (BotConfItem) r5;
        if (r9 == null) goto L24;
        r0 = r9.getConfValue();
        goto L24
    L14:
        if (Intrinsics.areEqual(r6.getConfKey(), "apply_attachment_sug_optional") == false) goto L16;
        r7 = true;
        goto L17
    L19:
        r5 = null;
    L24:
        if (Intrinsics.areEqual(r0, "1") == false) goto L26;
        boolean r1 = true;
    L27:
        if (r1 == false) goto L29;
    L30:
        return true;
    L29:
        if (b(r8) == true) goto L30;
        return false;
    L26:
        r1 = false;
        goto L27
    }

    public static boolean b(BotModel r7) {
        if (FeatureKitDelegate.b.E0().b() == false) goto L32;
        String r2 = null;
        if (r7 == null) goto L24;
        List r8 = r7.getBotConf();
        if (r8 == null) goto L24;
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L19;
        Object r3 = r9.next();
        BotConfItem r4 = (BotConfItem) r3;
        if (Intrinsics.areEqual(r4.getConfGroupKey(), "disable_function") == true) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L10;
    L20:
        BotConfItem r6 = (BotConfItem) r3;
        if (r6 == null) goto L24;
        r2 = r6.getConfValue();
        goto L24
    L14:
        if (Intrinsics.areEqual(r4.getConfKey(), "apply_preview_sug_optional") == false) goto L16;
        r5 = true;
        goto L17
    L19:
        r3 = null;
    L24:
        if (Intrinsics.areEqual(r2, "1") == false) goto L33;
        return true;
    L33:
        return false;
    L32:
        return false;
    }
}
