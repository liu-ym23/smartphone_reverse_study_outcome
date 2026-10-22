package com.larus.bmhome.double_post.drag_panel;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ce8.c;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.double_post.fragment.u;
import com.larus.bmhome.instruction.g;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 implements ChatAwemeNestedContainer$b {
    public final /* synthetic */ ChatAwemeFeedComponent a;
    public final /* synthetic */ LarusPageChatBinding b;

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void b() {
        ChatAwemeFeedComponent r0 = this.a;
        if (r0.q.isAdded() == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L37;
        AwemeDoublePostFragment r2 = this.a.q;
        LarusFragmentAwemeDoublePostBinding r3 = r2.e;
        Integer r4 = null;
        if (r3 == null) goto L16;
        RecyclerView r5 = r3.b;
        if (r5 == null) goto L16;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();
    L18:
        if ((r6 instanceof StaggeredGridLayoutManager) == false) goto L20;
        StaggeredGridLayoutManager r7 = (StaggeredGridLayoutManager) r6;
    L21:
        if (r7 == null) goto L39;
        int[] r8 = r7.findLastVisibleItemPositions(null);
        Intrinsics.checkNotNull(r8);
        int r9 = r8.length;
        int r10 = 0;
    L24:
        if (r10 >= r9) goto L32;
        int r11 = r8[r10];
        if (r11 < (r7.getItemCount() - r2.h.a)) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == true) goto L30;
        r10 = r10 + 1;
        goto L24
    L30:
        r4 = Integer.valueOf(r11);
        goto L32
    L28:
        r12 = false;
    L32:
        if (r4 == null) goto L38;
        r4.intValue();
        r2.h.b.invoke();
        return;
    L38:
        return;
    L39:
        return;
    L20:
        r7 = null;
    L16:
        r6 = null;
        goto L18
    L37:
        return;
    L5:
        if (r0.q.isDetached() == true) goto L9;
        if (r0.q.isRemoving() == true) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final boolean c() {
        ChatAwemeFeedComponent r0 = this.a;
        if (r0.I == null) goto L28;
        Integer[] r1 = {21, 22, 23, 11, 12, 13};
        Message r3 = ChatAwemeFeedComponent.D3(r0.B3());
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getMessageStatusLocal());
    L9:
        if (ArraysKt.contains(r1, r4) == false) goto L29;
        IChatMessageShareAbility r2 = (IChatMessageShareAbility) r0.v.getValue();
        if (r2 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        return false;
    L18:
        if (c.a() == true) goto L31;
        g1 r6 = (g1) r0.x.getValue();
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == true) goto L32;
        return true;
    L32:
        return false;
    L22:
        if (r6.isVisible() != true) goto L24;
        r7 = true;
        goto L25
    L31:
        return false;
    L13:
        if (r2.H1() != true) goto L15;
        r5 = true;
        goto L16
    L29:
        return false;
    L7:
        r4 = null;
        goto L9
    L28:
        return false;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void a(boolean r7) {
        this.a.G = r7;
        IAIChatControlTraceService.a.bc(r7);
        boolean r0 = true;
        if (r7 == false) goto L41;
        AwemeDoublePostFragment r8 = this.a.q;
        int r1 = AwemeDoublePostFragment.A;
        r8.getClass();
        Intrinsics.checkNotNullParameter("slide", "enterMethod");
        LarusFragmentAwemeDoublePostBinding r2 = r8.e;
        if (r2 == null) goto L14;
        TextView r3 = r2.c;
        if (r3 == null) goto L14;
        if (r3.getVisibility() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 != true) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L47;
        u r6 = r8.w;
        if (r6 == null) goto L20;
        r6.w();
    L20:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        Message r11 = r8.t;
        if (r11 != null) goto L23;
    L25:
        r0 = false;
    L26:
        if (r0 == false) goto L28;
        String r12 = "wcb_feed";
    L29:
        r10.put("current_page", r12);
        r10.put("previous_page", "chat");
        Message r13 = r8.t;
        String r14 = null;
        if (r13 == null) goto L36;
        String r15 = r13.getMessageId();
        if (r15 == null) goto L36;
        Long r16 = StringsKt.toLongOrNull(r15);
        if (r16 == null) goto L36;
        String r17 = r16.toString();
    L37:
        r10.put(MusicAppletPage.KEY_MESSAGE_ID, r17);
        Message r18 = r8.t;
        if (r18 == null) goto L40;
        r14 = r18.getReplyId();
    L40:
        r10.put("reply_id", r14);
        r10.put("enter_method", "slide");
        Unit r19 = Unit.INSTANCE;
        r9.reportEvent("enter_page", r10);
        return;
    L36:
        r17 = null;
        goto L37
    L28:
        r12 = "chat_feed";
        goto L29
    L23:
        if (d.W(r11) != true) goto L25;
    L47:
        return;
    L11:
        r4 = false;
    L14:
        r5 = false;
        goto L15
    L41:
        this.a.E3();
        ChatAwemeFeedComponent r20 = this.a;
        r20.F = Boolean.TRUE;
        g r21 = (g) r20.w.getValue();
        if (r21 == null) goto L46;
        r21.T40(true);
        return;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void d(boolean r4) {
        if (r4 == true) goto L13;
        ChatAwemeFeedComponent r5 = this.a;
        r5.q.g = false;
        com.larus.bmhome.double_post.utils.c.a = false;
        if (r5.P == false) goto L7;
    L8:
        this.b.b.a();
    L9:
        ChatAwemeFeedComponent r6 = this.a;
        Message r2 = r6.K;
        if (r2 == null) goto L12;
        r6.m3(r2, true);
    L12:
        this.a.P = false;
    L26:
        ChatAwemeFeedComponent r7 = this.a;
        int r3 = ChatAwemeFeedComponent.V;
        Message r8 = ChatAwemeFeedComponent.D3(r7.B3());
        if (r8 != null) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == true) goto L41;
        if (r8 != null) goto L35;
    L37:
        boolean r10 = false;
    L38:
        if (r10 == true) goto L42;
        ChatAwemeFeedComponent r11 = this.a;
        r11.I = null;
        AwemeDoublePostFragment r12 = r11.q;
        r12.g = false;
        r12.j = true;
        r12.ba0(CollectionsKt.emptyList());
        return;
    L42:
        return;
    L35:
        if (d.E0(r8) != true) goto L37;
        r10 = true;
        goto L38
    L41:
        return;
    L29:
        if (d.W(r8) != true) goto L31;
        r9 = true;
        goto L32
    L7:
        if (r5.z3().getRevertAlignTopView() == true) goto L9;
    L13:
        ChatAwemeFeedComponent r13 = this.a;
        int r14 = ChatAwemeFeedComponent.V;
        g r15 = (g) r13.w.getValue();
        if (r15 != null) goto L16;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == false) goto L21;
    L24:
        boolean r17 = true;
    L25:
        r13.P = r17;
        AwemeDoublePostFragment r18 = this.a.q;
        r18.g = true;
        com.larus.bmhome.double_post.utils.c.a = true;
        r18.da0("slide");
        goto L26
    L21:
        if (this.a.L == true) goto L24;
        r17 = false;
        goto L25
    L16:
        if (r15.z0() != true) goto L18;
        r16 = true;
        goto L19
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void f(boolean r2) {
        this.a.H = r2;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void g(boolean r4) {
        FLogger.a.d("ChatAwemeFeedComponent", "onBottomViewScrollStateChange " + r4);
        if (r4 == true) goto L17;
        LarusFragmentAwemeDoublePostBinding r5 = this.a.q.e;
        StaggeredGridLayoutManager r0 = null;
        if (r5 == null) goto L7;
        RecyclerView r6 = r5.b;
    L8:
        if (r6 == null) goto L10;
        RecyclerView.LayoutManager r7 = r6.getLayoutManager();
    L12:
        if ((r7 instanceof StaggeredGridLayoutManager) == false) goto L14;
        r0 = (StaggeredGridLayoutManager) r7;
    L14:
        if (r0 == null) goto L18;
        r0.invalidateSpanAssignments();
        return;
    L18:
        return;
    L10:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    }

    public d0(ChatAwemeFeedComponent r1, LarusPageChatBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer$b
    public final void e(int r5, boolean r6, int r7) {
        boolean r0 = true;
        if (r6 == false) goto L6;
        if (r5 <= 1) goto L6;
        boolean r2 = true;
    L7:
        if (r6 == true) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r2 == false) goto L15;
        ChatAwemeFeedComponent r9 = this.a;
        int r3 = ChatAwemeFeedComponent.V;
        r9.H3(true, false);
    L17:
        ChatAwemeFeedComponent r10 = this.a;
        if (r6 == false) goto L22;
        int r11 = i5.l0();
        ChatAwemeFeedComponent r4 = this.a;
        int r12 = ChatAwemeFeedComponent.V;
        r4.getClass();
        if (r7 <= (r11 + com.larus.bmhome.double_post.utils.c.a())) goto L22;
    L23:
        int r13 = ChatAwemeFeedComponent.V;
        r10.G3(r0);
        return;
    L22:
        r0 = false;
        goto L23
    L15:
        if (r8 == false) goto L17;
        ChatAwemeFeedComponent r14 = this.a;
        int r15 = ChatAwemeFeedComponent.V;
        r14.H3(false, r6);
        goto L17
    L9:
        if (r5 <= (-5)) goto L12;
        r8 = false;
    L6:
        r2 = false;
        goto L7
    }
}
