package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j, Object> {

    public static final class a implements QuickCommentView.a {
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;

        public a(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
        public final void a(QuickCommentView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.J();
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
        public final void b(IQuickCommentShowWord r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            TokenCert r0 = b72.a.a;
            if (b72.a.b(this.a.getActivity()) == true) goto L5;
            return;
        L5:
            x22.e r1 = this.a.U();
            if (r1 == null) goto L11;
            CommentWidget r2 = ((CommentWidget.e) r1).a;
            int r4 = CommentWidget.V1;
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r5 = r2.Lq();
            if (r5 == null) goto L11;
            r5.sendQuickComment(r3);
        L11:
            this.a.J();
        }
    }

    public h1() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return InputSectionType.QUICK_COMMENT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        LinkedList<IQuickCommentShowWord> r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        View r2 = LayoutInflater.from(r0).inflate(2131567718, null);
        QuickCommentView r3 = (QuickCommentView) r2.findViewById(2131392578);
        r3.setListener(new a(r5));
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r6 = r5.V();
        if (r6 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r7 = r6.g;
        if (r7 == null) goto L10;
        r1 = r7.o;
    L10:
        if (r1 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
        r3.setQuickComment(r1);
    L18:
        return r2;
    L12:
        if (r1.isEmpty() == true) goto L15;
        r8 = false;
        goto L16
    }
}
