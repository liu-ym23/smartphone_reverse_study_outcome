package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public static final a f = null;

    public static final class a {
        public a() {
        }

        public static void a(Room r2) {
            dm r0 = new dm();
            r0.set_componentType(20);
            r0.set_eventType(1);
            r0.set_groupId(1);
            r0.set_opType(1);
            r0.set_showType(3);
            r0.set_text(s1.B(2131922489));
            b(r2, r0, false);
        }

        public static ToolbarComponentData c(dm r5) {
            ToolbarComponentData r0 = new ToolbarComponentData();
            r0.setId(r5.getComponentType());
            r0.setGroupId(r5.getGroupId());
            r0.setOperate(r5.getOpType());
            String r1 = r5.getText();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.setName(r1);
            String r3 = r5.getExtraData();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r0.setExtraData(r3);
            r0.setShowType((int) r5.getShowType());
            py.k r4 = r5.getIcon();
            if ((r4 instanceof ImageModel) == true) goto L11;
            r4 = null;
        L11:
            r0.setIcon((ImageModel) r4);
            String r6 = r5.getSchema();
            if (r6 == null) goto L15;
            r2 = r6;
        L15:
            r0.setScheme(r2);
            return r0;
        }

        public static boolean d(Room r6) {
            Object r2 = null;
            if (r6 == null) goto L18;
            LiveToolbarData r7 = r6.getToolbarData();
            if (r7 == null) goto L18;
            List r8 = r7.getLandScapeTop();
            if (r8 == null) goto L18;
            Iterator r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L17;
            Object r3 = r9.next();
            if (((ToolbarComponentData) r3).getId() != 20) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L10;
            r2 = r3;
            goto L17
        L14:
            r4 = false;
        L17:
            r2 = (ToolbarComponentData) r2;
        L18:
            if (r2 == null) goto L26;
            return true;
        L26:
            return false;
        }

        public static boolean e(Room r6) {
            Object r2 = null;
            if (r6 == null) goto L18;
            LiveToolbarData r7 = r6.getToolbarData();
            if (r7 == null) goto L18;
            List r8 = r7.getMorePanelDataList();
            if (r8 == null) goto L18;
            Iterator r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L17;
            Object r3 = r9.next();
            if (((ToolbarComponentData) r3).getId() != 20) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L10;
            r2 = r3;
            goto L17
        L14:
            r4 = false;
        L17:
            r2 = (ToolbarComponentData) r2;
        L18:
            if (r2 == null) goto L26;
            return true;
        L26:
            return false;
        }

        public static void f(Room r8) {
            Object r0 = null;
            if (r8 != null) goto L53;
        L7:
            List r1 = null;
        L9:
            if ((r1 instanceof ArrayList) == true) goto L11;
            r1 = null;
        L11:
            ArrayList r2 = (ArrayList) r1;     // Catch: Exception -> L51
            if (r2 != null) goto L14;
            return;
        L14:
            Iterator r3 = r2.iterator();     // Catch: Exception -> L51
        L16:
            if (r3.hasNext() == false) goto L23;
            Object r4 = r3.next();     // Catch: Exception -> L51
            if (((ToolbarComponentData) r4).getId() != 20) goto L20;
            boolean r7 = true;
        L21:
            if (r7 == false) goto L16;
        L24:
            ToolbarComponentData r5 = (ToolbarComponentData) r4;     // Catch: Exception -> L51
            if (r5 == null) goto L27;
            r2.remove(r5);     // Catch: Exception -> L51
        L27:
            if (r8 == null) goto L31;
            LiveToolbarData r9 = r8.getToolbarData();     // Catch: Exception -> L51
            if (r9 == null) goto L31;
            List r10 = r9.getToolbarDataList();     // Catch: Exception -> L51
        L33:
            if ((r10 instanceof ArrayList) == true) goto L35;
            r10 = null;
        L35:
            ArrayList r11 = (ArrayList) r10;     // Catch: Exception -> L51
            if (r11 != null) goto L38;
            return;
        L38:
            Iterator r6 = r11.iterator();     // Catch: Exception -> L51
        L40:
            if (r6.hasNext() == false) goto L47;
            Object r12 = r6.next();     // Catch: Exception -> L51
            if (((IToolbarComponentData) r12).getId() != 20) goto L44;
            boolean r13 = true;
        L45:
            if (r13 == false) goto L40;
            r0 = r12;
            goto L47
        L44:
            r13 = false;
        L47:
            IToolbarComponentData r14 = (IToolbarComponentData) r0;     // Catch: Exception -> L51
            if (r14 == null) goto L65;
            r11.remove(r14);     // Catch: Exception -> L51
            return;
        L51:
            ALogger.e("ToolbarShareConfig", "remove room data error.");
            return;
        L65:
            return;
        L31:
            r10 = null;
            goto L33
        L20:
            r7 = false;
            goto L21
        L23:
            r4 = null;
            goto L24
        L53:
            LiveToolbarData r15 = r8.getToolbarData();     // Catch: Exception -> L51
            if (r15 == null) goto L7;
            r1 = r15.getMorePanelDataList();     // Catch: Exception -> L51
            goto L9
        }

        public static boolean g(Room r6) {
            Object r2 = null;
            if (r6 == null) goto L18;
            LiveToolbarData r7 = r6.getToolbarData();
            if (r7 == null) goto L18;
            List r8 = r7.getToolbarDataList();
            if (r8 == null) goto L18;
            Iterator r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L17;
            Object r3 = r9.next();
            if (((IToolbarComponentData) r3).getId() != 20) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L10;
            r2 = r3;
            goto L17
        L14:
            r4 = false;
        L17:
            r2 = (IToolbarComponentData) r2;
        L18:
            if (r2 == null) goto L26;
            return true;
        L26:
            return false;
        }

        public static void b(Room r1, dm r2, boolean r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            List r0 = null;
            if (r3 == false) goto L18;
            if (r1 == null) goto L10;
            LiveToolbarData r4 = r1.getToolbarData();
            if (r4 == null) goto L10;
            List r5 = r4.getToolbarDataList();
        L12:
            if ((r5 instanceof ArrayList) == false) goto L15;
            r0 = r5;
        L15:
            ArrayList r6 = (ArrayList) r0;
            if (r6 == null) goto L31;
            r6.add(c(r2));
            return;
        L31:
            return;
        L10:
            r5 = null;
            goto L12
        L18:
            if (r1 == null) goto L22;
            LiveToolbarData r7 = r1.getToolbarData();
            if (r7 == null) goto L22;
            List r8 = r7.getMorePanelDataList();
        L24:
            if ((r8 instanceof ArrayList) == false) goto L27;
            r0 = r8;
        L27:
            ArrayList r9 = (ArrayList) r0;
            if (r9 == null) goto L33;
            r9.add(c(r2));
            return;
        L33:
            return;
        L22:
            r8 = null;
            goto L24
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean o() {
        return true;
    }

    static {
        f = new a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.SHARE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarShare.INSTANCE;
    }

    public r(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(null, null, 7);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        Object r4 = r1.l.c;
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == true) goto L6;
        r4 = null;
    L6:
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r4;
    }
}
