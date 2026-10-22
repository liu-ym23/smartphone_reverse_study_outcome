package com.bytedance.android.livesdk.interactivity.interactive;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1<T> implements Consumer {
    public final /* synthetic */ VSMsgBoardBaseWidget a;

    public e1(VSMsgBoardBaseWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        OpenVSMsgBoardInputEvent r13 = (OpenVSMsgBoardInputEvent) r11;
        VSMsgBoardBaseWidget r0 = this.a;
        Context r1 = ((Widget) r0).context;
        Long r3 = null;
        if ((r1 instanceof Activity) == true) goto L5;
        r1 = null;
    L5:
        Activity r2 = (Activity) r1;
        String r5 = BuildConfig.FLAVOR;
        if (r2 == null) goto L70;
        int r6 = VSMsgBoardPortraitInputDialog.x;
        t9 r7 = new t9();
        r7.l = ((Widget) r0).dataCenter;
        VSMsgBoardDataContext r8 = r0.b;
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.n<CharSequence> r9 = r8.getDraft();
        if (r9 == null) goto L13;
        CharSequence r10 = (CharSequence) r9.getValue();
    L14:
        r7.a = r10;
        VSMsgBoardDataContext r14 = r0.b;
        if (r14 == null) goto L22;
        com.bytedance.live.datacontext.j<u9> r15 = r14.getInputPanelConfig();
        if (r15 == null) goto L22;
        u9 r16 = (u9) r15.getValue();
        if (r16 == null) goto L22;
        String r17 = r16.a;
        if (r17 == null) goto L22;
    L23:
        r7.b = r17;
        VSMsgBoardDataContext r18 = r0.b;
        if (r18 == null) goto L28;
        com.bytedance.live.datacontext.j<u9> r19 = r18.getInputPanelConfig();
        if (r19 == null) goto L28;
        u9 r20 = (u9) r19.getValue();
    L29:
        r7.c = r20;
        r7.d = r13.getShowType();
        r7.e = r13.getGradientType();
        r7.f = r13.getTabName();
        DataCenter r21 = ((Widget) r0).dataCenter;
        if (r21 == null) goto L32;
        boolean r23 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r21, true);
    L33:
        r7.g = r23;
        boolean r24 = PadConfigUtils.c();
        r7.h = r24;
        boolean r25 = r7.g;
        if (r25 == true) goto L38;
        if (r24 == true) goto L38;
        boolean r26 = false;
    L39:
        r7.i = r26;
        int r27 = 3;
        if (r25 == false) goto L42;
        int r28 = 3;
    L43:
        r7.j = r28;
        if (r25 == true) goto L47;
        r27 = 1;
    L47:
        r7.k = r27;
        r7.m = r13.getParentCommentId();
        r7.n = r13.getReplyCommentId();
        r7.o = r13.getReplyToUserId();
        if (TextUtils.isEmpty(r7.m) == true) goto L50;
    L55:
        boolean r29 = true;
    L56:
        r7.p = r29;
        r7.q = r13.isSelectToStory();
        Unit r30 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "attrs");
        VSMsgBoardPortraitInputDialog r31 = new VSMsgBoardPortraitInputDialog();
        r31.d = r7;
        r0.c = r31;
        r31.i = ((Widget) r0).dataCenter;
        if (TextUtils.isEmpty(r13.getReplyToUserId()) == true) goto L59;
    L64:
        boolean r33 = true;
    L65:
        VSMsgBoardPortraitInputDialog r34 = r0.c;
        if (r34 == null) goto L68;
        r34.e = new VSMsgBoardBaseWidget$showInputPanel$2(r0, r13, r33, r2);
    L68:
        if (r34 == null) goto L70;
        r34.show(r2, "VSMsgBoard");
        goto L70
    L59:
        if (TextUtils.isEmpty(r13.getReplyCommentId()) == false) goto L64;
        if (TextUtils.isEmpty(r13.getParentCommentId()) == false) goto L64;
        r33 = false;
        goto L65
    L50:
        if (TextUtils.isEmpty(r7.n) == false) goto L55;
        if (TextUtils.isEmpty(r7.o) == false) goto L55;
        r29 = false;
        goto L56
    L42:
        r28 = 1;
    L38:
        r26 = true;
        goto L39
    L32:
        r23 = true;
    L28:
        r20 = null;
    L22:
        r17 = BuildConfig.FLAVOR;
    L13:
        r10 = null;
    L70:
        VSMsgBoardBaseWidget r4 = this.a;
        Pair[] r35 = new Pair[2];
        String r36 = r13.getSource();
        if (r36 != null) goto L73;
        r36 = BuildConfig.FLAVOR;
    L73:
        r35[0] = TuplesKt.to("source", r36);
        String r37 = r13.getShowType();
        if (r37 != null) goto L76;
        r37 = BuildConfig.FLAVOR;
    L76:
        r35[1] = TuplesKt.to("show_type", r37);
        Map<String, String> r38 = MapsKt.mutableMapOf(r35);
        r38.putAll(this.a.wq());
        DataCenter r39 = ((Widget) this.a).dataCenter;
        if (r39 == null) goto L83;
        IRoom r40 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r39);
        if (r40 == null) goto L83;
        IEpisodeExtraInfo r41 = r40.getEpisodeExtra();
        if (r41 == null) goto L83;
        r3 = Long.valueOf(r41.getId());
    L83:
        r38.put("vs_from_episode_id", String.valueOf(r3));
        if (TextUtils.isEmpty(r13.getReplyToUserId()) == true) goto L86;
    L91:
        r38.put("message_type", "reply");
    L92:
        String r43 = r13.getTabName();
        if (r43 != null) goto L95;
        r43 = BuildConfig.FLAVOR;
    L95:
        r38.put("tab_name", r43);
        if (TextUtils.isEmpty(r13.getEnterFromMerge()) == true) goto L102;
        String r110 = r13.getEnterFromMerge();
        if (r110 == null) goto L101;
        r5 = r110;
    L101:
        r38.put("enter_from_merge", r5);
    L102:
        Unit r111 = Unit.INSTANCE;
        r4.zq("livesdk_vs_guest_book_input_click", r38, "click");
        return;
    L86:
        if (TextUtils.isEmpty(r13.getReplyCommentId()) == false) goto L91;
        if (TextUtils.isEmpty(r13.getParentCommentId()) == false) goto L91;
        r38.put("message_type", "message");
        goto L92
    }
}
