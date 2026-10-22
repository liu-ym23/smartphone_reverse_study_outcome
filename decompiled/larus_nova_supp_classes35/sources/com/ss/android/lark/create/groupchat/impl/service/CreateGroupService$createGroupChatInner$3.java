package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.ChatForsetiBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.entity.Contact;
import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pair", "Landroid/util/Pair;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lcom/ss/android/lark/chat/linkedpage/ChatCreatePageLinkResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$createGroupChatInner$3", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreateGroupService$createGroupChatInner$3 extends SuspendLambda implements Function2<Pair<Chat, w5b.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Chat> $callback;
    final /* synthetic */ hab.b $chatDependency;
    final /* synthetic */ CreateGroupService.b $createGroupContext;
    final /* synthetic */ CreateGroupService.c $param;
    final /* synthetic */ jab.c $sChatCreateGroupHitPoint;
    final /* synthetic */ CreateGroupScene $source;
    final /* synthetic */ String $sourceTag;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateGroupService this$0;

    public CreateGroupService$createGroupChatInner$3(String r1, CreateGroupService r2, CreateGroupService.b r3, CreateGroupScene r4, CreateGroupService.c r5, hab.b r6, IGetDataCallback<Chat> r7, jab.c r8, Continuation<? super CreateGroupService$createGroupChatInner$3> r9) {
        this.$sourceTag = r1;
        this.this$0 = r2;
        this.$createGroupContext = r3;
        this.$source = r4;
        this.$param = r5;
        this.$chatDependency = r6;
        this.$callback = r7;
        this.$sChatCreateGroupHitPoint = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        CreateGroupService$createGroupChatInner$3 r10 = new CreateGroupService$createGroupChatInner$3(this.$sourceTag, this.this$0, this.$createGroupContext, this.$source, this.$param, this.$chatDependency, this.$callback, this.$sChatCreateGroupHitPoint, r13);
        r10.L$0 = r12;
        return r10;
    }

    public final Object invoke(Pair<Chat, w5b.a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L90;
        ResultKt.throwOnFailure(r30);
        Pair r1 = (Pair) this.L$0;
        final Chat r2 = (Chat) r1.first;
        StringBuilder r3 = new StringBuilder();
        r3.append(this.$sourceTag);
        r3.append(": create group success. chatId is ");
        if (r2 == null) goto L7;
        String r5 = r2.getId();
    L8:
        r3.append(r5);
        Log.i("CreateGroupService", r3.toString());
        if (r2 == null) goto L11;
        CreateGroupService r4 = this.this$0;
        CreateGroupService.b r6 = this.$createGroupContext;
        CreateGroupScene r7 = this.$source;
        CreateGroupService.c r8 = this.$param;
        hab.b r9 = this.$chatDependency;
        final jab.c r10 = this.$sChatCreateGroupHitPoint;
        Function0<Unit> r11 = new AnonymousClass1(r10, r2);
        int r12 = CreateGroupService.c;
        r4.getClass();
        WeakReference<Context> r13 = r6.getContext();
        Fragment r14 = r6.b;
        r9.a();
        if (r7 != CreateGroupScene.P2P) goto L16;
        int r15 = jab.a.a;
        jab.a.C0240a.a(r2, "p2p_config");
    L59:
        String r22 = kab.a.a;
        if (r22 == null) goto L63;
        kab.a.a = null;
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r22, null, null, null, MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("is_initialize", Boolean.TRUE), TuplesKt.to("is_in_background", Integer.valueOf(!ImSdkProxy.b().b() ? 1 : 0))}), 14, null);
    L63:
        r11.invoke();
        Context r16 = r13.get();
        if (r8.a == false) goto L79;
        if (r16 == null) goto L79;
        Bundle r17 = new Bundle();
        List<Contact> r18 = r8.c;
        if (r18 != null) goto L69;
    L71:
        boolean r19 = false;
    L72:
        if (r19 == false) goto L74;
        r17.putParcelableArrayList("option_bundle_contacts_to_apply", new ArrayList(r8.c));
    L74:
        r17.putBoolean("option_bundle_apply_group_member_limit", r8.e);
        Bundle r20 = new Bundle();
        r20.putSerializable("key_forseti_bundle", new ChatForsetiBundle(true, false, 2, null));
        ChatBundle.a r21 = new ChatBundle.a();
        r21.a = r2.getId();
        r21.a(r2.getChatMode());
        r21.y = 1;
        r21.h = SourceType.PROFILE;
        r21.d = ChatFromType.GROUP_CREATE;
        r21.l = r8.b;
        r21.p = r17;
        r21.x = r20;
        ChatBundle r23 = new ChatBundle(r21);
        Lazy r24 = ForsetiFGHelpers.a;
        if (ForsetiFGHelpers.c(BizType.IM, "sec_create_group") == false) goto L78;
        if (r14 == null) goto L78;
        Intrinsics.checkNotNull(r23);
        r9.c(r14, r16, r23);
    L78:
        Intrinsics.checkNotNull(r23);
        r9.openChat(r16, r23);
        goto L79
    L69:
        if ((!r18.isEmpty()) != true) goto L71;
        r19 = true;
    L79:
        IGetDataCallback<Chat> r25 = this.$callback;
        if (r25 == null) goto L82;
        r25.onSuccess(r2);
    L82:
        w5b.a r26 = (w5b.a) r1.second;
        if (r26 == null) goto L88;
        IGetDataCallback<w5b.a> r27 = this.$param.d;
        if (r27 == null) goto L88;
        r27.onSuccess(r26);
    L88:
        return Unit.INSTANCE;
    L16:
        if (r7 != CreateGroupScene.ADD_GROUP_MEMBER) goto L20;
        int r28 = jab.a.a;
        jab.a.C0240a.a(r2, "internal_to_external");
        goto L59
    L20:
        if (r2.isPublic() == true) goto L22;
        int r29 = jab.a.a;
        JSONObject r31 = new JSONObject().put("members_number", r2.getMemberCount()).put("chat_id", r2.getId());
        if (r2.isPublic() == false) goto L47;
        Object r32 = "public";
    L50:
        JSONObject r33 = r31.put(IPortraitService.TYPE, r32);
        if (r2.isThread() == false) goto L53;
        Object r110 = "topic";
    L54:
        JSONObject r34 = r33.put("mode", r110);
        if (r2.isPublic() == false) goto L57;
        String r35 = "custom";
    L58:
        Statistics.sendEvent(ChatFromType.GROUP_CREATE, r34.put("group_name", r35));
        goto L59
    L57:
        r35 = "default";
        goto L58
    L53:
        r110 = "classic";
        goto L54
    L47:
        if (r2.isCrossTenant() == false) goto L49;
        r32 = "external";
        goto L50
    L49:
        r32 = "private";
        goto L50
    L22:
        if (r2.isThread() == false) goto L24;
        CreateGroupMode r36 = CreateGroupMode.TOPIC_MODE;
    L25:
        int r111 = jab.b.a;
        boolean r112 = r2.isPublic();
        boolean r210 = r2.isCrossTenant();
        String r113 = r2.getDescription();
        Integer r114 = Integer.valueOf(r2.getMemberCount());
        Intrinsics.checkNotNullParameter(r36, "mode");
        Intrinsics.checkNotNullParameter(r113, "description");
        Intrinsics.checkNotNullParameter(r114, "memberNumber");
        if (r210 == true) goto L30;
        if (r112 == false) goto L29;
        Object r115 = "public";
    L31:
        int r37 = jab.b.a.C0241a.a[r36.ordinal()];
        if (r37 != 1) goto L34;
    L37:
        Object r38 = "classic";
    L38:
        JSONObject r39 = new JSONObject().put(IPortraitService.TYPE, r115).put("mode", r38);
        if (TextUtils.isEmpty(r113) == false) goto L41;
        String r40 = "n";
    L42:
        Statistics.sendEvent(ChatFromType.GROUP_CREATE, r39.put("add_description", r40).put("members_number", r114));
        goto L59
    L41:
        r40 = "y";
        goto L42
    L34:
        if (r37 != 2) goto L37;
        r38 = "topic";
        goto L38
    L29:
        r115 = "private";
        goto L31
    L30:
        r115 = "external";
        goto L31
    L24:
        r36 = CreateGroupMode.CONVERSATION_MODE;
        goto L25
    L11:
        return Unit.INSTANCE;
    L7:
        r5 = null;
        goto L8
    L90:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
