package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.audiencerecord.LiveAudienceBacktrackPreviewDialog;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdk.chatroom.liverecord.RecordEntranceDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.widget.LiveCircleProgressView;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarAudienceRecordBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, se1.a {
    public se1.c a;
    public se1.b b;
    public DataCenter c;
    public Room d;
    public LiveCircleProgressView e;
    public ImageView f;
    public View g;
    public View h;
    public View i;
    public boolean j;
    public Disposable k;
    public final Lazy l;
    public final a m;
    public final FragmentActivity n;
    public final boolean o;
    public final com.bytedance.android.live.pushstream.d p;

    public static final class a implements com.bytedance.android.livesdk.chatroom.model.n2 {
        public final /* synthetic */ ToolbarAudienceRecordBehavior a;

        public a(ToolbarAudienceRecordBehavior r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.livesdk.chatroom.model.i2 r8, View r9) {
            Intrinsics.checkNotNullParameter(r8, "item");
            Intrinsics.checkNotNullParameter(r9, "itemView");
            int r10 = r8.a;
            if (r10 != 1) goto L5;
            this.a.a();
            return;
        L5:
            if (r10 != 3) goto L37;
            ToolbarAudienceRecordBehavior r11 = this.a;
            se1.b r0 = r11.b;
            if (r0 != null) goto L10;
        L19:
            LinkedHashMap r1 = new LinkedHashMap();
            Room r2 = r11.d;
            BacktrackState r3 = null;
            if (r2 == null) goto L22;
            LiveMode r4 = r2.getStreamType();
        L23:
            int r5 = com.bytedance.android.live.core.utils.h1.a;
            r1.put("live_type", com.bytedance.android.live.core.utils.i1.a(r4));
            String r6 = "0";
            if (r11.o == false) goto L26;
            Object r7 = "0";
        L27:
            r1.put("room_orientation", r7);
            se1.b r12 = r11.b;
            if (r12 == null) goto L31;
            r3 = r12.a();
        L31:
            if (r3 != BacktrackState.BACKTRACK_DOING) goto L33;
            r6 = "1";
        L33:
            r1.put("is_record_status", r6);
            r1.put("request_page", "live_room");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watched_record_button_click", r1, new Object[]{Room.class, am2.x.class});
            return;
        L26:
            r7 = "1";
            goto L27
        L22:
            r4 = null;
            goto L23
        L10:
            switch(k2.b[r0.a().ordinal()]) {
                case 1: goto L16;
                case 2: goto L16;
                case 3: goto L16;
                case 4: goto L12;
                case 5: goto L12;
                case 6: goto L12;
                default: goto L19;
            };
        L12:
            DataCenter r13 = r11.c;
            if (r13 == null) goto L19;
            LiveAudienceBacktrackPreviewDialog.b r14 = LiveAudienceBacktrackPreviewDialog.p;
            FragmentActivity r15 = r11.n;
            Intrinsics.checkNotNull(r13);
            r14.getClass();
            LiveAudienceBacktrackPreviewDialog.b.a(r15, r13);
            goto L19
        L16:
            if (com.bytedance.android.livesdk.chatroom.record.u.d(r11.c) == false) goto L18;
            com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
            goto L19
        L18:
            DataCenter r16 = r11.c;
            Intrinsics.checkNotNull(r16);
            r16.put("cmd_save_back_record_preview_info", new Object());
            se1.c r17 = r11.a;
            Intrinsics.checkNotNull(r17);
            r17.startBacktrack();
            goto L19
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ToolbarAudienceRecordBehavior a;

        public b(ToolbarAudienceRecordBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            IBaseUser r2 = (IBaseUser) r1;
            this.a.b();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d extends tp2.b {
        public d(ToolbarAudienceRecordBehavior r1) {
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final void G0(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final void UL(BacktrackState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final void a() {
        if (((com.bytedance.android.live.pushstream.d) this.l.getValue()) != null) goto L5;
        return;
    L5:
        xs2.b r0 = xs2.b.a();
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) this.l.getValue();
        Intrinsics.checkNotNull(r2);
        r0.post(new zg1.n1(r2, new d(this), false, 0, false, "more_function"));
    }

    public final void b() {
        if (this.j == true) goto L6;
        com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
        return;
    L6:
        se1.b r0 = this.b;
        Intrinsics.checkNotNull(r0);
        switch(k2.a[r0.a().ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L39;
        };
    L9:
        DataCenter r1 = this.c;
        if (r1 == null) goto L36;
        LiveAudienceBacktrackPreviewDialog.b r2 = LiveAudienceBacktrackPreviewDialog.p;
        FragmentActivity r3 = this.n;
        Intrinsics.checkNotNull(r1);
        r2.getClass();
        LiveAudienceBacktrackPreviewDialog.b.a(r3, r1);
        return;
    L36:
        return;
    L12:
        List r4 = kh1.a.b(kh1.a.a, this.o, this.d);
        int r5 = RecordEntranceDialog.h;
        RecordEntranceDialog.a.a(this.n, r4, this.m, this.o);
        DataCenter r6 = this.c;
        if (r6 == null) goto L15;
        r6.put("cmd_live_toolbarmore_dialog_dismiss", new Object());
    L15:
        Iterator r7 = ((ArrayList) r4).iterator();
    L16:
        LiveMode r8 = null;
        if (r7.hasNext() == false) goto L24;
        Object r9 = r7.next();
        if (((com.bytedance.android.livesdk.chatroom.model.i2) r9).a != 3) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L16;
    L25:
        if (r9 == null) goto L38;
        LinkedHashMap r11 = new LinkedHashMap();
        Room r12 = this.d;
        if (r12 == null) goto L29;
        r8 = r12.getStreamType();
    L29:
        int r13 = com.bytedance.android.live.core.utils.h1.a;
        r11.put("live_type", com.bytedance.android.live.core.utils.i1.a(r8));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watched_record_button_show", r11, new Object[]{Room.class, am2.x.class});
        return;
    L38:
        return;
    L21:
        r10 = false;
        goto L22
    L24:
        r9 = null;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.o.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if ((r2 instanceof pp1.b) == false) goto L6;
        this.j = ((pp1.b) r2).a;
        return;
    L6:
        if ((r2 instanceof pp1.a) == false) goto L10;
        a();
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r2 = "0";
        r0.put("is_anchor", "0");
        if (this.o == true) goto L6;
        r2 = "1";
    L6:
        r0.put("is_landscape", r2);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_combined_record_button_click", r0, new Object[]{Room.class, am2.x.class});
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.o;
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L9;
        Boolean r3 = Boolean.FALSE;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r3);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.c).b(ToolbarButton.MORE, new pp1.j(false));
    L9:
        UIUtils.setViewVisibility(this.i, 4);
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L13;
        com.bytedance.android.livesdk.user.f r4 = TTLiveSDKContext.getHostService().h();
        Intrinsics.checkNotNull(r7);
        this.k = r4.login(r7.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
        return;
    L13:
        b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        se1.c r0 = (se1.c) r7.get("data_audience_backtrace_service");
        this.a = r0;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.audiencerecord.o r1 = r0.a();
    L6:
        this.b = r1;
        if (r1 == null) goto L9;
        r1.b(this);
    L9:
        this.d = (Room) r7.get("data_room");
        this.c = r7;
        View r8 = r6.findViewById(2131374718);
        ViewGroup r9 = (ViewGroup) r8.findViewById(2131374718);
        if (r9 == null) goto L30;
        LayoutInflater r3 = LayoutInflater.from(r9.getContext());
        if (this.o == false) goto L15;
        int r4 = 2131567854;
    L16:
        r3.inflate(r4, r9, true);
        this.f = (ImageView) r9.findViewById(2131375297);
        this.g = r9.findViewById(2131383333);
        this.h = r9.findViewById(2131372576);
        this.e = (LiveCircleProgressView) r9.findViewById(2131383286);
        this.i = r8.findViewById(2131384095);
        LiveCircleProgressView r10 = this.e;
        if (r10 == null) goto L19;
        r10.setProgressColor((int) 3003121663L);
        r10.setCircleWidth(UtilityKotlinExtentionsKt.i(2));
        r10.setBgCircleWidth(UtilityKotlinExtentionsKt.i(2));
        r10.setBgCircleColor(436207615);
        r10.setMaxProgress(100);
    L19:
        ImageView r11 = this.f;
        if (r11 == null) goto L29;
        Context r12 = com.bytedance.android.live.core.utils.s1.getContext();
        if (this.o == false) goto L25;
        int r5 = 2131251399;
    L28:
        r11.setImageDrawable(ContextCompat.getDrawable(r12, r5));
        goto L29
    L25:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.c) == false) goto L27;
        r5 = 2131251401;
        goto L28
    L27:
        r5 = 2131250853;
    L29:
        UIUtils.setViewVisibility(this.f, 0);
        UIUtils.setViewVisibility(this.g, 4);
        UIUtils.setViewVisibility(this.h, 4);
        goto L30
    L15:
        r4 = 2131567853;
    L30:
        LinkedHashMap r13 = new LinkedHashMap();
        String r14 = "0";
        r13.put("is_anchor", "0");
        if (this.o == true) goto L34;
        r14 = "1";
    L34:
        r13.put("is_landscape", r14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_combined_record_button_show", r13, new Object[]{Room.class, am2.x.class});
        return;
    L5:
        r1 = null;
        goto L6
    }

    public ToolbarAudienceRecordBehavior(FragmentActivity r1, boolean r2, com.bytedance.android.live.pushstream.d r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        this.n = r1;
        this.o = r2;
        this.p = r3;
        this.j = true;
        this.l = LazyKt.lazy(new ToolbarAudienceRecordBehavior$mLiveStream$2(this));
        this.m = new a(this);
    }
}
