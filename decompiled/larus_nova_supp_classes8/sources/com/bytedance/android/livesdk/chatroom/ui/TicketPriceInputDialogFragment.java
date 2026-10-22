package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "b", "RecommendPriceAdapter", "RecommendPriceTagViewHolder", "RecommendPriceViewHolder", "c", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketPriceInputDialogFragment extends DialogFragment {
    public View d;
    public View e;
    public EditText f;
    public RecyclerView g;
    public String h;
    public List<String> i;
    public b j;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final List<String> a;
        public final TicketPriceInputDialogFragment b;

        public static final class a {
        }

        static {
        }

        public final int getItemCount() {
            List<String> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getItemViewType(int r2) {
            List<String> r0 = this.a;
            if (r0 == null) goto L5;
            String r3 = (String) ListProtector.get(r0, r2);
        L7:
            return !TextUtils.equals(r3, "recommend_price_tag") ? 1 : 0;
        L5:
            r3 = null;
            goto L7
        }

        public RecommendPriceAdapter(List<String> r1, TicketPriceInputDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            String r1 = null;
            if ((r3 instanceof RecommendPriceViewHolder) == true) goto L5;
            r3 = null;
        L5:
            RecommendPriceViewHolder r5 = (RecommendPriceViewHolder) r3;
            if (r5 == null) goto L12;
            List<String> r0 = this.a;
            if (r0 == null) goto L10;
            r1 = (String) ListProtector.get(r0, r4);
        L10:
            r5.a.setText(r1);
            ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(r5);
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != 0) goto L6;
            return new RecommendPriceTagViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567274, r3, false));
        L6:
            return new RecommendPriceViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567275, r3, false), this.b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceTagViewHolder extends RecyclerView.ViewHolder {
        public RecommendPriceTagViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView a;
        public final TicketPriceInputDialogFragment b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r0 = new Pair[3];
            r0[0] = TuplesKt.to("enter_from_merge", "direct_shoot");
            r0[1] = TuplesKt.to("live_type", "video_live");
            CharSequence r1 = this.a.getText();
            String r4 = null;
            if (r1 == null) goto L5;
            String r2 = r1.toString();
        L6:
            r0[2] = TuplesKt.to("price", r2);
            r8.sendLog("livesdk_paidlive_activity_price_filling_shortcut_panel_click", MapsKt.mapOf(r0), new Object[]{Room.class});
            TicketPriceInputDialogFragment r9 = this.b;
            if (r9 == null) goto L13;
            CharSequence r3 = this.a.getText();
            if (r3 == null) goto L11;
            r4 = r3.toString();
        L11:
            r9.T90(r4, true);
            return;
        L13:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public RecommendPriceViewHolder(View r2, TicketPriceInputDialogFragment r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.b = r3;
            this.a = (TextView) r2.findViewById(2131382997);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        void f(String r1, boolean r2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$c;", "", "", "initialValue", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "AmountList", "Ljava/util/List;", "a", "()Ljava/util/List;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("amount_list")
        private final List<String> AmountList;

        @SerializedName("initial_value")
        private final String initialValue;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.initialValue, r4.initialValue) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.AmountList, r4.AmountList) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.initialValue;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.AmountList;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TicketPriceMethodParams(initialValue=" + this.initialValue + ", AmountList=" + this.AmountList + ")";
        }

        public c() {
            this.initialValue = null;
            this.AmountList = null;
        }

        public final List<String> a() {
            return this.AmountList;
        }

        public final String b() {
            return this.initialValue;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ TicketPriceInputDialogFragment a;

        public d(TicketPriceInputDialogFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r0 = this.a.f;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.requestFocus();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        EditText r0 = this.f;
        if (r0 == null) goto L6;
        r0.postDelayed(new d(this), 100);
        return;
    }

    public TicketPriceInputDialogFragment() {
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void onCreate(Bundle r3) {
        setStyle(0, 2131954652);
        super.onCreate(r3);
    }

    public final Dialog onCreateDialog(Bundle r7) {
        Dialog r8 = super.onCreateDialog(r7);
        r8.setCanceledOnTouchOutside(false);
        Window r1 = r8.getWindow();
        if (r1 == null) goto L7;
        r1.setGravity(80);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setSoftInputMode(3);
        r1.addFlags(32);
        r1.clearFlags(2);
        int r2 = Build.VERSION.SDK_INT;
        r1.clearFlags(67108864);
        View r3 = S90(r1);
        com.bytedance.android.live.core.utils.statusbar.a.a r4 = com.bytedance.android.live.core.utils.statusbar.a.b;
        r4.a();
        r4.a();
        r3.setSystemUiVisibility(1280);
        r4.a();
        r1.addFlags(Integer.MIN_VALUE);
        r1.setStatusBarColor(0);
        if (r2 < 23) goto L7;
        S90(r1).setSystemUiVisibility(S90(r1).getSystemUiVisibility() | DeviceInfoAndroid.BUFFER_SIZE);
    L7:
        return r8;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        b r3 = this.j;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.a();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void T90(String r2, boolean r3) {
        b r0 = this.j;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
    L6:
        if (this.f != null) goto L8;
        i40.h.a("hide key board return, edit text view null");
    L16:
        dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L18;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L18:
        return;
    L8:
        com.bytedance.android.livesdk.utils.t2.a(getContext(), this.f);
        goto L16
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = LayoutInflater.from(getContext()).inflate(2131567513, r4, false);
        r6.setLayoutParams(new FrameLayout.LayoutParams(com.bytedance.android.live.core.utils.x1.h(), com.bytedance.android.live.core.utils.x1.g()));
        this.d = r6.findViewById(2131371607);
        this.e = r6.findViewById(2131375372);
        EditText r7 = (EditText) r6.findViewById(2131371463);
        this.f = r7;
        String r8 = this.h;
        if (r8 == null) goto L13;
        if (r7 == null) goto L6;
        r7.setText(r8);
    L6:
        EditText r9 = this.f;
        if (r9 == null) goto L13;
        Editable r10 = r9.getText();
        if (r10 == null) goto L11;
        int r11 = r10.length();
    L12:
        r9.setSelection(r11);
        goto L13
    L11:
        r11 = 0;
    L13:
        EditText r12 = this.f;
        if (r12 == null) goto L16;
        r12.setOnFocusChangeListener(new m9(this));
    L16:
        this.g = r6.findViewById(2131383954);
        View r13 = this.e;
        if (r13 == null) goto L19;
        r13.setOnClickListener(new n9(this));
    L19:
        View r14 = this.d;
        if (r14 == null) goto L22;
        r14.setOnClickListener(new o9(this));
    L22:
        RecyclerView r15 = this.g;
        if (r15 == null) goto L25;
        r15.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L25:
        RecyclerView r16 = this.g;
        if (r16 == null) goto L28;
        r16.setAdapter(new RecommendPriceAdapter(this.i, this));
    L28:
        setCancelable(true);
        return r6;
    }
}
