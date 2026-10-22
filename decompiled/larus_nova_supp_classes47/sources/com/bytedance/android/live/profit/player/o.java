package com.bytedance.android.live.profit.player;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final List<c> a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$a;", "", "Lcom/bytedance/android/live/profit/player/o$b;", "portrait", "Lcom/bytedance/android/live/profit/player/o$b;", "a", "()Lcom/bytedance/android/live/profit/player/o$b;", "landscape", "getLandscape", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("landscape")
        private final b landscape;

        @SerializedName("portrait")
        private final b portrait;

        public a() {
        }

        public final b a() {
            return this.portrait;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$b;", "", "", "Lcom/bytedance/android/live/profit/player/o$c;", "layers", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("layers")
        private final List<c> layers;

        public b() {
        }

        public final List<c> a() {
            return this.layers;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0012R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$c;", "", "", "name", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "rgbArea", "[I", "getRgbArea", "()[I", "setRgbArea", "([I)V", "alphaArea", "getAlphaArea", "setAlphaArea", "", "enableTap", "Z", "getEnableTap", "()Z", "setEnableTap", "(Z)V", "_originSize", "Lcom/bytedance/android/live/profit/player/o$d;", "maskContainer", "Lcom/bytedance/android/live/profit/player/o$d;", "getMaskContainer", "()Lcom/bytedance/android/live/profit/player/o$d;", "setMaskContainer", "(Lcom/bytedance/android/live/profit/player/o$d;)V", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("originSize")
        private int[] _originSize;

        @SerializedName("alphaFrame")
        private int[] alphaArea;

        @SerializedName("enableTap")
        private boolean enableTap;

        @SerializedName("maskContainer")
        private d maskContainer;

        @SerializedName("name")
        private String name;

        @SerializedName("rgbFrame")
        private int[] rgbArea;

        @SerializedName("type")
        private int type;

        public final e b() {
            int[] r1 = this._originSize;
            return new e(r1[0], r1[1]);
        }

        public final boolean c() {
            d r0 = this.maskContainer;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.a() != 2) goto L7;
            return true;
        }

        public c() {
            this.name = "";
            this.rgbArea = new int[0];
            this.alphaArea = new int[0];
            this._originSize = new int[]{0, 0};
        }

        public final String a() {
            return this.name;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$d;", "", "", "containerType", "I", "a", "()I", "setContainerType", "(I)V", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("type")
        private int containerType;

        public d() {
        }

        public final int a() {
            return this.containerType;
        }
    }

    public static final class e {
        public final int a;
        public final int b;

        public static final class a {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof e) == false) goto L10;
            e r4 = (e) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Size(width=" + this.a + ", height=" + this.b + ")";
        }

        static {
        }

        public e(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((o) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<c> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "Mp4ProbeInfo(layers=" + this.a + ")";
    }

    public o(List<c> r1) {
        this.a = r1;
    }

    public final c a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "layerName");
        List<c> r0 = this.a;
        Object r1 = null;
        if (r0 == null) goto L15;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((c) r3).a(), r5) == false) goto L6;
        r1 = r3;
    L11:
        return (c) r1;
    L15:
        return null;
    }
}
