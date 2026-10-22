package androidx.room.ext;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\bH\u0002\u001a\u0012\u0010\t\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\bH\u0002\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0003\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\f\u0010\f\u001a\u00020\u0003*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"javaCharRegex", "Lkotlin/text/Regex;", "capitalize", "", "locale", "Ljava/util/Locale;", "decapitalize", "joinToCamelCase", "", "joinToCamelCaseAsVar", "stripNonJava", "toCamelCase", "toCamelCaseAsVar", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class String_extKt {
    private static final Regex javaCharRegex = null;

    static {
        javaCharRegex = new Regex("[^a-zA-Z0-9]");
    }

    public static final /* synthetic */ String access$toCamelCase(String r5) {
        return toCamelCase(r5);
    }

    public static final String capitalize(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        if (Character.isLowerCase(r5.charAt(0)) == true) goto L7;
        return r5;
    L7:
        return j0.j(r5.substring(0, 1).toUpperCase(r10), r5.substring(1));
    }

    public static final String decapitalize(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        if (Character.isUpperCase(r5.charAt(0)) == true) goto L7;
        return r5;
    L7:
        return j0.j(r5.substring(0, 1).toLowerCase(r10), r5.substring(1));
    }

    private static final String joinToCamelCase(List<String> r10) {
        int r5 = r10.size();
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L8;
        return CollectionsKt.q(r10, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30);
    L8:
        return toCamelCase(r10.get(0));
    L10:
        throw new IllegalArgumentException("invalid section size, cannot be zero");
    }

    private static final String joinToCamelCaseAsVar(List<String> r5) {
        int r10 = r5.size();
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return j0.j(toCamelCaseAsVar(r5.get(0)), joinToCamelCase(CollectionsKt.i(r5, 1)));
    L8:
        return toCamelCaseAsVar(r5.get(0));
    L10:
        throw new IllegalArgumentException("invalid section size, cannot be zero");
    }

    public static final String stripNonJava(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<String> r10 = javaCharRegex.split(r5, 0);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.add(StringsKt.trim((String) r12.next()).toString());
        goto L4
    L7:
        return joinToCamelCaseAsVar(r11);
    }

    private static final String toCamelCase(String r5) {
        List r10 = StringsKt.K(r5, new String[]{"_"}, 0, 6);
        if (r10.isEmpty() == false) goto L7;
        return "";
    L7:
        if (r10.size() != 1) goto L11;
        return capitalize((String) r10.get(0), Locale.US);
    L11:
        return joinToCamelCase(r10);
    }

    private static final String toCamelCaseAsVar(String r5) {
        List r10 = StringsKt.K(r5, new String[]{"_"}, 0, 6);
        if (r10.isEmpty() == false) goto L7;
        return "";
    L7:
        if (r10.size() != 1) goto L11;
        return (String) r10.get(0);
    L11:
        return joinToCamelCaseAsVar(r10);
    }
}
