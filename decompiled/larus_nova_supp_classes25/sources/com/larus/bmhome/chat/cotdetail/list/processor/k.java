package com.larus.bmhome.chat.cotdetail.list.processor;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public final Fragment a;
    public final RecyclerView b;
    public final Message c;
    public final BotModel d;
    public final CustomMarkdownTextView e;
    public final LongClickSource f;
    public final String g;
    public final boolean h;
    public final Function0<Boolean> i;
    public final f j;

    public static final class a {
    }

    public static final class b implements o99.a {
        public final /* synthetic */ MsgFeedbackType a;
        public final /* synthetic */ int b;
        public final /* synthetic */ k c;
        public final /* synthetic */ List<Integer> d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public final void d() {
        }

        public final void e(q99.d r1) {
        }

        public final void h() {
        }

        public final void i() {
        }

        public final Bundle b(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            Intrinsics.checkNotNullParameter(r2, "bundle");
            return r2;
        }

        public final n3 f(n3 r2) {
            Intrinsics.checkNotNullParameter(r2, "originalRequest");
            Intrinsics.checkNotNullParameter(r2, "originalRequest");
            return r2;
        }

        public final void a(q99.m r7, q99.l r8) {
            Intrinsics.checkNotNullParameter(r7, "request");
            Intrinsics.checkNotNullParameter(r8, "error");
            FLogger.a.w("CotDetailMessageActionDelegate", "[submitFeedback] failed, feedbackType=" + this.a + ", error=" + r8);
            int r9 = this.b;
            if (r9 <= 0) goto L5;
            this.c.a(this.a, this.d, this.e, this.f, r9 - 1);
            return;
        L5:
            k r10 = this.c;
            if (r10.h == true) goto L8;
            return;
        L8:
            if (this.f == false) goto L15;
            MsgFeedbackType r11 = this.a;
            View r0 = r10.a.getView();
            if (r0 == null) goto L16;
            r0.post(new h(r10, false, r11));
            return;
        L16:
            return;
        }

        public final void c(q99.e r1, q99.a r2) {
            o99.a.a.a(r1, r2);
        }

        public final void g(q99.m r4, q99.n r5) {
            Intrinsics.checkNotNullParameter(r4, "request");
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.d("CotDetailMessageActionDelegate", "[submitFeedback] success, feedbackType=" + this.a);
            k r6 = this.c;
            if (r6.h == false) goto L12;
            MsgFeedbackType r7 = this.a;
            if (r7 != MsgFeedbackType.MsgFeedbackTypeLike) goto L7;
        L8:
            View r0 = r6.a.getView();
            if (r0 == null) goto L14;
            r0.post(new h(r6, true, r7));
            return;
        L14:
            return;
        L7:
            if (this.f == true) goto L8;
            return;
        }

        public final void j(q99.e r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "delivery");
            Intrinsics.checkNotNullParameter(r1, "delivery");
        }

        public b(MsgFeedbackType r1, int r2, k r3, List<Integer> r4, String r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public final Set<String> c() {
        Set r0 = SetsKt.createSetBuilder();
        r0.add("copy");
        if (this.c.getMessageStatusLocal() != 21) goto L5;
    L8:
        r0.add("play");
    L9:
        r0.add("like");
        r0.add("dislike");
        r0.add("report");
        if (this.e == null) goto L13;
        r0.add("choose_text");
    L13:
        return SetsKt.build(r0);
    L5:
        if (this.c.getMessageStatusLocal() == 22) goto L8;
        if (this.c.getMessageStatusLocal() != 23) goto L9;
        goto L8
    }

    public final void a(MsgFeedbackType r24, List<Integer> r25, String r26, boolean r27, int r28) {
        String r0 = this.c.getMessageId();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        String r10 = r0;
        if (r10 == null) goto L26;
        Integer r2 = (Integer) CollectionsKt.firstOrNull(r25);
        if (r2 == null) goto L17;
        int r12 = r2.intValue();
    L18:
        String r3 = this.g;
        if (r3 != null) goto L23;
        r3 = this.c.getConversationId();
        if (r3 != null) goto L23;
        r3 = "";
    L23:
        q99.m r6 = new q99.m(new yc9.m(r3, r10, r24, r12, r25, r26, null, null, null, null, null, false, null, 8128), 8, null, this.c.getSectionId(), "message_menu_action", null, null, 100);
        FlowFeedbackServiceDelegate.a.g(r6, new b(r24, r28, this, r25, r26, r27));
        return;
    L17:
        r12 = 0;
        goto L18
    L26:
        return;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(k r6, MsgFeedbackType r7, List r8, String r9, boolean r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        List r2 = r8;
        if ((r11 & 4) == 0) goto L8;
        r9 = "";
    L8:
        String r3 = r9;
        if ((r11 & 8) == 0) goto L11;
        boolean r4 = false;
    L13:
        if ((r11 & 16) == 0) goto L15;
        int r5 = 1;
    L16:
        r6.a(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = 0;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }

    public k(Fragment r2, RecyclerView r3, Message r4, BotModel r5, CustomMarkdownTextView r6, LongClickSource r7, String r8, boolean r9, com.larus.bmhome.chat.cotdetail.list.processor.a r10) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "botModel");
        Intrinsics.checkNotNullParameter(r7, "longClickSource");
        Intrinsics.checkNotNullParameter(r10, "canAct");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        if (r9 == false) goto L5;
        int r11 = f.f;
        f r12 = f.a.a(r2, r4, r5);
    L6:
        this.j = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
