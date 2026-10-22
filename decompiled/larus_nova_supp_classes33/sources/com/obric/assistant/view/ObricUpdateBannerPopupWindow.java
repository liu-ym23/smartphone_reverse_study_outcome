package com.obric.assistant.view;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;
import com.obric.assistant.impl.databinding.ObricUpdateBannerBinding;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricUpdateBannerPopupWindow {
    public static final /* synthetic */ int m = 0;
    public final String a;
    public PopupWindow b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ObricUpdateBannerBinding g;
    public View h;
    public h0 i;
    public final ObricUpdateBannerPopupWindow$obricUpdateListener$1 j;
    public int k;
    public String l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricBannerType.values().length];
            r0[ObricBannerType.AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ObricBannerType.DOWNLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ObricBannerType.WIFI_DOWNLOADING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ObricBannerType.STATE_DOWNLOADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public ObricUpdateBannerPopupWindow() {
        this("default");
    }

    public static ObricBannerType e() {
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L7;
        ObricBannerType r1 = r0.getBannerType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return ObricBannerType.UNKNOWN;
    }

    public final void c() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("dismissBanner, hostId=");
        r1.append(this.a);
        r1.append(", isShowing=");
        PopupWindow r2 = this.b;
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.isShowing());
    L6:
        r1.append(r3);
        r0.i("ObricUpdateBannerPopupWindow", r1.toString());
        IObricUpdateService r4 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r4 == null) goto L9;
        r4.i(this.j);
    L9:
        h0 r5 = this.i;
        if (r5 == null) goto L16;
        View r6 = this.h;
        if (r6 == null) goto L15;
        r6.removeOnAttachStateChangeListener(r5);
    L15:
        this.i = null;
        this.h = null;
    L16:
        PopupWindow r7 = this.b;
        if (r7 != null) goto L19;
    L21:
        this.b = null;
        this.g = null;
        this.l = null;
        this.k = -1;
        return;
    L19:
        if (r7.isShowing() == false) goto L21;
        PopupWindowLancet.handleDismissBeforeOrigin(r7);
        r7.dismiss();
        goto L21
    L5:
        r3 = null;
        goto L6
    }

    public final boolean f() {
        PopupWindow r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void h() {
        ObricBannerType r1 = e();
        IObricUpdateService r2 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r2 == null) goto L5;
        int r3 = r2.l();
    L6:
        String r4 = this.l;
        if (r4 != null) goto L57;
        IObricUpdateService r5 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r5 == null) goto L55;
        String r8 = r5.versionName();
        String r9 = AppHost.a.getApplication().getString(2131912646);
        Long r6 = Long.valueOf(r5.o());
        if (r6.longValue() <= 0) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L20;
        String r7 = ((int) ((r6.longValue() / 1024.0d) / 1024.0d)) + "MB";
    L21:
        StringBuilder r11 = new StringBuilder();
        if (r8 != null) goto L24;
    L27:
        boolean r12 = true;
    L28:
        if (r12 == true) goto L30;
        r11.append(r9);
        r11.append(r8);
    L30:
        if (r7 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r13 == true) goto L54;
        if (r8 != null) goto L39;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == true) goto L45;
        r11.append("（");
    L45:
        r11.append(r7);
        if (r8 != null) goto L48;
    L51:
        boolean r15 = true;
    L52:
        if (r15 == true) goto L54;
        r11.append("）");
        goto L54
    L48:
        if (r8.length() == 0) goto L51;
        r15 = false;
        goto L52
    L39:
        if (r8.length() == 0) goto L42;
        r14 = false;
    L54:
        this.l = r11.toString();
        goto L55
    L32:
        if (r7.length() == 0) goto L35;
        r13 = false;
        goto L36
    L24:
        if (r8.length() == 0) goto L27;
        r12 = false;
        goto L28
    L20:
        r7 = null;
        goto L21
    L14:
        r10 = false;
    L55:
        r4 = this.l;
    L57:
        if (r3 != this.k) goto L60;
        FLogger.a.i("ObricUpdateBannerPopupWindow", "setupButton skipped, hostId=" + this.a + ", currentState=" + r3 + ", bannerShowType=" + r1);
        return;
    L60:
        this.k = r3;
        FLogger r16 = FLogger.a;
        r16.i("ObricUpdateBannerPopupWindow", "setupButton, hostId=" + this.a + ", currentState=" + r3 + ", bannerShowType=" + r1 + ", packageSize=" + r4);
        if (r3 == 1) goto L107;
        int r17 = 2131912649;
        int r18 = 2131912652;
        if (r3 == 2) goto L95;
        if (r3 == 3) goto L82;
        if (r3 != 4) goto L67;
        b(2131912648, r4);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r19 = this.g;
        if (r19 == null) goto L112;
        TextView r20 = r19.c;
        if (r20 == null) goto L112;
        r20.setText(AppHost.a.getApplication().getString(2131912644));
    L112:
        if (r3 == (-1)) goto L131;
        r16.i("ObricUpdateBannerPopupWindow", "reportObricUpgradeBannerShow, hostId=" + this.a + ", bannerType=" + r1 + ", window=" + this);
        IObricUpdateService r21 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r21 == null) goto L116;
        String r22 = r21.m();
    L117:
        int r23 = b.a[r1.ordinal()];
        if (r23 == 1) goto L126;
        if (r23 == 2) goto L125;
        if (r23 == 3) goto L124;
        if (r23 == 4) goto L123;
        String r24 = "unknown";
    L127:
        IObricUpdateService r25 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r25 == null) goto L132;
        JSONObject r26 = new JSONObject();
        r26.put("source", r22);
        r26.put("banner_type", r24);
        Unit r27 = Unit.INSTANCE;
        r25.h("obric_upgrade_banner_show", r26);
        return;
    L132:
        return;
    L123:
        r24 = "obric_upgrade_ready_to_install_banner";
        goto L127
    L124:
        r24 = "obric_upgrade_auto_downloading_banner";
        goto L127
    L125:
        r24 = "obric_upgrade_downloading_banner";
        goto L127
    L126:
        r24 = "obric_upgrade_new_version_banner";
        goto L127
    L116:
        r22 = null;
        goto L117
    L131:
        return;
    L67:
        if (r3 == 6) goto L71;
        ObricUpdateBannerBinding r28 = this.g;
        if (r28 == null) goto L112;
        r28.j.setVisibility(8);
        r28.i.setVisibility(8);
        r28.b.setVisibility(8);
        r28.f.setVisibility(8);
        r28.e.setVisibility(8);
        r28.g.setVisibility(8);
        goto L112
    L71:
        b(2131912650, null);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r29 = this.g;
        if (r29 == null) goto L112;
        TextView r30 = r29.c;
        if (r30 == null) goto L112;
        r30.setText(AppHost.a.getApplication().getString(2131912651));
        goto L112
    L82:
        if (r1 != ObricBannerType.WIFI_DOWNLOADING) goto L93;
        IObricUpdateService r110 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r110 != null) goto L86;
    L88:
        boolean r111 = false;
    L89:
        if (r111 == true) goto L92;
        r18 = 2131912653;
    L92:
        b(r18, r4);
        a(this, false, false, true, 11);
        goto L112
    L86:
        if (r110.j() != true) goto L88;
        r111 = true;
        goto L89
    L93:
        b(2131912649, r4);
        a(this, false, false, true, 11);
        goto L112
    L95:
        if (r1 == ObricBannerType.DOWNLOADING) goto L106;
        IObricUpdateService r31 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r31 != null) goto L100;
    L102:
        boolean r32 = false;
    L103:
        if (r32 == true) goto L106;
        r17 = 2131912652;
        goto L106
    L100:
        if (r31.j() != true) goto L102;
        r32 = true;
    L106:
        b(r17, r4);
        a(this, false, true, false, 13);
        goto L112
    L107:
        b(2131912647, r4);
        a(this, true, false, false, 14);
        ObricUpdateBannerBinding r33 = this.g;
        if (r33 == null) goto L112;
        TextView r34 = r33.c;
        if (r34 == null) goto L112;
        r34.setText(AppHost.a.getApplication().getString(2131912645));
        goto L112
    L5:
        r3 = -1;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.view.ObricUpdateBannerPopupWindow$obricUpdateListener$1] */
    public ObricUpdateBannerPopupWindow(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hostId");
        this.a = r2;
        this.j = new ObricUpdateBannerPopupWindow$obricUpdateListener$1(this);
        this.k = -1;
    }

    public static void d(Function0 r2) {
        AppHost.Companion r0 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r0.getApplication()) == true) goto L7;
        i(2131912668);
        return;
    L7:
        if (NetworkUtils.isWifi(r0.getApplication()) == false) goto L9;
        i(2131912672);
    L10:
        r2.invoke();
        return;
    L9:
        i(2131912671);
        goto L10
    }

    public static void g(String r5) {
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        ObricBannerType r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.m();
    L6:
        IObricUpdateService r3 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r3 == null) goto L9;
        r1 = r3.getBannerType();
    L9:
        if (r1 != null) goto L11;
        int r4 = -1;
    L13:
        if (r4 != 1) goto L15;
        String r6 = "obric_upgrade_new_version_banner";
    L25:
        IObricUpdateService r7 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r7 == null) goto L29;
        JSONObject r8 = new JSONObject();
        r8.put("source", r2);
        r8.put("banner_type", r6);
        r8.put("action_type", r5);
        Unit r9 = Unit.INSTANCE;
        r7.h("obric_upgrade_banner_click", r8);
        return;
    L29:
        return;
    L15:
        if (r4 != 2) goto L17;
        r6 = "obric_upgrade_downloading_banner";
        goto L25
    L17:
        if (r4 != 3) goto L19;
        r6 = "obric_upgrade_auto_downloading_banner";
        goto L25
    L19:
        if (r4 == 4) goto L21;
        r6 = "unknown";
        goto L25
    L21:
        r6 = "obric_upgrade_ready_to_install_banner";
        goto L25
    L11:
        r4 = b.a[r1.ordinal()];
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public static void i(int r2) {
        AppHost.Companion r0 = AppHost.a;
        Toast.makeText(r0.getApplication(), r0.getApplication().getString(r2), 0).show();
    }

    public static String j(View r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getClass().getSimpleName());
        r0.append('@');
        r0.append(Integer.toHexString(System.identityHashCode(r3)));
        r0.append("[shown=");
        r0.append(r3.isShown());
        r0.append(",attached=");
        r0.append(r3.isAttachedToWindow());
        r0.append(",bounds=");
        r0.append(r3.getLeft());
        r0.append(',');
        r0.append(r3.getTop());
        r0.append('-');
        r0.append(r3.getRight());
        r0.append(',');
        r0.append(r3.getBottom());
        r0.append(",root=");
        View r1 = r3.getRootView();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r4 = Integer.valueOf(r1.getWidth());
    L6:
        r0.append(r4);
        r0.append('x');
        View r5 = r3.getRootView();
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getHeight());
    L9:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    public final void b(int r5, String r6) {
        ObricUpdateBannerBinding r0 = this.g;
        if (r0 == null) goto L15;
        r0.j.setVisibility(0);
        r0.h.setText(AppHost.a.getApplication().getString(r5));
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        r0.i.setVisibility(8);
        return;
    L13:
        r0.i.setText(r6);
        r0.i.setVisibility(0);
        return;
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
        goto L11
    }

    public static void a(ObricUpdateBannerPopupWindow r3, boolean r4, boolean r5, boolean r6, int r7) {
        int r1 = 0;
        if ((r7 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = false;
    L11:
        ObricUpdateBannerBinding r8 = r3.g;
        if (r8 == null) goto L31;
        ConstraintLayout r9 = r8.b;
        if (r4 == false) goto L16;
        int r2 = 0;
    L17:
        r9.setVisibility(r2);
        TextView r10 = r8.c;
        if (r4 == false) goto L20;
        int r11 = 0;
    L21:
        r10.setVisibility(r11);
        CustomUpdateCircleProgressBar r12 = r8.f;
        if (r5 == false) goto L24;
        int r13 = 0;
    L25:
        r12.setVisibility(r13);
        ConstraintLayout r14 = r8.e;
        if (r6 == true) goto L29;
        r1 = 8;
    L29:
        r14.setVisibility(r1);
        r8.g.setVisibility(8);
        return;
    L24:
        r13 = 8;
        goto L25
    L20:
        r11 = 8;
        goto L21
    L16:
        r2 = 8;
        goto L17
    }
}
