package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.HeaderAreaAdapter;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.utils.j3;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.d;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.SafeExtKt;
import dh8.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d6 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public d6(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r15) {
        wc9.e r16 = (wc9.e) r15;
        Intrinsics.checkNotNullParameter(r16, "new");
        if (a.c(this.a).isResumed() == false) goto L8;
        b r0 = b.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r16.a);
        r1.append(':');
        String r2 = r16.B;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.append(r2);
        String r3 = r1.toString();
        r0.getClass();
        b.a(r3);
    L8:
        com.larus.bmhome.social.userchat.model.g0 r4 = this.a.D3;
        r4.getClass();
        String r5 = r16.a;
        r4.d = r5;
        r4.c(r5, r4.c);
        ChatListComponent r6 = this.a;
        String r7 = r16.a;
        if (com.larus.utils.o0.d(r6.x3) == false) goto L14;
        NativeMessageServiceImpl r8 = d.e();
        String r9 = r6.x3;
        if (r9 != null) goto L13;
        r9 = r7;
    L13:
        r8.unregisterOnMessageChangedObserver(r9, r6.C3);
    L14:
        d.e().registerOnMessageChangedObserver(r7, r6.C3);
        r6.x3 = r7;
        ChatListComponent r10 = this.a;
        HeaderAreaAdapter r11 = r10.P;
        boolean r12 = true;
        if (r11 != null) goto L56;
        if (r11 != null) goto L44;
        z2 r13 = z2.a;
        if (r13.enableChatWithTab() == false) goto L23;
        if (r13.enableShowDisclaimer() == false) goto L23;
    L24:
        HeaderAreaAdapter r14 = new HeaderAreaAdapter();
        wc9.e r17 = r10.R4();
        if (r17 == null) goto L27;
        String r18 = r17.a;
    L28:
        r14.a = r18;
        boolean r19 = com.larus.bmhome.utils.i.f(r17);
        r14.g = r19;
        if (r14.f == false) goto L32;
        if (r19 == true) goto L32;
        boolean r20 = true;
    L33:
        r14.f = r20;
        if (r10.pl() == false) goto L45;
        Integer r21 = r10.f5();
        r14.d = r21;
        if (r13.enableBioInChatTop() != 2) goto L38;
    L42:
        boolean r22 = true;
    L43:
        r14.f = r22;
        goto L45
    L38:
        if (r13.enableBioInChatTop() != 1) goto L41;
        if (r21 != null) goto L42;
    L41:
        r22 = false;
    L45:
        r10.P = r14;
        if (r14 == null) goto L56;
        ConcatAdapter r23 = new ConcatAdapter(new RecyclerView.Adapter[]{r10.O});
        HeaderAreaAdapter r24 = r10.P;
        if (r24 == null) goto L51;
        com.larus.common_ui.widget.concat_adapter.a r25 = r23.a;
        r25.a(((ArrayList) r25.e).size(), r24);
    L51:
        LarusPageChatBinding r26 = r10.h4();
        if (r26 == null) goto L56;
        ChatMessageList r27 = r26.n;
        if (r27 == null) goto L56;
        r27.setAdapter(r23);
    L32:
        r20 = false;
        goto L33
    L27:
        r18 = null;
    L23:
        if (r13.enableBioInChatTop() != 0) goto L24;
    L44:
        r14 = null;
    L56:
        final ChatListComponent r28 = this.a;
        final String r29 = r16.a;
        final LarusPageChatBinding r30 = r28.h4();
        if (r30 == null) goto L91;
        r28.h1 = null;
        r28.p1 = false;
        Object r31 = r30.n.getTag();
        if (r31 != null) goto L61;
    L66:
        MessageAdapter r32 = r28.O;
        if (r32 == null) goto L71;
        MediatorLiveData<List<xc8.b>> r33 = r32.K;
        if (r33 == null) goto L71;
        r33.removeObservers(r28);
    L71:
        ComponentViewModel.onEach$default(r28.U5(), ChatListComponent$setupList$1$2.INSTANCE, ChatListComponent$setupList$1$3.INSTANCE, null, new ChatListComponent$setupList$1$4(r28, null), 4, null);
        ChatMessageList r34 = r30.n;
        if (r28.f1().B() == false) goto L74;
    L85:
        boolean r35 = true;
    L86:
        r34.setMiddleLoad(r35);
        MessageAdapter r36 = r28.O;
        if (r36 == null) goto L91;
        MediatorLiveData<List<xc8.b>> r37 = r36.K;
        if (r37 == null) goto L91;
        r37.observe(r28, new t6(new l0(r28, r30, r29)));
        Unit r38 = Unit.INSTANCE;
        goto L91
    L74:
        if (r28.z5() != (-1)) goto L85;
        if (r28.D6() == true) goto L85;
        if (r28.o6() == true) goto L85;
        r28.q5();
        if (com.larus.utils.o0.d(null) == true) goto L85;
        if (com.larus.utils.o0.d(r28.f1().t()) == true) goto L85;
        r35 = false;
        goto L86
    L61:
        if ((r31 instanceof LiveData) == false) goto L63;
        LiveData r39 = (LiveData) r31;
    L64:
        if (r39 == null) goto L66;
        r39.removeObservers(r28);
        goto L66
    L63:
        r39 = null;
    L91:
        ChatListComponent r40 = this.a;
        r40.getClass();
        String r41 = r16.a;
        com.larus.bmhome.chat.component.showcase.x r42 = r40.l4();
        if (r42 != null) goto L94;
    L96:
        boolean r43 = false;
    L97:
        if (r43 == false) goto L106;
        StringBuilder r44 = new StringBuilder(r41);
        r44.append("::case");
        com.larus.bmhome.chat.component.showcase.x r45 = r40.l4();
        if (r45 == null) goto L103;
        Case r46 = r45.mz(false);
        if (r46 == null) goto L103;
        String r47 = r46.getCaseId();
    L104:
        r44.append(r47);
        r41 = r44.toString();
    L103:
        r47 = null;
    L106:
        if (r41.length() != 0) goto L108;
        boolean r48 = true;
    L109:
        if (r48 == true) goto L112;
        com.larus.im.internal.stream.b r49 = com.larus.im.internal.stream.b.a;
        ChatListComponent.streamObserver.1 r50 = r40.s3;
        r49.e(r50.a, r50);
        r40.g1.clear();
        r40.h1 = null;
        r40.p1 = false;
        ChatListComponent.streamObserver.1 r51 = r40.s3;
        r51.getClass();
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r51.a = r41;
        r49.b(r41, r40.s3);
    L112:
        final ChatListComponent r52 = this.a;
        r52.P0 = false;
        if (r52.G1 == true) goto L116;
        r52.G1 = true;
        SafeExtKt.b(r52.F2(), new i0(r52), 1000);
    L116:
        ChatListComponent r53 = this.a;
        HeaderAreaAdapter r54 = r53.P;
        if (r54 == null) goto L119;
        r54.a = r16.a;
    L119:
        int r55 = ChatListComponent.W3;
        if (r53.R5() != null) goto L139;
        wc9.e r56 = this.a.R4();
        if (r56 == null) goto L139;
        String r57 = r56.a;
        if (r57 == null) goto L139;
        ChatListComponent r58 = this.a;
        String r59 = r58.H;
        if (r59.length() == 0) goto L130;
        r12 = false;
    L130:
        if (r12 == false) goto L133;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r58), Dispatchers.getIO(), null, new ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1(r58, r16, null), 2, null);
    L133:
        if (Intrinsics.areEqual(r59, r57) == true) goto L139;
        ConcurrentHashMap r60 = com.larus.bmhome.utils.v3.a;
        String r61 = r58.R5();
        Intrinsics.checkNotNullParameter(r59, "oldId");
        Intrinsics.checkNotNullParameter(r57, "newId");
        ConcurrentHashMap r62 = com.larus.bmhome.utils.v3.a;
        j3 r63 = (j3) r62.remove(new com.larus.bmhome.utils.u3(r59, r61));
        if (r63 == null) goto L137;
        r62.put(new com.larus.bmhome.utils.u3(r57, r61), r63);
    L137:
        r58.H = r57;
    L139:
        if (this.a.pl() == false) goto L146;
        wc9.e r64 = this.a.R4();
        if (r64 == null) goto L146;
        String r65 = r64.a;
        if (r65 == null) goto L146;
        ConcurrentHashMap r66 = com.larus.bmhome.utils.v3.a;
        Intrinsics.checkNotNullParameter(r65, "conversationId");
        com.larus.bmhome.utils.v3.b.add(r65);
    L146:
        if (com.larus.utils.o0.d(r16.a) == true) goto L148;
        return;
    L148:
        if (Intrinsics.areEqual(this.a.f1().p(), "ai_space_list") == true) goto L152;
        AccountService.a.p("open_conversation", System.currentTimeMillis(), MapsKt.mapOf(TuplesKt.to("conversation_id", r16.a)), "ChatFragment");
        return;
    L152:
        return;
    L108:
        r48 = false;
        goto L109
    L94:
        if (r42.e6() != true) goto L96;
        r43 = true;
        goto L97
    }
}
