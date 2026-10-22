package lf8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import ei9.e;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final q0 b(BaseMessageListCell<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        RecyclerView r4 = r3.b;
        if (r4 == null) goto L5;
        RecyclerView.Adapter r5 = r4.getAdapter();
    L7:
        if ((r5 instanceof q0) == false) goto L10;
        return (q0) r5;
    L10:
        if ((r5 instanceof ConcatAdapter) == false) goto L12;
        ConcatAdapter r6 = (ConcatAdapter) r5;
    L13:
        if (r6 == null) goto L24;
        List r7 = r6.getAdapters();
        if (r7 == null) goto L24;
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r1 = r8.next();
        if ((((RecyclerView.Adapter) r1) instanceof q0) == false) goto L18;
    L23:
        RecyclerView.Adapter r2 = (RecyclerView.Adapter) r1;
    L26:
        if ((r2 instanceof q0) == true) goto L28;
        return null;
    L28:
        return (q0) r2;
    L22:
        r1 = null;
    L24:
        r2 = null;
        goto L26
    L12:
        r6 = null;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public static final Fragment d(BaseMessageListCell<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RecyclerView r2 = r1.b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return e.b(r2);
    }

    public static final void e(View r2) {
        ViewGroup r0 = null;
        if (r2 == null) goto L5;
        ViewParent r3 = r2.getParent();
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L9;
        r0 = (ViewGroup) r3;
    L9:
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r4;
        ((ViewGroup.MarginLayoutParams) r5).height = 0;
        r0.setLayoutParams(r5);
        r0.setVisibility(8);
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public static final void f(View r2) {
        ViewGroup r0 = null;
        if (r2 == null) goto L5;
        ViewParent r3 = r2.getParent();
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L9;
        r0 = (ViewGroup) r3;
    L9:
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r4;
        ((ViewGroup.MarginLayoutParams) r5).height = -2;
        r0.setLayoutParams(r5);
        r0.setVisibility(0);
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public static final Context getContext(BaseMessageListCell<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RecyclerView r2 = r1.b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getContext();
    }

    public static final <T extends t1a.a> T a(BaseMessageListCell<?> r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Fragment r3 = d(r1);
        if (r3 == null) goto L7;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L7;
        return (T) r4.getAbility(r2);
    L7:
        return null;
    }

    public static final <T extends t1a.c> T c(BaseMessageListCell<?> r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Fragment r3 = d(r1);
        if (r3 == null) goto L7;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L7;
        return (T) r4.a(r2);
    L7:
        return null;
    }
}
