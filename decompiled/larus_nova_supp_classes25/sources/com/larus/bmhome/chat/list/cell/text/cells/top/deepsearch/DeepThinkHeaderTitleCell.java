package com.larus.bmhome.chat.list.cell.text.cells.top.deepsearch;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInStubInboxCheckboxSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.e0;
import de8.c;
import ed8.h;
import ei9.f;
import hg8.i;
import hg8.j;
import hg8.k;
import hg8.l;
import hg8.m;
import hg8.n;
import hg8.o;
import hg8.p;
import hg8.z;
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
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0#H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010%J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001dH\u0016J\u001e\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020'H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkHeaderTitleCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkHeaderTitleCellState;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/IDeepThinkCutCell;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "searchReferenceTitleComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/SearchReferenceTitleComponent;", "getSearchReferenceTitleComponent", "()Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/SearchReferenceTitleComponent;", "searchReferenceTitleComponent$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "context", "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getColor", "()Ljava/lang/Integer;", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "getAllSlotCells", "refreshSearchHeaderTitle", "updateArrowCollapsed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkHeaderTitleCell extends BaseCompositeTextCell<p> implements z {
    public static final /* synthetic */ int n = 0;
    public t j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    @Override // hg8.z
    public final void i(int r1) {
    }

    @Override // hg8.z
    public final void j() {
        e0 r0 = (e0) this.m.getValue();
        r0.J(r0.o);
    }

    public DeepThinkHeaderTitleCell() {
        this.k = LazyKt.lazy(new j(this));
        this.l = LazyKt.lazy(new k(this));
        this.m = LazyKt.lazy(new l());
    }

    public final List<BaseMessageSlotCell<? extends f>> f(int r4) {
        ArrayList r0 = new ArrayList();
        if (r4 != 0) goto L5;
        MessageInStubInboxCheckboxSlotCell r5 = new MessageInStubInboxCheckboxSlotCell();
        CompositeBoxType r1 = CompositeBoxType.CompositeTopBox;
        Intrinsics.checkNotNullParameter(r1, "boxType");
        r5.m = r1;
        r0.add(r5);
    L5:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((BaseMessageListCell) this).c = r0;
        return r0;
    }

    public final List<BaseMessageSlotCell<? extends f>> g(int r6, List<BaseMessageSlotCell<? extends f>> r7) {
        Intrinsics.checkNotNullParameter(r7, "default");
        if (r6 == 1) goto L19;
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
        CollectionsKt.removeAll(r7, new m());
        c r9 = (c) this.l.getValue();
        if (r9 == null) goto L16;
        Integer r10 = r9.m();
    L17:
        if (r10 != null) goto L19;
        CollectionsKt.removeAll(r7, new n());
        CollectionsKt.removeAll(r7, new o());
        goto L19
    L16:
        r10 = null;
    L19:
        return r7;
    }

    public final g t(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        o((e0) this.m.getValue());
        c r0 = (c) this.l.getValue();
        if (r0 == null) goto L5;
        Integer r1 = r0.m();
    L6:
        t r2 = new t(r4);
        r2.setImmerseBgColor(r1);
        ChatParam r6 = (ChatParam) this.k.getValue();
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        r2.setUseSubscribedColor(r7);
        r2.setBoxType(r5);
        this.j = r2;
        r2.setUpCompositeBoxType(CompositeBoxType.CompositeTopBox);
        r2.z = false;
        r2.y = true;
        r2.setNeedKeepWidthToMaxWidth(true);
        return r2;
    L9:
        if (r6.f != true) goto L11;
        r7 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onBindView(View r1, f r2, int r3) {
        x(r1, (p) r2, r3);
    }

    public final /* bridge */ /* synthetic */ void u(View r1, b r2, int r3) {
        x(r1, (p) r2, r3);
    }

    public final void x(View r6, p r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.u(r6, r7, r8);
        t r9 = this.j;
        h r0 = null;
        if (r9 == null) goto L16;
        Sequence r10 = ViewGroupKt.getChildren(r9);
        if (r10 == null) goto L16;
        Sequence r11 = SequencesKt.map(r10, new i());
        if (r11 == null) goto L16;
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        if (((Boolean) r12.next()).booleanValue() == false) goto L10;
        boolean r13 = true;
    L15:
        Boolean r14 = Boolean.valueOf(r13);
    L17:
        Iterator r1 = ((BaseMessageListCell) this).c.iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        Object r2 = r1.next();
        if ((((BaseMessageSlotCell) r2) instanceof MessageInStubInboxCheckboxSlotCell) == false) goto L19;
    L25:
        if ((r2 instanceof MessageInStubInboxCheckboxSlotCell) == false) goto L27;
        MessageInStubInboxCheckboxSlotCell r3 = (MessageInStubInboxCheckboxSlotCell) r2;
    L28:
        t r4 = this.j;
        if (r4 == null) goto L40;
        Context r5 = r4.getContext();
        if (r5 == null) goto L40;
        t r15 = this.j;
        if (r15 == null) goto L38;
        Integer r16 = r15.getImmerseBgColor();
        if (r16 == null) goto L38;
        int r17 = r16.intValue();
    L39:
        Integer r18 = Integer.valueOf(r17);
    L42:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L54;
        if (r3 == null) goto L45;
        r3.m(true);
    L45:
        t r19 = this.j;
        if (r19 == null) goto L48;
        ViewParent r20 = r19.getParent();
    L50:
        if ((r20 instanceof h) == false) goto L52;
        r0 = (h) r20;
    L52:
        if (r0 == null) goto L72;
        r0.o5(true, r18);
        return;
    L72:
        return;
    L48:
        r20 = null;
        goto L50
    L54:
        if (r3 == null) goto L56;
        r3.m(false);
    L56:
        t r21 = this.j;
        if (r21 == null) goto L59;
        ViewParent r22 = r21.getParent();
    L61:
        if ((r22 instanceof h) == false) goto L63;
        r0 = (h) r22;
    L63:
        if (r0 == null) goto L74;
        r0.o5(false, r18);
        return;
    L74:
        return;
    L59:
        r22 = null;
    L38:
        r17 = ContextCompat.getColor(r5, v19.c.b(2130970533, r5, 2131102542));
    L40:
        r18 = null;
        goto L42
    L27:
        r3 = null;
        goto L28
    L23:
        r2 = null;
        goto L25
    L14:
        r13 = false;
    L16:
        r14 = null;
        goto L17
    }
}
