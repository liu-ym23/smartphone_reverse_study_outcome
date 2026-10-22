package com.larus.bmhome.chat.component.bottom.talk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;
import t19.s;
import tx9.a1;
import tx9.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\"H\u0002J \u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\b\b\u0002\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u000204H\u0002J\b\u00102\u001a\u00020,H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/talk/ChatContinueTalkComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/IChatContinueTalkAbility;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "playbackAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "getPlaybackAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "playbackAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "onConversationOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onlyReadCvsId", "", "onlyReadCvs", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "observeConversationChanged", "setOnClick", "cvs", "continueTalk", "needShowIme", "", "(Lcom/larus/im/bean/conversation/Conversation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "removeUnContinueTalkCvs", "shouldAutoLaunchKeyboardOnCreateSub", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatContinueTalkComponent extends BaseContentWidget implements t1a.a {
    public static final /* synthetic */ int v = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public j r;
    public String s;
    public wc9.e t;
    public final Lazy u;

    public ChatContinueTalkComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new d(this));
        this.o = LazyKt.lazy(new e(this));
        this.p = LazyKt.lazy(new f(this));
        this.q = LazyKt.lazy(new g(this));
        this.u = LazyKt.lazy(new h());
    }

    public final void onDestroy() {
        Bundle r0 = ((de8.c) s1a.d.a(this).f(de8.c.class)).b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("as_container");
    L7:
        if (o0.d(this.s) == true) goto L9;
    L11:
        ((Handler) this.u.getValue()).removeCallbacksAndMessages(null);
        return;
    L9:
        if (Intrinsics.areEqual(r1, "FLOAT_CHAT") == true) goto L11;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ChatContinueTalkComponent$removeUnContinueTalkCvs$1(this, null), 3, null);
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.r = new j(this);
        y r4 = (y) this.m.getValue();
        if (r4 == null) goto L6;
        r4.rh(new b(), this.r);
        return;
    }

    public static final Object Y2(final ChatContinueTalkComponent r92, wc9.e r93, boolean r94, Continuation r95) {
        wc9.e r1 = r93;
        r92.getClass();
        if ((r95 instanceof ChatContinueTalkComponent$continueTalk$1) == false) goto L7;
        ChatContinueTalkComponent$continueTalk$1 r3 = (ChatContinueTalkComponent$continueTalk$1) r95;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        ChatContinueTalkComponent$continueTalk$1 r14 = r3;
        Object r2 = r14.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r14.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        boolean r7 = r14.Z$0;
        wc9.e r8 = (wc9.e) r14.L$0;
        ResultKt.throwOnFailure(r2);
        Object r9 = r2;
        boolean r10 = r7;
        r1 = r8;
    L17:
        com.larus.network.http.f r11 = (com.larus.network.http.a) r9;
        boolean r15 = false;
        if ((r11 instanceof com.larus.network.http.f) == false) goto L28;
        String r12 = r11.d.getMessage();
        if (r12 != null) goto L22;
    L25:
        boolean r13 = true;
    L26:
        if (r13 == true) goto L32;
        s r16 = s.a;
        Context r17 = AppHost.a.getApplication().getApplicationContext();
        r16.getClass();
        s.c(r17, r12);
    L32:
        ((Handler) r92.u.getValue()).removeCallbacksAndMessages(null);
        u7 r18 = (u7) r92.n.getValue();
        if (r18 == null) goto L35;
        r18.dismissLoading();
    L35:
        z2 r19 = z2.a;
        if (r19.subConvKeyboardConfig().a() == false) goto L38;
    L41:
        boolean r20 = true;
    L42:
        ICoreInputAbility r21 = (ICoreInputAbility) r92.o.getValue();
        if (r21 != null) goto L45;
    L47:
        boolean r22 = false;
    L48:
        boolean r23 = !r22;
        if (r20 == false) goto L52;
        if (r23 == false) goto L52;
        r15 = true;
    L52:
        if (r15 == false) goto L56;
        if (r10 == false) goto L56;
        ((Handler) r92.u.getValue()).postDelayed(new a(r92), 200);
    L56:
        return Unit.INSTANCE;
    L45:
        if (r21.Rp() != 2) goto L47;
        r22 = true;
        goto L48
    L38:
        if (r19.subConvKeyboardConfig().b() == true) goto L41;
        r20 = false;
        goto L42
    L22:
        if (r12.length() == 0) goto L25;
        r13 = false;
        goto L26
    L28:
        r92.s = null;
        String r24 = r1.r;
        if (r24 != null) goto L31;
        r24 = "";
    L31:
        JSONObject r25 = new JSONObject(r24);
        r25.remove("forbid_send_msg");
        RepoDispatcherDelegate.b.f().e(r1, r25.toString());
        String r26 = r1.a;
        JSONObject r27 = new JSONObject();
        r27.put("current_page_status", "temporary");
        k0.a(null, "click_continue_talk", r26, "chat", "landing", null, null, null, null, null, null, null, null, null, r27, null, null, null, 1015747);
        String r28 = r1.a;
        JSONObject r29 = new JSONObject();
        r29.put("current_page_status", "normal");
        r29.put("previous_page_status", "temporary");
        a1.c(null, null, null, null, r28, "chat", null, null, null, null, null, null, null, null, null, null, "chat", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r29, null, null, null, null, null, null, null, null, -1048769, -8388609, 7);
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        JSONObject r30 = new JSONObject();
        r30.put("conversation_id", r1.a);
        Unit r31 = Unit.INSTANCE;
        r14.L$0 = r1;
        r10 = r94;
        r14.Z$0 = r10;
        r14.label = 1;
        r9 = HttpExtKt.k("Message", String.class, "/social/conversation/continue_chat", r30, null, null, false, null, null, null, r14, 1008);
        if (r9 != r5) goto L17;
        return r5;
    L7:
        r3 = new ChatContinueTalkComponent$continueTalk$1(r92, r95);
        goto L8
    }
}
