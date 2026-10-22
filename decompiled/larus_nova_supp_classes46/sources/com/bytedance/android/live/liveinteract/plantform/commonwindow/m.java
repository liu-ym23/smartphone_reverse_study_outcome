package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001:\u0006>?\f\u0013@:B\u0007¢\u0006\u0004\b<\u0010=R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010$\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\"\u00103\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\"\u00106\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\"\u00109\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "Ltf0/j;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "uiContainer", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "t", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "E", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "canvasParams", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "c", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "u", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "contentParams", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "d", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "v", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$d;", "regionList", "Ljava/util/List;", "h", "()Ljava/util/List;", "y", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$e;", "seatList", "k", "A", "", "scene", "I", "j", "()I", "z", "(I)V", "uiLayout", "getUiLayout", "F", "playMode", "g", "x", "spatialId", "n", "D", "seiVersion", "m", "C", "seiSubScene", "l", "B", "orientation", "f", "w", "<init>", "()V", "a", "b", "e", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m implements tf0.j {
    public boolean a;
    public int b;
    public boolean c;

    @SerializedName("canvas")
    private a canvasParams;

    @SerializedName("content")
    private c contentParams;
    public pn0.f d;
    public List<Integer> e;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName("play_mode")
    private int playMode;

    @SerializedName("regions")
    private List<d> regionList;

    @SerializedName("scene")
    private int scene;

    @SerializedName("seats")
    private List<e> seatList;

    @SerializedName("sei_sub_scene")
    private int seiSubScene;

    @SerializedName("sei_ver")
    private int seiVersion;

    @SerializedName("spatial_id")
    private int spatialId;

    @SerializedName("ui_container")
    private f uiContainer;

    @SerializedName("ui_layout")
    private int uiLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0004\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$a;", "", "", "width", "I", "f", "()I", "k", "(I)V", "height", "d", "i", "scale", "e", "j", "getScale$annotations", "()V", "align", "b", "g", "getAlign$annotations", "", "backgroundColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "<init>", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("align")
        private int align;

        @SerializedName("background_color")
        private String backgroundColor;

        @SerializedName("h")
        private int height;

        @SerializedName("scale")
        private int scale;

        @SerializedName("w")
        private int width;

        public final a a() {
            a r0 = new a();
            r0.width = this.width;
            r0.height = this.height;
            r0.scale = this.scale;
            r0.align = this.align;
            return r0;
        }

        public a() {
            this.scale = 1;
            this.align = 8;
            this.backgroundColor = "#322542";
        }

        public final int b() {
            return this.align;
        }

        public final String c() {
            return this.backgroundColor;
        }

        public final int d() {
            return this.height;
        }

        public final int e() {
            return this.scale;
        }

        public final int f() {
            return this.width;
        }

        public final void g(int r1) {
            this.align = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.backgroundColor = r2;
        }

        public final void i(int r1) {
            this.height = r1;
        }

        public final void j(int r1) {
            this.scale = r1;
        }

        public final void k(int r1) {
            this.width = r1;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$c;", "", "", "x", "I", "d", "()I", "h", "(I)V", "y", "e", "i", "width", "c", "g", "height", "b", "f", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("h")
        private int height;

        @SerializedName("w")
        private int width;

        @SerializedName("x")
        private int x;

        @SerializedName("y")
        private int y;

        public c() {
        }

        public final c a() {
            c r0 = new c();
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

        public final int d() {
            return this.x;
        }

        public final int e() {
            return this.y;
        }

        public final void f(int r1) {
            this.height = r1;
        }

        public final void g(int r1) {
            this.width = r1;
        }

        public final void h(int r1) {
            this.x = r1;
        }

        public final void i(int r1) {
            this.y = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$d;", "", "", "zOrder", "I", "g", "()I", "m", "(I)V", "position", "c", "i", "", "x", "D", "e", "()D", "k", "(D)V", "y", "f", "l", "width", "d", "j", "height", "b", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

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

        public d() {
        }

        public final d a() {
            d r0 = new d();
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$e;", "", "", "zOrder", "I", "g", "()I", "m", "(I)V", "position", "c", "i", "", "x", "D", "e", "()D", "k", "(D)V", "y", "f", "l", "width", "d", "j", "height", "b", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m$f;", "", "", "topDp", "I", "e", "()I", "i", "(I)V", "leftDp", "c", "g", "bottomDp", "b", "f", "rightDp", "d", "h", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f {

        @SerializedName("bottom")
        private int bottomDp;

        @SerializedName("left")
        private int leftDp;

        @SerializedName("right")
        private int rightDp;

        @SerializedName("top")
        private int topDp;

        public f() {
        }

        public final f a() {
            f r0 = new f();
            r0.topDp = this.topDp;
            r0.rightDp = this.rightDp;
            r0.bottomDp = this.bottomDp;
            r0.leftDp = this.leftDp;
            return r0;
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

    @Override // tf0.j
    public final String a() {
        return "linkWindowLayoutConfig: (scene=" + this.scene + ",uiLayout=" + this.uiLayout + ",seiVer=" + this.seiVersion + ')';
    }

    public final m b() {
        m r0 = new m();
        r0.scene = this.scene;
        r0.uiLayout = this.uiLayout;
        r0.seiVersion = this.seiVersion;
        r0.spatialId = this.spatialId;
        f r1 = this.uiContainer;
        c r2 = null;
        if (r1 == null) goto L5;
        f r3 = r1.a();
    L6:
        r0.uiContainer = r3;
        a r4 = this.canvasParams;
        if (r4 == null) goto L9;
        a r5 = r4.a();
    L10:
        r0.canvasParams = r5;
        c r6 = this.contentParams;
        if (r6 == null) goto L13;
        r2 = r6.a();
    L13:
        r0.contentParams = r2;
        List<d> r7 = this.regionList;
        ArrayList r8 = new ArrayList();
        int r9 = 0;
        if (r7 == null) goto L19;
        int r10 = r7.size();
        int r11 = 0;
    L17:
        if (r11 >= r10) goto L19;
        r8.add(((d) ListProtector.get(r7, r11)).a());
        r11 = r11 + 1;
    L19:
        r0.regionList = r8;
        List<e> r12 = this.seatList;
        ArrayList r13 = new ArrayList();
        if (r12 == null) goto L25;
        int r14 = r12.size();
    L23:
        if (r9 >= r14) goto L25;
        r13.add(((e) ListProtector.get(r12, r9)).a());
        r9 = r9 + 1;
    L25:
        r0.seatList = r13;
        r0.a = this.a;
        r0.b = this.b;
        r0.d = this.d;
        return r0;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(l97.a.a, this);
    }

    public m() {
        this.spatialId = -1;
        this.a = true;
    }

    public final a c() {
        return this.canvasParams;
    }

    public final c d() {
        return this.contentParams;
    }

    public final int e() {
        return this.orientation;
    }

    public final int f() {
        return this.orientation;
    }

    public final int g() {
        return this.playMode;
    }

    @Override // tf0.j
    public final int getUiLayout() {
        return this.uiLayout;
    }

    public final List<d> h() {
        return this.regionList;
    }

    public final List<Object> i() {
        return this.regionList;
    }

    public final int j() {
        return this.scene;
    }

    public final List<e> k() {
        return this.seatList;
    }

    public final int l() {
        return this.seiSubScene;
    }

    public final int m() {
        return this.seiVersion;
    }

    public final int n() {
        return this.spatialId;
    }

    public final f t() {
        return this.uiContainer;
    }

    public final void A(List<e> r1) {
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

    public final void E(f r1) {
        this.uiContainer = r1;
    }

    public final void F(int r1) {
        this.uiLayout = r1;
    }

    public final int o(int r2) {
        b03.a r0 = b03.a.a;
        float r3 = r2 / s1.w();
        f r1 = this.uiContainer;
        if (r1 == null) goto L5;
        int r4 = r1.b();
    L7:
        return (int) (r3 * b03.c.b(r4));
    L5:
        r4 = 0;
        goto L7
    }

    public final int p(int r2) {
        b03.a r0 = b03.a.a;
        float r3 = r2 / s1.w();
        f r1 = this.uiContainer;
        if (r1 == null) goto L5;
        int r4 = r1.d();
    L7:
        return (int) (r3 * b03.c.b(r4));
    L5:
        r4 = 0;
        goto L7
    }

    public final int q(int r5) {
        f r0 = this.uiContainer;
        if (r0 == null) goto L5;
        int r1 = r0.e();
    L6:
        int r2 = b03.c.b(r1);
        if (((Boolean) vm2.i.L.getValue(null, vm2.i.a[36])).booleanValue() == true) goto L9;
    L12:
        b03.a r3 = b03.a.a;
        return (int) ((r5 / s1.w()) * r2);
    L9:
        if (this.a == true) goto L12;
        if (r2 <= 0) goto L12;
        b03.a r4 = b03.a.a;
        r2 = r2 + s1.A();
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    public final int r(int r3) {
        f r0 = this.uiContainer;
        if (r0 == null) goto L5;
        int r1 = r0.e();
    L6:
        int r2 = b03.c.b(r1);
        b03.a r4 = b03.a.a;
        return (int) ((r3 / s1.w()) * r2);
    L5:
        r1 = 0;
        goto L6
    }

    public final void u(a r1) {
        this.canvasParams = r1;
    }

    public final void v(c r1) {
        this.contentParams = r1;
    }

    public final void w(int r1) {
        this.orientation = r1;
    }

    public final void x(int r1) {
        this.playMode = r1;
    }

    public final void y(List<d> r1) {
        this.regionList = r1;
    }

    public final void z(int r1) {
        this.scene = r1;
    }

    public final float s(int r6, int r7) {
        float r8 = r6;
        c r0 = this.contentParams;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        float r1 = r0.c();
        c r2 = this.contentParams;
        Intrinsics.checkNotNull(r2);
        float r3 = r1 / r2.b();
    L6:
        float r4 = r8 / r3;
        b03.a r5 = b03.a.a;
        float r9 = ((s1.w() - q(r7)) - o(r7)) * (r7 / s1.w());
        a r10 = this.canvasParams;
        if (r10 == null) goto L36;
        if (r10.e() != 2) goto L36;
        yz0.g r11 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r11 == null) goto L13;
        boolean r12 = r11.isAnchor();
    L15:
        if (((Boolean) vm2.i.M.getValue(null, vm2.i.a[37])).booleanValue() == false) goto L37;
        if (r12 == false) goto L18;
    L21:
        int r13 = this.uiLayout;
        if (r13 != 1) goto L24;
    L29:
        c r14 = this.contentParams;
        if (r14 == null) goto L37;
        float r15 = r8 / r9;
        Intrinsics.checkNotNull(r14);
        float r16 = r14.c();
        c r17 = this.contentParams;
        Intrinsics.checkNotNull(r17);
        if (r15 <= (r16 / r17.b())) goto L37;
        return r4;
    L24:
        if (r13 == 6) goto L29;
        if (r13 == 9) goto L29;
        if (r13 != 112) goto L37;
    L18:
        if (b03.a.b() == true) goto L21;
        if (b03.a.a() == true) goto L21;
    L37:
        return r9;
    L13:
        r12 = false;
    L36:
        return Math.min(r4, r9);
    L5:
        r3 = 1.0f;
        goto L6
    }
}
