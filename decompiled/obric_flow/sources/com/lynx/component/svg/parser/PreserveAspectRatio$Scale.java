package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum PreserveAspectRatio$Scale extends Enum<PreserveAspectRatio$Scale> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreserveAspectRatio$Scale f9736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PreserveAspectRatio$Scale f9737b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PreserveAspectRatio$Scale[] f9738c = null;

    static {
        PreserveAspectRatio$Scale r5 = new PreserveAspectRatio$Scale("meet", 0);
        f9736a = r5;
        PreserveAspectRatio$Scale r10 = new PreserveAspectRatio$Scale("slice", 1);
        f9737b = r10;
        f9738c = new PreserveAspectRatio$Scale[]{r5, r10};
    }

    public PreserveAspectRatio$Scale(String r5, int r10) {
        super(r5, r10);
    }

    public static PreserveAspectRatio$Scale valueOf(String r5) {
        return (PreserveAspectRatio$Scale) Enum.valueOf(PreserveAspectRatio$Scale.class, r5);
    }

    public static PreserveAspectRatio$Scale[] values() {
        return (PreserveAspectRatio$Scale[]) f9738c.clone();
    }
}
