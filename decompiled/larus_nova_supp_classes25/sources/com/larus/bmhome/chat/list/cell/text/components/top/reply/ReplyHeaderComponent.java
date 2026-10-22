package com.larus.bmhome.chat.list.cell.text.components.top.reply;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.manager.l0;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.bmhome.view.ChatReplyHeaderView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.utils.logger.FLogger;
import dg8.t;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ReplyHeaderComponent extends bd8.b {
    public static final /* synthetic */ int o = 0;
    public ChatReplyHeaderView l;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        ChatReplyHeaderView r0 = this.l;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public ReplyHeaderComponent(int r2) {
        super(true, r2);
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new d(this));
    }

    @Override // bd8.b
    public final boolean G(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.isNewBlockType() == true) goto L5;
        ReferenceInfo r0 = r5.getReferenceInfo();
    L9:
        if (r0 != null) goto L12;
        r0 = r5.getReferenceInfo();
    L12:
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L22;
        BotModel r1 = t.d((y) this.m.getValue());
        if (r1 != null) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L22;
        if (com.larus.bmhome.chat.bean.d.G0(r5) == false) goto L22;
        return false;
    L16:
        if (ce8.a.b(r1) != true) goto L18;
        r2 = true;
    L22:
        if (r0 == null) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.b1(r5) == null) goto L7;
        r0 = null;
        goto L9
    L7:
        r0 = r5.getReferenceInfo();
        goto L9
    }

    public final void J(Message r9, BotModel r10) {
        if (r10 != null) goto L5;
        r10 = t.d((y) this.m.getValue());
    L5:
        if (r10 != null) goto L10;
        FLogger.a.i("ReplyHeaderComponent", "[setupReferenceMessage] getCurrentChatBot is null");
        y r11 = (y) this.m.getValue();
        if (r11 == null) goto L52;
        r11.ll(new b(), new e(this, r9));
        return;
    L52:
        return;
    L10:
        int r1 = l0.a;
        if (l0.a(r10.getBotType()) == true) goto L17;
        if (ce8.a.b(r10) == true) goto L17;
        FLogger.a.i("ReplyHeaderComponent", "[setupReferenceMessage] disabled by config");
        return;
    L17:
        if (r9.isNewBlockType() == true) goto L19;
        ReferenceInfo r0 = r9.getReferenceInfo();
    L23:
        if (r0 != null) goto L28;
        ChatReplyHeaderView r12 = this.l;
        if (r12 == null) goto L53;
        r12.setVisibility(8);
        return;
    L53:
        return;
    L28:
        q0 r2 = this.e;
        if (r2 == null) goto L40;
        List r3 = r2.getCurrentList();
        if (r3 == null) goto L40;
        Iterator r4 = r3.iterator();
    L34:
        if (r4.hasNext() == false) goto L38;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Message) r5).getMessageId(), r0.referencedMessageId) == false) goto L34;
    L39:
        Message r6 = (Message) r5;
    L41:
        ReferenceMessage.Companion.getClass();
        K(ReferenceMessage.Companion.a(r0, r6, r10), com.larus.bmhome.chat.bean.d.G0(r9));
        if (r6 != null) goto L54;
        Fragment r13 = this.c;
        if (r13 == null) goto L55;
        LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(r13);
        if (r7 == null) goto L56;
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new ReplyHeaderComponent$setupReferenceMessage$1(r0, this, r9, null), 2, null);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L38:
        r5 = null;
    L40:
        r6 = null;
        goto L41
    L19:
        if (com.larus.bmhome.chat.bean.d.b1(r9) == null) goto L21;
        r0 = null;
        goto L23
    L21:
        r0 = r9.getReferenceInfo();
        goto L23
    }

    public final void K(ReferenceMessage r13, boolean r14) {
        String r0 = r13.getContent();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L31;
        String r2 = CollectionsKt.joinToString$default(StringsKt.lines(r0), " ", null, null, 0, null, null, 62, null);
        String r15 = r13.getRefExt();
        if (r15 != null) goto L13;
    L15:
        boolean r16 = false;
    L16:
        ChatReplyHeaderView r4 = this.l;
        if (r4 == null) goto L35;
        q0 r5 = this.e;
        Integer r6 = null;
        if (r5 == null) goto L21;
        Integer r7 = r5.I7();
    L22:
        if (r7 == null) goto L24;
        r1 = true;
    L24:
        Boolean r8 = Boolean.valueOf(r1);
        if (r16 == false) goto L30;
        if (r14 == false) goto L28;
        int r17 = 2131242740;
    L29:
        r6 = Integer.valueOf(r17);
        goto L30
    L28:
        r17 = 2131242739;
    L30:
        r4.a(r2, r8, r14, r6);
        return;
    L21:
        r7 = null;
        goto L22
    L35:
        return;
    L13:
        if (Intrinsics.areEqual(new JSONObject(r15).optString("ref_icon_key", ""), "task") != true) goto L15;
        r16 = true;
        goto L16
    L31:
        ChatReplyHeaderView r18 = this.l;
        if (r18 == null) goto L37;
        r18.setVisibility(8);
        return;
    L37:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // bd8.b
    public final void w(Message r1, int r2, ec8.b r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r1, "message");
        J(r1, null);
    }

    @Override // bd8.b
    public final List<View> x(int r3, Context r4, BaseMessageListCell<?> r5, i r6, q0 r7, Fragment r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.x(r3, r4, r5, r6, r7, r8);
        ChatReplyHeaderView r9 = new ChatReplyHeaderView(r4, null, 6, 0);
        r9.setVisibility(8);
        if (r6 == null) goto L5;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMargins(i5.q(), i5.h(), i5.q(), 0);
        Unit r11 = Unit.INSTANCE;
        r6.addView(r9, r3, r10);
    L5:
        this.l = r9;
        return CollectionsKt.listOf(r9);
    }
}
