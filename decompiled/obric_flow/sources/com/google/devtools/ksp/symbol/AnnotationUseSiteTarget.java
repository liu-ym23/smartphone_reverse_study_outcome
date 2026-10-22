package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/google/devtools/ksp/symbol/AnnotationUseSiteTarget;", "", "FILE", "PROPERTY", "FIELD", "GET", "SET", "RECEIVER", "PARAM", "SETPARAM", "DELEGATE", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum AnnotationUseSiteTarget extends Enum<AnnotationUseSiteTarget> {
    public static final AnnotationUseSiteTarget DELEGATE = null;
    public static final AnnotationUseSiteTarget FIELD = null;
    public static final AnnotationUseSiteTarget FILE = null;
    public static final AnnotationUseSiteTarget GET = null;
    public static final AnnotationUseSiteTarget PARAM = null;
    public static final AnnotationUseSiteTarget PROPERTY = null;
    public static final AnnotationUseSiteTarget RECEIVER = null;
    public static final AnnotationUseSiteTarget SET = null;
    public static final AnnotationUseSiteTarget SETPARAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnotationUseSiteTarget[] f9450a = null;

    static {
        AnnotationUseSiteTarget r5 = new AnnotationUseSiteTarget("FILE", 0);
        FILE = r5;
        AnnotationUseSiteTarget r10 = new AnnotationUseSiteTarget("PROPERTY", 1);
        PROPERTY = r10;
        AnnotationUseSiteTarget r11 = new AnnotationUseSiteTarget("FIELD", 2);
        FIELD = r11;
        AnnotationUseSiteTarget r12 = new AnnotationUseSiteTarget("GET", 3);
        GET = r12;
        AnnotationUseSiteTarget r13 = new AnnotationUseSiteTarget("SET", 4);
        SET = r13;
        AnnotationUseSiteTarget r14 = new AnnotationUseSiteTarget("RECEIVER", 5);
        RECEIVER = r14;
        AnnotationUseSiteTarget r15 = new AnnotationUseSiteTarget("PARAM", 6);
        PARAM = r15;
        AnnotationUseSiteTarget r16 = new AnnotationUseSiteTarget("SETPARAM", 7);
        SETPARAM = r16;
        AnnotationUseSiteTarget r17 = new AnnotationUseSiteTarget("DELEGATE", 8);
        DELEGATE = r17;
        f9450a = new AnnotationUseSiteTarget[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public static AnnotationUseSiteTarget valueOf(String r5) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, r5);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) f9450a.clone();
    }
}
