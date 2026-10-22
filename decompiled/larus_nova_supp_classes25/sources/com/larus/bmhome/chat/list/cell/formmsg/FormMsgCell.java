package com.larus.bmhome.chat.list.cell.formmsg;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.api.h0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.im.internal.stream.b;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ei9.f;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nf9.c;
import tf8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\"H\u0016J\b\u0010)\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/formmsg/FormMsgCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/formmsg/FormMsgCellState;", "<init>", "()V", "TAG", "", "formMsgBox", "Lcom/larus/bmhome/chat/layout/item/FormMsgBox;", "chatArguments", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArguments", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArguments$delegate", "Lkotlin/Lazy;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "conversationId", "streamObserver", "com/larus/bmhome/chat/list/cell/formmsg/FormMsgCell$streamObserver$1", "Lcom/larus/bmhome/chat/list/cell/formmsg/FormMsgCell$streamObserver$1;", "onCreateBoxView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "removeOnStreamObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FormMsgCell extends BaseMessageListCell<e> {
    public final String e;
    public q0 f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public String j;
    public final a k;

    public static final class a implements c {
        public final /* synthetic */ FormMsgCell a;

        public a(FormMsgCell r1) {
            this.a = r1;
        }

        public final void A(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            FLogger.a.d(this.a.e, "OnStreamObserver: onStreamEnd... messageId = " + r5.getMessageId() + ", conversationId = " + this.a.j);
            q0 r6 = this.a.f;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("formMsgBox");
            r6 = null;
        L5:
            e1.x(r6);
            String r7 = this.a.j;
            if (r7 == null) goto L9;
            int r0 = d.a;
            b.a.e(r7, this);
            return;
        }

        public final void B(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            FLogger.a.d(this.a.e, "OnStreamObserver: onStreamUpdate... messageId = " + r5.getMessageId() + ", conversationId = " + this.a.j);
        }

        public final void C(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            FLogger.a.d(this.a.e, "OnStreamObserver: onStreamBegin... messageId = " + r5.getMessageId() + ", conversationId = " + this.a.j);
        }
    }

    public final void onViewDetachedFromWindow() {
        FLogger.a.d(this.e, "onViewDetachedFromWindow...");
        String r0 = this.j;
        if (r0 == null) goto L6;
        int r1 = d.a;
        b.a.e(r0, this.k);
        return;
    }

    public final void onViewRecycled() {
        FLogger.a.d(this.e, "onRecycled...");
        String r0 = this.j;
        if (r0 == null) goto L6;
        int r1 = d.a;
        b.a.e(r0, this.k);
        return;
    }

    public FormMsgCell() {
        this.e = "FormMsgCell_" + hashCode();
        this.g = LazyKt.lazy(new tf8.a(this));
        this.h = LazyKt.lazy(new tf8.b(this));
        this.i = LazyKt.lazy(new tf8.c(this));
        this.k = new a(this);
    }

    public final void onViewAttachedToWindow() {
        com.larus.bmhome.chat.api.q0 r0 = lf8.a.b(this);
        if (r0 == null) goto L9;
        h0 r1 = r0.A7();
        if (r1 == null) goto L9;
        wc9.e r2 = (wc9.e) r1.invoke();
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        FLogger.a.d(this.e, "onViewAttachedToWindow: conversationId = ".concat(r3));
        if (o0.d(r3) == false) goto L16;
        this.j = r3;
        int r4 = d.a;
        b.a.b(r3, this.k);
        return;
    L16:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final View m(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        q0 r4 = new q0(r1);
        r4.setBoxType(r3);
        de8.c r5 = (de8.c) this.g.getValue();
        if (r5 == null) goto L5;
        Integer r6 = r5.m();
    L6:
        r4.setImmerseBgColor(r6);
        this.f = r4;
        return r4;
    L5:
        r6 = null;
        goto L6
    }

    public final void onBindView(View r6, f r7, int r8) {
        e r9 = (e) r7;
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r9, "state");
        Message r10 = r9.a;
        q0 r11 = this.f;
        q0 r0 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("formMsgBox");
        r11 = null;
    L5:
        r11.g(r10);
        q0 r12 = this.f;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("formMsgBox");
        r12 = null;
    L8:
        r12.setClickListener(new tf8.d(this));
        com.larus.bmhome.chat.api.q0 r13 = lf8.a.b(this);
        boolean r1 = true;
        if (r13 == null) goto L20;
        List r14 = r13.getCurrentList();
        if (r14 == null) goto L20;
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L19;
        Message r2 = (Message) r15.next();
        if ((!Intrinsics.areEqual(r2.getMessageId(), r10.getMessageId())) == false) goto L14;
    L21:
        if (r2 != null) goto L23;
    L25:
        r1 = false;
    L26:
        if (r1 == false) goto L32;
        FLogger.a.d(this.e, "bindData: message is streaming");
        q0 r16 = this.f;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("formMsgBox");
    L31:
        e1.o(r0);
        return;
    L30:
        r0 = r16;
        goto L31
    L32:
        q0 r17 = this.f;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("formMsgBox");
    L36:
        e1.x(r0);
        return;
    L35:
        r0 = r17;
        goto L36
    L23:
        if (com.larus.im.bean.message.a.w0(r2) != true) goto L25;
    L19:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L20:
        r2 = null;
        goto L21
    }
}
