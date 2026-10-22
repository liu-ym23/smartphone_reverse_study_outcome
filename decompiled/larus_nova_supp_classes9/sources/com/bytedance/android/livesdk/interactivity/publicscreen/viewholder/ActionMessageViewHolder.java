package com.bytedance.android.livesdk.interactivity.publicscreen.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.bytedance.bdlocation.BuildConfig;
import e52.a;
import g52.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ActionMessageViewHolder extends MessageViewHolder {
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final View e;
    public final View.OnClickListener f;
    public final a g;

    public ActionMessageViewHolder(View r2, MessageListAdapter.a r3, q92.a r4) {
        super(r2);
        this.b = (ImageView) r2.findViewById(2131374718);
        this.c = (ImageView) r2.findViewById(2131384584);
        this.d = (TextView) r2.findViewById(2131367794);
        this.e = r2.findViewById(2131381068);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(f<?> r2, int r3, e r4) {
        if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.entity.a) == true) goto L5;
        return;
    L5:
        this.d.setAlpha(1.0f);
        com.bytedance.android.livesdk.interactivity.api.entity.a r5 = (com.bytedance.android.livesdk.interactivity.api.entity.a) r2;
        r5.M();
        r5.L();
        ImageView r6 = this.b;
        r5.L();
        r6.setImageResource(2131251424);
        r5.O();
        if (TextUtils.isEmpty(r5.N()) == true) goto L8;
        this.d.setText(r5.N());
    L9:
        if (r4 == null) goto L11;
        r4.a(this.d, true);
        e.b(r4, this.b);
        e.b(r4, this.c);
    L11:
        int r7 = l.a(false, r5, this.g);
        l.e(this.e, r7);
        r5.O();
        ((RecyclerView.ViewHolder) this).itemView.setTag(r5);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(this.f);
        return;
    L8:
        this.d.setText(BuildConfig.FLAVOR);
        goto L9
    }
}
