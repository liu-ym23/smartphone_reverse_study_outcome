package com.ss.android.lark.export.entity.preview;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient;", "Ljava/io/Serializable;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "content", "Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;Lcom/ss/android/lark/export/entity/preview/Gradient$Content;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "setType", "(Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;)V", "getContent", "()Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "setContent", "(Lcom/ss/android/lark/export/entity/preview/Gradient$Content;)V", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "copy", "toString", BuildConfig.FLAVOR, "GradientType", "Linear", "Content", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Gradient implements Serializable {
    private Content content;
    private GradientType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "Ljava/io/Serializable;", "<init>", "()V", "clone", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Content implements Serializable {
        public Content() {
        }

        public Content clone() {
            return new Content();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LINEAR", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GradientType extends Enum<GradientType> implements Serializable {
        public static final a Companion = null;
        public static final GradientType LINEAR = null;
        public static final /* synthetic */ GradientType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<GradientType> getEntries() {
            return b;
        }

        static {
            GradientType r0 = new GradientType();
            LINEAR = r0;
            GradientType[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
            Companion = new a();
        }

        public GradientType() {
            super("LINEAR", 0);
            this.value = 0;
        }

        public static GradientType[] values() {
            return (GradientType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static GradientType valueOf(String r1) {
            return (GradientType) r27.a.a(GradientType.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\u001d\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J8\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$Linear;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "deg", BuildConfig.FLAVOR, "themeColors", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getDeg", "()Ljava/lang/Integer;", "setDeg", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getThemeColors", "()Ljava/util/ArrayList;", "setThemeColors", "(Ljava/util/ArrayList;)V", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/ss/android/lark/export/entity/preview/Gradient$Linear;", "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Linear extends Content {
        private Integer deg;
        private ArrayList<ThemeColor> themeColors;

        /* JADX WARN: Multi-variable type inference failed */
        public Linear() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Linear copy$default(Linear r0, Integer r1, ArrayList r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.deg;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.themeColors;
        L9:
            return r0.copy(r1, r2);
        }

        public final Integer component1() {
            return this.deg;
        }

        public final ArrayList<ThemeColor> component2() {
            return this.themeColors;
        }

        public final Linear copy(Integer r2, ArrayList<ThemeColor> r3) {
            return new Linear(r2, r3);
        }

        public String toString() {
            return "Linear(deg=" + this.deg + ", themeColors=" + this.themeColors + ')';
        }

        @Override // com.ss.android.lark.export.entity.preview.Gradient.Content
        public Linear clone() {
            ArrayList r0 = new ArrayList();
            ArrayList<ThemeColor> r1 = this.themeColors;
            if (r1 == null) goto L9;
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            r0.add(((ThemeColor) r2.next()).clone());
        L9:
            return new Linear(this.deg, r0);
        }

        public int hashCode() {
            Integer r0 = this.deg;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.intValue();
        L6:
            int r3 = r2 * 31;
            ArrayList<ThemeColor> r4 = this.themeColors;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final Integer getDeg() {
            return this.deg;
        }

        public final ArrayList<ThemeColor> getThemeColors() {
            return this.themeColors;
        }

        @Override // com.ss.android.lark.export.entity.preview.Gradient.Content
        public /* bridge */ /* synthetic */ Content clone() {
            return clone();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(Linear.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
            Linear r6 = (Linear) r5;
            if (Intrinsics.areEqual(this.deg, r6.deg) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.themeColors, r6.themeColors) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public final void setDeg(Integer r1) {
            this.deg = r1;
        }

        public final void setThemeColors(ArrayList<ThemeColor> r1) {
            this.themeColors = r1;
        }

        public Linear(Integer r1, ArrayList<ThemeColor> r2) {
            this.deg = r1;
            this.themeColors = r2;
        }

        public /* synthetic */ Linear(Integer r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Gradient() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Gradient copy$default(Gradient r0, GradientType r1, Content r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        return r0.copy(r1, r2);
    }

    public final GradientType component1() {
        return this.type;
    }

    public final Content component2() {
        return this.content;
    }

    public final Gradient copy(GradientType r2, Content r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "content");
        return new Gradient(r2, r3);
    }

    public String toString() {
        return "Gradient(type=" + this.type + ", content=" + this.content + ')';
    }

    public final Gradient clone() {
        return new Gradient(this.type, this.content.clone());
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.content.hashCode();
    }

    public final Content getContent() {
        return this.content;
    }

    public final GradientType getType() {
        return this.type;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(Gradient.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient");
        Gradient r6 = (Gradient) r5;
        if (this.type == r6.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setContent(Content r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setType(GradientType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public Gradient(GradientType r2, Content r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "content");
        this.type = r2;
        this.content = r3;
    }

    public /* synthetic */ Gradient(GradientType r1, Content r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = GradientType.LINEAR;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new Linear(0, null);
    L8:
        this(r1, r2);
    }
}
