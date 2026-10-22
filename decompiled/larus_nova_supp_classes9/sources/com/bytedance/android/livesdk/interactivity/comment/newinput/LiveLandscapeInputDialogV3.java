package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.h1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.j0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.o1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/LiveLandscapeInputDialogV3;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/LiveInputDialogV3;", "Lx22/b;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandscapeInputDialogV3 extends LiveInputDialogV3 {
    public static final /* synthetic */ int A = 0;
    public InputPanelSectionContainer u;
    public InputPanelSectionContainer v;
    public InputPanelSectionContainer w;
    public InputPanelSectionContainer x;
    public InputPanelSectionContainer y;
    public final boolean z;

    public static final class a {
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ LiveLandscapeInputDialogV3 b;

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
                InputPanelSectionContainer r2 = this.a.b.x;
                if (r2 == null) goto L15;
                InputSectionType r3 = r2.getCurrentSectionType();
            L17:
                if (r3 == InputSectionType.NONE) goto L25;
                InputPanelSectionContainer r4 = this.a.b.x;
                if (r4 == null) goto L30;
                InputSectionType r5 = r4.getCurrentSectionType();
                if (r5 == null) goto L31;
                InputPanelSectionContainer r6 = this.a.b.x;
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
                InputPanelSectionContainer r7 = this.a.b.x;
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

        public b(EditText r1, LiveLandscapeInputDialogV3 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            r3.postDelayed(new a(this), 100);
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

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final int getLayoutId() {
        return 2131566046;
    }

    static {
        s1.f(15.0f);
    }

    public final void aa0() {
        InputPanelSectionContainer r0 = this.x;
        InputSectionType r1 = null;
        if (r0 == null) goto L5;
        InputSectionType r2 = r0.getCurrentSectionType();
    L6:
        int r3 = 0;
        if (r2 == InputSectionType.NONE) goto L9;
        boolean r4 = true;
    L10:
        InputPanelSectionContainer r5 = this.x;
        if (r5 == null) goto L13;
        View r6 = r5.getCurrentSectionView();
    L14:
        InputPanelSectionContainer r7 = this.x;
        if (r7 == null) goto L17;
        int r8 = r7.getKeyboardHeight();
    L18:
        InputPanelSectionContainer r9 = this.x;
        if (r9 == null) goto L22;
        r1 = r9.getCurrentSectionType();
    L22:
        if (r1 != InputSectionType.KEYBOARD) goto L29;
        InputPanelSectionContainer r10 = this.x;
        if (r10 == null) goto L26;
        r3 = r10.getKeyboardHeight();
    L26:
        if (r3 == 0) goto L28;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r11 = l42.a.n;
        Integer r13 = Integer.valueOf(r3);
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r13);
    L28:
        r8 = r3;
    L41:
        xs2.b.a().post(new i1(r8, r4));
        return;
    L29:
        InputPanelSectionContainer r14 = this.x;
        if (r14 == null) goto L32;
        int r15 = r14.getHeight();
    L33:
        if (r15 <= 0) goto L37;
        InputPanelSectionContainer r16 = this.x;
        if (r16 == null) goto L28;
        r3 = r16.getHeight();
        goto L28
    L37:
        if (r6 == null) goto L41;
        ViewGroup.LayoutParams r17 = r6.getLayoutParams();
        if (r17 == null) goto L41;
        r8 = r17.height;
        goto L41
    L32:
        r15 = 0;
        goto L33
    L17:
        r8 = 0;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public LiveLandscapeInputDialogV3() {
        this.z = this.r.c();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        InputPanelSectionContainer r0 = this.x;
        if (r0 == null) goto L10;
        MeasureLinearLayout r1 = this.f;
        if (r1 == null) goto L10;
        i40.b r2 = r1.getKeyBoardObservable();
        if (r2 == null) goto L10;
        r2.b(r0);
    L10:
        if (this.m == false) goto L18;
        InputPanelSectionContainer r3 = this.x;
        if (r3 == null) goto L14;
        InputSectionType r4 = r3.getCurrentSectionType();
    L16:
        if (r4 == InputSectionType.KEYBOARD) goto L18;
        this.m = false;
        Z90(200, 1, 5);
    L23:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.g;
        if (r5 == null) goto L32;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r6 = r5.V();
        if (r6 == null) goto L32;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r7 = r6.g;
        if (r7 == null) goto L32;
        Long r8 = r7.m;
        if (r8 == null) goto L32;
        long r9 = r8.longValue();
    L34:
        if (r9 <= 0) goto L44;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10 = this.g;
        if (r10 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r11 = r10.V();
        if (r11 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r13 = r11.g;
        if (r13 == null) goto L44;
        if (r13.s != true) goto L44;
        z32.f.b(PSRoomIndicatorNode.LandscapeCommentPanelShowDelay, System.currentTimeMillis() - r9);
    L44:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r14 = this.d;
        if (r14 == null) goto L53;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r15 = r14.g;
        if (r15 != null) goto L49;
        return;
    L49:
        if (r15.u > 0) goto L51;
        return;
    L51:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.CommentPanelShowDelay, MapsKt.mapOf(new Pair[]{TuplesKt.to("delay_time", String.valueOf(System.currentTimeMillis() - r15.u)), TuplesKt.to("operate_source", r15.t.getSource())}));
        return;
    L53:
        return;
    L32:
        r9 = 0;
        goto L34
    L14:
        r4 = null;
    L18:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r16 = this.g;
        if (r16 == null) goto L23;
        EditText r17 = r16.a;
        if (r17 == null) goto L23;
        r17.post(new c(r17));
        r17.setOnFocusChangeListener(new b(r17, this));
        goto L23
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void U90(MeasureLinearLayout r6) {
        Intrinsics.checkNotNullParameter(r6, "layout");
        if (this.z == false) goto L7;
        MeasureLinearLayout r0 = this.f;
        if (r0 == null) goto L7;
        r0.setKeyBoardObservable(new i40.i(r0, this.s, this.t, com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorKeyboard));
    L7:
        this.u = (InputPanelSectionContainer) r6.findViewById(2131375401);
        this.w = (InputPanelSectionContainer) r6.findViewById(2131375395);
        this.v = (InputPanelSectionContainer) r6.findViewById(2131375393);
        this.x = (InputPanelSectionContainer) r6.findViewById(2131375392);
        this.y = (InputPanelSectionContainer) r6.findViewById(2131375398);
        InputPanelSectionContainer r7 = this.u;
        if (r7 == null) goto L10;
        ((ArrayList) this.i).add(r7);
    L10:
        InputPanelSectionContainer r8 = this.w;
        if (r8 == null) goto L13;
        ((ArrayList) this.i).add(r8);
    L13:
        InputPanelSectionContainer r9 = this.v;
        if (r9 == null) goto L16;
        ((ArrayList) this.i).add(r9);
    L16:
        InputPanelSectionContainer r10 = this.x;
        if (r10 == null) goto L19;
        ((ArrayList) this.i).add(r10);
    L19:
        InputPanelSectionContainer r11 = this.y;
        if (r11 == null) goto L23;
        ((ArrayList) this.i).add(r11);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void W90(MeasureLinearLayout r31) {
        Intrinsics.checkNotNullParameter(r31, "layout");
        j0 r13 = new j0();
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e r14 = new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e();
        x r15 = new x();
        DanmakuSectionProvider r11 = new DanmakuSectionProvider();
        o1 r10 = new o1();
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a r9 = new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a();
        h1 r8 = new h1();
        HashSet r0 = new HashSet();
        InputSectionType r7 = InputSectionType.SHADOW;
        r0.add(r7);
        InputPanelSectionContainer r1 = this.u;
        if (r1 == null) goto L5;
        r1.setSupportSections(r0);
    L5:
        HashSet r2 = new HashSet();
        InputSectionType r6 = InputSectionType.CONTENT;
        r2.add(r6);
        InputPanelSectionContainer r3 = this.v;
        if (r3 == null) goto L8;
        r3.setSupportSections(r2);
    L8:
        HashSet r4 = new HashSet();
        InputSectionType r5 = InputSectionType.CONTROL_LANDSCAPE;
        r4.add(r5);
        InputPanelSectionContainer r16 = this.w;
        if (r16 == null) goto L11;
        r16.setSupportSections(r4);
    L11:
        InputPanelSectionContainer r17 = this.y;
        if (r17 == null) goto L14;
        HashSet r18 = new HashSet();
        r18.add(InputSectionType.QUICK_COMMENT);
        Unit r19 = Unit.INSTANCE;
        r17.setSupportSections(r18);
    L14:
        HashSet r20 = new HashSet();
        InputSectionType r21 = InputSectionType.EMOJI;
        r20.add(r21);
        InputSectionType r23 = InputSectionType.KEYBOARD;
        r20.add(r23);
        r20.add(InputSectionType.DANMAKU);
        r20.add(InputSectionType.AUDIO2TEXT);
        InputPanelSectionContainer r24 = this.x;
        if (r24 == null) goto L17;
        r24.setSupportSections(r20);
    L17:
        j0.d r25 = r13.d;
        if (r25 == null) goto L109;
        x.a r26 = r15.c;
        if (r26 == null) goto L107;
        DanmakuSectionProvider.c r27 = r11.h;
        if (r27 == null) goto L105;
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r110 = r9.d;
        if (r110 == null) goto L103;
        com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r28 = r14.f;
        if (r28 == null) goto L101;
        d r111 = new d(this, r28, r25, r26, r27, r110, r28, r25, r26, r27, r110);
        this.g = r111;
        InputPanelSectionContainer r29 = this.v;
        if (r29 == null) goto L30;
        r29.a(r111, r14);
    L30:
        InputPanelSectionContainer r30 = this.v;
        if (r30 == null) goto L33;
        InputPanelSectionContainer.e(r30, r6, null, false, 6);
    L33:
        InputPanelSectionContainer r33 = this.w;
        if (r33 == null) goto L36;
        r33.a(r111, r13);
    L36:
        InputPanelSectionContainer r34 = this.w;
        if (r34 == null) goto L40;
        InputPanelSectionContainer.e(r34, r5, null, false, 6);
    L40:
        if (r111.f0() == false) goto L44;
        InputPanelSectionContainer r35 = this.x;
        if (r35 == null) goto L44;
        r35.a(r111, r11);
    L44:
        InputPanelSectionContainer r36 = this.x;
        if (r36 == null) goto L48;
        r36.a(r111, r15);
    L48:
        if (r111.c0() == false) goto L52;
        InputPanelSectionContainer r37 = this.x;
        if (r37 == null) goto L52;
        r37.a(r111, r9);
    L52:
        InputPanelSectionContainer r38 = this.x;
        if (r38 == null) goto L55;
        InputPanelSectionContainer.e(r38, r23, null, false, 6);
    L55:
        InputPanelSectionContainer r39 = this.y;
        if (r39 == null) goto L58;
        r39.a(r111, r8);
    L58:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r40 = r111.V();
        if (r40 == null) goto L69;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r41 = r40.g;
        if (r41 == null) goto L69;
        LinkedList<IQuickCommentShowWord> r43 = r41.o;
        if (r43 == null) goto L69;
        if (r43.isEmpty() == true) goto L69;
        InputPanelSectionContainer r44 = this.y;
        if (r44 == null) goto L69;
        InputPanelSectionContainer.e(r44, InputSectionType.QUICK_COMMENT, null, false, 6);
    L69:
        InputPanelSectionContainer r45 = this.u;
        if (r45 == null) goto L72;
        r45.a(r111, r10);
    L72:
        InputPanelSectionContainer r46 = this.u;
        if (r46 == null) goto L75;
        InputPanelSectionContainer.e(r46, r7, null, false, 6);
    L75:
        InputPanelSectionContainer r47 = this.x;
        if (r47 == null) goto L78;
        e r48 = new e(this, r111);
        Intrinsics.checkNotNullParameter(r48, "listener");
        r47.k.add(r48);
    L78:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r49 = r111.V();
        if (r49 == null) goto L90;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r50 = r49.g;
        if (r50 == null) goto L90;
        String r51 = r50.p;
        if (r51 == null) goto L90;
        if (Intrinsics.areEqual(r51, DefaultLandingPanel.Emoji.getPanel()) == false) goto L90;
        InputPanelSectionContainer r53 = this.x;
        if (r53 == null) goto L89;
        InputPanelSectionContainer.e(r53, r21, null, false, 6);
    L89:
        r111.r(false);
    L90:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r54 = r111.Y();
        if (r54 != null) goto L93;
        return;
    L93:
        if (y22.b.a(r111.S()) == false) goto L95;
        return;
    L95:
        if (r54.isFixedComment() == true) goto L97;
        return;
    L97:
        if (TextUtils.isEmpty(r54.getFixCommentToast()) == true) goto L113;
        IESUIUtils.displayToast(getContext(), r54.getFixCommentToast());
        return;
    L113:
        return;
    L101:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.ContentSectionBridge");
    L103:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.AudioSectionBridge");
    L105:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.DanmakuSectionBridge");
    L107:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.EmojiSectionBridge");
    L109:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.LandscapeControlSectionBridge");
    }
}
