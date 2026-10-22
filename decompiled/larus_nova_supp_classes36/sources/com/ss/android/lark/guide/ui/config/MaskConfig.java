package com.ss.android.lark.guide.ui.config;

import android.graphics.Rect;
import android.util.Size;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MaskConfig {
    public final int a;
    public final float b;
    public final ShapeType c;
    public final Rect d;
    public final Size e;
    public final int f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/guide/ui/config/MaskConfig$ShapeType;", "", "<init>", "(Ljava/lang/String;I)V", "RECTANGLE", "CIRCLE", "SQUARE", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ShapeType extends Enum<ShapeType> {
        public static final ShapeType CIRCLE = null;
        public static final ShapeType RECTANGLE = null;
        public static final ShapeType SQUARE = null;
        public static final /* synthetic */ ShapeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ShapeType> getEntries() {
            return b;
        }

        static {
            ShapeType r0 = new ShapeType("RECTANGLE", 0);
            RECTANGLE = r0;
            ShapeType r1 = new ShapeType("CIRCLE", 1);
            CIRCLE = r1;
            ShapeType r3 = new ShapeType("SQUARE", 2);
            SQUARE = r3;
            ShapeType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ShapeType[] values() {
            return (ShapeType[]) a.clone();
        }

        public static ShapeType valueOf(String r1) {
            return (ShapeType) a.a(ShapeType.class, r1);
        }

        public ShapeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public MaskConfig(ShapeType r5, Rect r6, Size r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        int r0 = 0;
    L7:
        if ((r8 & 4) == 0) goto L10;
        r5 = ShapeType.RECTANGLE;
    L10:
        if ((r8 & 8) == 0) goto L13;
        r6 = null;
    L13:
        if ((r8 & 16) == 0) goto L15;
        r7 = null;
    L15:
        Intrinsics.checkNotNullParameter(r5, "shapeType");
        this.a = r0;
        this.b = 0.0f;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = 0;
        return;
    L5:
        r0 = 76;
        goto L7
    }
}
