package com.bytedance.android.live.room.share.summersinging;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final /* synthetic */ int e = 0;
    public ConstraintLayout a;
    public boolean b;
    public Disposable c;
    public final com.bytedance.android.live.room.share.summersinging.a d;

    public static final class a {
    }

    static {
    }

    public l(com.bytedance.android.live.room.share.summersinging.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dataProvider");
        this.d = r2;
    }

    public static void a(l r3, Context r4, Function1 r5) {
        if (r3.b == false) goto L5;
        ALogger.i("GroupPhotoShareLayoutViewHolder", "call trySaveImg when isn't isSaving");
        return;
    L5:
        r3.b = true;
        GroupPhotoShareLayoutViewHolder$trySaveImg$1 r0 = new GroupPhotoShareLayoutViewHolder$trySaveImg$1(r3, r4, r5, null);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        r0.m1112invoke();
        return;
    L8:
        Activity r6 = ContextUtil.contextToActivity(r4);
        SettingKey r7 = m60.i.a;
        new m60.i.b(r6).b(new n(r3, r0, null), null, TokenCert.Companion.with("bpea-live_group_photo_request_permission"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }
}
