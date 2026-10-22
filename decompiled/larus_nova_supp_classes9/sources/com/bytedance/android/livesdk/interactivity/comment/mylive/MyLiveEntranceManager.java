package com.bytedance.android.livesdk.interactivity.comment.mylive;

import am2.x;
import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.f;
import py.k;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mylive/MyLiveEntranceManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyLiveEntranceManager implements Observer<KVData> {
    public static final /* synthetic */ int k = 0;
    public HSImageView a;
    public HSImageView b;
    public CompositeDisposable c;
    public final int d;
    public final int e;
    public final Context f;
    public final IRoom g;
    public final FrameLayout h;
    public final DataContext i;
    public final DataCenter j;

    public static final class a {
    }

    static {
    }

    public final IBaseUser b() {
        DataCenter r0 = this.j;
        if (r0 != null) goto L5;
        return null;
    L5:
        return (IBaseUser) r0.get("data_user_in_room", null);
    }

    public final Context getContext() {
        return this.f;
    }

    public static final void a(MyLiveEntranceManager r5) {
        r5.getClass();
        HashMap r0 = new HashMap();
        IBaseUser r6 = r5.b();
        if (r6 != null) goto L5;
    L7:
        r0.put("my_live_status", "head_portrait");
    L8:
        j0.l().sendLog("livesdk_my_live_button_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        if (r6.isMysteryMan() != true) goto L7;
        r0.put("my_live_status", "mystery_man");
        goto L8
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        k r0 = null;
        if (r7 == null) goto L5;
        String r8 = r7.getKey();
    L7:
        if ((!Intrinsics.areEqual("data_user_in_room", r8)) == false) goto L10;
        return;
    L10:
        if (this.a != null) goto L12;
        return;
    L12:
        if (this.b == null) goto L55;
        UIUtils.setViewVisibility(this.h, 0);
        HSImageView r9 = this.a;
        IBaseUser r3 = b();
        if (r3 == null) goto L16;
        r0 = r3.getAvatarThumbKt();
    L16:
        int r4 = this.d;
        ImageLoader.bindAvatar(r9, r0, r4, r4);
        IBaseUser r10 = b();
        if (r10 != null) goto L19;
    L22:
        IBaseUser r11 = b();
        if (r11 == null) goto L33;
        f r13 = r11.getBorder();
        if (r13 == null) goto L33;
        com.bytedance.android.live.profit.dress.a r1 = c.a().getDressData(r13.getDressId(), 1, "myLive");
        if (r1 == null) goto L30;
        k r2 = r1.a;
        if (r2 == null) goto L30;
    L31:
        if (r2 == null) goto L33;
        HSImageView r14 = this.b;
        int r5 = this.e;
        ImageLoader.bindAvatar(r14, r2, r5, r5);
    L30:
        r2 = r13.getIcon();
    L33:
        ALogger.i("MyLive", "bind userInRoom User data");
        h r15 = i.a(this.i, this.j);
        if (r15 == null) goto L50;
        m<Boolean> r16 = r15.getMyLiveEntranceHasShow();
        if (r16 == null) goto L50;
        if (((Boolean) r16.getValue()).booleanValue() == true) goto L50;
        HashMap r17 = new HashMap();
        IBaseUser r18 = b();
        if (r18 != null) goto L42;
    L44:
        r17.put("my_live_status", "head_portrait");
    L45:
        j0.l().sendLog("livesdk_my_live_button_show", r17, new Object[]{IRoom.class, x.class});
        h r19 = i.a(this.i, this.j);
        if (r19 == null) goto L50;
        m<Boolean> r20 = r19.getMyLiveEntranceHasShow();
        if (r20 == null) goto L50;
        r20.setValue(Boolean.TRUE);
        goto L50
    L42:
        if (r18.isMysteryMan() != true) goto L44;
        r17.put("my_live_status", "mystery_man");
    L50:
        IBaseUser r21 = b();
        if (r21 == null) goto L56;
        this.h.setOnClickListener(new y62.c(r21, this));
        return;
    L56:
        return;
    L19:
        if (r10.isMysteryMan() != true) goto L22;
        if (y62.a.b == false) goto L33;
    L55:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public MyLiveEntranceManager(Context r2, IRoom r3, FrameLayout r4, DataContext r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "myLiveContainer");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.d = InteractivityOpt.a(32.0f);
        this.e = InteractivityOpt.a(40.0f);
    }
}
