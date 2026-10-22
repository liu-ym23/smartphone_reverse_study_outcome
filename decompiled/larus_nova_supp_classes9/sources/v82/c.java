package v82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkTitleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends me.drakeet.multitype.b<a, MediaAnchorLinkTitleViewHolder> {

    public static final class a {
        public String a;

        public a() {
        }
    }

    public c() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        MediaAnchorLinkTitleViewHolder r4 = (MediaAnchorLinkTitleViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        String r6 = r5.a;
        r4.a.setText(r6);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new MediaAnchorLinkTitleViewHolder(r4.inflate(2131566325, r5, false));
    }
}
