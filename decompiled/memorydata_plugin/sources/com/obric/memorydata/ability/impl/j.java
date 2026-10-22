package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/ability/impl/LanguageChangeEventAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "previousLanguage", "", "currentLanguage", "subscriberCount", "", "isRegisterLocaleChanged", "", "onReceive", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "iAbilityContext", "onDestroy", "registerLocaleChanged", "unregisterLocaleChanged", "onSubscribe", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "getSystemLanguage", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8389b;
    private Context c;
    private String d;
    private String e;
    private int f;
    private boolean g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/LanguageChangeEventAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8388a = new a(null);
    }

    public j() {
        this.d = d();
        this.e = d();
    }

    private final void b() {
        if (this.g == true) goto L8;
        this.g = true;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.LOCALE_CHANGED");
        Context r1 = this.c;
        if (r1 == null) goto L9;
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
        return;
    L9:
        return;
    }

    private final void c() {
        if (this.g == false) goto L6;
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        return;
    }

    private final String d() {
        String r1 = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(r1, "toLanguageTag(...)");
        return r1;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        c();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r4) {
        com.obric.memorydata.ability.j r5 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "iAbilityContext");
        this.g = false;
        this.f8389b = r5;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f = 0;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        int r4 = this.f + 1;
        this.f = r4;
        if (r4 != 1) goto L5;
        b();
    L5:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        int r4 = this.f - 1;
        this.f = r4;
        if (r4 != 0) goto L7;
        c();
        return true;
    L7:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r6 = d();
        if (Intrinsics.areEqual(this.e, r6) == false) goto L5;
        return;
    L5:
        this.d = this.e;
        this.e = r6;
        RunLog.INSTANCE.debug("LanguageAbility", "language changed: " + this.d + " -> " + this.e);
        com.obric.memorydata.ability.j r7 = this.f8389b;
        Intrinsics.checkNotNull(r7);
        r7.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.j(this.d, this.e), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    }
}
