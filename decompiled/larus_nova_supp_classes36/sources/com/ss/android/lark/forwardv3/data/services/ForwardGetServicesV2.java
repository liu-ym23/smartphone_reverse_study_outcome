package com.ss.android.lark.forwardv3.data.services;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.bytedance.lark.pb.feed.v1.ForwardIncludeItem;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsRequestV2;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsResponseV2;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsRequestV2;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsResponseV2;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.message.Message;
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
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardGetServicesV2 {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements SdkSender.IParser {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function1<SearchBaseInfo, Boolean> c;

        public a(boolean r1, long r2, Function1<? super SearchBaseInfo, Boolean> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final Object parse(byte[] r8) {
            GetRecentTransmitTargetsResponseV2 r9 = (GetRecentTransmitTargetsResponseV2) GetRecentTransmitTargetsResponseV2.ADAPTER.decode(r8);
            long r0 = SystemClock.elapsedRealtime();
            StringBuilder r2 = new StringBuilder("get recent forward data v2, from local: ");
            r2.append(this.a);
            r2.append(" :\n     response is: ");
            boolean r3 = true;
            int r4 = 0;
            if (r9 == null) goto L5;
            boolean r5 = true;
        L6:
            r2.append(r5);
            r2.append("\n    target is: ");
            if (r9 == null) goto L9;
            List r6 = r9.targets;
        L10:
            if (r6 != null) goto L13;
            r3 = false;
        L13:
            r2.append(r3);
            r2.append("\n    size is: ");
            if (r9 == null) goto L18;
            List r7 = r9.targets;
            if (r7 == null) goto L18;
            r4 = r7.size();
        L18:
            r2.append(r4);
            r2.append(" \n    request forward cost: ");
            r2.append(r0 - this.b);
            Log.i("ForwardGetServicesV2", r2.toString());
            if (r9 == null) goto L38;
            List r10 = r9.targets;
            if (r10 == null) goto L38;
            Function1<SearchBaseInfo, Boolean> r1 = this.c;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L24:
            if (r12.hasNext() == false) goto L32;
            ForwardCommonData r13 = (ForwardCommonData) r12.next();
            WeakReference<Message> r14 = ForwardDataUtils.a;
            Intrinsics.checkNotNull(r13);
            SearchBaseInfo r15 = ForwardDataUtils.e(r13);
            if (r15 != null) goto L28;
        L29:
            r15 = null;
        L30:
            if (r15 == null) goto L24;
            r11.add(r15);
            goto L24
        L28:
            if (((Boolean) r1.invoke(r15)).booleanValue() == false) goto L30;
        L32:
            WeakReference<Message> r16 = ForwardDataUtils.a;
            com.ss.android.lark.forwardv3.utils.b.d();
            List r17 = CollectionsKt.take(r11, 30);
            if (r17 == null) goto L38;
            List r18 = CollectionsKt.toMutableList(r17);
            if (r18 == null) goto L38;
            return r18;
        L38:
            return new ArrayList();
        L9:
            r6 = null;
            goto L10
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class b<T> implements SdkSender.IParser {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;

        public b(boolean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object parse(byte[] r7) {
            GetRecentVisitTargetsResponseV2 r8 = (GetRecentVisitTargetsResponseV2) GetRecentVisitTargetsResponseV2.ADAPTER.decode(r7);
            long r0 = SystemClock.elapsedRealtime();
            StringBuilder r2 = new StringBuilder("get recent visit data v2, from local: ");
            r2.append(this.a);
            r2.append(" :\n     response is: ");
            boolean r3 = true;
            int r4 = 0;
            if (r8 == null) goto L5;
            boolean r5 = true;
        L6:
            r2.append(r5);
            r2.append("\n    target is: ");
            if (r8 == null) goto L9;
            List r6 = r8.targets;
        L10:
            if (r6 != null) goto L13;
            r3 = false;
        L13:
            r2.append(r3);
            r2.append("\n    size is: ");
            if (r8 == null) goto L18;
            List r9 = r8.targets;
            if (r9 == null) goto L18;
            r4 = r9.size();
        L18:
            r2.append(r4);
            r2.append(" \n    request forward cost: ");
            r2.append(r0 - this.b);
            Log.i("ForwardGetServicesV2", r2.toString());
            if (r8 == null) goto L37;
            List r1 = r8.targets;
            if (r1 == null) goto L37;
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r1.iterator();
        L24:
            if (r11.hasNext() == false) goto L28;
            ForwardCommonData r12 = (ForwardCommonData) r11.next();
            WeakReference<Message> r13 = ForwardDataUtils.a;
            Intrinsics.checkNotNull(r12);
            SearchBaseInfo r14 = ForwardDataUtils.e(r12);
            if (r14 == null) goto L24;
            r10.add(r14);
            goto L24
        L28:
            com.ss.android.lark.forwardv3.utils.b.d();
            List r15 = CollectionsKt.take(r10, 30);
            if (r15 == null) goto L37;
            WeakReference<Message> r16 = ForwardDataUtils.a;
            Map r17 = r8.can_not_select_chatter_map;
            if (r17 != null) goto L33;
            r17 = MapsKt.emptyMap();
        L33:
            ForwardDataUtils.b(r15, r17);
            List r18 = CollectionsKt.toMutableList(r15);
            if (r18 == null) goto L37;
            return r18;
        L37:
            return new ArrayList();
        L9:
            r6 = null;
            goto L10
        L5:
            r5 = false;
            goto L6
        }
    }

    static {
    }

    public static List a(IncludeConfig r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = ((ArrayList) r6.a).iterator();
    L4:
        if (r7.hasNext() == false) goto L53;
        EntityItem r1 = (EntityItem) r7.next();
        UserConfig r2 = r1.a;
        int r3 = 0;
        if (r2 != null) goto L7;
        GroupConfig r4 = r1.b;
        if (r4 != null) goto L17;
        if (r1.c != null) goto L35;
        ThreadConfig r5 = r1.d;
        if (r5 != null) goto L38;
        if (r1.e == null) goto L4;
        ForwardIncludeItem.IncludeItem r8 = new ForwardIncludeItem.IncludeItem.Builder().my_ai_configs(new ForwardIncludeItem.IncludeItem.MyAIConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r8);
        r0.add(r8);
        goto L4
    L38:
        ForwardIncludeItem.IncludeItem.Builder r9 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r10 = new ForwardIncludeItem.IncludeItem.ThreadConfig.Builder();
        Condition$Tenant r11 = r5.getTenant();
        if (r11 == null) goto L41;
        int r12 = r11.getValue();
    L42:
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r13 = r10.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r12));
        Condition$Status r14 = r5.getStatus();
        if (r14 == null) goto L45;
        int r15 = r14.getValue();
    L46:
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r16 = r13.public_type_condition(ForwardIncludeItem.PublicTypeCondition.fromValue(r15));
        Condition$ThreadType r17 = r5.getThreadType();
        if (r17 == null) goto L49;
        r3 = r17.getValue();
    L49:
        ForwardIncludeItem.IncludeItem r18 = r9.thread_configs(r16.thread_type_condition(ForwardIncludeItem.ThreadTypeCondition.fromValue(r3)).build()).build();
        Intrinsics.checkNotNull(r18);
        r0.add(r18);
        goto L4
    L45:
        r15 = 0;
        goto L46
    L41:
        r12 = 0;
        goto L42
    L35:
        ForwardIncludeItem.IncludeItem r19 = new ForwardIncludeItem.IncludeItem.Builder().bot_configs(new ForwardIncludeItem.IncludeItem.BotConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r19);
        r0.add(r19);
        goto L4
    L17:
        ForwardIncludeItem.IncludeItem.Builder r20 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r21 = new ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder();
        Condition$Tenant r22 = r4.getTenant();
        if (r22 == null) goto L20;
        int r23 = r22.getValue();
    L21:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r24 = r21.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r23));
        Condition$Shield r25 = r4.getShield();
        if (r25 == null) goto L24;
        int r26 = r25.getValue();
    L25:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r27 = r24.shield_type_condition(ForwardIncludeItem.ShieldTypeCondition.fromValue(r26));
        Condition$GroupType r28 = r4.getGroupType();
        if (r28 == null) goto L28;
        int r29 = r28.getValue();
    L29:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r30 = r27.group_chat_type_condition(ForwardIncludeItem.GroupChatTypeCondition.fromValue(r29));
        Condition$Status r31 = r4.getStatus();
        if (r31 == null) goto L32;
        r3 = r31.getValue();
    L32:
        ForwardIncludeItem.IncludeItem r32 = r20.group_chat_configs(r30.public_type_condition(ForwardIncludeItem.PublicTypeCondition.fromValue(r3)).build()).build();
        Intrinsics.checkNotNull(r32);
        r0.add(r32);
        goto L4
    L28:
        r29 = 0;
        goto L29
    L24:
        r26 = 0;
        goto L25
    L20:
        r23 = 0;
        goto L21
    L7:
        ForwardIncludeItem.IncludeItem.Builder r33 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.UserConfig.Builder r34 = new ForwardIncludeItem.IncludeItem.UserConfig.Builder().talked_status_condition(ForwardIncludeItem.TalkedStatusCondition.ALL_TALKED).work_status_condition(ForwardIncludeItem.WorkStatusCondition.NOT_RESIGNED);
        Condition$Tenant r35 = r2.getTenant();
        if (r35 == null) goto L10;
        int r36 = r35.getValue();
    L11:
        ForwardIncludeItem.IncludeItem.UserConfig.Builder r37 = r34.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r36));
        Condition$UserType r38 = r2.getUserType();
        if (r38 == null) goto L14;
        r3 = r38.getValue();
    L14:
        ForwardIncludeItem.IncludeItem r39 = r33.user_configs(r37.user_type_condition(ForwardIncludeItem.UserTypeCondition.fromValue(r3)).build()).build();
        Intrinsics.checkNotNull(r39);
        r0.add(r39);
        goto L4
    L10:
        r36 = 0;
        goto L11
    L53:
        return r0;
    }

    public static Object c(long r4, IncludeConfig r6, final boolean r7, Continuation r8) throws ErrorResult {
        long r0 = SystemClock.elapsedRealtime();
        Log.i("ForwardGetServicesV2", "start get recent visit data v2, from local: " + r7 + "\n    from start activity to request visit cost: " + (r0 - r4));
        if (r6 == null) goto L5;
        GetRecentVisitTargetsRequestV2.Builder r5 = new GetRecentVisitTargetsRequestV2.Builder();
        WeakReference<Message> r9 = ForwardDataUtils.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        if (r7 == false) goto L9;
        int r10 = 10;
    L10:
        GetRecentVisitTargetsRequestV2.Builder r11 = r5.limit(Boxing.boxInt(r10));
        if (r7 == false) goto L13;
        SyncDataStrategy r12 = SyncDataStrategy.LOCAL;
    L14:
        GetRecentVisitTargetsRequestV2.Builder r13 = r11.sync_data_strategy(r12).include_items(a(r6));
        b r14 = new b(r7, r0);
        final SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(r8));
        SdkSender.asynSendRequestNonWrap(Command.GET_RECENT_VISIT_TARGETS_V2, r13, new ForwardGetServicesV2$getRecentVisitDataV2$2$innerCallback$1(r15, r7), r14);
        Object r16 = r15.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L17:
        return r16;
    L13:
        r12 = SyncDataStrategy.FORCE_SERVER;
        goto L14
    L9:
        r10 = 30;
        goto L10
    L5:
        return new ArrayList();
    }

    public static Object b(long r4, IncludeConfig r6, final boolean r7, Function1 r8, Continuation r9) throws ErrorResult {
        long r0 = SystemClock.elapsedRealtime();
        Log.i("ForwardGetServicesV2", "start get recent forward data v2, from local: " + r7 + "\n    from start activity to request forward cost: " + (r0 - r4));
        if (r6 == null) goto L5;
        GetRecentTransmitTargetsRequestV2.Builder r5 = new GetRecentTransmitTargetsRequestV2.Builder();
        WeakReference<Message> r10 = ForwardDataUtils.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        GetRecentTransmitTargetsRequestV2.Builder r11 = r5.limit(Boxing.boxInt(15));
        if (r7 == false) goto L9;
        SyncDataStrategy r12 = SyncDataStrategy.LOCAL;
    L10:
        GetRecentTransmitTargetsRequestV2.Builder r13 = r11.sync_data_strategy(r12).include_items(a(r6));
        a r14 = new a(r7, r0, r8);
        final SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        SdkSender.asynSendRequestNonWrap(Command.GET_RECENT_TRANSMIT_TARGETS_V2, r13, new ForwardGetServicesV2$getRecentForwardDataV2$2$innerCallback$1(r15, r7), r14);
        Object r16 = r15.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L13:
        return r16;
    L9:
        r12 = SyncDataStrategy.FORCE_SERVER;
        goto L10
    L5:
        return new ArrayList();
    }
}
