package bp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ext.ExtShareUserViewHolder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends me.drakeet.multitype.b<d, ExtShareUserViewHolder> {
    public DataCenter b;

    public e() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        ExtShareUserViewHolder r6 = (ExtShareUserViewHolder) r4;
        d r7 = (d) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        DataCenter r0 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        r6.a = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131371982);
        r6.b = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131371981);
        r6.c = (TextView) ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131371984);
        ImageModel r1 = r7.b;
        if (r1 == null) goto L5;
        ImageLoader.bindImage(r6.a, r1);
    L11:
        if (r7.e == false) goto L15;
        View r2 = r6.b;
        if (r2 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r2);
    L18:
        TextView r3 = r6.c;
        if (r3 == null) goto L21;
        r3.setText(r7.c);
    L21:
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new g(r7, r0));
        return;
    L15:
        View r8 = r6.b;
        if (r8 == null) goto L18;
        UtilityKotlinExtentionsKt.u(r8);
        goto L18
    L5:
        Integer r9 = r7.g;
        if (r9 == null) goto L11;
        int r10 = r9.intValue();
        HSImageView r11 = r6.a;
        if (r11 == null) goto L11;
        r11.setImageResource(r10);
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ExtShareUserViewHolder(r3.inflate(2131566994, r4, false));
    }
}
