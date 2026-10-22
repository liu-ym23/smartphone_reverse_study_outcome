package com.obric.oui.sheet.v2;

import android.app.Dialog;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public class OSheet extends Dialog {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Header;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Header extends Enum<Header> {
        private static final /* synthetic */ Header[] $VALUES = null;
        public static final Header ACTION = null;
        public static final Header CUSTOM = null;
        public static final Header MODAL = null;
        public static final Header ONLY_TITLE = null;
        public static final Header PAGE = null;

        static {
            Header r10 = new Header("CUSTOM", 0);
            CUSTOM = r10;
            Header r11 = new Header("PAGE", 1);
            PAGE = r11;
            Header r12 = new Header("ACTION", 2);
            ACTION = r12;
            Header r13 = new Header("MODAL", 3);
            MODAL = r13;
            Header r14 = new Header("ONLY_TITLE", 4);
            ONLY_TITLE = r14;
            $VALUES = new Header[]{r10, r11, r12, r13, r14};
        }

        private Header(String r10, int r11) {
            super(r10, r11);
        }

        public static Header valueOf(String r10) {
            return (Header) Enum.valueOf(Header.class, r10);
        }

        public static Header[] values() {
            return (Header[]) $VALUES.clone();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HeightMode extends Enum<HeightMode> {
        private static final /* synthetic */ HeightMode[] $VALUES = null;
        public static final HeightMode FULL_HEIGHT = null;
        public static final HeightMode WRAP_HEIGHT = null;

        static {
            HeightMode r10 = new HeightMode("FULL_HEIGHT", 0);
            FULL_HEIGHT = r10;
            HeightMode r11 = new HeightMode("WRAP_HEIGHT", 1);
            WRAP_HEIGHT = r11;
            $VALUES = new HeightMode[]{r10, r11};
        }

        private HeightMode(String r10, int r11) {
            super(r10, r11);
        }

        public static HeightMode valueOf(String r10) {
            return (HeightMode) Enum.valueOf(HeightMode.class, r10);
        }

        public static HeightMode[] values() {
            return (HeightMode[]) $VALUES.clone();
        }
    }
}
