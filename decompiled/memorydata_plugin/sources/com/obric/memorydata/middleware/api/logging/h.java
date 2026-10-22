package com.obric.memorydata.middleware.api.logging;

import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\f\u001a\u00020\n*\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/LogTextSanitizer;", "", "<init>", "()V", "token", "", EventBody.KEY_VALUE, XSDatatype.FACET_MAXLENGTH, "", "lowercase", "", "singleLine", "isLogTokenCharacter", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11620a = null;

    static {
        f11620a = new h();
    }

    private h() {
    }

    private final boolean a(char r3) {
        if ('a' <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if ('A' <= r3) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        return true;
    L17:
        if ('0' <= r3) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        return true;
    L24:
        if (r3 != '_') goto L26;
        return true;
    L26:
        if (r3 != '.') goto L28;
        return true;
    L28:
        if (r3 != '-') goto L31;
        return true;
    L31:
        return false;
    L19:
        if (r3 >= ':') goto L21;
        r4 = true;
        goto L22
    L12:
        if (r3 >= '[') goto L14;
        r2 = true;
        goto L15
    L5:
        if (r3 >= '{') goto L7;
        r1 = true;
        goto L8
    }

    public final String a(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        StringBuilder r6 = new StringBuilder(Math.min(r7.length(), r8));
        int r0 = r7.length();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L20;
        char r4 = r7.charAt(r2);
        if (CharsKt.isWhitespace(r4) == true) goto L7;
        if (r3 == false) goto L14;
        if (r6.length() >= r8) goto L14;
        r6.append(' ');
    L14:
        if (r6.length() >= r8) goto L17;
        r6.append(r4);
    L17:
        if (r6.length() >= r8) goto L20;
    L18:
        r3 = false;
    L19:
        r2 = r2 + 1;
        goto L3
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        r3 = true;
    L20:
        String r9 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return r9;
    }

    public final String a(String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        StringBuilder r0 = new StringBuilder(Math.min(r11.length(), r12));
        int r1 = r11.length();
        boolean r2 = false;
        int r3 = 0;
        boolean r4 = false;
    L3:
        boolean r6 = true;
        if (r3 >= r1) goto L31;
        char r8 = r11.charAt(r3);
        if (a(r8) == false) goto L8;
        if (r4 == false) goto L17;
        if (r0.length() >= r12) goto L17;
        r0.append('_');
    L17:
        if (r0.length() >= r12) goto L31;
        if (r8 == '_') goto L20;
    L24:
        if (r13 == false) goto L26;
        r8 = Character.toLowerCase(r8);
    L26:
        r0.append(r8);
    L28:
        if (r0.length() >= r12) goto L31;
        r4 = false;
    L30:
        r3 = r3 + 1;
        goto L3
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L28;
    L22:
        r5 = false;
        goto L23
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L11;
        r6 = false;
    L11:
        r4 = r6;
    L31:
        Character r10 = StringsKt.lastOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L38;
        if (r10.charValue() != '_') goto L38;
        r0.deleteCharAt(StringsKt.getLastIndex((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")));
    L38:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L40;
        r2 = true;
    L40:
        if (r2 == true) goto L43;
        r0 = null;
    L43:
        if (r0 == null) goto L46;
        String r14 = r0.toString();
        if (r14 == null) goto L46;
        return r14;
    L46:
        return "unknown";
    }
}
