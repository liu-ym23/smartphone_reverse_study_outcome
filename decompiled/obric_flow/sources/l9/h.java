package l9;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19563a;

    public h(String r5) {
        this.f19563a = r5;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        return r5.getName().endsWith(this.f19563a);
    }
}
