package com.larus.bmhome.chat.list.cell.text.cells.middle;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInStubInboxCheckboxSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightStubRegenForImmerseSlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import fg8.b;
import fg8.c;
import fg8.d;
import fg8.e;
import fg8.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J4\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c0\u001fH\u0016J\u001e\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/middle/MiddleTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/middle/MiddleTextCellState;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "middleTextComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/middle/MiddleTextComponent;", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "context", "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getAllSlotCells", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "adjustMarkdownTextviewMarginAndCheckBoxStatus", "adjustImmerseRetry", "isBottomHaveContent", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MiddleTextCell extends BaseCompositeTextCell<f> {
    public static final /* synthetic */ int n = 0;
    public t j;
    public final Lazy k;
    public final Lazy l;
    public MiddleTextComponent m;

    public static final class a {
    }

    static {
    }

    public MiddleTextCell() {
        this.k = LazyKt.lazy(new fg8.a(this));
        this.l = LazyKt.lazy(new b(this));
    }

    public final List<BaseMessageSlotCell<? extends ei9.f>> f(int r5) {
        ArrayList r0 = new ArrayList();
        if (r5 != 0) goto L5;
        r0.add(new MessageInboxRightRetrySlotCell());
        MessageInStubInboxCheckboxSlotCell r1 = new MessageInStubInboxCheckboxSlotCell();
        CompositeBoxType r2 = CompositeBoxType.CompositeMiddleBox;
        Intrinsics.checkNotNullParameter(r2, "boxType");
        r1.m = r2;
        r0.add(r1);
    L5:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((BaseMessageListCell) this).c = r0;
        g(r5, r0);
        return r0;
    }

    public final List<BaseMessageSlotCell<? extends ei9.f>> g(int r6, List<BaseMessageSlotCell<? extends ei9.f>> r7) {
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
        CollectionsKt.removeAll(r7, new c());
        de8.c r9 = (de8.c) this.l.getValue();
        if (r9 == null) goto L16;
        Integer r10 = r9.m();
    L17:
        if (r10 != null) goto L19;
        CollectionsKt.removeAll(r7, new d());
        CollectionsKt.removeAll(r7, new e());
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

    public final g t(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        MiddleTextComponent r0 = new MiddleTextComponent(0, this);
        o(r0);
        this.m = r0;
        o(new ig8.b());
        de8.c r1 = (de8.c) this.l.getValue();
        if (r1 == null) goto L5;
        Integer r2 = r1.m();
    L6:
        t r3 = new t(r4);
        r3.setImmerseBgColor(r2);
        ChatParam r6 = (ChatParam) this.k.getValue();
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        r3.setUseSubscribedColor(r7);
        r3.setBoxType(r5);
        this.j = r3;
        r3.z = false;
        r3.y = false;
        r3.setNeedKeepWidthToMaxWidth(true);
        r3.setUpCompositeBoxType(CompositeBoxType.CompositeMiddleBox);
        return r3;
    L9:
        if (r6.f != true) goto L11;
        r7 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onBindView(View r1, ei9.f r2, int r3) {
        x(r1, (f) r2, r3);
    }

    public final /* bridge */ /* synthetic */ void u(View r1, xc8.b r2, int r3) {
        x(r1, (f) r2, r3);
    }

    public final void x(View r18, f r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "state");
        super.u(r18, r19, r20);
        Fragment r2 = lf8.a.d(this);
        if (r2 == null) goto L5;
        t1a.b r3 = s1a.a.g(r2);
    L6:
        Message r4 = r19.f;
        q0 r5 = lf8.a.b(this);
        List<tg8.b> r6 = com.larus.bmhome.chat.list.cell.text.cells.base.b.a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Intrinsics.checkNotNullParameter(r4, "message");
        List<tg8.b> r8 = com.larus.bmhome.chat.list.cell.text.cells.base.b.b;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = ((ArrayList) r8).iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        r9.add(Boolean.valueOf(((tg8.b) r10.next()).c(r3, r4, r5)));
        goto L8
    L11:
        if (r9.isEmpty() == true) goto L19;
        Iterator r7 = r9.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        if (((Boolean) r7.next()).booleanValue() == false) goto L15;
        boolean r11 = true;
    L20:
        Fragment r12 = lf8.a.d(this);
        if (r12 == null) goto L23;
        t1a.b r13 = s1a.a.g(r12);
    L24:
        Message r14 = r19.f;
        q0 r15 = lf8.a.b(this);
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Intrinsics.checkNotNullParameter(r14, "message");
        List<tg8.b> r16 = com.larus.bmhome.chat.list.cell.text.cells.base.b.a;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r21 = ((ArrayList) r16).iterator();
    L26:
        if (r21.hasNext() == false) goto L29;
        r17.add(Boolean.valueOf(((tg8.b) r21.next()).c(r13, r14, r15)));
        goto L26
    L29:
        if (r17.isEmpty() == true) goto L37;
        Iterator r22 = r17.iterator();
    L33:
        if (r22.hasNext() == false) goto L37;
        if (((Boolean) r22.next()).booleanValue() == false) goto L33;
        boolean r23 = true;
    L39:
        if (r23 == false) goto L45;
        Context r24 = lf8.a.getContext(this);
        if (r24 == null) goto L45;
        Resources r25 = r24.getResources();
        if (r25 == null) goto L45;
        int r26 = r25.getDimensionPixelSize(2131167562);
    L46:
        if (r11 == false) goto L52;
        Context r27 = lf8.a.getContext(this);
        if (r27 == null) goto L52;
        Resources r28 = r27.getResources();
        if (r28 == null) goto L52;
        int r29 = r28.getDimensionPixelSize(2131167562);
    L53:
        FLogger.a.d("MiddleTextCell", "onBindView:" + r19.f.getContent() + "===topMargin:" + r26 + "===bottomMargin:" + r29 + "==topHaveVisibleView:" + r23 + "===bottomHaveVisibleView:" + r11);
        MiddleTextComponent r1 = this.m;
        if (r1 == null) goto L87;
        LinearLayout r30 = r1.M;
        if (r30 == null) goto L87;
        int r31 = r30.getChildCount();
        int r110 = 0;
    L58:
        if (r110 >= r31) goto L87;
        View r111 = r30.getChildAt(r110);
        if ((r111 instanceof FrameLayout) == false) goto L62;
        FrameLayout r112 = (FrameLayout) r111;
    L63:
        if (r112 == null) goto L86;
        int r113 = r112.getChildCount();
        int r114 = 0;
    L65:
        if (r114 >= r113) goto L86;
        CustomMarkdownTextView r115 = r112.getChildAt(r114);
        if ((r115 instanceof CustomMarkdownTextView) == false) goto L69;
        CustomMarkdownTextView r116 = r115;
    L70:
        if (r116 == null) goto L85;
        CustomMarkdownTextView r117 = r115;
        Context r118 = lf8.a.getContext(this);
        if (r118 == null) goto L76;
        Resources r119 = r118.getResources();
        if (r119 == null) goto L76;
        int r120 = r119.getDimensionPixelSize(2131167561);
    L77:
        Context r121 = lf8.a.getContext(this);
        if (r121 == null) goto L82;
        Resources r32 = r121.getResources();
        if (r32 == null) goto L82;
        int r33 = r32.getDimensionPixelSize(2131167561);
    L83:
        FLogger.a.i("updatePaddingRelative", "view:" + r117.getClass().getSimpleName() + ",source:,start:" + r120 + ",top:" + r26 + ",end:" + r33 + ",bottom:" + r29);
        r117.setPaddingRelative(r120, r26, r33, r29);
    L82:
        r33 = 0;
    L76:
        r120 = 0;
    L85:
        r114 = r114 + 1;
        r30 = r30;
        goto L65
    L69:
        r116 = null;
    L86:
        r110 = r110 + 1;
        r30 = r30;
        goto L58
    L62:
        r112 = null;
    L87:
        t r34 = this.j;
        if (r34 == null) goto L90;
        r34.setUpMiddleNeedTopRadius(!r23);
    L90:
        t r35 = this.j;
        if (r35 == null) goto L93;
        r35.setUpMiddleNeedBottomRadius(!r11);
    L93:
        Iterator r36 = ((BaseMessageListCell) this).c.iterator();
    L95:
        if (r36.hasNext() == false) goto L99;
        Object r37 = r36.next();
        if ((((BaseMessageSlotCell) r37) instanceof MessageInStubInboxCheckboxSlotCell) == false) goto L95;
    L101:
        if ((r37 instanceof MessageInStubInboxCheckboxSlotCell) == false) goto L103;
        MessageInStubInboxCheckboxSlotCell r38 = (MessageInStubInboxCheckboxSlotCell) r37;
    L104:
        if (r23 == true) goto L107;
        if (r38 == null) goto L109;
        r38.m(true);
    L109:
        t r39 = this.j;
        if (r39 == null) goto L112;
        Integer r40 = r39.getImmerseBgColor();
    L113:
        if (r40 == null) goto L157;
        Iterator r41 = ((BaseMessageListCell) this).c.iterator();
    L117:
        if (r41.hasNext() == false) goto L121;
        Object r42 = r41.next();
        if ((((BaseMessageSlotCell) r42) instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L117;
    L123:
        if ((r42 instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L125;
        MessageInboxRightStubRegenForImmerseSlotCell r43 = (MessageInboxRightStubRegenForImmerseSlotCell) r42;
    L126:
        if (r11 == false) goto L131;
        if (r43 == null) goto L153;
        ChatRetry r44 = r43.m;
        if (r44 == null) goto L154;
        e1.o(r44);
        return;
    L154:
        return;
    L153:
        return;
    L131:
        if (r43 == null) goto L156;
        r43.t(false);
        return;
    L156:
        return;
    L125:
        r43 = null;
        goto L126
    L121:
        r42 = null;
        goto L123
    L157:
        return;
    L112:
        r40 = null;
        goto L113
    L107:
        if (r38 == null) goto L109;
        r38.m(false);
        goto L109
    L103:
        r38 = null;
        goto L104
    L99:
        r37 = null;
    L52:
        r29 = 0;
    L45:
        r26 = 0;
    L37:
        r23 = false;
        goto L39
    L23:
        r13 = null;
    L19:
        r11 = false;
        goto L20
    L5:
        r3 = null;
        goto L6
    }
}
