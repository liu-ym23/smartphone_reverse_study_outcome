package com.bytedance.ai.bridge.method.calendar.remote;

import evc.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import o3.v;
import okhttp3.HttpUrl;
import p3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CalDavResponse {
    public static final /* synthetic */ int h = 0;
    public final HttpUrl a;
    public final HttpUrl b;
    public final j c;
    public final List<c> d;
    public final List<i> e;
    public final HttpUrl f;
    public final Lazy g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/CalDavResponse$HrefRelation;", "", "<init>", "(Ljava/lang/String;I)V", "SELF", "MEMBER", "OTHER", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HrefRelation extends Enum<HrefRelation> {
        public static final HrefRelation MEMBER = null;
        public static final HrefRelation OTHER = null;
        public static final HrefRelation SELF = null;
        public static final /* synthetic */ HrefRelation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<HrefRelation> getEntries() {
            return b;
        }

        static {
            HrefRelation r0 = new HrefRelation("SELF", 0);
            SELF = r0;
            HrefRelation r1 = new HrefRelation("MEMBER", 1);
            MEMBER = r1;
            HrefRelation r10 = new HrefRelation("OTHER", 2);
            OTHER = r10;
            HrefRelation[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static HrefRelation[] values() {
            return (HrefRelation[]) a.clone();
        }

        public static HrefRelation valueOf(String r1) {
            return (HrefRelation) r27.a.a(HrefRelation.class, r1);
        }

        public HrefRelation(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CalDavResponse) == true) goto L8;
        return false;
    L8:
        CalDavResponse r11 = (CalDavResponse) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        j r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((r0 + r11) * 31) + this.d.hashCode()) * 31;
        List<i> r13 = this.e;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        HttpUrl r16 = this.f;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalDavResponse(requestedUrl=" + this.a + ", href=" + this.b + ", status=" + this.c + ", propstat=" + this.d + ", error=" + this.e + ", newLocation=" + this.f + ')';
    }

    public final boolean b() {
        j r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if ((r0.b / 100) == 2) goto L8;
        return false;
    }

    public final <T extends Property> T a(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) CollectionsKt.firstOrNull(CollectionsKt.filterIsInstance((List) this.g.getValue(), r10));
    }

    public CalDavResponse(HttpUrl r10, HttpUrl r11, j r12, List<c> r13, List<i> r14, HttpUrl r15) {
        Intrinsics.checkNotNullParameter(r10, "requestedUrl");
        Intrinsics.checkNotNullParameter(r11, "href");
        Intrinsics.checkNotNullParameter(r13, "propstat");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = LazyKt.lazy(new v(this));
    }
}
