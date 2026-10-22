package component;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import de8.c;
import ic8.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import s1a.d;
import va8.j0;
import va8.s;
import va8.s0;
import va8.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J8\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016Jl\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010\u00152\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010*\u001a\u00020\r2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,0&H\u0016J\u001c\u0010-\u001a\u00020\r2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,0&H\u0016J\u0018\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020!H\u0016J\n\u00101\u001a\u0004\u0018\u00010)H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u00063"}, d2 = {"Lcomponent/ChatRepoComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "Lcom/larus/bmhome/ability/IChatTTSRenderAbility;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "onAttach", "", "onCreate", "onDestroy", "retryNew", "message", "Lcom/larus/im/bean/message/Message;", "breakAnswer", "conversationId", "", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "sendMessage", "strategy", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "scene", "callback", "Lcom/larus/im/callback/IIMCallback;", "sendFuncChannel", "convertToSendMessageStrategy", "isResend", "", "isReedit", "reeditTextContent", "newLocalMessageId", "newExt", "", "newBizExt", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "addDisposableMessageExt", DBDefinition.EXTRA, "Lcom/larus/bmhome/ability/IMessageExtGenerator;", "addChatLifecycleMessageExt", "stopAndCancelAll", "stopReason", "isFromManual", "currentChatPageContext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRepoComponent extends ComponentFeature implements s, v {
    public static final ConcurrentHashMap<String, j0> i = null;
    public static final ConcurrentHashMap<String, j0> j = null;
    public final Lazy h;

    public static final class a {
        public static Map a(w r4) {
            Intrinsics.checkNotNullParameter(r4, "strategy");
            Map r0 = MapsKt.toMutableMap(ChatRepoComponent.j);
            ConcurrentHashMap<String, j0> r1 = ChatRepoComponent.i;
            Map r2 = MapsKt.plus(r0, MapsKt.toMutableMap(r1));
            r1.clear();
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator r5 = r2.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Map.Entry r6 = (Map.Entry) r5.next();
            String r7 = ((j0) r6.getValue()).a(r4);
            if (r7 == null) goto L4;
            r3.put(r6.getKey(), r7);
            goto L4
        L8:
            return r3;
        }
    }

    public static final class b implements Function0<c> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).g(Reflection.getOrCreateKotlinClass(c.class));
        }
    }

    static {
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
    }

    public final void onCreate() {
        c r0 = (c) this.h.getValue();
        if (r0 == null) goto L16;
        Bundle r1 = r0.b;
        if (r1 == null) goto L8;
        Bundle r2 = r1.getBundle("common_message_ext");
        if (r2 == null) goto L8;
    L9:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r4 = r2.keySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        String r5 = (String) r4.next();
        String r6 = r2.getString(r5);
        if (r6 == null) goto L11;
        Intrinsics.checkNotNull(r5);
        r3.put(r5, new s0(r6));
        goto L11
    L15:
        Wt(r3);
    L8:
        r2 = new Bundle();
    L16:
        c r7 = (c) this.h.getValue();
        if (r7 == null) goto L41;
        Bundle r8 = r7.b;
        if (r8 == null) goto L22;
        Bundle r9 = r8.getBundle("disposable_message_ext");
        if (r9 == null) goto L22;
    L23:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<T> r11 = r9.keySet().iterator();
    L25:
        if (r11.hasNext() == false) goto L29;
        String r12 = (String) r11.next();
        String r13 = r9.getString(r12);
        if (r13 == null) goto L25;
        Intrinsics.checkNotNull(r12);
        r10.put(r12, new s0(r13));
        goto L25
    L29:
        Intrinsics.checkNotNullParameter(r10, DBDefinition.EXTRA);
        i.putAll(r10);
        return;
    L22:
        r9 = new Bundle();
        goto L23
    }

    public final void onDestroy() {
        i.clear();
        j.clear();
    }

    public final void y2() {
        i.clear();
        j.clear();
    }

    public ChatRepoComponent() {
        this.h = LazyKt.lazy(new b(this));
    }

    public final void Wt(Map<String, ? extends j0> r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.EXTRA);
        j.putAll(r2);
    }

    public final void h40(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.e.J(r4, d.a(this).a(ChatPageContext.class));
    }

    public final void i6(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "stopReason");
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.d.d.i6("ChatRepoComponent ".concat(r3), r4);
    }

    public final void n1(String r2, OmniBreakReason r3) {
        Intrinsics.checkNotNullParameter("", "conversationId");
        Intrinsics.checkNotNullParameter(r3, "breakReason");
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.e.n1("", r3);
    }
}
