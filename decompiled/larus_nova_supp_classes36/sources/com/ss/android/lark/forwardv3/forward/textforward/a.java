package com.ss.android.lark.forwardv3.forward.textforward;

import android.content.Context;
import com.ss.android.lark.forwardv3.ForwardNewActivity;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    public static void a(Context r6, @TextSource int r7, int r8, ForwardTemplateNew r9) {
        TextSource.Companion.getClass();
        switch(r7) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L18;
        };
    L5:
        String r10 = "DOUBAO_TEXT";
    L19:
        Log.i("TextForward", "start forward text:\nfrom: ".concat(r10));
        if (r6 != null) goto L24;
        Log.e("TextForward", "context is null");
        return;
    L24:
        if (r9.getForwardTargetConfig().d != null) goto L26;
        ForwardTargetConfig r11 = r9.getForwardTargetConfig();
        IncludeConfig.CREATOR.getClass();
        r11.d = IncludeConfig.b.a();
    L26:
        IncludeConfig r12 = r9.getForwardTargetConfig().d;
        if (r12 == null) goto L29;
        EntityItem.a r0 = new EntityItem.a();
        r0.a(new AIConfig());
        r12.a(r0.c());
    L29:
        r9.setType(3);
        if (r9.getForwardConfirmDialogConfig().d != null) goto L36;
        ForwardConfirmDialogConfig r13 = r9.getForwardConfirmDialogConfig();
        BasicDialogContentConfig.a r1 = new BasicDialogContentConfig.a();
        if ((r9.getForwardContent() instanceof TextForwardContent) == false) goto L34;
        IForwardContent r2 = r9.getForwardContent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent");
        String r3 = ((TextForwardContent) r2).b;
    L35:
        Intrinsics.checkNotNullParameter(r3, "content");
        r1.c = r3;
        r13.d = r1.a();
        goto L36
    L34:
        r3 = "";
    L36:
        int r14 = ForwardNewActivity.b;
        ForwardNewActivity.a.a(r6, r9, r8, null, null, 56);
        return;
    L6:
        r10 = "LABS_JSB";
        goto L19
    L7:
        r10 = "APP_LINK";
        goto L19
    L8:
        r10 = "VC_LINK_TEXT";
        goto L19
    L9:
        r10 = "ENTRY_DICTIONARY_TEXT";
        goto L19
    L10:
        r10 = "OLD_MOMENT_TEXT";
        goto L19
    L11:
        r10 = "MINUTE_LIVE_TEXT";
        goto L19
    L12:
        r10 = "MEEGO_URL_TEXT";
        goto L19
    L13:
        r10 = "UD_SHARE_PANEL_TEXT";
        goto L19
    L14:
        r10 = "INVITATION_LARK_TEXT";
        goto L19
    L15:
        r10 = "CCM_DOC_URL_TEXT";
        goto L19
    L16:
        r10 = "APP_CENTER_CUSTOM_TEXT";
        goto L19
    L17:
        r10 = "OCR_TEXT";
        goto L19
    L18:
        r10 = "UNKNOWN";
        goto L19
    }
}
