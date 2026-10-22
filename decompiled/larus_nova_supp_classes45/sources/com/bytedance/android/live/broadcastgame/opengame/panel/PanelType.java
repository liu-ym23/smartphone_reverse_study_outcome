package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.utils.n;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/PanelType;", "", "", "w", "h", "", "updateWH", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "Companion", "a", "PANEL_TYPE_X_SCREEN_LOW", "PANEL_TYPE_PORTRAIT", "PANEL_TYPE_X_SCREEN", "PANEL_TYPE_LANDSCAPE", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelType extends Enum<PanelType> {
    public static final a Companion = null;
    public static final PanelType PANEL_TYPE_LANDSCAPE = null;
    public static final PanelType PANEL_TYPE_PORTRAIT = null;
    public static final PanelType PANEL_TYPE_X_SCREEN = null;
    public static final PanelType PANEL_TYPE_X_SCREEN_LOW = null;
    public static final /* synthetic */ PanelType[] a = null;
    private int height;
    private final String type;
    private int width;

    public static final class a {
        public a() {
        }

        public static boolean a(PanelType r1) {
            if (r1 != PanelType.PANEL_TYPE_PORTRAIT) goto L5;
        L8:
            return true;
        L5:
            if (r1 == PanelType.PANEL_TYPE_LANDSCAPE) goto L8;
            return false;
        }

        public final PanelType getType(String r6) {
            Intrinsics.checkNotNullParameter(r6, "type");
            PanelType[] r0 = PanelType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            PanelType r3 = r0[r2];
            if (Intrinsics.areEqual(r6, r3.getType()) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static boolean b(PanelType r2, PanelType r3) {
            Intrinsics.checkNotNullParameter(r2, "fromType");
            Intrinsics.checkNotNullParameter(r3, "toType");
            int r4 = j.a[r2.ordinal()];
            if (r4 == 1) goto L20;
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L20;
            if (r4 != 4) goto L18;
            if (r3 != PanelType.PANEL_TYPE_PORTRAIT) goto L13;
            return true;
        L13:
            if (r3 != PanelType.PANEL_TYPE_X_SCREEN_LOW) goto L15;
            return true;
        L15:
            if (r3 == PanelType.PANEL_TYPE_X_SCREEN) goto L26;
        L22:
            return false;
        L26:
            return true;
        L18:
            throw new NoWhenBranchMatchedException();
        L20:
            if (r3 != PanelType.PANEL_TYPE_LANDSCAPE) goto L22;
            return true;
        }
    }

    static {
        PanelType r7 = new PanelType("PANEL_TYPE_X_SCREEN_LOW", 0, "xscreen_low", s1.y(), (int) ((((double) s1.y()) * 0.736d) + ((double) s1.f(68.0f))));
        PANEL_TYPE_X_SCREEN_LOW = r7;
        PanelType r1 = new PanelType("PANEL_TYPE_PORTRAIT", 1, "portrait", s1.y(), s1.w());
        PANEL_TYPE_PORTRAIT = r1;
        int r8 = s1.y();
        int r2 = n.a;
        PanelType r3 = new PanelType("PANEL_TYPE_X_SCREEN", 2, "xscreen", r8, s1.f(484.0f));
        PANEL_TYPE_X_SCREEN = r3;
        PanelType r4 = new PanelType("PANEL_TYPE_LANDSCAPE", 3, "landscape", s1.w(), s1.y());
        PANEL_TYPE_LANDSCAPE = r4;
        a = new PanelType[]{r7, r1, r3, r4};
        Companion = new a();
    }

    public static PanelType valueOf(String r1) {
        return (PanelType) r27.a.a(PanelType.class, r1);
    }

    public static PanelType[] values() {
        return (PanelType[]) a.clone();
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public final void updateWH(int r1, int r2) {
        this.width = r1;
        this.height = r2;
    }

    public PanelType(String r1, int r2, String r3, int r4, int r5) {
        super(r1, r2);
        this.type = r3;
        this.width = r4;
        this.height = r5;
    }
}
