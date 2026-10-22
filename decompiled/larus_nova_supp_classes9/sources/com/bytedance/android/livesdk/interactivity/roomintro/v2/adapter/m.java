package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final /* synthetic */ int i = 0;
    public View a;
    public View b;
    public View c;
    public View d;
    public final List<p> e;
    public final RoomIntroDataSource f;
    public final ViewGroup g;
    public final CompositeDisposable h;

    public static final class a {
    }

    static {
    }

    public m(RoomIntroDataSource r2, WrapLineFlowLayout r3, CompositeDisposable r4) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "cd");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.e = new ArrayList();
    }
}
