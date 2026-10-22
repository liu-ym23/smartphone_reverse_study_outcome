package com.bytedance.android.live.room.discovery;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/discovery/LiveSceneWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSceneWidget extends RowRecyclableWidget implements Observer<KVData> {
    public HSImageView a;
    public TextView b;
    public Room c;
    public boolean d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveSceneWidget a;

        public a(LiveSceneWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            BannerInRoomCollection.BannerInfo r9 = ((BannerData) r8).getData().getSceneBanner();
            if (r9 == null) goto L54;
            LiveSceneWidget r0 = this.a;
            r0.getClass();
            if (r9.getBannerList().isEmpty() == true) goto L55;
            r0.d = true;
            View r2 = ((Widget) r0).contentView;
            if (r2 == null) goto L10;
            r2.setVisibility(0);
        L10:
            Unit r3 = Unit.INSTANCE;
            List r10 = r9.getBannerList();
            if (r10 == null) goto L44;
            ArrayList r4 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L14:
            if (r12.hasNext() == false) goto L21;
            T r5 = r12.next();
            if (((b1) r5).getExtra() == null) goto L18;
            boolean r6 = true;
        L19:
            if (r6 == false) goto L14;
            r4.add(r5);
            goto L14
        L18:
            r6 = false;
            goto L19
        L21:
            Iterator r13 = r4.iterator();
        L23:
            if (r13.hasNext() == false) goto L44;
            b1 r7 = (b1) r13.next();
            TextView r14 = r0.b;
            if (r14 == null) goto L31;
            if (r7 == null) goto L28;
            String r15 = r7.getExtra();
        L29:
            Intrinsics.checkNotNull(r15);
            r14.setText(new JSONObject(r15).optString("title"));
            goto L31
        L28:
            r15 = null;
        L31:
            if (r7.getImage() == null) goto L37;
            HSImageView r16 = r0.a;
            if (r16 == null) goto L35;
            r16.setVisibility(0);
        L35:
            ImageUtil.loadImage(r0.a, r7.getImage(), 0);
        L37:
            if (r7.getActionType() != 1) goto L39;
            String r17 = "live";
        L40:
            View r18 = ((Widget) r0).contentView;
            if (r18 == null) goto L43;
            r18.setOnClickListener(new k0(r7, r17, r0));
        L43:
            r0.xq("livesdk_activity_entrance_show", r17);
            goto L23
        L39:
            r17 = "h5";
        L44:
            ((Widget) r0).dataCenter.put("data_live_scene_shown", Boolean.TRUE);
            return;
        L55:
            return;
        }
    }

    public final int getLayoutId() {
        return 2131567406;
    }

    public final String getSpm() {
        return "a100.a100.a167";
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.put("data_live_scene_shown", Boolean.FALSE);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public LiveSceneWidget() {
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r0 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "data_keyboard_status") == true) goto L9;
        return;
    L9:
        if (r4.getData() == null) goto L24;
        Object r5 = r4.getData();
        Intrinsics.checkNotNull(r5);
        boolean r6 = ((Boolean) r5).booleanValue();
        int r1 = 8;
        if (this.d == true) goto L16;
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L15;
        r7.setVisibility(8);
    L15:
        Unit r8 = Unit.INSTANCE;
        return;
    L16:
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L26;
        if (r6 == false) goto L20;
        Unit r9 = Unit.INSTANCE;
    L21:
        r2.setVisibility(r1);
        return;
    L20:
        Unit r10 = Unit.INSTANCE;
        r1 = 0;
        goto L21
    L26:
        return;
    L24:
        return;
    L5:
        r0 = null;
        goto L7
    }

    public final void onInit(Object[] r1) {
        this.a = findViewById(2131385152);
        this.b = (TextView) findViewById(2131385166);
    }

    public final void onLoad(Object[] r6) {
        this.c = (Room) ((Widget) this).dataCenter.get("data_room", null);
        this.d = false;
        boolean r0 = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).b;
        if (r0 == true) goto L5;
        ((Widget) this).contentView.setBackground(s1.m(2131252912));
    L6:
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L9;
        r2.setVisibility(8);
    L9:
        Unit r3 = Unit.INSTANCE;
        if (r0 == true) goto L12;
        UIUtils.updateLayoutMargin(((Widget) this).contentView, 0, -3, s1.f(8.0f), -3);
    L13:
        HSImageView r1 = this.a;
        if (r1 == null) goto L16;
        r1.setVisibility(8);
    L16:
        IBannerManager r4 = (IBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r4 == null) goto L27;
        Room r5 = this.c;
        if (r5 == null) goto L21;
        long r7 = r5.getRoomId();
    L22:
        Observable r8 = r4.observeBanner(r7, 0);
        if (r8 == null) goto L27;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(autoDispose());
        if (r9 == null) goto L27;
        r9.subscribe(new a(this));
        goto L27
    L21:
        r7 = 0;
    L27:
        ((Widget) this).dataCenter.observe("data_keyboard_status", this);
        return;
    L12:
        UIUtils.updateLayoutMargin(((Widget) this).contentView, 0, -3, 0, -3);
        goto L13
    L5:
        ((Widget) this).contentView.setBackground(s1.m(2131252911));
        goto L6
    }

    public final void wq(String r5) {
        HashMap r0 = new HashMap();
        Room r1 = this.c;
        if (r1 == null) goto L6;
        String r2 = r1.getOwnerUserIdString();
        if (r2 == null) goto L6;
    L7:
        r0.put("anchor_id", r2);
        r0.put("button_type", r5);
        r0.put("page_type", "live");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_activity_entrance_page_show", r0, new Object[]{new am2.x(), Room.class});
        return;
    L6:
        r2 = DataType.FALSE;
        goto L7
    }

    public final void xq(String r5, String r6) {
        HashMap r0 = new HashMap();
        Room r1 = this.c;
        if (r1 == null) goto L6;
        String r2 = r1.getOwnerUserIdString();
        if (r2 == null) goto L6;
    L7:
        r0.put("anchor_id", r2);
        r0.put("entrance_type", r6);
        com.bytedance.android.livesdk.log.u.l().sendLog(r5, r0, new Object[]{new am2.x(), Room.class});
        return;
    L6:
        r2 = DataType.FALSE;
        goto L7
    }
}
