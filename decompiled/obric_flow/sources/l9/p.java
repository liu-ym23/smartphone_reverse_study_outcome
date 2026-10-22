package l9;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19585a;

    public /* synthetic */ p(int r5) {
        this.f19585a = r5;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r5, String r10) {
        switch(this.f19585a) {
            case 0: goto L36;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L17;
            case 4: goto L15;
            default: goto L5;
        };
    L5:
        if (r10.endsWith(".hoting") == false) goto L8;
        return true;
    L8:
        if (r10.endsWith(".hot") == true) goto L10;
    L12:
        return false;
    L10:
        if (r10.endsWith(".alog.hot") == true) goto L12;
        return true;
    L15:
        return r10.startsWith(".logCache_");
    L17:
        if (r10.endsWith(".hoting") == false) goto L20;
        return true;
    L20:
        if (r10.endsWith(".hot") == true) goto L22;
    L24:
        return false;
    L22:
        if (r10.endsWith(".alog.hot") == true) goto L24;
        return true;
    L27:
        return r10.startsWith(".logCache_");
    L29:
        if (r10.contains(".ctx") == true) goto L31;
    L33:
        return false;
    L31:
        if (Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(r10).matches() == false) goto L33;
        return true;
    L36:
        return r10.endsWith(".txt");
    }
}
