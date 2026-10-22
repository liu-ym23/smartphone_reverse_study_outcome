package com.larus.bmhome.chat.larkforward;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import tx9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 P2\u00020\u0001:\u0003NOPB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016Jt\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00072\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u000b0&H\u0016J\u001e\u0010(\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b0&H\u0016Jd\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u001dH\u0002J0\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007042\b\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u0002072\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0002J,\u00108\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007042\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070:H\u0002J\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070:2\b\u0010<\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007H\u0002J8\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010,\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010C\u001a\u00020A2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u001c\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0011H\u0002J(\u0010E\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u00112\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0004\u0012\u00020\u000b0&H\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010H\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0004\u0012\u00020\u000b0&H\u0002J\n\u0010I\u001a\u0004\u0018\u00010\u0017H\u0002J\f\u0010J\u001a\u00020\u0011*\u00020\u0017H\u0002J,\u0010K\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u0011H\u0002¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoServiceImpl;", "Lcom/larus/bmhome/chat/larkforward/IFlowLarkToDoubaoService;", "<init>", "()V", "getDoubaoForwardTarget", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoTarget;", "fallbackName", "", "fallbackIcon", "Landroid/graphics/drawable/Drawable;", "forwardToDoubao", "", "request", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoRequest;", "callback", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoCallback;", "enabled", "", "failureMessage", "sendToDoubao", "activity", "Landroid/app/Activity;", "accountIdentity", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoServiceImpl$AccountIdentity;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "validMsgIds", "", "bizMsgIds", "", "messageTransferTraceContext", "Lcom/larus/trace/DoubaoMessageTransferTraceHelper$MessageTransferTraceContext;", "businessSendStartTimestamp", "failureText", "downgradeEnabled", "localOnBoardingMessageId", "resolveMainBotBundle", "fallbackTitle", "Lkotlin/Function1;", "Landroid/os/Bundle;", "resolveMainBotConversationId", "buildMessageRequest", "Lcom/larus/im/bean/message/MessageRequestV2;", "msgIds", "brief", "extraNote", "cardLocalMessageId", "botId", "isThreadRootMsg", "functionScene", "originMergeForwardId", "buildRequestExt", "", "collectionId", "replyMode", "", "putExtraHeader", "reqHeaderMap", "", "parseExtraHeader", "extraHeader", "buildTextRequestMessage", "Lcom/larus/im/bean/message/RequestMessage;", ChatDraftItem.TYPE_TEXT, "buildMergeForwardBlock", "Lcom/larus/im/bean/message/block/Block;", "blockId", "buildTextBlock", "resolveMainBotId", "resolveMainBotConversation", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoServiceImpl$ResolvedMainBot;", "resolveCachedMainBotConversationForCurrentAccount", "queryCurrentMainBotConversation", "currentAccountIdentity", "isCurrent", "buildMainBotBundle", "conversationId", "isCocoSub", "AccountIdentity", "ResolvedMainBot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FlowLarkToDoubaoServiceImpl implements IFlowLarkToDoubaoService {
    public static final Lazy<Handler> a = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "AccountIdentity(userId=" + this.a + ", secUserId=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "secUserId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public static final Handler a() {
            Lazy<Handler> r0 = FlowLarkToDoubaoServiceImpl.a;
            return (Handler) FlowLarkToDoubaoServiceImpl.a.getValue();
        }

        public b() {
        }
    }

    public static final class c {
        public final a a;
        public final wc9.e b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ResolvedMainBot(accountIdentity=" + this.a + ", conversation=" + this.b + ", localOnBoardingMessageId=" + this.c + ')';
        }

        public c(a r2, wc9.e r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "accountIdentity");
            Intrinsics.checkNotNullParameter(r3, "conversation");
            Intrinsics.checkNotNullParameter(r4, "localOnBoardingMessageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public FlowLarkToDoubaoServiceImpl() {
    }

    static {
        new b();
        a = LazyKt.lazy(new r());
    }

    public static a e() {
        AccountService r0 = AccountService.a;
        String r1 = r0.getUserId();
        String r2 = r0.getSecUserId();
        if (StringsKt.isBlank(r1) == false) goto L5;
    L8:
        return null;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        return new a(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static wc9.e h(a r9) {
        LaunchInfo[] r1 = new LaunchInfo[2];
        AuthModelDelegate r2 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        Object r4 = null;
        if (r3 == null) goto L5;
        LaunchInfo r5 = r3.a;
    L6:
        r1[0] = r5;
        r1[1] = r2.x().getValue();
        List r6 = CollectionsKt.listOf(r1);
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L17;
        Object r10 = r8.next();
        LaunchInfo r11 = (LaunchInfo) r10;
        if (r11 == null) goto L12;
        String r12 = r11.A1();
    L14:
        if (Intrinsics.areEqual(r12, r9.b) == false) goto L8;
        r7.add(r10);
        goto L8
    L12:
        r12 = null;
        goto L14
    L17:
        if (r7.isEmpty() == false) goto L19;
        return null;
    L19:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r7.iterator();
    L21:
        if (r14.hasNext() == false) goto L32;
        LaunchInfo r15 = (LaunchInfo) r14.next();
        if (r15 == null) goto L29;
        String r16 = r15.Y();
        if (r16 == null) goto L29;
        if ((!StringsKt.isBlank(r16)) == false) goto L29;
    L30:
        if (r16 == null) goto L21;
        r13.add(r16);
    L29:
        r16 = null;
        goto L30
    L32:
        Set r17 = CollectionsKt.toSet(r13);
        if (r17.isEmpty() == false) goto L40;
        wc9.e r18 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r18 != null) goto L37;
        return null;
    L37:
        if ((!StringsKt.isBlank(r18.a)) == true) goto L39;
        return null;
    L39:
        return r18;
    L40:
        AuthModelDelegate r19 = AuthModelDelegate.b;
        Iterator r0 = CollectionsKt.listOf(new wc9.e[]{r19.y().getValue(), r19.u().getValue()}).iterator();
    L42:
        if (r0.hasNext() == false) goto L51;
        Object r20 = r0.next();
        wc9.e r21 = (wc9.e) r20;
        Set r22 = r17;
        if (r21 == null) goto L46;
        String r23 = r21.a;
    L48:
        if (CollectionsKt.contains(r22, r23) == false) goto L42;
        r4 = r20;
        goto L51
    L46:
        r23 = null;
    L51:
        return (wc9.e) r4;
    L5:
        r5 = null;
        goto L6
    }

    public static String j(wc9.e r7, boolean r8) {
        if (r8 == false) goto L5;
        LocalSubConvHelper r9 = LocalSubConvHelper.a;
        return LocalSubConvHelper.g(r7);
    L5:
        String r10 = r7.a;
        String r11 = AccountService.a.getSecUserId();
        AuthModelDelegate r0 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r1 = (com.larus.bmhome.chat.api.e0) r0.e().getValue();
        boolean r2 = true;
        if (r1 == null) goto L17;
        LaunchInfo r3 = r1.a;
        if (r3 == null) goto L17;
        if (StringsKt.isBlank(r11) == false) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
    L18:
        if (r3 == null) goto L39;
        String r6 = r3.W();
        if (r6 == null) goto L39;
        String r12 = r3.Y();
        if (r12 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
    L33:
        boolean r4 = true;
    L34:
        if (r4 == true) goto L37;
        r6 = null;
    L37:
        if (r6 == null) goto L39;
        return r6;
    L30:
        if (Intrinsics.areEqual(r3.Y(), r10) == true) goto L33;
        r4 = false;
        goto L34
    L24:
        if (StringsKt.isBlank(r12) == true) goto L27;
        r13 = false;
    L39:
        LaunchInfo r14 = (LaunchInfo) r0.x().getValue();
        if (r14 != null) goto L42;
    L49:
        r14 = null;
    L50:
        if (r14 == null) goto L70;
        String r15 = r14.W();
        if (r15 == null) goto L70;
        String r16 = r14.Y();
        if (r16 != null) goto L56;
    L59:
        boolean r17 = true;
    L60:
        if (r17 == false) goto L62;
    L65:
        if (r2 == true) goto L68;
        r15 = null;
    L68:
        if (r15 == null) goto L70;
        return r15;
    L62:
        if (Intrinsics.areEqual(r14.Y(), r10) == true) goto L65;
        r2 = false;
        goto L65
    L56:
        if (StringsKt.isBlank(r16) == true) goto L59;
        r17 = false;
    L70:
        return null;
    L42:
        if (StringsKt.isBlank(r11) == false) goto L44;
    L46:
        boolean r18 = false;
    L47:
        if (r18 == false) goto L49;
    L44:
        if (Intrinsics.areEqual(r14.A1(), r11) == false) goto L46;
        r18 = true;
        goto L47
    L12:
        if (Intrinsics.areEqual(r3.A1(), r11) == false) goto L14;
        r5 = true;
    L17:
        r3 = null;
        goto L18
    }

    @Override // com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService
    public final void a(final String r2, final Function1<? super Bundle, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "fallbackTitle");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Function1<? super c, Unit> r0 = new u(r3, this, r2);
        i(com.larus.platform.exp.o.a(), r0);
    }

    @Override // com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService
    public final d0 c(String r5, Drawable r6) {
        Intrinsics.checkNotNullParameter(r5, "fallbackName");
        FLogger.a.i("FlowLarkToDoubaoService", "getDoubaoForwardTarget");
        if (n0.a.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        r5 = AppHost.a.getApplication().getString(2131907244);
    L10:
        Intrinsics.checkNotNull(r5);
        if (r0 == false) goto L13;
        r6 = ContextCompat.getDrawable(AppHost.a.getApplication(), 2131240963);
    L13:
        Handler r3 = i.a;
        if (r6 == null) goto L16;
        final Drawable r7 = i.c(r6);
    L17:
        final LayerDrawable r4 = new LayerDrawable(new Drawable[]{r7});
        i.f(new com.larus.bmhome.chat.larkforward.c(r4, r7));
        return new d0(r5, r4);
    L16:
        r7 = new ColorDrawable(0);
        goto L17
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
        r0 = true;
        goto L8
    }

    public final void i(final boolean r11, final Function1<? super c, Unit> r12) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        b.a().post(new t(this, r11, r12));
        return;
    L6:
        final a r0 = e();
        Runnable r1 = null;
        if (r0 != null) goto L10;
        r12.invoke(null);
        return;
    L10:
        if (r11 == false) goto L13;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2(r0, r12, this, null), 3, null);
        return;
    L13:
        wc9.e r13 = h(r0);
        if (r13 == null) goto L17;
        r12.invoke(new c(r0, r13, ""));
        return;
    L17:
        final AtomicBoolean r14 = new AtomicBoolean(false);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = new v(r14, r8, this, r0, r12);
        Handler r2 = b.a();
        Object r3 = r8.element;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    L21:
        r2.postDelayed(r1, 10000);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        com.larus.im.d.d().getMainConversation(new y(r14, r8, this, r0, r12));     // Catch: Throwable -> L24
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L32;
        FLogger.a.e("FlowLarkToDoubaoService", "get main conversation threw", r6);
        f(r14, r8, this, r0, r12, null, false);
        return;
    L32:
        return;
    L24:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L20:
        r1 = (Runnable) r3;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bundle d(wc9.e r5, String r6, String r7, boolean r8) {
        AuthModelDelegate r1 = AuthModelDelegate.b;
        Iterator r0 = CollectionsKt.listOf(new wc9.e[]{r1.y().getValue(), r1.u().getValue()}).iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L12;
        Object r2 = r0.next();
        wc9.e r4 = (wc9.e) r2;
        if (r4 == null) goto L8;
        String r9 = r4.a;
    L10:
        if (Intrinsics.areEqual(r9, r7) == false) goto L3;
    L13:
        wc9.e r10 = (wc9.e) r2;
        if (r10 == null) goto L20;
        String r11 = r10.c;
        if (r11 == null) goto L20;
        if ((!StringsKt.isBlank(r11)) == false) goto L20;
    L21:
        Bundle r12 = new Bundle();
        if ((!StringsKt.isBlank(r7)) == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L27;
        r12.putString("argConversationId", r7);
    L27:
        String r13 = r5.c;
        if (r13 != null) goto L30;
    L36:
        if (r11 == null) goto L39;
        r6 = r11;
    L39:
        r12.putString("argChatTitle", r6);
        String r14 = j(r5, r8);
        if (r14 != null) goto L42;
    L46:
        if (r8 == false) goto L48;
        r12.putInt("argBotConversationType", 3);
        r12.putBoolean("is_create_sub_conversation", true);
    L48:
        return r12;
    L42:
        if ((!StringsKt.isBlank(r14)) == false) goto L44;
        r3 = r14;
    L44:
        if (r3 == null) goto L46;
        r12.putString("argBotId", r3);
        goto L46
    L30:
        if ((!StringsKt.isBlank(r13)) == true) goto L33;
        r13 = null;
    L33:
        if (r13 == null) goto L36;
        r6 = r13;
    L20:
        r11 = null;
        goto L21
    L8:
        r9 = null;
        goto L10
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService
    public final void b(final p r15, final o r16, boolean r17, final String r18) {
        Intrinsics.checkNotNullParameter(r15, "request");
        Intrinsics.checkNotNullParameter(r16, "callback");
        Intrinsics.checkNotNullParameter(r18, "failureMessage");
        final long r9 = System.currentTimeMillis();
        if (r17 == true) goto L6;
        r16.onFailure(-2, r18);
        return;
    L6:
        List<String> r0 = r15.a;
        final ArrayList r7 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        if ((true ^ StringsKt.isBlank((String) r2)) == false) goto L8;
        r7.add(r2);
        goto L8
    L13:
        if (r7.isEmpty() == false) goto L16;
        r16.onFailure(-1, r18);
        return;
    L16:
        ConcurrentHashMap r3 = v0.a;
        final v0.b r5 = v0.d("to_doubao", r15.e, r7, CollectionsKt.emptyList());
        v0.h(r5);
        final ArrayList r8 = new ArrayList();
        Iterator r4 = r7.iterator();
    L18:
        if (r4.hasNext() == false) goto L23;
        Long r11 = StringsKt.toLongOrNull((String) r4.next());
        if (r11 == null) goto L18;
        r8.add(r11);
        goto L18
    L23:
        if (r8.size() == r7.size()) goto L26;
        FLogger.a.w("FlowLarkToDoubaoService", "forward to doubao failed, invalid message ids=" + r7);
        v0.j(r5, false, null, "-1", r18, 4);
        r16.onFailure(-1, r18);
        return;
    L26:
        final Activity r12 = AppHost.a.a().getCurrentActivity();
        if (r12 != null) goto L29;
    L41:
        v0.j(r5, false, null, "-3", r18, 4);
        r16.onFailure(-3, r18);
        return;
    L29:
        if (r12.isFinishing() == true) goto L41;
        if (r12.isDestroyed() == true) goto L41;
        if ((r16 instanceof q) == true) goto L36;
    L38:
        boolean r13 = false;
    L39:
        final boolean r14 = r13;
        i(r13, new s(r5, r18, r16, r12, this, r15, r7, r8, r9, r14));
        return;
    L36:
        if (com.larus.platform.exp.o.a() == false) goto L38;
        r13 = true;
        goto L39
    }

    public static final void f(final AtomicBoolean r10, final Ref.ObjectRef<Runnable> r11, final FlowLarkToDoubaoServiceImpl r12, final a r13, final Function1<? super c, Unit> r14, final wc9.e r15, final boolean r16) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        g(r10, r11, r12, r13, r14, r15, r16);
        return;
    L5:
        b.a().post(new w(r15, r16, r10, r11, r12, r13, r14));
    }

    public static final void g(AtomicBoolean r2, Ref.ObjectRef<Runnable> r3, FlowLarkToDoubaoServiceImpl r4, a r5, Function1<? super c, Unit> r6, wc9.e r7, boolean r8) {
        if (r2.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Handler r9 = b.a();
        Object r10 = r3.element;
        c r0 = null;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
        Runnable r11 = null;
    L9:
        r9.removeCallbacks(r11);
        r4.getClass();
        if (Intrinsics.areEqual(r5, e()) == true) goto L13;
        FLogger.a.w("FlowLarkToDoubaoService", "ignore main conversation result: account changed");
        r6.invoke(null);
        return;
    L13:
        if (r7 != null) goto L15;
    L19:
        wc9.e r12 = h(r5);
    L20:
        if (r8 == false) goto L25;
        if (r7 == null) goto L25;
        if (r12 != r7) goto L25;
        AuthModelDelegate.b.f(r12);
    L25:
        if (Intrinsics.areEqual(r5, e()) == true) goto L28;
        FLogger.a.w("FlowLarkToDoubaoService", "ignore main conversation result: account changed before callback");
        r6.invoke(null);
        return;
    L28:
        if (r12 == null) goto L30;
        r0 = new c(r5, r12, "");
    L30:
        r6.invoke(r0);
        return;
    L15:
        if ((!StringsKt.isBlank(r7.a)) == false) goto L17;
        r12 = r7;
    L18:
        if (r12 != null) goto L20;
    L17:
        r12 = null;
        goto L18
    L8:
        r11 = (Runnable) r10;
        goto L9
    }
}
