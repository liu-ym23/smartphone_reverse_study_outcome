package ng0;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ok;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public boolean b;
    public final RadioTextBoardView c;
    public final int d;
    public final DataCenter e;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static boolean a(LinkMicRecyclerView r2) {
            if (r2 != 0) goto L5;
            return false;
        L5:
            if (r2.getChildCount() > 0) goto L7;
            return false;
        L7:
            if (r2.getChildAt(0).getHeight() <= 0) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RadioTextBoardView a;
        public final /* synthetic */ e b;
        public final /* synthetic */ int c;
        public final /* synthetic */ qb d;

        public b(RadioTextBoardView r1, e r2, int r3, qb r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();     // Catch: Throwable -> L10
            if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
            r0 = null;
        L5:
            ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            ((ViewGroup.MarginLayoutParams) r1).topMargin = UtilityKotlinExtentionsKt.i(12) + this.c;     // Catch: Throwable -> L10
        L8:
            this.b.d(this.d);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    static {
    }

    public final boolean b() {
        int r0 = this.d;
        if (r0 != 0) goto L6;
        boolean r1 = h.e();
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.d) == false) goto L13;
    L14:
        return true;
    L13:
        if (this.d == 0) goto L14;
        return false;
    L6:
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r0) == false) goto L8;
        r1 = h.f();
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    public static boolean c(qb r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.getPlaceholder() != 1) goto L8;
        if (r5.getTextBg() == null) goto L8;
        return true;
    }

    public final void d(qb r10) {
        if (b() == false) goto L77;
        if (r10 != null) goto L6;
        return;
    L6:
        if (c(r10) == false) goto L56;
        this.a = true;
        ConstraintLayout r0 = this.c;
        if (r0 == null) goto L25;
        if (r0.getVisibility() != 8) goto L25;
        if (this.d != 0) goto L25;
        if (this.e == null) goto L25;
        int r1 = s1.j(2131168508);
        if (h.g() == false) goto L18;
        r1 = s1.j(2131168509);
    L18:
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.e, 0, 2);
        if (r2 == null) goto L23;
        m r3 = r2.getAudioTalkRadioBottomOffset();
        if (r3 == null) goto L23;
        r3.setValue(Integer.valueOf(r1));
    L23:
        this.e.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "MultiLinkRadioMainSeatLayer show"));
    L25:
        if (this.a == false) goto L53;
        ConstraintLayout r4 = this.c;
        if (r4 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r4);
    L29:
        RadioTextBoardView r5 = this.c;
        if (r5 == null) goto L33;
        r5.f = -1;
    L33:
        if (this.d != 0) goto L53;
        if (this.b == true) goto L53;
        this.b = true;
        i0 r6 = TalkRoomLogUtils.a;
        o r7 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        HashMap r8 = new HashMap();
        r8.put("live_type", "voice_live");
        r8.put("function_type2", "live");
        r8.put("voice_mode", "head");
        r8.put("action_type", "show");
        m r9 = r7.getRoom();
        String r11 = "0";
        if (r9 == null) goto L43;
        IRoom r12 = (IRoom) r9.getValue();
        if (r12 == null) goto L43;
        String r13 = r12.getAnchorId();
        if (r13 == null) goto L43;
    L44:
        r8.put("anchor_id", r13);
        m r14 = r7.getRoom();
        if (r14 == null) goto L52;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L52;
        String r16 = r15.getIdStr();
        if (r16 == null) goto L52;
        r11 = r16;
    L52:
        r8.put("room_id", r11);
        j0.l().sendLog("livesdk_live_text_show_play", r8, new Object[0]);
    L43:
        r13 = "0";
    L53:
        RadioTextBoardView r17 = this.c;
        if (r17 == null) goto L79;
        com.bytedance.android.live.liveinteract.view.c.a r18 = com.bytedance.android.live.liveinteract.view.c.f;
        ok r19 = r10.getTextBg();
        Intrinsics.checkNotNull(r19);
        r18.getClass();
        r17.T5(com.bytedance.android.live.liveinteract.view.c.a.a(r19));
        return;
    L79:
        return;
    L56:
        ConstraintLayout r110 = this.c;
        if (r110 != null) goto L59;
    L70:
        this.a = false;
        RadioTextBoardView r111 = this.c;
        if (r111 == null) goto L73;
        r111.S5();
        r111.g = null;
    L73:
        ConstraintLayout r112 = this.c;
        if (r112 == null) goto L81;
        UtilityKotlinExtentionsKt.t(r112);
        return;
    L81:
        return;
    L59:
        if (r110.getVisibility() != 0) goto L70;
        if (this.d != 0) goto L70;
        DataCenter r113 = this.e;
        if (r113 == null) goto L70;
        InteractionWidgetsPosContext r114 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, r113, 0, 2);
        if (r114 == null) goto L69;
        m r115 = r114.getAudioTalkRadioBottomOffset();
        if (r115 == null) goto L69;
        r115.setValue(0);
    L69:
        this.e.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "MultiLinkRadioMainSeatLayer gone"));
        goto L70
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.live.liveinteract.view.RadioTextBoardView] */
    public final void a(int r3, qb r4) {
        ?? r0 = this.c;
        if (r0 == 0) goto L6;
        r0.post(new b(r0, this, r3, r4));
        return;
    }

    public e(RadioTextBoardView r1, int r2, DataCenter r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
