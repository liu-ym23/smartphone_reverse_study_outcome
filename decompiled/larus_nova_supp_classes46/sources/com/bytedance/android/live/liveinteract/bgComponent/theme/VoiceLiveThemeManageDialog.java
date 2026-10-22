package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.dialog.theme.VoiceLiveThemeAdapter;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/VoiceLiveThemeManageDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/broadcast/dialog/theme/a;", "Lx00/b;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceLiveThemeManageDialog extends CommonBottomDialog implements com.bytedance.android.live.broadcast.dialog.theme.a, x00.b {
    public static boolean j;
    public x00.a a;
    public VoiceLiveThemeAdapter b;
    public IVoiceLiveTheme c;
    public final List<x00.d> d;
    public final boolean e;
    public final String f;
    public final com.bytedance.android.live.room.g g;
    public int h;
    public final DataCenter i;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ VoiceLiveThemeManageDialog a;
        public final /* synthetic */ IVoiceLiveTheme b;

        public c(VoiceLiveThemeManageDialog r1, IVoiceLiveTheme r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            int r9 = i.a;
            IVoiceLiveTheme r10 = this.b;
            Intrinsics.checkNotNullParameter(r10, "theme");
            LinkedHashMap r0 = new LinkedHashMap();
            Room r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            if (r1 == null) goto L5;
            Long r2 = Long.valueOf(r1.getRoomId());
        L6:
            r0.put("anchor_id", jc1.k.n(IMiddlewareUserService.class).user().n());
            r0.put("pic_uri", r10.getImageUri());
            r0.put("template_id", String.valueOf(r10.getId()));
            if (r2 != null) goto L9;
            r0.put("event_page", "live_take_page");
        L10:
            int r11 = r10.getFormatType();
            if (r11 != 1) goto L13;
            String r12 = "static";
        L17:
            r0.put("pic_type", r12);
            com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.c.c(r0);
            l0.a.getClass();
            l0.d(r0);
            if (r2 != null) goto L20;
            j0.l().sendLog("livesdk_anchor_theme_delect_success", r0, new Object[0]);
        L21:
            VoiceLiveThemeManageDialog r13 = this.a;
            IVoiceLiveTheme r3 = this.b;
            boolean r4 = VoiceLiveThemeManageDialog.j;
            r13.getClass();
            Room r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            if (r5 == null) goto L24;
            long r6 = r5.getRoomId();
        L25:
            x00.a r14 = r13.a;
            if (r14 == null) goto L28;
            r14.d(r6, r3);
        L28:
            r7.dismiss();
            return;
        L24:
            r6 = 0;
            goto L25
        L20:
            r0.put("room_id", String.valueOf(r2.longValue()));
            j0.l().sendLog("livesdk_anchor_theme_delect_success", r0, new Object[]{IRoom.class});
            goto L21
        L13:
            if (r11 == 2) goto L15;
            r12 = "";
            goto L17
        L15:
            r12 = "dynamic";
            goto L17
        L9:
            r0.put("event_page", "live_take_detail");
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ VoiceLiveThemeManageDialog a;

        public d(VoiceLiveThemeManageDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.s0();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565801;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        j = true;
        super.onAttachedToWindow();
        VoiceLiveThemeAdapter r0 = this.b;
        if (r0 == null) goto L5;
        r0.c = false;
    L5:
        int r1 = this.h;
        if (r1 != 100) goto L10;
        x00.a r2 = this.a;
        if (r2 == null) goto L13;
        r2.k(r1, 36, new AnonymousClass1(this));
    L13:
        RecyclerView r3 = findViewById(2131385021);
        ViewGroup.LayoutParams r4 = null;
        if (r3 == null) goto L16;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
    L18:
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        Resources r6 = getContext().getResources();
        int r7 = (int) (WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density * 12);
        RecyclerView r8 = findViewById(2131385021);
        if (r8 == null) goto L22;
        r4 = r8.getLayoutParams();
    L22:
        if (r4 == null) goto L25;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r4;
        ((ViewGroup.MarginLayoutParams) r9).leftMargin = r7;
        ((ViewGroup.MarginLayoutParams) r9).rightMargin = r7;
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L26:
        return;
    L16:
        r5 = null;
        goto L18
    L10:
        x00.a r10 = this.a;
        if (r10 == null) goto L13;
        r10.g(r1, new AnonymousClass2(this));
        goto L13
    }

    public final void onError(int r1) {
    }

    public final void M0() {
        VoiceLiveThemeAdapter r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.c == true) goto L50;
        j r1 = r0.e;
        int r2 = r0.g;
        IVoiceLiveTheme r3 = (IVoiceLiveTheme) r1.c.a(r2).getCurrentTheme().getValue();
        int r4 = 0;
        if (r3 == null) goto L40;
        ArrayList<IVoiceLiveTheme> r5 = r1.v(r2);
        String r6 = r3.getImageUri();
        boolean r7 = true;
        if (r6 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L25;
        Iterator<IVoiceLiveTheme> r9 = r5.iterator();
    L20:
        if (r9.hasNext() == false) goto L39;
        IVoiceLiveTheme r10 = r9.next();
        if (Intrinsics.areEqual(r3.getImageUri(), r10.getImageUri()) == true) goto L40;
        r4 = r4 + 1;
    L39:
        r4 = -1;
        goto L40
    L25:
        String r11 = r3.getLocalPath();
        if (r11 != null) goto L28;
    L31:
        if (r7 == true) goto L40;
        Iterator<IVoiceLiveTheme> r12 = r5.iterator();
    L34:
        if (r12.hasNext() == false) goto L39;
        IVoiceLiveTheme r13 = r12.next();
        if (Intrinsics.areEqual(r3.getLocalPath(), r13.getLocalPath()) == true) goto L40;
        r4 = r4 + 1;
        goto L34
    L28:
        if (r11.length() == 0) goto L31;
        r7 = false;
        goto L31
    L13:
        if (r6.length() == 0) goto L16;
        r8 = false;
    L40:
        r0.b = r4;
        ((ArrayList) r0.a).clear();
        ArrayList<IVoiceLiveTheme> r14 = r0.e.v(r0.g);
        IVoiceLiveTheme r15 = VoiceLiveThemeAdapter.y2(r14);
        if (r15 == null) goto L43;
        r15.getPlayMode();
    L43:
        ((ArrayList) r0.a).addAll(r14);
        r0.notifyDataSetChanged();
        return;
    }

    public final void N0() {
        x00.a r0 = this.a;
        if (r0 != null) goto L5;
    L9:
        ((LinearLayout) findViewById(2131388557)).setVisibility(8);
        return;
    L5:
        if (r0.n(this.h) != true) goto L9;
        if (this.h == 3) goto L9;
        ((LinearLayout) findViewById(2131388557)).setVisibility(0);
        ((LinearLayout) findViewById(2131388557)).setOnClickListener(new d(this));
    }

    public final void s0() {
        int r0 = i.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("anchor_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        l0.b(r1);
        l0.a.getClass();
        l0.c(r1);
        r1.put("play_mode", w.a());
        String r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.put("function_type2", r2);
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L8;
        IRoom r4 = (IRoom) r3.getValue();
    L9:
        boolean r5 = false;
        if (r4 == null) goto L12;
        r1.put("event_page", "live_take_detail");
        j0.l().sendLog("livesdk_anchor_theme_upload_click", r1, new Object[]{IRoom.class});
    L13:
        k2 r6 = this.g;
        if (r6 == null) goto L28;
        x00.a r7 = this.a;
        if (r7 != null) goto L18;
    L20:
        boolean r8 = false;
    L21:
        x00.a r9 = this.a;
        if (r9 != null) goto L24;
    L26:
        r6.u(r8, r5, this.h);
        return;
    L24:
        if (r9.o(this.h) != true) goto L26;
        r5 = true;
        goto L26
    L18:
        if (r7.n(this.h) != true) goto L20;
        r8 = true;
        goto L21
    L28:
        return;
    L12:
        r1.put("live_type", "voice_live");
        r1.put("event_page", "live_take_page");
        j0.l().sendLog("livesdk_anchor_theme_upload_click", r1, new Object[0]);
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x00.a r0 = this.a;
        if (r0 == null) goto L75;
        IVoiceLiveTheme r1 = r0.q(this.h);
        if (r1 == null) goto L76;
        String r2 = r1.getImageUri();
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L23;
        IVoiceLiveTheme r4 = this.c;
        if (r4 == null) goto L19;
        String r5 = r4.getImageUri();
    L21:
        if (Intrinsics.areEqual(r5, r1.getImageUri()) == false) goto L23;
        boolean r6 = true;
    L24:
        String r7 = r1.getLocalPath();
        if (r7 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == true) goto L39;
        IVoiceLiveTheme r9 = this.c;
        if (r9 == null) goto L35;
        String r10 = r9.getLocalPath();
    L37:
        if (Intrinsics.areEqual(r10, r1.getLocalPath()) == false) goto L39;
        r6 = true;
        goto L39
    L35:
        r10 = null;
    L39:
        VoiceLiveThemeAdapter r11 = this.b;
        if (r11 == null) goto L43;
        r11.c = true;
    L43:
        if (this.e == true) goto L69;
        Room r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r12 == null) goto L68;
        long r13 = r12.getRoomId();
        IVoiceLiveTheme r14 = this.c;
        if (r14 == null) goto L52;
        Iterator r15 = ((ArrayList) this.d).iterator();
    L50:
        if (r15.hasNext() == false) goto L52;
        ((x00.d) r15.next()).lj(r14, r1);
    L52:
        x00.a r16 = this.a;
        if (r16 == null) goto L57;
        IVoiceLiveTheme r17 = r16.a(this.h);
        if (r17 == null) goto L57;
        Integer r18 = Integer.valueOf(r17.getImageType());
    L58:
        if (r6 == false) goto L65;
        if (r18 == null) goto L69;
        if (r18.intValue() != 1) goto L69;
        if (((LinearLayout) findViewById(2131388557)).getVisibility() == 0) goto L69;
    L65:
        x00.a r19 = this.a;
        if (r19 == null) goto L69;
        r19.m(r13, r1, this.h);
    L57:
        r18 = null;
        goto L58
    L68:
        return;
    L69:
        this.c = null;
        VoiceLiveThemeAdapter r20 = this.b;
        if (r20 == null) goto L72;
        ((ArrayList) r20.a).clear();
        r20.notifyDataSetChanged();
    L72:
        j = false;
        return;
    L27:
        if (r7.length() == 0) goto L30;
        r8 = false;
        goto L31
    L19:
        r5 = null;
    L23:
        r6 = false;
        goto L24
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
        goto L15
    L76:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(IVoiceLiveTheme r8) {
        Intrinsics.checkNotNullParameter(r8, "theme");
        int r1 = i.a;
        Intrinsics.checkNotNullParameter(r8, "theme");
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.getRoomId());
    L6:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("anchor_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r3.put("pic_uri", r8.getImageUri());
        r3.put("template_id", String.valueOf(r8.getId()));
        if (r2 != null) goto L9;
        r3.put("event_page", "live_take_page");
    L10:
        int r4 = r8.getFormatType();
        if (r4 != 1) goto L13;
        String r5 = "static";
    L17:
        r3.put("pic_type", r5);
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.c.c(r3);
        l0.a.getClass();
        l0.d(r3);
        if (r2 != null) goto L20;
        j0.l().sendLog("livesdk_anchor_theme_delect_click", r3, new Object[0]);
    L21:
        x0.b r6 = new x0.b(getContext(), 0);
        x0.d r7 = r6.a;
        r7.a = 5;
        r7.k = false;
        r6.m(2131922876);
        r6.i(0, 2131914613, b.a);
        r6.i(1, 2131916024, new c(this, r8));
        r6.n();
        return;
    L20:
        r3.put("room_id", String.valueOf(r2.longValue()));
        j0.l().sendLog("livesdk_anchor_theme_delect_click", r3, new Object[]{IRoom.class});
        goto L21
    L13:
        if (r4 == 2) goto L15;
        r5 = "";
        goto L17
    L15:
        r5 = "dynamic";
        goto L17
    L9:
        r3.put("event_page", "live_take_detail");
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        setCancelable(true);
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        x00.a r1 = null;
        if (r0 == null) goto L5;
        x00.a r10 = r0.getThemeManager(true, this.i);
    L6:
        this.a = r10;
        if ((r10 instanceof j) == false) goto L10;
        r1 = r10;
    L10:
        j r4 = (j) r1;
        if (r4 == null) goto L14;
        this.b = new VoiceLiveThemeAdapter(getContext(), r4, this, this.h, this.f);
        findViewById(2131385021).setAdapter(this.b);
        findViewById(2131385021).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        N0();
        return;
    L14:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void p0(IVoiceLiveTheme r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        r3.setChoosing(true);
        x00.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.c(r3, this.h);
    L5:
        VoiceLiveThemeAdapter r4 = this.b;
        if (r4 == null) goto L9;
        r4.notifyDataSetChanged();
        return;
    }

    public VoiceLiveThemeManageDialog(Context r2, boolean r3, String r4, com.bytedance.android.live.room.g r5, int r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.d = new ArrayList();
    }
}
