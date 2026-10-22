package zgb;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.model.d;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.chatbase.model.c;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadViewModel;
import java.util.List;
import jdb.g;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m6b.m;
import q3b.e;
import q3b.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements y0 {
    public final c<String, MessageInfo, x4b.a<MessageInfo>, d<MessageInfo>> a;
    public final v b;
    public final FlowChatThreadViewModel c;

    /* JADX INFO: renamed from: zgb.a$a, reason: collision with other inner class name */
    public static final class C0351a implements com.ss.android.lark.chatthread.model.loader.a.c {
        public C0351a() {
        }

        public final void a() {
        }

        public final void b() {
        }
    }

    public static final class b implements com.ss.android.lark.chatthread.model.loader.a.b<e> {
        public b() {
        }

        public final e a(List r8) {
            Intrinsics.checkNotNullParameter(r8, "messageList");
            return new e(r8, CollectionsKt.emptyList(), CollectionsKt.emptyList(), -1, MapsKt.emptyMap());
        }
    }

    public final void a(q<x4b.a<MessageInfo>, MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
    }

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean canLoadPre() {
        return false;
    }

    public final void e(q<x4b.a<MessageInfo>, MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
    }

    public final void c(IGetDataCallback<ChatMessageResponse> r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        BasePageStore r0 = this.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chatbase.BasePageStore<com.ss.android.lark.chat.entity.message.MessageInfo, com.ss.android.lark.chat.chatwindow.chat.model.ChatPageData>");
        BasePageStore r2 = r0;
        g r3 = this.b.C();
        m r4 = this.b.W();
        e7b.c r1 = (e7b.c) this.c.getChatThreadInitData().getValue();
        if (r1 == null) goto L6;
        String r5 = ((e7b.a) r1).b;
        if (r5 == null) goto L6;
    L7:
        String r6 = r5;
        Chat r7 = (Chat) this.c.getChat().getValue();
        if (r7 == null) goto L10;
        int r8 = r7.getFirstMessagePosition();
    L11:
        com.ss.android.lark.chatthread.model.loader.a r12 = new com.ss.android.lark.chatthread.model.loader.a(r2, r3, r4, r6, r8, new C0351a(), new b());
        r12.c.d2(r12.d, false, r12.h);
        return;
    L10:
        r8 = 0;
    L6:
        r5 = "";
        goto L7
    }

    public final void d(List<Integer> r2, IGetDataCallback<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "missingPositions");
        Intrinsics.checkNotNullParameter(r3, "callback");
        y0.a.a(r2, r3);
    }

    public final void b(int r1, boolean r2, q<x4b.a<MessageInfo>, MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "receiver");
        Intrinsics.checkNotNullParameter(r3, "receiver");
    }

    public a(BasePageStore r2, v r3, FlowChatThreadViewModel r4, x4b.d r5, x4b.d r6, CallbackManager r7, String r8, MutableLiveData r9) {
        Intrinsics.checkNotNullParameter(r2, "pageStore");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r4, "chatThreadViewModel");
        Intrinsics.checkNotNullParameter(r5, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r6, "workExecutor");
        Intrinsics.checkNotNullParameter(r7, "callbackManager");
        Intrinsics.checkNotNullParameter(r8, "chatId");
        Intrinsics.checkNotNullParameter(r9, "currentChatLiveData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
