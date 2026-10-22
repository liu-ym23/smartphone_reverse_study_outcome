package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.api.FrequentChatApi;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatSubPanelSource;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.m;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FrequentChatPresenter extends q46.b<a> implements FrequentChatListAdapter.b, FrequentChatSecondaryFragment.b, t62.a {
    public final CompositeDisposable b;
    public final List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> c;
    public final FrequentChatListAdapter d;
    public final ItemTouchHelper e;
    public final com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c f;
    public FrequentChatShowMode g;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g h;
    public String i;
    public long j;
    public boolean k;

    public interface a extends q46.a {
        void Cg();

        void Ih();

        void iP();
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FrequentChatPresenter a;

        public b(FrequentChatPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Response r10 = (Response) r9;
            if (((BaseResponse) r10).statusCode != 0) goto L31;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d r11 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d) ((BaseResponse) r10).data;
            List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b> r0 = r11.a();
            if (r0 == null) goto L28;
            int r1 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a;
            Intrinsics.checkNotNullParameter(r0, "chatDataList");
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r0.iterator();
        L8:
            if (r3.hasNext() == false) goto L17;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b r4 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b) r3.next();
            if (r4.a() == 0) goto L8;
            if (TextUtils.isEmpty(r4.b()) == true) goto L8;
            String r5 = r4.b();
            if (r5 != null) goto L16;
            r5 = BuildConfig.FLAVOR;
        L16:
            r2.add(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r5, r4.a(), 1));
            goto L8
        L17:
            ((ArrayList) this.a.c).clear();
            ((ArrayList) this.a.c).addAll(r2);
            FrequentChatPresenter r6 = this.a;
            if (r6.g != FrequentChatShowMode.READ) goto L20;
            ((ArrayList) r6.c).add(r6.f);
        L20:
            this.a.d.notifyDataSetChanged();
            this.a.j = RangesKt.coerceAtLeast(r11.b(), r2.size());
            a r13 = (a) ((q46.b) this.a).a;
            if (r13 == null) goto L23;
            r13.Ih();
        L23:
            int r14 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r15 = this.a.h;
            if (r15 == null) goto L26;
            Boolean r16 = Boolean.valueOf(r15.k0());
        L27:
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_panel_show", r16, MapsKt.mapOf(TuplesKt.to("common_comment_num", String.valueOf(this.a.c0()))));
            return;
        L26:
            r16 = null;
            goto L27
        L28:
            a r17 = (a) ((q46.b) this.a).a;
            if (r17 == null) goto L41;
            r17.iP();
            return;
        L41:
            return;
        L31:
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.b("query", r10);
            ((a) ((q46.b) this.a).a).iP();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FrequentChatPresenter a;

        public c(FrequentChatPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a((Throwable) r3, "query", BuildConfig.FLAVOR);
            ((a) ((q46.b) this.a).a).iP();
        }
    }

    public final void d0() {
        this.k = false;
        FrequentChatApi.a.getClass();
        FrequentChatApi r0 = FrequentChatApi.a.a();
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.h;
        if (r1 == null) goto L7;
        long r2 = r1.Z();
    L8:
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d>> r3 = r0.queryFrequentChatList(r2);
        if (r3 == null) goto L17;
        Observable r4 = r3.compose(RxUtil.rxSchedulerHelper());
        if (r4 == null) goto L18;
        Disposable r5 = r4.subscribe(new b(this), new c(this));
        if (r5 == null) goto L19;
        RxUtilKt.c(r5, this.b);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.h = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void R() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = this.h;
        if (r7 != null) goto L5;
        return;
    L5:
        FrequentChatSecondaryFragment r8 = new FrequentChatSecondaryFragment(r7, this, FrequentChatSubPanelSource.ADD, -1, BuildConfig.FLAVOR);
        r7.o0(InputDialogFragmentSwitchType.NONE, r8);
        int r0 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_add", Boolean.valueOf(r7.k0()), null);
    }

    public final int c0() {
        FrequentChatShowMode r0 = this.g;
        int r1 = f.b[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    L14:
        return ((ArrayList) this.c).size();
    L13:
        return ((ArrayList) this.c).size() - 1;
    }

    public final void f0() {
        FrequentChatShowMode r0 = this.g;
        int r1 = f.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        a r2 = (a) ((q46.b) this).a;
        if (r2 == null) goto L32;
        r2.Ih();
        return;
    L32:
        return;
    L5:
        if (r1 == 2) goto L8;
        return;
    L8:
        if (this.k == true) goto L34;
        String r3 = CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, FrequentChatPresenter$trySaveSortResult$sortedSeq$1.INSTANCE, 30, null);
        FrequentChatApi.a.getClass();
        FrequentChatApi r4 = FrequentChatApi.a.a();
        if (r4 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.h;
        if (r5 == null) goto L15;
        long r6 = r5.Z();
    L16:
        Observable<Response<Object>> r7 = r4.sortFrequentChatList(r6, r3);
        if (r7 == null) goto L28;
        Observable r8 = r7.compose(RxUtil.rxSchedulerHelper());
        if (r8 == null) goto L29;
        Disposable r9 = r8.subscribe(new i(this, r3), new j(this));
        if (r9 == null) goto L30;
        RxUtilKt.c(r9, this.b);
        this.k = true;
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r6 = 0;
        goto L16
    L27:
        return;
    }

    public FrequentChatPresenter() {
        this.b = new CompositeDisposable();
        ArrayList r0 = new ArrayList();
        this.c = r0;
        this.d = new FrequentChatListAdapter(r0, this);
        this.e = new ItemTouchHelper(new FrequentChatDragCallback(this));
        this.f = new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(BuildConfig.FLAVOR, -1, 2);
        this.g = FrequentChatShowMode.READ;
        this.i = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final boolean j() {
        if (c0() < this.j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final FrequentChatShowMode L() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final boolean S() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final long o() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final boolean F(String r7) {
        Intrinsics.checkNotNullParameter(r7, "content");
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r4 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) r1;
        if (r4.getType() == 1) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
    L14:
        if (r1 == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        if (Intrinsics.areEqual(r4.a, r7) == false) goto L10;
        r5 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void O(FrequentChatViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.e.startDrag(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void U(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r10) {
        Intrinsics.checkNotNullParameter(r10, "chatItem");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        FrequentChatSecondaryFragment r8 = new FrequentChatSecondaryFragment(r0, this, FrequentChatSubPanelSource.EDIT, r10.b, r10.a);
        r0.o0(InputDialogFragmentSwitchType.NONE, r8);
        int r11 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_button_click", Boolean.valueOf(r0.k0()), null);
    }

    public final void e0(FrequentChatShowMode r13) {
        Intrinsics.checkNotNullParameter(r13, "newMode");
        if (this.g == r13) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L40;
        this.g = r13;
        if (r13 != FrequentChatShowMode.READ) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r1 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) CollectionsKt.lastOrNull(this.c);
        if (r1 != null) goto L12;
    L13:
        ((ArrayList) this.c).add(this.f);
    L20:
        if (r13 != FrequentChatShowMode.SORT) goto L22;
        this.i = CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, FrequentChatPresenter$setShowMode$1.INSTANCE, 30, null);
    L22:
        this.d.notifyDataSetChanged();
        int r14 = f.c[r13.ordinal()];
        if (r14 == 1) goto L31;
        if (r14 != 2) goto L26;
        String r15 = "livesdk_common_comment_rank_status_enter";
    L32:
        if (r15 == null) goto L41;
        int r2 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.h;
        if (r3 == null) goto L37;
        Boolean r4 = Boolean.valueOf(r3.k0());
    L38:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a(r15, r4, null);
        return;
    L37:
        r4 = null;
        goto L38
    L41:
        return;
    L26:
        if (r14 != 3) goto L29;
        r15 = "livesdk_common_comment_edit_status_enter";
        goto L32
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        r15 = null;
        goto L32
    L12:
        if (r1.getType() == 2) goto L20;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r5 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) CollectionsKt.lastOrNull(this.c);
        if (r5 == null) goto L20;
        if (r5.getType() != 2) goto L20;
        List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r6 = this.c;
        ListProtector.remove(r6, ((ArrayList) r6).size() - 1);
        goto L20
    L40:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void p(boolean r1) {
        this.k = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void u(final com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.h;
        if (r0 == null) goto L23;
        Context r1 = r0.getContext();
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.k == false) goto L10;
        return;
    L10:
        int r2 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.h;
        if (r3 == null) goto L13;
        Boolean r4 = Boolean.valueOf(r3.k0());
    L14:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_delete_button_click", r4, null);
        m r6 = new m(r1, new FrequentChatPresenter$showRemoveConfirmDialog$cancelOperation$1(this), new FrequentChatPresenter$showRemoveConfirmDialog$confirmOperation$1(this, r5));
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L13:
        r4 = null;
        goto L14
    }

    @Override // t62.a
    public final void J(int r2, int r3) {
        Collections.swap(this.c, r2, r3);
        this.d.notifyItemMoved(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void g(long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = c0();
        ListProtector.add(this.c, r0, new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r7, r5, 1));
        this.d.notifyItemInserted(r0);
        this.d.notifyItemChanged(((ArrayList) this.c).size() - 1);
        a r6 = (a) ((q46.b) this).a;
        if (r6 == null) goto L6;
        r6.Ih();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void k(CharSequence r8, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r9) {
        Intrinsics.checkNotNullParameter(r8, "content");
        Intrinsics.checkNotNullParameter(r9, "item");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        EditText r1 = r0.a;
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.getSelectionStart();
        r0.d = 11;     // Catch: Exception -> L15
        int r5 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a;     // Catch: Exception -> L15
        int r6 = LivePortraitInputDialogV3.L;     // Catch: Exception -> L15
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a(r1, r8, LivePortraitInputDialogV3.a.a(), false);     // Catch: Exception -> L15
        int r3 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;     // Catch: Exception -> L15
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = this.h;     // Catch: Exception -> L15
        if (r7 == null) goto L12;
        Boolean r10 = Boolean.valueOf(r7.k0());     // Catch: Exception -> L15
    L13:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_click", r10, MapsKt.mapOf(TuplesKt.to("common_comment_id", r9.toString())));     // Catch: Exception -> L15
        return;
    L12:
        r10 = null;
    L15:
        e = move-exception;
        r0.d = 0;
        SafetyGuard.a(null, e, "input frequent comment failed,startpos:" + r2 + "，content:" + r8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void n(long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, "newContent");
        Iterator r0 = ((ArrayList) this.c).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) r0.next()).b != r8) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 >= 0) goto L15;
        return;
    L15:
        if (r2 >= ((ArrayList) this.c).size()) goto L22;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r9 = new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r10, ((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.c, r2)).b, 1);
        ListProtector.set(this.c, r2, r9);
        this.d.notifyItemChanged(r2);
        return;
    L22:
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }
}
