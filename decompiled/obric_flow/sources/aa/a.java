package aa;

import ai.h;
import ai.i;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f149a;

    public a(Gson r5) {
        this.f149a = r5;
    }

    public static a f() {
        return new a(new Gson());
    }

    @Override // ai.h
    public final i c(Type r5) {
        TypeToken<?> r10 = TypeToken.get(r5);
        Gson r11 = this.f149a;
        return new b(r11, r11.getAdapter(r10));
    }

    @Override // ai.h
    public final i d(Type r5, Annotation[] r10) {
        TypeToken<?> r11 = TypeToken.get(r5);
        Gson r12 = this.f149a;
        int r13 = 1;
        return new r(r13, r12, r12.getAdapter(r11));
    }
}
