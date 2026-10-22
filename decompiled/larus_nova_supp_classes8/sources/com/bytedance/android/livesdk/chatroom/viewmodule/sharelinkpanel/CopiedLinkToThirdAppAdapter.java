package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.x0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppHolder;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CopiedLinkToThirdAppAdapter extends RecyclerView.Adapter<CopiedLinkToThirdAppHolder> {
    public ArrayList<l> a;
    public Function1<? super l, Unit> b;

    public final int getItemCount() {
        return this.a.size();
    }

    public CopiedLinkToThirdAppAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        CopiedLinkToThirdAppHolder r5 = (CopiedLinkToThirdAppHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        final l r6 = (l) CollectionsKt.getOrNull(this.a, r4);
        if (r6 == null) goto L12;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        ImageView r0 = r5.a;
        if (r0 == null) goto L7;
        r0.setImageResource(r6.c());
    L7:
        TextView r1 = r5.b;
        if (r1 == null) goto L10;
        r1.setText(r6.e());
    L10:
        r5.c.setOnClickListener(x0.a(new AnonymousClass1(this, r6)));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new CopiedLinkToThirdAppHolder(LayoutInflater.from(r3.getContext()).inflate(2131567451, r3, false));
    }
}
