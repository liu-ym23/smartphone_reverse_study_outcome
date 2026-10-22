package com.obric.oui.material;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\bJ1\u0010\b\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004¢\u0006\u0002\u0010\u000bJ;\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086\bJ>\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012J9\u0010\u0015\u001a\u00020\r\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u000f2\u0006\u0010\u0018\u001a\u0002H\u00162\u0006\u0010\u0019\u001a\u0002H\u0017H\u0002¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/material/TokenParser;", "", "()V", "createTokenMap", "", "", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.AttributesType.S_TARGET, "parse", ActivityLifecycle.NAME, "tokens", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Object;", "register", "", "tokenMap", "", "customTokenOwner", "overrideExisting", "", "registerTokens", "customTokens", "putIfAbsentCompat", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "key", EventBody.KEY_VALUE, "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f14027a = null;

    static {
        f14027a = new n();
    }

    private n() {
    }

    private final <K, V> void a(Map<K, V> r2, K r3, V r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r1.containsKey(r3) == true) goto L6;
        r1.put(r3, r4);
        return;
    }

    public final <T> T a(String r4, Map<String, ? extends T> r5) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "tokens");
        if (r4 != null) goto L5;
    L4:
        String r6 = null;
    L9:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        return null;
    L19:
        return (T) r3.get(r6);
    L12:
        if (r0.length() == 0) goto L15;
        r1 = false;
        goto L16
    L5:
        Locale r2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r2, "ROOT");
        String r7 = r4.toLowerCase(r2);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toLowerCase(locale)");
        if (r7 == null) goto L4;
        r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        goto L9
    }

    public final <T> void a(Map<String, T> r8, Map<String, ? extends T> r9, boolean r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "tokenMap");
        Intrinsics.checkNotNullParameter(r12, "customTokens");
        if (r12.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10 == false) goto L16;
        Iterator r7 = r12.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L25;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r15 = r13.getValue();
        Locale r5 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r5, "ROOT");
        String r16 = r14.toLowerCase(r5);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).toLowerCase(locale)");
        String r17 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r11.put(r17, r15);
        goto L9
    L13:
        r6 = false;
        goto L14
    L25:
        return;
    L16:
        Iterator r18 = r12.entrySet().iterator();
    L18:
        if (r18.hasNext() == false) goto L36;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r110 = r19.getValue();
        Locale r21 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r21, "ROOT");
        String r22 = r20.toLowerCase(r21);
        Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).toLowerCase(locale)");
        String r23 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
        boolean r24 = true;
    L23:
        if (r24 == false) goto L18;
        a(r11, r23, r110);
        goto L18
    L22:
        r24 = false;
        goto L23
    }
}
