package com.bytedance.android.live.recharge.panel.dynamic;

import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/dynamic/f;", "", "", "balance", "J", "getBalance", "()J", "a", "(J)V", "lackMoney", "getLackMoney", "e", "Lvw0/g;", "commonParams", "Lvw0/g;", "getCommonParams", "()Lvw0/g;", "c", "(Lvw0/g;)V", "Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "panelProperties", "Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "getPanelProperties", "()Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "g", "(Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;)V", "Lcom/bytedance/android/live/recharge/panel/dynamic/c;", "giftRechargeParams", "Lcom/bytedance/android/live/recharge/panel/dynamic/c;", "getGiftRechargeParams", "()Lcom/bytedance/android/live/recharge/panel/dynamic/c;", "d", "(Lcom/bytedance/android/live/recharge/panel/dynamic/c;)V", "", "noPasswdScene", "I", "getNoPasswdScene", "()I", "f", "(I)V", "Lcom/bytedance/android/live/recharge/deal/aio/c;", "cachedDealSet", "Lcom/bytedance/android/live/recharge/deal/aio/c;", "getCachedDealSet", "()Lcom/bytedance/android/live/recharge/deal/aio/c;", "b", "(Lcom/bytedance/android/live/recharge/deal/aio/c;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.RechargePanelInitParams")
public final class f {

    @SerializedName("balance")
    private long balance;

    @SerializedName("cached_deal_set")
    private com.bytedance.android.live.recharge.deal.aio.c cachedDealSet;

    @SerializedName("common_params")
    private vw0.g commonParams;

    @SerializedName("gift_params")
    private c giftRechargeParams;

    @SerializedName("lack_money")
    private long lackMoney;

    @SerializedName("no_passwd_scene")
    private int noPasswdScene;

    @SerializedName("panel_properties")
    private IPanelProperties panelProperties;

    public f() {
        this.noPasswdScene = NoPasswordScene.SCENE_UNKNOWN.ordinal();
    }

    public final void a(long r1) {
        this.balance = r1;
    }

    public final void b(com.bytedance.android.live.recharge.deal.aio.c r1) {
        this.cachedDealSet = r1;
    }

    public final void c(vw0.g r1) {
        this.commonParams = r1;
    }

    public final void d(c r1) {
        this.giftRechargeParams = r1;
    }

    public final void e(long r1) {
        this.lackMoney = r1;
    }

    public final void f(int r1) {
        this.noPasswdScene = r1;
    }

    public final void g(IPanelProperties r1) {
        this.panelProperties = r1;
    }
}
