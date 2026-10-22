package com.obric.oui.texteffects.runtime;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerApplier;", "", "()V", "apply", "", TypedValues.AttributesType.S_FRAME, "Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;", "bindings", "", "Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "parentWidthPx", "", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14688a = null;

    static {
        f14688a = new b();
    }

    private b() {
    }

    public final void a(h r8, Collection<c> r9, float r10) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, TypedValues.AttributesType.S_FRAME);
        Intrinsics.checkNotNullParameter(r7, "bindings");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r11.next(), c.class, "com.obric.memorydata.plugin")).c();
        goto L4
    L6:
        int r12 = 0;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin");
        String r3 = r2.c();
        if (r3 == null) goto L8;
        Iterator r4 = r7.iterator();
    L14:
        if (r4.hasNext() == false) goto L8;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4.next(), c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.a(), r3) == false) goto L14;
        r5.a((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.memorydata.plugin"), r10);
        r12 = r12 + 1;
        goto L14
    L19:
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L22;
        return;
    L22:
        if (com.obric.oui.texteffects.a.b() == false) goto L36;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ExternalApplier"), "apply frameLayers=" + r8.a().size() + ", bindings=" + r7.size() + ", applied=" + r12 + ", parentWidth=" + r10);
        return;
    }
}
