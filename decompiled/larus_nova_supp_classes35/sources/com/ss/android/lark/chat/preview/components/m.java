package com.ss.android.lark.chat.preview.components;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ HashMap<Integer, String> b;
    public final /* synthetic */ View c;

    public final void onItemClick(int r8) {
        k r0 = this.a;
        String r9 = this.b.get(Integer.valueOf(r8));
        Context r1 = this.c.getContext();
        r0.getClass();
        if (Intrinsics.areEqual(r9, "show_copy") == false) goto L14;
        String r10 = r0.h.c;
        if (TextUtils.isEmpty(r10) == true) goto L45;
        Object r2 = r1.getSystemService("clipboard");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r3 = (ClipboardManager) r2;
        ClipData r11 = ClipData.newPlainText(BuildConfig.FLAVOR, com.ss.android.lark.utils.o.c(r10));     // Catch: Exception -> L9 SensitiveAPIException -> L11
        qf7.a r4 = qf7.a.a;     // Catch: Exception -> L9 SensitiveAPIException -> L11
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L9 SensitiveAPIException -> L11
        r4.a(r3, r11, r0.m);     // Catch: Exception -> L9 SensitiveAPIException -> L11
        UDToast.show(r1, 2131891640);     // Catch: Exception -> L9 SensitiveAPIException -> L11
    L52:
        return;
    L9:
        e = move-exception;
        Log.e("[URLPreview]PreviewTitleComponent", "Copy failed", e, true);
        return;
    L11:
        e = move-exception;
        UDToast.show(r1, 2131891032);
        Log.e("[URLPreview]PreviewTitleComponent", "Copy failed: " + e.getMessage());
        return;
    L45:
        return;
    L14:
        if (Intrinsics.areEqual(r9, "close_preview") == false) goto L48;
        URLPreviewParams r12 = r0.h;
        if (r12.a != null) goto L18;
    L41:
        Log.i("[URLPreview]PreviewTitleComponent", "previewId: " + r0.h.a + " or msgId:" + r0.h.g + " is null, close preview failed");
        return;
    L18:
        if (r12.g == null) goto L41;
        com.ss.android.lark.storage.kv.repo.a r13 = h6b.f.a();
        URLPreviewParams r5 = r0.h;
        if (r5.b == false) goto L25;
        String r6 = r5.g;
        if (r6 != null) goto L24;
        r6 = BuildConfig.FLAVOR;
    L24:
        r13.putBoolean(r6, true);
    L29:
        r6c.a r7 = ((q6c.a) r0).a;
        vcb.a r14 = null;
        if ((r7 instanceof vcb.d) == false) goto L32;
        vcb.d r15 = (vcb.d) r7;
    L33:
        if (r15 == null) goto L35;
        r14 = r15.c;
    L35:
        WeakReference r16 = new WeakReference(r14);
        if (r16.get() != null) goto L38;
        Log.i("[URLPreview]PreviewTitleComponent", "callback is null");
        return;
    L38:
        vcb.a r17 = (vcb.a) r16.get();
        if (r17 == null) goto L50;
        r17.a(r0.h.a, BuildConfig.FLAVOR);
        return;
    L50:
        return;
    L32:
        r15 = null;
        goto L33
    L25:
        String r18 = r5.a;
        if (r18 != null) goto L28;
        r18 = BuildConfig.FLAVOR;
    L28:
        r13.putBoolean(r18, true);
        goto L29
    }

    public m(k r1, HashMap<Integer, String> r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
