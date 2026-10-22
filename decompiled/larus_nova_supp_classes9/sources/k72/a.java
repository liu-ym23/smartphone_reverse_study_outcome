package k72;

import android.graphics.Rect;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.interactivity.api.entity.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public final int c;

    public abstract Integer f();

    public abstract int g();

    public abstract d h(int r1, int r2, e r3, Room r4, LiveRoomEnvStateHolder r5);

    public a() {
        this.c = UtilityKotlinExtentionsKt.i(8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public d a(int r17, int r18, e r19, Room r20, LiveRoomEnvStateHolder r21) {
        Intrinsics.checkNotNullParameter(r19, "uiContext");
        Intrinsics.checkNotNullParameter(r20, "room");
        Intrinsics.checkNotNullParameter(r21, "roomStatus");
        long r5 = r20.getRoomId();
        d r7 = null;
        if (PublicScreenStyleHelper.n == true) goto L6;
    L56:
        d r6 = r7;
    L72:
        if (r6 == null) goto L74;
        return r6;
    L74:
        return h(r17, r18, r19, r20, r21);
    L6:
        if (r19.g1() == false) goto L56;
        if (r21.O() == true) goto L11;
    L17:
        int r9 = -10086;
        if (r21.S() == false) goto L36;
        Integer r1 = f();
        if (r1 == null) goto L22;
        int r2 = r1.intValue();
    L23:
        int r8 = g();
        int r10 = r19.pT();
        Rect r13 = l00.c.a();
        if (r13 == null) goto L26;
        int r11 = r10 - r13.bottom;
        InteractionWidgetsPosContext.Companion.getClass();
        int r14 = (r11 - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) - r2;
    L27:
        int r15 = PublicScreenStyleHelper.c();
        if (r15 == 1) goto L31;
        if (r15 != 2) goto L56;
    L32:
        int r16 = RangesKt.coerceAtLeast(r14, r8);
        if (r2 == r18) goto L35;
        r9 = r2;
    L35:
        r7 = new d(r16, r9, 12);
        goto L56
    L31:
        r14 = (r14 + r8) / 2;
        goto L32
    L26:
        ALogger.e("LandscapeBroadcastUtils", "return null bottom position");
        r14 = g();
        goto L27
    L22:
        r2 = r18;
        goto L23
    L36:
        int r3 = PublicScreenStyleHelper.c();
        if (r3 == 0) goto L56;
        Integer r110 = f();
        if (r110 == null) goto L42;
        int r111 = r110.intValue();
    L43:
        int r112 = g();
        int r113 = r19.pT();
        InteractionWidgetsPosContext r23 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r5, 1);
        if (r23 == null) goto L50;
        m r24 = r23.getAnswerQuestionContainerHeight();
        if (r24 == null) goto L50;
        Integer r25 = (Integer) r24.getValue();
        if (r25 == null) goto L50;
        int r26 = r25.intValue();
    L51:
        int r27 = ((r113 - r111) - r112) - y.d;
        int r114 = n.a;
        int r28 = (r27 - r114) - r26;
        if (r28 <= 0) goto L56;
        if (r3 == 1) goto L57;
        if (r3 != 2) goto L56;
    L58:
        int r4 = r113 - (((r28 + r112) + r111) + r114);
        if (r21.B() == false) goto L62;
        boolean r29 = j.a;
        Intrinsics.checkNotNullParameter("adjust height. carnival is showing", "msg");
        r4 = Math.max(r4, o22.a.e);
    L62:
        if (r21.d0() == false) goto L66;
        boolean r30 = j.a;
        Intrinsics.checkNotNullParameter("adjust height. pin container is showing", "msg");
        r4 = Math.max(r4, r21.o() + this.c);
    L66:
        if (r21.t() == false) goto L68;
        boolean r31 = j.a;
        Intrinsics.checkNotNullParameter("adjust height. announcement is showing", "msg");
        r4 = Math.max(r4, r21.i());
    L68:
        int r33 = Math.max(((r113 - r4) - r114) - r111, r112);
        if (r111 == r18) goto L71;
        r9 = r111;
    L71:
        r6 = new d(r33, r9, 12);
        goto L72
    L57:
        r28 = r28 / 2;
    L50:
        r26 = 0;
        goto L51
    L42:
        r111 = r18;
        goto L43
    L11:
        if (r21.k0() == false) goto L15;
        if (r21.m() == 8) goto L17;
    L15:
        if (r21.H() == true) goto L17;
        goto L17
    }
}
