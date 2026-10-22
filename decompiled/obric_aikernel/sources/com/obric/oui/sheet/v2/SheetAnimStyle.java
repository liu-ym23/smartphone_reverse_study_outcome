package com.obric.oui.sheet.v2;

import android.util.Log;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class SheetAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SheetAnimStyle f7431a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "", "maxRatio", "F", "getMaxRatio", "()F", "<init>", "(Ljava/lang/String;IF)V", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        static {
            HeightLevel r10 = new HeightLevel("SMALL", 0, 0.4f);
            SMALL = r10;
            HeightLevel r11 = new HeightLevel("MEDIUM", 1, 0.8f);
            MEDIUM = r11;
            HeightLevel r12 = new HeightLevel("LARGE", 2, 1.0f);
            LARGE = r12;
            $VALUES = new HeightLevel[]{r10, r11, r12};
        }

        private HeightLevel(String r10, int r11, float r12) {
            super(r10, r11);
            this.maxRatio = r12;
        }

        public static HeightLevel valueOf(String r10) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r10);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) $VALUES.clone();
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    static {
        f7431a = new SheetAnimStyle();
    }

    private SheetAnimStyle() {
    }

    public static final /* synthetic */ void a(SheetAnimStyle r10, View r11, float r12, float r13, float r14) {
        r10.c(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void b(SheetAnimStyle r10, Window r11, float r12, float r13, float r14) {
        r10.d(r11, r12, r13, r14);
    }

    private final void c(View r10, float r11, float r12, float r13) {
        r10.setAlpha(r12 + ((r13 - r12) * RangesKt.coerceIn(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", "updateDimViewWithAnim: " + e.getMessage());
    }

    private final void d(Window r10, float r11, float r12, float r13) {
        r10.setDimAmount(r12 + ((r13 - r12) * RangesKt.coerceIn(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }
}
