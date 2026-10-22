package com.ss.android.lark.keyboard;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.keyboard.keyboard2.KeyboardImeWrapper;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.keyboard2.j;
import com.ss.android.lark.keyboard.keyboard2.k;
import com.ss.android.lark.keyboard.keyboard2.l;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class KeyboardBuilder {
    public static final /* synthetic */ int g = 0;
    public final Activity a;
    public final Fragment b;
    public Function1<? super d, Unit> c;
    public final List<Pair<c.a<?>, c>> d;
    public KeyboardScene e;
    public Lifecycle f;

    public static final class a {
    }

    public static final class b extends KeyboardBuilder {
        public KeyboardMenu h;
        public KeyboardImeWrapper i;
        public mob.a j;

        public final j b(ViewGroup r10) {
            Intrinsics.checkNotNullParameter(r10, "container");
            Context r2 = r10.getContext();
            final KeyboardMenu r0 = this.h;
            if (r0 != null) goto L5;
            r0 = new KeyboardMenu(r2);
        L5:
            KeyboardImeWrapper r1 = this.i;
            if (r1 != null) goto L8;
            r1 = new KeyboardImeWrapper(getActivity());
        L8:
            KeyboardImeWrapper r3 = r1;
            mob.a r4 = this.j;
            if (r4 != null) goto L11;
            r4 = new l(r2);
        L11:
            mob.a r5 = r4;
            k r6 = new k(this.e, this.f, getActivity(), this.b);
            j r7 = new j(r2, r3, r0, r5, r6);
            Iterator r8 = ((ArrayList) this.d).iterator();
        L13:
            if (r8.hasNext() == false) goto L15;
            Pair r9 = (Pair) r8.next();
            r7.R((c.a) r9.getFirst(), (c) r9.getSecond());
            goto L13
        L15:
            Function0<Unit> r11 = new KeyboardBuilder$ImplNew$build$1$2(this, r0);
            Intrinsics.checkNotNullParameter(r11, "action");
            ((ArrayList) r7.l).add(r11);
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.Keyboard2");
            r7.S(r10);
            return r7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(mob.a r2) {
            Intrinsics.checkNotNullParameter(r2, "element");
            if ((r2 instanceof KeyboardMenu) == false) goto L6;
            this.h = (KeyboardMenu) r2;
            return;
        L6:
            if ((r2 instanceof KeyboardImeWrapper) == false) goto L8;
            this.i = (KeyboardImeWrapper) r2;
            return;
        L8:
            this.j = r2;
        }

        public b(Activity r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            super(r2, r3);
        }
    }

    static {
    }

    public final Activity getActivity() {
        return this.a;
    }

    public KeyboardBuilder(Activity r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = r3;
        this.c = KeyboardBuilder$actionOnBuildKeyboardMenu$1.INSTANCE;
        this.d = new ArrayList();
        this.e = KeyboardScene.UNKNOWN;
    }

    public final <E extends c> void a(c.a<E> r2, E r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "element");
        List<Pair<c.a<?>, c>> r0 = this.d;
        ArrayList r1 = (ArrayList) r0;
        r1.add(TuplesKt.to(r2, r3));
    }
}
