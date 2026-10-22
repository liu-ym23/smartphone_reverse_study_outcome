package com.obric.memorydata.utils;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J*\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\u0005J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010#\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006,"}, d2 = {"Lcom/obric/memorydata/utils/URLUtils;", "", "<init>", "()V", "TAG", "", CipherConst.LEVEL_DEBUG, "", "log", "", NotificationCompat.CATEGORY_MESSAGE, "COMMON_FILE_EXTENSIONS", "", "IPV4_OCTET", "IPV4_PATTERN", "IPV6_SEG", "IPV6_CORE", "IPV6_BRACKETED", "IPV6_BARE", "DOMAIN", "URL_WITH_PROTOCOL", "Ljava/util/regex/Pattern;", "getURL_WITH_PROTOCOL", "()Ljava/util/regex/Pattern;", "URL_WITHOUT_PROTOCOL", "getURL_WITHOUT_PROTOCOL", "URL_PATTERN", "getURL_PATTERN", "isValidIpv4", "ip", "isValidIpv6", "ipv6", "isFileExtensionFalsePositive", "url", "isLikelyUrl", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "extractHost", "extractAndValidateIpv4", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", LocationMonitorConst.TAG, "extractUrls", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ax f13189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f13190b = null;
    private static final Pattern c = null;
    private static final Pattern d = null;
    private static final Pattern e = null;

    static {
        f13189a = new ax();
        f13190b = SetsKt.setOf(new String[]{"pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "jpg", "jpeg", "png", "gif", "bmp", "webp", "svg", "ico", "zip", "rar", "7z", "tar", "gz", "bz2", "apk", "exe", "dmg", "msi", "deb", "rpm", "txt", "xml", "json", "csv", "log", "md", "mp3", "mp4", "avi", "mkv", "mov", "wav", "flac", "js", "ts", "css", "html", "htm", "php", "py", "kt", "java"});
        Pattern r0 = Pattern.compile("(https?://)(?:[\\w._~!$&'()+,;=%-]+(?::[\\w._~!$&'()+,;=%-]*)?@)?(?:(?:(?:www\\.|[A-Za-z0-9_\\-]+\\.)+[A-Za-z]{2,})|(?:(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.){3}(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])(?![0-9.])|\\[(?:(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,7}:|(?:[0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,5}(?::[0-9a-fA-F]{1,4}){1,2}|(?:[0-9a-fA-F]{1,4}:){1,4}(?::[0-9a-fA-F]{1,4}){1,3}|(?:[0-9a-fA-F]{1,4}:){1,3}(?::[0-9a-fA-F]{1,4}){1,4}|(?:[0-9a-fA-F]{1,4}:){1,2}(?::[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:(?::[0-9a-fA-F]{1,4}){1,6}|:(?::[0-9a-fA-F]{1,4}){1,7}|::)\\]|(?:(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,7}:|(?:[0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,5}(?::[0-9a-fA-F]{1,4}){1,2}|(?:[0-9a-fA-F]{1,4}:){1,4}(?::[0-9a-fA-F]{1,4}){1,3}|(?:[0-9a-fA-F]{1,4}:){1,3}(?::[0-9a-fA-F]{1,4}){1,4}|(?:[0-9a-fA-F]{1,4}:){1,2}(?::[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:(?::[0-9a-fA-F]{1,4}){1,6}|:(?::[0-9a-fA-F]{1,4}){1,7}|::)|localhost)(?::\\d{1,5})?(?:/[\\w._~:/?#\\[\\]@!$&'()+,;=%\\-]*)?", 2);
        Intrinsics.checkNotNullExpressionValue(r0, "compile(...)");
        c = r0;
        Pattern r3 = Pattern.compile("(?<![A-Za-z0-9@/:])(?:(?:(?:www\\.|[A-Za-z0-9_\\-]+\\.)+[A-Za-z]{2,})|(?:(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.){3}(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])(?![0-9.])|\\[(?:(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,7}:|(?:[0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,5}(?::[0-9a-fA-F]{1,4}){1,2}|(?:[0-9a-fA-F]{1,4}:){1,4}(?::[0-9a-fA-F]{1,4}){1,3}|(?:[0-9a-fA-F]{1,4}:){1,3}(?::[0-9a-fA-F]{1,4}){1,4}|(?:[0-9a-fA-F]{1,4}:){1,2}(?::[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:(?::[0-9a-fA-F]{1,4}){1,6}|:(?::[0-9a-fA-F]{1,4}){1,7}|::)\\]|(?:(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,7}:|(?:[0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,5}(?::[0-9a-fA-F]{1,4}){1,2}|(?:[0-9a-fA-F]{1,4}:){1,4}(?::[0-9a-fA-F]{1,4}){1,3}|(?:[0-9a-fA-F]{1,4}:){1,3}(?::[0-9a-fA-F]{1,4}){1,4}|(?:[0-9a-fA-F]{1,4}:){1,2}(?::[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:(?::[0-9a-fA-F]{1,4}){1,6}|:(?::[0-9a-fA-F]{1,4}){1,7}|::)|localhost)(?::\\d{1,5})?(?:/[\\w._~:/?#\\[\\]@!$&'()+,;=%\\-]*)?", 2);
        Intrinsics.checkNotNullExpressionValue(r3, "compile(...)");
        d = r3;
        Pattern r1 = Pattern.compile(r0.pattern() + '|' + r3.pattern(), 2);
        Intrinsics.checkNotNullExpressionValue(r1, "compile(...)");
        e = r1;
    }

    private ax() {
    }

    private static final void a(String r3, boolean r4, String r5) {
        f13189a.e("isLikelyUrl input='" + r3 + "', result=" + r4 + ", reason=" + r5);
    }

    private static final boolean a(String r7, String r8) {
        ax r0 = f13189a;
        String r9 = r0.f(r8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        a(r7, false, "empty host");
        return false;
    L10:
        if (new Regex("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        boolean r2 = r0.a(r9);
        StringBuilder r3 = new StringBuilder();
        String r4 = "ipv4 host=";
    L12:
        a(r7, r2, r3.append(r4).append(r9).toString());
        return r2;
    L15:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L17;
        r2 = r0.b(r9);
        r3 = new StringBuilder();
        r4 = "ipv6 host=";
        goto L12
    L17:
        a(r7, true, "host=" + r9);
        return true;
    L5:
        r1 = false;
        goto L6
    }

    private final void e(String r3) {
        RunLog.INSTANCE.debug("URLUtils", "[UrlDebug] " + r3);
    }

    private final String f(String r5) {
        String r6 = StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(StringsKt.removePrefix(StringsKt.removePrefix(r5, (CharSequence) ZeusTransformUtils.preCheckCast("http://", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(ReportConsts.HTTPS, CharSequence.class, "com.obric.memorydata.plugin")), "/", null, 2, null), "@", null, 2, null);
        if (StringsKt.startsWith$default(r6, "[", false, 2, null) == false) goto L7;
        return StringsKt.substringBefore$default(StringsKt.substringAfter$default(r6, "[", null, 2, null), "]", null, 2, null);
    L7:
        if (b(r6) == false) goto L10;
        return r6;
    L10:
        return StringsKt.substringBefore$default(r6, ParameterizedMessage.ERROR_MSG_SEPARATOR, null, 2, null);
    }

    public final boolean a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "ip");
        List r7 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
        if (r7.size() == 4) goto L5;
        return false;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L8;
    L10:
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L22;
        Integer r11 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        if (r11 == null) goto L30;
        int r12 = r11.intValue();
        if (r12 >= 0) goto L18;
    L20:
        boolean r13 = false;
    L21:
        if (r13 == true) goto L12;
        return false;
    L18:
        if (r12 >= 256) goto L20;
        r13 = true;
        goto L21
    L30:
        return false;
    L22:
        return true;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean b(String r13) {
        Intrinsics.checkNotNullParameter(r13, "ipv6");
        String r12 = StringsKt.removeSurrounding(r13, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r12, "::") == false) goto L6;
        return true;
    L6:
        if (SequencesKt.count(Regex.findAll$default(new Regex("::"), (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null)) <= 1) goto L9;
        return false;
    L9:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("::", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L31;
        List r14 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"::"}, false, 0, 6, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14.get(0), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L16;
        List r16 = CollectionsKt.emptyList();
    L18:
        if (r14.size() >= 2) goto L20;
    L26:
        List r17 = CollectionsKt.emptyList();
    L28:
        if ((r16.size() + r17.size()) <= 7) goto L30;
        return false;
    L30:
        List r18 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"));
    L34:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L37;
    L39:
        Iterator r110 = r19.iterator();
    L41:
        if (r110.hasNext() == false) goto L94;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin");
        int r0 = r111.length();
        if (1 <= r0) goto L45;
    L47:
        boolean r1 = false;
    L48:
        if (r1 == false) goto L82;
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L51:
        if (r2 >= r112.length()) goto L79;
        char r3 = r112.charAt(r2);
        if ('0' <= r3) goto L55;
    L57:
        boolean r5 = false;
    L58:
        if (r5 == false) goto L60;
    L75:
        boolean r4 = true;
    L76:
        if (r4 == false) goto L77;
        r2 = r2 + 1;
        goto L51
    L77:
        boolean r113 = false;
    L80:
        if (r113 == false) goto L82;
        boolean r114 = true;
    L83:
        if (r114 == true) goto L41;
        return false;
    L60:
        if ('a' <= r3) goto L62;
    L64:
        boolean r6 = false;
    L65:
        if (r6 == true) goto L75;
        if ('A' <= r3) goto L69;
    L71:
        boolean r7 = false;
    L72:
        if (r7 == true) goto L75;
        r4 = false;
        goto L76
    L69:
        if (r3 >= 'G') goto L71;
        r7 = true;
        goto L72
    L62:
        if (r3 >= 'g') goto L64;
        r6 = true;
        goto L65
    L55:
        if (r3 >= ':') goto L57;
        r5 = true;
        goto L58
    L79:
        r113 = true;
    L82:
        r114 = false;
        goto L83
    L45:
        if (r0 >= 5) goto L47;
        r1 = true;
        goto L48
    L94:
        return true;
    L37:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L39;
        return true;
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14.get(1), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L26;
        r17 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r14.get(1), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null);
        goto L28
    L22:
        r8 = false;
        goto L23
    L16:
        r16 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r14.get(0), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null);
        goto L18
    L13:
        r15 = false;
        goto L14
    L31:
        r18 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null);
        if (r18.size() == 8) goto L34;
        return false;
    }

    public final boolean c(String r11) {
        Intrinsics.checkNotNullParameter(r11, "url");
        if (StringsKt.startsWith$default(r11, "http://", false, 2, null) == false) goto L5;
    L23:
        return false;
    L5:
        if (StringsKt.startsWith$default(r11, ReportConsts.HTTPS, false, 2, null) == true) goto L23;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L23;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L23;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L23;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("#", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L23;
        List r10 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
        if (r10.size() != 2) goto L23;
        String r12 = ((String) ZeusTransformUtils.preCheckCast(r10.get(1), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "toLowerCase(...)");
        if (r12.length() > 5) goto L23;
        if (f13190b.contains(r12) == false) goto L23;
        return true;
    }

    public final boolean d(String r6) {
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        e("isLikelyUrl input is empty, result=false");
        return false;
    L10:
        if (StringsKt.startsWith$default(r7, "http://", false, 2, null) == true) goto L25;
        if (StringsKt.startsWith$default(r7, ReportConsts.HTTPS, false, 2, null) == true) goto L25;
        if (d.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).matches() == true) goto L17;
        a(r7, false, "regex mismatch");
        return false;
    L17:
        if (c(r7) == false) goto L21;
        a(r7, false, "file extension false positive");
        return false;
    L21:
        return a(r7, r7);
    L25:
        if (c.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).matches() == true) goto L29;
        a(r7, false, "protocol regex mismatch");
        return false;
    L29:
        return a(r7, r7);
    L5:
        r0 = false;
        goto L6
    }
}
