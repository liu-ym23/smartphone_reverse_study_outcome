package e3b;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import b3b.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.message.params.h;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.q;
import com.ss.android.lark.chat.utils.r;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.view.photopreview.LoadMoreListenerImpl;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photo.preview.utils.d;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnLoadMoreListener;
import com.ss.android.lark.widget.photopicker.utils.l;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements i, o4b.a {
    public final v a;
    public final Context b;
    public final IMessageListViewModel c;
    public final InterfaceC0213a d;
    public final m2b.a e;

    /* JADX INFO: renamed from: e3b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0213a {
        Fragment getFragment();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a.getContext(), 2131891151);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements q.a {
        public final /* synthetic */ a a;

        @Override // com.ss.android.lark.chat.utils.q.a
        public final boolean a() {
            IMessageListViewModel r0 = this.a.c;
            if (r0 == null) goto L7;
            MutableLiveData<Chat> r1 = r0.getCurrentChat();
            if (r1 == null) goto L7;
            Chat r2 = (Chat) r1.getValue();
        L9:
            if (r2 != null) goto L11;
            return false;
        L11:
            if (r2.isSecret() == true) goto L15;
            return true;
        L15:
            return false;
        L7:
            r2 = null;
            goto L9
        }

        @Override // com.ss.android.lark.chat.utils.q.a
        public final String getChatId() {
            IMessageListViewModel r0 = this.a.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getChatId();
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    @Override // b3b.i
    public final void n(View r1, String r2, List<? extends Object> r3, int r4) {
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // o4b.a
    public final void U(PhotoItem r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "selectPhotoItem");
        if (fdc.a.a(r12) == false) goto L6;
        UICallbackExecutor.execute(new b(this));
        return;
    L6:
        ValidateResult r1 = MessagePermissionUtil.b();
        ValidateIMFileResult r2 = r12.getValidateIMFileResult();
        List r3 = null;
        if (r2 == null) goto L9;
        ValidateResult r4 = r2.getValidateResult();
    L10:
        int r5 = r12.getReceiveAuthorizationStateValue();
        MessagePermissionUtil.ReceiveAuthorizationState.Companion.getClass();
        MessagePermissionUtil.ReceiveAuthorizationState r6 = MessagePermissionUtil.ReceiveAuthorizationState.a.a(r5);
        if (MessagePermissionUtil.g(r6) == true) goto L13;
        owa.a.c().a(r4, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        if (r12.isHasPreviewPermission() == false) goto L23;
    L30:
        owa.a.c().a(r1, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        if (r12.getMessageIdentity() == null) goto L36;
        MessageIdentity r7 = r12.getMessageIdentity();
        if (r7 == null) goto L36;
        String r8 = r7.getMessageId();
        if (r8 == null) goto L36;
    L37:
        String r9 = r8;
        IMessageListViewModel r10 = this.c;
        if (r10 == null) goto L40;
        r3 = IMessageListViewModel.getAllImage$default(r10, r9, r13, null, null, 12, null);
    L40:
        List r14 = l.b(r3);
        if (CollectionUtils.isEmpty(r14) == false) goto L43;
        return;
    L43:
        int r15 = PhotoUtilsNew.g(r14, r12);
        if (r15 != (-1)) goto L46;
        return;
    L46:
        if (r15 >= ((ArrayList) r14).size()) goto L63;
        IMessageListViewModel r11 = this.c;
        if (r11 == null) goto L61;
        MutableLiveData<Chat> r16 = r11.getCurrentChat();
        if (r16 == null) goto L62;
        Chat r17 = (Chat) r16.getValue();
        if (r17 == null) goto L64;
        boolean r18 = y0.b(r17);
        boolean r19 = y0.c(r17);
        PhotoItem r20 = (PhotoItem) ListProtector.get(r14, r15);
        if (r20 != null) goto L58;
        return;
    L58:
        Context r21 = this.b;
        Fragment r22 = this.d.getFragment();
        c r23 = new c(this);
        w4b.a r110 = q.a;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r20, "selectPhotoItem");
        Intrinsics.checkNotNullParameter(r22, "fragment");
        Intrinsics.checkNotNullParameter(r23, "auditDependency");
        CoreThreadPool.getDefault().getFixedThreadPool().submit(new r(r20, r21, r23, r22, r18, r19));
        return;
    L64:
        return;
    L62:
        return;
    L61:
        return;
    L63:
        return;
    L36:
        r8 = BuildConfig.FLAVOR;
        goto L37
    L23:
        if (MessagePermissionUtil.e(r1) == false) goto L30;
        if (r12.isVideo() == false) goto L27;
        int r111 = 2131891413;
    L28:
        MessagePermissionUtil.n(this.b, r111, r1);
        owa.a.c().a(r1, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return;
    L27:
        r111 = 2131891410;
        goto L28
    L13:
        if (r6 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L16;
        MessagePermissionUtil.m(this.b);
    L18:
        owa.a.c().a(r4, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        return;
    L16:
        if (r6 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L18;
        owa.a.c().d(r4, MessagePermissionUtil.a());
        goto L18
    L9:
        r4 = null;
        goto L10
    }

    @Override // b3b.i
    public final void v(View r4, PhotoItem r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        IMessageListViewModel r7 = this.c;
        if (r7 == null) goto L13;
        MutableLiveData<Chat> r8 = r7.getCurrentChat();
        if (r8 == null) goto L14;
        Chat r9 = (Chat) r8.getValue();
        if (r9 == null) goto L15;
        Scene r1 = Scene.Chat;
        int r2 = k.a;
        k.c r10 = k.a.a(new ArrayList(r0), 0, r4);
        r10.d(r6);
        r10.l(true);
        r10.n(false);
        r10.p(true);
        r10.m(true);
        r10.f(new OperateListenerImpl(r9));
        r10.q(Biz.Messenger, r1, 4);
        r10.r(ContextsKt.requireActivity(this.b));
        return;
    L15:
        return;
    L14:
        return;
    }

    public a(v r2, Context r3, IMessageListViewModel r4, MessageListEventDispatchFeature.a r5, m2b.a r6) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    @Override // b3b.i
    public final void s(View r19, ActivityTransitionLauncher.LocationInfo r20, PhotoItem r21, boolean r22, boolean r23, int r24, Message.SourceType r25) {
        Intrinsics.checkNotNullParameter(r21, "selectPhoItem");
        if (r21.getMessageIdentity() == null) goto L10;
        MessageIdentity r3 = r21.getMessageIdentity();
        if (r3 == null) goto L10;
        String r4 = r3.getMessageId();
        if (r4 == null) goto L10;
        String r6 = r4;
    L11:
        IMessageListViewModel r5 = this.c;
        h r7 = null;
        if (r5 == null) goto L14;
        List r8 = IMessageListViewModel.getAllImage$default(r5, r6, r23, null, null, 12, null);
    L15:
        List r9 = d.b(r8, BuildConfig.FLAVOR);
        if (CollectionUtils.isEmpty(r9) == false) goto L18;
        return;
    L18:
        PhotoUtilsNew r10 = PhotoUtilsNew.a;
        int r11 = PhotoUtilsNew.g(r9, r21);
        if (r11 <= (-1)) goto L21;
        ((PhotoItem) ListProtector.get(r9, r11)).setThumbnail(r21.getThumbnail());
    L21:
        IMessageListViewModel r12 = this.c;
        if (r12 == null) goto L65;
        MutableLiveData<Chat> r13 = r12.getCurrentChat();
        if (r13 == null) goto L65;
        Chat r14 = (Chat) r13.getValue();
        if (r14 == null) goto L65;
        Scene r15 = Scene.Chat;
        String r16 = r14.getId();
        OnLoadMoreListener r17 = new LoadMoreListenerImpl(r16, r14.getAnonymousId());
        OperateListenerImpl r18 = new OperateListenerImpl(r14);
        if (r14.isSecret() == false) goto L31;
    L33:
        boolean r110 = false;
    L34:
        if (r24 != 1) goto L36;
    L38:
        m2b.a r111 = this.e;
        if (r111 == null) goto L41;
        r7 = (h) r111.d0(h.class);
    L41:
        if (r7 == null) goto L43;
        boolean r112 = false;
    L44:
        if (r7 == null) goto L46;
        boolean r113 = false;
    L47:
        if (r7 == null) goto L49;
        boolean r114 = false;
    L50:
        if (r7 == null) goto L52;
        boolean r26 = false;
    L54:
        if (y0.a(r14) == false) goto L57;
        if (r26 == false) goto L57;
        boolean r27 = true;
    L58:
        boolean r115 = y0.b(r14);
        if (y0.c(r14) == false) goto L62;
        if (r112 == false) goto L62;
        boolean r116 = true;
    L63:
        boolean r1 = y0.d(r14);
        boolean r28 = y0.a(r14);
        boolean r29 = y0.e(r14);
        int r117 = k.a;
        k.c r0 = k.a.a(r9, r11, r19);
        r0.c(7414);
        r0.d(r22);
        r0.i(r28);
        r0.o(r110);
        r0.c = r20;
        r0.a.putSerializable("load_more_listener", r17);
        r0.f(r18);
        r0.m(r1);
        r0.l(r115);
        r0.n(r115);
        r0.h(r116);
        r0.j(r113);
        r0.p(r114);
        r0.g(r27);
        r0.e(true ^ r29);
        r0.q(Biz.Messenger, r15, r24);
        EnterSource.Companion.getClass();
        r0.b(EnterSource.a.a(r25));
        r0.u(ContextsKt.requireActivity(this.b));
        int r2 = w5c.a.a;
        w5c.a.a(r16, r21.getImageKey());
        return;
    L62:
        r116 = false;
    L57:
        r27 = false;
        goto L58
    L52:
        r26 = true;
        goto L54
    L49:
        r114 = true;
        goto L50
    L46:
        r113 = true;
        goto L47
    L43:
        r112 = true;
        goto L44
    L36:
        if (r24 == 3) goto L38;
    L31:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable") == false) goto L33;
        r110 = true;
    L65:
        return;
    L14:
        r8 = null;
    L10:
        r6 = BuildConfig.FLAVOR;
        goto L11
    }
}
