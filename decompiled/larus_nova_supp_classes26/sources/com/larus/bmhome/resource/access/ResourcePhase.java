package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourcePhase;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "VALIDATE", "REMOTE_RESOLVE", "POLICY", "PREPROCESS", "DETECT", "UPLOAD", "REMOTE_DIRECT", "REVIEW", "POST_PROCESS", "CACHE", "REMOTE_FALLBACK", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourcePhase extends Enum<ResourcePhase> {
    public static final ResourcePhase CACHE = null;
    public static final ResourcePhase DETECT = null;
    public static final ResourcePhase POLICY = null;
    public static final ResourcePhase POST_PROCESS = null;
    public static final ResourcePhase PREPROCESS = null;
    public static final ResourcePhase REMOTE_DIRECT = null;
    public static final ResourcePhase REMOTE_FALLBACK = null;
    public static final ResourcePhase REMOTE_RESOLVE = null;
    public static final ResourcePhase REVIEW = null;
    public static final ResourcePhase UPLOAD = null;
    public static final ResourcePhase VALIDATE = null;
    public static final /* synthetic */ ResourcePhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int order;

    public static EnumEntries<ResourcePhase> getEntries() {
        return b;
    }

    static {
        ResourcePhase r0 = new ResourcePhase("VALIDATE", 0, 10);
        VALIDATE = r0;
        ResourcePhase r1 = new ResourcePhase("REMOTE_RESOLVE", 1, 15);
        REMOTE_RESOLVE = r1;
        ResourcePhase r4 = new ResourcePhase("POLICY", 2, 18);
        POLICY = r4;
        ResourcePhase r5 = new ResourcePhase("PREPROCESS", 3, 20);
        PREPROCESS = r5;
        ResourcePhase r7 = new ResourcePhase("DETECT", 4, 30);
        DETECT = r7;
        ResourcePhase r9 = new ResourcePhase("UPLOAD", 5, 40);
        UPLOAD = r9;
        ResourcePhase r11 = new ResourcePhase("REMOTE_DIRECT", 6, 45);
        REMOTE_DIRECT = r11;
        ResourcePhase r13 = new ResourcePhase("REVIEW", 7, 50);
        REVIEW = r13;
        ResourcePhase r14 = new ResourcePhase("POST_PROCESS", 8, 60);
        POST_PROCESS = r14;
        ResourcePhase r12 = new ResourcePhase("CACHE", 9, 70);
        CACHE = r12;
        ResourcePhase r10 = new ResourcePhase("REMOTE_FALLBACK", 10, 80);
        REMOTE_FALLBACK = r10;
        ResourcePhase[] r8 = {r0, r1, r4, r5, r7, r9, r11, r13, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static ResourcePhase[] values() {
        return (ResourcePhase[]) a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static ResourcePhase valueOf(String r1) {
        return (ResourcePhase) r27.a.a(ResourcePhase.class, r1);
    }

    public ResourcePhase(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }
}
