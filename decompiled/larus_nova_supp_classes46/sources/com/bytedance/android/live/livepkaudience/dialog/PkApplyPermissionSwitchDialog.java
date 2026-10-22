package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkApplyPermissionSwitchDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkApplyPermissionSwitchDialog extends CommonBottomDialog {
    public static final a f = null;
    public final CompositeDisposable a;
    public boolean b;
    public boolean c;
    public final Room d;
    public final int e;

    public static final class a {
        public a() {
        }
    }

    public final int getLayoutId() {
        return 2131565699;
    }

    static {
        f = new a();
    }

    public final void N0() {
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L5;
        this.b = true;
        ((FrameLayout) findViewById(2131372797)).setAlpha(1.0f);
        ((FrameLayout) findViewById(2131372795)).setAlpha(1.0f);
        O0();
        return;
    L5:
        this.b = false;
        ((FrameLayout) findViewById(2131372797)).setAlpha(0.4f);
        ((FrameLayout) findViewById(2131372795)).setAlpha(0.4f);
        ((ImageView) findViewById(2131376428)).setVisibility(8);
        ((ImageView) findViewById(2131376439)).setVisibility(8);
    }

    public final void O0() {
        if (this.c == false) goto L5;
        ((ImageView) findViewById(2131376428)).setVisibility(0);
        ((ImageView) findViewById(2131376439)).setVisibility(8);
        return;
    L5:
        ((ImageView) findViewById(2131376428)).setVisibility(8);
        ((ImageView) findViewById(2131376439)).setVisibility(0);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (this.e != 1) goto L6;
        ((Switch) findViewById(2131387922)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue());
        this.c = ((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue();
        O0();
    L6:
        ((Switch) findViewById(2131387922)).setOnCheckedChangeListener(new f(this));
        ((FrameLayout) findViewById(2131372797)).setOnClickListener(new g(this));
        ((FrameLayout) findViewById(2131372795)).setOnClickListener(new h(this));
        ((FrameLayout) findViewById(2131372864)).setVisibility(0);
        ((Switch) findViewById(2131387924)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue());
        ((Switch) findViewById(2131387924)).setOnCheckedChangeListener(new e(this));
        N0();
    }

    public PkApplyPermissionSwitchDialog(Room r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.d = r2;
        this.e = 1;
        this.a = new CompositeDisposable();
        this.b = true;
    }

    public static final void M0(PkApplyPermissionSwitchDialog r5, boolean r6) {
        if (r5.b == false) goto L11;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        HashMap r1 = new HashMap();
        r0.element = r1;
        r1.put("scene", Integer.valueOf(r5.e));
        if (r5.e != 1) goto L9;
        ((HashMap) r0.element).put("big_party_accept_need_verified", Boolean.valueOf(r6));
        ((HashMap) r0.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(((Switch) r5.findViewById(2131387922)).isChecked()));
    L9:
        Disposable r7 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(r5.d.id, (HashMap) r0.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r5, r0, r6));
        r5.a.add(r7);
        return;
    }
}
