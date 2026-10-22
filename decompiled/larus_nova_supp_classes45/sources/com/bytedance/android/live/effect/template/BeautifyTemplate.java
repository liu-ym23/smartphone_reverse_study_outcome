package com.bytedance.android.live.effect.template;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BeautifyTemplate {
    public final boolean a;
    public final List<BeautifyContentType> b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/template/BeautifyTemplate$BeautifyContentType;", "", "BEAUTY_TEMPLATE", "BEAUTY", "FILTER", "AV_ADJUST", "MAKEUPS", "BODY_BEAUTY", "STICKER", "PRESETS", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BeautifyContentType extends Enum<BeautifyContentType> {
        public static final BeautifyContentType AV_ADJUST = null;
        public static final BeautifyContentType BEAUTY = null;
        public static final BeautifyContentType BEAUTY_TEMPLATE = null;
        public static final BeautifyContentType BODY_BEAUTY = null;
        public static final BeautifyContentType FILTER = null;
        public static final BeautifyContentType MAKEUPS = null;
        public static final BeautifyContentType PRESETS = null;
        public static final BeautifyContentType STICKER = null;
        public static final /* synthetic */ BeautifyContentType[] a = null;

        static {
            BeautifyContentType r1 = new BeautifyContentType("BEAUTY_TEMPLATE", 0);
            BEAUTY_TEMPLATE = r1;
            BeautifyContentType r2 = new BeautifyContentType("BEAUTY", 1);
            BEAUTY = r2;
            BeautifyContentType r3 = new BeautifyContentType("FILTER", 2);
            FILTER = r3;
            BeautifyContentType r4 = new BeautifyContentType("AV_ADJUST", 3);
            AV_ADJUST = r4;
            BeautifyContentType r5 = new BeautifyContentType("MAKEUPS", 4);
            MAKEUPS = r5;
            BeautifyContentType r6 = new BeautifyContentType("BODY_BEAUTY", 5);
            BODY_BEAUTY = r6;
            BeautifyContentType r7 = new BeautifyContentType("STICKER", 6);
            STICKER = r7;
            BeautifyContentType r8 = new BeautifyContentType("PRESETS", 7);
            PRESETS = r8;
            a = new BeautifyContentType[]{r1, r2, r3, r4, r5, r6, r7, r8};
        }

        public static BeautifyContentType valueOf(String r1) {
            return (BeautifyContentType) r27.a.a(BeautifyContentType.class, r1);
        }

        public static BeautifyContentType[] values() {
            return (BeautifyContentType[]) a.clone();
        }

        public BeautifyContentType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((BeautifyContentType) r0.next()).hashCode();
        goto L4
    L6:
        return r1;
    }

    public final String toString() {
        return "BeautyFilterDialogTemplate(types=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeautifyTemplate(List<? extends BeautifyContentType> r2) {
        Intrinsics.checkNotNullParameter(r2, "types");
        this.b = r2;
        this.a = true;
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Object r2 = null;
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if ((!Intrinsics.areEqual(BeautifyTemplate.class, r3)) == false) goto L12;
        return false;
    L12:
        if (r7 == null) goto L27;
        BeautifyTemplate r8 = (BeautifyTemplate) r7;
        if (r8.b.size() == this.b.size()) goto L16;
        return false;
    L16:
        Iterator<T> r9 = r8.b.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r1 = r9.next();
        if ((!this.b.contains((BeautifyContentType) r1)) == false) goto L18;
        r2 = r1;
    L22:
        if (r2 == null) goto L31;
        return false;
    L31:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.template.BeautifyTemplate");
    L8:
        r3 = null;
        goto L10
    }
}
