package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DLPBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public long h;

    public static final class a implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final TextView b;

        public final View getView() {
            return this.a;
        }

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            TextView r3 = (TextView) r2.findViewById(2131388367);
            this.b = r3;
            zz7.a.d(r3, LarkFont.CAPTION0);
        }
    }

    public static final class b {
    }

    public static final class c extends OnSingleClickListener {
        public final /* synthetic */ DLPBlock a;
        public final /* synthetic */ y6b.a<?> b;

        public final void onSingleClick(View r8) {
            DLPBlock r9 = this.a;
            y6b.a<?> r0 = this.b;
            r9.getClass();
            ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).i(new o4c.b(FileBizDomain.FileBizDomainIM, new o4c.a(r0.getId(), r0.getcId(), r0.g(), r0.getChatId())));
        }

        public c(DLPBlock r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public DLPBlock(com.ss.android.lark.blueprint.g r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r3);
        this.g = IMMessageKeys$Blocks.DLP;
        this.h = -1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r12, com.ss.android.lark.blueprint.q<y6b.a<?>> r13, y6b.a<?> r14) {
        Intrinsics.checkNotNullParameter(r12, "cell");
        Intrinsics.checkNotNullParameter(r13, "layout");
        Intrinsics.checkNotNullParameter(r14, Keys.API_RETURN_KEY_DATA);
        boolean r0 = true;
        if (r14.h() == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r15 == true) goto L11;
        g(r13, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L11:
        a r16 = (a) r13.c(this.g, IMMessageKeys$Slots.BOTTOM, new DLPBlock$update$blockView$1(this));
        MessageSecurityESCReviewExtra r17 = r14.v();
        if (r17 == null) goto L30;
        String r18 = r17.getTipText();
        if (r18 == null) goto L30;
        MessageSecurityESCReviewExtra r2 = r14.v();
        if (r2 == null) goto L30;
        String r8 = r2.getSubmitText();
        if (r8 == null) goto L30;
        MessageSecurityESCReviewExtra r3 = r14.v();
        if (r3 == null) goto L30;
        String r9 = r3.getFeedBackUrl();
        if (r9 == null) goto L30;
        int r10 = StringsKt.indexOf$default(r18, "{SubmitFeedback}", 0, false, 6, null);
        if (r10 == (-1)) goto L30;
        String r19 = StringsKt.replace$default(r18, "{SubmitFeedback}", r8, false, 4, null);
        SpannableString r4 = new SpannableString(r19 + 8203);
        r4.setSpan(new ForegroundColorSpan(UIUtils.getColor(this.c.getContext(), 2131102080)), 0, r19.length(), 33);
        r4.setSpan(new j(this, r9), r10, r8.length() + r10, 33);
        r16.b.setText(r4);
        r16.b.setMovementMethod(LinkMovementMethod.getInstance());
    L31:
        if (r0 == true) goto L34;
        r16.a.setOnClickListener(new c(this, r14));
        return;
    L34:
        return;
    L30:
        r0 = false;
        goto L31
    L5:
        if (MessageDLPState.BLOCK != r14.t()) goto L7;
        r15 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
