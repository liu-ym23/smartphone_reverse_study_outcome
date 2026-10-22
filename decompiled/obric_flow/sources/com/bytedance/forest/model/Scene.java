package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/model/Scene;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum Scene extends Enum<Scene> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Scene f4345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Scene f4346b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Scene f4347c = null;
    public static final Scene d = null;
    public static final Scene e = null;
    public static final Scene f = null;
    public static final Scene g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Scene f4348h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Scene f4349i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Scene f4350j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Scene f4351k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Scene f4352l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Scene f4353m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Scene f4354n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f4355o = null;

    static {
        Scene r5 = new Scene("LYNX_TEMPLATE", 0);
        f4345a = r5;
        Scene r10 = new Scene("LYNX_EXTERNAL_JS", 1);
        f4346b = r10;
        Scene r11 = new Scene("LYNX_COMPONENT", 2);
        f4347c = r11;
        Scene r12 = new Scene("LYNX_FONT", 3);
        d = r12;
        Scene r13 = new Scene("LYNX_I18N", 4);
        e = r13;
        Scene r14 = new Scene("LYNX_IMAGE", 5);
        f = r14;
        Scene r15 = new Scene("LYNX_LOTTIE", 6);
        g = r15;
        Scene r16 = new Scene("LYNX_VIDEO", 7);
        f4348h = r16;
        Scene r17 = new Scene("LYNX_SVG", 8);
        f4349i = r17;
        Scene r18 = new Scene("LYNX_CHILD_RESOURCE", 9);
        f4350j = r18;
        Scene r19 = new Scene("WEB_MAIN_DOCUMENT", 10);
        f4351k = r19;
        Scene r110 = new Scene("WEB_CHILD_RESOURCE", 11);
        f4352l = r110;
        Scene r111 = new Scene("PRELOAD_CONFIG", 12);
        f4353m = r111;
        Scene r112 = new Scene("OTHER", 13);
        f4354n = r112;
        f4355o = new Scene[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    public Scene(String r5, int r10) {
        super(r5, r10);
    }

    public static Scene valueOf(String r5) {
        return (Scene) Enum.valueOf(Scene.class, r5);
    }

    public static Scene[] values() {
        return (Scene[]) f4355o.clone();
    }
}
