package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.pk.PkSwitchMultiSelectPkView;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorPersonalPkLaunchDialogV2;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPersonalPkLaunchDialogV2 extends LinkCommonDialogFragment {
    public Map<Integer, View> e;
    public final Lazy f;
    public String g;
    public u h;
    public boolean i;
    public final CompositeDisposable j;
    public final p21.e k;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchDialogV2 a;

        public a(MultiAnchorPersonalPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            u r6 = (u) r5;
            MultiAnchorPersonalPkLaunchDialogV2 r0 = this.a;
            r0.h = r6;
            PkSwitchMultiSelectPkView r1 = (PkSwitchMultiSelectPkView) r0.S90(2131362913);
            if (r6 == null) goto L6;
            List<com.bytedance.android.livesdk.link.model.p> r7 = r6.a;
            if (r7 == null) goto L6;
        L7:
            com.bytedance.android.livesdk.revenue.service.room.c r2 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
            if (r2 == null) goto L10;
            DataCenter r3 = r2.getDataCenter();
        L11:
            r1.update(r7, r3);
            MultiAnchorPersonalPkLaunchDialogV2 r8 = this.a;
            u r4 = r8.h;
            if (r4 == null) goto L16;
            List<com.bytedance.android.livesdk.link.model.p> r9 = r4.a;
            if (r9 == null) goto L16;
            int r10 = r9.size();
        L18:
            if (r10 <= 2) goto L20;
            boolean r12 = true;
        L21:
            r8.i = r12;
            u r13 = r8.h;
            if (r13 == null) goto L25;
            List r14 = r13.a;
            if (r14 == null) goto L25;
        L26:
            Iterator r15 = r14.iterator();
        L28:
            if (r15.hasNext() == false) goto L33;
            if (((com.bytedance.android.livesdk.link.model.p) r15.next()).getStatus() == 2) goto L28;
            r8.i = false;
            goto L28
        L33:
            if (r8.i == false) goto L35;
            ((TextView) r8.S90(2131387228)).setBackgroundResource(2131249697);
            return;
        L35:
            ((TextView) r8.S90(2131387228)).setBackgroundResource(2131249980);
            return;
        L25:
            r14 = new ArrayList();
            goto L26
        L20:
            r12 = false;
        L16:
            r10 = 0;
            goto L18
        L10:
            r3 = null;
        L6:
            r7 = CollectionsKt.emptyList();
            goto L7
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchDialogV2 a;

        public b(MultiAnchorPersonalPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchDialogV2 a;

        public c(MultiAnchorPersonalPkLaunchDialogV2 r1) {
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchDialogV2 a;

        public d(MultiAnchorPersonalPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
            if (r5 == null) goto L13;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r5, 0, 0, null, 7);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L15;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public final MultiAnchorPersonalPkLaunchViewModel T90() {
        return (MultiAnchorPersonalPkLaunchViewModel) this.f.getValue();
    }

    public final String getDegradeTag() {
        return "anchor_multi_launch";
    }

    public MultiAnchorPersonalPkLaunchDialogV2() {
        this.k = null;
        this.e = new LinkedHashMap();
        this.f = LazyKt.lazy(new MultiAnchorPersonalPkLaunchDialogV2$vm$2(this));
        this.j = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        p21.e r0 = this.k;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.j.dispose();
        jy0.b.d("ttlive_anchor_link_multi_pk", "MultiAnchorPersonalPkLaunchDialogV2 dismissed");
        ((LinkedHashMap) this.e).clear();
    }

    public static void U90(MultiAnchorPersonalPkLaunchDialogV2 r4) {
        h41.f r0 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r0 == null) goto L6;
        r0.h(false, r4.T90().getCurrentAnchorList().size(), r4.T90().getCurrentAnchorList().size(), PlayMode.PERSONAL_PK);
        return;
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        T90().attach();
        T90().setNpkInvitePageSource(this.g);
        T90().getPersonalPkSwitchMultiData().observe(this, new a(this));
        RxUtilKt.c(T90().getOnDismissEvent().subscribe(new b(this)), this.j);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ((TextView) S90(2131387228)).setOnClickListener(x0.a(new AnonymousClass1(this)));
        S90(2131381758).setOnClickListener(new c(this));
        ((ImageView) S90(2131363762)).setOnClickListener(new d(this));
        d31.e r5 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r5 == null) goto L5;
        r5.g("routine_pk");
    L5:
        jy0.b.d("ttlive_anchor_link_multi_pk", "MultiAnchorPersonalPkLaunchDialogV2 show");
        p21.e r6 = this.k;
        if (r6 == null) goto L9;
        i97.a r7 = i97.a.a;
        r6.a = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131567002, r2);
    }
}
