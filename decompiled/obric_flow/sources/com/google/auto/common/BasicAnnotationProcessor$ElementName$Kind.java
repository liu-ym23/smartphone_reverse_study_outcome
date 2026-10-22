package com.google.auto.common;

/* JADX INFO: loaded from: classes2.dex */
final enum BasicAnnotationProcessor$ElementName$Kind extends Enum<BasicAnnotationProcessor$ElementName$Kind> {
    public static final BasicAnnotationProcessor$ElementName$Kind PACKAGE_NAME = null;
    public static final BasicAnnotationProcessor$ElementName$Kind TYPE_NAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BasicAnnotationProcessor$ElementName$Kind[] f8617a = null;

    static {
        BasicAnnotationProcessor$ElementName$Kind r5 = new BasicAnnotationProcessor$ElementName$Kind("PACKAGE_NAME", 0);
        PACKAGE_NAME = r5;
        BasicAnnotationProcessor$ElementName$Kind r10 = new BasicAnnotationProcessor$ElementName$Kind("TYPE_NAME", 1);
        TYPE_NAME = r10;
        f8617a = new BasicAnnotationProcessor$ElementName$Kind[]{r5, r10};
    }

    public static BasicAnnotationProcessor$ElementName$Kind valueOf(String r5) {
        return (BasicAnnotationProcessor$ElementName$Kind) Enum.valueOf(BasicAnnotationProcessor$ElementName$Kind.class, r5);
    }

    public static BasicAnnotationProcessor$ElementName$Kind[] values() {
        return (BasicAnnotationProcessor$ElementName$Kind[]) f8617a.clone();
    }
}
