package com.bytedance.android.live.revlink.impl.control;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/CreateLinkLynxWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CreateLinkLynxWidget extends LiveWidget {
    public boolean a;
    public zy0.b b;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> c;
    public final b d;
    public final CompositeDisposable e;
    public final HashMap<String, LiveData<?>> f;
    public final Map<String, LiveData<Pair<String, JSONObject>>> g;
    public final a h;
    public final i11.c i;

    public final void onCreate() {
        super.onCreate();
        if (this.a == true) goto L50;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r0.getClass();
        ReadOnlyProperty r1 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.z;
        KProperty[] r2 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.a;
        u6 r3 = new u6((String) r1.getValue(r0, r2[24]));
        u6 r4 = r3.d("url");
        yz0.k r5 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        View r6 = null;
        if (r5 == null) goto L8;
        IRoom r7 = r5.getRoom();
    L9:
        if (r7 == null) goto L13;
        IBaseUser r8 = r7.getOwner();
        if (r8 == null) goto L13;
        String r9 = r8.getIdString();
    L14:
        r4.b("anchor_id", r9);
        if (r7 == null) goto L19;
        IBaseUser r10 = r7.getOwner();
        if (r10 == null) goto L19;
        Intrinsics.checkNotNullParameter(r10, "$this$secUidExt");
        String r12 = r10.getCastSecUid();
    L20:
        r4.b("sec_anchor_id", r12);
        r4.b("user_id", com.bytedance.android.live.revlink.impl.utils.u.e());
        if (r7 == null) goto L23;
        String r13 = r7.getIdStr();
    L24:
        r4.b("room_id", r13);
        r4.b("forest_newly_builtin", DataType.TRUE);
        r4.b("load_source", DataType.FALSE);
        r4.b("business_type", r41.b.a());
        r4.b("group", r41.b.a());
        if (r41.b.a == false) goto L27;
    L29:
        boolean r14 = false;
    L30:
        r4.b("enable_find_people", String.valueOf(r14));
        this.a = true;
        long r15 = System.currentTimeMillis();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.A.getValue(r0, r2[25])).booleanValue() == false) goto L33;
        zy0.b r16 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(((Widget) this).context, r3.c(), new CreateLinkLynxWidget$initHub$1(r15));
    L34:
        this.b = r16;
        if (r16 == null) goto L39;
        View r17 = r16.c();
        if (r17 == null) goto L39;
        r17.setVisibility(8);
    L39:
        ViewGroup r18 = ((Widget) this).containerView;
        if (r18 == null) goto L45;
        zy0.b r19 = this.b;
        if (r19 == null) goto L44;
        r6 = r19.c();
    L44:
        r18.addView(r6, new FrameLayout.LayoutParams(0, 0));
    L45:
        zy0.b r20 = this.b;
        if (r20 == null) goto L50;
        xy0.a<?> r22 = r20.g();
        if (r22 == null) goto L50;
        r22.load();
        goto L50
    L33:
        r16 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(((Widget) this).context, r3.c(), new CreateLinkLynxWidget$initHub$2(r15));
        goto L34
    L27:
        if (com.bytedance.android.live.revlink.impl.utils.u.b() == false) goto L29;
        r14 = true;
        goto L30
    L23:
        r13 = null;
    L19:
        r12 = null;
    L13:
        r9 = null;
        goto L14
    L8:
        r7 = null;
    L50:
        i11.c r23 = this.i;
        if (r23 == null) goto L53;
        r23.i(this.d);
    L53:
        Iterator<String> r24 = this.f.keySet().iterator();
    L55:
        if (r24.hasNext() == false) goto L59;
        LiveData r25 = (LiveData) ((LinkedHashMap) this.g).get(r24.next());
        if (r25 == null) goto L55;
        r25.observeForever(this.h);
        goto L55
    }

    public final void onDestroy() {
        super.onDestroy();
        zy0.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e.dispose();
        i11.c r1 = this.i;
        if (r1 == null) goto L8;
        r1.l(this.d);
    L8:
        Iterator<String> r2 = this.f.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();
        LiveData r4 = (LiveData) ((LinkedHashMap) this.g).get(r3);
        if (r4 == null) goto L10;
        r4.removeObserver(this.h);
        goto L10
    }

    public CreateLinkLynxWidget(AnchorLinkUserCenterV2 r6) {
        this.i = r6;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r7 = new MutableLiveData();
        this.c = r7;
        this.d = new b(this);
        this.e = new CompositeDisposable();
        HashMap<String, LiveData<?>> r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r7, "liveData");
        MediatorLiveData r1 = new MediatorLiveData();
        r1.addSource(r7, new RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1(r1, null));
        r0.put("link_anchor_list_v2", r1);
        Unit r8 = Unit.INSTANCE;
        this.f = r0;
        LinkedHashMap r9 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
        Iterator<T> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        Object r4 = r3.getKey();
        String r5 = (String) r3.getKey();
        r9.put(r4, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r3.getValue(), r5, FormatType.NEW));
        goto L4
    L6:
        this.g = r9;
        this.h = new a(this);
    }
}
