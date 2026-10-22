package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RewardItemViewBinder extends me.drakeet.multitype.b<m0, RewardItemViewHolder> {
    public final Function0<Unit> b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.view.RewardItemViewBinder$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m359invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m359invoke();
            return Unit.INSTANCE;
        }
    }

    public RewardItemViewBinder(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        RewardItemViewHolder r8 = (RewardItemViewHolder) r6;
        m0 r9 = (m0) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "info");
        r8.a.setText(s1.C(2131917062, new Object[]{r9.g, Integer.valueOf(r9.f), r3.c(), Integer.valueOf(r9.e)}));
        TextView r0 = r8.b;
        String r1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(r9.a));     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        String r2 = r1.substring(11, 16);     // Catch: Exception -> L8
    L9:
        r0.setText(r2);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new x(r8, r9));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L8
    L8:
        r2 = "";
        goto L9
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new RewardItemViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131567099, r5, false), this.b);
    }
}
