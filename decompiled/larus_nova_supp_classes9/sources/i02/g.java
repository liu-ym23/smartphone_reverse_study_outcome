package i02;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class g {

    @SerializedName("landscape")
    public b landscape;

    @SerializedName("portrait")
    public b portrait;

    public static class a {

        @SerializedName("close")
        public String closeUrl;

        @SerializedName(sz1.a.KEY_HEIGHT)
        public int height;

        @SerializedName("open")
        public String openUrl;

        @SerializedName(sz1.a.KEY_WIDTH)
        public int width;

        @SerializedName(sz1.a.KEY_X)
        public int x;

        @SerializedName(sz1.a.KEY_Y)
        public int y;

        public a() {
        }
    }

    public static class b {

        @SerializedName("h")
        public int actualHeight;

        @SerializedName("w")
        public int actualWidth;

        @SerializedName("align")
        public int align;

        @SerializedName("aFrame")
        public int[] alphaFrame;

        @SerializedName("background")
        public HashMap<String, b> backgroundItemMap;

        @SerializedName("foreground")
        public HashMap<String, b> foregroundItemMap;

        @SerializedName("icons")
        public a icons;

        @SerializedName("has_audio")
        public int isAudio;

        @SerializedName("layers")
        private List<c> layersModel;

        @SerializedName("masks")
        public Map<String, Map<String, DataSource.Element>> masks;

        @SerializedName("path")
        public String path;

        @SerializedName("rgbFrame")
        public int[] rgbFrame;

        @SerializedName("f")
        public int totalFrame;

        @SerializedName("v")
        public int version;

        @SerializedName("vibrate_path")
        public String vibratePath;

        @SerializedName("videoH")
        public int videoHeight;

        @SerializedName("videoW")
        public int videoWidth;

        public final List<DataSource.Layer> a() {
            if (this.layersModel != null) goto L5;
            return null;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<c> r2 = this.layersModel.iterator();
        L7:
            if (r2.hasNext() == false) goto L41;
            c r3 = r2.next();
            r3.getClass();
            DataSource.Layer r4 = new DataSource.Layer();
            r4.a = r3.name;
            int r5 = r3.type;
            r4.b = r5;
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L14;
            if (r5 != 2) goto L15;
            r4.d = new DataSource.Area(r3.alphaArea);
            r4.c = new DataSource.Area(r3.rgbArea);
        L15:
            d r6 = r3.maskContainer;
            if (r6 == null) goto L40;
            if (r6.alphaArea != null) goto L20;
        L38:
            DataSource.MaskContainer r7 = null;
        L39:
            r4.f = r7;
            goto L40
        L20:
            if (r6.rgbArea == null) goto L38;
            r7 = new DataSource.MaskContainer();
            new DataSource.Area(r6.alphaArea);
            new DataSource.Area(r6.rgbArea);
            int[] r8 = r6.contentPadding;
            if (r8 != null) goto L25;
        L28:
            int[] r9 = r6.flexPadding;
            if (r9 == null) goto L37;
            int[] r13 = r6.anchorPoint;
            if (r13 == null) goto L37;
            if (r9.length != 4) goto L36;
            int r10 = r9[1];
            int r11 = r9[3];
            int r14 = r9[0];
            int r15 = r9[2];
        L36:
            int r16 = r13[0];
            int r17 = r13[1];
        L37:
            r7.a = r6.fallbackLayer;
            goto L39
        L25:
            if (r8.length != 4) goto L28;
            int r18 = r8[1];
            int r19 = r8[3];
            int r110 = r8[0];
            int r20 = r8[2];
        L40:
            r0.add(r4);
        L14:
            r4.e = r3.enableTap;
            goto L15
        L41:
            return r0;
        }

        public b() {
            this.foregroundItemMap = new HashMap();
            this.backgroundItemMap = new HashMap();
        }
    }

    public static class c {

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("enableTap")
        public boolean enableTap;

        @SerializedName("maskContainer")
        public d maskContainer;

        @SerializedName("name")
        public String name;

        @SerializedName("originSize")
        public int[] originSize;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        @SerializedName("type")
        public int type;

        public c() {
        }
    }

    public static class d {

        @SerializedName("alignType")
        public int alignType;

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("anchorPoint")
        public int[] anchorPoint;

        @SerializedName("type")
        public int containerType;

        @SerializedName("contentPadding")
        public int[] contentPadding;

        @SerializedName("disableFlexX")
        public boolean disableFlexX;

        @SerializedName("disableFlexY")
        public boolean disableFlexY;

        @SerializedName("fallbackLayer")
        public String fallbackLayer;

        @SerializedName("flexPadding")
        public int[] flexPadding;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        public d() {
            this.disableFlexX = false;
            this.disableFlexY = false;
        }
    }

    public g() {
    }
}
