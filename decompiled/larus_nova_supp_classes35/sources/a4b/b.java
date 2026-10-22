package a4b;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import b3b.e;
import b3b.f;
import b3b.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.StickerMessageLoader$preLoadStickMessageFavoriteStatus$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatbase.l;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.i0;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s2b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements f, e {
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b a;
    public h b;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a F() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) this.a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a G() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) this.a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // b3b.f, b3b.a, com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC0048a
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // b3b.e
    public final Map<String, String> h() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.n0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }

    @Override // b3b.o
    public final void A(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L6;
        r0.retrySendMessage(r2);
        return;
    }

    @Override // b3b.t
    public final void E(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        IMessageListViewModel r0 = this.a.f();
        if (r0 == null) goto L6;
        r0.updatePreviewByMessageId(r2);
        return;
    }

    @Override // b3b.d
    public final void K6(y6b.a<? extends v5b.a<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageVO");
        IMessageListComponent.e r0 = this.a.getDependency();
        if (r0 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.i(r2);
        return;
    L9:
        return;
    }

    @Override // b3b.a, q5b.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L8;
        s2b.e r1 = r0.getUIModel();
        if (r1 == null) goto L9;
        r1.e(r2);
        return;
    L9:
        return;
    }

    @Override // q5b.a
    public final boolean c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) this.a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r0 == null) goto L9;
        g r1 = r0.C();
        if (r1 == null) goto L9;
        List<Object> r2 = r1.h();
        if (r2 == null) goto L9;
        Object r3 = CollectionsKt.lastOrNull(r2);
    L11:
        if ((r3 instanceof y6b.a) == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        Log.d("MessageCallbackImpl", "isLastMessage:" + r5 + ",msgId:" + r4);
        return r5;
    L13:
        if (Intrinsics.areEqual(r4, ((y6b.a) r3).getId()) == false) goto L15;
        r5 = true;
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC0048a
    public final void f(y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageVO");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) this.a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r0 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.a r1 = r0.getAdapter();
        if (r1 == null) goto L9;
        r1.Y0(r3);
        return;
    L9:
        return;
    }

    @Override // p4b.b
    public final void i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L9;
        MessageInfo r1 = r0.getMessageInfoById(r5);
        if (r1 == null) goto L10;
        Message r2 = r1.getMessage();
        Message r3 = h0.f(r1);
        ChatCoreModule.a().getMergeForwardDependnecy().b(this.a.getContext(), r5, r2, r3);
        return;
    L10:
        return;
    }

    @Override // b3b.g
    public final boolean j(y6b.b r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = r4.d;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r2 = F();
        if (r2 == null) goto L19;
        Chat r3 = r2.getCurrentChat();
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isP2PChat() == false) goto L13;
        r1 = r4.c;
    L13:
        IMessageListComponent.e r5 = this.a.getDependency();
        if (r5 == null) goto L20;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r6 = r5.a();
        if (r6 == null) goto L21;
        String r0 = r4.a;
        Intrinsics.checkNotNull(r1);
        return r6.f(r0, r1, r4.v);
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    @Override // b3b.c
    public final void k(String r2) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L6;
        r0.H5(r2);
        return;
    }

    @Override // q5b.a
    public final void l(String r3) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y(r3));
        return;
    }

    @Override // b3b.h
    public final void q(String r2) {
        h r0 = this.b;
        if (r0 == null) goto L6;
        r0.q(r2);
        return;
    }

    @Override // p4b.a
    public final void u(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        IMessageListViewModel r0 = this.a.f();
        if (r0 == null) goto L18;
        MessageInfo r5 = r0.getMessageInfoById(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.getMessage().getType() == Message.Type.FOLDER) goto L10;
        return;
    L10:
        Message r6 = r5.getMessage();
        xtb.a r1 = ChatCoreModule.a().getFileDetailDependency();
        Context r2 = this.a.getContext();
        IMessageListViewModel r3 = this.a.f();
        if (r3 == null) goto L15;
        MutableLiveData<Chat> r7 = r3.getCurrentChat();
        if (r7 == null) goto L15;
        Chat r8 = (Chat) r7.getValue();
    L16:
        r1.e(r2, r6, r8);
        return;
    L15:
        r8 = null;
        goto L16
    }

    @Override // b3b.r
    public final void y(String r3) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y(r3));
        return;
    }

    @Override // b3b.b
    public final List<String> y0(int r2) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y0(r2);
    }

    @Override // com.ss.android.lark.chat.utils.SystemContentUtil.a
    public final void B(String r8, List<GroupRecallEntity> r9) {
        IMessageListViewModel r1 = this.a.f();
        if (r1 == null) goto L6;
        IMessageListViewModel.recallMembers$default(r1, r8, null, r9, 2, null);
        return;
    }

    @Override // b3b.p
    public final void C(final String r4, final StickerContentVO r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "stickerContentVO");
        IMessageListViewModel r1 = this.a.f();
        if (r1 == null) goto L6;
        l<f5b.b> r2 = r1.stream();
        Intrinsics.checkNotNullParameter(r4, "msgId");
        Intrinsics.checkNotNullParameter(r5, "stickerContentVO");
        Intrinsics.checkNotNullParameter(r2, "stream");
        final WeakReference r0 = new WeakReference(r2);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new StickerMessageLoader$preLoadStickMessageFavoriteStatus$1(r4, r5, r0));
        return;
    }

    @Override // b3b.r
    public final void d(View r3, y6b.a<v5b.a<?>> r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "messageVO");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.z(r3, r4));
        return;
    }

    @Override // q5b.a
    public final void e(int r3, boolean r4) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r0 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a) this.a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class);
        if (r0 == null) goto L6;
        r0.e(r3, r4);
        return;
    }

    @Override // b3b.m
    public final void g(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "threadId");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "autoTranslateLanguageByForward");
        IMessageListViewModel r0 = this.a.f();
        if (r0 == null) goto L9;
        MessageInfo r8 = r0.getMessageInfoById(r7);
        if (r8 == null) goto L10;
        Message r1 = r8.getMessage();
        Message r2 = h0.f(r8);
        Context r3 = this.a.getContext();
        l1.a r4 = new l1.a();
        r4.e = r6;
        r4.p = r8.getId();
        r4.r = r1;
        r4.d = true;
        r4.s = r2;
        r4.v = BuildConfig.FLAVOR;
        ReplyInThreadUtil.c(r3, new l1(r4), this.a.getFragment());
        return;
    L10:
        return;
    }

    @Override // b3b.s
    public final void p(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "url");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a0(r3, r4));
        return;
    }

    @Override // b3b.j
    public final void r(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageCid");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L6;
        r0.cancelUploadMediaMsg(r2, r3);
        return;
    }

    @Override // b3b.q
    public final void t(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.r(r3, r4));
        return;
    }

    @Override // b3b.a
    public final void x(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L8;
        s2b.e r1 = r0.getUIModel();
        if (r1 == null) goto L9;
        r1.g(r2, r3);
        return;
    L9:
        return;
    }

    @Override // b3b.k
    public final void z(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L9;
        MessageInfo r5 = r0.getMessageInfoById(r3);
        if (r5 == null) goto L10;
        ChatCoreModule.a().getChatDependency().h(this.a.getContext(), r5.getId(), r4);
        ChatHitPoint.a("replyCount");
        return;
    L10:
        return;
    }

    @Override // b3b.b
    public final void z0(String r2, String r3) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = F();
        if (r0 == null) goto L6;
        r0.rm(r2, r3);
        return;
    }

    @Override // q5b.a
    public final void m(v5b.c r3, AppCompatImageView r4, r5b.a r5) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.u(r3, r4, r5));
        return;
    }

    @Override // b3b.e
    public final void o(View r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "view");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.x(r3, r4, r5));
        return;
    }

    @Override // b3b.i
    public final void v(View r3, PhotoItem r4, boolean r5) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.q(r3, r4, r5));
        return;
    }

    @Override // a3b.b
    public final void w(String r4, String r5, Long r6) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L20;
        if (r5 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L20;
        IMessageListViewModel r1 = this.a.f();
        if (r1 == null) goto L22;
        r1.sendSignRequest(r4, r5, r6);
        return;
    L22:
        return;
    L12:
        if (r5.length() != 0) goto L14;
    L20:
        Log.i(TitlebarViewModel.LOG_TAG, "personal sign is null or userId is null");
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // b3b.n
    public final void P3(String r2, String r3, RichText r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "content");
        IMessageListComponent.e r0 = this.a.getDependency();
        if (r0 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.k(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    @Override // q5b.a
    public final void a(View r17, List<Image> r18, Image r19, String r20) {
        FragmentActivity r2 = this.a.getActivity();
        Scene r3 = Scene.Chat;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r4 = F();
        if (r4 == null) goto L5;
        Chat r5 = r4.getCurrentChat();
    L6:
        List r6 = com.ss.android.lark.widget.photo.preview.utils.d.c(i0.b(r18), r20);
        int r1 = PhotoUtilsNew.g(r6, (PhotoItem) ListProtector.get(com.ss.android.lark.widget.photo.preview.utils.d.c(Collections.singletonList(i0.a(r19)), r20), 0));
        if (r5 != null) goto L9;
        Log.e("CardImageClickHandler", "onCardImageClick: chat is null, return");
        return;
    L9:
        boolean r7 = y0.a(r5);
        boolean r8 = y0.b(r5);
        boolean r9 = y0.c(r5);
        boolean r10 = y0.d(r5);
        boolean r11 = y0.a(r5);
        boolean r12 = y0.e(r5);
        if (r5.isSecret() == false) goto L12;
    L14:
        boolean r13 = false;
    L15:
        ArrayList r15 = new ArrayList(r6);
        int r14 = k.a;
        k.c r16 = k.a.a(r15, r1, r17);
        r16.c(7414);
        r16.i(r11);
        r16.o(r13);
        r16.f(new OperateListenerImpl(r5.getId()));
        r16.m(r10);
        r16.l(r8);
        r16.n(r8);
        r16.h(r9);
        r16.j(true);
        r16.p(false);
        r16.g(r7);
        r16.e(!r12);
        r16.q(Biz.Messenger, r3, 7);
        r16.r(r2);
        return;
    L12:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable") == false) goto L14;
        r13 = true;
        goto L15
    L5:
        r5 = null;
        goto L6
    }

    @Override // b3b.i
    public final void n(View r3, String r4, List<? extends Object> r5, int r6) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.v(r3, r4, r5, r6));
        return;
    }

    @Override // b3b.l
    public final void D(String r2, String r3, String r4, Integer r5, Boolean r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        l1.a r8 = new l1.a();
        r8.e = r3;
        boolean r9 = false;
        r8.o = false;
        if (r4 == null) goto L5;
        r8.l = r4;
    L5:
        if (r5 == null) goto L7;
        r8.f = r5.intValue();
    L7:
        if (r6 == null) goto L9;
        r8.b = r6.booleanValue();
    L9:
        s2b.d r10 = this.a.a();
        if (r10 != null) goto L12;
    L14:
        if (r9 == false) goto L20;
        s2b.d r11 = this.a.a();
        if (r11 == null) goto L20;
        MergeForwardContent r12 = r11.F8();
        if (r12 == null) goto L20;
        r8.p = r12.getMessageId();
        r8.t = r12;
        r8.o = true;
    L20:
        r8.A = "chat";
        l1 r13 = new l1(r8);
        Context r14 = this.a.getContext();
        Intrinsics.checkNotNull(r13);
        ReplyInThreadUtil.c(r14, r13, r7);
        return;
    L12:
        if (r10.e0() != true) goto L14;
        r9 = true;
        goto L14
    }

    @Override // b3b.i
    public final void s(View r11, ActivityTransitionLauncher.LocationInfo r12, PhotoItem r13, boolean r14, boolean r15, int r16, Message.SourceType r17) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = G();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p(r11, r12, r13, r14, r15, r16, r17));
        return;
    }
}
