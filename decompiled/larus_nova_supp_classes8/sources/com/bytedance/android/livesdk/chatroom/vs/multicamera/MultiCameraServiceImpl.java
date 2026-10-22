package com.bytedance.android.livesdk.chatroom.vs.multicamera;

import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget$addDataChangeObserver$;
import com.bytedance.android.livesdk.chatroom.utils.u4;
import com.bytedance.android.livesdk.chatroom.utils.v4;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.b0;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import dq1.d;
import dq1.e;
import dq1.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu2.b;
import lu2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/multicamera/MultiCameraServiceImpl;", "Ldq1/a;", "Lcom/bytedance/android/scope/o;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraServiceImpl implements dq1.a, o, Observer<KVData> {
    public MutableLiveData<Boolean> a;
    public long b;
    public VSCameraInfo c;
    public DataCenter d;
    public final List<e> e;
    public final List<f> f;
    public final ArrayList<VSCameraInfo> g;
    public long h;
    public d i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // dq1.a
    public final int W3() {
        Iterator<VSCameraInfo> r0 = this.g.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().cameraId != this.b) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L16;
        r2 = r2 + 1;
        goto L4
    L16:
        return r2;
    L8:
        r3 = false;
        goto L9
    L12:
        return -1;
    }

    @Override // dq1.a
    public final void o4() {
        if (this.j == true) goto L5;
        return;
    L5:
        this.j = false;
        Iterator<T> r0 = this.e.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((e) r0.next()).c();
        goto L7
    }

    public MultiCameraServiceImpl() {
        this.a = new MutableLiveData(Boolean.FALSE);
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    @Override // dq1.a
    public final VSCameraInfo C4() {
        return this.c;
    }

    @Override // dq1.a
    public final List<VSCameraInfo> p4() {
        return this.g;
    }

    @Override // dq1.a
    public final void D4(e r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.e).add(r2);
    }

    @Override // dq1.a
    public final void F4(v4 r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.f).add(r2);
    }

    public final VSCameraInfo a(long r6) {
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((VSCameraInfo) r1).cameraId != r6) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (VSCameraInfo) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Object r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-363428784)) goto L12;
        return;
    L12:
        if (r1.equals("data_room") == false) goto L19;
        Object r7 = r6.getData();
        if ((r7 instanceof IRoom) == false) goto L17;
        r0 = r7;
    L17:
        z4((IRoom) r0);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // dq1.a
    public final void x4(DataCenter r5) {
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L6:
        DataCenter r1 = this.d;
        if (r1 == null) goto L9;
        int r2 = r1.hashCode();
    L10:
        if (r6 == r2) goto L12;
        return;
    L12:
        DataCenter r7 = this.d;
        if (r7 == null) goto L15;
        r7.removeObserver(this);
    L15:
        this.a = new MutableLiveData(Boolean.FALSE);
        this.b = 0;
        this.c = null;
        this.d = null;
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        this.g.clear();
        this.h = 0;
        this.i = null;
        this.j = false;
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    @Override // dq1.a
    public final void z4(IRoom r7) {
        this.g.clear();
        Boolean r0 = null;
        if (r7 != null) goto L8;
        DataCenter r8 = this.d;
        if (r8 == null) goto L7;
        r7 = c.f(r8);
        goto L8
    L7:
        r7 = null;
    L8:
        long r1 = 0;
        if (r7 == null) goto L13;
        IEpisodeExtraInfo r3 = r7.getEpisodeComponentData();
        if (r3 == null) goto L13;
        long r4 = r3.getDefaultCameraId();
    L14:
        this.h = r4;
        if (r7 == null) goto L33;
        EpisodeExtraInfo r5 = c.a(r7);
        if (r5 == null) goto L33;
        List r6 = r5.getCameraInfos();
        if (r6 == null) goto L33;
        VSCameraInfo r9 = b.a(r7);
        if (r9 == null) goto L23;
        this.g.add(r9);
    L23:
        Iterator r10 = r6.iterator();
    L25:
        if (r10.hasNext() == false) goto L33;
        VSCameraInfo r11 = (IVSCameraInfo) r10.next();
        if ((r11 instanceof VSCameraInfo) == true) goto L29;
        VSCameraInfo r12 = null;
    L31:
        if (r12 == null) goto L25;
        this.g.add(r11);
        goto L25
    L29:
        r12 = r11;
    L33:
        long r13 = this.b;
        if (r13 == 0) goto L37;
        this.c = a(r13);
    L37:
        if (this.c != null) goto L49;
        int r14 = b.a;
        if (r7 == null) goto L43;
        EpisodeExtraInfo r15 = c.a(r7);
        if (r15 == null) goto L43;
        long r16 = r15.getDefaultCameraId();
    L44:
        VSCameraInfo r17 = a(r16);
        this.c = r17;
        if (r17 == null) goto L47;
        r1 = r17.cameraId;
    L47:
        this.b = r1;
    L43:
        r16 = 0;
    L49:
        if (this.g.size() <= 1) goto L51;
        boolean r18 = true;
    L52:
        MutableLiveData<Boolean> r2 = this.a;
        if (r2 == null) goto L56;
        r0 = (Boolean) r2.getValue();
    L56:
        if ((!Intrinsics.areEqual(r0, Boolean.valueOf(r18))) == false) goto L66;
        MutableLiveData<Boolean> r19 = this.a;
        if (r19 == null) goto L67;
        r19.setValue(Boolean.valueOf(r18));
        return;
    L67:
        return;
    L66:
        return;
    L51:
        r18 = false;
    L13:
        r4 = 0;
        goto L14
    }

    @Override // dq1.a
    public final void c4(LifecycleOwner r2, HamletAvatarWidget$addDataChangeObserver$.inlined.let.lambda.10 r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        MutableLiveData<Boolean> r0 = this.a;
        if (r0 == null) goto L6;
        r0.observe(r2, r3);
        return;
    }

    @Override // dq1.a
    public final void e4(DataCenter r2, u4 r3, long r4) {
        x4(this.d);
        this.d = r2;
        this.i = r3;
        this.b = r4;
        r2.observe("data_room", this);
    }

    @Override // dq1.a
    public final void l4(Long r18, Bundle r19, boolean r20, String r21, Boolean r22) {
        boolean r4 = true;
        if (r18 != null) goto L24;
        long r5 = this.b;
        Iterator<VSCameraInfo> r7 = this.g.iterator();
        int r8 = 0;
    L6:
        if (r7.hasNext() == false) goto L14;
        if (r7.next().cameraId != r5) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == true) goto L15;
        r8 = r8 + 1;
    L15:
        if (r8 != (-1)) goto L17;
    L20:
        VSCameraInfo r6 = (VSCameraInfo) CollectionsKt.firstOrNull(this.g);
        if (r6 == null) goto L23;
        Long r10 = Long.valueOf(r6.cameraId);
    L25:
        if (r10 == null) goto L171;
        long r11 = r10.longValue();
        VSCameraInfo r12 = this.c;
        if (r12 != null) goto L29;
    L31:
        VSCameraInfo r13 = a(r11);
        if (r13 != null) goto L35;
        return;
    L35:
        if (r13.streamUrl != null) goto L37;
        return;
    L37:
        Iterator r14 = ((ArrayList) this.f).iterator();
    L39:
        if (r14.hasNext() == false) goto L43;
        if (((f) r14.next()).a(r13) == false) goto L39;
        return;
    L43:
        Iterator r15 = ((ArrayList) this.e).iterator();
    L45:
        if (r15.hasNext() == false) goto L47;
        ((e) r15.next()).b(r13, r19);
        goto L45
    L47:
        VSCameraInfo r16 = this.c;
        if (r16 == null) goto L52;
        Intrinsics.checkNotNullParameter(r16, "$this$realCameraStyle");
        if (b0.a(r16) != 2) goto L52;
        boolean r17 = true;
    L53:
        Intrinsics.checkNotNullParameter(r13, "$this$realCameraStyle");
        if (b0.a(r13) != 2) goto L56;
        boolean r110 = true;
    L57:
        if (r17 == r110) goto L59;
        boolean r23 = true;
    L60:
        IBaseStreamUrl r111 = r13.streamUrl;
        if (r111 == null) goto L63;
        r.p().d(r111);
    L63:
        VSCameraInfo r112 = this.c;
        if (r112 == null) goto L70;
        long r113 = r112.groupId;
        if (r113 != r13.groupId) goto L70;
        if (r113 <= 0) goto L70;
        boolean r2 = true;
    L71:
        Iterator r3 = ((ArrayList) this.e).iterator();
    L73:
        if (r3.hasNext() == false) goto L75;
        ((e) r3.next()).d(this.c, r13);
        goto L73
    L75:
        VSCameraInfo r24 = this.c;
        this.c = r13;
        this.b = r13.cameraId;
        this.j = true;
        if (r24 == null) goto L80;
        Intrinsics.checkNotNullParameter(r24, "$this$realCameraStyle");
        if (b0.a(r24) != 2) goto L80;
        boolean r114 = true;
    L81:
        long r25 = r13.cameraId;
        if (r25 > 0) goto L84;
    L86:
        boolean r26 = false;
    L87:
        Intrinsics.checkNotNullParameter(r13, "$this$realCameraStyle");
        if (b0.a(r13) != 2) goto L90;
        boolean r27 = true;
    L91:
        d r28 = this.i;
        if (r28 != null) goto L94;
    L103:
        if (r27 == false) goto L108;
        d r1 = this.i;
        if (r1 == null) goto L115;
        r1.x6(r13, r26);
    L115:
        d r29 = this.i;
        if (r29 != null) goto L118;
    L152:
        if (r110 == true) goto L156;
        d r30 = this.i;
        if (r30 == null) goto L156;
        r30.Ma(r23, r2, IMultiCameraView.Source.CameraChange);
    L156:
        if (r110 == false) goto L163;
        d r31 = this.i;
        if (r31 == null) goto L160;
        r31.y6();
    L160:
        DataCenter r32 = this.d;
        if (r32 == null) goto L163;
        r32.put("live_cast_screen_connecting_pannel_change", "");
    L163:
        if (r110 == true) goto L167;
        d r33 = this.i;
        if (r33 == null) goto L167;
        r33.X5(r23, r2, IMultiCameraView.Source.CameraChange);
    L167:
        Iterator r34 = ((ArrayList) this.e).iterator();
    L169:
        if (r34.hasNext() == false) goto L180;
        ((e) r34.next()).a(r24, r13, r19, r20, r21);
        goto L169
    L180:
        return;
    L118:
        if (r29.g1() != true) goto L152;
        d r35 = this.i;
        if (r35 == null) goto L122;
        r35.Ma(r23, r2, IMultiCameraView.Source.CameraChange);
    L122:
        gr1.a r36 = jr1.c.a();
        if (r36 == null) goto L127;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r37 = r36.provideVSPlayerViewControlService(this.d);
        if (r37 == null) goto L127;
        r37.setVisibilityStatus(false);
    L127:
        if (r23 == false) goto L142;
        DataCenter r38 = this.d;
        if (r38 == null) goto L131;
        String r115 = (String) r38.get("live_cast_screen_connecting_pannel_change", "");
    L132:
        Handler r39 = UtilityKotlinExtentionsKt.a;
        if (r115 != null) goto L135;
    L137:
        r4 = false;
    L138:
        if (r4 == false) goto L142;
        DataCenter r40 = this.d;
        if (r40 == null) goto L142;
        r40.put("live_cast_screen_connecting_pannel_change", "");
        goto L142
    L135:
        if (r115.length() <= 0) goto L137;
    L131:
        r115 = null;
    L142:
        d r41 = this.i;
        if (r41 == null) goto L167;
        gr1.a r42 = jr1.c.a();
        if (r42 == null) goto L151;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r43 = r42.provideVSPlayerViewControlService(this.d);
        if (r43 == null) goto L151;
        VSPlayerViewControlContext r44 = r43.provideContext();
        if (r44 == null) goto L151;
        r44.setInitVisible(false);
    L151:
        r41.X5(r23, r2, IMultiCameraView.Source.CameraChange);
        goto L167
    L108:
        if (Intrinsics.areEqual(r22, Boolean.FALSE) == false) goto L112;
        d r45 = this.i;
        if (r45 == null) goto L115;
        r45.x6(r13, r26);
        goto L115
    L112:
        d r46 = this.i;
        if (r46 == null) goto L115;
        r46.a4(r13, false, false, r26);
        goto L115
    L94:
        if (r28.g1() != true) goto L103;
        if (Intrinsics.areEqual(r22, Boolean.FALSE) == false) goto L100;
        d r47 = this.i;
        if (r47 == null) goto L115;
        r47.x6(r13, r26);
        goto L115
    L100:
        d r48 = this.i;
        if (r48 == null) goto L115;
        r48.a4(r13, r114, r27, r26);
        goto L115
    L90:
        r27 = false;
        goto L91
    L84:
        if (r25 == this.h) goto L86;
        r26 = true;
    L80:
        r114 = false;
    L70:
        r2 = false;
        goto L71
    L59:
        r23 = false;
        goto L60
    L56:
        r110 = false;
    L52:
        r17 = false;
        goto L53
    L29:
        if (r12.cameraId != r11) goto L31;
        return;
    L171:
        return;
    L23:
        r10 = null;
        goto L25
    L17:
        if ((r8 + 2) > this.g.size()) goto L20;
        r10 = Long.valueOf(((VSCameraInfo) ListProtector.get(this.g, r8 + 1)).cameraId);
        goto L25
    L10:
        r9 = false;
        goto L11
    L14:
        r8 = -1;
        goto L15
    L24:
        r10 = r18;
        goto L25
    }
}
