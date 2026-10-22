package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.h1;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.MessageListModelFactory;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.MessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.chatbase.i;
import com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModelFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jdb.g;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q3b.m;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListDataFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a {
    public final t6b.c a;
    public final fxa.b b;
    public final z2b.a c;
    public final b<IMessageListViewModel> d;
    public final a e;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b f;
    public IMessageListViewModel g;
    public n2b.b h;
    public Boolean i;
    public final List<u0> j;
    public final List<b1> k;
    public final List<h1> l;
    public final List<y3b.a> m;
    public final List<i<MessageInfo>> n;

    public interface a {
        FlowThreadWindowListViewModelFactory a(i7b.a r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b r2);

        void b(IMessageListViewModel r1);
    }

    public interface b<T extends ViewModel> {
        IMessageListViewModel a(String r1, Class r2, ViewModelProvider.Factory r3);
    }

    public static final class c implements IMessageListComponent.c {
        public final /* synthetic */ MessageListDataFeature a;
        public final /* synthetic */ int b;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.c
        public final void a() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.f;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r0 = null;
        L5:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
            if (r1 == null) goto L9;
            r1.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.t(this.b));
            return;
        }

        public c(MessageListDataFeature r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements n2b.b.InterfaceC0262b {
        public final /* synthetic */ MessageListDataFeature a;

        @Override // n2b.b.InterfaceC0262b
        public final void a() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
            if (r0 == null) goto L5;
            r0.j();
        L5:
            u r1 = MessagePermissionUtil.a;
        }

        @Override // n2b.b.InterfaceC0262b
        public final void b() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
            if (r0 == null) goto L5;
            r0.j();
        L5:
            u r1 = MessagePermissionUtil.a;
        }

        @Override // n2b.b.InterfaceC0262b
        public final List<y6b.c<?>> c() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
            if (r0 == null) goto L9;
            com.ss.android.lark.chat.chatwindow.chat.a r1 = r0.getAdapter();
            if (r1 == null) goto L9;
            List<y6b.c<?>> r2 = r1.getData();
            if (r2 == null) goto L9;
            return r2;
        L9:
            return CollectionsKt.emptyList();
        }

        public d(MessageListDataFeature r1) {
            this.a = r1;
        }
    }

    public static final class e implements m.c {
        public final /* synthetic */ MessageListDataFeature a;

        public e(MessageListDataFeature r1) {
            this.a = r1;
        }

        @Override // q3b.m.c
        public final int a() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
            if (r0 == null) goto L6;
            List<y6b.c<?>> r1 = r0.t();
            if (r1 == null) goto L6;
        L7:
            int r2 = r1.size() - 1;
            if (r2 < 0) goto L15;
        L9:
            int r3 = r2 - 1;
            y6b.c r4 = (y6b.c) ListProtector.get(r1, r2);
            if (r4.isPreMessage() == false) goto L18;
            if (r3 < 0) goto L19;
            r2 = r3;
            goto L9
        L19:
            return -1;
        L18:
            return r4.n;
        L15:
            return -1;
        L6:
            r1 = CollectionsKt.emptyList();
            goto L7
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final MutableLiveData Da() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L8;
        MutableLiveData<List<y6b.c<?>>> r1 = r0.getMessageList();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new MutableLiveData();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a F() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final int Fe() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L7;
        Integer r1 = r0.getExpiredPeriodTime();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final MutableLiveData Kn() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L8;
        MutableLiveData<Chat> r1 = r0.getCurrentChat();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new MutableLiveData();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final ChatChatter N0() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L7;
        MutableLiveData<ChatChatter> r1 = r0.getSelfChatterLiveData();
        if (r1 == null) goto L7;
        return (ChatChatter) r1.getValue();
    L7:
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void N3() {
        IGetDataCallback<Integer> r0 = new MessageListDataFeature$ensureLastPageDataLoaded$callback$1(this);
        IMessageListViewModel r1 = this.g;
        if (r1 == null) goto L6;
        r1.ensureLastPageDataLoaded(new UIGetDataCallback(r0));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final ChatChatter an() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L7;
        MutableLiveData<ChatChatter> r1 = r0.getP2pChatterLiveData();
        if (r1 == null) goto L7;
        return (ChatChatter) r1.getValue();
    L7:
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void b7() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L8;
        final BasePageStore<MessageInfo, x4b.a<MessageInfo>> r1 = r0.getDataStore();
        if (r1 == null) goto L9;
        r1.a.execute(new com.ss.android.lark.chatbase.b(r1));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final boolean canLoadMore() {
        IMessageListViewModel r0 = this.g;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.canLoadMore();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final boolean canLoadPre() {
        IMessageListViewModel r0 = this.g;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.canLoadPre();
    }

    public final List<AuthorityParam> getAuthFileEntities() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L5;
        List<AuthorityParam> r1 = r0.getAuthFileEntities();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final Chat getCurrentChat() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L7;
        MutableLiveData<Chat> r1 = r0.getCurrentChat();
        if (r1 == null) goto L7;
        return (Chat) r1.getValue();
    L7:
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final s2b.e getUIModel() {
        IMessageListViewModel r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUIModel();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onDestroy() {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final IMessageListViewModel f() {
        return this.g;
    }

    public static final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a l(MessageListDataFeature r1) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = r1.f;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r2 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a) r2.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final List<f5b.b> Fa(Collection<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L5;
        List<MessageInfo> r4 = r0.getMessageInfoByIds(r3);
    L6:
        ArrayList r1 = new ArrayList();
        if (r4 == null) goto L12;
        Iterator<T> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r1.add((MessageInfo) r5.next());
    L12:
        return r1;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void H5(String r2) {
        n2b.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void Jf(MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.loadNextPage(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void addSticker(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.addSticker(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void executeMessage(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.executeMessage(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void g(List<? extends y6b.c<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageList");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L9;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = this.f;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r1 = null;
    L7:
        r0.readMessage(r3, r1.getContext());
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void g6(int r3) {
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.checkToClearDataStore(r3, new c(this, r3));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final MessageInfo getMessageInfoById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        IMessageListViewModel r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageInfoById(r2);
    }

    public final void m(com.ss.android.lark.chat.chatwindow.biz.plugin.a.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) this.m).add(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void retrySendMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageCid");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.retrySendMessage(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r10) {
        Intrinsics.checkNotNullParameter(r10, "initData");
        Intrinsics.checkNotNullParameter(r10, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b r6 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b(this);
        a r0 = this.e;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r8 = null;
        if (r0 == null) goto L6;
        FlowThreadWindowListViewModelFactory r1 = r0.a(r10, r6);
        if (r1 == null) goto L6;
    L13:
        Class<?> r11 = this.a.m();
        if (r11 != null) goto L17;
        r11 = MessageListViewModel.class;
    L17:
        if (IMessageListViewModel.class.isAssignableFrom(r11) == false) goto L38;
        IMessageListViewModel r12 = this.d.a(com.ss.android.lark.chat.chatwindow.chat.v2.component.d.a(r11), r11, r1);
        this.g = r12;
        if (r12 == null) goto L23;
        a r2 = this.e;
        if (r2 == null) goto L23;
        r2.b(r12);
    L23:
        this.h = new n2b.b(this.g, new d(this));
        IMessageListViewModel r13 = this.g;
        if (r13 == null) goto L26;
        r13.setWindowDataPreLoadTaskProvider(null);
    L26:
        IMessageListViewModel r14 = this.g;
        if (r14 == null) goto L33;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r3 = this.f;
        if (r3 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L32:
        r14.setActionDispatch(ActionDispatcher.from(r8.getActivity()));
        goto L33
    L31:
        r8 = r3;
    L33:
        IMessageListViewModel r15 = this.g;
        if (r15 == null) goto L39;
        r15.setScreenItemProvider(new e(this));
        return;
    L39:
        return;
    L38:
        throw new IllegalArgumentException("spec.viewModelClass must be a subclass of IMessageListViewModel");
    L6:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = this.f;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r4 = null;
    L9:
        Context r5 = r4.getContext();
        fxa.b r7 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r9 = this.f;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r9 = null;
    L12:
        r1 = new MessageListModelFactory(r5, r10, r7, r9.getContainer(), r6);
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void xl(MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.loadPrePage(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.f = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final List<String> y0(int r2) {
        n2b.b r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y0(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void z6(boolean r3) {
        IMessageListViewModel r0 = this.g;
        if (r0 != null) goto L5;
        this.i = Boolean.valueOf(r3);
        return;
    L5:
        v r1 = r0.getChatContainer();
        if (r1 == null) goto L12;
        g r2 = r1.C();
        if (r2 == null) goto L12;
        boolean r4 = true;
        if (r2.isEnable("im.chat.readable_update") != true) goto L12;
    L13:
        if (r4 == false) goto L20;
        IMessageListViewModel r5 = this.g;
        if (r5 == null) goto L33;
        MutableLiveData<Boolean> r6 = r5.getMessageReadable();
        if (r6 == null) goto L34;
        r6.postValue(Boolean.valueOf(r3));
        return;
    L34:
        return;
    L33:
        return;
    L20:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L26;
        IMessageListViewModel r7 = this.g;
        if (r7 == null) goto L36;
        MutableLiveData<Boolean> r8 = r7.getMessageReadable();
        if (r8 == null) goto L37;
        r8.setValue(Boolean.valueOf(r3));
        return;
    L37:
        return;
    L36:
        return;
    L26:
        IMessageListViewModel r9 = this.g;
        if (r9 == null) goto L39;
        MutableLiveData<Boolean> r10 = r9.getMessageReadable();
        if (r10 == null) goto L40;
        r10.postValue(Boolean.valueOf(r3));
        return;
    L40:
        return;
    L39:
        return;
    L12:
        r4 = false;
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void cancelUploadMediaMsg(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageCid");
        IMessageListViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancelUploadMediaMsg(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a
    public final void rm(String r2, String r3) {
        n2b.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.z0(r2, r3);
        return;
    }

    public MessageListDataFeature(t6b.c r2, fxa.b r3, z2b.a r4, b<IMessageListViewModel> r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r5, "viewModelProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.j = new CopyOnWriteArrayList(r2.d());
        this.k = new CopyOnWriteArrayList(r2.g());
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new ArrayList();
    }
}
