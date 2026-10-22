package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryIconColorResolver;", "", "<init>", "()V", "colorResByKey", "", "", "", "resolveDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableRes", "colorKey", "resolveColor", "resolveColorRes", "isNightMode", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f10681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f10682b = null;

    static {
        f10681a = new k();
        f10682b = MapsKt.mapOf(new Pair[]{TuplesKt.to("red", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6"))), TuplesKt.to("orange", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_orange_6, TypedValues.Custom.S_COLOR, "oui_functional_orange_6"))), TuplesKt.to("yellow", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_yellow_6, TypedValues.Custom.S_COLOR, "oui_functional_yellow_6"))), TuplesKt.to("green", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_green_6, TypedValues.Custom.S_COLOR, "oui_functional_green_6"))), TuplesKt.to("cyan", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_teal_6, TypedValues.Custom.S_COLOR, "oui_functional_teal_6"))), TuplesKt.to("blue", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"))), TuplesKt.to("purple", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_purple_6, TypedValues.Custom.S_COLOR, "oui_functional_purple_6"))), TuplesKt.to("pink", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_vividred_6, TypedValues.Custom.S_COLOR, "oui_functional_vividred_6"))), TuplesKt.to("gray", Integer.valueOf(ZeusTransformUtils.mapRes(R.color.oui_functional_graphite_5, TypedValues.Custom.S_COLOR, "oui_functional_graphite_5")))});
    }

    private k() {
    }

    private final int a(String r3) {
        Map<String, Integer> r2 = f10682b;
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L7;
        String r5 = r4.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
    L8:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        return r6.intValue();
    L12:
        return ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r2, "gray"), Number.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        r5 = null;
        goto L8
    }

    private final boolean a(Context r2) {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public final int a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        return ContextCompat.getColor(r5, a(r4));
    }

    public final Drawable a(Context r3, int r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        return j.f10678a.a(r6, r4, a(r6, r5), a(r6));
    }
}
