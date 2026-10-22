package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J+\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0013\"\b\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0096\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/compiler/processing/XAnnotationBox;", "obj", "", "(Ljava/lang/Object;)V", "classGetter", "Landroidx/room/compiler/processing/javac/JavacClassGetter;", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/annotation/Annotation;", "Ljava/lang/annotation/Annotation;", "getAsAnnotationBox", "methodName", "", "getAsAnnotationBoxArray", "", "(Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "getAsType", "Landroidx/room/compiler/processing/XType;", "getAsTypeList", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacAnnotationBox<T extends Annotation> implements XAnnotationBox<T> {
    private final JavacClassGetter classGetter;
    private final T value;

    public JavacAnnotationBox(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        this.classGetter = (JavacClassGetter) r5;
        this.value = (T) r5;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <T extends Annotation> XAnnotationBox<T> getAsAnnotationBox(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return this.classGetter.getAsAnnotationBox(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <T extends Annotation> XAnnotationBox<T>[] getAsAnnotationBoxArray(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return this.classGetter.getAsAnnotationBoxArray(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public XType getAsType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return this.classGetter.getAsType(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public List<XType> getAsTypeList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return this.classGetter.getAsTypeList(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public T getValue() {
        return this.value;
    }
}
