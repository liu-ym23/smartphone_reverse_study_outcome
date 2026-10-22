package com.bytedance.android.live.liveinteract.interactivesong.panel;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.voicechat.util.k;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusServiceImpl;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import fd2.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/i;", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectDialog extends BaseKtvDialogFragment implements com.bytedance.android.livesdk.ktvapi.model.mv.i<i> {
    public static final /* synthetic */ int x = 0;
    public MvSelectViewModel g;
    public com.bytedance.android.livesdk.ktvapi.model.mv.c h;
    public com.bytedance.android.livesdk.ktvapi.model.mv.h<?> i;
    public MvSelectTabView j;
    public ViewPager k;
    public TextView l;
    public FrameLayout m;
    public View n;
    public View o;
    public TextView p;
    public DialogFragment q;
    public m r;
    public MvSelectPagerAdapter s;
    public Function0<Unit> t;
    public boolean u;
    public String v;
    public final MvSelectDialog$clickListener$1 w;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MvSelectDialog a;
        public final /* synthetic */ int b;

        public b(MvSelectDialog r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.b;     // Catch: Throwable -> L10
            ViewPager r1 = this.a.k;     // Catch: Throwable -> L10
            if (r1 != null) goto L5;
        L6:
            ViewPager r2 = this.a.k;     // Catch: Throwable -> L10
            if (r2 == null) goto L17;
            r2.setCurrentItem(this.b);     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L5:
            if (r0 != r1.getCurrentItem()) goto L6;
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
    }

    public final String S90() {
        return "MvSelectDialog";
    }

    public final int getLayoutId() {
        return 2131566209;
    }

    public final int aa0() {
        MvSelectViewModel r0 = this.g;
        if (r0 == null) goto L11;
        i r1 = r0.getLastMvData();
        if (r1 == null) goto L11;
        IOrderSingMVInfo r2 = r1.a;
        if (r2 == null) goto L11;
        if (r2.isLocked() != true) goto L11;
        return 1;
    L11:
        MvSelectViewModel r3 = this.g;
        if (r3 == null) goto L17;
        i r4 = r3.getLastMvData();
        if (r4 == null) goto L17;
        if (r4.c != 1) goto L17;
    L23:
        return 3;
    L17:
        MvSelectViewModel r5 = this.g;
        if (r5 == null) goto L25;
        i r6 = r5.getLastMvData();
        if (r6 != null) goto L22;
        return 2;
    L22:
        if (r6.c == 2) goto L23;
        return 2;
    L25:
        return 2;
    }

    public final void ca0() {
        TextView r0 = this.p;
        if (r0 == null) goto L5;
        r0.setText(Z90());
    L5:
        View r1 = this.o;
        if (r1 != null) goto L8;
        return;
    L8:
        if (aa0() == 3) goto L10;
        int r2 = 2131249601;
    L11:
        r1.setBackground(s1.m(r2));
        return;
    L10:
        r2 = 2131249600;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectDialog$clickListener$1] */
    public MvSelectDialog() {
        this.u = true;
        this.v = "";
        this.w = new MvSelectDialog$clickListener$1(this);
    }

    public final String Z90() {
        int r0 = aa0();
        if (r0 == 1) goto L9;
        if (r0 == 3) goto L11;
        return s1.B(2131918134);
    L11:
        return s1.B(2131918139);
    L9:
        return s1.B(2131918142);
    }

    public final int da0(String r4) {
        MvSelectViewModel r0 = this.g;
        int r1 = 0;
        if (r0 == null) goto L18;
        MutableLiveData<g> r2 = r0.getMvSelectUIState();
        if (r2 == null) goto L18;
        g r3 = (g) r2.getValue();
        if (r3 == null) goto L18;
        List<IMVTab> r5 = r3.b;
        if (r5 == null) goto L18;
        Iterator<IMVTab> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r6.next().getName(), r4) == true) goto L18;
        r1 = r1 + 1;
        goto L12
    L17:
        r1 = -1;
    L18:
        ViewPager r7 = this.k;
        if (r7 == null) goto L21;
        r7.post(new b(this, r1));
    L21:
        return r1;
    }

    public final void ea0(i r5) {
        IOrderSingMVInfo r0 = r5.a;
        String r1 = null;
        if (r0 == null) goto L7;
        IMVBaseInfo r2 = r0.getMvBaseInfo();
        if (r2 == null) goto L7;
        String r3 = r2.getVid();
    L8:
        MvSelectViewModel r4 = this.g;
        if (r4 == null) goto L17;
        i r6 = r4.getLastMvData();
        if (r6 == null) goto L17;
        IOrderSingMVInfo r7 = r6.a;
        if (r7 == null) goto L17;
        IMVBaseInfo r8 = r7.getMvBaseInfo();
        if (r8 == null) goto L17;
        String r9 = r8.getVid();
    L19:
        if ((!Intrinsics.areEqual(r3, r9)) == false) goto L21;
        ba0("select", "mv_page");
    L21:
        MvSelectViewModel r10 = this.g;
        if (r10 == null) goto L24;
        r10.setLastMvData(r5);
    L24:
        InteractiveSongContext r11 = InteractiveSongContext.Companion.getContext();
        if (r11 == null) goto L38;
        MvSelectViewModel r12 = this.g;
        if (r12 == null) goto L37;
        MutableLiveData<g> r13 = r12.getMvSelectUIState();
        if (r13 == null) goto L37;
        g r14 = (g) r13.getValue();
        if (r14 == null) goto L37;
        f r15 = r14.c;
        if (r15 == null) goto L37;
        IMVTab r16 = r15.a;
        if (r16 == null) goto L37;
        r1 = r16.getName();
    L37:
        r11.setCurMvDialogSelectedMv(new h(r1, r5.a));
    L38:
        ca0();
        return;
    L17:
        r9 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static final void X90(final MvSelectDialog r6, int r7) {
        MvSelectViewModel r0 = r6.g;
        if (r0 == null) goto L90;
        MutableLiveData<g> r1 = r0.getMvSelectUIState();
        if (r1 == null) goto L91;
        g r2 = (g) r1.getValue();
        if (r2 == null) goto L92;
        final f r3 = r2.c;
        if (r3 == null) goto L94;
        MvSelectViewModel r4 = r6.g;
        if (r4 == null) goto L42;
        MutableLiveData<g> r5 = r4.getMvSelectUIState();
        if (r5 == null) goto L42;
        g r8 = (g) r5.getValue();
        if (r8 == null) goto L42;
        if (r8.b == null) goto L42;
        MvSelectViewModel r9 = r6.g;
        if (r9 == null) goto L27;
        MutableLiveData<g> r10 = r9.getMvSelectUIState();
        if (r10 == null) goto L27;
        g r11 = (g) r10.getValue();
        if (r11 == null) goto L27;
        List<IMVTab> r12 = r11.b;
    L28:
        Intrinsics.checkNotNull(r12);
        Iterator<IMVTab> r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L42;
        IMVTab r14 = r13.next();
        MvSelectViewModel r15 = r6.g;
        if (r15 == null) goto L30;
        Map<String, f> r16 = r15.getRequestCache();
        if (r16 == null) goto L30;
        f r17 = r16.get(r14.getName());
        if (r17 == null) goto L30;
        Iterator<i> r18 = r17.b.iterator();
    L40:
        if (r18.hasNext() == false) goto L30;
        r18.next().c = 0;
    L27:
        r12 = null;
    L42:
        Iterator<i> r19 = r3.b.iterator();
    L44:
        if (r19.hasNext() == false) goto L68;
        i r20 = r19.next();
        IOrderSingMVInfo r21 = r20.a;
        if (r21 == null) goto L50;
        IMVBaseInfo r22 = r21.getMvBaseInfo();
        if (r22 == null) goto L50;
        String r23 = r22.getVid();
    L51:
        MvSelectViewModel r24 = r6.g;
        if (r24 == null) goto L60;
        i r25 = r24.getLastMvData();
        if (r25 == null) goto L60;
        IOrderSingMVInfo r26 = r25.a;
        if (r26 == null) goto L60;
        IMVBaseInfo r27 = r26.getMvBaseInfo();
        if (r27 == null) goto L60;
        String r28 = r27.getVid();
    L62:
        if (Intrinsics.areEqual(r23, r28) == false) goto L44;
        r20.c = r7;
        MvSelectViewModel r29 = r6.g;
        if (r29 == null) goto L44;
        i r30 = r29.getLastMvData();
        if (r30 == null) goto L44;
        r30.c = r7;
    L60:
        r28 = null;
    L50:
        r23 = null;
        goto L51
    L68:
        int r31 = r6.da0(r3.a.getName());
        MvSelectPagerAdapter r32 = r6.s;
        if (r32 == null) goto L93;
        r32.f(r3, r31, true, new MvSelectDialog$updateMvData$1(r6, r3));
        return;
    L93:
        return;
    L94:
        return;
    L92:
        return;
    L91:
        return;
    }

    public static final void Y90(final MvSelectDialog r2, final IMVTab r3) {
        MvSelectTabView r0 = r2.j;
        if (r0 == null) goto L5;
        r0.r(r3.getName());
    L5:
        MvSelectViewModel r1 = r2.g;
        if (r1 == null) goto L12;
        Map<String, f> r4 = r1.getRequestCache();
        if (r4 == null) goto L12;
        f r5 = r4.get(r3.getName());
        if (r5 == null) goto L12;
        List<i> r6 = r5.b;
    L13:
        if (r6 == null) goto L30;
        MvSelectViewModel r7 = r2.g;
        if (r7 == null) goto L25;
        Map<String, f> r8 = r7.getRequestCache();
        if (r8 == null) goto L25;
        f r9 = r8.get(r3.getName());
        if (r9 == null) goto L25;
        List<i> r10 = r9.b;
        if (r10 == null) goto L25;
        if (r10.isEmpty() == true) goto L30;
    L25:
        MvSelectViewModel r11 = r2.g;
        if (r11 == null) goto L34;
        MutableLiveData<g> r12 = r11.getMvSelectUIState();
        if (r12 == null) goto L35;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r12, new MvSelectDialog$updateSelectedTab$1(r2, r3));
        return;
    L35:
        return;
    L34:
        return;
    L30:
        MvSelectViewModel r13 = r2.g;
        if (r13 == null) goto L37;
        r13.getMvList(r3);
        return;
    L37:
        return;
    L12:
        r6 = null;
        goto L13
    }

    public final boolean G70(int r1, Object r2) {
        Intrinsics.checkNotNullParameter((i) r2, "info");
        return false;
    }

    public final void ba0(String r12, String r13) {
        MvSelectViewModel r0 = this.g;
        if (r0 == null) goto L7;
        i r1 = r0.getLastMvData();
        if (r1 == null) goto L7;
        IOrderSingMVInfo r2 = r1.a;
    L8:
        MvSelectViewModel r3 = this.g;
        String r4 = "";
        if (r3 == null) goto L20;
        MutableLiveData<g> r5 = r3.getMvSelectUIState();
        if (r5 == null) goto L20;
        g r6 = (g) r5.getValue();
        if (r6 == null) goto L20;
        f r7 = r6.c;
        if (r7 == null) goto L20;
        IMVTab r8 = r7.a;
        if (r8 == null) goto L20;
        String r9 = r8.getName();
        if (r9 == null) goto L20;
    L21:
        if (r2 == null) goto L26;
        IMVBaseInfo r10 = r2.getMvBaseInfo();
        if (r10 == null) goto L26;
        String r11 = r10.getVid();
        if (r11 == null) goto L26;
    L28:
        if (r2 == null) goto L30;
        boolean r14 = r2.isHighQuality();
    L31:
        MvSelectViewModel r15 = this.g;
        if (r15 == null) goto L38;
        String r16 = r15.getItemId();
        if (r16 == null) goto L38;
        r4 = r16;
    L38:
        if (r2 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        InteractiveSongContext r18 = InteractiveSongContext.Companion.getContext();
        if (r18 != null) goto L46;
    L48:
        boolean r19 = false;
    L49:
        Intrinsics.checkNotNullParameter(r9, "mvTab");
        Intrinsics.checkNotNullParameter(r11, "mvId");
        Intrinsics.checkNotNullParameter(r4, "itemId");
        Intrinsics.checkNotNullParameter(r12, "buttonType");
        Intrinsics.checkNotNullParameter(r13, "requestPage");
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("mv_tab", r9);
        String r21 = "1";
        if (r19 == false) goto L52;
        Object r22 = "1";
    L53:
        r20.put("is_mv", r22);
        if (r14 == false) goto L56;
        Object r23 = "1";
    L57:
        r20.put("is_privileged_mv", r23);
        if (r17 == true) goto L61;
        r21 = "0";
    L61:
        r20.put("is_mv_available", r21);
        r20.put("button_type", r12);
        r20.put("mv_id", r11);
        r20.put("request_page", r13);
        r20.put("item_id", r4);
        k r110 = InteractiveSongLoggerKt.a();
        if (r110 == null) goto L65;
        j0 r111 = j0.l();
        int r24 = k.g;
        r111.sendLog("livesdk_anchor_ksong_mv_click", r110.a(r20, false), new Object[]{IRoom.class, x.class});
        return;
    L65:
        return;
    L56:
        r23 = "0";
        goto L57
    L52:
        r22 = "0";
        goto L53
    L46:
        if (r18.getCurHasMvIsPlaying() != true) goto L48;
        r19 = true;
        goto L49
    L40:
        if (r2.isLocked() == true) goto L42;
        r17 = true;
        goto L43
    L30:
        r14 = false;
    L26:
        r11 = "";
    L20:
        r9 = "";
    L7:
        r2 = null;
        goto L8
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r5, r6);
        View r7 = ((BaseKtvDialogFragment) this).f;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r8 = null;
        if (r7 == null) goto L5;
        MvSelectTabView r9 = (MvSelectTabView) r7.findViewById(2131380541);
    L6:
        this.j = r9;
        View r10 = ((BaseKtvDialogFragment) this).f;
        if (r10 == null) goto L9;
        ViewPager r11 = (ViewPager) r10.findViewById(2131380542);
    L10:
        this.k = r11;
        View r12 = ((BaseKtvDialogFragment) this).f;
        if (r12 == null) goto L13;
        TextView r13 = (TextView) r12.findViewById(2131380540);
    L14:
        this.l = r13;
        View r14 = ((BaseKtvDialogFragment) this).f;
        if (r14 == null) goto L17;
        FrameLayout r15 = (FrameLayout) r14.findViewById(2131380539);
    L18:
        this.m = r15;
        View r16 = ((BaseKtvDialogFragment) this).f;
        if (r16 == null) goto L21;
        TextView r17 = (TextView) r16.findViewById(2131380538);
    L22:
        this.p = r17;
        View r18 = ((BaseKtvDialogFragment) this).f;
        if (r18 == null) goto L25;
        View r19 = r18.findViewById(2131380537);
    L26:
        this.o = r19;
        if (this.k == null) goto L31;
        MvSelectPagerAdapter r20 = new MvSelectPagerAdapter();
        this.s = r20;
        ViewPager r0 = this.k;
        if (r0 == null) goto L31;
        r0.setAdapter(r20);
    L31:
        View r21 = ((BaseKtvDialogFragment) this).f;
        if (r21 == null) goto L37;
        ViewGroup.LayoutParams r1 = r21.getLayoutParams();
        if (r1 != null) goto L36;
        r1 = new ViewGroup.LayoutParams(-1, s1.f(600.0f));
    L36:
        r1.height = s1.f(600.0f);
        Unit r2 = Unit.INSTANCE;
        r21.setLayoutParams(r1);
    L37:
        TextView r22 = this.l;
        if (r22 == null) goto L40;
        r22.setOnClickListener(new MvSelectDialog$initView$3(this));
    L40:
        ca0();
        FrameLayout r23 = this.m;
        if (r23 == null) goto L43;
        r23.setOnClickListener(this.w);
    L43:
        LayoutInflater r24 = LayoutInflater.from(getContext());
        View r3 = ((BaseKtvDialogFragment) this).f;
        if ((r3 instanceof ViewGroup) == true) goto L46;
        r3 = null;
    L46:
        this.n = r24.inflate(2131566215, (ViewGroup) r3, false);
        MvSelectViewModel r25 = (MvSelectViewModel) ViewModelProviders.of(this).get(MvSelectViewModel.class);
        this.g = r25;
        if (r25 == null) goto L49;
        r25.setItemId(this.v);
    L49:
        this.r = jc1.k.n(IKtvService.class).getOpusPreviewDialogBuilder();
        Context r26 = getContext();
        if (r26 == null) goto L56;
        com.bytedance.android.livesdk.ktvapi.model.mv.d r4 = jc1.k.n(IKtvService.class).createOpusMvService();
        if (r4 == null) goto L54;
        OpusServiceImpl r27 = r4.build(r26);
    L55:
        this.h = r27;
        goto L56
    L54:
        r27 = null;
    L56:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r28 = this.h;
        if (r28 == null) goto L59;
        r8 = r28.a();
    L59:
        this.i = r8;
        MvSelectTabView r29 = this.j;
        if (r29 == null) goto L62;
        r29.setTabSelectedListener(new MvSelectDialog$initObserver$1(this));
    L62:
        MvSelectViewModel r30 = this.g;
        if (r30 == null) goto L67;
        MutableLiveData<g> r31 = r30.getMvSelectUIState();
        if (r31 == null) goto L67;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r31, this, MvSelectDialog$initObserver$2.INSTANCE, new d(this));
    L67:
        MvSelectViewModel r32 = this.g;
        if (r32 == null) goto L72;
        MutableLiveData<g> r33 = r32.getMvSelectUIState();
        if (r33 == null) goto L72;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r33, this, MvSelectDialog$initObserver$4.INSTANCE, new e(this));
    L72:
        ViewPager r34 = this.k;
        if (r34 == null) goto L75;
        r34.addOnPageChangeListener(new MvSelectDialog$initObserver$6(this));
    L75:
        MvSelectViewModel r35 = this.g;
        if (r35 == null) goto L79;
        r35.getMvTabList();
        return;
    L79:
        return;
    L25:
        r19 = null;
        goto L26
    L21:
        r17 = null;
        goto L22
    L17:
        r15 = null;
        goto L18
    L13:
        r13 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public final void G80(int r4, Object r5, IMvPreviewViewHolder r6, Function0 r7) {
        i r8 = (i) r5;
        Intrinsics.checkNotNullParameter(r8, "panel");
        Intrinsics.checkNotNullParameter(r6, "vh");
        Intrinsics.checkNotNullParameter(r7, "unSelectedCb");
        if (this.t != null) goto L40;
        MvSelectViewModel r9 = this.g;
        if (r9 == null) goto L40;
        Map<String, f> r10 = r9.getRequestCache();
        if (r10 == null) goto L40;
        MvSelectViewModel r11 = this.g;
        if (r11 == null) goto L18;
        MutableLiveData<g> r12 = r11.getMvSelectUIState();
        if (r12 == null) goto L18;
        g r13 = (g) r12.getValue();
        if (r13 == null) goto L18;
        IMVTab r14 = r13.a;
        if (r14 == null) goto L18;
        String r15 = r14.getName();
        if (r15 == null) goto L18;
    L19:
        final f r16 = r10.get(r15);
        if (r16 == null) goto L40;
        int r0 = 0;
        ((i) ListProtector.get(r16.b, 0)).b = false;
        MvSelectViewModel r17 = this.g;
        if (r17 == null) goto L37;
        MutableLiveData<g> r18 = r17.getMvSelectUIState();
        if (r18 == null) goto L37;
        g r19 = (g) r18.getValue();
        if (r19 == null) goto L37;
        List<IMVTab> r20 = r19.b;
        if (r20 == null) goto L37;
        Iterator<IMVTab> r21 = r20.iterator();
    L31:
        if (r21.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(r21.next().getName(), r16.a.getName()) == true) goto L37;
        r0 = r0 + 1;
        goto L31
    L36:
        r0 = -1;
    L37:
        MvSelectPagerAdapter r22 = this.s;
        if (r22 == null) goto L40;
        r22.f(r16, r0, true, new MvSelectDialog$onMvClick$$inlined$apply$lambda$1(r16, this));
    L18:
        r15 = "";
    L40:
        Function0<Unit> r23 = this.t;
        if (r23 == null) goto L43;
        Unit r24 = (Unit) r23.invoke();
    L43:
        ea0(r8);
        this.t = r7;
    }
}
