package com.bytedance.bpea.entry.api.clipboard;

import android.text.ClipboardManager;
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
final class ClipboardEntry$Companion$setText$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CharSequence $text;
    final /* synthetic */ ClipboardManager $this_setText;

    public ClipboardEntry$Companion$setText$2(ClipboardManager r1, CharSequence r2) {
        this.$this_setText = r1;
        this.$text = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1578invoke() {
        ClipboardManager r9 = this.$this_setText;
        CharSequence r10 = this.$text;
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r10};
        b r14 = new b();
        a r1 = (a) ApiHookConfig.b.get(101812);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r5 = r8[r6];
        int r18 = r6;
        int r19 = r7;
        f06.a[] r20 = r8;
        d r3 = r5.preInvoke(101812, "android/text/ClipboardManager", "setText", r9, r12, "void", r14);     // Catch: Exception -> L21
        if (r3.a == true) goto L17;
        r11.add(r5);     // Catch: Exception -> L21
    L17:
        if (r3.a == true) goto L27;
        r9.setText(r10);
        return;
    L27:
        return;
    L14:
        r6 = r18 + 1;
        r7 = r19;
        r8 = r20;
        goto L8
    L15:
        r3 = new d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1578invoke();
        return Unit.INSTANCE;
    }
}
