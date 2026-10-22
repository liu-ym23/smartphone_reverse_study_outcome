package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\t\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacClassGetter;", "", "getAsAnnotationBox", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "methodName", "", "getAsAnnotationBoxArray", "", "(Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "getAsType", "Landroidx/room/compiler/processing/XType;", "getAsTypeList", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface JavacClassGetter {
    <T extends Annotation> XAnnotationBox<T> getAsAnnotationBox(String r5);

    <T extends Annotation> XAnnotationBox<T>[] getAsAnnotationBoxArray(String r5);

    XType getAsType(String r5);

    List<XType> getAsTypeList(String r5);
}
