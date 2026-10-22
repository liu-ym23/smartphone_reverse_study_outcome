package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.telephony.CellInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/ability/impl/MobileCellularAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "cellInfoListener", "Landroid/telephony/TelephonyCallback$CellInfoListener;", "onCreate", "", "iAbilityContext", "onSubscribe", "", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onQuery", "onDestroy", "Companion", "DefaultSubIdChangeListener", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8399b;
    private Context c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/MobileCellularAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8398a = new a(null);
    }

    public l() {
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8399b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r1, com.obric.memorydata.ability.f r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.c(this, r1, r2);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r9, com.obric.memorydata.ability.f r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r10, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileCellularAbility", "onQuery " + r9, false, 4, null);
        com.obric.memorydata.ability.a.d r11 = com.obric.memorydata.ability.a.d.f8302a;
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        int r12 = r11.a(r0);
        com.obric.memorydata.ability.a.d r1 = com.obric.memorydata.ability.a.d.f8302a;
        Context r2 = this.c;
        Intrinsics.checkNotNull(r2);
        CellInfo r3 = r1.a(r2, r12);
        if (r3 != null) goto L6;
        com.obric.memorydata.ability.j r8 = this.f8399b;
        Intrinsics.checkNotNull(r8);
        Object r13 = ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.l(), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
    L5:
        r8.a(r9, (com.obric.memorydata.ability.data.h) r13);
        return true;
    L6:
        com.obric.memorydata.ability.data.l r4 = com.obric.memorydata.ability.a.d.f8302a.a(r3);
        if (r12 != (-1)) goto L9;
        r4.a(-1);
    L9:
        r8 = this.f8399b;
        Intrinsics.checkNotNull(r8);
        r13 = ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        goto L5
    }
}
