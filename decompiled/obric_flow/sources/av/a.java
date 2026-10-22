package av;

import java.util.regex.Pattern;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f782c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f784b;

    static {
        f782c = Pattern.compile("backup(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+to\\s+(\"[^\"]*\"|'[^']*'|\\S+)", 2);
    }

    public a(String r5, String r10) {
        this.f783a = r5;
        this.f784b = r10;
    }

    @Override // av.c
    public final void a(NativeDB r5) {
        r5.getClass();
        r5.backup(NativeDB.o(this.f783a), NativeDB.o(this.f784b), null);
    }
}
