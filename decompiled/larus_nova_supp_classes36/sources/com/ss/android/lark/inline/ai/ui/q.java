package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.inline.ai.api.ui.Feedback;
import com.ss.android.lark.inline.ai.api.ui.FeedbackConfig;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.myai.export.model.DownVoteFeedbackParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ InlineAIPanelController a;

    public static final class a implements wlb.b {
        public final /* synthetic */ InlineAIPanelController a;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.ui.q$a$a, reason: collision with other inner class name */
        public static final class C0110a implements nsb.a {
            public C0110a() {
            }

            @Override // nsb.a
            public final void a(com.ss.android.lark.keyboard.plugin.tool.voice.vote.a r2) {
                Intrinsics.checkNotNullParameter(r2, "dialog");
                Log.i("InlineAIPanelController", "click feedback thumbs down: onDialogShowSuccess");
            }

            @Override // nsb.a
            public final void b(ErrorResult r3) {
                Intrinsics.checkNotNullParameter(r3, "errorResult");
                Log.i("InlineAIPanelController", "click feedback thumbs down: onDialogShowError: " + r3);
            }
        }

        public a(InlineAIPanelController r1) {
            this.a = r1;
        }

        @Override // wlb.b
        public final void a(FeedbackConfig r5) {
            Intrinsics.checkNotNullParameter(r5, "feedbackConfig");
            InlineAIPanel r0 = this.a.O;
            if (r0 == null) goto L9;
            Feedback r1 = r0.getFeedback();
            if (r1 == null) goto L9;
            boolean r2 = true;
            if (r1.getUnlike() != true) goto L9;
        L10:
            if (r2 == false) goto L34;
            DownVoteFeedbackParam.a r3 = new DownVoteFeedbackParam.a();
            String r4 = r5.getAiMessageId();
            String r6 = "";
            if (r4 != null) goto L14;
            r4 = "";
        L14:
            Intrinsics.checkNotNullParameter(r4, "id");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r3.a = r4;
            Intrinsics.checkNotNullParameter(DownVoteFeedbackParam.WorkMode.INLINE, "workMode");
            String r7 = r5.getScenario();
            if (r7 != null) goto L17;
            r7 = "";
        L17:
            Intrinsics.checkNotNullParameter(r7, "scenario");
            String r8 = r5.getRequestRawdata();
            if (r8 != null) goto L20;
            r8 = "";
        L20:
            Intrinsics.checkNotNullParameter(r8, "data");
            String r9 = r5.getAnswerRawdata();
            if (r9 == null) goto L24;
            r6 = r9;
        L24:
            Intrinsics.checkNotNullParameter(r6, "data");
            C0110a r10 = new C0110a();
            Intrinsics.checkNotNullParameter(r10, "callback");
            r3.b = r10;
            Intrinsics.checkNotNullParameter(r3, "builder");
            if (r3.a != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("aiMessageId");
        L28:
            InlineAIPanelController r11 = this.a;
            nsb.b r12 = r11.c;
            if (r12 != null) goto L32;
            Log.w("InlineAIPanelController", "skip showDownVoteFeedback, MyAIApi unavailable, keep unlike state only");
            return;
        L32:
            r11.a.getActivity();
            r12.b();
            return;
        L34:
            return;
        L9:
            r2 = false;
            goto L10
        }
    }

    public q(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        StringBuilder r6 = new StringBuilder("click feedback thumbs down, like = ");
        InlineAIPanel r0 = this.a.O;
        Feedback r1 = null;
        if (r0 == null) goto L7;
        Feedback r2 = r0.getFeedback();
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.getLike());
    L8:
        r6.append(r3);
        r6.append(" like = ");
        InlineAIPanel r4 = this.a.O;
        if (r4 == null) goto L13;
        Feedback r7 = r4.getFeedback();
        if (r7 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r7.getLike());
    L14:
        r6.append(r8);
        Log.i("InlineAIPanelController", r6.toString());
        InlineAIPanel r9 = this.a.O;
        boolean r10 = true;
        if (r9 == null) goto L25;
        Feedback r11 = r9.getFeedback();
        if (r11 == null) goto L25;
        InlineAIPanel r12 = this.a.O;
        if (r12 == null) goto L23;
        Feedback r13 = r12.getFeedback();
        if (r13 == null) goto L23;
        boolean r14 = r13.getUnlike();
    L24:
        r11.setUnlike(!r14);
    L23:
        r14 = false;
    L25:
        InlineAIPanel r15 = this.a.O;
        if (r15 == null) goto L32;
        Feedback r16 = r15.getFeedback();
        if (r16 == null) goto L32;
        if (r16.getUnlike() != true) goto L32;
    L33:
        if (r10 == false) goto L39;
        InlineAIPanel r17 = this.a.O;
        if (r17 == null) goto L39;
        Feedback r18 = r17.getFeedback();
        if (r18 == null) goto L39;
        r18.setLike(false);
    L39:
        InlineAIPanelController r19 = this.a;
        InlineAIPanel r20 = r19.O;
        if (r20 == null) goto L42;
        r1 = r20.getFeedback();
    L42:
        r19.m(r1);
        InlineAIPanelController r21 = this.a;
        r21.b.l(false, new a(r21));
        return;
    L32:
        r10 = false;
    L13:
        r8 = null;
    L7:
        r3 = null;
        goto L8
    }
}
