package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.config.z91;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.android.livesdk.message.model.AnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiEnlargeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lx82/d;", "Lvlc/l;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiEnlargeWidget extends RoomWidget implements x82.d, vlc.l {
    public final CompositeDisposable b;
    public String c;
    public boolean d;
    public boolean e;
    public long f;
    public boolean g;
    public final hy.e h;
    public final long i;

    public final class a implements Comparator<String> {
        public final String a;
        public final String b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "selfLinkerID");
            Intrinsics.checkNotNullParameter(r3, "enlargeLinkerID");
            this.a = r2;
            this.b = r3;
        }

        @Override // java.util.Comparator
        public final int compare(String r4, String r5) {
            String r6 = r4;
            String r7 = r5;
            if (TextUtils.equals(this.b, r6) == false) goto L6;
            return -1;
        L6:
            if (TextUtils.equals(this.b, r7) == false) goto L9;
        L7:
            return 1;
        L9:
            if (TextUtils.equals(this.a, r6) == false) goto L12;
            return -1;
        L12:
            if (TextUtils.equals(this.a, r7) == true) goto L7;
            return 0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MediaMultiEnlargeWidget a;

        public b(MediaMultiEnlargeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            this.a.g = false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MediaMultiEnlargeWidget a;

        public c(MediaMultiEnlargeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MediaMultiEnlargeWidget r0 = this.a;
            r0.g = false;
            Context r1 = ((Widget) r0).context;
            ExceptionUtils.handleException(r1, (Throwable) r3);
        }
    }

    @Override // x82.d
    public final String zd() {
        hy.e r0 = this.h;
        Iterator r1 = r0.getOnlineUserList().iterator();
    L3:
        String r3 = null;
        if (r1.hasNext() == false) goto L15;
        AnchorLinkUser r2 = (AnchorLinkUser) r1.next();
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L9;
        r3 = r5.getIdString();
    L9:
        if (Intrinsics.areEqual(r3, this.c) == false) goto L3;
        String r4 = r2.getInteractId();
        if (r4 != null) goto L14;
        return BuildConfig.FLAVOR;
    L14:
        return r4;
    L15:
        Iterator r6 = r0.a().iterator();
    L17:
        if (r6.hasNext() == false) goto L37;
        AnchorLinkUser r7 = (AnchorLinkUser) r6.next();
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L21;
        String r9 = r8.getIdString();
    L23:
        if (Intrinsics.areEqual(r9, this.c) == false) goto L17;
        String r10 = r7.getInteractId();
        if (r10 != null) goto L28;
        return BuildConfig.FLAVOR;
    L28:
        return r10;
    L21:
        r9 = null;
        goto L23
    L37:
        return BuildConfig.FLAVOR;
    }

    public final void onCreate() {
        super.onCreate();
        RoomContext r0 = ((RoomWidget) this).a;
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L11;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L12;
        r2.addMessageListener(MessageType.LINKER.getIntType(), this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        RoomContext r0 = ((RoomWidget) this).a;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(this);
    L9:
        this.b.clear();
    }

    public final boolean wq() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.f) <= (((Number) z91.a.getValue()).intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) goto L5;
        this.f = r0;
        return true;
    L5:
        f2.b(2131920311, 0);
        return false;
    }

    @Override // x82.d
    public final Map<String, WindowsPosition> gc(List<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "linkIdList");
        if (this.c.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r3 = null;
        if (r0 == true) goto L85;
        ArrayList r1 = (ArrayList) r13;
        if (r1.size() < 2) goto L85;
        if (this.d == false) goto L85;
        LinkedHashMap r4 = new LinkedHashMap();
        int r2 = r1.size();
        if (r2 == 1) goto L24;
        if (r2 != 2) goto L17;
        List r5 = CollectionsKt.listOf(new WindowsPosition[]{WindowsPosition.TWO_LEFT, WindowsPosition.TWO_RIGHT});
    L25:
        AnchorLinkUser r6 = this.h.getGuestInfo(this.c, null);
        if (r6 == null) goto L29;
        String r7 = r6.getInteractId();
        if (r7 == null) goto L29;
    L30:
        String r8 = MediaMultiAnchorLinkContext.Companion.b();
        if (r8 != null) goto L56;
        Iterator r9 = this.h.getOnlineUserList().iterator();
    L34:
        if (r9.hasNext() == false) goto L50;
        Object r10 = r9.next();
        IBaseUser r11 = ((AnchorLinkUser) r10).getUser();
        if (r11 == null) goto L38;
        String r14 = r11.getIdString();
    L39:
        RoomContext r15 = ((RoomWidget) this).a;
        if (r15 == null) goto L46;
        m r16 = r15.getRoom();
        if (r16 == null) goto L46;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L46;
        String r18 = r17.getOwnerUserIdString();
    L48:
        if (Intrinsics.areEqual(r14, r18) == false) goto L34;
        r3 = r10;
    L46:
        r18 = null;
        goto L48
    L38:
        r14 = null;
    L50:
        AnchorLinkUser r19 = (AnchorLinkUser) r3;
        if (r19 == null) goto L54;
        String r20 = r19.getInteractId();
        if (r20 == null) goto L54;
    L55:
        r8 = r20;
    L54:
        r20 = "0";
    L56:
        if (r6 == null) goto L58;
    L65:
        Iterator r110 = CollectionsKt.sortedWith(r13, new a(r8, r7)).iterator();
    L67:
        if (r110.hasNext() == false) goto L84;
        String r21 = (String) r110.next();
        if (TextUtils.equals(r21, r7) == true) goto L70;
        if (TextUtils.equals(r21, r8) == true) goto L76;
        WindowsPosition r23 = (WindowsPosition) CollectionsKt.getOrNull(r5, r4.size());
        if (r23 != null) goto L83;
        r23 = WindowsPosition.IGNORE;
    L83:
        r4.put(r21, r23);
        goto L67
    L76:
        WindowsPosition r24 = (WindowsPosition) CollectionsKt.getOrNull(r5, 1);
        if (r24 != null) goto L79;
        r24 = WindowsPosition.IGNORE;
    L79:
        r4.put(r21, r24);
        goto L67
    L70:
        WindowsPosition r25 = (WindowsPosition) CollectionsKt.getOrNull(r5, 0);
        if (r25 != null) goto L73;
        r25 = WindowsPosition.IGNORE;
    L73:
        r4.put(r21, r25);
        goto L67
    L84:
        return r4;
    L58:
        if (Intrinsics.areEqual(this.c, ey.c.b()) == false) goto L65;
        if (r7.length() != 0) goto L62;
        boolean r26 = true;
    L63:
        if (r26 == false) goto L65;
        r7 = r8;
        goto L65
    L62:
        r26 = false;
    L29:
        r7 = BuildConfig.FLAVOR;
        goto L30
    L17:
        if (r2 != 3) goto L19;
        r5 = CollectionsKt.listOf(new WindowsPosition[]{WindowsPosition.THREE_LEFT, WindowsPosition.THREE_RIGHT_TOP, WindowsPosition.THREE_RIGHT_BOTTOM});
        goto L25
    L19:
        if (r2 == 4) goto L21;
        r5 = CollectionsKt.listOf(new WindowsPosition[]{WindowsPosition.FOUR_LEFT_TOP, WindowsPosition.FOUR_RIGHT_TOP, WindowsPosition.FOUR_RIGHT_BOTTOM, WindowsPosition.FOUR_LEFT_BOTTOM});
        goto L25
    L21:
        r5 = CollectionsKt.listOf(new WindowsPosition[]{WindowsPosition.FOUR_LEFT_TOP, WindowsPosition.FOUR_RIGHT_TOP, WindowsPosition.FOUR_RIGHT_BOTTOM, WindowsPosition.FOUR_LEFT_BOTTOM});
        goto L25
    L24:
        r5 = CollectionsKt.listOf(WindowsPosition.SINGLE);
    L85:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public final void onMessage(tlc.d r9) {
        if ((r9 instanceof if) == false) goto L41;
        if r10 = (if) r9;
        if (r10.mScene == 17) goto L8;
        return;
    L8:
        if (r10.getMType() != 51) goto L43;
        com.bytedance.android.livesdk.interactivity.medialink.contract.c r0 = MediaMultiAnchorLinkContext.Companion.getContext();
        if (r0 == null) goto L17;
        m<? extends Integer> r1 = r0.getWindowCount();
        if (r1 == null) goto L17;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
    L19:
        if (r3 >= 4) goto L21;
        return;
    L21:
        AnchorUpdateLayoutContent r11 = r10.anchorUpdateLayoutContent;
        if (r11 == null) goto L42;
        int r4 = r11.anchorLayoutRange;
        if (r4 >= AnchorUpdateLayoutContent.AnchorLayoutRange.values().length) goto L27;
        if (r4 < 0) goto L27;
        AnchorUpdateLayoutContent.AnchorLayoutRange r5 = AnchorUpdateLayoutContent.AnchorLayoutRange.values()[r4];
    L27:
        int r6 = r11.updateLayoutType;
        if (r6 >= AnchorUpdateLayoutContent.UpdateAnchorLayoutType.values().length) goto L32;
        if (r6 < 0) goto L32;
        AnchorUpdateLayoutContent.UpdateAnchorLayoutType r7 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.values()[r6];
    L32:
        if (r11.anchorUILayout != AnchorUpdateLayoutContent.AnchorUILayout.AnchorUILayout1V3.ordinal()) goto L34;
        boolean r8 = true;
    L35:
        String r13 = r11.getUpdateUserID();
        if (r11.anchorLayoutRange != AnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom.ordinal()) goto L38;
        boolean r14 = true;
    L39:
        xq(r8, r13, r14, "update_layout_message", true);
        return;
    L38:
        r14 = false;
        goto L39
    L34:
        r8 = false;
        goto L35
    L42:
        return;
    L17:
        r3 = 0;
        goto L19
    L43:
        return;
    }

    @Override // x82.d
    public final boolean t4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        if (Intrinsics.areEqual("0", r3) == true) goto L12;
        return Intrinsics.areEqual(this.c, r3);
    L12:
        return !Intrinsics.areEqual(this.c, BuildConfig.FLAVOR);
    L5:
        r0 = false;
        goto L6
    }

    @Override // x82.d
    public final boolean x5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (t4(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.e == true) goto L7;
        return true;
    }

    public MediaMultiEnlargeWidget(hy.e r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "userCenter");
        this.h = r2;
        this.i = r3;
        this.b = new CompositeDisposable();
        this.c = BuildConfig.FLAVOR;
        AnchorUpdateLayoutContent.AnchorLayoutRange r4 = AnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        AnchorUpdateLayoutContent.UpdateAnchorLayoutType r5 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        ey.c.b();
    }

    @Override // x82.d
    public final void A5(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (wq() == true) goto L5;
        return;
    L5:
        yq(r2, r3, true);
    }

    @Override // x82.d
    public final void P4(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (wq() == true) goto L5;
        return;
    L5:
        yq(r2, r3, false);
    }

    public final void yq(String r8, boolean r9, boolean r10) {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        System.currentTimeMillis();
        if (r9 == false) goto L9;
        if (r10 == false) goto L9;
        AnchorUpdateLayoutContent.UpdateAnchorLayoutType r11 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeMyStream;
    L19:
        RxUtilKt.c(((SingleSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).updateAnchorLayout(r11.ordinal(), this.i, MediaMultiAnchorLinkContext.Companion.a(), r8).as(autoDisposeWithTransformer())).subscribe(new b(this), new c(this)), this.b);
        return;
    L9:
        if (r9 == false) goto L12;
        if (r10 == true) goto L12;
        r11 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeAllStream;
    L12:
        if (r9 == true) goto L15;
        if (r10 == false) goto L15;
        r11 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeMyStream;
    L15:
        if (r9 == true) goto L18;
        if (r10 == true) goto L18;
        r11 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream;
    L18:
        r11 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L19
    }

    public final void xq(boolean r1, String r2, boolean r3, String r4, boolean r5) {
        this.d = r1;
        if (r1 == true) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        this.c = r2;
        this.e = r3;
        if (r1 == false) goto L9;
        UILayout r6 = UILayout.Enlarge;
    L10:
        x82.e.A2.getClass();
        x82.e r7 = x82.e.a.a();
        if (r7 == null) goto L14;
        r7.kg(r6, r4, r5);
        return;
    L14:
        return;
    L9:
        r6 = UILayout.Normal;
        goto L10
    }
}
