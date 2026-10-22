package com.ss.android.lark.message.vote.message;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.message.vote.VoteCardOptionsAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.g;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoteMessageCell implements r5b.d<VoteContentVO>, u5b.a<VoteContentVO> {
    public static final int b = 0;
    public com.ss.android.lark.message.vote.c a;

    public static class VoteMessageViewHolder {
        public trb.b a;
        public trb.a b;

        @BindView(9018)
        public TextView mActionBtn;

        @BindView(9034)
        public TextView mActualParticipantNumberTv;

        @BindView(9896)
        public TextView mNumberOfParticipantsTv;

        @BindView(9915)
        public RecyclerView mOptionsRv;

        @BindView(10168)
        public TextView mSelectType;

        @BindView(10338)
        public View mTitleLayout;

        @BindView(10342)
        public TextView mTitleTv;

        @BindView(10513)
        public View mVoteIcon;

        public final TextView a() {
            return this.mActionBtn;
        }

        public final TextView b() {
            return this.mActualParticipantNumberTv;
        }

        public final TextView c() {
            return this.mNumberOfParticipantsTv;
        }

        public final RecyclerView d() {
            return this.mOptionsRv;
        }

        public final TextView e() {
            return this.mSelectType;
        }

        public final View f() {
            return this.mTitleLayout;
        }

        public final TextView g() {
            return this.mTitleTv;
        }

        public final trb.a h() {
            return this.b;
        }

        public final trb.b i() {
            return this.a;
        }

        public VoteMessageViewHolder(View r3) {
            ButterKnife.bind(this, r3);
            TextView r4 = this.mSelectType;
            LarkFont r0 = LarkFont.CAPTION0;
            zz7.a.d(r4, r0);
            zz7.a.d(this.mTitleTv, LarkFont.HEADLINE);
            zz7.a.d(this.mNumberOfParticipantsTv, r0);
            zz7.a.d(this.mActualParticipantNumberTv, r0);
            zz7.a.d(this.mActionBtn, LarkFont.BODY2);
            zz7.a.a(this.mVoteIcon, 16);
            ViewGroup.LayoutParams r5 = this.mActionBtn.getLayoutParams();
            r5.height = zz7.b.g(this.mActionBtn.getContext(), 32);
            this.mActionBtn.setLayoutParams(r5);
        }
    }

    public class VoteMessageViewHolder_ViewBinding implements Unbinder {
        public VoteMessageViewHolder a;

        public final void unbind() {
            VoteMessageViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mTitleLayout = null;
            r0.mTitleTv = null;
            r0.mVoteIcon = null;
            r0.mSelectType = null;
            r0.mOptionsRv = null;
            r0.mNumberOfParticipantsTv = null;
            r0.mActualParticipantNumberTv = null;
            r0.mActionBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public VoteMessageViewHolder_ViewBinding(VoteMessageViewHolder r4, View r5) {
            this.a = r4;
            r4.mTitleLayout = Utils.findRequiredView(r5, 2131388881, "field 'mTitleLayout'");
            r4.mTitleTv = (TextView) Utils.findRequiredViewAsType(r5, 2131388920, "field 'mTitleTv'", TextView.class);
            r4.mVoteIcon = Utils.findRequiredView(r5, 2131392798, "field 'mVoteIcon'");
            r4.mSelectType = (TextView) Utils.findRequiredViewAsType(r5, 2131385821, "field 'mSelectType'", TextView.class);
            r4.mOptionsRv = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131381608, "field 'mOptionsRv'", RecyclerView.class);
            r4.mNumberOfParticipantsTv = (TextView) Utils.findRequiredViewAsType(r5, 2131381101, "field 'mNumberOfParticipantsTv'", TextView.class);
            r4.mActualParticipantNumberTv = (TextView) Utils.findRequiredViewAsType(r5, 2131362196, "field 'mActualParticipantNumberTv'", TextView.class);
            r4.mActionBtn = (TextView) Utils.findRequiredViewAsType(r5, 2131362061, "field 'mActionBtn'", TextView.class);
        }
    }

    public class a implements qrb.a {
        public final /* synthetic */ VoteMessageViewHolder a;
        public final /* synthetic */ VoteMessageCell b;

        public final void a(irb.b r17) {
            com.ss.android.lark.message.vote.c r8 = this.b.a;
            VoteMessageViewHolder r1 = this.a;
            r8.getClass();
            if (r1 == null) goto L40;
            if (r17 == null) goto L43;
            List<irb.a> r2 = r17.c;
            if (CollectionUtils.isEmpty(r2) == true) goto L44;
            TextView r3 = r1.g();
            TextView r4 = r1.e();
            View r5 = r1.f();
            RecyclerView r6 = r1.d();
            DefaultItemAnimator r9 = r6.getItemAnimator();
            if ((r9 instanceof DefaultItemAnimator) == false) goto L12;
            r9.setSupportsChangeAnimations(false);
            r9.setAddDuration(0);
            r9.setChangeDuration(0);
            r9.setMoveDuration(0);
            r9.setRemoveDuration(0);
        L12:
            TextView r10 = r1.c();
            TextView r11 = r1.b();
            trb.b r12 = r1.i();
            trb.a r13 = r1.h();
            TextView r14 = r1.a();
            if (r8.b == false) goto L19;
            r5.setVisibility(0);
            r3.setText((CharSequence) ListProtector.get(r17.a, 0));
            if (r17.b <= 1) goto L17;
            String r7 = UIUtils.getString(r8.a, 2131892002);
        L18:
            r4.setText(r7);
        L21:
            if (r8.c == false) goto L27;
            r6.setVisibility(0);
            if (r6.getAdapter() != null) goto L25;
            VoteCardOptionsAdapter r15 = new VoteCardOptionsAdapter(r8.a);
            r6.setLayoutManager(new LinearLayoutManager(r8.a, 1, false));
            r6.setAdapter(r15);
        L26:
            r15.resetAll(r2);
            r15.b = r17.b;
            r15.d = new com.ss.android.lark.message.vote.b(r8, r17, r14);
            r15.g = r13;
        L28:
            r14.setVisibility(0);
            r14.setEnabled(false);
            r14.setOnClickListener(new trb.d(r8, r14, r12, r17, r15));
            if (TextUtils.isEmpty(r17.d) == false) goto L31;
            r14.setVisibility(8);
        L33:
            if (r8.d == true) goto L35;
            r11.setVisibility(8);
            r10.setVisibility(8);
            return;
        L35:
            if (TextUtils.isEmpty(r17.d) == false) goto L37;
            r11.setVisibility(0);
            r11.setText(((String) ListProtector.get(r17.a, 1)) + ((String) ListProtector.get(r17.a, 2)));
            r10.setVisibility(0);
            r10.setText(((String) ListProtector.get(r17.a, 3)) + ((String) ListProtector.get(r17.a, 4)));
            return;
        L37:
            r11.setVisibility(8);
            r10.setVisibility(8);
            return;
        L31:
            r14.setVisibility(0);
            r14.setText((CharSequence) ListProtector.get(r17.a, 1));
            r14.setTextColor(UIUtils.getColor(r8.a, 2131106620));
            goto L33
        L25:
            r15 = (VoteCardOptionsAdapter) r6.getAdapter();
            goto L26
        L27:
            r15 = new VoteCardOptionsAdapter(r8.a);
            r6.setVisibility(8);
            goto L28
        L17:
            r7 = UIUtils.getString(r8.a, 2131892229);
            goto L18
        L19:
            r5.setVisibility(8);
            goto L21
        L44:
            return;
        L43:
            return;
        }

        public a(VoteMessageCell r1, VoteMessageViewHolder r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public VoteMessageCell() {
    }

    public final void f(View r1) {
    }

    public final u5b.c i(v5b.c<VoteContentVO> r1) {
        return null;
    }

    static {
        b = UIHelper.dp2px(12.0f);
    }

    public final Class c() {
        return VoteContentVO.class;
    }

    public final View a(LayoutInflater r3, ViewGroup r4) {
        if (this.a != null) goto L6;
        com.ss.android.lark.message.vote.c.a r1 = new com.ss.android.lark.message.vote.c.a(r3.getContext());
        r1.b = true;
        r1.c = true;
        r1.d = true;
        this.a = new com.ss.android.lark.message.vote.c(r1);
    L6:
        return r3.inflate(2131568213, r4, false);
    }

    public final BubbleStyle d(v5b.c<VoteContentVO> r3, View r4) {
        BubbleStyle.a(112, r4.findViewById(2131388881), new int[]{0, 0, 0, b});
        return BubbleStyle.h;
    }

    public final void e(View r2, int r3, v5b.c<VoteContentVO> r4) {
        VoteContentVO r5 = (VoteContentVO) r4.b();
        if (r5 != null) goto L5;
        return;
    L5:
        if (((RichText) r5.b.getValue()) == null) goto L16;
        VoteMessageViewHolder r0 = (VoteMessageViewHolder) r2.getTag();
        if (r0 != null) goto L10;
        r0 = new VoteMessageViewHolder(r2);
        r2.setTag(r0);
    L10:
        r0.a = new com.ss.android.lark.message.vote.message.a(this, r4);
        r0.b = new b(r4);
        trb.c r6 = new trb.c((RichText) r5.b.getValue(), new a(this, r0));
        RichText r7 = r6.a;
        if (r7 == null) goto L17;
        g.b(r7, r6.d);
        return;
    L17:
        return;
    }
}
