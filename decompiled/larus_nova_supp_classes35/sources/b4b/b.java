package b4b;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.MessageReactionHandlerImpl;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import z5c.o2;
import z5c.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements b4b.a {
    public final t6b.a a;
    public final Function0<Unit> b;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b c;
    public LKUIDialog d;

    public static final class a {
    }

    /* JADX INFO: renamed from: b4b.b$b, reason: collision with other inner class name */
    public static final class C0009b<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ i7b.a b;

        public C0009b(b r1, i7b.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L7;
            UICallbackExecutor.executeDelayed(new b4b.e(this.a, this.b), 500);
            Log.i(TitlebarViewModel.LOG_TAG, "Need relocate message after first load!");
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ s2b.d b;

        public c(b r1, s2b.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Chat r4 = (Chat) r3;
            if (r4 == null) goto L8;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = b.l(this.a);
            if (r0 == null) goto L7;
            r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c(r4));
        L7:
            this.b.d = r4;
            return;
        L8:
            Log.e("MessageListContextFeature", "currentChat observe chat == null");
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ThreadTopic r4 = (ThreadTopic) r3;
            if (r4 == null) goto L8;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = b.l(this.a);
            if (r0 == null) goto L9;
            r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d0(r4));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ s2b.d a;

        public e(s2b.d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ChatChatter r4 = (ChatChatter) r3;
            s2b.d r0 = this.a;
            if (r4 == null) goto L5;
            r0.b.getClass();
            r0.e = u2b.d.a(r4);
            return;
        L5:
            r0.getClass();
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ s2b.d b;

        public f(b r1, s2b.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            ChatChatter r4 = (ChatChatter) r3;
            if (r4 == null) goto L7;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = b.l(this.a);
            if (r0 == null) goto L7;
            r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.b0(r4));
        L7:
            s2b.d r1 = this.b;
            if (r4 == null) goto L10;
            r1.b.getClass();
            r1.f = u2b.d.a(r4);
            return;
        L10:
            r1.getClass();
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ b a;

        public g(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r0 = null;
        L5:
            LKUIToast.show(r0.getContext(), r3);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ b a;

        public h(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r0 = null;
        L5:
            h7b.i.b(r0.getContext(), (String) r4.getFirst(), (String) r4.getSecond());
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ b a;

        public i(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            String r7 = (String) r6;
            if (r7 == null) goto L22;
            b r0 = this.a;
            r0.getClass();
            if (TextUtils.isEmpty(r7) == false) goto L8;
            r0.b.invoke();
            return;
        L8:
            LKUIDialog r1 = r0.d;
            if (r1 != null) goto L11;
        L13:
            boolean r2 = false;
        L14:
            if (r2 == true) goto L23;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = r0.c;
            if (r4 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r4 = null;
        L19:
            com.larksuite.component.ui.dialog.d r3 = new com.larksuite.component.ui.dialog.d(r4.getContext());
            r3.k(r7);
            r3.c.titleBold(true);
            r3.c.titleLineCount(3);
            r3.a(2131378551, 2131891628, new b4b.c(r0));
            r3.c.cancelable(false);
            LKUIDialog r8 = r3.i();
            r0.d = r8;
            r8.setOnKeyListener(new b4b.d(r0));
            return;
        L23:
            return;
        L11:
            if (r1.isShowing() != true) goto L13;
            r2 = true;
            goto L14
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ b a;

        public j(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = b.l(this.a);
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r4);
            r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.n(r4));
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ b a;

        public k(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = b.l(this.a);
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r4);
            r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.m(r4));
            return;
        }
    }

    static {
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onDestroy() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        s2b.d r1 = r0.a();
        if (r1 == null) goto L51;
        z2b.b r3 = r1.k;
        if (r3 == null) goto L52;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.f r4 = TextLayoutRenderExtKt.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof w2b.b) == false) goto L20;
        w2b.b r5 = (w2b.b) r3;
        z2b.a r6 = r5.a;
        if ((r6 instanceof com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h) == false) goto L15;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r7 = r5.b.c();
    L21:
        if (r7 == null) goto L56;
        StringBuilder r8 = new StringBuilder("logTextLayoutCacheInfo: ");
        String r9 = "CacheInfo(msgCount: " + r7.a + ", ";
        StringBuilder r10 = new StringBuilder();
        r10.append(r9);
        if (r7.b <= 0) goto L26;
        String r11 = "parseHitRate: " + ((r7.c * 100.0f) / r7.b) + "%, ";
    L27:
        r10.append(r11);
        String r12 = r10.toString();
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        if (r7.d <= 0) goto L30;
        String r14 = "renderHitRate: " + ((r7.e * 100.0f) / r7.d) + '%';
    L31:
        r13.append(r14);
        r8.append(r13.toString() + " )");
        Log.i("MessageListContextFeature", r8.toString());
        int r15 = r7.d;
        if (r15 == 0) goto L53;
        int r16 = r7.b;
        if (r16 == 0) goto L57;
        float r17 = r7.c / r16;
        float r18 = r7.e / r15;
        Statistics.sendEvent("im_msg_text_layout_view", s5c.d.b.b(o2.c.a(String.valueOf(r17)), v2.c.a(String.valueOf(r18))).toJson());
        if (r17 >= 0.5f) goto L39;
    L40:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r19 = this.c;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r19 = null;
    L44:
        if (DevEnvUtil.isDebugMode(r19.getContext()) == false) goto L55;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r20 = this.c;
        if (r20 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L49:
        UDToast.show(r2.getContext(), "message text layout cache rate is lower than 0.5f !!! , please check the logs of \"TextLayoutCacheStoreImpl\"");
        return;
    L48:
        r2 = r20;
        goto L49
    L55:
        return;
    L39:
        if (r18 < 0.5f) goto L40;
        return;
    L57:
        return;
    L53:
        return;
    L30:
        r14 = "no render request.";
        goto L31
    L26:
        r11 = "no parse request";
        goto L27
    L56:
        return;
    L15:
        if ((r6 instanceof TextLayoutCacheStoreImpl2) == false) goto L18;
        r7 = r5.c.c();
        goto L21
    L18:
        if ((r6 instanceof w2b.a) == false) goto L20;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r21 = r5.b.c();
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r22 = r5.c.c();
        r7 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d(r22.a + r21.a, r22.b + r21.b, r22.c + r21.c, r22.d + r21.d, r21.e + r22.e);
    L20:
        r7 = null;
        goto L21
    L52:
        return;
    }

    public static final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a l(b r1) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = r1.c;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r2 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r2.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r9) {
        Intrinsics.checkNotNullParameter(r9, "initData");
        Intrinsics.checkNotNullParameter(r9, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
        if (r1 == null) goto L53;
        IMessageListViewModel r3 = r1.f();
        if (r3 == null) goto L53;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = this.c;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r4 = null;
    L13:
        s2b.d r5 = r4.a();
        if ((r5 instanceof s2b.d) == true) goto L17;
        r5 = null;
    L17:
        if (r5 != null) goto L20;
        Log.e("MessageListContextFeature", "chatContext is null");
        return;
    L20:
        mya.i r6 = new mya.i();
        MessageReactionHandlerImpl r7 = new MessageReactionHandlerImpl(r5);
        Intrinsics.checkNotNullParameter(r3, "streamProvider");
        r7.b = r3;
        r6.a(mya.d.class, r7);
        r5.g(r6);
        MutableLiveData<Chat> r8 = r3.getCurrentChat();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r10 = this.c;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r10 = null;
    L23:
        r8.observe(r10.getLifecycleOwner(), new c(this, r5));
        MutableLiveData<ThreadTopic> r11 = r3.getCurrentThreadTopic();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r12 = this.c;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r12 = null;
    L26:
        r11.observe(r12.getLifecycleOwner(), new d(this));
        MutableLiveData<ChatChatter> r13 = r3.getSelfChatterLiveData();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r14 = this.c;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r14 = null;
    L29:
        r13.observe(r14.getLifecycleOwner(), new e(r5));
        MutableLiveData<ChatChatter> r15 = r3.getP2pChatterLiveData();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r16 = this.c;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r16 = null;
    L32:
        r15.observe(r16.getLifecycleOwner(), new f(this, r5));
        MutableLiveData<String> r17 = r3.getToastInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r18 = this.c;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r18 = null;
    L35:
        r17.observe(r18.getLifecycleOwner(), new g(this));
        MutableLiveData<Pair<String, String>> r19 = r3.getDialogInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r20 = this.c;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r20 = null;
    L38:
        r19.observe(r20.getLifecycleOwner(), new h(this));
        MutableLiveData<String> r21 = r3.getClosePageInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r22 = this.c;
        if (r22 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r22 = null;
    L41:
        r21.observe(r22.getLifecycleOwner(), new i(this));
        MutableLiveData<List<MessageInfo>> r23 = r3.getNewMessageItems();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r24 = this.c;
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r24 = null;
    L44:
        r23.observe(r24.getLifecycleOwner(), new j(this));
        MutableLiveData<List<MessageInfo>> r25 = r3.getNewMessageItemsAppend();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r26 = this.c;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r26 = null;
    L47:
        r25.observe(r26.getLifecycleOwner(), new k(this));
        MutableLiveData<Boolean> r27 = r3.getNeedRelocateMessage();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r28 = this.c;
        if (r28 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L51:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r27, r2.getLifecycleOwner(), new C0009b(this, r9));
        r3.loadFirstPage(r9.k);
        PerfLog.end("message_list_init_with_data", BuildConfig.FLAVOR);
        return;
    L50:
        r2 = r28;
    L53:
        Log.e("MessageListContextFeature", "dataFeature is null");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.c = r2;
    }

    public b(t6b.a r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        Intrinsics.checkNotNullParameter(r3, "exitChat");
        this.a = r2;
        this.b = r3;
    }
}
