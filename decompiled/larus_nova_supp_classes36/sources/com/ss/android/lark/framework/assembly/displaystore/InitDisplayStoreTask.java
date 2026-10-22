package com.ss.android.lark.framework.assembly.displaystore;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitDisplayStoreTask extends AbstractLaunchTask {
    public InitDisplayStoreTask() {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.framework.assembly.displaystore.a, java.lang.Object] */
    public final void a(Context r11) {
        b r0 = new b();
        ?? r1 = new a();
        ZoomLevel6 r2 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r0, "storeGear");
        Intrinsics.checkNotNullParameter(r1, "fgFetcher");
        ZoomLevel6.a r3 = ZoomLevel6.Companion;
        boolean r4 = true;
        Integer r5 = Integer.valueOf(LarkKVStorage.g(new com.ss.android.lark.storage.a("core"), "display_manager", true).getInt("display_zoom", 0));
        r3.getClass();
        ZoomLevel6[] r6 = ZoomLevel6.values();
        int r7 = r6.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L11;
        ZoomLevel6 r9 = r6[r8];
        int r10 = r9.getLevel();
        if (r5 == null) goto L10;
        if (r5.intValue() != r10) goto L10;
    L12:
        zz7.b.a = r9;
        if (CarUtils.a() == true) goto L15;
    L17:
        boolean r12 = false;
    L19:
        if (r12 == false) goto L21;
        Log.i("DisplayManagerTAG", "global font display force disable");
        yz7.a.a = false;
    L22:
        int r13 = a08.a.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        if (yz7.a.b == true) goto L25;
    L27:
        r4 = false;
    L28:
        if (r4 == true) goto L31;
        Log.i("FontContextHook", "config not hook font for application");
        return;
    L31:
        if ((r11 instanceof Application) == false) goto L49;
        Resources r14 = ((Application) r11).getResources();
        if (r14 == null) goto L47;
        float r15 = zz7.b.d().getMultiplier();
        Configuration r16 = r14.getConfiguration();
        if (r16 == null) goto L39;
        r16.fontScale = r15;
    L39:
        if (r14.getConfiguration() == null) goto L48;
        r14.updateConfiguration(r14.getConfiguration(), WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()));
        return;
    L48:
        return;
    L47:
        return;
    L49:
        return;
    L25:
        if (yz7.a.a == false) goto L27;
    L21:
        boolean r17 = !((Boolean) r1.invoke("fg_open")).booleanValue();
        Log.i("DisplayManagerTAG", "global font display enable " + r17);
        yz7.a.a = r17;
        goto L22
    L15:
        if (((v28.a) ClaymoreServiceLoader.loadFirst(v28.a.class)).enableFontScale() == true) goto L17;
        r12 = true;
    L10:
        r8 = r8 + 1;
        goto L3
    L11:
        r9 = ZoomLevel6.NORMAL;
        goto L12
    }
}
