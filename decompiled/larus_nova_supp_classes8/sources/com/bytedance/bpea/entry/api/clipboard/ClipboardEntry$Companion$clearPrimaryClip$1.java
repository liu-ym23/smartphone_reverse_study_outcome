package com.bytedance.bpea.entry.api.clipboard;

import android.content.ClipboardManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class ClipboardEntry$Companion$clearPrimaryClip$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ClipboardManager $this_clearPrimaryClip;

    public ClipboardEntry$Companion$clearPrimaryClip$1(ClipboardManager r1) {
        this.$this_clearPrimaryClip = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1567invoke() {
        ClipboardManager r9 = this.$this_clearPrimaryClip;
        ArrayList r10 = new ArrayList();
        Object[] r12 = new Object[0];
        b r13 = new b();
        a r1 = (a) ApiHookConfig.b.get(101800);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r5 = r8[r6];
        int r17 = r6;
        int r18 = r7;
        f06.a[] r19 = r8;
        d r3 = r5.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r9, r12, "void", r13);     // Catch: Exception -> L21
        if (r3.a == true) goto L17;
        r10.add(r5);     // Catch: Exception -> L21
    L17:
        if (r3.a == true) goto L27;
        r9.clearPrimaryClip();
        return;
    L27:
        return;
    L14:
        r6 = r17 + 1;
        r7 = r18;
        r8 = r19;
        goto L8
    L15:
        r3 = new d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1567invoke();
        return Unit.INSTANCE;
    }
}
