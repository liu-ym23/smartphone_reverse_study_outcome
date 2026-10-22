package com.bytedance.android.live.liveinteract.feed.datamerge;

import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVManager;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.IUserMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MicrophoneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FeedViewInteractSongDataHandler extends com.bytedance.android.live.liveinteract.feed.datamerge.a {
    public boolean b;
    public List<IUserMicrophoneItem> c;
    public CompositeDisposable d;
    public Integer e;
    public FrameLayout f;
    public LiveLinkmicAIMVManager g;
    public boolean h;
    public Boolean i;
    public final Function0<DataCenter> j;
    public final Function0<IRoom> k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        this.b = true;
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        this.b = false;
        CompositeDisposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        LiveLinkmicAIMVManager r1 = this.g;
        if (r1 == null) goto L9;
        r1.d();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a b(List<ch0.e> r18) {
        Intrinsics.checkNotNullParameter(r18, "oldMergeDataList");
        List<ch0.e> r1 = r18;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
        ch0.e r4 = null;
    L4:
        if (r3.hasNext() == false) goto L72;
        ch0.e r5 = (ch0.e) r3.next();
        HashMap r11 = new HashMap(r5.d);
        IBaseUser r7 = r5.a.getUser();
        if (r7 == null) goto L9;
        String r8 = r7.getIdString();
        if (r8 == null) goto L9;
    L10:
        Integer r9 = this.e;
        if (r9 == null) goto L13;
        r11.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT", Integer.valueOf(r9.intValue()));
    L13:
        List<IUserMicrophoneItem> r10 = this.c;
        if (r10 == null) goto L52;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L17:
        if (r13.hasNext() == false) goto L25;
        Object r14 = r13.next();
        IBaseUser r15 = ((IUserMicrophoneItem) r14).getOrderUser();
        if (r15 == null) goto L21;
        String r16 = r15.getIdString();
    L23:
        if (Intrinsics.areEqual(r16, r8) == false) goto L17;
        r12.add(r14);
        goto L17
    L21:
        r16 = null;
        goto L23
    L25:
        IUserMicrophoneItem r17 = (IUserMicrophoneItem) CollectionsKt.firstOrNull(r12);
        if (r17 == null) goto L52;
        List r19 = r17.getMicrophoneList();
        if (r19 != null) goto L30;
    L36:
        List r110 = r17.getMicrophoneList();
        if (r110 == null) goto L47;
        IMicrophoneItem r111 = (IMicrophoneItem) ListProtector.get(r110, 0);
        if (r111 == null) goto L47;
        if (r111.getMicrophoneType() != MicrophoneType.Golden.ordinal()) goto L47;
        List r6 = r17.getMicrophoneList();
        if (r6 == null) goto L52;
        IMicrophoneItem r20 = (IMicrophoneItem) ListProtector.get(r6, 0);
        if (r20 == null) goto L52;
        r11.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE", r20);
        ALogger.i("FeedViewInteractSongDataHandler", "用户" + r8 + " 话筒类型-> " + r20.getMicrophoneType() + ", 数目 ：" + r20.getMicroPhoneNum());
    L47:
        List r21 = r17.getMicrophoneList();
        if (r21 == null) goto L52;
        IMicrophoneItem r22 = (IMicrophoneItem) ListProtector.get(r21, 1);
        if (r22 == null) goto L52;
        r11.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE", r22);
        ALogger.i("FeedViewInteractSongDataHandler", "用户" + r8 + " 话筒类型-> " + r22.getMicrophoneType() + ", 数目 ：" + r22.getMicroPhoneNum());
        goto L52
    L30:
        if (r19.size() != 1) goto L36;
        List r23 = r17.getMicrophoneList();
        if (r23 == null) goto L52;
        IMicrophoneItem r24 = (IMicrophoneItem) ListProtector.get(r23, 0);
        if (r24 == null) goto L52;
        r11.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE", r24);
        ALogger.i("FeedViewInteractSongDataHandler", "用户" + r8 + " 话筒类型-> " + r24.getMicrophoneType() + ", 数目 ：" + r24.getMicroPhoneNum());
    L52:
        StringBuilder r25 = new StringBuilder("micInfo = null, currentUserId == micInfo?.userId = ");
        r25.append(Intrinsics.areEqual(r8, null));
        r25.append(" micInfo?.action: null  update list size: ");
        Object r26 = r11.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST");
        if (TypeIntrinsics.isMutableList(r26) == true) goto L55;
        r26 = null;
    L55:
        List r27 = (List) r26;
        if (r27 == null) goto L58;
        Integer r28 = Integer.valueOf(r27.size());
    L59:
        r25.append(r28);
        ALogger.d("FeedViewInteractSongDataHandler", r25.toString());
        r11.put("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO", null);
        if (r11.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST") != null) goto L62;
        r11.put("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST", new ArrayList());
    L62:
        ch0.e r29 = ch0.e.a(r5, null, null, null, r11, 7);
        IBaseUser r30 = r29.a.getUser();
        if (r30 == null) goto L65;
        String r31 = r30.getIdString();
    L67:
        if (Intrinsics.areEqual(r31, gh0.a.c()) == false) goto L70;
        if (r29 == r5) goto L70;
        r4 = r29;
    L70:
        r2.add(r29);
        goto L4
    L65:
        r31 = null;
        goto L67
    L58:
        r28 = null;
    L9:
        r8 = "";
        goto L10
    L72:
        return new j.a(true, r2, r4);
    }

    public final void e(FrameLayout r5) {
        if (r5 == null) goto L5;
        this.f = r5;
        LiveLinkmicAIMVManager r0 = new LiveLinkmicAIMVManager(r5.getContext(), (DataCenter) this.j.invoke(), null);
        this.g = r0;
        r0.a(r5);
        return;
    }

    public final void f(boolean r5) {
        wg0.a r6 = wg0.a.a(c().j(), false, null, r5, 3);
        c().c(r6);
    }

    public FeedViewInteractSongDataHandler(Function0<? extends DataCenter> r2, Function0<? extends IRoom> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenterProvider");
        Intrinsics.checkNotNullParameter(r3, "roomProvider");
        this.j = r2;
        this.k = r3;
        new FeedViewInteractSongDataHandler$setMvInfoCallBack$1(this);
    }
}
