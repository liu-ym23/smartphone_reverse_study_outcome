package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes6.dex */
public class RegexFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 4269646126155225062L;
    private final Function<Path, String> pathToString;
    private final Pattern pattern;

    public RegexFileFilter(String r2) {
        this(r2, 0);
    }

    public RegexFileFilter(String r1, int r2) {
        this(compile(r1, r2));
    }

    public RegexFileFilter(String r1, IOCase r2) {
        this(compile(r1, toFlags(r2)));
    }

    public RegexFileFilter(Pattern r2) {
        this(r2, $$Lambda$RegexFileFilter$ERyOkDrDv3vpojO5bvdxL6QfI.INSTANCE);
    }

    public RegexFileFilter(Pattern r3, Function<Path, String> r4) {
        Function<Path, String> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        this.pattern = r3;
        this.pathToString = r5;
        return;
    L7:
        throw new IllegalArgumentException("Pattern is missing");
    }

    private static Pattern compile(String r0, int r1) {
        if (r0 == null) goto L6;
        return Pattern.compile(r0, r1);
    L6:
        throw new IllegalArgumentException("Pattern is missing");
    }

    static /* synthetic */ String lambda$new$0(Path r2) {
        return ((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin")).getFileName().toString();
    }

    private static int toFlags(IOCase r0) {
        if (IOCase.isCaseSensitive(r0) == false) goto L5;
        return 2;
    L5:
        return 0;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(this.pattern.matcher((CharSequence) ZeusTransformUtils.preCheckCast(this.pathToString.apply(r5), CharSequence.class, "com.obric.memorydata.plugin")).matches(), r5);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return this.pattern.matcher(r2).matches();
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return "RegexFileFilter [pattern=" + this.pattern + "]";
    }
}
