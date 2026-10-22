package com.obric.oui.color;

import ai.j0;
import androidx.annotation.Keep;
import av.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bH\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\tJ9\u0010\u0012\u001a\u00020\u00072\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00110\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R,\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u0012\u0004\b$\u0010\u0003\u001a\u0004\b#\u0010\u001eR\u0014\u0010%\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0019R,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u0010\u001c\u0012\u0004\b)\u0010\u0003\u001a\u0004\b(\u0010\u001eR\u0014\u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019R,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010\u001c\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010\u001eR\u0014\u0010/\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00101\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00102\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0019R,\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b3\u0010\u001c\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u0010\u001eR\u0014\u00106\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0019R\u0014\u00107\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0019R,\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b8\u0010\u001c\u0012\u0004\b:\u0010\u0003\u001a\u0004\b9\u0010\u001eR\u0014\u0010;\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0014\u0010<\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0019R,\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u0010\u001c\u0012\u0004\b?\u0010\u0003\u001a\u0004\b>\u0010\u001eR\u0014\u0010@\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0019R\u0014\u0010A\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0019R,\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bB\u0010\u001c\u0012\u0004\bD\u0010\u0003\u001a\u0004\bC\u0010\u001eR\u0014\u0010E\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0019R,\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bG\u0010\u001c\u0012\u0004\bI\u0010\u0003\u001a\u0004\bH\u0010\u001eR\u0014\u0010J\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0019R\u0014\u0010K\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0019R,\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bL\u0010\u001c\u0012\u0004\bN\u0010\u0003\u001a\u0004\bM\u0010\u001eR\u0014\u0010O\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0019R\u0014\u0010P\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0019R,\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bQ\u0010\u001c\u0012\u0004\bS\u0010\u0003\u001a\u0004\bR\u0010\u001eR\u0014\u0010T\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0019R\u0014\u0010U\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0019R,\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bV\u0010\u001c\u0012\u0004\bX\u0010\u0003\u001a\u0004\bW\u0010\u001e¨\u0006Y"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "<init>", "()V", "customTokenOwner", "", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "", "", "Lcom/obric/oui/color/d;", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "registerProvider", "Lkotlin/Function1;", "registerProviderTokens", "name", "parse", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "isLight", "(Ljava/lang/String;Z)Lcom/obric/oui/color/d;", "OUI_Effect_Stroke_Regular_Light", "Lcom/obric/oui/color/d;", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular", "Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular", "()Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular$annotations", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular$annotations", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "OUI_Effect_Stroke_Yellow_Thin_Light", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Blue_Regular = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Blue_Regular_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Blue_Thin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Blue_Thin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Green_Regular = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Green_Regular_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Green_Thin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Green_Thin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Red_Regular = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Red_Regular_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Red_Thin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Red_Thin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Regular = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Regular_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Regular_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Thick = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Thick_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Thick_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Thin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Thin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Thin_Light = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Tinted_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Tinted_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_UltraThin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_UltraThin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_UltraThin_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Yellow_Regular = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Yellow_Regular_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final Function1<Boolean, d> OUI_Effect_Stroke_Yellow_Thin = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Yellow_Thin_Dark = null;

    @JvmField
    public static final d OUI_Effect_Stroke_Yellow_Thin_Light = null;

    static {
        INSTANCE = new StrokeToken();
        OUI_Effect_Stroke_Regular_Light = f.f12431c;
        OUI_Effect_Stroke_Regular_Dark = f.d;
        OUI_Effect_Stroke_Regular = f.e;
        OUI_Effect_Stroke_UltraThin_Light = f.f;
        OUI_Effect_Stroke_UltraThin_Dark = f.g;
        OUI_Effect_Stroke_UltraThin = f.f12432h;
        OUI_Effect_Stroke_Thin_Light = f.f12433i;
        OUI_Effect_Stroke_Thin_Dark = f.f12434j;
        OUI_Effect_Stroke_Thin = f.f12435k;
        OUI_Effect_Stroke_Thick_Light = f.f12436l;
        OUI_Effect_Stroke_Thick_Dark = f.f12437m;
        OUI_Effect_Stroke_Thick = f.f12438n;
        OUI_Effect_Stroke_Tinted_Light = f.f12439o;
        OUI_Effect_Stroke_Tinted_Dark = f.f12440p;
        OUI_Effect_Stroke_Blue_Regular_Light = f.f12441q;
        OUI_Effect_Stroke_Blue_Regular_Dark = f.f12442r;
        OUI_Effect_Stroke_Blue_Regular = f.s;
        OUI_Effect_Stroke_Blue_Thin_Light = f.f12443t;
        OUI_Effect_Stroke_Blue_Thin_Dark = f.f12444u;
        OUI_Effect_Stroke_Blue_Thin = f.f12445v;
        OUI_Effect_Stroke_Red_Regular_Light = f.f12446w;
        OUI_Effect_Stroke_Red_Regular_Dark = f.f12447x;
        OUI_Effect_Stroke_Red_Regular = f.f12448y;
        OUI_Effect_Stroke_Red_Thin_Light = f.f12449z;
        OUI_Effect_Stroke_Red_Thin_Dark = f.A;
        OUI_Effect_Stroke_Red_Thin = f.B;
        OUI_Effect_Stroke_Green_Regular_Light = f.C;
        OUI_Effect_Stroke_Green_Regular_Dark = f.D;
        OUI_Effect_Stroke_Green_Regular = f.E;
        OUI_Effect_Stroke_Green_Thin_Light = f.F;
        OUI_Effect_Stroke_Green_Thin_Dark = f.G;
        OUI_Effect_Stroke_Green_Thin = f.H;
        OUI_Effect_Stroke_Yellow_Regular_Light = f.I;
        OUI_Effect_Stroke_Yellow_Regular_Dark = f.J;
        OUI_Effect_Stroke_Yellow_Regular = f.K;
        OUI_Effect_Stroke_Yellow_Thin_Light = f.L;
        OUI_Effect_Stroke_Yellow_Thin_Dark = f.M;
        OUI_Effect_Stroke_Yellow_Thin = f.N;
    }

    private StrokeToken() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    public static final Function1<Boolean, d> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    @JvmStatic
    public static final Function1<Boolean, d> parse(String r5) {
        return (Function1) i.w(r5, f.a(INSTANCE));
    }

    @JvmStatic
    public static final void register(Object r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokenOwner");
        i.x(f.b(INSTANCE), i.n(d.class, r5), r10);
    }

    public static /* synthetic */ void register$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        register(r5, r10);
    }

    @JvmStatic
    public static final void registerProvider(Object r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokenOwner");
        i.x(f.a(INSTANCE), i.n(Function1.class, r5), r10);
    }

    public static /* synthetic */ void registerProvider$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerProvider(r5, r10);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, d>> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        i.x(f.a(INSTANCE), r5, r10);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerProviderTokens(r5, r10);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, d> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        i.x(f.b(INSTANCE), r5, r10);
    }

    public static /* synthetic */ void registerTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerTokens(r5, r10);
    }

    @JvmStatic
    public static final d parse(String r5, boolean r10) {
        StrokeToken r11 = INSTANCE;
        d r12 = (d) i.w(r5, f.b(r11));
        if (r12 != null) goto L10;
        StringBuilder r13 = j0.u(r5);
        if (r10 == false) goto L7;
        String r14 = "_light";
    L8:
        r13.append(r14);
        return (d) i.w(r13.toString(), f.b(r11));
    L7:
        r14 = "_dark";
        goto L8
    L10:
        return r12;
    }
}
