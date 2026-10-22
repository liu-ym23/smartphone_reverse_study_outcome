package ut1;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.chatroom.utils.LiveMultiTabHandler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.hp;
import com.bytedance.android.livesdk.config.kp;
import com.bytedance.android.livesdk.drawer.LiveDrawerContainerDialog;
import com.bytedance.android.livesdk.drawer.LiveDrawerDialog;
import com.bytedance.android.livesdk.drawer.LiveMergeDrawerDialog;
import com.bytedance.android.livesdk.drawer.drawerlynx.LiveDrawerLynxDialog;
import com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.a0;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    @JvmStatic
    public static final void e(Activity r1, boolean r2, Bundle r3, DataCenter r4) {
        g(r1, r2, r3, r4, 16);
    }

    static {
    }

    @JvmStatic
    public static final void d(Activity r2) {
        Fragment r1 = null;
        if ((r2 instanceof FragmentActivity) == true) goto L5;
        r2 = null;
    L5:
        FragmentActivity r3 = (FragmentActivity) r2;
        if (r3 == null) goto L8;
        FragmentManager r4 = r3.getSupportFragmentManager();
    L9:
        if (r4 == null) goto L11;
        r1 = r4.findFragmentByTag("LiveDrawerContainerDialog");
    L11:
        LiveDrawerContainerDialog r5 = (LiveDrawerContainerDialog) r1;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.isAdded() == false) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        return;
    L22:
        if (r5.er() == true) goto L27;
        r5.H();
        return;
    L27:
        return;
    L16:
        if (r5.isShowing() == true) goto L19;
        r6 = false;
        goto L20
    L8:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final void h(DataCenter r17) {
        com.bytedance.android.live.room.l r1 = null;
        if (r17 == null) goto L5;
        Room r2 = (Room) r17.get("data_room", null);
    L6:
        if (r17 == null) goto L8;
        r1 = (com.bytedance.android.live.room.l) r17.get("data_room_logger", null);
    L8:
        if (r2 == null) goto L10;
        String r3 = String.valueOf(r2.id);
    L11:
        String r4 = r3;
        long r5 = 0;
        if (r1 == null) goto L14;
        long r6 = r1.getDuration();
    L15:
        int r7 = 0;
        if (r17 == null) goto L20;
        Integer r0 = (Integer) r17.get("data_room_draw_index", 0);
        if (r0 == null) goto L20;
        int r8 = r0.intValue();
    L21:
        IGiftServiceExternal r9 = jc1.k.f(IGiftServiceExternal.class);
        if (r9 == null) goto L24;
        long r10 = r9.getSendGiftTime();
    L25:
        if (r9 == null) goto L27;
        r5 = r9.getSendGiftMoney();
    L27:
        long r11 = r5;
        com.bytedance.android.livesdk.interactivity.api.base.b.a r12 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r13 = q.a;
        r12.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b r14 = com.bytedance.android.livesdk.interactivity.api.base.b.a.a();
        if (r14 == null) goto L30;
        int r15 = r14.f;
    L31:
        if (r14 == null) goto L33;
        int r16 = (((r14.a + r14.b) + r14.c) + r14.d) + r14.e;
    L34:
        if (r14 == null) goto L36;
        int r18 = r14.k;
    L37:
        if (r14 == null) goto L39;
        int r19 = r14.l;
    L40:
        a0.a r20 = a0.a;
        long r110 = r6 / ((long) BubbleId.PadCast);
        if (r18 <= 0) goto L43;
        int r111 = 1;
    L44:
        if (r19 <= 0) goto L46;
        r7 = 1;
    L46:
        r20.getClass();
        a0.a r21 = new a0.a(r4, r8, r110, r10, r11, r15, r16, r111, r7);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        a0.a = r21;
        return;
    L43:
        r111 = 0;
        goto L44
    L39:
        r19 = 0;
        goto L40
    L36:
        r18 = 0;
        goto L37
    L33:
        r16 = 0;
        goto L34
    L30:
        r15 = 0;
        goto L31
    L24:
        r10 = 0;
    L20:
        r8 = 0;
        goto L21
    L14:
        r6 = 0;
        goto L15
    L10:
        r3 = "";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void a(LiveDrawerDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LiveDrawerDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.showNow(r3, "LiveDrawerDialog");
    }

    public static void b(LiveMergeDrawerDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LiveMergeDrawerDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.showNow(r3, "LiveMergeDrawerDialog");
    }

    public static FragmentTransaction c(FragmentTransaction r2, BaseDialogFragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    @JvmStatic
    public static final void f(Activity r21, boolean r22, Bundle r23, DataCenter r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r23, "args");
        boolean r3 = r21 instanceof FragmentActivity;
        if (r3 == true) goto L5;
        return;
    L5:
        String r4 = null;
        if (r24 == null) goto L8;
        Boolean r5 = (Boolean) r24.get("data_is_enter_from_preview_live_mix", Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L12;
        return;
    L12:
        LiveMultiTabHandler r6 = LiveMultiTabHandler.b;
        if (r6.interceptLeftSlideOpenDrawer() == false) goto L19;
        if (r6.b(RoomContext.a.c(RoomContext.Companion, r24, 0, 2)) == false) goto L19;
        ALogger.e("LiveDrawerOpener-openDrawer", "more live to live tab intercept");
        return;
    L19:
        if (r23.getBoolean("LIVE_DRAW_DIALOG_OPEN_SEARCH", false) == false) goto L21;
    L24:
        boolean r7 = true;
    L25:
        RoomContext.a r11 = RoomContext.Companion;
        RoomContext r12 = RoomContext.a.c(r11, r24, 0, 2);
        if (r12 == null) goto L61;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L61;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L61;
        if (r14.withAggregateColumn != true) goto L61;
        if (r23.getBoolean("drawer_feed", false) == true) goto L61;
        if (r7 == true) goto L61;
        if (r3 == false) goto L282;
        FragmentManager r0 = ((FragmentActivity) r21).getSupportFragmentManager();
        if (r22 == false) goto L49;
        if ((r0.findFragmentByTag("LiveMergeDrawerDialog") instanceof LiveMergeDrawerDialog) == false) goto L47;
        LiveMergeDrawerDialog r1 = r0.findFragmentByTag("LiveMergeDrawerDialog");
        if (r1 != null) goto L45;
        return;
    L45:
        if (r1.isAdded() == true) goto L275;
        b(r1, r0);
        return;
    L275:
        return;
    L47:
        LiveMergeDrawerDialog r2 = new LiveMergeDrawerDialog();
        r2.e = r24;
        b(r2, r0);
        return;
    L49:
        if ((r0.findFragmentByTag("LiveMergeDrawerDialog") instanceof LiveMergeDrawerDialog) == false) goto L278;
        LiveMergeDrawerDialog r8 = r0.findFragmentByTag("LiveMergeDrawerDialog");
        if (r8 != null) goto L53;
        return;
    L53:
        if (r8.isAdded() != true) goto L280;
        r8.dismiss();     // Catch: Exception -> L56
        return;
    L56:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L281;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L281:
        return;
    L280:
        return;
    L278:
        return;
    L282:
        return;
    L61:
        h(r24);
        if (r24 == null) goto L67;
        Object r10 = r24.get("data_room");
        if (r10 != null) goto L66;
        r10 = null;
    L66:
        Room r15 = (Room) r10;
    L68:
        if (r15 == null) goto L70;
        VerticalTypeInfo r16 = r15.mVerticalTypeInfo;
    L71:
        long r17 = -1;
        if (r16 == null) goto L76;
        Long r18 = r16.tagId;
        if (r18 == null) goto L76;
        long r19 = r18.longValue();
    L77:
        r23.putLong("tag_id", r19);
        if (r16 == null) goto L82;
        Long r20 = r16.tabType;
        if (r20 == null) goto L82;
        r17 = r20.longValue();
    L82:
        r23.putLong("tab_type", r17);
        if (r16 == null) goto L87;
        Boolean r26 = r16.isSubTag;
        if (r26 == null) goto L87;
        boolean r27 = r26.booleanValue();
    L88:
        r23.putBoolean("is_sub_tag", r27);
        if (r16 == null) goto L92;
        String r28 = r16.extra;
        if (r28 == null) goto L92;
    L93:
        r23.putString("extra_info", r28);
        if (r15 == null) goto L112;
        VerticalTypeInfo r29 = r15.mVerticalTypeInfo;
        if (r29 == null) goto L112;
        Long r30 = r29.tabType;
        if (r30 != null) goto L101;
    L103:
        boolean r31 = false;
    L104:
        if (r31 == true) goto L107;
        r29 = null;
    L107:
        if (r29 == null) goto L112;
        Pair[] r32 = new Pair[2];
        r32[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        String r33 = r29.eventExtra;
        if (r33 != null) goto L111;
        r33 = "";
    L111:
        r32[1] = TuplesKt.to("extra", r33);
        Map r34 = MapsKt.mutableMapOf(r32);
    L113:
        FragmentManager r35 = ((FragmentActivity) r21).getSupportFragmentManager();
        FragmentTransaction r36 = r35.beginTransaction();
        RoomContext r37 = RoomContext.a.c(r11, r24, 0, 2);
        StringBuilder r38 = new StringBuilder("drawer_setting=");
        hp r39 = hp.a;
        r38.append(r39.getValue());
        r38.append(";isVSSpecialDrawer=");
        if (r37 == null) goto L116;
        Boolean r110 = Boolean.valueOf(r37.isVSSpecialDrawer());
    L117:
        r38.append(r110);
        r38.append(";room_id=");
        if (r37 == null) goto L124;
        com.bytedance.live.datacontext.m r111 = r37.getRoom();
        if (r111 == null) goto L124;
        Room r112 = (Room) r111.getValue();
        if (r112 == null) goto L124;
        r4 = r112.getIdStr();
    L124:
        r38.append(r4);
        ALogger.i("LiveDrawerOpener", r38.toString());
        Integer r40 = r39.getValue();
        if (r40 != null) goto L128;
    L129:
        if (r37 == null) goto L133;
        if (r37.isVSSpecialDrawer() != true) goto L133;
    L176:
        Integer r41 = r39.getValue();
        if (r41 != null) goto L180;
    L181:
        if (r37 == null) goto L185;
        if (r37.isVSSpecialDrawer() != true) goto L185;
    L224:
        if (r22 == false) goto L250;
        if (r24 == null) goto L235;
        IAbilityCenter r42 = com.bytedance.android.live.core.utils.a0.a(r24);
        if (r42 == null) goto L235;
        IRoomRecordService r43 = r42.getAbility(IRoomRecordService.class);
        if (r43 == null) goto L235;
        if (r43.isRecording() != true) goto L235;
        f2.b(2131921972, 0);
        return;
    L235:
        if ((r35.findFragmentByTag("LiveDrawerDialog") instanceof LiveDrawerDialog) == false) goto L243;
        LiveDrawerDialog r44 = r35.findFragmentByTag("LiveDrawerDialog");
        if (r44 != null) goto L239;
    L241:
        if (r44 == null) goto L244;
        a(r44, r35);
    L244:
        String r45 = r23.getString("pull_type");
        if (r45 != null) goto L247;
        String r46 = "";
    L248:
        h.b(r46, r34);
        return;
    L247:
        r46 = r45;
        goto L248
    L239:
        if (r44.isAdded() != true) goto L241;
        return;
    L243:
        r23.putLong("drawer_enter_time", SystemClock.elapsedRealtime());
        List<DrawerLayout.DrawerListener> r47 = LiveDrawerHelper.a;
        LiveDrawerDialog r48 = new LiveDrawerDialog();
        r48.p = r47;
        r48.q = r23;
        r48.y = r24;
        a(r48, r35);
        goto L244
    L250:
        if ((r35.findFragmentByTag("LiveDrawerDialog") instanceof LiveDrawerDialog) == false) goto L294;
        LiveDrawerDialog r49 = r35.findFragmentByTag("LiveDrawerDialog");
        if (r49 != null) goto L254;
        return;
    L254:
        if (r49.isAdded() != true) goto L296;
        r49.dismiss();     // Catch: Exception -> L257
        return;
    L257:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r50 = DialogFragmentLancet.sLastShowStack;
        if (r50 == null) goto L297;
        com.bytedance.crash.d.d(r50, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L297:
        return;
    L296:
        return;
    L294:
        return;
    L185:
        if (kp.a.getValue().booleanValue() == false) goto L224;
        if (r22 == false) goto L216;
        if ((r35.findFragmentByTag("LiveDrawerRelaxDialog") instanceof LiveDrawerRelaxDialog) == false) goto L205;
        LiveDrawerRelaxDialog r51 = r35.findFragmentByTag("LiveDrawerRelaxDialog");
        if (r51 == null) goto L204;
        LiveDrawerRelaxDialog r52 = r51;
        if (r52.isAdded() == true) goto L195;
        c(r36, r52, "LiveDrawerRelaxDialog");
    L195:
        Bundle r53 = r52.getArguments();
        if (r53 == null) goto L198;
        r53.putAll(r23);
    L198:
        r52.f = r24;
        r36.setMaxLifecycle(r52, Lifecycle.State.RESUMED).commitAllowingStateLoss();     // Catch: Exception -> L201
    L210:
        r23.putLong("drawer_enter_time", SystemClock.elapsedRealtime());
        String r54 = r23.getString("pull_type");
        if (r54 != null) goto L213;
        String r55 = "";
    L214:
        h.b(r55, r34);
        return;
    L213:
        r55 = r54;
    L201:
        e = move-exception;
        ALogger.e("LiveDrawerOpener-findFragment", e);
        goto L210
    L204:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog");
    L205:
        LiveDrawerRelaxDialog r56 = new LiveDrawerRelaxDialog();
        r56.f = r24;
        Lifecycle.State r57 = Lifecycle.State.RESUMED;     // Catch: Exception -> L208
        r56.setArguments(r23);     // Catch: Exception -> L208
        c(r36, r56, "LiveDrawerRelaxDialog").setMaxLifecycle(r56, r57).commitAllowingStateLoss();     // Catch: Exception -> L208
    L208:
        e = move-exception;
        ALogger.e("LiveDrawerOpener-createFragment", e);
        goto L210
    L216:
        if ((r35.findFragmentByTag("LiveDrawerRelaxDialog") instanceof LiveDrawerRelaxDialog) == false) goto L290;
        LiveDrawerRelaxDialog r58 = r35.findFragmentByTag("LiveDrawerRelaxDialog");
        if (r58 != null) goto L220;
        return;
    L220:
        if (r58.isAdded() != true) goto L292;
        r58.V90();
        return;
    L292:
        return;
    L290:
        return;
    L180:
        if (r41.intValue() == 0) goto L224;
    L133:
        if (kp.a.getValue().booleanValue() == true) goto L176;
        if (r22 == false) goto L169;
        if ((r35.findFragmentByTag("LiveDrawerLynxDialog") instanceof LiveDrawerLynxDialog) == false) goto L154;
        if (r25 == true) goto L154;
        LiveDrawerLynxDialog r59 = r35.findFragmentByTag("LiveDrawerLynxDialog");
        if (r59 == null) goto L153;
        LiveDrawerLynxDialog r60 = r59;
        if (r60.isAdded() == true) goto L144;
        c(r36, r60, "LiveDrawerLynxDialog");
    L144:
        Bundle r61 = r60.getArguments();
        if (r61 == null) goto L147;
        r61.putAll(r23);
    L147:
        r60.e = r24;
        r36.setMaxLifecycle(r60, Lifecycle.State.RESUMED).commitAllowingStateLoss();     // Catch: Exception -> L150
    L162:
        r23.putLong("drawer_enter_time", SystemClock.elapsedRealtime());
        String r62 = r23.getString("pull_type");
        if (r62 != null) goto L165;
        String r63 = "";
    L166:
        if (r25 == true) goto L284;
        h.b(r63, r34);
        return;
    L284:
        return;
    L165:
        r63 = r62;
    L150:
        e = move-exception;
        ALogger.e("LiveDrawerOpener-findFragment", e);
        goto L162
    L153:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.drawer.drawerlynx.LiveDrawerLynxDialog");
    L154:
        LiveDrawerLynxDialog r64 = new LiveDrawerLynxDialog();
        r64.e = r24;
        if (r25 == false) goto L157;
        r23.putBoolean("smart_client_preload", true);     // Catch: Exception -> L160
        Lifecycle.State r65 = Lifecycle.State.CREATED;     // Catch: Exception -> L160
    L158:
        r64.setArguments(r23);     // Catch: Exception -> L160
        c(r36, r64, "LiveDrawerLynxDialog").setMaxLifecycle(r64, r65).commitAllowingStateLoss();     // Catch: Exception -> L160
        goto L162
    L157:
        r65 = Lifecycle.State.RESUMED;     // Catch: Exception -> L160
    L160:
        e = move-exception;
        ALogger.e("LiveDrawerOpener-createFragment", e);
        goto L162
    L169:
        if ((r35.findFragmentByTag("LiveDrawerLynxDialog") instanceof LiveDrawerLynxDialog) == false) goto L286;
        LiveDrawerLynxDialog r66 = r35.findFragmentByTag("LiveDrawerLynxDialog");
        if (r66 != null) goto L173;
        return;
    L173:
        if (r66.isAdded() != true) goto L288;
        r66.V90();
        return;
    L288:
        return;
    L286:
        return;
    L128:
        if (r40.intValue() == 0) goto L176;
    L116:
        r110 = null;
        goto L117
    L101:
        if (r30.longValue() != 11) goto L103;
        r31 = true;
    L112:
        r34 = null;
    L92:
        r28 = "";
    L87:
        r27 = false;
    L76:
        r19 = -1;
        goto L77
    L70:
        r16 = null;
        goto L71
    L67:
        r15 = null;
        goto L68
    L21:
        if (r23.getBoolean("LIVE_DRAW_DIALOG_OPEN_HISTORY", false) == true) goto L24;
        r7 = false;
        goto L25
    L8:
        r5 = null;
        goto L10
    }

    public static /* synthetic */ void g(Activity r0, boolean r1, Bundle r2, DataCenter r3, int r4) {
        if ((r4 & 8) == 0) goto L5;
        r3 = null;
    L5:
        f(r0, r1, r2, r3, false);
    }
}
