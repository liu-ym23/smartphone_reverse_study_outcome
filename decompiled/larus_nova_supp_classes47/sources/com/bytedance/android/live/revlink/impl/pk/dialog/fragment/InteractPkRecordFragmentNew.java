package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import r11.q;
import y31.t;
import y31.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkRecordFragmentNew;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPkRecordContract$View;", "Lx31/o;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkRecordFragmentNew extends InteractDialogPkRecordContract$View implements x31.o, x {
    public static final /* synthetic */ int y = 0;
    public Map<Integer, View> g;
    public String h;
    public DataCenter i;
    public IRoom j;
    public final Handler k;
    public boolean l;
    public boolean m;
    public int n;
    public ViewGroup o;
    public com.bytedance.android.live.revlink.impl.pk.utils.m p;
    public String q;
    public m0 r;
    public b0 s;
    public int t;
    public boolean u;
    public boolean v;
    public InteractPkRecordView w;
    public InteractPkReserveView x;

    public static final class a {
        public static InteractPkRecordFragmentNew a(r r3, DataCenter r4, int r5, int r6, boolean r7, boolean r8, String r9) {
            Intrinsics.checkNotNullParameter(r4, "dataCenter");
            Intrinsics.checkNotNullParameter("", "activityName");
            Intrinsics.checkNotNullParameter(r9, "source");
            InteractPkRecordFragmentNew r0 = new InteractPkRecordFragmentNew();
            r0.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.o(r0);
            r0.d = r3;
            r0.i = r4;
            yz0.k r10 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r10 == null) goto L5;
            IRoom r12 = r10.getRoom();
        L6:
            r0.j = r12;
            r0.p = new com.bytedance.android.live.revlink.impl.pk.utils.m();
            r0.n = r5;
            r0.q = "";
            r0.r = null;
            r0.s = null;
            r0.t = r6;
            r0.u = r7;
            r0.m = r8;
            r0.h = r9;
            if (r6 != 1) goto L9;
            r0.v = true;
        L9:
            Integer r13 = (Integer) new com.bytedance.android.livesdk.sharedpref.e("live_pk_record_init_type", 0).getValue();
            if (r13 == null) goto L16;
            if (r13.intValue() != 1) goto L16;
            r0.t = 1;
        L16:
            if (b51.b.c0.c() == true) goto L18;
            r0.t = 0;
        L18:
            return r0;
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ InteractPkRecordFragmentNew a;

        public b(InteractPkRecordFragmentNew r1) {
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

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragmentNew$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(InteractPkRecordFragmentNew r8) {
            super(1, r8, InteractPkRecordFragmentNew.class, "updateDefaultBackGround", "updateDefaultBackGround(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r2) {
            InteractPkRecordFragmentNew.fa0((InteractPkRecordFragmentNew) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragmentNew$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(InteractPkRecordFragmentNew r8) {
            super(1, r8, InteractPkRecordFragmentNew.class, "updateDefaultBackGround", "updateDefaultBackGround(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r2) {
            InteractPkRecordFragmentNew.fa0((InteractPkRecordFragmentNew) ((CallableReference) this).receiver, r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // x31.o
    public final void op(f2 r1) {
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

    public InteractPkRecordFragmentNew() {
        this.g = new LinkedHashMap();
        this.k = new Handler();
        this.l = true;
        this.q = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacksAndMessages(null);
        x31.p r0 = (x31.p) this.f;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("live_pk_record_init_type", 0), Integer.valueOf(this.t));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        x31.p r0 = (x31.p) this.f;
        if (r0 == null) goto L5;
        r0.m();
    L5:
        ((LinkedHashMap) this.g).clear();
    }

    public final void onResume() {
        super.onResume();
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
        com.bytedance.android.live.revlink.impl.pk.service.a.C0175a.a(r17, this.d.getCurrentRoom().getId(), this.s, PkAutoMatchManager.AutoMatchRequestSource.FromRecordList);
    L26:
        HashMap r18 = new HashMap();
        r18.put("is_oncemore", DataType.FALSE);
        r18.put("connection_type", "random_pk");
        if (this.q.length() <= 0) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L32;
        r2 = "activity";
    L32:
        r18.put("pk_description", r2);
        r18.put("pk_activity_type", this.q);
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

    public final void setUserVisibleHint(boolean r4) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r4);
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        Object r0 = (View) ((LinkedHashMap) this.g).get(2131384076);
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 == null) goto L12;
        r0 = r1.findViewById(2131384076);
        if (r0 == null) goto L12;
        this.g.put(2131384076, (View) r0);
    L12:
        r0 = null;
    L13:
        PkItemExposeRecyclerView r2 = (PkItemExposeRecyclerView) r0;
        if (r2 == null) goto L17;
        r2.setNestedScrollingEnabled(r4);
        r2.requestLayout();
    L17:
        if (this.l == false) goto L21;
        if (r4 == false) goto L22;
        this.k.post(new b(this));
        this.l = false;
        return;
    L22:
        return;
    }

    public static final void fa0(InteractPkRecordFragmentNew r9, boolean r10) {
        ViewGroup r0 = r9.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        int r1 = 8;
        if (r0 == null) goto L13;
        View r2 = r0.findViewById(2131368743);
        if (r2 == null) goto L13;
        if (r10 == false) goto L11;
        int r4 = 0;
    L12:
        r2.setVisibility(r4);
        goto L13
    L11:
        r4 = 8;
    L13:
        View r3 = r9.getView();
        if (r3 == null) goto L34;
        ViewParent r5 = r3.getParent();
        if (r5 == null) goto L34;
        ViewParent r6 = r5.getParent();
        if (r6 == null) goto L34;
        ViewGroup r7 = (ViewGroup) r6;
        int r8 = r7.getChildCount();
        if (r8 < 0) goto L34;
        int r12 = 0;
    L22:
        View r13 = r7.getChildAt(r12);
        if (r13 == null) goto L25;
        int r14 = r13.getHeight();
    L26:
        if (r14 >= 10) goto L32;
        if (r13 == null) goto L32;
        if (r10 == false) goto L30;
        int r15 = 8;
    L31:
        r13.setVisibility(r15);
        goto L32
    L30:
        r15 = 0;
    L32:
        if (r12 == r8) goto L34;
        r12 = r12 + 1;
        goto L22
    L25:
        r14 = 10;
    L34:
        View r16 = r9.getView();
        if (r16 == null) goto L43;
        View r17 = r16.findViewById(2131368743);
        if (r17 == null) goto L44;
        if (r10 == false) goto L40;
        r1 = 0;
    L40:
        r17.setVisibility(r1);
        return;
    L44:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
    public final void da0(Throwable r4, int r5) {
        ?? r0 = this.w;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (((BaseFragment) this).mStatusViewValid == false) goto L13;
        r0.e.a(1);
        r0.R5(null, r5);
        View r6 = r0.c;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L10:
        r6.setVisibility(8);
        com.bytedance.android.live.revenue.common.k.e(r0.getContext(), r4);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View
    public final void ea0(g2 r6, int r7) {
        InteractPkRecordView r0 = this.w;
        if (r0 == null) goto L31;
        boolean r1 = ((BaseFragment) this).mStatusViewValid;
        String r2 = this.h;
        if (r1 == false) goto L33;
        boolean r3 = false;
        r0.e.a(0);
        r0.R5(r6, r7);
        View r8 = r0.c;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L10:
        r8.setVisibility(8);
        if (r0.g == true) goto L32;
        HashMap r9 = new HashMap();
        if (r0.i.length() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L18;
        String r12 = "activity";
    L19:
        r9.put("pk_description", r12);
        if (r0.i.length() <= 0) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L25;
        String r4 = r0.i;
    L26:
        r9.put("pk_activity_type", r4);
        r9.put("anchor_connect_status", DataType.FALSE);
        r9.put("room_status", "live");
        if (r2 != null) goto L29;
        r2 = "";
    L29:
        r9.put("source", r2);
        r9.put("record_type", "pk_record");
        mz0.n r13 = new mz0.n();
        Map<String, String> r5 = r13.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r5.putAll(r9);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        List<Object> r15 = r13.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_pk_record_show", r13.a, r13.b);
        r0.g = true;
        return;
    L25:
        r4 = "";
        goto L26
    L18:
        r12 = "routine";
        goto L19
    L15:
        r10 = false;
        goto L16
    L32:
        return;
    L33:
        return;
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkReserveView, y31.b] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r10, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r12);
        this.w = (InteractPkRecordView) r10.findViewById(2131382362);
        if (b51.b.c0.c() == false) goto L5;
        this.x = (InteractPkReserveView) r10.findViewById(2131382363);
    L6:
        InteractPkRecordView r13 = this.w;
        if (r13 == null) goto L9;
        String r0 = this.q;
        m0 r1 = this.r;
        int r2 = this.n;
        x31.p r3 = (x31.p) this.f;
        AnonymousClass1 r4 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "activityName");
        Intrinsics.checkNotNullParameter(this, "inviteListener");
        Intrinsics.checkNotNullParameter(r4, "updateDefaultBackGround");
        r13.getClass();
        r13.i = r0;
        r13.j = r1;
        r13.h = r2;
        r13.l = r4;
        r13.n = this;
        r13.m = r3;
    L9:
        InteractPkReserveView r14 = this.x;
        if (r14 == null) goto L12;
        r r5 = this.d;
        AnonymousClass2 r6 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r6, "updateDefaultBackGround");
        r14.g = r5;
        r14.f = r6;
    L12:
        InteractPkRecordView r15 = this.w;
        if (r15 != null) goto L15;
    L19:
        final ?? r16 = this.x;
        if (r16 != 0) goto L22;
        return;
    L22:
        if (this.t != 1) goto L24;
        boolean r7 = true;
    L25:
        boolean r8 = this.v;
        boolean r9 = this.u;
        r16.c = new n(r16);
        MultiTypeAdapter r17 = new MultiTypeAdapter();
        r16.b = r17;
        r17.z2(w.a.class, new w());
        ArrayList r18 = new ArrayList();
        w.a r19 = new w.a();
        r19.a = "我发起的";
        r19.b = 0;
        r19.c = r16;
        if (r7 == false) goto L30;
        if (r8 == false) goto L30;
        boolean r20 = false;
    L31:
        r19.d = r20;
        Unit r22 = Unit.INSTANCE;
        r18.add(r19);
        w.a r23 = new w.a();
        r23.a = "对方发起的";
        r23.b = 1;
        r23.c = r16;
        if (r7 != true) goto L35;
        if (r8 != true) goto L35;
        boolean r24 = true;
    L36:
        r23.d = r24;
        r18.add(r23);
        ?? r25 = (PkItemExposeRecyclerView) r16.findViewById(2131384080);
        MultiTypeAdapter r26 = r16.b;
        if (r26 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L39:
        r25.setAdapter(r26);
        r25.setLayoutManager(new SSLinearLayoutManager(r16.getContext(), 0));
        r25.setVisibility(0);
        MultiTypeAdapter r27 = r16.b;
        if (r27 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L42:
        r27.a = r18;
        MultiTypeAdapter r28 = r16.b;
        if (r28 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L45:
        r28.notifyDataSetChanged();
        r16.e = new LinkedList();
        MultiTypeAdapter r29 = new MultiTypeAdapter();
        r16.a = r29;
        r29.z2(y31.v.a.class, new y31.v());
        MultiTypeAdapter r30 = r16.a;
        if (r30 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L48:
        r30.z2(t.a.class, new t());
        ?? r32 = (PkItemExposeRecyclerView) r16.findViewById(2131384076);
        if (r32 == 0) goto L54;
        MultiTypeAdapter r33 = r16.a;
        if (r33 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L53:
        r32.setAdapter(r33);
        r32.setVisibility(0);
        r32.setLayoutManager(new SSLinearLayoutManager(r16.getContext(), 1));
        r32.addOnScrollListener(new InteractPkReserveView$onIntoDefaultAction$$inlined$let$lambda$1(r16));
    L54:
        KmpEnv r34 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L57;
        int r35 = 2131382879;
    L58:
        View r36 = r16.findViewById(r35);
        r16.d = r36;
        if (r36 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L61:
        r36.setVisibility(0);
        MultiTypeAdapter r37 = r16.a;
        if (r37 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L64:
        LinkedList<Object> r38 = r16.e;
        if (r38 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L67:
        r37.a = r38;
        MultiTypeAdapter r39 = r16.a;
        if (r39 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L70:
        r39.notifyDataSetChanged();
        if (r7 == true) goto L73;
        return;
    L73:
        if (r8 == false) goto L81;
        InteractPkReserveView.S5(1, r9);
        n r40 = r16.c;
        if (r40 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L77:
        Disposable r42 = r40.a;
        if (r42 == null) goto L80;
        r42.dispose();
    L80:
        r40.c = 1;
        r40.d = "";
        r40.b = false;
    L82:
        n r110 = r16.c;
        if (r110 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L85:
        r110.a();
        r16.setVisibility(0);
        return;
    L81:
        InteractPkReserveView.S5(0, r9);
        goto L82
    L57:
        r35 = 2131382880;
    L35:
        r24 = false;
    L30:
        r20 = true;
        goto L31
    L24:
        r7 = false;
        goto L25
    L15:
        if (this.t != 0) goto L17;
        boolean r43 = true;
    L18:
        r15.S5(r43);
        goto L19
    L17:
        r43 = false;
        goto L18
    L5:
        ((InteractPkReserveView) r10.findViewById(2131382363)).setVisibility(8);
        goto L6
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
        if (this.q.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r2 = "activity";
    L12:
        r0.put("pk_description", r2);
        r0.put("pk_activity_type", this.q);
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
        IPKLinkBizDataService r16 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r16 == null) goto L39;
        Integer r17 = Integer.valueOf(r16.getPeakSwitchPlayMode());
    L40:
        int r18 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r17 != null) goto L44;
    L46:
        r0.put("connection_type", "manual_pk");
    L47:
        IPKLinkBizDataService r19 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r19 == null) goto L55;
        if (r10 == null) goto L53;
        IBaseUser r20 = r10.getOwner();
        if (r20 == null) goto L53;
        String r22 = iz.a.a(r20);
    L54:
        String r23 = IPKLinkBizDataService.b.a(r19, r22);
    L56:
        if (r23 != null) goto L58;
    L61:
        boolean r24 = true;
    L62:
        if (r24 == true) goto L64;
        r0.put("transform_reason", r23);
    L64:
        p11.h r25 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r25 == null) goto L67;
        String r26 = r25.getTheme();
    L68:
        if (r26 != null) goto L70;
    L73:
        boolean r27 = true;
    L74:
        if (r27 == true) goto L77;
        Intrinsics.checkNotNull(r26);
        r0.put(FileUtils.PICTURE_THEME, r26);
    L77:
        if (v.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode(), 32) == false) goto L82;
        dq2.w r28 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r28 == null) goto L81;
        r4 = r28.w();
    L81:
        r0.put("audience_connect_cnt", String.valueOf(r4));
    L83:
        r0.put("invite_type", "anchor");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r29 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r29 == null) goto L87;
        String r30 = r29.a;
        if (r30 == null) goto L87;
    L88:
        r0.put("source", r30);
        r0.put("anchor_connection_type", "invite");
        d31.d r32 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r32 == null) goto L92;
        String r33 = r32.a();
        if (r33 == null) goto L92;
    L93:
        r0.put("anchor_connect_status", r33);
        r0.put("invitee_room_status", "live");
        r0.put("invitee_connect_cnt", DataType.FALSE);
        r0.put("is_random_match", DataType.FALSE);
        r0.put("connection_sub_type", "");
        if (r10 == null) goto L98;
        IBaseUser r34 = r10.getOwner();
        if (r34 == null) goto L98;
        String r35 = iz.a.a(r34);
    L99:
        r0.put("invitee_id", String.valueOf(r35));
        if (r10 == null) goto L102;
        r9 = Long.valueOf(r10.getRoomId());
    L102:
        if (r9 != null) goto L104;
    L106:
        r0.put("list_num", String.valueOf(r13 + 1));
        String r110 = r12.getEventTrackingInfo();
        if (r110 == null) goto L111;
        Map<String, String> r111 = h41.h.a(r110);
        if (r111 == null) goto L111;
        r0.putAll(r111);
    L111:
        mz0.n r112 = new mz0.n();
        Map<String, String> r113 = r112.a;
        Intrinsics.checkNotNullParameter(r113, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r113.putAll(r0);
        mz0.m r114 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r115 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r115, "linkInfoLog");
        am2.m r116 = r115.a;
        r116.i = 300;
        ((ArrayList) r114.a).add(r116);
        LinkCrossRoomDataHolder.a r117 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r114);
        r114.b(LogCommon.ROOM);
        ((ArrayList) r112.b).addAll(r114.a);
        cy0.e.a.getClass();
        cy0.j r118 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r119 = com.bytedance.android.scope.m.b(r118).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r119);
        ((mz0.i) ((f80.a) r119)).w3("connection_invite", r112.a, r112.b);
        return;
    L104:
        if (r10.getRoomId() == 0) goto L106;
        r0.put("invitee_room_id", String.valueOf(r10.getRoomId()));
    L98:
        r35 = null;
    L92:
        r33 = "";
    L87:
        r30 = "";
        goto L88
    L82:
        r0.put("audience_connect_cnt", DataType.FALSE);
        goto L83
    L70:
        if (r26.length() == 0) goto L73;
        r27 = false;
        goto L74
    L67:
        r26 = null;
        goto L68
    L58:
        if (r23.length() == 0) goto L61;
        r24 = false;
    L53:
        r22 = null;
        goto L54
    L55:
        r23 = null;
        goto L56
    L44:
        if (r17.intValue() != 1) goto L46;
        r0.put("connection_type", "manual_link");
        goto L47
    L39:
        r17 = null;
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
        View r10 = LayoutInflater.from(getContext()).inflate(2131565534, null);
        if (r10 == null) goto L59;
        ViewGroup r12 = (ViewGroup) r10;
        this.o = r12;
        ((TextView) r12.findViewById(2131391606)).setText(s1.B(2131917924));
        if (this.q.length() <= 0) goto L7;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L22;
        m0 r14 = this.r;
        if (r14 == null) goto L22;
        if (r14.getDisplayTabText() == null) goto L22;
        m0 r15 = this.r;
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
        ((ImageView) r18.findViewById(2131376031)).setOnClickListener(new k(this));
        com.bytedance.android.livesdk.sharedpref.e r19 = new com.bytedance.android.livesdk.sharedpref.e("live_pk_record_init_type", 0);
        if (this.t != 0) goto L36;
        Integer r20 = (Integer) r19.getValue();
        if (r20 == null) goto L36;
        if (r20.intValue() != 0) goto L36;
        ViewGroup r22 = this.o;
        if (r22 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L35:
        ((TextView) r22.findViewById(2131391606)).setTextColor(s1.h(2131107936));
    L41:
        if (b51.b.c0.c() == true) goto L46;
        ViewGroup r23 = this.o;
        if (r23 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L45:
        ((TextView) r23.findViewById(2131391626)).setVisibility(8);
    L50:
        ViewGroup r24 = this.o;
        if (r24 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L53:
        r24.findViewById(2131391606).setOnClickListener(new l(this));
        ViewGroup r25 = this.o;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L56:
        r25.findViewById(2131391626).setOnClickListener(new m(this));
        return r7.inflate(2131566078, r8, false);
    L46:
        ViewGroup r26 = this.o;
        if (r26 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L49:
        ((TextView) r26.findViewById(2131391626)).setVisibility(0);
    L36:
        ViewGroup r27 = this.o;
        if (r27 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L39:
        ((TextView) r27.findViewById(2131391626)).setTextColor(s1.h(2131107936));
        goto L41
    L7:
        r13 = false;
        goto L9
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
