package ib8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements IIMCallback<Message> {
    public final /* synthetic */ WeakReference<com.larus.bmhome.block.newheader.foldcontainer.a> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        com.larus.bmhome.block.newheader.foldcontainer.a r0 = this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.h == this.b) goto L8;
        return;
    L8:
        r0.i = false;
        r0.j = null;
        g r1 = r0.b;
        if (r1 == null) goto L11;
        r1.g(null);
    L11:
        FLogger.a.w("FoldContainerViewModel", "loadFullMessage failed, code=" + r5.getCode());
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L20;
        r6.P();
        Fragment r7 = ChatServiceImpl.a.f();
        if (r7 == null) goto L21;
        Context r8 = r7.getContext();
        if (r8 == null) goto L22;
        t19.s.a.g(r8, 2131908080, false);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void onSuccess(Object r7) {
        Message r8 = (Message) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        com.larus.bmhome.block.newheader.foldcontainer.a r0 = this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.h != this.b) goto L93;
        Message r1 = r0.g;
        String r2 = null;
        if (r1 == null) goto L10;
        String r3 = r1.getMessageId();
    L12:
        if (Intrinsics.areEqual(r3, this.c) == false) goto L94;
        Message r4 = r0.g;
        if (r4 == null) goto L16;
        String r5 = r4.getConversationId();
    L18:
        if (Intrinsics.areEqual(r5, this.d) == false) goto L100;
        boolean r6 = false;
        r0.i = false;
        g r9 = r0.b;
        if (r9 == null) goto L24;
        r9.g(null);
    L24:
        if (Intrinsics.areEqual(r8.getMessageId(), this.c) == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r8.getConversationId(), this.d) == true) goto L28;
        return;
    L28:
        if (com.larus.bmhome.chat.bean.d.i0(r8) == false) goto L33;
        if (com.larus.bmhome.chat.bean.d.w(r8) == true) goto L33;
    L52:
        boolean r10 = false;
    L53:
        if (r10 == false) goto L97;
        Message r11 = r0.g;
        if (r11 != null) goto L57;
    L84:
        if (r6 == false) goto L98;
        Set r12 = SetsKt.setOf(new String[]{"1", "true"});
        Map r13 = r8.getExt();
        if (r13 == null) goto L89;
        r2 = (String) r13.get("need_lazy_load");
    L89:
        if (CollectionsKt.contains(r12, r2) == true) goto L101;
        r0.j = this.e;
        r0.b();
        return;
    L101:
        return;
    L98:
        return;
    L57:
        if (com.larus.bmhome.chat.bean.d.i0(r11) == false) goto L62;
        if (com.larus.bmhome.chat.bean.d.w(r11) == true) goto L62;
    L81:
        boolean r14 = false;
    L82:
        if (r14 != true) goto L84;
        r6 = true;
    L62:
        if (com.larus.bmhome.chat.bean.d.T(r11) == true) goto L81;
        if (com.larus.bmhome.chat.bean.d.p0(r11) == true) goto L81;
        if (com.larus.bmhome.chat.bean.d.C0(r11) == true) goto L69;
    L71:
        MessageStatus r15 = r11.getMessageStatus();
        if (r15 != null) goto L74;
    L76:
        boolean r16 = false;
    L77:
        if (r16 == false) goto L79;
    L80:
        r14 = true;
        goto L82
    L79:
        if (com.larus.bmhome.social.userchat.model.b0.f(r11) == false) goto L81;
    L74:
        if (r15.isVisible() != true) goto L76;
        r16 = true;
        goto L77
    L69:
        if (r11.getRegenVisible() == true) goto L71;
    L97:
        return;
    L33:
        if (com.larus.bmhome.chat.bean.d.T(r8) == true) goto L52;
        if (com.larus.bmhome.chat.bean.d.p0(r8) == true) goto L52;
        if (com.larus.bmhome.chat.bean.d.C0(r8) == true) goto L40;
    L42:
        MessageStatus r17 = r8.getMessageStatus();
        if (r17 != null) goto L45;
    L47:
        boolean r18 = false;
    L48:
        if (r18 == false) goto L50;
    L51:
        r10 = true;
        goto L53
    L50:
        if (com.larus.bmhome.social.userchat.model.b0.f(r8) == false) goto L52;
    L45:
        if (r17.isVisible() != true) goto L47;
        r18 = true;
        goto L48
    L40:
        if (r8.getRegenVisible() == true) goto L42;
    L100:
        return;
    L16:
        r5 = null;
        goto L18
    L94:
        return;
    L10:
        r3 = null;
        goto L12
    }

    public b0(WeakReference<com.larus.bmhome.block.newheader.foldcontainer.a> r1, int r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
