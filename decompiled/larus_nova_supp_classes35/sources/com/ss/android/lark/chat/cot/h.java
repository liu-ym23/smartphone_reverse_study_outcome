package com.ss.android.lark.chat.cot;

import android.content.Context;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[CotStatus.values().length];
            r0[CotStatus.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L32:
            r0[CotStatus.DONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L42:
            r0[CotStatus.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L34:
            r0[CotStatus.PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            r0[CotStatus.INTERRUPTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L26:
            r0[CotStatus.TIMEOUT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L11:
            a = r0;
            int[] r1 = new int[CotViewBlockType.values().length];
            r1[CotViewBlockType.STEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L38:
            r1[CotViewBlockType.TOOL_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L28:
            r1[CotViewBlockType.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L15:
            b = r1;
        }
    }

    static {
    }

    public static CharSequence a(CotViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        if (r3.getOverallStatus() == CotStatus.RUNNING) goto L5;
        return null;
    L5:
        CotViewBlock r4 = (CotViewBlock) CollectionsKt.lastOrNull(r3.getBlocks());
        if (r4 != null) goto L8;
        return null;
    L8:
        CotViewBlockType r0 = r4.getType();
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L19;
        return null;
    L19:
        return r4.getBody();
    L20:
        return r4.getTitle();
    L18:
        return r4.getTitle();
    }

    public static String c(CotViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        HashMap<String, String> r0 = r4.getRunStatusText();
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        int r1 = a.a[r4.getOverallStatus().ordinal()];
        if (r1 != 1) goto L8;
        CotViewBlock r5 = (CotViewBlock) CollectionsKt.lastOrNull(r4.getBlocks());
        if (r5 == null) goto L23;
        CotViewBlockType r6 = r5.getType();
    L25:
        if (r6 != CotViewBlockType.REASONING) goto L27;
        String r7 = "thinking";
    L28:
        String r8 = r0.get(r7);
        if (r8 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r8)) == true) goto L33;
        return null;
    L33:
        return r8;
    L27:
        r7 = "running";
        goto L28
    L23:
        r6 = null;
        goto L25
    L8:
        if (r1 != 2) goto L10;
        r7 = "done";
        goto L28
    L10:
        if (r1 != 3) goto L12;
        r7 = Keys.API_RETURN_KEY_ERROR;
        goto L28
    L12:
        if (r1 != 4) goto L14;
        r7 = "paused";
        goto L28
    L14:
        if (r1 == 5) goto L16;
        return null;
    L16:
        r7 = "interrupted";
        goto L28
    }

    public static String b(CotViewModel r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r2, "context");
        CotStatus r3 = r1.getOverallStatus();
        switch(a.a[r3.ordinal()]) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return r2.getString(2131890933);
    L13:
        return r2.getString(2131890942);
    L14:
        return r2.getString(2131890939);
    L15:
        return r2.getString(2131890940);
    L16:
        return r2.getString(2131890938);
    L17:
        return r2.getString(2131890937);
    L11:
        return r2.getString(2131890941);
    }
}
