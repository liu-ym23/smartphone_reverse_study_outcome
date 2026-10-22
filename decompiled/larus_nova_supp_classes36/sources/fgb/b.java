package fgb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.d;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.e;
import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.c;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import lgb.f;
import yya.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements c {
    public static final b a = null;

    public static final class a implements com.ss.android.lark.chat.core.api.b {
        public a() {
        }

        public final void a(MessageInfo r2, MessageContentResolver r3) {
            Intrinsics.checkNotNullParameter(r2, "messageInfo");
            Intrinsics.checkNotNullParameter(r3, "contentResolver");
        }
    }

    /* JADX INFO: renamed from: fgb.b$b, reason: collision with other inner class name */
    public static final class C0260b implements e {
        public static final C0260b a = null;

        static {
            a = new C0260b();
        }

        public C0260b() {
        }

        public final List<d> a(FragmentActivity r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3) {
            Intrinsics.checkNotNullParameter(r2, "<unused var>");
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            return CollectionsKt.emptyList();
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    public final Collection<l> c() {
        Map<ImExtensionType, List<Class<?>>> r0 = com.ss.android.lark.im.base.d.a;
        return com.ss.android.lark.im.base.d.c(ImExtensionType.MESSAGE_ACTION_INTERCEPTOR, l.class);
    }

    public final Collection<yya.b> e() {
        Map<ImExtensionType, List<Class<?>>> r0 = com.ss.android.lark.im.base.d.a;
        return com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_ACTION_PROVIDER, yya.b.class);
    }

    public final com.ss.android.lark.chat.core.api.b g() {
        return new a();
    }

    public final Collection<com.ss.android.lark.chat.chatwindow.chat.perload.d<? extends u3b.a, ?>> h() {
        return CollectionsKt.listOf(new com.ss.android.lark.chat.chatwindow.chat.perload.d(f6b.b.class, new f6b.c(), new f6b.a()));
    }

    public final e a(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initChat");
        return C0260b.a;
    }

    public final com.ss.android.lark.chat.core.api.e i(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        return new fgb.a();
    }

    public final Object f(String r1, int r2, Continuation<? super Result<? extends ChatMessageResponse>> r3) {
        Result.Companion r4 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Exception("not implemented")));
    }

    public final Object b(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r1, String r2, int r3, Continuation<? super Result<? extends ChatMessageResponse>> r4) {
        Result.Companion r5 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Exception("not implemented")));
    }

    public final x4b.c d(v r4, m2b.a r5, boolean r6, boolean r7, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r8) {
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        List r9 = CollectionsKt.listOf(new y6b.d[]{new com.ss.android.lark.flow.chat.message.profile.a(), new jgb.a(), new jgb.b(), new lgb.b(), new lgb.c(), new f(), new lgb.d(), new com.ss.android.lark.flow.chat.message.redpacket.d(Message.Type.RED_PACKET), new com.ss.android.lark.flow.chat.message.redpacket.d(Message.Type.COMMERCIALIZED_HONGBAO), new lgb.e()});
        if (r5 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L22;
        ThreadTopic r11 = r5.N1();
        String r2 = "";
        if (r11 == null) goto L13;
        String r12 = r11.getId();
        if (r12 == null) goto L13;
    L14:
        ThreadTopic r13 = r5.N1();
        if (r13 == null) goto L21;
        String r14 = r13.getAnonymousId();
        if (r14 == null) goto L21;
        r2 = r14;
    L21:
        return new x2c.a(r4, r12, r2, new u2b.c(r4, false, true, r9));
    L13:
        r12 = "";
        goto L14
    L22:
        if (r5 != null) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L31;
        return new mhb.a(r4, new u2b.c(r4, false, true, r9));
    L31:
        return new u2b.c(r4, true, r7, r9);
    L24:
        if (r5.e0() != true) goto L26;
        r15 = true;
        goto L27
    L5:
        if (r5.Y() != true) goto L7;
        r10 = true;
        goto L8
    }
}
