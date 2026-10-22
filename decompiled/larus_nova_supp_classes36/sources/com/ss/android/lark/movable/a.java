package com.ss.android.lark.movable;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.lark.movable.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageKey");
    }

    @Override // com.ss.android.lark.movable.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captionUri");
    }

    public static String e(String r1, String r2, String r3) {
        return new JSONObject(r1).optString(r2);
    L4:
        e = move-exception;
        Log.e("MovableUtils", r3 + " payload parse failed, e: " + e.getMessage());
        return null;
    }

    @Override // com.ss.android.lark.movable.b
    public boolean c(View r2, String r3, com.ss.android.lark.movable.attatchment.b r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r3, "imageKey");
        Intrinsics.checkNotNullParameter(r4, "attachmentInfo");
        return false;
    }

    @Override // com.ss.android.lark.movable.b
    public final void d(Context r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "schema");
        Intrinsics.checkNotNullParameter(r12, "payload");
        boolean r6 = true;
        boolean r7 = false;
        switch(r11.hashCode()) {
            case -1961610058: goto L107;
            case -506252289: goto L72;
            case -504883868: goto L37;
            case 937803688: goto L22;
            case 1938746582: goto L6;
            default: goto L133;
        };
    L133:
        Log.d("MovableUtils", "eventClick: unknow schema");
        return;
    L6:
        if (r11.equals("movableOpenTable") == false) goto L133;
        if (com.ss.android.lark.movable.preview.a.a(r9) == true) goto L157;
        String r13 = e(r12, "text", "handleOpenTablePreview");
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.length() == 0) goto L18;
        r6 = false;
    L18:
        if (r6 == true) goto L159;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r13, "markdown");
        com.ss.android.lark.movable.preview.a.b(r9, 0, r13, r10);
        return;
    L159:
        return;
    L157:
        return;
    L22:
        if (r11.equals("movableOpenCodeBlock") == false) goto L133;
        if (com.ss.android.lark.movable.preview.a.a(r9) == true) goto L160;
        String r14 = e(r12, "text", "handleOpenCodeBlockPreview");
        if (r14 != null) goto L31;
        return;
    L31:
        if (r14.length() != 0) goto L33;
        r7 = true;
    L33:
        if (r7 == true) goto L162;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r14, "markdown");
        com.ss.android.lark.movable.preview.a.b(r9, 1, r14, r10);
        return;
    L162:
        return;
    L160:
        return;
    L37:
        if (r11.equals("openLink") == false) goto L133;
        String r15 = e(r12, "url", "openLink");
        if (r15 != null) goto L43;
        return;
    L43:
        if (r15.length() == 0) goto L46;
        r6 = false;
    L46:
        if (r6 == true) goto L164;
        lsb.a r16 = (lsb.a) ClaymoreServiceLoader.loadFirstOrNull(lsb.a.class);
        if (r16 == null) goto L137;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L52
        Object r18 = Result.constructor-impl(Boolean.valueOf(r16.a()));     // Catch: Throwable -> L52
    L54:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L57;
        Log.e("MovableUtils", "openLink by ILinkOpener failed, url=" + r15 + ", e: " + r19.getMessage());
    L57:
        Boolean r110 = Boolean.FALSE;
        if (Result.isFailure-impl(r18) == false) goto L61;
        r18 = r110;
    L61:
        if (((Boolean) r18).booleanValue() == true) goto L165;
        Log.i("MovableUtils", "openLink: ILinkOpener not handled, fallback to ACTION_VIEW, url=".concat(r15));
        goto L137
    L165:
        return;
    L52:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L137:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L66
        Intent r113 = new Intent("android.intent.action.VIEW", UriProtector.parse(r15));     // Catch: Throwable -> L66
        r113.addFlags(268435456);     // Catch: Throwable -> L66
        r9.startActivity(r113);     // Catch: Throwable -> L66
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L68:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L147;
        Log.e("MovableUtils", "openLink failed, url=" + r15 + ", e: " + r21.getMessage());
        return;
    L147:
        return;
    L66:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L68
    L164:
        return;
    L72:
        if (r11.equals("openProfile") == false) goto L133;
        String r22 = e(r12, "user_id", "openProfile");
        if (r22 != null) goto L78;
        return;
    L78:
        if (r22.length() != 0) goto L80;
        boolean r115 = true;
    L81:
        if (r115 == true) goto L149;
        int r116 = 0;
    L84:
        if (r116 >= r22.length()) goto L94;
        char r117 = r22.charAt(r116);
        if ('0' <= r117) goto L88;
    L90:
        boolean r118 = false;
    L91:
        if (r118 == false) goto L92;
        r116 = r116 + 1;
        goto L84
    L92:
        r6 = false;
        goto L94
    L88:
        if (r117 >= ':') goto L90;
        r118 = true;
    L94:
        if (r6 == false) goto L167;
        lsb.c r119 = (lsb.c) ClaymoreServiceLoader.loadFirstOrNull(lsb.c.class);
        if (r119 != null) goto L139;
        Log.i("MovableUtils", "openProfile: no IProfileOpener impl found, userId=".concat(r22));
        return;
    L139:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L101
        r119.b();     // Catch: Throwable -> L101
        Object r121 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L103:
        Throwable r122 = Result.exceptionOrNull-impl(r121);
        if (r122 == null) goto L151;
        Log.e("MovableUtils", "openProfile failed, userId=" + r22 + ", e: " + r122.getMessage());
        return;
    L151:
        return;
    L101:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L167:
        return;
    L149:
        return;
    L80:
        r115 = false;
        goto L81
    L107:
        if (r11.equals("clipboardWriteText") == false) goto L133;
        String r23 = e(r12, "text", "clipboardWriteText");
        if (r23 != null) goto L113;
        return;
    L113:
        if (r23.length() == 0) goto L116;
        r6 = false;
    L116:
        if (r6 == true) goto L169;
        Application r124 = com.larksuite.framework.utils.b.a;
        if (r124 != null) goto L121;
        Log.w("MovableUtils", "clipboardWriteText: app context is null");
        return;
    L121:
        Object r125 = r124.getSystemService("clipboard");
        if ((r125 instanceof ClipboardManager) == false) goto L124;
        ClipboardManager r126 = (ClipboardManager) r125;
    L125:
        if (r126 != null) goto L141;
        Log.w("MovableUtils", "clipboardWriteText: ClipboardManager is null");
        return;
    L141:
        qf7.a.a.a(r126, ClipData.newPlainText("", r23), new Token("LARK-PSDA-movable-default-clipboard-write"));     // Catch: Exception -> L129 SensitiveAPIException -> L131
        UDToast.show(r124, 2131891640);     // Catch: Exception -> L129 SensitiveAPIException -> L131
    L170:
        return;
    L129:
        e = move-exception;
        Log.e("MovableUtils", "clipboardWriteText failed, e: " + e.getMessage());
        return;
    L131:
        e = move-exception;
        Log.e("MovableUtils", "clipboardWriteText forbidden by sensitive policy: " + e.getMessage());
        UDToast.show(r124, 2131891032);
        return;
    L124:
        r126 = null;
        goto L125
    }
}
