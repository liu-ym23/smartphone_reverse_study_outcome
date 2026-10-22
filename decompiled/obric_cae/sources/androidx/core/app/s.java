package androidx.core.app;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f1671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1672b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public s(Context r8) {
        this.f1671a = new ArrayList();
        this.f1672b = r8;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f1671a.iterator();
    }
}
