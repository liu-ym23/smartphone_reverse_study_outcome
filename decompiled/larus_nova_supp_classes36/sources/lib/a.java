package lib;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$TenantCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: lib.a$a, reason: collision with other inner class name */
    public static final class C0293a {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;

        public C0293a() {
            this.a = true;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Condition$TenantCondition.values().length];
            r0[Condition$TenantCondition.ALL_TENANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Condition$TenantCondition.NOT_CROSS_TENANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Condition$TenantCondition.CROSS_TENANT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(SearchBaseInfo r13, BusinessRecentVisitEnableConfig r14) {
        Intrinsics.checkNotNullParameter(r13, "searchBaseInfo");
        Intrinsics.checkNotNullParameter(r14, "enableConfig");
        Log.i("Android_Recent_Visit", "start enableSearchBaseInfo");
        hib.d r1 = com.ss.android.lark.forwardv2.e.a;
        com.ss.android.lark.forwardv2.e.a.a().getPassportDependency().getClass();
        boolean r2 = r13 instanceof SearchShieldP2PChatInfo;
        if (r2 == true) goto L45;
        if ((r13 instanceof SearchChatterInfo) == true) goto L45;
        if ((r13 instanceof SearchChatInfo) == false) goto L31;
        SearchChatInfo r3 = (SearchChatInfo) r13;
        if (r3.getChatMode() != Chat.ChatMode.THREAD) goto L12;
    L17:
        int r4 = Condition$GroupChatTypeCondition.THREAD_CHAT.getValue();
        int r5 = Condition$GroupChatTypeCondition.offset;
    L18:
        int r6 = (r4 << r5) | 0;
        if (r3.isPublic() == false) goto L21;
        int r7 = Condition$PublicTypeCondition.PUBLIC.getValue();
        int r8 = Condition$PublicTypeCondition.offset;
    L22:
        int r9 = r6 | (r7 << r8);
        if (r3.isShield() == false) goto L25;
        int r10 = Condition$ShieldTypeCondition.SHIELD.getValue();
        int r11 = Condition$ShieldTypeCondition.offset;
    L26:
        int r12 = r9 | (r10 << r11);
        if (r3.isCrossTenant() == false) goto L29;
        int r15 = Condition$TenantCondition.CROSS_TENANT.getValue();
        int r16 = Condition$TenantCondition.offset;
    L65:
        int r17 = (r15 << r16) | r12;
    L67:
        if (r14.c.isEmpty() == false) goto L69;
        return true;
    L69:
        Iterator<T> r18 = r14.c.iterator();
    L70:
        boolean r19 = false;
    L72:
        if (r18.hasNext() == false) goto L146;
        EntityItem r20 = (EntityItem) r18.next();
        UserConfig r21 = r20.a;
        if (r21 != null) goto L85;
        if (r20.b != null) goto L85;
        if (r20.d != null) goto L85;
        if (r20.c != null) goto L85;
        if (r20.e == null) goto L72;
    L85:
        if (r21 != null) goto L87;
    L98:
        GroupChatConfig r22 = r20.b;
        if (r22 == null) goto L110;
        if ((r13 instanceof SearchChatInfo) == false) goto L110;
        int r23 = (r22.getShieldTypeCondition().getValue() << Condition$ShieldTypeCondition.offset) | ((((r22.getGroupChatTypeCondition().getValue() << Condition$GroupChatTypeCondition.offset) | 0) | (r22.getPublicTypeCondition().getValue() << Condition$PublicTypeCondition.offset)) | (r22.getTenantCondition().getValue() << Condition$TenantCondition.offset));
        Log.i("Android_Recent_Visit", "groupChatConfigFlag is " + r23 + ", searchBaseInfoFlag is " + r17);
        if (r19 == false) goto L105;
    L108:
        r19 = true;
        goto L110
    L105:
        if ((r17 & r23) == r23) goto L108;
        r19 = false;
    L110:
        if (r20.c != null) goto L112;
    L122:
        ThreadConfig r24 = r20.d;
        if (r24 == null) goto L136;
        if ((r13 instanceof SearchThreadInfo) == false) goto L127;
    L128:
        int r25 = (r24.getThreadTypeCondition().getValue() << Condition$ThreadTypeCondition.offset) | ((r24.getTenantCondition().getValue() << Condition$TenantCondition.offset) | 0);
        Log.i("Android_Recent_Visit", "threadConfigFlag is " + r25 + ", searchBaseInfoFlag is " + r17);
        if (r19 == false) goto L131;
    L134:
        r19 = true;
        goto L136
    L131:
        if ((r17 & r25) == r25) goto L134;
        r19 = false;
        goto L136
    L127:
        if ((r13 instanceof SearchReplyInThreadInfo) == true) goto L128;
    L136:
        if (r20.e == null) goto L72;
        if ((r13 instanceof SearchChatterInfo) == false) goto L72;
        if (((SearchChatterInfo) r13).getChatterType() != Chatter.ChatterType.AI) goto L72;
        Log.i("Android_Recent_Visit", "aiConfigFlag is 0, searchBaseInfoFlag is " + r17);
        if (r19 == false) goto L144;
    L145:
        r19 = true;
        goto L72
    L144:
        if ((r17 & 0) != 0) goto L70;
    L112:
        if ((r13 instanceof SearchChatterInfo) == false) goto L122;
        if (((SearchChatterInfo) r13).getChatterType() != Chatter.ChatterType.BOT) goto L122;
        Log.i("Android_Recent_Visit", "botConfigFlag is 0, searchBaseInfoFlag is " + r17);
        if (r19 == false) goto L118;
    L121:
        r19 = true;
        goto L122
    L118:
        if ((r17 & 0) == 0) goto L121;
        r19 = false;
        goto L122
    L87:
        if ((r13 instanceof SearchChatterInfo) == true) goto L89;
    L90:
        if (r2 == false) goto L98;
    L91:
        int r26 = (r21.getShieldTypeCondition().getValue() << Condition$ShieldTypeCondition.offset) | (((r21.getTenantCondition().getValue() << Condition$TenantCondition.offset) | 0) | (r21.getUserTypeCondition().getValue() << Condition$UserTypeCondition.offset));
        Log.i("Android_Recent_Visit", "userConfigFlag is " + r26 + ", searchBaseInfoFlag is " + r17);
        if (r19 == false) goto L94;
    L97:
        r19 = true;
        goto L98
    L94:
        if ((r17 & r26) == r26) goto L97;
        r19 = false;
        goto L98
    L89:
        if (((SearchChatterInfo) r13).getChatterType() == Chatter.ChatterType.USER) goto L91;
    L146:
        Log.i("Android_Recent_Visit", "end enableSearchBaseInfo, " + r13.getId() + " result: " + r19);
        return r19;
    L29:
        r15 = Condition$TenantCondition.NOT_CROSS_TENANT.getValue();
        r16 = Condition$TenantCondition.offset;
        goto L65
    L25:
        r10 = Condition$ShieldTypeCondition.NORMAL.getValue();
        r11 = Condition$ShieldTypeCondition.offset;
        goto L26
    L21:
        r7 = Condition$PublicTypeCondition.PRIVATE.getValue();
        r8 = Condition$PublicTypeCondition.offset;
        goto L22
    L12:
        if (r3.getChatMode() == Chat.ChatMode.THREAD_V2) goto L17;
        if (r3.getChatDisplayModeSetting() == ChatDisplayModeSetting.THREAD) goto L17;
        r4 = Condition$GroupChatTypeCondition.DEFAULT_CHAT.getValue();
        r5 = Condition$GroupChatTypeCondition.offset;
        goto L18
    L31:
        if ((r13 instanceof SearchReplyInThreadInfo) == true) goto L37;
        if ((r13 instanceof SearchThreadInfo) == true) goto L37;
        Log.e("Android_Recent_Visit", "searchBaseInfo is others error!!!");
    L48:
        r17 = 0;
    L37:
        if ((r13 instanceof SearchThreadInfo) == false) goto L39;
        int r27 = Condition$ThreadTypeCondition.CHAT_THREAD.getValue();
        int r28 = Condition$ThreadTypeCondition.offset;
    L40:
        r12 = (r27 << r28) | 0;
        if (r13.isCrossTenant() == false) goto L43;
        r15 = Condition$TenantCondition.CROSS_TENANT.getValue();
        r16 = Condition$TenantCondition.offset;
        goto L65
    L43:
        r15 = Condition$TenantCondition.NOT_CROSS_TENANT.getValue();
        r16 = Condition$TenantCondition.offset;
        goto L65
    L39:
        r27 = Condition$ThreadTypeCondition.MSG_THREAD.getValue();
        r28 = Condition$ThreadTypeCondition.offset;
    L45:
        if ((r13 instanceof SearchChatterInfo) == false) goto L50;
        if (((SearchChatterInfo) r13).getChatterType() == Chatter.ChatterType.BOT) goto L48;
    L50:
        if (r13.isCrossTenant() == false) goto L52;
        int r29 = Condition$TenantCondition.CROSS_TENANT.getValue();
        int r30 = Condition$TenantCondition.offset;
    L53:
        r17 = (r29 << r30) | 0;
        if ((r13 instanceof SearchShieldP2PChatInfo) == false) goto L57;
        r17 = (r17 | (Condition$ShieldTypeCondition.SHIELD.getValue() << Condition$ShieldTypeCondition.offset)) | (Condition$UserTypeCondition.OTHERS.getValue() << Condition$UserTypeCondition.offset);
    L57:
        if ((r13 instanceof SearchChatterInfo) == false) goto L67;
        SearchChatterInfo r31 = (SearchChatterInfo) r13;
        if (r31.getChatterType() != Chatter.ChatterType.USER) goto L67;
        int r32 = r17 | (Condition$ShieldTypeCondition.NORMAL.getValue() << Condition$ShieldTypeCondition.offset);
        if (Intrinsics.areEqual(r31.getId(), "") == false) goto L63;
        int r33 = Condition$UserTypeCondition.SELF.getValue();
        r16 = Condition$UserTypeCondition.offset;
    L64:
        int r110 = r33;
        r12 = r32;
        r15 = r110;
        goto L65
    L63:
        r33 = Condition$UserTypeCondition.OTHERS.getValue();
        r16 = Condition$UserTypeCondition.offset;
        goto L64
    L52:
        r29 = Condition$TenantCondition.NOT_CROSS_TENANT.getValue();
        r30 = Condition$TenantCondition.offset;
        goto L53
    }
}
