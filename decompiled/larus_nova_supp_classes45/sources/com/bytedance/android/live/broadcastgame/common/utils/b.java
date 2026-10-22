package com.bytedance.android.live.broadcastgame.common.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.model.o;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import jc1.k;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final u r16, Context r17, final DataCenter r18, final Function0 r19, Function0 r21) {
        Intrinsics.checkNotNullParameter(r16, "gameItem");
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        Intrinsics.checkNotNullParameter(r19, "onSuccess");
        Intrinsics.checkNotNullParameter(r21, "onFail");
        if (r16.interactId != InteractID.EffectGame.getValue()) goto L6;
        Sequence r1 = SequencesKt.sequence(new LiveOpenFeatureMutexHelper$provideEffectGameStartUpMutexStrategy$1(null));
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        if (((Boolean) ((Function0) r2.next()).invoke()).booleanValue() == false) goto L11;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L90;
        u r4 = ((IInteractGameService) k.n(IInteractGameService.class)).getCurrentPlayingGame();
        String r11 = "";
        if (r4 == null) goto L21;
        String r5 = r4.name;
        if (r5 == null) goto L21;
    L22:
        if (r4 == null) goto L27;
        r r6 = r4.c();
        if (r6 == null) goto L27;
        String r7 = String.valueOf(r6.p());
        if (r7 == null) goto L27;
    L28:
        InteractGameContext.Companion r8 = InteractGameContext.Companion;
        if (r8.g() == false) goto L48;
        InteractGameContext r9 = r8.getContext();
        if (r9 == null) goto L38;
        n<i0> r12 = r9.getCurrentOpenPlatformAppInfo();
        if (r12 == null) goto L38;
        i0 r13 = (i0) r12.getValue();
        if (r13 == null) goto L38;
        r5 = r13.c;
        if (r5 == null) goto L38;
    L39:
        InteractGameContext r14 = r8.getContext();
        if (r14 == null) goto L47;
        n<i0> r15 = r14.getCurrentOpenPlatformAppInfo();
        if (r15 == null) goto L47;
        i0 r22 = (i0) r15.getValue();
        if (r22 == null) goto L47;
        r7 = r22.b;
        if (r7 != null) goto L48;
    L47:
        r7 = "";
    L38:
        r5 = "";
    L48:
        Triple r110 = new Triple(r7, r5, r4);
        final String r111 = (String) r110.component1();
        final String r112 = (String) r110.component2();
        final u r23 = (u) r110.component3();
        if (o.a(r16) == true) goto L62;
        if (r112.length() != 0) goto L53;
        boolean r24 = true;
    L54:
        if (r24 == false) goto L62;
        if (r111.length() != 0) goto L58;
        boolean r25 = true;
    L59:
        if (r25 == false) goto L62;
        r19.invoke();
        return;
    L58:
        r25 = false;
        goto L59
    L53:
        r24 = false;
    L62:
        if (LiveOpenFeatureChooseConfig.useV3() == true) goto L64;
        String r26 = s1.B(2131922675);
    L77:
        x0.d r113 = new x0.d();
        r113.b = r17;
        r113.a = 7;
        r113.k = false;
        r113.l = false;
        r113.c = s1.B(2131922677);
        r113.d = r26;
        DialogInterface.OnClickListener r114 = new LiveOpenFeatureMutexHelper$getSwitchGameConfirmDialog$1(r23, r18, r16, r19, r112, r111);
        x0.c[] r0 = r113.g;
        x0.c r27 = r0[0];
        if (r27 != null) goto L80;
        r27 = new x0.c();
        r0[0] = r27;
    L80:
        r27.a = "确认";
        r27.b = r114;
        a r28 = new a(r21, r112, r111, r16);
        x0.c[] r29 = r113.g;
        x0.c r31 = r29[1];
        if (r31 != null) goto L83;
        r31 = new x0.c();
        r29[1] = r31;
    L83:
        r31.a = "取消";
        r31.b = r28;
        x0.b.g(new x0(r113.b, r113));
        int r32 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        String r33 = r16.name;
        r r34 = r16.c();
        if (r34 == null) goto L89;
        String r35 = String.valueOf(r34.p());
        if (r35 == null) goto L89;
        r11 = r35;
    L89:
        Intrinsics.checkNotNullParameter(r112, "programNameNow");
        Intrinsics.checkNotNullParameter(r111, "programIdNow");
        Intrinsics.checkNotNullParameter(r33, "programNameNext");
        Intrinsics.checkNotNullParameter(r11, "programIdNext");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_program_change_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id_now", r111), TuplesKt.to("program_name_now", r112), TuplesKt.to("program_id_next", r11), TuplesKt.to("program_name_next", r33)}), new Object[]{Room.class});
        return;
    L64:
        if (r8.j() == false) goto L70;
        if (r16.interactId != InteractID.SonicMiniGame.getValue()) goto L68;
        r26 = s1.B(2131922683);
        goto L77
    L68:
        r26 = s1.B(2131922684);
        goto L77
    L70:
        if (r8.f() == true) goto L72;
        r26 = s1.B(2131922675);
        goto L77
    L72:
        if (r16.interactId != InteractID.OpenMicroGame.getValue()) goto L74;
        r26 = s1.B(2131922676);
        goto L77
    L74:
        r26 = s1.B(2131922679);
    L27:
        r7 = "";
    L21:
        r5 = "";
        goto L22
    L90:
        r19.invoke();
        return;
    L15:
        r3 = false;
        goto L16
    L6:
        if (o.a(r16) == false) goto L8;
        r1 = SequencesKt.sequence(new LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1(r16, null));
        goto L9
    L8:
        r1 = SequencesKt.sequence(new LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1(null));
        goto L9
    }
}
