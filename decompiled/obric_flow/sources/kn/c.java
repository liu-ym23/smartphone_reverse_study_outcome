package kn;

import com.lynx.tasm.common.NullableConcurrentHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map.Entry f18689b;

    public /* synthetic */ c() {
        this.f18688a = 1;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch(this.f18688a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Map.Entry r5 = this.f18689b;
        if (r5 != null) goto L8;
        return null;
    L8:
        return (String) r5.getKey();
    L9:
        Object r10 = this.f18689b.getKey();
        if (r10 != NullableConcurrentHashMap.f10824a) goto L14;
        return null;
    L14:
        return r10;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        switch(this.f18688a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        Map.Entry r5 = this.f18689b;
        if (r5 == null) goto L11;
        if ((r5.getValue() instanceof Long) == false) goto L11;
        return (Long) this.f18689b.getValue();
    L11:
        return -1L;
    L12:
        Object r10 = this.f18689b.getValue();
        if (r10 != NullableConcurrentHashMap.f10824a) goto L17;
        return null;
    L17:
        return r10;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r5) {
        switch(this.f18688a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Long r10 = (Long) r5;
        return null;
    L6:
        if (r5 != null) goto L9;
        r5 = NullableConcurrentHashMap.f10824a;
    L9:
        return this.f18689b.setValue(r5);
    }

    public c(Map.Entry r5) {
        this.f18688a = 0;
        this.f18689b = r5;
    }
}
