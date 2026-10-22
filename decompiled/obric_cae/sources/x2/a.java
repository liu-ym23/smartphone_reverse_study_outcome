package x2;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f13366a;

    public a(b r8, String r10, String r11, JSONObject r12) {
        this.f13366a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<u2.a> r8 = this.f13366a.f13368a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().a();
        goto L4
    }
}
