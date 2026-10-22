package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.core.widget.LiveEditText;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.OGCFixedCommentSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/OGCFixedInputDialog;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/LiveInputDialogV3;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputDialog extends LiveInputDialogV3 {
    public static final /* synthetic */ int D = 0;
    public HSImageView A;
    public HSImageView B;
    public boolean C;
    public QuickCommentView u;
    public View v;
    public InputPanelSectionContainer w;
    public boolean x;
    public HSImageView y;
    public LiveEditText z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OGCFixedInputDialog a;

        public b(OGCFixedInputDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.aa0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final int getLayoutId() {
        return 2131565678;
    }

    public final void aa0() {
        if (PadConfigUtils.c() == false) goto L6;
        ALogger.i("OGCFixedInputDialog", "sendLiveInputEvent: pad,skip send sendLiveInputEvent");
        return;
    L6:
        int r0 = UtilityKotlinExtentionsKt.i(400);
        QuickCommentView r2 = this.u;
        if (r2 == null) goto L19;
        if (r2 == null) goto L19;
        if (r2.getVisibility() != 0) goto L19;
        QuickCommentView r3 = this.u;
        int r4 = 0;
        if (r3 == null) goto L14;
        int r5 = r3.getHeight();
    L15:
        r0 = r0 + r5;
        StringBuilder r6 = new StringBuilder("sendLiveInputEvent: height diff add quickCommentView: ");
        QuickCommentView r7 = this.u;
        if (r7 == null) goto L18;
        r4 = r7.getHeight();
    L18:
        r6.append(r4);
        ALogger.i("OGCFixedInputDialog", r6.toString());
        goto L19
    L14:
        r5 = 0;
    L19:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8 = this.g;
        if (r8 == null) goto L22;
        r8.u0(r0);
    L22:
        ALogger.i("OGCFixedInputDialog", "sendLiveInputEvent: height diff = " + r0);
        xs2.b.a().post(new i1(r0, this.x));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.x = true;
        InputPanelSectionContainer r0 = this.w;
        if (r0 == null) goto L6;
        r0.post(new b(this));
        return;
    }

    public OGCFixedInputDialog() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void U90(MeasureLinearLayout r7) {
        Intrinsics.checkNotNullParameter(r7, "layout");
        this.y = r7.findViewById(2131368952);
        this.v = r7.findViewById(2131368956);
        HSImageView r0 = this.y;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new k(this));
    L5:
        this.A = r7.findViewById(2131364133);
        this.B = r7.findViewById(2131364135);
        this.z = new LiveEditText(getContext());
        this.u = (QuickCommentView) r7.findViewById(2131392578);
        InputPanelSectionContainer r1 = (InputPanelSectionContainer) r7.findViewById(2131372637);
        this.w = r1;
        if (r1 == null) goto L8;
        ((ArrayList) this.i).add(r1);
    L8:
        InputPanelSectionContainer r8 = (InputPanelSectionContainer) r7.findViewById(2131375401);
        if (r8 == null) goto L11;
        r8.setOnClickListener(new l(this));
    L11:
        View r9 = this.v;
        if (r9 == null) goto L14;
        r9.post(new m(this));
    L14:
        LinkedList<IQuickCommentShowWord> r2 = null;
        if (PadConfigUtils.c() == false) goto L52;
        View r10 = this.v;
        if (r10 == null) goto L19;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L21:
        if ((r11 instanceof LinearLayout.LayoutParams) == true) goto L23;
        r11 = null;
    L23:
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r11;
        if (r13 == null) goto L26;
        r13.width = UtilityKotlinExtentionsKt.i(375);
        r13.rightMargin = UtilityKotlinExtentionsKt.i(20);
        r13.bottomMargin = UtilityKotlinExtentionsKt.i(20);
        r13.gravity = 8388613;
    L27:
        if (r13 == null) goto L31;
        View r4 = this.v;
        if (r4 == null) goto L31;
        r4.setLayoutParams(r13);
    L31:
        QuickCommentView r14 = this.u;
        if (r14 == null) goto L34;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
    L36:
        if ((r15 instanceof LinearLayout.LayoutParams) == true) goto L38;
        r15 = null;
    L38:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        if (r16 == null) goto L41;
        r16.width = UtilityKotlinExtentionsKt.i(375);
        r16.rightMargin = UtilityKotlinExtentionsKt.i(20);
        r16.gravity = 8388613;
    L42:
        if (r16 == null) goto L46;
        QuickCommentView r3 = this.u;
        if (r3 == null) goto L46;
        r3.setLayoutParams(r16);
    L46:
        MeasureLinearLayout r17 = this.f;
        if (r17 == null) goto L49;
        r17.setOnClickListener(new n(this));
    L49:
        View r18 = this.v;
        if (r18 == null) goto L52;
        r18.setOnClickListener(o.a);
        goto L52
    L41:
        r16 = null;
        goto L42
    L34:
        r15 = null;
        goto L36
    L26:
        r13 = null;
        goto L27
    L19:
        r11 = null;
    L52:
        DataCenter r19 = this.j;
        if (r19 == null) goto L55;
        IRoom r20 = a0.n(r19);
    L57:
        if (ht2.g.f(r20, 22, true) == false) goto L63;
        HSImageView r5 = this.A;
        if (r5 == null) goto L61;
        r5.setBackground(null);
    L61:
        HSImageView r6 = this.A;
        OGCFixedInputDialog$loadSkin$1 r21 = OGCFixedInputDialog$loadSkin$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r21, "onStart");
        ht2.g.d(22, r20, r6, r21);
    L63:
        if (ht2.g.f(r20, 23, true) == false) goto L65;
        HSImageView r23 = this.B;
        OGCFixedInputDialog$loadSkin$2 r24 = OGCFixedInputDialog$loadSkin$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r24, "onStart");
        ht2.g.d(23, r20, r23, r24);
    L65:
        com.bytedance.android.livesdk.interactivity.api.h r25 = com.bytedance.android.livesdk.interactivity.api.i.b(this.j, 1);
        if (r25 == null) goto L72;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r26 = r25.getQuickCommentManager();
        if (r26 == null) goto L72;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r27 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r26.getValue();
        if (r27 == null) goto L72;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r28 = r27.getOGCFixedChatInfo();
    L73:
        if (r28 == null) goto L79;
        py.k r29 = r28.cancelIcon;
        if (r29 == null) goto L79;
        if ((!r29.getUrls().isEmpty()) == false) goto L79;
        ImageUtil.loadImage(this.y, r29, 0);
    L79:
        c r30 = this.d;
        if (r30 == null) goto L84;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r31 = r30.g;
        if (r31 == null) goto L84;
        r2 = r31.o;
    L84:
        if (r2 != null) goto L86;
    L101:
        QuickCommentView r33 = this.u;
        if (r33 == null) goto L107;
        UtilityKotlinExtentionsKt.t(r33);
        return;
    L107:
        return;
    L86:
        if (r2.isEmpty() == true) goto L101;
        nm1.m r34 = pm1.f.l();
        if (r34 != null) goto L90;
    L92:
        QuickCommentView r35 = this.u;
        if (r35 == null) goto L95;
        UtilityKotlinExtentionsKt.w(r35);
    L95:
        QuickCommentView r36 = this.u;
        if (r36 == null) goto L98;
        r36.setQuickComment(r2);
    L98:
        QuickCommentView r37 = this.u;
        if (r37 == null) goto L105;
        r37.setListener(new q(this));
        return;
    L105:
        return;
    L90:
        if (r34.y(this.j) != true) goto L92;
    L72:
        r28 = null;
        goto L73
    L55:
        r20 = null;
        goto L57
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final HashMap<String, Object> V90(com.bytedance.android.live.profit.privilege.model.danmu.b r5) {
        HashMap<String, Object> r6 = super.V90(r5);
        r6.put("scene", 1);
        String r1 = "0";
        if (this.C == false) goto L5;
        Object r0 = "0";
    L6:
        r6.put("is_settled", r0);
        if (this.C == false) goto L9;
        r1 = "1";
    L9:
        r6.put("is_shortcut_message", r1);
        return r6;
    L5:
        r0 = "1";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void W90(MeasureLinearLayout r9) {
        Intrinsics.checkNotNullParameter(r9, "layout");
        OGCFixedCommentSectionProvider r10 = new OGCFixedCommentSectionProvider(this.j);
        x r0 = new x();
        DanmakuSectionProvider r1 = new DanmakuSectionProvider();
        x.a r6 = r0.c;
        if (r6 == null) goto L15;
        DanmakuSectionProvider.c r7 = r1.h;
        p r2 = new p(this, r6, r7, r6, r7);
        this.g = r2;
        r2.a = this.z;
        HashSet r3 = new HashSet();
        InputSectionType r4 = InputSectionType.OGC_FIXED_INPUT;
        r3.add(r4);
        InputPanelSectionContainer r5 = this.w;
        if (r5 == null) goto L7;
        r5.setSupportSections(r3);
    L7:
        InputPanelSectionContainer r8 = this.w;
        if (r8 == null) goto L10;
        r8.a(r2, r10);
    L10:
        InputPanelSectionContainer r11 = this.w;
        if (r11 == null) goto L16;
        InputPanelSectionContainer.e(r11, r4, null, false, 6);
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.EmojiSectionBridge");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        this.x = false;     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        aa0();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
