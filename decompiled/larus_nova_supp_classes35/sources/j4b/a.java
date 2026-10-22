package j4b;

import android.app.Application;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.LarkUriUtil;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.g0;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.biz.im.api.l;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.biz.im.api.t0;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.b1;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q3b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a implements q4b.a {
    public final com.ss.android.lark.im.sdk.service.h a;
    public final p b;
    public final IChatService c;
    public final c d;
    public Chat e;
    public ChatChatter f;
    public final List<g0> g;

    /* JADX INFO: renamed from: j4b.a$a, reason: collision with other inner class name */
    public static class C0238a extends f {
        public C0238a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "ref");
            super(r2);
        }

        @Override // j4b.a.f, com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void a(ErrorResult r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "errorResult");
            Intrinsics.checkNotNullParameter(r3, "preMessage");
            super.a(r2, r3);
            if (r2.getErrorCode() != 321000) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L15;
            String r5 = r2.getDisplayMsg();
            if (r5 == null) goto L16;
            a r6 = this.r.get();
            if (r6 == null) goto L17;
            c r7 = r6.d;
            if (r7 == null) goto L18;
            r7.onAuditedFailed(r5);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class b {
    }

    public interface c extends d {
        void b(Message r1, String r2);

        void g0(Message r1, ErrorResult r2);

        void h0(hya.b r1, com.ss.android.lark.chatbase.model.c.b r2);

        @Deprecated(message = "will be removed in the future")
        MessageParams.a<?, ?> j(MessageParams.a<?, ?> r1);

        void o();

        void onAuditedFailed(String r1);

        void q0(jkb.e r1, Message r2);
    }

    public interface d {
        void R();

        void g(String r1, MessageParams<?, ?> r2);
    }

    public static final class e extends C0238a {
        public e(a r2) {
            Intrinsics.checkNotNullParameter(r2, "ref");
            super(r2);
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback, m6b.p
        public final void onBeginSendMessage(Message r4) {
            if (r4 == null) goto L9;
            a r0 = this.r.get();
            if (r0 == null) goto L10;
            c r1 = r0.d;
            if (r1 == null) goto L11;
            r1.h0(new o(r4), new s3b.d(r4));
            return;
        L11:
            return;
        L10:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback, com.ss.android.lark.chat.service.impl.u
        public final void onUpdateMediaCompressProgress(Message r4) {
            if (r4 == null) goto L9;
            a r0 = this.r.get();
            if (r0 == null) goto L10;
            c r1 = r0.d;
            if (r1 == null) goto L11;
            r1.h0(new o(r4), new s3b.d(r4));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static class f extends MonitorMessageSendCallback {
        public final WeakReference<a> r;

        public f(a r2) {
            Intrinsics.checkNotNullParameter(r2, "ref");
            this.r = new WeakReference(r2);
            Chat r0 = r2.e;
            this.d = r0;
            if (r0.isGroup() == false) goto L5;
            this.g = Scene.Group;
        L5:
            this.e = r2.f;
            p(new n4b.a(r2.e));
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public /* bridge */ /* synthetic */ void g(Object r1) {
            u((o6b.b) r1);
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void l(String r1) {
            super.l(r1);
            a r2 = this.r.get();
            if (r2 == null) goto L8;
            c r3 = r2.d;
            if (r3 == null) goto L9;
            r3.R();
            return;
        L9:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public void u(o6b.b r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            super.u(r5);
            a r0 = this.r.get();
            if (r0 == null) goto L7;
            c r1 = r0.d;
            if (r1 == null) goto L7;
            r1.b(r5.a, r5.b);
        L7:
            a r2 = this.r.get();
            if (r2 == null) goto L15;
            List<g0> r3 = r2.g;
            if (r3 == null) goto L17;
            Iterator r4 = ((ArrayList) r3).iterator();
        L13:
            if (r4.hasNext() == false) goto L18;
            ((g0) r4.next()).b(r5.a, r5.b);
            goto L13
        L18:
            return;
        L17:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public void a(ErrorResult r5, Message r6) {
            Intrinsics.checkNotNullParameter(r5, "errorResult");
            Intrinsics.checkNotNullParameter(r6, "preMessage");
            super.a(r5, r6);
            a r0 = this.r.get();
            if (r0 == null) goto L7;
            c r1 = r0.d;
            if (r1 == null) goto L7;
            r1.g0(r6, r5);
        L7:
            a r2 = this.r.get();
            if (r2 == null) goto L18;
            List<g0> r3 = r2.g;
            if (r3 == null) goto L22;
            Iterator r4 = ((ArrayList) r3).iterator();
        L13:
            if (r4.hasNext() == false) goto L23;
            g0 r7 = (g0) r4.next();
            Integer r8 = Integer.valueOf(r5.getCode());
            String r9 = r5.getDisplayMsg();
            if (r9 != null) goto L17;
            r9 = r5.getDebugMsg();
        L17:
            r7.c(r6, r8, r9);
            goto L13
        L23:
            return;
        L22:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void d(String r3, MessageParams<?, ?> r4) {
            Intrinsics.checkNotNullParameter(r4, "messageParams");
            super.d(r3, r4);
            a r0 = this.r.get();
            if (r0 == null) goto L7;
            c r1 = r0.d;
            if (r1 == null) goto L7;
            r1.g(r3, r4);
        L7:
            a r2 = this.r.get();
            if (r2 == null) goto L15;
            List<g0> r5 = r2.g;
            if (r5 == null) goto L17;
            Iterator r6 = ((ArrayList) r5).iterator();
        L13:
            if (r6.hasNext() == false) goto L18;
            ((g0) r6.next()).e(r3, r4);
            goto L13
        L18:
            return;
        L17:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void k(jkb.e r5, Message r6) {
            Intrinsics.checkNotNullParameter(r5, "reason");
            super.k(r5, r6);
            a r0 = this.r.get();
            if (r0 == null) goto L7;
            c r1 = r0.d;
            if (r1 == null) goto L7;
            r1.q0(r5, r6);
        L7:
            a r2 = this.r.get();
            if (r2 == null) goto L15;
            List<g0> r3 = r2.g;
            if (r3 == null) goto L17;
            Iterator r4 = ((ArrayList) r3).iterator();
        L13:
            if (r4.hasNext() == false) goto L18;
            ((g0) r4.next()).d(r6, r5.b, r5.a);
            goto L13
        L18:
            return;
        L17:
            return;
        }
    }

    public final class g extends f {
        public final a s;
        public final StickerFileInfo t;
        public final /* synthetic */ a u;

        @Override // j4b.a.f, com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final /* bridge */ /* synthetic */ void g(Object r1) {
            u((o6b.b) r1);
        }

        @Override // j4b.a.f, com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void u(o6b.b r11) {
            Intrinsics.checkNotNullParameter(r11, "response");
            super.u(r11);
            String r8 = ChatCoreModule.a().getLoginDependency().getUserId();
            Message r12 = r11.a;
            ChatHitPoint r0 = ChatHitPoint.a;
            a r1 = this.u;
            com.ss.android.lark.im.sdk.service.h r3 = r1.a;
            IChatService r4 = r1.c;
            StickerFileInfo r2 = this.t;
            String r6 = r2.stickerSetId;
            String r7 = r2.stickerId;
            Intrinsics.checkNotNull(r8);
            String r9 = r12.getcId();
            String r5 = r12.getChatId();
            Chat r10 = this.s.e;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r3, "chatterService");
            Intrinsics.checkNotNullParameter(r4, "legacyChatService");
            Intrinsics.checkNotNullParameter(r8, "userUniqueId");
            Intrinsics.checkNotNullParameter(r9, "cid");
            Intrinsics.checkNotNullParameter(r5, "chatId");
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.statistics.chat.a(r10, r3, r4, r5, r6, r7, r8, r9));
        }

        public g(a r2, a r3, StickerFileInfo r4) {
            Intrinsics.checkNotNullParameter(r3, "ref");
            Intrinsics.checkNotNullParameter(r4, "stickerFileInfo");
            this.u = r2;
            super(r3);
            this.s = r3;
            this.t = r4;
        }
    }

    public static final class h extends f {
        public final /* synthetic */ m5b.e s;

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final /* bridge */ /* synthetic */ void h(MessageInfo r1) {
            s(r1);
        }

        @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
        public final void s(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
            super.s(r2);
            AudioContent r3 = (AudioContent) r2.getMessage().getContent();
            Integer r0 = this.s.v;
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            r3.setDuration(r1);
            r3.setLocalFilePath(this.s.w);
            r3.setRecognizeFinished(true);
            r3.setNeedHideText(true);
            r3.setFileState(AudioContent.AudioState.DOWNLOAD);
            return;
        L5:
            r1 = 0;
            goto L6
        }

        public h(a r1, m5b.e r2) {
            this.s = r2;
            super(r1);
        }
    }

    public /* synthetic */ class i implements com.ss.android.lark.chat.entity.message.a, FunctionAdapter {
        public final /* synthetic */ c a;

        public i(c r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof com.ss.android.lark.chat.entity.message.a) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(1, this.a, c.class, "onInterceptMessageParams", "onInterceptMessageParams(Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;)Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", 8);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.ss.android.lark.chat.entity.message.a
        public final void a(MessageParams.a<?, ?> r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.j(r2);
        }
    }

    public static final class j implements e2b.h.a {
        public final /* synthetic */ a a;
        public final /* synthetic */ List<String> b;

        public j(a r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // e2b.h.a
        public final void a(PolarisFileWrapper r4) {
            Intrinsics.checkNotNullParameter(r4, "file");
            this.a.v(r4, null, this.b.size());
        }
    }

    static {
    }

    @Override // m5b.a
    public final String m() {
        Chat r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getId();
    }

    @Override // m5b.b
    public Message a(m5b.d r7) {
        Chat r0 = this.e;
        String r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.d.o();
        if (r7 == null) goto L8;
        m5b.e r2 = r7.e;
    L9:
        h5b.a.C0230a r3 = new h5b.a.C0230a();
        r3.c = r0.getId();
        String r4 = BuildConfig.FLAVOR;
        if (r2 == null) goto L13;
        String r5 = r2.j;
        if (r5 == null) goto L13;
    L14:
        r3.a = r5;
        this.d.j(r3);
        if (r2 == null) goto L20;
        String r6 = r2.k;
        if (r6 == null) goto L20;
        r4 = r6;
    L20:
        r3.b = r4;
        if (r2 == null) goto L23;
        String r8 = r2.p;
    L24:
        r3.i = r8;
        boolean r9 = false;
        if (r2 == null) goto L29;
        Boolean r10 = r2.q;
        if (r10 == null) goto L29;
        boolean r11 = r10.booleanValue();
    L30:
        r3.m = r11;
        if (r2 == null) goto L33;
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r12 = r2.t;
    L34:
        r3.s = r12;
        if (r2 == null) goto L37;
        Long r13 = r2.d;
    L38:
        r3.w = r13;
        if (r2 == null) goto L41;
        r9 = r2.b;
    L41:
        r3.v = r9;
        r3.e = r0.getLastMessagePosition();
        if (r2 == null) goto L44;
        String r14 = r2.u;
    L45:
        r3.d = r14;
        if (r2 == null) goto L48;
        String r15 = r2.w;
    L49:
        r3.A = r15;
        if (r7 == null) goto L54;
        PartialReplyInfo r16 = r7.d;
        if (r16 == null) goto L54;
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r17 = ReplyActionUtils.e(r16);
    L55:
        r3.s = r17;
        r3.C = AudioContent.AudioState.RECORDING;
        h5b.a r18 = r3.b();
        if (r2 == null) goto L59;
        r1 = r2.u;
    L59:
        return r18.c(r1, ChatCoreModule.a().getLoginDependency().getUserId());
    L54:
        r17 = null;
        goto L55
    L48:
        r15 = null;
        goto L49
    L44:
        r14 = null;
        goto L45
    L37:
        r13 = null;
        goto L38
    L33:
        r12 = null;
    L29:
        r11 = false;
        goto L30
    L23:
        r8 = null;
    L13:
        r5 = BuildConfig.FLAVOR;
        goto L14
    L8:
        r2 = null;
        goto L9
    }

    @Override // m5b.b
    public void b(m5b.d r8) {
        if (r8 == null) goto L23;
        m5b.e r0 = r8.e;
        if (r0 == null) goto L25;
        Message r1 = r0.s;
        if (r1 != null) goto L9;
        return;
    L9:
        Chat r2 = this.e;
        if (r2 == null) goto L24;
        this.d.o();
        AudioContent r3 = (AudioContent) r1.getContent();
        MonitorMessageSendCallback r4 = r0.x;
        if (r4 != null) goto L14;
        r4 = new h(this, r0);
    L14:
        h5b.a.C0230a r5 = new h5b.a.C0230a();
        r5.c = r2.getId();
        r5.a = r0.j;
        r5.b = r0.k;
        r5.i = r0.p;
        Boolean r6 = r0.q;
        int r7 = 0;
        if (r6 == null) goto L17;
        boolean r9 = r6.booleanValue();
    L18:
        r5.m = r9;
        r5.e = r2.getLastMessagePosition();
        r5.d = r0.u;
        r5.C = AudioContent.AudioState.DOWNLOAD;
        Integer r10 = r0.v;
        if (r10 == null) goto L21;
        r7 = r10.intValue();
    L21:
        r5.B = r7;
        r5.A = r0.w;
        r5.w = r0.d;
        r5.v = r0.b;
        r5.s = ReplyActionUtils.e(r8.d);
        r5.D = r3.getUploadId();
        this.d.j(r5);
        r5.E = r3.getAudioToken();
        r5.s = r0.t;
        h5b.a r11 = r5.b();
        p r12 = this.b;
        Intrinsics.checkNotNull(r11);
        r12.ib(r11, r4);
        return;
    L17:
        r9 = false;
        goto L18
    L24:
        return;
    L25:
        return;
    }

    @Override // m5b.a
    public final void c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.g).remove(r2);
    }

    @Override // m5b.b
    public void g(m5b.d r6) {
        Chat r0 = this.e;
        if (r0 != null) goto L6;
        Log.e("MessageSender", "sendTextMessage: mCurrentChat is null");
        return;
    L6:
        this.d.o();
        p r1 = this.b;
        MessageParams.a<?, ?> r2 = new j1.a();
        r2.c = r0.getId();
        r2.e = r0.getLastMessagePosition();
        r2.d = UUID.randomUUID().toString();
        Boolean r3 = null;
        if (r6 == null) goto L11;
        m5b.e r4 = r6.e;
        if (r4 == null) goto L11;
        String r5 = r4.j;
    L12:
        r2.a = r5;
        if (r6 == null) goto L17;
        m5b.e r7 = r6.e;
        if (r7 == null) goto L17;
        String r8 = r7.k;
    L18:
        r2.b = r8;
        if (r6 == null) goto L23;
        m5b.e r9 = r6.e;
        if (r9 == null) goto L23;
        String r10 = r9.p;
    L24:
        r2.i = r10;
        if (r6 == null) goto L27;
        PartialReplyInfo r11 = r6.d;
    L28:
        r2.s = ReplyActionUtils.e(r11);
        boolean r12 = false;
        if (r6 == null) goto L35;
        m5b.e r13 = r6.e;
        if (r13 == null) goto L35;
        Boolean r14 = r13.q;
        if (r14 == null) goto L35;
        boolean r15 = r14.booleanValue();
    L36:
        r2.m = r15;
        if (r6 == null) goto L41;
        m5b.e r16 = r6.e;
        if (r16 == null) goto L41;
        boolean r17 = r16.B;
    L42:
        r2.r = r17;
        if (r6 == null) goto L45;
        RichText r18 = r6.c;
    L46:
        ((j1.a) r2).A = r18;
        if (r6 == null) goto L51;
        m5b.e r19 = r6.e;
        if (r19 == null) goto L51;
        List<File> r20 = r19.A;
    L52:
        if (r20 != null) goto L54;
        r20 = Collections.emptyList();
    L54:
        ((j1.a) r2).C = r20;
        if (r6 == null) goto L61;
        m5b.e r21 = r6.e;
        if (r21 == null) goto L61;
        xcb.a r22 = r21.z;
        if (r22 == null) goto L61;
        Map<String, UrlPreviewHangPoint> r23 = r22.a;
    L62:
        r2.y = r23;
        if (r6 == null) goto L69;
        m5b.e r24 = r6.e;
        if (r24 == null) goto L69;
        xcb.a r25 = r24.z;
        if (r25 == null) goto L69;
        Map<String, UrlPreviewEntity> r26 = r25.b;
    L70:
        r2.z = r26;
        if (r6 == null) goto L75;
        m5b.e r27 = r6.e;
        if (r27 == null) goto L75;
        boolean r28 = r27.c;
    L76:
        ((j1.a) r2).B = r28;
        if (r6 == null) goto L81;
        m5b.e r29 = r6.e;
        if (r29 == null) goto L81;
        r12 = r29.b;
    L81:
        r2.v = r12;
        if (r6 == null) goto L86;
        m5b.e r30 = r6.e;
        if (r30 == null) goto L86;
        Long r31 = r30.d;
    L87:
        r2.w = r31;
        if (r6 == null) goto L92;
        m5b.e r32 = r6.e;
        if (r32 == null) goto L92;
        r3 = r32.e;
    L92:
        r2.x = r3;
        this.d.j(r2);
        r1.ib(r2.b(), new f(this));
        return;
    L86:
        r31 = null;
    L75:
        r28 = false;
    L69:
        r26 = null;
    L61:
        r23 = null;
    L51:
        r20 = null;
        goto L52
    L45:
        r18 = null;
    L41:
        r17 = false;
    L35:
        r15 = false;
        goto L36
    L27:
        r11 = null;
    L23:
        r10 = null;
    L17:
        r8 = null;
    L11:
        r5 = null;
        goto L12
    }

    @Override // q4b.a
    public final void i(List<? extends java.io.File> r5) {
        Intrinsics.checkNotNullParameter(r5, "files");
        if (CollectionUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.d.o();
        Iterator<? extends java.io.File> r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        v(r0.next(), BuildConfig.FLAVOR, r5.size());
        goto L7
    }

    @Override // m5b.b
    public void j(m5b.d r7) {
        Chat r0 = this.e;
        if (r0 != null) goto L6;
        Log.e("MessageSender", "sendImageMessage: mCurrentChat is null");
        return;
    L6:
        this.d.o();
        p r1 = this.b;
        MessageParams.a<?, ?> r2 = new p0.a();
        r2.c = r0.getId();
        r2.e = r0.getLastMessagePosition();
        r2.d = UUID.randomUUID().toString();
        Boolean r3 = null;
        if (r7 == null) goto L11;
        m5b.e r4 = r7.e;
        if (r4 == null) goto L11;
        String r5 = r4.j;
    L12:
        r2.a = r5;
        if (r7 == null) goto L17;
        m5b.e r6 = r7.e;
        if (r6 == null) goto L17;
        String r8 = r6.k;
    L18:
        r2.b = r8;
        if (r7 == null) goto L23;
        m5b.e r9 = r7.e;
        if (r9 == null) goto L23;
        String r10 = r9.p;
    L24:
        r2.i = r10;
        boolean r11 = false;
        if (r7 == null) goto L31;
        m5b.e r12 = r7.e;
        if (r12 == null) goto L31;
        Boolean r13 = r12.q;
        if (r13 == null) goto L31;
        boolean r14 = r13.booleanValue();
    L32:
        r2.m = r14;
        if (r7 == null) goto L37;
        m5b.e r15 = r7.e;
        if (r15 == null) goto L37;
        String r16 = r15.n;
    L38:
        ((p0.a) r2).A = r16;
        int r17 = 50;
        if (r7 == null) goto L45;
        m5b.e r18 = r7.e;
        if (r18 == null) goto L45;
        Integer r19 = r18.l;
        if (r19 == null) goto L45;
        int r20 = r19.intValue();
    L46:
        ((p0.a) r2).B = r20;
        if (r7 == null) goto L53;
        m5b.e r21 = r7.e;
        if (r21 == null) goto L53;
        Integer r22 = r21.m;
        if (r22 == null) goto L53;
        r17 = r22.intValue();
    L53:
        ((p0.a) r2).C = r17;
        if (r7 == null) goto L56;
        PartialReplyInfo r23 = r7.d;
    L57:
        r2.s = ReplyActionUtils.e(r23);
        if (r7 == null) goto L62;
        m5b.e r24 = r7.e;
        if (r24 == null) goto L62;
        boolean r25 = r24.y;
    L63:
        ((p0.a) r2).E = r25;
        if (r7 == null) goto L68;
        m5b.e r26 = r7.e;
        if (r26 == null) goto L68;
        String r27 = r26.f;
    L69:
        ((p0.a) r2).G = r27;
        if (r7 == null) goto L74;
        m5b.e r28 = r7.e;
        if (r28 == null) goto L74;
        Long r29 = r28.d;
    L75:
        r2.w = r29;
        if (r7 == null) goto L80;
        m5b.e r30 = r7.e;
        if (r30 == null) goto L80;
        r3 = r30.e;
    L80:
        r2.x = r3;
        if (r7 == null) goto L85;
        m5b.e r31 = r7.e;
        if (r31 == null) goto L85;
        r11 = r31.b;
    L85:
        r2.v = r11;
        this.d.j(r2);
        r2.h = Message.Type.IMAGE;
        r1.ib(new p0(r2), new C0238a(this));
        return;
    L74:
        r29 = null;
    L68:
        r27 = null;
    L62:
        r25 = false;
        goto L63
    L56:
        r23 = null;
    L45:
        r20 = 50;
    L37:
        r16 = null;
    L31:
        r14 = false;
    L23:
        r10 = null;
    L17:
        r8 = null;
    L11:
        r5 = null;
        goto L12
    }

    @Override // m5b.b
    public void l(m5b.d r6) {
        Chat r0 = this.e;
        if (r0 != null) goto L6;
        Log.e("MessageSender", "sendPostMessage: mCurrentChat is null");
        return;
    L6:
        this.d.o();
        p r1 = this.b;
        MessageParams.a<?, ?> r2 = new kya.a.a();
        r2.c = r0.getId();
        r2.e = r0.getLastMessagePosition();
        r2.d = UUID.randomUUID().toString();
        boolean r3 = false;
        ((kya.a.a) r2).C = false;
        Map<String, UrlPreviewEntity> r4 = null;
        if (r6 == null) goto L11;
        m5b.e r5 = r6.e;
        if (r5 == null) goto L11;
        String r7 = r5.j;
    L12:
        r2.a = r7;
        if (r6 == null) goto L17;
        m5b.e r8 = r6.e;
        if (r8 == null) goto L17;
        String r9 = r8.k;
    L18:
        r2.b = r9;
        if (r6 == null) goto L23;
        m5b.e r10 = r6.e;
        if (r10 == null) goto L23;
        String r11 = r10.p;
    L24:
        r2.i = r11;
        if (r6 == null) goto L31;
        m5b.e r12 = r6.e;
        if (r12 == null) goto L31;
        Boolean r13 = r12.q;
        if (r13 == null) goto L31;
        boolean r14 = r13.booleanValue();
    L32:
        r2.m = r14;
        if (r6 == null) goto L39;
        m5b.e r15 = r6.e;
        if (r15 == null) goto L39;
        Boolean r16 = r15.r;
        if (r16 == null) goto L39;
        boolean r17 = r16.booleanValue();
    L40:
        ((kya.a.a) r2).C = r17;
        if (r6 == null) goto L45;
        m5b.e r18 = r6.e;
        if (r18 == null) goto L45;
        boolean r19 = r18.B;
    L46:
        r2.r = r19;
        if (r6 == null) goto L49;
        String r20 = r6.a;
    L50:
        ((kya.a.a) r2).A = r20;
        if (r6 == null) goto L53;
        PartialReplyInfo r21 = r6.d;
    L54:
        r2.s = ReplyActionUtils.e(r21);
        if (r6 == null) goto L57;
        RichText r22 = r6.c;
    L58:
        ((kya.a.a) r2).B = r22;
        if (r6 == null) goto L63;
        m5b.e r23 = r6.e;
        if (r23 == null) goto L63;
        List<File> r24 = r23.A;
    L64:
        if (r24 != null) goto L66;
        r24 = Collections.emptyList();
    L66:
        ((kya.a.a) r2).E = r24;
        if (r6 == null) goto L71;
        m5b.e r25 = r6.e;
        if (r25 == null) goto L71;
        r3 = r25.b;
    L71:
        r2.v = r3;
        if (r6 == null) goto L76;
        m5b.e r26 = r6.e;
        if (r26 == null) goto L76;
        Long r27 = r26.d;
    L77:
        r2.w = r27;
        if (r6 == null) goto L82;
        m5b.e r28 = r6.e;
        if (r28 == null) goto L82;
        Boolean r29 = r28.e;
    L83:
        r2.x = r29;
        if (r6 == null) goto L90;
        m5b.e r30 = r6.e;
        if (r30 == null) goto L90;
        xcb.a r31 = r30.z;
        if (r31 == null) goto L90;
        Map<String, UrlPreviewHangPoint> r32 = r31.a;
    L91:
        r2.y = r32;
        if (r6 == null) goto L98;
        m5b.e r33 = r6.e;
        if (r33 == null) goto L98;
        xcb.a r34 = r33.z;
        if (r34 == null) goto L98;
        r4 = r34.b;
    L98:
        r2.z = r4;
        this.d.j(r2);
        r1.ib(r2.b(), new C0238a(this));
        return;
    L90:
        r32 = null;
    L82:
        r29 = null;
    L76:
        r27 = null;
    L63:
        r24 = null;
        goto L64
    L57:
        r22 = null;
        goto L58
    L53:
        r21 = null;
        goto L54
    L49:
        r20 = null;
    L45:
        r19 = false;
    L39:
        r17 = false;
    L31:
        r14 = false;
    L23:
        r11 = null;
    L17:
        r9 = null;
    L11:
        r7 = null;
        goto L12
    }

    @Override // m5b.b
    public void n(m5b.d r9) {
        this.d.o();
        Uri r0 = null;
        Boolean r1 = null;
        r0 = null;
        if (r9 == null) goto L7;
        m5b.e r2 = r9.e;
        if (r2 == null) goto L7;
        k r3 = r2.C;
    L9:
        if (r3 == null) goto L49;
        Chat r4 = this.e;
        if (r4 == null) goto L58;
        StringBuilder r5 = new StringBuilder("[DoubaoFile] create file message, storageType=");
        r5.append(r3.c);
        r5.append(", isLastInBatch=");
        m5b.e r6 = r9.e;
        if (r6 == null) goto L15;
        Boolean r7 = r6.e;
    L16:
        r5.append(r7);
        Log.i("MessageSender", r5.toString());
        C0238a r8 = new C0238a(this);
        r8.l = 1;
        p r10 = this.b;
        MessageParams.a<?, ?> r11 = new l.a();
        r11.c = r4.getId();
        r11.e = r4.getLastMessagePosition();
        r11.d = UUID.randomUUID().toString();
        String r12 = r3.b;
        if (r12 == null) goto L19;
        ((l.a) r11).B = r12;
    L19:
        ((l.a) r11).C = r3.a();
        ((l.a) r11).F = FileState.UPLOADING;
        m5b.e r13 = r9.e;
        if (r13 == null) goto L22;
        String r14 = r13.j;
    L23:
        r11.a = r14;
        if (r13 == null) goto L26;
        String r15 = r13.k;
    L27:
        r11.b = r15;
        if (r13 == null) goto L30;
        String r16 = r13.p;
    L31:
        r11.i = r16;
        boolean r17 = false;
        if (r13 == null) goto L36;
        Boolean r18 = r13.q;
        if (r18 == null) goto L36;
        boolean r19 = r18.booleanValue();
    L37:
        r11.m = r19;
        m5b.e r20 = r9.e;
        if (r20 == null) goto L40;
        Long r21 = r20.d;
    L41:
        r11.w = r21;
        if (r20 == null) goto L44;
        r1 = r20.e;
    L44:
        r11.x = r1;
        if (r20 == null) goto L47;
        r17 = r20.b;
    L47:
        r11.v = r17;
        r11.s = ReplyActionUtils.e(r9.d);
        ((l.a) r11).J = r3;
        this.d.j(r11);
        r10.ib(r11.b(), r8);
        return;
    L40:
        r21 = null;
    L36:
        r19 = false;
        goto L37
    L30:
        r16 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L22:
        r14 = null;
        goto L23
    L15:
        r7 = null;
        goto L16
    L58:
        return;
    L49:
        if (r9 == null) goto L53;
        m5b.e r22 = r9.e;
        if (r22 == null) goto L53;
        r0 = r22.o;
    L53:
        if (r0 != null) goto L56;
        Log.e("MessageSender", "sendFileMessage: uri is null");
        return;
    L56:
        w(CollectionsKt.listOf(r0), r9);
        return;
    L7:
        r3 = null;
        goto L9
    }

    @Override // m5b.b
    public void p(m5b.d r17) {
        Chat r3 = this.e;
        if (r3 == null) goto L105;
        this.d.o();
        if (r17 == null) goto L9;
        m5b.e r0 = r17.e;
        if (r0 == null) goto L9;
        String r1 = r0.n;
    L10:
        if (r17 == null) goto L14;
        m5b.e r5 = r17.e;
        if (r5 == null) goto L14;
        Uri r6 = r5.o;
    L15:
        if (r1 != null) goto L17;
    L101:
        Log.e("MessageSender", "sendVideoMessage: resourcePath or uri is null");
        return;
    L17:
        if (TextUtils.isEmpty(r1) == true) goto L101;
        if (r6 == null) goto L101;
        VFSFile r7 = com.ss.android.lark.videosend.tools.l.b().i(r1);
        e r8 = new e(this);
        String r9 = CompressPathManager.generateCompressFilePath(r1, Boolean.FALSE);
        int r10 = b1.a;
        Intrinsics.checkNotNullParameter(r1, "resourcePath");
        MediaMetadataRetriever r11 = new MediaMetadataRetriever();
        long r12 = 0;
        r11.setDataSource(r1);     // Catch: Throwable -> L33 Exception -> L35
        PolarisFileWrapper r13 = new PolarisFileWrapper(r1);     // Catch: Throwable -> L33 Exception -> L35
        if (r13.exists() == false) goto L24;
        long r14 = r13.length();     // Catch: Throwable -> L33 Exception -> L35
    L25:
        String r2 = b1.a(r11);     // Catch: Throwable -> L33 Exception -> L35
        if (r2 == null) goto L30;
        Long r4 = StringsKt.toLongOrNull(r2);     // Catch: Throwable -> L33 Exception -> L35
        if (r4 == null) goto L30;
        long r15 = r4.longValue();     // Catch: Throwable -> L33 Exception -> L35
    L31:
        Pair r16 = new Pair(Long.valueOf(r14), Long.valueOf(r15));     // Catch: Throwable -> L33 Exception -> L35
        r11.release();
    L38:
        if (r16 == null) goto L40;
        long r18 = ((Number) r16.getFirst()).longValue();
    L41:
        if (r16 == null) goto L44;
        r12 = ((Number) r16.getSecond()).longValue();
    L44:
        if (r3.isSecret() == true) goto L46;
        ResourcePreprocessor.d r19 = ResourcePreprocessor.c.a.b(r9, true);
    L47:
        if (r19 == null) goto L51;
        String r110 = r19.f;
        if (r110 == null) goto L51;
        r8.c = r110;
    L51:
        m5b.e r111 = r17.e;
        if (r111 == null) goto L56;
        Context r112 = r111.getContext();
        if (r112 == null) goto L56;
        String r20 = LarkUriUtil.l(r112, r6);
    L57:
        Message.Type r113 = Message.Type.MEDIA;
        r8.v(null, null, r113);
        MessageParams.a<?, ?> r114 = new t0.a();
        r114.c = r3.getId();
        m5b.e r21 = r17.e;
        if (r21 == null) goto L60;
        String r22 = r21.j;
    L61:
        r114.a = r22;
        if (r21 == null) goto L64;
        String r23 = r21.k;
    L65:
        r114.b = r23;
        if (r21 == null) goto L68;
        String r24 = r21.p;
    L69:
        r114.i = r24;
        boolean r25 = false;
        if (r21 == null) goto L74;
        Boolean r26 = r21.q;
        if (r26 == null) goto L74;
        boolean r27 = r26.booleanValue();
    L75:
        r114.m = r27;
        r114.e = r3.getLastMessagePosition();
        ((t0.a) r114).D = r7;
        ((t0.a) r114).C = r20;
        ((t0.a) r114).B = r18;
        ((t0.a) r114).A = r12;
        r114.l = r8.c;
        if (r19 == null) goto L78;
        String r28 = r19.d;
    L79:
        ((t0.a) r114).G = r28;
        ((t0.a) r114).E = r9;
        m5b.e r29 = r17.e;
        if (r29 == null) goto L82;
        String r30 = r29.h;
    L83:
        ((t0.a) r114).I = r30;
        if (r29 == null) goto L86;
        String r31 = r29.i;
    L87:
        ((t0.a) r114).H = r31;
        if (r29 == null) goto L90;
        Long r32 = r29.d;
    L91:
        r114.w = r32;
        if (r29 == null) goto L94;
        Boolean r33 = r29.e;
    L95:
        r114.x = r33;
        if (r29 == null) goto L98;
        r25 = r29.b;
    L98:
        r114.v = r25;
        ((t0.a) r114).J = true;
        r114.s = ReplyActionUtils.e(r17.d);
        this.d.j(r114);
        r114.h = r113;
        t0 r34 = new t0(r114);
        p r35 = this.b;
        Intrinsics.checkNotNull(r34);
        r35.ib(r34, r8);
        return;
    L94:
        r33 = null;
        goto L95
    L90:
        r32 = null;
        goto L91
    L86:
        r31 = null;
        goto L87
    L82:
        r30 = null;
        goto L83
    L78:
        r28 = null;
    L74:
        r27 = false;
        goto L75
    L68:
        r24 = null;
        goto L69
    L64:
        r23 = null;
        goto L65
    L60:
        r22 = null;
    L56:
        r20 = null;
        goto L57
    L46:
        r19 = null;
        goto L47
    L40:
        r18 = 0;
        goto L41
    L30:
        r15 = 0;
        goto L31
    L24:
        r14 = 0;
    L33:
        th = move-exception;
        r11.release();
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        r11.release();
        r16 = null;
    L14:
        r6 = null;
    L9:
        r1 = null;
        goto L10
    }

    @Override // q4b.a
    public final void q(List<? extends Uri> r2) {
        Intrinsics.checkNotNullParameter(r2, "uris");
        this.d.o();
        w(r2, null);
    }

    @Override // m5b.a
    public final void s(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.g).contains(r2) == true) goto L6;
        ((ArrayList) this.g).add(r2);
        return;
    }

    public final void w(List<? extends Uri> r17, m5b.d r18) {
        Chat r2 = this.e;
        if (r2 == null) goto L82;
        Application r3 = LarkContext.getApplication();
        if (r3 == null) goto L88;
        int r4 = r17.size();
        Iterator<T> r5 = r17.iterator();
    L8:
        if (r5.hasNext() == false) goto L89;
        Uri r6 = (Uri) r5.next();
        String r7 = LarkUriUtil.l(r3, r6);
        Pair r8 = LarkUriUtil.g(r3, r6);
        if (r8 == null) goto L8;
        String r9 = (String) r8.component1();
        long r10 = ((Number) r8.component2()).longValue();
        C0238a r11 = new C0238a(this);
        r11.l = r4;
        Chat r12 = this.e;
        if (r12 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == false) goto L19;
        ResourcePreprocessor.d r14 = ResourcePreprocessor.c.a.b(r6.getPath(), true);
    L20:
        p r15 = this.b;
        MessageParams.a<?, ?> r16 = new l.a();
        r16.c = r2.getId();
        r16.e = r2.getLastMessagePosition();
        r16.d = UUID.randomUUID().toString();
        if (r9 == null) goto L23;
        ((l.a) r16).B = r9;
    L23:
        ((l.a) r16).F = FileState.UPLOADING;
        if (r14 == null) goto L26;
        String r19 = r14.d;
    L27:
        ((l.a) r16).H = r19;
        if (r18 == null) goto L32;
        m5b.e r20 = r18.e;
        if (r20 == null) goto L32;
        String r21 = r20.j;
    L33:
        r16.a = r21;
        if (r18 == null) goto L38;
        m5b.e r22 = r18.e;
        if (r22 == null) goto L38;
        String r23 = r22.k;
    L39:
        r16.b = r23;
        if (r18 == null) goto L44;
        m5b.e r24 = r18.e;
        if (r24 == null) goto L44;
        String r25 = r24.p;
    L45:
        r16.i = r25;
        if (r18 == null) goto L52;
        m5b.e r26 = r18.e;
        if (r26 == null) goto L52;
        Boolean r27 = r26.q;
        if (r27 == null) goto L52;
        boolean r28 = r27.booleanValue();
    L53:
        r16.m = r28;
        if (r18 == null) goto L58;
        m5b.e r29 = r18.e;
        if (r29 == null) goto L58;
        String r30 = r29.g;
    L59:
        ((l.a) r16).I = r30;
        if (r18 == null) goto L64;
        m5b.e r31 = r18.e;
        if (r31 == null) goto L64;
        Long r32 = r31.d;
    L65:
        r16.w = r32;
        if (r18 == null) goto L70;
        m5b.e r33 = r18.e;
        if (r33 == null) goto L70;
        Boolean r34 = r33.e;
    L71:
        r16.x = r34;
        if (r18 == null) goto L76;
        m5b.e r35 = r18.e;
        if (r35 == null) goto L76;
        boolean r36 = r35.b;
    L77:
        r16.v = r36;
        ((l.a) r16).D = r10;
        ((l.a) r16).E = r7;
        ((l.a) r16).G = r6;
        if (r18 == null) goto L80;
        PartialReplyInfo r110 = r18.d;
    L81:
        r16.s = ReplyActionUtils.e(r110);
        this.d.j(r16);
        r15.ib(r16.b(), r11);
        goto L8
    L80:
        r110 = null;
    L76:
        r36 = false;
    L70:
        r34 = null;
    L64:
        r32 = null;
    L58:
        r30 = null;
    L52:
        r28 = false;
    L44:
        r25 = null;
    L38:
        r23 = null;
    L32:
        r21 = null;
        goto L33
    L26:
        r19 = null;
        goto L27
    L19:
        r14 = null;
        goto L20
    L14:
        if (r12.isSecret() == true) goto L16;
        r13 = true;
        goto L17
    L89:
        return;
    L88:
        return;
    }

    @Override // m5b.a
    public final void d(String r10, String r11, RichText r12) {
        Intrinsics.checkNotNullParameter(r10, "rootMsgId");
        Intrinsics.checkNotNullParameter(r11, "parentMsgId");
        Intrinsics.checkNotNullParameter(r12, "richText");
        o(r10, r11, r12, false, null, false, false);
    }

    @Override // m5b.a
    public final void k(String r10, String r11, RichText r12) {
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r12, "richText");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "rootMsgId");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "parentMsgId");
        x(r10, r11, r12, BuildConfig.FLAVOR, BuildConfig.FLAVOR, false, null, false);
    }

    public final void v(java.io.File r7, String r8, int r9) {
        Chat r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        String r2 = null;
        if (r1 == false) goto L11;
        ResourcePreprocessor.d r3 = ResourcePreprocessor.c.a.b(r7.getPath(), true);
    L12:
        Chat r4 = this.e;
        if (r4 == null) goto L25;
        C0238a r5 = new C0238a(this);
        r5.l = r9;
        p r10 = this.b;
        MessageParams.a<?, ?> r6 = new l.a();
        r6.c = r4.getId();
        r6.e = r4.getLastMessagePosition();
        if (TextUtils.isEmpty(r8) == false) goto L17;
        r8 = UUID.randomUUID().toString();
    L17:
        r6.d = r8;
        String r11 = r7.getName();
        if (r11 == null) goto L20;
        ((l.a) r6).B = r11;
    L20:
        ((l.a) r6).A = r7.getPath();
        ((l.a) r6).F = FileState.UPLOADING;
        if (r3 == null) goto L23;
        r2 = r3.d;
    L23:
        ((l.a) r6).H = r2;
        String[] r12 = FileUtils.a;
        ((l.a) r6).D = r7.length();
        ((l.a) r6).E = FileUtils.p(r7.getPath());
        this.d.j(r6);
        r10.ib(r6.b(), r5);
        return;
    L25:
        return;
    L11:
        r3 = null;
        goto L12
    L5:
        if (r0.isSecret() == true) goto L7;
        r1 = true;
        goto L8
    }

    public a(com.ss.android.lark.im.sdk.service.h r2, p r3, IChatService r4, BaseMessageSenderComponent r5) {
        Intrinsics.checkNotNullParameter(r2, "chatterService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "legacyChatService");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = new ArrayList();
    }

    @Override // q4b.a
    public void r(StickerFileInfo r6, String r7, String r8, PartialReplyInfo r9) {
        Intrinsics.checkNotNullParameter(r6, "stickerFileInfo");
        Intrinsics.checkNotNullParameter(r7, "rootMsgId");
        Intrinsics.checkNotNullParameter(r8, "parentMsgId");
        Chat r1 = this.e;
        if (r1 == null) goto L9;
        this.d.o();
        p r2 = this.b;
        h5b.b.a r3 = new h5b.b.a();
        r3.c = r1.getId();
        r3.e = r1.getLastMessagePosition();
        r3.a = r7;
        r3.b = r8;
        r3.s = ReplyActionUtils.e(r9);
        r3.A = r6;
        this.d.j(r3);
        r3.h = Message.Type.STICKER;
        r2.ib(new h5b.b(r3), new g(this, this, r6));
        ChatHitPoint r10 = ChatHitPoint.a;
        com.ss.android.lark.im.sdk.service.h r11 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "chatterService");
        Intrinsics.checkNotNullParameter(r6, "stickerFileInfo");
        Intrinsics.checkNotNullParameter(r1, "chat");
        if (r6.stickerSetId == null) goto L10;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.statistics.chat.b(r1, r11, r6));
        return;
    L10:
        return;
    }

    @Override // m5b.a
    public final void u(String r10, String r11, RichText r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "rootMsgId");
        Intrinsics.checkNotNullParameter(r11, "parentMsgId");
        Intrinsics.checkNotNullParameter(r12, "richText");
        o(r10, r11, r12, false, null, false, r13);
    }

    @Override // q4b.a
    public final Message e(String r3, String r4, String r5, String r6, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r7) {
        Intrinsics.checkNotNullParameter(r3, "rootMsgId");
        Intrinsics.checkNotNullParameter(r4, "parentMsgId");
        Intrinsics.checkNotNullParameter(r5, "fileName");
        Intrinsics.checkNotNullParameter(r6, "cid");
        if (this.e != null) goto L6;
        return null;
    L6:
        this.d.o();
        h5b.a.C0230a r0 = new h5b.a.C0230a();
        Chat r1 = this.e;
        if (r1 == null) goto L10;
        String r2 = r1.getId();
        if (r2 == null) goto L10;
    L11:
        r0.c = r2;
        r0.a = r3;
        this.d.j(r0);
        r0.b = r4;
        r0.s = r7;
        Chat r8 = this.e;
        Intrinsics.checkNotNull(r8);
        r0.e = r8.getLastMessagePosition();
        r0.d = r6;
        r0.A = r5;
        r0.C = AudioContent.AudioState.RECORDING;
        return r0.b().c(r6, ChatCoreModule.a().getLoginDependency().getUserId());
    L10:
        r2 = BuildConfig.FLAVOR;
        goto L11
    }

    @Override // q4b.a
    public final void h(List<? extends Photo> r8, String r9, String r10, int r11, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r12) {
        Intrinsics.checkNotNullParameter(r8, "photos");
        Intrinsics.checkNotNullParameter(r9, "rootMsgId");
        Intrinsics.checkNotNullParameter(r10, "parentMsgId");
        Log.i("MessageSender", "sendMediaMsg: method called");
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        Chat r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isSecret() == false) goto L15;
        ArrayList r13 = new ArrayList();
        Iterator<? extends Photo> r14 = r8.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        r13.add(com.ss.android.lark.im.base.a.b().i(r14.next().getPath()));
        goto L11
    L13:
        i(r13);
        return;
    L15:
        this.d.o();
        Photo r15 = (Photo) ListProtector.get(r8, 0);
        VFSFile r1 = com.ss.android.lark.videosend.tools.l.b().i(r15.getPath());
        e r2 = new e(this);
        r2.l = r11;
        String r3 = null;
        if (r0.isSecret() == true) goto L18;
        ResourcePreprocessor.d r16 = ResourcePreprocessor.c.a.b(r15.getCompressPath(), true);
    L19:
        if (r16 == null) goto L23;
        String r4 = r16.f;
        if (r4 == null) goto L23;
        r2.c = r4;
    L23:
        Message.Type r5 = Message.Type.MEDIA;
        r2.v(null, null, r5);
        MessageParams.a<?, ?> r6 = new t0.a();
        r6.c = r0.getId();
        r6.a = r9;
        r6.b = r10;
        r6.s = r12;
        r6.e = r0.getLastMessagePosition();
        ((t0.a) r6).D = r1;
        ((t0.a) r6).C = r15.getMimeType();
        ((t0.a) r6).B = r15.getSize();
        ((t0.a) r6).A = r15.getDuration();
        r6.l = r2.c;
        if (r16 == null) goto L26;
        r3 = r16.d;
    L26:
        ((t0.a) r6).G = r3;
        ((t0.a) r6).E = r15.getCompressPath();
        this.d.j(r6);
        r6.h = r5;
        t0 r17 = new t0(r6);
        p r18 = this.b;
        Intrinsics.checkNotNull(r17);
        r18.ib(r17, r2);
        return;
    L18:
        r16 = null;
        goto L19
    }

    @Override // q4b.a
    public final void f(List<String> r3, boolean r4, String r5, String r6, int r7, String r8, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r9) {
        Intrinsics.checkNotNullParameter(r3, "photos");
        Intrinsics.checkNotNullParameter(r5, "rootMsgId");
        Intrinsics.checkNotNullParameter(r6, "parentMsgId");
        Log.i("MessageSender", "sendImageMsg: method called");
        Chat r0 = this.e;
        if (r0 == null) goto L10;
        this.d.o();
        C0238a r1 = new C0238a(this);
        r1.l = r7;
        if (TextUtils.isEmpty(r8) == true) goto L7;
        r1.m = r8;
    L8:
        final e2b.h r10 = new e2b.h(r0.getId(), r3);
        r10.c = r4;
        r10.g = r0.getLastMessagePosition();
        r10.e = r6;
        r10.d = r5;
        r10.f = r9;
        Biz r11 = Biz.Messenger;
        r10.i = Scene.Chat;
        r10.j = r1;
        r10.m = new i(this.d);
        r10.h = r0.isSecret();
        r10.k = new j(this, r3);
        ImSdkService.f().P0().execute(new e2b.b(r10));
        return;
    L7:
        r1.m = "unknown";
        goto L8
    }

    @Override // m5b.c
    public final void o(String r5, String r6, RichText r7, boolean r8, PartialReplyInfo r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "rootMsgId");
        Intrinsics.checkNotNullParameter(r6, "parentMsgId");
        Intrinsics.checkNotNullParameter(r7, "richText");
        Chat r0 = this.e;
        if (r0 == null) goto L6;
        this.d.o();
        p r1 = this.b;
        MessageParams.a<?, ?> r2 = new j1.a();
        r2.c = r0.getId();
        r2.e = r0.getLastMessagePosition();
        r2.d = UUID.randomUUID().toString();
        r2.a = r5;
        r2.b = r6;
        ((j1.a) r2).A = r7;
        r2.r = r8;
        r2.v = r11;
        r2.s = ReplyActionUtils.e(r9);
        r2.u = r10;
        this.d.j(r2);
        r1.ib(r2.b(), new f(this));
        return;
    }

    @Override // m5b.a
    public final /* bridge */ /* synthetic */ void t(String r10, String r11, RichText r12, String r13, String r14, Boolean r15, PartialReplyInfo r16, boolean r17) {
        x(r10, r11, r12, r13, r14, r15.booleanValue(), r16, r17);
    }

    public final void x(String r4, String r5, RichText r6, String r7, String r8, boolean r9, PartialReplyInfo r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "richText");
        Intrinsics.checkNotNullParameter(r7, "rootMsgId");
        Intrinsics.checkNotNullParameter(r8, "parentMsgId");
        Chat r12 = this.e;
        if (r12 == null) goto L6;
        this.d.o();
        p r0 = this.b;
        MessageParams.a<?, ?> r1 = new kya.a.a();
        r1.c = r12.getId();
        r1.e = r12.getLastMessagePosition();
        r1.d = UUID.randomUUID().toString();
        ((kya.a.a) r1).C = false;
        r1.a = r7;
        r1.b = r8;
        ((kya.a.a) r1).A = r4;
        ((kya.a.a) r1).B = r6;
        r1.r = r9;
        r1.s = ReplyActionUtils.e(r10);
        r1.u = r11;
        this.d.j(r1);
        r0.ib(r1.b(), new C0238a(this));
        return;
    }
}
