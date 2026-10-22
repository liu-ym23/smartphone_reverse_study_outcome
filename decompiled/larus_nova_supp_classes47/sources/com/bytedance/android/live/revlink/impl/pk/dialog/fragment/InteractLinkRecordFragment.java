package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.o5;
import com.bytedance.android.livesdk.link.model.p5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import dq2.w;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import r11.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractLinkRecordFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogLinkRecordContract$View;", "Lx31/b;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractLinkRecordFragment extends InteractDialogLinkRecordContract$View implements x31.b, x {
    public static final /* synthetic */ int A = 0;
    public Map<Integer, View> g;
    public String h;
    public DataCenter i;
    public IRoom j;
    public final Handler k;
    public boolean l;
    public int m;
    public ViewGroup n;
    public com.bytedance.android.live.revlink.impl.pk.utils.m o;
    public MultiTypeAdapter p;
    public LinkedList<Object> q;
    public View r;
    public boolean s;
    public CharSequence t;
    public Function1<? super CharSequence, Unit> u;
    public final Lazy v;
    public final Lazy w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ InteractLinkRecordFragment c;

        public b(int r1, View r2, InteractLinkRecordFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            InteractLinkRecordFragment r0 = this.c;
            int r1 = InteractLinkRecordFragment.A;
            x31.c r2 = (x31.c) r0.f;
            if (r2 != null) goto L6;
            return;
        L6:
            if (r2.g() == this.a) goto L41;
            View r3 = ((GridLayout) this.c.fa0(2131378692)).getChildAt(r2.g());
            if ((r3 instanceof TextView) == true) goto L10;
            r3 = null;
        L10:
            TextView r4 = (TextView) r3;
            if (r4 == null) goto L13;
            r4.setSelected(false);
            r4.setTextColor(((Number) this.c.v.getValue()).intValue());
        L13:
            this.b.setSelected(true);
            View r5 = this.c.r;
            if (r5 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
        L16:
            r5.setVisibility(0);
            LinkedList<Object> r6 = this.c.q;
            if (r6 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("recordList");
        L19:
            r6.clear();
            MultiTypeAdapter r7 = this.c.p;
            if (r7 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L22:
            LinkedList<Object> r9 = this.c.q;
            if (r9 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("recordList");
        L25:
            r7.a = r9;
            MultiTypeAdapter r10 = this.c.p;
            if (r10 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L28:
            r10.notifyDataSetChanged();
            if ((r8 instanceof TextView) == true) goto L31;
            r8 = null;
        L31:
            TextView r12 = (TextView) r8;
            if (r12 == null) goto L39;
            ViewGroup r13 = this.c.n;
            if (r13 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("mTopView");
        L36:
            ((TextView) r13.findViewById(2131390628)).setText(r12.getText());
            r12.setTextColor(((Number) this.c.w.getValue()).intValue());
            this.c.t = r12.getText();
            InteractLinkRecordFragment r14 = this.c;
            Function1<? super CharSequence, Unit> r15 = r14.u;
            if (r15 == null) goto L39;
            Unit r16 = (Unit) r15.invoke(r14.t);
        L39:
            r2.k(this.a);
            UtilityKotlinExtentionsKt.t(this.c.fa0(2131378691));
            HashMap r17 = new HashMap();
            r17.put("options_click", String.valueOf(this.a + 1));
            mz0.n r18 = new mz0.n();
            Map<String, String> r19 = r18.a;
            Intrinsics.checkNotNullParameter(r19, "map");
            Intrinsics.checkNotNullParameter(r17, "map");
            r19.putAll(r17);
            mz0.m r20 = new mz0.m();
            r20.b(LogCommon.ROOM);
            ((ArrayList) r18.b).addAll(r20.a);
            cy0.e.a.getClass();
            cy0.j r22 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r23);
            ((mz0.i) ((f80.a) r23)).w3("livesdk_all_pk_records_choice_panel_click", r18.a, r18.b);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractLinkRecordFragment a;

        public c(InteractLinkRecordFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            UtilityKotlinExtentionsKt.t(this.a.fa0(2131378691));
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ InteractLinkRecordFragment a;

        public d(InteractLinkRecordFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.a.o;     // Catch: Throwable -> L9
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");     // Catch: Throwable -> L9
        L5:
            r0.c();     // Catch: Throwable -> L9
            x31.c r1 = (x31.c) this.a.f;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            r1.i(null, true, 0);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r0 = b51.b.c0.j();
        if (r0 != null) goto L5;
        return 432.0f;
    L5:
        if (r0.getEnable() == true) goto L7;
        return 432.0f;
    L7:
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * q.a(r0)) - 48;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final void ha0() {
        HashMap r0 = new HashMap();
        r0.put("pk_description", "routine");
        r0.put("anchor_connect_status", DataType.FALSE);
        r0.put("room_status", "live");
        String r1 = this.h;
        if (r1 == null) goto L5;
        r0.put("source", r1);
    L5:
        r0.put("record_type", "link_record");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r3.putAll(r0);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.ROOM);
        List<Object> r5 = r2.b;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_pk_record_show", r2.a, r2.b);
    }

    public InteractLinkRecordFragment() {
        this.g = new LinkedHashMap();
        this.k = new Handler();
        this.l = true;
        this.v = LazyKt.lazy(InteractLinkRecordFragment$filterNonSelectColor$2.INSTANCE);
        this.w = LazyKt.lazy(InteractLinkRecordFragment$filterSelectColor$2.INSTANCE);
        this.y = true;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacksAndMessages(null);
        x31.c r0 = (x31.c) this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        x31.c r0 = (x31.c) this.f;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        LinkedList<Object> r1 = this.q;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L8:
        r1.clear();
        ((LinkedHashMap) this.g).clear();
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L5:
        r0.c();
        if (this.l == false) goto L12;
        x31.c r1 = (x31.c) this.f;
        if (r1 == null) goto L10;
        r1.i(null, true, 0);
    L10:
        this.l = false;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.x
    public final void Fy(String r10) {
        boolean r0 = false;
        if (this.i == null) goto L5;
        int r12 = wq2.e.a().getLinkState();
    L7:
        if (v.a(r12, 32) == false) goto L9;
    L57:
        ToastUtil.a(2131917956, 0);
        return;
    L9:
        if (v.a(r12, 8) == true) goto L57;
        i41.a r13 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r13 != null) goto L14;
    L19:
        com.bytedance.android.live.revlink.impl.pk.utils.j r14 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r14 == null) goto L53;
        String r6 = null;
        if (r14.c(-1, null, 1) != true) goto L53;
        com.bytedance.android.live.revlink.impl.pk.service.a r15 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r15 == null) goto L26;
        com.bytedance.android.live.revlink.impl.pk.service.a.C0175a.a(r15, this.d.getCurrentRoom().getId(), null, PkAutoMatchManager.AutoMatchRequestSource.FromRecordList);
    L26:
        HashMap r16 = new HashMap();
        r16.put("is_oncemore", DataType.FALSE);
        r16.put("connection_type", "random_pk");
        r16.put("pk_description", "routine");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r2 == null) goto L29;
        String r3 = r2.a();
    L30:
        r16.put("from_room_status", r3);
        p11.h r4 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r4 == null) goto L33;
        String r5 = r4.getTheme();
    L34:
        if (r5 != null) goto L36;
    L39:
        boolean r7 = true;
    L40:
        if (r7 == true) goto L42;
        Intrinsics.checkNotNull(r5);
        r16.put(FileUtils.PICTURE_THEME, r5);
    L42:
        p11.h r8 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r8 == null) goto L45;
        r6 = r8.getInviteMode();
    L45:
        if (r6 != null) goto L47;
    L48:
        r0 = true;
    L49:
        if (r0 == false) goto L52;
        r6 = "routine_pk";
    L52:
        r16.put("invite_mode", r6);
        mz0.n r1 = new mz0.n();
        Map<String, String> r9 = r1.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r9.putAll(r16);
        mz0.m r17 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r18 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r18, "linkInfoLog");
        am2.m r19 = r18.a;
        r19.i = 300;
        ((ArrayList) r17.a).add(r19);
        LinkCrossRoomDataHolder.a r20 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r17);
        r17.b(LogCommon.ROOM);
        ((ArrayList) r1.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("connection_invite", r1.a, r1.b);
        goto L53
    L47:
        if (r6.length() != 0) goto L49;
    L36:
        if (r5.length() == 0) goto L39;
        r7 = false;
        goto L40
    L33:
        r5 = null;
        goto L34
    L29:
        r3 = "";
    L53:
        r r112 = this.d;
        if (r112 == null) goto L60;
        r112.dismiss();
        return;
    L60:
        return;
    L14:
        if (r13.f != true) goto L19;
        HashMap r113 = new HashMap();
        r113.put("pk_description", "routine");
        i41.a r22 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r22 == null) goto L18;
        r22.b(AutoMatchSource.Manual);
    L18:
        mz0.n r23 = new mz0.n();
        Map<String, String> r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r113, "map");
        r24.putAll(r113);
        mz0.m r114 = new mz0.m();
        LinkCrossRoomDataHolder.a r25 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r114);
        r114.b(LogCommon.ROOM);
        ((ArrayList) r23.b).addAll(r114.a);
        cy0.e.a.getClass();
        cy0.j r115 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r116 = com.bytedance.android.scope.m.b(r115).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r116);
        ((mz0.i) ((f80.a) r116)).w3("match_cancel_click", r23.a, r23.b);
        return;
    L5:
        r12 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View
    public final void ba0(Throwable r7) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L6;
        return;
    L6:
        if ((r7 instanceof ApiServerException) == false) goto L18;
        int r8 = ((ApiServerException) r7).getErrorCode();
        if (r8 != 31012) goto L12;
        this.d.dismiss();
        return;
    L12:
        if (r8 != 4004129) goto L15;
        HashMap r9 = new HashMap();
        r9.put("connection_type", "pk");
        r9.put("control_user", "inviter");
        mz0.n r0 = new mz0.n();
        Map<String, String> r2 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r2.putAll(r9);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r3 = r0.b;
        ArrayList r4 = (ArrayList) r3;
        r4.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_connection_anchor_control_toast_show", r0.a, r0.b);
        return;
    L15:
        if (r8 != 4004130) goto L20;
        HashMap r14 = new HashMap();
        r14.put("connection_type", "pk");
        r14.put("control_user", "invitee");
        mz0.n r1 = new mz0.n();
        Map<String, String> r5 = r1.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r5.putAll(r14);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        r15.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r6 = r1.b;
        ArrayList r16 = (ArrayList) r6;
        r16.addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_connection_anchor_control_toast_show", r1.a, r1.b);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View
    public final void da0(Throwable r3) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.o;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L8:
        r0.a(1);
        ga0(null, null);
        View r1 = this.r;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L11:
        r1.setVisibility(8);
        com.bytedance.android.live.revenue.common.k.e(getContext(), r3);
    }

    public final View fa0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        PkItemExposeRecyclerView r0 = (PkItemExposeRecyclerView) fa0(2131384076);
        if (r0 == null) goto L6;
        r0.setNestedScrollingEnabled(r2);
        r0.requestLayout();
    L6:
        if (this.l == false) goto L10;
        if (r2 == false) goto L11;
        this.k.post(new d(this));
        this.l = false;
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View
    public final void ca0(IRoom r10, v4 r12) {
        Intrinsics.checkNotNullParameter(r12, "inviteResult");
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        this.d.dismiss();
        HashMap r0 = new HashMap();
        r0.put("is_oncemore", DataType.FALSE);
        r0.put("invitee_list", "link_history");
        r0.put("is_recommend_list", DataType.FALSE);
        r0.put("pk_description", "routine");
        r0.put("room_status", "live");
        w31.c r4 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r4 == null) goto L12;
        IPKLinkBizDataService r5 = r4.g();
        if (r5 == null) goto L12;
        if (r5.getSelfHasAudienceBeforePk() == false) goto L12;
        r0.put("room_status", "audience_connection");
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r1 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r1 == null) goto L15;
        String r2 = r1.a();
    L16:
        r0.put("from_room_status", r2);
        p11.h r3 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        Long r6 = null;
        if (r3 == null) goto L19;
        String r7 = r3.getInviteMode();
    L20:
        boolean r8 = true;
        int r9 = 0;
        if (r7 != null) goto L23;
    L26:
        boolean r13 = true;
    L27:
        if (r13 == false) goto L30;
        r7 = "routine_pk";
    L30:
        r0.put("invite_mode", r7);
        int r14 = r12.getSwitchPlayMode();
        int r15 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r14 != 1) goto L33;
        r0.put("connection_type", "manual_link");
    L34:
        IPKLinkBizDataService r16 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r16 == null) goto L42;
        if (r10 == null) goto L40;
        IBaseUser r17 = r10.getOwner();
        if (r17 == null) goto L40;
        String r18 = iz.a.a(r17);
    L41:
        String r19 = IPKLinkBizDataService.b.a(r16, r18);
    L43:
        if (r19 != null) goto L45;
    L48:
        boolean r20 = true;
    L49:
        if (r20 == true) goto L51;
        r0.put("transform_reason", r19);
    L51:
        p11.h r110 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r110 == null) goto L54;
        String r111 = r110.getTheme();
    L55:
        if (r111 != null) goto L57;
    L60:
        if (r8 == true) goto L62;
        Intrinsics.checkNotNull(r111);
        r0.put(FileUtils.PICTURE_THEME, r111);
    L62:
        ox0.a r112 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r112 == null) goto L65;
        int r113 = r112.a();
    L67:
        if (v.a(r113, 32) == false) goto L72;
        w r114 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r114 == null) goto L71;
        r9 = r114.w();
    L71:
        r0.put("audience_connect_cnt", String.valueOf(r9));
    L73:
        r0.put("invite_type", "anchor");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r115 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r115 == null) goto L77;
        String r116 = r115.a;
        if (r116 == null) goto L77;
    L78:
        r0.put("source", r116);
        r0.put("anchor_connection_type", "invite");
        d31.d r117 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r117 == null) goto L82;
        String r118 = r117.a();
        if (r118 == null) goto L82;
    L83:
        r0.put("anchor_connect_status", r118);
        r0.put("invitee_room_status", "live");
        r0.put("invitee_connect_cnt", DataType.FALSE);
        r0.put("is_random_match", DataType.FALSE);
        r0.put("connection_sub_type", "");
        if (r10 == null) goto L88;
        IBaseUser r119 = r10.getOwner();
        if (r119 == null) goto L88;
        String r120 = iz.a.a(r119);
    L89:
        r0.put("invitee_id", String.valueOf(r120));
        if (r10 == null) goto L92;
        r6 = Long.valueOf(r10.getRoomId());
    L92:
        if (r6 != null) goto L94;
    L96:
        mz0.n r121 = new mz0.n();
        Map<String, String> r122 = r121.a;
        Intrinsics.checkNotNullParameter(r122, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r122.putAll(r0);
        mz0.m r123 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r22 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r22, "linkInfoLog");
        am2.m r23 = r22.a;
        r23.i = 300;
        ((ArrayList) r123.a).add(r23);
        LinkCrossRoomDataHolder.a r24 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r123);
        r123.b(LogCommon.ROOM);
        ((ArrayList) r121.b).addAll(r123.a);
        cy0.e.a.getClass();
        cy0.j r124 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r125 = com.bytedance.android.scope.m.b(r124).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r125);
        ((mz0.i) ((f80.a) r125)).w3("connection_invite", r121.a, r121.b);
        return;
    L94:
        if (r10.getRoomId() == 0) goto L96;
        r0.put("invitee_room_id", String.valueOf(r10.getRoomId()));
    L88:
        r120 = null;
    L82:
        r118 = "";
    L77:
        r116 = "";
        goto L78
    L72:
        r0.put("audience_connect_cnt", DataType.FALSE);
        goto L73
    L65:
        r113 = 0;
        goto L67
    L57:
        if (r111.length() == 0) goto L60;
        r8 = false;
        goto L60
    L54:
        r111 = null;
        goto L55
    L45:
        if (r19.length() == 0) goto L48;
        r20 = false;
    L40:
        r18 = null;
        goto L41
    L42:
        r19 = null;
        goto L43
    L33:
        r0.put("connection_type", "manual_pk");
        goto L34
    L23:
        if (r7.length() == 0) goto L26;
        r13 = false;
        goto L27
    L19:
        r7 = null;
        goto L20
    L15:
        r2 = "";
        goto L16
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View
    public final void ea0(p5 r3, String r4) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.o;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L8:
        r0.a(0);
        ga0(r3, r4);
        View r5 = this.r;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L11:
        r5.setVisibility(8);
        if (this.s == false) goto L14;
        return;
    L14:
        if (this.y == false) goto L16;
        ha0();
    L16:
        this.s = true;
    }

    public final void ga0(p5 r10, String r12) {
        boolean r4 = false;
        if (r10 != null) goto L5;
    L6:
        LinkedList<Object> r5 = this.q;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L10:
        if (r5.isEmpty() == false) goto L12;
        ((PkItemExposeRecyclerView) fa0(2131384076)).setVisibility(8);
        ((LinearLayout) fa0(2131390556)).setVisibility(0);
        ((TextView) fa0(2131371603)).setText(s1.B(2131917795));
    L13:
        if (r10 == null) goto L133;
        MultiTypeAdapter r0 = this.p;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L17:
        LinkedList<Object> r6 = this.q;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L21:
        if (r6.isEmpty() == true) goto L34;
        LinkedList<Object> r7 = this.q;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L25:
        LinkedList<Object> r8 = this.q;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L29:
        if ((ListProtector.get(r7, r8.size() - 1) instanceof y31.v.a) == false) goto L34;
        LinkedList<Object> r9 = this.q;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L33:
        r9.removeLast();
    L34:
        LinkedList<Object> r13 = this.q;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L38:
        if (r13.size() >= 100) goto L53;
        Iterator r14 = r10.getRecords().iterator();
    L41:
        if (r14.hasNext() == false) goto L53;
        o5 r15 = (o5) r14.next();
        y31.c.a r16 = new y31.c.a();
        r16.a = 8;
        r16.b = r15;
        r16.c = this.m;
        r16.d = this.x;
        String r17 = this.h;
        if (r17 != null) goto L45;
        r17 = "";
    L45:
        r16.f = r17;
        LinkedList<Object> r18 = this.q;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L48:
        r18.add(r16);
        LinkedList<Object> r19 = this.q;
        if (r19 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L52:
        if (r19.size() < 100) goto L41;
    L53:
        LinkedList<Object> r110 = this.q;
        if (r110 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L56:
        ArrayList r3 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L58:
        if (r111.hasNext() == false) goto L62;
        Object r20 = r111.next();
        if ((r20 instanceof y31.c.a) == false) goto L58;
        r3.add(r20);
        goto L58
    L62:
        Iterator r112 = r3.iterator();
        int r22 = 0;
    L64:
        if (r112.hasNext() == false) goto L69;
        Object r23 = r112.next();
        int r24 = r22 + 1;
        if (r22 >= 0) goto L68;
        CollectionsKt.throwIndexOverflow();
    L68:
        ((y31.c.a) r23).e = r22;
        r22 = r24;
        goto L64
    L69:
        y31.v.a r113 = new y31.v.a();
        if (r12 != null) goto L72;
    L75:
        boolean r25 = true;
    L77:
        if (r25 == false) goto L96;
        LinkedList<Object> r26 = this.q;
        if (r26 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L82:
        if (r26.size() > 16) goto L96;
        LinkedList<Object> r114 = this.q;
        if (r114 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L87:
        if ((!r114.isEmpty()) == false) goto L92;
        x31.c r115 = (x31.c) this.f;
        if (r115 == null) goto L91;
        r115.e();
    L91:
        r113.a = s1.B(2131917932);
    L92:
        LinkedList<Object> r116 = this.q;
        if (r116 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L95:
        r116.add(r113);
    L114:
        LinkedList<Object> r117 = this.q;
        if (r117 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L117:
        r0.a = r117;
        MultiTypeAdapter r118 = this.p;
        if (r118 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L120:
        r118.notifyDataSetChanged();
        return;
    L96:
        if (r12 != null) goto L98;
    L99:
        r4 = true;
    L100:
        if (r4 == false) goto L110;
        LinkedList<Object> r27 = this.q;
        if (r27 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L105:
        if (r27.size() <= 16) goto L110;
        r113.a = s1.B(2131917932);
        LinkedList<Object> r119 = this.q;
        if (r119 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L109:
        r119.add(r113);
    L110:
        r113.a = r12;
        LinkedList<Object> r120 = this.q;
        if (r120 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L113:
        r120.add(r113);
        goto L114
    L98:
        if (r12.length() != 0) goto L100;
    L72:
        if (r12.length() == 0) goto L75;
        r25 = false;
        goto L77
    L133:
        return;
    L12:
        ((PkItemExposeRecyclerView) fa0(2131384076)).setVisibility(0);
        ((LinearLayout) fa0(2131390556)).setVisibility(8);
        goto L13
    L5:
        if (r10.getRecords().isEmpty() == false) goto L12;
        goto L6
    }

    @Override // x31.b
    public final void mF(int r3, o5 r4) {
        Intrinsics.checkNotNullParameter(r4, "linkRecord");
        if (this.d.getCurrentRoom() != null) goto L5;
        return;
    L5:
        x31.c r0 = (x31.c) this.f;
        if (r0 == null) goto L9;
        this.d.getCurrentRoom().getId();
        r0.h(r3, r4);
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        View r8 = this.r;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L5:
        r8.setVisibility(0);
        this.q = new LinkedList();
        MultiTypeAdapter r9 = new MultiTypeAdapter();
        this.p = r9;
        r9.z2(y31.v.a.class, new y31.v());
        MultiTypeAdapter r10 = this.p;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L9:
        if (this.o != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L11:
        r10.z2(y31.c.a.class, new y31.c(this, (x31.c) this.f));
        PkItemExposeRecyclerView r1 = (PkItemExposeRecyclerView) fa0(2131384076);
        MultiTypeAdapter r2 = this.p;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L14:
        r1.setAdapter(r2);
        ((PkItemExposeRecyclerView) fa0(2131384076)).setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        ((PkItemExposeRecyclerView) fa0(2131384076)).setItemViewCacheSize(8);
        ((PkItemExposeRecyclerView) fa0(2131384076)).setItemAnimator(null);
        ((PkItemExposeRecyclerView) fa0(2131384076)).addOnScrollListener(new AnonymousClass1(this));
        Iterator r12 = UtilityKotlinExtentionsKt.g((ViewGroup) fa0(2131378692)).iterator();
        int r0 = 0;
    L16:
        if (r12.hasNext() == false) goto L25;
        Object r3 = r12.next();
        int r4 = r0 + 1;
        if (r0 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        View r5 = (View) r3;
        if (r0 != 0) goto L23;
        boolean r13 = true;
    L24:
        r5.setSelected(r13);
        r5.setOnClickListener(new b(r0, r5, this));
        r0 = r4;
        goto L16
    L23:
        r13 = false;
        goto L24
    L25:
        fa0(2131363883).setOnClickListener(new c(this));
        String r14 = s1.B(2131917926);
        this.t = r14;
        Function1<? super CharSequence, Unit> r15 = this.u;
        if (r15 == null) goto L32;
        Unit r16 = (Unit) r15.invoke(r14);
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = LayoutInflater.from(getContext()).inflate(2131565533, null);
        if (r6 == null) goto L17;
        ViewGroup r7 = (ViewGroup) r6;
        this.n = r7;
        ((TextView) r7.findViewById(2131391606)).setText(s1.B(2131917706));
        ViewGroup r8 = this.n;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        ((ImageView) r8.findViewById(2131376031)).setOnClickListener(new e(this));
        ViewGroup r9 = this.n;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L10:
        ((TextView) r9.findViewById(2131390628)).setOnClickListener(new f(this));
        View r10 = r3.inflate(2131566055, r4, false);
        KmpEnv r12 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L13;
        int r13 = 2131382879;
    L14:
        this.r = r10.findViewById(r13);
        return r10;
    L13:
        r13 = 2131382880;
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
