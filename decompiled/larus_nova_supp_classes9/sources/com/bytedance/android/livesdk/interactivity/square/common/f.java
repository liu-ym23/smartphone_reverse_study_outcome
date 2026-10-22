package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final BaseModelListScrollManager a;
    public final SpaceItemDecoration b;
    public final CompositeDisposable c;
    public final RecyclerView d;
    public final BaseMessageModelAdapter e;

    public static final class a {
    }

    static {
        s1.f(2.0f);
    }

    public final void a() {
        BaseModelListScrollManager r0 = this.a;
        Disposable r1 = r0.g;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r0.g = null;
        r0.k.setOnClickListener(null);
        r0.d = false;
        r0.j.setOnFlingListener(null);
        r0.j.setOnTouchListener(null);
        r0.j.removeOnScrollListener(r0.f);
        this.c.dispose();
        BaseMessageModelAdapter r2 = this.e;
        ArrayList r3 = new ArrayList();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "items");
        r2.a = r3;
        this.d.removeItemDecoration(this.b);
    }

    public f(RecyclerView r3, View r4, NoMoreSpaceTextView r5, BaseMessageModelAdapter r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "hintLayout");
        Intrinsics.checkNotNullParameter(r5, "hintTextView");
        Intrinsics.checkNotNullParameter(r6, "recyclerAdapter");
        this.d = r3;
        this.e = r6;
        this.a = new BaseModelListScrollManager(r3, r4, r5, 550.0f);
        SpaceItemDecoration r8 = new SpaceItemDecoration(1, r7, false);
        this.b = r8;
        this.c = new CompositeDisposable();
        r3.setItemViewCacheSize(4);
        r3.addItemDecoration(r8);
        r3.setAdapter(r6);
        r3.setOverScrollMode(0);
    }
}
