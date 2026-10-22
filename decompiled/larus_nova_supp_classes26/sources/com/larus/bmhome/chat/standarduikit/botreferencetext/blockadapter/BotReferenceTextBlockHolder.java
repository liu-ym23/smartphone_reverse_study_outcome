package com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.manager.l0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.standarduikit.botreferencetext.view.BotReferenceTextView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ReferenceBlock;
import com.larus.im.bean.message.block.ReferenceText;
import com.larus.mainbot.impl.databinding.LarusLayoutBotReplyHeaderBinding;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import jc8.d;
import jc8.e;
import kc8.i;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotReferenceTextBlockHolder extends jc8.b<a> {
    public kc8.b d;
    public zi8.c e;
    public final Lazy f;

    public final String c() {
        return "BotReferenceTextBlockHolder";
    }

    public BotReferenceTextBlockHolder() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r4) {
        final a r5 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        kc8.b r0 = jc8.c.a(this, kc8.b.class);
        this.d = r0;
        BotModel r1 = null;
        if (r0 == null) goto L5;
        i r2 = r0.r;
    L6:
        if (r0 == null) goto L12;
        y r3 = r0.a;
        if (r3 == null) goto L12;
        Function0 r6 = r3.l;
        if (r6 == null) goto L12;
        r1 = (BotModel) r6.invoke();
    L12:
        if (r1 != null) goto L17;
        if (r2 == null) goto L19;
        Function1 r7 = r2.a;
        if (r7 == null) goto L20;
        r7.invoke(new c(this, r5));
        return;
    L20:
        return;
    L19:
        return;
    L17:
        k(r5, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        zi8.c r0 = new zi8.c(r2.getContext());
        this.e = r0;
        return (BotReferenceTextView) r0.a.getValue();
    }

    public final void k(a r13, BotModel r14) {
        BlockContent r0 = ((jc8.a) r13).a.getContent();
        Message r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        if (r0 == null) goto L9;
        ReferenceBlock r3 = r0.getReferenceBlock();
        if (r3 == null) goto L9;
        ReferenceText r4 = r3.getText();
        if (r4 == null) goto L9;
        String r5 = r4.getMessageId();
    L10:
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        kc8.b r7 = this.d;
        if (r7 == null) goto L25;
        y r8 = r7.a;
        if (r8 == null) goto L25;
        q0 r9 = r8.x;
        if (r9 == null) goto L25;
        List<Message> r10 = r9.getCurrentList();
        if (r10 == null) goto L25;
        Iterator<T> r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((Message) r12).getMessageId(), r5) == false) goto L20;
        r2 = r12;
    L24:
        r1 = (Message) r2;
    L25:
        r6.element = r1;
        l(r13, r14, r1);
        if (r6.element != null) goto L40;
        kc8.b r15 = this.d;
        if (r15 == null) goto L41;
        y r16 = r15.a;
        if (r16 == null) goto L42;
        Fragment r17 = r16.a;
        if (r17 == null) goto L43;
        LifecycleCoroutineScope r18 = LifecycleOwnerKt.getLifecycleScope(r17);
        if (r18 == null) goto L44;
        BuildersKt.launch$default(r18, Dispatchers.getIO(), null, new BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1(r6, this, r5, r13, r14, null), 2, null);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L9:
        r5 = null;
        goto L10
    }

    public static final Object j(BotReferenceTextBlockHolder r4, String r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof BotReferenceTextBlockHolder$getRepoMessage$1) == false) goto L7;
        BotReferenceTextBlockHolder$getRepoMessage$1 r0 = (BotReferenceTextBlockHolder$getRepoMessage$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L25
    L21:
        return (Message) r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        if (r5 == null) goto L24;
        IChatRepoService r9 = zh8.a.a;     // Catch: Exception -> L25
        r0.label = 1;     // Catch: Exception -> L25
        r7 = r9.E1(r5, r0);     // Catch: Exception -> L25
        if (r7 != r8) goto L21;
        return r8;
    L24:
        return null;
    L7:
        r0 = new BotReferenceTextBlockHolder$getRepoMessage$1(r4, r6);
        goto L8
    }

    public final void l(a r12, BotModel r13, Message r14) {
        int r0 = l0.a;
        if (l0.a(r13.getBotType()) == false) goto L5;
    L7:
        BlockContent r15 = ((jc8.a) r12).a.getContent();
        String r1 = null;
        if (r15 == null) goto L10;
        ReferenceBlock r16 = r15.getReferenceBlock();
    L11:
        bj8.a r2 = new bj8.a(r16, r13, r14);
        zi8.c r17 = this.e;
        if (r17 == null) goto L84;
        bj8.b r18 = (bj8.b) this.f.getValue();
        Intrinsics.checkNotNullParameter(r2, "vmData");
        bj8.d r3 = (bj8.d) r17.b.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "vmData");
        r3.a = r2;
        r3.b = r18;
        bj8.d r19 = (bj8.d) r17.b.getValue();
        bj8.a r110 = r19.a;
        if (r110 == null) goto L16;
        ReferenceBlock r4 = r110.a;
    L17:
        if (r110 == null) goto L19;
        Message r111 = r110.c;
    L21:
        if (com.larus.bmhome.chat.bean.d.U(r111) == false) goto L29;
        if (r4 == null) goto L26;
        ReferenceText r112 = r4.getText();
        if (r112 == null) goto L26;
        String r113 = r112.getText();
    L27:
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        String r114 = CollectionsKt.joinToString$default(StringsKt.lines(r113), " ", null, null, 0, null, null, 62, null);
        int r5 = 0;
        if (r114.length() <= 0) goto L33;
        boolean r6 = true;
    L34:
        bj8.b r115 = r19.b;
        if (r115 == null) goto L37;
        boolean r116 = r115.p();
    L38:
        if (r4 == null) goto L43;
        ReferenceText r7 = r4.getText();
        if (r7 == null) goto L43;
        r1 = r7.getIconKey();
    L43:
        if (Intrinsics.areEqual(r1, "task") == false) goto L45;
        r5 = 2131242739;
    L45:
        aj8.a r8 = new aj8.a(r6, r114, r116, r5);
        ((bj8.d) r17.b.getValue()).getClass();
        aj8.b r117 = new aj8.b();
        BotReferenceTextView r118 = (BotReferenceTextView) r17.a.getValue();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r117, "output");
        if (r8.a == false) goto L82;
        LarusLayoutBotReplyHeaderBinding r119 = r118.a;
        if (r119 == null) goto L53;
        TextView r120 = r119.c;
        if (r120 == null) goto L53;
        r120.setText(r8.b);
    L53:
        if (r8.c == false) goto L64;
        LarusLayoutBotReplyHeaderBinding r121 = r118.a;
        if (r121 == null) goto L59;
        TextView r122 = r121.c;
        if (r122 == null) goto L59;
        r122.setTextColor(ve8.d.a(2131106540, AppHost.a.getApplication()));
    L59:
        LarusLayoutBotReplyHeaderBinding r123 = r118.a;
        if (r123 == null) goto L74;
        ImageView r124 = r123.b;
        if (r124 == null) goto L74;
        r124.setImageResource(2131241863);
    L74:
        int r125 = r8.d;
        if (r125 == 0) goto L81;
        LarusLayoutBotReplyHeaderBinding r126 = r118.a;
        if (r126 == null) goto L81;
        ImageView r127 = r126.b;
        if (r127 == null) goto L81;
        r127.setImageResource(r125);
    L81:
        e1.x(r118);
        return;
    L64:
        LarusLayoutBotReplyHeaderBinding r128 = r118.a;
        if (r128 == null) goto L69;
        TextView r129 = r128.c;
        if (r129 == null) goto L69;
        r129.setTextColor(v19.c.a(2130972082, r118.getContext(), 2131103146));
    L69:
        LarusLayoutBotReplyHeaderBinding r130 = r118.a;
        if (r130 == null) goto L74;
        ImageView r131 = r130.b;
        if (r131 == null) goto L74;
        r131.setImageResource(2131241865);
        goto L74
    L82:
        e1.o(r118);
        return;
    L37:
        r116 = false;
        goto L38
    L33:
        r6 = false;
    L26:
        r113 = null;
        goto L27
    L29:
        r113 = AppHost.a.getApplication().getString(2131908670);
        goto L30
    L19:
        r111 = null;
        goto L21
    L16:
        r4 = null;
        goto L17
    L84:
        return;
    L10:
        r16 = null;
        goto L11
    L5:
        if (ce8.a.b(r13) == true) goto L7;
    }
}
