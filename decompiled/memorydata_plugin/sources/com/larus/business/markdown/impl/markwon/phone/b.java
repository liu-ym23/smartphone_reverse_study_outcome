package com.larus.business.markdown.impl.markwon.phone;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils;", "", "()V", "HOTLINE_5_REGEX", "", "HYBRID_PHONE_REGEX", "SERVICE_5_REGEX", "SERVICE_6_REGEX", "SERVICE_REGEX", "customPattern", "Ljava/util/regex/Pattern;", "hybridPattern", "getAllPhoneInfo", "", "Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils$PhoneInfo;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "phoneRegex", "getCustomRegexPattern", "getDefaultRegexPattern", "PhoneInfo", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Pattern f5264b;
    private static Pattern c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils$PhoneInfo;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "phoneNumber", "", "(IILjava/lang/String;)V", "getEnd", "()I", "getPhoneNumber", "()Ljava/lang/String;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5266b;
        private final String c;

        public a(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "phoneNumber");
            this.f5265a = r2;
            this.f5266b = r3;
            this.c = r4;
        }

        public final int a() {
            return this.f5265a;
        }

        public final int b() {
            return this.f5266b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f5265a == r6.f5265a) goto L12;
            return false;
        L12:
            if (this.f5266b == r6.f5266b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f5265a) * 31) + Integer.hashCode(this.f5266b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "PhoneInfo(start=" + this.f5265a + ", end=" + this.f5266b + ", phoneNumber=" + this.c + ')';
        }
    }

    static {
        f5263a = new b();
    }

    private b() {
    }

    @JvmStatic
    private static final Pattern a() {
        Pattern r0 = f5264b;
        if (r0 != null) goto L6;
        Pattern r1 = Pattern.compile("(?<![\\d.])((?:(?:\\+86|86)[- ]?)?1[3-9][0-9][- ]?\\d{4}[- ]?\\d{4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?\\d{7,8}|(?:400|800)[- ]?\\d{3,4}[- ]?\\d{3,4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?(?:(?:1[0-3]\\d{3})|(?:9(?:[5,6]\\d{3}))|(?:1(?:2\\d{4}|\\d{5})|9(?:[5,6]\\d{4})|100\\d{3}))|\\+\\d{1,3}[- ]?(?:\\(\\d{1,5}\\)|\\d{1,5})[- ]?\\d{1,4}[- ]?\\d{3,5})(?![\\d.])");
        f5264b = r1;
        Intrinsics.checkNotNullExpressionValue(r1, "run {\n            val pa…        pattern\n        }");
        return r1;
    L6:
        return r0;
    }

    private final Pattern a(String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Pattern r2 = c;
        if (r2 != null) goto L16;
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        Pattern r5 = Pattern.compile(r3);
        c = r5;
        return r5;
    L16:
        return r2;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final List<a> a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Pattern r4 = a(r6);
        if (r4 != null) goto L5;
        r4 = a();
    L5:
        Matcher r7 = r4.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        List<a> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L7:
        if (r7.find() == false) goto L9;
        int r0 = r7.start();
        int r1 = r7.end();
        String r2 = r7.group();
        Intrinsics.checkNotNullExpressionValue(r2, "matcher.group()");
        r8.add(new a(r0, r1, r2));
        goto L7
    L9:
        return r8;
    }
}
