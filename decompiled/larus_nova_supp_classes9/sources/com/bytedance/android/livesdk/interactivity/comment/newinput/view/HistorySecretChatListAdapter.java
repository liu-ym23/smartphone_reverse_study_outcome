package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.c;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb2.d;
import yb2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/HistorySecretChatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/HistorySecretChatListAdapter$SecretChatItemViewHolder;", "<init>", "()V", "SecretChatItemViewHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistorySecretChatListAdapter extends RecyclerView.Adapter<SecretChatItemViewHolder> {
    public final List<n> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/HistorySecretChatListAdapter$SecretChatItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SecretChatItemViewHolder extends RecyclerView.ViewHolder {
        public final RoundCornerImageView a;
        public final TextView b;
        public final TextView c;
        public final int d;
        public final float e;
        public final a f;

        public SecretChatItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131363623);
            this.b = (TextView) r2.findViewById(2131380897);
            this.c = (TextView) r2.findViewById(2131388414);
            this.d = s1.f(18.0f);
            this.e = 14.0f;
            a r3 = w.a();
            r3.d = -1;
            r3.a = -1;
            Unit r0 = Unit.INSTANCE;
            this.f = r3;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public HistorySecretChatListAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        SecretChatItemViewHolder r9 = (SecretChatItemViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        n r10 = (n) ListProtector.get(this.a, r8);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "data");
        User r0 = r10.b();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L6;
        String r2 = r0.getNickName();
        if (r2 == null) goto L6;
    L7:
        User r3 = r10.b();
        if (r3 == null) goto L10;
        ImageModel r4 = r3.getAvatarThumb();
    L11:
        String r5 = r10.a();
        if (r5 == null) goto L15;
        r1 = r5;
    L15:
        User r11 = r10.b();
        if (r11 == null) goto L18;
        String r13 = r11.getCastSecUid();
    L19:
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L26;
        e r14 = r6.user();
        if (r14 == null) goto L26;
        IBaseUser r15 = r14.b();
        if (r15 == null) goto L26;
        Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
        String r16 = r15.getCastSecUid();
    L27:
        boolean r17 = Intrinsics.areEqual(r13, r16);
        d r18 = new d();
        r18.c(c.f(r1));
        r18.b = r9.f;
        TextView r19 = r9.b;
        if (r19 == null) goto L31;
        r19.setText(r2);
    L31:
        if ((r4 instanceof ImageModel) == true) goto L33;
        r4 = null;
    L33:
        ImageLoader.bindImage(r9.a, r4);
        RoundCornerImageView r20 = r9.a;
        if (r20 == null) goto L36;
        r20.setImportantForAccessibility(1);
        r20.setFocusable(true);
        r3.c(r20, r2.concat("头像"), true);
    L36:
        SpannableString r21 = qb2.c.c(r18, null);
        if (r17 == false) goto L41;
        TextView r23 = r9.c;
        if (r23 == null) goto L44;
        r23.setBackgroundResource(2131250205);
    L44:
        TextView r24 = r9.c;
        if (r24 == null) goto L47;
        r24.setTextSize(1, r9.e);
    L47:
        TextView r25 = r9.c;
        if (r25 == null) goto L51;
        ab2.a.e(r21, r9.d);
        r25.setText(r21);
        return;
    L51:
        return;
    L41:
        TextView r26 = r9.c;
        if (r26 == null) goto L44;
        r26.setBackgroundResource(2131250204);
    L26:
        r16 = null;
        goto L27
    L18:
        r13 = null;
        goto L19
    L10:
        r4 = null;
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new SecretChatItemViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567428, r3, false));
    }
}
