package com.bytedance.android.livesdk.interactivity;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.config.il0;
import com.bytedance.android.livesdkapi.depend.model.live.BottomCard;
import com.bytedance.android.livesdkapi.publicscreen.AbsPublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.publicscreen.IPublicScreenBottomListener;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u {
    public final HashMap<AbsPublicScreenBottomWidget, v> a;
    public com.bytedance.android.livesdk.interactivity.a b;
    public final String[] c;
    public final ArrayList<String> d;
    public boolean e;
    public final List<BottomCard> f;
    public final ViewGroup g;

    public static final class a implements IPublicScreenBottomListener {
        public final /* synthetic */ Map.Entry a;

        public final void onFail() {
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
            f2.c("load " + ((AbsPublicScreenBottomWidget) this.a.getKey()).getBusinessName() + " error", 0);
        L5:
            int r0 = t.a;
            ALogger.e("PSBottomWidget", "load " + ((AbsPublicScreenBottomWidget) this.a.getKey()).getBusinessName() + " error");
        }

        public a(Map.Entry r1) {
            this.a = r1;
        }
    }

    public final void a() {
        int r0 = t.a;
        ALogger.i("PSBottomWidget", "total widget count:" + this.a.size());
        Iterator<Map.Entry<AbsPublicScreenBottomWidget, v>> r1 = this.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        Map.Entry<AbsPublicScreenBottomWidget, v> r2 = r1.next();
        Iterator<T> r3 = this.f.iterator();
    L6:
        String r5 = null;
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        String r7 = ((BottomCard) r4).getName();
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L6;
    L17:
        BottomCard r6 = (BottomCard) r4;
        if (r6 == null) goto L20;
        r5 = r6.getBizParams();
    L20:
        v r9 = r2.getValue();
        a r10 = new a(r2);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (r9.a == true) goto L24;
        int r11 = t.a;
        ALogger.i("PSBottomWidget", r9.e.getBusinessName() + " onInit");
        r9.e.onInit(r5, r10);
        r9.a = true;
    L24:
        r2.getValue().onLoad();
        goto L4
    L11:
        if (r7.equals(r2.getKey().getBusinessName()) != true) goto L13;
        r8 = true;
        goto L14
    L16:
        r4 = null;
        goto L17
    }

    public final void b(IExternalWidget r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof AbsPublicScreenBottomWidget) == true) goto L5;
        IExternalWidget r0 = null;
    L6:
        AbsPublicScreenBottomWidget r1 = (AbsPublicScreenBottomWidget) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        int r2 = t.a;
        ALogger.i("PSBottomWidget", ((AbsPublicScreenBottomWidget) r3).getBusinessName() + " request dismiss");
        v r4 = this.a.get(r1);
        if (r4 == null) goto L13;
        r4.onViewWillDetach();
        this.g.removeAllViews();
        r4.onViewDetached();
        return;
    L13:
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public u(List<BottomCard> r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "cardInfo");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.f = r2;
        this.g = r3;
        this.a = new HashMap();
        this.c = (String[]) il0.a.getValue();
        this.d = new ArrayList();
        Iterator<BottomCard> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r5 = r4.next().getName();
        if (r5 == null) goto L4;
        this.d.add(r5);
        goto L4
    }
}
