package androidx.room.compiler.processing;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J+\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u000b\"\b\b\u0001\u0010\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "getValue", "()Ljava/lang/Object;", "getAsAnnotationBox", "", "methodName", "", "getAsAnnotationBoxArray", "", "(Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "getAsType", "Landroidx/room/compiler/processing/XType;", "getAsTypeList", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XAnnotationBox<T> {
    <T extends Annotation> XAnnotationBox<T> getAsAnnotationBox(String r5);

    <T extends Annotation> XAnnotationBox<T>[] getAsAnnotationBoxArray(String r5);

    XType getAsType(String r5);

    List<XType> getAsTypeList(String r5);

    T getValue();
}
