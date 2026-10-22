package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.editor.input.ChatEditorEnable;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.utils.j;
import com.ss.android.lark.keyboard.widget.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceInnerEndPlugin implements wnb.b<VoiceInnerEndPlugin>, wnb.a {
    public static final b t = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;
    public ThreadTopic d;
    public wnb.d e;
    public View f;
    public com.ss.android.lark.keyboard.biz.voice.inject.d g;
    public boolean h;
    public final Lazy i;
    public final Lazy j;
    public volatile com.ss.android.lark.keyboard.biz.voice.inject.a k;
    public final ExecutorService l;
    public volatile boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    public final class a implements qob.a {
        public final /* synthetic */ VoiceInnerEndPlugin a;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin$a$a, reason: collision with other inner class name */
        public static final class C0128a extends j4b.a.f {
            public final /* synthetic */ int s;
            public final /* synthetic */ String t;

            public final /* bridge */ /* synthetic */ void h(MessageInfo r1) {
                s(r1);
            }

            public final void s(MessageInfo r2) {
                Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
                super/*com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback*/.s(r2);
                AudioContent r3 = r2.getMessage().getContent();
                r3.setDuration(this.s);
                r3.setLocalFilePath(this.t);
                r3.setRecognizeFinished(false);
                r3.setNeedHideText(true);
                r3.setFileState(AudioContent.AudioState.DOWNLOAD);
            }

            public C0128a(q4b.a r1, int r2, String r3) {
                this.s = r2;
                this.t = r3;
                super((j4b.a) r1);
            }
        }

        public static final class b extends MonitorMessageSendCallback {
            public final /* synthetic */ int r;
            public final /* synthetic */ String s;

            public final /* bridge */ /* synthetic */ void h(MessageInfo r1) {
                s(r1);
            }

            public final void s(MessageInfo r2) {
                Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
                super.s(r2);
                AudioContent r3 = r2.getMessage().getContent();
                r3.setDuration(this.r);
                r3.setLocalFilePath(this.s);
                r3.setRecognizeFinished(true);
                r3.setNeedHideText(true);
                r3.setFileState(AudioContent.AudioState.DOWNLOAD);
            }

            public b(VoiceInnerEndPlugin r1, int r2, String r3) {
                this.r = r2;
                this.s = r3;
                wnb.d r4 = r1.e;
                ChatChatter r5 = null;
                if (r4 == null) goto L5;
                Chat r6 = r4.e;
            L6:
                if (r4 == null) goto L8;
                r5 = r4.f;
            L8:
                if (r6 == null) goto L14;
                if (r5 == null) goto L14;
                ((MonitorMessageSendCallback) this).d = r6;
                if (r6.isGroup() == false) goto L13;
                ((MonitorMessageSendCallback) this).g = Scene.Group;
            L13:
                ((MonitorMessageSendCallback) this).e = r5;
                p(new n4b.a(r6));
                return;
            L14:
                Log.e("VoiceInnerEndPlugin", "chat or chatter not initialized");
                return;
            L5:
                r6 = null;
                goto L6
            }
        }

        @Override // qob.a
        public final void i() {
        }

        @Override // qob.a
        public final String getChatId() {
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L5;
            String r1 = r0.d;
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // qob.a
        public final com.ss.android.lark.keyboard.b n() {
            return this.a.n();
        }

        @Override // qob.a
        public final PartialReplyInfo c() {
            return com.ss.android.lark.keyboard.a.c(n());
        }

        @Override // qob.a
        public final String d() {
            return com.ss.android.lark.keyboard.a.b(n());
        }

        @Override // qob.a
        public final Message.PartialReplyInfo f() {
            return ReplyActionUtils.e(com.ss.android.lark.keyboard.a.c(n()));
        }

        @Override // qob.a
        public final String h() {
            return com.ss.android.lark.keyboard.a.d(n());
        }

        @Override // qob.a
        public final String k() {
            return ChatCoreModule.a().getLanguageDependency().getLanguageSetting().toString();
        }

        public a(VoiceInnerEndPlugin r1) {
            this.a = r1;
        }

        @Override // qob.a
        public final com.ss.android.lark.chat.entity.message.Message a(m5b.d r2) {
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L7;
            q4b.a r1 = r0.h;
            if (r1 == null) goto L7;
            return r1.a(r2);
        L7:
            return null;
        }

        @Override // qob.a
        public final void b(m5b.d r2) {
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L8;
            q4b.a r1 = r0.h;
            if (r1 == null) goto L9;
            r1.b(r2);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void g(m5b.d r2) {
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L8;
            q4b.a r1 = r0.h;
            if (r1 == null) goto L9;
            r1.g(r2);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void m(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L8;
            Function1<String, Unit> r1 = r0.i;
            if (r1 == null) goto L9;
            r1.invoke(r2);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void p(com.ss.android.lark.chat.entity.message.Message r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "fileName");
        }

        @Override // qob.a
        public final MonitorMessageSendCallback l(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "strFileName");
            Intrinsics.checkNotNullParameter(r3, "cid");
            wnb.d r5 = this.a.e;
            if (r5 == null) goto L5;
            q4b.a r6 = r5.h;
        L7:
            if ((r6 instanceof j4b.a) == false) goto L11;
            return new C0128a(r6, r4, r2);
        L11:
            return new b(this.a, r4, r2);
        L5:
            r6 = null;
            goto L7
        }

        @Override // qob.a
        public final void j(com.ss.android.lark.chat.entity.message.Message r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "text");
            Intrinsics.checkNotNullParameter(r4, "fileName");
            Intrinsics.checkNotNullParameter(r5, "cid");
        }

        @Override // qob.a
        public final void o(String r2, String r3, String r4, RichText r5) {
            Intrinsics.checkNotNullParameter(r2, "rootMsgId");
            Intrinsics.checkNotNullParameter(r3, "parentMsgId");
            Intrinsics.checkNotNullParameter(r4, "content");
            Intrinsics.checkNotNullParameter(r5, "richText");
        }

        @Override // qob.a
        public final com.ss.android.lark.chat.entity.message.Message e(String r8, String r9, String r10, String r11, Message.PartialReplyInfo r12) {
            Intrinsics.checkNotNullParameter(r8, "rootMsgId");
            Intrinsics.checkNotNullParameter(r9, "parentMsgId");
            Intrinsics.checkNotNullParameter(r10, "fileName");
            Intrinsics.checkNotNullParameter(r11, "cid");
            wnb.d r0 = this.a.e;
            if (r0 == null) goto L7;
            q4b.a r1 = r0.h;
            if (r1 == null) goto L7;
            return r1.e(r8, r9, r10, r11, r12);
        L7:
            return null;
        }
    }

    public static final class b implements wnb.b.a<VoiceInnerEndPlugin> {
        public b() {
        }
    }

    public static final class c implements View.OnFocusChangeListener {
        public final /* synthetic */ VoiceInnerEndPlugin a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ EditText c;

        public c(VoiceInnerEndPlugin r1, Fragment r2, EditText r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r5, boolean r6) {
            if (this.a.m == false) goto L5;
            return;
        L5:
            if (this.b.isResumed() == true) goto L8;
            return;
        L8:
            if (this.a.r() == true) goto L12;
            this.a.t(this.b, this.c);
            return;
        L12:
            if (Intrinsics.areEqual(r5, this.c) == true) goto L14;
        L19:
            VoiceInnerEndPlugin r0 = this.a;
            View.OnTouchListener r2 = null;
            boolean r3 = false;
            if (r0.n == false) goto L35;
            if (r0.o == true) goto L29;
            ViewGroup r7 = r0.o();
            if (r7 == null) goto L26;
            int r8 = r7.getChildCount();
        L27:
            if (r8 <= 0) goto L29;
            this.a.k(0);
            goto L29
        L26:
            r8 = 0;
        L29:
            EditText r9 = this.c;
            fya.a r10 = this.a.p();
            if (r10 == null) goto L32;
            r2 = r10.D0(this.c);
        L32:
            r9.setOnTouchListener(r2);
            return;
        L35:
            if (this.c.getVisibility() != 0) goto L37;
            boolean r1 = true;
        L38:
            if (r1 == true) goto L40;
        L52:
            this.a.t(this.b, this.c);
            return;
        L40:
            if (Intrinsics.areEqual(r5, this.c) == false) goto L52;
            if (r6 == true) goto L52;
            Editable r11 = this.c.getEditableText();
            if (r11 != null) goto L45;
        L46:
            r3 = true;
        L47:
            if (r3 == false) goto L52;
            this.a.k(4);
            EditText r12 = this.c;
            fya.a r13 = this.a.p();
            if (r13 == null) goto L51;
            r2 = r13.D0(this.c);
        L51:
            r12.setOnTouchListener(r2);
            return;
        L45:
            if (r11.length() != 0) goto L47;
        L37:
            r1 = false;
            goto L38
        L14:
            if (this.a.s() == false) goto L19;
            if (this.a.q().i == false) goto L19;
            this.a.t(this.b, this.c);
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ VoiceInnerEndPlugin a;

        public d(VoiceInnerEndPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            int r10 = r1.getMeasuredHeight();
            if (r10 <= 0) goto L10;
            VoiceInnerEndPlugin r11 = this.a;
            r11.p = r10;
            ViewGroup r12 = r11.o();
            if (r12 == null) goto L7;
            int r13 = r12.getVisibility();
        L8:
            r11.k(r13);
            return;
        L7:
            r13 = 8;
            goto L8
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ VoiceInnerEndPlugin a;

        public e(VoiceInnerEndPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            VoiceInnerEndPlugin r10 = this.a;
            if (r10.r() == false) goto L27;
            wnb.d r0 = r10.e;
            if (r0 == null) goto L28;
            Fragment r1 = r0.a;
            if (r1 != null) goto L12;
            return;
        L12:
            if (r10.n == false) goto L14;
            r10.m(r1, true);
            return;
        L14:
            View r2 = r1.getView();
            if ((r2 instanceof ViewGroup) == false) goto L17;
            ViewGroup r3 = (ViewGroup) r2;
        L18:
            if (r3 == null) goto L23;
            ViewGroup r4 = (ViewGroup) r3.findViewWithTag("flow_chat_message_list_view_observer");
            if (r4 == null) goto L23;
            int r5 = xob.a.a;
            Context r6 = r1.requireContext();
            String r7 = r10.a.c.getId();
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r7), new Pair("click", "switch_voice_input"), new Pair("target", "im_chat_voice_msg_view"), new Pair("keyboard_status", xob.a.a(r6))});
            r10.l(r1, r4);
            return;
        L23:
            Log.e("VoiceInnerEndPlugin", "voice start aborted: root view is null");
            return;
        L17:
            r3 = null;
            goto L18
        L28:
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ Function0 a;

        public f(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements fya.a.b {
        public final /* synthetic */ VoiceInnerEndPlugin a;

        public final String a() {
            VoiceInnerEndPlugin r0 = this.a;
            com.ss.android.lark.biz.im.api.extension.chat_window.h r1 = r0.a.e;
            String r2 = null;
            if (r1 == null) goto L7;
            MutableLiveData r3 = r1.c;
            if (r3 == null) goto L7;
            Chat r4 = (Chat) r3.getValue();
        L8:
            if (r4 == null) goto L10;
            String r5 = r4.getLastMessageId();
        L11:
            String r6 = "";
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            com.ss.android.lark.biz.im.api.extension.chat_window.h r7 = r0.a.e;
            if (r7 == null) goto L17;
            String r8 = r7.b;
        L18:
            if (r8 != null) goto L20;
            r8 = "";
        L20:
            boolean r9 = true;
            if (r8.length() != 0) goto L23;
            boolean r10 = true;
        L25:
            if (r10 == true) goto L47;
            ThreadTopic r11 = r0.d;
            if (r11 == null) goto L47;
            String r12 = r11.getLastMsgId();
            if (r12 == null) goto L34;
            r6 = r12;
        L34:
            if (r6.length() == 0) goto L38;
            r9 = false;
        L38:
            if (r9 == false) goto L43;
            StringBuilder r13 = new StringBuilder("threadTopic.lastMsgId is empty, chatId=");
            if (r4 == null) goto L42;
            r2 = r4.getId();
        L42:
            r13.append(r2);
            r13.append(", threadId=");
            r13.append(r8);
            r13.append(", contextQueryMsgId=");
            r13.append(r5);
            Log.w("VoiceInnerEndPlugin", r13.toString());
            return r5;
        L43:
            StringBuilder r14 = new StringBuilder("return thread.lastMsgId, chatId=");
            if (r4 == null) goto L46;
            r2 = r4.getId();
        L46:
            r14.append(r2);
            r14.append(", threadId=");
            r14.append(r8);
            r14.append(", contextQueryMsgId=");
            r14.append(r6);
            Log.i("VoiceInnerEndPlugin", r14.toString());
            return r6;
        L47:
            StringBuilder r15 = new StringBuilder("threadTopic is empty, return chat.lastMessageId, chatId=");
            if (r4 == null) goto L50;
            r2 = r4.getId();
        L50:
            r15.append(r2);
            r15.append(", contextQueryMsgId=");
            r15.append(r5);
            Log.i("VoiceInnerEndPlugin", r15.toString());
            return r5;
        L23:
            r10 = false;
            goto L25
        L17:
            r8 = null;
            goto L18
        L10:
            r5 = null;
        L7:
            r4 = null;
            goto L8
        }

        public final String getChatId() {
            return this.a.a.c.getId();
        }

        public g(VoiceInnerEndPlugin r1) {
            this.a = r1;
        }
    }

    public static final class h implements fya.a.c {
        public final /* synthetic */ VoiceInnerEndPlugin a;
        public final /* synthetic */ Fragment b;

        public final void onCancel() {
            VoiceInnerEndPlugin r0 = this.a;
            r0.getClass();
            r0.u("onExternalCancel", new VoiceInnerEndPlugin$onExternalCancel$1(r0));
        }

        public final void b(final byte[] r3) {
            Intrinsics.checkNotNullParameter(r3, "bytes");
            final VoiceInnerEndPlugin r0 = this.a;
            r0.getClass();
            r0.u("onExternalChunk", new VoiceInnerEndPlugin$onExternalChunk$1(r3, r0));
        }

        public final void c(boolean r2) {
            this.a.h = r2;
        }

        public final void e(fya.a.a r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            if ((r5 instanceof fya.a.a.c) == false) goto L6;
            int r6 = xob.a.a;
            Context r7 = this.b.requireContext();
            String r0 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r0, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r0), new Pair("click", "press_voice_input"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r7))});
            return;
        }

        public h(VoiceInnerEndPlugin r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(byte[] r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "bytes");
            Intrinsics.checkNotNullParameter(r3, "content");
            VoiceInnerEndPlugin.g(this.a, r3);
        }

        public final void d(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "content");
            VoiceInnerEndPlugin r0 = this.a;
            r0.h = r3;
            VoiceInnerEndPlugin.g(r0, r2);
        }
    }

    static {
        t = new b();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final void onDestroy() {
        this.m = true;
        n().e().of(this).a();
        this.o = false;
        View r2 = this.f;
        if (r2 == null) goto L5;
        r2.setOnClickListener(null);
    L5:
        com.ss.android.lark.keyboard.biz.voice.inject.d r3 = this.g;
        if (r3 == null) goto L9;
        this.g = null;
        n().L().c().removeTextChangedListener(r3);
    L9:
        ViewGroup r4 = (ViewGroup) this.s.getValue();
        if (r4 == null) goto L13;
        r4.setOnLongClickListener(null);
    L13:
        if (s() == false) goto L32;
        VoiceInputPreviewDelegate r5 = q();
        r5.i = false;
        r5.k = false;
        r5.j = VoiceInputPreviewDelegate.PreviewOriginMode.INPUT_UNFOCUSED;
        r5.l = "";
        r5.a(true);
        CoroutineScopeKt.cancel$default(r5.e, null, 1, null);
    L32:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        com.ss.android.lark.keyboard.biz.voice.inject.a r1 = this.k;     // Catch: Throwable -> L21
        if (r1 == null) goto L18;
        r1.a();     // Catch: Throwable -> L21
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(r6);     // Catch: Throwable -> L21
    L23:
        this.k = null;
        Result.constructor-impl(this.l.shutdownNow());     // Catch: Throwable -> L26
    L28:
        this.e = null;
        EditText r7 = n().L().c();
        r7.setOnFocusChangeListener(null);
        Map<View, View.OnTouchListener> r8 = l.a;
        Intrinsics.checkNotNullParameter(r7, "view");
        l.a.remove(r7);
        r7.setOnTouchListener(null);
        return;
    L26:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L18:
        r6 = null;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // wnb.b
    public final View a() {
        ViewGroup r2 = null;
        View r0 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131561612, null);
        r0.setOnClickListener(new e(this));
        this.f = r0;
        ViewGroup r1 = (ViewGroup) this.s.getValue();
        if (r1 != null) goto L5;
    L16:
        n().e().of(this).c(ChatEditorEnable.class, new VoiceInnerEndPlugin$getPluginView$2(this));
        if (r() == false) goto L61;
        fya.a r3 = p();
        if (r3 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L61;
        wnb.d r5 = this.e;
        if (r5 == null) goto L61;
        Fragment r6 = r5.a;
        if (r6 == null) goto L61;
        View r7 = r6.getView();
        if ((r7 instanceof ViewGroup) == false) goto L35;
        r2 = (ViewGroup) r7;
    L35:
        if (r2 == null) goto L60;
        ViewGroup r8 = (ViewGroup) r2.findViewWithTag("flow_chat_message_list_view_observer");
        if (r8 == null) goto L60;
        this.n = true;
        fya.a r9 = p();
        if (r9 == null) goto L42;
        r9.v5(true);
    L42:
        this.o = true;
        KeyboardUtils.hideKeyboard(this.a.a.requireContext());
        View r10 = this.f;
        if (r10 == null) goto L47;
        ImageView r11 = (ImageView) r10.findViewById(2131375952);
        if (r11 == null) goto L47;
        r11.setImageResource(2131235962);
    L47:
        v(r8, r6);
        ViewGroup r12 = (ViewGroup) this.s.getValue();
        if (r12.isLaidOut() == true) goto L50;
    L59:
        r12.addOnLayoutChangeListener(new com.ss.android.lark.keyboard.biz.voice.inject.e(this));
        goto L61
    L50:
        if (r12.isLayoutRequested() == true) goto L59;
        if (this.m == true) goto L61;
        if (this.n == false) goto L61;
        if (this.o == false) goto L61;
        this.o = false;
        k(0);
    L60:
        Log.e("VoiceInnerEndPlugin", "voice init aborted: root view is null");
        goto L61
    L21:
        if (r3.y3() != true) goto L23;
        r4 = true;
    L61:
        j();
        if (this.g != null) goto L66;
        EditText r13 = n().L().c();
        com.ss.android.lark.keyboard.biz.voice.inject.d r14 = new com.ss.android.lark.keyboard.biz.voice.inject.d(this);
        this.g = r14;
        r13.addTextChangedListener(r14);
    L66:
        if (s() == false) goto L69;
        n().e().of(this).c(q.b.class, new VoiceInnerEndPlugin$bindSendActionWatcher$1(this));
    L69:
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (r1.isLaidOut() == true) goto L7;
    L15:
        r1.addOnLayoutChangeListener(new d(this));
        goto L16
    L7:
        if (r1.isLayoutRequested() == true) goto L15;
        int r15 = r1.getMeasuredHeight();
        if (r15 <= 0) goto L16;
        this.p = r15;
        ViewGroup r16 = o();
        if (r16 == null) goto L13;
        int r17 = r16.getVisibility();
    L14:
        k(r17);
        goto L16
    L13:
        r17 = 8;
        goto L14
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final void j() {
        wnb.d r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        Fragment r1 = r0.a;
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = r1.getView();
        View.OnTouchListener r3 = null;
        if ((r2 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r2;
    L12:
        if (r4 == null) goto L49;
        ViewGroup r5 = (ViewGroup) r4.findViewWithTag("flow_chat_message_list_view_observer");
        if (r5 == null) goto L49;
        EditText r6 = n().L().c();
        if (r() == true) goto L21;
        t(r1, r6);
        return;
    L21:
        if (this.n == false) goto L26;
        fya.a r7 = p();
        if (r7 == null) goto L25;
        r3 = r7.D0(r6);
    L25:
        r6.setOnTouchListener(r3);
    L47:
        r6.setOnFocusChangeListener(new c(this, r1, r6));
        return;
    L26:
        boolean r8 = false;
        if (r6.getVisibility() != 0) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L44;
        if (r6.hasFocus() == true) goto L44;
        Editable r10 = r6.getEditableText();
        if (r10 != null) goto L36;
    L37:
        r8 = true;
    L38:
        if (r8 == false) goto L44;
        v(r5, r1);
        k(4);
        fya.a r11 = p();
        if (r11 == null) goto L42;
        r3 = r11.D0(r6);
    L42:
        r6.setOnTouchListener(r3);
        goto L47
    L36:
        if (r10.length() != 0) goto L38;
    L44:
        if (s() == false) goto L46;
        q().a(true);
    L46:
        t(r1, r6);
        goto L47
    L29:
        r9 = false;
    L49:
        Log.e("VoiceInnerEndPlugin", "voice start aborted: root view is null");
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public final ViewGroup o() {
        return (ViewGroup) this.r.getValue();
    }

    public final fya.a p() {
        return (fya.a) this.i.getValue();
    }

    public final VoiceInputPreviewDelegate q() {
        return (VoiceInputPreviewDelegate) this.q.getValue();
    }

    public final boolean r() {
        com.ss.android.lark.keyboard.keyboard2.b r0 = n().L();
        if ((r0 instanceof FlowChatKeyboardEditor) == false) goto L5;
        FlowChatKeyboardEditor r1 = (FlowChatKeyboardEditor) r0;
    L6:
        boolean r2 = false;
        if (r1 == null) goto L12;
        if (r1.y == true) goto L12;
        r2 = true;
    L12:
        return !r2;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean s() {
        fya.a r0 = p();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.z5() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEnd;
    }

    @Override // wnb.b
    public final wnb.b.a<VoiceInnerEndPlugin> getKey() {
        return t;
    }

    public VoiceInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.h = true;
        this.i = LazyKt.lazy(new VoiceInnerEndPlugin$voiceInputExtension$2(this));
        this.j = LazyKt.lazy(new VoiceInnerEndPlugin$attachmentExtension$2(this));
        this.l = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoiceInnerEndPlugin"));
        this.q = LazyKt.lazy(new VoiceInnerEndPlugin$voiceInputPreviewDelegate$2(this));
        this.r = LazyKt.lazy(new VoiceInnerEndPlugin$touchSpeakViewContainer$2(this));
        this.s = LazyKt.lazy(new VoiceInnerEndPlugin$etContainer$2(this));
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // wnb.a
    public final void f(wnb.d r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.e = r2;
    }

    public final void k(int r6) {
        ViewGroup r0 = (ViewGroup) this.s.getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getMeasuredHeight();
    L6:
        if (r2 <= 0) goto L8;
        this.p = r2;
    L8:
        ViewGroup r3 = o();
        if (r3 == null) goto L11;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L12:
        if (r4 == null) goto L16;
        int r5 = r4.height;
        int r7 = this.p;
        if (r5 == r7) goto L16;
        r4.height = r7;
        r3.setLayoutParams(r4);
    L16:
        ViewGroup r8 = o();
        if (r8 == null) goto L19;
        r8.setVisibility(r6);
    L19:
        ViewGroup r9 = (ViewGroup) this.s.getValue();
        if (r9 != null) goto L22;
        return;
    L22:
        if (o().getVisibility() != 0) goto L24;
        boolean r10 = true;
    L26:
        if ((!r10) == true) goto L29;
        r1 = 8;
    L29:
        r9.setVisibility(r1);
        return;
    L24:
        r10 = false;
        goto L26
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public static final void g(final VoiceInnerEndPlugin r32, String r33) {
        final com.ss.android.lark.keyboard.biz.voice.inject.a r2 = r32.k;
        Long r0 = null;
        r32.k = null;
        long r3 = System.currentTimeMillis();
        if (r32.h == true) goto L67;
        String r5 = StringsKt.trim(r33).toString();
        if (r5.length() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        return;
    L11:
        if (r32.s() == false) goto L29;
        wnb.d r4 = r32.e;
        if (r4 == null) goto L16;
        Fragment r7 = r4.a;
        if (r7 == null) goto L16;
    L17:
        boolean r8 = r32.n;
        r32.u("previewVoiceText_cancelVoice", new VoiceInnerEndPlugin$onExternalStop$1(r32, r2));
        r32.m(r7, false);
        VoiceInputPreviewDelegate r1 = r32.q();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "recognitionText");
        r1.a(true);
        EditText r9 = r1.a.L().c();
        r1.i = true;
        if (r8 == false) goto L20;
        VoiceInputPreviewDelegate.PreviewOriginMode r10 = VoiceInputPreviewDelegate.PreviewOriginMode.VOICE_MODE;
    L21:
        r1.j = r10;
        r1.k = false;
        r1.m = true;
        ExtensionEditTextCompatKt.p(r9, com.ss.android.lark.widget.richtext.c.c(r5));     // Catch: Throwable -> L26
        fya.a.d r11 = r1.b();     // Catch: Throwable -> L26
        if (r11 == null) goto L25;
        String r12 = r1.a.v().l().getKey().getTag();     // Catch: Throwable -> L26
        ImmersiveVoiceInputComponent.a r13 = ImmersiveVoiceInputComponent.a;     // Catch: Throwable -> L26
        r11.a(r9, Intrinsics.areEqual(r12, "ImmersiveVoiceKeyboardKey"));     // Catch: Throwable -> L26
    L25:
        r1.m = false;
        r1.l = r1.c();
        r9.clearFocus();
        r1.h = BuildersKt.launch$default(r1.e, null, null, new VoiceInputPreviewDelegate$startPreview$2(r1, r9, r5, null), 3, null);
        return;
    L26:
        th = move-exception;
        r1.m = false;
        throw th;
    L20:
        r10 = VoiceInputPreviewDelegate.PreviewOriginMode.INPUT_UNFOCUSED;
    L16:
        r7 = r32.a.a;
        goto L17
    L29:
        wxa.a r14 = (wxa.a) r32.j.getValue();
        if (r14 == null) goto L32;
        List r15 = r14.q1();
    L33:
        if (r15 != null) goto L36;
        r15 = CollectionsKt.emptyList();
    L36:
        if (r15.isEmpty() == true) goto L39;
        r0 = Long.valueOf(r3);
    L39:
        Long r16 = r0;
        wnb.d r17 = r32.e;
        if (r17 == null) goto L43;
        Fragment r18 = r17.a;
        if (r18 == null) goto L43;
    L45:
        if (j.a(r32.n(), r18, "VoiceInnerEndPlugin", r5, r16, new r(null, false, true, null, null, null, false, null, null, 8388603)) == true) goto L72;
        if (r2 == null) goto L48;
        String r19 = com.ss.android.lark.keyboard.a.d(r32.n());
        String r20 = com.ss.android.lark.keyboard.a.b(r32.n());
        RichText r21 = com.ss.android.lark.widget.richtext.c.c(r5);
        PartialReplyInfo r110 = com.ss.android.lark.keyboard.a.c(r32.n());
        Intrinsics.checkNotNullParameter(r19, "rootMsgId");
        Intrinsics.checkNotNullParameter(r20, "parentMsgId");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r21, "richText");
        m5b.e r22 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r22.j = r19;
        r22.k = r20;
        r22.d = r2.l;
        r22.b = r2.f;
        r2.b.g(new m5b.d("", r5, r21, r110, r22));
    L48:
        if (r2 == null) goto L73;
        k.a.a(r32.n().e(), q.a.a);
        return;
    L73:
        return;
    L72:
        return;
    L43:
        r18 = r32.a.a;
        goto L45
    L32:
        r15 = null;
        goto L33
    L7:
        r6 = false;
        goto L8
    L67:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        if (r2 == null) goto L53;
        r2.l = Long.valueOf(r3);     // Catch: Throwable -> L55
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L53:
        Object r24 = Result.constructor-impl(r0);     // Catch: Throwable -> L55
    L57:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L60;
        Log.e("VoiceInnerEndPlugin", "setSendWithQueueId failed", r25);
    L60:
        wnb.d r26 = r32.e;
        if (r26 == null) goto L64;
        Fragment r27 = r26.a;
        if (r27 == null) goto L64;
    L65:
        j.a(r32.n(), r27, "VoiceInnerEndPlugin", null, Long.valueOf(r3), null);
        r32.u("onExternalStop", new VoiceInnerEndPlugin$stopAndSendSession$1(r32, r2));
        return;
    L64:
        r27 = r32.a.a;
    L55:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    }

    public final void l(Fragment r4, ViewGroup r5) {
        if (r() == true) goto L5;
        return;
    L5:
        this.o = false;
        this.n = true;
        fya.a r2 = p();
        if (r2 == null) goto L8;
        r2.v5(true);
    L8:
        KeyboardUtils.hideKeyboard(this.a.a.requireContext());
        View r1 = this.f;
        if (r1 == null) goto L13;
        ImageView r3 = (ImageView) r1.findViewById(2131375952);
        if (r3 == null) goto L13;
        r3.setImageResource(2131235962);
    L13:
        v(r5, r4);
        k(0);
    }

    public final void m(Fragment r3, boolean r4) {
        this.o = false;
        if (this.n == false) goto L7;
        this.n = false;
        fya.a r1 = p();
        if (r1 == null) goto L7;
        r1.v5(false);
    L7:
        if (r3 != null) goto L24;
    L16:
        u("onExternalCancel", new VoiceInnerEndPlugin$onExternalCancel$1(this));
        k(8);
        View r5 = this.f;
        if (r5 == null) goto L21;
        ImageView r6 = (ImageView) r5.findViewById(2131375952);
        if (r6 == null) goto L21;
        r6.setImageResource(2131236052);
    L21:
        if (r4 == false) goto L26;
        KeyboardUtils.showKeyboard(n().L().c());
        return;
    L26:
        return;
    L24:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        fya.a r2 = p();     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        r2.w5(r3);     // Catch: Throwable -> L14
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r7);     // Catch: Throwable -> L14
        goto L16
    L11:
        r7 = null;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final void t(Fragment r2, EditText r3) {
        fya.a r0 = p();
        if (r0 == null) goto L5;
        r0.w5(r2);
    L5:
        k(8);
        Map<View, View.OnTouchListener> r4 = l.a;
        Intrinsics.checkNotNullParameter(r3, "view");
        r3.setOnTouchListener((View.OnTouchListener) ((LinkedHashMap) l.a).get(r3));
    }

    public final void u(String r4, Function0<Unit> r5) {
        if (this.m == false) goto L7;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial ignored: destroyed, task=".concat(r4));
        return;
    L7:
        if (this.l.isShutdown() == false) goto L17;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial ignored: executor shutdown, task=".concat(r4));
        return;
    L17:
        this.l.execute(new f(r5));     // Catch: Throwable -> L12 RejectedExecutionException -> L14
    L20:
        return;
    L14:
        e = move-exception;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial rejected, task=".concat(r4), e);
        return;
    L12:
        th = move-exception;
        Log.e("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial failed, task=".concat(r4), th);
    }

    public final void v(ViewGroup r8, Fragment r9) {
        if (r() == true) goto L5;
        return;
    L5:
        fya.a r1 = p();
        if (r1 == null) goto L9;
        r1.A5(r8, r9, o(), new g(this), new h(this, r9));
        return;
    }
}
