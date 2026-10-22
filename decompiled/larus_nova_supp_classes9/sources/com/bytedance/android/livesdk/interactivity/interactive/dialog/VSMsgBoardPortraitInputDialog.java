package com.bytedance.android.livesdk.interactivity.interactive.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VsMsgBoardBottomTipSectionProvider;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VsMsgBoardBottomTipSectionProvider$sectionBridge$1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.i;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.q;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import fq1.s;
import fq1.t;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.e;
import nq1.d;
import pm1.f;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/VSMsgBoardPortraitInputDialog;", "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/VSMsgBoardInputDialog;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardPortraitInputDialog extends VSMsgBoardInputDialog {
    public static final int x = 0;
    public final long m;
    public final long n;
    public VSInputPanelSectionContainer o;
    public VSInputPanelSectionContainer p;
    public VSInputPanelSectionContainer q;
    public VSInputPanelSectionContainer r;
    public VSInputPanelSectionContainer s;
    public VSInputPanelSectionContainer t;
    public View u;
    public SkinSelection v;
    public final CompositeDisposable w;

    public static final class a {
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ VSMsgBoardPortraitInputDialog b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void a() {
                if (this.a.b.isAdded() == true) goto L5;
                return;
            L5:
                if (this.a.b.getContext() == null) goto L35;
                FragmentActivity r0 = this.a.b.getActivity();
                if (r0 == null) goto L12;
                Window r1 = r0.getWindow();
                if (r1 == null) goto L12;
                r1.setSoftInputMode(48);
            L12:
                VSInputPanelSectionContainer r2 = this.a.b.s;
                if (r2 == null) goto L15;
                VSInputSectionType r3 = r2.getCurrentSectionType();
            L17:
                if (r3 == VSInputSectionType.NONE) goto L25;
                VSInputPanelSectionContainer r4 = this.a.b.s;
                if (r4 == null) goto L30;
                VSInputSectionType r5 = r4.getCurrentSectionType();
                if (r5 == null) goto L31;
                VSInputPanelSectionContainer r6 = this.a.b.s;
                if (r6 == null) goto L32;
                VSInputPanelSectionContainer.d(r6, r5, null, 6);
                return;
            L32:
                return;
            L31:
                return;
            L30:
                return;
            L25:
                VSInputPanelSectionContainer r7 = this.a.b.s;
                if (r7 == null) goto L34;
                VSInputPanelSectionContainer.d(r7, VSInputSectionType.KEYBOARD, null, 6);
                return;
            L34:
                return;
            L15:
                r3 = null;
                goto L17
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(EditText r1, VSMsgBoardPortraitInputDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            r3.postDelayed(new a(this), this.b.m);
            this.a.setOnFocusChangeListener(null);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ EditText a;

        public c(EditText r1) {
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
            ALogger.e("VSMsgBoardInputPanel", e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    public final Map<String, String> W90() {
        Pair[] r0 = new Pair[3];
        SkinSelection r1 = this.v;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L6;
        String r3 = r1.a;
        if (r3 == null) goto L6;
    L7:
        r0[0] = TuplesKt.to("skin_id", r3);
        SkinSelection r4 = this.v;
        if (r4 == null) goto L11;
        String r5 = r4.b;
        if (r5 == null) goto L11;
    L12:
        r0[1] = TuplesKt.to("badge_id", r5);
        int r6 = n82.c.a;
        t9 r7 = this.d;
        String r8 = null;
        if (r7 == null) goto L15;
        DataCenter r9 = r7.l;
    L16:
        e r10 = f.c();
        if (r10 == null) goto L21;
        ReplayDataContext r11 = r10.h(r9);
        if (r11 == null) goto L21;
        j r13 = r11.getVsMsgBoardDataContext();
    L23:
        if ((r13 instanceof j) == true) goto L26;
        r13 = null;
    L26:
        if (r13 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.msgboard.a r14 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r13.getValue();
        if (r14 == null) goto L29;
    L38:
        if (r14 == null) goto L51;
        IRoom r15 = r14.getRoom();
        if (r15 == null) goto L51;
        IEpisodeExtraInfo r16 = r15.getEpisodeExtra();
        if (r16 == null) goto L51;
        Map r17 = r16.getPrivilegeInfo();
        if (r17 == null) goto L51;
        PrivilegeInfo r18 = (PrivilegeInfo) r17.get(String.valueOf(5));
        if (r18 == null) goto L51;
        String r19 = String.valueOf(r18.entityid);
        if (r19 == null) goto L51;
        r8 = r19;
    L61:
        if (r8 == null) goto L64;
        r2 = r8;
    L64:
        r0[2] = TuplesKt.to("entity_id", r2);
        return MapsKt.mapOf(r0);
    L51:
        if (r14 == null) goto L61;
        Episode r20 = r14.getEpisode();
        if (r20 == null) goto L61;
        IMainEpisode r21 = r20.castToOrNull(IMainEpisode.class);
        if (r21 == null) goto L61;
        Map r23 = r21.getPrivilegeInfo();
        if (r23 == null) goto L61;
        PrivilegeInfo r24 = (PrivilegeInfo) r23.get(5);
        if (r24 == null) goto L61;
        r8 = String.valueOf(r24.entityid);
    L29:
        u r25 = r.u(r9, null, 2);
        if (r25 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.msgboard.a r26 = r25.L0();
    L34:
        if ((r26 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L36;
        r14 = null;
        goto L38
    L36:
        r14 = r26;
        goto L38
    L32:
        r26 = null;
    L21:
        r13 = null;
        goto L23
    L15:
        r9 = null;
    L11:
        r5 = BuildConfig.FLAVOR;
    L6:
        r3 = BuildConfig.FLAVOR;
        goto L7
    }

    static {
        x = s1.f(15.0f);
    }

    public final void X90() {
        t9 r0 = this.d;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        SkinSelection r2 = this.v;
        DataCenter r3 = null;
        if (r2 == null) goto L28;
        Set<String> r4 = r2.c;
        if (r4 == null) goto L28;
        Set<String> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r6 = r5.iterator();
    L18:
        if (r6.hasNext() == false) goto L26;
        String r7 = (String) r6.next();
        int r8 = n82.c.a;
        t9 r9 = this.d;
        if (r9 == null) goto L22;
        DataCenter r10 = r9.l;
    L24:
        if ((!n82.c.c(r7, r10)) == false) goto L18;
    L27:
        Boolean r11 = Boolean.valueOf(r1);
    L29:
        StringBuilder r13 = new StringBuilder();
        s r14 = t.a();
        if (r14 == null) goto L32;
        String r15 = r14.getCurrentUserId();
    L33:
        r13.append(r15);
        r13.append('_');
        int r16 = n82.c.a;
        t9 r17 = this.d;
        if (r17 == null) goto L36;
        r3 = r17.l;
    L36:
        r13.append(n82.c.f(r3));
        String r18 = r13.toString();
        boolean r19 = Intrinsics.areEqual(r11, Boolean.TRUE);
        String r20 = BuildConfig.FLAVOR;
        if (r19 == false) goto L39;
        ((HashMap) d.y.getValue()).put(r18, BuildConfig.FLAVOR);
        ((HashMap) d.z.getValue()).put(r18, BuildConfig.FLAVOR);
        return;
    L39:
        com.bytedance.android.livesdk.sharedpref.e r21 = d.y;
        HashMap r23 = (HashMap) r21.getValue();
        SkinSelection r24 = this.v;
        if (r24 == null) goto L43;
        String r25 = r24.a;
        if (r25 == null) goto L43;
    L44:
        r23.put(r18, r25);
        com.bytedance.android.livesdk.sharedpref.f.d(r21, r23);
        com.bytedance.android.livesdk.sharedpref.e r26 = d.z;
        HashMap r27 = (HashMap) r26.getValue();
        SkinSelection r28 = this.v;
        if (r28 == null) goto L50;
        String r29 = r28.b;
        if (r29 == null) goto L50;
        r20 = r29;
    L50:
        r27.put(r18, r20);
        com.bytedance.android.livesdk.sharedpref.f.d(r26, r27);
        return;
    L43:
        r25 = BuildConfig.FLAVOR;
        goto L44
    L32:
        r15 = null;
        goto L33
    L22:
        r10 = null;
    L26:
        r1 = false;
        goto L27
    L14:
        if (r5.isEmpty() == false) goto L16;
    L28:
        r11 = null;
        goto L29
    L5:
        if (r0.p != true) goto L7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final int getLayoutId() {
        t9 r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
    L11:
        return 2131566093;
    L9:
        if (r0.g != true) goto L11;
        return 2131566092;
    L5:
        if (r0.h != true) goto L7;
        return 2131566094;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void hideSoftKeyBoard() {
        k82.a r0 = this.g;
        if (r0 == null) goto L10;
        EditText r1 = r0.a;
        if (r1 == null) goto L11;
        VSInputPanelSectionContainer r2 = this.s;
        if (r2 == null) goto L12;
        VSInputPanelSectionContainer.d(r2, VSInputSectionType.NONE, r1, 4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public VSMsgBoardPortraitInputDialog() {
        this.m = 100;
        this.n = 200;
        this.v = new SkinSelection();
        this.w = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void dismissInputDialog() {
        super.dismissInputDialog();
        X90();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        CompositeDisposable r0 = this.w;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        CompositeDisposable r1 = this.w;
        if (r1 == null) goto L9;
        r1.clear();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        VSInputPanelSectionContainer r0 = this.s;
        if (r0 == null) goto L10;
        MeasureLinearLayout r1 = this.f;
        if (r1 == null) goto L10;
        i40.b r2 = r1.getKeyBoardObservable();
        if (r2 == null) goto L10;
        r2.b(r0);
    L10:
        if (this.k == false) goto L18;
        VSInputPanelSectionContainer r3 = this.s;
        if (r3 == null) goto L14;
        VSInputSectionType r4 = r3.getCurrentSectionType();
    L16:
        if (r4 == VSInputSectionType.KEYBOARD) goto L18;
        this.k = false;
        V90(this.n, 1, 5);
        return;
    L14:
        r4 = null;
    L18:
        k82.a r5 = this.g;
        if (r5 == null) goto L25;
        EditText r6 = r5.a;
        if (r6 == null) goto L26;
        r6.post(new c(r6));
        r6.setOnFocusChangeListener(new b(r6, this));
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void onSendSuccess() {
        super.onSendSuccess();
        this.v = new SkinSelection();
        X90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void T90(MeasureLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        this.o = (VSInputPanelSectionContainer) r2.findViewById(2131375401);
        this.p = (VSInputPanelSectionContainer) r2.findViewById(2131375393);
        this.q = (VSInputPanelSectionContainer) r2.findViewById(2131375397);
        this.r = (VSInputPanelSectionContainer) r2.findViewById(2131375394);
        this.s = (VSInputPanelSectionContainer) r2.findViewById(2131375392);
        this.t = (VSInputPanelSectionContainer) r2.findViewById(2131375391);
        this.u = r2.findViewById(2131367747);
        int r3 = n82.c.a;
        t9 r4 = this.d;
        if (r4 == null) goto L7;
        u9 r5 = r4.c;
        if (r5 == null) goto L7;
        String r6 = r5.c;
    L8:
        int r7 = n82.c.k(r6, -1);
        View r0 = this.u;
        if (r0 == null) goto L12;
        r0.setBackgroundColor(r7);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void U90(MeasureLinearLayout r35) {
        Intrinsics.checkNotNullParameter(r35, "layout");
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a r15 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a();
        q r13 = new q(getContext());
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j r14 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j();
        i r11 = new i();
        v r10 = new v(getContext());
        VsMsgBoardBottomTipSectionProvider r9 = new VsMsgBoardBottomTipSectionProvider(getContext());
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.t r8 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.t();
        HashSet r0 = new HashSet();
        VSInputSectionType r7 = VSInputSectionType.SHADOW;
        r0.add(r7);
        VSInputPanelSectionContainer r1 = this.o;
        if (r1 == null) goto L5;
        r1.setSupportSections(r0);
    L5:
        HashSet r2 = new HashSet();
        VSInputSectionType r6 = VSInputSectionType.CONTENT;
        r2.add(r6);
        VSInputPanelSectionContainer r3 = this.p;
        if (r3 == null) goto L8;
        r3.setSupportSections(r2);
    L8:
        nq1.b r16 = nq1.b.a;
        if (((Boolean) r16.getValue()).booleanValue() == false) goto L13;
        HashSet r4 = new HashSet();
        r4.add(VSInputSectionType.PUBLISH);
        VSInputPanelSectionContainer r5 = this.q;
        if (r5 == null) goto L13;
        r5.setSupportSections(r4);
    L13:
        HashSet r17 = new HashSet();
        VSInputSectionType r18 = VSInputSectionType.CONTROL_PORTRAIT;
        r17.add(r18);
        VSInputPanelSectionContainer r19 = this.r;
        if (r19 == null) goto L16;
        r19.setSupportSections(r17);
    L16:
        HashSet r20 = new HashSet();
        r20.add(VSInputSectionType.EMOJI);
        r20.add(VSInputSectionType.KEYBOARD);
        int r21 = n82.c.a;
        t9 r23 = this.d;
        if (r23 == null) goto L19;
        DataCenter r24 = r23.l;
    L21:
        if (n82.c.d(r24) == false) goto L25;
        r20.add(VSInputSectionType.PAID_LIVE_PACKAGE);
        r20.add(VSInputSectionType.BOTTOM_TIP);
        VSInputPanelSectionContainer r25 = this.t;
        if (r25 == null) goto L25;
        r25.setSupportSections(r20);
    L25:
        VSInputPanelSectionContainer r26 = this.s;
        if (r26 == null) goto L28;
        r26.setSupportSections(r20);
    L28:
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.c r27 = r15.e;
        if (r27 == null) goto L97;
        q.c r28 = r13.e;
        if (r28 == null) goto L95;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j.c r29 = r14.c;
        if (r29 == null) goto L93;
        i.a r30 = r11.c;
        if (r30 == null) goto L91;
        v.b r110 = r10.g;
        if (r110 == null) goto L89;
        VsMsgBoardBottomTipSectionProvider$sectionBridge$1 r111 = r9.h;
        if (r111 == null) goto L87;
        Observable r31 = xs2.b.a().b(RefreshVSMessageBoardDataEvent.class);
        if (r31 == null) goto L45;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j.c r210 = r29;
        q.c r211 = r28;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.c r212 = r27;
        VSInputSectionType r213 = r6;
        VSInputSectionType r214 = r18;
        Disposable r33 = r31.subscribe(new h82.a(this, r110, r27, r111, r210));
        if (r33 == null) goto L46;
        RxUtilKt.c(r33, this.w);
    L46:
        VSInputSectionType r215 = r213;
        h82.b r34 = new h82.b(this, r111, r212, r210, r110, r211, r30, r212, r211, r30, r210, r110, r111);
        this.g = r34;
        VSInputPanelSectionContainer r36 = this.p;
        if (r36 == null) goto L49;
        r36.a(r34, r15);
    L49:
        VSInputPanelSectionContainer r37 = this.p;
        if (r37 == null) goto L52;
        EditText r38 = null;
        VSInputPanelSectionContainer.d(r37, r215, null, 6);
    L54:
        if (((Boolean) r16.getValue()).booleanValue() == false) goto L61;
        VSInputPanelSectionContainer r39 = this.q;
        if (r39 == null) goto L58;
        r39.a(r34, r13);
    L58:
        VSInputPanelSectionContainer r40 = this.q;
        if (r40 == null) goto L61;
        VSInputPanelSectionContainer.d(r40, VSInputSectionType.PUBLISH, r38, 6);
    L61:
        VSInputPanelSectionContainer r41 = this.r;
        if (r41 == null) goto L64;
        r41.a(r34, r14);
    L64:
        VSInputPanelSectionContainer r43 = this.r;
        if (r43 == null) goto L67;
        VSInputPanelSectionContainer.d(r43, r214, r38, 6);
    L67:
        VSInputPanelSectionContainer r44 = this.s;
        if (r44 == null) goto L70;
        r44.a(r34, r11);
    L70:
        VSInputPanelSectionContainer r45 = this.s;
        if (r45 == null) goto L73;
        r45.a(r34, r10);
    L73:
        VSInputPanelSectionContainer r46 = this.t;
        if (r46 == null) goto L76;
        r46.a(r34, r9);
    L76:
        VSInputPanelSectionContainer r47 = this.s;
        if (r47 == null) goto L79;
        h82.c r48 = new h82.c(this);
        Intrinsics.checkNotNullParameter(r48, "listener");
        r47.j.add(r48);
    L79:
        VSInputPanelSectionContainer r49 = this.o;
        if (r49 == null) goto L82;
        r49.a(r34, r8);
    L82:
        VSInputPanelSectionContainer r50 = this.o;
        if (r50 == null) goto L98;
        VSInputPanelSectionContainer.d(r50, r7, r38, 6);
        return;
    L98:
        return;
    L52:
        r38 = null;
        goto L54
    L45:
        r210 = r29;
        r211 = r28;
        r212 = r27;
        r214 = r18;
        r213 = r6;
        goto L46
    L87:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardTipSectionBridge");
    L89:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardSkinSectionBridge");
    L91:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardEmojiSectionBridge");
    L93:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardPortraitControlSectionBridge");
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardPublishSectionBridge");
    L97:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardContentSectionBridge");
    L19:
        r24 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }
}
