package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import com.larus.minor.api.IMinorService;
import com.larus.receive.contract.ReceiveTextDelivery;
import com.larus.receive.contract.ReceiveTextDiffContract;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements com.larus.receive.impl.handler.b {
    public String a;
    public com.larus.receive.contract.a.C0019a b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReceiveTextDelivery.values().length];
            r0[ReceiveTextDelivery.FILL_INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReceiveTextDelivery.AUTO_SEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public c() {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return "ReceiveTextHandler";
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("handle, hasText:");
        String r3 = this.a;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r2.append(!r4);
        r2.append(", currentPage:landing");
        r0.i("ReceiveTextHandler", r2.toString());
        com.larus.receive.contract.a.C0019a r1 = this.b;
        String r5 = this.a;
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
    L20:
        if (r1 != null) goto L23;
    L21:
        this.a = null;
        this.b = null;
        return;
    L23:
        int r7 = qs9.a.a;
        String r8 = this.a;
        if (r8 != null) goto L26;
        r8 = "";
    L26:
        ReceiveTextDelivery r10 = r1.a;
        Pair[] r11 = new Pair[5];
        r11[0] = TuplesKt.to("argPreviousPage", "landing");
        int r12 = b.a[r10.ordinal()];
        if (r12 == 1) goto L32;
        if (r12 != 2) goto L31;
        String r13 = "share_to_chat_text";
    L33:
        r11[1] = TuplesKt.to(r13, r8);
        r11[2] = TuplesKt.to("enter_method", "selfshare_open");
        r11[3] = TuplesKt.to("enter_from", "selfshare_open");
        r11[4] = TuplesKt.to("ignore_same_page_check", Boolean.TRUE);
        qs9.a.a(r9, f.c(r11));
        this.a = null;
        this.b = null;
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r13 = "input_text";
        goto L33
    L19:
        if (IMinorService.a.a() == false) goto L21;
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
        goto L17
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r9) {
        Intrinsics.checkNotNullParameter(r9, "intent");
        com.larus.receive.contract.a.C0019a r0 = null;
        this.a = null;
        this.b = null;
        if (ArraysKt.contains(new String[]{"android.intent.action.SEND"}, r9.getAction()) == true) goto L5;
        return false;
    L5:
        this.a = r9.getStringExtra("android.intent.extra.TEXT");
        ReceiveTextDiffContract r1 = ReceiveTextDiffContract.b;
        String r4 = r9.getAction();
        String r5 = r9.getType();
        String r6 = this.a;
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        boolean r8 = !r7;
        List r10 = qs9.a.b(r9);
        if (r10 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        com.larus.receive.contract.a r12 = r1.a(new ps9.a(r4, r5, r8, !r11));
        if ((r12 instanceof com.larus.receive.contract.a.C0019a) == false) goto L22;
        r0 = (com.larus.receive.contract.a.C0019a) r12;
    L22:
        this.b = r0;
        if (r0 == null) goto L26;
        return true;
    L26:
        return false;
    L15:
        if (r10.isEmpty() == true) goto L18;
        r11 = false;
        goto L19
    L8:
        if (r6.length() == 0) goto L11;
        r7 = false;
        goto L12
    }
}
