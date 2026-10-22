package com.larus.bmhome.chat.list.cell.text.cells.bottom;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageForkRelationSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomRetrySlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInStubInboxCheckboxSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightStubRegenForImmerseSlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.AnswerActionComponent;
import com.larus.utils.e1;
import eg8.b;
import eg8.c;
import eg8.d;
import eg8.e;
import eg8.g;
import ei9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a0\u001dH\u0016J\u001e\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/bottom/BottomTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/bottom/BottomTextCellState;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "context", "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getAllSlotCells", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "adjustImmerseRetry", "isBottomHaveContent", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomTextCell extends BaseCompositeTextCell<g> {
    public static final /* synthetic */ int m = 0;
    public t j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
    }

    static {
    }

    public BottomTextCell() {
        this.k = LazyKt.lazy(new b(this));
        this.l = LazyKt.lazy(new c(this));
    }

    public final List<BaseMessageSlotCell<? extends f>> f(int r4) {
        ArrayList r0 = new ArrayList();
        if (r4 != 0) goto L5;
        MessageInStubInboxCheckboxSlotCell r5 = new MessageInStubInboxCheckboxSlotCell();
        CompositeBoxType r1 = CompositeBoxType.CompositeBottomBox;
        Intrinsics.checkNotNullParameter(r1, "boxType");
        r5.m = r1;
        r5.m(false);
        r0.add(r5);
        r0.add(new MessageInBoxBottomRetrySlotCell());
        r0.add(new MessageForkRelationSlotCell());
    L5:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((BaseMessageListCell) this).c = r0;
        return r0;
    }

    public final List<BaseMessageSlotCell<? extends f>> g(int r6, List<BaseMessageSlotCell<? extends f>> r7) {
        Intrinsics.checkNotNullParameter(r7, "default");
        if (r6 == 1) goto L20;
        ArrayList r8 = new ArrayList();
        Iterator<T> r1 = r7.iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (r2 == true) goto L9;
        if ((((BaseMessageSlotCell) r3) instanceof MessageInboxRightRetrySlotCell) == true) goto L6;
        r8.add(r3);
        r2 = true;
        goto L6
    L9:
        r8.add(r3);
        goto L6
    L13:
        CollectionsKt.removeAll(r7, new d());
        de8.c r9 = (de8.c) this.l.getValue();
        if (r9 == null) goto L16;
        Integer r10 = r9.m();
    L17:
        if (r10 != null) goto L19;
        CollectionsKt.removeAll(r7, new e());
        CollectionsKt.removeAll(r7, new eg8.f());
        goto L20
    L19:
        ArrayList r0 = (ArrayList) r7;
        r0.add(new MessageInboxRightStubRegenForImmerseSlotCell());
        goto L20
    L16:
        r10 = null;
    L20:
        return r7;
    }

    public final com.larus.bmhome.chat.layout.item.g t(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        o(new jg8.d(0));
        o(new lg8.f(10));
        o(new mg8.e(20));
        o(new ng8.b(25));
        o(new kg8.b(26));
        o(new AnswerActionComponent(30));
        o(new ig8.b());
        if (com.larus.network.http.d.e == false) goto L5;
        o(new og8.a());
    L5:
        de8.c r0 = (de8.c) this.l.getValue();
        if (r0 == null) goto L8;
        Integer r1 = r0.m();
    L9:
        t r2 = new t(r4);
        r2.setImmerseBgColor(r1);
        ChatParam r6 = (ChatParam) this.k.getValue();
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        r2.setUseSubscribedColor(r7);
        r2.setBoxType(r5);
        this.j = r2;
        r2.setUpCompositeBoxType(CompositeBoxType.CompositeBottomBox);
        r2.z = true;
        r2.y = false;
        r2.setNeedKeepWidthToMaxWidth(true);
        return r2;
    L12:
        if (r6.f != true) goto L14;
        r7 = true;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final /* bridge */ /* synthetic */ void onBindView(View r1, f r2, int r3) {
        x(r1, (g) r2, r3);
    }

    public final /* bridge */ /* synthetic */ void u(View r1, xc8.b r2, int r3) {
        x(r1, (g) r2, r3);
    }

    public final void x(View r4, g r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.u(r4, r5, r6);
        t r7 = this.j;
        if (r7 == null) goto L45;
        Sequence r8 = ViewGroupKt.getChildren(r7);
        if (r8 == null) goto L46;
        Sequence r9 = SequencesKt.map(r8, new eg8.a());
        if (r9 == null) goto L47;
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        if (((Boolean) r10.next()).booleanValue() == false) goto L10;
        boolean r11 = true;
    L15:
        t r12 = this.j;
        MessageInboxRightStubRegenForImmerseSlotCell r0 = null;
        if (r12 == null) goto L18;
        Integer r13 = r12.getImmerseBgColor();
    L19:
        if (r13 == null) goto L52;
        Iterator r14 = ((BaseMessageListCell) this).c.iterator();
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r1 = r14.next();
        if ((((BaseMessageSlotCell) r1) instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L23;
    L29:
        if ((r1 instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L31;
        r0 = (MessageInboxRightStubRegenForImmerseSlotCell) r1;
    L31:
        if (r11 == false) goto L36;
        if (r0 == null) goto L48;
        ChatRetry r15 = r0.m;
        if (r15 == null) goto L49;
        e1.o(r15);
        return;
    L49:
        return;
    L48:
        return;
    L36:
        if (r0 == null) goto L51;
        r0.t(true);
        return;
    L51:
        return;
    L27:
        r1 = null;
        goto L29
    L52:
        return;
    L18:
        r13 = null;
        goto L19
    L14:
        r11 = false;
        goto L15
    L47:
        return;
    L46:
        return;
    }
}
