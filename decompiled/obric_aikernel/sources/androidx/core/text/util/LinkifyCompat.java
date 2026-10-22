package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import com.bytedance.apm6.util.constant.ReportConsts;
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

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void addLinks(TextView r10, Pattern r11, String r12, String[] r13, Linkify.MatchFilter r14, Linkify.TransformFilter r15) {
            Linkify.addLinks(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        static boolean addLinks(Spannable r10, Pattern r11, String r12, String[] r13, Linkify.MatchFilter r14, Linkify.TransformFilter r15) {
            return Linkify.addLinks(r10, r11, r12, r13, r14, r15);
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = a.f338c;
    }

    private LinkifyCompat() {
    }

    public static /* synthetic */ int a(LinkSpec r10, LinkSpec r11) {
        return lambda$static$0(r10, r11);
    }

    private static void addLinkMovementMethod(@NonNull TextView r10) {
        if ((r10.getMovementMethod() instanceof LinkMovementMethod) == false) goto L5;
        return;
    L5:
        if (r10.getLinksClickable() == false) goto L9;
        r10.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public static void addLinks(@NonNull TextView r10, @NonNull Pattern r11, @Nullable String r12) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r10, r11, r12);
        return;
    L6:
        addLinks(r10, r11, r12, null, null, null);
    }

    public static void addLinks(@NonNull TextView r10, @NonNull Pattern r11, @Nullable String r12, @Nullable Linkify.MatchFilter r13, @Nullable Linkify.TransformFilter r14) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r10, r11, r12, r13, r14);
        return;
    L6:
        addLinks(r10, r11, r12, null, r13, r14);
    }

    public static void addLinks(@NonNull TextView r10, @NonNull Pattern r11, @Nullable String r12, @Nullable String[] r13, @Nullable Linkify.MatchFilter r14, @Nullable Linkify.TransformFilter r15) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Api24Impl.addLinks(r10, r11, r12, r13, r14, r15);
        return;
    L6:
        SpannableString r16 = SpannableString.valueOf(r10.getText());
        if (addLinks(r16, r11, r12, r13, r14, r15) == false) goto L10;
        r10.setText(r16);
        addLinkMovementMethod(r10);
        return;
    }

    public static boolean addLinks(@NonNull Spannable r10, int r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11);
    L7:
        if (r11 != 0) goto L9;
        return false;
    L9:
        URLSpan[] r12 = (URLSpan[]) r10.getSpans(0, r10.length(), URLSpan.class);
        int r13 = r12.length - 1;
    L10:
        if (r13 < 0) goto L13;
        r10.removeSpan(r12[r13]);
        r13 = r13 - 1;
        goto L10
    L13:
        if ((r11 & 4) == 0) goto L15;
        Linkify.addLinks(r10, 4);
    L15:
        ArrayList r14 = new ArrayList();
        if ((r11 & 1) == 0) goto L19;
        gatherLinks(r14, r10, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", ReportConsts.HTTPS, "rtsp://"}, Linkify.sUrlMatchFilter, null);
    L19:
        if ((r11 & 2) == 0) goto L22;
        gatherLinks(r14, r10, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
    L22:
        if ((r11 & 8) == 0) goto L24;
        gatherMapLinks(r14, r10);
    L24:
        pruneOverlaps(r14, r10);
        if (r14.size() != 0) goto L27;
        return false;
    L27:
        Iterator r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L33;
        LinkSpec r16 = (LinkSpec) r15.next();
        if (r16.frameworkAddedSpan != null) goto L29;
        applyLink(r16.url, r16.start, r16.end, r10);
        goto L29
    L33:
        return true;
    }

    public static boolean addLinks(@NonNull Spannable r10, @NonNull Pattern r11, @Nullable String r12) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11, r12);
    L7:
        return addLinks(r10, r11, r12, null, null, null);
    }

    public static boolean addLinks(@NonNull Spannable r10, @NonNull Pattern r11, @Nullable String r12, @Nullable Linkify.MatchFilter r13, @Nullable Linkify.TransformFilter r14) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11, r12, r13, r14);
    L7:
        return addLinks(r10, r11, r12, null, r13, r14);
    }

    public static boolean addLinks(@NonNull Spannable r10, @NonNull Pattern r11, @Nullable String r12, @Nullable String[] r13, @Nullable Linkify.MatchFilter r14, @Nullable Linkify.TransformFilter r15) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Api24Impl.addLinks(r10, r11, r12, r13, r14, r15);
    L7:
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        if (r13 != null) goto L12;
    L13:
        r13 = EMPTY_STRING;
    L14:
        String[] r16 = new String[r13.length + 1];
        r16[0] = r12.toLowerCase(Locale.ROOT);
        int r17 = 0;
    L16:
        if (r17 >= r13.length) goto L22;
        String r18 = r13[r17];
        r17 = r17 + 1;
        if (r18 != null) goto L20;
        String r19 = "";
    L21:
        r16[r17] = r19;
        goto L16
    L20:
        r19 = r18.toLowerCase(Locale.ROOT);
        goto L21
    L22:
        Matcher r20 = r11.matcher(r10);
        boolean r21 = false;
    L24:
        if (r20.find() == false) goto L32;
        int r22 = r20.start();
        int r23 = r20.end();
        String r24 = r20.group(0);
        if (r14 == null) goto L28;
        boolean r25 = r14.acceptMatch(r10, r22, r23);
    L29:
        if (r25 == false) goto L24;
        if (r24 == null) goto L24;
        applyLink(makeUrl(r24, r16, r20, r15), r22, r23, r10);
        r21 = true;
        goto L24
    L28:
        r25 = true;
        goto L29
    L32:
        return r21;
    L12:
        if (r13.length >= 1) goto L14;
        goto L13
    }

    public static boolean addLinks(@NonNull TextView r10, int r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11);
    L7:
        if (r11 != 0) goto L9;
        return false;
    L9:
        CharSequence r12 = r10.getText();
        if ((r12 instanceof Spannable) == true) goto L12;
        SpannableString r13 = SpannableString.valueOf(r12);
        if (addLinks(r13, r11) == false) goto L19;
        addLinkMovementMethod(r10);
        r10.setText(r13);
        return true;
    L19:
        return false;
    L12:
        if (addLinks((Spannable) r12, r11) == false) goto L19;
        addLinkMovementMethod(r10);
        return true;
    }

    private static void applyLink(String r10, int r11, int r12, Spannable r13) {
        r13.setSpan(new URLSpan(r10), r11, r12, 33);
    }

    private static String findAddress(String r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return WebView.findAddress(r10);
    L7:
        return FindAddress.findAddress(r10);
    }

    private static void gatherLinks(ArrayList<LinkSpec> r10, Spannable r11, Pattern r12, String[] r13, Linkify.MatchFilter r14, Linkify.TransformFilter r15) {
        Matcher r16 = r12.matcher(r11);
    L4:
        if (r16.find() == false) goto L11;
        int r17 = r16.start();
        int r18 = r16.end();
        String r19 = r16.group(0);
        if (r14 == null) goto L9;
        if (r14.acceptMatch(r11, r17, r18) == false) goto L4;
    L9:
        if (r19 == null) goto L4;
        LinkSpec r20 = new LinkSpec();
        r20.url = makeUrl(r19, r13, r16, r15);
        r20.start = r17;
        r20.end = r18;
        r10.add(r20);
        goto L4
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> r10, Spannable r11) {
        String r12 = r11.toString();
        int r13 = 0;
    L15:
        String r14 = findAddress(r12);     // Catch: UnsupportedOperationException -> L14
        if (r14 == null) goto L25;
        int r15 = r12.indexOf(r14);     // Catch: UnsupportedOperationException -> L14
        if (r15 < 0) goto L12;
        LinkSpec r16 = new LinkSpec();     // Catch: UnsupportedOperationException -> L14
        int r17 = r14.length() + r15;     // Catch: UnsupportedOperationException -> L14
        r16.start = r15 + r13;     // Catch: UnsupportedOperationException -> L14
        r13 = r13 + r17;     // Catch: UnsupportedOperationException -> L14
        r16.end = r13;     // Catch: UnsupportedOperationException -> L14
        r12 = r12.substring(r17);     // Catch: UnsupportedOperationException -> L14
        r16.url = "geo:0,0?q=" + URLEncoder.encode(r14, "UTF-8");     // Catch: UnsupportedOperationException -> L14
        r10.add(r16);     // Catch: UnsupportedOperationException -> L14
    L12:
        return;
    L25:
        return;
    }

    private static /* synthetic */ int lambda$static$0(LinkSpec r10, LinkSpec r11) {
        int r12 = r10.start;
        int r13 = r11.start;
        if (r12 >= r13) goto L6;
        return -1;
    L6:
        if (r12 <= r13) goto L10;
        return 1;
    L10:
        return Integer.compare(r11.end, r10.end);
    }

    private static String makeUrl(@NonNull String r10, @NonNull String[] r11, Matcher r12, @Nullable Linkify.TransformFilter r13) {
        if (r13 == null) goto L4;
        r10 = r13.transformUrl(r12, r10);
    L4:
        int r14 = r11.length;
        int r15 = 0;
    L5:
        boolean r16 = true;
        if (r15 >= r14) goto L13;
        String r17 = r11[r15];
        if (r10.regionMatches(true, 0, r17, 0, r17.length()) == true) goto L10;
        r15 = r15 + 1;
        goto L5
    L10:
        if (r10.regionMatches(false, 0, r17, 0, r17.length()) == true) goto L14;
        r10 = r17 + r10.substring(r17.length());
    L14:
        if (r16 == false) goto L16;
        return r10;
    L16:
        if (r11.length > 0) goto L18;
        return r10;
    L18:
        return r11[0] + r10;
    L13:
        r16 = false;
        goto L14
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r10, Spannable r11) {
        int r12 = 0;
        URLSpan[] r13 = (URLSpan[]) r11.getSpans(0, r11.length(), URLSpan.class);
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        URLSpan r16 = r13[r15];
        LinkSpec r17 = new LinkSpec();
        r17.frameworkAddedSpan = r16;
        r17.start = r11.getSpanStart(r16);
        r17.end = r11.getSpanEnd(r16);
        r10.add(r17);
        r15 = r15 + 1;
        goto L3
    L5:
        Collections.sort(r10, COMPARATOR);
        int r18 = r10.size();
    L7:
        if (r12 >= (r18 - 1)) goto L28;
        LinkSpec r19 = r10.get(r12);
        int r20 = r12 + 1;
        LinkSpec r21 = r10.get(r20);
        int r22 = r19.start;
        int r23 = r21.start;
        if (r22 > r23) goto L27;
        int r24 = r19.end;
        if (r24 <= r23) goto L27;
        int r25 = r21.end;
        if (r25 > r24) goto L16;
    L14:
        int r26 = r20;
    L22:
        if (r26 == (-1)) goto L27;
        Object r27 = r10.get(r26).frameworkAddedSpan;
        if (r27 == null) goto L26;
        r11.removeSpan(r27);
    L26:
        r10.remove(r26);
        r18 = r18 - 1;
        goto L7
    L16:
        if ((r24 - r22) > (r25 - r23)) goto L14;
        if ((r24 - r22) >= (r25 - r23)) goto L21;
        r26 = r12;
        goto L22
    L21:
        r26 = -1;
    L27:
        r12 = r20;
        goto L7
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }
}
