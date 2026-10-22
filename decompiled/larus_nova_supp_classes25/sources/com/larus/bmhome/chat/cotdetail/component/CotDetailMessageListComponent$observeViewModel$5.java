package com.larus.bmhome.chat.cotdetail.component;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "msgList", "", "Lcom/larus/im/bean/message/Message;", "isFromChunk", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.cotdetail.component.CotDetailMessageListComponent$observeViewModel$5", f = "CotDetailMessageListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CotDetailMessageListComponent$observeViewModel$5 extends SuspendLambda implements Function3<List<? extends Message>, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CotDetailMessageListComponent this$0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ CotDetailMessageListComponent a;
        public final /* synthetic */ Ref.IntRef b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CotDetailMessageListComponent r0 = this.a;
            int r1 = CotDetailMessageListComponent.A;
            RecyclerView r2 = r0.Y2();
            LinearLayoutManager r3 = null;
            if (r2 == null) goto L5;
            RecyclerView.LayoutManager r4 = r2.getLayoutManager();
        L7:
            if ((r4 instanceof LinearLayoutManager) == false) goto L9;
            LinearLayoutManager r5 = (LinearLayoutManager) r4;
        L11:
            if (r5 == null) goto L15;
            View r6 = r5.findViewByPosition(this.b.element);
            if (r6 == null) goto L15;
            int r7 = r6.getTop();
        L16:
            RecyclerView r8 = this.a.Y2();
            if (r8 == null) goto L19;
            RecyclerView.LayoutManager r9 = r8.getLayoutManager();
        L21:
            if ((r9 instanceof LinearLayoutManager) == false) goto L23;
            r3 = (LinearLayoutManager) r9;
        L23:
            if (r3 == null) goto L25;
            r3.scrollToPositionWithOffset(this.b.element, r7);
        L25:
            RecyclerView r10 = this.a.Y2();
            if (r10 == null) goto L30;
            ViewTreeObserver r11 = r10.getViewTreeObserver();
            if (r11 == null) goto L30;
            r11.removeOnPreDrawListener(this);
        L30:
            return false;
        L19:
            r9 = null;
        L15:
            r7 = 0;
            goto L16
        L9:
            r5 = null;
            goto L11
        L5:
            r4 = null;
            goto L7
        }

        public a(CotDetailMessageListComponent r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ CotDetailMessageListComponent a;

        public b(CotDetailMessageListComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            CotDetailMessageListComponent.m3(this.a);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ CotDetailMessageListComponent a;
        public final /* synthetic */ boolean b;

        public c(CotDetailMessageListComponent r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            CotDetailMessageListComponent r10 = this.a;
            if (r10.w == false) goto L5;
            return;
        L5:
            if (this.b == false) goto L7;
            CotDetailMessageListComponent.m3(r10);
            return;
        L7:
            RecyclerView r11 = r10.Y2();
            LinearLayoutManager r12 = null;
            if (r11 == null) goto L10;
            RecyclerView.LayoutManager r13 = r11.getLayoutManager();
        L12:
            if ((r13 instanceof LinearLayoutManager) == false) goto L14;
            r12 = (LinearLayoutManager) r13;
        L14:
            if (r12 == null) goto L19;
            r12.scrollToPositionWithOffset(0, 0);
            return;
        L19:
            return;
        L10:
            r13 = null;
            goto L12
        }
    }

    public CotDetailMessageListComponent$observeViewModel$5(CotDetailMessageListComponent r1, Continuation<? super CotDetailMessageListComponent$observeViewModel$5> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invoke(List<Message> r3, boolean r4, Continuation<? super Unit> r5) {
        CotDetailMessageListComponent$observeViewModel$5 r0 = new CotDetailMessageListComponent$observeViewModel$5(this.this$0, r5);
        r0.L$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r52) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r52);
        List r1 = (List) this.L$0;
        final boolean r2 = this.Z$0;
        Iterator<Function1<List<Message>, Unit>> r3 = this.this$0.z.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r3.next().invoke(r1);
        goto L6
    L8:
        CotDetailMessageListComponent r4 = this.this$0;
        kc8.y r5 = (kc8.y) r4.o.getValue();
        r4.getClass();
        List<je8.a> r6 = je8.b.a;
        Intrinsics.checkNotNullParameter(r1, "messageList");
        final ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
    L10:
        if (r8.hasNext() == false) goto L23;
        Message r9 = (Message) r8.next();
        Iterator<T> r10 = je8.b.a.iterator();
    L13:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        if (((je8.a) r11).a(r9) == false) goto L13;
    L18:
        je8.a r12 = (je8.a) r11;
        if (r12 == null) goto L10;
        ie8.a r13 = (ie8.a) r12.b(r9);
        if (r13 == null) goto L10;
        r13.c = r5;
        r7.add(r13);
        goto L10
    L17:
        r11 = null;
        goto L18
    L23:
        ie8.a r14 = (ie8.a) CollectionsKt.firstOrNull(r7);
        if (r14 != null) goto L27;
    L30:
        final CotDetailMessageListComponent r15 = this.this$0;
        r15.u.submitList(r7, new c0(r15, r2, r7));
        return Unit.INSTANCE;
    L27:
        if (com.larus.bmhome.chat.bean.d.G0(r14.a) == false) goto L30;
        ArrayList r16 = new ArrayList();
        ListProtector.add(r16, 0, new he8.a(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null)));
        r16.addAll(r7);
        r7 = r16;
        goto L30
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
