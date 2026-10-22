package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.FrequentChatABHelper;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.AudioComposeSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.FrequentCommentSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.InteractivityShareSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.InterestSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.TruthSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.c1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.h1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.k1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.o1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.t1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.z;
import com.bytedance.android.livesdk.interactivity.common.InterceptLinearLayout;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.j0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/LivePortraitInputDialogV3;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/LiveInputDialogV3;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePortraitInputDialogV3 extends LiveInputDialogV3 implements Observer<KVData> {
    public static final /* synthetic */ int L = 0;
    public InputPanelSectionContainer A;
    public InputPanelSectionContainer B;
    public InputPanelSectionContainer C;
    public InputPanelSectionContainer D;
    public InputPanelSectionContainer E;
    public FrameLayout F;
    public InterceptLinearLayout G;
    public ValueAnimator H;
    public boolean I;
    public InputSectionType J;
    public final boolean K;
    public final long u;
    public final long v;
    public FrameLayout w;
    public InputPanelSectionContainer x;
    public InputPanelSectionContainer y;
    public InputPanelSectionContainer z;

    public static final class a {
        public static int a() {
            Lazy r0 = PublicScreenABHelper.a;
            IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
            IRoom r2 = null;
            if (r1 == null) goto L10;
            com.bytedance.android.livesdk.chatroom.o r3 = IRoomContextService.a.a(r1, null, 0, 3);
            if (r3 == null) goto L10;
            com.bytedance.live.datacontext.m r4 = r3.getRoom();
            if (r4 == null) goto L10;
            r2 = (IRoom) r4.getValue();
        L10:
            if (PublicScreenABHelper.b(r2) == false) goto L13;
            return s1.f(18.0f);
        L13:
            return s1.f(15.0f);
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ LivePortraitInputDialogV3 b;

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
                InputPanelSectionContainer r2 = this.a.b.C;
                if (r2 == null) goto L15;
                InputSectionType r3 = r2.getCurrentSectionType();
            L17:
                if (r3 == InputSectionType.NONE) goto L25;
                InputPanelSectionContainer r4 = this.a.b.C;
                if (r4 == null) goto L30;
                InputSectionType r5 = r4.getCurrentSectionType();
                if (r5 == null) goto L31;
                InputPanelSectionContainer r6 = this.a.b.C;
                if (r6 == null) goto L32;
                InputPanelSectionContainer.e(r6, r5, null, false, 6);
                return;
            L32:
                return;
            L31:
                return;
            L30:
                return;
            L25:
                InputPanelSectionContainer r7 = this.a.b.C;
                if (r7 == null) goto L34;
                InputPanelSectionContainer.e(r7, InputSectionType.KEYBOARD, null, false, 6);
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

        public b(EditText r1, LivePortraitInputDialogV3 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            r3.postDelayed(new a(this), this.b.u);
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
            ALogger.e("InputPanelV3", e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final int getLayoutId() {
        return 2131566045;
    }

    public final void aa0() {
        InputPanelSectionContainer r0 = this.C;
        CommentInputConfig.State r1 = null;
        if (r0 == null) goto L5;
        InputSectionType r2 = r0.getCurrentSectionType();
    L6:
        InputSectionType r3 = InputSectionType.NONE;
        boolean r4 = true;
        if (r2 == r3) goto L9;
        boolean r5 = true;
    L10:
        InputPanelSectionContainer r6 = this.C;
        if (r6 == null) goto L13;
        View r7 = r6.getCurrentSectionView();
    L14:
        InputPanelSectionContainer r8 = this.C;
        if (r8 == null) goto L17;
        int r9 = r8.getKeyboardHeight();
    L18:
        InputPanelSectionContainer r10 = this.C;
        if (r10 == null) goto L21;
        InputSectionType r11 = r10.getCurrentSectionType();
    L23:
        if (r11 != InputSectionType.KEYBOARD) goto L30;
        InputPanelSectionContainer r13 = this.C;
        if (r13 == null) goto L27;
        r9 = r13.getKeyboardHeight();
    L28:
        if (r9 == 0) goto L43;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r14 = l42.a.m;
        Integer r15 = Integer.valueOf(r9);
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r15);
    L43:
        InputPanelSectionContainer r16 = this.A;
        if (r16 == null) goto L46;
        InputSectionType r17 = r16.getCurrentSectionType();
    L47:
        if (r17 == r3) goto L53;
        InputPanelSectionContainer r18 = this.A;
        if (r18 == null) goto L51;
        int r19 = r18.getHeight();
    L52:
        r9 = r9 + r19;
        goto L53
    L51:
        r19 = 0;
    L53:
        InputPanelSectionContainer r20 = this.B;
        if (r20 == null) goto L56;
        InputSectionType r21 = r20.getCurrentSectionType();
    L57:
        if (r21 == r3) goto L63;
        InputPanelSectionContainer r23 = this.B;
        if (r23 == null) goto L61;
        int r24 = r23.getHeight();
    L62:
        r9 = r9 + r24;
        goto L63
    L61:
        r24 = 0;
    L63:
        InputPanelSectionContainer r25 = this.E;
        if (r25 == null) goto L66;
        InputSectionType r26 = r25.getCurrentSectionType();
    L67:
        if (r26 == r3) goto L73;
        InputPanelSectionContainer r27 = this.E;
        if (r27 == null) goto L71;
        int r28 = r27.getHeight();
    L72:
        r9 = r9 + r28;
        goto L73
    L71:
        r28 = 0;
    L73:
        InputPanelSectionContainer r29 = this.z;
        if (r29 == null) goto L76;
        InputSectionType r30 = r29.getCurrentSectionType();
    L77:
        if (r30 == null) goto L85;
        int r31 = f.c[r30.ordinal()];
        if (r31 != 1) goto L82;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r33 = this.g;
        if (r33 == null) goto L85;
        int r34 = r33.y();
    L95:
        int r35 = r9 + r34;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r36 = this.g;
        if (r36 == null) goto L98;
        r36.u0(r35);
    L98:
        i40.h.c("send LiveInputEvent,height=" + r35 + ",visibility = " + r5, true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r37 = this.g;
        if (r37 == null) goto L113;
        CommentFlowContext r38 = r37.S();
        if (r38 == null) goto L106;
        CommentInputConfig r39 = r38.d;
        if (r39 == null) goto L106;
        r1 = r39.l;
    L106:
        if (r1 != CommentInputConfig.State.ForceOpen) goto L109;
    L107:
        boolean r40 = true;
    L111:
        if (r40 != true) goto L113;
    L114:
        i1 r41 = new i1(r35, r5, r4);
        PublicScreenTraceMonitor.m("LiveInputDialog.send@" + r41.hashCode());
        xs2.b.a().post(r41);
        return;
    L109:
        if (r1 != CommentInputConfig.State.ForeClose) goto L107;
        r40 = false;
    L113:
        r4 = false;
        goto L114
    L82:
        if (r31 != 2) goto L84;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r43 = this.g;
        if (r43 == null) goto L85;
        r34 = r43.n();
        goto L95
    L84:
        if (r31 != 3) goto L85;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r44 = this.g;
        if (r44 == null) goto L85;
        r34 = r44.B();
    L85:
        r34 = 0;
        goto L95
    L76:
        r30 = null;
        goto L77
    L66:
        r26 = null;
        goto L67
    L56:
        r21 = null;
        goto L57
    L46:
        r17 = null;
        goto L47
    L27:
        r9 = 0;
        goto L28
    L30:
        InputPanelSectionContainer r45 = this.C;
        if (r45 == null) goto L33;
        int r46 = r45.getHeight();
    L34:
        if (r46 <= 0) goto L39;
        InputPanelSectionContainer r47 = this.C;
        if (r47 == null) goto L38;
        r9 = r47.getHeight();
        goto L43
    L38:
        r9 = 0;
        goto L43
    L39:
        if (r7 == null) goto L43;
        ViewGroup.LayoutParams r48 = r7.getLayoutParams();
        if (r48 == null) goto L43;
        r9 = r48.height;
        goto L43
    L33:
        r46 = 0;
        goto L34
    L21:
        r11 = null;
        goto L23
    L17:
        r9 = 0;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void hideSoftKeyBoard() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.g;
        if (r0 == null) goto L10;
        EditText r1 = r0.a;
        if (r1 == null) goto L11;
        InputPanelSectionContainer r2 = this.C;
        if (r2 == null) goto L12;
        InputPanelSectionContainer.e(r2, InputSectionType.NONE, r1, false, 4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public LivePortraitInputDialogV3() {
        this.u = 100;
        this.v = 200;
        this.J = InputSectionType.NONE;
        this.K = this.r.b();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ValueAnimator r0 = this.H;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (((Boolean) j0.a.getValue()).booleanValue() == true) goto L8;
        xs2.b.a().post(new i1(0, false));
    L8:
        DataCenter r1 = this.j;
        if (r1 == null) goto L12;
        r1.removeObserver(this);
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        InputPanelSectionContainer r0 = this.C;
        if (r0 == null) goto L12;
        MeasureLinearLayout r1 = this.f;
        if (r1 == null) goto L13;
        i40.b r2 = r1.getKeyBoardObservable();
        if (r2 == null) goto L14;
        List r3 = r2.b;
        if (r3 == null) goto L15;
        ((ArrayList) r3).remove(r0);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.I == true) goto L12;
        InputPanelSectionContainer r0 = this.C;
        if (r0 == null) goto L12;
        MeasureLinearLayout r1 = this.f;
        if (r1 == null) goto L12;
        i40.b r2 = r1.getKeyBoardObservable();
        if (r2 == null) goto L12;
        r2.b(r0);
    L12:
        if (this.m == false) goto L20;
        InputPanelSectionContainer r3 = this.C;
        if (r3 == null) goto L16;
        InputSectionType r4 = r3.getCurrentSectionType();
    L18:
        if (r4 == InputSectionType.KEYBOARD) goto L20;
        this.m = false;
        Z90(this.v, 1, 5);
    L25:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.g;
        if (r5 == null) goto L34;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r6 = r5.V();
        if (r6 == null) goto L34;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r7 = r6.g;
        if (r7 == null) goto L34;
        Long r8 = r7.m;
        if (r8 == null) goto L34;
        long r9 = r8.longValue();
    L36:
        if (r9 <= 0) goto L46;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10 = this.g;
        if (r10 == null) goto L46;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r11 = r10.V();
        if (r11 == null) goto L46;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r13 = r11.g;
        if (r13 == null) goto L46;
        if (r13.s != true) goto L46;
        z32.f.b(PSRoomIndicatorNode.PortraitCommentPanelShowDelay, System.currentTimeMillis() - r9);
    L46:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r14 = this.g;
        if (r14 == null) goto L55;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r15 = r14.V();
        if (r15 == null) goto L55;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r16 = r15.g;
        if (r16 == null) goto L55;
        Long r17 = r16.n;
        if (r17 == null) goto L55;
        long r18 = r17.longValue();
    L57:
        if (r18 <= 0) goto L59;
        z32.f.b(PSRoomIndicatorNode.PortraitLongClickCommentPanelShowDelay, System.currentTimeMillis() - r18);
    L59:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r19 = this.d;
        if (r19 == null) goto L68;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r20 = r19.g;
        if (r20 != null) goto L64;
        return;
    L64:
        if (r20.u > 0) goto L66;
        return;
    L66:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.CommentPanelShowDelay, MapsKt.mapOf(new Pair[]{TuplesKt.to("delay_time", String.valueOf(System.currentTimeMillis() - r20.u)), TuplesKt.to("operate_source", r20.t.getSource())}));
        return;
    L68:
        return;
    L55:
        r18 = 0;
    L34:
        r9 = 0;
        goto L36
    L16:
        r4 = null;
    L20:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r21 = this.g;
        if (r21 == null) goto L25;
        EditText r23 = r21.a;
        if (r23 == null) goto L25;
        r23.post(new c(r23));
        r23.setOnFocusChangeListener(new b(r23, this));
        goto L25
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void U90(MeasureLinearLayout r6) {
        Intrinsics.checkNotNullParameter(r6, "layout");
        this.w = (FrameLayout) r6.findViewById(2131381796);
        MeasureLinearLayout r0 = r6.findViewById(2131384840);
        this.f = r0;
        if (this.K == false) goto L6;
        if (r0 == null) goto L6;
        r0.setKeyBoardObservable(new i40.i(r0, this.s, this.t, com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorKeyboard));
    L6:
        this.x = (InputPanelSectionContainer) r6.findViewById(2131375401);
        this.y = (InputPanelSectionContainer) r6.findViewById(2131375399);
        this.z = (InputPanelSectionContainer) r6.findViewById(2131375396);
        this.A = (InputPanelSectionContainer) r6.findViewById(2131375393);
        this.B = (InputPanelSectionContainer) r6.findViewById(2131375394);
        this.C = (InputPanelSectionContainer) r6.findViewById(2131375392);
        this.D = (InputPanelSectionContainer) r6.findViewById(2131375400);
        this.F = (FrameLayout) r6.findViewById(2131373275);
        this.G = (InterceptLinearLayout) r6.findViewById(2131363990);
        this.E = (InputPanelSectionContainer) r6.findViewById(2131375398);
        InputPanelSectionContainer r7 = this.x;
        if (r7 == null) goto L9;
        ((ArrayList) this.i).add(r7);
    L9:
        InputPanelSectionContainer r8 = this.x;
        if (r8 == null) goto L12;
        ((ArrayList) this.i).add(r8);
    L12:
        InputPanelSectionContainer r9 = this.z;
        if (r9 == null) goto L15;
        ((ArrayList) this.i).add(r9);
    L15:
        InputPanelSectionContainer r10 = this.A;
        if (r10 == null) goto L18;
        ((ArrayList) this.i).add(r10);
    L18:
        InputPanelSectionContainer r11 = this.B;
        if (r11 == null) goto L21;
        ((ArrayList) this.i).add(r11);
    L21:
        InputPanelSectionContainer r13 = this.C;
        if (r13 == null) goto L24;
        ((ArrayList) this.i).add(r13);
    L24:
        InputPanelSectionContainer r14 = this.D;
        if (r14 == null) goto L27;
        ((ArrayList) this.i).add(r14);
    L27:
        InputPanelSectionContainer r15 = this.E;
        if (r15 == null) goto L31;
        ((ArrayList) this.i).add(r15);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void W90(MeasureLinearLayout r64) {
        Intrinsics.checkNotNullParameter(r64, "layout");
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e r4 = new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e();
        d1 r3 = new d1();
        x r1 = new x();
        DanmakuSectionProvider r0 = new DanmakuSectionProvider();
        z r13 = new z();
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a r8 = new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a();
        AudioComposeSectionProvider r11 = new AudioComposeSectionProvider();
        t1 r10 = new t1();
        e0 r15 = new e0();
        InteractivityShareSectionProvider r7 = new InteractivityShareSectionProvider();
        c1 r6 = new c1();
        FrequentCommentSectionProvider r14 = new FrequentCommentSectionProvider();
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.s1 r9 = new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.s1(this.j, this);
        h1 r16 = new h1();
        b1 r2 = new b1();
        k1 r17 = new k1();
        a1 r18 = new a1();
        TruthSectionProvider r19 = new TruthSectionProvider();
        InterestSectionProvider r110 = new InterestSectionProvider();
        o1 r111 = new o1();
        HashSet r5 = new HashSet();
        InputSectionType r112 = InputSectionType.SHADOW;
        r5.add(r112);
        InputPanelSectionContainer r20 = this.x;
        if (r20 == null) goto L5;
        r20.setSupportSections(r5);
    L5:
        InputPanelSectionContainer r21 = this.y;
        if (r21 == null) goto L8;
        r21.setSupportSections(SetsKt.setOf(InputSectionType.SECRET_CHAT));
    L8:
        HashSet r23 = new HashSet();
        InputSectionType r24 = InputSectionType.WORD_ASSOCIATE;
        r23.add(r24);
        InputSectionType r25 = InputSectionType.DANMAKU;
        r23.add(r25);
        r23.add(InputSectionType.MENTION);
        InputPanelSectionContainer r26 = this.z;
        if (r26 == null) goto L11;
        r26.setSupportSections(r23);
    L11:
        HashSet r27 = new HashSet();
        InputSectionType r28 = InputSectionType.CONTENT;
        r27.add(r28);
        InputSectionType r29 = InputSectionType.EMPTY;
        r27.add(r29);
        InputPanelSectionContainer r30 = this.A;
        if (r30 == null) goto L14;
        r30.setSupportSections(r27);
    L14:
        HashSet r31 = new HashSet();
        InputSectionType r33 = InputSectionType.CONTROL_PORTRAIT;
        r31.add(r33);
        r31.add(r25);
        r31.add(r29);
        InputPanelSectionContainer r34 = this.B;
        if (r34 == null) goto L17;
        r34.setSupportSections(r31);
    L17:
        HashSet r35 = new HashSet();
        InputSectionType r36 = InputSectionType.EMOJI;
        r35.add(r36);
        r35.add(InputSectionType.KEYBOARD);
        r35.add(InputSectionType.AUDIO);
        r35.add(InputSectionType.AUDIO2TEXT);
        InputSectionType r37 = InputSectionType.AUDIO_COMPOSE;
        r35.add(r37);
        InputSectionType r113 = InputSectionType.VIDEO;
        r35.add(r113);
        InputSectionType r114 = InputSectionType.INTERACTIVITY_SHARE;
        r35.add(r114);
        InputSectionType r115 = InputSectionType.FREQUENT_CHAT;
        r35.add(r115);
        r35.add(InputSectionType.MARK_HIGHLIGHT);
        fc2.d r38 = com.bytedance.android.livesdk.interactivity.comment.newinput.b.a;
        DataCenter r39 = this.j;
        if (r39 == null) goto L20;
        IRoom r310 = a0.n(r39);
    L21:
        if (r310 == null) goto L25;
        AudioComposeSectionProvider r311 = r11;
        boolean r116 = true;
        if (r310.isMediaRoom() != true) goto L26;
    L44:
        boolean r40 = false;
    L46:
        if (r40 == false) goto L48;
        r35.add(InputSectionType.MORE);
        r35.add(InputSectionType.INTEREST);
        r35.add(InputSectionType.TRUTH);
    L48:
        InputPanelSectionContainer r41 = this.C;
        if (r41 == null) goto L51;
        r41.setSupportSections(r35);
    L51:
        HashSet r43 = new HashSet();
        InputSectionType r117 = InputSectionType.SEND_PORTRAIT;
        r43.add(r117);
        r43.add(r29);
        InputPanelSectionContainer r44 = this.D;
        if (r44 == null) goto L54;
        r44.setSupportSections(r43);
    L54:
        InputPanelSectionContainer r45 = this.E;
        if (r45 == null) goto L57;
        HashSet r46 = new HashSet();
        r46.add(InputSectionType.QUICK_COMMENT);
        Unit r47 = Unit.INSTANCE;
        r45.setSupportSections(r46);
    L57:
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r48 = r4.f;
        d1.d r49 = r3.c;
        x.a r50 = r1.c;
        DanmakuSectionProvider.c r118 = r0.h;
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r51 = r8.d;
        AudioComposeSectionProvider r53 = r311;
        AudioComposeSectionProvider.g r54 = r53.c;
        t1.d r55 = r10.c;
        e0.d r56 = r15.c;
        LivePortraitInputDialogV3$initFramework$2 r57 = new LivePortraitInputDialogV3$initFramework$2(this, r48, r0, r2, r10, r50, r118, r54, r49, r51, r55, r56, r48, r50, r118, r54, r49, r51, r55, r56, r2.c);
        this.g = r57;
        r57.b = System.currentTimeMillis();
        InputPanelSectionContainer r58 = this.A;
        if (r58 == null) goto L60;
        r58.a(r57, r4);
    L60:
        InputPanelSectionContainer r59 = this.A;
        if (r59 == null) goto L63;
        r59.a(r57, r13);
    L63:
        InputPanelSectionContainer r60 = this.A;
        if (r60 == null) goto L66;
        IRoom r61 = null;
        boolean r63 = false;
        InputPanelSectionContainer.e(r60, r28, null, false, 6);
    L67:
        InputPanelSectionContainer r65 = this.B;
        if (r65 == null) goto L71;
        r65.a(r57, r3);
    L71:
        if (r57.f0() == false) goto L75;
        InputPanelSectionContainer r66 = this.z;
        if (r66 == null) goto L75;
        r66.a(r57, r0);
    L75:
        InputPanelSectionContainer r67 = this.B;
        if (r67 == null) goto L78;
        r67.a(r57, r13);
    L78:
        InputPanelSectionContainer r68 = this.B;
        if (r68 == null) goto L81;
        InputPanelSectionContainer.e(r68, r33, r61, r63, 6);
    L81:
        InputPanelSectionContainer r69 = this.C;
        if (r69 == null) goto L84;
        r69.a(r57, r1);
    L84:
        InputPanelSectionContainer r70 = this.E;
        if (r70 == null) goto L87;
        r70.a(r57, r16);
    L87:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r71 = r57.V();
        if (r71 == null) goto L98;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r73 = r71.g;
        if (r73 == null) goto L98;
        LinkedList<IQuickCommentShowWord> r74 = r73.o;
        if (r74 == null) goto L98;
        if (r74.isEmpty() == true) goto L98;
        InputPanelSectionContainer r75 = this.E;
        if (r75 == null) goto L98;
        InputPanelSectionContainer.e(r75, InputSectionType.QUICK_COMMENT, r61, r63, 6);
    L98:
        CommentFlowContext r76 = r57.S();
        if (r76 == null) goto L101;
        IRoom r119 = r76.c;
    L103:
        if (r119 != CommentScene.SecretChat) goto L105;
        boolean r120 = true;
    L106:
        if (r120 == false) goto L114;
        InputPanelSectionContainer r77 = this.y;
        if (r77 == null) goto L110;
        r77.a(r57, r17);
    L110:
        InputPanelSectionContainer r78 = this.y;
        if (r78 == null) goto L114;
        InputPanelSectionContainer.e(r78, InputSectionType.SECRET_CHAT, r61, r63, 6);
    L114:
        if (r57.e0() == false) goto L116;
    L117:
        Integer r79 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r79 != null) goto L121;
    L122:
        InputPanelSectionContainer r80 = this.C;
        if (r80 == null) goto L126;
        r80.a(r57, r53);
    L126:
        if (r57.j0() == false) goto L131;
        InputPanelSectionContainer r81 = this.C;
        if (r81 == null) goto L131;
        r81.a(r57, r9);
    L131:
        if (r57.h0() == false) goto L135;
        InputPanelSectionContainer r83 = this.C;
        if (r83 == null) goto L135;
        r83.a(r57, r18);
    L135:
        InputPanelSectionContainer r84 = this.C;
        if (r84 == null) goto L138;
        r84.a(r57, r7);
    L138:
        InputPanelSectionContainer r85 = this.C;
        if (r85 == null) goto L141;
        r85.a(r57, r14);
    L141:
        InputPanelSectionContainer r86 = this.C;
        if (r86 == null) goto L144;
        r86.a(r57, r6);
    L144:
        InputPanelSectionContainer r87 = this.C;
        if (r87 == null) goto L147;
        r87.a(r57, r19);
    L147:
        InputPanelSectionContainer r88 = this.C;
        if (r88 == null) goto L150;
        r88.a(r57, r110);
    L150:
        InputPanelSectionContainer r89 = this.C;
        if (r89 == null) goto L153;
        h r90 = new h(this);
        Intrinsics.checkNotNullParameter(r90, "listener");
        r89.k.add(r90);
    L153:
        InputPanelSectionContainer r91 = this.x;
        if (r91 == null) goto L156;
        r91.a(r57, r111);
    L156:
        InputPanelSectionContainer r93 = this.x;
        if (r93 == null) goto L159;
        InputPanelSectionContainer.e(r93, r112, r61, r63, 6);
    L159:
        int r94 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.a;
        DataCenter r95 = r57.R();
        if (r95 == null) goto L162;
        IRoom r121 = a0.n(r95);
    L164:
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.a(r57, r121) == false) goto L168;
        InputPanelSectionContainer r96 = this.z;
        if (r96 == null) goto L168;
        r96.a(r57, r2);
    L168:
        CommentFlowContext r97 = r57.S();
        if (r97 == null) goto L173;
        CommentInputConfig r98 = r97.d;
        if (r98 == null) goto L173;
        IRoom r122 = r98.y;
    L175:
        if (r122 != CommentInputConfig.State.ForceOpen) goto L178;
    L182:
        boolean r123 = true;
    L184:
        if (r123 == false) goto L191;
        InputPanelSectionContainer r99 = this.z;
        if (r99 == null) goto L188;
        r99.a(r57, r10);
    L188:
        InputPanelSectionContainer r100 = this.z;
        if (r100 == null) goto L191;
        InputPanelSectionContainer.e(r100, r24, r61, r63, 2);
    L191:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r101 = r57.V();
        if (r101 == null) goto L244;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r102 = r101.g;
        if (r102 == null) goto L244;
        String r103 = r102.p;
        if (r103 == null) goto L244;
        if (Intrinsics.areEqual(r103, DefaultLandingPanel.Video.getPanel()) == true) goto L238;
        if (Intrinsics.areEqual(r103, InputFunctionEnum.ChatInputCarrier_Video.getLogValue()) == true) goto L238;
        if (Intrinsics.areEqual(r103, DefaultLandingPanel.Audio.getPanel()) == false) goto L214;
        if (r57.c0() == false) goto L207;
    L209:
        InputPanelSectionContainer r104 = this.C;
        if (r104 == null) goto L212;
        InputPanelSectionContainer.e(r104, r37, r61, r63, 6);
    L212:
        r57.s(InputFunctionEnum.ChatInputCarrier_Audio);
        goto L244
    L207:
        if (r57.e0() == true) goto L209;
    L214:
        if (Intrinsics.areEqual(r103, DefaultLandingPanel.Collection.getPanel()) == false) goto L223;
        if (r57.i0() == false) goto L244;
        InputPanelSectionContainer r105 = this.C;
        if (r105 == null) goto L221;
        InputPanelSectionContainer.e(r105, r114, r61, r63, 6);
    L221:
        r57.s(InputFunctionEnum.ChatInputCarrier_Share);
        goto L244
    L223:
        if (Intrinsics.areEqual(r103, DefaultLandingPanel.FastComment.getPanel()) == false) goto L232;
        if (FrequentChatABHelper.a(r57) == false) goto L244;
        InputPanelSectionContainer r106 = this.C;
        if (r106 == null) goto L230;
        InputPanelSectionContainer.e(r106, r115, r61, r63, 6);
    L230:
        r57.s(InputFunctionEnum.ChatInputCarrier_FastChat);
        goto L244
    L232:
        if (Intrinsics.areEqual(r103, DefaultLandingPanel.Emoji.getPanel()) == false) goto L244;
        InputPanelSectionContainer r107 = this.C;
        if (r107 == null) goto L236;
        InputPanelSectionContainer.e(r107, r36, r61, r63, 6);
    L236:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.g("live_emoji", r57.d0(), r57.g0());
    L238:
        if (r57.j0() == false) goto L244;
        InputPanelSectionContainer r108 = this.C;
        if (r108 == null) goto L243;
        InputPanelSectionContainer.e(r108, r113, r61, r63, 6);
    L243:
        r57.s(InputFunctionEnum.ChatInputCarrier_Video);
    L244:
        InputPanelSectionContainer r109 = this.D;
        if (r109 == null) goto L247;
        r109.a(r57, r15);
    L247:
        InputPanelSectionContainer r124 = this.D;
        if (r124 == null) goto L250;
        r124.a(r57, r13);
    L250:
        InputPanelSectionContainer r125 = this.D;
        if (r125 == null) goto L254;
        InputPanelSectionContainer.e(r125, r117, r61, r63, 6);
        return;
    L254:
        return;
    L178:
        if (r122 != CommentInputConfig.State.ForeClose) goto L181;
    L183:
        r123 = false;
        goto L184
    L181:
        if (r57.V() == null) goto L183;
    L173:
        r122 = r61;
        goto L175
    L162:
        r121 = r61;
        goto L164
    L121:
        if (r79.intValue() == 2) goto L126;
    L116:
        if (r57.c0() == false) goto L126;
    L105:
        r120 = false;
        goto L106
    L101:
        r119 = r61;
        goto L103
    L66:
        r61 = null;
        r63 = false;
    L26:
        if (r310 == null) goto L31;
        if (r310.isMergeVSRoom() == r116) goto L44;
    L31:
        if (com.bytedance.android.livesdk.utils.c1.b(r39) == false) goto L33;
    L36:
        boolean r126 = true;
    L37:
        if (r126 == true) goto L44;
        fc2.d r127 = com.bytedance.android.livesdk.interactivity.comment.newinput.b.a;
        if (r127.a() == false) goto L42;
    L45:
        r40 = true;
        goto L46
    L42:
        if (r127.b() == false) goto L44;
    L33:
        if (com.bytedance.android.livesdk.utils.c1.c(r39) == true) goto L36;
        r126 = false;
        goto L37
    L25:
        r311 = r11;
        r116 = true;
        goto L26
    L20:
        r310 = null;
        goto L21
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3.getKey(), "live_common_input_dialog_dismiss") == false) goto L9;
        dismissInputDialog();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        DataCenter r4 = this.j;
        if (r4 == null) goto L6;
        r4.observe("live_common_input_dialog_dismiss", this);
        return;
    }
}
