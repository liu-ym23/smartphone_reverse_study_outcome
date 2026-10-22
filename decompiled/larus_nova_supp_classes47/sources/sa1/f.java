package sa1;

import am2.x;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.q01;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.landscape.LandscapeScene;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveSearchViewHolder a;
    public final /* synthetic */ Room b;

    public f(LiveSearchViewHolder r1, Room r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LiveSearchViewHolder r12 = this.a;
        Room r0 = this.b;
        int r1 = LiveSearchViewHolder.t;
        r12.getClass();
        Bundle r2 = new Bundle();
        r2.putString("source", "general_search");
        r2.putString("enter_from", "general_search");
        r2.putString("source", "drawer_cover");
        r2.putString("anchor_id", r0.getOwnerUserIdString());
        o r3 = u.l().c(x.class);
        if (r3 != null) goto L5;
    L7:
        Bundle r4 = new Bundle();
        r4.putString("live.intent.extra.ENTER_LIVE_SOURCE_V1", "drawer_cover");
        r2.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r4);
        r2.putString("anchor_id", r0.getOwnerUserIdString());
        com.bytedance.android.live.search.impl.search.b r5 = r12.m;
        if (r5 == null) goto L11;
        String r6 = r5.f;
        if (r6 == null) goto L11;
    L12:
        r2.putString("previous_page", r6);
        String r7 = r0.getRequestId();
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r2.putString("request_id", r7);
        r2.putString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE", "draw");
        r2.putString("live.intent.extra.ENTER_TYPE", "draw");
        Integer r8 = (Integer) q01.a.getValue();
        if (r8 != null) goto L19;
    L30:
        com.bytedance.android.live.search.impl.search.b r9 = r12.m;
        if (r9 == null) goto L33;
        long[] r13 = r9.b;
    L34:
        r2.putLongArray("live_drawer_search_room_id", r13);
        com.bytedance.android.live.search.impl.search.b r14 = r12.m;
        if (r14 == null) goto L37;
        String[] r15 = r14.d;
    L38:
        r2.putStringArray("live_drawer_search_id", r15);
        com.bytedance.android.live.search.impl.search.b r16 = r12.m;
        if (r16 == null) goto L41;
        String[] r17 = r16.e;
    L42:
        r2.putStringArray("live_drawer_search_result_id", r17);
        com.bytedance.android.live.search.impl.search.b r18 = r12.m;
        if (r18 == null) goto L47;
        pa1.d r19 = r18.a;
        if (r19 == null) goto L47;
        r19.b(r2);
    L47:
        r2.putInt(VSConstants.EXTRA_ITEM_TYPE, ArgumentsBuilder.getRoomType(r0));
        IRoomService r20 = (IRoomService) k.f(IRoomService.class);
        if (r20 == null) goto L50;
        Room r22 = r20.getCurrentRoom();
    L51:
        RoomContext r23 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r23 != null) goto L54;
    L57:
        if (r22 != null) goto L59;
    L60:
        xs2.b r24 = xs2.b.a();
        JumpToOtherRoomEvent r25 = new JumpToOtherRoomEvent(r0.id, "general_search", r2);
        r25.source = "sourceJumpToOtherLiveSearchVh";
        Unit r26 = Unit.INSTANCE;
        r24.post(r25);
        String r27 = com.bytedance.android.live.search.impl.search.a.a;
        com.bytedance.android.live.search.impl.search.a.b = r0.id;
    L61:
        com.bytedance.android.live.search.impl.search.b r28 = r12.m;
        if (r28 == null) goto L66;
        pa1.d r29 = r28.a;
        if (r29 == null) goto L66;
        r29.closeDrawerDialog();
    L66:
        qa1.e r30 = r12.l;
        if (r30 == null) goto L70;
        r30.D0(r12.k);
        return;
    L70:
        return;
    L59:
        if (r22.id == r0.id) goto L61;
    L54:
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L57;
        LandscapeLiveMonitor.a r32 = LandscapeLiveMonitor.Companion;
        Pair r33 = TuplesKt.to(Long.valueOf(r0.id), LandscapeScene.JUMP);
        r32.getClass();
        LandscapeLiveMonitor.a.d(r33);
        r2.putBoolean("live.intent.extra.is_game_live", d1.a(r0));
        r2.putInt("live.intent.extra.SCREEN_ORIENTATION", ((Boolean) r23.isPortraitInteraction().getValue()).booleanValue() ? 1 : 0);
        goto L57
    L50:
        r22 = null;
        goto L51
    L41:
        r17 = null;
        goto L42
    L37:
        r15 = null;
        goto L38
    L33:
        r13 = null;
        goto L34
    L19:
        if (r8.intValue() != 1) goto L30;
        com.bytedance.android.live.search.impl.search.b r34 = r12.m;
        if (r34 == null) goto L25;
        long[] r35 = r34.b;
        if (r35 == null) goto L25;
        r2.putLongArray("live.intent.extra.ENTER_ROOM_IDS", r35);
    L25:
        com.bytedance.android.live.search.impl.search.b r36 = r12.m;
        if (r36 == null) goto L30;
        int[] r37 = r36.c;
        if (r37 == null) goto L30;
        r2.putIntArray(VSConstants.EXTRA_STORY_ROOM_TYPE_ARRAY, r37);
    L11:
        r6 = "live_merge";
        goto L12
    L5:
        if (r3.getMap() == null) goto L7;
        r2.putString("enter_from_merge", "general_search");
        r2.putString("enter_method", "drawer_cover");
        goto L7
    }
}
