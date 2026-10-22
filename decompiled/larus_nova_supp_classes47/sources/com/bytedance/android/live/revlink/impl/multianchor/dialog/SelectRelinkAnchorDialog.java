package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.ui.SelectRelinkAnchorListView;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import cy0.e;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/SelectRelinkAnchorDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/ui/SelectRelinkAnchorListView$a;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectRelinkAnchorDialog extends LinkCommonDialogFragment implements SelectRelinkAnchorListView.a {
    public Map<Integer, View> e;
    public SelectRelinkAnchorListView f;
    public View g;
    public final i11.b h;
    public final CompositeDisposable i;
    public final a j;

    public static final class a extends i11.c.a {
        public final /* synthetic */ SelectRelinkAnchorDialog a;

        public a(SelectRelinkAnchorDialog r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r2, List<? extends p> r3) {
            Intrinsics.checkNotNullParameter(r3, "list");
            if (r3.isEmpty() == false) goto L5;
            return;
        L5:
            CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) r3;
            if (r4.size() <= 2) goto L19;
            SelectRelinkAnchorListView r5 = this.a.f;
            if (r5 == null) goto L23;
            r5.b(r4);
            return;
        L23:
            return;
        L19:
            this.a.dismiss();     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L21;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SelectRelinkAnchorDialog a;

        public b(SelectRelinkAnchorDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SelectRelinkAnchorDialog a;

        public c(SelectRelinkAnchorDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            n9 r7 = (n9) r6;
            if (r7.isFailure() == false) goto L35;
            Map r0 = r7.getNotAllowMap();
            if (r0 != null) goto L7;
        L10:
            boolean r1 = true;
        L11:
            if (r1 == true) goto L35;
            SelectRelinkAnchorListView r2 = this.a.f;
            if (r2 == null) goto L42;
            Map r8 = r7.getNotAllowMap();
            Intrinsics.checkNotNull(r8);
            Intrinsics.checkNotNullParameter(r8, "notAllowMap");
            Iterator r9 = r8.entrySet().iterator();
        L16:
            if (r9.hasNext() == false) goto L45;
            Map.Entry r3 = (Map.Entry) r9.next();
            String r4 = (String) r3.getKey();
            if (((Boolean) r3.getValue()).booleanValue() == false) goto L16;
            View r5 = r2.findViewWithTag(r4);
            if (r5.isSelected() == false) goto L22;
            r2.b.remove(r4);
        L23:
            SelectRelinkAnchorListView.a r10 = r2.c;
            if (r10 == null) goto L26;
            r10.ro(r2.b);
        L26:
            r5.setSelected(!r5.isSelected());
            goto L16
        L22:
            r2.b.add(r4);
            goto L23
        L45:
            return;
        L42:
            return;
        L7:
            if (r0.isEmpty() == true) goto L10;
            r1 = false;
        L35:
            this.a.dismiss();     // Catch: Exception -> L30
            return;
        L30:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r12 = DialogFragmentLancet.sLastShowStack;
            if (r12 == null) goto L43;
            com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SelectRelinkAnchorDialog a;

        public d(SelectRelinkAnchorDialog r1) {
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

    public SelectRelinkAnchorDialog() {
        this.e = new LinkedHashMap();
        this.h = com.bytedance.android.live.revlink.impl.global.b.e();
        this.i = new CompositeDisposable();
        this.j = new a(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        i11.b r0 = this.h;
        if (r0 == null) goto L5;
        r0.l(this.j);
    L5:
        this.i.dispose();
        ((LinkedHashMap) this.e).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        i11.b r5 = this.h;
        if (r5 == null) goto L5;
        r5.i(this.j);
    L5:
        ld.a r6 = ld.d.a();
        if (r6 == null) goto L14;
        NextLiveData r7 = r6.so();
        if (r7 == null) goto L14;
        Observable r8 = ld.c.a(r7);
        if (r8 == null) goto L14;
        Disposable r9 = r8.subscribe(new b(this));
        if (r9 == null) goto L14;
        this.i.add(r9);
    L14:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r10 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r10 == null) goto L17;
        MultiAnchorRelinkService r12 = r10.Fa();
    L18:
        if (r12 == null) goto L28;
        RelinkDataContext r13 = r12.b;
        if (r13 == null) goto L28;
        k<n9> r14 = r13.getRelinkInviteSuccess();
        if (r14 == null) goto L28;
        PublishSubject r15 = r14.onEvent();
        if (r15 == null) goto L28;
        Disposable r16 = r15.subscribe(new c(this));
        if (r16 == null) goto L28;
        this.i.add(r16);
    L28:
        int r17 = o31.a.a;
        LinkedHashMap r18 = new LinkedHashMap();
        d31.d r0 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r0 == null) goto L31;
        Map<String, String> r1 = r0.i();
    L32:
        r18.putAll(r1);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.d() == false) goto L35;
        String r2 = "pk_participate";
    L36:
        r18.put("source", r2);
        n r3 = new n();
        Map<String, String> r19 = r3.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r18, "map");
        r19.putAll(r18);
        m r20 = new m();
        r20.b(LogCommon.ROOM);
        List<Object> r22 = r3.b;
        ArrayList r23 = (ArrayList) r22;
        r23.addAll(r20.a);
        e.a.getClass();
        j r24 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r25);
        ((i) ((f80.a) r25)).w3("livesdk_connection_quit_relink_tab_show", r3.a, r3.b);
        return;
    L35:
        r2 = "link_participate";
        goto L36
    L31:
        r1 = MapsKt.emptyMap();
        goto L32
    L17:
        r12 = null;
        goto L18
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.ui.SelectRelinkAnchorListView.a
    public final void ro(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        boolean r1 = false;
        if (f.N.a() == false) goto L10;
        View r0 = this.g;
        if (r0 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r5).size() != 1) goto L9;
        r1 = true;
    L9:
        r0.setSelected(r1);
        return;
    L10:
        ArrayList r6 = (ArrayList) r5;
        int r2 = r6.size() + 1;
        i11.b r3 = this.h;
        if (r3 == null) goto L19;
        List<p> r4 = r3.getOnlineUserList();
        if (r4 == null) goto L19;
        if (r2 != r4.size()) goto L19;
        View r7 = this.g;
        if (r7 == null) goto L25;
        r7.setSelected(false);
        return;
    L25:
        return;
    L19:
        View r8 = this.g;
        if (r8 == null) goto L27;
        r8.setSelected(!r6.isEmpty());
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        SelectRelinkAnchorListView r4 = (SelectRelinkAnchorListView) r2.findViewById(2131385813);
        this.f = r4;
        if (r4 == null) goto L5;
        r4.setSelectCallback(this);
    L5:
        i11.b r5 = this.h;
        if (r5 == null) goto L12;
        List<? extends p> r6 = r5.getOnlineUserList();
        if (r6 == null) goto L12;
        SelectRelinkAnchorListView r0 = this.f;
        if (r0 == null) goto L12;
        r0.b(r6);
    L12:
        View r7 = r2.findViewById(2131375613);
        this.g = r7;
        if (r7 == null) goto L16;
        r7.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L16:
        if (this.e != null) goto L18;
        this.e = new LinkedHashMap();
    L18:
        View r8 = (View) ((LinkedHashMap) this.e).get(2131381758);
        if (r8 != null) goto L26;
        View r9 = getView();
        if (r9 == null) goto L25;
        r8 = r9.findViewById(2131381758);
        if (r8 == null) goto L25;
        this.e.put(2131381758, r8);
    L25:
        r8 = null;
    L26:
        r8.setOnClickListener(new d(this));
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131567442, r2);
    }
}
