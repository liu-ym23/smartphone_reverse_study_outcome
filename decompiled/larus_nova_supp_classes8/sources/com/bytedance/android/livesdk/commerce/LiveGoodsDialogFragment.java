package com.bytedance.android.livesdk.commerce;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolderType;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.utils.V3Utils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Deprecated(message = "instead by com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomPromotionListFragment")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/LiveGoodsDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsDialogFragment extends LiveDialogFragment {
    public long d;
    public long e;
    public TextView f;
    public RecyclerView g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveGoodsDialogFragment a;

        public b(LiveGoodsDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LiveGoodsDialogFragment a;

        public c(LiveGoodsDialogFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L5;
        L13:
            TextView r6 = this.a.f;
            if (r6 == null) goto L19;
            r6.setVisibility(8);
            return;
        L19:
            return;
        L5:
            if (r5.intValue() <= 0) goto L13;
            TextView r0 = this.a.f;
            if (r0 == null) goto L10;
            r0.setVisibility(0);
        L10:
            TextView r1 = this.a.f;
            if (r1 == null) goto L17;
            r1.setText(s1.C(2131919983, new Object[]{r5}));
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ Ref.ObjectRef a;

        public d(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            NetworkStat r3 = (NetworkStat) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3 != NetworkStat.LOADING) goto L8;
            ((LoadingStatusView) this.a.element).showLoading();
            return;
        L8:
            ((LoadingStatusView) this.a.element).setVisibility(8);
        }
    }

    public static final class e extends SimpleViewHolderType<com.bytedance.android.livesdk.commerce.d, Object> {
        public final /* synthetic */ LiveGoodsDialogFragment a;

        public final int getLayoutResId() {
            return 2131566322;
        }

        public e(LiveGoodsDialogFragment r1) {
            this.a = r1;
        }

        public final boolean match(Object r1) {
            return r1 instanceof com.bytedance.android.livesdk.commerce.d;
        }

        public final void unBind(SimpleViewHolder r5, Object r6) {
            com.bytedance.android.livesdk.commerce.d r7 = (com.bytedance.android.livesdk.commerce.d) r6;
            Intrinsics.checkNotNullParameter(r5, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r7, "data");
            if ((System.currentTimeMillis() - r5.getLong("start_time")) <= 100) goto L6;
            String r8 = V3Utils.TYPE.access$000(V3Utils.TYPE.SHOW);
            HashMap r0 = new HashMap();
            r0.put("event_type", r8);
            r0.put("event_belong", "");
            r0.put("event_page", "");
            r0.put("room_id", String.valueOf(this.a.e));
            r0.put("anchor_id", String.valueOf(this.a.d));
            r0.put("commodity_id", r7.e());
            TTLiveSDKContext.getHostService().f().logV3("hotsoonlive_commodity_show", r0);
            return;
        }

        public final void bind(SimpleViewHolder r3, Object r4, int r5) {
            com.bytedance.android.livesdk.commerce.d r6 = (com.bytedance.android.livesdk.commerce.d) r4;
            Intrinsics.checkNotNullParameter(r3, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r6, "data");
            r3.setText(2131388772, r6.g());
            r3.setText(2131382999, String.valueOf(r6.d() / 100));
            if (TextUtils.isEmpty(r6.c()) == true) goto L5;
            r3.setText(2131379535, r6.c());
        L6:
            int r7 = r6.d() % 100;
            StringBuilder r0 = new StringBuilder();
            if (r7 <= 10) goto L9;
            String r1 = ".";
        L10:
            r0.append(r1);
            r0.append(r7);
            r3.setText(2131383000, r0.toString());
            r3.setText(2131385079, s1.C(2131919985, new Object[]{Integer.valueOf(r6.f())}));
            ImageUtil.loadImage((ImageView) r3.getView(2131368133), r6.a());
            ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new com.bytedance.android.livesdk.commerce.f(this, r6));
            r3.put("start_time", Long.valueOf(System.currentTimeMillis()));
            return;
        L9:
            r1 = ".0";
            goto L10
        L5:
            r3.hide(2131379535);
            goto L6
        }
    }

    public static final class f extends SimpleViewHolderType<com.bytedance.android.livesdk.commerce.e, Object> {
        public final /* synthetic */ LiveGoodsViewModel a;

        public final int getLayoutResId() {
            return 2131566323;
        }

        public f(LiveGoodsViewModel r1) {
            this.a = r1;
        }

        public final boolean match(Object r1) {
            return r1 instanceof com.bytedance.android.livesdk.commerce.e;
        }

        public final void bind(SimpleViewHolder r2, Object r3, int r4) {
            com.bytedance.android.livesdk.commerce.e r5 = (com.bytedance.android.livesdk.commerce.e) r3;
            Intrinsics.checkNotNullParameter(r2, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r5, "data");
            r2.setText(2131388367, r5.b());
            r2.setOnClickListener(2131368777, new g(this, r5));
        }
    }

    static {
    }

    public LiveGoodsDialogFragment() {
        setNoTitleAndCancelOutside(true);
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setLayout(-1, -2);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(1, 2131954638);
        setCancelable(true);
        Bundle r4 = getArguments();
        if (r4 == null) goto L13;
        this.d = r4.getLong("user_id");
        this.e = r4.getLong("room_id");
        return;
    L13:
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L15;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        if (r5 == null) goto L7;
        Window r0 = r5.getWindow();
        if (r0 == null) goto L7;
        r0.setGravity(80);
        r0.setLayout(-1, -2);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setSoftInputMode(3);
        r0.clearFlags(2);
    L7:
        return r5;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        r4.findViewById(2131366972).setOnClickListener(new b(this));
        this.f = (TextView) r4.findViewById(2131368004);
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r4.findViewById(2131387318);
        RecyclerView r7 = r4.findViewById(2131378057);
        this.g = r7;
        if (r7 == null) goto L5;
        r7.setLayoutManager(new SSLinearLayoutManager(getActivity(), 1));
    L5:
        LiveGoodsViewModel r8 = ViewModelProviders.of(this).get(LiveGoodsViewModel.class);
        r8.getTotalNum().observe(this, new c(this));
        r8.refreshStat().observe(this, new d(r6));
        r8.setUserId(this.d).addViewHolderType(new e(this)).addViewHolderType(new f(r8)).bind(this.g).load();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565474, r3, false);
    }
}
