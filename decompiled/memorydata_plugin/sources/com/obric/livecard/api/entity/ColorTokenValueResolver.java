package com.obric.livecard.api.entity;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import androidx.core.content.ContextCompat;
import com.obric.livecard.api.ILiveCard;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\f\u0010\n\u001a\u00020\u000b*\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u00020\t*\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/livecard/api/entity/ColorTokenValueResolver;", "", "()V", "resolve", "Lcom/obric/livecard/api/entity/ColorHex;", "colorRes", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "toArgbHex", "", "withNightMode", "nightMode", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColorTokenValueResolver {
    public static final ColorTokenValueResolver INSTANCE = null;

    static {
        INSTANCE = new ColorTokenValueResolver();
    }

    private ColorTokenValueResolver() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColorHex resolve$default(ColorTokenValueResolver r0, int r1, WeakReference r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.resolve(r1, r2);
    }

    private final String toArgbHex(int r4) {
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r5 = String.format(Locale.US, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1));
        Intrinsics.checkNotNullExpressionValue(r5, "java.lang.String.format(locale, format, *args)");
        return r5;
    }

    private final Context withNightMode(Context r3, int r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Configuration r5 = new Configuration(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getConfiguration());
        r5.uiMode = r4 | (r5.uiMode & (-49));
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.createConfigurationContext(r5), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "createConfigurationContext(configuration)");
        return r6;
    }

    public final ColorHex resolve(int r4, WeakReference<Context> r5) {
        if (r5 == null) goto L6;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r5.get(), Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
    L7:
        if (r6 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r6, "checkNotNull(context?.ge…ing ColorToken\"\n        }");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(withNightMode(r6, 16), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(withNightMode(r6, 32), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return new ColorHex(toArgbHex(ContextCompat.getColor(r1, r4)), toArgbHex(ContextCompat.getColor(r7, r4)));
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("ILiveCard.init(context) must be called before creating ColorToken".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        r6 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L7
    }
}
