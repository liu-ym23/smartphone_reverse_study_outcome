package com.larus.bmhome.chat.cell.slot;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.h0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageForkRelationSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageForkRelationSlotState;", "<init>", "()V", "boundMessage", "Lcom/larus/im/bean/message/Message;", "boundIsForkFrom", "", "boundSourceConversationId", "", "boundTextView", "Landroid/widget/TextView;", "reportedForkTipMessageIds", "", "getContainerId", "", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "onBindView", "", "view", "position", "onSlotCellVisibilityChange", "isVisible", "reportForkTipShowIfNeeded", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageForkRelationSlotCell extends BaseMessageSlotCell<i> {
    public Message d;
    public boolean e;
    public String f;
    public TextView g;
    public final Set<String> h;

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379984;
    }

    public MessageForkRelationSlotCell() {
        this.f = "";
        this.h = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void g(boolean r9) {
        if (r9 == false) goto L51;
        Message r10 = this.d;
        if (r10 == null) goto L55;
        TextView r0 = this.g;
        if (r0 != null) goto L10;
        return;
    L10:
        if (this.e == true) goto L12;
        return;
    L12:
        if (r0.getVisibility() == 0) goto L14;
        return;
    L14:
        if (r0.isShown() == true) goto L16;
        return;
    L16:
        if (r0.getGlobalVisibleRect(new Rect()) == false) goto L57;
        String r1 = r10.getMessageId();
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        String r3 = r10.getLocalMessageId();
        if (r3 != null) goto L24;
        r3 = "";
    L24:
        ?? r2 = new Pair(r3, "fork_tip_show");
        RecyclerView r4 = this.b;
        Long r5 = null;
        if (r4 == null) goto L27;
        Object r6 = r4.getTag(2131384073);
    L29:
        if (TypeIntrinsics.isMutableSet(r6) == false) goto L31;
        Set r7 = (Set) r6;
    L32:
        if (r7 != null) goto L36;
        r7 = this.h;
        r2 = r2.getFirst();
    L36:
        if (r7.add(r2) == false) goto L58;
        String r8 = r10.getConversationId();
        if (r8 != null) goto L41;
        r8 = "";
    L41:
        String r11 = this.f;
        Map r12 = r10.getExt();
        if (r12 == null) goto L46;
        String r13 = (String) r12.get("fork_index");
        if (r13 == null) goto L46;
        r5 = StringsKt.toLongOrNull(r13);
    L46:
        Map r14 = h0.a;
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r11, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r1, "messageId");
        h0.d(r8, r11, "", r5);
        JSONObject r15 = new JSONObject();
        r15.put("current_page", "chat");
        r15.put("conversation_id", r8);
        r15.put("fork_from_conversation_id", r11);
        r15.put("message_id", r1);
        if (r5 == null) goto L49;
        r15.put("fork_index", r5.longValue());
    L49:
        h0.b("fork_tip_show", r15);
        return;
    L58:
        return;
    L31:
        r7 = null;
        goto L32
    L27:
        r6 = null;
        goto L29
    L57:
        return;
    L55:
        return;
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return new i(r2);
    }

    public final View onCreateView(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        TextView r5 = new TextView(r3);
        r5.setGravity(17);
        r5.setTextSize(12.0f);
        r5.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r5.setMaxLines(1);
        r5.setIncludeFontPadding(false);
        r5.setPadding(0, i5.Y(), 0, i5.Y());
        this.g = r5;
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(View r22, ei9.f r23, int r24) {
        i r2 = (i) r23;
        Intrinsics.checkNotNullParameter(r22, "view");
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r22 instanceof TextView) == false) goto L5;
        TextView r1 = (TextView) r22;
    L6:
        if (r1 == null) goto L130;
        final Message r7 = r2.a.getMessage();
        Map r3 = r7.getExt();
        if (r3 != null) goto L11;
        r3 = MapsKt.emptyMap();
    L11:
        String r5 = (String) r3.get("fork_from_conversation_id");
        String r6 = "";
        if (r5 != null) goto L14;
        final String r8 = "";
    L15:
        String r9 = (String) r3.get("fork_from_conversation_name");
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        String r10 = (String) r3.get("fork_to_conversation_id");
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        String r11 = (String) r3.get("fork_to_conversation_name");
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        if ((!StringsKt.isBlank(r8)) == true) goto L27;
    L29:
        boolean r12 = false;
    L30:
        this.d = r7;
        this.e = r12;
        this.f = r8;
        if (r12 == false) goto L44;
        String r15 = r7.getConversationId();
        if (r15 != null) goto L35;
        r15 = "";
    L35:
        String r4 = (String) r3.get("fork_from_message_id");
        if (r4 == null) goto L39;
        r6 = r4;
    L39:
        String r13 = (String) r3.get("fork_index");
        if (r13 == null) goto L42;
        Long r14 = StringsKt.toLongOrNull(r13);
    L43:
        h0.d(r15, r8, r6, r14);
        goto L44
    L42:
        r14 = null;
    L44:
        if (r12 == false) goto L46;
        r10 = r8;
    L46:
        if (r12 == true) goto L50;
        r9 = r11;
    L50:
        if (StringsKt.isBlank(r10) == false) goto L52;
    L118:
        e1.o(r1);
        return;
    L52:
        if (StringsKt.isBlank(r9) == true) goto L118;
        RecyclerView r16 = this.b;
        if (r16 == null) goto L57;
        RecyclerView.Adapter r17 = r16.getAdapter();
    L59:
        if ((r17 instanceof q0) == false) goto L61;
        q0 r18 = (q0) r17;
    L62:
        if (r18 == null) goto L76;
        List<wq8.a> r19 = r18.D7();
        if (r19 == null) goto L76;
        List r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L67:
        if (r21.hasNext() == false) goto L77;
        Object r25 = r21.next();
        Map r110 = ((wq8.a) r25).getMessage().getExt();
        if (r110 != null) goto L71;
        r110 = MapsKt.emptyMap();
    L71:
        if (r12 == false) goto L73;
        boolean r111 = Intrinsics.areEqual(r110.get("fork_from_conversation_id"), r10);
    L74:
        if (r111 == false) goto L67;
        r20.add(r25);
        goto L67
    L73:
        r111 = Intrinsics.areEqual(r110.get("fork_to_conversation_id"), r10);
    L77:
        if (r20 != 0) goto L79;
        r20 = CollectionsKt.emptyList();
    L79:
        Iterator r26 = r20.iterator();
    L81:
        if (r26.hasNext() == false) goto L85;
        Object r27 = r26.next();
        if (com.larus.bmhome.chat.bean.d.O0(((wq8.a) r27).getMessage()) == false) goto L81;
    L86:
        wq8.a r28 = (wq8.a) r27;
        if (r28 == null) goto L91;
        Message r29 = r28.getMessage();
        if (r29 == null) goto L91;
    L95:
        if (r29 != null) goto L97;
    L101:
        Context r30 = r1.getContext();
        if (r12 == false) goto L104;
        int r31 = 2131906577;
    L105:
        String r32 = r30.getString(r31, new Object[]{r9});
        int r33 = ContextCompat.getColor(r1.getContext(), v19.c.b(2130972081, r1.getContext(), 2131103143));
        int r34 = ContextCompat.getColor(r1.getContext(), v19.c.b(2130972123, r1.getContext(), 2131103203));
        Drawable r35 = ContextCompat.getDrawable(r1.getContext(), 2131242701);
        if (r35 == null) goto L108;
        Drawable r36 = r35.mutate();
    L109:
        if (r36 == null) goto L111;
        DrawableCompat.setTint(r36, r33);
        r36.setBounds(0, 0, i5.m(), i5.m());
    L111:
        r1.setTextColor(r33);
        r1.setCompoundDrawables(null, null, null, null);
        SpannableStringBuilder r37 = new SpannableStringBuilder();
        if (r36 == null) goto L114;
        int r112 = r37.length();
        r37.append(65532);
        r37.setSpan(new g(r36), r112, r112 + 1, 33);
    L114:
        int r38 = r37.length();
        r37.append(r32);
        int r113 = StringsKt.indexOf$default(r32, r9, 0, false, 6, null);
        if (r113 < 0) goto L117;
        int r39 = r38 + r113;
        r37.setSpan(new ForegroundColorSpan(r34), r39, r9.length() + r39, 33);
    L117:
        r1.setText(r37);
        final boolean r40 = r12;
        final String r41 = r10;
        final TextView r114 = r1;
        r1.setOnClickListener(new f(r40, r7, r8, r41, r114));
        r1.setContentDescription(r32);
        e1.x(r1);
        return;
    L108:
        r36 = null;
        goto L109
    L104:
        r31 = 2131906578;
        goto L105
    L97:
        if (Intrinsics.areEqual(r29.getLocalMessageId(), r7.getLocalMessageId()) == true) goto L101;
        if (Intrinsics.areEqual(r29.getMessageId(), r7.getMessageId()) == true) goto L101;
        e1.o(r1);
        return;
    L91:
        wq8.a r42 = (wq8.a) CollectionsKt.lastOrNull(r20);
        if (r42 == null) goto L94;
        r29 = r42.getMessage();
        goto L95
    L94:
        r29 = null;
        goto L95
    L85:
        r27 = null;
    L76:
        r20 = 0;
        goto L77
    L61:
        r18 = null;
        goto L62
    L57:
        r17 = null;
        goto L59
    L27:
        if ((!StringsKt.isBlank(r9)) == false) goto L29;
        r12 = true;
        goto L30
    L14:
        r8 = r5;
        goto L15
    L130:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
