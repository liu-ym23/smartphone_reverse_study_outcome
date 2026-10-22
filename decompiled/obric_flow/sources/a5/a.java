package a5;

import g8.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable {
    public static final /* synthetic */ KProperty[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f94a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Regex f95b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f96c;

    static {
        d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "regex", "getRegex()Lkotlin/text/Regex;", 0))};
    }

    public a(String r5, Regex r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f94a = r5;
        this.f96c = new g(this, 1);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f95b = r10;
    }

    public final Regex a() {
        Intrinsics.checkNotNullParameter(d[0], "property");
        Regex r5 = ((a) this.f96c.f17073b).f95b;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("_regex");
        return null;
    L7:
        return r5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        a r10 = (a) r5;
        Intrinsics.checkNotNullParameter(r10, "other");
        return r10.a().getPattern().length() - a().getPattern().length();
    }

    public final String toString() {
        return this.f94a + ": [" + a() + ']';
    }
}
