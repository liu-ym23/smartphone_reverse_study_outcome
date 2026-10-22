package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = null;
    private static final String[] EMPTY_STRING = null;

    static class Api24Impl {
        private Api24Impl() {
        }

        static void addLinks(TextView r8, Pattern r9, String r10, String[] r11, Linkify.MatchFilter r12, Linkify.TransformFilter r13) {
            Linkify.addLinks(r8, r9, r10, r11, (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.MatchFilter.class, "com.obric.memorydata.plugin"), (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r13, Linkify.TransformFilter.class, "com.obric.memorydata.plugin"));
        }

        static boolean addLinks(Spannable r8, Pattern r9, String r10, String[] r11, Linkify.MatchFilter r12, Linkify.TransformFilter r13) {
            return Linkify.addLinks((Spannable) ZeusTransformUtils.wrapperContextForParams(r8, Spannable.class, "com.obric.memorydata.plugin"), r9, r10, r11, (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.MatchFilter.class, "com.obric.memorydata.plugin"), (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r13, Linkify.TransformFilter.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = $$Lambda$LinkifyCompat$ZKIVpYQfVVlE_POSX3ZpOQbt6w.INSTANCE;
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(TextView r2) {
        if (ZeusTransformUtils.instanceOf(r2.getMovementMethod(), LinkMovementMethod.class) == false) goto L5;
        return;
    L5:
        if (r2.getLinksClickable() == false) goto L9;
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public static void addLinks(TextView r7, Pattern r8, String r9) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r7, r8, r9);
        return;
    L6:
        addLinks(r7, r8, r9, null, null, null);
    }

    public static void addLinks(TextView r8, Pattern r9, String r10, Linkify.MatchFilter r11, Linkify.TransformFilter r12) {
        Linkify.MatchFilter r6 = (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r11, Linkify.MatchFilter.class, "com.obric.memorydata.plugin");
        Linkify.TransformFilter r7 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r8, r9, r10, r6, r7);
        return;
    L6:
        addLinks(r8, r9, r10, null, r6, r7);
    }

    public static void addLinks(TextView r8, Pattern r9, String r10, String[] r11, Linkify.MatchFilter r12, Linkify.TransformFilter r13) {
        Linkify.MatchFilter r6 = (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.MatchFilter.class, "com.obric.memorydata.plugin");
        Linkify.TransformFilter r7 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r13, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Api24Impl.addLinks(r8, r9, r10, r11, r6, r7);
        return;
    L6:
        SpannableString r14 = SpannableString.valueOf(r8.getText());
        if (addLinks(r14, r9, r10, r11, r6, r7) == false) goto L10;
        r8.setText(r14);
        addLinkMovementMethod(r8);
        return;
    }

    public static boolean addLinks(Spannable r10, int r11) {
        Spannable r12 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r10, Spannable.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r12, r11);
    L7:
        if (r11 != 0) goto L9;
        return false;
    L9:
        URLSpan[] r2 = (URLSpan[]) ZeusTransformUtils.preCheckCast(r12.getSpans(0, r12.length(), URLSpan.class), URLSpan[].class, "com.obric.memorydata.plugin");
        int r3 = r2.length - 1;
    L10:
        if (r3 < 0) goto L13;
        r12.removeSpan(r2[r3]);
        r3 = r3 - 1;
        goto L10
    L13:
        if ((r11 & 4) == 0) goto L15;
        Linkify.addLinks(r12, 4);
    L15:
        ArrayList r9 = new ArrayList();
        if ((r11 & 1) == 0) goto L19;
        gatherLinks(r9, r12, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", ReportConsts.HTTPS, "rtsp://"}, Linkify.sUrlMatchFilter, null);
    L19:
        if ((r11 & 2) == 0) goto L22;
        gatherLinks(r9, r12, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
    L22:
        if ((r11 & 8) == 0) goto L24;
        gatherMapLinks(r9, r12);
    L24:
        pruneOverlaps(r9, r12);
        if (r9.size() != 0) goto L27;
        return false;
    L27:
        Iterator r13 = r9.iterator();
    L29:
        if (r13.hasNext() == false) goto L33;
        LinkSpec r0 = (LinkSpec) ZeusTransformUtils.preCheckCast(r13.next(), LinkSpec.class, "com.obric.memorydata.plugin");
        if (r0.frameworkAddedSpan != null) goto L29;
        applyLink(r0.url, r0.start, r0.end, r12);
        goto L29
    L33:
        return true;
    }

    public static boolean addLinks(Spannable r6, Pattern r7, String r8) {
        Spannable r0 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r6, Spannable.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r0, r7, r8);
    L7:
        return addLinks(r0, r7, r8, null, null, null);
    }

    public static boolean addLinks(Spannable r8, Pattern r9, String r10, Linkify.MatchFilter r11, Linkify.TransformFilter r12) {
        Spannable r2 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r8, Spannable.class, "com.obric.memorydata.plugin");
        Linkify.MatchFilter r6 = (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r11, Linkify.MatchFilter.class, "com.obric.memorydata.plugin");
        Linkify.TransformFilter r7 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r2, r9, r10, r6, r7);
    L7:
        return addLinks(r2, r9, r10, null, r6, r7);
    }

    public static boolean addLinks(Spannable r8, Pattern r9, String r10, String[] r11, Linkify.MatchFilter r12, Linkify.TransformFilter r13) {
        Spannable r2 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r8, Spannable.class, "com.obric.memorydata.plugin");
        Linkify.MatchFilter r6 = (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.MatchFilter.class, "com.obric.memorydata.plugin");
        Linkify.TransformFilter r7 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r13, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Api24Impl.addLinks(r2, r9, r10, r11, r6, r7);
    L7:
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        if (r11 != null) goto L12;
    L13:
        r11 = EMPTY_STRING;
    L14:
        String[] r14 = new String[r11.length + 1];
        r14[0] = r10.toLowerCase(Locale.ROOT);
        int r15 = 0;
    L16:
        if (r15 >= r11.length) goto L22;
        String r1 = r11[r15];
        r15 = r15 + 1;
        if (r1 != null) goto L20;
        String r3 = "";
    L21:
        r14[r15] = r3;
        goto L16
    L20:
        r3 = r1.toLowerCase(Locale.ROOT);
        goto L21
    L22:
        Matcher r16 = r9.matcher(r2);
        boolean r17 = false;
    L24:
        if (r16.find() == false) goto L32;
        int r18 = r16.start();
        int r19 = r16.end();
        String r4 = r16.group(0);
        if (r6 == null) goto L28;
        boolean r5 = r6.acceptMatch(r2, r18, r19);
    L29:
        if (r5 == false) goto L24;
        if (r4 == null) goto L24;
        applyLink(makeUrl(r4, r14, r16, r7), r18, r19, r2);
        r17 = true;
        goto L24
    L28:
        r5 = true;
        goto L29
    L32:
        return r17;
    L12:
        if (r11.length >= 1) goto L14;
        goto L13
    }

    public static boolean addLinks(TextView r5, int r6) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r5, r6);
    L7:
        if (r6 != 0) goto L9;
        return false;
    L9:
        CharSequence r1 = r5.getText();
        if (ZeusTransformUtils.instanceOf(r1, Spannable.class) == true) goto L12;
        SpannableString r2 = SpannableString.valueOf(r1);
        if (addLinks(r2, r6) == false) goto L19;
        addLinkMovementMethod(r5);
        r5.setText(r2);
        return true;
    L19:
        return false;
    L12:
        if (addLinks((Spannable) ZeusTransformUtils.preCheckCast(r1, Spannable.class, "com.obric.memorydata.plugin"), r6) == false) goto L19;
        addLinkMovementMethod(r5);
        return true;
    }

    private static void applyLink(String r2, int r3, int r4, Spannable r5) {
        ((Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.memorydata.plugin")).setSpan(new URLSpan(r2), r3, r4, 33);
    }

    private static String findAddress(String r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return WebView.findAddress(r2);
    L7:
        return FindAddress.findAddress(r2);
    }

    private static void gatherLinks(ArrayList<LinkSpec> r4, Spannable r5, Pattern r6, String[] r7, Linkify.MatchFilter r8, Linkify.TransformFilter r9) {
        Spannable r10 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.memorydata.plugin");
        Linkify.MatchFilter r11 = (Linkify.MatchFilter) ZeusTransformUtils.wrapperContextForParams(r8, Linkify.MatchFilter.class, "com.obric.memorydata.plugin");
        Linkify.TransformFilter r12 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r9, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        Matcher r13 = r6.matcher(r10);
    L4:
        if (r13.find() == false) goto L11;
        int r0 = r13.start();
        int r1 = r13.end();
        String r2 = r13.group(0);
        if (r11 == null) goto L9;
        if (r11.acceptMatch(r10, r0, r1) == false) goto L4;
    L9:
        if (r2 == null) goto L4;
        LinkSpec r3 = new LinkSpec();
        r3.url = makeUrl(r2, r7, r13, r12);
        r3.start = r0;
        r3.end = r1;
        r4.add(r3);
        goto L4
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> r5, Spannable r6) {
        String r7 = ((Spannable) ZeusTransformUtils.wrapperContextForParams(r6, Spannable.class, "com.obric.memorydata.plugin")).toString();
        int r0 = 0;
    L15:
        String r1 = findAddress(r7);     // Catch: UnsupportedOperationException -> L14
        if (r1 == null) goto L25;
        int r2 = r7.indexOf(r1);     // Catch: UnsupportedOperationException -> L14
        if (r2 < 0) goto L12;
        LinkSpec r3 = new LinkSpec();     // Catch: UnsupportedOperationException -> L14
        int r4 = r1.length() + r2;     // Catch: UnsupportedOperationException -> L14
        r3.start = r2 + r0;     // Catch: UnsupportedOperationException -> L14
        r0 = r0 + r4;     // Catch: UnsupportedOperationException -> L14
        r3.end = r0;     // Catch: UnsupportedOperationException -> L14
        r7 = r7.substring(r4);     // Catch: UnsupportedOperationException -> L14
        r3.url = "geo:0,0?q=" + URLEncoder.encode(r1, RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedOperationException -> L14
        r5.add(r3);     // Catch: UnsupportedOperationException -> L14
    L12:
        return;
    L25:
        return;
    }

    static /* synthetic */ int lambda$static$0(LinkSpec r2, LinkSpec r3) {
        if (r2.start >= r3.start) goto L7;
        return -1;
    L7:
        if (r2.start <= r3.start) goto L11;
        return 1;
    L11:
        return Integer.compare(r3.end, r2.end);
    }

    private static String makeUrl(String r9, String[] r10, Matcher r11, Linkify.TransformFilter r12) {
        Linkify.TransformFilter r13 = (Linkify.TransformFilter) ZeusTransformUtils.wrapperContextForParams(r12, Linkify.TransformFilter.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L5;
        r9 = r13.transformUrl(r11, r9);
    L5:
        int r14 = r10.length;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r6 >= r14) goto L14;
        String r8 = r10[r6];
        if (r9.regionMatches(true, 0, r8, 0, r8.length()) == true) goto L11;
        r6 = r6 + 1;
        goto L6
    L11:
        if (r9.regionMatches(false, 0, r8, 0, r8.length()) == true) goto L15;
        r9 = r8 + r9.substring(r8.length());
    L15:
        if (r7 == false) goto L17;
        return r9;
    L17:
        if (r10.length > 0) goto L19;
        return r9;
    L19:
        return r10[0] + r9;
    L14:
        r7 = false;
        goto L15
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r10, Spannable r11) {
        Spannable r12 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r11, Spannable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        URLSpan[] r0 = (URLSpan[]) ZeusTransformUtils.preCheckCast(r12.getSpans(0, r12.length(), URLSpan.class), URLSpan[].class, "com.obric.memorydata.plugin");
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        URLSpan r5 = r0[r4];
        LinkSpec r6 = new LinkSpec();
        r6.frameworkAddedSpan = r5;
        r6.start = r12.getSpanStart(r5);
        r6.end = r12.getSpanEnd(r5);
        r10.add(r6);
        r4 = r4 + 1;
        goto L3
    L5:
        Collections.sort(r10, COMPARATOR);
        int r1 = r10.size();
    L7:
        if (r3 >= (r1 - 1)) goto L28;
        LinkSpec r7 = (LinkSpec) ZeusTransformUtils.preCheckCast(r10.get(r3), LinkSpec.class, "com.obric.memorydata.plugin");
        int r8 = r3 + 1;
        LinkSpec r9 = (LinkSpec) ZeusTransformUtils.preCheckCast(r10.get(r8), LinkSpec.class, "com.obric.memorydata.plugin");
        if (r7.start > r9.start) goto L27;
        if (r7.end <= r9.start) goto L27;
        if (r9.end > r7.end) goto L16;
    L14:
        int r13 = r8;
    L22:
        if (r13 == (-1)) goto L27;
        URLSpan r14 = ((LinkSpec) ZeusTransformUtils.preCheckCast(r10.get(r13), LinkSpec.class, "com.obric.memorydata.plugin")).frameworkAddedSpan;
        if (r14 == null) goto L26;
        r12.removeSpan(r14);
    L26:
        r10.remove(r13);
        r1 = r1 - 1;
        goto L7
    L16:
        if ((r7.end - r7.start) > (r9.end - r9.start)) goto L14;
        if ((r7.end - r7.start) >= (r9.end - r9.start)) goto L21;
        r13 = r3;
        goto L22
    L21:
        r13 = -1;
    L27:
        r3 = r8;
        goto L7
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }
}
