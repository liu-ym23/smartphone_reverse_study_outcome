package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/VideoTalkAVPermissionFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkAVPermissionFragment extends VideoTalkDialogContract$View {
    public static final /* synthetic */ int l = 0;
    public View g;
    public ViewGroup h;
    public IRoom i;
    public final Map<String, Boolean> j;
    public final CompositeDisposable k;

    public static final class a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ VideoTalkAVPermissionFragment a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
                com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.J0;
                Boolean r0 = Boolean.valueOf(this.a);
                r4.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.fragment.VideoTalkAVPermissionFragment$b$b, reason: collision with other inner class name */
        public static final class C0038b<T> implements Consumer {
            public final /* synthetic */ b a;

            public C0038b(b r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                ALogger.e("VideoAudioPermissionSwitchDialog", "updateSetting openGuestLinkAutoSilence", r4);
                ExceptionUtils.handleException(this.a.a.getContext(), r4);
            }
        }

        public b(VideoTalkAVPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            HashMap r7 = new HashMap();
            r7.put("scene", 4);
            JSONArray r0 = new JSONArray();
            JSONObject r1 = new JSONObject();
            r1.put("key", 77);
            if (r6 == false) goto L5;
            int r2 = 1;
        L6:
            r1.put("value", r2);
            r0.put(r1);
            r7.put("incremental_update", r0);
            LinkApi r3 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
            IRoom r4 = this.a.i;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
        L9:
            Disposable r8 = r3.updateSetting(r4.getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6), new C0038b(this));
            this.a.k.add(r8);
            return;
        L5:
            r2 = 2;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final View aa0() {
        View r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        return r0;
    }

    public final void ba0() {
        View r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131374065);
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        View r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        Switch r3 = (Switch) r2.findViewById(2131387907);
        if (r3 == null) goto L14;
        r3.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.J0.getValue()).booleanValue());
    L14:
        View r4 = this.g;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((Switch) r4.findViewById(2131387907)).setOnCheckedChangeListener(new b(this));
    }

    public VideoTalkAVPermissionFragment() {
        this.j = new LinkedHashMap();
        this.k = new CompositeDisposable();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        Iterator r0 = ((LinkedHashMap) this.j).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.J0;
        if (Intrinsics.areEqual(r2, r3.getName()) == false) goto L14;
        if ((!Intrinsics.areEqual((Boolean) r1.getValue(), (Boolean) r3.getValue())) == false) goto L14;
        String r4 = com.bytedance.android.live.core.utils.s1.B(2131918072);
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L12;
        String r5 = "on";
    L13:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.m(r4, r5);
        goto L4
    L12:
        r5 = "off";
    L14:
        ALogger.i("VideoAudioPermissionSwitchDialog", "no setting change");
        goto L4
    L15:
        ((LinkedHashMap) this.j).clear();
        this.k.dispose();
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        this.g = r6.inflate(2131565793, r7, false);
        View r9 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r9 == null) goto L99;
        ViewGroup r10 = (ViewGroup) r9;
        this.h = r10;
        ((ImageView) r10.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkAVPermissionFragment$initTopView$1(this)));
        ViewGroup r11 = this.h;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        ((TextView) r11.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131918067));
        if (((Boolean) vm2.d.v0.getValue(null, vm2.d.a[71])).booleanValue() == false) goto L30;
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 != null) goto L12;
    L13:
        IKtvService r13 = jc1.k.f(IKtvService.class);
        if (r13 != null) goto L16;
    L29:
        ba0();
    L37:
        if (tc0.c.h().E == false) goto L87;
        View r14 = this.g;
        if (r14 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L41:
        ((FrameLayout) r14.findViewById(2131365090)).setVisibility(0);
        View r15 = this.g;
        if (r15 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L44:
        ((Switch) r15.findViewById(2131387888)).setChecked(((Boolean) b6.h.getValue()).booleanValue());
        View r16 = this.g;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L47:
        ((Switch) r16.findViewById(2131387888)).setOnCheckedChangeListener(new o0(this));
        int r17 = com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
        View r4 = this.g;
        if (r4 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L50:
        ((RelativeLayout) r4.findViewById(2131368745)).setVisibility(8);
        if (tb1.c.a == false) goto L53;
    L56:
        boolean r1 = true;
    L58:
        if (sj1.a(r17, r1) == false) goto L94;
        View r2 = this.g;
        if (r2 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L62:
        ((RelativeLayout) r2.findViewById(2131368745)).setVisibility(0);
        View r3 = this.g;
        if (r3 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L65:
        ((Switch) r3.findViewById(2131387890)).setClickable(false);
        View r5 = this.g;
        if (r5 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L68:
        ((Switch) r5.findViewById(2131387890)).setChecked(((Boolean) b6.g.getValue()).booleanValue());
        View r18 = this.g;
        if (r18 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L71:
        ((FrameLayout) r18.findViewById(2131387891)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkAVPermissionFragment$initLinkVideoSetting$2(this)));
        View r19 = this.g;
        if (r19 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L74:
        ((Switch) r19.findViewById(2131387890)).setOnCheckedChangeListener(new p0(this, r17));
        View r20 = this.g;
        if (r20 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L78:
        if (((Switch) r20.findViewById(2131387888)).isChecked() == true) goto L83;
        View r21 = this.g;
        if (r21 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L82:
        ((Switch) r21.findViewById(2131387890)).setChecked(false);
    L83:
        HashMap r22 = new HashMap();
        View r23 = this.g;
        if (r23 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L86:
        r22.put("button_type", String.valueOf(((Switch) r23.findViewById(2131387890)).isChecked()));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.F(r22, r17);
        com.bytedance.android.live.liveinteract.api.utils.a.a.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.C0018a.b(r22, r17);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_auto_video_button_show", r22, new Object[]{IRoom.class});
    L94:
        Map<String, Boolean> r24 = this.j;
        com.bytedance.android.livesdk.sharedpref.e r25 = com.bytedance.android.livesdk.sharedpref.c.J0;
        r24.put(r25.getName(), (Boolean) r25.getValue());
        View r26 = this.g;
        if (r26 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L97:
        return r26;
    L53:
        if (tb1.c.c == true) goto L56;
        r1 = false;
        goto L58
    L87:
        View r27 = this.g;
        if (r27 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L90:
        ((FrameLayout) r27.findViewById(2131365090)).setVisibility(8);
        View r28 = this.g;
        if (r28 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L93:
        ((RelativeLayout) r28.findViewById(2131368745)).setVisibility(8);
        goto L94
    L16:
        if (r13.currentIsAudienceSingEnable() != true) goto L29;
    L17:
        IRoom r29 = this.i;
        if (r29 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L21:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.l.b(r29) == false) goto L23;
        ba0();
        goto L37
    L23:
        View r30 = this.g;
        if (r30 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        FrameLayout r31 = (FrameLayout) r30.findViewById(2131374065);
        if (r31 == null) goto L37;
        r31.setVisibility(8);
        goto L37
    L12:
        if (r12.currentIsMultipleKtvMode() == true) goto L17;
    L30:
        View r32 = this.g;
        if (r32 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L33:
        FrameLayout r33 = (FrameLayout) r32.findViewById(2131374065);
        if (r33 == null) goto L37;
        r33.setVisibility(8);
        goto L37
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
