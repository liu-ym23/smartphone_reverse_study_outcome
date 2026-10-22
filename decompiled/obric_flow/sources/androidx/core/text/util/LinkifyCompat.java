package androidx.core.text.util;

import ai.j0;
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
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void addLinks(TextView r5, Pattern r10, String r11, String[] r12, Linkify.MatchFilter r13, Linkify.TransformFilter r14) {
            Linkify.addLinks(r5, r10, r11, r12, r13, r14);
        }

        @DoNotInline
        public static boolean addLinks(Spannable r5, Pattern r10, String r11, String[] r12, Linkify.MatchFilter r13, Linkify.TransformFilter r14) {
            return Linkify.addLinks(r5, r10, r11, r12, r13, r14);
        }
    }

    public static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        public LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new a();
    }

    private LinkifyCompat() {
    }

    public static /* synthetic */ int a(LinkSpec r5, LinkSpec r10) {
        return lambda$static$0(r5, r10);
    }

    private static void addLinkMovementMethod(@NonNull TextView r5) {
        if ((r5.getMovementMethod() instanceof LinkMovementMethod) == false) goto L5;
        return;
    L5:
        if (r5.getLinksClickable() == false) goto L9;
        r5.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public static boolean addLinks(@NonNull Spannable r10, int r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11);
    L7:
        if (r11 != 0) goto L9;
        return false;
    L9:
        URLSpan[] r5 = (URLSpan[]) r10.getSpans(0, r10.length(), URLSpan.class);
        int r12 = r5.length - 1;
    L10:
        if (r12 < 0) goto L13;
        r10.removeSpan(r5[r12]);
        r12 = r12 - 1;
        goto L10
    L13:
        if ((r11 & 4) == 0) goto L15;
        Linkify.addLinks(r10, 4);
    L15:
        ArrayList r13 = new ArrayList();
        if ((r11 & 1) == 0) goto L19;
        gatherLinks(r13, r10, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
    L19:
        if ((r11 & 2) == 0) goto L22;
        gatherLinks(r13, r10, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
    L22:
        if ((r11 & 8) == 0) goto L24;
        gatherMapLinks(r13, r10);
    L24:
        pruneOverlaps(r13, r10);
        if (r13.size() != 0) goto L27;
        return false;
    L27:
        Iterator r14 = r13.iterator();
    L29:
        if (r14.hasNext() == false) goto L33;
        LinkSpec r15 = (LinkSpec) r14.next();
        if (r15.frameworkAddedSpan != null) goto L29;
        applyLink(r15.url, r15.start, r15.end, r10);
        goto L29
    L33:
        return true;
    }

    private static void applyLink(String r5, int r10, int r11, Spannable r12) {
        r12.setSpan(new URLSpan(r5), r10, r11, 33);
    }

    private static String findAddress(String r5) {
        return WebView.findAddress(r5);
    }

    private static void gatherLinks(ArrayList<LinkSpec> r5, Spannable r10, Pattern r11, String[] r12, Linkify.MatchFilter r13, Linkify.TransformFilter r14) {
        Matcher r15 = r11.matcher(r10);
    L4:
        if (r15.find() == false) goto L11;
        int r16 = r15.start();
        int r17 = r15.end();
        String r18 = r15.group(0);
        if (r13 == null) goto L9;
        if (r13.acceptMatch(r10, r16, r17) == false) goto L4;
    L9:
        if (r18 == null) goto L4;
        LinkSpec r19 = new LinkSpec();
        r19.url = makeUrl(r18, r12, r15, r14);
        r19.start = r16;
        r19.end = r17;
        r5.add(r19);
        goto L4
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> r5, Spannable r10) {
        String r11 = r10.toString();
        int r12 = 0;
    L15:
        String r13 = findAddress(r11);     // Catch: UnsupportedOperationException -> L14
        if (r13 == null) goto L25;
        int r14 = r11.indexOf(r13);     // Catch: UnsupportedOperationException -> L14
        if (r14 < 0) goto L12;
        LinkSpec r15 = new LinkSpec();     // Catch: UnsupportedOperationException -> L14
        int r16 = r13.length() + r14;     // Catch: UnsupportedOperationException -> L14
        r15.start = r14 + r12;     // Catch: UnsupportedOperationException -> L14
        r12 = r12 + r16;     // Catch: UnsupportedOperationException -> L14
        r15.end = r12;     // Catch: UnsupportedOperationException -> L14
        r11 = r11.substring(r16);     // Catch: UnsupportedOperationException -> L14
        r15.url = "geo:0,0?q=" + URLEncoder.encode(r13, "UTF-8");     // Catch: UnsupportedOperationException -> L14
        r5.add(r15);     // Catch: UnsupportedOperationException -> L14
    L12:
        return;
    L25:
        return;
    }

    private static /* synthetic */ int lambda$static$0(LinkSpec r5, LinkSpec r10) {
        int r11 = r5.start;
        int r12 = r10.start;
        if (r11 >= r12) goto L6;
        return -1;
    L6:
        if (r11 <= r12) goto L10;
        return 1;
    L10:
        return Integer.compare(r10.end, r5.end);
    }

    private static String makeUrl(@NonNull String r10, @NonNull String[] r11, Matcher r12, @Nullable Linkify.TransformFilter r13) {
        if (r13 == null) goto L4;
        r10 = r13.transformUrl(r12, r10);
    L4:
        int r14 = r11.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L12;
        String r16 = r11[r15];
        if (r10.regionMatches(true, 0, r16, 0, r16.length()) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        boolean r5 = true;
        if (r10.regionMatches(false, 0, r16, 0, r16.length()) == true) goto L13;
        StringBuilder r17 = j0.u(r16);
        r17.append(r10.substring(r16.length()));
        r10 = r17.toString();
    L13:
        if (r5 == false) goto L15;
        return r10;
    L15:
        if (r11.length > 0) goto L17;
        return r10;
    L17:
        return j0.q(new StringBuilder(), r11[0], r10);
    L12:
        r5 = false;
        goto L13
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r10, Spannable r11) {
        int r5 = 0;
        URLSpan[] r12 = (URLSpan[]) r11.getSpans(0, r11.length(), URLSpan.class);
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        URLSpan r15 = r12[r14];
        LinkSpec r16 = new LinkSpec();
        r16.frameworkAddedSpan = r15;
        r16.start = r11.getSpanStart(r15);
        r16.end = r11.getSpanEnd(r15);
        r10.add(r16);
        r14 = r14 + 1;
        goto L3
    L5:
        Collections.sort(r10, COMPARATOR);
        int r17 = r10.size();
    L7:
        if (r5 >= (r17 - 1)) goto L28;
        LinkSpec r18 = r10.get(r5);
        int r19 = r5 + 1;
        LinkSpec r20 = r10.get(r19);
        int r21 = r18.start;
        int r22 = r20.start;
        if (r21 > r22) goto L27;
        int r23 = r18.end;
        if (r23 <= r22) goto L27;
        int r24 = r20.end;
        if (r24 > r23) goto L16;
    L14:
        int r25 = r19;
    L22:
        if (r25 == (-1)) goto L27;
        Object r26 = r10.get(r25).frameworkAddedSpan;
        if (r26 == null) goto L26;
        r11.removeSpan(r26);
    L26:
        r10.remove(r25);
        r17 = r17 - 1;
        goto L7
    L16:
        if ((r23 - r21) > (r24 - r22)) goto L14;
        if ((r23 - r21) >= (r24 - r22)) goto L21;
        r25 = r5;
        goto L22
    L21:
        r25 = -1;
    L27:
        r5 = r19;
        goto L7
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return true;
    }

    public static boolean addLinks(@NonNull TextView r5, int r10) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r5, r10);
    L7:
        if (r10 != 0) goto L9;
        return false;
    L9:
        CharSequence r11 = r5.getText();
        if ((r11 instanceof Spannable) == true) goto L12;
        SpannableString r12 = SpannableString.valueOf(r11);
        if (addLinks(r12, r10) == false) goto L19;
        addLinkMovementMethod(r5);
        r5.setText(r12);
        return true;
    L19:
        return false;
    L12:
        if (addLinks((Spannable) r11, r10) == false) goto L19;
        addLinkMovementMethod(r5);
        return true;
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
        SpannableString r5 = SpannableString.valueOf(r10.getText());
        if (addLinks(r5, r11, r12, r13, r14, r15) == false) goto L10;
        r10.setText(r5);
        addLinkMovementMethod(r10);
        return;
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
        String[] r5 = new String[r13.length + 1];
        r5[0] = r12.toLowerCase(Locale.ROOT);
        int r16 = 0;
    L16:
        if (r16 >= r13.length) goto L22;
        String r17 = r13[r16];
        r16 = r16 + 1;
        if (r17 != null) goto L20;
        String r18 = "";
    L21:
        r5[r16] = r18;
        goto L16
    L20:
        r18 = r17.toLowerCase(Locale.ROOT);
        goto L21
    L22:
        Matcher r19 = r11.matcher(r10);
        boolean r20 = false;
    L24:
        if (r19.find() == false) goto L32;
        int r21 = r19.start();
        int r22 = r19.end();
        String r23 = r19.group(0);
        if (r14 == null) goto L28;
        boolean r24 = r14.acceptMatch(r10, r21, r22);
    L29:
        if (r24 == false) goto L24;
        if (r23 == null) goto L24;
        applyLink(makeUrl(r23, r5, r19, r15), r21, r22, r10);
        r20 = true;
        goto L24
    L28:
        r24 = true;
        goto L29
    L32:
        return r20;
    L12:
        if (r13.length >= 1) goto L14;
        goto L13
    }
}
