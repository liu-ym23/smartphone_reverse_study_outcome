package r3;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;
import x4.m0;
import x4.s;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c4.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f11419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f11420b;

    public d(c r8, m r10) {
        this.f11420b = r8;
        this.f11419a = r10;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        r8.put("appId", this.f11419a.f11425a);     // Catch: Throwable -> L43
        r8.put("channel", this.f11419a.f11427c);     // Catch: Throwable -> L43
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L43
        r10.put("AppLog版本号", "5.7.15");     // Catch: Throwable -> L43
        r10.put("AppLog版本地区", "cn");     // Catch: Throwable -> L43
        r10.put("接口加密", this.f11420b.f11409q);     // Catch: Throwable -> L43
        int r11 = v4.g.f12728a;     // Catch: Throwable -> L43
        r10.put("调试日志", false);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("自定义日志打印", false);     // Catch: Throwable -> L43
        r10.put("自动启动", this.f11419a.f11426b);     // Catch: Throwable -> L43
        r10.put("自动激活", this.f11419a.f11435k);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("后台静默", false);     // Catch: Throwable -> L43
        r10.put("缓存文件名称", this.f11419a.f11437m);     // Catch: Throwable -> L43
        r10.put("数据库文件名称", this.f11419a.a());     // Catch: Throwable -> L43
        r10.put("监听生命周期", this.f11419a.f11436l);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("禁用个性化", false);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("小版本号", null);     // Catch: Throwable -> L43
        r10.put("版本号编码", String.valueOf(this.f11419a.f11431g));     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("版本号", null);     // Catch: Throwable -> L43
        r10.put("应用名称", this.f11419a.f11429e);     // Catch: Throwable -> L43
        boolean r12 = true;
        if (this.f11419a.f11428d != 1) goto L6;
        String r13 = "main";
    L7:
        r10.put("当前进程", r13);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("地区", null);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("语言", null);     // Catch: Throwable -> L43
        this.f11419a.getClass();     // Catch: Throwable -> L43
        r10.put("PLAY开关", false);     // Catch: Throwable -> L43
        if ((this.f11420b.d() & 1) <= 0) goto L10;
        boolean r14 = true;
    L11:
        r10.put("事件采样", r14);     // Catch: Throwable -> L43
        if ((this.f11420b.d() & 2) > 0) goto L15;
        r12 = false;
    L15:
        r10.put("Tea还原采样", r12);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("事件分级", false);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("采集USER ID", false);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("游客模式", false);     // Catch: Throwable -> L43
        r10.put("游客模式采集事件", this.f11420b.f11411s);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("DAU虚高修复", false);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("HTTP代理", false);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("预期上报频率", null);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("双发开关", false);     // Catch: Throwable -> L43
        this.f11420b.getClass();     // Catch: Throwable -> L43
        r10.put("立即Terminate开关", false);     // Catch: Throwable -> L43
        if (this.f11419a.f11430f == null) goto L40;
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L43
        s r16 = this.f11419a.f11430f.f11443e;     // Catch: Throwable -> L43
        if (r16 == null) goto L28;
        m0 r17 = r16.f13379b;     // Catch: Throwable -> L43
        if (r17 == null) goto L28;
        if (TextUtils.isEmpty(r17.f13529a) == true) goto L26;
        r15.add(this.f11419a.f11430f.f11443e.f13379b.f13529a);     // Catch: Throwable -> L43
    L26:
        if (TextUtils.isEmpty(this.f11419a.f11430f.f11443e.f13379b.f13530b) == true) goto L28;
        r15.add(this.f11419a.f11430f.f11443e.f13379b.f13530b);     // Catch: Throwable -> L43
    L28:
        String[] r18 = this.f11419a.f11430f.f11439a;     // Catch: Throwable -> L43
        if (r18 == null) goto L34;
        if (r18.length <= 0) goto L34;
        r15.add(TextUtils.join(";", r18));     // Catch: Throwable -> L43
    L34:
        if (TextUtils.isEmpty(this.f11419a.f11430f.f11441c) == true) goto L37;
        r15.add(this.f11419a.f11430f.f11441c);     // Catch: Throwable -> L43
    L37:
        if (TextUtils.isEmpty(this.f11419a.f11430f.f11441c) == true) goto L39;
        r15.add(this.f11419a.f11430f.f11441c);     // Catch: Throwable -> L43
    L39:
        String r19 = TextUtils.join("、", r15);     // Catch: Throwable -> L43
    L41:
        r10.put("服务域名配置", r19);     // Catch: Throwable -> L43
        r8.put("config", r10);     // Catch: Throwable -> L43
        goto L42
    L40:
        r19 = "default";
        goto L41
    L10:
        r14 = false;
        goto L11
    L6:
        r13 = "child";
    L42:
        return r8;
    }
}
