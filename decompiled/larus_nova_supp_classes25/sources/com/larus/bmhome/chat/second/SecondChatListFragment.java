package com.larus.bmhome.chat.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import by7.e;
import com.larus.bmhome.chat.CommonChatListFragment;
import com.larus.bmhome.chat.adapter.ConversationAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.databinding.LarusPageSecondChatListBinding;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.a1;
import ui8.b;
import ui8.c;
import ui8.d;
import v19.j5;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u001cH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/second/SecondChatListFragment;", "Lcom/larus/bmhome/chat/CommonChatListFragment;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/larus/bmhome/databinding/LarusPageSecondChatListBinding;", "cellType", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitle", "performBack", "onCvsListChangeEvent", "list", "", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "onDestroyView", "getChatListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initData", "checkShowEmptyPage", "onBindEmptyView", "parent", "getCurrentPageName", "getTraceNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPreviousPage", "getRecommendFromString", "conversationData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SecondChatListFragment extends CommonChatListFragment {
    public static final /* synthetic */ int t = 0;
    public final String q;
    public LarusPageSecondChatListBinding r;
    public int s;

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final String b() {
        return "chat_list";
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final e ba0() {
        return this;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final ChatConversationList Y90() {
        LarusPageSecondChatListBinding r0 = this.r;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void ga0() {
        LarusPageSecondChatListBinding r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.j.getCurrentList().isEmpty() == false) goto L49;
        e1.x(r0.c);
        e1.o(r0.b);
        LinearLayout r1 = r0.c;
        if (r1.getChildCount() > 0) goto L53;
        LayoutInflater.from(getContext()).inflate(2131563055, r1);
        int r2 = 2131376297;
        if (ViewBindings.findChildViewById(r1, 2131376297) == null) goto L48;
        r2 = 2131390557;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131390557)) == null) goto L48;
        r2 = 2131390558;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r1, 2131390558);
        if (r3 == null) goto L48;
        r2 = 2131390564;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r1, 2131390564);
        if (r4 == null) goto L48;
        AppHost.Companion r5 = AppHost.a;
        CharSequence r6 = "";
        if (r5.isOversea() == false) goto L24;
        Context r7 = getContext();
        if (r7 == null) goto L28;
        String r8 = j5.a(r7, 2131894310, 2131901957);
        if (r8 == null) goto L28;
    L29:
        r4.setText(r8);
        if (r5.isOversea() == false) goto L36;
        Context r9 = getContext();
        if (r9 == null) goto L42;
        String r10 = j5.a(r9, 2131894311, 2131901953);
        if (r10 == null) goto L42;
    L41:
        r6 = r10;
    L42:
        CharSequence r11 = r6;
        int r12 = StringsKt.indexOf$default(r11, "{", 0, false, 6, null);
        int r13 = StringsKt.indexOf$default(r11, "}", 0, false, 6, null);
        if (r12 == (-1)) goto L46;
        if (r13 == (-1)) goto L46;
        SpannableString r14 = new SpannableString(StringsKt.removeRange(StringsKt.removeRange(r6, r13, r13 + 1).toString(), r12, r12 + 1).toString());
        r14.setSpan(new d(this), r12, r13 - 1, 33);
        r6 = r14;
    L46:
        r3.setText(r6);
        r3.setMovementMethod(LinkMovementMethod.getInstance());
        r3.setHighlightColor(0);
        return;
    L36:
        Context r15 = getContext();
        if (r15 == null) goto L42;
        r10 = r15.getString(2131901363);
        if (r10 != null) goto L41;
    L28:
        r8 = "";
        goto L29
    L24:
        Context r16 = getContext();
        if (r16 == null) goto L28;
        r8 = r16.getString(2131901364);
        if (r8 != null) goto L29;
    L48:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    L53:
        return;
    L49:
        e1.o(r0.c);
        e1.x(r0.b);
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void initData() {
        LarusPageSecondChatListBinding r1 = this.r;
        if (r1 == null) goto L7;
        ChatConversationList r2 = r1.b;
        if (r2 == null) goto L7;
        r2.setAdapter(this.j);
    L7:
        ConversationAdapter r3 = this.j;
        if (this.s != 2) goto L10;
        ConversationListModel.a.getClass();
        List<a> r4 = ConversationListModel.q();
    L11:
        r3.E2(r4);
        ga0();
        a1.c(null, null, null, null, null, k(), null, null, null, null, null, null, null, null, null, null, "chat_list", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048705, -1, 7);
        return;
    L10:
        ConversationListModel.a.getClass();
        r4 = ConversationListModel.s();
        goto L11
    }

    public final String k() {
        if (this.s != 2) goto L5;
        return "chat_list_only_send";
    L5:
        return "chat_list_doubao_pc";
    }

    public SecondChatListFragment() {
        this.q = "SecondChatListFragment";
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void onDestroyView() {
        super.onDestroyView();
        LarusPageSecondChatListBinding r0 = this.r;
        if (r0 == null) goto L5;
        r0.b.setAdapter(null);
    L5:
        this.r = null;
    }

    public final void zg() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        r0.setResult(100, new Intent().putExtras(f.c(new Pair[]{TuplesKt.to("previous_page", k())})));
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final String aa0(a r1) {
        return k();
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void da0(List<a> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        ArrayList r0 = new ArrayList(r7);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r8.add(a.a((a) r1.next(), null, null, 4095));
        goto L4
    L6:
        ArrayList r2 = new ArrayList();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        Object r3 = r9.next();
        a r4 = (a) r3;
        if (this.s != 2) goto L12;
        boolean r5 = n.l(r4.a);
    L13:
        if (r5 == false) goto L8;
        r2.add(r3);
        goto L8
    L12:
        r5 = n.y(r4.a);
        goto L13
    L15:
        FLogger r10 = FLogger.a;
        String r6 = this.q;
        StringBuilder r11 = new StringBuilder("onConversationListChange, source : ");
        Iterator r12 = r2.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        wc9.e r13 = ((a) r12.next()).a;
        goto L17
    L19:
        r11.append(Unit.INSTANCE);
        r10.d(r6, r11.toString());
        this.j.E2(r2);
        if (r2.isEmpty() == false) goto L35;
        int r14 = this.s;
        if (r14 != 2) goto L25;
        zg();
        return;
    L25:
        if (r14 != 1) goto L37;
        y.c(new c(this));
        return;
    L37:
        return;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusPageSecondChatListBinding r10 = this.r;
        if (r10 == null) goto L14;
        NovaTitleBarEx r0 = r10.d;
        if (this.s != 2) goto L8;
        String r11 = getString(2131908263);
    L12:
        Intrinsics.checkNotNull(r11);
        NovaTitleBarEx.Y5(r0, r11, Integer.valueOf(v19.c.b(2130972079, r0.getContext(), 2131103136)), null, 4);
        NovaTitleBarEx.b6(r0, v19.c.b(2130971749, r0.getContext(), 2131241477), false, null, null, new b(this), 14);
        return;
    L8:
        if (AppHost.a.isOversea() == false) goto L10;
        int r12 = 2131900621;
    L11:
        r11 = getString(r12);
        goto L12
    L10:
        r12 = 2131901362;
        goto L11
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Bundle r7 = getArguments();
        if (r7 == null) goto L5;
        int r8 = r7.getInt("page_type", 0);
    L6:
        this.s = r8;
        if (r8 > 0) goto L10;
        zg();
        return null;
    L10:
        View r9 = r4.inflate(2131563066, r5, false);
        int r10 = 2131367945;
        ChatConversationList r11 = ViewBindings.findChildViewById(r9, 2131367945);
        if (r11 == null) goto L21;
        r10 = 2131371589;
        LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r9, 2131371589);
        if (r0 == null) goto L21;
        r10 = 2131388772;
        NovaTitleBarEx r2 = ViewBindings.findChildViewById(r9, 2131388772);
        if (r2 == null) goto L21;
        LinearLayout r12 = (LinearLayout) r9;
        this.r = new LarusPageSecondChatListBinding(r12, r11, r0, r2);
        if (r12 == null) goto L22;
        r12.setTag(2131377847, this);
        return r12;
    L22:
        return null;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    L5:
        r8 = 0;
        goto L6
    }
}
