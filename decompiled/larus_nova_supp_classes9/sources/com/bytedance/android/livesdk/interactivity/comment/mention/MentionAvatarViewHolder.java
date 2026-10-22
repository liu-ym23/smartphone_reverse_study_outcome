package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MentionAvatarViewHolder extends RecyclerView.ViewHolder {
    public final TransparentCircleIconView a;
    public final ImageView b;
    public final MentionCheckBoxWrapper c;
    public final TextView d;
    public l e;
    public int f;
    public boolean g;
    public final View h;
    public final m i;
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g j;

    public static final class a implements MentionCheckBoxWrapper.a {
        public final /* synthetic */ MentionAvatarViewHolder a;

        public a(MentionAvatarViewHolder r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.mention.MentionCheckBoxWrapper.a
        public final void a(boolean r5) {
            MentionAvatarViewHolder r0 = this.a;
            l r1 = r0.e;
            if (r1 != null) goto L5;
            return;
        L5:
            r1.b = r5;
            if (r5 == false) goto L8;
            r0.a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
            UtilityKotlinExtentionsKt.t(this.a.b);
            this.a.c.c.setVisibility(0);
        L12:
            this.a.i.a(r1, r5);
            return;
        L8:
            r0.c.c.setVisibility(8);
            MentionAvatarViewHolder r2 = this.a;
            if (r2.g == false) goto L11;
            r2.a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
            UtilityKotlinExtentionsKt.w(this.a.b);
            goto L12
        L11:
            r2.a.setCircleRadius(0.0f);
            UtilityKotlinExtentionsKt.t(this.a.b);
            goto L12
        }
    }

    public static final class b {
    }

    static {
    }

    public MentionAvatarViewHolder(View r2, m r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "selectListener");
        Intrinsics.checkNotNullParameter(r4, "bridges");
        super(r2);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.a = r2.findViewById(2131379894);
        this.b = (ImageView) r2.findViewById(2131379893);
        MentionCheckBoxWrapper r5 = new MentionCheckBoxWrapper(r2.findViewById(2131379897));
        this.c = r5;
        this.d = (TextView) r2.findViewById(2131379896);
        this.f = -1;
        a r6 = new a(this);
        Intrinsics.checkNotNullParameter(r6, "checkStateChangeListener");
        ((List) r5.b.getValue()).add(r6);
        r2.setOnClickListener(new AnonymousClass2(this));
    }
}
