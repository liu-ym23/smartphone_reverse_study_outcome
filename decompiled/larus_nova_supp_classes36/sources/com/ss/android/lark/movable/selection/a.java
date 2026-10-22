package com.ss.android.lark.movable.selection;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements h {

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.a$a, reason: collision with other inner class name */
    public static final class C0190a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final boolean a(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        return false;
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final void b(String r4, String r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "markdownStr");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r4.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        return;
    L8:
        Context r8 = r6.getApplicationContext();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = r8.getSystemService("clipboard");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Throwable -> L11
        qf7.a r0 = qf7.a.a;     // Catch: Throwable -> L11
        r0.a((ClipboardManager) r10, ClipData.newPlainText(null, r4), new Token("LARK-PSDA-knowledge_ai_long_selection"));     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L11
        UDToast.show(r8, 2131891641);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        r7 = false;
        goto L6
    }
}
