package erb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public i() {
    }

    public final void a(com.ss.android.lark.mention.base.impl.atselector.bean.a r3, RecyclerView.ViewHolder r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r4;
        r5.profileInfoCard.setVisibility(0);
        r5.profileInfoCard.setOnClickListener(new g(r3, r5));
    }

    public final void b(com.ss.android.lark.mention.base.impl.atselector.bean.a r2, RecyclerView.ViewHolder r3) {
        AtSelectableViewHolder r4 = (AtSelectableViewHolder) r3;
        r4.profileInfoCard.setVisibility(8);
        r4.profileInfoCard.setOnClickListener(null);
    }

    public final void e(com.ss.android.lark.mention.base.impl.atselector.bean.a r3, RecyclerView.ViewHolder r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r4;
        Drawable r6 = arb.a.b.e0(r5.mCustomStatus.getContext(), r3.r);
        if (r6 == null) goto L5;
        r5.mCustomStatus.setVisibility(0);
        r5.mCustomStatus.setImageDrawable(r6);
        return;
    L5:
        r5.mCustomStatus.setVisibility(8);
    }

    public final void g(com.ss.android.lark.mention.base.impl.atselector.bean.a r10, RecyclerView.ViewHolder r11) {
        AtSelectableViewHolder r12 = (AtSelectableViewHolder) r11;
        Context r0 = ((RecyclerView.ViewHolder) r12).itemView.getContext();
        com.ss.android.lark.usersetting.service.e r1 = com.ss.android.lark.usersetting.service.e.a.a;
        long r2 = r10.n;
        r1.getClass();
        int r3 = dac.c.c;
        dac.c.b.a.getClass();
        if (r2 != 0) goto L6;
    L8:
        boolean r4 = false;
    L9:
        boolean r5 = r10.o;
        boolean r6 = r10.t;
        boolean r7 = r10.u;
        boolean r8 = true ^ r10.p.isEmpty();
        if (r6 == true) goto L16;
        if (r7 == true) goto L16;
        if (r4 == true) goto L16;
        if (r5 == true) goto L16;
        if (r8 == true) goto L16;
    L18:
        LarkNameTag.d r9 = new LarkNameTag.d(r0);
        r9.x = r4;
        r9.r = r6;
        r9.s = r7;
        TagData r13 = r10.s;
        if (r13 == null) goto L21;
        r9.g(TagData.parse(r13));
    L21:
        TagInfo.apply(r9, r10.p, com.ss.android.lark.chat.entity.chatter.c.b);
        r9.f().c(r12.mTagWrapper);
        return;
    L16:
        if (r10.b() == true) goto L18;
        r12.mTagWrapper.setVisibility(0);
        goto L18
    L6:
        if (r2 <= cac.b.a.a.a(30000)) goto L8;
        r4 = true;
        goto L9
    }

    public final void h(com.ss.android.lark.mention.base.impl.atselector.bean.a r12, RecyclerView.ViewHolder r13) {
        AtSelectableViewHolder r14 = (AtSelectableViewHolder) r13;
        ChatterDescription r0 = r12.h;
        if (TextUtils.isEmpty(r0.description) == true) goto L5;
    L7:
        r14.mUserStatus.setVisibility(0);
        Context r1 = r14.mUserStatus.getContext();
        hpc.b r3 = hpc.b.b();
        r0.type.getNumber();
        r3.getClass();
        Drawable r7 = UIUtils.getDrawable(r1, 2131238071);
        if (TextUtils.isEmpty(r12.a) == true) goto L14;
        long r2 = r0.descriptionId;
        if (r2 <= 0) goto L12;
        Long r10 = Long.valueOf(r2);
    L13:
        r14.mUserStatus.setNeedToRecognize(true);
        r14.mUserStatus.b(r0.description, r12.a, r7, false, "profile_sign", r10);
        return;
    L12:
        r10 = null;
        goto L13
    L14:
        r14.mUserStatus.setNeedToRecognize(false);
        UserStatusLinearLayout r15 = r14.mUserStatus;
        String r16 = r0.description;
        r15.a.setImageDrawable(r7);
        r15.b.G(r16, null);
        r15.c = r16;
        return;
    L5:
        if (r0.type != ChatterDescription.Type.DEFAULT) goto L7;
        r14.mUserStatus.setVisibility(8);
    }

    public final void i(com.ss.android.lark.mention.base.impl.atselector.bean.a r3, RecyclerView.ViewHolder r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r4;
        WorkStatus r6 = r3.m;
        if (WorkStatus.isInvalid(r6) == false) goto L5;
        r5.mWorkStatus.setVisibility(8);
        return;
    L5:
        r5.mWorkStatus.setVisibility(0);
        TextView r7 = r5.mWorkStatus;
        r7.setText(r6.getDisplayTextNoDuration(r7.getContext()));
    }

    public final void c(BaseAtBean r2, RecyclerView.ViewHolder r3, IItemContainer r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r3;
        h r0 = new h(r4, r2);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(r0);
        r5.mAtSelectCheckBox.setOnClickListener(r0);
    }

    public final void d(BaseAtBean r2, RecyclerView.ViewHolder r3, int r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r3;
        if (r4 != 0) goto L5;
        r5.mAtSelectCheckBox.setVisibility(8);
        return;
    L5:
        r5.mAtSelectCheckBox.setVisibility(0);
        r5.mAtSelectCheckBox.setChecked(r2.isSelected());
    }

    public final void f(RecyclerView.ViewHolder r4, int r5, List r6, int r7) {
        AtSelectableViewHolder r8 = (AtSelectableViewHolder) r4;
        int r9 = r5 - 1;
        if (r7 != r9) goto L5;
        r8.mDividerView.setVisibility(8);
        return;
    L5:
        if (r7 >= r9) goto L22;
        if (r7 <= 0) goto L23;
        BaseAtBean r10 = (BaseAtBean) ListProtector.get(r6, r7 + 1);
        BaseAtBean r11 = (BaseAtBean) ListProtector.get(r6, r7);
        if (r10.getType() != 3) goto L10;
    L19:
        r8.mDividerView.setVisibility(8);
        return;
    L10:
        if (r10.getType() == 1) goto L19;
        if (r10.getType() == 0) goto L15;
        r8.mDividerView.setVisibility(0);
        return;
    L15:
        if (((GroupMemAtBean) r10).getChatterInfo().l.charAt(0) == ((GroupMemAtBean) r11).getChatterInfo().l.charAt(0)) goto L17;
        r8.mDividerView.setVisibility(8);
        return;
    L17:
        r8.mDividerView.setVisibility(0);
        return;
    L23:
        return;
    }
}
