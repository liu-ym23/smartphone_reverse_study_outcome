package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import b3b.h;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.chat.utils.s;
import com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mya.m;
import w4b.j;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final h a;
    public final vab.b b;
    public com.larksuite.framework.callback.c c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a$a, reason: collision with other inner class name */
    public static final class C0044a {
    }

    public static final class b extends FileView.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ g b;
        public final /* synthetic */ y6b.a<FileContentVO> c;
        public final /* synthetic */ m2b.a d;
        public final /* synthetic */ FileContentVO e;

        public final void b(FileView.b r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
        }

        public final void a() {
            Log.i("FileContentBlockController", "checkFileState calls.");
            FileContentVO r0 = this.c.b();
            u r1 = MessagePermissionUtil.a;
            j r2 = ChatCoreModule.a().getDownloadDependency();
            String r3 = this.c.getId();
            String r4 = r0.o;
            Message.SourceType r5 = r0.p;
            if (r5 == null) goto L5;
            int r6 = r5.getNumber();
        L6:
            r2.c(r3, r4, r6, r0.e(), null);
            return;
        L5:
            r6 = 0;
            goto L6
        }

        public final void c(FileView.b r20) {
            Intrinsics.checkNotNullParameter(r20, "info");
            final a r1 = this.a;
            g r2 = this.b;
            y6b.a<FileContentVO> r8 = this.c;
            m2b.a r3 = this.d;
            r1.getClass();
            Context r4 = r2.getContext();
            if (r8.isPreMessage() == true) goto L55;
            u r5 = MessagePermissionUtil.a;
            Intrinsics.checkNotNullParameter(r8, "item");
            Message.FileDeletedStatus r6 = r8.b().q;
            if (r6 != Message.FileDeletedStatus.RECOVERABLE) goto L8;
        L11:
            boolean r7 = true;
        L13:
            if (((FileContent) r8.b().a).resourceIsCleaned() == true) goto L49;
            if (r7 == true) goto L49;
            ValidateIMFileResult r9 = r8.N();
            if (r9 == null) goto L19;
            IMFileResult r10 = r9.getResultType();
        L20:
            MessagePermissionUtil.ReceiveAuthorizationState r11 = MessagePermissionUtil.h(r10);
            ValidateIMFileResult r12 = r8.N();
            if (r12 == null) goto L23;
            ValidateResult r13 = r12.getValidateResult();
        L25:
            if (MessagePermissionUtil.g(r11) == true) goto L27;
            owa.a.c().a(r13, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            ValidateResult r14 = MessagePermissionUtil.b();
            if (MessagePermissionUtil.f(r8, r3.getChat(), r14) == true) goto L36;
            MessagePermissionUtil.n(r4, 2131891409, r14);
            owa.a.c().a(r14, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            goto L55
        L36:
            owa.a.c().a(r14, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            m r15 = r3.j5().b(m.class);
            if (r15 == null) goto L40;
            r15.f(r8.getId(), r4);
            goto L55
        L40:
            if (r1.a == null) goto L55;
            if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.file.delete.by.script.toast") == false) goto L48;
            Context r16 = r2.getContext();
            FileContentVO r17 = r8.b();
            final f r18 = new f(r2);
            final com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.c r19 = new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.c(r2);
            final e r21 = new e(r2, r16);
            final d r22 = new d(r3, r8, r16, r1);
            IGetDataCallback<Message.FileDeletedStatus> r110 = new FileContentBlockController$checkFileStateBeforeOpen$callback$1(r1, r18, r19, r21, r22);
            com.larksuite.framework.callback.c r23 = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
            r23.d();
            r23.b(r18, 500);
            r1.c = r23;
            j r111 = ChatCoreModule.a().getDownloadDependency();
            String r112 = r8.getId();
            String r113 = r17.o;
            Message.SourceType r24 = r17.p;
            if (r24 == null) goto L46;
            int r114 = r24.getNumber();
        L47:
            r111.c(r112, r113, r114, r17.e(), r110);
            goto L55
        L46:
            r114 = 0;
            goto L47
        L48:
            r1.a.q(r8.getId());
            goto L55
        L27:
            if (r11 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L30;
            MessagePermissionUtil.m(r4);
        L32:
            owa.a.c().a(r13, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            goto L55
        L30:
            if (r11 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L32;
            owa.a.c().d(r13, MessagePermissionUtil.a());
            goto L32
        L23:
            r13 = null;
            goto L25
        L19:
            r10 = null;
        L49:
            y6b.b r25 = r8.a();
            if (r25 == null) goto L53;
            String r26 = r25.w;
            if (r26 == null) goto L53;
        L54:
            acc.a.f(r4, new acc.d(ResourceType.FILE, lpc.a.b(r8), acc.a.d(r26)));
        L53:
            r26 = BuildConfig.FLAVOR;
            goto L54
        L8:
            if (r6 == Message.FileDeletedStatus.UNRECOVERABLE) goto L11;
            r7 = false;
        L55:
            ChatHitPointNew.f(this.d.getChat(), "file", ChatHitPointNew.c("file"), ChatHitPointNew.b(this.d, this.c, null, null, null));
        }

        public final void d(FileView.b r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            xtb.a r3 = this.a.b;
            this.e.e();
            r3.getClass();
            Iterator r4 = ((CopyOnWriteArrayList) qfb.a.a).iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((qfb.a.InterfaceC0286a) r4.next()).a();
            goto L4
        }

        public b(a r1, g r2, y6b.a<FileContentVO> r3, m2b.a r4, v4b.d r5, FileContentVO r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<FileContentVO>> a;
        public final /* synthetic */ i<y6b.a<FileContentVO>, Object> b;
        public final /* synthetic */ y6b.a<FileContentVO> c;

        public c(com.ss.android.lark.blueprint.m<y6b.a<FileContentVO>> r1, i<y6b.a<FileContentVO>, Object> r2, y6b.a<FileContentVO> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public a(com.ss.android.lark.blueprint.g r2, b3b.f r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r3;
        this.b = ChatCoreModule.a().getFileDetailDependency();
    }

    public final void update(g r52, y6b.a<FileContentVO> r53, m2b.a r54, v4b.d r55, com.ss.android.lark.blueprint.m<y6b.a<FileContentVO>> r56, i<y6b.a<FileContentVO>, Object> r57) {
        Intrinsics.checkNotNullParameter(r52, "view");
        Intrinsics.checkNotNullParameter(r53, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r54, "chatContext");
        Intrinsics.checkNotNullParameter(r56, "cell");
        Intrinsics.checkNotNullParameter(r57, BizScene.BLOCK);
        Context r13 = r52.getContext();
        jdb.g r14 = w.a(r54).C();
        int r0 = s.a;
        Intrinsics.checkNotNullParameter(r14, "fgService");
        boolean r1 = r14.isEnable("messenger.message.online_edit_excel_hide_last_edit");
        ValidateIMFileResult r2 = r53.N();
        if (r2 == null) goto L5;
        IMFileResult r3 = r2.getResultType();
    L6:
        MessagePermissionUtil.ReceiveAuthorizationState r4 = MessagePermissionUtil.h(r3);
        boolean r38 = MessagePermissionUtil.f(r53, r54.getChat(), null);
        if (r54.m() == false) goto L9;
    L14:
        r52.f();
    L15:
        r52.e(r53.getcId());
        FileContentVO r6 = r53.b();
        FileState r5 = (FileState) r6.t.getValue();
        if (r53.G() != SendStatus.SUCCESS) goto L18;
        r5 = FileState.DOWNLOAD;
    L18:
        Log.d("FileContentBlockController", "file key = " + r6.e());
        boolean r16 = r6.g();
        boolean r17 = r6.h();
        boolean r18 = r6.i();
        boolean r7 = r6.n;
        Message.FileDeletedStatus r15 = r6.q;
        Message.FileDeletedStatus r12 = Message.FileDeletedStatus.UNRECOVERABLE;
        if (r15 != r12) goto L21;
        boolean r20 = true;
    L22:
        Message.FileDeletedStatus r9 = Message.FileDeletedStatus.RECOVERABLE;
        if (r15 != r9) goto L25;
        boolean r21 = true;
    L27:
        if (r15 != Message.FileDeletedStatus.FREED_UP) goto L29;
        boolean r22 = true;
    L30:
        boolean r23 = !r53.isPreMessage();
        String r25 = (String) r6.r.getValue();
        FileView.FileState r8 = new FileView.FileState(r5.getFileStateType(), UIUtils.getString(r13, r5.getValue()));
        String r27 = r6.f();
        long r28 = ((Number) r6.d.getValue()).longValue();
        int r30 = ((Number) r6.u.getValue()).intValue();
        long r31 = ((Number) r6.v.getValue()).longValue();
        if (s.b(r14, r53.b().f()) == false) goto L51;
        if (r1 == true) goto L51;
        if (r54.b0() == true) goto L51;
        if (r38 == false) goto L51;
        FileContentVO r10 = r53.b();
        FileContent.FileAbility r11 = (FileContent.FileAbility) r53.b().y.getValue();
        if (FileContent.FileAbility.SUPPORT_EDIT != r11) goto L40;
    L44:
        boolean r19 = false;
    L45:
        if (r19 == true) goto L51;
        String r24 = (String) r10.A.getValue();
        if (r24 == null) goto L51;
        long r110 = ((Number) r10.z.getValue()).longValue();
        c7c.a r26 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r26.b(DisplayPattern.RELATIVE);
        r26.c(LengthType.LONG);
        ChatCoreModule.a().getTimeFormatDependency().a();
        r26.h = false;
        r26.d(TimePreciseness.SECOND);
        r26.j = true;
        String r34 = UIHelper.mustacheFormat(2131891332, "time", c7c.b.c(UIHelper.getContext(), new Date(r110), r26)) + ' ' + r24;
    L52:
        int r35 = r4.getValue();
        ResourceCleanScene r36 = lpc.a.b(r53);
        y6b.b r29 = r53.a();
        if (r29 == null) goto L56;
        String r32 = r29.w;
        if (r32 == null) goto L56;
    L57:
        r52.n(new FileView.b(r16, r17, r18, r7, r20, r21, r22, r23, r38, r25, r8, r27, r28, r30, r31, false, r34, r35, r36, r32), new b(this, r52, r53, r54, r55, r6));
        if (r6.n == true) goto L64;
        Message.FileDeletedStatus r33 = r6.q;
        if (r33 == r9) goto L64;
        if (r33 == r12) goto L64;
        if (r6.h() == true) goto L64;
    L65:
        boolean r111 = true;
    L67:
        r52.g(r111);
        r52.m(new c(r56, r57, r53));
        if (r53.j() == false) goto L70;
    L78:
        boolean r112 = false;
    L80:
        if (r54.m() == false) goto L82;
    L91:
        boolean r37 = true;
    L92:
        if (r37 == true) goto L96;
        if (r112 == true) goto L96;
        boolean r113 = false;
    L97:
        r52.h(r113);
        r52.c();
        r52.k();
        r52.a(UIUtils.getColor(r13, 2131103351));
        if (r.a(r53.i()) == true) goto L100;
    L102:
        boolean r114 = false;
    L103:
        r52.j(r114);
        ViewGroup r39 = r52.o();
        if (r39 == null) goto L161;
        r52.b();
        FileContentVO r40 = r53.b();
        if (s.b(r14, r40.f()) == true) goto L109;
        return;
    L109:
        if (s.a(r40) == false) goto L158;
        FileContent.FileAbility r41 = (FileContent.FileAbility) r53.b().y.getValue();
        if (FileContent.FileAbility.SUPPORT_EDIT != r41) goto L113;
    L117:
        boolean r115 = false;
    L118:
        if (r115 == false) goto L120;
        return;
    L120:
        if (r54.b0() == true) goto L160;
        if (r38 == false) goto L162;
        boolean r42 = false;
        if (r55 != null) goto L126;
    L128:
        boolean r43 = false;
    L129:
        if (r43 == true) goto L163;
        ViewGroup.LayoutParams r44 = r39.getLayoutParams();
        Intrinsics.checkNotNull(r44, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r54.m() == false) goto L134;
    L154:
        r52.k();
    L155:
        r52.d(r45);
        com.ss.android.lark.chatwindow.view.preview.i.b(r40.j());
        UrlPreviewBinder r116 = new UrlPreviewBinder(r52.getContext(), null, new f3b.d(r53, r54.getChat(), r54.x8()), r54, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.b.a);
        h2b.c r46 = new h2b.c(r40.j(), r53.b().B, CollectionsKt.emptyList(), true);
        Intrinsics.checkNotNullParameter(r39, "parent");
        r116.c(r46, new UrlPreviewBinder.b(r39));
        return;
    L134:
        if (r54.Y() == true) goto L154;
        if (r54.r() == true) goto L154;
        if (r54.q() == true) goto L154;
        Intrinsics.checkNotNullParameter(r53, "messageVO");
        if (Message.Type.FILE != r53.getType()) goto L149;
        FileContentVO r47 = r53.b();
        if ((r47 instanceof FileContentVO) == false) goto L149;
        if (r53.d() == false) goto L149;
        r42 = s.a(r47);
    L149:
        if (r42 == false) goto L154;
        if (l1.a() == true) goto L154;
        r52.i();
        goto L155
    L163:
        return;
    L126:
        if (r55.c == true) goto L128;
        r43 = true;
        goto L129
    L162:
        return;
    L160:
        return;
    L113:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r41) goto L117;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r41) goto L117;
        r115 = true;
        goto L118
    L158:
        return;
    L161:
        return;
    L100:
        if (r53.d() == true) goto L102;
        r114 = true;
    L96:
        r113 = true;
        goto L97
    L82:
        if (r53.l() == false) goto L91;
        if (r54.Y() == true) goto L91;
        if (r54.r() == true) goto L91;
        if (r54.q() == true) goto L91;
        r37 = false;
        goto L92
    L70:
        if (r53.m() == true) goto L78;
        if (r53.O() == true) goto L78;
        if (r53.l() == false) goto L78;
        if (r53.d() == false) goto L78;
        r112 = true;
    L64:
        if (r38 == false) goto L65;
        r111 = false;
    L56:
        r32 = BuildConfig.FLAVOR;
        goto L57
    L40:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r11) goto L44;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r11) goto L44;
        r19 = true;
    L51:
        r34 = null;
        goto L52
    L29:
        r22 = false;
        goto L30
    L25:
        r21 = false;
        goto L27
    L21:
        r20 = false;
        goto L22
    L9:
        if (r54.r() == true) goto L14;
        if (r54.Y() == true) goto L14;
        if (r54.q() == false) goto L15;
    L5:
        r3 = null;
        goto L6
    }
}
