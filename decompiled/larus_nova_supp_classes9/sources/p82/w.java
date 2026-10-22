package p82;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends p82.a {
    public final com.bytedance.android.livesdk.sharedpref.e<Integer> e;
    public final com.bytedance.android.livesdk.sharedpref.e<Integer> f;
    public final RoomContext g;
    public final DataCenter h;

    public static final class a {
    }

    static {
    }

    @Override // p82.a
    public final int e() {
        return 2131567230;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Room r5 = (Room) this.g.getRoom().getValue();
        LiveMode r0 = (LiveMode) this.g.getLiveMode().getValue();
        boolean r1 = ((Boolean) this.g.isAnchor().getValue()).booleanValue();
        DataCenter r2 = this.h;
        if (SelectedMsgABHelper.a(r1, r5, r0) == true) goto L6;
        return false;
    L6:
        if (r0 != LiveMode.VIDEO) goto L9;
        return true;
    L9:
        if (r0 == LiveMode.AUDIO) goto L11;
        return false;
    L11:
        return SelectedMsgABHelper.e(r2);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r4) {
        super.onClick(r4);
        if (((LiveMode) this.g.getLiveMode().getValue()) != LiveMode.AUDIO) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = this.f;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, -1);
    L8:
        if (r4 == null) goto L12;
        Context r5 = r4.getContext();
        if (r5 == null) goto L12;
        SelectedMsgABHelper.h(r5, this.h, "message_setting_panel", SelectedMsgABHelper.b().settingPageSchemaAi);
    L12:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r6 = this.c;
        if (r6 == null) goto L16;
        r6.dismissDialog();
        return;
    L16:
        return;
    L6:
        if (((LiveMode) this.g.getLiveMode().getValue()) != LiveMode.VIDEO) goto L8;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r1 = this.e;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, -1);
        goto L8
    }

    public w(RoomContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.PUBLIC_SCREEN_HELPER);
        this.g = r2;
        this.h = r3;
        this.e = new com.bytedance.android.livesdk.sharedpref.e("plugin_screen_helper_item_red_dot_count", 0);
        this.f = new com.bytedance.android.livesdk.sharedpref.e("plugin_screen_helper_item_red_dot_count_audio", 0);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r4, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "bridge");
        super.c(r4, r5);
        if (((LiveMode) this.g.getLiveMode().getValue()) != LiveMode.AUDIO) goto L17;
        Integer r6 = (Integer) this.f.getValue();
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        if (r7 >= 0) goto L10;
        return;
    L10:
        if (r7 >= ((com.bytedance.android.livesdk.interactivity.api.settings.config.w) SelectedMsgABHelper.b.getValue()).a()) goto L32;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = this.f;
        Integer r8 = Integer.valueOf(r7 + 1);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r8);
        View r9 = getView(r4.getContext());
        if (r9 == null) goto L33;
        View r10 = r9.findViewById(2131383415);
        if (r10 == null) goto L34;
        r10.setVisibility(0);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L7:
        r7 = 0;
        goto L8
    L17:
        if (((LiveMode) this.g.getLiveMode().getValue()) != LiveMode.VIDEO) goto L36;
        Integer r11 = (Integer) this.e.getValue();
        if (r11 == null) goto L21;
        int r13 = r11.intValue();
    L22:
        if (r13 >= 0) goto L24;
        return;
    L24:
        if (r13 >= ((com.bytedance.android.livesdk.interactivity.api.settings.config.w) SelectedMsgABHelper.b.getValue()).a()) goto L38;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r1 = this.e;
        Integer r14 = Integer.valueOf(r13 + 1);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r14);
        View r15 = getView(r4.getContext());
        if (r15 == null) goto L39;
        View r16 = r15.findViewById(2131383415);
        if (r16 == null) goto L40;
        r16.setVisibility(0);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L21:
        r13 = 0;
        goto L22
    }
}
