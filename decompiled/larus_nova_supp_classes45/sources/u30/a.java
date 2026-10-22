package u30;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.h;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import com.bytedance.android.livehostapi.platform.IHostAction;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements b {
    public String a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public h m;
    public final Context n;
    public final String o;

    @Override // u30.b
    public final void b() {
        Bundle r0 = new Bundle();
        r0.putBoolean("is_fullscreen", true);
        r0.putBoolean("hide_nav_bar", this.b);
        r0.putBoolean("hide_status_bar", this.c);
        r0.putBoolean("trans_status_bar", false);
        r0.putBoolean("hide_system_video_poster", this.f);
        r0.putString("title", this.a);
        r0.putBoolean("show_progress", false);
        r0.putBoolean("bundle_user_webview_title", true);
        r0.putString("status_bar_color", this.d);
        r0.putString("status_bar_bg_color", this.e);
        r0.putInt("bundle_web_view_background_color", s1.h(2131106889));
        r0.putInt("request_code", this.g);
        r0.putBoolean("show_back", this.i);
        r0.putBoolean("enable_share", this.h);
        r0.putString("is_external_scene", null);
        r0.putBoolean("is_external_url", false);
        r0.putString("original_scheme", null);
        r0.putBoolean("support_exchange_theme", false);
        r0.putBoolean("use_annie", this.j);
        r0.putBoolean("use_anniex_container", this.k);
        r0.putBoolean("disable_bounces", this.l);
        k.n(IRoomService.class).setOnNeedMuteAudioFullPage(true);
        k.n(IHostAction.class).openLiveBrowser(this.o, r0, this.n);
    }

    @Override // u30.b
    public final a a(int r1) {
        this.g = r1;
        return this;
    }

    @Override // u30.b
    public final a d(boolean r1) {
        this.b = r1;
        return this;
    }

    @Override // u30.b
    public final a setTitle(String r1) {
        this.a = r1;
        return this;
    }

    public a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        this.n = r2;
        this.o = r3;
        BrowserServiceImpl.Companion.getClass();
        s20.b r4 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r4.getClass();
        h r5 = (h) r4.b.c.get();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.m = r5;
    }

    @Override // u30.b
    public final void c(WebHybridParamVo r4, Bundle r5) {
        if (r5 == null) goto L5;
        Bundle r0 = new Bundle(r5);
    L6:
        r0.putParcelable("hybrid_web_vo", r4);
        if (r4 == null) goto L9;
        BaseHybridParamVo r1 = r4.h;
    L10:
        r0.putParcelable("hybrid_pop_vo", r1);
        r0.putString("original_scheme", null);
        if (r4 == null) goto L13;
        boolean r6 = r4.i;
    L14:
        r0.putBoolean("use_annie", r6);
        r0.putBoolean("create_by_router", true);
        r0.putLong("container_init_start_time", System.currentTimeMillis());
        k.n(IRoomService.class).setOnNeedMuteAudioFullPage(true);
        k.n(IHostAction.class).openLiveBrowser(this.o, r0, this.n);
        return;
    L13:
        r6 = this.j;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = new Bundle();
        goto L6
    }
}
