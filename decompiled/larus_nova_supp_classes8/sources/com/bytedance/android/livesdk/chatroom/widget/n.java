package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.message.model.k3;
import com.bytedance.android.livesdk.viewmodel.CommonGuideViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public k3 b;
    public HSImageView c;
    public TextView d;
    public LinearLayout e;
    public TextView f;
    public HSImageView g;
    public final CommonGuideViewModel h;

    public static Spannable a(Text r5) {
        String r0 = null;
        if (r5 == null) goto L16;
        String r1 = r5.getDefaultPattern();
        if (r5.getKey() == null) goto L11;
        r0 = com.bytedance.android.live.core.i18n.a.b().a(r5.getKey());
        if (TextUtils.isEmpty(r1) == false) goto L11;
        if (TextUtils.isEmpty(r0) == true) goto L11;
        w50.h.a().b(r5.getKey(), r0, "guidDialog");
    L11:
        if (r0 == null) goto L15;
        r1 = r0;
    L15:
        return sb2.a.i(r1, r5);
    L16:
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        CommonGuideViewModel r0 = this.h;
        if (r0 == null) goto L22;
        String r1 = null;
        if (r5 == null) goto L7;
        Integer r6 = Integer.valueOf(r5.getId());
    L8:
        if (r6 != null) goto L11;
    L13:
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.intValue() != 2131374110) goto L24;
        CommonGuideViewModel.g r7 = r0.getStateMachine();
        k3 r2 = this.b;
        if (r2 == null) goto L20;
        r1 = r2.E();
    L20:
        r7.a(new CommonGuideViewModel.c(r1));
        return;
    L24:
        return;
    L11:
        if (r6.intValue() != 2131374119) goto L13;
        r0.getStateMachine().a(new CommonGuideViewModel.b());
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        setContentView(2131565324);
        this.c = findViewById(2131374128);
        this.d = (TextView) findViewById(2131374146);
        this.e = (LinearLayout) findViewById(2131374143);
        this.f = (TextView) findViewById(2131374110);
        this.g = findViewById(2131374107);
        View r14 = findViewById(2131374119);
        if (r14 == null) goto L5;
        r14.setOnClickListener(this);
    L5:
        TextView r15 = this.f;
        if (r15 == null) goto L8;
        r15.setOnClickListener(this);
    L8:
        CommonGuideViewModel r16 = this.h;
        if (r16 == null) goto L96;
        CommonGuideViewModel.h r17 = r16.getStateMachine().a;
        if ((r17 instanceof CommonGuideViewModel.h) == false) goto L79;
        k3 r18 = r17.a;
        this.b = r18;
        if (r18 == null) goto L120;
        ImageModel r0 = r18.getIcon();
        if (r18.T() == false) goto L17;
        ImageUtil.loadRoundImage(this.c, r0);
    L18:
        Spannable r1 = a(r18.P());
        if (r1 == null) goto L23;
        TextView r2 = this.d;
        if (r2 == null) goto L23;
        r2.setText(r1);
    L23:
        List r3 = r18.Q();
        if (r3 == null) goto L51;
        Iterator r4 = r3.iterator();
    L27:
        if (r4.hasNext() == false) goto L51;
        k3.b r5 = (k3.b) r4.next();
        String r6 = r5.getType();
        if (r6 == null) goto L27;
        int r7 = r6.hashCode();
        if (r7 != (-842613072)) goto L34;
        if (r6.equals("rich_text") == false) goto L27;
        String r8 = r5.a();
        int r9 = r5.b();
        String r10 = r5.d();
        TextView r11 = new TextView(getContext());
        r11.setText(r10);
        r11.setTextColor(Color.parseColor(r8));     // Catch: IllegalArgumentException -> L46
    L48:
        r11.setTextSize(1, r9);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout r12 = this.e;
        if (r12 == null) goto L27;
        r12.addView(r11, r12.getChildCount(), new LinearLayout.LayoutParams(-2, -2));
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L34:
        if (r7 != 104387) goto L27;
        if (r6.equals("img") == false) goto L27;
        ImageModel r19 = r5.c();
        ImageView r20 = new ImageView(getContext());
        ImageUtil.loadImage(r20, r19, new m(r20));
        LinearLayout r21 = this.e;
        if (r21 == null) goto L27;
        r21.addView(r20, r21.getChildCount());
    L51:
        Text r22 = r18.G();
        ImageModel r23 = r18.H();
        TextView r24 = this.f;
        if (r24 == null) goto L54;
        r24.setText(a(r22));
    L54:
        ImageLoader.bindImage(this.g, r23);
        Long r25 = null;
        if (StringsKt.contains$default(r18.E(), "webcast_audiotalk_invite", false, 2, null) == false) goto L68;
        HashMap r26 = new HashMap();
        Room r110 = jc1.k.n(IRoomService.class).getCurrentRoom();
        r26.put("live_type", "voice_live");
        if (r110 == null) goto L61;
        User r111 = r110.getOwner();
        if (r111 == null) goto L61;
        String r112 = r111.getIdStr();
    L62:
        r26.put("anchor_id", String.valueOf(r112));
        if (r110 == null) goto L65;
        Long r113 = Long.valueOf(r110.id);
    L66:
        r26.put("room_id", String.valueOf(r113));
        r26.put("request_page", "popup");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_apply_guide_show", r26, new Object[0]);
        goto L68
    L65:
        r113 = null;
    L61:
        r112 = null;
    L68:
        if (StringsKt.contains$default(r18.E(), "webcast_inroom_bigparty", false, 2, null) == false) goto L121;
        HashMap r114 = new HashMap();
        Room r27 = jc1.k.n(IRoomService.class).getCurrentRoom();
        r114.put("live_type", "video_live");
        if (r27 == null) goto L74;
        User r28 = r27.getOwner();
        if (r28 == null) goto L74;
        String r29 = r28.getIdStr();
    L75:
        r114.put("anchor_id", String.valueOf(r29));
        if (r27 == null) goto L78;
        r25 = Long.valueOf(r27.id);
    L78:
        r114.put("room_id", String.valueOf(r25));
        r114.put("request_page", "popup");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_apply_guide_show", r114, new Object[0]);
        return;
    L74:
        r29 = null;
        goto L75
    L121:
        return;
    L17:
        ImageLoader.bindImage(this.c, r0);
        goto L18
    L120:
        return;
    L79:
        Handler r115 = DialogLancet.resolveDialogHandler(this);
        if (r115 != null) goto L82;
    L84:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L87 Exception -> L89
    L93:
        DialogLancet.afterDialogDismiss(this);
        return;
    L89:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L87
        Throwable r116 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L87
        if (r116 == null) goto L93;
        com.bytedance.crash.d.d(r116, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L82:
        if (Looper.myLooper() == r115.getLooper()) goto L84;
        r115.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    public n(Context r2, CommonGuideViewModel r3) {
        super(r2, true);
        this.h = r3;
    }
}
