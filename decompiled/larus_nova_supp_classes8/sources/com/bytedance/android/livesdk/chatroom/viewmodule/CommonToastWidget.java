package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.widget.CommonToastLayout;
import com.bytedance.android.livesdk.config.yl;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class CommonToastWidget extends LiveWidget implements qo1.b {
    public boolean a;
    public final d0 b;
    public a c;

    public class a extends dmc.e {
        public final /* synthetic */ CommonToastWidget d;

        public final void onMessage(tlc.d r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.message.model.n3) == false) goto L6;
            this.d.M9((com.bytedance.android.livesdk.message.model.n3) r2);
            return;
        }

        public a(CommonToastWidget r1, Set r2, Set r3, dmc.d r4) {
            this.d = r1;
            super(r2, r3, r4);
        }
    }

    public final String getSpm() {
        return "a100.a100.a254";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.d0] */
    public CommonToastWidget() {
        this.a = false;
        this.b = new d0();
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (yl.a.getValue().booleanValue() == false) goto L11;
        HashSet r0 = new HashSet();
        r0.add(Integer.valueOf(MessageType.COMMON_TOAST.getIntType()));
        vlc.d r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        a r2 = new a(this, r0, new HashSet(), new dmc.d(0));
        this.c = r2;
        int r3 = d4.a;
        if ((r1 instanceof dmc.a) == true) goto L7;
        r1 = null;
    L7:
        dmc.a r4 = (dmc.a) r1;
        if (r4 == null) goto L11;
        r4.C(r2);
    L11:
        if (ho1.a.o(getComponentContext()) == false) goto L14;
        ho1.a.p(getComponentContext(), qo1.b.class, this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (this.c == null) goto L11;
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        a r1 = this.c;
        int r2 = d4.a;
        if ((r0 instanceof dmc.a) == true) goto L7;
        r0 = null;
    L7:
        dmc.a r3 = (dmc.a) r0;
        if (r3 == null) goto L10;
        r3.o(r1);
    L10:
        this.c = null;
    L11:
        ho1.a.q(getComponentContext(), qo1.b.class);
    }

    public final void onStart() {
        super.onStart();
        this.a = false;
    }

    public final void onStop() {
        super.onStop();
        this.a = true;
    }

    public static String wq(String r3) {
        if (r3.length() == 9) goto L5;
        return r3;
    L5:
        return "#" + r3.substring(7, 9) + r3.substring(1, 7);
    }

    @Override // qo1.b
    public final void M9(com.bytedance.android.livesdk.message.model.n3 r12) {
        if (this.a == false) goto L5;
        return;
    L5:
        Text r0 = r12.getBaseMessage().getDisplayText();
        if (r0 != null) goto L10;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L10:
        if (r0.getPieces() == null) goto L13;
        r0.getPieces().size();
    L13:
        if (r12.G() != null) goto L16;
        r12.d0();
    L16:
        if (r12.E() != null) goto L19;
        r12.X();
    L19:
        if (r12.getTextColor() != null) goto L21;
        r12.setTextColor("#ffffff");
    L21:
        CommonToastLayout r1 = (CommonToastLayout) LayoutInflater.from(((Widget) this).context).inflate(2131567643, null);
        r1.setOnDetachListener(this.b);
        LinearLayout r2 = (LinearLayout) r1.findViewById(2131367728);
        TextView r4 = (TextView) r1.findViewById(2131390392);
        HSImageView r5 = r1.findViewById(2131376693);
        int r6 = ColorProtector.parseColor("#ff9d5c");
        int r7 = ColorProtector.parseColor("#ff5c67");
        String r8 = wq(r12.G());     // Catch: Exception -> L24
        String r9 = wq(r12.E());     // Catch: Exception -> L24
        r6 = Color.parseColor(r8);     // Catch: Exception -> L24
        r7 = Color.parseColor(r9);     // Catch: Exception -> L24
    L26:
        int r10 = 0;
        int[] r11 = {r6, r7};
        if (RTLUtil.isAppRTL(((Widget) this).context) == false) goto L29;
        GradientDrawable r13 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, r11);
    L30:
        r13.setCornerRadius(com.bytedance.android.live.core.utils.s1.f(8.0f));
        r2.setBackgroundDrawable(r13);
        if (r12.V() == null) goto L38;
        r5.setVisibility(0);
        if (r12.P() > 0) goto L35;
    L37:
        ImageUtil.loadImage(r5, r12.V(), 0);
    L39:
        String r3 = r0.getDefaultPattern();
        if (TextUtils.isEmpty(r0.getKey()) == false) goto L42;
    L46:
        Objects.toString(sb2.a.i(r3, r0));
        r4.setText(sb2.a.i(r3, r0));
        int r14 = r12.getPosition();
        if (r14 == 0) goto L51;
        if (r14 == 2) goto L50;
        int r15 = 17;
        int r16 = 0;
    L53:
        if (r12.T() == false) goto L57;
        Context r17 = ((Widget) this).context;
        com.bytedance.android.livesdk.widget.x0.d r18 = new com.bytedance.android.livesdk.widget.x0.d();
        r18.b = r17;
        r18.a = 0;
        r18.e = r1;
        final com.bytedance.android.livesdk.widget.x0 r19 = new com.bytedance.android.livesdk.widget.x0(r18.b, r18);
        com.bytedance.android.livesdk.widget.x0.b.g(r19);
        if (r12.getDuration() <= 0) goto L64;
        ((SingleSubscribeProxy) Single.timer(r12.getDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b0(r19), new c0());
        return;
    L64:
        return;
    L57:
        Toast r20 = new Toast(((Widget) this).context.getApplicationContext());
        r20.setView(r1);
        r20.setGravity(r15, 0, r16);
        if (r12.getDuration() <= 0) goto L60;
        r10 = r12.getDuration();
    L60:
        r20.setDuration(r10);
        r20.show();
        return;
    L50:
        r16 = com.bytedance.android.live.core.utils.s1.f(64.0f);
        r15 = 80;
        goto L53
    L51:
        r16 = com.bytedance.android.live.core.utils.s1.f(72.0f);
        r15 = 48;
        goto L53
    L42:
        if (com.bytedance.android.live.core.i18n.a.b().a(r0.getKey()) == null) goto L46;
        r3 = com.bytedance.android.live.core.i18n.a.b().a(r0.getKey());
        if (TextUtils.isEmpty(r0.getDefaultPattern()) == false) goto L46;
        w50.h.a().b(r0.getKey(), r3, "");
        goto L46
    L35:
        if (r12.H() <= 0) goto L37;
        ViewGroup.LayoutParams r21 = r5.getLayoutParams();
        r21.width = r12.P();
        r21.height = r12.H();
        r5.requestLayout();
        ImageUtil.loadImage(r5, r12.V(), r5.getWidth(), r5.getHeight(), null);
        goto L39
    L38:
        r5.setVisibility(8);
        goto L39
    L29:
        r13 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r11);
    L24:
        e = move-exception;
        ALogger.stacktrace(6, "CommonToastWidget", e.getStackTrace());
        goto L26
    }
}
