package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.provider.Settings;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/ability/impl/ScreenBrightnessAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "onCreate", "", "iAbilityContext", "onDestroy", "onQuery", "", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "getScreenBrightness", "", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8405b;
    private Context c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/ScreenBrightnessAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8404a = new a(null);
    }

    public o() {
    }

    private final int b() {
        Context r3 = this.c;     // Catch: Settings.SettingNotFoundException -> L4
        Intrinsics.checkNotNull(r3);     // Catch: Settings.SettingNotFoundException -> L4
        return Settings.System.getInt(r3.getContentResolver(), "screen_brightness");
    L4:
        e = move-exception;
        RunLog.INSTANCE.error("ScreenBrightnessAbility", "Get screen brightness exception:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8405b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.c(this, r1, r2);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r3, com.obric.memorydata.ability.f r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        int r5 = b();
        if (r5 == (-1)) goto L5;
        com.obric.memorydata.ability.j r2 = this.f8405b;
        Intrinsics.checkNotNull(r2);
        r2.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.o(r5), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    L5:
        return false;
    }
}
