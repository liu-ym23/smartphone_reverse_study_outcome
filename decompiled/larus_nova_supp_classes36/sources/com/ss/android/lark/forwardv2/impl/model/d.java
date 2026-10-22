package com.ss.android.lark.forwardv2.impl.model;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.ForwardIncludeItem;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsRequestV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetContinualDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
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
import com.ss.android.lark.forwardv2.impl.model.service.ForwardServiceV2$getRecentForwardDataListV2$innerCallback$1;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import hib.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends com.ss.android.lark.forwardv2.impl.model.a implements iib.b {
    public final e b;
    public List<SearchBaseInfo> c;
    public List<SearchBaseInfo> d;
    public final ForwardTemplate e;

    public class a implements com.ss.android.lark.forwardv2.dto.template.b.a {
        public final /* synthetic */ IGetDataCallback a;

        public a(IGetDataCallback r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv2.dto.template.b.a
        public final void b(String r3, boolean r4) {
            Log.i("TemplateForwardModel", "on executor forward failed");
            this.a.onError(new ForwardErrorResult(r3, r4));
        }

        @Override // com.ss.android.lark.forwardv2.dto.template.b.a
        public final void onSuccess(int r3, Intent r4) {
            Log.i("TemplateForwardModel", "on executor forward success");
            b r0 = new b();
            r0.a = r3;
            r0.b = r4;
            this.a.onSuccess(r0);
        }

        @Override // com.ss.android.lark.forwardv2.dto.template.b.a
        public final void a(String r3, String r4, boolean r5) {
            Log.i("TemplateForwardModel", "on executor forward failed");
            this.a.onError(new ForwardErrorResult(r3, r4, r5));
        }
    }

    @Override // iib.b
    public final List<SearchBaseInfo> R4() {
        List<SearchBaseInfo> r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    @Override // iib.a
    public final String getSource() {
        ForwardTemplate r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        ForwardHitPoint r1 = r0.f;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.b;
    }

    @Override // iib.b
    public final List<SearchBaseInfo> u3() {
        List<SearchBaseInfo> r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    public d(ForwardTemplate r1) {
        this.e = r1;
        hib.d r2 = com.ss.android.lark.forwardv2.e.a;
        this.b = com.ss.android.lark.forwardv2.e.a.a().d();
    }

    @Override // iib.a
    public final void L1(boolean r1, List r2, UIGetDataCallback r3) {
        ((hib.b) PluginServiceLoader.loadFirst(hib.b.class)).a();
    }

    @Override // iib.a
    public final void L6(final Context r5, List<ForwardTarget> r6, IGetDataCallback<b> r7) {
        a r0 = new a(r7);
        StringBuffer r8 = new StringBuffer();
        if (CollectionUtils.isEmpty(r6) == true) goto L8;
        Iterator<ForwardTarget> r1 = r6.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ForwardTarget r2 = r1.next();
        r8.append(r2.b());
        r8.append("-");
        r8.append(r2.a);
        r8.append(". ");
    L8:
        Log.i("TemplateForwardModel", "will calling executor process forward , target data : " + r8.toString());
        final ForwardTemplate r9 = this.e;
        com.ss.android.lark.forwardv2.dto.template.b r3 = r9.i;
        if (r3 == null) goto L12;
    L18:
        if (r3 != null) goto L20;
        return;
    L20:
        r3.a(r6, r9.g, r0);
        return;
    L12:
        if (r9.k == null) goto L15;
        r9.i = new com.ss.android.lark.forwardv2.dto.a(r9, r5);
    L17:
        r3 = r9.i;
        goto L18
    L15:
        if (r9.j == null) goto L17;
        r9.i = new com.ss.android.lark.forwardv2.dto.b(r9);
        goto L17
    }

    @Override // iib.b
    public final void O2(long r10, final boolean r12, final UIGetContinualDataCallback r13) {
        int r0 = com.ss.android.lark.forwardv2.impl.model.service.b.a;
        BusinessRecentVisitIncludeConfig r1 = this.e.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        final Function1 r5 = new c();
        final IGetDataCallback r6 = getCallbackManager().wrapAndAddCallback(new TemplateForwardModel$1(this, r13));
        Intrinsics.checkNotNullParameter(r1, "includeConfigs");
        Intrinsics.checkNotNullParameter(r5, "filter");
        Intrinsics.checkNotNullParameter(r6, "callback");
        final long r2 = SystemClock.elapsedRealtime();
        Log.i("Android_Recent_Forward_V2", "start get recent forward targets v2, from local: " + r12 + "\nfrom start activity to send request forward: " + (r2 - r10));
        GetRecentTransmitTargetsRequestV2.Builder r11 = new GetRecentTransmitTargetsRequestV2.Builder();
        WeakReference<Message> r14 = ForwardDataUtils.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        GetRecentTransmitTargetsRequestV2.Builder r15 = r11.limit(15);
        if (r12 == false) goto L5;
        SyncDataStrategy r16 = SyncDataStrategy.LOCAL;
    L6:
        GetRecentTransmitTargetsRequestV2.Builder r17 = r15.sync_data_strategy(r16);
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r1.a.iterator();
    L8:
        if (r19.hasNext() == false) goto L57;
        EntityItem r3 = (EntityItem) r19.next();
        UserConfig r4 = r3.a;
        int r7 = 0;
        if (r4 != null) goto L11;
        GroupChatConfig r8 = r3.b;
        if (r8 != null) goto L21;
        ThreadConfig r9 = r3.d;
        if (r9 != null) goto L39;
        if (r3.c != null) goto L53;
        if (r3.e == null) goto L8;
        ForwardIncludeItem.IncludeItem r20 = new ForwardIncludeItem.IncludeItem.Builder().my_ai_configs(new ForwardIncludeItem.IncludeItem.MyAIConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r20);
        r18.add(r20);
        goto L8
    L53:
        ForwardIncludeItem.IncludeItem r21 = new ForwardIncludeItem.IncludeItem.Builder().bot_configs(new ForwardIncludeItem.IncludeItem.BotConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r21);
        r18.add(r21);
        goto L8
    L39:
        ForwardIncludeItem.IncludeItem.Builder r22 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r23 = new ForwardIncludeItem.IncludeItem.ThreadConfig.Builder();
        Condition$ThreadTypeCondition r24 = r9.getThreadTypeCondition();
        if (r24 == null) goto L42;
        int r25 = r24.getValue();
    L43:
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r26 = r23.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r25));
        Condition$PublicTypeCondition r27 = r9.getPublicTypeCondition();
        if (r27 == null) goto L46;
        int r28 = r27.getValue();
    L47:
        ForwardIncludeItem.IncludeItem.ThreadConfig.Builder r29 = r26.public_type_condition(ForwardIncludeItem.PublicTypeCondition.fromValue(r28));
        Condition$ThreadTypeCondition r30 = r9.getThreadTypeCondition();
        if (r30 == null) goto L50;
        r7 = r30.getValue();
    L50:
        ForwardIncludeItem.IncludeItem r31 = r22.thread_configs(r29.thread_type_condition(ForwardIncludeItem.ThreadTypeCondition.fromValue(r7)).build()).build();
        Intrinsics.checkNotNull(r31);
        r18.add(r31);
        goto L8
    L46:
        r28 = 0;
        goto L47
    L42:
        r25 = 0;
        goto L43
    L21:
        ForwardIncludeItem.IncludeItem.Builder r32 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r33 = new ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder();
        Condition$TenantCondition r34 = r8.getTenantCondition();
        if (r34 == null) goto L24;
        int r35 = r34.getValue();
    L25:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r36 = r33.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r35));
        Condition$ShieldTypeCondition r37 = r8.getShieldTypeCondition();
        if (r37 == null) goto L28;
        int r38 = r37.getValue();
    L29:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r39 = r36.shield_type_condition(ForwardIncludeItem.ShieldTypeCondition.fromValue(r38));
        Condition$GroupChatTypeCondition r40 = r8.getGroupChatTypeCondition();
        if (r40 == null) goto L32;
        int r41 = r40.getValue();
    L33:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r42 = r39.group_chat_type_condition(ForwardIncludeItem.GroupChatTypeCondition.fromValue(r41));
        Condition$PublicTypeCondition r43 = r8.getPublicTypeCondition();
        if (r43 == null) goto L36;
        r7 = r43.getValue();
    L36:
        ForwardIncludeItem.IncludeItem r44 = r32.group_chat_configs(r42.public_type_condition(ForwardIncludeItem.PublicTypeCondition.fromValue(r7)).build()).build();
        Intrinsics.checkNotNull(r44);
        r18.add(r44);
        goto L8
    L32:
        r41 = 0;
        goto L33
    L28:
        r38 = 0;
        goto L29
    L24:
        r35 = 0;
        goto L25
    L11:
        ForwardIncludeItem.IncludeItem.Builder r45 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.UserConfig.Builder r46 = new ForwardIncludeItem.IncludeItem.UserConfig.Builder().talked_status_condition(ForwardIncludeItem.TalkedStatusCondition.ALL_TALKED).work_status_condition(ForwardIncludeItem.WorkStatusCondition.NOT_RESIGNED);
        Condition$TenantCondition r47 = r4.getTenantCondition();
        if (r47 == null) goto L14;
        int r48 = r47.getValue();
    L15:
        ForwardIncludeItem.IncludeItem.UserConfig.Builder r49 = r46.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r48));
        Condition$UserTypeCondition r50 = r4.getUserTypeCondition();
        if (r50 == null) goto L18;
        r7 = r50.getValue();
    L18:
        ForwardIncludeItem.IncludeItem r51 = r45.user_configs(r49.user_type_condition(ForwardIncludeItem.UserTypeCondition.fromValue(r7)).build()).build();
        Intrinsics.checkNotNull(r51);
        r18.add(r51);
        goto L8
    L14:
        r48 = 0;
        goto L15
    L57:
        SdkSender.asynSendRequestNonWrap(Command.GET_RECENT_TRANSMIT_TARGETS_V2, r17.include_items(r18), new ForwardServiceV2$getRecentForwardDataListV2$innerCallback$1(r2, r12, r5, r6), new com.ss.android.lark.forwardv2.impl.model.service.a(r12));
        return;
    L5:
        r16 = SyncDataStrategy.FORCE_SERVER;
        goto L6
    }

    @Override // iib.b
    public final void R2(final long r8, final boolean r10, final UIGetContinualDataCallback r11) {
        RxScheduledExecutor.justInIO(new TemplateForwardModel$2(this, r8, r10, r11));
    }
}
