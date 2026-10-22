package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MergeForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>, com.ss.android.lark.chat.base.view.vo.message.c> {
    public final IMMessageKeys$Blocks g;
    public int h;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final TextView b;
        public final LKUILightTextView c;
        public final View d;
        public final View e;

        public final View getView() {
            return this.a;
        }

        public b(View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            this.a = r6;
            TextView r0 = (TextView) r6.findViewById(2131379956);
            this.b = r0;
            LKUILightTextView r1 = r6.findViewById(2131379949);
            this.c = r1;
            this.d = r6.findViewById(2131384813);
            View r2 = r6.findViewById(2131377093);
            this.e = r2;
            Context r7 = r6.getContext();
            r1.setTextSize((int) zz7.b.i(r1.getContext(), LarkFont.BODY1));
            zz7.a.d(r0, LarkFont.TITLE4);
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
            int r5 = zz7.b.g(r7, 4);
            ((ViewGroup.MarginLayoutParams) r4).width = zz7.b.g(r7, 2);
            r4.setMargins(0, r5, 0, r5);
            r2.setLayoutParams(r4);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MergeForwardContentBlock a;
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> b;

        public c(MergeForwardContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            w4b.w r5 = ChatCoreModule.a().getMergeForwardDependnecy();
            m2b.a r0 = this.a.c;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r1 = this.b;
            w4b.u r2 = MessagePermissionUtil.a;
            r5.d(r0, r1);
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> a;
        public final /* synthetic */ MergeForwardContentBlock b;
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r1, MergeForwardContentBlock r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MergeForwardContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.MERGE_FORWARD_CONTENT;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r5, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r6, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_DATA);
        b r8 = (b) r6.c(this.g, IMMessageKeys$Slots.CONTENT, MergeForwardContentBlock$update$blockView$1.INSTANCE);
        pxa.a r0 = r7.b().i;
        if (r0 == null) goto L5;
        r8.b.setText(r0.a);
        r8.c.setMaxLines(4);
        r8.c.setEllipsize(TextUtils.TruncateAt.END);
        LKUILightTextView r2 = r8.c;
        r2.setTextColor(r2.getContext().getResources().getColor(2131106607));
        r8.c.setTextSize((int) UIHelper.sp2px(14.0f));
        r8.c.setContentText(r0.b);
    L5:
        r8.d.setOnClickListener(new c(this, r7));
        r8.d.setOnLongClickListener(new d(r5, this, r7));
        r8.d.setBackground(null);
        if (r7.d() == false) goto L8;
        this.h = v2c.a.a(getContext(), 12.0f);
    L9:
        View r9 = r8.d;
        int r10 = this.h;
        r9.setPadding(r10, r10, r10, r10);
        int r11 = v2c.a.b(getContext(), 2131106622);
        int r12 = v2c.a.b(getContext(), 2131106607);
        r8.b.setTextColor(r11);
        r8.c.setTextColor(r12);
        return;
    L8:
        this.h = 0;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r1, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r3) {
        update2(r1, r2, r3);
    }
}
