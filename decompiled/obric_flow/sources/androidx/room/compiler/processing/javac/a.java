package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.ksp.KspAnnotationBox;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f576b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f575a = r10;
        this.f576b = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object[] r11) {
        int r12 = this.f575a;
        Object r13 = this.f576b;
        switch(r12) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return KspAnnotationBox.a((KspAnnotationBox) r13, r5, r10, r11);
    L7:
        return JavacAnnotationBoxKt.a((LinkedHashMap) r13, r5, r10, r11);
    }
}
