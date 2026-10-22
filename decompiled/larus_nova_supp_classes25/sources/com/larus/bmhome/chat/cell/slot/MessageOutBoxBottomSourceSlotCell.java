package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.adapter.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.MessageSourceView;
import com.larus.chat.common.databinding.LarusWidgetChatMessageSourceBinding;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.g1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001dH\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020)2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageOutBoxBottomSourceSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageBottomSourceSlotCellData;", "<init>", "()V", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "Lkotlin/Lazy;", "collectionMessageAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionMessageAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectionMessageAbility$delegate", "caseMessageAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseMessageAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseMessageAbility$delegate", "message", "Lcom/larus/im/bean/message/Message;", "getContainerId", "", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "onSlotViewCreated", "", "slotCellView", "onBindView", "view", "position", "onSlotCellVisibilityChange", "isVisible", "", "canShowSource", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageOutBoxBottomSourceSlotCell extends BaseMessageSlotCell<d> {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public Message g;

    public static final class a implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class b implements Function0<com.larus.bmhome.chat.component.collection.o> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.collection.o.class));
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.showcase.x> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.showcase.x.class));
        }
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379968;
    }

    public MessageOutBoxBottomSourceSlotCell() {
        this.d = LazyKt.lazy(new a(this));
        this.e = LazyKt.lazy(new b(this));
        this.f = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void g(boolean r6) {
        if (r6 == true) goto L4;
        return;
    L4:
        if (l(this.g) == false) goto L38;
        Message r7 = this.g;
        String r0 = null;
        if (r7 == null) goto L8;
        String r8 = r7.getMessageId();
    L9:
        Message r1 = this.g;
        if (r1 == null) goto L12;
        String r2 = com.larus.bmhome.chat.bean.d.b(r1);
    L13:
        Message r3 = this.g;
        if (r3 == null) goto L16;
        String r4 = com.larus.bmhome.chat.bean.d.c(r3);
    L17:
        Message r5 = this.g;
        if (r5 == null) goto L20;
        r0 = r5.getLocalMessageId();
    L20:
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r8 != null) goto L35;
    L25:
        if (r2 == null) goto L27;
        r9.put("aed_display_res", r2);     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r9.put("aed_res", r4);     // Catch: JSONException -> L23
    L29:
        if (r0 == null) goto L33;
        r9.put("local_message_id", r0);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("AsrRecognizeTypeShowEventHelper", "error in AsrRecognizeTypeShowEventHelper mobAsrRecognizeTypeShowEventHelper " + e.getLocalizedMessage());
    L33:
        TrackParams r10 = new TrackParams().merge(r9);
        by7.a r11 = new by7.a("asr_recognize_type_show");
        r11.a.merge(r10);
        r11.b();
        return;
    L35:
        r9.put("message_id", r8);     // Catch: JSONException -> L23
        goto L25
    L16:
        r4 = null;
        goto L17
    L12:
        r2 = null;
        goto L13
    L8:
        r8 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void h(View r5) {
        Intrinsics.checkNotNullParameter(r5, "slotCellView");
        ConstraintLayout.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r7 = r6;
    L6:
        if (r7 == null) goto L9;
        int r0 = i5.r0();
        r7.setMargins(((ViewGroup.MarginLayoutParams) r7).leftMargin, ((ViewGroup.MarginLayoutParams) r7).topMargin, r0, ((ViewGroup.MarginLayoutParams) r7).bottomMargin);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        return new d(r3, r3.e());
    }

    public final boolean l(Message r8) {
        g1 r0 = z2.a.getAsrCheckAudioConfig();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        if (r8 != null) goto L12;
        return false;
    L12:
        RecyclerView r2 = this.b;
        Boolean r3 = null;
        if (r2 == null) goto L15;
        RecyclerView.Adapter r4 = r2.getAdapter();
    L17:
        if ((r4 instanceof q0) == false) goto L19;
        q0 r5 = (q0) r4;
    L20:
        if (r5 == null) goto L22;
        String r6 = r5.W();
    L23:
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) this.d.getValue();
        if (r7 == null) goto L26;
        List r9 = r7.tq();
    L27:
        com.larus.bmhome.chat.component.collection.o r10 = (com.larus.bmhome.chat.component.collection.o) this.e.getValue();
        if (r10 == null) goto L30;
        Boolean r11 = Boolean.valueOf(r10.i0());
    L31:
        com.larus.bmhome.chat.component.showcase.x r12 = (com.larus.bmhome.chat.component.showcase.x) this.f.getValue();
        if (r12 == null) goto L35;
        r3 = Boolean.valueOf(r12.e6());
    L35:
        if (h0.f(r8, r6, r9, r11, r3) == true) goto L38;
        return false;
    L38:
        if (com.larus.bmhome.chat.bean.d.P0(r8) == false) goto L40;
        return false;
    L40:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L63
        Map r14 = r8.getExt();     // Catch: Throwable -> L63
        if (r14 == null) goto L48;
        String r15 = (String) r14.get("audio_data_tos_uri");     // Catch: Throwable -> L63
        if (r15 == null) goto L48;
        if (o0.d(r15) != true) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == false) goto L60;
        Map r17 = r8.getExt();     // Catch: Throwable -> L63
        if (r17 == null) goto L57;
        String r18 = (String) r17.get("audio_event_resp");     // Catch: Throwable -> L63
        if (r18 == null) goto L57;
        if (o0.d(r18) != true) goto L57;
        boolean r19 = true;
    L58:
        if (r19 == false) goto L60;
        boolean r20 = true;
    L61:
        Object r21 = Result.constructor-impl(Boolean.valueOf(r20));     // Catch: Throwable -> L63
    L65:
        Boolean r22 = Boolean.FALSE;
        if (Result.isFailure-impl(r21) == false) goto L69;
        r21 = r22;
    L69:
        if (((Boolean) r21).booleanValue() == true) goto L71;
        return false;
    L71:
        return true;
    L57:
        r19 = false;
    L60:
        r20 = false;
    L48:
        r16 = false;
    L63:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L30:
        r11 = null;
        goto L31
    L26:
        r9 = null;
        goto L27
    L22:
        r6 = null;
        goto L23
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = null;
        goto L17
    L5:
        if (r0.b() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final View onCreateView(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        List r6 = ad8.a.b;
        if (z2.a.enablePreloadChatPageView().b() == false) goto L15;
        o37.c.e.getClass();
        if (o37.c.f("chat_slot_cell_nita") == false) goto L15;
        if ((r4 instanceof Activity) == false) goto L15;
        View r7 = o37.c.e("chat_slot_cell_nita").i(-5, (Activity) r4, true);     // Catch: Exception -> L13
        if ((r7 instanceof MessageSourceView) == true) goto L18;
        return new MessageSourceView(r4);
    L18:
        return r7;
    L19:
        return new MessageSourceView(r4);
    L15:
        return new MessageSourceView(r4);
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(View r5, ei9.f r6, int r7) {
        d r8 = (d) r6;
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r8, "state");
        LarusWidgetChatMessageSourceBinding r0 = null;
        if ((r5 instanceof MessageSourceView) == false) goto L5;
        MessageSourceView r9 = (MessageSourceView) r5;
    L6:
        if (r9 == null) goto L39;
        this.g = r8.a.getMessage();
        if (l(r8.a.getMessage()) == false) goto L31;
        String r10 = com.larus.bmhome.chat.bean.d.b(r8.a.getMessage());
        if (r10 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L23;
        LarusWidgetChatMessageSourceBinding r11 = r9.a;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r0.a.setVisibility(8);
        return;
    L21:
        r0 = r11;
        goto L22
    L23:
        Intrinsics.checkNotNullParameter(r10, "sourceText");
        LarusWidgetChatMessageSourceBinding r1 = r9.a;
        if (r1 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L26:
        r1.a.setVisibility(0);
        LarusWidgetChatMessageSourceBinding r12 = r9.a;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        r0.b.setText(r10);
        return;
    L29:
        r0 = r12;
        goto L30
    L13:
        if (r10.length() == 0) goto L16;
        r3 = false;
        goto L17
    L31:
        LarusWidgetChatMessageSourceBinding r13 = r9.a;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        r0.a.setVisibility(8);
        return;
    L34:
        r0 = r13;
        goto L35
    L39:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
