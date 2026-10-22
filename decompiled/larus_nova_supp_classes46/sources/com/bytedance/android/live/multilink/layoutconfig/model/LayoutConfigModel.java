package com.bytedance.android.live.multilink.layoutconfig.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001:\u000bS\u0005\u0018\u0010TUVW&-PB\u0007¢\u0006\u0004\bR\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR(\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010\u0004\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\b¨\u0006X"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel;", "", "", "adjustBase", "I", "b", "()I", "r", "(I)V", "getAdjustBase$annotations", "()V", "scale", "j", "y", "getScale$annotations", "align", "d", "s", "getAlign$annotations", "", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$a;", "adjustMap", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setAdjustMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "uiContainer", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "p", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "E", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "canvasParams", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "e", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "t", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "contentParams", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "f", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "u", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;)V", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$e;", "regionList", "Ljava/util/List;", "i", "()Ljava/util/List;", "x", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$f;", "seatList", "l", "A", "scene", "k", "z", "uiLayout", "q", "F", "playMode", "h", "w", "spatialId", "o", "D", "seiVersion", "n", "C", "seiSubScene", "m", "B", "orientation", "g", "v", "<init>", "a", "LayoutAdjustBase", "LayoutAlign", "LayoutOrientation", "LayoutScale", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LayoutConfigModel {

    @SerializedName("adjust_base")
    private int adjustBase;

    @SerializedName("adjust_map")
    private Map<String, a> adjustMap;

    @SerializedName("align")
    private int align;

    @SerializedName("canvas")
    private b canvasParams;

    @SerializedName("content")
    private d contentParams;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName("play_mode")
    private int playMode;

    @SerializedName("regions")
    private List<e> regionList;

    @SerializedName("scale")
    private int scale;

    @SerializedName("scene")
    private int scene;

    @SerializedName("seats")
    private List<f> seatList;

    @SerializedName("sei_sub_scene")
    private int seiSubScene;

    @SerializedName("sei_ver")
    private int seiVersion;

    @SerializedName("spatial_id")
    private int spatialId;

    @SerializedName("ui_container")
    private g uiContainer;

    @SerializedName("ui_layout")
    private int uiLayout;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutAdjustBase;", "", "Companion", "a", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutAdjustBase {
        public static final int CANVAS = 1;
        public static final int CONTENT = 0;
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutAlign;", "", "Companion", "a", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutAlign {
        public static final int CENTER = 5;
        public static final int CENTER_BOTTOM = 2;
        public static final int CENTER_TOP = 8;
        public static final a Companion = null;
        public static final int LEFT_BOTTOM = 1;
        public static final int LEFT_CENTER = 4;
        public static final int LEFT_TOP = 7;
        public static final int RIGHT_BOTTOM = 3;
        public static final int RIGHT_CENTER = 6;
        public static final int RIGHT_TOP = 9;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutOrientation;", "", "Companion", "a", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutOrientation {
        public static final int COMMON = 0;
        public static final a Companion = null;
        public static final int HORIZONTAL = 2;
        public static final int VERTICAL = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$LayoutScale;", "", "Companion", "a", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutScale {
        public static final int ASPECT_FILL = 2;
        public static final int ASPECT_FIT = 1;
        public static final a Companion = null;
        public static final int FILL = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$a;", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "uiContainer", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "b", "()Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "setUiContainer", "(Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;)V", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("ui_container")
        private g uiContainer;

        public a() {
        }

        public final a a() {
            a r0 = new a();
            g r1 = this.uiContainer;
            if (r1 == null) goto L5;
            g r2 = r1.a();
        L6:
            r0.uiContainer = r2;
            return r0;
        L5:
            r2 = null;
            goto L6
        }

        public final g b() {
            return this.uiContainer;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$b;", "", "", "width", "I", "d", "()I", "g", "(I)V", "height", "c", "f", "", "backgroundColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("background_color")
        private String backgroundColor;

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        public final b a() {
            b r0 = new b();
            r0.width = this.width;
            r0.height = this.height;
            r0.backgroundColor = this.backgroundColor;
            return r0;
        }

        public b() {
            this.backgroundColor = "#322542";
        }

        public final String b() {
            return this.backgroundColor;
        }

        public final int c() {
            return this.height;
        }

        public final int d() {
            return this.width;
        }

        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.backgroundColor = r2;
        }

        public final void f(int r1) {
            this.height = r1;
        }

        public final void g(int r1) {
            this.width = r1;
        }
    }

    public static final class c {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$d;", "", "", "x", "D", "d", "()D", "h", "(D)V", "y", "e", "i", "", "width", "I", "c", "()I", "g", "(I)V", "height", "b", "f", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        @SerializedName("x")
        private double x;

        @SerializedName("y")
        private double y;

        public d() {
        }

        public final d a() {
            d r0 = new d();
            r0.x = this.x;
            r0.y = this.y;
            r0.width = this.width;
            r0.height = this.height;
            return r0;
        }

        public final int b() {
            return this.height;
        }

        public final int c() {
            return this.width;
        }

        public final double d() {
            return this.x;
        }

        public final double e() {
            return this.y;
        }

        public final void f(int r1) {
            this.height = r1;
        }

        public final void g(int r1) {
            this.width = r1;
        }

        public final void h(double r1) {
            this.x = r1;
        }

        public final void i(double r1) {
            this.y = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$e;", "", "", "zOrder", "I", "g", "()I", "m", "(I)V", "position", "c", "i", "", "x", "D", "e", "()D", "k", "(D)V", "y", "f", "l", "width", "d", "j", "height", "b", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        @SerializedName("x")
        private double x;

        @SerializedName("y")
        private double y;

        @SerializedName("z")
        private int zOrder;

        public e() {
        }

        public final e a() {
            e r0 = new e();
            r0.zOrder = this.zOrder;
            r0.position = this.position;
            r0.x = this.x;
            r0.y = this.y;
            r0.width = this.width;
            r0.height = this.height;
            return r0;
        }

        public final String toString() {
            return "{zOrder = " + this.zOrder + ", position = " + this.position + ", region = [" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + "]}";
        }

        public final double b() {
            return this.height;
        }

        public final int c() {
            return this.position;
        }

        public final double d() {
            return this.width;
        }

        public final double e() {
            return this.x;
        }

        public final double f() {
            return this.y;
        }

        public final int g() {
            return this.zOrder;
        }

        public final void h(double r1) {
            this.height = r1;
        }

        public final void i(int r1) {
            this.position = r1;
        }

        public final void j(double r1) {
            this.width = r1;
        }

        public final void k(double r1) {
            this.x = r1;
        }

        public final void l(double r1) {
            this.y = r1;
        }

        public final void m(int r1) {
            this.zOrder = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$f;", "", "", "zOrder", "I", "g", "()I", "m", "(I)V", "position", "c", "i", "", "x", "D", "e", "()D", "k", "(D)V", "y", "f", "l", "width", "d", "j", "height", "b", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f {

        @SerializedName("h")
        private double height;

        @SerializedName("p")
        private int position;

        @SerializedName("w")
        private double width;

        @SerializedName("x")
        private double x;

        @SerializedName("y")
        private double y;

        @SerializedName("z")
        private int zOrder;

        public f() {
        }

        public final f a() {
            f r0 = new f();
            r0.zOrder = this.zOrder;
            r0.position = this.position;
            r0.x = this.x;
            r0.y = this.y;
            r0.width = this.width;
            r0.height = this.height;
            return r0;
        }

        public final double b() {
            return this.height;
        }

        public final int c() {
            return this.position;
        }

        public final double d() {
            return this.width;
        }

        public final double e() {
            return this.x;
        }

        public final double f() {
            return this.y;
        }

        public final int g() {
            return this.zOrder;
        }

        public final void h(double r1) {
            this.height = r1;
        }

        public final void i(int r1) {
            this.position = r1;
        }

        public final void j(double r1) {
            this.width = r1;
        }

        public final void k(double r1) {
            this.x = r1;
        }

        public final void l(double r1) {
            this.y = r1;
        }

        public final void m(int r1) {
            this.zOrder = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel$g;", "", "", "topDp", "I", "e", "()I", "i", "(I)V", "leftDp", "c", "g", "bottomDp", "b", "f", "rightDp", "d", "h", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g {

        @SerializedName("bottom")
        private int bottomDp;

        @SerializedName("left")
        private int leftDp;

        @SerializedName("right")
        private int rightDp;

        @SerializedName("top")
        private int topDp;

        public g() {
        }

        public final g a() {
            g r0 = new g();
            r0.topDp = this.topDp;
            r0.rightDp = this.rightDp;
            r0.bottomDp = this.bottomDp;
            r0.leftDp = this.leftDp;
            return r0;
        }

        public final String toString() {
            return "[" + this.leftDp + ", " + this.topDp + ", " + this.rightDp + ", " + this.bottomDp + ']';
        }

        public final int b() {
            return this.bottomDp;
        }

        public final int c() {
            return this.leftDp;
        }

        public final int d() {
            return this.rightDp;
        }

        public final int e() {
            return this.topDp;
        }

        public final void f(int r1) {
            this.bottomDp = r1;
        }

        public final void g(int r1) {
            this.leftDp = r1;
        }

        public final void h(int r1) {
            this.rightDp = r1;
        }

        public final void i(int r1) {
            this.topDp = r1;
        }
    }

    static {
    }

    public final void r() {
        this.adjustBase = 0;
    }

    public final LayoutConfigModel a() {
        LayoutConfigModel r0 = new LayoutConfigModel();
        r0.scene = this.scene;
        r0.uiLayout = this.uiLayout;
        r0.playMode = this.playMode;
        r0.seiVersion = this.seiVersion;
        r0.spatialId = this.spatialId;
        r0.seiSubScene = this.seiSubScene;
        r0.orientation = this.orientation;
        Map<String, a> r1 = this.adjustMap;
        LinkedHashMap r2 = new LinkedHashMap();
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, a>> r3 = r1.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, a> r4 = r3.next();
        r2.put(r4.getKey(), r4.getValue().a());
    L8:
        r0.adjustMap = r2;
        r0.adjustBase = this.adjustBase;
        r0.scale = this.scale;
        r0.align = this.align;
        g r5 = this.uiContainer;
        d r6 = null;
        if (r5 == null) goto L11;
        g r7 = r5.a();
    L12:
        r0.uiContainer = r7;
        b r8 = this.canvasParams;
        if (r8 == null) goto L15;
        b r9 = r8.a();
    L16:
        r0.canvasParams = r9;
        d r10 = this.contentParams;
        if (r10 == null) goto L19;
        r6 = r10.a();
    L19:
        r0.contentParams = r6;
        List<e> r11 = this.regionList;
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        if (r11 == null) goto L25;
        int r14 = r11.size();
        int r15 = 0;
    L23:
        if (r15 >= r14) goto L25;
        r12.add(((e) ListProtector.get(r11, r15)).a());
        r15 = r15 + 1;
    L25:
        r0.regionList = r12;
        List<f> r16 = this.seatList;
        ArrayList r17 = new ArrayList();
        if (r16 == null) goto L31;
        int r18 = r16.size();
    L29:
        if (r13 >= r18) goto L31;
        r17.add(((f) ListProtector.get(r16, r13)).a());
        r13 = r13 + 1;
    L31:
        r0.seatList = r17;
        return r0;
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    }

    public LayoutConfigModel() {
        this.scale = 1;
        this.align = 8;
        this.spatialId = -1;
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(GsonHelper.get(), this).toString();
    }

    public final int b() {
        return this.adjustBase;
    }

    public final Map<String, a> c() {
        return this.adjustMap;
    }

    public final int d() {
        return this.align;
    }

    public final b e() {
        return this.canvasParams;
    }

    public final d f() {
        return this.contentParams;
    }

    public final int g() {
        return this.orientation;
    }

    public final int h() {
        return this.playMode;
    }

    public final List<e> i() {
        return this.regionList;
    }

    public final int j() {
        return this.scale;
    }

    public final int k() {
        return this.scene;
    }

    public final List<f> l() {
        return this.seatList;
    }

    public final int m() {
        return this.seiSubScene;
    }

    public final int n() {
        return this.seiVersion;
    }

    public final int o() {
        return this.spatialId;
    }

    public final g p() {
        return this.uiContainer;
    }

    public final int q() {
        return this.uiLayout;
    }

    public final void A(List<f> r1) {
        this.seatList = r1;
    }

    public final void B(int r1) {
        this.seiSubScene = r1;
    }

    public final void C(int r1) {
        this.seiVersion = r1;
    }

    public final void D(int r1) {
        this.spatialId = r1;
    }

    public final void E(g r1) {
        this.uiContainer = r1;
    }

    public final void F(int r1) {
        this.uiLayout = r1;
    }

    public final void s(int r1) {
        this.align = r1;
    }

    public final void t(b r1) {
        this.canvasParams = r1;
    }

    public final void u(d r1) {
        this.contentParams = r1;
    }

    public final void v(int r1) {
        this.orientation = r1;
    }

    public final void w(int r1) {
        this.playMode = r1;
    }

    public final void x(List<e> r1) {
        this.regionList = r1;
    }

    public final void y(int r1) {
        this.scale = r1;
    }

    public final void z(int r1) {
        this.scene = r1;
    }
}
