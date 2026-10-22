package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.IntentFilter;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.input.impl.databinding.LarusLayoutLatestPhotoShortcutViewBinding;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "latestPhotoViewState", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutComponent$observeLatestPhotoViewState$1", f = "LatestPhotoShortcutComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LatestPhotoShortcutComponent$observeLatestPhotoViewState$1 extends SuspendLambda implements Function2<LatestPhotoShortcutViewState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LatestPhotoShortcutComponent this$0;

    public LatestPhotoShortcutComponent$observeLatestPhotoViewState$1(LatestPhotoShortcutComponent r1, Continuation<? super LatestPhotoShortcutComponent$observeLatestPhotoViewState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LatestPhotoShortcutComponent$observeLatestPhotoViewState$1 r0 = new LatestPhotoShortcutComponent$observeLatestPhotoViewState$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(LatestPhotoShortcutViewState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((LatestPhotoShortcutViewState) r1, (Continuation) r2);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.larus.bmhome.chat.component.bottom.multimodal.latest.c] */
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r11);
        LatestPhotoShortcutViewState r12 = (LatestPhotoShortcutViewState) this.L$0;
        FLogger r0 = FLogger.a;
        r0.i("LatestPhotoShortcutComponent", "[onEach] latestPhotoViewState:" + r12);
        ShortcutViewState r1 = r12.getShortcutViewState();
        if (r1 == null) goto L55;
        final LatestPhotoShortcutComponent r3 = this.this$0;
        boolean r5 = false;
        if (Intrinsics.areEqual(r1, ShortcutViewState.a.a) == false) goto L17;
        if (r3.v < 0) goto L12;
        long r6 = System.currentTimeMillis() - r3.v;
        r3.v = -1;
        r0.i("LatestPhotoShortcutComponent", "[recordDisplayDuration] displayDuration:" + r6 + "ms");
    L12:
        LarusLayoutLatestPhotoShortcutViewBinding r13 = r3.u;
        if (r13 == null) goto L15;
        LatestPhotoShortcutComponent.m3(r13, false);
    L15:
        LatestPhotoShortcutMsgProcessor r14 = (LatestPhotoShortcutMsgProcessor) r3.s.getValue();
        LocalBroadcastManager.getInstance(r14.a).unregisterReceiver(r14.d);
        goto L55
    L17:
        if ((r1 instanceof ShortcutViewState.b) == false) goto L53;
        Iterator r2 = ((List) ((b0) r3.r.getValue()).i.getValue()).iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        b0.b r4 = (b0.b) r2.next();
        if (((Boolean) r4.b.invoke()).booleanValue() == false) goto L20;
        FLogger.a.i("LatestPhotoShortcutShowGate", "[canShow] false, " + r4.a);
    L25:
        if (r5 == false) goto L51;
        r3.v = System.currentTimeMillis();
        final Uri r7 = ((ShortcutViewState.b) r1).a;
        final boolean r15 = r12.getSkipAttachmentPanel();
        ViewStub r8 = r3.t;
        if (r8 == null) goto L46;
        r8.setLayoutResource(2131562844);
        ?? r9 = new c(r7, r3, r15);
        LarusLayoutLatestPhotoShortcutViewBinding r16 = r3.u;
        if (r16 != null) goto L45;
        FLogger.a.i("LatestPhotoShortcutComponent", "[inflateStub] inflate");
        View r17 = r8.inflate();
        if (r17 == null) goto L46;
        ViewGroup.LayoutParams r10 = r17.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r10;
    L36:
        if (r18 == null) goto L38;
        r18.setMarginEnd(-c7.b(8));
    L38:
        r17.setLayoutParams(r18);
        LatestPhotoShortcutGestureLayout r19 = (LatestPhotoShortcutGestureLayout) r17;
        int r20 = 2131388629;
        SimpleDraweeView r21 = ViewBindings.findChildViewById(r17, 2131388629);
        if (r21 == null) goto L44;
        r20 = 2131391396;
        if (ViewBindings.findChildViewById(r17, 2131391396) == null) goto L44;
        LarusLayoutLatestPhotoShortcutViewBinding r110 = new LarusLayoutLatestPhotoShortcutViewBinding(r19, r21);
        r3.u = r110;
        Intrinsics.checkNotNull(r110);
        r9.invoke(r110);
    L44:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r20)));
    L35:
        r18 = null;
        goto L36
    L45:
        r9.invoke(r16);
        FLogger.a.i("LatestPhotoShortcutComponent", "[inflateStub] already inflated");
    L46:
        LatestPhotoShortcutMsgProcessor r111 = (LatestPhotoShortcutMsgProcessor) r3.s.getValue();
        LocalBroadcastManager r22 = LocalBroadcastManager.getInstance(r111.a);
        LatestPhotoShortcutMsgProcessor$broadcastReceiver$1 r23 = r111.d;
        IntentFilter r24 = new IntentFilter();
        Iterator<String> r112 = r111.c.iterator();
    L48:
        if (r112.hasNext() == false) goto L50;
        r24.addAction(r112.next());
        goto L48
    L50:
        Unit r113 = Unit.INSTANCE;
        r22.registerReceiver(r23, r24);
        goto L55
    L51:
        r3.Y2().handleEvent(LatestPhotoShortcutEvent.b.a);
        goto L55
    L24:
        r5 = true;
        goto L25
    L53:
        throw new NoWhenBranchMatchedException();
    L55:
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
