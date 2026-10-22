package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.CompositeImagePreviewDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements b {
    public static final /* synthetic */ int f = 0;
    public final List<com.bytedance.android.livesdk.chatroom.likeegg.a> a;
    public CompositeImagePreviewDialog b;
    public Disposable c;
    public final ViewGroup d;
    public final DataCenter e;

    public static final class a {
    }

    static {
    }

    public c(ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(null, "guideTrayManager");
        this.d = r3;
        this.e = r4;
        this.a = new ArrayList();
        new d(this);
    }
}
