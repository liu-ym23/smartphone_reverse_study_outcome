package com.obric.assistant.privacy.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.t1;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.lisitem.OCardListItem;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r5, String r6) {
        int r0 = com.obric.assistant.reporter.a.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("privacy_policy", "currentPage");
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        StringBuilder r1 = new StringBuilder();
        JSONObject r2 = new JSONObject();
        r2.put("current_page", "privacy_policy");
        r2.put("button_type", r6);
        r1.append(r2);
        r1.append('\n');
        String r7 = r1.toString();
        PolarisFileWrapper r3 = new PolarisFileWrapper(r5.getFilesDir(), "obric_dialog_click_cache.txt");     // Catch: Exception -> L28
        if (r3.exists() == true) goto L6;
        r3.createNewFile();     // Catch: Exception -> L28
    L6:
        RandomAccessFile r8 = new RandomAccessFile(r3, "rw");     // Catch: Exception -> L28
        FileChannel r4 = r8.getChannel();     // Catch: Throwable -> L23
        FileLock r9 = r4.lock();     // Catch: Throwable -> L18
        r8.seek(r3.length());     // Catch: Throwable -> L15
        r8.write(r7.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L15
        r8.getFD().sync();     // Catch: Throwable -> L15
        r9.release();     // Catch: Throwable -> L18
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L28
        return;
    L15:
        th = move-exception;
        r9.release();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.toString();
    }

    public static OCardListItem b(View r4, String r5) {
        if ((r4 instanceof OCardListItem) == false) goto L12;
        OCardListItem r0 = (OCardListItem) r4;
        CharSequence r2 = r0.getTitle();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L9:
        if (Intrinsics.areEqual(r3, r5) == false) goto L12;
        return r0;
    L7:
        r3 = null;
    L12:
        if ((r4 instanceof ViewGroup) == false) goto L19;
        ViewGroup r6 = (ViewGroup) r4;
        int r1 = r6.getChildCount();
        int r7 = 0;
    L14:
        if (r7 >= r1) goto L19;
        OCardListItem r8 = b(r6.getChildAt(r7), r5);
        if (r8 != null) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        return r8;
    L19:
        return null;
    }

    public static void c(final Context r4, boolean r5, final com.obric.oui.privacy.c r6, final String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "switchTitle");
        if (r5 == false) goto L6;
        t1.a.u1(true);
        return;
    L6:
        com.obric.oui.dialog.v2.alert.g r8 = new com.obric.oui.dialog.v2.alert.g(r4);
        r8.w = false;
        String r1 = r4.getString(2131912519);
        r8.j = false;
        r8.h = r1;
        r8.i = r4.getString(2131912517);
        com.obric.oui.dialog.v2.alert.g.c(r8);
        r8.d(r4.getString(2131912518), new a(r4), ButtonStyleController.TextColorType.Negative);
        r8.h(r4.getString(2131912516), new b(r4, r6, r7));
        com.obric.oui.dialog.v2.alert.c r9 = r8.a();
        r9.setCancelable(false);
        r9.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    }
}
