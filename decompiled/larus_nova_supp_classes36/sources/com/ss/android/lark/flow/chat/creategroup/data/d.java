package com.ss.android.lark.flow.chat.creategroup.data;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.UserRelation;
import com.bytedance.lark.pb.im.v2.GetContactsDoubaoWithDeniedReasonRequest;
import com.bytedance.lark.pb.im.v2.GetContactsDoubaoWithDeniedReasonResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public d() {
    }

    public static int b(char r4) {
        if (r4 != ' ') goto L5;
        return 36;
    L5:
        boolean r0 = false;
        if ('a' <= r4) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        return 35 - (r4 - 'a');
    L14:
        if ('0' <= r4) goto L16;
    L18:
        if (r0 == true) goto L24;
        return -1;
    L24:
        return 9 - (r4 - '0');
    L16:
        if (r4 >= ':') goto L18;
        r0 = true;
        goto L18
    L8:
        if (r4 >= '{') goto L10;
        r3 = true;
        goto L11
    }

    public static String c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        String r4 = ContactMobileUtils.c(r3);
        boolean r1 = true;
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        char r5 = r4.charAt(0);
    L10:
        if ('A' <= r5) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L18;
        return String.valueOf(r5);
    L18:
        if ('a' <= r5) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == true) goto L28;
        return "#";
    L28:
        return String.valueOf(Character.toUpperCase(r5));
    L20:
        if (r5 >= '{') goto L22;
    L12:
        if (r5 >= '[') goto L14;
        r2 = true;
        goto L15
    L8:
        r5 = '#';
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final Pair a(boolean r33, Long r34) {
        GetContactsDoubaoWithDeniedReasonRequest.Builder r2 = new GetContactsDoubaoWithDeniedReasonRequest.Builder();
        if (r33 == false) goto L5;
        r2.strategy(SyncDataStrategy.LOCAL);
    L6:
        r2.action_type = ActionType.INVITE_SAME_CHAT;
        if (r34 == null) goto L9;
        r2.chat_id = r34;
    L9:
        Command r1 = Command.GET_CONTACTS_DOUBAO_WITH_DENIED_REASON;
        final ProtoAdapter r3 = GetContactsDoubaoWithDeniedReasonResponse.ADAPTER;
        SdkSender.d r4 = SdkSender.syncSendMayError(r1, r2, new b(r3));
        if (r4.b == null) goto L16;
        StringBuilder r5 = new StringBuilder("getContactsDoubao error fromLocal=");
        r5.append(r33);
        r5.append(' ');
        ErrorResult r6 = r4.b;
        if (r6 == null) goto L14;
        String r7 = r6.getMessage();
    L15:
        r5.append(r7);
        Log.i("FlowGroupCreateContactRepository", r5.toString());
        goto L16
    L14:
        r7 = null;
    L16:
        GetContactsDoubaoWithDeniedReasonResponse r8 = (GetContactsDoubaoWithDeniedReasonResponse) r4.a;
        if (r8 == null) goto L19;
        List r9 = r8.contacts;
    L20:
        List r10 = r9;
        boolean r11 = true;
        if (r10 != null) goto L23;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == false) goto L29;
        Log.i("FlowGroupCreateContactRepository", "getContactsDoubao empty fromLocal=" + r33);
        return new Pair(CollectionsKt.emptyList(), r4.b);
    L29:
        Log.i("FlowGroupCreateContactRepository", "getContactsDoubao success fromLocal=" + r33 + " count=" + r9.size());
        ArrayList r0 = new ArrayList();
        Iterator r13 = r9.iterator();
    L31:
        if (r13.hasNext() == false) goto L68;
        ContactProfile r14 = (ContactProfile) r13.next();
        int r15 = a.o;
        if (r8 == null) goto L35;
        Map r16 = r8.id2denied_reason;
    L36:
        if (r8 == null) goto L38;
        List r17 = r8.in_chat_chatter_ids;
    L39:
        Intrinsics.checkNotNullParameter(r14, "contactProfile");
        if (r16 != null) goto L42;
    L45:
        boolean r18 = true;
    L46:
        if (r18 == true) goto L54;
        Long r19 = r14.feishu_user_id;
        if (r19 == null) goto L54;
        if (r16.containsKey(r19) == false) goto L54;
        DeniedReason r20 = (DeniedReason) r16.get(r19);
    L55:
        if (r17 != null) goto L57;
    L59:
        boolean r22 = false;
    L60:
        long r110 = r14.feishu_user_id.longValue();
        long r111 = r14.db_user_id.longValue();
        String r112 = r14.name;
        String r113 = r14.alias;
        String r21 = r14.display_name;
        String r23 = r14.display_name_pinyin;
        String r24 = r14.avatar_key;
        String r25 = r14.doubao_key;
        boolean r26 = r14.is_b_user.booleanValue();
        boolean r27 = r14.is_contact_deleted.booleanValue();
        boolean r28 = r14.is_resigned.booleanValue();
        UserRelation r29 = r14.relation;
        if (r29 == null) goto L63;
        int r30 = e.f;
        Intrinsics.checkNotNullParameter(r29, "relation");
        e r210 = new e(r29.is_friend.booleanValue(), r29.request_user_apply.booleanValue(), r29.request_user_apply_id.longValue(), r29.request_user_apply_reason, r29.target_user_apply.booleanValue());
    L64:
        if (r20 != null) goto L66;
        List r211 = null;
    L67:
        r0.add(new a(r110, r111, r112, r113, r21, r23, r24, r25, r26, r27, r22, r28, r210, r211));
        r13 = r13;
        r11 = true;
        goto L31
    L66:
        r211 = CollectionsKt.listOf(r20);
        goto L67
    L63:
        r210 = null;
        goto L64
    L57:
        if (r17.contains(r14.feishu_user_id) != r11) goto L59;
        r22 = true;
    L54:
        r20 = null;
        goto L55
    L42:
        if (r16.isEmpty() == true) goto L45;
        r18 = false;
        goto L46
    L38:
        r17 = null;
        goto L39
    L35:
        r16 = null;
        goto L36
    L68:
        Intrinsics.checkNotNullParameter(r0, "contactList");
        CollectionsKt.sortWith(r0, c.a);
        return new Pair(r0, null);
    L23:
        if (r10.isEmpty() == true) goto L26;
        r12 = false;
        goto L27
    L19:
        r9 = null;
        goto L20
    L5:
        r2.strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }
}
