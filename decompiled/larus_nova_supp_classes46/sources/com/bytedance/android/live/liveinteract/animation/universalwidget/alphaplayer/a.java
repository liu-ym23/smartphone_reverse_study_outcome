package com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a {

    @SerializedName("landscape")
    public C0015a landscape;

    @SerializedName("portrait")
    public C0015a portrait;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a$a, reason: collision with other inner class name */
    public static class C0015a {

        @SerializedName("h")
        public int actualHeight;

        @SerializedName("w")
        public int actualWidth;

        @SerializedName("align")
        public int align;

        @SerializedName("aFrame")
        public int[] alphaFrame;

        @SerializedName("layers")
        private List<b> layersModel;

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

        @SerializedName("videoH")
        public int videoHeight;

        @SerializedName("videoW")
        public int videoWidth;

        public C0015a() {
        }

        public final List<DataSource.Layer> a() {
            if (this.layersModel != null) goto L5;
            return null;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<b> r2 = this.layersModel.iterator();
        L7:
            if (r2.hasNext() == false) goto L41;
            b r3 = r2.next();
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
            c r6 = r3.maskContainer;
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
            int[] r12 = r6.anchorPoint;
            if (r12 == null) goto L37;
            if (r9.length != 4) goto L36;
            int r10 = r9[1];
            int r11 = r9[3];
            int r13 = r9[0];
            int r14 = r9[2];
        L36:
            int r15 = r12[0];
            int r16 = r12[1];
        L37:
            r7.a = r6.fallbackLayer;
            goto L39
        L25:
            if (r8.length != 4) goto L28;
            int r17 = r8[1];
            int r18 = r8[3];
            int r19 = r8[0];
            int r20 = r8[2];
        L40:
            r0.add(r4);
        L14:
            r4.e = r3.enableTap;
            goto L15
        L41:
            return r0;
        }
    }

    public static class b {

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("enableTap")
        public boolean enableTap;

        @SerializedName("maskContainer")
        public c maskContainer;

        @SerializedName("name")
        public String name;

        @SerializedName("originSize")
        public int[] originSize;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        @SerializedName("type")
        public int type;

        public b() {
        }
    }

    public static class c {

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

        public c() {
            this.disableFlexX = false;
            this.disableFlexY = false;
        }
    }

    public a() {
    }
}
