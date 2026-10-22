package com.obric.oui.color;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010GH\u0007J\u001c\u0010E\u001a\u0004\u0018\u00010\u00062\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0005H\u0007J\u001a\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J\u001a\u0010M\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J2\u0010N\u001a\u00020J2\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J&\u0010Q\u001a\u00020J2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00060P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\tR\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\tR\u0010\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\tR\u0010\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\tR\u0010\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\tR\u0010\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0002\u001a\u0004\b'\u0010\tR\u0010\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\tR\u0010\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\tR\u0010\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\tR\u0010\u00109\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\tR\u0010\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\tR\u0010\u0010C\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "()V", "OUI_Effect_Stroke_Blue_Regular", "Lkotlin/Function1;", "", "Lcom/obric/oui/color/StrokeConfig;", "getOUI_Effect_Stroke_Blue_Regular$annotations", "getOUI_Effect_Stroke_Blue_Regular", "()Lkotlin/jvm/functions/Function1;", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "getOUI_Effect_Stroke_Blue_Thin", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "getOUI_Effect_Stroke_Green_Regular", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "getOUI_Effect_Stroke_Green_Thin", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "getOUI_Effect_Stroke_Red_Regular", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "getOUI_Effect_Stroke_Red_Thin", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Regular", "getOUI_Effect_Stroke_Regular$annotations", "getOUI_Effect_Stroke_Regular", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular_Light", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "getOUI_Effect_Stroke_Thick", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "getOUI_Effect_Stroke_Thin", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "getOUI_Effect_Stroke_UltraThin", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "getOUI_Effect_Stroke_Yellow_Regular", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "getOUI_Effect_Stroke_Yellow_Thin", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin_Light", "parse", ActivityLifecycle.NAME, "", "isLight", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerTokens", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Blue_Regular = null;
    public static final e OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final e OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Blue_Thin = null;
    public static final e OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final e OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Green_Regular = null;
    public static final e OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final e OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Green_Thin = null;
    public static final e OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final e OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Red_Regular = null;
    public static final e OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final e OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Red_Thin = null;
    public static final e OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final e OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Regular = null;
    public static final e OUI_Effect_Stroke_Regular_Dark = null;
    public static final e OUI_Effect_Stroke_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Thick = null;
    public static final e OUI_Effect_Stroke_Thick_Dark = null;
    public static final e OUI_Effect_Stroke_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Thin = null;
    public static final e OUI_Effect_Stroke_Thin_Dark = null;
    public static final e OUI_Effect_Stroke_Thin_Light = null;
    public static final e OUI_Effect_Stroke_Tinted_Dark = null;
    public static final e OUI_Effect_Stroke_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_UltraThin = null;
    public static final e OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final e OUI_Effect_Stroke_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final e OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final e OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, e> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final e OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final e OUI_Effect_Stroke_Yellow_Thin_Light = null;

    static {
        INSTANCE = new StrokeToken();
        f r0 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Effect_Stroke_Regular_Light");
        OUI_Effect_Stroke_Regular_Light = g.a(r0);
        f r1 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Effect_Stroke_Regular_Dark");
        OUI_Effect_Stroke_Regular_Dark = g.a(r1);
        OUI_Effect_Stroke_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r2 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Effect_Stroke_UltraThin_Light");
        OUI_Effect_Stroke_UltraThin_Light = g.a(r2);
        f r3 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Effect_Stroke_UltraThin_Dark");
        OUI_Effect_Stroke_UltraThin_Dark = g.a(r3);
        OUI_Effect_Stroke_UltraThin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_UltraThin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r4 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r4, "OUI_Effect_Stroke_Thin_Light");
        OUI_Effect_Stroke_Thin_Light = g.a(r4);
        f r5 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r5, "OUI_Effect_Stroke_Thin_Dark");
        OUI_Effect_Stroke_Thin_Dark = g.a(r5);
        OUI_Effect_Stroke_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r6 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Light;
        Intrinsics.checkNotNullExpressionValue(r6, "OUI_Effect_Stroke_Thick_Light");
        OUI_Effect_Stroke_Thick_Light = g.a(r6);
        f r7 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark;
        Intrinsics.checkNotNullExpressionValue(r7, "OUI_Effect_Stroke_Thick_Dark");
        OUI_Effect_Stroke_Thick_Dark = g.a(r7);
        OUI_Effect_Stroke_Thick = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Thick$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r8 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r8, "OUI_Effect_Stroke_Tinted_Light");
        OUI_Effect_Stroke_Tinted_Light = g.a(r8);
        f r9 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r9, "OUI_Effect_Stroke_Tinted_Dark");
        OUI_Effect_Stroke_Tinted_Dark = g.a(r9);
        f r10 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r10, "OUI_Effect_Stroke_Blue_Regular_Light");
        OUI_Effect_Stroke_Blue_Regular_Light = g.a(r10);
        f r11 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r11, "OUI_Effect_Stroke_Blue_Regular_Dark");
        OUI_Effect_Stroke_Blue_Regular_Dark = g.a(r11);
        OUI_Effect_Stroke_Blue_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Blue_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r12 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r12, "OUI_Effect_Stroke_Blue_Thin_Light");
        OUI_Effect_Stroke_Blue_Thin_Light = g.a(r12);
        f r13 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r13, "OUI_Effect_Stroke_Blue_Thin_Dark");
        OUI_Effect_Stroke_Blue_Thin_Dark = g.a(r13);
        OUI_Effect_Stroke_Blue_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Blue_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r14 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r14, "OUI_Effect_Stroke_Red_Regular_Light");
        OUI_Effect_Stroke_Red_Regular_Light = g.a(r14);
        f r15 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r15, "OUI_Effect_Stroke_Red_Regular_Dark");
        OUI_Effect_Stroke_Red_Regular_Dark = g.a(r15);
        OUI_Effect_Stroke_Red_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Red_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r16 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r16, "OUI_Effect_Stroke_Red_Thin_Light");
        OUI_Effect_Stroke_Red_Thin_Light = g.a(r16);
        f r17 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r17, "OUI_Effect_Stroke_Red_Thin_Dark");
        OUI_Effect_Stroke_Red_Thin_Dark = g.a(r17);
        OUI_Effect_Stroke_Red_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Red_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r18 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r18, "OUI_Effect_Stroke_Green_Regular_Light");
        OUI_Effect_Stroke_Green_Regular_Light = g.a(r18);
        f r19 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r19, "OUI_Effect_Stroke_Green_Regular_Dark");
        OUI_Effect_Stroke_Green_Regular_Dark = g.a(r19);
        OUI_Effect_Stroke_Green_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Green_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r20 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r20, "OUI_Effect_Stroke_Green_Thin_Light");
        OUI_Effect_Stroke_Green_Thin_Light = g.a(r20);
        f r21 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r21, "OUI_Effect_Stroke_Green_Thin_Dark");
        OUI_Effect_Stroke_Green_Thin_Dark = g.a(r21);
        OUI_Effect_Stroke_Green_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Green_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r22 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r22, "OUI_Effect_Stroke_Yellow_Regular_Light");
        OUI_Effect_Stroke_Yellow_Regular_Light = g.a(r22);
        f r23 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r23, "OUI_Effect_Stroke_Yellow_Regular_Dark");
        OUI_Effect_Stroke_Yellow_Regular_Dark = g.a(r23);
        OUI_Effect_Stroke_Yellow_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Yellow_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        f r24 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r24, "OUI_Effect_Stroke_Yellow_Thin_Light");
        OUI_Effect_Stroke_Yellow_Thin_Light = g.a(r24);
        f r25 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r25, "OUI_Effect_Stroke_Yellow_Thin_Dark");
        OUI_Effect_Stroke_Yellow_Thin_Dark = g.a(r25);
        OUI_Effect_Stroke_Yellow_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(StrokeToken$OUI_Effect_Stroke_Yellow_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
    }

    private StrokeToken() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, e> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    public static /* synthetic */ f lambda$IROnWQJCNQ7pXwwNk0lsM_QSJPs(kotlin.jvm.functions.Function1 r0, Boolean r1) {
        return m1272registerProviderTokens$lambda2$lambda1(r0, r1);
    }

    @JvmStatic
    public static final e parse(String r1, boolean r2) {
        f r3 = StrokeTokenCore.parse(INSTANCE, r1, r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return g.a(r3);
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, e> parse(String r2) {
        final Function1<Boolean, f> r3 = StrokeTokenCore.parseProvider(INSTANCE, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final void register(Object r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokenOwner");
        StrokeTokenCore.register(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void registerProvider(Object r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokenOwner");
        StrokeTokenCore.registerProvider(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, e>> r6, boolean r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "customTokens");
        StrokeToken r0 = INSTANCE;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r8.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r3 = r9.next();
        Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        final kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        r2.put(r4, new $$Lambda$StrokeToken$IROnWQJCNQ7pXwwNk0lsM_QSJPs(r5));
        goto L4
    L6:
        StrokeTokenCore.registerProviderTokens(r0, r2, r7);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerProviderTokens(r5, r2);
    }

    /* JADX INFO: renamed from: registerProviderTokens$lambda-2$lambda-1, reason: not valid java name */
    private static final f m1272registerProviderTokens$lambda2$lambda1(kotlin.jvm.functions.Function1 r2, Boolean r3) {
        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.wrapperContextForParams(r2, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$provider");
        Intrinsics.checkNotNullExpressionValue(r3, "isLight");
        return ((e) ZeusTransformUtils.preCheckCast(r4.invoke(r3), e.class, "com.obric.memorydata.plugin")).d();
    }

    @JvmStatic
    public static final void registerTokens(Map<String, e> r6, boolean r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "customTokens");
        StrokeToken r0 = INSTANCE;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r8.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r3 = r9.next();
        r2.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), ((e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), e.class, "com.obric.memorydata.plugin")).d());
        goto L4
    L6:
        StrokeTokenCore.registerTokens(r0, r2, r7);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }
}
