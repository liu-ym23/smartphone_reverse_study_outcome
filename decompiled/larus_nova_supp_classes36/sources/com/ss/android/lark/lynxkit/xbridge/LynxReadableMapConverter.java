package com.ss.android.lark.lynxkit.xbridge;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/LynxReadableMapConverter;", "", "<init>", "()V", "toMap", "", "", "mapData", "Lcom/lynx/react/bridge/ReadableMap;", "toList", "", "arrayData", "Lcom/lynx/react/bridge/ReadableArray;", "readMapValue", TabAppInfo.IMAGE_JSON_KEY, "readArrayValue", "index", "", "readNumber", "", "readInt", "Lkotlin/Function0;", "readDouble", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LynxReadableMapConverter {
    public static final LynxReadableMapConverter INSTANCE = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ReadableType.PiperData.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new LynxReadableMapConverter();
    }

    private LynxReadableMapConverter() {
    }

    private final List<Object> toList(ReadableArray r5) {
        if (r5 == null) goto L4;
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = r5.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.add(INSTANCE.readArrayValue(r5, r2));
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    public final Map<String, Object> toMap(ReadableMap r5) {
        if (r5 == null) goto L4;
        LinkedHashMap r0 = new LinkedHashMap();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L7:
        if (r1.hasNextKey() == false) goto L9;
        String r2 = r1.nextKey();
        Intrinsics.checkNotNull(r2);
        r0.put(r2, INSTANCE.readMapValue(r5, r2));
        goto L7
    L9:
        return r0;
    L4:
        return MapsKt.emptyMap();
    }

    private final Object readArrayValue(final ReadableArray r3, final int r4) {
        ReadableType r0 = r3.getType(r4);
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        switch(r1) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        return null;
    L20:
        return r3.getPiperData(r4);
    L21:
        return r3.getByteArray(r4);
    L22:
        return toList(r3.getArray(r4));
    L23:
        return toMap(r3.getMap(r4));
    L24:
        return r3.getString(r4);
    L25:
        return readNumber(new AnonymousClass1(r3, r4), new AnonymousClass2(r3, r4));
    L26:
        return Long.valueOf(r3.getLong(r4));
    L27:
        return Integer.valueOf(r3.getInt(r4));
    L18:
        return Boolean.valueOf(r3.getBoolean(r4));
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }

    private final Object readMapValue(final ReadableMap r3, final String r4) {
        ReadableType r0 = r3.getType(r4);
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        switch(r1) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        return null;
    L20:
        return r3.getPiperData(r4);
    L21:
        return r3.getByteArray(r4);
    L22:
        return toList(r3.getArray(r4));
    L23:
        return toMap(r3.getMap(r4));
    L24:
        return r3.getString(r4);
    L25:
        return readNumber(new C04301(r3, r4), new C04312(r3, r4));
    L26:
        return Long.valueOf(r3.getLong(r4));
    L27:
        return Integer.valueOf(r3.getInt(r4));
    L18:
        return Boolean.valueOf(r3.getBoolean(r4));
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }

    private final Number readNumber(Function0<Integer> r5, Function0<Double> r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r7 = Result.constructor-impl(Integer.valueOf(((Number) r5.invoke()).intValue()));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r7) == false) goto L9;
        r7 = 0;
    L9:
        int r8 = ((Number) r7).intValue();
        Object r9 = Result.constructor-impl(Double.valueOf(((Number) r6.invoke()).doubleValue()));     // Catch: Throwable -> L12
    L14:
        Double r1 = Double.valueOf(0.0d);
        if (Result.isFailure-impl(r9) == false) goto L17;
        r9 = r1;
    L17:
        double r2 = ((Number) r9).doubleValue();
        if (Double.compare(r8, r2) == 0) goto L20;
        long r10 = (long) r2;
        if (Double.compare(r10, r2) != 0) goto L26;
        return Long.valueOf(r10);
    L26:
        return Double.valueOf(r2);
    L20:
        return Integer.valueOf(r8);
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
