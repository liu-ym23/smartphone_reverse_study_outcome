package com.ss.android.lark.forwardv2.impl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardSendDialogAdapter extends LarkRecyclerViewBaseAdapter<PickedChatViewHolder, SearchBaseInfo> {
    public Context a;
    public a b;

    public static class PickedChatViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int a = 0;

        @BindView(9504)
        public ImageView mAvatar;

        @BindView(9086)
        public LKUIRoundedImageView mThreadIcon;

        public PickedChatViewHolder(View r1) {
            super(r1);
            ButterKnife.bind(this, r1);
        }
    }

    public class PickedChatViewHolder_ViewBinding implements Unbinder {
        public PickedChatViewHolder a;

        public final void unbind() {
            PickedChatViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mAvatar = null;
            r0.mThreadIcon = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public PickedChatViewHolder_ViewBinding(PickedChatViewHolder r4, View r5) {
            this.a = r4;
            r4.mAvatar = (ImageView) Utils.findRequiredViewAsType(r5, 2131382897, "field 'mAvatar'", ImageView.class);
            r4.mThreadIcon = (LKUIRoundedImageView) Utils.findRequiredViewAsType(r5, 2131372256, "field 'mThreadIcon'", LKUIRoundedImageView.class);
        }
    }

    public interface a {
    }

    public ForwardSendDialogAdapter() {
        this.b = null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        PickedChatViewHolder r10 = (PickedChatViewHolder) r8;
        final SearchReplyInThreadInfo r11 = (SearchBaseInfo) getItem(r9);
        boolean r0 = r11 instanceof SearchReplyInThreadInfo;
        LKUIRoundedImageView r1 = r10.mThreadIcon;
        int r2 = 0;
        if (r0 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setBorderColor(r3);
        LKUIRoundedImageView r4 = r10.mThreadIcon;
        if (r0 == false) goto L9;
        float r5 = 0.0f;
    L10:
        r4.setBorderWidthDP(r5);
        LKUIRoundedImageView r6 = r10.mThreadIcon;
        if (r0 == false) goto L13;
    L16:
        r6.setVisibility(r2);
        if (r0 == false) goto L20;
        String r7 = r11.getEntityId();
        r10.mAvatar.setImageResource(2131237551);
        Context r12 = this.a;
        LKUIRoundedImageView r13 = r10.mThreadIcon;
        String r14 = r11.getAvatarKey();
        int r15 = UIHelper.dp2px(40.0f);
        int r16 = UIHelper.dp2px(40.0f);
        LoadParams r17 = new LoadParams();
        r17.a = r15;
        r17.b = r16;
        ImageModule.a(r12, r13, r14, r7, r17);
    L24:
        final a r18 = this.b;
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new mib.a(r18, r11));
        return;
    L20:
        if ((r11 instanceof SearchThreadInfo) == false) goto L22;
        String r19 = ((SearchThreadInfo) r11).getChannel().getId();
    L23:
        Context r20 = this.a;
        ImageView r21 = r10.mAvatar;
        String r22 = r11.getAvatarKey();
        int r23 = UIHelper.dp2px(40.0f);
        int r24 = UIHelper.dp2px(40.0f);
        LoadParams r25 = new LoadParams();
        r25.a = r23;
        r25.b = r24;
        ImageModule.a(r20, r21, r22, r19, r25);
        r10.mThreadIcon.setImageResource(2131235361);
        goto L24
    L22:
        r19 = r11.getId();
        goto L23
    L13:
        if ((r11 instanceof SearchThreadInfo) == true) goto L16;
        r2 = 8;
        goto L16
    L9:
        r5 = 1.5f;
        goto L10
    L5:
        r3 = UIUtils.getColor(this.a, 2131106521);
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        this.a = r3.getContext();
        return new PickedChatViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131559876, r3, false));
    }
}
