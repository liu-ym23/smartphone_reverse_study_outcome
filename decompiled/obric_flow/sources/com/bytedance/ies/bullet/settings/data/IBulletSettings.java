package com.bytedance.ies.bullet.settings.data;

import com.bytedance.ies.bullet.base.settings.b;
import com.bytedance.ies.bullet.base.settings.j;
import com.bytedance.ies.bullet.base.settings.m;
import com.bytedance.ies.bullet.base.settings.n;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import kotlin.Metadata;
import rg.a;
import xb.c;
import xb.d;
import xc.f;
import xc.g;
import xc.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H'¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H'¢\u0006\u0004\b$\u0010%J\u0011\u0010'\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b'\u0010(J\u0011\u0010*\u001a\u0004\u0018\u00010)H'¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010,H'¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "Lxc/h;", "getResourceLoaderConfig", "()Lxc/h;", "Lxc/d;", "getCommonConfig", "()Lxc/d;", "Lcom/bytedance/ies/bullet/base/settings/n;", "getWebConfig", "()Lcom/bytedance/ies/bullet/base/settings/n;", "Lxc/f;", "getMonitorConfig", "()Lxc/f;", "Lxc/g;", "getPineappleConfig", "()Lxc/g;", "Lcom/bytedance/ies/bullet/base/settings/j;", "getMixConfig", "()Lcom/bytedance/ies/bullet/base/settings/j;", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "getSccSettingsConfig", "()Lcom/bytedance/ies/bullet/secure/SccConfig;", "Lcom/bytedance/ies/bullet/base/settings/m;", "getSecuritySettingConfig", "()Lcom/bytedance/ies/bullet/base/settings/m;", "Lcom/bytedance/ies/bullet/base/settings/d;", "getForestSettingConfig", "()Lcom/bytedance/ies/bullet/base/settings/d;", "Lcom/bytedance/pia/core/setting/c;", "getPIAConfig", "()Lcom/bytedance/pia/core/setting/c;", "Lcom/bytedance/ies/bullet/base/settings/a;", "getAnnieXRedirectConfig", "()Lcom/bytedance/ies/bullet/base/settings/a;", "Lxb/c;", "getAnnieXPredefineConfig", "()Lxb/c;", "Lxb/d;", "getAnnieXPredefineWasmConfig", "()Lxb/d;", "Lcom/bytedance/ies/bullet/base/settings/b;", "getArgusSecuritySettingConfig", "()Lcom/bytedance/ies/bullet/base/settings/b;", "Lcom/bytedance/ies/bullet/base/settings/c;", "getClientAiConfig", "()Lcom/bytedance/ies/bullet/base/settings/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@a(settingsId = "Bullet", storageKey = "bullet")
public interface IBulletSettings extends ISettings {
    c getAnnieXPredefineConfig();

    d getAnnieXPredefineWasmConfig();

    com.bytedance.ies.bullet.base.settings.a getAnnieXRedirectConfig();

    b getArgusSecuritySettingConfig();

    com.bytedance.ies.bullet.base.settings.c getClientAiConfig();

    xc.d getCommonConfig();

    com.bytedance.ies.bullet.base.settings.d getForestSettingConfig();

    j getMixConfig();

    f getMonitorConfig();

    com.bytedance.pia.core.setting.c getPIAConfig();

    g getPineappleConfig();

    h getResourceLoaderConfig();

    SccConfig getSccSettingsConfig();

    m getSecuritySettingConfig();

    n getWebConfig();
}
