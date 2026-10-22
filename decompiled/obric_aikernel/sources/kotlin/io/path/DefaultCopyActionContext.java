package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalPathApi
final class DefaultCopyActionContext implements CopyActionContext {
    public static final DefaultCopyActionContext INSTANCE = null;

    static {
        INSTANCE = new DefaultCopyActionContext();
    }

    private DefaultCopyActionContext() {
    }

    @Override // kotlin.io.path.CopyActionContext
    public CopyActionResult copyToIgnoringExistingDirectory(Path r10, Path r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        LinkOption[] r13 = LinkFollowing.INSTANCE.toLinkOptions(r12);
        LinkOption[] r14 = (LinkOption[]) Arrays.copyOf(r13, r13.length);
        if (Files.isDirectory(r10, (LinkOption[]) Arrays.copyOf(r14, r14.length)) == true) goto L5;
    L6:
        CopyOption[] r15 = (CopyOption[]) Arrays.copyOf(r13, r13.length);
        Intrinsics.checkNotNullExpressionValue(Files.copy(r10, r11, (CopyOption[]) Arrays.copyOf(r15, r15.length)), "copy(this, target, *options)");
    L8:
        return CopyActionResult.CONTINUE;
    L5:
        if (Files.isDirectory(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == true) goto L8;
        goto L6
    }
}
