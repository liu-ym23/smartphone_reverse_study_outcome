package com.obric.oui.shadow;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.material.f;
import com.obric.oui.material.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R-\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/shadow/ShadowToken;", "", "()V", "Oui_Shadow_Regular", "", "Lcom/obric/oui/shadow/ShadowConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "Oui_Shadow_Text_Regular", "Oui_Shadow_Thick", "Oui_Shadow_Thin", "Oui_Shadow_UltraThick", "Shadow_1", "Shadow_2", "Shadow_3", "Shadow_Text", "Shadow_Thick", "tokens", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "parse", ActivityLifecycle.NAME, "(Ljava/lang/String;)[Lcom/obric/oui/shadow/ShadowConfig;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowToken {
    public static final ShadowToken INSTANCE = null;
    public static final a[] Oui_Shadow_Regular = null;
    public static final a[] Oui_Shadow_Text_Regular = null;
    public static final a[] Oui_Shadow_Thick = null;
    public static final a[] Oui_Shadow_Thin = null;
    public static final a[] Oui_Shadow_UltraThick = null;
    public static final a[] Shadow_1 = null;
    public static final a[] Shadow_2 = null;
    public static final a[] Shadow_3 = null;
    public static final a[] Shadow_Text = null;
    public static final a[] Shadow_Thick = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new ShadowToken();
        tokens$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ShadowToken$tokens$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        b[] r0 = ShadowTokenCore.Oui_Shadow_Thin;
        Intrinsics.checkNotNullExpressionValue(r0, "Oui_Shadow_Thin");
        Oui_Shadow_Thin = f.a(r0);
        b[] r1 = ShadowTokenCore.Oui_Shadow_Regular;
        Intrinsics.checkNotNullExpressionValue(r1, "Oui_Shadow_Regular");
        Oui_Shadow_Regular = f.a(r1);
        b[] r2 = ShadowTokenCore.Oui_Shadow_Thick;
        Intrinsics.checkNotNullExpressionValue(r2, "Oui_Shadow_Thick");
        Oui_Shadow_Thick = f.a(r2);
        b[] r3 = ShadowTokenCore.Oui_Shadow_UltraThick;
        Intrinsics.checkNotNullExpressionValue(r3, "Oui_Shadow_UltraThick");
        Oui_Shadow_UltraThick = f.a(r3);
        b[] r4 = ShadowTokenCore.Oui_Shadow_Text_Regular;
        Intrinsics.checkNotNullExpressionValue(r4, "Oui_Shadow_Text_Regular");
        Oui_Shadow_Text_Regular = f.a(r4);
        b[] r5 = ShadowTokenCore.Shadow_1;
        Intrinsics.checkNotNullExpressionValue(r5, "Shadow_1");
        Shadow_1 = f.a(r5);
        b[] r6 = ShadowTokenCore.Shadow_2;
        Intrinsics.checkNotNullExpressionValue(r6, "Shadow_2");
        Shadow_2 = f.a(r6);
        b[] r7 = ShadowTokenCore.Shadow_3;
        Intrinsics.checkNotNullExpressionValue(r7, "Shadow_3");
        Shadow_3 = f.a(r7);
        b[] r8 = ShadowTokenCore.Shadow_Thick;
        Intrinsics.checkNotNullExpressionValue(r8, "Shadow_Thick");
        Shadow_Thick = f.a(r8);
        b[] r9 = ShadowTokenCore.Shadow_Text;
        Intrinsics.checkNotNullExpressionValue(r9, "Shadow_Text");
        Shadow_Text = f.a(r9);
    }

    private ShadowToken() {
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final a[] parse(String r4) {
        return (a[]) ZeusTransformUtils.preCheckCast(n.f14027a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin")), a[].class, "com.obric.memorydata.plugin");
    }
}
