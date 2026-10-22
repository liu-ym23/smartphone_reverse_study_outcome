package com.bytedance.android.livesdk.chatroom.ui.livesticker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.model.e3;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.RoomStickerDecorationAdapter;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.b3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/StickerDecorationPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDecorationPageFragment extends Fragment {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> d;
    public DataCenter e;
    public StickerDecorationType f;
    public String g;
    public e3 h;
    public RoomStickerDecorationAdapter i;
    public Disposable j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ StickerDecorationPageFragment a;

        public b(StickerDecorationPageFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            e3 r4 = ((b3) r3).a;
            if (r4 != null) goto L5;
        L12:
            RoomStickerDecorationAdapter r5 = this.a.i;
            if (r5 == null) goto L16;
            r5.notifyDataSetChanged();
            return;
        L16:
            return;
        L5:
            if (this.a.f != StickerDecorationType.TEXT_STICKER) goto L7;
            List r6 = r4.h();
        L8:
            if (r6 == null) goto L12;
            RoomStickerDecorationAdapter r0 = this.a.i;
            if (r0 == null) goto L12;
            Intrinsics.checkNotNullParameter(r6, "data");
            ((ArrayList) r0.a).clear();
            ArrayList r1 = (ArrayList) r0.a;
            r1.addAll(r6);
            r0.notifyDataSetChanged();
            goto L12
        L7:
            r6 = r4.f();
            goto L8
        }
    }

    static {
    }

    public StickerDecorationPageFragment() {
        this.d = new LinkedHashMap();
        this.f = StickerDecorationType.TEXT_STICKER;
        this.g = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.j;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final void setUserVisibleHint(boolean r6) {
        super.setUserVisibleHint(r6);
        if (getUserVisibleHint() == false) goto L16;
        DataCenter r7 = this.e;
        String r0 = this.g;
        int r1 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a;
        Intrinsics.checkNotNullParameter(r0, "pageTitle");
        if (r7 != null) goto L7;
    L9:
        String r8 = "video_live";
    L10:
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_page", "live_take_detail"), TuplesKt.to("tab", r0), TuplesKt.to("live_type", r8)});
        u.l().sendLog("pm_live_prop_tab_change", r9, new Object[]{Room.class});
        if (this.f.getType() != StickerDecorationType.IMAGE_STICKER.getType()) goto L13;
        String r10 = "picture_prop_tab_show";
    L14:
        u.l().sendLog(r10, null, new Object[]{Room.class});
        return;
    L13:
        r10 = "character_prop_tab_show";
        goto L14
    L7:
        if (z.g(r7) != true) goto L9;
        r8 = "voice_live";
        goto L10
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.i = new RoomStickerDecorationAdapter(this.f);
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.d).get(2131387341);
        if (r4 != null) goto L13;
        View r5 = getView();
        if (r5 == null) goto L12;
        r4 = r5.findViewById(2131387341);
        if (r4 == null) goto L12;
        this.d.put(2131387341, r4);
    L12:
        r4 = null;
    L13:
        RecyclerView r6 = (RecyclerView) r4;
        if (r6 == null) goto L17;
        r6.setAdapter(this.i);
    L17:
        if (this.f != StickerDecorationType.TEXT_STICKER) goto L23;
        e3 r7 = this.h;
        if (r7 == null) goto L22;
        Collection r8 = r7.h();
        if (r8 == null) goto L22;
    L28:
        RoomStickerDecorationAdapter r9 = this.i;
        if (r9 == null) goto L31;
        Intrinsics.checkNotNullParameter(r8, "data");
        ((ArrayList) r9.a).clear();
        ArrayList r0 = (ArrayList) r9.a;
        r0.addAll(r8);
        r9.notifyDataSetChanged();
    L31:
        this.j = ((ObservableSubscribeProxy) xs2.b.a().b(b3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
        return;
    L22:
        r8 = new ArrayList();
        goto L28
    L23:
        e3 r10 = this.h;
        if (r10 == null) goto L27;
        r8 = r10.f();
        if (r8 != null) goto L28;
    L27:
        r8 = new ArrayList();
        goto L28
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (r3 != null) goto L7;
        return null;
    L7:
        return r2.inflate(2131567476, r3, false);
    }
}
