package ja;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public final class k implements t<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Type f8765a;

    public k(Type r8) {
        this.f8765a = r8;
    }

    @Override // ja.t
    public final Object b() {
        Type r8 = this.f8765a;
        if ((r8 instanceof ParameterizedType) == false) goto L11;
        Type r10 = ((ParameterizedType) r8).getActualTypeArguments()[0];
        if ((r10 instanceof Class) == false) goto L9;
        return EnumSet.noneOf((Class) r10);
    L9:
        throw new ha.q("Invalid EnumSet type: " + r8.toString());
    L11:
        throw new ha.q("Invalid EnumSet type: " + r8.toString());
    }
}
