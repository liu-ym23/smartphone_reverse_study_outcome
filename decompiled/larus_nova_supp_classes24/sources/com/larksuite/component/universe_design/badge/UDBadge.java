package com.larksuite.component.universe_design.badge;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDBadge {
    public final Context a;
    public final c b;
    public final b c;
    public float d;
    public float e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadge$BadgeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOT", "TEXT", "ICON", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum BadgeType extends Enum<BadgeType> {
        public static final BadgeType DOT = null;
        public static final BadgeType ICON = null;
        public static final BadgeType TEXT = null;
        public static final BadgeType UNKNOWN = null;
        public static final /* synthetic */ BadgeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<BadgeType> getEntries() {
            return b;
        }

        static {
            BadgeType r0 = new BadgeType("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            BadgeType r1 = new BadgeType("DOT", 1, 0);
            DOT = r1;
            BadgeType r2 = new BadgeType("TEXT", 2, 1);
            TEXT = r2;
            BadgeType r5 = new BadgeType("ICON", 3, 2);
            ICON = r5;
            BadgeType[] r7 = {r0, r1, r2, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static BadgeType[] values() {
            return (BadgeType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BadgeType valueOf(String r1) {
            return (BadgeType) r27.a.a(BadgeType.class, r1);
        }

        public BadgeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public final class b {
        public final Paint a;
        public final Paint b;
        public final Paint c;
        public final RectF d;
        public final PointF e;
        public final RectF f;
        public final /* synthetic */ UDBadge g;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BadgeType.values().length];
                r0[BadgeType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[BadgeType.ICON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public b(UDBadge r3) {
            this.g = r3;
            Paint r0 = new Paint();
            r0.setAntiAlias(true);
            this.a = r0;
            Paint r1 = new Paint();
            r1.setAntiAlias(true);
            this.b = r1;
            Paint r2 = new Paint();
            r2.setAntiAlias(true);
            w08.a.a(r2, r3.a, 1);
            this.c = r2;
            this.d = new RectF();
            this.e = new PointF();
            this.f = new RectF();
        }
    }

    public static class c {
        public BadgeType a;
        public float b;
        public int c;
        public float d;
        public int e;
        public float f;
        public int g;
        public String h;
        public float i;
        public int j;
        public float k;
        public Drawable l;
        public RectF m;

        public c() {
            this.a = BadgeType.UNKNOWN;
        }

        public final void update(c r2) {
            Intrinsics.checkNotNullParameter(r2, "newModel");
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.g = r2.g;
            this.h = r2.h;
            this.i = r2.i;
            this.j = r2.j;
            this.k = r2.k;
            this.l = r2.l;
            this.m = r2.m;
        }
    }

    static {
    }

    public UDBadge(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new c();
        this.c = new b(this);
    }

    public static final float a(UDBadge r2) {
        float r3 = 0.0f - (r2.d / 2);
        if (r3 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        return r3;
    }

    public static final float b(UDBadge r2) {
        float r3 = 0.0f - (r2.e / 2);
        if (r3 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        return r3;
    }
}
