package w62;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.model.k;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoFooterViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends me.drakeet.multitype.b<k, LiveVideoCommentSearchVideoFooterViewHolder> {
    public c() {
    }

    public final void e(RecyclerView.ViewHolder r3) {
        LiveVideoCommentSearchVideoFooterViewHolder r4 = (LiveVideoCommentSearchVideoFooterViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L6;
        r4.a.b();
        return;
    }

    public final void f(RecyclerView.ViewHolder r3) {
        LiveVideoCommentSearchVideoFooterViewHolder r4 = (LiveVideoCommentSearchVideoFooterViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L6;
        r4.a.c();
        return;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        LiveVideoCommentSearchVideoFooterViewHolder r4 = (LiveVideoCommentSearchVideoFooterViewHolder) r2;
        k r5 = (k) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        UtilityKotlinExtentionsKt.t(r4.a);
        UtilityKotlinExtentionsKt.t(r4.b);
        int r6 = r5.a;
        r4.c = r6;
        if (r6 != 1) goto L6;
        UtilityKotlinExtentionsKt.w(r4.a);
    L6:
        if (r4.c != 2) goto L9;
        UtilityKotlinExtentionsKt.w(r4.b);
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LiveVideoCommentSearchVideoFooterViewHolder(r3.inflate(2131567579, r4, false));
    }
}
