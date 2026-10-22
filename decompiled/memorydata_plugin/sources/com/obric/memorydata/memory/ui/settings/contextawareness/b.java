package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessPolicy;", "", "readPreference", "Lkotlin/Function0;", "", "writePreference", "Lkotlin/Function1;", "", "readEffective", "writeEffective", "refreshUploadTaskConditions", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "isPreferenceEnabled", "setPreferenceEnabled", "enabled", "labVisible", "cloudEnabled", "refreshEffectiveState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f11446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Boolean, Unit> f11447b;
    private final Function0<Boolean> c;
    private final Function1<Boolean, Unit> d;
    private final Function0<Unit> e;

    public b(Function0<Boolean> r3, Function1<? super Boolean, Unit> r4, Function0<Boolean> r5, Function1<? super Boolean, Unit> r6, Function0<Unit> r7) {
        Function0<Boolean> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "readPreference");
        Intrinsics.checkNotNullParameter(r9, "writePreference");
        Intrinsics.checkNotNullParameter(r10, "readEffective");
        Intrinsics.checkNotNullParameter(r11, "writeEffective");
        Intrinsics.checkNotNullParameter(r12, "refreshUploadTaskConditions");
        this.f11446a = r8;
        this.f11447b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f11446a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(boolean r6, boolean r7) {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r6 == false) goto L8;
        if (r7 == false) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11446a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        boolean r8 = true;
    L9:
        this.d.invoke(Boolean.valueOf(r8));
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r0 == r9) goto L12;
        this.e.invoke();
    L12:
        if (r9 != r8) goto L15;
        return true;
    L15:
        return false;
    L8:
        r8 = false;
        goto L9
    }

    public final boolean a(boolean r5, boolean r6, boolean r7) {
        if (r7 == true) goto L6;
        a(r6, false);
        return false;
    L6:
        this.f11447b.invoke(Boolean.valueOf(r5));
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11446a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != r5) goto L9;
        boolean r8 = true;
    L10:
        boolean r4 = a(r6, r7);
        if (r8 == false) goto L15;
        if (r4 == true) goto L14;
        return false;
    L14:
        return true;
    L15:
        return false;
    L9:
        r8 = false;
        goto L10
    }
}
