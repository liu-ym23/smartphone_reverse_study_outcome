package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.bytedance.lark.pb.openplatform.v1.CommonGadgetPushRequest;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesResponse;
import com.bytedance.lark.pb.openplatform.v1.PushAppsNeedUpdateRequest;
import com.bytedance.lark.pb.openplatform.v1.PushOpenAppBadgeNodesRequest;
import com.bytedance.lark.sdk.refactor.q;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o1b.e;
import o1b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r8) {
        q r9 = (q) r8;
        WeakReference<b> r0 = this.a.a;
        if (r0 == null) goto L157;
        b r1 = r0.get();
        if (r1 == 0) goto L158;
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r9, "response");
        Command r3 = r9.a;     // Catch: Exception -> L141
        Command r4 = Command.PUSH_OPEN_APP_BADGE_NODES;     // Catch: Exception -> L141
        boolean r5 = Intrinsics.areEqual(r3, r4);     // Catch: Exception -> L141
        Object r6 = BuildConfig.FLAVOR;
        if (r5 == false) goto L26;
        MGetChattersResponse r10 = (PushOpenAppBadgeNodesRequest) PushOpenAppBadgeNodesRequest.ADAPTER.decode(r9.a());     // Catch: Exception -> L141
        int r2 = r4.getValue();     // Catch: Exception -> L141
        int r7 = f.a;     // Catch: Exception -> L141
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L141
        if (Intrinsics.areEqual(PushOpenAppBadgeNodesRequest.class, MGetChattersResponse.class) == false) goto L14;
        r6 = o1b.b.b(r10);     // Catch: Exception -> L141
    L25:
        r1.a(r2, r6);     // Catch: Exception -> L141
        return;
    L14:
        if (Intrinsics.areEqual(PushOpenAppBadgeNodesRequest.class, PullOpenAppBadgeNodesResponse.class) == false) goto L17;
        r6 = o1b.c.b((PullOpenAppBadgeNodesResponse) r10);     // Catch: Exception -> L141
        goto L25
    L17:
        if (Intrinsics.areEqual(PushOpenAppBadgeNodesRequest.class, PushOpenAppBadgeNodesRequest.class) == false) goto L20;
        r6 = e.a(r10);     // Catch: Exception -> L141
        goto L25
    L20:
        if (Intrinsics.areEqual(PushOpenAppBadgeNodesRequest.class, PushAppsNeedUpdateRequest.class) == false) goto L23;
        r6 = o1b.d.a((PushAppsNeedUpdateRequest) r10);     // Catch: Exception -> L141
        goto L25
    L23:
        if (Intrinsics.areEqual(PushOpenAppBadgeNodesRequest.class, CommonGadgetPushRequest.class) == false) goto L25;
        r6 = o1b.a.a((CommonGadgetPushRequest) r10);     // Catch: Exception -> L141
        goto L25
    L26:
        Command r11 = Command.PUSH_OP_APP_CENTER_UPDATE_V2;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r11) == false) goto L44;
        MGetChattersResponse r12 = (PushAppsNeedUpdateRequest) PushAppsNeedUpdateRequest.ADAPTER.decode(r9.a());     // Catch: Exception -> L141
        int r13 = r11.getValue();     // Catch: Exception -> L141
        int r14 = f.a;     // Catch: Exception -> L141
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L141
        if (Intrinsics.areEqual(PushAppsNeedUpdateRequest.class, MGetChattersResponse.class) == false) goto L32;
        r6 = o1b.b.b(r12);     // Catch: Exception -> L141
    L43:
        r1.a(r13, r6);     // Catch: Exception -> L141
        return;
    L32:
        if (Intrinsics.areEqual(PushAppsNeedUpdateRequest.class, PullOpenAppBadgeNodesResponse.class) == false) goto L35;
        r6 = o1b.c.b((PullOpenAppBadgeNodesResponse) r12);     // Catch: Exception -> L141
        goto L43
    L35:
        if (Intrinsics.areEqual(PushAppsNeedUpdateRequest.class, PushOpenAppBadgeNodesRequest.class) == false) goto L38;
        r6 = e.a((PushOpenAppBadgeNodesRequest) r12);     // Catch: Exception -> L141
        goto L43
    L38:
        if (Intrinsics.areEqual(PushAppsNeedUpdateRequest.class, PushAppsNeedUpdateRequest.class) == false) goto L41;
        r6 = o1b.d.a(r12);     // Catch: Exception -> L141
        goto L43
    L41:
        if (Intrinsics.areEqual(PushAppsNeedUpdateRequest.class, CommonGadgetPushRequest.class) == false) goto L43;
        r6 = o1b.a.a((CommonGadgetPushRequest) r12);     // Catch: Exception -> L141
        goto L43
    L44:
        Command r15 = Command.GADGET_COMMON_PUSH;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r15) == false) goto L62;
        MGetChattersResponse r16 = (CommonGadgetPushRequest) CommonGadgetPushRequest.ADAPTER.decode(r9.a());     // Catch: Exception -> L141
        int r17 = r15.getValue();     // Catch: Exception -> L141
        int r18 = f.a;     // Catch: Exception -> L141
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L141
        if (Intrinsics.areEqual(CommonGadgetPushRequest.class, MGetChattersResponse.class) == false) goto L50;
        r6 = o1b.b.b(r16);     // Catch: Exception -> L141
    L61:
        r1.a(r17, r6);     // Catch: Exception -> L141
        return;
    L50:
        if (Intrinsics.areEqual(CommonGadgetPushRequest.class, PullOpenAppBadgeNodesResponse.class) == false) goto L53;
        r6 = o1b.c.b((PullOpenAppBadgeNodesResponse) r16);     // Catch: Exception -> L141
        goto L61
    L53:
        if (Intrinsics.areEqual(CommonGadgetPushRequest.class, PushOpenAppBadgeNodesRequest.class) == false) goto L56;
        r6 = e.a((PushOpenAppBadgeNodesRequest) r16);     // Catch: Exception -> L141
        goto L61
    L56:
        if (Intrinsics.areEqual(CommonGadgetPushRequest.class, PushAppsNeedUpdateRequest.class) == false) goto L59;
        r6 = o1b.d.a((PushAppsNeedUpdateRequest) r16);     // Catch: Exception -> L141
        goto L61
    L59:
        if (Intrinsics.areEqual(CommonGadgetPushRequest.class, CommonGadgetPushRequest.class) == false) goto L61;
        r6 = o1b.a.a(r16);     // Catch: Exception -> L141
        goto L61
    L62:
        Command r19 = Command.PUSH_TODO_COMMENT_NOTIFICATION;     // Catch: Exception -> L141
        int r20 = 0;
        if (Intrinsics.areEqual(r3, r19) == false) goto L68;
        int r21 = r19.getValue();     // Catch: Exception -> L141
        byte[] r22 = r9.a();     // Catch: Exception -> L141
        ArrayList r23 = new ArrayList(r22.length);     // Catch: Exception -> L141
        int r24 = r22.length;     // Catch: Exception -> L141
    L65:
        if (r20 >= r24) goto L67;
        r23.add(Integer.valueOf(UByte.constructor-impl(r22[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L65
    L67:
        r1.a(r21, CollectionsKt.toList(r23));     // Catch: Exception -> L141
        return;
    L68:
        Command r25 = Command.PUSH_TODO_COMMENT_REACTION_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r25) == false) goto L74;
        int r26 = r25.getValue();     // Catch: Exception -> L141
        byte[] r27 = r9.a();     // Catch: Exception -> L141
        ArrayList r28 = new ArrayList(r27.length);     // Catch: Exception -> L141
        int r29 = r27.length;     // Catch: Exception -> L141
    L71:
        if (r20 >= r29) goto L73;
        r28.add(Integer.valueOf(UByte.constructor-impl(r27[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L71
    L73:
        r1.a(r26, CollectionsKt.toList(r28));     // Catch: Exception -> L141
        return;
    L74:
        Command r30 = Command.PUSH_TASK_LISTS_CHANGED_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r30) == false) goto L80;
        int r31 = r30.getValue();     // Catch: Exception -> L141
        byte[] r32 = r9.a();     // Catch: Exception -> L141
        ArrayList r33 = new ArrayList(r32.length);     // Catch: Exception -> L141
        int r34 = r32.length;     // Catch: Exception -> L141
    L77:
        if (r20 >= r34) goto L79;
        r33.add(Integer.valueOf(UByte.constructor-impl(r32[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L77
    L79:
        r1.a(r31, CollectionsKt.toList(r33));     // Catch: Exception -> L141
        return;
    L80:
        Command r35 = Command.PUSH_LIST_TASKS_CHANGED_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r35) == false) goto L86;
        int r36 = r35.getValue();     // Catch: Exception -> L141
        byte[] r37 = r9.a();     // Catch: Exception -> L141
        ArrayList r38 = new ArrayList(r37.length);     // Catch: Exception -> L141
        int r39 = r37.length;     // Catch: Exception -> L141
    L83:
        if (r20 >= r39) goto L85;
        r38.add(Integer.valueOf(UByte.constructor-impl(r37[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L83
    L85:
        r1.a(r36, CollectionsKt.toList(r38));     // Catch: Exception -> L141
        return;
    L86:
        Command r40 = Command.PUSH_CONTAINER_SECTIONS_CHANGED_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r40) == false) goto L92;
        int r41 = r40.getValue();     // Catch: Exception -> L141
        byte[] r42 = r9.a();     // Catch: Exception -> L141
        ArrayList r43 = new ArrayList(r42.length);     // Catch: Exception -> L141
        int r44 = r42.length;     // Catch: Exception -> L141
    L89:
        if (r20 >= r44) goto L91;
        r43.add(Integer.valueOf(UByte.constructor-impl(r42[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L89
    L91:
        r1.a(r41, CollectionsKt.toList(r43));     // Catch: Exception -> L141
        return;
    L92:
        Command r45 = Command.PUSH_CONTAINER_SECTION_REFS_CHANGED_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r45) == false) goto L98;
        int r46 = r45.getValue();     // Catch: Exception -> L141
        byte[] r47 = r9.a();     // Catch: Exception -> L141
        ArrayList r48 = new ArrayList(r47.length);     // Catch: Exception -> L141
        int r49 = r47.length;     // Catch: Exception -> L141
    L95:
        if (r20 >= r49) goto L97;
        r48.add(Integer.valueOf(UByte.constructor-impl(r47[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L95
    L97:
        r1.a(r46, CollectionsKt.toList(r48));     // Catch: Exception -> L141
        return;
    L98:
        Command r50 = Command.PUSH_TODOS_CHANGED_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r50) == false) goto L104;
        int r51 = r50.getValue();     // Catch: Exception -> L141
        byte[] r52 = r9.a();     // Catch: Exception -> L141
        ArrayList r53 = new ArrayList(r52.length);     // Catch: Exception -> L141
        int r54 = r52.length;     // Catch: Exception -> L141
    L101:
        if (r20 >= r54) goto L103;
        r53.add(Integer.valueOf(UByte.constructor-impl(r52[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L101
    L103:
        r1.a(r51, CollectionsKt.toList(r53));     // Catch: Exception -> L141
        return;
    L104:
        Command r55 = Command.PUSH_TODO_EXTRA_INFO_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r55) == false) goto L110;
        int r56 = r55.getValue();     // Catch: Exception -> L141
        byte[] r57 = r9.a();     // Catch: Exception -> L141
        ArrayList r58 = new ArrayList(r57.length);     // Catch: Exception -> L141
        int r59 = r57.length;     // Catch: Exception -> L141
    L107:
        if (r20 >= r59) goto L109;
        r58.add(Integer.valueOf(UByte.constructor-impl(r57[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L107
    L109:
        r1.a(r56, CollectionsKt.toList(r58));     // Catch: Exception -> L141
        return;
    L110:
        Command r60 = Command.PUSH_TASK_SECTION_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r60) == false) goto L116;
        int r61 = r60.getValue();     // Catch: Exception -> L141
        byte[] r62 = r9.a();     // Catch: Exception -> L141
        ArrayList r63 = new ArrayList(r62.length);     // Catch: Exception -> L141
        int r64 = r62.length;     // Catch: Exception -> L141
    L113:
        if (r20 >= r64) goto L115;
        r63.add(Integer.valueOf(UByte.constructor-impl(r62[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L113
    L115:
        r1.a(r61, CollectionsKt.toList(r63));     // Catch: Exception -> L141
        return;
    L116:
        Command r65 = Command.PUSH_TASK_CONTAINER_REFS_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r65) == false) goto L122;
        int r66 = r65.getValue();     // Catch: Exception -> L141
        byte[] r67 = r9.a();     // Catch: Exception -> L141
        ArrayList r68 = new ArrayList(r67.length);     // Catch: Exception -> L141
        int r69 = r67.length;     // Catch: Exception -> L141
    L119:
        if (r20 >= r69) goto L121;
        r68.add(Integer.valueOf(UByte.constructor-impl(r67[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L119
    L121:
        r1.a(r66, CollectionsKt.toList(r68));     // Catch: Exception -> L141
        return;
    L122:
        Command r70 = Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION;     // Catch: Exception -> L141
        if (Intrinsics.areEqual(r3, r70) == false) goto L129;
        int r71 = r70.getValue();     // Catch: Exception -> L141
        byte[] r72 = r9.a();     // Catch: Exception -> L141
        ArrayList r73 = new ArrayList(r72.length);     // Catch: Exception -> L141
        int r74 = r72.length;     // Catch: Exception -> L141
    L125:
        if (r20 >= r74) goto L127;
        r73.add(Integer.valueOf(UByte.constructor-impl(r72[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L125
    L127:
        r1.a(r71, CollectionsKt.toList(r73));     // Catch: Exception -> L141
        return;
    L129:
        if (Intrinsics.areEqual(r3, Command.PUSH_AGENT_CHANGED_NOTIFICATION) == false) goto L131;
    L136:
        int r75 = r3.getValue();     // Catch: Exception -> L141
        byte[] r76 = r9.a();     // Catch: Exception -> L141
        ArrayList r77 = new ArrayList(r76.length);     // Catch: Exception -> L141
        int r78 = r76.length;     // Catch: Exception -> L141
    L137:
        if (r20 >= r78) goto L139;
        r77.add(Integer.valueOf(UByte.constructor-impl(r76[r20]) & 255));     // Catch: Exception -> L141
        r20 = r20 + 1;     // Catch: Exception -> L141
        goto L137
    L139:
        r1.a(r75, CollectionsKt.toList(r77));     // Catch: Exception -> L141
        return;
    L131:
        if (Intrinsics.areEqual(r3, Command.AGENT_DIALOG_RESPONSE_PUSH_NOTIFICATION) == true) goto L136;
        if (Intrinsics.areEqual(r3, Command.PUSH_TASK_AGENT_RECORD_CHANGED_NOTIFICATION) == true) goto L136;
        j.b("LK_API_TAG_Transport", "Invalid command:" + r3.getValue());     // Catch: Exception -> L141
        return;
    L141:
        e = move-exception;
        j.c("LK_API_TAG_Transport", "handlePushMessage error", e);
        return;
    L158:
        return;
    }
}
