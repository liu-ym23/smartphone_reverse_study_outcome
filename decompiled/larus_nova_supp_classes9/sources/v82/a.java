package v82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkExpandViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends me.drakeet.multitype.b<C0289a, MediaAnchorLinkExpandViewHolder> {
    public final MediaAnchorLinkExpandViewHolder.a b;
    public final boolean c;

    /* JADX INFO: renamed from: v82.a$a, reason: collision with other inner class name */
    public static final class C0289a {
        public String a;

        public C0289a() {
        }
    }

    public a(MediaAnchorLinkExpandViewHolder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listenr");
        this.b = r2;
        this.c = false;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        MediaAnchorLinkExpandViewHolder r4 = (MediaAnchorLinkExpandViewHolder) r2;
        C0289a r5 = (C0289a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        String r6 = r5.a;
        r4.a.setText(r6);
        r4.b.setImageResource(2131252614);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new MediaAnchorLinkExpandViewHolder(r4.inflate(2131566324, r5, false), this.b, this.c);
    }
}
