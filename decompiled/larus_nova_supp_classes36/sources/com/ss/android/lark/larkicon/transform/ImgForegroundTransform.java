package com.ss.android.lark.larkicon.transform;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import xpb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImgForegroundTransform extends c {
    public final Drawable a;
    public Bitmap b;
    public final Gravity c;
    public final Integer d;
    public final Integer e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/larkicon/transform/ImgForegroundTransform$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LeftTop", "LeftBottom", "RightTop", "RightBottom", "lark-icon_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity LeftBottom = null;
        public static final Gravity LeftTop = null;
        public static final Gravity RightBottom = null;
        public static final Gravity RightTop = null;
        public static final /* synthetic */ Gravity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Gravity> getEntries() {
            return b;
        }

        static {
            Gravity r0 = new Gravity("LeftTop", 0);
            LeftTop = r0;
            Gravity r1 = new Gravity("LeftBottom", 1);
            LeftBottom = r1;
            Gravity r3 = new Gravity("RightTop", 2);
            RightTop = r3;
            Gravity r5 = new Gravity("RightBottom", 3);
            RightBottom = r5;
            Gravity[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Gravity[] values() {
            return (Gravity[]) a.clone();
        }

        public static Gravity valueOf(String r1) {
            return (Gravity) r27.a.a(Gravity.class, r1);
        }

        public Gravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Gravity.values().length];
            r0[Gravity.LeftBottom.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Gravity.RightTop.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Gravity.RightBottom.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public ImgForegroundTransform(Drawable r2, Gravity r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        Intrinsics.checkNotNullParameter(r3, "gravity");
        this.c = Gravity.LeftTop;
        this.a = r2;
        this.c = r3;
        this.d = null;
        this.e = null;
    }
}
