package com.bytedance.android.livesdk.feed.feed;

import android.text.TextUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class e {
    public boolean a;

    @SerializedName("custom_layout")
    private boolean customLayout;

    @SerializedName("shield_enter_source")
    private List<String> disableEnableSource;

    @SerializedName("enable_dislike")
    private int dislike;

    @SerializedName("enable_draw_stream")
    private int draw;

    @SerializedName("enter_source")
    private List<String> enableSource;

    @SerializedName("id")
    private long id;

    @SerializedName("inner_req_from")
    private String innerReqFrom;

    @SerializedName("inter_url")
    private String innerStreamUrl;

    @SerializedName(LiveEndPageData.TAG_NAME)
    private String name;

    @SerializedName("event")
    private String replaceEvent;

    @SerializedName("source")
    private int replaceSource;

    @SerializedName("req_from")
    private String reqFrom;

    @SerializedName("default")
    private int showdefault;

    @SerializedName("style")
    private int style;

    @SerializedName("type")
    private int type;

    @SerializedName("umeng_event")
    private String umengEvent;

    @SerializedName("umeng_source")
    private int umengSource;

    @SerializedName("url")
    private String url;

    public e() {
    }

    public final boolean a() {
        if (this.draw == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.umengEvent) == false) goto L7;
        return this.replaceEvent;
    L7:
        return this.umengEvent;
    }

    public final int m() {
        int r0 = this.style;
        if (r0 >= 1) goto L5;
    L6:
        this.style = 2;
    L8:
        return this.style;
    L5:
        if (r0 <= 4) goto L8;
        goto L6
    }

    public final boolean p() {
        if (this.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean q() {
        return !StringUtils.isEmpty(this.name);
    }

    public final boolean r() {
        if (this.type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final List<String> b() {
        return this.disableEnableSource;
    }

    public final int c() {
        return this.dislike;
    }

    public final List<String> d() {
        return this.enableSource;
    }

    public final long f() {
        return this.id;
    }

    public final String g() {
        return this.innerReqFrom;
    }

    public int getType() {
        return this.type;
    }

    public final String h() {
        return this.innerStreamUrl;
    }

    public final String i() {
        return this.name;
    }

    public final String j() {
        return this.replaceEvent;
    }

    public final String k() {
        return this.reqFrom;
    }

    public final int l() {
        return this.umengSource;
    }

    public final String n() {
        return this.url;
    }

    public final boolean o() {
        return this.customLayout;
    }

    public final void A(String r1) {
        this.replaceEvent = r1;
    }

    public final void B(int r1) {
        this.showdefault = r1;
    }

    public final void C(int r1) {
        this.umengSource = r1;
    }

    public final void D(int r1) {
        this.style = r1;
    }

    public final void E(int r1) {
        this.type = r1;
    }

    public final void F(String r1) {
        this.url = r1;
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    public final void s(boolean r1) {
        this.customLayout = r1;
    }

    public final void t(List<String> r1) {
        this.disableEnableSource = r1;
    }

    public final void u(int r1) {
        this.dislike = r1;
    }

    public final void v(List<String> r1) {
        this.enableSource = r1;
    }

    public final void w(String r1) {
        this.umengEvent = r1;
    }

    public final void x(long r1) {
        this.id = r1;
    }

    public final void y(String r1) {
        this.innerStreamUrl = r1;
    }

    public final void z(String r1) {
        this.name = r1;
    }
}
