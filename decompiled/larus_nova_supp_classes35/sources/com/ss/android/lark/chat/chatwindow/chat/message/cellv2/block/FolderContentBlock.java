package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.im.sdk.statistics.ImSdkChatHitPointV2;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FolderContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>, com.ss.android.lark.chat.base.view.vo.message.a> {
    public static final /* synthetic */ int j = 0;
    public final IMMessageKeys$Blocks g;
    public final Lazy h;
    public final b3b.f i;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final FileView b;

        public final View getView() {
            return this.a;
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            FileView r3 = r2.findViewById(2131365529);
            this.b = r3;
            r3.S5();
        }
    }

    public static final class c extends FileView.c {
        public final /* synthetic */ FolderContentBlock a;
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> b;

        public final void d(FileView.b r1) {
        }

        public final void c(FileView.b r11) {
            FolderContentBlock r12 = this.a;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r0 = this.b;
            r12.getClass();
            if (r0.isPreMessage() == true) goto L58;
            boolean r3 = false;
            Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r0.getId()), TuplesKt.to("file_type", "folder")});
            String r2 = r0.getChatId();
            Lazy r5 = ChatHitPointNew.a;
            Intrinsics.checkNotNullParameter("file_card", "click");
            Intrinsics.checkNotNullParameter("im_chat_file_manage_view", "target");
            Lazy r9 = ImSdkChatHitPointV2.a;
            Intrinsics.checkNotNullParameter("file_card", "click");
            Intrinsics.checkNotNullParameter("im_chat_file_manage_view", "target");
            Map<String, Object> r4 = ChatParamUtils.f(r2);
            if (r4 == null) goto L9;
            ImSdkChatHitPointV2.a("file_card", "im_chat_file_manage_view", r4, r1);
        L9:
            Message.FileDeletedStatus r6 = r0.b().q;
            if (r6 != Message.FileDeletedStatus.RECOVERABLE) goto L12;
        L13:
            r3 = true;
        L14:
            IMFileResult r7 = null;
            if (((FolderContent) r0.b().a).resourceIsCleaned() == true) goto L48;
            if (r3 == true) goto L48;
            ValidateIMFileResult r8 = r0.N();
            if (r8 == null) goto L21;
            ValidateResult r10 = r8.getValidateResult();
        L22:
            ValidateIMFileResult r13 = r0.N();
            if (r13 == null) goto L25;
            r7 = r13.getResultType();
        L25:
            MessagePermissionUtil.ReceiveAuthorizationState r14 = MessagePermissionUtil.h(r7);
            if (MessagePermissionUtil.g(r14) == true) goto L28;
            owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            ValidateResult r15 = MessagePermissionUtil.b();
            if (MessagePermissionUtil.f(r0, r12.c.getChat(), r15) == true) goto L37;
            MessagePermissionUtil.n(r12.getContext(), 2131891409, r15);
            owa.a.c().a(r15, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            return;
        L37:
            owa.a.c().a(r15, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            if (r12.c.r() == true) goto L40;
        L42:
            mya.n r16 = r12.c.j5().b(mya.n.class);
            if (r16 == null) goto L45;
            r16.n(r0.getId(), r12.c.getContext());
            return;
        L45:
            b3b.f r17 = r12.i;
            if (r17 == null) goto L56;
            r17.u(r0.getId());
            return;
        L56:
            return;
        L40:
            if ((r0 instanceof ThreadMessageVO) == false) goto L42;
            ThreadMessageVO r18 = (ThreadMessageVO) r0;
            goto L42
        L28:
            if (r14 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L31;
            MessagePermissionUtil.m(r12.getContext());
        L33:
            owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            return;
        L31:
            if (r14 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L33;
            owa.a.c().d(r10, MessagePermissionUtil.a());
            goto L33
        L21:
            r10 = null;
        L48:
            Context r19 = r12.getContext();
            ResourceType r20 = ResourceType.FILE;
            ResourceCleanScene r21 = lpc.a.b(r0);
            y6b.b r22 = r0.a();
            if (r22 == null) goto L51;
            r7 = r22.w;
        L51:
            acc.a.f(r19, new acc.d(r20, r21, acc.a.d(r7)));
            return;
        L12:
            if (r6 != Message.FileDeletedStatus.UNRECOVERABLE) goto L14;
        }

        public c(FolderContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> a;
        public final /* synthetic */ FolderContentBlock b;
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r1, FolderContentBlock r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            e6b.b r5 = this.a;
            if ((r5 instanceof e6b.b) == false) goto L5;
            e6b.b r6 = r5;
        L6:
            if (r6 == null) goto L8;
            FolderContentBlock r0 = this.b;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r1 = this.c;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<*>");
            return r6.e(r0, r1);
        L8:
            return false;
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public FolderContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.FOLDER_CONTENT;
        this.h = LazyKt.lazy(new FolderContentBlock$fgService$2(this));
        b3b.f r3 = this.d;
        if ((r3 instanceof p4b.a) == true) goto L6;
        r3 = null;
    L6:
        this.i = r3;
    }

    public boolean h(y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        if (this.c.m() == false) goto L5;
    L12:
        return true;
    L5:
        if (r2.l() == false) goto L12;
        if (this.c.Y() == true) goto L12;
        if (this.c.r() == true) goto L12;
        return false;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r36, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r37, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r38) {
        Intrinsics.checkNotNullParameter(r36, "cell");
        Intrinsics.checkNotNullParameter(r37, "layout");
        Intrinsics.checkNotNullParameter(r38, Keys.API_RETURN_KEY_DATA);
        b r2 = (b) r37.c(this.g, IMMessageKeys$Slots.CONTENT, FolderContentBlock$update$blockView$1.INSTANCE);
        ValidateIMFileResult r4 = r38.N();
        if (r4 == null) goto L5;
        IMFileResult r5 = r4.getResultType();
    L6:
        MessagePermissionUtil.ReceiveAuthorizationState r6 = MessagePermissionUtil.h(r5);
        boolean r16 = MessagePermissionUtil.f(r38, this.c.getChat(), null);
        r2.b.setTag(r38.getcId());
        com.ss.android.lark.chat.base.view.vo.message.a r7 = r38.b();
        FileState r8 = FileState.DOWNLOAD;
        Log.d("FolderContentBlock", "folder key = " + r7.e());
        boolean r9 = r7.g();
        boolean r10 = r7.h();
        boolean r11 = r7.i();
        boolean r12 = r7.n;
        Message.FileDeletedStatus r13 = r7.q;
        Message.FileDeletedStatus r14 = Message.FileDeletedStatus.UNRECOVERABLE;
        if (r13 != r14) goto L9;
        boolean r15 = true;
    L10:
        Message.FileDeletedStatus r17 = Message.FileDeletedStatus.RECOVERABLE;
        if (r13 != r17) goto L13;
        boolean r18 = true;
    L14:
        Message.FileDeletedStatus r1 = Message.FileDeletedStatus.FREED_UP;
        if (r13 != r1) goto L17;
        boolean r19 = true;
    L18:
        boolean r110 = !r38.isPreMessage();
        FileView.FileState r111 = new FileView.FileState(r8.getFileStateType(), UIUtils.getString(getContext(), r8.getValue()));
        String r0 = r7.f();
        long r22 = ((Number) r7.d.getValue()).longValue();
        int r20 = r6.getValue();
        ResourceCleanScene r29 = ((FolderContent) r7.a).currentResourceScene();
        y6b.b r21 = r38.a();
        if (r21 == null) goto L21;
        String r32 = r21.w;
    L22:
        FileView.b r112 = new FileView.b(r9, r10, r11, r12, r15, r18, r19, r110, r16, BuildConfig.FLAVOR, r111, r0, r22, 0, 0, true, null, r20, r29, r32);
        FileView r3 = r2.b;
        if (r7.n == true) goto L31;
        Message.FileDeletedStatus r23 = r7.q;
        if (r23 == r17) goto L31;
        if (r23 == r14) goto L31;
        if (r23 == r1) goto L31;
        if (r7.h() == true) goto L31;
        boolean r24 = true;
    L32:
        r3.setFileSizeVisibility(r24);
        if (r38.j() == false) goto L35;
    L43:
        boolean r25 = false;
    L44:
        boolean r26 = h(r38);
        FileView r27 = r2.b;
        if (r26 == true) goto L49;
        if (r25 == true) goto L49;
        boolean r28 = false;
    L50:
        r27.setBottomMargin(r28);
        r2.b.getFileIconView().setCornerRadiusDP(0.0f);
        if (this.c.m() == false) goto L53;
    L56:
        r2.b.setBackgroundResource(2131235383);
    L57:
        r2.b.S5();
        r2.b.setTopBorderColor(UIUtils.getColor(this.c.getContext(), 2131103351));
        FileView r30 = r2.b;
        if (com.ss.android.lark.message.lynxcard.message.r.a(r38.i()) == true) goto L60;
    L62:
        boolean r31 = false;
    L63:
        r30.setTopBorderVisibility(r31);
        FileView r33 = r2.b;
        r33.setCallback(new c(this, r38));
        r33.setInfo(r112);
        r2.b.setOnLongClickListener(new d(r36, this, r38));
        UIUtils.hide(r2.b.l);
        return;
    L60:
        if (r38.d() == true) goto L62;
        r31 = true;
        goto L63
    L53:
        if (this.c.r() == true) goto L56;
        if (this.c.Y() == false) goto L57;
    L49:
        r28 = true;
        goto L50
    L35:
        if (r38.m() == true) goto L43;
        if (r38.O() == true) goto L43;
        if (r38.l() == false) goto L43;
        if (r38.d() == false) goto L43;
        r25 = true;
    L31:
        r24 = false;
        goto L32
    L21:
        r32 = null;
        goto L22
    L17:
        r19 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r1, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r3) {
        update2(r1, r2, r3);
    }
}
