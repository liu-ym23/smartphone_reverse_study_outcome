package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class WifiManagerEntry$Companion$addSuggestionConnectionStatusListenerUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Executor $executor;
    final /* synthetic */ WifiManager.SuggestionConnectionStatusListener $listener;
    final /* synthetic */ WifiManager $this_addSuggestionConnectionStatusListenerUnsafe;

    public WifiManagerEntry$Companion$addSuggestionConnectionStatusListenerUnsafe$1(WifiManager r1, Executor r2, WifiManager.SuggestionConnectionStatusListener r3) {
        this.$this_addSuggestionConnectionStatusListenerUnsafe = r1;
        this.$executor = r2;
        this.$listener = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1687invoke() {
        WifiManager r9 = this.$this_addSuggestionConnectionStatusListenerUnsafe;
        Executor r10 = this.$executor;
        WifiManager.SuggestionConnectionStatusListener r11 = this.$listener;
        ArrayList r12 = new ArrayList();
        Object[] r13 = {r10, r11};
        f06.b r15 = new f06.b();
        g06.a r1 = (g06.a) ApiHookConfig.b.get(102303);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r5 = r8[r6];
        int r19 = r6;
        int r20 = r7;
        f06.a[] r21 = r8;
        f06.d r3 = r5.preInvoke(102303, "android/net/wifi/WifiManager", "addSuggestionConnectionStatusListener", r9, r13, "void", r15);     // Catch: Exception -> L21
        if (r3.a == true) goto L17;
        r12.add(r5);     // Catch: Exception -> L21
    L17:
        if (r3.a == true) goto L27;
        r9.addSuggestionConnectionStatusListener(r10, r11);
        return;
    L27:
        return;
    L14:
        r6 = r19 + 1;
        r7 = r20;
        r8 = r21;
        goto L8
    L15:
        r3 = new f06.d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1687invoke();
        return Unit.INSTANCE;
    }
}
