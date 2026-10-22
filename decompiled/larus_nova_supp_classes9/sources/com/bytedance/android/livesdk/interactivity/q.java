package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MsgOptPanel;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.b {
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> a;
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> b;
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> c;
    public RoomContext d;
    public Context e;
    public MsgOptPanel f;
    public Disposable g;
    public final CompositeDisposable h;
    public final b i;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            return (int) (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r4).a().getPriority() - ((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r3).a().getPriority());
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.b
    public final void destroy() {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        Disposable r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.g = null;
        this.h.clear();
        ALogger.d("PSOperatePanel", "destroy PSPanelItemManager");
    }

    public q() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.h = new CompositeDisposable();
        this.i = b.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.b
    public final void a(MsgOptPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.f = r2;
    }

    public static boolean b(List r3, PanelItemSymbol r4) {
        if (r3.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r3.size() == 1) goto L7;
    L9:
        return false;
    L7:
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) ListProtector.get(r3, 0)).a() != r4) goto L9;
        return true;
    }
}
