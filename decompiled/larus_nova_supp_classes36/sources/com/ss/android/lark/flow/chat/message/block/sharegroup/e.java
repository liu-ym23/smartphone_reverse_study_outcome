package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareGroupChatContent.GroupState.values().length];
            a = r0;
            r0[ShareGroupChatContent.GroupState.ALREADY_IN_GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            a[ShareGroupChatContent.GroupState.NEED_APPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            a[ShareGroupChatContent.GroupState.SHARE_EXPIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            a[ShareGroupChatContent.GroupState.PENDING_APPROVAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            a[ShareGroupChatContent.GroupState.INVITER_LEFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            a[ShareGroupChatContent.GroupState.GROUP_DISBANDED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            a[ShareGroupChatContent.GroupState.SHARING_DISABLED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            a[ShareGroupChatContent.GroupState.NO_EXTERNAL_COMMUNICATION_AUTHORITY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            a[ShareGroupChatContent.GroupState.GROUP_IS_FULL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            a[ShareGroupChatContent.GroupState.EXTERNAL_USERS_CANNOT_OPERATE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            a[ShareGroupChatContent.GroupState.SHARE_CARD_CERTIFIED_REFUSE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static void b(ShareGroupChatContent.GroupState r10, TextView r11, TextView r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        Context r0 = r11.getContext();
        int r1 = 2131103352;
        boolean r2 = true;
        int r5 = 2131108883;
        int r6 = 2131890753;
        int r7 = 2131890853;
        switch(a.a[r10.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L6:
        int r13 = 2131102049;
        int r3 = 2131102063;
        boolean r4 = true;
        boolean r8 = true;
        int r9 = 2131108882;
        int r14 = 2131108883;
        int r15 = 2131891855;
        int r16 = 2131890853;
    L22:
        if (r12 == null) goto L24;
        r12.setText(r16);
    L24:
        if (r2 == false) goto L34;
        if (r14 == 0) goto L34;
        r11.setVisibility(0);
        r11.setText(r15);
        r11.setEnabled(r4);
        if (r8 == false) goto L31;
        r11.setTextColor(UDColorUtils.getColor(r0, r3));
        r11.setBackgroundColor(UDColorUtils.getColor(r0, r13));
        if ((r11 instanceof UDButton) == false) goto L36;
        ((UDButton) r11).setStrokeWidth(0);
        return;
    L36:
        return;
    L31:
        r11.setTextColor(UDColorUtils.getColor(r0, r14));
        r11.setBackgroundColor(0);
        if ((r11 instanceof UDButton) == false) goto L38;
        UDButton r17 = (UDButton) r11;
        r17.setStrokeColor(UDColorUtils.getColor(r0, r9));
        r17.setStrokeWidth(UIUtils.dp2px(r0, 1.0f));
        return;
    L38:
        return;
    L34:
        r11.setVisibility(4);
        return;
    L7:
        int r18 = 2131890841;
    L16:
        r2 = false;
        r6 = 0;
    L17:
        r5 = 2131106610;
        r7 = r18;
        boolean r19 = false;
    L21:
        r4 = r19;
        r15 = r6;
        r16 = r7;
        r13 = 0;
        r9 = r1;
        r14 = r5;
        r3 = 0;
        r8 = false;
        goto L22
    L8:
        r18 = 2131890758;
        goto L16
    L9:
        r18 = 2131891800;
        goto L16
    L10:
        r18 = 2131890826;
        goto L16
    L11:
        r18 = 2131890786;
        goto L16
    L12:
        r18 = 2131890778;
        goto L16
    L13:
        r18 = 2131890789;
        goto L16
    L14:
        r18 = 2131890797;
        goto L17
    L15:
        r18 = 2131891716;
        goto L16
    L18:
        r1 = 2131108882;
    L20:
        r19 = true;
        goto L21
    L19:
        r7 = 2131891709;
        r6 = 2131892046;
        r5 = 2131106622;
        goto L20
    }

    public static void a(Chat r2, Message r3, boolean r4, String r5) {
        Map r6 = ChatParamUtils.g(r3);
        if (r4 == false) goto L5;
        String r0 = "true";
    L6:
        r6.put("is_toast_remind", r0);
        if (r4 == false) goto L10;
        if (r5 == null) goto L10;
        r6.put("toast_remind", r5);
    L10:
        ChatHitPointNew.f(r2, "group_card_button_share", "none", r6);
        return;
    L5:
        r0 = "false";
        goto L6
    }
}
