package com.squareup.kotlinpoet;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"com/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget", "", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "", "keyword", "Ljava/lang/String;", "getKeyword$kotlinpoet", "()Ljava/lang/String;", "FILE", "PROPERTY", "FIELD", "GET", "SET", "RECEIVER", "PARAM", "SETPARAM", "DELEGATE", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum AnnotationSpec$UseSiteTarget extends Enum<AnnotationSpec$UseSiteTarget> {
    public static final AnnotationSpec$UseSiteTarget DELEGATE = null;
    public static final AnnotationSpec$UseSiteTarget FIELD = null;
    public static final AnnotationSpec$UseSiteTarget FILE = null;
    public static final AnnotationSpec$UseSiteTarget GET = null;
    public static final AnnotationSpec$UseSiteTarget PARAM = null;
    public static final AnnotationSpec$UseSiteTarget PROPERTY = null;
    public static final AnnotationSpec$UseSiteTarget RECEIVER = null;
    public static final AnnotationSpec$UseSiteTarget SET = null;
    public static final AnnotationSpec$UseSiteTarget SETPARAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnotationSpec$UseSiteTarget[] f15067a = null;
    private final String keyword;

    static {
        AnnotationSpec$UseSiteTarget r5 = new AnnotationSpec$UseSiteTarget("FILE", 0, "file");
        FILE = r5;
        AnnotationSpec$UseSiteTarget r10 = new AnnotationSpec$UseSiteTarget("PROPERTY", 1, "property");
        PROPERTY = r10;
        AnnotationSpec$UseSiteTarget r11 = new AnnotationSpec$UseSiteTarget("FIELD", 2, "field");
        FIELD = r11;
        AnnotationSpec$UseSiteTarget r12 = new AnnotationSpec$UseSiteTarget("GET", 3, "get");
        GET = r12;
        AnnotationSpec$UseSiteTarget r13 = new AnnotationSpec$UseSiteTarget("SET", 4, "set");
        SET = r13;
        AnnotationSpec$UseSiteTarget r14 = new AnnotationSpec$UseSiteTarget("RECEIVER", 5, "receiver");
        RECEIVER = r14;
        AnnotationSpec$UseSiteTarget r15 = new AnnotationSpec$UseSiteTarget("PARAM", 6, "param");
        PARAM = r15;
        AnnotationSpec$UseSiteTarget r16 = new AnnotationSpec$UseSiteTarget("SETPARAM", 7, "setparam");
        SETPARAM = r16;
        AnnotationSpec$UseSiteTarget r17 = new AnnotationSpec$UseSiteTarget("DELEGATE", 8, "delegate");
        DELEGATE = r17;
        f15067a = new AnnotationSpec$UseSiteTarget[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public AnnotationSpec$UseSiteTarget(String r5, int r10, String r11) {
        super(r5, r10);
        this.keyword = r11;
    }

    public static AnnotationSpec$UseSiteTarget valueOf(String r5) {
        return (AnnotationSpec$UseSiteTarget) Enum.valueOf(AnnotationSpec$UseSiteTarget.class, r5);
    }

    public static AnnotationSpec$UseSiteTarget[] values() {
        return (AnnotationSpec$UseSiteTarget[]) f15067a.clone();
    }

    public final String getKeyword$kotlinpoet() {
        return this.keyword;
    }
}
