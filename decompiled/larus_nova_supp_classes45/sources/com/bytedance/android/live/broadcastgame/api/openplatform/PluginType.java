package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/openplatform/PluginType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "LYNX", "MINI_APP", "SONIC_GAME", "UNKNOWN_TYPE", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PluginType extends Enum<PluginType> {
    public static final a Companion = null;
    public static final PluginType LYNX = null;
    public static final PluginType MINI_APP = null;
    public static final PluginType SONIC_GAME = null;
    public static final PluginType UNKNOWN_TYPE = null;
    public static final /* synthetic */ PluginType[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static PluginType a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "schema");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            String r2 = UriProtector.getQueryParameter(UriProtector.parse(r4), "tech_type");     // Catch: Throwable -> L9
            if (r2 == null) goto L6;
            Integer r3 = Integer.valueOf(CastIntegerProtector.parseInt(r2));     // Catch: Throwable -> L9
        L7:
            Object r5 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
        L12:
            if (Result.isFailure-impl(r5) == false) goto L14;
            r5 = null;
        L14:
            Integer r6 = (Integer) r5;
            Object r7 = Result.constructor-impl(UriProtector.parse(r4).getHost());     // Catch: Throwable -> L17
        L20:
            if (Result.isFailure-impl(r7) == true) goto L23;
            r0 = r7;
        L23:
            String r8 = (String) r0;
            PluginType r9 = b(r6);
            if (r9 == null) goto L26;
        L33:
            return r9;
        L26:
            if (StringsKt.equals("microapp", r8, true) == false) goto L30;
            return PluginType.MINI_APP;
        L30:
            if (k.a(r4) == false) goto L33;
            return PluginType.LYNX;
        L17:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        L6:
            r3 = null;
        L9:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }

        public static PluginType b(Integer r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            PluginType[] r1 = PluginType.values();
            int r2 = r1.length;
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L17;
            PluginType r5 = r1[r4];
            if (r5.getValue() != r8.intValue()) goto L10;
            boolean r6 = true;
        L11:
            if (r6 == true) goto L14;
            r4 = r4 + 1;
            goto L6
        L14:
            return r5;
        L10:
            r6 = false;
            goto L11
        L17:
            return null;
        }

        public static String c(PluginType r1) {
            Intrinsics.checkNotNullParameter(r1, "$this$getNameLowerCase");
            String r2 = r1.name();
            Locale r0 = Locale.ROOT;
            if (r2 == null) goto L7;
            return r2.toLowerCase(r0);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
        PluginType r1 = new PluginType("LYNX", 0, 13);
        LYNX = r1;
        PluginType r2 = new PluginType("MINI_APP", 1, 1);
        MINI_APP = r2;
        PluginType r3 = new PluginType("SONIC_GAME", 2, 16);
        SONIC_GAME = r3;
        PluginType r4 = new PluginType("UNKNOWN_TYPE", 3, 0);
        UNKNOWN_TYPE = r4;
        a = new PluginType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static PluginType valueOf(String r1) {
        return (PluginType) r27.a.a(PluginType.class, r1);
    }

    public static PluginType[] values() {
        return (PluginType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PluginType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
