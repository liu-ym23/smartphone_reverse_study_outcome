package com.ss.android.lark.keyboard.editor;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.keyboard.editor.KeyboardHintPriority;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.EnumMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements zxa.a {
    public final Map<KeyboardHintPriority, Function2<Chat, Chatter, CharSequence>> a;

    public c() {
        this.a = new EnumMap(KeyboardHintPriority.class);
    }

    public final zxa.c a(Context r8, Chat r9, Chatter r10, zxa.b r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chat");
        boolean r3 = com.ss.android.lark.keyboard.utils.a.a;
        KeyboardHintPriority r4 = CollectionsKt.maxOrNull(((EnumMap) this.a).keySet());
        if (r4 != null) goto L5;
        Function2 r5 = null;
    L6:
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chat");
        boolean r0 = false;
        if (r10 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L15;
        int r12 = u6b.a.b;
        CharSequence r13 = u6b.a.a.a(UIHelper.getString(2131891592));
    L44:
        if (r10 != null) goto L46;
    L48:
        boolean r14 = false;
    L49:
        if (r14 == false) goto L51;
    L59:
        Intrinsics.checkNotNullParameter(r9, "chat");
        if (r9.isAllowPost() == false) goto L62;
        int r15 = UIHelper.getColor(2131106620);
    L64:
        return new zxa.c(r13, r15);
    L62:
        r15 = UIHelper.getColor(2131108718);
        goto L64
    L51:
        if (r9.isAllowPost() == false) goto L59;
        if (r11 == null) goto L59;
        CharSequence r16 = r11.b();
        Log.i("ChatKBPluginUtil", "iInputBoxHitInterceptor currentHint:" + r13.length() + " interceptHint:" + r16.length());
        if (r16.length() <= 0) goto L57;
        r0 = true;
    L57:
        if (r0 == false) goto L59;
        r11.a(r13);
        r13 = r16;
        goto L59
    L46:
        if (r10.isDimission() != true) goto L48;
        r14 = true;
        goto L49
    L15:
        if (r9.isAllowPost() == false) goto L38;
        if (r9.getType() != Chat.Type.P2P) goto L19;
    L20:
        Chat.RestrictedModeSetting.OnTimeDelMsgSetting r7 = r9.getRestrictedModeSetting().getOnTimeDelMsgSetting();
        if (r7 != null) goto L23;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == false) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L31;
        r13 = UIHelper.getString(2131891307);
        Intrinsics.checkNotNull(r13);
        goto L44
    L31:
        if (r5 == null) goto L34;
        r13 = (CharSequence) r5.invoke(r9, r10);
        goto L44
    L34:
        if (com.ss.android.lark.keyboard.utils.a.a == false) goto L36;
        r13 = UIUtils.getString(r8, 2131890160);
        Intrinsics.checkNotNull(r13);
        goto L44
    L36:
        r13 = UIUtils.getString(r8, 2131890159);
        Intrinsics.checkNotNull(r13);
    L28:
        r18 = false;
        goto L29
    L23:
        if (r7.getStatus() != true) goto L25;
        r17 = true;
        goto L26
    L19:
        if (r9.getType() != Chat.Type.GROUP) goto L28;
    L38:
        if (r9.isFrozen() == false) goto L41;
        int r19 = u6b.a.b;
        r13 = u6b.a.a.a(UIHelper.getString(2131891013));
        goto L44
    L41:
        if (r9.getAdminPostSetting() != Chat.AdminPostSetting.BANNED_POST) goto L43;
        int r20 = u6b.a.b;
        r13 = u6b.a.a.a(UIHelper.getString(2131891020));
        goto L44
    L43:
        int r21 = u6b.a.b;
        r13 = u6b.a.a.a(UIHelper.getString(2131890783));
        goto L44
    L9:
        if (r10.isDimission() != true) goto L11;
        r6 = true;
        goto L12
    L5:
        r5 = (Function2) ((EnumMap) this.a).get(r4);
        goto L6
    }
}
