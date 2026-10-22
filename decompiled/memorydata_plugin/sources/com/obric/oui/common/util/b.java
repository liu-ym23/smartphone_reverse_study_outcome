package com.obric.oui.common.util;

import android.content.Context;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0007\u001a\u00020\bJ \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0007\u001a\u00020\b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/common/util/OAttributes;", "", "()V", "resolve", "Landroid/util/TypedValue;", "context", "Landroid/content/Context;", "attributeResId", "", "resolveBoolean", "", "defaultValue", "resolveBooleanOrThrow", "errorMessageComponent", "", "resolveDimension", "defaultDimenResId", "resolveInteger", "resolveOrThrow", "componentView", "Landroid/view/View;", "resolveTypedValueOrThrow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13500a = null;

    static {
        f13500a = new b();
    }

    private b() {
    }

    public final int a(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        TypedValue r2 = a(r6, r4);
        if (r2 != null) goto L5;
    L8:
        float r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDimension(r5);
    L10:
        return (int) r7;
    L5:
        if (r2.type != 5) goto L8;
        r7 = r2.getDimension(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics());
        goto L10
    }

    public final TypedValue a(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        TypedValue r4 = new TypedValue();
        if (r1.getTheme().resolveAttribute(r3, r4, true) == true) goto L7;
        return null;
    L7:
        return r4;
    }
}
