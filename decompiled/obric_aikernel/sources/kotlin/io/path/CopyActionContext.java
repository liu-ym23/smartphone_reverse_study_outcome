package kotlin.io.path;

import java.nio.file.Path;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.8")
@ExperimentalPathApi
public interface CopyActionContext {
    CopyActionResult copyToIgnoringExistingDirectory(Path r10, Path r11, boolean r12);
}
