package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragmentNew;
import com.bytedance.android.live.revlink.impl.precisefind.MultiPkPreciseFindContext;
import com.bytedance.android.livesdk.a5;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00012\u00020\u0003:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/g;", "Lcom/bytedance/android/livesdk/widget/LinkNoScrollViewPager$a;", "<init>", "()V", "Companion", "b", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorInteractContainerFragment extends RevInteractDialogFragmentBaseContract$View<com.bytedance.android.live.revlink.impl.control.dialog.g<?>> implements LinkNoScrollViewPager.a {
    public static final /* synthetic */ int S = 0;
    public boolean A;
    public Disposable B;
    public String C;
    public String D;
    public String E;
    public String F;
    public final CompositeDisposable G;
    public f0 H;
    public String I;
    public boolean J;
    public ViewGroup K;
    public boolean L;
    public boolean M;
    public boolean N;
    public zy0.b O;
    public final boolean P;
    public final d Q;
    public final f R;
    public Map<Integer, View> g;
    public String h;
    public IRoom i;
    public int j;
    public View k;
    public HSImageView l;
    public View m;
    public View n;
    public View o;
    public DataCenter p;
    public com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d q;
    public com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r;
    public AnchorLinkUserListFragment s;
    public int t;
    public Integer u;
    public final com.bytedance.android.live.revlink.impl.pk.utils.k v;
    public final com.bytedance.android.live.revlink.impl.pk.utils.k w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment$Companion$TabLocate;", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface TabLocate {
        }

        public Companion() {
        }

        @JvmStatic
        public static AnchorInteractContainerFragment a(com.bytedance.android.live.revlink.impl.control.dialog.r r1, DataCenter r2, int r3, String r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "posStr");
            Intrinsics.checkNotNullParameter(r6, "defaultPage");
            AnchorInteractContainerFragment r0 = new AnchorInteractContainerFragment();
            r0.d = r1;
            r0.p = r2;
            r0.j = r3;
            r0.h = r4;
            r0.i = (IRoom) r2.get("data_room", vh7.f.c(IRoom.class));
            int r7 = com.bytedance.android.live.revlink.impl.utils.x.a;
            Intrinsics.checkNotNullParameter("live_link_last_invite_source", "key");
            if (Intrinsics.areEqual((String) new com.bytedance.android.livesdk.sharedpref.e("live_link_last_invite_source", "").getValue(), "link_banner") == false) goto L6;
            d51.c r8 = d51.c.A0;
            r8.getClass();
            if (((Boolean) d51.c.Z.getValue(r8, d51.c.a[50])).booleanValue() == false) goto L6;
        L7:
            KProperty[] r9 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            r0.j = 0;
        L8:
            r0.E = r6;
            return r0;
        L6:
            if (r5 == false) goto L8;
            goto L7
        }

        public static /* synthetic */ AnchorInteractContainerFragment b(RevLinkDialog r8, DataCenter r9, int r10, String r12, String r13, int r14) {
            if ((r14 & 8) == 0) goto L5;
            String r5 = "";
        L7:
            if ((r14 & 32) == 0) goto L9;
            String r7 = "";
        L11:
            return a(r8, r9, r10, r5, false, r7);
        L9:
            r7 = r13;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AnchorInteractContainerFragment a;

        public a(AnchorInteractContainerFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            com.bytedance.android.live.revlink.impl.control.dialog.e r0 = (com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond();
            AnchorInteractContainerFragment r1 = this.a;
            Boolean r2 = null;
            if (r0 == null) goto L7;
            IRivalRankRecommendResponse r3 = r0.c;
            if (r3 == null) goto L7;
            Boolean r4 = Boolean.valueOf(r3.isOpenAutoFindPeople());
        L8:
            boolean r5 = r4.booleanValue();
            int r8 = AnchorInteractContainerFragment.S;
            r1.ka0(true, r5);
            if (r0 == null) goto L13;
            IRivalRankRecommendResponse r9 = r0.c;
            if (r9 == null) goto L13;
            String r10 = r9.getPkSeasonInfo();
        L15:
            if (TextUtils.isEmpty(r10) == true) goto L27;
            this.a.I = r0.c.getPkSeasonInfo();
            AnchorInteractContainerFragment r12 = this.a;
            if (r12.N == true) goto L27;
            if (r12.O != null) goto L27;
            IRoom r13 = r12.i;
            if (r13 == null) goto L23;
            LiveMode r14 = r13.getStreamType();
        L25:
            if (r14 == LiveMode.SCREEN_RECORD) goto L27;
            this.a.ea0();
            goto L27
        L23:
            r14 = null;
        L27:
            AnchorInteractContainerFragment r15 = this.a;
            if (r15.J == true) goto L35;
            com.bytedance.android.live.revlink.impl.control.dialog.e r16 = (com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond();
            if (r16 == null) goto L34;
            IRivalRankRecommendResponse r17 = r16.c;
            if (r17 == null) goto L34;
            r2 = Boolean.valueOf(r17.isUnReadReserveRecord());
        L34:
            r15.J = r2.booleanValue();
        L35:
            AnchorInteractContainerFragment r18 = this.a;
            View r19 = r18.n;
            if (r19 != null) goto L38;
            return;
        L38:
            if (r18.J == false) goto L41;
            r19.setBackground(s1.m(2131252592));
        L41:
            if (Intrinsics.areEqual(this.a.E, "reserve") == false) goto L47;
            AnchorInteractContainerFragment r20 = this.a;
            r20.J = false;
            View r22 = r20.n;
            if (r22 == null) goto L48;
            r22.setBackground(s1.m(2131252591));
            return;
        L48:
            return;
        L47:
            return;
        L13:
            r10 = null;
        L7:
            r4 = null;
            goto L8
        }
    }

    public interface b {
        void onUpdate(int r1);

        void q60(boolean r1);
    }

    public interface c {
        void a();

        void b(boolean r1);

        void c();

        void d(boolean r1);

        void e();
    }

    public static final class d implements c {
        public final /* synthetic */ AnchorInteractContainerFragment a;

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.c
        public final void a() {
            AnchorInteractContainerFragment.ca0(this.a, 1);
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.c
        public final void c() {
            AnchorInteractContainerFragment r0 = this.a;
            r0.y = true;
            f(true, r0.z);
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.c
        public final void e() {
            LinkNoScrollViewPager r0 = this.a.ba0(2131392847);
            if (r0 == null) goto L6;
            int r1 = r0.getCurrentItem();
            KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            if (r1 != 2) goto L6;
            return;
        L6:
            com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.d;
            KProperty[] r4 = l51.a.a;
            if (((Boolean) r3.getValue(null, r4[2])).booleanValue() == true) goto L21;
            f0 r5 = this.a.H;
            if (r5 == null) goto L18;
            Intrinsics.checkNotNullParameter("巅峰赛已开启", "text");
            View r6 = r5.a;
            if (r6 == null) goto L18;
            Context r7 = r6.getContext();
            if (r7 == null) goto L18;
            View r8 = r5.a;
            if (r8 == null) goto L18;
            r8.post(new d0(r5, r7));
        L18:
            r3.setValue(null, r4[2], Boolean.TRUE);
            return;
        }

        public d(AnchorInteractContainerFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.c
        public final void b(boolean r4) {
            f0 r0 = this.a.H;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.c == r4) goto L24;
            r0.c = r4;
            View r1 = r0.a;
            if (r1 == null) goto L16;
            TabLayout r2 = r1.findViewById(2131387986);
            if (r2 == null) goto L16;
            KProperty[] r3 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            TabLayout.Tab r5 = r2.getTabAt(2);
            if (r5 == null) goto L16;
            if (r4 == false) goto L14;
            CharSequence r6 = f0.a();
        L15:
            r5.setText(r6);
            goto L16
        L14:
            r6 = "";
        L16:
            if (r4 == true) goto L18;
            return;
        L18:
            if (r0.d == false) goto L26;
            r0.d = false;
            View r7 = r0.a;
            if (r7 == null) goto L27;
            r7.post(new e0(r0));
            return;
        L27:
            return;
        L26:
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.c
        public final void d(boolean r2) {
            AnchorInteractContainerFragment r0 = this.a;
            r0.z = r2;
            f(r0.y, r2);
        }

        public final void f(boolean r7, boolean r8) {
            if (this.a.getView() != null) goto L5;
            return;
        L5:
            LinkNoScrollViewPager r0 = this.a.ba0(2131392847);
            boolean r1 = true;
            if (r0 == null) goto L10;
            int r3 = r0.getCurrentItem();
            KProperty[] r4 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            if (r3 != 1) goto L10;
            boolean r5 = true;
        L11:
            if (r0 == null) goto L15;
            int r6 = r0.getCurrentItem();
            KProperty[] r9 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            if (r6 != 2) goto L15;
            boolean r10 = true;
        L16:
            if (r0 == null) goto L20;
            int r2 = r0.getCurrentItem();
            KProperty[] r12 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            if (r2 != 0) goto L20;
        L22:
            if (r10 == false) goto L33;
            View r13 = this.a.m;
            if (r13 == null) goto L26;
            r13.setVisibility(8);
        L26:
            View r14 = this.a.n;
            if (r14 == null) goto L29;
            r14.setVisibility(0);
        L29:
            this.a.la0(8);
            View r15 = this.a.o;
            if (r15 == null) goto L75;
            r15.setVisibility(8);
            return;
        L75:
            return;
        L33:
            if (this.a.ha0() == true) goto L65;
            if (r5 == false) goto L38;
            if (r7 == true) goto L65;
            b51.b r16 = b51.b.c0;
            r16.getClass();
            if (((Number) b51.b.q.getValue(r16, b51.b.a[15])).intValue() > 0) goto L65;
        L38:
            if (r1 == false) goto L41;
            if (r8 == true) goto L65;
        L41:
            IRoom r17 = this.a.i;
            if (r17 == null) goto L44;
            LiveMode r18 = r17.getStreamType();
        L46:
            if (r18 != LiveMode.SCREEN_RECORD) goto L56;
            View r19 = this.a.m;
            if (r19 == null) goto L50;
            r19.setVisibility(8);
        L50:
            View r20 = this.a.n;
            if (r20 == null) goto L53;
            r20.setVisibility(8);
        L53:
            this.a.la0(8);
            View r22 = this.a.o;
            if (r22 == null) goto L77;
            r22.setVisibility(0);
            return;
        L77:
            return;
        L56:
            View r23 = this.a.m;
            if (r23 == null) goto L59;
            r23.setVisibility(8);
        L59:
            View r24 = this.a.n;
            if (r24 == null) goto L62;
            r24.setVisibility(8);
        L62:
            this.a.la0(8);
            View r25 = this.a.o;
            if (r25 == null) goto L79;
            r25.setVisibility(0);
            return;
        L79:
            return;
        L44:
            r18 = null;
        L65:
            View r26 = this.a.m;
            if (r26 == null) goto L68;
            r26.setVisibility(0);
        L68:
            View r27 = this.a.n;
            if (r27 == null) goto L71;
            r27.setVisibility(0);
        L71:
            this.a.la0(0);
            View r28 = this.a.o;
            if (r28 == null) goto L81;
            r28.setVisibility(8);
            return;
        L81:
            return;
        L20:
            r1 = false;
        L15:
            r10 = false;
        L10:
            r5 = false;
            goto L11
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorInteractContainerFragment a;

        public e(AnchorInteractContainerFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L6;
            d r0 = this.a.Q;
            r0.a.A = r3.booleanValue();
            return;
        }
    }

    public static final class f implements b {
        public final /* synthetic */ AnchorInteractContainerFragment a;

        public f(AnchorInteractContainerFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.b
        public final void onUpdate(int r6) {
            boolean r0 = false;
            if (r6 != 1) goto L11;
            this.a.x = true;
            String r7 = (String) ((HashMap) l51.a.L.getValue(null, l51.a.a[38])).get(String.valueOf(Calendar.getInstance().get(6)));     // Catch: Exception -> L9
            if (r7 == null) goto L11;
            int r8 = CastIntegerProtector.parseInt(r7);     // Catch: Exception -> L9
        L13:
            if (AnchorInteractContainerFragment.ca0(this.a, r8) == false) goto L25;
            KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            if (r8 != 0) goto L26;
            AnchorInteractContainerFragment r9 = this.a;
            r9.getClass();
            HashMap r3 = new HashMap();
            r3.put("show_type", "auto");
            r3.put("source", "live_pk_icon");
            if (r9.C.length() <= 0) goto L19;
            r0 = true;
        L19:
            if (r0 == false) goto L21;
            r3.put("guide_type", r9.C);
            r3.put("source", "guide");
        L21:
            r3.put("to_user_group", r9.D);
            r3.put("room_status", "live");
            r3.put("anchor_connect_status", DataType.FALSE);
            r3.put("channel_id", DataType.FALSE);
            mz0.n r10 = new mz0.n();
            Map<String, String> r1 = r10.a;
            Intrinsics.checkNotNullParameter(r1, "map");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.putAll(r3);
            mz0.m r4 = new mz0.m();
            r4.b(LogCommon.ROOM);
            ((ArrayList) r10.b).addAll(r4.a);
            cy0.e.a.getClass();
            cy0.j r5 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r12 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r12);
            ((mz0.i) ((f80.a) r12)).w3("livesdk_connection_tab_show", r10.a, r10.b);
            return;
        L26:
            return;
        L25:
            return;
        L9:
            e = move-exception;
            ALogger.e("AnchorInteractContainerFragment", "updateTab " + e.getMessage());
        L11:
            r8 = 0;
            goto L13
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.b
        public final void q60(boolean r3) {
            LinkNoScrollViewPager r0 = this.a.ba0(2131392847);
            if (r0 == null) goto L6;
            r0.requestDisallowInterceptTouchEvent(r3);
            return;
        }
    }

    static {
        new Companion();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r0 = b51.b.c0.j();
        if (r0.getEnable() == true) goto L7;
        return 432.0f;
    L7:
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * r11.q.a(r0)) - 48;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        View r0 = this.k;
        if ((r0 instanceof ViewGroup) == true) goto L6;
        r0 = null;
    L6:
        return (ViewGroup) r0;
    }

    public final boolean ha0() {
        IRoom r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        IRoom r3 = this.i;
        if (r3 == null) goto L15;
        IRoomSpecificSceneTypeInfo r4 = r3.getSceneTypeInfo();
        if (r4 == null) goto L15;
        if (r4.isLandscapeVerticalRoom() != 1) goto L15;
        boolean r5 = true;
    L17:
        if (d51.c.A0.d() == true) goto L19;
        if (r1 == false) goto L19;
    L20:
        return true;
    L19:
        if (r5 == true) goto L20;
        return false;
    L15:
        r5 = false;
        goto L17
    L5:
        if (r0.isLiveTypeAudio() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void ja0() {
        HashMap r0 = new HashMap();
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r1 != null) goto L5;
        String r2 = null;
    L15:
        r0.put("source", "live_pk_icon");
        if (this.C.length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        r0.put("guide_type", this.C);
        r0.put("source", "guide");
    L21:
        r0.put("to_user_group", this.D);
        if (r2 != null) goto L24;
        r2 = "";
    L24:
        r0.put("room_status", r2);
        r0.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        mz0.n r4 = new mz0.n();
        Map<String, String> r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        mz0.m r6 = new mz0.m();
        r6.b(LogCommon.ROOM);
        List<Object> r7 = r4.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((mz0.i) ((f80.a) r10)).w3("livesdk_connection_icon_click", r4.a, r4.b);
        return;
    L18:
        r3 = false;
        goto L19
    L5:
        if (r1.k0(16) == false) goto L7;
    L13:
        r2 = "PK";
        goto L15
    L7:
        if (r1.k0(4) == true) goto L13;
        if (r1.getCurrentMode() != 0) goto L12;
        r2 = "live";
        goto L15
    L12:
        r2 = "connection";
        goto L15
    }

    public AnchorInteractContainerFragment() {
        this.g = new LinkedHashMap();
        this.h = "";
        this.t = 2;
        this.v = new com.bytedance.android.live.revlink.impl.pk.utils.k(com.bytedance.android.live.revlink.impl.global.b.k(), "pk_invite");
        this.w = new com.bytedance.android.live.revlink.impl.pk.utils.k(com.bytedance.android.live.revlink.impl.global.b.k(), "link_invite");
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        CompositeDisposable r0 = new CompositeDisposable();
        this.G = r0;
        this.P = b51.c.a((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        this.Q = new d(this);
        this.R = new f(this);
        LinkRevPanelDataContext r1 = LinkRevPanelDataContext.Companion.getContext();
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.k<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e>> r2 = r1.getLoadCompleteEvent();
        if (r2 == null) goto L13;
        PublishSubject r3 = r2.onEvent();
        if (r3 == null) goto L14;
        Disposable r4 = r3.subscribe(new a(this));
        if (r4 == null) goto L15;
        r0.add(r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public static boolean fa0() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r1 == null) goto L10;
        i11.b r2 = r1.getLinkUserCenter();
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (Lists.isEmpty(r2.getInviteeList()) == true) goto L25;
        com.bytedance.android.live.revenuelink.connect.g r3 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r3 == null) goto L25;
        if (r3.w1() != true) goto L25;
        if (Lists.isEmpty(r2.a()) == false) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r4 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r4 == null) goto L23;
        LinkedHashMap r5 = new LinkedHashMap();
        r4.b(r5);
        r4.f(r5);
        int r6 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "invitee_diff_from_waiting_list: " + r5, null);
    L23:
        return true;
    L25:
        if (Lists.isEmpty(CollectionsKt.toList(r2.n())) == true) goto L33;
        com.bytedance.android.live.revenuelink.connect.g r7 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r7 != null) goto L29;
        return false;
    L29:
        if (r7.w1() != true) goto L35;
        return true;
    L35:
        return false;
    L33:
        return false;
    L10:
        r2 = null;
        goto L11
    L5:
        if (r0.k0(64) != true) goto L7;
        return true;
    }

    public final void ea0() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        b51.b r1 = b51.b.c0;
        r1.getClass();
        final String r2 = (String) b51.b.R.getValue(r1, b51.b.a[42]);
        com.bytedance.android.live.revlink.impl.control.dialog.r r3 = this.d;
        if (r3 == null) goto L8;
        r3.so();
    L8:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r4 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r0, null, new AnchorInteractContainerFragment$initPkSeasonCard$card$1(r2));
        if (r4 == null) goto L22;
        this.O = r4;
        ViewGroup r5 = this.K;
        if (r5 == null) goto L13;
        r5.removeAllViews();
    L13:
        ViewGroup r6 = this.K;
        if (r6 == null) goto L16;
        r6.addView(r4.d, new ViewGroup.LayoutParams(-1, -1));
    L16:
        ViewGroup r7 = this.K;
        if (r7 == null) goto L19;
        r7.setVisibility(0);
    L19:
        HashMap r8 = new HashMap();
        r8.put("banner_info", this.I);
        xy0.a<?> r9 = r4.g();
        if (r9 == null) goto L22;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r9).load(r2, r8);
    L22:
        this.N = true;
        if (Intrinsics.areEqual(this.E, "reserve") == false) goto L26;
        ga0(1, true);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.B;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.B = null;
        zy0.b r1 = this.O;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.G.dispose();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        f0 r0 = this.H;
        if (r0 == null) goto L7;
        yo2.d<?> r1 = r0.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r1);
        r1.d();
        r0.b = null;
    L7:
        p11.d r2 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r2 == null) goto L10;
        r2.g();
    L10:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkRecoverForNative("anchor_invite_panel", "dismiss");
        ((LinkedHashMap) this.g).clear();
    }

    public final boolean rB() {
        LinkNoScrollViewPager r0 = ba0(2131392847);
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getCurrentItem());
    L7:
        if (r1.intValue() != 0) goto L10;
        return false;
    L10:
        if (fa0() == true) goto L17;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r2 = this.q;
        if (r2 != null) goto L14;
    L15:
        return true;
    L14:
        if (r2.EV(false) == true) goto L15;
        return false;
    L17:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final /* bridge */ /* synthetic */ Boolean aa0() {
        return Boolean.FALSE;
    }

    public final View ba0(int r3) {
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

    public final void la0(int r5) {
        com.bytedance.android.live.revlink.impl.precisefind.a r0 = MultiPkPreciseFindContext.Companion.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.Ip() != true) goto L15;
        HSImageView r1 = this.l;
        if (r1 == null) goto L9;
        r1.setVisibility(r5);
    L9:
        if (r5 != 0) goto L16;
        com.bytedance.tools.kcp.spongepreference.runtime.a r6 = l51.a.N0;
        KProperty[] r2 = l51.a.a;
        if (((Boolean) r6.getValue(null, r2[103(0x67, float:1.44E-43)])).booleanValue() == true) goto L17;
        r6.setValue(null, r2[103(0x67, float:1.44E-43)], Boolean.TRUE);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static final boolean ca0(AnchorInteractContainerFragment r2, int r3) {
        LinkNoScrollViewPager r1 = r2.ba0(2131392847);
        if (r1 != null) goto L5;
    L8:
        LinkNoScrollViewPager r4 = r2.ba0(2131392847);
        if (r4 == null) goto L11;
        r4.setCurrentItem(r3);
    L11:
        return true;
    L5:
        if (r1.getCurrentItem() != r3) goto L8;
        return false;
    }

    public static final void da0(AnchorInteractContainerFragment r3, boolean r4) {
        r3.getClass();
        HashMap r5 = new HashMap();
        r5.put("pk_description", "routine");
        if (r4 == false) goto L5;
        String r0 = "pk_banner";
    L6:
        r5.put("source", r0);
        if (r4 == false) goto L9;
        String r6 = "livesdk_pksearch_click";
    L10:
        mz0.n r1 = new mz0.n();
        Map<String, String> r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r2.putAll(r5);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        List<Object> r8 = r1.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3(r6, r1.a, r1.b);
        return;
    L9:
        r6 = "livesdk_connection_tab_search_click";
        goto L10
    L5:
        r0 = "link_banner";
        goto L6
    }

    public static void ia0(String r3, boolean r4) {
        if (Intrinsics.areEqual(r3, "show") == false) goto L5;
        String r5 = "livesdk_pk_circle_select_entry_show";
    L6:
        HashMap r0 = new HashMap();
        if (r4 == false) goto L9;
        String r6 = DataType.TRUE;
    L10:
        r0.put("match_status", r6);
        mz0.n r7 = new mz0.n();
        Map<String, String> r1 = r7.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        mz0.m r2 = new mz0.m();
        r2.b(LogCommon.ROOM);
        List<Object> r8 = r7.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3(r5, r7.a, r7.b);
        return;
    L9:
        r6 = DataType.FALSE;
        goto L10
    L5:
        r5 = "livesdk_pk_circle_select_entry_click";
        goto L6
    }

    public final void ga0(int r12, boolean r13) {
        if (this.q != null) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("pk_description", "routine");
        mz0.n r1 = new mz0.n();
        Map<String, String> r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        List<Object> r4 = r1.b;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r3.a);
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((mz0.i) ((f80.a) r7)).w3("livesdk_pk_record_click", r1.a, r1.b);
        DataCenter r8 = this.p;
        if (r8 == null) goto L13;
        com.bytedance.android.live.revlink.impl.control.dialog.r r9 = this.d;
        int r10 = InteractPkRecordFragmentNew.y;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r14 = this.q;
        if (r14 == null) goto L10;
        int r15 = r14.getSkinType();
    L11:
        r9.zD(InteractPkRecordFragmentNew.a.a(r9, r8, r15, r12, r13, false, "pk_banner"));
        return;
    L10:
        r15 = 0;
        goto L11
    }

    public final void ka0(boolean r3, boolean r4) {
        if (r3 == true) goto L5;
    L11:
        if (r3 == true) goto L13;
    L15:
        this.L = r4;
        if (r4 != true) goto L19;
        a1.m(this.l, 2131251320);
        return;
    L19:
        if (((Boolean) l51.a.N0.getValue(null, l51.a.a[103(0x67, float:1.44E-43)])).booleanValue() == true) goto L21;
        a1.m(this.l, 2131251321);
        return;
    L21:
        a1.m(this.l, 2131251319);
        return;
    L13:
        if (r4 != this.L) goto L15;
        return;
    L5:
        if (this.M == true) goto L11;
        com.bytedance.android.live.revlink.impl.precisefind.a r1 = MultiPkPreciseFindContext.Companion.a();
        if (r1 == null) goto L11;
        if (r1.Ip() != true) goto L11;
        this.M = true;
        ia0("show", r4);
        goto L11
    }

    public final void ma0(TabLayout.Tab r9, boolean r10) {
        if (r9 == null) goto L4;
        CharSequence r0 = r9.getText();
    L5:
        String r1 = String.valueOf(r0);
        int r2 = r1.length() - 1;
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 > r2) goto L21;
        if (r5 == true) goto L9;
        int r6 = r4;
    L11:
        if (Intrinsics.compare(r1.charAt(r6), 32) > 0) goto L13;
        boolean r7 = true;
    L14:
        if (r5 == false) goto L15;
        if (r7 == false) goto L21;
        r2 = r2 - 1;
        goto L6
    L15:
        if (r7 == false) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        r5 = true;
        goto L6
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = r2;
    L21:
        String r3 = r1.subSequence(r4, r2 + 1).toString();
        SpannableString r8 = new SpannableString(r3);
        r8.setSpan(new StyleSpan(r10 ? 1 : 0), 0, r3.length(), 17);
        if (r9 == null) goto L35;
        r9.setText(r8);
        return;
    L35:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        final boolean r16 = ha0();
        IRoom r17 = this.i;
        Disposable r7 = null;
        if (r17 == null) goto L5;
        LiveMode r18 = r17.getStreamType();
    L7:
        if (r18 == LiveMode.SCREEN_RECORD) goto L9;
    L11:
        boolean r19 = false;
    L12:
        if (r16 == true) goto L15;
        if (r19 == true) goto L15;
        int r1 = 3;
    L17:
        this.t = r1;
        ba0(2131392847).setScrollEnable(this);
        ba0(2131392847).setOffscreenPageLimit(this.t);
        final FragmentManager r5 = getFragmentManager();
        if (r5 == null) goto L20;
        LinkNoScrollViewPager r12 = ba0(2131392847);
        b51.b r2 = b51.b.c0;
        r2.getClass();
        final boolean r4 = r19;
        final int r6 = ((Boolean) b51.b.r.getValue(r2, b51.b.a[16])).booleanValue() ? 1 : 0;
        r12.setAdapter(new AnonymousClass1(this, r16, r4, r5, r6));
    L20:
        ba0(2131392542).setBackgroundColor(-1);
        View r3 = LayoutInflater.from(getContext()).inflate(2131565494, null);
        this.k = r3;
        f0 r8 = new f0();
        this.H = r8;
        r8.a = r3;
        TabLayout r9 = r3.findViewById(2131387986);
        TextView r10 = (TextView) r3.findViewById(2131365424);
        this.m = r3.findViewById(2131389222);
        this.l = r3.findViewById(2131389198);
        ka0(false, this.L);
        View r13 = r3.findViewById(2131389200);
        this.n = r13;
        if (this.J == false) goto L24;
        if (r13 == null) goto L24;
        r13.setBackground(s1.m(2131252592));
    L24:
        this.o = r3.findViewById(2131385967);
        if (r16 == false) goto L35;
        if (r10 == null) goto L109;
        i41.a r110 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r110 != null) goto L30;
    L32:
        String r111 = s1.B(2131918016);
    L33:
        r10.setText(r111);
        goto L109
    L30:
        if (r110.f != true) goto L32;
        r111 = s1.B(2131917862);
    L109:
        TabLayout r112 = r3.findViewById(2131387986);
        if (r112 == null) goto L112;
        r112.setSelectedTabIndicatorColor(0);
    L112:
        TabLayout r113 = r3.findViewById(2131387986);
        if (r113 == null) goto L115;
        r113.setSelectedTabIndicatorHeight(0);
    L115:
        r3.findViewById(2131385953).setOnClickListener(new i(this, r3));
        HSImageView r114 = this.l;
        if (r114 == null) goto L118;
        r114.setOnClickListener(new j(this));
    L118:
        View r115 = this.m;
        if (r115 == null) goto L121;
        r115.setOnClickListener(new k(this));
    L121:
        View r116 = this.n;
        if (r116 == null) goto L124;
        r116.setOnClickListener(new l(this));
    L124:
        b51.b r117 = b51.b.c0;
        r117.getClass();
        if (((Number) b51.b.q.getValue(r117, b51.b.a[15])).intValue() <= 0) goto L135;
        View r118 = this.m;
        if (r118 == null) goto L129;
        r118.setVisibility(0);
    L129:
        View r119 = this.n;
        if (r119 == null) goto L132;
        r119.setVisibility(0);
    L132:
        la0(0);
        View r120 = this.o;
        if (r120 == null) goto L135;
        r120.setVisibility(8);
    L135:
        ViewGroup r121 = (ViewGroup) r3.findViewById(2131382366);
        this.K = r121;
        if (r121 == null) goto L139;
        r121.setOnClickListener(new m(this));
    L139:
        if (TextUtils.isEmpty(this.I) == false) goto L141;
    L149:
        ba0(2131392847).addOnPageChangeListener(new AnonymousClass2(this));
        jy0.b.c("ttlive_pk", "AnchorInteractContainerFragment onCreateView mDefaultItem = " + this.j + " isInLink = " + fa0(), null, 4);
        if (r16 == false) goto L152;
    L187:
        LinkRevPanelDataContext r122 = LinkRevPanelDataContext.Companion.getContext();
        if (r122 == null) goto L194;
        com.bytedance.live.datacontext.m<Boolean> r123 = r122.isOftenLinkList();
        if (r123 == null) goto L194;
        Observable r124 = r123.a();
        if (r124 == null) goto L194;
        r7 = r124.subscribe(new e(this));
    L194:
        this.B = r7;
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkDegradeForNative("anchor_invite_panel");
        return;
    L152:
        if (fa0() == true) goto L160;
        int r125 = this.j;
        KProperty[] r126 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        if (r125 == 0) goto L160;
        d31.e r127 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r127 == null) goto L159;
        r127.e();
    L159:
        ba0(2131392847).setCurrentItem(1);
    L161:
        int r128 = this.t;
        int r129 = 0;
    L162:
        if (r129 >= r128) goto L184;
        if (r129 != ba0(2131392847).getCurrentItem()) goto L174;
        View r0 = this.k;
        if (r0 == null) goto L168;
        View r20 = r0.findViewById(2131387986);
    L169:
        TabLayout r22 = (TabLayout) r20;
        if (r22 == null) goto L172;
        TabLayout.Tab r23 = r22.getTabAt(r129);
    L173:
        ma0(r23, true);
    L183:
        r129 = r129 + 1;
        goto L162
    L172:
        r23 = null;
        goto L173
    L168:
        r20 = null;
        goto L169
    L174:
        View r24 = this.k;
        if (r24 == null) goto L177;
        View r25 = r24.findViewById(2131387986);
    L178:
        TabLayout r26 = (TabLayout) r25;
        if (r26 == null) goto L181;
        TabLayout.Tab r27 = r26.getTabAt(r129);
    L182:
        ma0(r27, false);
        goto L183
    L181:
        r27 = null;
        goto L182
    L177:
        r25 = null;
        goto L178
    L184:
        p11.d r130 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r130 == null) goto L187;
        r130.b();
    L160:
        ja0();
        LinkNoScrollViewPager r131 = ba0(2131392847);
        KProperty[] r132 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r131.setCurrentItem(0);
        goto L161
    L141:
        if (this.N == true) goto L149;
        IRoom r133 = this.i;
        if (r133 == null) goto L145;
        LiveMode r134 = r133.getStreamType();
    L147:
        if (r134 == LiveMode.SCREEN_RECORD) goto L149;
        ea0();
        goto L149
    L145:
        r134 = null;
        goto L147
    L35:
        if (r19 == false) goto L46;
        if (r10 == null) goto L109;
        com.bytedance.android.live.revlink.impl.global.c r135 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r135 == null) goto L44;
        i41.a r136 = r135.getAutoMatchManager();
        if (r136 == null) goto L44;
        if (r136.f != true) goto L44;
        String r137 = s1.B(2131917862);
    L45:
        r10.setText(r137);
    L44:
        r137 = s1.B(2131917479);
        goto L45
    L46:
        int r138 = this.t;
    L47:
        int r28 = r138 - 1;
        if (r138 <= 0) goto L52;
        if (r9 == null) goto L51;
        r9.addTab(r9.newTab());
    L51:
        r138 = r28;
        goto L47
    L52:
        TabLayout r139 = r3.findViewById(2131387986);
        if (r139 == null) goto L55;
        r139.setupWithViewPager(ba0(2131392847));
    L55:
        TabLayout r140 = r3.findViewById(2131387986);
        if (r140 == null) goto L60;
        KProperty[] r29 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r141 = r140.getTabAt(1);
        if (r141 == null) goto L60;
        r141.setText(s1.B(2131917480));
    L60:
        TabLayout r142 = r3.findViewById(2131387986);
        if (r142 == null) goto L71;
        KProperty[] r30 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r143 = r142.getTabAt(2);
        if (r143 == null) goto L71;
        f0 r32 = this.H;
        if (r32 != null) goto L67;
    L69:
        CharSequence r33 = "";
    L70:
        r143.setText(r33);
        goto L71
    L67:
        if (r32.c != true) goto L69;
        r33 = f0.a();
    L71:
        TabLayout r144 = r3.findViewById(2131387986);
        if (r144 == null) goto L76;
        KProperty[] r34 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r145 = r144.getTabAt(0);
        if (r145 == null) goto L76;
        r145.setText(s1.B(2131917479));
    L76:
        r3.a(r3.findViewById(2131385953), s1.B(2131922469));
        TabLayout r146 = r3.findViewById(2131387986);
        if (r146 == null) goto L79;
        r146.addOnTabSelectedListener(new com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.e(this));
    L79:
        TabLayout r147 = r3.findViewById(2131387986);
        if (r147 == null) goto L82;
        KProperty[] r35 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r148 = r147.getTabAt(1);
    L83:
        Object r149 = JavaCalls.getField(r148, "view");
        if ((r149 instanceof View) == true) goto L86;
    L89:
        TabLayout r150 = r3.findViewById(2131387986);
        if (r150 == null) goto L92;
        KProperty[] r36 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r151 = r150.getTabAt(0);
    L93:
        Object r152 = JavaCalls.getField(r151, "view");
        if ((r152 instanceof View) == true) goto L96;
    L99:
        TabLayout r153 = r3.findViewById(2131387986);
        if (r153 == null) goto L102;
        KProperty[] r37 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r154 = r153.getTabAt(2);
    L103:
        Object r155 = JavaCalls.getField(r154, "view");
        if ((r155 instanceof View) == false) goto L109;
        if (d51.c.A0.r().n9() == false) goto L108;
        View r38 = (View) r155;
        r38.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        r38.setMinimumWidth(0);
    L108:
        ((View) r155).setOnTouchListener(new h(this, r3));
        goto L109
    L102:
        r154 = null;
        goto L103
    L96:
        if (d51.c.A0.r().n9() == false) goto L98;
        View r39 = (View) r152;
        r39.setPadding(s1.f(12.0f), 0, s1.f(5.0f), 0);
        r39.setMinimumWidth(0);
    L98:
        ((View) r152).setOnTouchListener(new g(this, r3));
        goto L99
    L92:
        r151 = null;
        goto L93
    L86:
        if (d51.c.A0.r().n9() == false) goto L88;
        View r40 = (View) r149;
        r40.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        r40.setMinimumWidth(0);
    L88:
        ((View) r149).setOnTouchListener(new com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.f(this, r3));
        goto L89
    L82:
        r148 = null;
    L15:
        r1 = 1;
        goto L17
    L9:
        if (Intrinsics.areEqual(a5.a.getValue(), Boolean.TRUE) == false) goto L11;
        r19 = true;
        goto L12
    L5:
        r18 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565493, r3, false);
    }
}
