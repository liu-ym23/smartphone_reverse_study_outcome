package i1;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f8084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataSetObserver f8085b;

    public a() {
        this.f8084a = new DataSetObservable();
    }

    public abstract int a();
}
