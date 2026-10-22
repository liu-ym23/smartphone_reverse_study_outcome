package av;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f796b;

    public /* synthetic */ h(String r5, int r10) {
        this.f795a = r10;
        this.f796b = r5;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r5, String r10) {
        switch(this.f795a) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            default: goto L5;
        };
    L5:
        if (r10.endsWith(this.f796b) == true) goto L7;
    L9:
        return false;
    L7:
        if (Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(r10).matches() == false) goto L9;
        return true;
    L12:
        return r10.equals(this.f796b);
    L14:
        return r10.contains(this.f796b);
    L16:
        return r10.contains(this.f796b);
    L18:
        return r10.contains(this.f796b);
    L20:
        return r10.contains(this.f796b);
    L22:
        if (r10.startsWith(this.f796b) == true) goto L24;
    L26:
        return false;
    L24:
        if (r10.endsWith(".lck") == true) goto L26;
        return true;
    }

    public h() {
        this.f795a = 0;
        this.f796b = "sqlite-" + i.q();
    }
}
