package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryTitleFormatter;", "", "<init>", "()V", "TOPIC_LABEL", "", "topicLinePattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getTopicLinePattern", "()Ljava/util/regex/Pattern;", "topicLinePattern$delegate", "Lkotlin/Lazy;", "getTitle", "summary", "fallback", "findLineStart", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "topicIndex", "findLineEnd", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11221b = null;

    static {
        f11220a = new b();
        f11221b = LazyKt.lazy($$Lambda$b$DvnGBZj01k5QJBl1AkEobnwEUuE.INSTANCE);
    }

    private b() {
    }

    private final int a(String r9, int r10) {
        int r8 = r10 - 1;
        return Math.max(StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '\n', r8, false, 4, null), StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '\r', r8, false, 4, null)) + 1;
    }

    private final Pattern a() {
        return (Pattern) ZeusTransformUtils.preCheckCast(f11221b.getValue(), Pattern.class, "com.obric.memorydata.plugin");
    }

    private final int b(String r12, int r13) {
        int r11 = r13 + 2;
        Integer r14 = Integer.valueOf(StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '\n', r11, false, 4, null));
        boolean r8 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r10 = null;
        if (r1 == true) goto L10;
        r14 = null;
    L10:
        if (r14 == null) goto L12;
        int r15 = r14.intValue();
    L13:
        Integer r16 = Integer.valueOf(StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '\r', r11, false, 4, null));
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L17;
        r8 = false;
    L17:
        if (r8 == false) goto L19;
        r10 = r16;
    L19:
        if (r10 == null) goto L21;
        int r17 = r10.intValue();
    L23:
        return Math.min(r15, r17);
    L21:
        r17 = r12.length();
        goto L23
    L12:
        r15 = r12.length();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private static final Pattern b() {
        return Pattern.compile("[ \\t]*(?:\\*{1,2})?[ \\t]*主题[ \\t]*(?:\\*{1,2})?[ \\t]*[：:][ \\t]*([^\\r\\n]+)[ \\t]*");
    }

    public static /* synthetic */ Pattern lambda$DvnGBZj01k5QJBl1AkEobnwEUuE() {
        return b();
    }

    public final String a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "fallback");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r13;
    L11:
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), "主题", 0, false, 6, null);
        if (r2 >= 0) goto L14;
        return r13;
    L14:
        Matcher r3 = a().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
    L15:
        if (r2 < 0) goto L34;
        int r4 = a(r12, r2);
        int r5 = b(r12, r2);
        r3.region(r4, r5);
        if (r3.matches() == true) goto L18;
        if (r5 < r12.length()) goto L32;
        r2 = -1;
        goto L15
    L32:
        r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), "主题", r5 + 1, false, 4, null);
        goto L15
    L18:
        String r11 = r3.group(1);
        if (r11 == null) goto L42;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r14 != null) goto L23;
        return r13;
    L23:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        r14 = null;
    L26:
        if (r14 != null) goto L29;
        return r13;
    L29:
        return r14;
    L42:
        return r13;
    L34:
        return r13;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
