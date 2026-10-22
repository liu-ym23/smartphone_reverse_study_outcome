package vj8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import oi8.n;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final kc8.b a;
    public final Boolean b;

    public static final class a implements Function0<ChatPageContext> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(ChatPageContext.class));
        }
    }

    @Override // vj8.b
    public final void a(vj8.a r26) {
        Intrinsics.checkNotNullParameter(r26, "vmData");
        Message r2 = r26.d;
        if (r2 != null) goto L5;
        return;
    L5:
        LruCache<String, e> r1 = ko8.a.a;
        long r3 = ko8.a.e;
        Map<String, String> r4 = r26.h;
        ChatPageContext r24 = null;
        if (r4 == null) goto L8;
        String r16 = r4.get("deep_research_id");
    L9:
        int r5 = n.a;
        IAIChatControlTraceService.Companion r6 = IAIChatControlTraceService.a;
        n.a(r2, new ChatParam(null, null, r6.bb(r3), "chat", ko8.a.e(r3), 227), null, null, null, "start", r6.getBotId(r3), null, null, null, null, null, null, null, r16, null, null, null, null, null, null, 4161436);
        if (Intrinsics.areEqual(r26.f, "send_user_message") == false) goto L31;
        u1 r7 = zh8.a.a.getSender();
        String r8 = r26.g;
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        String r9 = r26.e;
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        String r10 = UUID.randomUUID().toString();
        Map<String, String> r0 = r26.h;
        if (r0 != null) goto L20;
        r0 = MapsKt.emptyMap();
    L20:
        Map<String, String> r11 = r0;
        kc8.b r12 = this.a;
        if (r12 == null) goto L29;
        y r13 = r12.a;
        if (r13 == null) goto L29;
        AttachReceiver r14 = r13.v;
        if (r14 == null) goto L29;
        Lazy r15 = LazyKt.lazy(new a(r14));
        if (r15 == null) goto L29;
        r24 = (ChatPageContext) r15.getValue();
    L29:
        u1.a.f(r7, r8, r9, "start_card", r11, null, null, r10, false, null, "CommonBlockButton", null, r24, null, false, 26984);
        return;
    L31:
        return;
    L8:
        r16 = null;
        goto L9
    }

    @Override // vj8.b
    public final boolean b(vj8.a r7) {
        Intrinsics.checkNotNullParameter(r7, "vmData");
        Message r8 = r7.d;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (com.larus.im.bean.message.a.w0(r8) == true) goto L38;
        kc8.b r1 = this.a;
        String r2 = null;
        if (r1 == null) goto L12;
        y r3 = r1.a;
        if (r3 == null) goto L12;
        q0 r4 = r3.x;
    L14:
        if (r4 == null) goto L30;
        List r5 = r4.D7();
        if (r5 == null) goto L30;
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        Object r9 = r6.next();
        if ((!com.larus.bmhome.chat.bean.d.O0(((wq8.a) r9).getMessage())) == false) goto L19;
    L24:
        wq8.a r10 = (wq8.a) r9;
        if (r10 == null) goto L30;
        Message r11 = r10.getMessage();
        if (r11 == null) goto L30;
        r2 = r11.getMessageId();
        goto L30
    L23:
        r9 = null;
    L30:
        if (Intrinsics.areEqual(r2, r8.getMessageId()) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.b, Boolean.TRUE) == true) goto L40;
        return true;
    L40:
        return false;
    L12:
        r4 = null;
        goto L14
    L38:
        return false;
    }

    @Override // vj8.b
    public final void c(vj8.a r23) {
        Intrinsics.checkNotNullParameter(r23, "vmData");
        Message r2 = r23.d;
        if (r2 != null) goto L5;
        return;
    L5:
        LruCache<String, e> r1 = ko8.a.a;
        long r3 = ko8.a.e;
        IAIChatControlTraceService.Companion r4 = IAIChatControlTraceService.a;
        String r5 = r4.getBotId(r3);
        if ((!StringsKt.isBlank(r5)) == true) goto L9;
        r5 = null;
    L9:
        if (r5 != null) goto L13;
        r5 = r2.getSenderId();
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        String r8 = r5;
        Map<String, String> r0 = r23.h;
        if (r0 == null) goto L16;
        String r11 = r0.get("deep_research_id");
    L17:
        int r6 = n.a;
        n.b(r2, new ChatParam(null, null, r4.bb(r3), "chat", ko8.a.e(r3), 227), null, null, null, "start", r8, null, null, r11, null, null, null, null, null, null, null, 261020);
        return;
    L16:
        r11 = null;
        goto L17
    }

    public c(kc8.b r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
