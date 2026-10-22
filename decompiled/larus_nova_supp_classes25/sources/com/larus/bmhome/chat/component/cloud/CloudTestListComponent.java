package com.larus.bmhome.chat.component.cloud;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.network.http.d;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pd8.c;
import pd8.f;
import pd8.g;
import pd8.h;
import pd8.j;
import pd8.k;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001$\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b*\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020)R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/component/cloud/CloudTestListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "chatFragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "binding$delegate", "listAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listAbility$delegate", "lastChangedList", "", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "observeForScrollToTop", "Landroidx/lifecycle/Observer;", "getObserveForScrollToTop", "()Landroidx/lifecycle/Observer;", "observeForScrollToTop$delegate", "filteredFakeAndSuggestMessages", "conversationListener", "com/larus/bmhome/chat/component/cloud/CloudTestListComponent$conversationListener$2$1", "getConversationListener", "()Lcom/larus/bmhome/chat/component/cloud/CloudTestListComponent$conversationListener$2$1;", "conversationListener$delegate", "onParentViewCreated", "", "removeObserve", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CloudTestListComponent extends ComponentFeature {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public List<? extends b> l;
    public final Lazy m;
    public final Lazy n;

    public static final class a implements y.a<e> {
        public final /* synthetic */ CloudTestListComponent a;

        public a(CloudTestListComponent r1) {
            this.a = r1;
        }

        public final void c(Object r4) {
            Intrinsics.checkNotNullParameter((e) r4, "new");
            u7 r5 = (u7) this.a.k.getValue();
            ChatListComponent r0 = null;
            if (r5 == null) goto L5;
            MessageAdapter r6 = r5.MF();
        L7:
            if ((r6 instanceof MessageAdapter) == true) goto L10;
            r6 = null;
        L10:
            if (r6 == null) goto L14;
            MediatorLiveData<List<b>> r7 = r6.K;
            if (r7 == null) goto L14;
            CloudTestListComponent r1 = this.a;
            r7.observe(r1, (Observer) r1.m.getValue());
        L14:
            u7 r8 = (u7) this.a.k.getValue();
            if (r8 == null) goto L17;
            MessageAdapter r9 = r8.MF();
        L19:
            if ((r9 instanceof MessageAdapter) == true) goto L22;
            r9 = null;
        L22:
            if (r9 == null) goto L26;
            ChatMessageList r10 = r9.u;
            if (r10 == null) goto L26;
            final CloudTestListComponent r2 = this.a;
            Function1 r3 = new j(r2);
            Intrinsics.checkNotNullParameter(r3, "onTouch");
            ((ArrayList) r10.M).add(r3);
        L26:
            u7 r11 = (u7) this.a.k.getValue();
            if ((r11 instanceof ChatListComponent) == false) goto L29;
            r0 = (ChatListComponent) r11;
        L29:
            if (r0 == null) goto L32;
            final CloudTestListComponent r12 = this.a;
            Function0 r13 = new k(r12);
            Intrinsics.checkNotNullParameter(r13, "callback");
            ((ArrayList) r0.K3).add(r13);
            return;
        L32:
            return;
        L17:
            r9 = null;
            goto L19
        L5:
            r6 = null;
            goto L7
        }
    }

    public final void B2() {
        String r0 = d.a;
        com.larus.network.http.e r1 = d.h;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        if (r2 == false) goto L12;
        y r3 = (y) this.h.getValue();
        if (r3 == null) goto L13;
        r3.rh(new pd8.b(), (a) this.n.getValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r1.f != true) goto L7;
        r2 = true;
        goto L7
    }

    public final void F2() {
        u7 r0 = (u7) this.k.getValue();
        MessageAdapter r1 = null;
        if (r0 == null) goto L5;
        MessageAdapter r2 = r0.MF();
    L7:
        if ((r2 instanceof MessageAdapter) == false) goto L9;
        r1 = r2;
    L9:
        if (r1 == null) goto L14;
        MediatorLiveData<List<b>> r3 = r1.K;
        if (r3 == null) goto L15;
        r3.removeObserver((Observer) this.m.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public CloudTestListComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = LazyKt.lazy(new pd8.d(this));
        this.j = LazyKt.lazy(new pd8.e(this));
        this.k = LazyKt.lazy(new f(this));
        this.m = LazyKt.lazy(new g(this));
        this.n = LazyKt.lazy(new h(this));
    }
}
