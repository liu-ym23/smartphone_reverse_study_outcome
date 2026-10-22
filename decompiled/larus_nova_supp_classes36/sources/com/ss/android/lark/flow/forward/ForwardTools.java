package com.ss.android.lark.flow.forward;

import android.text.TextUtils;
import com.larksuite.framework.utils.f0;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardTools {

    public static final enum RecentVisitTargetType extends Enum<RecentVisitTargetType> {
        public static final RecentVisitTargetType CHAT = null;
        public static final RecentVisitTargetType MSG_THREAD = null;
        public static final RecentVisitTargetType THREAD = null;
        public static final /* synthetic */ RecentVisitTargetType[] a = null;
        private final int value;

        static {
            RecentVisitTargetType r0 = new RecentVisitTargetType("CHAT", 0, 1);
            CHAT = r0;
            RecentVisitTargetType r1 = new RecentVisitTargetType("THREAD", 1, 4);
            THREAD = r1;
            RecentVisitTargetType r4 = new RecentVisitTargetType("MSG_THREAD", 2, 11);
            MSG_THREAD = r4;
            a = new RecentVisitTargetType[]{r0, r1, r4};
        }

        public static RecentVisitTargetType[] values() {
            return (RecentVisitTargetType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$000(RecentVisitTargetType r0) {
            return r0.value;
        }

        public static RecentVisitTargetType fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 4) goto L13;
            if (r1 == 11) goto L11;
            return null;
        L11:
            return MSG_THREAD;
        L13:
            return THREAD;
        L15:
            return CHAT;
        }

        public static RecentVisitTargetType valueOf(String r1) {
            return (RecentVisitTargetType) r27.a.a(RecentVisitTargetType.class, r1);
        }

        public RecentVisitTargetType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatterNameDisplayRule.values().length];
            a = r0;
            r0[ChatterNameDisplayRule.ALIAS_NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ChatterNameDisplayRule.NICKNAME_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ChatterNameDisplayRule.ALIAS_NICKNAME_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ChatterNameDisplayRule.NICKNAME_ALIAS_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ChatterNameDisplayRule.NICKNAME_WITH_ALIAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String a(Chatter r6, ChatterNameDisplayRule r7) {
        String r0 = "";
        if (r6 != null) goto L6;
        return "";
    L6:
        if ((r6 instanceof ChatChatter) == false) goto L12;
        ChatChatter r1 = (ChatChatter) r6;
        if (r1.isOncallDuty() == true) goto L10;
        String r2 = r1.getNickName();
    L13:
        String r3 = r6.getAlias();
        String r4 = r6.getName();
        String r5 = r6.getLocalizedName();
        r6.getEnName();
        int r8 = a.a[r7.ordinal()];
        if (r8 == 1) goto L49;
        if (r8 == 2) goto L46;
        if (r8 == 3) goto L40;
        if (r8 == 4) goto L34;
        if (r8 != 5) goto L52;
        if (f0.a(r2) == true) goto L31;
        StringBuilder r9 = new StringBuilder();
        r9.append(r2);
        if (f0.a(r3) == true) goto L29;
        r0 = String.format("(%s)", new Object[]{r3});
    L29:
        r9.append(r0);
        return r9.toString();
    L31:
        if (f0.a(r3) == true) goto L52;
    L57:
        return r3;
    L52:
        if (TextUtils.isEmpty(r5) == true) goto L55;
        return r5;
    L55:
        return r4;
    L34:
        if (f0.a(r2) == true) goto L37;
        return r2;
    L37:
        if (f0.a(r3) == true) goto L52;
    L40:
        if (f0.a(r3) == false) goto L57;
        if (f0.a(r2) == true) goto L52;
        return r2;
    L46:
        if (f0.a(r2) == true) goto L52;
        return r2;
    L49:
        if (f0.a(r3) == true) goto L52;
    L10:
        return r1.getName();
    L12:
        r2 = null;
        goto L13
    }
}
