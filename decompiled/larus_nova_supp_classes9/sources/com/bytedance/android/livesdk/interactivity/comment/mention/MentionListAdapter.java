package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionAvatarViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MentionListAdapter extends RecyclerView.Adapter<MentionAvatarViewHolder> {
    public List<l> a;
    public final m b;
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g c;

    public final int getItemCount() {
        List<l> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public MentionListAdapter(MentionSectionController.c r2, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedListener");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        this.b = r2;
        this.c = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        MentionAvatarViewHolder r9 = (MentionAvatarViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        List<l> r0 = this.a;
        if (r0 == null) goto L50;
        l r1 = (l) ListProtector.get(r0, r8);
        if (r1 == null) goto L51;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "data");
        r9.e = r1;
        r9.f = r8;
        ImageLoader.bindAvatar(r9.a, r1.a.getAvatarThumbKt(), UtilityKotlinExtentionsKt.i(56), UtilityKotlinExtentionsKt.i(56));
        IBaseUser r10 = r1.a;
        String r2 = null;
        if ((r10 instanceof IUser) == true) goto L10;
        r10 = null;
    L10:
        IUser r11 = (IUser) r10;
        if (r11 == null) goto L34;
        List<String> r3 = r1.c;
        if (r3 != null) goto L16;
    L17:
        String r4 = r11.getIdString();
        IMiddlewareUserService r5 = jc1.k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L24;
        IBaseUser r13 = r6.b();
        if (r13 == null) goto L24;
        String r14 = r13.getIdString();
    L26:
        if (Intrinsics.areEqual(r4, r14) == false) goto L31;
    L27:
        r9.g = true;
        r9.a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
        r9.b.setBackgroundResource(2131249520);
        r9.b.setImageResource(2131251886);
        if (r1.b == true) goto L30;
        UtilityKotlinExtentionsKt.w(r9.b);
        goto L34
    L30:
        UtilityKotlinExtentionsKt.t(r9.b);
        goto L34
    L31:
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        String r15 = r11.getCastSecUid();
        if (r15 == null) goto L34;
        TTMiddlewareLiveSDK.hostMiddlewareService().user().observeAndUpdateActiveStatusBySecUid(r9.j.T(), r9.b, r15, new a(r9));
    L24:
        r14 = null;
        goto L26
    L16:
        if (r3.contains("anchor") == true) goto L27;
    L34:
        MentionCheckBoxWrapper r16 = r9.c;
        boolean r17 = r1.b;
        if (r17 == r16.a) goto L40;
        r16.a = r17;
        Iterator r18 = ((List) r16.b.getValue()).iterator();
    L38:
        if (r18.hasNext() == false) goto L40;
        ((MentionCheckBoxWrapper.a) r18.next()).a(r17);
    L40:
        TextView r19 = r9.d;
        String r20 = r1.a.getNickName();
        if (r20 != null) goto L43;
    L47:
        r19.setText(r2);
        return;
    L43:
        if (r20.length() <= 6) goto L46;
        r20 = r20.subSequence(0, 6) + "...";
    L46:
        r2 = r20;
        goto L47
    L51:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new MentionAvatarViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567715, null), this.b, this.c);
    }
}
