package com.obric.memorydata.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/utils/ContextAwarenessEntryPolicy;", "", "<init>", "()V", "MIN_ROM_VERSION", "", "MIN_OS_RELEASE_DATE", "", "hasEntry", "", "shortOSVersion", "", "osReleaseDate", "parseStrictVersion", "version", "(Ljava/lang/String;)Ljava/lang/Long;", "isValidReleaseDate", "releaseDate", "isLeapYear", "year", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13249a = null;

    static {
        f13249a = new m();
    }

    private m() {
    }

    private final Long a(String r11) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        return null;
    L12:
        List r13 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r13.size() == 4) goto L15;
        return null;
    L15:
        long r4 = 0;
        Iterator r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L54;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L52;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        int r8 = 0;
    L25:
        if (r8 >= r7.length()) goto L36;
        char r9 = r7.charAt(r8);
        if ('0' <= r9) goto L29;
    L31:
        boolean r16 = false;
    L33:
        if ((!r16) == true) goto L34;
        r8 = r8 + 1;
        goto L25
    L34:
        boolean r17 = true;
    L37:
        if (r17 == true) goto L52;
        Integer r18 = StringsKt.toIntOrNull(r15);
        if (r18 == null) goto L52;
        int r19 = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r19 >= 0) goto L44;
    L46:
        boolean r20 = false;
    L47:
        if (r20 == true) goto L50;
        r18 = null;
    L50:
        if (r18 == null) goto L52;
        r4 = (r4 * 1000) + ((long) r18.intValue());
        goto L17
    L44:
        if (r19 >= 1000) goto L46;
        r20 = true;
        goto L47
    L29:
        if (r9 >= ':') goto L31;
        r16 = true;
        goto L33
    L36:
        r17 = false;
    L52:
        return null;
    L21:
        r6 = false;
        goto L22
    L54:
        return Long.valueOf(r4);
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L10
    }

    private final boolean a(int r6) {
        int r0 = r6 / 10000;
        int r1 = (r6 / 100) % 100;
        int r7 = r6 % 100;
        if (2000 <= r0) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L37;
        if (1 <= r1) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L37;
        if (r1 == 2) goto L29;
        if (r1 != 4) goto L21;
    L27:
        int r8 = 30;
    L32:
        if (1 > r7) goto L36;
        if (r7 > r8) goto L36;
        return true;
    L36:
        return false;
    L21:
        if (r1 == 6) goto L27;
        if (r1 == 9) goto L27;
        if (r1 == 11) goto L27;
        r8 = 31;
        goto L32
    L29:
        if (b(r0) == false) goto L31;
        r8 = 29;
        goto L32
    L31:
        r8 = 28;
        goto L32
    L11:
        if (r1 >= 13) goto L13;
        r5 = true;
    L37:
        return false;
    L5:
        if (r0 >= 10000) goto L7;
        r4 = true;
        goto L8
    }

    private final boolean b(int r1) {
        if ((r1 % 400) != 0) goto L5;
    L10:
        return true;
    L5:
        if ((r1 % 4) == 0) goto L7;
    L9:
        return false;
    L7:
        if ((r1 % 100) == 0) goto L9;
        goto L9
    }

    public final boolean a(String r6, int r7) {
        Long r8 = a(r6);
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.longValue() >= 2006000000) goto L7;
        return false;
    L7:
        if (a(r7) == true) goto L9;
        return false;
    L9:
        if (r7 < 20260904) goto L15;
        return true;
    L15:
        return false;
    }
}
