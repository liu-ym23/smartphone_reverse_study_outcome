package com.larus.bmhome.chat.deepresearch.view;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements com.larus.bmhome.chat.service.e {
    public final Message a;
    public final BotModel b;
    public final Long c;
    public final RecyclerView d;
    public final String e;
    public final by7.e f;
    public final w g;
    public final Boolean h;
    public final String i;
    public final Function5<CustomMarkdownTextView, String, Integer, Boolean, com.larus.bmhome.chat.api.d0, Boolean> j;
    public final com.larus.bmhome.chat.api.z k;
    public final Lazy l;
    public long m;
    public long n;
    public final y o;

    public static final class a implements com.larus.bmhome.chat.api.d0 {
        public final /* synthetic */ CustomMarkdownTextView a;
        public final /* synthetic */ a0 b;

        public a(CustomMarkdownTextView r1, a0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r2, int r3, int r4) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(r2, this.a) == true) goto L7;
            return;
        L7:
            if (r4 == 2) goto L9;
            return;
        L9:
            if (((MarkDownSelectorSettings) this.b.l.getValue()).getDoubleClickShiftStrategy() <= 0) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L17;
            final a0 r6 = this.b;
            final CustomMarkdownTextView r7 = this.a;
            r2.postDelayed(new z(r6, r7), 100);
            return;
        L17:
            return;
        L11:
            r5 = false;
            goto L12
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
            Intrinsics.checkNotNullParameter(r1, "rangeType");
            Intrinsics.checkNotNullParameter(r7, "selectedText");
            FLogger r8 = FLogger.a;
            StringBuilder r9 = new StringBuilder("onSelectionRangeChanged rect : ");
            Integer r10 = null;
            if (r6 == null) goto L5;
            Integer r11 = Integer.valueOf(r6.left);
        L6:
            r9.append(r11);
            r9.append(',');
            if (r6 == null) goto L9;
            Integer r12 = Integer.valueOf(r6.top);
        L10:
            r9.append(r12);
            r9.append(',');
            if (r6 == null) goto L13;
            Integer r13 = Integer.valueOf(r6.right);
        L14:
            r9.append(r13);
            r9.append(',');
            if (r6 == null) goto L17;
            r10 = Integer.valueOf(r6.bottom);
        L17:
            r9.append(r10);
            r8.i("yyytest!!", r9.toString());
            w r14 = this.b.g;
            if (r14 == null) goto L21;
            r14.a(r6, r7);
            return;
        L21:
            return;
        L13:
            r13 = null;
            goto L14
        L9:
            r12 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }
    }

    @Override // com.larus.bmhome.chat.service.e
    public final void onClick(View r10) {
        if ((r10 instanceof CustomMarkdownTextView) == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.n) > 300) goto L8;
        return;
    L8:
        boolean r6 = false;
        if ((r0 - this.m) <= 300) goto L11;
    L17:
        y r1 = this.o;
        int r2 = r1.a + 1;
        r1.a = r2;
        r1.b = (CustomMarkdownTextView) r10;
        if (r2 != 1) goto L20;
        r6 = true;
    L20:
        if (r6 == false) goto L23;
        com.larus.utils.t0.a.postDelayed(r1, 300);
        return;
    L23:
        return;
    L11:
        if (((MarkDownSelectorSettings) this.l.getValue()).getTripleClickStrategy() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        c((CustomMarkdownTextView) r10, false);
        this.n = r0;
        return;
    L13:
        r3 = false;
        goto L14
    }

    public final void b(CustomMarkdownTextView r11, boolean r12) {
        FLogger.a.i("MarkdownClickProcessor", "performDoubleClick, isReClick:" + r12);
        a(this.f, r11, "double_click_text", 2, r12, this.i);
    }

    public final void c(CustomMarkdownTextView r11, boolean r12) {
        FLogger.a.i("MarkdownClickProcessor", "performTripleClick, isReClick:" + r12);
        a(this.f, r11, "triple_click_text", 3, r12, this.i);
    }

    public final void a(by7.e r23, CustomMarkdownTextView r24, String r25, int r26, boolean r27, String r28) {
        a r14 = new a(r24, this);
        Function5<CustomMarkdownTextView, String, Integer, Boolean, com.larus.bmhome.chat.api.d0, Boolean> r1 = this.j;
        boolean r8 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        com.larus.bmhome.chat.api.z r3 = this.k;
        if (r3 == null) goto L21;
        BotModel r4 = this.b;
        Long r5 = this.c;
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
    L16:
        long r7 = r6;
        Message r9 = this.a;
        String r10 = this.e;
        RecyclerView r11 = this.d;
        Boolean r12 = this.h;
        if (r12 == null) goto L19;
        r8 = r12.booleanValue();
    L19:
        com.larus.bmhome.chat.api.z.a.a(r3, r23, r4, "default", r7, r24, r9, r25, r10, r11, true, r26, r27, null, r14, true, Boolean.valueOf(r8), r28, null, 397312);
        return;
    L15:
        r6 = 0;
        goto L16
    L21:
        return;
    L5:
        if (((Boolean) r1.invoke(r24, r25, Integer.valueOf(r26), Boolean.valueOf(r27), r14)).booleanValue() != true) goto L7;
        r2 = true;
        goto L8
    }

    public a0(Message r3, BotModel r4, Long r5, RecyclerView r6, String r7, com.larus.bmhome.chat.cotdetail.list.processor.f r8, com.larus.larkfeed.impl.lark.holder.content.z r9, Boolean r10, String r11, ke8.n r12, int r13) {
        if ((r13 & 128) == 0) goto L6;
        r10 = Boolean.TRUE;
    L6:
        if ((r13 & 256) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 512) == 0) goto L11;
        r12 = null;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = ILegacyChatUiServiceDelegate.b.F8();
        this.l = LazyKt.lazy(new x());
        this.o = new y(this);
    }
}
