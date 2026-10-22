package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewSelectionLimit {
    public final int a;
    public final MediaScope b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewSelectionLimit$MediaScope;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ONLY", "IMAGE_AND_VIDEO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MediaScope extends Enum<MediaScope> {
        public static final MediaScope IMAGE_AND_VIDEO = null;
        public static final MediaScope IMAGE_ONLY = null;
        public static final /* synthetic */ MediaScope[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<MediaScope> getEntries() {
            return b;
        }

        static {
            MediaScope r0 = new MediaScope("IMAGE_ONLY", 0);
            IMAGE_ONLY = r0;
            MediaScope r1 = new MediaScope("IMAGE_AND_VIDEO", 1);
            IMAGE_AND_VIDEO = r1;
            MediaScope[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static MediaScope[] values() {
            return (MediaScope[]) a.clone();
        }

        public static MediaScope valueOf(String r1) {
            return (MediaScope) r27.a.a(MediaScope.class, r1);
        }

        public MediaScope(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PreviewSelectionLimit) == true) goto L8;
        return false;
    L8:
        PreviewSelectionLimit r6 = (PreviewSelectionLimit) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PreviewSelectionLimit(maxCount=" + this.a + ", mediaScope=" + this.b + ')';
    }

    public PreviewSelectionLimit(int r2, MediaScope r3) {
        Intrinsics.checkNotNullParameter(r3, "mediaScope");
        this.a = r2;
        this.b = r3;
    }
}
