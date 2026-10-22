package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.internal.x;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f19239a;

    public j(x r5) {
        this.f19239a = r5;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new i(this.f19239a);
    }
}
