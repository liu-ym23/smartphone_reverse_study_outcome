package com.larus.avlink.gallery.banner;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/gallery/banner/GalleryState;", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public @interface GalleryState {
    public static final int AP_ON = 9;
    public static final a Companion = null;
    public static final int GPS_OFF = 8;
    public static final int INITIAL = -1;
    public static final int LOW_BATTERY = 10;
    public static final int NO_STORAGE_PERMISSION = 7;
    public static final int RECORDING = 11;
    public static final int SHOW_DIFF = 0;
    public static final int TRANS_COMPLETE = 3;
    public static final int TRANS_ING = 2;
    public static final int VPN_ON = 4;
    public static final int WIFI_CONNECTING = 1;
    public static final int WIFI_ERROR = 6;
    public static final int WIFI_OFF = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
