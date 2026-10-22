package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.api.FrequentChatApi;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatSubPanelSource;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/view/FrequentChatSecondaryFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/input/AbsLiveInputSecondaryFragment;", "a", "b", "c", "d", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatSecondaryFragment extends AbsLiveInputSecondaryFragment {
    public static final /* synthetic */ int D = 0;
    public final FrequentChatSubPanelSource A;
    public final long B;
    public final String C;
    public final CompositeDisposable d;
    public GradientEditText e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public View k;
    public View l;
    public FrameLayout m;
    public View n;
    public View o;
    public View p;
    public FrameLayout q;
    public final List<String> r;
    public int s;
    public int t;
    public final int u;
    public final e v;
    public final FrequentChatSecondaryFragment$textWatcher$1 w;
    public final boolean x;
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g y;
    public final b z;

    public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0114a implements View.OnClickListener {
            public final /* synthetic */ a a;
            public final /* synthetic */ TextView b;

            public ViewOnClickListenerC0114a(a r1, TextView r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                GradientEditText r5 = this.a.a.e;
                if (r5 != null) goto L5;
                return;
            L5:
                int r0 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a;
                com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a(r5, this.b.getText(), com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a, true);
                int r6 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
                com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_recommend_click", Boolean.valueOf(this.a.a.y.k0()), null);
            }
        }

        public final int getItemCount() {
            return ((ArrayList) this.a.r).size();
        }

        public a(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            TextView r0 = (TextView) r3.itemView.findViewById(2131383861);
            r0.setText((CharSequence) ListProtector.get(this.a.r, r4));
            r3.itemView.setOnClickListener(new ViewOnClickListenerC0114a(this, r0));
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return new d(LayoutInflater.from(r3.getContext()).inflate(2131567824, r3, false));
        }
    }

    public interface b {
        boolean F(String r1);

        boolean S();

        void g(long r1, String r3);

        void n(long r1, String r3);

        void p(boolean r1);
    }

    public static final class c {
    }

    public final class d extends RecyclerView.ViewHolder {
        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class e implements i40.c {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public e(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        public final void X6(boolean r3, int r4) {
            View r0 = this.a.j;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3 == false) goto L10;
            if (r4 >= ((s1.w() * 2) / 3)) goto L10;
            this.a.s = r4;
        L10:
            if (r0.isSelected() == false) goto L28;
            if (r3 == true) goto L31;
            FrequentChatSecondaryFragment r5 = this.a;
            FrameLayout r6 = r5.m;
            if (r6 == null) goto L19;
            int r1 = r5.s;
            if (r1 > 0) goto L18;
            r1 = r5.y.W();
        L18:
            a1.k(r6, r1);
        L19:
            FrameLayout r7 = r5.m;
            if (r7 == null) goto L22;
            UtilityKotlinExtentionsKt.w(r7);
        L22:
            View r8 = r5.k;
            if (r8 == null) goto L25;
            UtilityKotlinExtentionsKt.w(r8);
        L25:
            View r9 = r5.o;
            if (r9 == null) goto L31;
            UtilityKotlinExtentionsKt.t(r9);
        L31:
            this.a.ba0();
            return;
        L28:
            if (r3 == false) goto L30;
            this.a.Z90();
            goto L31
        L30:
            this.a.ca0();
            goto L31
        }
    }

    public static final class f implements View.OnFocusChangeListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ FrequentChatSecondaryFragment b;

        public static final class a implements Runnable {
            public final /* synthetic */ f a;

            public a(f r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            L19:
                return;
            L3:
                if (this.a.b.isAdded() == false) goto L15;
                FragmentActivity r0 = this.a.b.getActivity();     // Catch: Throwable -> L12
                if (r0 == null) goto L10;
                Window r1 = r0.getWindow();     // Catch: Throwable -> L12
                if (r1 == null) goto L10;
                r1.setSoftInputMode(48);     // Catch: Throwable -> L12
            L10:
                FrequentChatSecondaryFragment.Y90(this.a.b);     // Catch: Throwable -> L12
                this.a.b.ba0();     // Catch: Throwable -> L12
                return;
            }
        }

        public f(GradientEditText r1, FrequentChatSecondaryFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            r3.postDelayed(new a(this), 100);
            this.a.setOnFocusChangeListener(null);
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ EditText a;

        public g(GradientEditText r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestFocus();     // Catch: Throwable -> L4 Exception -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            ALogger.e("InputPanelV3", e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public h(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            GradientEditText r3 = this.a.e;     // Catch: Exception -> L7
            if (r3 == null) goto L5;
            r3.requestFocus();     // Catch: Exception -> L7
        L5:
            FrequentChatSecondaryFragment.Y90(this.a);     // Catch: Exception -> L7
            this.a.Z90();     // Catch: Exception -> L7
            this.a.ba0();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            ALogger.e("InputPanelV3", e);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public i(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            FrequentChatSecondaryFragment r3 = this.a;
            int r0 = FrequentChatSecondaryFragment.D;
            r3.Z90();
            this.a.ba0();
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public j(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (r2.isSelected() == false) goto L5;
            r2.setSelected(false);
            FrequentChatSecondaryFragment.Y90(this.a);
            return;
        L5:
            r2.setSelected(true);
            FrequentChatSecondaryFragment r3 = this.a;
            int r0 = FrequentChatSecondaryFragment.D;
            r3.da0();
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public k(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View r3 = this.a.j;
            if (r3 != null) goto L5;
        L6:
            this.a.da0();
            return;
        L5:
            if (r3.isSelected() != true) goto L6;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ FrequentChatSecondaryFragment a;

        public AnonymousClass4(FrequentChatSecondaryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (FrequentChatSecondaryFragment.V90(this.a) == false) goto L16;
            Context r6 = this.a.y.getContext();
            if (r6 != null) goto L8;
            return;
        L8:
            if (this.a.z.S() == false) goto L10;
            return;
        L10:
            l r1 = new l(r6, new FrequentChatSecondaryFragment$onViewCreated$4$confirmDialog$1(this), new FrequentChatSecondaryFragment$onViewCreated$4$confirmDialog$2(this));
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r1);
        L15:
            int r7 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_cancel_popup_show", Boolean.valueOf(this.a.y.k0()), MapsKt.mapOf(TuplesKt.to("edit_status", FrequentChatSecondaryFragment.W90(this.a))));
        L17:
            int r8 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_panel_click", Boolean.valueOf(this.a.y.k0()), MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "cancel"), TuplesKt.to("edit_status", FrequentChatSecondaryFragment.W90(this.a))}));
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L14:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
            goto L15
        L16:
            FrequentChatSecondaryFragment.U90(this.a);
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final int T90() {
        int r0 = this.u;
        View r1 = this.k;
        int r2 = 0;
        if (r1 != null) goto L5;
    L10:
        Integer r3 = 0;
    L11:
        if (r3 == null) goto L13;
        r2 = r3.intValue();
    L13:
        int r4 = r0 + r2;
        int r5 = this.s;
        if (r5 > 0) goto L18;
        r5 = this.y.W();
    L18:
        return r4 + r5;
    L5:
        if (r1.getVisibility() != 0) goto L10;
        View r6 = this.k;
        if (r6 == null) goto L9;
        r3 = Integer.valueOf(r6.getHeight());
        goto L11
    L9:
        r3 = null;
        goto L11
    }

    public final void Z90() {
        FrameLayout r0 = this.m;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        View r1 = this.o;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r1);
    L8:
        View r2 = this.k;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r2);
    L11:
        View r3 = this.j;
        if (r3 == null) goto L15;
        r3.setSelected(false);
        return;
    }

    public final void ca0() {
        View r0 = this.o;
        if (r0 == null) goto L9;
        int r1 = this.s;
        if (r1 > 0) goto L8;
        r1 = this.y.W();
    L8:
        a1.k(r0, r1);
    L9:
        View r2 = this.j;
        if (r2 == null) goto L12;
        r2.setSelected(false);
    L12:
        View r3 = this.k;
        if (r3 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r3);
    L15:
        FrameLayout r4 = this.m;
        if (r4 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r4);
    L18:
        View r5 = this.o;
        if (r5 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    }

    public final void da0() {
        Context r0 = this.y.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        GradientEditText r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        t2.a(r0, r1);
    }

    public final void ba0() {
        xs2.b.a().post(new i1(T90(), true));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.A != FrequentChatSubPanelSource.ADD) goto L5;
        ca0();
        ba0();
    L8:
        MeasureLinearLayout r0 = this.y.a0();
        if (r0 == null) goto L14;
        i40.b r1 = r0.getKeyBoardObservable();
        if (r1 == null) goto L15;
        r1.b(this.v);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        Z90();
        GradientEditText r2 = this.e;
        if (r2 == null) goto L8;
        r2.post(new g(r2));
        r2.setOnFocusChangeListener(new f(r2, this));
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final boolean S90() {
        return this.x;
    }

    public static final void U90(FrequentChatSecondaryFragment r2) {
        MeasureLinearLayout r0 = r2.y.a0();
        if (r0 == null) goto L9;
        i40.b r1 = r0.getKeyBoardObservable();
        if (r1 == null) goto L9;
        e r3 = r2.v;
        List r4 = r1.b;
        if (r4 == null) goto L9;
        ((ArrayList) r4).remove(r3);
    L9:
        r2.da0();
        r2.y.G(InputDialogFragmentSwitchType.NONE, r2);
    }

    public static final boolean V90(FrequentChatSecondaryFragment r4) {
        GradientEditText r0 = r4.e;
        if (r0 == null) goto L18;
        Editable r1 = r0.getText();
        if (r1 != null) goto L8;
        return false;
    L8:
        if ((!Intrinsics.areEqual(r4.C, r1.toString())) == true) goto L10;
        return false;
    L10:
        if (r4.A == FrequentChatSubPanelSource.EDIT) goto L12;
    L16:
        return true;
    L12:
        if (r1.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L16;
        return false;
    L14:
        r5 = false;
        goto L15
    L18:
        return false;
    }

    public static final String W90(FrequentChatSecondaryFragment r1) {
        FrequentChatSubPanelSource r2 = r1.A;
        int r3 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.c[r2.ordinal()];
        if (r3 != 1) goto L5;
        return "first";
    L5:
        if (r3 != 2) goto L8;
        return "revise";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final void X90(final FrequentChatSecondaryFragment r5) {
        GradientEditText r0 = r5.e;
        if (r0 == null) goto L24;
        Editable r1 = r0.getText();
        if (r1 == null) goto L25;
        final String r2 = r1.toString();
        if (r2 == null) goto L28;
        Context r3 = r5.y.getContext();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r5.z.F(r2) == false) goto L19;
        n r4 = new n(r3, new FrequentChatSecondaryFragment$trySaveChatContent$1(r5), new FrequentChatSecondaryFragment$trySaveChatContent$2(r5, r2));
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L18:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L19:
        r5.aa0(r2);
        return;
    L28:
        return;
    L25:
        return;
    }

    public static final void Y90(FrequentChatSecondaryFragment r1) {
        Context r0 = r1.y.getContext();
        if (r0 == null) goto L10;
        GradientEditText r2 = r1.e;
        if (r2 == null) goto L11;
        t2.b(r0, r2);
        return;
    L11:
        return;
    }

    public final void aa0(String r9) {
        FrequentChatSubPanelSource r0 = this.A;
        int r1 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        FrequentChatApi.a.getClass();
        FrequentChatApi r2 = FrequentChatApi.a.a();
        if (r2 == null) goto L31;
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.a>> r3 = r2.addFrequentChat(this.y.Z(), r9);
        if (r3 == null) goto L32;
        Observable r4 = r3.compose(RxUtil.rxSchedulerHelper());
        if (r4 == null) goto L33;
        Disposable r10 = r4.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.h(this, r9), new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.i(this));
        if (r10 == null) goto L34;
        RxUtilKt.c(r10, this.d);
        this.z.p(true);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        if (r1 != 2) goto L35;
        FrequentChatApi.a.getClass();
        FrequentChatApi r5 = FrequentChatApi.a.a();
        if (r5 == null) goto L26;
        Observable<Response<Object>> r6 = r5.updateFrequentChat(this.y.Z(), this.B, r9);
        if (r6 == null) goto L27;
        Observable r7 = r6.compose(RxUtil.rxSchedulerHelper());
        if (r7 == null) goto L28;
        Disposable r11 = r7.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.j(this, r9), new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.k(this));
        if (r11 == null) goto L29;
        RxUtilKt.c(r11, this.d);
        this.z.p(true);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        FrequentChatSubPanelSource r4 = this.A;
        int r5 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = 2131897053;
    L10:
        TextView r7 = this.g;
        if (r7 == null) goto L14;
        r7.setText(s1.B(r6));
    L14:
        if (this.A != FrequentChatSubPanelSource.EDIT) goto L18;
        GradientEditText r8 = this.e;
        if (r8 == null) goto L18;
        r8.setText(this.C);
        r8.setSelection(r8.length());
    L18:
        FrameLayout r9 = this.q;
        if (r9 == null) goto L21;
        r9.setOnClickListener(new h(this));
    L21:
        GradientEditText r10 = this.e;
        if (r10 == null) goto L24;
        r10.setOnClickListener(new i(this));
    L24:
        TextView r11 = this.i;
        if (r11 == null) goto L27;
        r11.setOnClickListener(new AnonymousClass4(this));
    L27:
        View r13 = this.j;
        if (r13 == null) goto L30;
        r13.setOnClickListener(new j(this));
    L30:
        View r14 = this.l;
        if (r14 == null) goto L34;
        r14.setOnClickListener(new k(this));
        return;
    L34:
        return;
    L5:
        if (r5 != 2) goto L8;
        r6 = 2131897054;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131566193, r14, false);
        FrameLayout r17 = (FrameLayout) r16.findViewById(2131371464);
        this.q = r17;
        this.i = (TextView) r16.findViewById(2131365114);
        this.h = (TextView) r16.findViewById(2131385084);
        this.g = (TextView) r16.findViewById(2131388772);
        int r18 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a;
        Context r19 = this.y.getContext();
        FrequentChatSecondaryFragment$textWatcher$1 r1 = this.w;
        Intrinsics.checkNotNullParameter(r17, "inputContainer");
        GradientEditText r110 = ((IExpressionService) jc1.k.n(IExpressionService.class)).createEmojiEditText(r19, com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 48;
        r110.setLayoutParams(r2);
        r110.setImeOptions(268435460);
        r110.setInputType(1);
        r110.setLineSpacing(s1.f(3.0f), r110.getLineSpacingMultiplier());
        r110.setTextAlignment(5);
        r110.setInputType(131072);
        r110.setSingleLine(false);
        r110.setTextColor(s1.h(2131107788));
        r110.setTextSize(1, 15.0f);
        r110.setPadding(0, 0, 0, 0);
        r110.setHorizontallyScrolling(false);
        r110.setOnEditorActionListener(com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.c.a);
        Context r3 = null;
        r110.setBackground(null);
        Field r4 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L5
        r4.setAccessible(true);     // Catch: Exception -> L5
        r4.set(r110, 2131250389);     // Catch: Exception -> L5
    L7:
        r110.addTextChangedListener(r1);
        r110.setHintTextColor(s1.h(2131107021));
        r110.setHint(2131897038);
        r17.addView(r110);
        this.e = r110;
        FrameLayout r111 = (FrameLayout) r16.findViewById(2131371539);
        this.m = r111;
        Context r112 = this.y.getContext();
        if (r112 == null) goto L11;
        r111.addView(((IExpressionService) jc1.k.n(IExpressionService.class)).createExpressionPanelV3(r112, new com.bytedance.android.livesdk.interactivity.api.expression.a(true, false, false, false, false, new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.e(this))));
    L11:
        this.j = r16.findViewById(2131371540);
        this.l = r16.findViewById(2131374339);
        this.k = r16.findViewById(2131371541);
        this.n = r16.findViewById(2131364404);
        this.o = r16.findViewById(2131383927);
        RecyclerView r113 = r16.findViewById(2131383928);
        if (this.A != FrequentChatSubPanelSource.ADD) goto L27;
        if (r113 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.y;
        if (r5 == null) goto L18;
        r3 = r5.getContext();
    L18:
        r113.setLayoutManager(new LinearLayoutManager(r3, 1, false));
        r113.addItemDecoration(new SpaceItemDecoration(1, s1.f(12.0f), true));
        r113.setAdapter(new a(this));
        FrequentChatApi.a.getClass();
        FrequentChatApi r114 = FrequentChatApi.a.a();
        if (r114 == null) goto L27;
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.e>> r115 = r114.getRecommendChat(this.y.Z());
        if (r115 == null) goto L27;
        Observable r116 = r115.compose(RxUtil.rxSchedulerHelper());
        if (r116 == null) goto L27;
        Disposable r117 = r116.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.f(this, r113), com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.g.a);
        if (r117 == null) goto L27;
        RxUtilKt.c(r117, this.d);
    L27:
        this.p = r16.findViewById(2131383929);
        this.f = r16;
        return r16;
    L5:
        e = move-exception;
        i40.h.b("V3 emoji key board mCursorDrawableRes", e);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$textWatcher$1] */
    public FrequentChatSecondaryFragment(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2, b r3, FrequentChatSubPanelSource r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r2, "panelBridge");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "originSource");
        Intrinsics.checkNotNullParameter(r7, "originContent");
        this.y = r2;
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.C = r7;
        this.d = new CompositeDisposable();
        this.r = new ArrayList();
        this.u = UtilityKotlinExtentionsKt.i(144);
        this.v = new e(this);
        this.w = new FrequentChatSecondaryFragment$textWatcher$1(this);
        this.x = true;
    }
}
