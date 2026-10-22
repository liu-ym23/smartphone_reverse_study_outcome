package f8;

import com.bytedance.common.utility.reflect.Reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Reflect f16883b;

    public a(Reflect r5, boolean r10) {
        this.f16883b = r5;
        this.f16882a = r10;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object[] r11) {
        Reflect r12 = this.f16883b;
        String r13 = r10.getName();
        return Reflect.on(Reflect.access$100(r12)).call(r13, Reflect.access$000(r11), r11).get();
    L5:
        e = move-exception;
        if (this.f16882a == false) goto L29;
        Map r14 = (Map) Reflect.access$100(r12);
        if (r11 != null) goto L11;
        int r15 = 0;
    L13:
        if (r15 == 0) goto L15;
    L18:
        if (r15 != 0) goto L24;
        if (r13.startsWith("is") == false) goto L24;
        return r14.get(Reflect.access$200(r13.substring(2)));
    L24:
        if (r15 != 1) goto L29;
        if (r13.startsWith("set") == false) goto L29;
        r14.put(Reflect.access$200(r13.substring(3)), r11[0]);
        return null;
    L15:
        if (r13.startsWith("get") == false) goto L18;
        return r14.get(Reflect.access$200(r13.substring(3)));
    L11:
        r15 = r11.length;
    L29:
        throw e;
    }
}
