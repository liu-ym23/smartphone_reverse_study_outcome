package com.obric.oui.material;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.shadow.ShadowToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/material/BlurShadowToken;", "", "()V", "Blur_Shadow_Regular", "Lcom/obric/oui/material/BlurShadowConfig;", "Blur_Shadow_Regular_On_Image", "Blur_Shadow_Thin", "Blur_Shadow_Thin_On_Image", "tokens", "", "", "getTokens", "()Ljava/util/Map;", "tokens$delegate", "Lkotlin/Lazy;", "parse", ActivityLifecycle.NAME, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurShadowToken {
    public static final a Blur_Shadow_Regular = null;
    public static final a Blur_Shadow_Regular_On_Image = null;
    public static final a Blur_Shadow_Thin = null;
    public static final a Blur_Shadow_Thin_On_Image = null;
    public static final BlurShadowToken INSTANCE = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new BlurShadowToken();
        tokens$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(BlurShadowToken$tokens$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        Blur_Shadow_Thin = new a(BlurToken.Blur_Thin, ShadowToken.Shadow_2);
        Blur_Shadow_Regular = new a(BlurToken.Blur_Regular, ShadowToken.Shadow_3);
        Blur_Shadow_Thin_On_Image = new a(BlurToken.Blur_Regular, ShadowToken.Shadow_3);
        Blur_Shadow_Regular_On_Image = new a(BlurToken.Blur_Thick, ShadowToken.Shadow_Thick);
    }

    private BlurShadowToken() {
    }

    private final Map<String, a> getTokens() {
        return (Map) ZeusTransformUtils.preCheckCast(tokens$delegate.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final a parse(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(n.f14027a.a(r2, INSTANCE.getTokens()), a.class, "com.obric.memorydata.plugin");
    }
}
