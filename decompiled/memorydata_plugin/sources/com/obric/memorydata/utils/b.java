package com.obric.memorydata.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\u001a\u0017\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0003\u001a/\u0010\u0005\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\u0006\u0010\u0006\u001a\u0002H\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\u0010\t\u001a-\u0010\n\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\u0006\u0010\u0006\u001a\u0002H\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\u0010\t\u001a\u001f\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\u0006\u0010\u0006\u001a\u0002H\u0002¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e\u001a\u0011\u0010\u0010\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e\u001a\u0011\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u0002H\u00022\u0006\u0010\u0017\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\b\u001a\f\u0010\u001d\u001a\u00020\u0013*\u0004\u0018\u00010\u0013\u001a%\u0010\u001e\u001a\u00020\u0013*\u0004\u0018\u00010\u00132\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001f¢\u0006\u0002\b \u001a\u001c\u0010!\u001a\u00020\u0013*\u0004\u0018\u00010\u00132\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\b\u001a\u001a\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$\u001a\u0012\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0006\u0010#\u001a\u00020$\u001a\u001c\u0010!\u001a\u00020&*\u0004\u0018\u00010&2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\b\u001a\u000f\u0010'\u001a\u00020&*\u0004\u0018\u00010&H\u0086\b\u001a\f\u0010(\u001a\u00020\u0013*\u0004\u0018\u00010)\u001a4\u0010*\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u00010)2\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u001f¢\u0006\u0002\b ¢\u0006\u0002\u0010+\u001a\u001f\u0010,\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\u0002\u0010-\u001a\u0019\u0010.\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u00010)¢\u0006\u0002\u0010/\u001a\u001f\u00100\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010-\u001a\u001f\u00102\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010-\u001a\n\u00103\u001a\u00020\u0001*\u00020\u0013\u001a\n\u00104\u001a\u00020\u0001*\u00020\u0013\u001a\n\u00105\u001a\u00020\u0001*\u00020\u0013\u001a\n\u00106\u001a\u00020\u0001*\u00020\u0013¨\u00067"}, d2 = {"isNull", "", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Z", "isNotNull", "ifValue", EventBody.KEY_VALUE, "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifNullOrValue", "defaultIfNull", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "isTrue", "(Ljava/lang/Boolean;)Z", "isNullOrTrue", "isFalse", "isNullOrFalse", "toIntString", "", "(Ljava/lang/Boolean;)Ljava/lang/String;", "chooseValue", "trueValue", "falseValue", "(Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "runWith", "trueBlock", "", "falseBlock", "safeString", "ifNotEmpty", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ifNullOrEmpty", "safeSubstring", "startIndex", "", "endIndex", "", "selfOrEmpty", "jsonString", "", "transTo", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ifTrue", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)Z", "asType", "(Ljava/lang/Object;)Ljava/lang/Object;", "ifTrueWith", "default", "ifFalseWith", "isPacific", "isPike", "isN1", "isN1Lite", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final <T> T a(Boolean r1, T r2, T r3) {
        if (Intrinsics.areEqual(r1, true) == false) goto L6;
        return r2;
    L6:
        return r3;
    }

    public static final String a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r4 = RangesKt.coerceIn(r3, 0, r2.length());
        if (r4 > 0) goto L12;
    L14:
        String r5 = r2.substring(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        return r5;
    L12:
        if (Character.isLowSurrogate(r2.charAt(r4)) == false) goto L14;
        r4 = r4 - 1;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public static final String a(String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r6 = RangesKt.coerceIn(r4, 0, r3.length());
        int r7 = RangesKt.coerceIn(r5, 0, r3.length());
        if (r6 <= r7) goto L12;
        return "";
    L12:
        if (r6 <= 0) goto L17;
        if (Character.isLowSurrogate(r3.charAt(r6)) == false) goto L17;
        r6 = r6 - 1;
    L17:
        if (r7 < r3.length()) goto L19;
    L21:
        String r8 = r3.substring(r6, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        return r8;
    L19:
        if (Character.isHighSurrogate(r3.charAt(r7 - 1)) == false) goto L21;
        r7 = r7 + 1;
        goto L21
    L5:
        r0 = false;
        goto L7
    }

    public static final <T> boolean a(T r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1, "pacific");
    }

    public static final <T> boolean b(T r0) {
        if (r0 == null) goto L4;
        return true;
    L4:
        return false;
    }

    public static final boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1, "pike");
    }

    public static final String c(Object r0) {
        if (r0 == null) goto L5;
        String r1 = u.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return "null";
    }

    public static final boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1, "nerida");
    }
}
