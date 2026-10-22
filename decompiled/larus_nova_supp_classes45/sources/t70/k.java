package t70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class k {
    public final HashMap<Class<? extends View>, Constructor<? extends View>> a;
    public final LayoutInflater b;

    public Context getContext() {
        return this.b.getContext();
    }

    public k(LayoutInflater r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutInflater");
        this.b = r2;
        this.a = new HashMap();
    }

    public <T extends View> T a(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "viewClass");
        if (this.a.containsKey(r5) == false) goto L5;
        GenericDeclaration r6 = this.a.get(r5);
        Intrinsics.checkNotNull(r6);
        Constructor<T> r7 = (Constructor) r6;
    L6:
        T r8 = r7.newInstance(new Object[]{this.b.getContext()});
        if (r8 == null) goto L11;
        return r8;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L5:
        Constructor<T> r0 = r5.getDeclaredConstructor(new Class[]{Context.class});
        this.a.put(r5, r0);
        r7 = r0;
        goto L6
    }

    public View b(int r4) {
        if ((this.b.getContext() instanceof AppCompatActivity) == false) goto L12;
        AppCompatActivity r0 = this.b.getContext();
        if (r0 == null) goto L11;
        x70.b r1 = ViewPools.a(r0);
        if (r1.a(r4) == false) goto L12;
        View r5 = r1.e(r4);
        Intrinsics.checkNotNull(r5);
        return r5;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L12:
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.b.inflate(r4, null);
    }
}
