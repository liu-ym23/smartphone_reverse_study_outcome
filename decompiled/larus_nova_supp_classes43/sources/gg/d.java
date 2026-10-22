package gg;

import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ hg.a a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ List f;

    public d(hg.a r1, List r10, String r11, String r12, String r13, List r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final void accept(Object r10) {
        Long r11 = (Long) r10;
        ConcurrentHashMap<String, Map<String, hg.a>> r12 = c.a;
        c.b(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
