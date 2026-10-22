package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.7")
@ExperimentalPathApi
public interface FileVisitorBuilder {
    void onPostVisitDirectory(Function2<? super Path, ? super IOException, ? extends FileVisitResult> r10);

    void onPreVisitDirectory(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r10);

    void onVisitFile(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r10);

    void onVisitFileFailed(Function2<? super Path, ? super IOException, ? extends FileVisitResult> r10);
}
