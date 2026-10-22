package com.obric.contactsdk;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.android.material.timepicker.TimeModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u001a\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"HUNDRED", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "SHA_256", "", "TAG", "TEN_POW_7", "TWENTY_SIX", "anonymizePhoneNumber", "context", "Landroid/content/Context;", "phoneNumber", "normalizePhoneNumber", "phoneToCode", "sha256AsPositiveBigInteger", EventBody.KEY_VALUE, "contactsdk_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BigInteger f7858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BigInteger f7859b = null;
    private static final BigInteger c = null;

    static {
        f7858a = BigInteger.valueOf(100);
        f7859b = BigInteger.valueOf(26);
        c = BigInteger.valueOf(StackLeakChecker.CHECK_INTERVAL_10_SEC);
    }

    public static final String a(Context r3, String r4) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "context");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L17;
        return null;
    L17:
        return a(r4);
    L14:
        e = move-exception;
        com.obric.a.a.f.f5867a.a("PhoneNumberAnonymizer", "anonymizePhoneNumber failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r6 = false;
        goto L10
    }

    private static final String a(String r7) {
        String r8 = b(r7);
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.length() != 11) goto L22;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L9:
        if (r3 >= r1.length()) goto L14;
        if ((!Character.isDigit(r1.charAt(r3))) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L22;
        BigInteger r9 = c(r8);
        if (r9 != null) goto L20;
        return null;
    L20:
        BigInteger r0 = f7858a;
        int r4 = r9.mod(r0).intValueExact();
        BigInteger r10 = r9.divide(r0);
        Intrinsics.checkNotNullExpressionValue(r10, "divide(...)");
        BigInteger r5 = f7859b;
        char r6 = (char) (r10.mod(r5).intValueExact() + 97);
        BigInteger r11 = r10.divide(r5);
        Intrinsics.checkNotNullExpressionValue(r11, "divide(...)");
        int r12 = r11.mod(c).intValueExact();
        StringBuilder r13 = new StringBuilder().append('1');
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        String r15 = String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1));
        Intrinsics.checkNotNullExpressionValue(r15, "format(...)");
        StringBuilder r16 = r13.append(r15).append(r6);
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        String r18 = String.format(Locale.US, "%07d", Arrays.copyOf(new Object[]{Integer.valueOf(r12)}, 1));
        Intrinsics.checkNotNullExpressionValue(r18, "format(...)");
        return r16.append(r18).toString();
    L14:
        r2 = false;
    L22:
        return null;
    }

    private static final String b(String r9) {
        if (r9 == null) goto L5;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        return null;
    L15:
        StringBuilder r5 = new StringBuilder(r10.length());
        int r6 = 0;
    L17:
        if (r6 >= r10.length()) goto L29;
        char r7 = r10.charAt(r6);
        if (Character.isDigit(r7) == true) goto L26;
        if (r7 != '+') goto L27;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
    L24:
        r8 = false;
    L27:
        r6 = r6 + 1;
    L26:
        r5.append(r7);
        goto L27
    L29:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L32;
        r3 = false;
    L32:
        if (r3 == false) goto L34;
        return null;
    L34:
        String r11 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        if (StringsKt.startsWith$default(r11, "00", false, 2, null) == false) goto L38;
        StringBuilder r0 = new StringBuilder().append('+');
        String r12 = r11.substring(2);
        Intrinsics.checkNotNullExpressionValue(r12, "substring(...)");
        r11 = r0.append(r12).toString();
    L38:
        if (StringsKt.startsWith$default(r11, "+86", false, 2, null) == false) goto L47;
        if (r11.length() != 14) goto L47;
        if (r11.charAt(3) != '1') goto L47;
        String r13 = r11.substring(3);
    L44:
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
        return r13;
    L47:
        if (StringsKt.startsWith$default(r11, BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, false, 2, null) == true) goto L49;
    L53:
        return r11;
    L49:
        if (r11.length() != 13) goto L53;
        if (r11.charAt(2) != '1') goto L53;
        r13 = r11.substring(2);
        goto L44
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r10 = null;
        goto L6
    }

    private static final BigInteger c(String r5) {
        MessageDigest r2 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Exception -> L4
        Charset r3 = StandardCharsets.UTF_8;     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r3, "UTF_8");     // Catch: Exception -> L4
        byte[] r6 = r5.getBytes(r3);     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r6, "getBytes(...)");     // Catch: Exception -> L4
        return new BigInteger(1, r2.digest(r6));
    L4:
        e = move-exception;
        com.obric.a.a.f.f5867a.a("PhoneNumberAnonymizer", "sha256 failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }
}
