package ep1;

import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ec;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.g4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends c {
    public final List<C0382a> a;

    /* JADX INFO: renamed from: ep1.a$a, reason: collision with other inner class name */
    public static final class C0382a {
        public List<? extends ToolbarButton> a;
        public final String b;
        public final List<ToolbarButton> c;
        public final int d;
        public final int e;

        /* JADX WARN: Multi-variable type inference failed */
        public C0382a(String r2, List<? extends ToolbarButton> r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_TITLE);
            Intrinsics.checkNotNullParameter(r3, "possibles");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.a = CollectionsKt.emptyList();
        }
    }

    @Override // ep1.c
    public final String b() {
        return null;
    }

    public a() {
        C0382a[] r1 = new C0382a[3];
        List r3 = CollectionsKt.mutableListOf(new ToolbarButton[]{ToolbarButton.BGM, ToolbarButton.FNA_GROUP, ToolbarButton.FAN_GROUP_MANAGE, ToolbarButton.COMMENT, ToolbarButton.KTV_GROUP, ToolbarButton.VIDEO_PLAY, ToolbarButton.COMMERCE_MORE, ToolbarButton.GAME_PROMOTE_MORE, ToolbarButton.TRANSFORM_WIDGET_MORE, ToolbarButton.WELFARE_FOLD, ToolbarButton.POI, ToolbarButton.ACTIVITY_ZONE, ToolbarButton.ANCHOR_SHOW, ToolbarButton.GROUP_PURCHASE_MORE, ToolbarButton.LIVE_IM_ENTRANCE_MORE, ToolbarButton.ADVANCE_ANNOUNCEMENT, ToolbarButton.LINKMIC_SETTING, ToolbarButton.UNION_LIVE, ToolbarButton.OPEN_PLATFORM_MINI_APP_MORE, ToolbarButton.INTERACT_GIFT, ToolbarButton.LINKMIC_ANNOUNCE});
        int r4 = g4.a;
        if (g4.a.a() == false) goto L5;
        r3.add(ToolbarButton.VOTE);
        r3.add(ToolbarButton.LOTTERY);
        r3.add(ToolbarButton.WISH_LIST);
    L5:
        Unit r5 = Unit.INSTANCE;
        r1[0] = new C0382a("互动能力", r3, 2131390040, 2131373800);
        r1[1] = new C0382a("直播工具", CollectionsKt.listOf(new ToolbarButton[]{ToolbarButton.PUSH_URL, ToolbarButton.BROADCAST_TASK, ToolbarButton.TASK_CENTER, ToolbarButton.PUBLIC_SCREEN_SELECTED_MESSAGE, ToolbarButton.PUBLIC_SCREEN_AI_HELPER, ToolbarButton.ANCHOR_CHAT_CHANNEL, ToolbarButton.PUBLIC_SCREEN_CONFIG, ToolbarButton.LIVING_DRAINAGE, ToolbarButton.RECORD, ToolbarButton.ANCHOR_BACKTRACK, ToolbarButton.RECORD_COMBINE, ToolbarButton.SHARE, ToolbarButton.GUARD_BOX, ToolbarButton.BROADCAST_PAUSE, ToolbarButton.LIVE_MATRIX, ToolbarButton.DOU_PLUS_PROMOTE, ToolbarButton.REN_QI_BAO, ToolbarButton.BROADCAST_INFO, ToolbarButton.MESSAGE_PUSH, ToolbarButton.TICKET_SALE_ANCHOR_MORE, ToolbarButton.BROADCAST_RESTART, ToolbarButton.STABLE_MODE, ToolbarButton.LICENSE_INFO, ToolbarButton.FLOW_FEEDBACK, ToolbarButton.KEY_ROOM_INFO, ToolbarButton.PERMANENT_CHAT_ROOM, ToolbarButton.PERMANENT_CHAT_GUEST, ToolbarButton.ADD_PICTURE}), 2131390045, 2131373801);
        r1[2] = new C0382a("基础功能", CollectionsKt.listOf(new ToolbarButton[]{ToolbarButton.REVERSE_CAMERA, ToolbarButton.BROADCAST_GIFT, ToolbarButton.BROADCAST_ADMIN, ToolbarButton.MANAGE, ToolbarButton.QUESTION_AND_ANSWER}), 2131390033, 2131373799);
        this.a = CollectionsKt.listOf(r1);
    }

    @Override // ep1.c
    public final int a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (ec.a.getValue().booleanValue() == false) goto L6;
        return 2131565666;
    L6:
        return 2131565665;
    }

    @Override // ep1.c
    public final boolean c(List<ToolbarButton> r11, ViewGroup r12, Function2<? super ToolbarButton, ? super GridLayout, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "buttons");
        Intrinsics.checkNotNullParameter(r12, "rootView");
        Intrinsics.checkNotNullParameter(r13, "loader");
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        C0382a r2 = (C0382a) r1.next();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "buttons");
        List<ToolbarButton> r3 = r2.c;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (r11.contains((ToolbarButton) r6) == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        r2.a = r4;
        TextView r7 = (TextView) r12.findViewById(r2.d);
        if (r7 == null) goto L4;
        GridLayout r8 = (GridLayout) r12.findViewById(r2.e);
        if (r8 == null) goto L4;
        boolean r9 = r2.a.isEmpty();
        boolean r10 = !r9;
        UtilityKotlinExtentionsKt.z(r7, r10);
        UtilityKotlinExtentionsKt.z(r8, r10);
        if (r9 == true) goto L4;
        r7.setText(r2.b);
        r8.removeAllViews();
        Iterator<T> r14 = r2.a.iterator();
    L22:
        if (r14.hasNext() == false) goto L4;
        r13.invoke((ToolbarButton) r14.next(), r8);
        goto L22
    L25:
        if (v.a() == false) goto L46;
        ArrayList r0 = new ArrayList();
        Iterator<T> r15 = r11.iterator();
    L27:
        boolean r16 = false;
        if (r15.hasNext() == false) goto L44;
        Object r17 = r15.next();
        ToolbarButton r18 = (ToolbarButton) r17;
        List<C0382a> r19 = this.a;
        if ((r19 instanceof Collection) == true) goto L32;
    L34:
        Iterator<T> r20 = r19.iterator();
    L36:
        if (r20.hasNext() == false) goto L40;
        if ((!((C0382a) r20.next()).a.contains(r18)) == true) goto L36;
    L41:
        if (r16 == false) goto L27;
        r0.add(r17);
    L40:
        r16 = true;
        goto L41
    L32:
        if (r19.isEmpty() == false) goto L34;
    L44:
        if ((!r0.isEmpty()) == false) goto L46;
        f2.c("以下按钮未分组，不会展示：" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null), 0);
    L46:
        return true;
    }
}
