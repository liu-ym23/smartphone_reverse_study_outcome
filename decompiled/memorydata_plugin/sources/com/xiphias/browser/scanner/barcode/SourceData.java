package com.xiphias.browser.scanner.barcode;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/xiphias/browser/scanner/barcode/SourceData;", "", "type", "Lcom/xiphias/browser/scanner/barcode/SourceData$Type;", "image", "Landroid/graphics/Bitmap;", "cameraZoomFactor", "", "<init>", "(Lcom/xiphias/browser/scanner/barcode/SourceData$Type;Landroid/graphics/Bitmap;F)V", "getType", "()Lcom/xiphias/browser/scanner/barcode/SourceData$Type;", "getImage", "()Landroid/graphics/Bitmap;", "getCameraZoomFactor", "()F", "toString", "", "Type", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SourceData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f16329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f16330b;
    private final Bitmap c;
    private final float d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/xiphias/browser/scanner/barcode/SourceData$Type;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_CAMERA", "FROM_GALLERY", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FROM_CAMERA = null;
        public static final Type FROM_GALLERY = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{FROM_CAMERA, FROM_GALLERY};
        }

        static {
            FROM_CAMERA = new Type("FROM_CAMERA", 0);
            FROM_GALLERY = new Type("FROM_GALLERY", 1);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xiphias/browser/scanner/barcode/SourceData$Companion;", "", "<init>", "()V", "DEFAULT_CAMERA_ZOOM_FACTOR", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f16329a = new a(null);
    }

    public SourceData(Type r2, Bitmap r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "image");
        this.f16330b = r2;
        this.c = r3;
        this.d = r4;
    }

    public /* synthetic */ SourceData(Type r1, Bitmap r2, float r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 1.0f;
    L5:
        this(r1, r2, r3);
    }

    public final Bitmap a() {
        return this.c;
    }

    public final float b() {
        return this.d;
    }

    public final Type getType() {
        return this.f16330b;
    }

    public String toString() {
        return "SourceData(type=" + this.f16330b + ", cameraZoomFactor=" + this.d + ')';
    }
}
