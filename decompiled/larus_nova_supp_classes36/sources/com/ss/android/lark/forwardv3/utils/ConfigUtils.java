package com.ss.android.lark.forwardv3.utils;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.forwardv3.ForwardImServices;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Shield;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Status;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$UserType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ConfigUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int g = 0;
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.utils.ConfigUtils$a$a, reason: collision with other inner class name */
        public static final class C0076a {
            public static a a(boolean r3) {
                a r0 = new a();
                if (r3 == false) goto L5;
                r0.a = true;
                r0.b = true;
                r0.c = true;
                r0.d = true;
                r0.e = true;
                r0.f = false;
            L6:
                return r0;
            L5:
                r0.a = false;
                r0.b = false;
                r0.c = false;
                r0.d = false;
                r0.e = false;
                r0.f = true;
                goto L6
            }
        }

        static {
        }

        public a() {
            this.f = true;
        }
    }

    public static final class b {
        public static final /* synthetic */ int g = 0;
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;

        public static final class a {
        }

        static {
        }

        public b() {
            this.a = true;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[Condition$UserType.values().length];
            r0[Condition$UserType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            r0[Condition$UserType.SELF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L48:
            r0[Condition$UserType.OTHERS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L8:
            a = r0;
            int[] r1 = new int[Condition$Tenant.values().length];
            r1[Condition$Tenant.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L38:
            r1[Condition$Tenant.CROSS_TENANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L50:
            r1[Condition$Tenant.NOT_CROSS_TENANT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L12:
            b = r1;
            int[] r2 = new int[Condition$GroupType.values().length];
            r2[Condition$GroupType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L32:
            r2[Condition$GroupType.THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L40:
            r2[Condition$GroupType.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L16:
            c = r2;
            int[] r3 = new int[Chatter.ChatterType.values().length];
            r3[Chatter.ChatterType.BOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L34:
            r3[Chatter.ChatterType.AI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L19:
            d = r3;
        }
    }

    static {
    }

    public static boolean a(List r11, SearchBaseInfo r12) {
        boolean r0 = r12 instanceof SearchChatInfo;
        if (r0 == false) goto L26;
        SearchChatInfo r4 = (SearchChatInfo) r12;
        if (r4.getChatMode() != Chat.ChatMode.THREAD) goto L7;
    L12:
        int r5 = Condition$GroupType.THREAD.getValue();
    L13:
        int r6 = (r5 << 4) | 0;
        if (r4.isCrossTenant() == false) goto L16;
        int r7 = Condition$Tenant.CROSS_TENANT.getValue();
    L17:
        int r8 = r6 | (r7 << 0);
        if (r4.isShield() == false) goto L20;
        int r9 = Condition$Shield.SHIELD.getValue();
    L21:
        int r10 = r8 | (r9 << 8);
        if (r4.isPublic() == false) goto L24;
        int r13 = Condition$Status.PUBLIC.getValue();
    L25:
        int r14 = r13 << 6;
    L96:
        int r15 = r14 | r10;
    L98:
        Iterator r16 = r11.iterator();
    L99:
        boolean r17 = false;
    L101:
        if (r16.hasNext() == false) goto L174;
        EntityItem r18 = (EntityItem) r16.next();
        if (r18.a != null) goto L113;
        if (r18.b != null) goto L113;
        if (r18.c != null) goto L113;
        if (r18.d != null) goto L113;
        if (r18.e == null) goto L101;
    L113:
        if (r0 == true) goto L114;
        boolean r19 = r12 instanceof SearchChatterInfo;
        if (r19 == true) goto L139;
        if ((r12 instanceof SearchShieldP2PChatInfo) == true) goto L139;
        if ((r12 instanceof SearchThreadInfo) == true) goto L131;
        if ((r12 instanceof SearchReplyInThreadInfo) == false) goto L101;
    L131:
        ThreadConfig r20 = r18.d;
        if (r20 == null) goto L101;
        int r21 = ((r20.getThreadType().getValue() << 10) | 0) | (r20.getTenant().getValue() << 0);
        int r22 = (r20.getStatus().getValue() << 6) | r21;
        if (r17 == false) goto L137;
    L173:
        r17 = true;
        goto L101
    L137:
        if ((r15 & r22) != r22) goto L99;
    L139:
        if (r19 == true) goto L141;
    L142:
        boolean r23 = r12 instanceof SearchShieldP2PChatInfo;
        if (r23 == false) goto L153;
        if (((SearchShieldP2PChatInfo) r12).getChatterType() != Chatter.ChatterType.BOT) goto L153;
    L147:
        if (r18.c == null) goto L101;
        if (r17 == true) goto L173;
        if ((r15 & 0) != 0) goto L99;
    L153:
        if (r19 == true) goto L155;
    L156:
        if (r23 == false) goto L166;
        if (((SearchShieldP2PChatInfo) r12).getChatterType() != Chatter.ChatterType.AI) goto L166;
    L160:
        if (r18.e == null) goto L101;
        if (r17 == true) goto L173;
        if ((r15 & 0) != 0) goto L99;
    L166:
        UserConfig r24 = r18.a;
        if (r24 == null) goto L101;
        int r25 = ((r24.getTenant().getValue() << 0) | 0) | (r24.getUserType().getValue() << 2);
        int r26 = (r24.getShield().getValue() << 8) | r25;
        if (r17 == true) goto L173;
        if ((r15 & r26) != r26) goto L99;
    L155:
        if (((SearchChatterInfo) r12).getChatterType() == Chatter.ChatterType.AI) goto L160;
    L141:
        if (((SearchChatterInfo) r12).getChatterType() == Chatter.ChatterType.BOT) goto L147;
    L114:
        GroupConfig r27 = r18.b;
        if (r27 == null) goto L101;
        int r28 = (((r27.getGroupType().getValue() << 4) | 0) | (r27.getTenant().getValue() << 0)) | (r27.getStatus().getValue() << 6);
        int r29 = (r27.getShield().getValue() << 8) | r28;
        if (r17 == true) goto L173;
        if ((r15 & r29) != r29) goto L99;
    L174:
        return r17;
    L24:
        r13 = Condition$Status.PRIVATE.getValue();
        goto L25
    L20:
        r9 = Condition$Shield.NORMAL.getValue();
        goto L21
    L16:
        r7 = Condition$Tenant.NOT_CROSS_TENANT.getValue();
        goto L17
    L7:
        if (r4.getChatMode() == Chat.ChatMode.THREAD_V2) goto L12;
        if (r4.getChatDisplayModeSetting() == ChatDisplayModeSetting.THREAD) goto L12;
        r5 = Condition$GroupType.NORMAL.getValue();
        goto L13
    L26:
        int r30 = -1;
        if ((r12 instanceof SearchChatterInfo) == false) goto L43;
        SearchChatterInfo r31 = (SearchChatterInfo) r12;
        Chatter.ChatterType r32 = r31.getChatterType();
        if (r32 == null) goto L32;
        r30 = c.d[r32.ordinal()];
    L32:
        if (r30 == 1) goto L97;
        if (r30 == 2) goto L97;
        String r33 = ForwardModuleV3.a().getLoginUserId();
        if (r31.isCrossTenant() == false) goto L37;
        int r34 = Condition$Tenant.CROSS_TENANT.getValue();
    L38:
        int r35 = ((r34 << 0) | 0) | (Condition$Shield.NORMAL.getValue() << 8);
        if (TextUtils.equals(r31.getId(), r33) == false) goto L41;
        int r36 = Condition$UserType.SELF.getValue();
    L58:
        r15 = (r36 << 2) | r35;
        goto L98
    L41:
        r36 = Condition$UserType.OTHERS.getValue();
        goto L58
    L37:
        r34 = Condition$Tenant.NOT_CROSS_TENANT.getValue();
    L97:
        r15 = 0;
        goto L98
    L43:
        if ((r12 instanceof SearchShieldP2PChatInfo) == false) goto L59;
        SearchShieldP2PChatInfo r37 = (SearchShieldP2PChatInfo) r12;
        Chatter.ChatterType r38 = r37.getChatterType();
        if (r38 == null) goto L48;
        r30 = c.d[r38.ordinal()];
    L48:
        if (r30 == 1) goto L97;
        if (r30 == 2) goto L97;
        String r39 = ForwardModuleV3.a().getLoginUserId();
        if (r37.isCrossTenant() == false) goto L53;
        int r40 = Condition$Tenant.CROSS_TENANT.getValue();
    L54:
        r35 = ((r40 << 0) | 0) | (Condition$Shield.SHIELD.getValue() << 8);
        if (TextUtils.equals(r37.getChatterId(), r39) == false) goto L57;
        r36 = Condition$UserType.SELF.getValue();
        goto L58
    L57:
        r36 = Condition$UserType.OTHERS.getValue();
        goto L58
    L53:
        r40 = Condition$Tenant.NOT_CROSS_TENANT.getValue();
        goto L54
    L59:
        Chat r41 = null;
        if ((r12 instanceof SearchThreadInfo) == false) goto L78;
        ImSdkChatService r42 = (ImSdkChatService) ForwardImServices.a.getValue();
        if (r42 == null) goto L64;
        r41 = r42.we(((SearchThreadInfo) r12).getChatId());
    L64:
        int r43 = (Condition$ThreadType.NORMAL_THREAD.getValue() << 10) | 0;
        if (((SearchThreadInfo) r12).isCrossTenant() == false) goto L67;
        int r44 = Condition$Tenant.CROSS_TENANT.getValue();
    L68:
        r14 = r43 | (r44 << 0);
        if (r41 != null) goto L71;
    L73:
        boolean r45 = false;
    L74:
        if (r45 == false) goto L76;
        int r46 = Condition$Status.PUBLIC.getValue();
    L95:
        r10 = r46 << 6;
        goto L96
    L76:
        r46 = Condition$Status.PRIVATE.getValue();
        goto L95
    L71:
        if (r41.isPublic() != true) goto L73;
        r45 = true;
        goto L74
    L67:
        r44 = Condition$Tenant.NOT_CROSS_TENANT.getValue();
        goto L68
    L78:
        if ((r12 instanceof SearchReplyInThreadInfo) == false) goto L97;
        ImSdkChatService r47 = (ImSdkChatService) ForwardImServices.a.getValue();
        if (r47 == null) goto L82;
        r41 = r47.we(((SearchReplyInThreadInfo) r12).getChatId());
    L82:
        int r48 = (Condition$ThreadType.MSG_THREAD.getValue() << 10) | 0;
        if (((SearchReplyInThreadInfo) r12).isCrossTenant() == false) goto L85;
        int r49 = Condition$Tenant.CROSS_TENANT.getValue();
    L86:
        r14 = r48 | (r49 << 0);
        if (r41 != null) goto L89;
    L91:
        boolean r50 = false;
    L92:
        if (r50 == false) goto L94;
        r46 = Condition$Status.PUBLIC.getValue();
        goto L95
    L94:
        r46 = Condition$Status.PRIVATE.getValue();
        goto L95
    L89:
        if (r41.isPublic() != true) goto L91;
        r50 = true;
        goto L92
    L85:
        r49 = Condition$Tenant.NOT_CROSS_TENANT.getValue();
        goto L86
    }

    public static void b(SearcherConfig r9, IncludeConfig r10) {
        Intrinsics.checkNotNullParameter(r9, "searcherConfig");
        if (CollectionUtils.isEmpty(r10.a) == true) goto L43;
        Iterator r11 = ((ArrayList) r10.a).iterator();
    L7:
        if (r11.hasNext() == false) goto L34;
        EntityItem r0 = (EntityItem) r11.next();
        UserConfig r1 = r0.a;
        if (r1 == null) goto L18;
        Condition$Tenant r2 = r1.getTenant();
        int r3 = c.b[r2.ordinal()];
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L16;
        r9.chatter(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$2.INSTANCE);
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r9.chatter(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$1.INSTANCE);
    L18:
        GroupConfig r4 = r0.b;
        if (r4 == null) goto L29;
        Condition$Tenant r5 = r4.getTenant();
        int r6 = c.b[r5.ordinal()];
        if (r6 == 1) goto L27;
        if (r6 == 2) goto L29;
        if (r6 != 3) goto L26;
        r9.group(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$4.INSTANCE);
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        r9.group(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$3.INSTANCE);
    L29:
        if (r0.c == null) goto L32;
        r9.bot(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$5.INSTANCE);
    L32:
        if (r0.e == null) goto L7;
        r9.ai(true, ConfigUtils$getDouPickerV2ParamsFromForwardV3$1$6.INSTANCE);
        goto L7
    L34:
        Log.i("getPickerV2ParamsFromForwardV3", CollectionsKt.joinToString$default(r9.getEntities().entrySet(), ", ", null, null, 0, null, ConfigUtils$getDouPickerV2ParamsFromForwardV3$searcherConfigOutput$1.INSTANCE, 30, null));
        return;
    }

    public static void c(SearcherConfig r9, IncludeConfig r10) {
        Intrinsics.checkNotNullParameter(r9, "searcherConfig");
        if (r10 != null) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r10.a) == true) goto L46;
        Iterator r11 = ((ArrayList) r10.a).iterator();
    L9:
        if (r11.hasNext() == false) goto L36;
        EntityItem r0 = (EntityItem) r11.next();
        UserConfig r1 = r0.a;
        if (r1 == null) goto L20;
        Condition$Tenant r2 = r1.getTenant();
        int r3 = c.b[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L18;
        r9.chatter(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$2.INSTANCE);
        goto L20
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r9.chatter(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$1.INSTANCE);
    L20:
        GroupConfig r4 = r0.b;
        if (r4 == null) goto L31;
        Condition$Tenant r5 = r4.getTenant();
        int r6 = c.b[r5.ordinal()];
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L31;
        if (r6 != 3) goto L28;
        r9.group(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$4.INSTANCE);
        goto L31
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        r9.group(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$3.INSTANCE);
    L31:
        if (r0.c == null) goto L34;
        r9.bot(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$5.INSTANCE);
    L34:
        if (r0.e == null) goto L9;
        r9.ai(true, ConfigUtils$getPickerV2ParamsFromForwardV3$1$6.INSTANCE);
        goto L9
    L36:
        Log.i("getPickerV2ParamsFromForwardV3", CollectionsKt.joinToString$default(r9.getEntities().entrySet(), ", ", null, null, 0, null, ConfigUtils$getPickerV2ParamsFromForwardV3$searcherConfigOutput$1.INSTANCE, 30, null));
        return;
    }
}
