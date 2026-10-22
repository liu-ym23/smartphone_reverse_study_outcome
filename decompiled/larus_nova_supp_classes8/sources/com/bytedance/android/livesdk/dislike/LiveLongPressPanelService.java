package com.bytedance.android.livesdk.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.longpresspanel.LiveLongPressItemType;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.config.f81;
import com.bytedance.android.livesdk.config.n70;
import com.bytedance.android.livesdk.config.zc0;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdkapi.ILiveLongPressPanelService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J0\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/dislike/LiveLongPressPanelService;", "Lcom/bytedance/android/livesdkapi/ILiveLongPressPanelService;", "", "isNewLiveLongPressPanelEnable", "isUnloginPanelAlign2New", "", "getLiveLongPressPanelStyle", "", "", "getLiveFeedItemList", "Ldz/b;", "liveLongPressPanelParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", "logExtra", "getFeedLongPressPanelParams", "Lq61/b;", "entrance", "needLogin", "enableDouplus", "location", "", "logDouPlusShow", "", "roomId", "secUid", "Landroid/content/Context;", "context", "clickDouPlus", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLongPressPanelService implements ILiveLongPressPanelService {
    public LiveLongPressPanelService() {
    }

    public boolean enableDouplus() {
        return ((Boolean) n70.a.getValue()).booleanValue();
    }

    public int getLiveLongPressPanelStyle() {
        int r0 = com.bytedance.android.livesdk.config.setting.l.a;
        Integer r1 = zc0.a.getValue().style;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    }

    public boolean isUnloginPanelAlign2New() {
        return f81.a.getValue().a();
    }

    public List<String> getLiveFeedItemList() {
        List<ItemConfig> r0 = com.bytedance.android.livesdk.config.setting.l.a();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = ((ItemConfig) r2.next()).getIdentity();
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public boolean isNewLiveLongPressPanelEnable() {
        return com.bytedance.android.livesdk.config.setting.l.c();
    }

    public void logDouPlusShow(int r1) {
        qt1.b.b(r1);
    }

    public boolean needLogin(q61.b r2) {
        Intrinsics.checkNotNullParameter(r2, "entrance");
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r0 = ILoginGuideService.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.intercept(r2);
    }

    public void clickDouPlus(long r2, String r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "secUid");
        Intrinsics.checkNotNullParameter(r5, "context");
        qt1.b.a();
        qt1.b.c(r2, r4, r5);
    }

    public dz.b getFeedLongPressPanelParams(dz.b r11, final Room r12, final Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r11, "liveLongPressPanelParams");
        int r1 = q.a;
        Intrinsics.checkNotNullParameter(r11, "liveLongPressPanelParams");
        Iterator r0 = ((ArrayList) r11.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L46;
        final dz.a r2 = (dz.a) r0.next();
        ItemIdentity r3 = r2.a;
        ItemType[] r4 = ItemType.values();
        int r5 = r4.length;
        boolean r6 = false;
        int r7 = 0;
    L6:
        final OptionAction r8 = null;
        if (r7 >= r5) goto L12;
        ItemType r9 = r4[r7];
        if (r9.getIdentity() == r3) goto L13;
        r7 = r7 + 1;
    L13:
        if (r9 == null) goto L43;
        r9.getPriority(true).intValue();
        if (r9.getIdentity() == ItemIdentity.REPORT) goto L18;
        r9.getHasLandingPage();
    L18:
        Integer r10 = Integer.valueOf(r2.getType());
        if (r10.intValue() != 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        r10.intValue();
        r2.b = r9.getItemType(true).intValue();
    L27:
        r9.getClearColorFilter();
        Integer r15 = Integer.valueOf(r2.c);
        if (r15.intValue() != LiveLongPressItemType.NORMAL.getValue()) goto L30;
        r6 = true;
    L30:
        if (r6 == true) goto L33;
        r15 = null;
    L33:
        if (r15 == null) goto L36;
        r15.intValue();
        r2.c = r9.getItemType().getValue();
    L36:
        if (TextUtils.isEmpty(r2.e) == false) goto L39;
        r2.e = r9.getDesc();
    L39:
        if (r2.d != null) goto L43;
        Integer r16 = r9.getImgRes();
        if (r16 == null) goto L43;
        r2.d = s1.m(r16.intValue());
        goto L43
    L21:
        r14 = false;
    L43:
        final LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$1 r17 = new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$1(r12, r13);
        if (r2.f != null) goto L4;
        r2.f = new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$2(r17, r2, r8);
        new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$1$1$4(r8);
        new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$1$1$5(r8);
        goto L4
    L12:
        r9 = null;
        goto L13
    L46:
        new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$3(r12, r13);
        new LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$4(r12, r13);
        return r11;
    }
}
