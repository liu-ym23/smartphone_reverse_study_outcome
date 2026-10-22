package com.xiphias.browser.scanner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0015\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/xiphias/browser/scanner/DocumentScanConfig;", "", "modelDirectory", "", "<init>", "(Ljava/lang/String;)V", "getModelDirectory", "()Ljava/lang/String;", "enhancements", "", "Lcom/xiphias/browser/scanner/DocumentEnhancement;", "getEnhancements", "()Ljava/util/Set;", "setEnhancements", "(Ljava/util/Set;)V", "jpegQuality", "", "getJpegQuality", "()I", "setJpegQuality", "(I)V", "validatedQuality", "validatedQuality$scanner_selectedRelease", "resolvedEnhancements", "resolvedEnhancements$scanner_selectedRelease", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16337a = null;
    private static final Set<DocumentEnhancement> e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16338b;
    private Set<? extends DocumentEnhancement> c;
    private int d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/xiphias/browser/scanner/DocumentScanConfig$Companion;", "", "<init>", "()V", "REQUIRED_ENHANCEMENTS", "", "Lcom/xiphias/browser/scanner/DocumentEnhancement;", "getREQUIRED_ENHANCEMENTS", "()Ljava/util/Set;", "DEFAULT_JPEG_QUALITY", "", "MIN_JPEG_QUALITY", "MAX_JPEG_QUALITY", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f16337a = new a(null);
        e = SetsKt.setOf(DocumentEnhancement.DEBLUR);
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "modelDirectory");
        this.f16338b = r2;
        this.c = SetsKt.emptySet();
        this.d = 95;
    }

    public final String a() {
        return this.f16338b;
    }

    public final void a(int r1) {
        this.d = r1;
    }

    public final void a(Set<? extends DocumentEnhancement> r3) {
        Set<? extends DocumentEnhancement> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.c = r4;
    }

    public final Set<DocumentEnhancement> b() {
        return this.c;
    }

    public final int c() {
        return RangesKt.coerceIn(this.d, 60, 100);
    }
}
