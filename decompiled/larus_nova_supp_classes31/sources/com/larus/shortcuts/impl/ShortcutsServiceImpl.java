package com.larus.shortcuts.impl;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.net.Uri;
import android.os.Build;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.shortcuts.api.IShortcutsService;
import com.larus.shortcuts.impl.dynamic.DynamicShortcutsManager;
import com.larus.shortcuts.impl.pin.PinShortcutProcess;
import com.larus.shortcuts.impl.pin.c;
import com.larus.shortcuts.impl.pin.e;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J2\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/shortcuts/impl/ShortcutsServiceImpl;", "Lcom/larus/shortcuts/api/IShortcutsService;", "<init>", "()V", "addDynamicShortcut", "", "needShowCamera", "", "canShowRealtime", "cvsID", "", "refreshDynamicShortcut", "snapshotDynamicShortcutConfig", "clearDynamicShortcut", "tryAddPinShortcut", "cvsName", "iconUrl", "isCallBot", "eventJson", "Lorg/json/JSONObject;", "tryDisablePinShortcut", "cvsdID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShortcutsServiceImpl implements IShortcutsService {
    public ShortcutsServiceImpl() {
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void d() {
        com.larus.shortcuts.impl.dynamic.a.f = false;
        DynamicShortcutsManager.a();
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void b() {
        String r0 = com.larus.shortcuts.impl.dynamic.a.a;
        AppHost.Companion r1 = AppHost.a;
        List<tw9.a> r2 = null;
        if (r1.isPlugin() == false) goto L6;
        com.larus.shortcuts.impl.dynamic.a.e = null;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 25) goto L69;
    L67:
        com.larus.shortcuts.impl.dynamic.a.e = r2;
        return;
    L69:
        Object r3 = r1.getApplication().getApplicationContext().getSystemService("shortcut");     // Catch: Exception -> L65
        if ((r3 instanceof ShortcutManager) == false) goto L11;
        ShortcutManager r4 = (ShortcutManager) r3;     // Catch: Exception -> L65
    L12:
        if (r4 == null) goto L67;
        List<ShortcutInfo> r5 = r4.getDynamicShortcuts();     // Catch: Exception -> L65
        List<ShortcutInfo> r6 = r5;     // Catch: Exception -> L65
        boolean r7 = false;
        if ((r6 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r8 = r6.iterator();     // Catch: Exception -> L65
    L21:
        if (r8.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((ShortcutInfo) r8.next()).getId(), com.larus.shortcuts.impl.dynamic.a.a + com.larus.shortcuts.impl.dynamic.a.b) == false) goto L21;
        boolean r9 = true;
    L26:
        List<ShortcutInfo> r10 = r5;     // Catch: Exception -> L65
        if ((r10 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r11 = r10.iterator();     // Catch: Exception -> L65
    L33:
        if (r11.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(((ShortcutInfo) r11.next()).getId(), com.larus.shortcuts.impl.dynamic.a.a + com.larus.shortcuts.impl.dynamic.a.d) == false) goto L33;
        boolean r12 = true;
    L38:
        Iterator<T> r13 = r5.iterator();     // Catch: Exception -> L65
    L40:
        if (r13.hasNext() == false) goto L44;
        Object r14 = r13.next();     // Catch: Exception -> L65
        if (Intrinsics.areEqual(((ShortcutInfo) r14).getId(), com.larus.shortcuts.impl.dynamic.a.a + com.larus.shortcuts.impl.dynamic.a.c) == false) goto L40;
    L45:
        ShortcutInfo r15 = (ShortcutInfo) r14;     // Catch: Exception -> L65
        if (r9 == true) goto L50;
        if (r12 == true) goto L50;
        if (r15 == null) goto L67;
    L50:
        if (r15 == null) goto L62;
        Intent r16 = r15.getIntent();     // Catch: Exception -> L65
        if (r16 == null) goto L62;
        Uri r17 = r16.getData();     // Catch: Exception -> L65
        if (r17 == null) goto L62;
        String r18 = UriProtector.getQueryParameter(r17, "conversation_id");     // Catch: Exception -> L65
        if (r18 == null) goto L62;
        if (r18.length() <= 0) goto L60;
        r7 = true;
    L60:
        if (r7 == false) goto L62;
    L63:
        r2 = com.larus.shortcuts.impl.dynamic.a.b(r9, r18);     // Catch: Exception -> L65
    L62:
        r18 = null;
        goto L63
    L44:
        r14 = null;
    L37:
        r12 = false;
        goto L38
    L29:
        if (r10.isEmpty() == false) goto L31;
    L25:
        r9 = false;
        goto L26
    L17:
        if (r6.isEmpty() == false) goto L19;
    L11:
        r4 = null;
    L65:
        e = move-exception;
        FLogger.a.e("DynamicShortcutService", "find dynamic shortcuts from system failed", e);
        goto L67
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void e() {
        String r0 = com.larus.shortcuts.impl.dynamic.a.a;
        List<tw9.a> r1 = com.larus.shortcuts.impl.dynamic.a.e;
        com.larus.shortcuts.impl.dynamic.a.e = null;
        if (r1 != null) goto L5;
    L23:
        FLogger.a.i("DynamicShortcutService", "skip refresh dynamic shortcut, no pending shortcuts");
        return;
    L5:
        if (AppHost.a.isPlugin() == true) goto L23;
        int r2 = DynamicShortcutsManager.a;
        Intrinsics.checkNotNullParameter(r1, "shortcutInfoList");
        if (Build.VERSION.SDK_INT < 25) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        FLogger.a.e("DynamicShortcutsManager", "the os version is not support");
        return;
    L14:
        if (r1.isEmpty() == false) goto L16;
        DynamicShortcutsManager.a();
        return;
    L16:
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r1.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        ShortcutInfo r6 = DynamicShortcutsManager.b((tw9.a) r5.next());
        if (r6 == null) goto L18;
        r4.add(r6);
        goto L18
    L22:
        DynamicShortcutsManager.c(r4);
        return;
    L10:
        r3 = false;
        goto L11
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cvsdID");
        if (o0.d(r3) == false) goto L10;
        String r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "cvsID");
        if (Build.VERSION.SDK_INT < 26) goto L11;
        Lazy r1 = e.a;
        String r4 = c.a + r3;
        Intrinsics.checkNotNullParameter(r4, "id");
        if (e.a(r4) == false) goto L12;
        ((ShortcutManager) e.a.getValue()).disableShortcuts(CollectionsKt.listOf(r4));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void s0(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "cvsID");
        com.larus.shortcuts.impl.dynamic.a.a(r2, r3, r4);
    }

    @Override // com.larus.shortcuts.api.IShortcutsService
    public final void c(String r12, String r13, String r14, boolean r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r12, "cvsID");
        Intrinsics.checkNotNullParameter(r13, "cvsName");
        Intrinsics.checkNotNullParameter(r14, "iconUrl");
        String r5 = c.a;
        Intrinsics.checkNotNullParameter(r12, "cvsID");
        Intrinsics.checkNotNullParameter(r13, "cvsName");
        Intrinsics.checkNotNullParameter(r14, "iconUrl");
        if (Build.VERSION.SDK_INT < 26) goto L10;
        String r1 = c.a + r12;
        if (r15 == true) goto L7;
        String r0 = "sslocal://chat_page?is_from_outer=true&conversation_id=" + r12 + "&open_method=shortcut";
    L8:
        new PinShortcutProcess(new tw9.a(r1, r13, r13, 1, r0, null, r14, 160), r16);
        return;
    L7:
        r0 = "sslocal://flow/realtime_chat?is_from_outer=true&conversation_id=" + r12 + "&open_method=shortcut";
        goto L8
    }
}
