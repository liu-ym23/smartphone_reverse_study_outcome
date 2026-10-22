package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.f> {
    public static final a e = null;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;
    public final InputSectionType b;
    public c c;
    public final d d;

    public static final class a implements z62.f {
        public a() {
        }

        @Override // z62.f
        public final void r(boolean r1) {
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public ImageButton c;
        public ImageButton d;
        public ImageView e;
        public FrameLayout f;
        public FrameLayout g;
        public LinearLayout h;
        public LinearLayout i;
        public ImageButton j;
        public ImageButton k;
        public ImageButton l;
        public String m;
        public boolean n;
        public final /* synthetic */ j0 o;

        public final String i() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.o.a;
            if (r0 != null) goto L5;
            return null;
        L5:
            if (r0.d0() != true) goto L13;
            EffectiveActivityEmojiGroup r1 = com.bytedance.android.livesdk.interactivity.api.q.c();
            if (r1 == null) goto L14;
            ActivityEmojiGroup r2 = r1.getEmojiGroup();
            if (r2 != null) goto L11;
            return null;
        L11:
            return r2.getIdStr();
        L14:
            return null;
        L13:
            return null;
        }

        public final com.bytedance.android.livesdk.sharedpref.e<Integer> j() {
            return new com.bytedance.android.livesdk.sharedpref.e(this.m, 0);
        }

        public final void h(boolean r2) {
            if (r2 == false) goto L9;
            LinearLayout r3 = this.i;
            if (r3 == null) goto L6;
            UtilityKotlinExtentionsKt.w(r3);
        L6:
            LinearLayout r4 = this.h;
            if (r4 == null) goto L15;
            UtilityKotlinExtentionsKt.t(r4);
        L15:
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r5 = this.b.Y();
            if (r5 != null) goto L18;
            return;
        L18:
            if (r5.isFixedComment() == true) goto L20;
            return;
        L20:
            if (y22.b.a(this.b.S()) == true) goto L30;
            LinearLayout r6 = this.i;
            if (r6 == null) goto L24;
            UtilityKotlinExtentionsKt.t(r6);
        L24:
            LinearLayout r7 = this.h;
            if (r7 == null) goto L31;
            UtilityKotlinExtentionsKt.t(r7);
            return;
        L31:
            return;
        L30:
            return;
        L9:
            LinearLayout r8 = this.i;
            if (r8 == null) goto L12;
            UtilityKotlinExtentionsKt.t(r8);
        L12:
            LinearLayout r9 = this.h;
            if (r9 == null) goto L15;
            UtilityKotlinExtentionsKt.w(r9);
            goto L15
        }

        public final void k(boolean r2) {
            if (r2 == false) goto L21;
            ImageButton r3 = this.l;
            if (r3 == null) goto L6;
            r3.setImageResource(2131251936);
        L6:
            ImageButton r4 = this.k;
            if (r4 == null) goto L9;
            r4.setImageResource(2131251926);
        L9:
            ImageButton r5 = this.l;
            if (r5 == null) goto L12;
            r5.setClickable(true);
        L12:
            ImageButton r6 = this.k;
            if (r6 == null) goto L15;
            r6.setClickable(true);
        L15:
            ImageButton r7 = this.l;
            if (r7 == null) goto L18;
            r7.setEnabled(true);
        L18:
            ImageButton r8 = this.k;
            if (r8 == null) goto L40;
            r8.setEnabled(true);
            return;
        L40:
            return;
        L21:
            ImageButton r9 = this.l;
            if (r9 == null) goto L24;
            r9.setImageResource(2131251935);
        L24:
            ImageButton r10 = this.k;
            if (r10 == null) goto L27;
            r10.setImageResource(2131251925);
        L27:
            ImageButton r11 = this.k;
            if (r11 == null) goto L30;
            r11.setClickable(false);
        L30:
            ImageButton r13 = this.l;
            if (r13 == null) goto L33;
            r13.setClickable(false);
        L33:
            ImageButton r14 = this.l;
            if (r14 == null) goto L36;
            r14.setEnabled(false);
        L36:
            ImageButton r15 = this.k;
            if (r15 == null) goto L42;
            r15.setEnabled(false);
            return;
        }

        public static final void g(c r3, String r4) {
            r3.getClass();
            HashMap r5 = new HashMap();
            r5.put("click_icon", r4);
            r5.put("screen_type", "landscape");
            IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r6 == null) goto L5;
            r6.buildVsRoomLog(null, r5);
        L5:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_click", r5, new Object[]{IRoom.class, am2.x.class});
        }

        public c(j0 r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.o = r2;
            super(r3, r4);
            this.m = "portrait_control_emoji_";
        }
    }

    public static final class d implements z62.f {
        public final /* synthetic */ j0 a;

        public d(j0 r1) {
            this.a = r1;
        }

        @Override // z62.f
        public final void r(boolean r2) {
            c r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.h(r2);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        e = new a();
    }

    public j0() {
        this.b = InputSectionType.CONTROL_LANDSCAPE;
        this.d = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelBridge");
        Activity r0 = r9.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.a = r9;
        View r1 = LayoutInflater.from(r0).inflate(2131567704, null);
        c r2 = new c(this, r1, r9);
        r2.c = (ImageButton) r2.a.findViewById(2131367926);
        r2.e = (ImageView) r2.a.findViewById(2131384095);
        r2.d = (ImageButton) r2.a.findViewById(2131367919);
        r2.j = (ImageButton) r2.a.findViewById(2131367931);
        r2.k = (ImageButton) r2.a.findViewById(2131367925);
        r2.l = (ImageButton) r2.a.findViewById(2131367933);
        r2.f = (FrameLayout) r2.a.findViewById(2131367759);
        r2.g = (FrameLayout) r2.a.findViewById(2131367742);
        r2.h = (LinearLayout) r2.a.findViewById(2131367922);
        r2.i = (LinearLayout) r2.a.findViewById(2131373367);
        r2.h(true);
        if (r2.i() != null) goto L10;
        ImageView r3 = r2.e;
        if (r3 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r3);
    L28:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = r2.o.a;
        if (r4 == null) goto L51;
        EditText r5 = r4.a;
        if (r5 == null) goto L51;
        Editable r6 = r5.getText();
        if (r6 == null) goto L51;
        if (r6.length() != 0) goto L37;
        boolean r7 = true;
    L38:
        if (r7 == false) goto L51;
        ImageButton r8 = r2.l;
        if (r8 == null) goto L42;
        r8.setEnabled(false);
    L42:
        ImageButton r10 = r2.l;
        if (r10 == null) goto L45;
        r10.setClickable(false);
    L45:
        ImageButton r11 = r2.k;
        if (r11 == null) goto L48;
        r11.setEnabled(false);
    L48:
        ImageButton r13 = r2.k;
        if (r13 == null) goto L51;
        r13.setClickable(false);
        goto L51
    L37:
        r7 = false;
    L51:
        ImageButton r14 = r2.l;
        if (r14 == null) goto L54;
        r14.setOnClickListener(new k0(r2));
    L54:
        ImageButton r15 = r2.k;
        if (r15 == null) goto L57;
        r15.setOnClickListener(new l0(r2));
    L57:
        ImageButton r16 = r2.c;
        if (r16 == null) goto L60;
        r16.setOnClickListener(new m0(r2));
    L60:
        ImageButton r17 = r2.j;
        if (r17 == null) goto L63;
        r17.setOnClickListener(new n0(r2));
    L63:
        ImageButton r18 = r2.d;
        if (r18 == null) goto L66;
        r18.setOnClickListener(new o0(r2));
    L66:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r19 = r2.o.a;
        if (r19 == null) goto L69;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r20 = r19.V();
    L71:
        if (r20 != null) goto L73;
    L83:
        r2.b.w(new p0(r2));
        r3.a(r2.c, com.bytedance.android.live.core.utils.s1.B(2131914438));
        r3.a(r2.d, com.bytedance.android.live.core.utils.s1.B(2131914436));
        r3.c(r2.l, com.bytedance.android.live.core.utils.s1.B(2131914445), true);
        r3.c(r2.k, com.bytedance.android.live.core.utils.s1.B(2131914425), true);
        r3.a(r2.j, com.bytedance.android.live.core.utils.s1.B(2131914443));
        if (r2.n == false) goto L86;
        String r21 = "emoji|voice_to_text";
    L87:
        HashMap r23 = new HashMap();
        r23.put("show_icon", r21);
        r23.put("screen_type", "landscape");
        IInteractivityInjectService r24 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r24 == null) goto L90;
        r24.buildVsRoomLog(null, r23);
    L90:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_show", r23, new Object[]{IRoom.class, am2.x.class});
        Unit r25 = Unit.INSTANCE;
        this.c = r2;
        return r1;
    L86:
        r21 = "emoji";
        goto L87
    L73:
        if (r20.b != true) goto L83;
        Integer r26 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r26 != null) goto L78;
    L79:
        FrameLayout r27 = r2.g;
        if (r27 == null) goto L82;
        UtilityKotlinExtentionsKt.w(r27);
    L82:
        r2.n = true;
        goto L83
    L78:
        if (r26.intValue() == 2) goto L83;
    L69:
        r20 = null;
        goto L71
    L10:
        r2.m = r2.m + r2.i();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r28 = r2.b.V();
        if (r28 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r29 = r28.g;
        if (r29 == null) goto L15;
        String r30 = r29.p;
    L17:
        if (Intrinsics.areEqual(r30, DefaultLandingPanel.Emoji.getPanel()) == false) goto L20;
        com.bytedance.android.livesdk.sharedpref.f.d(r2.j(), 3);
    L20:
        if (((Number) r2.j().getValue()).intValue() >= 3) goto L25;
        ImageView r31 = r2.e;
        if (r31 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r31);
    L24:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r33 = r2.j();
        com.bytedance.android.livesdk.sharedpref.f.d(r33, Integer.valueOf(((Integer) r33.getValue()).intValue() + 1));
        goto L28
    L25:
        ImageView r34 = r2.e;
        if (r34 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r34);
    L15:
        r30 = null;
        goto L17
    }
}
