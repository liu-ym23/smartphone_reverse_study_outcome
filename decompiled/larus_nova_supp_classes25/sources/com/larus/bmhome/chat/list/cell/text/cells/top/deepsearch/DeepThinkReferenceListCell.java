package com.larus.bmhome.chat.list.cell.text.cells.top.deepsearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.w;
import de8.c;
import ei9.f;
import hg8.r;
import hg8.u;
import hg8.v;
import hg8.x;
import hg8.y;
import hg8.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0#H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001dH\u0016J\u001e\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020'H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u001dH\u0016J \u00101\u001a\u0002022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkReferenceListCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkReferenceCellState;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/IDeepThinkCutCell;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "referenceListComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/ReferenceListComponent;", "getReferenceListComponent", "()Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/ReferenceListComponent;", "referenceListComponent$delegate", "Lkotlin/Lazy;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "context", "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getColor", "()Ljava/lang/Integer;", "onViewAttachedToWindow", "", "onBindView", "view", "Landroid/view/View;", "state", "position", "getAllSlotCells", "onViewRecycled", "updateVisible", "visibility", "shouldBindCell", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkReferenceListCell extends BaseCompositeTextCell<r> implements z {
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
    public final void j() {
    }

    public DeepThinkReferenceListCell() {
        this.k = LazyKt.lazy(new hg8.t());
        this.l = LazyKt.lazy(new u(this));
        this.m = LazyKt.lazy(new v(this));
    }

    public final void onViewRecycled() {
        super.onViewRecycled();
        t r0 = this.j;
        View r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof View) == false) goto L9;
        r1 = (View) r2;
    L9:
        if (r1 == null) goto L12;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.height = -2;
        r1.setLayoutParams(r3);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
    }

    public final List<BaseMessageSlotCell<? extends f>> f(int r1) {
        return CollectionsKt.emptyList();
    }

    @Override // hg8.z
    public final void i(int r2) {
        ((w) this.k.getValue()).i(r2);
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
        CollectionsKt.removeAll(r7, new hg8.w());
        c r9 = (c) this.m.getValue();
        if (r9 == null) goto L16;
        Integer r10 = r9.m();
    L17:
        if (r10 != null) goto L19;
        CollectionsKt.removeAll(r7, new x());
        CollectionsKt.removeAll(r7, new y());
        goto L19
    L16:
        r10 = null;
    L19:
        return r7;
    }

    public final g t(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        o((w) this.k.getValue());
        c r0 = (c) this.m.getValue();
        if (r0 == null) goto L5;
        Integer r1 = r0.m();
    L6:
        t r2 = new t(r4);
        r2.setImmerseBgColor(r1);
        ChatParam r6 = (ChatParam) this.l.getValue();
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        r2.setUseSubscribedColor(r7);
        r2.setBoxType(r5);
        this.j = r2;
        r2.setUpCompositeBoxType(CompositeBoxType.CompositeMiddleBox);
        r2.z = false;
        r2.y = false;
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

    public final void onBindView(View r2, f r3, int r4) {
        r r5 = (r) r3;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.u(r2, r5, r4);
    }

    public final boolean shouldBindCell(View r1, f r2, int r3) {
        r r4 = (r) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        return ((w) this.k.getValue()).H(r4);
    }

    public final void u(View r2, b r3, int r4) {
        r r5 = (r) r3;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.u(r2, r5, r4);
    }

    public final boolean w(View r1, b r2, int r3) {
        r r4 = (r) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        return ((w) this.k.getValue()).H(r4);
    }
}
