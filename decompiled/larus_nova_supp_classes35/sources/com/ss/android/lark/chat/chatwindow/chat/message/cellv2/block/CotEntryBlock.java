package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.CotDisplayModel;
import com.ss.android.lark.chat.cot.entry.CotEntryView;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.widget.textview.ShineTextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotEntryBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;

    public static final class a implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final CotEntryView b;

        public final View getView() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.cot.entry.CotEntryView");
            this.b = (CotEntryView) r2;
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public CotEntryBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.COT_PROCESS;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.ViewGroup, com.ss.android.lark.chat.cot.entry.CotEntryView] */
    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r5, com.ss.android.lark.blueprint.q<y6b.a<?>> r6) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        com.ss.android.lark.blueprint.i.a.a(r5, r6);
        IMMessageKeys$Blocks r7 = this.g;
        IMMessageKeys$Slots r0 = IMMessageKeys$Slots.CONTENT;
        com.ss.android.lark.blueprint.k r8 = r6.f(r7, r0);
        if ((r8 instanceof a) == false) goto L5;
        a r9 = (a) r8;
    L6:
        if (r9 == null) goto L14;
        ?? r10 = r9.b;
        ShineTextView r1 = r10.a;
        if (r1 == null) goto L10;
        r1.x();
    L10:
        ShineTextView r2 = r10.a;
        if (r2 == null) goto L13;
        r2.setText(BuildConfig.FLAVOR);
    L13:
        r10.b = null;
        r10.c = null;
        r10.setOnClickListener(null);
        r10.setOnLongClickListener(null);
    L14:
        g(r6, this.g, r0);
        return;
    L5:
        r9 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup, com.ss.android.lark.chat.cot.entry.CotEntryView, java.lang.Object] */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r6, com.ss.android.lark.blueprint.q<y6b.a<?>> r7, final y6b.a<?> r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        final CotDisplayModel r9 = r8.b;
        if (r9 != null) goto L6;
        g(r7, this.g, IMMessageKeys$Slots.CONTENT);
        return;
    L6:
        final a r10 = (a) r7.c(this.g, IMMessageKeys$Slots.CONTENT, new CotEntryBlock$update$blockView$1(this));
        r9.getCotId();
        r10.getClass();
        com.ss.android.lark.chat.cot.f.c("entry_bind_v2", "messageId=" + r8.getId() + ", chatId=" + r8.getChatId() + ", cotId=" + r9.getCotId() + ", status=" + r9.getOverallStatus() + ", blocks=" + r9.getDetailViewModel().getBlocks().size());
        ?? r0 = r10.b;
        Function0<Unit> r1 = new CotEntryBlock$bindEntry$1(this, r10, r8, r9);
        r0.getClass();
        CharSequence r11 = r9.getTitleText();
        boolean r2 = true;
        if ((!StringsKt.isBlank(r11)) == true) goto L10;
        r11 = null;
    L10:
        if (r11 != null) goto L19;
        r11 = r0.b;
        if (r11 != null) goto L15;
    L17:
        r11 = null;
        goto L19
    L15:
        if (Intrinsics.areEqual(r0.c, r9.getCotId()) == false) goto L17;
    L19:
        if (r11 != null) goto L21;
    L24:
        if (r2 == false) goto L29;
        ShineTextView r12 = r0.a;
        if (r12 == null) goto L28;
        r12.x();
    L28:
        r0.setOnClickListener(null);
        r0.setVisibility(8);
        return;
    L29:
        r0.setVisibility(0);
        ShineTextView r13 = r0.a;
        if (r13 == null) goto L32;
        r13.setText(r11);
    L32:
        r0.b = r11;
        r0.c = r9.getCotId();
        r0.setOnClickListener(new com.ss.android.lark.chat.cot.entry.b(r1));
        if (r9.getOverallStatus() != CotStatus.RUNNING) goto L37;
        ShineTextView r14 = r0.a;
        if (r14 == null) goto L42;
        r14.y();
        return;
    L42:
        return;
    L37:
        ShineTextView r15 = r0.a;
        if (r15 == null) goto L44;
        r15.x();
        return;
    L44:
        return;
    L21:
        if (StringsKt.isBlank(r11) == true) goto L24;
        r2 = false;
        goto L24
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
