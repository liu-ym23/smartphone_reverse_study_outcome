package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "()V", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", TypedValues.AttributesType.S_TARGET, "followLinks", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DefaultCopyActionContext implements CopyActionContext {
    public static final DefaultCopyActionContext INSTANCE = null;

    static {
        INSTANCE = new DefaultCopyActionContext();
    }

    private DefaultCopyActionContext() {
    }

    @Override // kotlin.io.path.CopyActionContext
    public CopyActionResult copyToIgnoringExistingDirectory(Path r5, Path r6, boolean r7) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r8, TypedValues.AttributesType.S_TARGET);
        LinkOption[] r9 = LinkFollowing.INSTANCE.toLinkOptions(r7);
        LinkOption[] r10 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r9, r9.length), LinkOption[].class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r10, r10.length), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L5;
    L6:
        CopyOption[] r11 = (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r9, r9.length), CopyOption[].class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(Files.copy(r4, r8, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r11, r11.length), CopyOption[].class, "com.obric.memorydata.plugin")), "copy(...)");
    L8:
        return CopyActionResult.CONTINUE;
    L5:
        if (Files.isDirectory(r8, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L8;
        goto L6
    }
}
