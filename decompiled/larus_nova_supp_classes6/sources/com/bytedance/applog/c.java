package com.bytedance.applog;

import android.text.TextUtils;
import com.bytedance.applog.log.g;
import com.bytedance.bdinstall.b;
import com.bytedance.bdinstall.r0;
import com.bytedance.bdinstall.u;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements g.b {
    public final /* synthetic */ q a;
    public final /* synthetic */ b b;

    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.a.a);     // Catch: Throwable -> L56
        r0.put("channel", this.a.c);     // Catch: Throwable -> L56
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L56
        r1.put("AppLog版本号", "5.7.17-bugfix.5");     // Catch: Throwable -> L56
        r1.put("AppLog版本地区", "cn");     // Catch: Throwable -> L56
        r1.put("接口加密", this.b.v);     // Catch: Throwable -> L56
        int r3 = nx3.j.a;     // Catch: Throwable -> L56
        boolean r4 = false;
        r1.put("调试日志", false);     // Catch: Throwable -> L56
        if (this.a.e == null) goto L6;
        boolean r5 = true;
    L7:
        r1.put("自定义日志打印", r5);     // Catch: Throwable -> L56
        r1.put("自动启动", this.a.b);     // Catch: Throwable -> L56
        r1.put("自动激活", this.a.v);     // Catch: Throwable -> L56
        this.a.getClass();     // Catch: Throwable -> L56
        r1.put("后台静默", false);     // Catch: Throwable -> L56
        r1.put("缓存文件名称", this.a.z);     // Catch: Throwable -> L56
        r1.put("数据库文件名称", this.a.a());     // Catch: Throwable -> L56
        r1.put("监听生命周期", this.a.w);     // Catch: Throwable -> L56
        if (this.b.Y != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        r1.put("禁用个性化", r6);     // Catch: Throwable -> L56
        r1.put("小版本号", this.a.r);     // Catch: Throwable -> L56
        r1.put("版本号编码", String.valueOf(this.a.o));     // Catch: Throwable -> L56
        r1.put("版本号", this.a.m);     // Catch: Throwable -> L56
        r1.put("应用名称", this.a.k);     // Catch: Throwable -> L56
        if (this.a.i != 1) goto L16;
        String r7 = "main";
    L17:
        r1.put("当前进程", r7);     // Catch: Throwable -> L56
        r1.put("地区", this.a.f);     // Catch: Throwable -> L56
        r1.put("语言", this.a.d);     // Catch: Throwable -> L56
        this.a.getClass();     // Catch: Throwable -> L56
        r1.put("PLAY开关", false);     // Catch: Throwable -> L56
        if ((this.b.P1() & 1) <= 0) goto L20;
        boolean r8 = true;
    L21:
        r1.put("事件采样", r8);     // Catch: Throwable -> L56
        if ((this.b.P1() & 2) <= 0) goto L24;
        boolean r9 = true;
    L25:
        r1.put("Tea还原采样", r9);     // Catch: Throwable -> L56
        r1.put("事件分级", this.b.C);     // Catch: Throwable -> L56
        r1.put("采集USER ID", this.b.x);     // Catch: Throwable -> L56
        r1.put("游客模式", this.b.y);     // Catch: Throwable -> L56
        r1.put("游客模式采集事件", this.b.z);     // Catch: Throwable -> L56
        r1.put("DAU虚高修复", this.b.A);     // Catch: Throwable -> L56
        if (this.b.u == null) goto L28;
        r4 = true;
    L28:
        r1.put("HTTP代理", r4);     // Catch: Throwable -> L56
        r1.put("预期上报频率", this.b.e0);     // Catch: Throwable -> L56
        r1.put("双发开关", this.b.h0);     // Catch: Throwable -> L56
        r1.put("立即Terminate开关", this.b.P);     // Catch: Throwable -> L56
        if (this.a.l == null) goto L53;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L56
        u r10 = this.a.l.e;     // Catch: Throwable -> L56
        if (r10 == null) goto L41;
        r0 r11 = ((b) r10).b;     // Catch: Throwable -> L56
        if (r11 == null) goto L41;
        if (TextUtils.isEmpty(r11.a) == true) goto L39;
        r2.add(((b) this.a.l.e).b.a);     // Catch: Throwable -> L56
    L39:
        if (TextUtils.isEmpty(((b) this.a.l.e).b.b) == true) goto L41;
        r2.add(((b) this.a.l.e).b.b);     // Catch: Throwable -> L56
    L41:
        String[] r12 = this.a.l.a;     // Catch: Throwable -> L56
        if (r12 == null) goto L47;
        if (r12.length <= 0) goto L47;
        r2.add(TextUtils.join(";", r12));     // Catch: Throwable -> L56
    L47:
        if (TextUtils.isEmpty(this.a.l.c) == true) goto L50;
        r2.add(this.a.l.c);     // Catch: Throwable -> L56
    L50:
        if (TextUtils.isEmpty(this.a.l.c) == true) goto L52;
        r2.add(this.a.l.c);     // Catch: Throwable -> L56
    L52:
        r1.put("服务域名配置", TextUtils.join("、", r2));     // Catch: Throwable -> L56
    L54:
        r0.put("config", r1);     // Catch: Throwable -> L56
        goto L55
    L53:
        r1.put("服务域名配置", "default");     // Catch: Throwable -> L56
        goto L54
    L24:
        r9 = false;
        goto L25
    L20:
        r8 = false;
        goto L21
    L16:
        r7 = "child";
        goto L17
    L10:
        if (this.b.Y.intValue() != 1) goto L12;
        r6 = true;
        goto L13
    L6:
        r5 = false;
    L55:
        return r0;
    }

    public c(b r1, q r2) {
        this.b = r1;
        this.a = r2;
    }
}
