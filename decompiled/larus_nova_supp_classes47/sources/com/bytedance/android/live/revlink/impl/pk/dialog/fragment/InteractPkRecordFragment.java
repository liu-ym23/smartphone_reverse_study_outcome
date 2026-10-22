package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkUserBanSettingDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.link.model.x0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
import x31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkRecordFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPkRecordContract$View;", "Lx31/o;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkRecordFragment extends InteractDialogPkRecordContract$View implements x31.o, x {
    public static final /* synthetic */ int E = 0;
    public final Lazy A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Map<Integer, View> g;
    public String h;
    public PkUserBanSettingDialog i;
    public IRoom j;
    public final Handler k;
    public boolean l;
    public boolean m;
    public int n;
    public ViewGroup o;
    public com.bytedance.android.live.revlink.impl.pk.utils.m p;
    public MultiTypeAdapter q;
    public LinkedList<Object> r;
    public View s;
    public boolean t;
    public String u;
    public m0 v;
    public b0 w;
    public CharSequence x;
    public Function1<? super CharSequence, Unit> y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ InteractPkRecordFragment c;

        public b(int r1, View r2, InteractPkRecordFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            InteractPkRecordFragment r0 = this.c;
            int r1 = InteractPkRecordFragment.E;
            x31.p r2 = (x31.p) r0.f;
            if (r2 != null) goto L6;
            return;
        L6:
            if (r2.g() == this.a) goto L44;
            View r3 = ((GridLayout) this.c.fa0(2131378692)).getChildAt(r2.g());
            if ((r3 instanceof TextView) == true) goto L10;
            r3 = null;
        L10:
            TextView r4 = (TextView) r3;
            boolean r5 = false;
            if (r4 == null) goto L13;
            r4.setSelected(false);
            r4.setTextColor(((Number) this.c.z.getValue()).intValue());
        L13:
            this.b.setSelected(true);
            View r6 = this.c.s;
            if (r6 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
        L16:
            r6.setVisibility(0);
            LinkedList<Object> r7 = this.c.r;
            if (r7 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("recordList");
        L19:
            r7.clear();
            MultiTypeAdapter r8 = this.c.q;
            if (r8 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L22:
            LinkedList<Object> r10 = this.c.r;
            if (r10 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("recordList");
        L25:
            r8.a = r10;
            MultiTypeAdapter r12 = this.c.q;
            if (r12 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L28:
            r12.notifyDataSetChanged();
            if ((r9 instanceof TextView) == true) goto L31;
            r9 = null;
        L31:
            TextView r13 = (TextView) r9;
            if (r13 == null) goto L39;
            ViewGroup r14 = this.c.o;
            if (r14 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("mTopView");
        L36:
            ((TextView) r14.findViewById(2131390628)).setText(r13.getText());
            r13.setTextColor(((Number) this.c.A.getValue()).intValue());
            this.c.x = r13.getText();
            InteractPkRecordFragment r15 = this.c;
            Function1<? super CharSequence, Unit> r16 = r15.y;
            if (r16 == null) goto L39;
            Unit r17 = (Unit) r16.invoke(r15.x);
        L39:
            r2.n(this.a);
            InteractPkRecordFragment r18 = this.c;
            if (this.a == 0) goto L42;
            r5 = true;
        L42:
            r18.m = r5;
            UtilityKotlinExtentionsKt.t(r18.fa0(2131378691));
            HashMap r19 = new HashMap();
            r19.put("options_click", String.valueOf(this.a + 1));
            mz0.n r20 = new mz0.n();
            Map<String, String> r22 = r20.a;
            Intrinsics.checkNotNullParameter(r22, "map");
            Intrinsics.checkNotNullParameter(r19, "map");
            r22.putAll(r19);
            mz0.m r23 = new mz0.m();
            r23.b(LogCommon.ROOM);
            ((ArrayList) r20.b).addAll(r23.a);
            cy0.e.a.getClass();
            cy0.j r24 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r25);
            ((mz0.i) ((f80.a) r25)).w3("livesdk_all_pk_records_choice_panel_click", r20.a, r20.b);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractPkRecordFragment a;

        public c(InteractPkRecordFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            UtilityKotlinExtentionsKt.t(this.a.fa0(2131378691));
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ InteractPkRecordFragment a;

        public d(InteractPkRecordFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.a.p;     // Catch: Throwable -> L9
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");     // Catch: Throwable -> L9
        L5:
            r0.c();     // Catch: Throwable -> L9
            x31.p r1 = (x31.p) this.a.f;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            r1.k(0, true);     // Catch: Throwable -> L9
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
        ViewGroup r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final void ha0() {
        HashMap r0 = new HashMap();
        boolean r2 = false;
        if (this.u.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        String r3 = "activity";
    L9:
        r0.put("pk_description", r3);
        if (this.u.length() <= 0) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L14;
        String r4 = this.u;
    L15:
        r0.put("pk_activity_type", r4);
        r0.put("anchor_connect_status", DataType.FALSE);
        r0.put("room_status", "live");
        String r5 = this.h;
        if (r5 == null) goto L18;
        r0.put("source", r5);
    L18:
        r0.put("record_type", "pk_record");
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r9 = r6.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_pk_record_show", r6.a, r6.b);
        return;
    L14:
        r4 = "";
        goto L15
    L8:
        r3 = "routine";
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public InteractPkRecordFragment() {
        this.g = new LinkedHashMap();
        this.k = new Handler();
        this.l = true;
        this.u = "";
        this.z = LazyKt.lazy(InteractPkRecordFragment$filterNonSelectColor$2.INSTANCE);
        this.A = LazyKt.lazy(InteractPkRecordFragment$filterSelectColor$2.INSTANCE);
        this.C = true;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacksAndMessages(null);
        x31.p r0 = (x31.p) this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        x31.p r0 = (x31.p) this.f;
        if (r0 == null) goto L5;
        r0.m();
    L5:
        LinkedList<Object> r1 = this.r;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L8:
        r1.clear();
        ((LinkedHashMap) this.g).clear();
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L5:
        r0.c();
        if (this.l == false) goto L12;
        x31.p r1 = (x31.p) this.f;
        if (r1 == null) goto L10;
        r1.k(0, true);
    L10:
        this.l = false;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.x
    public final void Fy(String r12) {
        ox0.a r13 = com.bytedance.android.live.revlink.impl.global.b.s();
        boolean r0 = false;
        if (r13 == null) goto L5;
        int r14 = r13.a();
    L7:
        if (v.a(r14, 32) == false) goto L9;
    L60:
        ToastUtil.a(2131917956, 0);
        return;
    L9:
        if (v.a(r14, 8) == true) goto L60;
        i41.a r15 = com.bytedance.android.live.revlink.impl.global.b.g();
        String r2 = "routine";
        if (r15 != null) goto L14;
    L19:
        com.bytedance.android.live.revlink.impl.pk.utils.j r16 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r16 == null) goto L56;
        String r6 = null;
        if (r16.c(-1, null, 1) != true) goto L56;
        com.bytedance.android.live.revlink.impl.pk.service.a r17 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r17 == null) goto L26;
        com.bytedance.android.live.revlink.impl.pk.service.a.C0175a.a(r17, this.d.getCurrentRoom().getId(), this.w, PkAutoMatchManager.AutoMatchRequestSource.FromRecordList);
    L26:
        HashMap r18 = new HashMap();
        r18.put("is_oncemore", DataType.FALSE);
        r18.put("connection_type", "random_pk");
        if (this.u.length() <= 0) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L32;
        r2 = "activity";
    L32:
        r18.put("pk_description", r2);
        r18.put("pk_activity_type", this.u);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r3 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r3 == null) goto L35;
        String r4 = r3.a();
    L36:
        r18.put("from_room_status", r4);
        String r7 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService().getTheme();
        if (r7 != null) goto L39;
    L42:
        boolean r8 = true;
    L43:
        if (r8 == true) goto L45;
        Intrinsics.checkNotNull(r7);
        r18.put(FileUtils.PICTURE_THEME, r7);
    L45:
        p11.h r9 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r9 == null) goto L48;
        r6 = r9.getInviteMode();
    L48:
        if (r6 != null) goto L50;
    L51:
        r0 = true;
    L52:
        if (r0 == false) goto L55;
        r6 = "routine_pk";
    L55:
        r18.put("invite_mode", r6);
        mz0.n r1 = new mz0.n();
        Map<String, String> r10 = r1.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r18, "map");
        r10.putAll(r18);
        mz0.m r19 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r20 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r20, "linkInfoLog");
        am2.m r22 = r20.a;
        r22.i = 300;
        ((ArrayList) r19.a).add(r22);
        LinkCrossRoomDataHolder.a r23 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r19);
        r19.b(LogCommon.ROOM);
        List<Object> r24 = r1.b;
        ArrayList r25 = (ArrayList) r24;
        r25.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("connection_invite", r1.a, r1.b);
        goto L56
    L50:
        if (r6.length() != 0) goto L52;
    L39:
        if (r7.length() == 0) goto L42;
        r8 = false;
        goto L43
    L35:
        r4 = "";
        goto L36
    L29:
        r5 = false;
    L56:
        r r112 = this.d;
        if (r112 == null) goto L63;
        r112.dismiss();
        return;
    L63:
        return;
    L14:
        if (r15.f != true) goto L19;
        HashMap r113 = new HashMap();
        r113.put("pk_description", "routine");
        i41.a r26 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r26 == null) goto L18;
        r26.b(AutoMatchSource.Manual);
    L18:
        mz0.n r27 = new mz0.n();
        Map<String, String> r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r113, "map");
        r28.putAll(r113);
        mz0.m r114 = new mz0.m();
        LinkCrossRoomDataHolder.a r29 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r114);
        r114.b(LogCommon.ROOM);
        List<Object> r30 = r27.b;
        ArrayList r32 = (ArrayList) r30;
        r32.addAll(r114.a);
        cy0.e.a.getClass();
        cy0.j r115 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r116 = com.bytedance.android.scope.m.b(r115).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r116);
        ((mz0.i) ((f80.a) r116)).w3("match_cancel_click", r27.a, r27.b);
        return;
    L5:
        r14 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
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

    public final void ga0(g2 r17) {
        boolean r6 = true;
        if (r17 == null) goto L12;
        List r8 = r17.getBattleRecordList();
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L12;
    L33:
        ((PkItemExposeRecyclerView) fa0(2131384076)).setVisibility(0);
        ((LinearLayout) fa0(2131390556)).setVisibility(8);
    L34:
        if (r17 == null) goto L158;
        MultiTypeAdapter r2 = this.q;
        if (r2 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L38:
        LinkedList<Object> r10 = this.r;
        if (r10 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L42:
        if (r10.isEmpty() == true) goto L55;
        LinkedList<Object> r12 = this.r;
        if (r12 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L46:
        LinkedList<Object> r13 = this.r;
        if (r13 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L50:
        if ((ListProtector.get(r12, r13.size() - 1) instanceof y31.v.a) == false) goto L55;
        LinkedList<Object> r14 = this.r;
        if (r14 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L54:
        r14.removeLast();
    L55:
        List r15 = r17.getBattleRecordList();
        if (r15 != null) goto L58;
        r15 = CollectionsKt.emptyList();
    L58:
        Iterator r16 = r15.iterator();
    L60:
        if (r16.hasNext() == false) goto L86;
        f2 r18 = (f2) r16.next();
        y31.n.a r19 = new y31.n.a();
        r19.a = 8;
        r19.b = r18;
        r19.c = this.n;
        if (this.m == true) goto L81;
        x0 r110 = r17.getBattleConsecutiveRecordInfo();
        if (r110 == null) goto L66;
        long r111 = r110.getConsecutiveCount();
    L68:
        if (r111 < 2) goto L81;
        x0 r112 = r17.getBattleConsecutiveRecordInfo();
        if (r112 == null) goto L81;
        if (r112.getBattleResultType() != 1) goto L81;
        if (r18 == null) goto L81;
        if (r18.getBattleResultType() != 1) goto L81;
        x0 r20 = r17.getBattleConsecutiveRecordInfo();
        if (r20 == null) goto L79;
        Integer r22 = Integer.valueOf((int) r20.getConsecutiveCount());
    L80:
        r19.d = r22;
        this.m = true;
    L82:
        String r23 = this.u;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r19.e = r23;
        r19.f = this.B;
        r19.h = this.h;
        r19.i = false;
        LinkedList<Object> r24 = this.r;
        if (r24 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L85:
        r24.add(r19);
        goto L60
    L79:
        r22 = null;
        goto L80
    L66:
        r111 = 0;
    L81:
        r19.d = 0;
        goto L82
    L86:
        LinkedList<Object> r1 = this.r;
        if (r1 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L89:
        ArrayList r5 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L91:
        if (r3.hasNext() == false) goto L95;
        Object r25 = r3.next();
        if ((r25 instanceof y31.n.a) == false) goto L91;
        r5.add(r25);
        goto L91
    L95:
        Iterator r4 = r5.iterator();
        int r7 = 0;
    L97:
        if (r4.hasNext() == false) goto L102;
        Object r26 = r4.next();
        int r27 = r7 + 1;
        if (r7 >= 0) goto L101;
        CollectionsKt.throwIndexOverflow();
    L101:
        ((y31.n.a) r26).g = r7;
        r7 = r27;
        goto L97
    L102:
        y31.v.a r28 = new y31.v.a();
        String r29 = r17.getNoRecordTip();
        if (r29 != null) goto L105;
    L108:
        boolean r30 = true;
    L110:
        if (r30 == false) goto L119;
        LinkedList<Object> r32 = this.r;
        if (r32 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L115:
        if (r32.size() > 6) goto L119;
        x31.p r33 = (x31.p) this.f;
        if (r33 == null) goto L139;
        r33.e();
    L139:
        LinkedList<Object> r34 = this.r;
        if (r34 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L142:
        r2.a = r34;
        MultiTypeAdapter r35 = this.q;
        if (r35 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L145:
        r35.notifyDataSetChanged();
        return;
    L119:
        String r36 = r17.getNoRecordTip();
        if (r36 != null) goto L122;
    L125:
        if (r6 == false) goto L135;
        LinkedList<Object> r37 = this.r;
        if (r37 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L130:
        if (r37.size() <= 6) goto L135;
        r28.a = s1.B(2131917932);
        LinkedList<Object> r38 = this.r;
        if (r38 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L134:
        r38.add(r28);
    L135:
        r28.a = r17.getNoRecordTip();
        LinkedList<Object> r39 = this.r;
        if (r39 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L138:
        r39.add(r28);
        goto L139
    L122:
        if (r36.length() == 0) goto L125;
        r6 = false;
        goto L125
    L105:
        if (r29.length() == 0) goto L108;
        r30 = false;
        goto L110
    L158:
        return;
    L7:
        if (r8.isEmpty() == true) goto L10;
        r9 = false;
    L12:
        LinkedList<Object> r40 = this.r;
        if (r40 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L16:
        if (r40.isEmpty() == false) goto L33;
        ((PkItemExposeRecyclerView) fa0(2131384076)).setVisibility(8);
        ((LinearLayout) fa0(2131390556)).setVisibility(0);
        ((TextView) fa0(2131371603)).setText(s1.B(2131917865));
        if (this.u.length() <= 0) goto L20;
        boolean r42 = true;
    L21:
        if (r42 == false) goto L34;
        m0 r43 = this.v;
        if (r43 == null) goto L34;
        if (r43 == null) goto L26;
        a5 r44 = r43.getDisplayTabText();
    L27:
        if (r44 == null) goto L34;
        m0 r45 = this.v;
        if (r45 == null) goto L34;
        a5 r46 = r45.getDisplayTabText();
        if (r46 == null) goto L34;
        ((TextView) fa0(2131371603)).setText(s1.C(2131917866, new Object[]{vh6.c.b(ur2.a.class).Lf(r46, "").toString()}));
        goto L34
    L26:
        r44 = null;
        goto L27
    L20:
        r42 = false;
        goto L21
    }

    @Override // x31.o
    public final void op(f2 r6) {
        if (r6 == null) goto L55;
        PkUserBanSettingDialog r0 = this.i;
        if (r0 != null) goto L6;
    L13:
        IBattleUserInfo r1 = r6.getBattleUserInfo();
        IRoom r2 = null;
        if (r1 == null) goto L18;
        k0 r3 = r1.getUserInfo();
        if (r3 == null) goto L18;
        String r4 = r3.getUserId();
    L19:
        if (r4 == null) goto L23;
        x31.p r5 = (x31.p) this.f;
        if (r5 == null) goto L23;
        u r7 = r5.f(r4);
    L24:
        int r8 = PkUserBanSettingDialog.m;
        yz0.k r9 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r9 == null) goto L27;
        r2 = r9.getRoom();
    L27:
        Intrinsics.checkNotNullParameter(r6, "battleRecord");
        PkUserBanSettingDialog r10 = new PkUserBanSettingDialog();
        r10.i = r2;
        r10.l = r6;
        r10.e = r7;
        if (r7 == null) goto L30;
        int r12 = r7.a;
    L31:
        r10.f = r12;
        if (r7 == null) goto L34;
        int r13 = r7.b;
    L35:
        r10.g = r13;
        if (r7 == null) goto L38;
        boolean r14 = r7.c;
    L39:
        r10.h = r14;
        FragmentActivity r15 = ContextUtil.contextToFragmentActivity(getContext());
        if (r15 == null) goto L48;
        FragmentManager r16 = r15.getSupportFragmentManager();
        if (r16 == null) goto L48;
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "PkUserBanSettingDialog", r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r10, r17) == true) goto L48;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L47:
        r10.show(r16, "PkUserBanSettingDialog");
    L48:
        Unit r18 = Unit.INSTANCE;
        this.i = r10;
        HashMap r19 = new HashMap();
        r19.put("feedback_anchor_id", String.valueOf(r4));
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r22.putAll(r19);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        ((ArrayList) r20.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_pk_record_feedback_entry_click", r20.a, r20.b);
        return;
    L38:
        r14 = r6.getInviteRejectPermanent();
        goto L39
    L34:
        r13 = r6.getIncreaseOrDecreaseInvite();
        goto L35
    L30:
        r12 = r6.getFollowType();
    L23:
        r7 = null;
    L18:
        r4 = null;
        goto L19
    L6:
        if (r0.isVisible() == false) goto L13;
        r0.dismiss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r26 = DialogFragmentLancet.sLastShowStack;
        if (r26 == null) goto L13;
        com.bytedance.crash.d.d(r26, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
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

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
    public final void da0(Throwable r2, int r3) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.m r4 = this.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L8:
        r4.a(1);
        ga0(null);
        View r5 = this.s;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L11:
        r5.setVisibility(8);
        com.bytedance.android.live.revenue.common.k.e(getContext(), r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
    public final void ea0(g2 r2, int r3) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.m r4 = this.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L8:
        r4.a(0);
        ga0(r2);
        View r5 = this.s;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L11:
        r5.setVisibility(8);
        if (this.t == false) goto L14;
        return;
    L14:
        if (this.C == false) goto L16;
        ha0();
    L16:
        this.t = true;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        View r8 = this.s;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L5:
        r8.setVisibility(0);
        this.r = new LinkedList();
        MultiTypeAdapter r9 = new MultiTypeAdapter();
        this.q = r9;
        r9.z2(y31.v.a.class, new y31.v());
        MultiTypeAdapter r10 = this.q;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L8:
        com.bytedance.android.live.revlink.impl.pk.utils.m r3 = this.p;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L11:
        r10.z2(y31.n.a.class, new y31.n(r3, this, (x31.p) this.f));
        PkItemExposeRecyclerView r1 = (PkItemExposeRecyclerView) fa0(2131384076);
        MultiTypeAdapter r2 = this.q;
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
        Object r4 = r12.next();
        int r5 = r0 + 1;
        if (r0 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        View r13 = (View) r4;
        if (r0 != 0) goto L23;
        boolean r14 = true;
    L24:
        r13.setSelected(r14);
        r13.setOnClickListener(new b(r0, r13, this));
        r0 = r5;
        goto L16
    L23:
        r14 = false;
        goto L24
    L25:
        fa0(2131363883).setOnClickListener(new c(this));
        String r15 = s1.B(2131917926);
        this.x = r15;
        Function1<? super CharSequence, Unit> r16 = this.y;
        if (r16 == null) goto L32;
        Unit r17 = (Unit) r16.invoke(r15);
        return;
    }

    @Override // x31.o
    public final void a50(int r4, f2 r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "battleRecord");
        if (this.d.getCurrentRoom() != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.j r0 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.c(r4, iz.a.a(this.d.getCurrentRoom().getOwner()), 0) != true) goto L22;
        com.bytedance.android.live.revlink.impl.pk.utils.j r1 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.a(iz.a.a(this.d.getCurrentRoom().getOwner()), r4) != true) goto L23;
        x31.p r2 = (x31.p) this.f;
        if (r2 == null) goto L21;
        this.d.getCurrentRoom().getId();
        r2.j(r4, r5, r6, r5.getPlayMode());
        return;
    L21:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
    public final void ca0(IRoom r10, v4 r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "inviteResult");
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        this.d.dismiss();
        HashMap r0 = new HashMap();
        r0.put("is_oncemore", DataType.FALSE);
        r0.put("invitee_list", "history");
        r0.put("is_recommend_list", DataType.FALSE);
        int r4 = 0;
        if (this.u.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r2 = "activity";
    L12:
        r0.put("pk_description", r2);
        r0.put("pk_activity_type", this.u);
        r0.put("room_status", "live");
        w31.c r6 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r6 == null) goto L19;
        IPKLinkBizDataService r7 = r6.g();
        if (r7 == null) goto L19;
        if (r7.getSelfHasAudienceBeforePk() == false) goto L19;
        r0.put("room_status", "audience_connection");
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r3 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r3 == null) goto L22;
        String r5 = r3.a();
    L23:
        r0.put("from_room_status", r5);
        p11.h r8 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        Long r9 = null;
        if (r8 == null) goto L26;
        String r14 = r8.getInviteMode();
    L27:
        if (r14 != null) goto L29;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == false) goto L36;
        r14 = "routine_pk";
    L36:
        r0.put("invite_mode", r14);
        int r16 = r12.getSwitchPlayMode();
        int r17 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r16 != 1) goto L39;
        r0.put("connection_type", "manual_link");
    L40:
        IPKLinkBizDataService r18 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r18 == null) goto L48;
        if (r10 == null) goto L46;
        IBaseUser r19 = r10.getOwner();
        if (r19 == null) goto L46;
        String r20 = iz.a.a(r19);
    L47:
        String r110 = IPKLinkBizDataService.b.a(r18, r20);
    L49:
        if (r110 != null) goto L51;
    L54:
        boolean r22 = true;
    L55:
        if (r22 == true) goto L57;
        r0.put("transform_reason", r110);
    L57:
        p11.h r111 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r111 == null) goto L60;
        String r112 = r111.getTheme();
    L61:
        if (r112 != null) goto L63;
    L66:
        boolean r23 = true;
    L67:
        if (r23 == true) goto L70;
        Intrinsics.checkNotNull(r112);
        r0.put(FileUtils.PICTURE_THEME, r112);
    L70:
        if (v.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode(), 32) == false) goto L75;
        w r113 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r113 == null) goto L74;
        r4 = r113.w();
    L74:
        r0.put("audience_connect_cnt", String.valueOf(r4));
    L76:
        r0.put("invite_type", "anchor");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r114 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r114 == null) goto L80;
        String r115 = r114.a;
        if (r115 == null) goto L80;
    L81:
        r0.put("source", r115);
        r0.put("anchor_connection_type", "invite");
        d31.d r116 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r116 == null) goto L85;
        String r117 = r116.a();
        if (r117 == null) goto L85;
    L86:
        r0.put("anchor_connect_status", r117);
        r0.put("invitee_room_status", "live");
        r0.put("invitee_connect_cnt", DataType.FALSE);
        r0.put("is_random_match", DataType.FALSE);
        r0.put("connection_sub_type", "");
        if (r10 == null) goto L91;
        IBaseUser r118 = r10.getOwner();
        if (r118 == null) goto L91;
        String r119 = iz.a.a(r118);
    L92:
        r0.put("invitee_id", String.valueOf(r119));
        if (r10 == null) goto L95;
        r9 = Long.valueOf(r10.getRoomId());
    L95:
        if (r9 != null) goto L97;
    L99:
        r0.put("list_num", String.valueOf(r13 + 1));
        mz0.n r120 = new mz0.n();
        Map<String, String> r121 = r120.a;
        Intrinsics.checkNotNullParameter(r121, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r121.putAll(r0);
        mz0.m r122 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r123 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r123, "linkInfoLog");
        am2.m r124 = r123.a;
        r124.i = 300;
        ((ArrayList) r122.a).add(r124);
        LinkCrossRoomDataHolder.a r125 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r122);
        r122.b(LogCommon.ROOM);
        ((ArrayList) r120.b).addAll(r122.a);
        cy0.e.a.getClass();
        cy0.j r126 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r127 = com.bytedance.android.scope.m.b(r126).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r127);
        ((mz0.i) ((f80.a) r127)).w3("connection_invite", r120.a, r120.b);
        return;
    L97:
        if (r10.getRoomId() == 0) goto L99;
        r0.put("invitee_room_id", String.valueOf(r10.getRoomId()));
    L91:
        r119 = null;
    L85:
        r117 = "";
    L80:
        r115 = "";
        goto L81
    L75:
        r0.put("audience_connect_cnt", DataType.FALSE);
        goto L76
    L63:
        if (r112.length() == 0) goto L66;
        r23 = false;
        goto L67
    L60:
        r112 = null;
        goto L61
    L51:
        if (r110.length() == 0) goto L54;
        r22 = false;
    L46:
        r20 = null;
        goto L47
    L48:
        r110 = null;
        goto L49
    L39:
        r0.put("connection_type", "manual_pk");
        goto L40
    L29:
        if (r14.length() == 0) goto L32;
        r15 = false;
        goto L33
    L26:
        r14 = null;
        goto L27
    L22:
        r5 = "";
        goto L23
    L11:
        r2 = "routine";
        goto L12
    L8:
        r1 = false;
        goto L9
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = LayoutInflater.from(getContext()).inflate(2131565533, null);
        if (r10 == null) goto L35;
        ViewGroup r12 = (ViewGroup) r10;
        this.o = r12;
        ((TextView) r12.findViewById(2131391606)).setText(s1.B(2131917924));
        if (this.u.length() <= 0) goto L7;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L22;
        m0 r14 = this.v;
        if (r14 == null) goto L22;
        if (r14.getDisplayTabText() == null) goto L22;
        m0 r15 = this.v;
        if (r15 == null) goto L22;
        a5 r16 = r15.getDisplayTabText();
        if (r16 == null) goto L22;
        Spannable r17 = vh6.c.b(ur2.a.class).Lf(r16, "");
        ViewGroup r4 = this.o;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L21:
        ((TextView) r4.findViewById(2131391606)).setText(s1.C(2131917925, new Object[]{r17}));
    L22:
        ViewGroup r18 = this.o;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L25:
        ((ImageView) r18.findViewById(2131376031)).setOnClickListener(new i(this));
        ViewGroup r19 = this.o;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L28:
        ((TextView) r19.findViewById(2131390628)).setOnClickListener(new j(this));
        View r20 = r7.inflate(2131566059, r8, false);
        KmpEnv r22 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L31;
        int r23 = 2131382879;
    L32:
        this.s = r20.findViewById(r23);
        return r20;
    L31:
        r23 = 2131382880;
        goto L32
    L7:
        r13 = false;
        goto L9
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
