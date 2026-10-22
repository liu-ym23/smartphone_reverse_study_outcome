package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
public final class LinkFollowing {
    public static final LinkFollowing INSTANCE = null;
    private static final LinkOption[] followLinkOption = null;
    private static final Set<FileVisitOption> followVisitOption = null;
    private static final LinkOption[] nofollowLinkOption = null;
    private static final Set<FileVisitOption> nofollowVisitOption = null;

    static {
        INSTANCE = new LinkFollowing();
        nofollowLinkOption = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        followLinkOption = new LinkOption[0];
        nofollowVisitOption = SetsKt.emptySet();
        followVisitOption = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    }

    private LinkFollowing() {
    }

    public final LinkOption[] toLinkOptions(boolean r10) {
        if (r10 == false) goto L5;
        return followLinkOption;
    L5:
        return nofollowLinkOption;
    }

    public final Set<FileVisitOption> toVisitOptions(boolean r10) {
        if (r10 == false) goto L5;
        return followVisitOption;
    L5:
        return nofollowVisitOption;
    }
}
