package t70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.RecyclableTetrisElement;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends k {
    public final HashMap<Class<? extends View>, Constructor<? extends View>> c;
    public final RecyclableTetrisElement d;

    @Override // t70.k
    public Context getContext() {
        return this.b.getContext();
    }

    @Override // t70.k
    public final <T extends View> T a(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "viewClass");
        if (this.c.containsKey(r5) == false) goto L5;
        GenericDeclaration r6 = this.c.get(r5);
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
        this.c.put(r5, r0);
        r7 = r0;
        goto L6
    }

    @Override // t70.k
    public final View b(int r4) {
        if (d80.d.a() == false) goto L8;
        RecyclableTetrisElement.u.getClass();
        View r0 = (View) ((HashMap) RecyclableTetrisElement.t).get(this.d.o.getClass());
        if (r0 == null) goto L8;
        return r0;
    L8:
        if ((this.b.getContext() instanceof AppCompatActivity) == false) goto L17;
        AppCompatActivity r1 = this.b.getContext();
        if (r1 == null) goto L16;
        x70.b r2 = ViewPools.a(r1);
        if (r2.a(r4) == false) goto L17;
        View r5 = r2.e(r4);
        Intrinsics.checkNotNull(r5);
        return r5;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L17:
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.b.inflate(r4, null);
    }

    public g(LayoutInflater r2, RecyclableTetrisElement r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutInflater");
        Intrinsics.checkNotNullParameter(r3, "recyclableTetrisElement");
        super(r2);
        this.d = r3;
        this.c = new HashMap();
    }
}
