package com.obric.oui.sheet;

import android.app.Dialog;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public class OInsetSheet extends Dialog {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "", "<init>", "(Ljava/lang/String;I)V", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PanelWidth extends Enum<PanelWidth> {
        private static final /* synthetic */ PanelWidth[] $VALUES = null;
        public static final PanelWidth BOARD_WIDTH = null;
        public static final PanelWidth NARROW_WIDTH = null;

        static {
            PanelWidth r10 = new PanelWidth("NARROW_WIDTH", 0);
            NARROW_WIDTH = r10;
            PanelWidth r11 = new PanelWidth("BOARD_WIDTH", 1);
            BOARD_WIDTH = r11;
            $VALUES = new PanelWidth[]{r10, r11};
        }

        private PanelWidth(String r10, int r11) {
            super(r10, r11);
        }

        public static PanelWidth valueOf(String r10) {
            return (PanelWidth) Enum.valueOf(PanelWidth.class, r10);
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) $VALUES.clone();
        }
    }
}
